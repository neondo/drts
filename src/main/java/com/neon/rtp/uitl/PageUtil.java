package com.neon.rtp.uitl;

/**
 * @author Neon
 * @date 2020/5/12 19:51
 */
public class PageUtil{

    private final long total;

    private final long size;

    private static ThreadLocal<Long> startIndex = new ThreadLocal<>();

    private PageUtil(long total, long size) {
        this.total = total;
        this.size = size;
    }

    public static PageUtil init(long total, long size) {
        startIndex.set(0L);
        return new PageUtil(total, size);
    }

    /**
     * 用于ID区间查询
     * @param size  单词查询数量
     * @param start 开始索引
     * @param end   结束索引
     */
    public static PageUtil range(long size, IRun start, IRun end) {
        startIndex.set(start.run());
        long endIndex = end.run();
        long total = endIndex - startIndex.get();
        return new PageUtil(total, size);
    }

    public long getTotal() {
        return total;
    }

    public int getPage() {
        return (int) Math.ceil(total * 1.0 / size);
    }

    public int getStartIndex(int currentPage) {
        return (int) Math.min(((currentPage - 1) * size) + startIndex.get(), this.getEndIndex(currentPage) + startIndex.get());
    }

    public int getEndIndex(int currentPage) {
        return (int) Math.min((currentPage) * size + startIndex.get(), total + startIndex.get());
    }

    public long getLongStartIndex(int currentPage) {
        return Math.min(((currentPage - 1) * size) + startIndex.get(), this.getLongEndIndex(currentPage) + startIndex.get());
    }

    public long getLongEndIndex(int currentPage) {
        return Math.min((currentPage) * size + startIndex.get(), total + startIndex.get());
    }

    public interface IRun{

        long run();
    }
}
