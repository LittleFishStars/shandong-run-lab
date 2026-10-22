package com.bykv.vk.openvk.api.proto;

import android.util.SparseArray;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface PluginValueSet {
    <T> T[] arrayValue(int i, Class<T> cls);

    boolean booleanValue(int i);

    boolean booleanValue(int i, boolean z);

    boolean containsKey(int i);

    double doubleValue(int i);

    float floatValue(int i);

    float floatValue(int i, float f);

    int intValue(int i);

    int intValue(int i, int i2);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i);

    long longValue(int i, long j);

    <T> T objectValue(int i, Class<T> cls);

    void remove(int i);

    int size();

    SparseArray<Object> sparseArray();

    String stringValue(int i);

    String stringValue(int i, String str);
}
