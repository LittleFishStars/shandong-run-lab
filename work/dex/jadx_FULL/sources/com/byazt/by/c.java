package com.byazt.by;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.gr;
import com.byazt.aas.gu;
import com.byazt.aas.i;
import com.byazt.aas.my;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.yv;
import com.byazt.aas.zm;
import com.byazt.bwm.sp;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 20})
public class c {
    public static long c = -1;
    public static boolean tt = false;
    public static volatile String uj;
    public static AtomicBoolean ve = new AtomicBoolean(false);

    public static boolean tt() {
        if (tt) {
            return true;
        }
        if (c == -1) {
            return false;
        }
        boolean z = SystemClock.elapsedRealtime() - c > 60000;
        tt = z;
        return z;
    }

    public static String ve() {
        if (!TextUtils.isEmpty(uj)) {
            return uj;
        }
        String strC = uj.c().c((String) null);
        uj = strC;
        return strC;
    }

    public static void c() {
        if (c > -1) {
            return;
        }
        c = SystemClock.elapsedRealtime();
    }

    public static JSONObject c(Context context, int i) {
        return tt(context, i);
    }

    private static void c(int i, Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("type", Integer.valueOf(i));
            yp.c().c("b_ad_req", jSONObject, th);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:157:0x038a A[Catch: all -> 0x03dd, TryCatch #1 {all -> 0x03dd, blocks: (B:3:0x0009, B:5:0x0026, B:10:0x0030, B:14:0x0039, B:17:0x0045, B:19:0x004f, B:22:0x0056, B:29:0x0073, B:31:0x007d, B:34:0x0084, B:39:0x0095, B:42:0x00a2, B:44:0x00ac, B:47:0x00b3, B:52:0x00c8, B:55:0x00d4, B:59:0x00eb, B:61:0x00f5, B:64:0x00fc, B:69:0x0115, B:72:0x01b2, B:74:0x01bc, B:77:0x01c3, B:82:0x01dc, B:86:0x022f, B:88:0x02a3, B:91:0x02b0, B:93:0x02ba, B:96:0x02c1, B:104:0x02d7, B:106:0x02e1, B:109:0x02e8, B:117:0x02fe, B:119:0x0308, B:122:0x030f, B:130:0x0325, B:132:0x032f, B:136:0x0337, B:144:0x034d, B:146:0x0357, B:151:0x0368, B:154:0x0378, B:156:0x0386, B:158:0x0391, B:160:0x03a4, B:161:0x03a9, B:163:0x03b8, B:164:0x03bd, B:168:0x03d9, B:167:0x03d6, B:157:0x038a, B:147:0x035b, B:150:0x0365, B:137:0x033b, B:141:0x0346, B:123:0x0313, B:127:0x031e, B:110:0x02ec, B:114:0x02f7, B:97:0x02c5, B:101:0x02d0, B:78:0x01c7, B:81:0x01d9, B:65:0x0100, B:68:0x0112, B:56:0x00dc, B:48:0x00b7, B:51:0x00c5, B:35:0x0088, B:38:0x0092, B:23:0x005a, B:26:0x006c), top: B:175:0x0009, inners: #0 }] */
    public static JSONObject tt(Context context, int i) {
        String strT;
        String strSl;
        String strDa;
        String strI;
        String strX;
        String strYp;
        String strSp;
        String strA;
        String strN;
        String strI2;
        JSONObject jSONObject = new JSONObject();
        try {
            u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
            com.byazt.dna.ve veVar = (com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog");
            com.byazt.xgx.c cVar = new com.byazt.xgx.c();
            int i2 = 0;
            boolean z = (cVar.tt() && cVar.ve()) ? false : true;
            boolean z2 = !tt();
            uj.tt ttVar = new uj.tt();
            String str = null;
            if (z2 && (strI2 = uj.c().i(null)) != null) {
                if (TextUtils.isEmpty(strI2)) {
                    strI2 = null;
                }
                jSONObject.put(DeviceIdType.IMEI, strI2);
            } else {
                String strC = DeviceUtils.c(Boolean.valueOf(cVar.c()));
                jSONObject.put(DeviceIdType.IMEI, strC);
                if (strC == null) {
                    strC = "";
                }
                ttVar.c(strC);
            }
            if (z2 && (strN = uj.c().n()) != null) {
                if (TextUtils.isEmpty(strN)) {
                    strN = null;
                }
                jSONObject.put("android_id", strN);
            } else {
                String strTt = DeviceUtils.tt();
                jSONObject.put("android_id", strTt);
                if (strTt == null) {
                    strTt = "";
                }
                ttVar.tt(strTt);
            }
            jSONObject.put("uuid", ve());
            if (z2 && (strA = uj.c().a()) != null) {
                if (TextUtils.isEmpty(strA)) {
                    strA = null;
                }
                jSONObject.put("ssid", strA);
            } else {
                String ssid = uVar.getSSID(Boolean.valueOf(z));
                jSONObject.put("ssid", ssid);
                if (ssid == null) {
                    ssid = "";
                }
                ttVar.ve(ssid);
            }
            if (uj.c().sp(i)) {
                jSONObject.put("wifi_mac", uVar.getAsyncWifiMac());
            } else {
                jSONObject.put("wifi_mac", uVar.getWifiMac(Boolean.valueOf(z)));
            }
            if (z2 && (strSp = uj.c().sp()) != null) {
                if (TextUtils.isEmpty(strSp)) {
                    strSp = null;
                }
                jSONObject.put("imsi", strSp);
            } else {
                String imsi = uVar.getImsi(Boolean.valueOf(cVar.c()));
                jSONObject.put("imsi", imsi);
                if (imsi == null) {
                    imsi = "";
                }
                ttVar.uj(imsi);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() - SystemClock.elapsedRealtime());
            jSONObject.put("boot", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SystemClock.elapsedRealtime());
            jSONObject.put("power_on_time", sb2.toString());
            jSONObject.put("rom_version", uVar.getRomInfo());
            jSONObject.put("rom_new_version", zm.yp());
            jSONObject.put("sys_compiling_time", uVar.getCompilingTime());
            jSONObject.put("type", uVar.getDeviceType(z2));
            jSONObject.put("os", 1);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("vendor", Build.MANUFACTURER);
            jSONObject.put(ze1.k, uVar.getDeviceModel());
            jSONObject.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
            jSONObject.put("conn_type", DeviceUtils.uj());
            if (z2 && (strYp = uj.c().yp()) != null) {
                if (TextUtils.isEmpty(strYp)) {
                    strYp = null;
                }
                jSONObject.put("mac", strYp);
            } else {
                String macAddress = uVar.getMacAddress(Boolean.valueOf(cVar.tt()));
                jSONObject.put("mac", macAddress);
                if (macAddress == null) {
                    macAddress = "";
                }
                ttVar.n(macAddress);
            }
            int[] iArrVe = pf.ve(context);
            jSONObject.put("screen_width", iArrVe[0]);
            jSONObject.put("screen_height", iArrVe[1]);
            jSONObject.put(DeviceIdType.OAID, veVar.getOAID(z2));
            jSONObject.put("oaid_source", gu.c());
            jSONObject.put("free_space", i.c);
            jSONObject.put("locale_language", uVar.getLocalLanguage());
            jSONObject.put("screen_bright", Math.ceil(DeviceUtils.n() * 10.0f) / 10.0d);
            if (!DeviceUtils.c()) {
                i2 = 1;
            }
            jSONObject.put("is_screen_off", i2);
            jSONObject.put("cpu_num", nb.yp());
            jSONObject.put("cpu_max_freq", nb.z());
            jSONObject.put("cpu_min_freq", nb.m());
            jSONObject.put("battery_remaining_pct", (int) DeviceUtils.c.tt(context));
            jSONObject.put("is_charging", DeviceUtils.c.c(context));
            jSONObject.put("total_mem", nb.t());
            jSONObject.put("total_space", String.valueOf(nb.nu()));
            jSONObject.put("free_space_in", String.valueOf(nb.my()));
            jSONObject.put("sdcard_size", String.valueOf(nb.gt()));
            jSONObject.put("rooted", nb.qy());
            if (!uj.c().sp(i)) {
                jSONObject.put("enable_assisted_clicking", DeviceUtils.a());
            }
            if (z2 && (strX = uj.c().x()) != null) {
                if (TextUtils.isEmpty(strX)) {
                    strX = null;
                }
                jSONObject.put("mnc", strX);
            } else {
                String mnc = uVar.getMnc();
                jSONObject.put("mnc", mnc);
                if (mnc == null) {
                    mnc = "";
                }
                ttVar.a(mnc);
            }
            if (z2 && (strI = uj.c().i()) != null) {
                if (TextUtils.isEmpty(strI)) {
                    strI = null;
                }
                jSONObject.put("mcc", strI);
            } else {
                String mcc = uVar.getMcc();
                jSONObject.put("mcc", mcc);
                if (mcc == null) {
                    mcc = "";
                }
                ttVar.sp(mcc);
            }
            if (z2 && (strDa = uj.c().da()) != null) {
                if (TextUtils.isEmpty(strDa)) {
                    strDa = null;
                }
                jSONObject.put("mnc_2", strDa);
            } else {
                String mnc2 = uVar.getMnc2();
                jSONObject.put("mnc_2", mnc2);
                if (mnc2 == null) {
                    mnc2 = "";
                }
                ttVar.x(mnc2);
            }
            if (z2 && (strSl = uj.c().sl()) != null) {
                if (!TextUtils.isEmpty(strSl)) {
                    str = strSl;
                }
                jSONObject.put("mcc_2", str);
            } else {
                String mcc2 = uVar.getMcc2();
                jSONObject.put("mcc_2", mcc2);
                if (mcc2 == null) {
                    mcc2 = "";
                }
                ttVar.i(mcc2);
            }
            if (z2 && (strT = uj.c().t()) != null) {
                jSONObject.put("download_channel", strT);
            } else {
                String strI3 = com.byazt.fh.c.i();
                jSONObject.put("download_channel", strI3);
                ttVar.da(strI3 != null ? strI3 : "");
            }
            ttVar.c();
            jSONObject.put("is_app_log_con", com.byazt.ml.c.c());
            if (z2) {
                String strU = uj.c().u();
                if (!TextUtils.isEmpty(strU)) {
                    jSONObject.put("applog_did", strU);
                } else {
                    jSONObject.put("applog_did", veVar.getDid());
                }
            } else {
                jSONObject.put("applog_did", veVar.getDid());
            }
            jSONObject.put("sec_did", com.byazt.lkt.c.tt());
            long jI = DeviceUtils.i();
            if (jI != -1) {
                jSONObject.put("client_global_did", jI);
            }
            jSONObject.put("sys_vol", DeviceUtils.da());
            String strDa2 = gr.da();
            if (strDa2 != null) {
                jSONObject.put("ud", strDa2);
            }
            try {
                jSONObject.put("device_score", Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", com.byazt.vxy.c.uj())));
            } catch (NumberFormatException unused) {
                jSONObject.put("device_score", -1);
            }
            DeviceUtils.c(jSONObject);
        } catch (Throwable th) {
            m.c(th);
            c(i, th);
        }
        return jSONObject;
    }

    public static void c(JSONObject jSONObject, int i) throws JSONException {
        if (!ve.c().c(i)) {
            tt(jSONObject);
            return;
        }
        JSONArray jSONArrayZ = uj.c().z();
        if (jSONArrayZ != null) {
            if (jSONArrayZ.length() > 0) {
                jSONObject.put("scheme_success_list", jSONArrayZ);
            }
            if (ve.get()) {
                return;
            }
            ve.set(true);
            com.byazt.bwm.n.tt(new sp("tt-scheme") { // from class: com.byazt.by.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.tt(null);
                    } catch (Exception unused) {
                    }
                    c.ve.set(false);
                }
            });
            return;
        }
        tt(jSONObject);
    }

    public static String[] c(int i) {
        try {
            return ((u) com.byazt.ut.uj.getService("device_info_new")).getNewIpAddrs(!tt());
        } catch (Exception unused) {
            return new String[]{"", ""};
        }
    }

    public static String c(String str, int i) {
        return my.tt(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(JSONObject jSONObject) throws JSONException {
        Set<String> setO = gt.tt().o();
        if (setO == null || setO.size() <= 0) {
            return;
        }
        Map<String, Boolean> mapC = yv.c(259200000L);
        final JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (Map.Entry<String, Boolean> entry : mapC.entrySet()) {
            String key = entry.getKey();
            if (setO.contains(key)) {
                String scheme = Uri.parse(key).getScheme();
                if (entry.getValue().booleanValue()) {
                    jSONArray.put(scheme);
                } else {
                    jSONArray2.put(scheme);
                }
            }
        }
        if (jSONObject != null && jSONArray.length() > 0) {
            jSONObject.put("scheme_success_list", jSONArray);
        }
        if (jSONObject != null && jSONArray2.length() > 0) {
            jSONObject.put("scheme_fail_list", jSONArray2);
        }
        if (jSONObject == null) {
            uj.c().c(jSONArray);
        } else {
            com.byazt.bwm.n.tt(new sp("tt-scheme-save") { // from class: com.byazt.by.c.2
                @Override // java.lang.Runnable
                public void run() {
                    uj.c().c(jSONArray);
                }
            });
        }
    }
}
