package com.zj.adlib;

import android.app.Application;
import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import androidx.camera.video.AudioStats;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.fj;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.AMapLocationQualityReport;
import com.amap.api.location.APSService;
import com.amap.api.location.UmidtokenInfo;
import com.autonavi.aps.amapapi.utils.g;
import com.autonavi.aps.amapapi.utils.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class lua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f43156a = new AtomicBoolean(false);
    public static boolean m = true;
    public static volatile boolean n = false;
    public static boolean o = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f18064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Intent f18065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.autonavi.aps.amapapi.model.a f18071a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public deb f18074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e6b f18075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f18079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption f18069a = new AMapLocationClientOption();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a8b f18073a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18084a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile boolean f18087b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AMapLocationListener> f18083a = new ArrayList<>();
    public boolean c = false;
    public boolean d = true;
    public boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Messenger f18067a = null;
    public Messenger b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18063a = 0;
    public boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f18078a = null;
    public boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationClientOption.AMapLocationMode f18068a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f18081a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f18072a = null;
    public boolean h = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g0b f18076a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public AMapLocationClientOption f18085b = new AMapLocationClientOption();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wab f18080a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18082a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ServiceConnection f18066a = new b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AMapLocationQualityReport f18070a = null;
    public boolean i = false;
    public boolean j = false;
    public volatile boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f18077a = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f18086b = null;
    public boolean l = false;

    public static class a extends it {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f43157a;

        public a(Context context) {
            this.f43157a = context;
        }

        @Override // com.amap.api.col.p0003l.it
        public final void runTask() {
            fj.O();
            fj.t(this.f43157a);
            fj.N(this.f43157a);
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                lua.this.f18067a = new Messenger(iBinder);
                lua.this.f18084a = true;
                lua.this.h = true;
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            lua luaVar = lua.this;
            luaVar.f18067a = null;
            luaVar.f18084a = false;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f43159a;

        static {
            int[] iArr = new int[AMapLocationClientOption.AMapLocationMode.values().length];
            f43159a = iArr;
            try {
                iArr[AMapLocationClientOption.AMapLocationMode.Battery_Saving.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f43159a[AMapLocationClientOption.AMapLocationMode.Device_Sensors.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f43159a[AMapLocationClientOption.AMapLocationMode.Hight_Accuracy.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0 */
        /* JADX WARN: Type inference failed for: r0v1 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v7 */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ?? r0 = 0;
            try {
                super.handleMessage(message);
                int i = message.what;
                if (i == 11) {
                    lua.this.k(message.getData());
                    return;
                }
                if (i == 12) {
                    lua.this.I(message);
                    return;
                }
                if (i == 1011) {
                    lua.this.f(14, null);
                    lua.this.i0();
                }
                try {
                    switch (i) {
                        case 1002:
                            lua.this.U((AMapLocationListener) message.obj);
                            break;
                        case 1003:
                            lua.this.o0();
                            lua.this.f(13, null);
                            break;
                        case 1004:
                            lua.this.r0();
                            lua.this.f(14, null);
                            break;
                        case 1005:
                            lua.this.Z((AMapLocationListener) message.obj);
                            break;
                        default:
                            switch (i) {
                                case 1014:
                                    lua.this.l(message);
                                    break;
                                case 1015:
                                    lua luaVar = lua.this;
                                    luaVar.f18073a.k(luaVar.f18069a);
                                    lua.this.g(1025, null, 300000L);
                                    break;
                                case 1016:
                                    if (i.m(lua.this.f18064a)) {
                                        lua.this.x0();
                                    } else if (!lua.this.f18073a.v()) {
                                        lua.this.t0();
                                    } else {
                                        lua.this.g(1016, null, 1000L);
                                    }
                                    break;
                                case 1017:
                                    lua.this.f18073a.c();
                                    lua.this.d(1025);
                                    break;
                                case 1018:
                                    lua luaVar2 = lua.this;
                                    AMapLocationClientOption aMapLocationClientOption = (AMapLocationClientOption) message.obj;
                                    luaVar2.f18069a = aMapLocationClientOption;
                                    if (aMapLocationClientOption != null) {
                                        luaVar2.y0();
                                    }
                                    break;
                                default:
                                    switch (i) {
                                        case 1023:
                                            lua.this.S(message);
                                            break;
                                        case 1024:
                                            lua.this.X(message);
                                            break;
                                        case 1025:
                                            if (lua.this.f18073a.F()) {
                                                lua.this.f18073a.c();
                                                lua luaVar3 = lua.this;
                                                luaVar3.f18073a.k(luaVar3.f18069a);
                                            }
                                            lua.this.g(1025, null, 300000L);
                                            break;
                                        case 1026:
                                            lua.this.f18075a.i(lua.this.f18069a);
                                            break;
                                        case 1027:
                                            lua.this.f18075a.b();
                                            break;
                                        case 1028:
                                            lua.this.g0((AMapLocation) message.obj);
                                            break;
                                        default:
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                } catch (Throwable th) {
                    r0 = message;
                    th = th;
                    if (r0 == 0) {
                        r0 = "handleMessage";
                    }
                    com.autonavi.aps.amapapi.utils.b.a(th, "AMapLocationManage$MHandlerr", r0);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static class e extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public lua f43161a;

        public e(String str, lua luaVar) {
            super(str);
            this.f43161a = luaVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                this.f43161a.f18074a.b();
                com.autonavi.aps.amapapi.utils.f.a(this.f43161a.f18064a);
                this.f43161a.v0();
                lua luaVar = this.f43161a;
                if (luaVar != null && luaVar.f18064a != null) {
                    com.autonavi.aps.amapapi.utils.a.b(this.f43161a.f18064a);
                    com.autonavi.aps.amapapi.utils.a.a(this.f43161a.f18064a);
                }
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public lua(Context context, Intent intent, Looper looper) {
        this.f18065a = null;
        this.f18064a = context;
        this.f18065a = intent;
        H(looper);
    }

    public static void h(Context context) {
        if (f43156a.compareAndSet(false, true)) {
            z.g().b(new a(context));
        }
    }

    public static void s(com.autonavi.aps.amapapi.b bVar) {
        try {
            bVar.d();
            bVar.a(new AMapLocationClientOption().setNeedAddress(false));
            bVar.a(true, new com.autonavi.aps.amapapi.a());
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstNetLocate 2");
        }
    }

    public static void u(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.model.a aVar) {
        if (aVar != null) {
            try {
                if (aVar.getErrorCode() == 0) {
                    bVar.b(aVar);
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:doFirstAddCache");
            }
        }
    }

    public final void B(boolean z) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("j", z);
            g(1024, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final boolean C() {
        return this.f18084a;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x00c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x00ed A[EXC_TOP_SPLITTER, PHI: r1
      0x00ed: PHI (r1v8 com.amap.api.location.AMapLocation) = 
      (r1v6 com.amap.api.location.AMapLocation)
      (r1v6 com.amap.api.location.AMapLocation)
      (r1v6 com.amap.api.location.AMapLocation)
      (r1v13 com.amap.api.location.AMapLocation)
     binds: [B:67:0x00e8, B:61:0x00d6, B:63:0x00da, B:64:0x00dc] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x0031 A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #9 {all -> 0x0035, blocks: (B:10:0x0027, B:12:0x0031), top: B:117:0x0027, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:16:0x003b A[Catch: all -> 0x0138, TRY_LEAVE, TryCatch #11 {all -> 0x0138, blocks: (B:3:0x000a, B:16:0x003b, B:35:0x0092, B:15:0x0036, B:9:0x0022, B:4:0x0011, B:6:0x001b, B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c, B:10:0x0027, B:12:0x0031), top: B:121:0x000a, inners: #2, #8, #9 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x004b A[Catch: all -> 0x0091, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[Catch: all -> 0x0091, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0061  */
    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[Catch: all -> 0x0091, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x006a A[Catch: all -> 0x0091, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x007f A[Catch: all -> 0x0091, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008c A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #8 {all -> 0x0091, blocks: (B:18:0x0043, B:20:0x004b, B:22:0x0057, B:25:0x0062, B:27:0x006a, B:29:0x007f, B:31:0x0084, B:32:0x008c), top: B:116:0x0043, outer: #11 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:39:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x009d  */
    /* JADX WARN: Code duplicated, block: B:41:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a6 A[Catch: all -> 0x00b1, TRY_LEAVE, TryCatch #7 {all -> 0x00b1, blocks: (B:42:0x00a0, B:44:0x00a6), top: B:114:0x00a0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:59:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8 A[Catch: all -> 0x00e7, TryCatch #5 {all -> 0x00e7, blocks: (B:60:0x00d0, B:62:0x00d8, B:64:0x00dc), top: B:110:0x00d0, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00f5 A[Catch: all -> 0x00fe, TryCatch #12 {all -> 0x00fe, blocks: (B:68:0x00ed, B:70:0x00f5, B:72:0x00f9), top: B:122:0x00ed }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0105 A[Catch: all -> 0x0121, TryCatch #1 {all -> 0x0121, blocks: (B:73:0x00fe, B:75:0x0105, B:76:0x0118, B:78:0x011d), top: B:102:0x00fe, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x011d A[Catch: all -> 0x0121, TRY_LEAVE, TryCatch #1 {all -> 0x0121, blocks: (B:73:0x00fe, B:75:0x0105, B:76:0x0118, B:78:0x011d), top: B:102:0x00fe, outer: #6 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0127 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0129 A[ADDED_TO_REGION] */
    public final com.autonavi.aps.amapapi.model.a E(com.autonavi.aps.amapapi.b bVar) {
        com.autonavi.aps.amapapi.model.a aVar;
        Throwable th;
        boolean zL;
        boolean z;
        com.autonavi.aps.amapapi.model.a aVarA;
        boolean z2;
        String strK;
        Bundle bundle;
        f fVar;
        deb debVar;
        boolean z3;
        long jA;
        String umidtoken;
        AMapLocation aMapLocationM149clone = null;
        this.f18071a = null;
        com.autonavi.aps.amapapi.a aVar2 = new com.autonavi.aps.amapapi.a();
        try {
            try {
                aVar2.c(i.b());
                try {
                    String apikey = AMapLocationClientOption.getAPIKEY();
                    if (TextUtils.isEmpty(apikey)) {
                        umidtoken = UmidtokenInfo.getUmidtoken();
                        if (TextUtils.isEmpty(umidtoken)) {
                            t(bVar, aVar2);
                            zL = com.autonavi.aps.amapapi.utils.a.l();
                            z = false;
                            if (this.f18085b.getCacheCallBack()) {
                                aVarA = b(bVar, this.f18085b.getCacheCallBack());
                                if (aVarA == null) {
                                    aVarA = null;
                                } else if (!com.autonavi.aps.amapapi.utils.a.a(aVarA.getTime())) {
                                    if (this.f18085b.getCacheCallBack()) {
                                        int cacheTimeOut = this.f18085b.getCacheTimeOut();
                                        jA = i.a() - aVarA.getTime();
                                        if (jA > 0) {
                                            this.f18071a = aVarA;
                                            aVarA.setLocationType(10);
                                        }
                                    }
                                    aVarA = null;
                                }
                            } else {
                                aVarA = b(bVar, false);
                            }
                            if (aVarA == null) {
                                if (zL) {
                                    z3 = false;
                                } else {
                                    z3 = true;
                                }
                                aVarA = bVar.a(z3, aVar2);
                                if (aVarA != null) {
                                    z = true;
                                }
                                aVar = aVarA;
                                z2 = z;
                                z = true;
                            } else {
                                aVar = aVarA;
                                z2 = false;
                            }
                            if (aVar != null) {
                                strK = aVar.k();
                                aMapLocationM149clone = aVar.m149clone();
                            } else {
                                strK = null;
                            }
                            if (this.f18069a.isLocationCacheEnable()) {
                                if (this.f18085b.getCacheCallBack()) {
                                    fVar.removeMessages(13);
                                }
                                bundle = new Bundle();
                                if (aMapLocationM149clone != null) {
                                    bundle.putParcelable("loc", aMapLocationM149clone);
                                    bundle.putString("nb", aVar.k());
                                    bundle.putParcelable("statics", aVar2);
                                }
                                k(bundle);
                                if (z2) {
                                    u(bVar, aVar);
                                    if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                } else if (z) {
                                    n = true;
                                    s(bVar);
                                }
                            } else {
                                if (this.f18085b.getCacheCallBack()) {
                                    fVar.removeMessages(13);
                                }
                                bundle = new Bundle();
                                if (aMapLocationM149clone != null) {
                                    bundle.putParcelable("loc", aMapLocationM149clone);
                                    bundle.putString("nb", aVar.k());
                                    bundle.putParcelable("statics", aVar2);
                                }
                                k(bundle);
                                if (z2) {
                                    u(bVar, aVar);
                                    if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                } else if (z) {
                                    n = true;
                                    s(bVar);
                                }
                            }
                        } else {
                            fj.x(umidtoken);
                            t(bVar, aVar2);
                            zL = com.autonavi.aps.amapapi.utils.a.l();
                            z = false;
                            if (this.f18085b.getCacheCallBack()) {
                                aVarA = b(bVar, this.f18085b.getCacheCallBack());
                                if (aVarA == null) {
                                    aVarA = null;
                                } else if (!com.autonavi.aps.amapapi.utils.a.a(aVarA.getTime())) {
                                    if (this.f18085b.getCacheCallBack()) {
                                        int cacheTimeOut2 = this.f18085b.getCacheTimeOut();
                                        jA = i.a() - aVarA.getTime();
                                        if (jA > 0) {
                                            this.f18071a = aVarA;
                                            aVarA.setLocationType(10);
                                        }
                                    }
                                    aVarA = null;
                                }
                            } else {
                                aVarA = b(bVar, false);
                            }
                            if (aVarA == null) {
                                if (zL) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                aVarA = bVar.a(z3, aVar2);
                                if (aVarA != null) {
                                    z = true;
                                }
                                aVar = aVarA;
                                z2 = z;
                                z = true;
                            } else {
                                aVar = aVarA;
                                z2 = false;
                            }
                            if (aVar != null) {
                                strK = aVar.k();
                                aMapLocationM149clone = aVar.m149clone();
                            } else {
                                strK = null;
                            }
                            if (this.f18069a.isLocationCacheEnable()) {
                                if (this.f18085b.getCacheCallBack()) {
                                    fVar.removeMessages(13);
                                }
                                bundle = new Bundle();
                                if (aMapLocationM149clone != null) {
                                    bundle.putParcelable("loc", aMapLocationM149clone);
                                    bundle.putString("nb", aVar.k());
                                    bundle.putParcelable("statics", aVar2);
                                }
                                k(bundle);
                                if (z2) {
                                    u(bVar, aVar);
                                    if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                } else if (z) {
                                    n = true;
                                    s(bVar);
                                }
                            } else {
                                if (this.f18085b.getCacheCallBack()) {
                                    fVar.removeMessages(13);
                                }
                                bundle = new Bundle();
                                if (aMapLocationM149clone != null) {
                                    bundle.putParcelable("loc", aMapLocationM149clone);
                                    bundle.putString("nb", aVar.k());
                                    bundle.putParcelable("statics", aVar2);
                                }
                                k(bundle);
                                if (z2) {
                                    u(bVar, aVar);
                                    if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                } else if (z) {
                                    n = true;
                                    s(bVar);
                                }
                            }
                        }
                    } else {
                        fh.l(this.f18064a, apikey);
                        try {
                            umidtoken = UmidtokenInfo.getUmidtoken();
                            if (TextUtils.isEmpty(umidtoken)) {
                                fj.x(umidtoken);
                                t(bVar, aVar2);
                                zL = com.autonavi.aps.amapapi.utils.a.l();
                                z = false;
                                try {
                                    if (this.f18085b.getCacheCallBack()) {
                                        aVarA = b(bVar, this.f18085b.getCacheCallBack());
                                        if (aVarA == null) {
                                            aVarA = null;
                                        } else if (!com.autonavi.aps.amapapi.utils.a.a(aVarA.getTime())) {
                                            if (this.f18085b.getCacheCallBack()) {
                                                int cacheTimeOut3 = this.f18085b.getCacheTimeOut();
                                                jA = i.a() - aVarA.getTime();
                                                if (jA > 0 && jA < cacheTimeOut3) {
                                                    this.f18071a = aVarA;
                                                    aVarA.setLocationType(10);
                                                }
                                            }
                                            aVarA = null;
                                        }
                                    } else {
                                        aVarA = b(bVar, false);
                                    }
                                } catch (Throwable th2) {
                                    com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "apscach");
                                }
                                if (aVarA == null) {
                                    if (zL) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    try {
                                        aVarA = bVar.a(z3, aVar2);
                                        if (aVarA != null && aVarA.getErrorCode() == 0) {
                                            z = true;
                                        }
                                    } catch (Throwable th3) {
                                        try {
                                            com.autonavi.aps.amapapi.utils.b.a(th3, "ALManager", "apsLocation:doFirstNetLocate");
                                        } catch (Throwable th4) {
                                            th = th4;
                                            aVar = aVarA;
                                            try {
                                                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation");
                                                return aVar;
                                            } finally {
                                                try {
                                                    bVar.e();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                        }
                                    }
                                    aVar = aVarA;
                                    z2 = z;
                                    z = true;
                                } else {
                                    aVar = aVarA;
                                    z2 = false;
                                }
                                if (aVar != null) {
                                    try {
                                        strK = aVar.k();
                                        aMapLocationM149clone = aVar.m149clone();
                                    } catch (Throwable th5) {
                                        th = th5;
                                        com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation");
                                    }
                                } else {
                                    strK = null;
                                }
                                try {
                                    if (this.f18069a.isLocationCacheEnable() || (debVar = this.f18074a) == null) {
                                        try {
                                            if (this.f18085b.getCacheCallBack() && (fVar = this.f18079a) != null) {
                                                fVar.removeMessages(13);
                                            }
                                        } catch (Throwable unused2) {
                                        }
                                        try {
                                            bundle = new Bundle();
                                            if (aMapLocationM149clone != null) {
                                                bundle.putParcelable("loc", aMapLocationM149clone);
                                                bundle.putString("nb", aVar.k());
                                                bundle.putParcelable("statics", aVar2);
                                            }
                                            k(bundle);
                                            if (z2) {
                                                u(bVar, aVar);
                                                if (z && zL && !n) {
                                                    n = true;
                                                    s(bVar);
                                                }
                                            } else if (z) {
                                                n = true;
                                                s(bVar);
                                            }
                                        } catch (Throwable th6) {
                                            com.autonavi.aps.amapapi.utils.b.a(th6, "ALManager", "apsLocation:callback");
                                        }
                                    } else {
                                        aMapLocationM149clone = debVar.a(aMapLocationM149clone, strK, this.f18069a.getLastLocationLifeCycle());
                                        if (this.f18085b.getCacheCallBack()) {
                                            fVar.removeMessages(13);
                                        }
                                        bundle = new Bundle();
                                        if (aMapLocationM149clone != null) {
                                            bundle.putParcelable("loc", aMapLocationM149clone);
                                            bundle.putString("nb", aVar.k());
                                            bundle.putParcelable("statics", aVar2);
                                        }
                                        k(bundle);
                                        if (z2) {
                                            u(bVar, aVar);
                                            if (z) {
                                                n = true;
                                                s(bVar);
                                            }
                                        } else if (z) {
                                            n = true;
                                            s(bVar);
                                        }
                                    }
                                } catch (Throwable th7) {
                                    com.autonavi.aps.amapapi.utils.b.a(th7, "ALManager", "fixLastLocation");
                                }
                            } else {
                                t(bVar, aVar2);
                                zL = com.autonavi.aps.amapapi.utils.a.l();
                                z = false;
                                if (this.f18085b.getCacheCallBack()) {
                                    aVarA = b(bVar, this.f18085b.getCacheCallBack());
                                    if (aVarA == null) {
                                        aVarA = null;
                                    } else if (!com.autonavi.aps.amapapi.utils.a.a(aVarA.getTime())) {
                                        if (this.f18085b.getCacheCallBack()) {
                                            int cacheTimeOut4 = this.f18085b.getCacheTimeOut();
                                            jA = i.a() - aVarA.getTime();
                                            if (jA > 0) {
                                                this.f18071a = aVarA;
                                                aVarA.setLocationType(10);
                                            }
                                        }
                                        aVarA = null;
                                    }
                                } else {
                                    aVarA = b(bVar, false);
                                }
                                if (aVarA == null) {
                                    if (zL) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    aVarA = bVar.a(z3, aVar2);
                                    if (aVarA != null) {
                                        z = true;
                                    }
                                    aVar = aVarA;
                                    z2 = z;
                                    z = true;
                                } else {
                                    aVar = aVarA;
                                    z2 = false;
                                }
                                if (aVar != null) {
                                    strK = aVar.k();
                                    aMapLocationM149clone = aVar.m149clone();
                                } else {
                                    strK = null;
                                }
                                if (this.f18069a.isLocationCacheEnable()) {
                                    if (this.f18085b.getCacheCallBack()) {
                                        fVar.removeMessages(13);
                                    }
                                    bundle = new Bundle();
                                    if (aMapLocationM149clone != null) {
                                        bundle.putParcelable("loc", aMapLocationM149clone);
                                        bundle.putString("nb", aVar.k());
                                        bundle.putParcelable("statics", aVar2);
                                    }
                                    k(bundle);
                                    if (z2) {
                                        u(bVar, aVar);
                                        if (z) {
                                            n = true;
                                            s(bVar);
                                        }
                                    } else if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                } else {
                                    if (this.f18085b.getCacheCallBack()) {
                                        fVar.removeMessages(13);
                                    }
                                    bundle = new Bundle();
                                    if (aMapLocationM149clone != null) {
                                        bundle.putParcelable("loc", aMapLocationM149clone);
                                        bundle.putString("nb", aVar.k());
                                        bundle.putParcelable("statics", aVar2);
                                    }
                                    k(bundle);
                                    if (z2) {
                                        u(bVar, aVar);
                                        if (z) {
                                            n = true;
                                            s(bVar);
                                        }
                                    } else if (z) {
                                        n = true;
                                        s(bVar);
                                    }
                                }
                            }
                        } catch (Throwable th8) {
                            com.autonavi.aps.amapapi.utils.b.a(th8, "ALManager", "apsLocation setUmidToken");
                        }
                    }
                } catch (Throwable th9) {
                    com.autonavi.aps.amapapi.utils.b.a(th9, "ALManager", "apsLocation setAuthKey");
                }
            } catch (Throwable th10) {
                aVar = null;
                th = th10;
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation");
                return aVar;
            }
        } catch (Throwable unused3) {
        }
        return aVar;
    }

    public final void G() {
        f fVar;
        try {
            if (this.f18085b.getCacheCallBack() && (fVar = this.f18079a) != null) {
                fVar.sendEmptyMessageDelayed(13, this.f18085b.getCacheCallBackTime());
            }
        } catch (Throwable unused) {
        }
        try {
            g(1003, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startLocation");
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0029 -> B:29:0x002e). Please report as a decompilation issue!!! */
    public final void H(Looper looper) {
        try {
            if (looper != null) {
                this.f18079a = new f(looper);
            } else if (Looper.myLooper() == null) {
                this.f18079a = new f(this.f18064a.getMainLooper());
            } else {
                this.f18079a = new f();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "init 1");
        }
        try {
            try {
                this.f18074a = new deb(this.f18064a);
            } catch (Throwable th2) {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "init 2");
            }
            e eVar = new e("amapLocManagerThread", this);
            this.f18078a = eVar;
            eVar.setPriority(5);
            this.f18078a.start();
            this.f18077a = c(this.f18078a.getLooper());
        } catch (Throwable th3) {
            com.autonavi.aps.amapapi.utils.b.a(th3, "ALManager", "init 5");
        }
        try {
            this.f18073a = new a8b(this.f18064a, this.f18079a);
            this.f18075a = new e6b(this.f18064a, this.f18079a);
        } catch (Throwable th4) {
            com.autonavi.aps.amapapi.utils.b.a(th4, "ALManager", "init 3");
        }
        if (this.f18072a == null) {
            this.f18072a = new g();
        }
        h(this.f18064a);
    }

    public final void I(Message message) {
        try {
            AMapLocation aMapLocation = (AMapLocation) message.obj;
            if (this.d && this.f18067a != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f18069a));
                f(0, bundle);
                if (this.f18087b) {
                    f(13, null);
                }
                this.d = false;
            }
            o(aMapLocation, null);
            d(1025);
            g(1025, null, 300000L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    public final void J(AMapLocation aMapLocation) {
        if (aMapLocation != null) {
            try {
                String locationDetail = aMapLocation.getLocationDetail();
                StringBuilder sb = TextUtils.isEmpty(locationDetail) ? new StringBuilder() : new StringBuilder(locationDetail);
                boolean zC = i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF");
                boolean zC2 = i.c(this.f18064a, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF");
                boolean zC3 = i.c(this.f18064a, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==");
                boolean zC4 = i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU=");
                boolean zC5 = i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O");
                boolean zC6 = i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=");
                sb.append(zC ? "#pm1" : "#pm0");
                String str = "1";
                sb.append(zC2 ? "1" : "0");
                sb.append(zC3 ? "1" : "0");
                sb.append(zC4 ? "1" : "0");
                sb.append(zC5 ? "1" : "0");
                if (!zC6) {
                    str = "0";
                }
                sb.append(str);
                aMapLocation.setLocationDetail(sb.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public final void K(AMapLocationListener aMapLocationListener) {
        try {
            g(1005, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "unRegisterLocationListener");
        }
    }

    public final void R() {
        try {
            g(1004, null, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final void S(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i = data.getInt("i", 0);
            Notification notification = (Notification) data.getParcelable(y6b.g);
            Intent intentW0 = w0();
            intentW0.putExtra("i", i);
            intentW0.putExtra(y6b.g, notification);
            intentW0.putExtra(y6b.f, 1);
            j(intentW0, true);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doEnableBackgroundLocation");
        }
    }

    public final void T(AMapLocation aMapLocation) {
        Message messageObtainMessage = this.f18079a.obtainMessage();
        messageObtainMessage.what = 10;
        messageObtainMessage.obj = aMapLocation;
        this.f18079a.sendMessage(messageObtainMessage);
    }

    public final void U(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            throw new IllegalArgumentException("listener参数不能为null");
        }
        if (this.f18083a == null) {
            this.f18083a = new ArrayList<>();
        }
        if (this.f18083a.contains(aMapLocationListener)) {
            return;
        }
        this.f18083a.add(aMapLocationListener);
    }

    public final void W() {
        try {
            wab wabVar = this.f18080a;
            if (wabVar != null) {
                wabVar.h();
                this.f18080a = null;
            }
            g(1011, null, 0L);
            this.g = true;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "onDestroy");
        }
    }

    public final void X(Message message) {
        if (message == null) {
            return;
        }
        try {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            boolean z = data.getBoolean("j", true);
            Intent intentW0 = w0();
            intentW0.putExtra("j", z);
            intentW0.putExtra(y6b.f, 2);
            j(intentW0, false);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doDisableBackgroundLocation");
        }
    }

    public final synchronized void Y(AMapLocation aMapLocation) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("coarse amapLocation is null#2005");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerCoarseLocation part2");
                return;
            }
        }
        if (this.f18070a == null) {
            this.f18070a = new AMapLocationQualityReport();
        }
        this.f18070a.setLocationMode(this.f18069a.getLocationMode());
        if (this.f18075a != null) {
            this.f18070a.setGPSSatellites(aMapLocation.getSatellites());
            this.f18070a.setGpsStatus(this.f18075a.n());
        }
        this.f18070a.setWifiAble(i.g(this.f18064a));
        this.f18070a.setNetworkType(i.h(this.f18064a));
        this.f18070a.setNetUseTime(0L);
        this.f18070a.setInstallHighDangerMockApp(o);
        aMapLocation.setLocationQualityReport(this.f18070a);
        try {
            if (this.f18087b) {
                g.a(this.f18064a, aMapLocation);
                T(aMapLocation.m149clone());
                com.autonavi.aps.amapapi.utils.f.a(this.f18064a).a(aMapLocation);
                com.autonavi.aps.amapapi.utils.f.a(this.f18064a).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerCoarseLocation part");
        }
        if (this.g) {
            return;
        }
        if (this.f18075a != null) {
            r0();
        }
        f(14, null);
    }

    public final void Z(AMapLocationListener aMapLocationListener) {
        if (!this.f18083a.isEmpty() && this.f18083a.contains(aMapLocationListener)) {
            this.f18083a.remove(aMapLocationListener);
        }
        if (this.f18083a.isEmpty()) {
            r0();
        }
    }

    public final com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.b bVar, boolean z) {
        if (!this.f18069a.isLocationCacheEnable()) {
            return null;
        }
        try {
            return bVar.a(z);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doFirstCacheLoc");
            return null;
        }
    }

    public final d c(Looper looper) {
        d dVar;
        synchronized (this.f18081a) {
            dVar = new d(looper);
            this.f18077a = dVar;
        }
        return dVar;
    }

    public final AMapLocation c0() {
        AMapLocation aMapLocationD = null;
        try {
            deb debVar = this.f18074a;
            if (debVar != null && (aMapLocationD = debVar.d()) != null) {
                aMapLocationD.setTrustedLevel(3);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "getLastKnownLocation");
        }
        return aMapLocationD;
    }

    public final void d(int i) {
        synchronized (this.f18081a) {
            d dVar = this.f18077a;
            if (dVar != null) {
                dVar.removeMessages(i);
            }
        }
    }

    public final void d0(AMapLocation aMapLocation) {
        AMapLocation aMapLocationA;
        if (aMapLocation == null) {
            return;
        }
        try {
            com.autonavi.aps.amapapi.storage.b bVar = deb.c;
            if (bVar == null) {
                deb debVar = this.f18074a;
                aMapLocationA = debVar != null ? debVar.d() : null;
            } else {
                aMapLocationA = bVar.a();
            }
            g.a(aMapLocationA, aMapLocation);
        } catch (Throwable unused) {
        }
    }

    public final void e(int i, Notification notification) {
        if (i == 0 || notification == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("i", i);
            bundle.putParcelable(y6b.g, notification);
            g(1023, bundle, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "disableBackgroundLocation");
        }
    }

    public final void f(int i, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable th) {
                boolean z = (th instanceof IllegalStateException) && th.getMessage().contains("sending message to a Handler on a dead thread");
                if ((th instanceof RemoteException) || z) {
                    this.f18067a = null;
                    this.f18084a = false;
                }
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "sendLocMessage");
                return;
            }
        }
        if (TextUtils.isEmpty(this.f18082a)) {
            this.f18082a = com.autonavi.aps.amapapi.utils.b.b(this.f18064a);
        }
        bundle.putString("c", this.f18082a);
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.setData(bundle);
        messageObtain.replyTo = this.b;
        Messenger messenger = this.f18067a;
        if (messenger != null) {
            messenger.send(messageObtain);
        }
    }

    public final void f0() {
        try {
            wab wabVar = this.f18080a;
            if (wabVar != null) {
                wabVar.h();
                this.f18080a = null;
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopAssistantLocation");
        }
    }

    public final void g(int i, Object obj, long j) {
        synchronized (this.f18081a) {
            if (this.f18077a != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                if (obj instanceof Bundle) {
                    messageObtain.setData((Bundle) obj);
                } else {
                    messageObtain.obj = obj;
                }
                this.f18077a.sendMessageDelayed(messageObtain, j);
            }
        }
    }

    public final void g0(AMapLocation aMapLocation) {
        try {
            if (this.e && this.f18067a != null) {
                Bundle bundle = new Bundle();
                bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f18069a));
                f(0, bundle);
                if (this.f18087b) {
                    f(13, null);
                }
                this.e = false;
            }
            Y(aMapLocation);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "resultGpsLocationSuccess");
        }
    }

    public final void i(Intent intent) {
        try {
            this.f18064a.bindService(intent, this.f18066a, 1);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl");
        }
    }

    public final void i0() {
        f(12, null);
        this.d = true;
        this.e = true;
        this.f18084a = false;
        this.h = false;
        r0();
        g gVar = this.f18072a;
        if (gVar != null) {
            gVar.b(this.f18064a);
        }
        com.autonavi.aps.amapapi.utils.f.a(this.f18064a).a();
        g.a(this.f18064a);
        g0b g0bVar = this.f18076a;
        if (g0bVar != null) {
            g0bVar.s().sendEmptyMessage(11);
        } else {
            ServiceConnection serviceConnection = this.f18066a;
            if (serviceConnection != null) {
                this.f18064a.unbindService(serviceConnection);
            }
        }
        try {
            if (this.l) {
                this.f18064a.stopService(w0());
            }
        } catch (Throwable unused) {
        }
        this.l = false;
        ArrayList<AMapLocationListener> arrayList = this.f18083a;
        if (arrayList != null) {
            arrayList.clear();
            this.f18083a = null;
        }
        this.f18066a = null;
        k0();
        e eVar = this.f18078a;
        if (eVar != null) {
            try {
                com.autonavi.aps.amapapi.utils.e.a(eVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused2) {
                this.f18078a.quit();
            }
        }
        this.f18078a = null;
        f fVar = this.f18079a;
        if (fVar != null) {
            fVar.removeCallbacksAndMessages(null);
        }
        deb debVar = this.f18074a;
        if (debVar != null) {
            debVar.e();
            this.f18074a = null;
        }
    }

    public final void j(Intent intent, boolean z) {
        Context context = this.f18064a;
        if (context != null) {
            if (!z) {
                context.startService(intent);
            } else if (!z0()) {
                Log.e("amapapi", "-------------调用后台定位服务，缺少权限：android.permission.FOREGROUND_SERVICE--------------");
                return;
            } else {
                try {
                    this.f18064a.getClass().getMethod("startForegroundService", Intent.class).invoke(this.f18064a, intent);
                } catch (Throwable unused) {
                    this.f18064a.startService(intent);
                }
            }
            this.l = true;
        }
    }

    public final void k(Bundle bundle) {
        com.autonavi.aps.amapapi.a aVar;
        AMapLocation aMapLocation;
        a8b a8bVar;
        AMapLocation aMapLocationB = null;
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                this.f18086b = bundle.getString("nb");
                aVar = (com.autonavi.aps.amapapi.a) bundle.getParcelable("statics");
                if (aMapLocation != null) {
                    try {
                        if (aMapLocation.getErrorCode() == 0 && (a8bVar = this.f18073a) != null) {
                            a8bVar.x();
                            if (!TextUtils.isEmpty(aMapLocation.getAdCode())) {
                                a8b.c = aMapLocation;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager", "resultLbsLocationSuccess");
            }
            o(aMapLocationB, aVar);
        }
        aVar = null;
        aMapLocation = null;
        a8b a8bVar2 = this.f18073a;
        aMapLocationB = a8bVar2 != null ? a8bVar2.b(aMapLocation, this.f18086b) : aMapLocation;
        o(aMapLocationB, aVar);
    }

    public final void k0() {
        synchronized (this.f18081a) {
            d dVar = this.f18077a;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
            }
            this.f18077a = null;
        }
    }

    public final void l(Message message) {
        try {
            Bundle data = message.getData();
            AMapLocation aMapLocation = (AMapLocation) data.getParcelable("loc");
            String string = data.getString("lastLocNb");
            d0(aMapLocation);
            if (this.f18074a.c(aMapLocation, string)) {
                this.f18074a.f();
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doSaveLastLocation");
        }
    }

    public final void m(WebView webView) {
        if (this.f18080a == null) {
            this.f18080a = new wab(this.f18064a, webView);
        }
        this.f18080a.c();
    }

    public final void n(AMapLocation aMapLocation) {
        try {
            if (aMapLocation.getErrorCode() != 0) {
                aMapLocation.setLocationType(0);
            }
            if (aMapLocation.getErrorCode() == 0) {
                double latitude = aMapLocation.getLatitude();
                double longitude = aMapLocation.getLongitude();
                if ((latitude == AudioStats.AUDIO_AMPLITUDE_NONE && longitude == AudioStats.AUDIO_AMPLITUDE_NONE) || latitude < -90.0d || latitude > 90.0d || longitude < -180.0d || longitude > 180.0d) {
                    g.a("errorLatLng", aMapLocation.toStr());
                    aMapLocation.setLocationType(0);
                    aMapLocation.setErrorCode(8);
                    aMapLocation.setLocationDetail("LatLng is error#0802");
                }
            }
            if ("gps".equalsIgnoreCase(aMapLocation.getProvider()) || !this.f18073a.v()) {
                aMapLocation.setAltitude(i.c(aMapLocation.getAltitude()));
                aMapLocation.setBearing(i.a(aMapLocation.getBearing()));
                aMapLocation.setSpeed(i.a(aMapLocation.getSpeed()));
                J(aMapLocation);
                Iterator<AMapLocationListener> it = this.f18083a.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onLocationChanged(aMapLocation);
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public final boolean n0() {
        boolean z = false;
        int i = 0;
        while (this.f18067a == null) {
            try {
                Thread.sleep(100L);
                i++;
                if (i >= 50) {
                    break;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "checkAPSManager");
            }
        }
        if (this.f18067a == null) {
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setErrorCode(10);
            if (i.k(this.f18064a.getApplicationContext())) {
                aMapLocation.setLocationDetail("启动ApsServcie失败#1001");
            } else {
                aMapLocation.setLocationDetail("请检查配置文件是否配置服务，并且manifest中service标签是否配置在application标签内#1003");
            }
            bundle.putParcelable("loc", aMapLocation);
            messageObtain.setData(bundle);
            messageObtain.what = 1;
            this.f18079a.sendMessage(messageObtain);
        } else {
            z = true;
        }
        if (!z) {
            if (i.k(this.f18064a.getApplicationContext())) {
                g.a((String) null, 2101);
            } else {
                g.a((String) null, 2103);
            }
        }
        return z;
    }

    public final synchronized void o(AMapLocation aMapLocation, com.autonavi.aps.amapapi.a aVar) {
        if (aMapLocation == null) {
            try {
                aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(8);
                aMapLocation.setLocationDetail("amapLocation is null#0801");
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "handlerLocation part3");
                return;
            }
        }
        if (!"gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            aMapLocation.setProvider("lbs");
        }
        if (this.f18070a == null) {
            this.f18070a = new AMapLocationQualityReport();
        }
        this.f18070a.setLocationMode(this.f18069a.getLocationMode());
        a8b a8bVar = this.f18073a;
        if (a8bVar != null) {
            this.f18070a.setGPSSatellites(a8bVar.C());
            this.f18070a.setGpsStatus(this.f18073a.A());
        }
        this.f18070a.setWifiAble(i.g(this.f18064a));
        this.f18070a.setNetworkType(i.h(this.f18064a));
        if (aMapLocation.getLocationType() == 1 || "gps".equalsIgnoreCase(aMapLocation.getProvider())) {
            this.f18070a.setNetUseTime(0L);
        }
        if (aVar != null) {
            this.f18070a.setNetUseTime(aVar.a());
        }
        this.f18070a.setInstallHighDangerMockApp(o);
        aMapLocation.setLocationQualityReport(this.f18070a);
        try {
            if (this.f18087b) {
                p(aMapLocation, this.f18086b);
                if (aVar != null) {
                    aVar.d(i.b());
                }
                g.a(this.f18064a, aMapLocation, aVar);
                g.a(this.f18064a, aMapLocation);
                T(aMapLocation.m149clone());
                com.autonavi.aps.amapapi.utils.f.a(this.f18064a).a(aMapLocation);
                com.autonavi.aps.amapapi.utils.f.a(this.f18064a).b();
            }
        } catch (Throwable th2) {
            com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "handlerLocation part2");
        }
        if (this.g) {
            return;
        }
        if (this.f18069a.isOnceLocation()) {
            r0();
            f(14, null);
        }
    }

    public final synchronized void o0() {
        int i = Build.VERSION.SDK_INT;
        if ((i < 29 && !i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || ((i < 31 && i >= 29 && !i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")) || (i >= 31 && !i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19DT0FSU0VfTE9DQVRJT04=") && !i.c(this.f18064a, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19GSU5FX0xPQ0FUSU9O")))) {
            q0();
            return;
        }
        if (this.f18069a == null) {
            this.f18069a = new AMapLocationClientOption();
        }
        if (this.f18087b) {
            return;
        }
        this.f18087b = true;
        int i2 = c.f43159a[this.f18069a.getLocationMode().ordinal()];
        long gpsFirstTimeout = 0;
        if (i2 == 1) {
            g(1027, null, 0L);
            g(1017, null, 0L);
            g(1016, null, 0L);
            return;
        }
        if (i2 == 2) {
            if (i.m(this.f18064a)) {
                d(1016);
                g(1017, null, 0L);
                g(1026, null, 0L);
                return;
            } else {
                d(1016);
                g(1027, null, 0L);
                g(1015, null, 0L);
                return;
            }
        }
        if (i2 == 3) {
            if (i.m(this.f18064a)) {
                d(1016);
                g(1017, null, 0L);
                g(1026, null, 0L);
            } else {
                g(1027, null, 0L);
                g(1015, null, 0L);
                if (this.f18069a.isGpsFirst() && this.f18069a.isOnceLocation()) {
                    gpsFirstTimeout = this.f18069a.getGpsFirstTimeout();
                }
                g(1016, null, gpsFirstTimeout);
            }
        }
    }

    public final void p(AMapLocation aMapLocation, String str) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("lastLocNb", str);
        g(1014, bundle, 0L);
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        try {
            this.f18085b = aMapLocationClientOption.m150clone();
            g(1018, aMapLocationClientOption.m150clone(), 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationOption");
        }
    }

    public final void q0() {
        AMapLocation aMapLocation = new AMapLocation("");
        aMapLocation.setErrorCode(12);
        aMapLocation.setLocationDetail("定位权限被禁用,请授予应用定位权限 #1201");
        if (this.f18070a == null) {
            this.f18070a = new AMapLocationQualityReport();
        }
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        this.f18070a = aMapLocationQualityReport;
        aMapLocationQualityReport.setGpsStatus(4);
        this.f18070a.setGPSSatellites(0);
        this.f18070a.setLocationMode(this.f18069a.getLocationMode());
        this.f18070a.setWifiAble(i.g(this.f18064a));
        this.f18070a.setNetworkType(i.h(this.f18064a));
        this.f18070a.setNetUseTime(0L);
        aMapLocation.setLocationQualityReport(this.f18070a);
        g.a((String) null, 2121);
        T(aMapLocation);
    }

    public final void r(AMapLocationListener aMapLocationListener) {
        try {
            g(1002, aMapLocationListener, 0L);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "setLocationListener");
        }
    }

    public final void r0() {
        try {
            d(1025);
            a8b a8bVar = this.f18073a;
            if (a8bVar != null) {
                a8bVar.c();
            }
            e6b e6bVar = this.f18075a;
            if (e6bVar != null) {
                e6bVar.b();
            }
            d(1016);
            this.f18087b = false;
            this.f18063a = 0;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "stopLocation");
        }
    }

    public final void s0() {
        com.autonavi.aps.amapapi.model.a aVarE = E(new com.autonavi.aps.amapapi.b(true));
        if (n0()) {
            Bundle bundle = new Bundle();
            String str = (aVarE == null || !(aVarE.getLocationType() == 2 || aVarE.getLocationType() == 4)) ? "0" : "1";
            bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f18069a));
            bundle.putString("isCacheLoc", str);
            f(0, bundle);
            if (this.f18087b) {
                f(13, null);
            }
        }
    }

    public final void t(com.autonavi.aps.amapapi.b bVar, com.autonavi.aps.amapapi.a aVar) {
        try {
            bVar.a(this.f18064a);
            bVar.a(this.f18069a);
            bVar.b(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "initApsBase");
        }
    }

    public final void t0() {
        try {
            if (m || !(this.h || this.k)) {
                m = false;
                this.k = true;
                s0();
            } else {
                try {
                    if (this.h && !C() && !this.j) {
                        this.j = true;
                        v0();
                    }
                } catch (Throwable th) {
                    this.j = true;
                    com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "doLBSLocation reStartService");
                }
                if (n0()) {
                    this.j = false;
                    Bundle bundle = new Bundle();
                    bundle.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(this.f18069a));
                    bundle.putString("d", UmidtokenInfo.getUmidtoken());
                    if (!this.f18073a.v()) {
                        f(1, bundle);
                    }
                }
            }
            try {
                if (this.f18069a.isOnceLocation()) {
                    return;
                }
                u0();
            } catch (Throwable unused) {
            }
        } catch (Throwable th2) {
            try {
                com.autonavi.aps.amapapi.utils.b.a(th2, "ALManager", "doLBSLocation");
                try {
                    if (this.f18069a.isOnceLocation()) {
                    }
                } catch (Throwable unused2) {
                }
            } finally {
                try {
                    if (!this.f18069a.isOnceLocation()) {
                        u0();
                    }
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public final void u0() {
        if (this.f18069a.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            g(1016, null, this.f18069a.getInterval() >= 1000 ? this.f18069a.getInterval() : 1000L);
        }
    }

    public final void v0() {
        try {
            if (this.b == null) {
                this.b = new Messenger(this.f18079a);
            }
            i(w0());
        } catch (Throwable unused) {
        }
    }

    public final Intent w0() {
        String apikey;
        if (this.f18065a == null) {
            this.f18065a = new Intent(this.f18064a, (Class<?>) APSService.class);
        }
        try {
            apikey = !TextUtils.isEmpty(AMapLocationClientOption.getAPIKEY()) ? AMapLocationClientOption.getAPIKEY() : j4b.j(this.f18064a);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "startServiceImpl p2");
            apikey = "";
        }
        this.f18065a.putExtra("a", apikey);
        this.f18065a.putExtra("b", j4b.g(this.f18064a));
        this.f18065a.putExtra("d", UmidtokenInfo.getUmidtoken());
        return this.f18065a;
    }

    public final void x0() {
        try {
            StringBuilder sb = new StringBuilder();
            new com.autonavi.aps.amapapi.a().f("#2001");
            sb.append("模糊权限下不支持低功耗定位#2001");
            g.a((String) null, 2153);
            com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
            aVar.setErrorCode(20);
            aVar.setLocationDetail(sb.toString());
            g0(aVar);
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "ALManager", "apsLocation:callback");
        }
    }

    public final void y0() {
        this.f18073a.u(this.f18069a);
        this.f18075a.q(this.f18069a);
        if (this.f18087b && !this.f18069a.getLocationMode().equals(this.f18068a)) {
            r0();
            o0();
        }
        this.f18068a = this.f18069a.getLocationMode();
        if (this.f18072a != null) {
            if (this.f18069a.isOnceLocation()) {
                this.f18072a.a(this.f18064a, 0);
            } else {
                this.f18072a.a(this.f18064a, 1);
            }
            this.f18072a.a(this.f18064a, this.f18069a);
        }
    }

    public final boolean z0() {
        int iB;
        if (i.j(this.f18064a)) {
            try {
                iB = com.autonavi.aps.amapapi.utils.e.b(((Application) this.f18064a.getApplicationContext()).getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
                iB = -1;
            }
            if (iB != 0) {
                return false;
            }
        }
        return true;
    }

    public class f extends Handler {
        public f(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            f fVar;
            f fVar2;
            try {
                super.handleMessage(message);
                lua luaVar = lua.this;
                if (luaVar.g) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    Message messageObtainMessage = luaVar.f18077a.obtainMessage();
                    messageObtainMessage.what = 11;
                    messageObtainMessage.setData(message.getData());
                    lua.this.f18077a.sendMessage(messageObtainMessage);
                    return;
                }
                if (i != 2) {
                    if (i == 13) {
                        com.autonavi.aps.amapapi.model.a aVar = luaVar.f18071a;
                        if (aVar != null) {
                            luaVar.n(aVar);
                            return;
                        }
                        AMapLocation aMapLocation = new AMapLocation("LBS");
                        aMapLocation.setErrorCode(33);
                        lua.this.n(aMapLocation);
                        return;
                    }
                    switch (i) {
                        case 5:
                            Bundle data = message.getData();
                            data.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(lua.this.f18069a));
                            lua.this.f(10, data);
                            return;
                        case 6:
                            Bundle data2 = message.getData();
                            a8b a8bVar = lua.this.f18073a;
                            if (a8bVar != null) {
                                a8bVar.h(data2);
                                return;
                            }
                            return;
                        case 7:
                            lua.this.f = message.getData().getBoolean("ngpsAble");
                            return;
                        case 8:
                            g.a((String) null, 2141);
                            break;
                        case 9:
                            boolean unused = lua.o = message.getData().getBoolean("installMockApp");
                            return;
                        case 10:
                            luaVar.n((AMapLocation) message.obj);
                            return;
                        default:
                            switch (i) {
                                case 100:
                                    g.a((String) null, 2155);
                                    break;
                                case 101:
                                    break;
                                case 102:
                                    Bundle data3 = message.getData();
                                    data3.putBundle("optBundle", com.autonavi.aps.amapapi.utils.b.a(lua.this.f18069a));
                                    lua.this.f(15, data3);
                                    return;
                                case 103:
                                    Bundle data4 = message.getData();
                                    if (lua.this.f18075a != null) {
                                        lua.this.f18075a.f(data4);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1028;
                            messageObtain.obj = message.obj;
                            lua.this.f18077a.sendMessage(messageObtain);
                            if (lua.this.f18085b == null || !lua.this.f18085b.getCacheCallBack() || (fVar2 = lua.this.f18079a) == null) {
                                return;
                            }
                            fVar2.removeMessages(13);
                            return;
                    }
                }
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 12;
                messageObtain2.obj = message.obj;
                lua.this.f18077a.sendMessage(messageObtain2);
                if (lua.this.f18085b == null || !lua.this.f18085b.getCacheCallBack() || (fVar = lua.this.f18079a) == null) {
                    return;
                }
                fVar.removeMessages(13);
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "AmapLocationManager$MainHandler", 0 == 0 ? "handleMessage" : null);
            }
        }

        public f() {
        }
    }
}
