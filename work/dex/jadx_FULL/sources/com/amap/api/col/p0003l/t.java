package com.amap.api.col.p0003l;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class t extends hs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f26052a;
    public Map<String, String> c;

    public t(byte[] bArr, Map<String, String> map) {
        this.f26052a = bArr;
        this.c = map;
        setDegradeAbility(hs.a.SINGLE);
        setHttpProtocol(hs.c.HTTPS);
    }

    @Override // com.amap.api.col.p0003l.hs
    public final byte[] getEntityBytes() {
        return this.f26052a;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return this.c;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
