package com.kc.cw.ad.internal.d;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class k extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f38970a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    public k(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) n.a(proxySelector);
        this.c = (String) n.a(str);
        this.d = i;
    }

    public static void a(String str, int i) {
        ProxySelector.setDefault(new k(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        try {
            return this.c.equals(uri.getHost()) && this.d == uri.getPort() ? f38970a : this.b.select(uri);
        } catch (Exception unused) {
            return f38970a;
        }
    }
}
