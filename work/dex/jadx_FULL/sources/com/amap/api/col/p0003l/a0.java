package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.sdk.m.y.l;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.axa;
import com.zj.adlib.bxa;
import com.zj.adlib.c7b;
import com.zj.adlib.lwa;
import com.zj.adlib.n4b;
import com.zj.adlib.o9b;
import com.zj.adlib.pwa;
import com.zj.adlib.qwa;
import com.zj.adlib.r4b;
import com.zj.adlib.s4b;
import com.zj.adlib.sxb;
import com.zj.adlib.wwa;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a0 extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<IAMapDelegate> f687a;

    public class a extends it {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f688a;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(String str, String str2, boolean z, String str3, String str4, String str5, String str6) {
            this.f = str;
            this.g = str2;
            this.f688a = z;
            this.h = str3;
            this.i = str4;
            this.j = str5;
            this.k = str6;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            if (!TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(this.g)) {
                boolean z = this.f688a;
                String str = AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME;
                String str2 = this.g;
                String str3 = this.f;
                String str4 = this.h;
                if (z) {
                    b0.d dVar = new b0.d(str2, str3, str4, str);
                    dVar.g("amap_web_logo", "md5_day");
                    Context context = a0.this.f25873a;
                    zwa.t();
                    new b0(context, dVar).a();
                }
                WeakReference<IAMapDelegate> weakReference = a0.this.f687a;
                if (weakReference != null && weakReference.get() != null) {
                    a0.this.f687a.get().changeLogoIconStyle(str, z, 0);
                }
            }
            if (TextUtils.isEmpty(this.i) || TextUtils.isEmpty(this.j)) {
                return;
            }
            boolean z2 = this.f688a;
            String str5 = AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME;
            String str6 = this.j;
            String str7 = this.i;
            String str8 = this.k;
            if (z2) {
                b0.d dVar2 = new b0.d(str6, str7, str8, str5);
                dVar2.g("amap_web_logo", "md5_night");
                Context context2 = a0.this.f25873a;
                zwa.t();
                new b0(context2, dVar2).a();
            }
            WeakReference<IAMapDelegate> weakReference2 = a0.this.f687a;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            a0.this.f687a.get().changeLogoIconStyle(str5, z2, 1);
        }
    }

    public a0(Context context, IAMapDelegate iAMapDelegate) {
        this.f687a = null;
        this.f25873a = context;
        this.f687a = new WeakReference<>(iAMapDelegate);
    }

    public static void c(Context context, r4b r4bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("16V");
            boolean zX = fh.x(jSONObjectOptJSONObject.optString("di", ""), false);
            String strOptString = jSONObjectOptJSONObject.optString("dis", "");
            boolean zX2 = fh.x(jSONObjectOptJSONObject.optString("able", ""), false);
            boolean zX3 = fh.x(jSONObjectOptJSONObject.optString("isFilter", ""), true);
            if (!zX || s4b.C(strOptString)) {
                c7b.a(r4bVar).b(context, zX2, zX3);
            }
        } catch (Throwable unused) {
        }
    }

    public static void e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            bxa.j(jSONObject.optJSONObject("17E"));
        } catch (Throwable unused) {
        }
    }

    public static void g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("16G");
            boolean zX = fh.x(jSONObjectOptJSONObject.optString("able", ""), false);
            boolean zX2 = fh.x(jSONObjectOptJSONObject.optString("removeCache", ""), false);
            boolean zX3 = fh.x(jSONObjectOptJSONObject.optString("uploadInfo", ""), false);
            qwa.a(zX);
            qwa.d(zX2);
            qwa.f(zX3);
        } catch (Throwable unused) {
        }
    }

    public final Pair<JSONObject, fh.c.a> b(StringBuilder sb) {
        String string;
        JSONObject jSONObject;
        fh.c.a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long jLongValue = pwa.a(this.f25873a, "cloud_config_pull", "cloud_config_pull_timestamp", 0L).longValue();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - jLongValue) >= 86400000) {
                string = sb.toString();
                string.replaceAll(";;", l.b);
                pwa.c(this.f25873a, "cloud_config_pull", "cloud_config_pull_timestamp", new Long(jCurrentTimeMillis));
            } else {
                string = "";
            }
            fh.c cVarC = fh.c(this.f25873a, zwa.t(), string, null);
            if (fh.f25939a != 1 && string != "" && cVarC != null && (weakReference = this.f687a) != null && weakReference.get() != null) {
                Message messageObtainMessage = this.f687a.get().getMainHandler().obtainMessage();
                messageObtainMessage.what = 2;
                String str = cVarC.f861a;
                if (str != null) {
                    messageObtainMessage.obj = str;
                }
                this.f687a.get().getMainHandler().sendMessage(messageObtainMessage);
            }
            String str2 = GLFileUtil.getCacheDir(this.f25873a).getAbsolutePath() + "/authCustomConfigName";
            if (TextUtils.isEmpty(string) || cVarC == null || (jSONObject = cVarC.c) == null) {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str2)));
            } else {
                GLFileUtil.writeDatasToFile(str2, jSONObject.toString().getBytes());
            }
            String str3 = GLFileUtil.getCacheDir(this.f25873a).getAbsolutePath() + "/authLogConfigName";
            if (TextUtils.isEmpty(string) || cVarC == null || cVarC.f859a == null) {
                byte[] fileContents = GLFileUtil.readFileContents(str3);
                fh.c.a aVar2 = new fh.c.a();
                JSONObject jSONObject2 = new JSONObject(new String(fileContents));
                aVar2.f864a = jSONObject2.getBoolean("IsExceptionUpdate");
                if (jSONObject2.has("mOfflineLoc")) {
                    aVar2.f25941a = jSONObject2.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("IsExceptionUpdate", cVarC.f859a.f864a);
                jSONObject3.put("mOfflineLoc", cVarC.f859a.f25941a);
                GLFileUtil.writeDatasToFile(str3, jSONObject3.toString().getBytes());
                aVar = cVarC.f859a;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void d(fh.c.a aVar) {
        if (aVar != null) {
            try {
                wwa.a(this.f25873a, "maploc", "ue", Boolean.valueOf(aVar.f864a));
                JSONObject jSONObject = aVar.f25941a;
                int iOptInt = jSONObject.optInt("fn", 1000);
                int iOptInt2 = jSONObject.optInt("mpn", 0);
                if (iOptInt2 > 500) {
                    iOptInt2 = 500;
                }
                if (iOptInt2 < 30) {
                    iOptInt2 = 30;
                }
                o9b.b(iOptInt, fh.x(jSONObject.optString("igu"), false));
                wwa.a(this.f25873a, "maploc", "opn", Integer.valueOf(iOptInt2));
            } catch (Throwable th) {
                a7b.m(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    public final void f(JSONObject jSONObject) {
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            sxb.a().b(jSONObject.optJSONObject("1A1"));
            if (!sxb.a().c("feature_terrain") && (iAMapDelegate3 = this.f687a.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                zwa.D(new AMapException(AMapException.FEATURE_TERRAIN_NOT_SUPPORT));
            }
            if (!sxb.a().c("feature_gltf") && (iAMapDelegate2 = this.f687a.get()) != null) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                zwa.D(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
            }
            if (sxb.a().c("feature_mvt") || (iAMapDelegate = this.f687a.get()) == null) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            zwa.D(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            pwa.c(this.f25873a, "amap_param", "overlay_use_old_type", Boolean.valueOf(fh.x(jSONObject.optJSONObject("17W").optString("able", ""), false) ? false : true));
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Code duplicated, block: B:74:0x019f  */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z;
        JSONObject jSONObjectOptJSONObject;
        WeakReference<IAMapDelegate> weakReference;
        WeakReference<IAMapDelegate> weakReference2;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        JSONObject jSONObjectOptJSONObject2;
        Object obj6;
        JSONObject jSONObjectOptJSONObject3;
        Object obj7;
        r4b r4bVarT;
        Object obj8;
        JSONObject jSONObjectOptJSONObject4;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                n4b.a().c(this.f25873a);
                StringBuilder sb = new StringBuilder();
                sb.append("14S");
                sb.append(l.b);
                sb.append("11K");
                sb.append(l.b);
                sb.append("001");
                sb.append(l.b);
                sb.append("14M");
                sb.append(l.b);
                sb.append("14L");
                sb.append(l.b);
                sb.append("16V");
                sb.append(l.b);
                sb.append("14Z");
                sb.append(l.b);
                sb.append("154");
                sb.append(l.b);
                sb.append("156");
                sb.append(l.b);
                sb.append("15C");
                sb.append(l.b);
                sb.append("16G");
                sb.append(l.b);
                sb.append("17W");
                sb.append(l.b);
                sb.append("17E");
                sb.append(l.b);
                sb.append("1A1");
                try {
                    WeakReference<IAMapDelegate> weakReference3 = this.f687a;
                    if (weakReference3 != null && weakReference3.get() != null) {
                        IAMapDelegate iAMapDelegate = this.f687a.get();
                        if (iAMapDelegate.getAMapExtraInterfaceManager() != null) {
                            String strG = iAMapDelegate.getAMapExtraInterfaceManager().g();
                            if (!TextUtils.isEmpty(strG)) {
                                if (strG.indexOf(l.b) == 0) {
                                    sb.append(strG);
                                } else {
                                    sb.append(l.b);
                                    sb.append(strG);
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
                Pair<JSONObject, fh.c.a> pairB = b(sb);
                if (pairB != null && (obj8 = pairB.first) != null && (jSONObjectOptJSONObject4 = ((JSONObject) obj8).optJSONObject("154")) != null && fh.x(jSONObjectOptJSONObject4.getString("able"), true)) {
                    String strOptString = jSONObjectOptJSONObject4.optString("mc");
                    String strOptString2 = jSONObjectOptJSONObject4.optString("si");
                    String strOptString3 = jSONObjectOptJSONObject4.optString("te");
                    if (!TextUtils.isEmpty(strOptString)) {
                        pwa.c(this.f25873a, "approval_number", "mc", strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        pwa.c(this.f25873a, "approval_number", "si", strOptString2);
                    }
                    if (!TextUtils.isEmpty(strOptString3)) {
                        pwa.c(this.f25873a, "approval_number", "te", strOptString3);
                    }
                }
                if (pairB != null && pairB.second != null && (r4bVarT = zwa.t()) != null) {
                    r4bVarT.c(((fh.c.a) pairB.second).f864a);
                }
                if (pairB != null) {
                    d((fh.c.a) pairB.second);
                }
                if (pairB != null) {
                    try {
                        Object obj9 = pairB.first;
                        if (obj9 == null || (jSONObjectOptJSONObject = ((JSONObject) obj9).optJSONObject("14M")) == null || !jSONObjectOptJSONObject.has("able")) {
                            z = true;
                        } else {
                            z = true;
                            try {
                                if (fh.x(jSONObjectOptJSONObject.getString("able"), true)) {
                                    if (System.currentTimeMillis() - pwa.a(this.f25873a, "Map3DCache", "time", 0L).longValue() > (jSONObjectOptJSONObject.has("time") ? Math.max(60, jSONObjectOptJSONObject.getInt("time")) : 2592000) * 1000 && (weakReference = this.f687a) != null && weakReference.get() != null) {
                                        this.f687a.get().clearTileCache();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                th.printStackTrace();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z = true;
                    }
                } else {
                    z = true;
                }
                if (pairB != null && (obj7 = pairB.first) != null) {
                    try {
                        JSONObject jSONObjectOptJSONObject5 = ((JSONObject) obj7).optJSONObject("14L");
                        if (jSONObjectOptJSONObject5 != null && jSONObjectOptJSONObject5.has("able")) {
                            boolean zX = fh.x(jSONObjectOptJSONObject5.getString("able"), false);
                            WeakReference<IAMapDelegate> weakReference4 = this.f687a;
                            if (weakReference4 != null && weakReference4.get() != null) {
                                this.f687a.get().setHideLogoEnble(!zX ? z : false);
                            }
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                if (pairB != null && (obj6 = pairB.first) != null && (jSONObjectOptJSONObject3 = ((JSONObject) obj6).optJSONObject("156")) != null) {
                    lwa.e(fh.x(jSONObjectOptJSONObject3.optString("able"), false));
                }
                if (pairB != null && pairB.first != null) {
                    c(this.f25873a, zwa.t(), (JSONObject) pairB.first);
                }
                if (pairB != null && (obj5 = pairB.first) != null && (jSONObjectOptJSONObject2 = ((JSONObject) obj5).optJSONObject("15C")) != null) {
                    boolean zX2 = fh.x(jSONObjectOptJSONObject2.optString("able"), false);
                    ywa.a().b(new a(jSONObjectOptJSONObject2.optString("logo_day_md5"), jSONObjectOptJSONObject2.optString("logo_day_url"), zX2, jSONObjectOptJSONObject2.optString("logo_day_ipv6_url"), jSONObjectOptJSONObject2.optString("logo_night_md5"), jSONObjectOptJSONObject2.optString("logo_night_url"), jSONObjectOptJSONObject2.optString("logo_night_ipv6_url")));
                }
                if (pairB != null) {
                    try {
                        if (pairB.first != null && (weakReference2 = this.f687a) != null && weakReference2.get() != null) {
                            IAMapDelegate iAMapDelegate2 = this.f687a.get();
                            if (iAMapDelegate2.getAMapExtraInterfaceManager() != null) {
                                iAMapDelegate2.getAMapExtraInterfaceManager().h();
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
                if (pairB != null && (obj4 = pairB.first) != null) {
                    g((JSONObject) obj4);
                }
                if (pairB != null && (obj3 = pairB.first) != null) {
                    h((JSONObject) obj3);
                }
                if (pairB != null && (obj2 = pairB.first) != null) {
                    e((JSONObject) obj2);
                }
                if (pairB != null && (obj = pairB.first) != null) {
                    f((JSONObject) obj);
                }
                a7b.d(this.f25873a, zwa.t());
                interrupt();
                WeakReference<IAMapDelegate> weakReference5 = this.f687a;
                if (weakReference5 == null || weakReference5.get() == null) {
                    return;
                }
                this.f687a.get().setRunLowFrame(false);
            }
        } catch (Throwable th4) {
            interrupt();
            a7b.m(th4, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th4.printStackTrace();
            bxa.l(axa.c, "auth exception " + th4.getMessage());
        }
    }
}
