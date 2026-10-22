package com.kc.aw;

import com.ipd.dsp.internal.v0.q;
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
public final class _ew extends ProxySelector {
    public static final List<Proxy> _d = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector _a;
    public final String _b = (String) _hp._a(q.i);
    public final int _c;

    public _ew(ProxySelector proxySelector, int i) {
        this._a = (ProxySelector) _hp._a(proxySelector);
        this._c = i;
    }

    public static void _a(int i) {
        ProxySelector.setDefault(new _ew(ProxySelector.getDefault(), i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this._a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this._b.equals(uri.getHost()) && this._c == uri.getPort()) ? _d : this._a.select(uri);
    }
}
