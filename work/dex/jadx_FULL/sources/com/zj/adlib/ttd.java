package com.zj.adlib;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ttd extends wud {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f45002a;

    public /* synthetic */ ttd(Callable callable, vsd vsdVar) {
        super();
        this.f45002a = callable;
    }

    @Override // com.zj.adlib.wud
    public final String a() {
        try {
            return (String) this.f45002a.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
