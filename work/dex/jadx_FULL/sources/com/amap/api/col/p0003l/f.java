package com.amap.api.col.p0003l;

import android.content.Context;
import com.alibaba.ariver.remotedebug.b.c;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.s4b;
import com.zj.adlib.zwa;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f extends ey<String, a> {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25937a = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f836a;
    }

    public f(Context context, String str) {
        super(context, str);
        ((ey) this).f = "/map/styles";
    }

    public static a o(byte[] bArr) throws ex {
        a aVar = new a();
        aVar.f836a = bArr;
        return aVar;
    }

    @Override // com.amap.api.col.p0003l.ey
    public final /* bridge */ /* synthetic */ a a(String str) throws ex {
        return null;
    }

    @Override // com.amap.api.col.p0003l.ey
    public final /* synthetic */ a a(byte[] bArr) throws ex {
        return o(bArr);
    }

    public final void b(String str) {
        ((ey) this).f = str;
    }

    @Override // com.amap.api.col.p0003l.ey
    public final String c() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return zwa.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        HashMap map = new HashMap(16);
        map.put(CachedContentIndex.a.e, j4b.j(((ey) this).b));
        map.put(c.g, "bin");
        String strA = l4b.a();
        String strC = l4b.c(((ey) this).b, strA, s4b.s(map));
        map.put("ts", strA);
        map.put("scode", strC);
        return map;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return ((ey) this).f;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isSupportIPV6() {
        return true;
    }
}
