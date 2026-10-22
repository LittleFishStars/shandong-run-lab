package com.amap.api.col.p0003l;

import com.zj.adlib.p4b;
import com.zj.adlib.s4b;
import com.zj.adlib.s6b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class s extends fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f26051a;
    public String f;

    public s(byte[] bArr, String str) {
        this.f = "1";
        this.f26051a = (byte[]) bArr.clone();
        this.f = str;
        setDegradeAbility(hs.a.SINGLE);
        setHttpProtocol(hs.c.HTTP);
    }

    @Override // com.amap.api.col.p0003l.hs
    public final byte[] getEntityBytes() {
        return this.f26051a;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/zip");
        map.put("Content-Length", String.valueOf(this.f26051a.length));
        return map;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        String strV = s4b.v(s6b.f19531b);
        byte[] bArrP = s4b.p(s6b.f19527a);
        byte[] bArr = new byte[bArrP.length + 50];
        System.arraycopy(this.f26051a, 0, bArr, 0, 50);
        System.arraycopy(bArrP, 0, bArr, 50, bArrP.length);
        return String.format(strV, "1", this.f, "1", "open", p4b.b(bArr));
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isHostToIP() {
        return false;
    }
}
