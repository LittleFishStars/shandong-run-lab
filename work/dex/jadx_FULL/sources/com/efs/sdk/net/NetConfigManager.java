package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetConfigManager {
    private EfsReporter c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean k;
    private Context l;
    private int m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29895a = "NetConfigManager";
    private final int b = 0;
    private int h = 100;
    private int i = 10;
    private int j = 0;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;

    public NetConfigManager(Context context, EfsReporter efsReporter) {
        int i;
        boolean z;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.d = 0;
        this.e = 0;
        this.k = false;
        this.m = -1;
        Context applicationContext = context.getApplicationContext();
        this.l = applicationContext;
        this.c = efsReporter;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
            this.f = sharedPreferences.getInt("apm_netperf_sampling_rate_last", 0);
            this.g = sharedPreferences.getInt("apm_netperf_extra_last", 0);
        }
        SharedPreferences sharedPreferences2 = this.l.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            i = sharedPreferences2.getInt("apm_netperf_sampling_rate", -1);
            this.e = sharedPreferences2.getInt("apm_netperf_extra", -1);
        } else {
            i = -1;
        }
        this.c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate", "apm_netperf_day_limit", "apm_netperf_data_rate", "apm_netperf_dtet", "apm_netperf_extra", "apm_netperf_bd_state", "apm_netperf_res_bd_state", "apm_netperf_req_hd_state", "apm_netperf_res_hd_state"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences3;
                final SharedPreferences.Editor editorEdit6;
                SharedPreferences sharedPreferences4;
                final SharedPreferences.Editor editorEdit7;
                try {
                    final Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj != null && (sharedPreferences4 = NetConfigManager.this.l.getSharedPreferences("net_launch", 0)) != null && (editorEdit7 = sharedPreferences4.edit()) != null) {
                        new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                editorEdit7.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                                editorEdit7.commit();
                            }
                        }).start();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    final Object obj2 = map.get("apm_netperf_extra");
                    if (obj2 != null && (sharedPreferences3 = NetConfigManager.this.l.getSharedPreferences("net_launch", 0)) != null && (editorEdit6 = sharedPreferences3.edit()) != null) {
                        new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                editorEdit6.putInt("apm_netperf_extra", Integer.parseInt(obj2.toString()));
                                editorEdit6.commit();
                            }
                        }).start();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    NetConfigManager.this.h = Integer.parseInt(map.get("apm_netperf_day_limit").toString());
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                try {
                    Object obj3 = map.get("apm_netperf_data_rate");
                    if (obj3 != null) {
                        NetConfigManager.this.i = Integer.parseInt(obj3.toString());
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
                try {
                    Object obj4 = map.get("apm_netperf_dtet");
                    if (obj4 != null) {
                        NetConfigManager.this.j = Integer.parseInt(obj4.toString());
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                try {
                    Object obj5 = map.get("apm_netperf_bd_state");
                    if (obj5 != null) {
                        NetConfigManager.this.n = Integer.parseInt(obj5.toString()) == 100;
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                try {
                    Object obj6 = map.get("apm_netperf_res_bd_state");
                    if (obj6 != null) {
                        NetConfigManager.this.o = Integer.parseInt(obj6.toString()) == 100;
                    }
                } catch (Throwable th7) {
                    th7.printStackTrace();
                }
                try {
                    Object obj7 = map.get("apm_netperf_req_hd_state");
                    if (obj7 != null) {
                        NetConfigManager.this.p = Integer.parseInt(obj7.toString()) == 100;
                    }
                } catch (Throwable th8) {
                    th8.printStackTrace();
                }
                try {
                    Object obj8 = map.get("apm_netperf_res_hd_state");
                    if (obj8 != null) {
                        NetConfigManager.this.q = Integer.parseInt(obj8.toString()) == 100;
                    }
                } catch (Throwable th9) {
                    th9.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        if (SamplingWhiteListUtil.isHitWL()) {
            z = true;
        } else {
            SharedPreferences sharedPreferences3 = this.l.getSharedPreferences("net_launch", 0);
            long j = sharedPreferences3 != null ? sharedPreferences3.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L) : 0L;
            boolean z2 = sharedPreferences3 != null ? sharedPreferences3.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false) : false;
            int i2 = this.d;
            if (i2 == 0) {
                if (z2 && sharedPreferences3 != null && (editorEdit4 = sharedPreferences3.edit()) != null) {
                    editorEdit4.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                    editorEdit4.commit();
                }
                if (j != 0 && sharedPreferences3 != null && (editorEdit3 = sharedPreferences3.edit()) != null) {
                    editorEdit3.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                    editorEdit3.commit();
                }
            } else {
                boolean z3 = Math.max(i2, this.e) != Math.max(this.f, this.g);
                Long lValueOf = Long.valueOf(j);
                int iMax = Math.max(this.d, this.e);
                Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
                Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
                if (z2 && lValueOf3.longValue() < 86400000 && !z3) {
                    Log.d("NetConfigManager", " check in allready");
                    z = true;
                } else if (lValueOf3.longValue() >= 86400000 || z3) {
                    if (a(iMax)) {
                        Log.d("NetConfigManager", "random check in");
                        z = true;
                    } else {
                        Log.d("NetConfigManager", "random not check in!");
                        z = false;
                    }
                    SharedPreferences sharedPreferences4 = this.l.getSharedPreferences("net_launch", 0);
                    if (sharedPreferences4 != null && (editorEdit2 = sharedPreferences4.edit()) != null) {
                        editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z);
                        editorEdit2.commit();
                    }
                    if (sharedPreferences4 != null && (editorEdit = sharedPreferences4.edit()) != null) {
                        editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                        editorEdit.commit();
                    }
                } else {
                    Log.d("NetConfigManager", "un repeat check in 24 hour!");
                }
            }
            z = false;
        }
        this.k = z;
        SharedPreferences sharedPreferences5 = this.l.getSharedPreferences("net_launch", 0);
        if (sharedPreferences5 != null && (editorEdit5 = sharedPreferences5.edit()) != null) {
            editorEdit5.putInt("apm_netperf_sampling_rate_last", this.d);
            editorEdit5.putInt("apm_netperf_extra_last", this.e);
            editorEdit5.commit();
        }
        int i3 = this.d;
        int i4 = this.e;
        if (i3 >= i4) {
            this.m = 0;
            return;
        }
        if (i4 == 0) {
            this.m = 0;
        } else if (a((i3 * 100) / i4)) {
            this.m = 0;
        } else {
            this.m = 1;
        }
    }

    public boolean enableTracer() {
        return this.k;
    }

    public int getDataRate() {
        return this.i;
    }

    public int getDayLimit() {
        return this.h;
    }

    public int getExtraDataRate() {
        return this.j;
    }

    public int getExtraRateFlag() {
        return this.m;
    }

    public boolean getNetRequestBodyCollectState() {
        return this.n;
    }

    public boolean getNetRequestHeaderCollectState() {
        return this.p;
    }

    public boolean getNetResponseBodyCollectState() {
        return this.o;
    }

    public boolean getNetResponseHeaderCollectState() {
        return this.q;
    }

    public boolean isStrategyHitCurrentProcess() {
        return this.r;
    }

    public void setStrategyHitCurrentProcess(boolean z) {
        this.r = z;
    }

    private static boolean a(int i) {
        if (i == 0) {
            return false;
        }
        return i == 100 || new Random().nextInt(100) <= i;
    }
}
