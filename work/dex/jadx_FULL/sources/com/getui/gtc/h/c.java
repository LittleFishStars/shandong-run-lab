package com.getui.gtc.h;

import android.os.Build;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.http.MediaType;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.RequestBody;
import com.getui.gtc.base.http.crypt.PtRASCryptoInterceptor;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.dim.DimRequest;
import com.getui.gtc.server.ServerManager;
import com.kc.openset.constant.DeviceIdType;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    public interface a {
        void a(String str);
    }

    public static String a(String str) throws Exception {
        while (true) {
            String server = ServerManager.getServer("gtc.as");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("version", "1.0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject.put("data", jSONObject2);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject2.put("gtcid", str);
                }
                com.getui.gtc.i.d.b unused = com.getui.gtc.i.d.b.C0659b.f30388a;
                DimRequest.Builder builderKey = new DimRequest.Builder().key("dim-2-1-5-1");
                Caller caller = Caller.UNKNOWN;
                String str2 = (String) DimManager.getInstance().get(builderKey.caller(caller).useExpiredCacheForReserve(true).build());
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject2.put(DeviceIdType.OAID, str2);
                }
                if ("HONOR".equalsIgnoreCase(Build.MANUFACTURER)) {
                    com.getui.gtc.i.d.b unused2 = com.getui.gtc.i.d.b.C0659b.f30388a;
                    String str3 = (String) DimManager.getInstance().get(new DimRequest.Builder().key("dim-2-1-5-2").caller(caller).build());
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject2.put("oaid2", str3);
                    }
                }
                jSONObject2.put("gtAppid", com.getui.gtc.c.b.f30289a);
                jSONObject2.put("pkgName", GtcProvider.context().getPackageName());
                jSONObject2.put("os", "android");
                com.getui.gtc.i.d.b unused3 = com.getui.gtc.i.d.b.C0659b.f30388a;
                String str4 = (String) DimManager.getInstance().get(new DimRequest.Builder().key("dim-2-1-8-1").caller(caller).useExpiredCacheForReserve(true).build());
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject2.put("androidAid", str4);
                }
                com.getui.gtc.i.d.b unused4 = com.getui.gtc.i.d.b.C0659b.f30388a;
                String str5 = (String) DimManager.getInstance().get(new DimRequest.Builder().key("dim-2-1-10-1").caller(caller).useExpiredCacheForReserve(true).build());
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject2.put("phoneModel", str5);
                }
                JSONObject jSONObject3 = new JSONObject(d.f30374a.newCall(new Request.Builder().url(String.format("%s/cidserver/getcid", server)).method("POST").body(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).cryptInterceptor(new PtRASCryptoInterceptor(com.getui.gtc.c.b.i, com.getui.gtc.c.b.h)).tag("register gtcid").build()).execute().body().string());
                int i = jSONObject3.getInt("errno");
                String string = jSONObject3.getString("errmsg");
                if (i == 0) {
                    return jSONObject3.getJSONObject("data").getString("gtcid");
                }
                throw new Exception(string);
            } catch (Throwable th) {
                if (!(th instanceof IOException) || !ServerManager.switchServer("gtc.as", server)) {
                    throw th;
                }
                com.getui.gtc.i.c.a.c("register gtcId failed with server: " + server + ", try again with: " + ServerManager.getServer("gtc.as"));
            }
        }
        throw th;
    }

    public static void a(final String str, final a aVar) {
        ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.h.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String strA = c.a(str);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(strA);
                    }
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.c("register gtcId failed: " + th.getMessage());
                }
            }
        });
    }
}
