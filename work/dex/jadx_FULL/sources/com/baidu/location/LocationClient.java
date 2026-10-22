package com.baidu.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.b.g;
import com.baidu.location.b.o;
import com.baidu.location.e.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class LocationClient implements g.a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    private static boolean I = false;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_FINE_PERMISSION = 10;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_COARSE_FAIL = 11;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private static String x;
    private Boolean A;
    private Boolean B;
    private Boolean C;
    private boolean D;
    private g E;
    private boolean F;
    private boolean G;
    private boolean H;
    private String J;
    private ServiceConnection K;
    private LocationClientOption c;
    private LocationClientOption d;
    private Context f;
    private a h;
    private final Messenger i;
    private String w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f26321a = 0;
    private String b = null;
    private boolean e = false;
    private Messenger g = null;
    private ArrayList<BDLocationListener> j = null;
    private ArrayList<BDAbstractLocationListener> k = null;
    private BDLocation l = null;
    private BDLocation m = null;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private b q = null;
    private boolean r = false;
    private final Object s = new Object();
    private long t = 0;
    private long u = 0;
    private String v = null;
    private boolean y = false;
    private boolean z = true;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<LocationClient> f26324a;

        public a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.f26324a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LocationClient locationClient = this.f26324a.get();
            if (locationClient == null) {
                return;
            }
            int i = message.what;
            boolean z = true;
            if (i == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.G && locationClient.F && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.G && locationClient.F) {
                    locationClient.G = true;
                    return;
                }
                if (!locationClient.G) {
                    locationClient.G = true;
                }
                locationClient.a(message, 21);
                return;
            }
            try {
                if (i == 303) {
                    Bundle data2 = message.getData();
                    int i2 = data2.getInt("loctype");
                    int i3 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i2 <= 0 || i3 <= 0 || byteArray == null || locationClient.k == null) {
                        return;
                    }
                    Iterator it = locationClient.k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i2, i3, new String(byteArray, "UTF-8"));
                    }
                    return;
                }
                if (i == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                    int i4 = data3.getInt("hotspot", -1);
                    if (locationClient.k != null) {
                        Iterator it2 = locationClient.k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i4);
                        }
                        return;
                    }
                    return;
                }
                if (i == 701) {
                    locationClient.b((BDLocation) message.obj);
                    return;
                }
                if (i == 1300) {
                    locationClient.c(message);
                    return;
                }
                if (i == 1400) {
                    locationClient.d(message);
                    return;
                }
                if (i != 54) {
                    z = false;
                    if (i != 55) {
                        if (i == 703) {
                            Bundle data4 = message.getData();
                            int i5 = data4.getInt("id", 0);
                            if (i5 > 0) {
                                locationClient.a(i5, (Notification) data4.getParcelable("notification"));
                                return;
                            }
                            return;
                        }
                        if (i == 704) {
                            locationClient.a(message.getData().getBoolean("removenotify"));
                            return;
                        }
                        switch (i) {
                            case 1:
                                locationClient.a();
                                break;
                            case 2:
                                locationClient.b();
                                break;
                            case 3:
                                locationClient.a(message);
                                break;
                            case 4:
                                locationClient.e();
                                break;
                            case 5:
                                locationClient.b(message);
                                break;
                            case 6:
                                locationClient.e(message);
                                break;
                            default:
                                super.handleMessage(message);
                                break;
                        }
                        return;
                    }
                    if (!locationClient.c.location_change_notify) {
                        return;
                    }
                } else if (!locationClient.c.location_change_notify) {
                    return;
                }
                locationClient.r = z;
            } catch (Exception unused) {
            }
        }
    }

    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.s) {
                LocationClient.this.p = false;
                if (LocationClient.this.g != null && LocationClient.this.i != null) {
                    if ((LocationClient.this.j != null && LocationClient.this.j.size() >= 1) || (LocationClient.this.k != null && LocationClient.this.k.size() >= 1)) {
                        if (!LocationClient.this.o) {
                            LocationClient.this.h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (LocationClient.this.q == null) {
                            LocationClient locationClient = LocationClient.this;
                            locationClient.q = locationClient.new b();
                        }
                        LocationClient.this.h.postDelayed(LocationClient.this.q, LocationClient.this.c.scanSpan);
                    }
                }
            }
        }
    }

    public class c extends Thread {
        private c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (LocationClient.this.d.isOnceLocation()) {
                    com.baidu.location.c.c.a().b(LocationClient.this.f);
                }
                com.baidu.location.a.a.a().d();
                if (LocationClient.this.C.booleanValue()) {
                    if (LocationClient.this.E == null) {
                        com.baidu.location.c.f.a().b();
                        LocationClient.this.E = new g(LocationClient.this.f, LocationClient.this.d, LocationClient.this, null, false);
                    }
                    LocationClient locationClient = LocationClient.this;
                    locationClient.J = locationClient.E.g();
                    if (LocationClient.this.d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        LocationClient.this.E.d();
                        LocationClient.this.E.e();
                    }
                }
                LocationClient.this.h.obtainMessage(1).sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public LocationClient(Context context) throws Exception {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        Boolean bool = Boolean.FALSE;
        this.A = bool;
        this.B = bool;
        this.C = Boolean.TRUE;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = false;
        this.J = null;
        this.K = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.g = new Messenger(iBinder);
                if (LocationClient.this.g == null) {
                    return;
                }
                LocationClient.this.e = true;
                if (LocationClient.this.z) {
                    LocationClient.this.h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message messageObtain = Message.obtain((Handler) null, 11);
                    messageObtain.replyTo = LocationClient.this.i;
                    messageObtain.setData(LocationClient.this.d());
                    LocationClient.this.g.send(messageObtain);
                    LocationClient.this.e = true;
                    if (LocationClient.this.c != null) {
                        LocationClient.this.C.booleanValue();
                        LocationClient.this.h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.g = null;
                LocationClient.this.e = false;
            }
        };
        c();
        this.f = context;
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        this.c = new LocationClientOption();
        this.d = new LocationClientOption();
        this.f = null;
        Boolean bool = Boolean.FALSE;
        this.A = bool;
        this.B = bool;
        this.C = Boolean.TRUE;
        this.E = null;
        this.F = false;
        this.G = false;
        this.H = false;
        this.J = null;
        this.K = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LocationClient.this.g = new Messenger(iBinder);
                if (LocationClient.this.g == null) {
                    return;
                }
                LocationClient.this.e = true;
                if (LocationClient.this.z) {
                    LocationClient.this.h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message messageObtain = Message.obtain((Handler) null, 11);
                    messageObtain.replyTo = LocationClient.this.i;
                    messageObtain.setData(LocationClient.this.d());
                    LocationClient.this.g.send(messageObtain);
                    LocationClient.this.e = true;
                    if (LocationClient.this.c != null) {
                        LocationClient.this.C.booleanValue();
                        LocationClient.this.h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.g = null;
                LocationClient.this.e = false;
            }
        };
        c();
        this.f = context;
        this.c = locationClientOption;
        this.d = new LocationClientOption(locationClientOption);
        this.h = new a(Looper.getMainLooper(), this);
        this.i = new Messenger(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e) {
            return;
        }
        if (this.C.booleanValue()) {
            boolean zC = h.c(this.f);
            if (this.d.isOnceLocation()) {
                zC = true;
            }
            if (zC) {
                try {
                    new Thread() { // from class: com.baidu.location.LocationClient.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                if (LocationClient.this.E != null) {
                                    if (h.g(LocationClient.this.f) > 0) {
                                        LocationClient.this.E.a();
                                    }
                                    LocationClient.this.E.c();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }.start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.d.isOnceLocation()) {
            return;
        }
        this.C = Boolean.FALSE;
        this.b = this.f.getPackageName();
        this.v = this.b + "_bdls_v2.9";
        Intent intent = new Intent(this.f, (Class<?>) f.class);
        try {
            intent.putExtra("debug_dev", this.D);
        } catch (Exception unused2) {
        }
        if (this.c == null) {
            this.c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.c.isIgnoreKillProcess);
        intent.putExtra("auth_key", x);
        intent.putExtra("proxyHost", this.c.mProxyHost);
        intent.putExtra("proxyPort", this.c.mProxyPort);
        intent.putExtra("username", this.c.mUsername);
        intent.putExtra("password", this.c.mPassword);
        intent.putExtra("cuid", LBSAuthManager.getInstance(this.f).getCUID());
        try {
            this.f.bindService(intent, this.K, 1);
        } catch (Exception e) {
            e.printStackTrace();
            this.e = false;
        }
    }

    private void a(int i) {
        if (this.l.getCoorType() == null) {
            this.l.setCoorType(this.c.coorType);
        }
        if (this.n || ((this.c.location_change_notify && this.l.getLocType() == 61) || this.l.getLocType() == 66 || this.l.getLocType() == 67 || this.y || this.l.getLocType() == 161)) {
            ArrayList<BDLocationListener> arrayList = this.j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.l);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.l);
                }
            }
            if (this.l.getLocType() == 66 || this.l.getLocType() == 67) {
                return;
            }
            this.n = false;
            this.u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Notification notification) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i);
            intent.putExtra(com.heytap.mcssdk.constant.b.y, 1);
            this.f.startForegroundService(intent);
            this.H = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Object obj;
        this.o = false;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) obj;
        if (this.c.optionEquals(locationClientOption)) {
            return;
        }
        if (this.c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.s) {
                    try {
                        if (this.p) {
                            this.h.removeCallbacks(this.q);
                            this.p = false;
                        }
                        if (locationClientOption.scanSpan >= 1000 && !this.p) {
                            if (this.q == null) {
                                this.q = new b();
                            }
                            this.h.postDelayed(this.q, locationClientOption.scanSpan);
                            this.p = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.c = new LocationClientOption(locationClientOption);
        if (this.g != null && h.g(this.f) >= 1) {
            try {
                Message messageObtain = Message.obtain((Handler) null, 15);
                messageObtain.replyTo = this.i;
                messageObtain.setData(d());
                this.g.send(messageObtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i) {
        if (this.e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.t = System.currentTimeMillis();
                }
                if (this.l.getLocType() == 61 || this.l.getLocType() == 161) {
                    com.baidu.location.b.a.a().a(this.l.getLatitude(), this.l.getLongitude(), this.l.getCoorType());
                }
                a(i);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            Intent intent = new Intent(this.f, (Class<?>) f.class);
            intent.putExtra("removenotify", z);
            intent.putExtra(com.heytap.mcssdk.constant.b.y, 2);
            this.f.startService(intent);
            this.H = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (!this.e || this.g == null) {
            return;
        }
        Message messageObtain = Message.obtain((Handler) null, 12);
        messageObtain.replyTo = this.i;
        try {
            this.g.send(messageObtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.f.unbindService(this.K);
            if (this.H) {
                try {
                    this.f.stopService(new Intent(this.f, (Class<?>) f.class));
                } catch (Exception unused) {
                }
                this.H = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.s) {
            try {
                if (this.p) {
                    this.h.removeCallbacks(this.q);
                    this.p = false;
                }
            } catch (Exception unused3) {
            }
        }
        this.g = null;
        this.o = false;
        this.y = false;
        this.e = false;
        this.F = false;
        this.G = false;
        this.C = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        if (this.j.contains(bDLocationListener)) {
            return;
        }
        this.j.add(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BDLocation bDLocation) {
        if (this.z) {
            return;
        }
        this.l = bDLocation;
        if (!this.G && bDLocation.getLocType() == 161) {
            this.F = true;
            com.baidu.location.b.a.a().a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().c()) {
            ArrayList<BDLocationListener> arrayList = this.j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(bDLocation);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(bDLocation);
                }
                return;
            }
            return;
        }
        if (this.m == null) {
            BDLocation bDLocation2 = new BDLocation();
            this.m = bDLocation2;
            bDLocation2.setLocType(505);
        }
        ArrayList<BDLocationListener> arrayList3 = this.j;
        if (arrayList3 != null) {
            Iterator<BDLocationListener> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                it3.next().onReceiveLocation(this.m);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList4 = this.k;
        if (arrayList4 != null) {
            Iterator<BDAbstractLocationListener> it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                it4.next().onReceiveLocation(this.m);
            }
        }
    }

    private void c() throws Exception {
        if (I) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        if (this.k == null) {
            this.k = new ArrayList<>();
        }
        if (this.k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d() {
        if (this.c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.b);
        bundle.putString("prodName", this.c.prodName);
        bundle.putString("coorType", this.c.coorType);
        bundle.putString("addrType", this.c.addrType);
        bundle.putBoolean("openGPS", this.c.openGps);
        bundle.putBoolean("location_change_notify", this.c.location_change_notify);
        bundle.putInt("scanSpan", this.c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.c.enableSimulateGps);
        bundle.putInt("timeOut", this.c.timeOut);
        bundle.putInt("priority", this.c.priority);
        bundle.putBoolean("map", this.A.booleanValue());
        bundle.putBoolean("import", this.B.booleanValue());
        bundle.putBoolean("needDirect", this.c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.c.b());
        bundle.putInt("wifitimeout", this.c.wifiCacheTimeOut);
        bundle.putInt("wfnum", com.baidu.location.b.a.a().b);
        bundle.putBoolean("ischeckper", com.baidu.location.b.a.a().f26330a);
        bundle.putFloat("wfsm", (float) com.baidu.location.b.a.a().c);
        bundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f);
        bundle.putInt("gnmcon", com.baidu.location.b.a.a().g);
        bundle.putInt("iupl", com.baidu.location.b.a.a().h);
        bundle.putInt("lpcs", com.baidu.location.b.a.a().e);
        bundle.putInt("hpdts", com.baidu.location.b.a.a().o);
        bundle.putInt("oldts", com.baidu.location.b.a.a().p);
        bundle.putInt("onic", com.baidu.location.b.a.a().q);
        bundle.putInt("nlcs", com.baidu.location.b.a.a().r);
        bundle.putFloat("ncsr", com.baidu.location.b.a.a().s);
        bundle.putFloat("cscr", com.baidu.location.b.a.a().t);
        bundle.putString("connectBssid", this.J);
        bundle.putInt("cls", com.baidu.location.b.a.a().u);
        bundle.putIntArray("ocs", com.baidu.location.b.a.a().v);
        bundle.putInt("topCellNumber", com.baidu.location.b.a.a().w);
        bundle.putInt("locStrLength", com.baidu.location.b.a.a().x);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.k.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        int i;
        if (this.g == null) {
            return;
        }
        int iG = h.g(this.f);
        if ((System.currentTimeMillis() - this.t > 3000 || !this.c.location_change_notify || this.o) && iG == 1) {
            if (!this.y || System.currentTimeMillis() - this.u > 20000 || this.o) {
                Message messageObtain = Message.obtain((Handler) null, 22);
                if (this.o) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.o);
                    this.o = false;
                    messageObtain.setData(bundle);
                }
                try {
                    messageObtain.replyTo = this.i;
                    this.g.send(messageObtain);
                    this.f26321a = System.currentTimeMillis();
                    this.n = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (iG < 1) {
            BDLocation bDLocation = new BDLocation();
            if (iG == -1) {
                i = 69;
            } else if (iG == -2) {
                i = 70;
            } else {
                if (iG == 0) {
                    i = 71;
                }
                a(bDLocation);
            }
            bDLocation.setLocType(i);
            a(bDLocation);
        }
        synchronized (this.s) {
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption != null && locationClientOption.scanSpan >= 1000 && !this.p) {
                if (this.q == null) {
                    this.q = new b();
                }
                this.h.postDelayed(this.q, this.c.scanSpan);
                this.p = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        ArrayList<BDLocationListener> arrayList = this.j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.j.remove(bDLocationListener);
    }

    private void f() {
        LocationClientOption locationClientOption = this.d;
        if (locationClientOption == null) {
            return;
        }
        h.aZ = locationClientOption.mProxyHost;
        h.ba = locationClientOption.mProxyPort;
        h.bb = locationClientOption.mUsername;
        h.bc = locationClientOption.mPassword;
    }

    private void g() {
        LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(I);
        com.baidu.location.a.a.a().a(this.f, x);
        com.baidu.location.a.a.a().a(this.f);
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(dArrCoorEncrypt[1]);
        bDLocation2.setLongitude(dArrCoorEncrypt[0]);
        return bDLocation2;
    }

    public static void setAgreePrivacy(boolean z) {
        I = z;
    }

    public static void setKey(String str) {
        x = str;
    }

    public void disableAssistantLocation() {
        o.a().b();
    }

    public void disableLocInForeground(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z);
        Message messageObtainMessage = this.h.obtainMessage(704);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        o.a().a(this.f, webView, this);
    }

    public void enableLocInForeground(int i, Notification notification) {
        if (i <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i);
        bundle.putParcelable("notification", notification);
        Message messageObtainMessage = this.h.obtainMessage(703);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            String strB = com.baidu.location.a.a.b(this.f);
            this.w = strB;
            if (TextUtils.isEmpty(strB)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s", this.w);
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.l;
    }

    public LocationClientOption getLocOption() {
        return this.c;
    }

    public String getVersion() {
        return "9.6.4.3";
    }

    public boolean isStarted() {
        return this.e;
    }

    public void onReceiveLightLocString(String str) {
    }

    @Override // com.baidu.location.b.g.a
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.G || this.F) && bDLocation != null) {
            Message messageObtainMessage = this.h.obtainMessage(701);
            messageObtainMessage.obj = bDLocation;
            messageObtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(1300);
        messageObtainMessage.obj = bDAbstractLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(5);
        messageObtainMessage.obj = bDLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.g != null && this.e) {
            try {
                this.g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.g == null || this.i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.k) == null || arrayList.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f26321a < 1000) {
            return 6;
        }
        this.o = true;
        Message messageObtainMessage = this.h.obtainMessage(4);
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.z = false;
        this.h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.d = new LocationClientOption(locationClientOption);
        Message messageObtainMessage = this.h.obtainMessage(3);
        messageObtainMessage.obj = locationClientOption;
        messageObtainMessage.sendToTarget();
    }

    public void start() {
        this.z = false;
        f();
        g();
        LBSAuthManager.getInstance(this.f.getApplicationContext()).setPrivacyMode(I);
        com.baidu.location.b.a.a().a(this.f, this.d, (String) null);
        new c().start();
    }

    public void stop() {
        this.z = true;
        this.h.obtainMessage(2).sendToTarget();
        g gVar = this.E;
        if (gVar != null) {
            gVar.f();
            this.E = null;
        }
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(1400);
        messageObtainMessage.obj = bDAbstractLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.h.obtainMessage(6);
        messageObtainMessage.obj = bDLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.g == null || this.i == null || location == null) {
            return false;
        }
        try {
            Message messageObtain = Message.obtain((Handler) null, 57);
            messageObtain.obj = location;
            this.g.send(messageObtain);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
