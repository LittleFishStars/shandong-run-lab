package com.zj.adlib;

import android.content.Context;
import com.ali.auth.third.core.model.KernelMessageConstants;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eqb extends com.amap.api.col.p0003l.ey<String, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f41501a;
    public boolean c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f16388a;
        public String b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41502a = -1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f16389a = false;
    }

    public eqb(Context context, String str) {
        super(context, str);
        this.f41501a = new int[]{10000, 0, 10018, 10019, KernelMessageConstants.PARAM_ERROR, KernelMessageConstants.USER_CANCEL, KernelMessageConstants.QRCODE_CLIENT_EXPIRED, 10023};
        ((com.amap.api.col.p0003l.ey) this).f = "/feedback";
        this.isPostFlag = false;
        this.c = true;
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
        Hashtable hashtable = new Hashtable(16);
        hashtable.put(CachedContentIndex.a.e, j4b.j(((com.amap.api.col.p0003l.ey) this).b));
        if (this.c) {
            hashtable.put("pname", "3dmap");
        }
        String strA = l4b.a();
        String strC = l4b.c(((com.amap.api.col.p0003l.ey) this).b, strA, s4b.s(hashtable));
        hashtable.put("ts", strA);
        hashtable.put("scode", strC);
        return hashtable;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return "http://restsdk.amap.com/v4" + ((com.amap.api.col.p0003l.ey) this).f;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // com.amap.api.col.p0003l.ey
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final a a(String str) throws com.amap.api.col.p0003l.ex {
        String strOptString;
        int iOptInt;
        String strOptString2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                iOptInt = jSONObject.optInt("errcode");
                strOptString = jSONObject.optString("errmsg");
                strOptString2 = jSONObject.optString("errdetail");
            } else {
                strOptString = "";
                iOptInt = -1;
                strOptString2 = "";
            }
            a aVar = new a();
            aVar.f41502a = iOptInt;
            aVar.f16388a = strOptString;
            aVar.b = strOptString2;
            aVar.f16389a = false;
            for (int i : this.f41501a) {
                if (i == iOptInt) {
                    aVar.f16389a = true;
                    break;
                }
            }
            return aVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
