package com.neon.uitl;

import java.util.List;
import java.util.Map;

/**
 * 接口方法
 * 用于lambda
 * 接口取名特征
 * 1Args表示参数个数,1ArgsMap表示有一个Map结构参数
 * R表示有返回值R泛型,RList表示返回泛型List类型
 * @author Neon
 * @date 2021/3/9 15:03
 */

public interface IFunction{

    public interface Function0ArgsR<R>{

        R apply();
    }

    public interface Function0ArgsV{

        void apply();
    }

    public interface Function0ArgsVE{

        void apply() throws Exception;
    }

    public interface Function0ArgsRE<R>{

        R apply() throws Exception;
    }

    public interface Function1ArgsR<E, R>{

        R apply(E o);
    }

    public interface Function2ArgsR<T, E, R>{

        R apply(T k, E v);
    }

    public interface Function2ArgsV<E, R>{

        void apply(E k, R v);
    }

    public interface Function1ArgsV<E>{

        void apply(E o);
    }

    public interface Function1ArgsRList<E, R>{

        List<R> apply(E o);
    }

    public interface Function1ArgsListV<E>{

        void apply(List<E> e);
    }

    public interface Function1ArgsListRList<E, R>{

        List<R> apply(List<E> e);
    }

    public interface Function1ArgsMapRList<K, V, R>{

        List<R> apply(Map<K, V> e);
    }

    public interface Function1ArgsMapR<K, V, R>{

        R apply(Map<K, V> e);
    }

    public interface Function1ArgsMapV<K, V>{

        void apply(Map<K, V> e);
    }

    public interface Function2ArgsIntR<V, R>{

        R apply(V e, int i);
    }

    public interface Function2ArgsIntV<E>{

        void apply(E v, int k);
    }
}
