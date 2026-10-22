package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.google.android.material.timepicker.TimeModel;
import com.googlecode.mp4parser.boxes.dece.BaseLocationBox;
import com.zj.adlib.u15;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g {
    private static char[] s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f26350a;
    String b;
    private Context d;
    private TelephonyManager e;
    private WifiManager g;
    private String i;
    private String j;
    private LocationClientOption k;
    private a l;
    private String n;
    private String o;
    private boolean p;
    private com.baidu.location.c.a f = new com.baidu.location.c.a();
    private com.baidu.location.c.k h = null;
    private String m = null;
    b c = new b();
    private String q = null;
    private long r = 0;
    private boolean t = false;
    private long u = 0;
    private boolean v = false;

    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    public class b extends com.baidu.location.e.f {
        LocationManager b;
        a c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f26352a = null;
        boolean d = false;

        public class a implements LocationListener {
            private a() {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                b.this.c();
                b.this.d = true;
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        }

        public b() {
            this.el = new HashMap();
        }

        private void a(BDLocation bDLocation) {
            try {
                if (bDLocation.hasAddr()) {
                    Address address = bDLocation.getAddress();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(address.country);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.countryCode);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.province);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.city);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.cityCode);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.district);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.street);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.streetNumber);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.adcode);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.town);
                    stringBuffer.append(com.alipay.sdk.m.y.l.b);
                    stringBuffer.append(address.townCode);
                    String strEncodeToString = Base64.encodeToString((System.currentTimeMillis() + LoginConstants.UNDER_LINE + stringBuffer.toString()).getBytes("UTF-8"), 0);
                    SharedPreferences sharedPreferencesA = s.a(g.this.d);
                    if (sharedPreferencesA != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                        editorEdit.putString("FirstLocAddr", strEncodeToString);
                        editorEdit.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }

        private void b() {
            try {
                this.b = (LocationManager) g.this.d.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                a aVar = new a();
                this.c = aVar;
                LocationManager locationManager = this.b;
                if (locationManager != null) {
                    try {
                        locationManager.requestLocationUpdates("network", 1000L, 0.0f, aVar, Looper.getMainLooper());
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            LocationManager locationManager;
            a aVar = this.c;
            if (aVar == null || (locationManager = this.b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.location.e.f
        public void a() {
            if (g.this.n != null && g.this.o != null) {
                this.f26352a += String.format(Locale.CHINA, "&ki=%s&sn=%s", g.this.n, g.this.o);
            }
            String str = this.f26352a + "&enc=2";
            this.f26352a = str;
            String strEncodeTp4 = Jni.encodeTp4(str);
            this.f26352a = null;
            this.el.put(BaseLocationBox.TYPE, strEncodeTp4);
            this.el.put("trtm", String.format(Locale.CHINA, TimeModel.NUMBER_FORMAT, Long.valueOf(System.currentTimeMillis())));
        }

        public void a(String str) {
            this.f26352a = str;
            b(com.baidu.location.e.d.e);
            if (g.this.t) {
                b();
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() { // from class: com.baidu.location.b.g.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b bVar = b.this;
                        if (!bVar.d) {
                            bVar.c();
                        }
                        timer.cancel();
                        timer.purge();
                    }
                }, 10000L);
                SharedPreferences.Editor editorEdit = g.this.d.getSharedPreferences("cuidRelate", 0).edit();
                editorEdit.putLong("reqtime", System.currentTimeMillis());
                editorEdit.apply();
            }
        }

        /* JADX WARN: Code duplicated, block: B:33:0x009e A[Catch: Exception -> 0x00f4, TryCatch #2 {Exception -> 0x00f4, blocks: (B:6:0x000c, B:8:0x0014, B:22:0x005f, B:24:0x0067, B:26:0x0073, B:29:0x0085, B:31:0x0092, B:33:0x009e, B:34:0x00a3, B:30:0x0089, B:35:0x00ea, B:21:0x0057, B:9:0x0019, B:16:0x003a, B:11:0x0021, B:13:0x002c, B:17:0x003d, B:19:0x0053), top: B:48:0x000c, inners: #0, #1 }] */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        
            r6 = r5.ej;
         */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(boolean z) {
            String strB;
            BDLocation bDLocation;
            String str;
            g gVar;
            if (!z || strB == null) {
                g.this.b(63);
            } else {
                try {
                    if (strB.contains("enc3")) {
                        strB = com.baidu.location.e.h.d(strB);
                    } else if (strB.contains("\"enc\"")) {
                        try {
                            JSONObject jSONObject = new JSONObject(strB);
                            if (jSONObject.has("enc")) {
                                strB = n.a().b(jSONObject.getString("enc"));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        bDLocation = new BDLocation(strB);
                        g.this.a(strB);
                        if (!g.this.k.isOnceLocation()) {
                            a(bDLocation);
                        }
                    } catch (Exception unused) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation.getLocType() == 161) {
                        if ("wgs84".equals(bDLocation.getCoorType())) {
                            if (g.this.k.coorType.equals("bd09")) {
                                str = "wgs84mc";
                            }
                            gVar = g.this;
                            if (gVar.a(gVar.k)) {
                                bDLocation.setLocType(160);
                            }
                            l.a().a(bDLocation);
                            bDLocation.setLocationID(Jni.en1(g.this.f26350a + com.alipay.sdk.m.y.l.b + g.this.b + com.alipay.sdk.m.y.l.b + bDLocation.getTime()));
                            bDLocation.setRoadLocString(0.0f, 0.0f, null, null);
                            g.this.v = true;
                            g.this.l.onReceiveLocation(bDLocation);
                        } else {
                            str = g.this.k.coorType;
                        }
                        bDLocation.setCoorType(str);
                        gVar = g.this;
                        if (gVar.a(gVar.k)) {
                            bDLocation.setLocType(160);
                        }
                        l.a().a(bDLocation);
                        bDLocation.setLocationID(Jni.en1(g.this.f26350a + com.alipay.sdk.m.y.l.b + g.this.b + com.alipay.sdk.m.y.l.b + bDLocation.getTime()));
                        bDLocation.setRoadLocString(0.0f, 0.0f, null, null);
                        g.this.v = true;
                        g.this.l.onReceiveLocation(bDLocation);
                    } else {
                        g.this.b(bDLocation.getLocType());
                    }
                } catch (Exception e2) {
                    g.this.b(63);
                    e2.printStackTrace();
                }
            }
            Map<String, Object> map = this.el;
            if (map != null) {
                map.clear();
            }
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f26355a;
        public int b;

        public c(String str, int i) {
            this.f26355a = str;
            this.b = i;
        }
    }

    public g(Context context, LocationClientOption locationClientOption, a aVar, String str, boolean z) {
        StringBuilder sb;
        String str2 = null;
        this.d = null;
        this.e = null;
        this.g = null;
        this.i = null;
        this.j = null;
        this.n = null;
        this.o = null;
        this.f26350a = null;
        this.b = null;
        this.p = false;
        Context applicationContext = context.getApplicationContext();
        this.d = applicationContext;
        try {
            com.baidu.location.e.h.aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.p = true;
        this.k = new LocationClientOption(locationClientOption);
        this.l = aVar;
        this.f26350a = this.d.getPackageName();
        this.b = null;
        try {
            this.e = (TelephonyManager) this.d.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            this.g = (WifiManager) this.d.getApplicationContext().getSystemService("wifi");
        } catch (Exception unused2) {
        }
        if (this.k.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            com.baidu.location.c.f.a().a(this.d);
        }
        this.j = "&" + this.f26350a + "&" + ((String) null);
        try {
            this.b = LBSAuthManager.getInstance(this.d).getCUID();
        } catch (Throwable unused3) {
            this.b = null;
            this.e = null;
            this.g = null;
        }
        if (this.b != null) {
            com.baidu.location.e.h.n = "" + this.b;
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.k.prodName);
            sb.append(u15.f19942b);
            sb.append(this.f26350a);
            sb.append("|&cu=");
            str2 = this.b;
        } else {
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.k.prodName);
            sb.append(u15.f19942b);
            sb.append(this.f26350a);
            sb.append("|&im=");
        }
        sb.append(str2);
        sb.append("&coor=");
        sb.append(locationClientOption.getCoorType());
        this.i = sb.toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("9.643");
        stringBuffer.append("&sdk=");
        stringBuffer.append("9.643");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append("12");
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.i += "&addr=allj2";
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.i += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.i += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.i += "aptagd2|";
            }
            this.n = com.baidu.location.a.a.b(this.d);
            this.o = com.baidu.location.a.a.c(this.d);
        }
        stringBuffer.append("&first=1");
        if (z) {
            stringBuffer.append("&state=fore");
        }
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.i += stringBuffer.toString();
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private String a(int i) {
        String strB;
        String strA;
        com.baidu.location.c.a aVar;
        try {
            com.baidu.location.c.a aVarA = com.baidu.location.c.f.a().a(this.f, this.e);
            this.f = aVarA;
            strB = (aVarA == null || !aVarA.b()) ? null : com.baidu.location.c.f.a().b(this.f);
            try {
                if (!TextUtils.isEmpty(strB) && (aVar = this.f) != null && aVar.n != null) {
                    strB = strB + this.f.n;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strB = null;
        }
        try {
            this.h = null;
            if (!a(this.g) || this.k.priority == 4) {
                strA = null;
            } else {
                this.h = new com.baidu.location.c.k(this.g.getScanResults(), 0L);
                strA = com.baidu.location.c.f.a().a(this.h, i, h(), this.t, com.baidu.location.b.a.a().b);
                try {
                    LocationClientOption locationClientOption = this.k;
                    if (locationClientOption != null && locationClientOption.isOnceLocation()) {
                        this.g.startScan();
                    }
                } catch (Exception unused3) {
                }
            }
        } catch (Exception unused4) {
        }
        if (strB == null && strA == null) {
            this.m = null;
            return null;
        }
        if (strA != null) {
            if (strB == null) {
                strB = strA;
            } else {
                strB = strB + strA;
            }
        }
        if (strB == null) {
            return null;
        }
        this.m = strB;
        if (this.i != null) {
            this.m += this.i;
        }
        j();
        return strB + this.i;
    }

    private String a(List<WifiConfiguration> list) {
        ArrayList<c> arrayList;
        int iIntValue;
        int i = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                try {
                    iIntValue = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable unused) {
                    iIntValue = 0;
                }
                if (iIntValue > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new c(str, iIntValue));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new Comparator<c>() { // from class: com.baidu.location.b.g.1
                @Override // java.util.Comparator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(c cVar, c cVar2) {
                    int i2 = cVar.b;
                    int i3 = cVar2.b;
                    if (i2 > i3) {
                        return -1;
                    }
                    return i2 == i3 ? 0 : 1;
                }
            });
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (c cVar : arrayList) {
            stringBuffer.append(cVar.f26355a);
            stringBuffer.append(",");
            stringBuffer.append(cVar.b);
            stringBuffer.append("|");
            i++;
            if (i == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((c) arrayList.get(4)).f26355a);
            stringBuffer.append(",");
            stringBuffer.append(((c) arrayList.get(4)).b);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        String[] strArrSplit;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (strArrSplit = string.split("\\|")) == null || strArrSplit.length < 2) {
                return;
            }
            int i = Integer.parseInt(strArrSplit[0]);
            long j = Long.parseLong(strArrSplit[1]);
            SharedPreferences.Editor editorEdit = this.d.getSharedPreferences("cuidRelate", 0).edit();
            editorEdit.putInt("cuidoc", i);
            editorEdit.putLong("cuidfreq", j);
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(WifiManager wifiManager) {
        try {
            return wifiManager.isWifiEnabled() || wifiManager.isScanAlwaysAvailable();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(LocationClientOption locationClientOption) {
        return locationClientOption != null && locationClientOption.isOnceLocation() && com.baidu.location.e.h.h(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        LocationClientOption locationClientOption = this.k;
        if (locationClientOption == null || !locationClientOption.isOnceLocation()) {
            return;
        }
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLocType(i);
        bDLocation.setLocationID(Jni.en1(this.f26350a + com.alipay.sdk.m.y.l.b + this.b + com.alipay.sdk.m.y.l.b + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()))));
        a aVar = this.l;
        if (aVar != null) {
            aVar.onReceiveLocation(bDLocation);
        }
    }

    private boolean i() {
        if (com.baidu.location.b.a.a().d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!com.baidu.location.e.h.b(this.d, "com.baidu.map.location")) {
                editorEdit.putInt("isInstalled", 0);
                return false;
            }
            editorEdit.putInt("isInstalled", 1);
            editorEdit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.e.h.b(this.d) >= 2 && a(this.g) && this.h.a() > 3;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0067  */
    private void j() {
        String strA;
        if (!i()) {
            this.t = false;
            return;
        }
        this.t = true;
        com.baidu.location.c.k kVar = this.h;
        if (kVar == null) {
            strA = null;
        } else if (kVar.a() >= 10) {
            String strA2 = com.baidu.location.c.f.a().a(this.h, 9, h(), this.t, com.baidu.location.b.a.a().b);
            if (TextUtils.isEmpty(strA2)) {
                strA = null;
            } else {
                strA = com.baidu.location.e.h.a(strA2.getBytes(), false);
            }
        } else {
            com.baidu.location.c.f fVarA = com.baidu.location.c.f.a();
            com.baidu.location.c.k kVar2 = this.h;
            String strA3 = fVarA.a(kVar2, kVar2.a(), h(), this.t, com.baidu.location.b.a.a().b);
            if (TextUtils.isEmpty(strA3)) {
                strA = null;
            } else {
                strA = com.baidu.location.e.h.a(strA3.getBytes(), false);
            }
        }
        String strA4 = a(k());
        String strA5 = TextUtils.isEmpty(strA4) ? null : com.baidu.location.e.h.a(strA4.getBytes(), false);
        if (TextUtils.isEmpty(strA)) {
            this.t = false;
        } else {
            this.m += "&swf5=" + strA;
            this.t = true;
        }
        if (TextUtils.isEmpty(strA5)) {
            return;
        }
        this.m += "&hwf5=" + strA5;
        this.t = true;
    }

    private List<WifiConfiguration> k() {
        try {
            WifiManager wifiManager = this.g;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void a() {
        b();
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void c() {
        int i;
        if (this.m == null) {
            int iG = com.baidu.location.e.h.g(this.d);
            if (iG == -1) {
                i = 69;
            } else if (iG == -2) {
                i = 70;
            } else {
                i = iG == 0 ? 71 : 62;
            }
            if (!a(this.k)) {
                b(i);
                return;
            }
        }
        if (a(this.k)) {
            com.baidu.location.c.c cVarA = com.baidu.location.c.c.a();
            String strB = cVarA.b(cVarA.c());
            com.baidu.location.c.c.a().b();
            if (strB == null) {
                b(62);
                return;
            }
            this.m = strB + this.i + "&per_c=1";
        }
        if (this.p) {
            if (this.d != null) {
                e.a().a(this.d);
                this.m += e.a().b();
            }
            String strB2 = com.baidu.location.a.a.a().b();
            if (strB2 != null) {
                this.m += "&ak=" + strB2 + "&aks=lbs_locsdk";
            }
            String str = this.m + "&cnloc=" + l.a().b();
            this.m = str;
            this.c.a(str);
        }
    }

    public void d() {
        if ((this.g.isWifiEnabled() || this.g.isScanAlwaysAvailable()) && this.k.priority != 4) {
            com.baidu.location.c.f.a().a(0);
        }
        if (com.baidu.location.e.h.a(this.d, "android.permission.ACCESS_FINE_LOCATION") == 1) {
            com.baidu.location.c.f.a().f();
        }
    }

    public void e() {
        com.baidu.location.c.f.a().c();
    }

    public void f() {
        com.baidu.location.c.f.a().d();
    }

    public String g() {
        WifiInfo connectionInfo;
        if (this.g == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.r > 1000 && (connectionInfo = this.g.getConnectionInfo()) != null) {
            this.q = connectionInfo.getBSSID();
            this.r = jCurrentTimeMillis;
        }
        return this.q;
    }

    public String h() {
        try {
            String strG = g();
            String strReplace = strG != null ? strG.replace(u15.f19942b, "") : null;
            if (strReplace == null || strReplace.length() == 12) {
                return new String(strReplace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
