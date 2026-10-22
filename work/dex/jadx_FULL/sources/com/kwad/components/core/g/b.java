package com.kwad.components.core.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.k.a.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.sdk.commercial.c.a {
    public int Sb;
    public boolean Sc;
    public boolean Sd;
    public boolean Sf;
    public String Sg;
    public boolean Sh;
    public long Sj;
    public double Sk;
    public boolean Sl;
    public List<String> Sm;
    public double Sn;
    public int So;
    public int Sp;
    public int Sq;
    public int Sr;
    public int defaultType;
    public int Se = -1;
    public int Si = -1;
    private boolean Ss = false;
    private boolean St = false;
    private boolean Su = false;
    private Context mContext = ServiceProvider.Ud();

    private b() {
    }

    private static void a(b bVar) {
        try {
            String strKO = e.KO();
            if (TextUtils.isEmpty(strKO)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strKO);
            if (jSONObject.optBoolean("enableSlidingTrajectory", false)) {
                Pair<List<String>, Double> pairIJ = com.kwad.sdk.core.e.IJ();
                bVar.Sm = (List) pairIJ.first;
                bVar.Sn = ((Double) pairIJ.second).doubleValue();
                bVar.Ss = true;
            }
            if (jSONObject.optBoolean("enableAccessibility", false)) {
                bVar.Sc = ((Boolean) bt.eF(bVar.mContext).first).booleanValue();
                bVar.Sd = ((Boolean) bt.eF(bVar.mContext).second).booleanValue();
                bVar.St = true;
            }
            if (jSONObject.optBoolean("enableKeyguardSecure", false)) {
                bVar.Sl = ar(bVar.mContext);
                bVar.Su = true;
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
    }

    private static String ap(Context context) {
        int iE = aq.e(context, bf.dT(context), be.useNetworkStateDisable());
        if (iE == 1) {
            return "CMCC";
        }
        if (iE != 2) {
            return iE != 3 ? "unknown" : "CUCC";
        }
        return "CTCC";
    }

    private static int aq(Context context) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    private static boolean ar(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (keyguardManager != null) {
                return keyguardManager.isKeyguardSecure();
            }
            return false;
        } catch (Throwable th) {
            c.printStackTrace(th);
            return false;
        }
    }

    private static int as(@NonNull Context context) {
        if (e.ao(512L)) {
            return -1;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, intentFilter);
            if (intentRegisterReceiver == null) {
                return -1;
            }
            int intExtra = intentRegisterReceiver.getIntExtra("plugged", -1);
            int i = 2;
            if (intExtra != 2) {
                i = 1;
                if (intExtra != 1) {
                    i = 4;
                    if (intExtra != 4) {
                        return intExtra == 0 ? 0 : -1;
                    }
                }
            }
            return i;
        } catch (Exception e) {
            c.printStackTrace(e);
            return -1;
        }
    }

    private static JSONObject b(b bVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            ac.putValue(jSONObject, "c_batterylevel", bVar.Sb);
            ac.putValue(jSONObject, "c_charging", bVar.Se);
            ac.putValue(jSONObject, "is_cheat_user", bVar.Sf);
            ac.putValue(jSONObject, "c_operator", bVar.Sg);
            ac.putValue(jSONObject, "t_root", bVar.Sh);
            ac.putValue(jSONObject, "c_screenlight", bVar.Si);
            ac.putValue(jSONObject, "c_total_memory", bVar.Sj);
            ac.putValue(jSONObject, "c_volume", bVar.Sk);
            ac.putValue(jSONObject, "c_screen_height", bVar.Sp);
            ac.putValue(jSONObject, "c_screen_width", bVar.Sq);
            ac.putValue(jSONObject, "density_dpi", bVar.Sr);
            ac.putValue(jSONObject, "default_type", bVar.defaultType);
            if (bVar.Ss) {
                if (!bVar.Sm.isEmpty()) {
                    ac.putValue(jSONObject, "s_origin_points", bVar.Sm);
                }
                double d = bVar.Sn;
                if (d != AudioStats.AUDIO_AMPLITUDE_NONE) {
                    ac.putValue(jSONObject, "s_swipe_max_curvature", d);
                }
            }
            if (bVar.St) {
                ac.putValue(jSONObject, "t_accessibility_enabled", bVar.Sc);
                ac.putValue(jSONObject, "t_accessibility_service_existed", bVar.Sd);
            }
            if (bVar.Su) {
                ac.putValue(jSONObject, "t_is_keyguard_secure", bVar.Sl);
            }
        } catch (Throwable th) {
            c.printStackTrace(th);
        }
        return jSONObject;
    }

    private static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static b qV() {
        b bVar = new b();
        bVar.Sb = bt.es(bVar.mContext);
        bVar.Sg = ap(bVar.mContext);
        bVar.Se = as(bVar.mContext);
        bVar.Sh = qW();
        bVar.Si = SystemUtil.er(bVar.mContext);
        bVar.Sj = bt.et(bVar.mContext);
        bVar.Sk = SystemUtil.eq(bVar.mContext);
        bVar.Sr = aq(bVar.mContext);
        bVar.Sp = getScreenHeight(bVar.mContext);
        bVar.Sq = getScreenWidth(bVar.mContext);
        a(bVar);
        bVar.defaultType = 1;
        return bVar;
    }

    private static boolean qW() {
        d dVarUE = s.UE();
        return dVarUE != null && dVarUE.bmw == 1;
    }

    public final b aI(boolean z) {
        this.Sf = z;
        return this;
    }

    public final b aU(int i) {
        this.So = i;
        return this;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this);
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                bVar.Sb = jSONObject.optInt("c_batterylevel");
                bVar.Sc = jSONObject.optBoolean("t_accessibility_enabled");
                bVar.Sd = jSONObject.optBoolean("t_accessibility_service_existed");
                bVar.Se = jSONObject.optInt("c_charging");
                bVar.Sf = jSONObject.optBoolean("is_cheat_user");
                bVar.Sg = jSONObject.optString("c_operator");
                bVar.Sh = jSONObject.optBoolean("t_root");
                bVar.Si = jSONObject.optInt("c_screenlight");
                bVar.Sj = jSONObject.optLong("c_total_memory");
                bVar.Sk = jSONObject.optDouble("c_volume");
                bVar.Sl = jSONObject.optBoolean("t_is_keyguard_secure");
                bVar.Sm = ac.h(jSONObject.optJSONArray("s_origin_points"));
                bVar.Sn = jSONObject.optDouble("s_swipe_max_curvature");
                bVar.Sr = jSONObject.optInt("density_dpi");
                bVar.Sp = jSONObject.optInt("c_screen_height");
                bVar.Sq = jSONObject.optInt("c_screen_width");
                bVar.defaultType = jSONObject.optInt("default_type");
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
    }
}
