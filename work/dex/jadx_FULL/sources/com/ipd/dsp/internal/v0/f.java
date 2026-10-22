package com.ipd.dsp.internal.v0;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends ProxySelector {
    public static final List<Proxy> d = Collections.singletonList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ProxySelector f38565a;
    public final String b;
    public final int c;

    public f(ProxySelector proxySelector, String str, int i) {
        this.f38565a = proxySelector;
        this.b = str;
        this.c = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new f(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f38565a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.b.equals(uri.getHost()) && this.c == uri.getPort()) ? d : this.f38565a.select(uri);
    }
}
