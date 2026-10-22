package com.amap.api.col.p0003l;

import android.content.Context;
import com.zj.adlib.l4b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ez<T, V> extends ey<T, V> {
    public ez(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.p0003l.ey
    public abstract V a(String str) throws ex;

    @Override // com.amap.api.col.p0003l.ey
    public abstract String c();

    @Override // com.amap.api.col.p0003l.hs
    public byte[] getEntityBytes() {
        try {
            return c().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
    public Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.ey, com.amap.api.col.p0003l.hs
    public Map<String, String> getRequestHead() {
        HashMap map = new HashMap(16);
        map.put("Content-Type", " application/json");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "AMAP SDK Android Trace 9.5.0");
        map.put("x-INFO", l4b.i(((ey) this).b));
        map.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", "9.5.0", "trace"));
        map.put("logversion", "2.1");
        return map;
    }
}
