package com.amap.api.col.p0003l;

import android.content.Context;
import com.alibaba.ariver.remotedebug.b.c;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import com.zj.adlib.a7b;
import com.zj.adlib.i9b;
import com.zj.adlib.j4b;
import com.zj.adlib.l4b;
import com.zj.adlib.qwb;
import com.zj.adlib.r4b;
import com.zj.adlib.s4b;
import com.zj.adlib.zwa;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e extends ey<String, a> {
    public boolean c;
    public String k;
    public String l;
    public String m;
    public final String o;
    public String p;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f25911a = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f791a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f792a = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f793a;
    }

    public e(Context context, String str) {
        super(context, str);
        this.l = "1.0";
        this.m = "0";
        this.o = "lastModified";
        this.c = false;
        this.p = null;
        ((ey) this).f = "/map/styles";
        ((ey) this).f835b = true;
    }

    @Override // com.amap.api.col.p0003l.ey
    public final /* bridge */ /* synthetic */ a a(String str) throws ex {
        return null;
    }

    public final void b(String str) {
        this.p = str;
    }

    @Override // com.amap.api.col.p0003l.ey
    public final String c() {
        return null;
    }

    public final void c(String str) {
        this.k = str;
    }

    public final void d(String str) {
        this.m = str;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return zwa.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(CachedContentIndex.a.e, j4b.j(((ey) this).b));
        if (this.c) {
            hashtable.put(UserTrackConstant.SDK_TYPE, this.p);
        } else {
            hashtable.put(c.g, "bin");
        }
        hashtable.put("styleid", this.k);
        hashtable.put("protocol", this.l);
        hashtable.put("ispublic", "1");
        hashtable.put("lastModified", this.m);
        String strA = l4b.a();
        String strC = l4b.c(((ey) this).b, strA, s4b.s(hashtable));
        hashtable.put("ts", strA);
        hashtable.put("scode", strC);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.ey, com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        r4b r4bVarT = zwa.t();
        String strE = r4bVarT != null ? r4bVarT.e() : null;
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", qwb.b);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", strE, "3dmap"));
        hashtable.put("x-INFO", l4b.b(((ey) this).b));
        hashtable.put(CachedContentIndex.a.e, j4b.j(((ey) this).b));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + ((ey) this).f;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.ey
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final a a(i9b i9bVar) throws ex {
        List<String> list;
        if (i9bVar == null) {
            return null;
        }
        a aVarA = a(i9bVar.f17171a);
        aVarA.f792a = aVarA.f793a != null;
        Map<String, List<String>> map = i9bVar.f17169a;
        if (map == null || !map.containsKey("lastModified") || (list = i9bVar.f17169a.get("lastModified")) == null || list.size() <= 0) {
            return aVarA;
        }
        aVarA.f791a = list.get(0);
        return aVarA;
    }

    @Override // com.amap.api.col.p0003l.ey
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final a a(byte[] bArr) throws ex {
        a aVar = new a();
        aVar.f793a = bArr;
        if (this.c && bArr != null) {
            if (bArr.length == 0) {
                aVar.f793a = null;
            } else if (bArr.length <= 1024) {
                try {
                    if (new String(bArr, "utf-8").contains("errcode")) {
                        aVar.f793a = null;
                    }
                } catch (Exception e) {
                    a7b.m(e, "CustomStyleRequest", "loadData");
                }
            }
        }
        return aVar;
    }

    public e(Context context, String str, boolean z) {
        super(context, str);
        this.l = "1.0";
        this.m = "0";
        this.o = "lastModified";
        this.p = null;
        this.c = z;
        if (z) {
            ((ey) this).f = "/sdk/map/styles";
            this.isPostFlag = false;
        } else {
            ((ey) this).f = "/map/styles";
        }
        ((ey) this).f835b = true;
    }
}
