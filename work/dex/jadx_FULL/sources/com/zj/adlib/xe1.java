package com.zj.adlib;

import com.google.android.datatransport.runtime.retries.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class xe1 implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ze1 f45805a;

    public xe1(ze1 ze1Var) {
        this.f45805a = ze1Var;
    }

    public static Function a(ze1 ze1Var) {
        return new xe1(ze1Var);
    }

    @Override // com.google.android.datatransport.runtime.retries.Function
    public Object apply(Object obj) {
        return this.f45805a.d((ze1.a) obj);
    }
}
