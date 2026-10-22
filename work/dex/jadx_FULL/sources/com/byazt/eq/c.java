package com.byazt.eq;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.bt.DeviceInfoUtils;
import com.byazt.bt.a;
import com.byazt.bt.da;
import com.byazt.bt.i;
import com.byazt.bt.sl;
import com.byazt.bt.sp;
import com.byazt.dna.p;
import com.byazt.dna.u;
import com.byazt.fn.uj;
import com.byazt.lz.ve;
import com.byazt.nr.m;
import com.byazt.nr.qy;
import com.byazt.ut.ATSKeep;
import com.igexin.sdk.PushConsts;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 634, 20})
public class c implements u, Function {
    public static final int DEVICE_OS_ANDROID_TYPE = 1;
    public static final int MAIN_VERSION = 7600;
    public static volatile boolean c;
    public static AtomicBoolean mIsNeedUpdateIp = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f28479a;
    public volatile String da;
    public volatile String gr;
    public volatile String gt;
    public volatile String gu;
    public volatile String i;
    public volatile String m;
    public ve md;
    public volatile String my;
    public volatile String n;
    public volatile String nu;
    public Context p;
    public String qy;
    public volatile String rh;
    public volatile String rl;
    public volatile String sl;
    public volatile String sp;
    public volatile String t;
    public volatile String tt;
    public volatile String u;
    public volatile String uj = "";
    public volatile String ve;
    public volatile String x;
    public volatile String yp;
    public com.byazt.fn.ve yv;
    public volatile String z;
    public volatile long zm;

