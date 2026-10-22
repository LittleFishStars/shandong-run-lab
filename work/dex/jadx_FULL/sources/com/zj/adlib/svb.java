package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.amap.api.col.p0003l.it;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class svb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f44791a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f19666a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HandlerThread f19667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f19668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<IAMapDelegate> f19670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f19669a = new a();
    public final Runnable b = new b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (svb.this.f19668a == null) {
                svb svbVar = svb.this;
                svbVar.f19668a = new c(svbVar.f44791a, svb.this);
            }
            ywa.a().b(svb.this.f19668a);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IAMapDelegate iAMapDelegate = (IAMapDelegate) svb.this.f19670a.get();
            if (iAMapDelegate != null) {
                iAMapDelegate.setTerrainAuth(false);
            }
            dva.b(svb.this.f44791a, "地形图鉴权失败，当前key没有地形图的使用权限，地形图，将不会呈现！");
        }
    }

    public static class c extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f44794a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public d f19671a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public svb f19672a;

        public c(Context context, svb svbVar) {
            this.f44794a = context;
            this.f19672a = svbVar;
            this.f19671a = new d(context, "");
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            try {
                e eVarM = this.f19671a.m();
                if (eVarM == null) {
                    this.f19672a.d(30000L);
                } else {
                    if (eVarM.f19673a) {
                        return;
                    }
                    this.f19672a.h();
                }
            } catch (com.amap.api.col.p0003l.ex e) {
                e.printStackTrace();
                this.f19672a.d(30000L);
            }
        }
    }

    public static class d extends com.amap.api.col.p0003l.ey<String, e> {
        public boolean c;

        public d(Context context, String str) {
            super(context, str);
            ((com.amap.api.col.p0003l.ey) this).f = "/rest/feedback/terrain";
            this.isPostFlag = false;
            this.c = true;
        }

        public static e o(String str) throws com.amap.api.col.p0003l.ex {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String strOptString = jSONObject.optString(AliyunLogCommon.LogLevel.INFO);
                String strOptString2 = jSONObject.optString("infocode");
                String strOptString3 = jSONObject.optString("status");
                boolean z = false;
                z = false;
                e eVar = new e(z ? (byte) 1 : (byte) 0);
                eVar.f44795a = strOptString;
                eVar.b = strOptString2;
                eVar.c = strOptString3;
                if (!TextUtils.isEmpty(strOptString2) && TextUtils.equals(strOptString2, "10000")) {
                    z = true;
                }
                eVar.f19673a = z;
                return eVar;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static e p(byte[] bArr) throws com.amap.api.col.p0003l.ex {
            String str;
            try {
                str = new String(bArr, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (str == null || "".equals(str)) {
                return null;
            }
            return o(str);
        }

        @Override // com.amap.api.col.p0003l.ey
        public final /* synthetic */ e a(String str) throws com.amap.api.col.p0003l.ex {
            return o(str);
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
            return "http://restsdk.amap.com" + ((com.amap.api.col.p0003l.ey) this).f;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final boolean isSupportIPV6() {
            return true;
        }

        @Override // com.amap.api.col.p0003l.ey
        public final /* synthetic */ e a(byte[] bArr) throws com.amap.api.col.p0003l.ex {
            return p(bArr);
        }
    }

    public svb(Context context, IAMapDelegate iAMapDelegate) {
        this.f44791a = context.getApplicationContext();
        this.f19670a = new WeakReference<>(iAMapDelegate);
        f();
    }

    public final void c() {
        Handler handler = this.f19666a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f19666a = null;
        }
        HandlerThread handlerThread = this.f19667a;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.f19667a = null;
        }
    }

    public final void d(long j) {
        Handler handler = this.f19666a;
        if (handler != null) {
            handler.postDelayed(this.f19669a, j);
        }
    }

    public final void f() {
        if (this.f19667a == null) {
            HandlerThread handlerThread = new HandlerThread("terrain_auth");
            this.f19667a = handlerThread;
            handlerThread.start();
            this.f19666a = new Handler(this.f19667a.getLooper());
        }
    }

    public final void h() {
        Handler handler = this.f19666a;
        if (handler != null) {
            handler.postDelayed(this.b, 1000L);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f44795a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f19673a;
        public String b;
        public String c;

        public e() {
            this.f19673a = false;
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }
}
