package com.byazt.qh;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alipay.sdk.m.y.l;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.d;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.aas.z;
import com.byazt.bwm.i;
import com.byazt.bwm.n;
import com.byazt.dna.u;
import com.byazt.nr.da;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.omf.x;
import com.byazt.ukr.yp;
import com.byazt.uy.a;
import com.byazt.uy.sp;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.adapter.internal.CommonCode;
import com.zj.adlib.xh9;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 20})
public class c {
    public static String c;

    private static String n() {
        return tt("com.byted.pangle");
    }

    private static void tt(final Context context) {
        sp.c(new a() { // from class: com.byazt.qh.c.1
            @Override // com.byazt.uy.a
            public boolean c(final Throwable th, final Thread thread) {
                try {
                    i.tt.sp(com.byazt.jv.c.c);
                    if (!c.tt(th, null)) {
                        return false;
                    }
                    n.tt(new com.byazt.bwm.sp("tt_crash_handle") { // from class: com.byazt.qh.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.c().c(thread, th, c.c);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // com.byazt.uy.a
            public boolean c() {
                try {
                    return c.tt(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        com.byazt.uy.n nVar = new com.byazt.uy.n() { // from class: com.byazt.qh.c.2
            @Override // com.byazt.uy.n
            public List<String> a() {
                return null;
            }

            @Override // com.byazt.uy.n
            public Map<String, Object> c() {
                u uVar = (u) com.byazt.ut.uj.getService("device_info_new");
                HashMap map = new HashMap();
                String did = ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid();
                if (TextUtils.isEmpty(did)) {
                    did = z.c();
                }
                if (!TextUtils.isEmpty(did)) {
                    map.put("device_id", did);
                }
                map.put("ac", com.byazt.lf.a.ve(context));
                map.put("aid", com.byazt.omf.a.c().a());
                map.put("app_name", com.byazt.omf.a.c().sp());
                String strDa = nb.da();
                if (!TextUtils.isEmpty(strDa)) {
                    map.put(AlibcCommonConstant.APP_VERSION, strDa);
                }
                String strI = nb.i();
                if (!TextUtils.isEmpty(strI)) {
                    map.put("version_code", strI);
                    try {
                        map.put("update_version_code", Integer.valueOf(strI));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put("version_name", "7.6.1.1");
                map.put("sdk_api_version", p.n);
                map.put("device_platform", "android");
                map.put("os", "Android");
                String deviceModel = uVar.getDeviceModel();
                map.put("device_type", deviceModel);
                map.put("device_mode", deviceModel);
                map.put("rom", uVar.getRomInfo());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put("device_brand", Build.BRAND);
                map.put(xh9.WEBSITE_PARAMS_CHANNEL, p.a());
                map.put(MediaFormat.KEY_LANGUAGE, Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put("os_version", strSubstring);
                } catch (Exception unused) {
                }
                map.put("openudid", DeviceUtils.tt());
                map.put("dpi", String.valueOf(uVar.getDisplayDpi()));
                map.put(CommonCode.MapKey.HAS_RESOLUTION, pf.uj(context) + "*" + pf.n(context));
                return map;
            }

            @Override // com.byazt.uy.n
            public Map<String, Integer> n() {
                return null;
            }

            @Override // com.byazt.uy.n
            public Map<String, Object> sp() {
                HashMap map = new HashMap();
                String strRl = x.m().rl();
                if (TextUtils.isEmpty(strRl)) {
                    strRl = String.valueOf(com.byazt.omf.a.c().a());
                }
                map.put("host_appid", strRl);
                map.put("sdk_version", "7.6.1.1");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
                map.put(xh9.WEBSITE_PARAMS_CHANNEL, p.a());
                map.put("sdk_api_version", p.n);
                try {
                    map.put("device_score", Double.valueOf(Double.parseDouble(com.byazt.whk.c.c().c("DeviceRate", "bytebench_value", strRl))));
                } catch (Throwable unused) {
                }
                return map;
            }

            @Override // com.byazt.uy.n
            public String tt() {
                String strC = z.c();
                return TextUtils.isEmpty(strC) ? "0" : strC;
            }

            @Override // com.byazt.uy.n
            public String uj() {
                return null;
            }

            @Override // com.byazt.uy.n
            public String ve() {
                return com.byazt.omf.a.c().uj();
            }
        };
        boolean z3 = (gt.tt().rp() & 2) == 0;
        if (z2 && (gt.tt().rp() & 1) == 0) {
            z = true;
        }
        sp.c(applicationContext, nVar, z3, z);
        da.c().postDelayed(new Runnable() { // from class: com.byazt.qh.c.3
            @Override // java.lang.Runnable
            public void run() {
                if (!x.m().d()) {
                    sp.c();
                }
                if (com.byazt.xo.c.tt()) {
                    return;
                }
                boolean zH = gt.tt().h();
                boolean zC = c.c();
                if (zH && zC) {
                    sp.c(new com.byazt.ba.tt() { // from class: com.byazt.qh.c.3.1
                    });
                }
            }
        }, 5000L);
    }

    public static String ve() {
        return tt("com.byted.live.lite");
    }

    public static void c(Context context) {
        tt(context);
    }

    private static void c(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return;
        }
        try {
            Function<SparseArray<Object>, Object> functionLt = x.m().lt();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 17);
            String[] strArr = (String[]) functionLt.apply(sparseArray);
            if (strArr != null && strArr.length != 0) {
                Field declaredField = StackTraceElement.class.getDeclaredField("declaringClass");
                declaredField.setAccessible(true);
                for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                    if (stackTraceElement != null) {
                        String className = stackTraceElement.getClassName();
                        if (!TextUtils.isEmpty(className) && !className.startsWith("java") && !className.startsWith("android") && !className.startsWith("org")) {
                            com.byazt.zqa.c cVar = (com.byazt.zqa.c) Class.forName(className).getAnnotation(com.byazt.zqa.c.class);
                            int[] iArrC = cVar != null ? cVar.c() : null;
                            if (iArrC != null) {
                                StringBuilder sb = new StringBuilder();
                                char[] charArray = strArr[strArr.length - 1].toCharArray();
                                for (int i = 0; i < iArrC.length; i++) {
                                    int i2 = iArrC[i];
                                    if (i2 >= 0 && i2 < strArr.length) {
                                        sb.append(c(charArray, strArr[i2]));
                                        if (i != iArrC.length - 1) {
                                            sb.append(Consts.DOT);
                                        }
                                    } else {
                                        m.tt("NpthUtils", "nameIndex error:" + i2 + ", length:" + strArr.length);
                                    }
                                }
                                declaredField.set(stackTraceElement, sb.toString());
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            yp.c().c("report", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        String strC;
        if (x.m().d()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        if (p.uj >= 7400) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 16);
            Class cls = (Class) x.m().lt().apply(sparseArray);
            if (cls != null) {
                c = c(cls);
            }
            strC = c(c.class);
            c(stackTrace);
        } else {
            strC = null;
        }
        String string = Arrays.toString(stackTrace);
        boolean zContains = string.contains("com.byazt.ub") || string.contains("com.byazt.ak") || string.contains("com.bykv.vk") || string.contains("com.byted.csj.ext_impl") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm") || string.contains("com.byakv") || string.contains("com.byazt");
        if (!zContains && !TextUtils.isEmpty(c)) {
            zContains = string.contains(c);
        }
        if (!zContains && !TextUtils.isEmpty(strC)) {
            zContains = string.contains(strC);
        }
        if (!zContains) {
            return false;
        }
        Map<String, String> mapTt = com.byazt.omf.uj.c().tt();
        if (mapTt != null) {
            if (string.contains("com.byazt.ouz")) {
                mapTt.put("express", "true");
            }
            if (string.contains(com.byazt.apd.c.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapTt.put("live_sdk", "true");
                mapTt.put("live_sdk_version", ve());
            }
            if (!string.contains("com.bytedance.msdk") && !string.contains("com.bytedance.sdk.gromore") && !string.contains("com.bytedance.sdk.openadsdk.mediation") && !string.contains("bykvm")) {
                mapTt.put("mediation", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            } else {
                mapTt.put("mediation", "true");
            }
            String strN = p.ve ? n() : null;
            if (!TextUtils.isEmpty(strN)) {
                mapTt.put("second_plugin_version", strN);
            }
            sp.c(com.byazt.omf.uj.c().tt());
        }
        return true;
    }

    public static boolean c() {
        int iIntValue;
        try {
            String strXd = gt.tt().xd();
            if (!TextUtils.isEmpty(strXd) && strXd.contains(l.b)) {
                String[] strArrSplit = strXd.split(l.b);
                if (strArrSplit.length != 2) {
                    return true;
                }
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                Long lValueOf = -1L;
                try {
                    lValueOf = Long.valueOf(Long.valueOf(str).longValue() * 60 * 1000);
                    iIntValue = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    m.tt("apm", "error", e.getMessage());
                    iIntValue = -1;
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strTt = tt();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strTt)) {
                        sb.append(jCurrentTimeMillis);
                        c(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strTt.split(l.b);
                    int length = strArrSplit2.length;
                    if (length >= iIntValue && length != 0) {
                        boolean z = jCurrentTimeMillis - Long.valueOf(strArrSplit2[0]).longValue() > lValueOf.longValue();
                        int i = length - iIntValue;
                        for (int i2 = i; i2 < length; i2++) {
                            String str3 = strArrSplit2[i2];
                            if (i2 != i && !TextUtils.isEmpty(str3)) {
                                sb.append(str3);
                                sb.append(l.b);
                            }
                        }
                        sb.append(jCurrentTimeMillis);
                        c(sb.toString());
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4);
                        sb.append(l.b);
                    }
                    sb.append(jCurrentTimeMillis);
                    c(sb.toString());
                    return true;
                }
            }
            return true;
        } catch (Exception e2) {
            m.c(e2);
            return true;
        }
    }

    public static String tt() {
        return com.byazt.by.uj.c().tt("sp_apm_record", "");
    }

    private static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Function<SparseArray<Object>, Object> functionLt = x.m().lt();
            if (functionLt == null) {
                return null;
            }
            Object objApply = functionLt.apply(com.byazt.yxi.uj.c().c(8).c(String.class).c(0, str).tt());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void c(String str) {
        com.byazt.by.uj.c().c("sp_apm_record", str);
    }

    private static String c(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getPackage().getName();
        if (name.startsWith("com.bytedance.sdk")) {
            return name;
        }
        String[] strArrSplit = name.split("\\.");
        if (strArrSplit.length <= 3) {
            return name;
        }
        return strArrSplit[0] + Consts.DOT + strArrSplit[1];
    }

    private static String c(char[] cArr, String str) {
        if (str == null) {
            return null;
        }
        if (cArr.length == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = cArr.length;
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ cArr[i % length]);
        }
        return new String(charArray);
    }
}
