package com.google.android.datatransport;

import com.zj.adlib.f33;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TransportFactory {
    <T> Transport<T> a(String str, Class<T> cls, f33 f33Var, Transformer<T, byte[]> transformer);

    @Deprecated
    <T> Transport<T> b(String str, Class<T> cls, Transformer<T, byte[]> transformer);
}
