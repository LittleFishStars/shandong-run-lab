package com.zj.adlib;

import com.google.android.datatransport.runtime.retries.RetryStrategy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class ye1 implements RetryStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ye1 f46011a = new ye1();

    public static RetryStrategy b() {
        return f46011a;
    }

    @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
    public Object a(Object obj, Object obj2) {
        return ze1.k((ze1.a) obj, (ze1.b) obj2);
    }
}
