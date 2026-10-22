package com.kwad.sdk.core.videocache;

import com.kwad.sdk.utils.az;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class i extends ProxySelector {
    private static final List<Proxy> bao = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector bap;
    private final String baq;
    private final int bar;

    private i(ProxySelector proxySelector, String str, int i) {
        this.bap = (ProxySelector) az.checkNotNull(proxySelector);
        this.baq = az.hY(str);
        this.bar = i;
    }

    public static void install(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.bap.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return this.baq.equals(uri.getHost()) && this.bar == uri.getPort() ? bao : this.bap.select(uri);
    }
}
