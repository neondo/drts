/**
 *
 */

package com.neon.rtp.uitl;

/**
 * @author lee
 */
public interface CacheCallback<T>{

    /**
     * 获取数据
     * @return T
     */
    public T get();
}
