package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportScheduleCallback;
import com.zj.adlib.f33;
import com.zj.adlib.gc9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g<T> implements Transport<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Transformer<T, byte[]> f30437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f1941a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportInternal f1942a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f33 f1943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1944a;

    public g(TransportContext transportContext, String str, f33 f33Var, Transformer<T, byte[]> transformer, TransportInternal transportInternal) {
        this.f1941a = transportContext;
        this.f1944a = str;
        this.f1943a = f33Var;
        this.f30437a = transformer;
        this.f1942a = transportInternal;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // com.google.android.datatransport.Transport
    public void a(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
        this.f1942a.a(SendRequest.a().f(this.f1941a).c(event).g(this.f1944a).e(this.f30437a).b(this.f1943a).a(), transportScheduleCallback);
    }

    @Override // com.google.android.datatransport.Transport
    public void b(Event<T> event) {
        a(event, gc9.b());
    }
}
