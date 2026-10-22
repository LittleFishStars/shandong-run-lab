package com.zj.adlib;

import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class sj1 implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((WeakReference) obj).get();
    }
}