    public c(Context context, ve veVar) {
        this.p = context;
        this.md = veVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
        DeviceInfoUtils.c(this.p, new DeviceInfoUtils.ScreenStatusReceiver(this.md), intentFilter);
        DeviceInfoUtils.c cVar = new DeviceInfoUtils.c(this.md);
        this.yv = cVar;
        i.c(cVar, this.p);
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                qy.c();
                i.c(new tt());
            } catch (Exception unused) {
            }
        }
        com.byazt.bt.tt.c(new com.byazt.bt.tt.c() { // from class: com.byazt.eq.c.1
            @Override // com.byazt.bt.tt.c
            public void c(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                c.this.gu = str;
            }

            @Override // com.byazt.bt.tt.c
            public void tt(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                c.this.gr = str;
            }
        });
    }

    private boolean n() {
        return this.md.a() && this.md.ve() >= 7500;
    }

    private boolean uj() {
        return this.md.a() && this.md.ve() >= 7100;
    }

    private boolean ve() {
        return this.md.a() && this.md.ve() < 7600;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                ats_setAtsField((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return ats_getAtsField();
            case -1:
                release();
                return null;
            case 0:
            default:
                return null;
            case 1:
                return getAndroidId();
            case 2:
                return getDeviceModel();
            case 3:
                return getDeviceName();
            case 4:
                return getLanguage();
            case 5:
                return getLocalLanguage();
            case 6:
                return getMcc();
            case 7:
                return getMnc();
            case 8:
                return Integer.valueOf(getOs());
            case 9:
                return getOsVersion();
            case 10:
                return getTimeZone();
            case 11:
                return getVendor();
            case 12:
                return getBoot();
            case 13:
                return getCarrierName();
            case 14:
                return getCompilingTime();
            case 15:
                return getBuildSerial();
            case 16:
                return getUserAgent();
            case 17:
                return getRom();
            case 18:
                return Integer.valueOf(getTimeZoneInt());
            case 19:
                return Integer.valueOf(getDeviceType(((Boolean) sparseArray.get(1)).booleanValue()));
            case 20:
                return getWebViewUA(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                return getNewIpAddrs(((Boolean) sparseArray.get(1)).booleanValue());
            case 22:
                return getWifiMac((Boolean) sparseArray.get(1));
            case 23:
                com.byazt.fn.c location = getLocation(((Boolean) sparseArray.get(1)).booleanValue());
                return location != null ? new com.byazt.fn.tt(location) : location;
            case 24:
                return getImei((Boolean) sparseArray.get(1));
            case 25:
                return getMacAddress((Boolean) sparseArray.get(1));
            case 26:
                return getSSID((Boolean) sparseArray.get(1));
            case 27:
                return getImsi((Boolean) sparseArray.get(1));
            case 28:
                return getRomInfo();
            case 29:
                return Integer.valueOf(getDisplayDpi());
            case 30:
                return Integer.valueOf(getScreenHeight());
            case 31:
                return Integer.valueOf(getScreenWidth());
            case 32:
                return getMcc2();
            case 33:
                return getMnc2();
            case 34:
                return getAsyncWifiMac();
            case 35:
                return getSimOperator();
            case 36:
                return Integer.valueOf(getRealNetworkType(((Long) sparseArray.get(1)).longValue()));
            case 37:
                Object ujVar = sparseArray.get(1);
                if (ujVar != null) {
                    ujVar = new uj((Function) ujVar);
                }
                registerNetworkMonitor((com.byazt.fn.ve) ujVar);
                return null;
            case 38:
                Object ujVar2 = sparseArray.get(1);
                if (ujVar2 != null) {
                    ujVar2 = new uj((Function) ujVar2);
                }
                removeNetworkMonitor((com.byazt.fn.ve) ujVar2);
                return null;
            case 39:
                return getEmuiInfo();
            case 40:
                return Boolean.valueOf(isScreenOn());
            case 41:
                return Float.valueOf(getScreenBright());
            case 42:
                return getIpInfoMap(((Boolean) sparseArray.get(1)).booleanValue());
            case 43:
                return getNetworkSignalType(((Integer) sparseArray.get(1)).intValue());
            case 44:
                return getActiveSimOperatorStr();
            case 45:
                return getSimOperatorCode();
            case 46:
                return Long.valueOf(getUnlockTime());
        }
    }

    public SparseArray ats_getAtsField() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.tt);
        sparseArray.put(2, this.ve);
        sparseArray.put(3, this.uj);
        sparseArray.put(4, this.n);
        sparseArray.put(5, this.f28479a);
        sparseArray.put(6, this.sp);
        sparseArray.put(7, this.x);
        sparseArray.put(8, this.i);
        sparseArray.put(9, this.da);
        sparseArray.put(10, this.sl);
        sparseArray.put(11, this.t);
        sparseArray.put(12, this.u);
        sparseArray.put(13, this.yp);
        sparseArray.put(14, this.z);
        sparseArray.put(15, this.m);
        sparseArray.put(16, this.nu);
        sparseArray.put(18, this.rh);
        sparseArray.put(19, this.my);
        sparseArray.put(20, this.gt);
        sparseArray.put(21, this.rl);
        sparseArray.put(24, this.qy);
        sparseArray.put(25, mIsNeedUpdateIp);
        sparseArray.put(26, this.gu);
        sparseArray.put(27, this.gr);
        sparseArray.put(28, Long.valueOf(this.zm));
        return sparseArray;
    }

    public void ats_setAtsField(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.tt = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.ve = (String) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            this.uj = (String) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            this.n = (String) obj4;
        }
        Object obj5 = sparseArray.get(5);
        if (obj5 != null) {
            this.f28479a = (String) obj5;
        }
        Object obj6 = sparseArray.get(6);
        if (obj6 != null) {
            this.sp = (String) obj6;
        }
        Object obj7 = sparseArray.get(7);
        if (obj7 != null) {
            this.x = (String) obj7;
        }
        Object obj8 = sparseArray.get(8);
        if (obj8 != null) {
            this.i = (String) obj8;
        }
        Object obj9 = sparseArray.get(9);
        if (obj9 != null) {
            this.da = (String) obj9;
        }
        Object obj10 = sparseArray.get(10);
        if (obj10 != null) {
            this.sl = (String) obj10;
        }
        Object obj11 = sparseArray.get(11);
        if (obj11 != null) {
            this.t = (String) obj11;
        }
        Object obj12 = sparseArray.get(12);
        if (obj12 != null) {
            this.u = (String) obj12;
        }
        Object obj13 = sparseArray.get(13);
        if (obj13 != null) {
            this.yp = (String) obj13;
        }
        Object obj14 = sparseArray.get(14);
        if (obj14 != null) {
            this.z = (String) obj14;
        }
        Object obj15 = sparseArray.get(15);
        if (obj15 != null) {
            this.m = (String) obj15;
        }
        Object obj16 = sparseArray.get(16);
        if (obj16 != null) {
            this.nu = (String) obj16;
        }
        Object obj17 = sparseArray.get(18);
        if (obj17 != null) {
            this.rh = (String) obj17;
        }
        Object obj18 = sparseArray.get(19);
        if (obj18 != null) {
            this.my = (String) obj18;
        }
        Object obj19 = sparseArray.get(20);
        if (obj19 != null) {
            this.gt = (String) obj19;
        }
        Object obj20 = sparseArray.get(21);
        if (obj20 != null) {
            this.rl = (String) obj20;
        }
        Object obj21 = sparseArray.get(24);
        if (obj21 != null) {
            this.qy = (String) obj21;
        }
        Object obj22 = sparseArray.get(25);
        if (obj22 != null) {
            mIsNeedUpdateIp = (AtomicBoolean) obj22;
        }
        Object obj23 = sparseArray.get(26);
        if (obj23 != null) {
            this.gu = (String) obj23;
        }
        Object obj24 = sparseArray.get(27);
        if (obj24 != null) {
            this.gr = (String) obj24;
        }
        Object obj25 = sparseArray.get(28);
        if (obj25 != null) {
            this.zm = ((Long) obj25).longValue();
        }
    }

    @Override // com.byazt.dna.u
    public String getActiveSimOperatorStr() {
        return sp.c(this.p, this.md.c());
    }

    @Override // com.byazt.dna.u
    public String getAndroidId() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getAndroidId();
        }
        if (!TextUtils.isEmpty(this.tt)) {
            return this.tt;
        }
        com.byazt.lz.c customController = this.md.c().getCustomController();
        if (customController != null && !customController.isCanUseAndroidId()) {
            return customController.getAndroidId();
        }
        if (c) {
            return this.tt;
        }
        synchronized (this) {
            if (c) {
                return this.tt;
            }
            this.tt = com.byazt.bt.ve.ve(this.p);
            c = true;
            return this.tt;
        }
    }

    @Override // com.byazt.dna.u
    public String getAsyncWifiMac() {
        return com.byazt.bt.ve.tt(this.md.c(), this.p);
    }

    @Override // com.byazt.dna.u
    public String getBoot() {
        String string;
        double dCurrentTimeMillis = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d;
        try {
            string = new Formatter().format("%.6f", Double.valueOf(dCurrentTimeMillis)).toString();
        } catch (Exception unused) {
            string = "";
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return new DecimalFormat("#0.000000").format(dCurrentTimeMillis);
        } catch (Exception unused2) {
            return string;
        }
    }

    @Override // com.byazt.dna.u
    public String getBuildSerial() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getBuildSerial();
        }
        if (TextUtils.isEmpty(this.u)) {
            this.u = com.byazt.bt.ve.c(this.md.c());
        }
        return this.u;
    }

    @Override // com.byazt.dna.u
    public String getCarrierName() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getCarrierName();
        }
        if (TextUtils.isEmpty(this.yp)) {
            this.yp = com.byazt.bt.ve.i(this.md.c(), this.p);
        }
        return this.yp;
    }

    @Override // com.byazt.dna.u
    public String getCompilingTime() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getCompilingTime();
        }
        if (TextUtils.isEmpty(this.z)) {
            this.z = String.valueOf(Build.TIME);
        }
        return this.z;
    }

    @Override // com.byazt.dna.u
    public String getDeviceModel() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getDeviceModel();
        }
        if (TextUtils.isEmpty(this.ve)) {
            this.ve = Build.MODEL;
        }
        return this.ve;
    }

    @Override // com.byazt.dna.u
    public String getDeviceName() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getDeviceName();
        }
        if (this.p == null) {
            return "";
        }
        if (!TextUtils.isEmpty(this.uj)) {
            return this.uj;
        }
        this.uj = Settings.Global.getString(this.p.getContentResolver(), "device_name");
        return this.uj;
    }

    @Override // com.byazt.dna.u
    public int getDeviceType(boolean z) {
        p pVarTt;
        return (uj() && ve() && (pVarTt = tt()) != null) ? pVarTt.getDeviceType(z) : DeviceInfoUtils.c(this.p, z, this.md.c(), this.md.tt());
    }

    @Override // com.byazt.dna.u
    public int getDisplayDpi() {
        return sl.tt(this.p);
    }

    @Override // com.byazt.dna.u
    public String getEmuiInfo() {
        return a.tt(this.md.c());
    }

    @Override // com.byazt.dna.u
    public String getImei(Boolean bool) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getImei(bool);
        }
        if (TextUtils.isEmpty(this.i)) {
            this.i = com.byazt.bt.ve.c(bool, this.md.c(), this.p);
        }
        return this.i;
    }

    @Override // com.byazt.dna.u
    public String getImsi(Boolean bool) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getImsi(bool);
        }
        if (TextUtils.isEmpty(this.t)) {
            this.t = com.byazt.bt.ve.tt(bool, this.md.c(), this.p);
        }
        return this.t;
    }

    @Override // com.byazt.dna.u
    public Map<String, String> getIpInfoMap(boolean z) {
        return com.byazt.bt.tt.c(z, this.md.c(), this.md.n(), this.md.tt(), this.md);
    }

    @Override // com.byazt.dna.u
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.byazt.dna.u
    public String getLocalLanguage() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    @Override // com.byazt.dna.u
    public com.byazt.fn.c getLocation(boolean z) {
        p pVarTt;
        return (uj() && ve() && (pVarTt = tt()) != null) ? pVarTt.getLocation() : com.byazt.bt.c.c(this.p, z, this.md.c(), this.md.tt());
    }

    @Override // com.byazt.dna.u
    public String getMacAddress(Boolean bool) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getMacAddress(bool);
        }
        if (TextUtils.isEmpty(this.rl)) {
            this.rl = com.byazt.bt.ve.c(bool, this.md.c(), this.md.n(), this.md.tt(), this.md);
        }
        return this.rl;
    }

    @Override // com.byazt.dna.u
    public String getMcc() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getMcc();
        }
        if (TextUtils.isEmpty(this.n)) {
            this.n = com.byazt.bt.ve.n(this.md.c(), this.p);
        }
        return this.n;
    }

    @Override // com.byazt.dna.u
    public String getMcc2() {
        p pVarTt;
        if (n() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getMcc2();
        }
        if (TextUtils.isEmpty(this.sp)) {
            this.sp = com.byazt.bt.ve.a(this.md.c(), this.p);
        }
        return this.sp;
    }

    @Override // com.byazt.dna.u
    public String getMnc() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getMnc();
        }
        if (TextUtils.isEmpty(this.f28479a)) {
            this.f28479a = com.byazt.bt.ve.sp(this.md.c(), this.p);
        }
        return this.f28479a;
    }

    @Override // com.byazt.dna.u
    public String getMnc2() {
        p pVarTt;
        if (n() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getMnc2();
        }
        if (TextUtils.isEmpty(this.x)) {
            this.x = com.byazt.bt.ve.x(this.md.c(), this.p);
        }
        return this.x;
    }

    @Override // com.byazt.dna.u
    public String getNetworkSignalType(int i) {
        return DeviceInfoUtils.c(i, this.md.c(), this.p);
    }

    @Override // com.byazt.dna.u
    public String[] getNewIpAddrs(boolean z) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getNewIpAddrs(z);
        }
        if (c()) {
            return new String[]{this.gu, this.gr};
        }
        String[] strArrC = com.byazt.bt.tt.c(z, mIsNeedUpdateIp, this.md.c(), this.md.n(), this.md.tt(), this.md);
        this.zm = System.currentTimeMillis();
        if (strArrC.length >= 2) {
            this.gu = strArrC[0];
            this.gr = strArrC[1];
        }
        return strArrC;
    }

    @Override // com.byazt.dna.u
    public int getOs() {
        return 1;
    }

    @Override // com.byazt.dna.u
    public String getOsVersion() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getOsVersion();
        }
        if (TextUtils.isEmpty(this.m)) {
            this.m = Build.VERSION.RELEASE;
        }
        return this.m;
    }

    @Override // com.byazt.dna.u
    public int getRealNetworkType(long j) {
        return i.c(this.p, j);
    }

    @Override // com.byazt.dna.u
    public String getRom() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getRom();
        }
        if (TextUtils.isEmpty(this.my)) {
            this.my = a.c(this.md.c());
        }
        return this.my;
    }

    @Override // com.byazt.dna.u
    public String getRomInfo() {
        if (TextUtils.isEmpty(this.qy)) {
            this.qy = a.ve();
        }
        return this.qy;
    }

    @Override // com.byazt.dna.u
    public String getSSID(Boolean bool) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getSSID(bool);
        }
        if (TextUtils.isEmpty(this.da)) {
            this.da = com.byazt.bt.ve.ve(bool, this.md.c(), this.p);
        }
        return this.da;
    }

    @Override // com.byazt.dna.u
    public float getScreenBright() {
        return DeviceInfoUtils.sp(this.p);
    }

    @Override // com.byazt.dna.u
    public int getScreenHeight() {
        return sl.uj(this.p);
    }

    @Override // com.byazt.dna.u
    public int getScreenWidth() {
        return sl.ve(this.p);
    }

    @Override // com.byazt.dna.u
    public String getSimOperator() {
        return com.byazt.bt.ve.uj(this.md.c(), this.p);
    }

    @Override // com.byazt.dna.u
    public String getSimOperatorCode() {
        return sp.c(this.md.c(), this.p);
    }

    @Override // com.byazt.dna.u
    public String getTimeZone() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable th) {
            m.c(th);
            return "";
        }
    }

    @Override // com.byazt.dna.u
    public int getTimeZoneInt() {
        return DeviceInfoUtils.c();
    }

    @Override // com.byazt.dna.u
    public long getUnlockTime() {
        return DeviceInfoUtils.tt();
    }

    @Override // com.byazt.dna.u
    public String getUserAgent() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getUserAgent();
        }
        if (TextUtils.isEmpty(this.rh)) {
            this.rh = da.c();
        }
        return this.rh;
    }

    @Override // com.byazt.dna.u
    public String getVendor() {
        p pVarTt;
        if (ve() && (pVarTt = tt()) != null) {
            return pVarTt.getVendor();
        }
        if (TextUtils.isEmpty(this.nu)) {
            this.nu = Build.MANUFACTURER;
        }
        return this.nu;
    }

    @Override // com.byazt.dna.u
    public String getWebViewUA(boolean z) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null && !z) {
            return pVarTt.getWebViewUA();
        }
        if (TextUtils.isEmpty(this.gt)) {
            this.gt = da.c(this.p, this.md.c(), z, this.md.x(), this.md.tt());
        }
        return this.gt;
    }

    @Override // com.byazt.dna.u
    public String getWifiMac(Boolean bool) {
        p pVarTt;
        if (uj() && ve() && (pVarTt = tt()) != null) {
            return pVarTt.getWifiMac(bool);
        }
        if (TextUtils.isEmpty(this.sl)) {
            this.sl = com.byazt.bt.ve.uj(bool, this.md.c(), this.p);
        }
        return this.sl;
    }

    @Override // com.byazt.dna.u
    public boolean isScreenOn() {
        return DeviceInfoUtils.a(this.p);
    }

    @Override // com.byazt.dna.u
    public void registerNetworkMonitor(com.byazt.fn.ve veVar) {
        i.c(veVar, this.p);
    }

    public void release() {
        DeviceInfoUtils.ve(this.p);
        DeviceInfoUtils.uj(this.p);
        DeviceInfoUtils.n(this.p);
        com.byazt.bt.tt.c((com.byazt.bt.tt.c) null);
        i.c(this.yv);
        this.yv = null;
    }

    @Override // com.byazt.dna.u
    public void removeNetworkMonitor(com.byazt.fn.ve veVar) {
        i.c(veVar);
    }

    private boolean c() {
        return (mIsNeedUpdateIp.get() || DeviceInfoUtils.c(this.zm, 1800000L) || TextUtils.isEmpty(this.gu)) ? false : true;
    }

    private p tt() {
        return (p) com.byazt.ut.uj.getService("device_info");
    }
}
