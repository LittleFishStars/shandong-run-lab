package com.baidu.mshield.x0;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mshield.x0.d.d;
import com.baidu.mshield.x0.d.e;
import com.baidu.mshield.x0.d.g;
import com.baidu.mshield.x0.l.c;
import com.baidu.mshield.x0.receiver.ReceiverWork;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class EngineImpl {
    public static final String KEY_ACCOUNT_ID = "aid";
    public static final String KEY_ANDROID_ID = "arid";
    public static final String KEY_ANDROID_LEVEL = "arl";
    public static final String KEY_ANDROID_VERSION = "arv";
    public static final String KEY_CUID = "cuid";
    public static final String KEY_MODEL = "mod";
    public static final String KEY_PACKAGE = "p";
    public static final String KEY_SENSOR_LIST = "sl";
    public static final String KEY_SIGNATURE = "s";
    public static final String KEY_WIFI_STATE = "ws";
    public static boolean isUnload = false;
    public static Context mContext = null;
    public static String sAppkey = "";
    private static EngineImpl sInstance = null;
    public static boolean sIsArm = true;
    public static boolean sIsX86 = false;
    public static String sSecKey = "";
    public String ids = "{}";
    private IntentFilter mSecAlarmFilter;
    private IntentFilter mSecSystemFilter;
    private com.baidu.mshield.x0.l.a pref;
    private ReceiverWork secReceiver;
    private c sofirePreferences;
    public static final HashMap<String, String> PROPERTY_MAP = new HashMap<>();
    public static int sScreenStatus = 1;
    public static String sLoadVersion = com.baidu.mshield.x0.a.c;
    public static String secName = com.baidu.mshield.x0.a.d;
    public static String secPackageName = com.baidu.mshield.x0.a.f26729a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f26728a;
        public final /* synthetic */ boolean b;

        public a(int i, boolean z) {
            this.f26728a = i;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            EngineImpl.this.doInit(this.f26728a, this.b);
        }
    }

    public class b extends com.baidu.mshield.x0.d.h.b {

        public class a extends TimerTask {
            public a(b bVar) {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                d.b(EngineImpl.mContext);
            }
        }

        public b() {
        }

        @Override // com.baidu.mshield.x0.d.h.b
        public void a() {
            try {
                com.baidu.mshield.b.c.a.b("setAliveDate");
                d.q(EngineImpl.mContext);
                d.a(EngineImpl.mContext.getApplicationContext(), com.baidu.mshield.x0.a.d, com.baidu.mshield.x0.a.f26729a, EngineImpl.sLoadVersion, "1001003", "1001002");
                if (EngineImpl.this.pref.d("1001003").equals("")) {
                    new Timer().schedule(new a(this), 60000L);
                } else {
                    d.b(EngineImpl.mContext);
                }
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    private EngineImpl(Context context) {
        mContext = context;
        this.pref = new com.baidu.mshield.x0.l.a(context);
        this.sofirePreferences = new c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doInit(int i, boolean z) {
        try {
            isUnload = false;
            d.m(mContext);
            com.baidu.xclient.gdid.a.a(mContext, sAppkey, sSecKey);
            this.pref.g(sLoadVersion);
            registerReceiver();
            com.baidu.mshield.x0.d.b.a(mContext, true);
            initReport();
            setAlarms();
            com.baidu.mshield.x0.c.a.a(mContext);
            com.baidu.mshield.x0.c.c.a(mContext);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).init(i, z);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecImpl(new com.baidu.mshield.x0.b());
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public static synchronized EngineImpl getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new EngineImpl(context);
        }
        return sInstance;
    }

    private void handleTokenLogic() {
        try {
            if (d.a(mContext, "plc95", false, this.pref)) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                com.baidu.mshield.x6.b.b bVar = new com.baidu.mshield.x6.b.b(mContext);
                String strB = bVar.B();
                int iW = bVar.w();
                int iV = bVar.v();
                JSONArray jSONArray = TextUtils.isEmpty(strB) ? new JSONArray() : new JSONArray(strB);
                if (jSONArray.length() + 1 > iW) {
                    jSONArray.remove(0);
                }
                StringBuilder sb = new StringBuilder();
                int i = iV + 1;
                sb.append(i);
                sb.append("#");
                sb.append(this.sofirePreferences.d());
                sb.append("#");
                sb.append(jCurrentTimeMillis);
                jSONArray.put(sb.toString());
                bVar.a(i);
                bVar.j(jSONArray.toString());
                String strE = this.sofirePreferences.e();
                long jO = this.pref.o();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                com.baidu.mshield.x0.d.c cVar = new com.baidu.mshield.x0.d.c();
                d.a(mContext, "plc95", cVar, this.pref);
                long j = ((long) cVar.d) * 60000;
                if (TextUtils.isEmpty(strE)) {
                    new com.baidu.mshield.x0.h.a().a(mContext, 6, 1, j);
                    this.pref.f(jCurrentTimeMillis2);
                } else if (jCurrentTimeMillis2 - jO >= j) {
                    this.sofirePreferences.d(strE);
                    this.sofirePreferences.e("");
                    this.pref.f(jCurrentTimeMillis2);
                    new com.baidu.mshield.x0.h.a().a(mContext, 6, 1, j);
                }
            }
        } catch (Throwable th) {
            d.a(th);
        }
    }

    private void initReport() {
        com.baidu.mshield.x0.d.h.d.b().a(new b());
    }

    private void registerReceiver() {
        try {
            this.secReceiver = new ReceiverWork();
            if (this.mSecAlarmFilter == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.mSecAlarmFilter = intentFilter;
                intentFilter.addAction("com.baidu.mshield.x0.alarm.action");
                if (Build.VERSION.SDK_INT >= 33) {
                    try {
                        mContext.registerReceiver(this.secReceiver, this.mSecAlarmFilter, 4);
                    } catch (Throwable th) {
                        d.a(th);
                    }
                } else {
                    mContext.registerReceiver(this.secReceiver, this.mSecAlarmFilter);
                }
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    private void setAlarms() {
        long jCurrentTimeMillis;
        try {
            com.baidu.mshield.x0.l.a aVar = new com.baidu.mshield.x0.l.a(mContext);
            com.baidu.mshield.x0.d.b.a(mContext, false);
            long jN = aVar.n();
            if (jN == 0) {
                jCurrentTimeMillis = ((long) com.baidu.mshield.x0.d.b.b(mContext)) * 60000;
                aVar.e(System.currentTimeMillis() + jCurrentTimeMillis);
            } else {
                jCurrentTimeMillis = jN - System.currentTimeMillis();
                if (jCurrentTimeMillis < 0) {
                    jCurrentTimeMillis = 50;
                }
            }
            com.baidu.mshield.x0.d.b.a(mContext, jCurrentTimeMillis);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public int adm(String str) {
        return 0;
    }

    public int aen(String str) {
        return 0;
    }

    public String getAidFWM() {
        return e.a(mContext);
    }

    public String getIccFWM() {
        return "";
    }

    public String getIds() {
        return this.ids;
    }

    public String getImeFWM() {
        return "";
    }

    public String getImsFWM() {
        return "";
    }

    public String getMaFWM() {
        return "";
    }

    public String getNui() {
        return g.b(mContext);
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
            d.a(th);
            return "";
        }
    }

    public int gpol() {
        return com.baidu.mshield.x0.j.a.a(mContext).a((com.baidu.mshield.x0.j.a.b) null, false);
    }

    public String gtdid() {
        try {
            return com.baidu.xclient.gdid.a.b();
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public String ice() {
        return ice(-1);
    }

    public synchronized boolean init(int i, boolean z) {
        new Thread(new a(i, z)).start();
        return true;
    }

    public String mqa(int i, String str, int i2) {
        return "";
    }

    public void reportAlive() {
        d.b(mContext);
    }

    public void sendWMCrashLog(int i) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", i);
            jSONArray.put(jSONObject);
            d.a(mContext, jSONArray, "1001133");
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void setBusy(boolean z) {
    }

    public void setPkgNameVersion(String str, String str2) {
        try {
            com.baidu.mshield.b.c.a.b("p : " + str + " : v : " + str2);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setPkgNameVersion(str, str2);
            if (!TextUtils.isEmpty(str)) {
                com.baidu.mshield.x0.a.f26729a = str;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            sLoadVersion = str2;
            this.pref.g(str2);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void setRunStatus(int i) {
        try {
            this.pref.e(i);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setRunStatus(i);
        } catch (Throwable th) {
            d.a(th);
        }
    }

    public void setSecurityVerifyInfo(String str, String str2, HashMap<String, String> map) {
        try {
            com.baidu.mshield.b.c.a.b("a : " + str + " s : " + str2);
            com.baidu.mshield.x6.EngineImpl.getInstance(mContext).setSecurityVerifyInfo(str, str2, map);
            com.baidu.xclient.gdid.a.a(mContext, str, str2, map);
            sAppkey = str;
            sSecKey = str2;
            if (map != null) {
                HashMap<String, String> map2 = PROPERTY_MAP;
                synchronized (map2) {
                    try {
                        map2.putAll(map);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            d.a(th2);
        }
    }

    public Boolean stop() {
        return Boolean.TRUE;
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
                com.baidu.mshield.x6.EngineImpl.getInstance(mContext).ud(map);
            } catch (Throwable th) {
                d.a(th);
            }
        }
    }

    public void unload() {
        try {
            mContext.unregisterReceiver(this.secReceiver);
        } catch (Throwable th) {
            d.a(th);
        }
        com.baidu.mshield.x0.d.b.a(mContext);
        stop();
        com.baidu.mshield.x0.e.a.a().b();
        com.baidu.xclient.gdid.a.c();
        com.baidu.mshield.x0.d.h.d.b().c();
        com.baidu.mshield.x6.EngineImpl.getInstance(mContext).unload();
        isUnload = true;
    }

    public String uqi() {
        return "";
    }

    public String xgz(String str) {
        return "";
    }

    public String ice(int i) {
        return ice("", i);
    }

    public String ice(String str, int i) {
        return ice(str, i, "");
    }

    public String ice(String str, int i, String str2) {
        handleTokenLogic();
        return com.baidu.mshield.x0.g.a.a(mContext, str, i, str2);
    }
}
