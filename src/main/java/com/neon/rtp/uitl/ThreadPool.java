package com.neon.rtp.uitl;

import com.neon.rtp.uitl.IFunction.Function1ArgsR;
import com.neon.rtp.uitl.IFunction.Function1ArgsV;
import com.neon.rtp.uitl.IFunction.Function2ArgsR;
import com.neon.rtp.uitl.IFunction.Function2ArgsV;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author Neon
 * @date 2020/8/6 0006 23:23
 * <p>
 * run*方法为不返回结果
 * *async 方法为异步执行,主线程不等待执行结果
 * execute*方法为等待返回结果
 * *queue*方法为多线程按顺序给定的List或者Map中的顺序触发执行
 * 该方法主要是对于大量数据查询进行分割,比时间,ID等可切割参数
 * 对查询进行排序,尽量保持数据库的连续IO以提高数据库详情速度
 * @see PageUtil#range(long, PageUtil.IRun, PageUtil.IRun)
 * @see DateUtil#splitTime(Date, Date, int, Unit)
 */
public class ThreadPool{

    private static final Logger LOG = LoggerFactory.getLogger(ThreadPool.class);

    /**
     * 异步操作,不等待执行完毕
     * 不返回操作结果
     * 默认线程数量为当前可用量
     * @param iterable 需要执行的数据
     * @param run      任务方法
     */
    public static <E> void runAsync(List<E> iterable, Function1ArgsV<E> run) {
        runAsync(getDefaultThreadCount(iterable), iterable, run);
    }

    /**
     * 异步操作,不等待执行完毕
     * 不返回操作结果
     * @param threadCount 线程数量
     * @param iterable    需要执行的数据
     * @param run         任务方法
     */
    public static <E> void runAsync(int threadCount, List<E> iterable, Function1ArgsV<E> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        iterable.stream().<Runnable>map(o->()->{
            try {
                run.apply(o);
            } catch(Exception e) {
                exceptionHandler(e);
            }
        }).forEach(executorService::submit);
        shutdownPool(executorService);
    }

