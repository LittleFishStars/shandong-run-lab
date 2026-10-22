package com.kwad.sdk.liteapi.report;

import android.os.Build;
import com.kc.openset.constant.DeviceIdType;
import com.kwad.sdk.liteapi.LiteApiLogger;
import com.kwad.sdk.liteapi.LiteOAIDHelper;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
final class b {
    public String Np;
    public String Nq;
    public String Nr;
    public String aRa;
    public String aWZ;
    public int aqw;
    public int aqy;
    public String aqz;

    public static b RI() {
        b bVar = new b();
        try {
            bVar.aRa = LiteOAIDHelper.obtainCurrent();
            bVar.aqy = Build.VERSION.SDK_INT;
            bVar.Nr = Build.VERSION.RELEASE;
            bVar.aqw = 1;
            bVar.aqz = Locale.getDefault().getLanguage();
            bVar.aWZ = Build.MANUFACTURER;
            bVar.Np = Build.MODEL;
            bVar.Nq = Build.BRAND;
        } catch (Throwable unused) {
        }
        return bVar;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DeviceIdType.OAID, this.aRa);
        } catch (JSONException e) {
            LiteApiLogger.printStackTrace(e);
        }
        return jSONObject;
    }
}
