package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class cf {
    private static boolean brE = false;
    private static final List<a> brF = new CopyOnWriteArrayList();

    public static class a implements com.kwad.sdk.core.b {
        public String brG;
        public String brH;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.level = jSONObject.optInt(com.alibaba.ariver.permission.b.b, 0);
                this.brG = jSONObject.optString("ssid", "");
                this.brH = jSONObject.optString("bssid", "");
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, com.alibaba.ariver.permission.b.b, this.level);
            ac.putValue(jSONObject, "ssid", this.brG);
            ac.putValue(jSONObject, "bssid", this.brH);
            return jSONObject;
        }
    }

    public static boolean eG(Context context) {
        if (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) {
            return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1;
        }
        return ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }

    public static List<a> o(Context context, int i) {
        if (be.useNetworkStateDisable()) {
            return new ArrayList();
        }
        if (!brE && ServiceProvider.getSDKConfig().canReadNearbyWifiList()) {
            List<a> list = brF;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(32L)) {
                    return list;
                }
                try {
                    if (eG(context)) {
                        return list;
                    }
                    List<a> listP = com.kwad.sdk.utils.c.d.p(context, i);
                    if (listP != null) {
                        list.addAll(listP);
                    }
                } catch (Exception e) {
                    brE = true;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
                return brF;
            }
        }
        return brF;
    }
}