    public static <K, V> void runAsync(Map<K, V> iterable, Function2ArgsV<K, V> run) {
        runAsync(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <K, V> void runAsync(int threadCount, Map<K, V> iterable, Function2ArgsV<K, V> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        iterable.forEach((k, v)->executorService.submit(()->{
            try {
                run.apply(k, v);
            } catch(Exception e) {
                exceptionHandler(e);
            }
        }));
        shutdownPool(executorService);
    }

    /**
     * 同步操作,等待子线程全部执行完毕
     * 不返回操作结果
     * @param iterable 需要执行的数据
     * @param run      任务方法
     */
    public static <E> void run(List<E> iterable, Function1ArgsV<E> run) {
        run(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E> void run(int threadCount, List<E> iterable, Function1ArgsV<E> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        List<Future<?>> list = iterable.stream().map(o->executorService.submit(()->run.apply(o)))
                .collect(Collectors.toList());
        list.forEach(tFuture->{
                    try {
                        tFuture.get();
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
    }

    public static <K, V> void run(Map<K, V> iterable, Function2ArgsV<K, V> run) {
        run(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <K, V> void run(int threadCount, Map<K, V> iterable, Function2ArgsV<K, V> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        List<Future<?>> list = new ArrayList<>();
        iterable.forEach((k, v)->list.add(executorService.submit(()->run.apply(k, v))));
        list.forEach(tFuture->{
                    try {
                        tFuture.get();
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
    }

    /**
     * 异步操作,等待执行完毕
     * 返回操作结果
     * 默认线程数量为当前可用量
     * @param iterable 需要执行的数据
     * @param run      任务方法
     */
    public static <E, R> List<R> execute(List<E> iterable, Function1ArgsR<E, R> run) {
        return execute(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E, R> List<R> execute(int threadCount, List<E> iterable, Function1ArgsR<E, R> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        List<Future<R>> list = iterable.stream().map(o->executorService.submit(()->run.apply(o)))
                .collect(Collectors.toList());
        List<R> result = new ArrayList<>();
        list.forEach(tFuture->{
                    try {
                        R t = tFuture.get();
                        if(t != null)
                            result.add(t);
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
        return result;
    }

    public static <K, V, R> List<R> execute(Map<K, V> iterable, Function2ArgsR<K, V, R> run) {
        return execute(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <K, V, R> List<R> execute(int threadCount, Map<K, V> iterable, Function2ArgsR<K, V, R> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        List<Future<R>> list = new ArrayList<>();
        iterable.forEach((k, v)->{
            Future<R> submit = executorService.submit(()->run.apply(k, v));
            list.add(submit);
        });
        List<R> result = new ArrayList<>();
        list.forEach(tFuture->{
                    try {
                        R t = tFuture.get();
                        if(t != null)
                            result.add(t);
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
        return result;
    }

    public static <E> void runQueueAsync(List<E> iterable, Function1ArgsV<E> run) {
        runQueueAsync(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E> void runQueueAsync(int threadCount, List<E> iterable, Function1ArgsV<E> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
        iterable.forEach(o->{
            Runnable task = ()->{
                taskQueue.poll();
                try {
                    run.apply(o);
                } catch(Exception e) {
                    exceptionHandler(e);
                }
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                executorService.submit(taskQueue.peek());
            }
        }
        shutdownPool(executorService);
    }

    public static <K, V> void runQueueAsync(Map<K, V> iterable, Function2ArgsV<K, V> run) {
        runQueueAsync(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <K, V> void runQueueAsync(int threadCount, Map<K, V> iterable, Function2ArgsV<K, V> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
        iterable.forEach((k, v)->{
            Runnable task = ()->{
                taskQueue.poll();
                try {
                    run.apply(k, v);
                } catch(Exception e) {
                    exceptionHandler(e);
                }
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                executorService.submit(taskQueue.peek());
            }
        }
        shutdownPool(executorService);
    }

    /**
     * 同步操作,等待子线程全部执行完毕
     * 不返回操作结果
     * @param iterable 需要执行的数据
     * @param run      任务方法
     */
    public static <E> void runQueue(List<E> iterable, Function1ArgsV<E> run) {
        runQueue(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E> void runQueue(int threadCount, List<E> iterable, Function1ArgsV<E> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
        List<Future<?>> list = new ArrayList<>();
        iterable.forEach(o->{
            Runnable task = ()->{
                taskQueue.poll();
                run.apply(o);
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                Future<?> submit = executorService.submit(taskQueue.peek());
                list.add(submit);
            }
        }
        list.forEach(tFuture->{
                    try {
                        tFuture.get();
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
    }

    public static <K, V> void runQueue(int threadCount, Map<K, V> iterable, Function2ArgsV<K, V> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
        List<Future<?>> list = new ArrayList<>();
        iterable.forEach((k, v)->{
            Runnable task = ()->{
                taskQueue.poll();
                run.apply(k, v);
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                Future<?> submit = executorService.submit(taskQueue.peek());
                list.add(submit);
            }
        }
        list.forEach(tFuture->{
                    try {
                        tFuture.get();
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
    }

    public static <K, V> void runQueue(Map<K, V> iterable, Function2ArgsV<K, V> run) {
        runQueue(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <K, V, R> List<R> executeQueue(int threadCount, Map<K, V> iterable, Function2ArgsR<K, V, R> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        Queue<Callable<R>> taskQueue = new ConcurrentLinkedQueue<>();
        List<Future<R>> list = new ArrayList<>();
        iterable.forEach((k, v)->{
            Callable<R> task = ()->{
                taskQueue.poll();
                return run.apply(k, v);
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                Future<R> submit = executorService.submit(taskQueue.peek());
                list.add(submit);
            }
        }
        List<R> result = new ArrayList<>();
        list.forEach(tFuture->{
                    try {
                        R t = tFuture.get();
                        if(t != null)
                            result.add(t);
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
        return result;
    }

    public static <K, V, R> List<R> executeQueue(Map<K, V> iterable, Function2ArgsR<K, V, R> run) {
        return executeQueue(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E, R> List<R> executeQueue(List<E> iterable, Function1ArgsR<E, R> run) {
        return executeQueue(getDefaultThreadCount(iterable), iterable, run);
    }

    public static <E, R> List<R> executeQueue(int threadCount, List<E> iterable, Function1ArgsR<E, R> run) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount); ;
        Queue<Callable<R>> taskQueue = new ConcurrentLinkedQueue<>();
        List<Future<R>> list = new ArrayList<>();
        iterable.forEach(o->{
            Callable<R> task = ()->{
                taskQueue.poll();
                return run.apply(o);
            };
            taskQueue.add(task);
        });
        int i = taskQueue.size();
        while(i > 0 && taskQueue.size() > 0) {
            if(i == taskQueue.size()) {
                i--;
                Future<R> submit = executorService.submit(taskQueue.peek());
                list.add(submit);
            }
        }
        List<R> result = new ArrayList<>();
        list.forEach(tFuture->{
                    try {
                        R t = tFuture.get();
                        if(t != null)
                            result.add(t);
                    } catch(InterruptedException | ExecutionException e) {
                        exceptionHandler(e);
                    }
                }
        );
        shutdownPool(executorService);
        return result;
    }

    private static void exceptionHandler(Throwable e) {
        e = caseException(e);
        LOG.error("多线程任务执行失败", e);
        throw new OperateException("执行失败!", e);
    }

    private static int getDefaultThreadCount(List<?> list) {
        return Math.min(list.size(), Runtime.getRuntime().availableProcessors());
    }

    private static int getDefaultThreadCount(Map<?, ?> map) {
        return Math.min(map.size(), Runtime.getRuntime().availableProcessors());
    }

    private static void shutdownPool(ExecutorService executorService) {
        if(executorService != null && !executorService.isShutdown())
            executorService.shutdown();
    }

    private static Throwable caseException(Throwable exception) {
        return exception.getCause() != null ? caseException(exception.getCause()) : exception;
    }
}
