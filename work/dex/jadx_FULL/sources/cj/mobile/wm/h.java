package cj.mobile.wm;

import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class h {
    public final n0 dexa;
    public final Class<?> dexb;
    public Enum[] dexc;
    public long[] dexd;

    public h(Class<?> cls, n0 n0Var, int i) {
        this.dexb = cls;
        this.dexa = n0Var;
        if (n0Var == null) {
            return;
        }
        Class<?> cls2 = n0Var.dexg;
        if (cls2.isEnum()) {
            Enum[] enumArr = (Enum[]) cls2.getEnumConstants();
            int length = enumArr.length;
            long[] jArr = new long[length];
            this.dexd = new long[enumArr.length];
            for (int i2 = 0; i2 < enumArr.length; i2++) {
                String strName = enumArr[i2].name();
                long jCharAt = TypeUtils.fnv1a_64_magic_hashcode;
                for (int i3 = 0; i3 < strName.length(); i3++) {
                    jCharAt = (jCharAt ^ ((long) strName.charAt(i3))) * TypeUtils.fnv1a_64_magic_prime;
                }
                jArr[i2] = jCharAt;
                this.dexd[i2] = jCharAt;
            }
            Arrays.sort(this.dexd);
            this.dexc = new Enum[enumArr.length];
            for (int i4 = 0; i4 < this.dexd.length; i4++) {
                for (int i5 = 0; i5 < length; i5++) {
                    if (this.dexd[i4] == jArr[i5]) {
                        this.dexc[i4] = enumArr[i5];
                        break;
                    }
                }
            }
        }
    }

    public Enum dexa(long j) {
        int iBinarySearch;
        if (this.dexc != null && (iBinarySearch = Arrays.binarySearch(this.dexd, j)) >= 0) {
            return this.dexc[iBinarySearch];
        }
        return null;
    }

    public abstract void dexa(dex11 dex11Var, Object obj, Type type, Map<String, Object> map);

    public void dexa(Object obj, double d) throws IllegalAccessException {
        this.dexa.dexc.setDouble(obj, d);
    }

    public void dexa(Object obj, float f) throws IllegalAccessException {
        this.dexa.dexc.setFloat(obj, f);
    }

    public void dexa(Object obj, int i) throws IllegalAccessException {
        this.dexa.dexc.setInt(obj, i);
    }

    public void dexa(Object obj, long j) throws IllegalAccessException {
        this.dexa.dexc.setLong(obj, j);
    }

    public void dexa(Object obj, Object obj2) {
        Collection collection;
        Map map;
        if (obj2 == null && this.dexa.dexg.isPrimitive()) {
            return;
        }
        n0 n0Var = this.dexa;
        Field field = n0Var.dexc;
        Method method = n0Var.dexb;
        try {
            if (n0Var.dexd) {
                if (!n0Var.dexj) {
                    field.set(obj, obj2);
                    return;
                }
                if (Map.class.isAssignableFrom(n0Var.dexg)) {
                    map = (Map) field.get(obj);
                    if (map != null) {
                        map.putAll((Map) obj2);
                        return;
                    }
                    return;
                }
                collection = (Collection) field.get(obj);
                if (collection != null) {
                    collection.addAll((Collection) obj2);
                }
                return;
            }
            if (!n0Var.dexj) {
                method.invoke(obj, obj2);
                return;
            }
            if (Map.class.isAssignableFrom(n0Var.dexg)) {
                map = (Map) method.invoke(obj, new Object[0]);
                if (map == null) {
                    return;
                }
                map.putAll((Map) obj2);
                return;
            }
            collection = (Collection) method.invoke(obj, new Object[0]);
            if (collection == null) {
                return;
            }
            collection.addAll((Collection) obj2);
        } catch (Exception e) {
            throw new com.wangmai.insightvision.openadsdk.d.d("set property error, " + this.dexa.dexa, e);
        }
    }
}
