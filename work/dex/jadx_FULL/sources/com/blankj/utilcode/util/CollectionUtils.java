package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class CollectionUtils {

    public interface Closure<E> {
        void a(int i, E e);
    }

    public interface Predicate<E> {
        boolean a(E e);
    }

    public interface Transformer<E1, E2> {
        E2 transform(E1 e1);
    }

    public CollectionUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @SafeVarargs
    public static <E> LinkedList<E> A(E... eArr) {
        LinkedList<E> linkedList = new LinkedList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                linkedList.add(e);
            }
        }
        return linkedList;
    }

    @SafeVarargs
    public static <E> LinkedList<E> B(E... eArr) {
        LinkedList<E> linkedList = new LinkedList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                if (e != null) {
                    linkedList.add(e);
                }
            }
        }
        return linkedList;
    }

    public static Collection C(Collection collection) {
        return Collections.synchronizedCollection(collection);
    }

    @SafeVarargs
    public static <E> TreeSet<E> D(Comparator<E> comparator, E... eArr) {
        TreeSet<E> treeSet = new TreeSet<>(comparator);
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                treeSet.add(e);
            }
        }
        return treeSet;
    }

    @SafeVarargs
    public static <E> TreeSet<E> E(Comparator<E> comparator, E... eArr) {
        TreeSet<E> treeSet = new TreeSet<>(comparator);
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                if (e != null) {
                    treeSet.add(e);
                }
            }
        }
        return treeSet;
    }

    public static Collection F(Collection collection) {
        return Collections.unmodifiableCollection(collection);
    }

    @SafeVarargs
    public static <E> List<E> G(E... eArr) {
        return Collections.unmodifiableList(w(eArr));
    }

    @SafeVarargs
    public static <E> List<E> H(E... eArr) {
        return Collections.unmodifiableList(x(eArr));
    }

    public static <E> Collection<E> I(Collection<E> collection, Collection<E> collection2) {
        if (collection == null) {
            return new ArrayList();
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        for (E e : collection) {
            if (!collection2.contains(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> J(Collection<E> collection, Collection<E> collection2) {
        if (collection == null || collection2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (E e : collection) {
            if (collection2.contains(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> K(Collection<E> collection, Predicate<E> predicate) {
        if (collection == null || predicate == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (E e : collection) {
            if (predicate.a(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <E> Collection<E> L(Collection<E> collection, Predicate<E> predicate) {
        if (collection == null || predicate == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (E e : collection) {
            if (!predicate.a(e)) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    public static <T> void M(List<T> list) {
        Collections.shuffle(list);
    }

    public static int N(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length;
        }
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                i++;
                it.next();
            }
        } else {
            if (!(obj instanceof Enumeration)) {
                try {
                    return Array.getLength(obj);
                } catch (IllegalArgumentException unused) {
                    throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
                }
            }
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i++;
                enumeration.nextElement();
            }
        }
        return i;
    }

    public static boolean O(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj).length == 0;
        }
        if (obj instanceof Iterator) {
            return !((Iterator) obj).hasNext();
        }
        if (obj instanceof Enumeration) {
            return !((Enumeration) obj).hasMoreElements();
        }
        try {
            return Array.getLength(obj) == 0;
        } catch (IllegalArgumentException unused) {
            throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
        }
    }

    public static Collection P(Collection collection, Collection collection2) {
        if (collection == null) {
            return new ArrayList();
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        return arrayList;
    }

    public static String Q(Collection collection) {
        return collection == null ? "null" : collection.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E1, E2> void R(Collection<E1> collection, Transformer<E1, E2> transformer) {
        if (collection == null || transformer == 0) {
            return;
        }
        if (collection instanceof List) {
            ListIterator listIterator = ((List) collection).listIterator();
            while (listIterator.hasNext()) {
                listIterator.set(transformer.transform(listIterator.next()));
            }
        } else {
            Collection<? extends E1> collectionF = f(collection, transformer);
            collection.clear();
            collection.addAll(collectionF);
        }
    }

    public static Collection S(Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return new ArrayList();
        }
        if (collection == null) {
            return new ArrayList(collection2);
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMax = Math.max(p(obj, mapO), p(obj, mapO2));
            for (int i = 0; i < iMax; i++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <E> void a(Collection<E> collection, Enumeration<E> enumeration) {
        if (collection == null || enumeration == null) {
            return;
        }
        while (enumeration.hasMoreElements()) {
            collection.add(enumeration.nextElement());
        }
    }

    public static <E> void b(Collection<E> collection, Iterator<E> it) {
        if (collection == null || it == null) {
            return;
        }
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static <E> void c(Collection<E> collection, E[] eArr) {
        if (collection == null || eArr == null || eArr.length == 0) {
            return;
        }
        collection.addAll(Arrays.asList(eArr));
    }

    public static <E> boolean d(Collection<E> collection, E e) {
        return (collection == null || e == null || !collection.add(e)) ? false : true;
    }

    public static <E> int e(E e, Collection<E> collection) {
        int i = 0;
        if (collection == null) {
            return 0;
        }
        if (collection instanceof Set) {
            return collection.contains(e) ? 1 : 0;
        }
        if (e == null) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    i++;
                }
            }
        } else {
            Iterator<E> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (e.equals(it2.next())) {
                    i++;
                }
            }
        }
        return i;
    }

    public static <E1, E2> Collection<E2> f(Collection<E1> collection, Transformer<E1, E2> transformer) {
        ArrayList arrayList = new ArrayList();
        if (collection != null && transformer != null) {
            Iterator<E1> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(transformer.transform(it.next()));
            }
        }
        return arrayList;
    }

    public static boolean g(Collection collection, Collection collection2) {
        if (collection != null && collection2 != null) {
            if (collection.size() < collection2.size()) {
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (collection2.contains(it.next())) {
                        return true;
                    }
                }
            } else {
                Iterator it2 = collection2.iterator();
                while (it2.hasNext()) {
                    if (collection.contains(it2.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static <E> int h(Collection<E> collection, Predicate<E> predicate) {
        int i = 0;
        if (collection != null && predicate != null) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (predicate.a(it.next())) {
                    i++;
                }
            }
        }
        return i;
    }

    public static Collection i(Collection collection, Collection collection2) {
        if (collection == null && collection2 == null) {
            return new ArrayList();
        }
        if (collection == null) {
            return new ArrayList(collection2);
        }
        if (collection2 == null) {
            return new ArrayList(collection);
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMax = Math.max(p(obj, mapO), p(obj, mapO2)) - Math.min(p(obj, mapO), p(obj, mapO2));
            for (int i = 0; i < iMax; i++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <E> boolean j(Collection<E> collection, Predicate<E> predicate) {
        if (collection != null && predicate != null) {
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                if (predicate.a(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <E> void k(Collection<E> collection, Predicate<E> predicate) {
        if (collection == null || predicate == null) {
            return;
        }
        Iterator<E> it = collection.iterator();
        while (it.hasNext()) {
            if (!predicate.a(it.next())) {
                it.remove();
            }
        }
    }

    public static <E> E l(Collection<E> collection, Predicate<E> predicate) {
        if (collection != null && predicate != null) {
            for (E e : collection) {
                if (predicate.a(e)) {
                    return e;
                }
            }
        }
        return null;
    }

    public static <E> void m(Collection<E> collection, Closure<E> closure) {
        if (collection == null || closure == null) {
            return;
        }
        Iterator<E> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            closure.a(i, it.next());
            i++;
        }
    }

    public static Object n(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + i);
        }
        if (obj instanceof Map) {
            return n(((Map) obj).entrySet().iterator(), i);
        }
        if (obj instanceof List) {
            return ((List) obj).get(i);
        }
        if (obj instanceof Object[]) {
            return ((Object[]) obj)[i];
        }
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                i--;
                if (i == -1) {
                    return it.next();
                }
                it.next();
            }
            throw new IndexOutOfBoundsException("Entry does not exist: " + i);
        }
        if (obj instanceof Collection) {
            return n(((Collection) obj).iterator(), i);
        }
        if (!(obj instanceof Enumeration)) {
            try {
                return Array.get(obj, i);
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
            }
        }
        Enumeration enumeration = (Enumeration) obj;
        while (enumeration.hasMoreElements()) {
            i--;
            if (i == -1) {
                return enumeration.nextElement();
            }
            enumeration.nextElement();
        }
        throw new IndexOutOfBoundsException("Entry does not exist: " + i);
    }

    public static Map<Object, Integer> o(Collection collection) {
        HashMap map = new HashMap();
        if (collection == null) {
            return map;
        }
        for (Object obj : collection) {
            Integer num = (Integer) map.get(obj);
            if (num == null) {
                map.put(obj, 1);
            } else {
                map.put(obj, Integer.valueOf(num.intValue() + 1));
            }
        }
        return map;
    }

    public static int p(Object obj, Map map) {
        Integer num = (Integer) map.get(obj);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public static Collection q(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        HashSet hashSet = new HashSet(collection);
        hashSet.addAll(collection2);
        for (Object obj : hashSet) {
            int iMin = Math.min(p(obj, mapO), p(obj, mapO2));
            for (int i = 0; i < iMin; i++) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static boolean r(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean s(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        if (mapO.size() != mapO2.size()) {
            return false;
        }
        for (Object obj : mapO.keySet()) {
            if (p(obj, mapO) != p(obj, mapO2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean t(Collection collection) {
        return !r(collection);
    }

    public static boolean u(Collection collection, Collection collection2) {
        return collection != null && collection2 != null && collection.size() < collection2.size() && v(collection, collection2);
    }

    public static boolean v(Collection collection, Collection collection2) {
        if (collection == null || collection2 == null) {
            return false;
        }
        Map<Object, Integer> mapO = o(collection);
        Map<Object, Integer> mapO2 = o(collection2);
        for (Object obj : collection) {
            if (p(obj, mapO) > p(obj, mapO2)) {
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    public static <E> ArrayList<E> w(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    @SafeVarargs
    public static <E> ArrayList<E> x(E... eArr) {
        ArrayList<E> arrayList = new ArrayList<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                if (e != null) {
                    arrayList.add(e);
                }
            }
        }
        return arrayList;
    }

    @SafeVarargs
    public static <E> HashSet<E> y(E... eArr) {
        HashSet<E> hashSet = new HashSet<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                hashSet.add(e);
            }
        }
        return hashSet;
    }

    @SafeVarargs
    public static <E> HashSet<E> z(E... eArr) {
        HashSet<E> hashSet = new HashSet<>();
        if (eArr != null && eArr.length != 0) {
            for (E e : eArr) {
                if (e != null) {
                    hashSet.add(e);
                }
            }
        }
        return hashSet;
    }
}
