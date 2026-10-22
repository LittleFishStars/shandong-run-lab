package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xv7 implements Factory<SchemaManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Context> f45904a;
    public final Provider<String> b;
    public final Provider<Integer> c;

    public xv7(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f45904a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static xv7 a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new xv7(provider, provider2, provider3);
    }

    public static SchemaManager c(Context context, String str, int i) {
        return new SchemaManager(context, str, i);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SchemaManager get() {
        return c((Context) this.f45904a.get(), (String) this.b.get(), ((Integer) this.c.get()).intValue());
    }
}
