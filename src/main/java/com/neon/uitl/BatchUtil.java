package com.neon.uitl;

import com.chaboshi.crpc.commonservice.entity.OwnUser;
import com.chaboshi.tools.backend.exception.OperateException;
import com.chaboshi.tools.backend.util.CollectUtil;
import com.chaboshi.tools.backend.util.Constant;
import com.chaboshi.tools.backend.util.IFunction.Function1ArgsListRList;
import com.chaboshi.tools.backend.util.IFunction.Function1ArgsListV;
import com.chaboshi.tools.backend.util.IFunction.Function1ArgsMapRList;
import com.chaboshi.tools.backend.util.IFunction.Function1ArgsMapV;
import com.chaboshi.tools.backend.util.RedisClient;
import com.chaboshi.tools.backend.util.ThreadPool;
import com.chaboshi.web.crm.bll.CRPC;
import com.chaboshi.wf.mvc.BeatContext;

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
        }
        else {
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
        }
        else {
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
        }
        else {
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
        }
        else {
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
        }
        else {
            return f.apply(l);
        }
    }

    public static void getOwnUserId(Long ownUserId) {
        RedisClient.set(Thread.currentThread().toString() + Constant.USER_INFO, ownUserId, RedisClient.min(5));
    }

    /**
     * 日志记录登录用户
     */
    public static String operator() {
        OwnUser ownUser = getOwnUser();
        if(ownUser == null) {
            throw new OperateException("登录已过期,请重新登录!");
        }
        return ownUser.getId() + StringUtil.line + ownUser.getName();
    }

    public static OwnUser getOwnUser() {
        return BeatContext.current() != null ?
                (OwnUser) BeatContext.current().getRequest().getAttribute(Constant.USER_INFO) :
                CRPC.OWN_USER_SERVICE.queryById(getOwnUserId());
    }

    public static Long getOwnUserId() {
        return BeatContext.current() != null ?
                (Long) BeatContext.current().getRequest().getAttribute(Constant.USER_INFO_ID) :
                RedisClient.get(Thread.currentThread().toString() + Constant.USER_INFO, Long.class);
    }

    public static void setOwnUserId(Long ownUserId) {
        RedisClient.set(Thread.currentThread().toString() + Constant.USER_INFO, ownUserId, RedisClient.min(5));
    }
}
