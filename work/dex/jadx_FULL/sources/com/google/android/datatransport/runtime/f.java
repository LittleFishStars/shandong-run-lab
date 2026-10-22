package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.zj.adlib.f33;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements TransportFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f30436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportInternal f1939a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<f33> f1940a;

    public f(Set<f33> set, TransportContext transportContext, TransportInternal transportInternal) {
        this.f1940a = set;
        this.f30436a = transportContext;
        this.f1939a = transportInternal;
    }

    @Override // com.google.android.datatransport.TransportFactory
    public <T> Transport<T> a(String str, Class<T> cls, f33 f33Var, Transformer<T, byte[]> transformer) {
        if (this.f1940a.contains(f33Var)) {
            return new g(this.f30436a, str, f33Var, transformer, this.f1939a);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", f33Var, this.f1940a));
    }

    @Override // com.google.android.datatransport.TransportFactory
    public <T> Transport<T> b(String str, Class<T> cls, Transformer<T, byte[]> transformer) {
        return a(str, cls, f33.b("proto"), transformer);
    }
}
