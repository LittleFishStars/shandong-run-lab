package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.fj;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import com.huachenjie.common.constants.ErrorCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g0b {
    public static boolean d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f16653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Messenger> f16664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16665a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f16668b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f16662a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f16661a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16652a = 0;
    public long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.aps.amapapi.model.a f16657a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocation f16654a = null;
    public long c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41791a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f16660a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public deb f16659a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.aps.amapapi.b f16656a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap<Messenger, Long> f16663a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f16658a = null;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f16671d = 0;
    public long e = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f16667b = null;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f16670c = true;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f16669c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f16655a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public AMapLocationClientOption f16666b = new AMapLocationClientOption();

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            Throwable th;
            Bundle data;
            try {
                data = message.getData();
                try {
                    messenger = message.replyTo;
                    if (data != null) {
                        try {
                            if (!data.isEmpty()) {
                                if (!g0b.this.r(data.getString("c"))) {
                                    if (message.what == 1) {
                                        g.a((String) null, ErrorCode.FENCE_ERROR.f33661a);
                                        com.autonavi.aps.amapapi.model.a aVarU = g0b.u("invalid handlder scode!!!#1002");
                                        com.autonavi.aps.amapapi.a aVar = new com.autonavi.aps.amapapi.a();
                                        aVar.f("#1002");
                                        aVar.e("conitue");
                                        g0b.this.j(messenger, aVarU, aVarU.k(), aVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                            } catch (Throwable th3) {
                                com.autonavi.aps.amapapi.utils.b.a(th3, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    messenger = null;
                    th = th4;
                }
            } catch (Throwable th5) {
                messenger = null;
                th = th5;
                data = null;
            }
            int i = message.what;
            if (i == 0) {
                g0b.this.e(data);
                g0b.this.h(messenger, data);
            } else if (i != 1) {
                switch (i) {
                    case 9:
                        g0b.this.e(data);
                        g0b.this.E();
                        break;
                    case 10:
                        g0b.this.e(data);
                        g0b.this.i(messenger, data, "FINE_LOC");
                        break;
                    case 11:
                        g0b.this.A();
                        break;
                    case 12:
                        g0b.this.f(messenger);
                        break;
                    case 13:
                        Messenger messenger2 = message.replyTo;
                        if (messenger2 != null && g0b.this.f16664a != null && !g0b.this.f16664a.contains(messenger2)) {
                            g0b.this.f16664a.add(messenger2);
                            if (g0b.this.f16664a.size() == 1) {
                                g0b.this.D();
                            }
                        }
                        break;
                    case 14:
                        Messenger messenger3 = message.replyTo;
                        if (messenger3 != null && g0b.this.f16664a != null && g0b.this.f16664a.contains(messenger3)) {
                            g0b.this.f16664a.remove(messenger3);
                        }
                        if (g0b.this.f16664a != null && g0b.this.f16664a.size() == 0) {
                            g0b.this.f16656a.h();
                        }
                        break;
                    case 15:
                        g0b.this.e(data);
                        g0b.this.i(messenger, data, "COARSE_LOC");
                        break;
                }
            } else {
                g0b.this.e(data);
                g0b.this.y(messenger, data);
            }
            super.handleMessage(message);
        }
    }

    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                try {
                    g0b.this.f16659a = new deb(g0b.this.f16653a);
                } catch (Throwable th) {
                    com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "init 2");
                }
                try {
                    com.autonavi.aps.amapapi.utils.a.b(g0b.this.f16653a);
                    com.autonavi.aps.amapapi.utils.a.a(g0b.this.f16653a);
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager$ActionThread", "init 3");
                }
                g0b.this.f16656a = new com.autonavi.aps.amapapi.b(false);
                super.onLooperPrepared();
            } catch (Throwable th3) {
                com.autonavi.aps.amapapi.utils.b.a(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public g0b(Context context) {
        this.f16653a = null;
        this.f16653a = context;
    }

    public static void C() {
        d = false;
    }

    public static com.autonavi.aps.amapapi.model.a a(int i, String str) {
        try {
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(i);
            aVar.setLocationDetail(str);
            return aVar;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    public static void g(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message messageObtain = Message.obtain();
                messageObtain.setData(bundle);
                messageObtain.what = i;
                messenger.send(messageObtain);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    public static AMapLocationClientOption t(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOptionA = null;
        try {
            aMapLocationClientOptionA = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString("d");
                if (!TextUtils.isEmpty(string)) {
                    fj.x(string);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOptionA;
    }

    public static /* synthetic */ com.autonavi.aps.amapapi.model.a u(String str) {
        return a(10, str);
    }

    public final void A() {
        try {
            HashMap<Messenger, Long> map = this.f16663a;
            if (map != null) {
                map.clear();
                this.f16663a = null;
            }
            try {
                List<Messenger> list = this.f16664a;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "apm", "des1");
            }
            deb debVar = this.f16659a;
            if (debVar != null) {
                debVar.e();
                this.f16659a = null;
            }
            this.f16665a = false;
            this.f16668b = false;
            this.f16656a.e();
            a aVar = this.f16660a;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.f16660a = null;
            b bVar = this.f16661a;
            if (bVar != null) {
                try {
                    e.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.f16661a.quit();
                }
            }
            this.f16661a = null;
            if (this.f16658a != null && this.f16671d != 0 && this.e != 0) {
                long jB = i.b() - this.f16671d;
                g.a(this.f16653a, this.f16658a.c(this.f16653a), this.f16658a.d(this.f16653a), this.e, jB);
                this.f16658a.e(this.f16653a);
            }
            g.a(this.f16653a);
            a7b.j();
            if (d) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "apm", "tdest");
        }
    }

    public final void D() {
        if (i.m(this.f16653a)) {
            return;
        }
        try {
            com.autonavi.aps.amapapi.b bVar = this.f16656a;
            if (bVar == null || bVar == null) {
                return;
            }
            bVar.a(this.f16660a);
            this.f16656a.g();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "startColl");
        }
    }

    public final void E() {
        try {
            com.autonavi.aps.amapapi.utils.a.c(this.f16653a);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    public final void c() {
        try {
            this.f16658a = new g();
            b bVar = new b("amapLocCoreThread");
            this.f16661a = bVar;
            bVar.setPriority(5);
            this.f16661a.start();
            this.f16660a = new a(this.f16661a.getLooper());
            this.f16664a = new ArrayList();
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void d(Intent intent) {
        a aVar;
        if (!"true".equals(intent.getStringExtra("as")) || (aVar = this.f16660a) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    public final void e(Bundle bundle) {
        try {
            if (this.f16665a) {
                com.autonavi.aps.amapapi.b bVar = this.f16656a;
                if (bVar != null) {
                    bVar.a();
                    return;
                }
                return;
            }
            com.autonavi.aps.amapapi.utils.b.a(this.f16653a);
            if (bundle != null) {
                this.f16666b = com.autonavi.aps.amapapi.utils.b.a(bundle.getBundle("optBundle"));
            }
            this.f16656a.a(this.f16653a);
            this.f16656a.b();
            l(this.f16666b);
            this.f16656a.c();
            this.f16665a = true;
            this.f16670c = true;
            this.f16669c = "";
            List<Messenger> list = this.f16664a;
            if (list == null || list.size() <= 0) {
                return;
            }
            D();
        } catch (Throwable th) {
            this.f16670c = false;
            th.printStackTrace();
            this.f16669c = th.getMessage();
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "init");
        }
    }

    public final void f(Messenger messenger) {
        this.f16663a.remove(messenger);
    }

    public final void h(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.f16668b) {
                    return;
                }
                this.f16668b = true;
                x(messenger);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    public final void i(Messenger messenger, Bundle bundle, String str) {
        AMapLocationClientOption aMapLocationClientOptionT;
        float fA;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d2 = bundle.getDouble("lat");
                double d3 = bundle.getDouble("lon");
                float f = bundle.getFloat("radius");
                long j = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    AMapLocation aMapLocation = new AMapLocation("gps");
                    aMapLocation.setLatitude(d2);
                    aMapLocation.setLocationType(1);
                    aMapLocation.setLongitude(d3);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setTime(j);
                    this.f16656a.a(aMapLocation);
                }
                if (com.autonavi.aps.amapapi.utils.a.h() && (aMapLocationClientOptionT = t(bundle)) != null && aMapLocationClientOptionT.isNeedAddress()) {
                    l(aMapLocationClientOptionT);
                    AMapLocation aMapLocation2 = this.f16654a;
                    if (aMapLocation2 != null) {
                        fA = i.a(new double[]{d2, d3, aMapLocation2.getLatitude(), this.f16654a.getLongitude()});
                        if (fA < com.autonavi.aps.amapapi.utils.a.i() * 3) {
                            k(messenger, str);
                        }
                    } else {
                        fA = -1.0f;
                    }
                    if (fA == -1.0f || fA > com.autonavi.aps.amapapi.utils.a.i()) {
                        e(bundle);
                        com.autonavi.aps.amapapi.model.a aVarA = this.f16656a.a(d2, d3);
                        this.f16654a = aVarA;
                        if (aVarA == null || TextUtils.isEmpty(aVarA.getAdCode())) {
                            return;
                        }
                        k(messenger, str);
                    }
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    public final void j(Messenger messenger, AMapLocation aMapLocation, String str, com.autonavi.aps.amapapi.a aVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", aVar);
        this.f16663a.put(messenger, Long.valueOf(i.b()));
        g(messenger, 1, bundle);
    }

    public final void k(Messenger messenger, String str) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", com.autonavi.aps.amapapi.utils.a.i());
        bundle.putParcelable("loc", this.f16654a);
        if ("COARSE_LOC".equals(str)) {
            g(messenger, 103, bundle);
        } else {
            g(messenger, 6, bundle);
        }
    }

    public final void l(AMapLocationClientOption aMapLocationClientOption) {
        try {
            com.autonavi.aps.amapapi.b bVar = this.f16656a;
            if (bVar != null) {
                bVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                d = aMapLocationClientOption.isKillProcess();
                if (this.f16655a != null) {
                    if (aMapLocationClientOption.isOffset() != this.f16655a.isOffset() || aMapLocationClientOption.isNeedAddress() != this.f16655a.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.f16655a.isLocationCacheEnable() || this.f16655a.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.b = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.f16655a.isOffset() || this.f16655a.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.f16654a = null;
                    }
                }
                this.f16655a = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "setExtra");
        }
    }

    public final boolean r(String str) {
        if (TextUtils.isEmpty(this.f16667b)) {
            this.f16667b = com.autonavi.aps.amapapi.utils.b.b(this.f16653a);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.f16667b);
    }

    public final Handler s() {
        return this.f16660a;
    }

    public final void w(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            fh.l(this.f16653a, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra("b");
        this.f16662a = stringExtra2;
        j4b.c(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        fj.x(stringExtra3);
    }

    public final void x(Messenger messenger) {
        try {
            this.f16656a.f();
            if (com.autonavi.aps.amapapi.utils.a.k()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                g(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "initAuth");
        }
    }

    public final void y(Messenger messenger, Bundle bundle) {
        String str;
        deb debVar;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                com.autonavi.aps.amapapi.a aVar = new com.autonavi.aps.amapapi.a();
                aVar.e("conitue");
                AMapLocationClientOption aMapLocationClientOptionT = t(bundle);
                l(aMapLocationClientOptionT);
                if (this.f16663a.containsKey(messenger) && !aMapLocationClientOptionT.isOnceLocation()) {
                    if (i.b() - this.f16663a.get(messenger).longValue() < 800) {
                        return;
                    }
                }
                AMapLocation aMapLocationA = null;
                if (!this.f16670c) {
                    this.f16657a = a(9, "init error : " + this.f16669c + "#0901");
                    aVar.f("#0901");
                    com.autonavi.aps.amapapi.model.a aVar2 = this.f16657a;
                    j(messenger, aVar2, aVar2.k(), aVar);
                    g.a((String) null, 2091);
                    return;
                }
                long jB = i.b();
                if (i.a(this.f16657a) && jB - this.b < 600) {
                    com.autonavi.aps.amapapi.model.a aVar3 = this.f16657a;
                    j(messenger, aVar3, aVar3.k(), aVar);
                    this.f16656a.a(this.f16657a, 3);
                    return;
                }
                aVar.c(i.b());
                try {
                    com.autonavi.aps.amapapi.model.a aVarA = this.f16656a.a(aVar);
                    this.f16657a = aVarA;
                    if (aVarA.getLocationType() == 6 || this.f16657a.getLocationType() == 5) {
                        this.f16656a.a(this.f16657a, 2);
                    } else if (this.f16657a.getLocationType() == 2) {
                        this.f16656a.a(this.f16657a, 3);
                    } else if (this.f16657a.getLocationType() == 4) {
                        this.f16656a.a(this.f16657a, 4);
                    }
                    this.f16657a = this.f16656a.a(this.f16657a);
                } catch (Throwable th) {
                    g.a((String) null, 2081);
                    aVar.f("#0801");
                    this.f16657a = a(8, "loc error : " + th.getMessage() + "#0801");
                    com.autonavi.aps.amapapi.utils.b.a(th, "ApsServiceCore", "run part2");
                }
                if (i.a(this.f16657a)) {
                    this.b = i.b();
                }
                if (this.f16657a == null) {
                    this.f16657a = a(8, "loc is null#0801");
                    aVar.f("#0801");
                }
                com.autonavi.aps.amapapi.model.a aVar4 = this.f16657a;
                if (aVar4 != null) {
                    String strK = aVar4.k();
                    aMapLocationA = this.f16657a.m149clone();
                    str = strK;
                } else {
                    str = null;
                }
                try {
                    if (aMapLocationClientOptionT.isLocationCacheEnable() && (debVar = this.f16659a) != null) {
                        aMapLocationA = debVar.a(aMapLocationA, str, aMapLocationClientOptionT.getLastLocationLifeCycle());
                    }
                } catch (Throwable th2) {
                    com.autonavi.aps.amapapi.utils.b.a(th2, "ApsServiceCore", "fixLastLocation");
                }
                j(messenger, aMapLocationA, str, aVar);
            } catch (Throwable th3) {
                com.autonavi.aps.amapapi.utils.b.a(th3, "ApsServiceCore", "doLocation");
            }
        }
    }
}
