package com.neon.rtp.uitl;

import com.neon.rtp.uitl.IFunction.Function1ArgsR;
import com.neon.rtp.uitl.IFunction.Function2ArgsIntV;
import com.neon.rtp.uitl.IFunction.Function2ArgsR;
import com.neon.rtp.uitl.IFunction.Function2ArgsV;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Neon
 * @date 2020/8/10 15:05
 */
public class CollectUtil{

    public static final Integer BATCH_SIZE = 1000;

    public static final Integer MAX_SIZE = 10000;

    public static final String empty = "", comma = ",";

    private static final List<?> EMPTY_LIST = Collections.singletonList(null);

    public static <T, E> String toString(Collection<T> c, String split, Function1ArgsR<T, E> fc) {
        if(c == null) return "";
        return c.stream().map(e->fc.apply(e) + "").collect(Collectors.joining(split));
    }

    public static <T, E> String toString(Collection<T> c, Function1ArgsR<T, E> fc) {
        return toString(c, comma, fc);
    }

    public static <T, E> String toString(Collection<T> c, String split) {
        if(c == null) return empty;
        return c.stream().map(k->k + "").collect(Collectors.joining(split));
    }

    public static String toString(Collection<?> c) {
        if(c == null) return empty;
        return CollectUtil.toString(c, comma);
    }

