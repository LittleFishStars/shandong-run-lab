package com.baidu.mapauto.auth.org.spongycastle.util;

import java.security.PrivilegedAction;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b implements PrivilegedAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f26657a = "org.spongycastle.asn1.allow_unsafe_integer";

    @Override // java.security.PrivilegedAction
    public final Object run() {
        Map map = (Map) c.f26658a.get();
        return map != null ? map.get(this.f26657a) : System.getProperty(this.f26657a);
    }
}
