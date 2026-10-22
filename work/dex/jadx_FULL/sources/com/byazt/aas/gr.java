package com.byazt.aas;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.mobile.jsengine.NativeLibs;
import com.alipay.sdk.m.y.l;
import com.byazt.ete.yf;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.coremedia.iso.boxes.TimeToSampleBox;
import com.zj.adlib.ze1;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr {
    public static int c = 0;
    public static volatile com.byazt.dna.n.c n = null;
    public static int tt = 1;
    public static int uj = 300;
    public static int ve = 2;

    @com.byazt.zqa.c(c = {0, 1, 131, 1489})
    public static class c implements com.byazt.dna.n.tt {
        @Override // com.byazt.dna.n.tt
        public long getArmorFlags() {
            return ve.ve();
        }

        @Override // com.byazt.dna.n.tt
        public void reportSoftDecData(String str, JSONObject jSONObject) {
            if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            gr.c(jSONObject.toString(), str);
        }

        @Override // com.byazt.dna.n.tt
        public void setCryptInitStatus(long j, boolean z) {
            com.byazt.ukr.yp.c().c(10001, j, Boolean.valueOf(z), (String) null);
        }
    }

    public static String a() {
        try {
            return tt().getSoftChara();
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return c(th);
        }
    }

    public static void c() {
        da();
        a();
        if (com.byazt.omf.gt.tt().hj()) {
            sp();
            n();
            i();
            t();
        }
    }

    public static String da() {
        yf yfVarSl = sl();
        com.byazt.la.c.c().c(yfVarSl);
        if (yfVarSl != null) {
            String string = yfVarSl.toString();
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return null;
    }

    public static void i() {
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.gr.3
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                com.byazt.dna.n nVarTt = gr.tt();
                jSONObject.put("board", Build.BOARD + "#" + nVarTt.pglArmorCallApi2getProperty("ro.product.board", "unknown"));
                jSONObject.put(ze1.k, Build.MODEL + "#" + nVarTt.pglArmorCallApi2getProperty("ro.product.model", "unknown"));
                jSONObject.put("os_version", Build.VERSION.RELEASE + "#" + nVarTt.pglArmorCallApi2getProperty("ro.build.version.release", "unknown"));
                jSONObject.put("vendor", Build.MANUFACTURER + "#" + nVarTt.pglArmorCallApi2getProperty("ro.product.manufacturer", "unknown"));
                jSONObject.put("rom_version", Build.DISPLAY + "#" + nVarTt.pglArmorCallApi2getProperty("ro.build.display.id", "unknown"));
                jSONObject.put("compiling_time", Build.TIME + "#" + (Long.parseLong(nVarTt.pglArmorCallApi2getProperty("ro.build.date.utc", "-1")) * 1000));
                return com.byazt.qal.tt.tt().c("pangle_build_pick").tt(jSONObject.toString());
            }
        }, "pangle_build_pick");
    }

    public static void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArrayUj = uj();
            if (jSONArrayUj.length() > 0) {
                jSONObject.put("usb", jSONArrayUj);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                for (Class<? super Object> superclass = classLoader.getClass().getSuperclass(); superclass != null && !superclass.getName().equals("java.lang.Object"); superclass = superclass.getSuperclass()) {
                    if (superclass.getName().equals(NativeLibs.CLASS_DALVIK_SYSTEM_BASE_DEX_CLASS_LOADER)) {
                        c(classLoader, superclass, jSONObject2);
                        break;
                    }
                }
            }
            jSONObject.put(com.google.android.exoplayer2.source.rtsp.i.j, jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            c(jSONObject.toString(), "pangle_check");
        }
    }

    public static yf sl() {
        yf yfVarC;
        try {
            if (!com.byazt.omf.gt.tt().kn() || (yfVarC = com.byazt.sv.c.c(com.byazt.omf.gt.getContext()).c()) == null) {
                return null;
            }
            return yfVarC;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void sp() {
        String[] strArrEf = com.byazt.omf.gt.tt().ef();
        if (strArrEf == null || strArrEf.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrEf) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
    }

    public static void t() {
        Context context = com.byazt.omf.gt.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.xix.ve veVarC = com.byazt.xix.ve.c(context);
            try {
                jSONObject.put("access_perm", com.byazt.xgx.tt.c(context, "android.permission.ACCESS_NETWORK_STATE"));
                jSONObject.put("change_perm", com.byazt.xgx.tt.c(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getSimOperatorCode());
                jSONObject.put("network", veVarC.c());
                c(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static com.byazt.dna.n tt() {
        return (com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service");
    }

    public static String u() {
        com.byazt.dna.n nVarTt = tt();
        return nVarTt != null ? nVarTt.getArchEnv() : "";
    }

    public static JSONArray uj() {
        UsbAccessory[] accessoryList = ((UsbManager) com.byazt.omf.gt.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ze1.p, usbAccessory.getManufacturer());
                        jSONObject.put(ze1.k, usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put("uri", usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        com.byazt.nr.m.c(e);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void ve() {
        com.byazt.dna.n nVarTt = tt();
        if (nVarTt != null) {
            nVarTt.initPglArmorCallApi(new c());
        }
    }

    public static boolean x() {
        String strMy = com.byazt.omf.gt.tt().my();
        try {
            com.byazt.dna.n nVarTt = tt();
            if (nVarTt != null) {
                return nVarTt.detectHostLocalIp(strMy);
            }
            return false;
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            return false;
        }
    }

    public static void tt(JSONObject jSONObject) {
        com.byazt.whk.ve veVar;
        if (jSONObject == null || com.byazt.omf.gt.c(10003) == null || (veVar = (com.byazt.whk.ve) com.byazt.ut.uj.getService("pitaya")) == null || !veVar.isPitayaInitSuccess()) {
            return;
        }
        veVar.isPitayaEnvAvailable();
        veVar.runTask("antispam_handhold", jSONObject, new com.byazt.whk.x() { // from class: com.byazt.aas.gr.5
            @Override // com.byazt.whk.x
            public PluginValueSet c(int i, com.byazt.whk.i iVar) {
                com.byazt.yxi.tt ttVarVe = iVar.ve();
                if (ttVarVe == null) {
                    return null;
                }
                PluginValueSet pluginValueSetUj = ttVarVe.uj();
                if (!ttVarVe.c() || pluginValueSetUj == null) {
                    return null;
                }
                JSONObject jSONObjectC = com.byazt.whk.da.c(pluginValueSetUj, 2);
                if (jSONObjectC != null) {
                    try {
                        JSONArray jSONArray = jSONObjectC.getJSONArray("probability");
                        com.byazt.dna.n nVarTt = gr.tt();
                        if (jSONArray.length() == 1 && nVarTt != null) {
                            nVarTt.softDecTool2ua(jSONArray.optDouble(0), System.currentTimeMillis());
                        }
                    } catch (JSONException unused) {
                    }
                }
                return pluginValueSetUj;
            }
        });
    }

    private static void c(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField(NativeLibs.FIELD_PATH_LIST);
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3);
                        sb.append(l.b);
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void c(final String str, final String str2) {
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.gr.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() {
                return com.byazt.qal.tt.tt().c(str2).tt(str);
            }
        }, str2);
    }

    public static void c(MotionEvent motionEvent) {
        try {
            tt().pglArmorCallApi2c(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String c(String str, long j, int i, boolean z) {
        try {
            return tt().pglArmorCallApi2ccc(str, j, i, z);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(long j, int i) {
        try {
            tt().pglArmorCallApi2src(j, i);
        } catch (Throwable unused) {
        }
    }

    public static int c(String str) {
        int i = c;
        if (str != null && !str.isEmpty()) {
            int iIndexOf = str.indexOf(LoginConstants.UNDER_LINE);
            if (iIndexOf <= 0) {
                return ve;
            }
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            int iIndexOf2 = strSubstring2.indexOf(LoginConstants.UNDER_LINE);
            if (iIndexOf2 <= 0) {
                return ve;
            }
            String strSubstring3 = strSubstring2.substring(0, iIndexOf2);
            String strSubstring4 = strSubstring2.substring(iIndexOf2 + 1);
            long jLongValue = Long.valueOf(strSubstring).longValue() - Long.valueOf(strSubstring3).longValue();
            try {
                com.byazt.dna.n nVarTt = tt();
                if (nVarTt != null) {
                    if (!nVarTt.signVerifyMD5withRSA(strSubstring3 + LoginConstants.UNDER_LINE + z.c(), strSubstring4)) {
                        return ve;
                    }
                }
                if (Math.abs(jLongValue) > uj) {
                    i = tt;
                }
                return i;
            } catch (Throwable unused) {
                return c;
            }
        }
        return ve;
    }

    public static String c(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(TimeToSampleBox.TYPE, 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            com.byazt.nr.m.c(th2);
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void c(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.gr.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.byazt.qal.tt.tt().c("pangle_clz_found").tt(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    public static void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.ukr.yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.aas.gr.4
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                return com.byazt.qal.tt.tt().c("har_automatic").tt(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void c(int i, final int i2) {
        final com.byazt.dna.n nVarTt = tt();
        if (nVarTt == null || nVarTt.getArmorContext() == null || !com.byazt.omf.x.m().uj() || !nVarTt.enableSetHARSensorCallBack(i)) {
            return;
        }
        if (n == null) {
            n = new com.byazt.dna.n.c() { // from class: com.byazt.aas.gr.6
                @Override // com.byazt.dna.n.c
                public void reportSensorData(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("scene", i2);
                        } catch (JSONException unused) {
                        }
                        gr.tt(jSONObject);
                        gr.c(jSONObject);
                    }
                }
            };
            nVarTt.setHARSensorCallBack(n);
        }
        com.byazt.bwm.n.tt(new com.byazt.bwm.sp("har") { // from class: com.byazt.aas.gr.7
            @Override // java.lang.Runnable
            public void run() {
                nVarTt.registerHarSensors();
            }
        });
    }
}