    public static <T> List<T> toList(Collection<?> c, Class<T> clazz) {
        if(c == null) return null;
        return c.stream().map(o->BeanUtils.cast(o, clazz)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T, E> List<E> toList(Collection<T> collect, Function1ArgsR<T, E> runList) {
        if(collect == null) return null;
        return collect.stream().map(runList::apply).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <K, V, E> List<E> toList(Map<K, V> collect, Function2ArgsR<K, V, E> f) {
        if(collect == null) return null;
        List<E> re = new ArrayList<>();
        collect.forEach((k, v)->re.add(f.apply(k, v)));
        return re;
    }

    public static <T, E> List<E> toSortedList(Collection<T> collect, Function1ArgsR<T, E> runList) {
        if(collect == null) return null;
        return collect.stream().map(runList::apply).filter(Objects::nonNull).sorted().collect(Collectors.toList());
    }

    public static <T, E> List<E> toLinkedList(Collection<T> collect, Function1ArgsR<T, E> runList) {
        if(collect == null) return null;
        return collect.stream().map(runList::apply).filter(Objects::nonNull).sorted().collect(Collectors.toCollection(LinkedList::new));
    }

    public static <T, E> List<E> toDistinctList(Collection<T> collect, Function1ArgsR<T, E> runList) {
        if(collect == null) return null;
        return collect.stream().map(runList::apply).filter(Objects::nonNull).distinct().collect(Collectors.toList());
    }

    public static <T, E> Set<E> toSet(Collection<T> collect, Function1ArgsR<T, E> runList) {
        if(collect == null) return null;
        return collect.stream().map(runList::apply).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static <T, K, V> Map<K, V> toMap(Collection<T> collect, Function1ArgsR<T, K> keyF, Function1ArgsR<T, V> valueF) {
        Map<K, V> map = new HashMap<>();
        if(collect == null) return map;
        collect.forEach(t->{
            K apply = keyF.apply(t);
            boolean b = apply != null && map.put(apply, valueF.apply(t)) != null;
        });
        return map;
    }

    public static <T> void forEachReverse(List<T> list, Function2ArgsIntV<T> fc) {
        if(!Check.notNull(list)) return;
        for(int i = list.size() - 1; i >= 0; i--) {
            fc.apply(list.get(i), i);
        }
    }

    public static <T> void forEach(List<T> list, Function2ArgsIntV<T> fc) {
        if(!Check.notNull(list)) return;
        IntStream.range(0, list.size()).forEach(i->fc.apply(list.get(i), i));
    }

    public static <K, V> void forEach(Map<K, V> m, Function2ArgsV<K, V> fc) {
        if(!Check.notNull(m)) return;
        List<K> ks = new ArrayList<>(m.keySet());
        ks.forEach(k->fc.apply(k, m.get(k)));
    }

    @SuppressWarnings({ "unchecked" })
    public static <K, V, R extends Comparable<R>> Map<K, V> sort(Map<K, V> m, Function2ArgsR<K, V, R> fuc) {
        if(!Check.notNull(m)) return m;
        Map<K, V> sort = new TreeMap<K, V>(Comparator.comparing((k)->{
            Comparable apply = fuc.apply(k, m.get(k));
            return apply != null ? apply : (Comparable) o->0;
        }));
        sort.putAll(m);
        return sort;
    }

    public static <K, V> void removeIf(Map<K, V> m, Function2ArgsR<K, V, Boolean> fc) {
        if(!Check.notNull(m)) return;
        m.entrySet().removeIf(kvEntry->fc.apply(kvEntry.getKey(), kvEntry.getValue()));
    }

    public static <T> void filter(List<T> list, Function2ArgsR<Integer, T, Boolean> fc) {
        if(!Check.notNull(list)) return;
        List<T> ts = new LinkedList<>(list);
        for(int i = 0; i < list.size(); i++) {
            T e = list.get(i);
            Boolean apply = fc.apply(i, e);
            if(!apply) ts.remove(e);
        }
        list.clear();
        list.addAll(ts);
    }

    public static <T, K, V> Map<K, V> toLinkedMap(Collection<T> collect, Function1ArgsR<T, K> keyF, Function1ArgsR<T, V> valueF) {
        if(collect == null) return null;
        Map<K, V> map = new LinkedHashMap<>();
        collect.forEach(t->{
            K apply = keyF.apply(t);
            boolean b = apply != null && map.put(apply, valueF.apply(t)) != null;
        });
        return map;
    }

    public static <T, K, V> Map<K, V> toMap(T[] arr, Function1ArgsR<T, K> keyF, Function1ArgsR<T, V> valueF) {
        if(arr == null) return null;
        Map<K, V> map = new LinkedHashMap<>();
        Arrays.stream(arr).forEach(t->{
            K apply = keyF.apply(t);
            boolean b = apply != null && map.put(apply, valueF.apply(t)) != null;
        });
        map.remove(null);
        return map;
    }

    public static <T> List<T> merge(List<List<T>> list) {
        if(list == null) return null;
        List<T> result = new ArrayList<>();
        list.stream().filter(Check::notNull).forEachOrdered(result::addAll);
        return result;
    }

    @SafeVarargs
    public static <T> List<T> addAll(Collection<T>... c) {
        if(c == null) return null;
        List<T> result = null;
        for(Collection<T> list : c) {
            if(list != null) {
                if(result == null) result = new ArrayList<>();
            } else continue;
            result.addAll(list);
        }
        return result;
    }

    @SafeVarargs
    public static <K, V> Map<K, V> putAll(Map<K, V>... c) {
        if(c == null) return null;
        Map<K, V> result = null;
        for(Map<K, V> map : c) {
            if(map != null) {
                if(result == null) result = new HashMap<>();
            } else continue;
            result.putAll(map);
        }
        return result;
    }

    public static <K, V> Map<K, V> mergeMap(List<Map<K, V>> list) {
        if(list == null) return null;
        Map<K, V> kvMap = new HashMap<>();
        list.stream().filter(Objects::nonNull).forEach(kvMap::putAll);
        return kvMap;
    }

    public static <K, V> List<Map<K, V>> divideMap(Map<K, V> m, int pageSize) {
        if(m == null) return null;
        int i = 0;
        List<Map<K, V>> mList = new ArrayList<>();
        for(K o : m.keySet()) {
            if(i % pageSize == 0) mList.add(new HashMap<>());
            mList.get(mList.size() - 1).put(o, m.get(o));
            i++;
        }
        return mList;
    }

    public static <E> List<List<E>> divideList(List<E> list, int pageSize) {
        if(list == null) return null;
        PageUtil init = PageUtil.init(list.size(), pageSize);
        return IntStream.range(1, init.getPage() + 1).mapToObj(i1->list.subList(init.getStartIndex(i1), init.getEndIndex(i1)))
                .collect(Collectors.toList());
    }

    public static void removeEmpty(Collection<?> update) {
        if(update == null || !update.contains(null)) return;
        update.removeAll(EMPTY_LIST);
    }

    public static <T> void distinct(Collection<T> update) {
        if(update == null || update.size() == 0) return;
        List<T> collect = update.stream().distinct().collect(Collectors.toList());
        update.clear();
        update.addAll(collect);
    }

    /**
     * 去重,去空,排序
     */
    public static <T> void optimal(Collection<T> list) {
        if(list == null || list.size() == 0) return;
        Stream<T> stream = list.stream();
        if(list.contains(null)) stream = stream.filter(Objects::nonNull);
        if((list instanceof List) && ((List<T>) list).get(0) instanceof Number) stream = stream.sorted();
        List<T> collect = stream.distinct().collect(Collectors.toList());
        list.clear();
        list.addAll(collect);
    }

    public static <T> void removeAll(Collection<T> region, Collection<T> list) {
        if(region == null || list == null) return;
        Set<T> ts = new HashSet<>(list);
        List<T> collect = region.stream().filter(t->!ts.contains(t)).collect(Collectors.toList());
        region.clear();
        region.addAll(collect);
    }

    @SuppressWarnings({ "unchecked" })
    public static <T> void sort(List<T> list, Function<? super T, ? extends Comparable<?>> k, Function<? super T, ? extends Comparable> m) {
        CollectUtil.removeEmpty(list);
        Function<T, Comparable> tComparableFunction = v->{
            Comparable apply = k.apply(v);
            if(apply != null) return apply;
            else {
                apply = m.apply(v);
                return apply != null ? apply : (Comparable) o->0;
            }
        };
        list.sort(Comparator.comparing(tComparableFunction));
    }

    @SuppressWarnings({ "unchecked" })
    public static <T> void sort(List<T> list, Function<? super T, ? extends Comparable<?>> k) {
        CollectUtil.removeEmpty(list);
        Function<T, Comparable> tComparableFunction = v->{
            Comparable apply = k.apply(v);
            return apply != null ? apply : (Comparable) o->0;
        };
        list.sort(Comparator.comparing(tComparableFunction));
    }

    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        if(list == null) return;
        CollectUtil.removeEmpty(list);
        list.sort(Comparator.comparing(t->t));
    }

    public static <T extends Comparable<? super T>> void reverse(List<T> list) {
        if(list == null) return;
        CollectUtil.removeEmpty(list);
        list.sort(Comparator.reverseOrder());
    }

    @SafeVarargs
    public static <T> T[] addArray(T[]... t) {
        if(t == null) return null;
        List<T> l = new ArrayList<>();
        Arrays.stream(t).map(Arrays::asList).forEachOrdered(l::addAll);
        return l.toArray(t[0]);
    }

    @SafeVarargs
    public static <T> List<T> asList(T... t) {
        List<T> list = new ArrayList<>();
        if(t == null) return list;
        Collections.addAll(list, t);
        return list;
    }

    @SafeVarargs
    public static <T> Set<T> asSet(T... t) {
        Set<T> list = new HashSet<>();
        if(t == null) return list;
        Collections.addAll(list, t);
        return list;
    }

    public static <T> T getElement(List<T> list, int index) {
        return (list.size() > index) ? list.get(index) : null;
    }

    public static <T> T getElement(T[] arr, int index) {
        return (arr.length > index) ? arr[index] : null;
    }

    public static <T, E> Map<E, List<T>> group(Collection<T> c, Function1ArgsR<T, E> fun) {
        return c.stream().collect(Collectors.groupingBy(fun::apply));
    }
}
