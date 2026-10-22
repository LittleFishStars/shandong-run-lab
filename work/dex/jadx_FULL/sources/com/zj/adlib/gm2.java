package com.zj.adlib;

import android.telephony.TelephonyManager;
import androidx.arch.core.util.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class gm2 implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return ((TelephonyManager) obj).getSimOperator();
    }
}
