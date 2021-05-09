package com.neon.uitl;

import com.neon.uitl.IFunction.Function1ArgsListRList;
import com.neon.uitl.IFunction.Function1ArgsListV;
import com.neon.uitl.IFunction.Function1ArgsMapRList;
import com.neon.uitl.IFunction.Function1ArgsMapV;

import java.util.List;
import java.util.Map;

/**
 * @author Neon
 * @date 2021/3/3 18:51
 */
public class BatchUtil{

    public static <T> void run(List<T> l, Function1ArgsListV<T> f) {
        run(l, f, CollectUtil.MAX_SIZE);
    }

    public static <T> void run(List<T> l, Function1ArgsListV<T> f, int size) {
        if(l == null || l.isEmpty()) {
            return;
        }
        if(l.size() > size) {
            List<List<T>> lists = CollectUtil.divideList(l, CollectUtil.BATCH_SIZE);
            ThreadPool.run(lists, f::apply);
        } else {
            f.apply(l);
        }
    }

    public static <T> void runForeach(List<T> l, Function1ArgsListV<T> f) {
        runForeach(l, f, CollectUtil.MAX_SIZE);
    }

    public static <T> void runForeach(List<T> l, Function1ArgsListV<T> f, int size) {
        CollectUtil.removeEmpty(l);
        if(l == null || l.isEmpty()) {
            return;
        }
        if(l.size() > size) {
            List<List<T>> lists = CollectUtil.divideList(l, CollectUtil.BATCH_SIZE);
            lists.forEach(f::apply);
        } else {
            f.apply(l);
        }
    }

    public static <T, R> List<R> execute(List<T> l, Function1ArgsListRList<T, R> f) {
        return execute(l, f, CollectUtil.MAX_SIZE);
    }

    public static <T, R> List<R> execute(List<T> l, Function1ArgsListRList<T, R> f, int size) {
        if(l == null || l.isEmpty()) {
            return null;
        }
        if(l.size() > size) {
            List<List<T>> lists = CollectUtil.divideList(l, CollectUtil.BATCH_SIZE);
            List<List<R>> execute = ThreadPool.execute(lists, f::apply);
            return CollectUtil.merge(execute);
        } else {
            return f.apply(l);
        }
    }

    public static <K, V> void run(Map<K, V> l, Function1ArgsMapV<K, V> f) {
        run(l, f, CollectUtil.MAX_SIZE);
    }

    public static <K, V, R> void run(Map<K, V> l, Function1ArgsMapV<K, V> f, int size) {
        if(l == null || l.isEmpty()) {
            return;
        }
        if(l.size() > size) {
            List<Map<K, V>> maps = CollectUtil.divideMap(l, CollectUtil.BATCH_SIZE);
            ThreadPool.run(maps, f::apply);
        } else {
            f.apply(l);
        }
    }

    public static <K, V, R> List<R> execute(Map<K, V> l, Function1ArgsMapRList<K, V, R> f) {
        return execute(l, f, CollectUtil.MAX_SIZE);
    }

    public static <K, V, R> List<R> execute(Map<K, V> l, Function1ArgsMapRList<K, V, R> f, int size) {
        if(l == null || l.isEmpty()) {
            return null;
        }
        if(l.size() > size) {
            List<Map<K, V>> maps = CollectUtil.divideMap(l, CollectUtil.BATCH_SIZE);
            List<List<R>> execute = ThreadPool.execute(maps, f::apply);
            return CollectUtil.merge(execute);
        } else {
            return f.apply(l);
        }
    }
}
