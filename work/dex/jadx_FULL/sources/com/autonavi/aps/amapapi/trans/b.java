package com.autonavi.aps.amapapi.trans;

import android.text.TextUtils;
import com.amap.api.col.p0003l.fm;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b extends fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f26196a = null;
    Map<String, String> b = null;
    String g = "";
    byte[] h = null;
    private String i = null;

    public final void a(Map<String, String> map) {
        this.f26196a = map;
    }

    public final void b(Map<String, String> map) {
        this.b = map;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final byte[] getEntityBytes() {
        return this.h;
    }

    @Override // com.amap.api.col.p0003l.fm, com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return !TextUtils.isEmpty(this.i) ? this.i : super.getIPV6URL();
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return this.b;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        return this.f26196a;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return this.g;
    }

    public final void a(String str) {
        this.g = str;
    }

    public final void b(String str) {
        this.i = str;
    }

    public final void a(byte[] bArr) {
        this.h = bArr;
    }
}
