package com.fl.saas;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
class Z extends ProxySelector {
    private static final List d = Arrays.asList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxySelector f30099a;
    private final String b;
    private final int c;

    public Z(ProxySelector proxySelector, String str, int i) {
        this.f30099a = (ProxySelector) AbstractC1442w0.a(proxySelector);
        this.b = (String) AbstractC1442w0.a(str);
        this.c = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new Z(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f30099a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        return (this.b.equals(uri.getHost()) && this.c == uri.getPort()) ? d : this.f30099a.select(uri);
    }
}
