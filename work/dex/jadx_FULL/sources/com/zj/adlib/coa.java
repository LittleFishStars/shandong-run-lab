package com.zj.adlib;

import com.amap.api.col.p0003l.db;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class coa extends db {
    public String f;

    public coa(String str) {
        this.f = str;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return getURL();
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return this.f;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isSupportIPV6() {
        return false;
    }
}
