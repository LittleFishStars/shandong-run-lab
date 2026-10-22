package com.byazt.aas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.view.accessibility.AccessibilityManager;
import com.acse.ottn.p4;
import com.alibaba.ariver.permission.b;
import com.google.android.exoplayer2.StreamVolumeManager;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 2453})
public class DeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile long f28271a = -1;
    public static volatile BroadcastReceiver da = null;
    public static volatile long n = 0;
    public static volatile com.byazt.cb.c sl = null;
    public static volatile int uj = -1;
    public static volatile int ve = -1;
    public static final AtomicLong c = new AtomicLong();
    public static volatile int sp = -1;
    public static volatile boolean x = false;
    public static volatile boolean i = false;
    public static String t = "";
    public static String u = "";
    public static int tt = -1;
    public static long yp = 0;
    public static long z = 0;

    @com.byazt.zqa.c(c = {0, 1, 131, 2397})
    public static class DeviceStatusBroadCastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.byazt.nr.da.ve().post(new Runnable() { // from class: com.byazt.aas.DeviceUtils.DeviceStatusBroadCastReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    DeviceStatusBroadCastReceiver.this.c(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra("status", -1);
                    if (intExtra2 == -1) {
                        c.c = intExtra2;
                    } else if (intExtra2 == 2) {
                        c.c = 1;
                    } else {
                        c.c = 0;
                    }
                } else {
                    c.c = 2;
                }
                c.tt = (intent.getIntExtra(b.b, -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.byazt.omf.x.m().d()) {
                    com.byazt.hef.tt.c(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if (StreamVolumeManager.b.equals(intent.getAction()) && intExtra == 3) {
                com.byazt.nr.da.c().post(new com.byazt.bwm.sp("tt_vol") { // from class: com.byazt.aas.DeviceUtils.DeviceStatusBroadCastReceiver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int i;
                        try {
                            AudioManager audioManager = (AudioManager) com.byazt.omf.gt.getContext().getSystemService("audio");
                            if (audioManager == null) {
                                return;
                            }
                            int streamVolume = audioManager.getStreamVolume(3);
                            if (streamVolume != DeviceUtils.sp) {
                                com.byazt.qqc.ve.c().c(streamVolume);
                            }
                            if (DeviceUtils.sp != -1) {
                                if (streamVolume == 0) {
                                    i = 0;
                                } else {
                                    i = streamVolume - DeviceUtils.sp > 0 ? 2 : 1;
                                }
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - DeviceUtils.z > 1000) {
                                    com.byazt.ukr.yp.c(i, -1);
                                }
                                long unused2 = DeviceUtils.z = jCurrentTimeMillis;
                            }
                            int unused3 = DeviceUtils.sp = streamVolume;
                        } catch (Exception unused4) {
                        }
                    }
                });
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 131, 885})
    public static class c {
        public static int c = -1;
        public static float tt;

        public static int c(Context context) {
            com.byazt.hef.tt.c(context);
            return c;
        }

        public static float tt(Context context) {
            com.byazt.hef.tt.tt(context);
            return tt;
        }
    }

    public static int a() {
        if (uj != -1 && !c(n, 60000L)) {
            return uj;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.byazt.omf.gt.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        uj = accessibilityManager.isEnabled() ? 1 : 0;
        n = System.currentTimeMillis();
        return uj;
    }

    public static boolean c() {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).isScreenOn();
    }

    public static int da() {
        if (sp >= 0) {
            return sp;
        }
        try {
            AudioManager audioManager = (AudioManager) com.byazt.omf.gt.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            com.byazt.qqc.ve.c().tt(streamVolume);
            sp = streamVolume;
            return sp;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long i() {
        return f28271a != -1 ? f28271a : com.byazt.by.uj.c().tt("dev19", -1L);
    }

    public static float n() {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getScreenBright();
    }

    public static void sl() {
        try {
            if (x && da != null) {
                com.byazt.omf.gt.getContext().getApplicationContext().unregisterReceiver(da);
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public static void sp() {
        if (com.byazt.omf.gt.getContext() != null) {
            int iU = nb.u();
            com.byazt.by.uj.c().c("cpu_cnt", iU);
            nb.c = iU;
            int iVe = nb.ve(nb.u());
            com.byazt.by.uj.c().c("cpu_max_freq", iVe);
            nb.tt = iVe;
            int iUj = nb.uj(nb.u());
            com.byazt.by.uj.c().c("cpu_min_freq", iUj);
            nb.ve = iUj;
            String strI = nb.i("MemTotal");
            if (strI != null) {
                com.byazt.by.uj.c().c("total_memory", strI);
                nb.uj = strI;
            }
            long jRh = nb.rh();
            com.byazt.by.uj.c().c("internal_storage", jRh);
            nb.n = jRh;
            long jC = com.byazt.nr.nu.c();
            com.byazt.by.uj.c().c("free_storage", jC);
            nb.f28275a = jC;
            long jRl = nb.rl();
            com.byazt.by.uj.c().c("sdcard_storage", jRl);
            nb.sp = jRl;
            boolean zGu = nb.gu();
            com.byazt.by.uj.c().c("is_root", zGu ? 1 : 0);
            nb.x = zGu ? 1 : 0;
        }
    }

    public static void t() {
        if (i && sl != null) {
            sl.tt();
        }
    }

    public static int uj() {
        int iTt = com.byazt.nr.rh.tt(com.byazt.omf.gt.getContext());
        ve = iTt;
        return iTt;
    }

    public static int x() {
        return (int) (com.byazt.omf.gt.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static String c(Boolean bool) {
        String imei = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getImei(bool);
        String str = u;
        if (str == null || !str.equals(imei)) {
            u = imei;
            com.byazt.zlb.ve.tt(6, imei);
        }
        return imei;
    }

    public static void ve() {
        uj();
        n();
        a();
        c(0);
        c(1);
        ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getNewIpAddrs(false);
        my.tt((String) null);
    }

    public static String tt() {
        String androidId = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getAndroidId();
        String str = t;
        if (str == null || !str.equals(androidId)) {
            t = androidId;
            com.byazt.zlb.ve.tt(9, androidId);
        }
        return androidId;
    }

    public static void uj(Context context) {
        if (!x) {
            try {
                da = new DeviceStatusBroadCastReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction(StreamVolumeManager.b);
                context.getApplicationContext().registerReceiver(da, intentFilter);
                x = true;
            } catch (Throwable unused) {
            }
        }
        if (i) {
            return;
        }
        com.byazt.cb.c cVar = new com.byazt.cb.c(com.byazt.omf.gt.getContext(), com.byazt.nr.da.tt(), new com.byazt.cb.c.InterfaceC0373c() { // from class: com.byazt.aas.DeviceUtils.1
            @Override // com.byazt.cb.c.InterfaceC0373c
            public void c(int i2) {
                boolean zVe = DeviceUtils.ve(com.byazt.omf.gt.getContext());
                int i3 = DeviceUtils.tt;
                if (i3 == -1) {
                    DeviceUtils.tt = i2;
                    return;
                }
                int i4 = i3 - i2;
                DeviceUtils.tt = i2;
                if (!zVe) {
                    if (i2 != -1) {
                        com.byazt.ukr.yp.c(-1, i4 > 0 ? 1 : 2);
                    }
                    com.byazt.qqc.ve.c().c(true);
                } else if (Math.abs(i4) > 20) {
                    int i5 = i4 > 0 ? 1 : 2;
                    com.byazt.qqc.ve.c().c(true);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - DeviceUtils.yp > 1000) {
                        com.byazt.ukr.yp.c(-1, i5);
                    }
                    long unused2 = DeviceUtils.yp = jCurrentTimeMillis;
                }
            }
        });
        sl = cVar;
        cVar.c();
        i = true;
    }

    public static boolean c(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void c(JSONObject jSONObject) throws JSONException {
        if (sl.tt()) {
            jSONObject.putOpt("os_new", p4.f23132a);
            jSONObject.putOpt("harmonyos_api", sl.n());
            jSONObject.putOpt("harmonyos_version", sl.a());
            jSONObject.putOpt("harmonyos_release_type", sl.sp());
            jSONObject.putOpt("harmonyos_build_version", sl.x());
            jSONObject.putOpt("pure_mode", Integer.valueOf(sl.c(com.byazt.omf.gt.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static boolean tt(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static void tt(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", nb.x());
            jSONObject.put("version_code", nb.i());
            jSONObject.put("version", nb.da());
        } catch (Exception unused) {
        }
    }

    public static boolean ve(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String c(int i2) {
        return ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getNetworkSignalType(i2);
    }

    public static boolean c(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static JSONObject c(int i2, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.byazt.omf.x.m().rl());
            jSONObject.put("name", com.byazt.omf.x.m().qy());
            tt(jSONObject);
            com.byazt.qh.tt.tt(jSONObject);
            jSONObject.put("is_paid_app", com.byazt.omf.x.m().gu());
            if (!com.byazt.by.uj.c().sp(i2)) {
                jSONObject.put("network_speed", com.byazt.hy.c.c());
            }
            jSONObject.put("apk_sign", com.byazt.fh.c.sl());
            jSONObject.put("useful_open_sdk", com.byazt.wdw.uj.ve().tt());
            jSONObject.put("real_app_name", com.byazt.fh.c.da());
            jSONObject.put("app_cold_startup_time", com.byazt.qw.ve.ve().c());
            jSONObject.put("sdk_init_timestamp", com.byazt.qw.ve.ve().tt());
            if (z2) {
                jSONObject.put("session_ad_index", c.addAndGet(1L));
                if (com.byazt.omf.gt.tt().ri()) {
                    long jVe = com.byazt.qw.c.ve();
                    jSONObject.put("app_total_7_duration", com.byazt.qw.c.uj() + jVe);
                    jSONObject.put("app_use_7_duration", jVe);
                    jSONObject.put("start_session", com.byazt.qw.c.n());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void c(long j) {
        if (j == -1 || f28271a == j) {
            return;
        }
        f28271a = j;
        com.byazt.by.uj.c().c("dev19", j);
    }
}
