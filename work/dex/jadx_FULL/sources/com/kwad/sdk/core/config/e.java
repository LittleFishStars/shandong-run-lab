package com.kwad.sdk.core.config;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.item.f;
import com.kwad.sdk.core.config.item.g;
import com.kwad.sdk.core.config.item.l;
import com.kwad.sdk.core.config.item.p;
import com.kwad.sdk.core.config.item.s;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.i;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static volatile SdkConfigData aQW;
    private static final AtomicBoolean aQV = new AtomicBoolean(false);
    private static final Object mLock = new Object();

    public static boolean Dv() {
        return c.aPr.getValue().booleanValue();
    }

    public static boolean FF() {
        return c.aOc.getValue().intValue() == 1;
    }

    public static boolean FH() {
        return c.aOd.getValue().intValue() == 1;
    }

    public static boolean FI() {
        return c.aOb.getValue().intValue() == 1;
    }

    public static String FJ() {
        return c.aOp.getImei();
    }

    public static String FK() {
        return c.aOp.getOaid();
    }

    public static List<String> FL() {
        return c.aNI.getValue();
    }

    public static boolean FM() {
        return c.aOB.getValue().intValue() == 1;
    }

    public static boolean FN() {
        return c.aOC.getValue().booleanValue();
    }

    public static boolean FO() {
        return c.aOE.getValue().intValue() == 1;
    }

    public static boolean FQ() {
        return c.aPb.getValue().booleanValue();
    }

    public static boolean FR() {
        return c.aPc.getValue().booleanValue();
    }

    public static int FS() {
        if (aQW != null) {
            return aQW.goodIdcThresholdMs;
        }
        return 200;
    }

    public static int FT() {
        return c.aPe.getValue().intValue();
    }

    public static double FU() {
        return c.aOM.getValue().floatValue();
    }

    public static boolean FV() {
        return c.aPz.getValue().booleanValue();
    }

    public static boolean FZ() {
        return c.aPP.getValue().booleanValue();
    }

    public static int Fr() {
        return c.aNa.getValue().intValue();
    }

    public static boolean Fs() {
        return false;
    }

    public static boolean Ft() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return c.aNf.getValue().intValue() == 1;
    }

    @Deprecated
    public static int Ga() {
        return c.aNx.getValue().intValue();
    }

    public static boolean Gb() {
        return c.aPT.Lh();
    }

    public static boolean Gi() {
        return c.aQm.getValue().booleanValue();
    }

    public static int Gj() {
        return c.aQn.getValue().intValue();
    }

    public static boolean Gk() {
        int iIntValue = c.aQo.getValue().intValue();
        return iIntValue == 2 || iIntValue == 3;
    }

    public static int Gl() {
        return c.aQH.getValue().intValue();
    }

    public static int Gm() {
        return c.aQJ.getValue().intValue();
    }

    public static boolean Gv() {
        return c.aQe.Lh();
    }

    public static boolean JA() {
        return c.aNg.getValue().intValue() == 1;
    }

    public static int JB() {
        return c.aNh.getValue().intValue();
    }

    public static boolean JC() {
        return c.aNi.getValue().intValue() == 1;
    }

    public static int JD() {
        return c.aNj.getValue().intValue();
    }

    public static int JE() {
        return c.aNT.getValue().intValue();
    }

    public static int JF() {
        return c.aNU.getValue().intValue();
    }

    public static int JG() {
        return c.aNV.getValue().intValue();
    }

    public static long JH() {
        return ((long) c.aNW.getValue().intValue()) * 60000;
    }

    public static boolean JI() {
        return c.aOf.getValue().intValue() == 1;
    }

    public static boolean JJ() {
        return c.aOg.getValue().intValue() == 1;
    }

    public static int JK() {
        return c.aOn.getValue().intValue();
    }

    public static boolean JL() {
        return c.aOo.getValue().booleanValue();
    }

    public static boolean JM() {
        return com.kwad.sdk.core.h.a.Oy();
    }

    public static boolean JN() {
        return a(c.aOu);
    }

    public static boolean JO() {
        return !c.aOv.getValue().booleanValue();
    }

    public static boolean JP() {
        return a(c.aOt);
    }

    public static boolean JQ() {
        return c.aOx.getValue().intValue() == 1;
    }

    public static int JR() {
        return c.aOy.getValue().intValue();
    }

    @NonNull
    public static SdkConfigData JS() {
        if (aQW != null) {
            return aQW;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "getSdkConfigData is ui thread");
            aQW = JT();
        } else {
            synchronized (mLock) {
                if (aQW == null) {
                    return JT();
                }
            }
        }
        return aQW;
    }

    private static SdkConfigData JT() {
        aQW = new SdkConfigData();
        String strDw = ai.dw(ServiceProvider.Ud());
        if (TextUtils.isEmpty(strDw)) {
            com.kwad.sdk.core.d.c.d("SdkConfigManager", "configCache is empty");
        } else {
            try {
                aQW.parseJson(new JSONObject(strDw));
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        return aQW;
    }

    public static boolean JU() {
        return c.aNu.getValue().intValue() == 1;
    }

    public static boolean JV() {
        return c.aNv.getValue().intValue() == 1;
    }

    public static boolean JW() {
        return c.aNy.getValue().booleanValue();
    }

    public static boolean JX() {
        return c.aPa.getValue().intValue() == 1;
    }

    public static int JY() {
        return c.aNw.getValue().intValue();
    }

    public static int JZ() {
        return c.aOG.getValue().intValue();
    }

    public static boolean Jj() {
        return c.aNk.getValue().intValue() == 1;
    }

    public static int Jk() {
        return c.aNl.getValue().intValue();
    }

    public static int Jl() {
        return c.aNm.getValue().intValue();
    }

    public static boolean Jm() {
        return c.aNo.getValue().intValue() > 0;
    }

    public static boolean Jn() {
        return c.aNm.getValue().intValue() == 2;
    }

    public static int Jo() {
        return c.aNn.getValue().intValue();
    }

    public static boolean Jp() {
        return c.aNs.getValue().intValue() > 0;
    }

    public static boolean Jq() {
        return c.aNt.getValue().intValue() == 1;
    }

    public static int Jr() {
        return c.aNs.getValue().intValue();
    }

    @ForInvoker(methodId = "initConfigList")
    private static void Js() {
        com.kwad.components.ad.e.a.init();
        com.kwad.components.ad.feed.a.a.init();
        com.kwad.components.ad.fullscreen.a.a.init();
        com.kwad.components.ad.interstitial.b.a.init();
        com.kwad.components.ad.reward.a.a.init();
        com.kwad.components.ad.splashscreen.b.a.init();
    }

    public static List<String> Jt() {
        return c.aNK.getValue();
    }

    public static boolean Ju() {
        return true;
    }

    @NonNull
    public static List<String> Jv() {
        return c.aNJ.getValue();
    }

    public static int Jw() {
        return c.aPl.getValue().intValue();
    }

    public static int Jx() {
        return c.aPm.getValue().intValue();
    }

    public static String Jy() {
        return c.aNE.getValue();
    }

    public static String Jz() {
        return c.aNF.getValue();
    }

    public static int KA() {
        return c.aPC.getValue().intValue();
    }

    public static boolean KB() {
        return c.aQb.Lh();
    }

    public static boolean KC() {
        return c.aQd.Lh();
    }

    public static boolean KD() {
        return c.aQi.getValue().booleanValue();
    }

    public static int KE() {
        return c.aQk.getValue().intValue();
    }

    public static int KF() {
        return c.aQj.getValue().intValue();
    }

    public static long KG() {
        return c.aNq.getValue().longValue();
    }

    public static long KH() {
        return c.aNr.getValue().longValue();
    }

    public static boolean KI() {
        return c.aMY.getValue().booleanValue();
    }

    public static Long KJ() {
        return c.aMZ.getValue();
    }

    public static boolean KK() {
        int iIntValue = c.aQo.getValue().intValue();
        return iIntValue == 1 || iIntValue == 3;
    }

    public static long KL() {
        return c.aQp.getValue().longValue();
    }

    public static String KM() {
        return c.aQs.getValue();
    }

    public static String KN() {
        return c.aQD.getValue();
    }

    public static String KO() {
        return c.aQE.getValue();
    }

    public static boolean KP() {
        return c.aQF.Lh();
    }

    public static String KQ() {
        return c.aQI.getValue();
    }

    public static String KR() {
        return c.aQx.getValue();
    }

    public static String KS() {
        return c.aQy.getValue();
    }

    public static boolean KT() {
        return c.aQw.getValue().booleanValue();
    }

    public static String KU() {
        return c.aQz.getValue();
    }

    public static int KV() {
        return c.aQK.getValue().intValue();
    }

    public static String KW() {
        return c.aQL.getValue();
    }

    public static String KX() {
        return c.aQM.getValue();
    }

    public static List<String> KY() {
        return c.aQN.getValue();
    }

    public static String KZ() {
        return c.aQO.getValue();
    }

    public static int Ka() {
        return c.aOF.getValue().intValue();
    }

    public static boolean Kb() {
        return c.aOH.getValue().intValue() == 1;
    }

    public static boolean Kc() {
        return c.aOI.getValue().booleanValue();
    }

    public static float Kd() {
        float fFloatValue = c.aOJ.getValue().floatValue();
        if (fFloatValue <= 0.0f || fFloatValue > 1.0f) {
            return 0.3f;
        }
        return fFloatValue;
    }

    public static float Ke() {
        return c.aOL.getValue().floatValue();
    }

    public static float Kf() {
        return c.aOK.getValue().floatValue();
    }

    public static boolean Kg() {
        return c.aON.getValue().booleanValue();
    }

    public static boolean Kh() {
        return c.aOR.getValue().booleanValue();
    }

    public static boolean Ki() {
        return c.aOS.getValue().intValue() > 0;
    }

    public static boolean Kj() {
        return c.aOZ.getValue().intValue() == 1;
    }

    public static long Kk() {
        return c.aOX.getValue().longValue();
    }

    public static boolean Kl() {
        return c.aPd.Lh();
    }

    public static com.kwad.sdk.core.network.idc.a.b Km() {
        return c.aPf.getValue();
    }

    public static int Kn() {
        return c.aPg.getValue().intValue();
    }

    public static long Ko() {
        return c.aPh.getValue().longValue();
    }

    public static int Kp() {
        return c.aPi.getValue().intValue();
    }

    public static boolean Kq() {
        return c.aPj.getValue().floatValue() == 1.0f;
    }

    public static boolean Kr() {
        return c.aPk.Lh();
    }

    public static boolean Ks() {
        return c.aPn.Lh();
    }

    public static String Kt() {
        return c.aPo.getValue();
    }

    public static String Ku() {
        return c.aPp.getValue();
    }

    public static String Kv() {
        return c.aPq.getValue();
    }

    public static boolean Kw() {
        return c.aPs.getValue().booleanValue();
    }

    public static int Kx() {
        return c.aPt.getValue().intValue();
    }

    public static int Ky() {
        return c.aPv.getValue().intValue();
    }

    public static boolean Kz() {
        return c.aPB.getValue().booleanValue();
    }

    public static boolean La() {
        return c.aQP.getValue().booleanValue();
    }

    public static Set<String> Lb() {
        HashSet hashSet = new HashSet();
        hashSet.add("android.widget.View");
        hashSet.add("android.webkit.View");
        hashSet.add("android.app.View");
        return hashSet;
    }

    public static String R(String str, String str2) {
        if (br.isNullString(str)) {
            return str2;
        }
        JSONObject abConfig = JS().getAbConfig();
        if (abConfig != null && abConfig.has(str)) {
            return abConfig.optString(str);
        }
        JSONObject appConfig = JS().getAppConfig();
        if (appConfig != null && appConfig.has(str)) {
            return appConfig.optString(str);
        }
        JSONObject adxConfig = JS().getAdxConfig();
        return (adxConfig == null || !adxConfig.has(str)) ? str2 : adxConfig.optString(str);
    }

    public static JSONObject a(f fVar) {
        JSONObject jSONObject = (JSONObject) b(fVar);
        return jSONObject != null ? jSONObject : fVar.Lc();
    }

    public static boolean ao(long j) {
        return (j & c.aNz.getValue().longValue()) != 0;
    }

    public static <T> T b(@NonNull com.kwad.sdk.core.config.item.b<T> bVar) {
        if (!isLoaded()) {
            final Context contextUd = ServiceProvider.Ud();
            b.a(contextUd, bVar);
            i.execute(new bi() { // from class: com.kwad.sdk.core.config.e.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    e.bN(contextUd);
                }
            });
        }
        T value = bVar.getValue();
        return value != null ? value : bVar.Lc();
    }

    @WorkerThread
    public static synchronized void bN(Context context) {
        AtomicBoolean atomicBoolean = aQV;
        if (atomicBoolean.get()) {
            return;
        }
        com.kwad.sdk.core.d.c.d("SdkConfigManager", "loadCache");
        c.init();
        Js();
        b.bM(context);
        JS();
        atomicBoolean.set(true);
    }

    public static int cQ(String str) {
        return c.aQh.ek(str);
    }

    public static int cR(String str) {
        Integer value = c.aNQ.getValue(str);
        if (value != null) {
            return value.intValue();
        }
        return 0;
    }

    public static boolean enableInflaterOptimize() {
        return c.aQQ.getValue().booleanValue();
    }

    public static boolean f(String str, boolean z) {
        if (br.isNullString(str)) {
            return z;
        }
        JSONObject abConfig = JS().getAbConfig();
        if (abConfig != null && abConfig.has(str)) {
            return abConfig.optBoolean(str);
        }
        JSONObject appConfig = JS().getAppConfig();
        if (appConfig != null && appConfig.has(str)) {
            return appConfig.optBoolean(str);
        }
        JSONObject adxConfig = JS().getAdxConfig();
        return (adxConfig == null || !adxConfig.has(str)) ? z : adxConfig.optBoolean(str);
    }

    public static String getLogObiwanData() {
        return c.aOW.getValue();
    }

    public static int getTKErrorDetailCount() {
        return c.aQc.getValue().intValue();
    }

    @NonNull
    public static List<String> getTKPreloadMemCacheTemplates() {
        return c.aPY.getValue();
    }

    public static String getUserAgent() {
        return c.aOD.getValue();
    }

    public static boolean hO() {
        return c.aOQ.getValue().booleanValue();
    }

    public static boolean isLoaded() {
        return aQV.get();
    }

    public static JSONObject a(com.kwad.sdk.core.config.item.e eVar) {
        JSONObject jSONObject = (JSONObject) b(eVar);
        return jSONObject != null ? jSONObject : eVar.Lc();
    }

    public static int a(l lVar) {
        Integer numLc = (Integer) b((com.kwad.sdk.core.config.item.b) lVar);
        if (numLc == null) {
            numLc = lVar.Lc();
        }
        return numLc.intValue();
    }

    public static boolean b(l lVar) {
        Integer num = (Integer) b((com.kwad.sdk.core.config.item.b) lVar);
        if (num != null) {
            return num.intValue() > 0;
        }
        return lVar.Lc().intValue() > 0;
    }

    public static long a(p pVar) {
        Long lLc = (Long) b(pVar);
        if (lLc == null) {
            lLc = pVar.Lc();
        }
        return lLc.longValue();
    }

    public static double a(g gVar) {
        Double dLc = (Double) b(gVar);
        if (dLc == null) {
            dLc = gVar.Lc();
        }
        return dLc.doubleValue();
    }

    public static void f(@NonNull SdkConfigData sdkConfigData) {
        synchronized (mLock) {
            aQW = sdkConfigData;
        }
    }

    public static boolean a(com.kwad.sdk.core.config.item.d dVar) {
        Boolean boolLc = (Boolean) b(dVar);
        if (boolLc == null) {
            boolLc = dVar.Lc();
        }
        return boolLc.booleanValue();
    }

    public static String a(s sVar) {
        String str = (String) b(sVar);
        return str != null ? str : sVar.Lc();
    }
}
