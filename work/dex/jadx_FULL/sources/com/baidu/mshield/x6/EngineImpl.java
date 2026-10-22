package com.baidu.mshield.x6;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.x6.b.b;
import com.baidu.mshield.x6.e.h;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.g;
import com.baidu.mshield.x6.f.m.c;
import com.baidu.mshield.x6.recv.MyReceiver;
import com.igexin.sdk.PushConsts;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_OAID = "oid";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    private static EngineImpl instance = null;
    public static String sAppkey = null;
    public static String sLoadVersion = "4.2.6";
    public static String sSecKey;
    private IntentFilter alarmIntentFilter;
    private Context mContext;
    private a mSecApi;
    private MyReceiver receiver;
    public static final HashMap<String, String> PROPERTY_MAP = new HashMap<>();
    public static boolean isUnload = false;

    private EngineImpl(Context context) {
        this.mContext = context;
    }

    public static synchronized EngineImpl getInstance(Context context) {
        if (instance == null) {
            instance = new EngineImpl(context);
        }
        return instance;
    }

    private void registerReceiver() {
        try {
            if (this.alarmIntentFilter == null) {
                this.alarmIntentFilter = new IntentFilter();
            }
            this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.zid");
            this.alarmIntentFilter.addAction("com.baidu.mshield.x6.alarm.work.finger");
            this.alarmIntentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            this.alarmIntentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
            MyReceiver myReceiver = new MyReceiver();
            this.receiver = myReceiver;
            if (Build.VERSION.SDK_INT < 33) {
                this.mContext.registerReceiver(myReceiver, this.alarmIntentFilter);
                return;
            }
            try {
                this.mContext.registerReceiver(myReceiver, this.alarmIntentFilter, 4);
            } catch (Throwable th) {
                f.b(th);
            }
        } catch (Throwable th2) {
            f.b(th2);
        }
    }

    private void unRegister() {
        try {
            this.mContext.unregisterReceiver(this.receiver);
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public void bdsd(int i, boolean z) {
        h.a(this.mContext).a(i, z);
    }

    public String bqp() {
        return "";
    }

    public String getEmulatorSig() {
        return "";
    }

    public String getPropertyByType(String str) {
        try {
            HashMap<String, String> map = PROPERTY_MAP;
            if (map.size() <= 0) {
                return "";
            }
            synchronized (map) {
                if (!map.containsKey(str)) {
                    return "";
                }
                return map.get(str);
            }
        } catch (Throwable th) {
            f.b(th);
            return "";
        }
    }

    public a getSecApi() {
        return this.mSecApi;
    }

    public synchronized boolean init(int i, boolean z) {
        isUnload = false;
        f.h(this.mContext);
        registerReceiver();
        com.baidu.mshield.x6.f.a.b(this.mContext);
        com.baidu.mshield.x6.f.a.c(this.mContext);
        h.a(this.mContext).b();
        return true;
    }

    public void setBusy(boolean z) {
    }

    public void setPkgNameVersion(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            g.f26769a = str;
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        sLoadVersion = str2;
    }

    public void setRunStatus(int i) {
    }

    public void setSecImpl(a aVar) {
        this.mSecApi = aVar;
    }

    public void setSecurityVerifyInfo(String str, String str2, HashMap<String, String> map) {
        sAppkey = str;
        sSecKey = str2;
        if (map != null) {
            HashMap<String, String> map2 = PROPERTY_MAP;
            synchronized (map2) {
                map2.putAll(map);
            }
        }
    }

    public void uccs(int i, int i2) {
        new b(this.mContext).k(i);
        h.a(this.mContext).a(i, i2);
    }

    public void ud(HashMap<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                synchronized (PROPERTY_MAP) {
                    for (String str : map.keySet()) {
                        PROPERTY_MAP.put(str, map.get(str));
                    }
                }
                com.baidu.xclient.gdid.a.a(map);
            } catch (Throwable th) {
                f.b(th);
            }
        }
    }

    public synchronized void unload() {
        com.baidu.mshield.x6.f.a.a(this.mContext);
        unRegister();
        c.b().c();
        isUnload = true;
    }
}
