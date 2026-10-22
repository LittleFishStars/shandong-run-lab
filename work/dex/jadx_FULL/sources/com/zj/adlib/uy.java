package com.zj.adlib;

import androidx.arch.core.util.Function;
import com.fl.saas.base.base.builder.InnerSpreadBuilder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class uy implements Function {
    @Override // androidx.arch.core.util.Function
    public final Object apply(Object obj) {
        return Float.valueOf(((InnerSpreadBuilder) obj).getScreenPercentage());
    }
}
