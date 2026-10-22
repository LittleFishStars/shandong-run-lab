package com.kc.aw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.interf.PtgCustomController;
import com.kc.aw.lib.utils.dev.ScreenUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cc {
    public static _c9 _a;
    public static volatile _a6 _b;
    public static final AtomicBoolean _c = new AtomicBoolean(false);
    public static final AtomicLong _d = new AtomicLong(0);
    public static volatile boolean _e = false;
    public static volatile boolean _f = false;
    public static volatile boolean _g = false;

    @Keep
    public final class _a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            boolean z = true;
            try {
                if (PtgAdSdk.getContext() != null) {
                    _cc._e = Settings.Secure.getInt(PtgAdSdk.getContext().getContentResolver(), "development_settings_enabled", 0) > 0;
                }
            } catch (Exception unused) {
            }
            try {
                if (PtgAdSdk.getContext() != null) {
                    _cc._f = Settings.Secure.getInt(PtgAdSdk.getContext().getContentResolver(), "adb_enabled", 0) > 0;
                }
            } catch (Exception unused2) {
            }
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                int i = Integer.parseInt(property2);
                if (TextUtils.isEmpty(property) || i == -1) {
                    z = false;
                }
                _cc._g = z;
            } catch (Exception unused3) {
            }
            _cc._c.set(false);
        }
    }

    public static _a6 _a() {
        if (_b == null) {
            _b = new _a6();
            _a6 _a6Var = _b;
            if (TextUtils.isEmpty(_a5._c)) {
                try {
                    Context context = PtgAdSdk.getContext();
                    if (context != null) {
                        _a5._c = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                    }
                } catch (Exception unused) {
                }
            }
            _a6Var._b = _a5._c;
            _a6 _a6Var2 = _b;
            if (TextUtils.isEmpty(_a5._b)) {
                try {
                    Context context2 = PtgAdSdk.getContext();
                    if (context2 != null) {
                        _a5._b = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                    }
                } catch (Exception unused2) {
                }
            }
            _a6Var2._a = _a5._b;
            _b._c = _a5._a();
            _a6 _a6Var3 = _b;
            if (TextUtils.isEmpty(_a5._d)) {
                try {
                    Context context3 = PtgAdSdk.getContext();
                    if (context3 != null) {
                        _a5._d = context3.getPackageName();
                    }
                } catch (Exception unused3) {
                }
            }
            _a6Var3._d = _a5._d;
        }
        return _b;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0207  */
    /* JADX WARN: Code duplicated, block: B:107:0x0208 A[Catch: Exception -> 0x020f, TRY_LEAVE, TryCatch #2 {Exception -> 0x020f, blocks: (B:104:0x01f7, B:107:0x0208), top: B:236:0x01f7 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0212  */
    /* JADX WARN: Code duplicated, block: B:115:0x021d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0220 A[Catch: all -> 0x0273, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0273, blocks: (B:113:0x0217, B:122:0x0239, B:125:0x0248, B:116:0x0220, B:119:0x022e, B:127:0x024f, B:129:0x0257, B:133:0x0260), top: B:238:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x022b  */
    /* JADX WARN: Code duplicated, block: B:119:0x022e A[Catch: all -> 0x0273, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0273, blocks: (B:113:0x0217, B:122:0x0239, B:125:0x0248, B:116:0x0220, B:119:0x022e, B:127:0x024f, B:129:0x0257, B:133:0x0260), top: B:238:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:121:0x0237  */
    /* JADX WARN: Code duplicated, block: B:124:0x0247  */
    /* JADX WARN: Code duplicated, block: B:125:0x0248 A[Catch: Exception -> 0x0270, all -> 0x0273, PHI: r0
      0x0248: PHI (r0v39 android.content.pm.PackageInfo) = (r0v35 android.content.pm.PackageInfo), (r0v42 android.content.pm.PackageInfo) binds: [B:134:0x026c, B:123:0x0245] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {Exception -> 0x0270, blocks: (B:122:0x0239, B:125:0x0248, B:133:0x0260), top: B:232:0x021b }] */
    /* JADX WARN: Code duplicated, block: B:127:0x024f A[Catch: all -> 0x0273, TRY_ENTER, TryCatch #3 {all -> 0x0273, blocks: (B:113:0x0217, B:122:0x0239, B:125:0x0248, B:116:0x0220, B:119:0x022e, B:127:0x024f, B:129:0x0257, B:133:0x0260), top: B:238:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x0257 A[Catch: all -> 0x0273, TRY_LEAVE, TryCatch #3 {all -> 0x0273, blocks: (B:113:0x0217, B:122:0x0239, B:125:0x0248, B:116:0x0220, B:119:0x022e, B:127:0x024f, B:129:0x0257, B:133:0x0260), top: B:238:0x0217 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x025b  */
    /* JADX WARN: Code duplicated, block: B:132:0x025e  */
    /* JADX WARN: Code duplicated, block: B:136:0x026f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0277  */
    /* JADX WARN: Code duplicated, block: B:144:0x0280  */
    /* JADX WARN: Code duplicated, block: B:149:0x028f A[Catch: Exception -> 0x029f, TRY_LEAVE, TryCatch #1 {Exception -> 0x029f, blocks: (B:147:0x0289, B:149:0x028f), top: B:234:0x0289 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x02b2 A[Catch: Exception -> 0x02c6, TRY_LEAVE, TryCatch #6 {Exception -> 0x02c6, blocks: (B:153:0x02ac, B:155:0x02b2), top: B:243:0x02ac }] */
    /* JADX WARN: Code duplicated, block: B:161:0x02df A[Catch: Exception -> 0x02e5, TRY_LEAVE, TryCatch #7 {Exception -> 0x02e5, blocks: (B:159:0x02d9, B:161:0x02df), top: B:245:0x02d9 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:169:0x0300  */
    /* JADX WARN: Code duplicated, block: B:174:0x030f  */
    /* JADX WARN: Code duplicated, block: B:179:0x0324 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:182:0x033e  */
    /* JADX WARN: Code duplicated, block: B:234:0x0289 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x02ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:245:0x02d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static _c9 _b() {
        int i_a;
        int i;
        Context context;
        PtgCustomController ptgCustomController;
        Context context2;
        String strValueOf;
        String strValueOf2;
        PackageInfo packageInfo;
        _c9 _c9Var;
        _c9 _c9Var2;
        _c9 _c9Var3;
        Context context3;
        _nu _nuVar;
        Context context4;
        Context context5;
        Context context6;
        Context context7;
        String str;
        String str2;
        PackageInfo packageInfo2;
        String str3;
        if (_a == null) {
            _c9 _c9Var4 = new _c9();
            _a = _c9Var4;
            PtgCustomController ptgCustomController2 = PtgAdSdk.getConfig()._m;
            _c9Var4._d = (ptgCustomController2 == null || ptgCustomController2.isAllowSDKObtainAndroidId()) ? _cb._a(PtgAdSdk.getContext()) : ptgCustomController2.getMediaAndroidId();
            if (Build.VERSION.SDK_INT <= 28) {
                _c9 _c9Var5 = _a;
                PtgCustomController ptgCustomController3 = PtgAdSdk.getConfig()._m;
                _c9Var5._c = (ptgCustomController3 == null || ptgCustomController3.isAllowSDKObtainPhoneInfo()) ? "" : ptgCustomController3.getMediaDeviceImei();
            } else {
                _c9 _c9Var6 = _a;
                PtgCustomController ptgCustomController4 = PtgAdSdk.getConfig()._m;
                _c9Var6._a = (ptgCustomController4 == null || ptgCustomController4.isAllowSDKObtainOaId()) ? _hb._a : ptgCustomController4.getMediaDeviceOaId();
            }
            _c9 _c9Var7 = _a;
            PtgCustomController ptgCustomController5 = PtgAdSdk.getConfig()._m;
            _c9Var7._e = (ptgCustomController5 == null || ptgCustomController5.isAllowSDKObtainMacAddress()) ? "" : ptgCustomController5.getMediaMacAddress();
            _a._f = Build.MANUFACTURER;
            _a._g = Build.MODEL;
            _a._i = Build.VERSION.RELEASE;
            _c9 _c9Var8 = _a;
            _c9Var8._h = 1;
            try {
                i_a = _bp._a(PtgAdSdk.getContext());
            } catch (Exception unused) {
                i_a = 0;
            }
            _c9Var8._j = i_a;
            _c9 _c9Var9 = _a;
            try {
                try {
                    try {
                        String simOperator = ((TelephonyManager) PtgAdSdk.getContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
                        if (!TextUtils.isEmpty(simOperator)) {
                            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                                i = 1;
                            } else if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                                i = 2;
                            } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                                i = 3;
                            } else if ("46020".equals(simOperator)) {
                                i = 4;
                            }
                            _c9Var9._k = i;
                            _c9 _c9Var10 = _a;
                            context = PtgAdSdk.getContext();
                            if (TextUtils.isEmpty(_bp._a) && System.currentTimeMillis() - _bp._b >= 30000) {
                                _bp._b = System.currentTimeMillis();
                                try {
                                    _bp._a = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
                                } catch (Exception unused2) {
                                }
                            }
                            _c9Var10._l = _bp._a;
                            _c9 _c9Var11 = _a;
                            ptgCustomController = PtgAdSdk.getConfig()._m;
                            double longitude = AudioStats.AUDIO_AMPLITUDE_NONE;
                            if (ptgCustomController != null || ptgCustomController.isAllowSDKObtainLocation()) {
                                try {
                                    _dz _dzVar = new _dz();
                                    _dzVar._a = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    _dzVar._b = AudioStats.AUDIO_AMPLITUDE_NONE;
                                    _dzVar._c = new Date().getTime() / 1000;
                                    _a._m = _dzVar;
                                } catch (Exception unused3) {
                                }
                            } else {
                                _dz _dzVar2 = new _dz();
                                if (ptgCustomController.getMediaLocation() != null) {
                                    _dzVar2._a = ptgCustomController.getMediaLocation().getLatitude();
                                    longitude = ptgCustomController.getMediaLocation().getLongitude();
                                } else {
                                    _dzVar2._a = AudioStats.AUDIO_AMPLITUDE_NONE;
                                }
                                _dzVar2._b = longitude;
                                _dzVar2._c = new Date().getTime() / 1000;
                                _a._m = _dzVar2;
                            }
                            _c9 _c9Var12 = _a;
                            _c9Var11._m = _c9Var12._m;
                            context2 = PtgAdSdk.getContext();
                            if (TextUtils.isEmpty(_bp._a) && System.currentTimeMillis() - _bp._b >= 30000) {
                                _bp._b = System.currentTimeMillis();
                                try {
                                    _bp._a = ((TelephonyManager) context2.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
                                } catch (Exception unused4) {
                                }
                            }
                            _c9Var12._t = _bp._a;
                            _c9 _c9Var13 = _a;
                            strValueOf = null;
                            if (_lx._a()) {
                                try {
                                    packageInfo = PtgAdSdk.getContext().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                                    if (packageInfo == null) {
                                        strValueOf2 = null;
                                    } else {
                                        strValueOf2 = String.valueOf(packageInfo.versionCode);
                                    }
                                } catch (Exception unused5) {
                                }
                                if (strValueOf2 == null) {
                                    strValueOf2 = "";
                                }
                            } else {
                                strValueOf2 = "";
                            }
                            _c9Var13._w = strValueOf2;
                            _c9 _c9Var14 = _a;
                            if (_lx._a()) {
                                str3 = "com.huawei.appmarket";
                            } else {
                                str = Build.MANUFACTURER;
                                if (str.equalsIgnoreCase("vivo")) {
                                    str3 = "com.bbk.appstore";
                                } else {
                                    if (str.equalsIgnoreCase("xiaomi")) {
                                        str3 = "com.xiaomi.market";
                                    } else if (str.equalsIgnoreCase("oppo")) {
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            str2 = "com.heytap.market";
                                        } else {
                                            str2 = "com.oppo.market";
                                        }
                                        packageInfo2 = PtgAdSdk.getContext().getPackageManager().getPackageInfo(str2, 0);
                                        if (packageInfo2 != null) {
                                            strValueOf = String.valueOf(packageInfo2.versionCode);
                                        }
                                    } else {
                                        strValueOf = "";
                                    }
                                    if (strValueOf == null) {
                                        strValueOf = "";
                                    }
                                    _c9Var14._x = strValueOf;
                                    _c9Var = _a;
                                    ArrayList arrayList = _cb._b;
                                    if (_c9Var != null) {
                                        if (TextUtils.isEmpty(_a5._b)) {
                                            try {
                                                context5 = PtgAdSdk.getContext();
                                                if (context5 != null) {
                                                    _a5._b = context5.getPackageManager().getPackageInfo(context5.getPackageName(), 0).versionName;
                                                }
                                            } catch (Exception unused6) {
                                            }
                                        }
                                        _c9Var._r = _a5._b;
                                        if (TextUtils.isEmpty(_a5._c)) {
                                            try {
                                                context6 = PtgAdSdk.getContext();
                                                if (context6 != null) {
                                                    _a5._c = String.valueOf(context6.getPackageManager().getPackageInfo(context6.getPackageName(), 0).versionCode);
                                                }
                                            } catch (Exception unused7) {
                                            }
                                        }
                                        _c9Var._s = _a5._c;
                                        _c9Var._p = _a5._a();
                                        if (TextUtils.isEmpty(_a5._d)) {
                                            try {
                                                context7 = PtgAdSdk.getContext();
                                                if (context7 != null) {
                                                    _a5._d = context7.getPackageName();
                                                }
                                            } catch (Exception unused8) {
                                            }
                                        }
                                        _c9Var._q = _a5._d;
                                    }
                                    _c9Var2 = _a;
                                    if (PtgAdSdk.getContext() != null) {
                                        _nuVar = new _nu(_c9Var2);
                                        AtomicBoolean atomicBoolean = _nw._a;
                                        context4 = PtgAdSdk.getContext();
                                        if (context4 == null && _nw._b.get() <= 3 && atomicBoolean.compareAndSet(false, true)) {
                                            com.kc.aw.lib.utils._d._b(new _nv(context4, _nuVar));
                                        } else {
                                            _nw._a(_nuVar, "");
                                        }
                                    }
                                    _c9Var3 = _a;
                                    context3 = PtgAdSdk.getContext();
                                    if (context3 != null && _c9Var3 != null) {
                                        try {
                                            _c9Var3._n = ScreenUtils.getScreenRealWidth(context3);
                                            _c9Var3._o = ScreenUtils.getScreenRealHeight(context3);
                                            ScreenUtils.getWdpi(context3);
                                            ScreenUtils.getHdpi(context3);
                                            _c9Var3._y = _cd._a(context3) ? 2 : 1;
                                        } catch (Exception unused9) {
                                        }
                                    }
                                    com.kc.aw.lib.utils._d._b(new _ca(_a));
                                }
                            }
                            packageInfo2 = PtgAdSdk.getContext().getPackageManager().getPackageInfo(str3, 0);
                            if (packageInfo2 == null) {
                                strValueOf = String.valueOf(packageInfo2.versionCode);
                            }
                            if (strValueOf == null) {
                                strValueOf = "";
                            }
                            _c9Var14._x = strValueOf;
                            _c9Var = _a;
                            ArrayList arrayList2 = _cb._b;
                            if (_c9Var != null) {
                                if (TextUtils.isEmpty(_a5._b)) {
                                    context5 = PtgAdSdk.getContext();
                                    if (context5 != null) {
                                        _a5._b = context5.getPackageManager().getPackageInfo(context5.getPackageName(), 0).versionName;
                                    }
                                }
                                _c9Var._r = _a5._b;
                                if (TextUtils.isEmpty(_a5._c)) {
                                    context6 = PtgAdSdk.getContext();
                                    if (context6 != null) {
                                        _a5._c = String.valueOf(context6.getPackageManager().getPackageInfo(context6.getPackageName(), 0).versionCode);
                                    }
                                }
                                _c9Var._s = _a5._c;
                                _c9Var._p = _a5._a();
                                if (TextUtils.isEmpty(_a5._d)) {
                                    context7 = PtgAdSdk.getContext();
                                    if (context7 != null) {
                                        _a5._d = context7.getPackageName();
                                    }
                                }
                                _c9Var._q = _a5._d;
                            }
                            _c9Var2 = _a;
                            if (PtgAdSdk.getContext() != null) {
                                _nuVar = new _nu(_c9Var2);
                                AtomicBoolean atomicBoolean2 = _nw._a;
                                context4 = PtgAdSdk.getContext();
                                if (context4 == null) {
                                    _nw._a(_nuVar, "");
                                } else {
                                    com.kc.aw.lib.utils._d._b(new _nv(context4, _nuVar));
                                }
                            }
                            _c9Var3 = _a;
                            context3 = PtgAdSdk.getContext();
                            if (context3 != null) {
                                _c9Var3._n = ScreenUtils.getScreenRealWidth(context3);
                                _c9Var3._o = ScreenUtils.getScreenRealHeight(context3);
                                ScreenUtils.getWdpi(context3);
                                ScreenUtils.getHdpi(context3);
                                _c9Var3._y = _cd._a(context3) ? 2 : 1;
                            }
                            com.kc.aw.lib.utils._d._b(new _ca(_a));
                        }
                    } catch (Exception unused10) {
                    }
                    if (_lx._a()) {
                        str3 = "com.huawei.appmarket";
                    } else {
                        str = Build.MANUFACTURER;
                        if (str.equalsIgnoreCase("vivo")) {
                            str3 = "com.bbk.appstore";
                        } else {
                            if (str.equalsIgnoreCase("xiaomi")) {
                                str3 = "com.xiaomi.market";
                            } else if (str.equalsIgnoreCase("oppo")) {
                                if (Build.VERSION.SDK_INT >= 28) {
                                    str2 = "com.heytap.market";
                                } else {
                                    str2 = "com.oppo.market";
                                }
                                packageInfo2 = PtgAdSdk.getContext().getPackageManager().getPackageInfo(str2, 0);
                                if (packageInfo2 != null) {
                                    strValueOf = String.valueOf(packageInfo2.versionCode);
                                }
                            } else {
                                strValueOf = "";
                            }
                            if (strValueOf == null) {
                                strValueOf = "";
                            }
                            _c9Var14._x = strValueOf;
                            _c9Var = _a;
                            ArrayList arrayList3 = _cb._b;
                            if (_c9Var != null) {
                                if (TextUtils.isEmpty(_a5._b)) {
                                    context5 = PtgAdSdk.getContext();
                                    if (context5 != null) {
                                        _a5._b = context5.getPackageManager().getPackageInfo(context5.getPackageName(), 0).versionName;
                                    }
                                }
                                _c9Var._r = _a5._b;
                                if (TextUtils.isEmpty(_a5._c)) {
                                    context6 = PtgAdSdk.getContext();
                                    if (context6 != null) {
                                        _a5._c = String.valueOf(context6.getPackageManager().getPackageInfo(context6.getPackageName(), 0).versionCode);
                                    }
                                }
                                _c9Var._s = _a5._c;
                                _c9Var._p = _a5._a();
                                if (TextUtils.isEmpty(_a5._d)) {
                                    context7 = PtgAdSdk.getContext();
                                    if (context7 != null) {
                                        _a5._d = context7.getPackageName();
                                    }
                                }
                                _c9Var._q = _a5._d;
                            }
                            _c9Var2 = _a;
                            if (PtgAdSdk.getContext() != null) {
                                _nuVar = new _nu(_c9Var2);
                                AtomicBoolean atomicBoolean3 = _nw._a;
                                context4 = PtgAdSdk.getContext();
                                if (context4 == null) {
                                    _nw._a(_nuVar, "");
                                } else {
                                    com.kc.aw.lib.utils._d._b(new _nv(context4, _nuVar));
                                }
                            }
                            _c9Var3 = _a;
                            context3 = PtgAdSdk.getContext();
                            if (context3 != null) {
                                _c9Var3._n = ScreenUtils.getScreenRealWidth(context3);
                                _c9Var3._o = ScreenUtils.getScreenRealHeight(context3);
                                ScreenUtils.getWdpi(context3);
                                ScreenUtils.getHdpi(context3);
                                _c9Var3._y = _cd._a(context3) ? 2 : 1;
                            }
                            com.kc.aw.lib.utils._d._b(new _ca(_a));
                        }
                    }
                    packageInfo2 = PtgAdSdk.getContext().getPackageManager().getPackageInfo(str3, 0);
                    if (packageInfo2 == null) {
                        strValueOf = String.valueOf(packageInfo2.versionCode);
                    }
                } catch (Exception unused11) {
                }
                if (strValueOf == null) {
                    strValueOf = "";
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            i = 0;
            _c9Var9._k = i;
            _c9 _c9Var15 = _a;
            context = PtgAdSdk.getContext();
            if (TextUtils.isEmpty(_bp._a)) {
                _bp._b = System.currentTimeMillis();
                _bp._a = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
            }
            _c9Var15._l = _bp._a;
            _c9 _c9Var16 = _a;
            ptgCustomController = PtgAdSdk.getConfig()._m;
            double longitude2 = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (ptgCustomController != null) {
                _dz _dzVar3 = new _dz();
                _dzVar3._a = AudioStats.AUDIO_AMPLITUDE_NONE;
                _dzVar3._b = AudioStats.AUDIO_AMPLITUDE_NONE;
                _dzVar3._c = new Date().getTime() / 1000;
                _a._m = _dzVar3;
            } else {
                _dz _dzVar4 = new _dz();
                _dzVar4._a = AudioStats.AUDIO_AMPLITUDE_NONE;
                _dzVar4._b = AudioStats.AUDIO_AMPLITUDE_NONE;
                _dzVar4._c = new Date().getTime() / 1000;
                _a._m = _dzVar4;
            }
            _c9 _c9Var17 = _a;
            _c9Var16._m = _c9Var17._m;
            context2 = PtgAdSdk.getContext();
            if (TextUtils.isEmpty(_bp._a)) {
                _bp._b = System.currentTimeMillis();
                _bp._a = ((TelephonyManager) context2.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
            }
            _c9Var17._t = _bp._a;
            _c9 _c9Var18 = _a;
            strValueOf = null;
            if (_lx._a()) {
                strValueOf2 = "";
            } else {
                packageInfo = PtgAdSdk.getContext().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
                if (packageInfo == null) {
                    strValueOf2 = null;
                } else {
                    strValueOf2 = String.valueOf(packageInfo.versionCode);
                }
                if (strValueOf2 == null) {
                    strValueOf2 = "";
                }
            }
            _c9Var18._w = strValueOf2;
            _c9 _c9Var19 = _a;
            _c9Var19._x = strValueOf;
            _c9Var = _a;
            ArrayList arrayList4 = _cb._b;
            if (_c9Var != null) {
                if (TextUtils.isEmpty(_a5._b)) {
                    context5 = PtgAdSdk.getContext();
                    if (context5 != null) {
                        _a5._b = context5.getPackageManager().getPackageInfo(context5.getPackageName(), 0).versionName;
                    }
                }
                _c9Var._r = _a5._b;
                if (TextUtils.isEmpty(_a5._c)) {
                    context6 = PtgAdSdk.getContext();
                    if (context6 != null) {
                        _a5._c = String.valueOf(context6.getPackageManager().getPackageInfo(context6.getPackageName(), 0).versionCode);
                    }
                }
                _c9Var._s = _a5._c;
                _c9Var._p = _a5._a();
                if (TextUtils.isEmpty(_a5._d)) {
                    context7 = PtgAdSdk.getContext();
                    if (context7 != null) {
                        _a5._d = context7.getPackageName();
                    }
                }
                _c9Var._q = _a5._d;
            }
            _c9Var2 = _a;
            if (PtgAdSdk.getContext() != null) {
                _nuVar = new _nu(_c9Var2);
                AtomicBoolean atomicBoolean4 = _nw._a;
                context4 = PtgAdSdk.getContext();
                if (context4 == null) {
                    _nw._a(_nuVar, "");
                } else {
                    com.kc.aw.lib.utils._d._b(new _nv(context4, _nuVar));
                }
            }
            _c9Var3 = _a;
            context3 = PtgAdSdk.getContext();
            if (context3 != null) {
                _c9Var3._n = ScreenUtils.getScreenRealWidth(context3);
                _c9Var3._o = ScreenUtils.getScreenRealHeight(context3);
                ScreenUtils.getWdpi(context3);
                ScreenUtils.getHdpi(context3);
                _c9Var3._y = _cd._a(context3) ? 2 : 1;
            }
            com.kc.aw.lib.utils._d._b(new _ca(_a));
        } else if (Build.VERSION.SDK_INT <= 28) {
            if (TextUtils.isEmpty(_a._c)) {
                _c9 _c9Var20 = _a;
                PtgCustomController ptgCustomController6 = PtgAdSdk.getConfig()._m;
                _c9Var20._c = (ptgCustomController6 == null || ptgCustomController6.isAllowSDKObtainPhoneInfo()) ? "" : ptgCustomController6.getMediaDeviceImei();
            }
        } else if (TextUtils.isEmpty(_a._a)) {
            _c9 _c9Var21 = _a;
            PtgCustomController ptgCustomController7 = PtgAdSdk.getConfig()._m;
            _c9Var21._a = (ptgCustomController7 == null || ptgCustomController7.isAllowSDKObtainOaId()) ? _hb._a : ptgCustomController7.getMediaDeviceOaId();
        }
        if (TextUtils.isEmpty(_a._u)) {
            _c9 _c9Var22 = _a;
            PtgCustomController ptgCustomController8 = PtgAdSdk.getConfig()._m;
            _c9Var22._u = ptgCustomController8 != null ? ptgCustomController8.getAliBoot() : "";
        }
        if (TextUtils.isEmpty(_a._v)) {
            _c9 _c9Var23 = _a;
            PtgCustomController ptgCustomController9 = PtgAdSdk.getConfig()._m;
            _c9Var23._v = ptgCustomController9 != null ? ptgCustomController9.getAliUpdate() : "";
        }
        return _a;
    }

    public static void _c() {
        AtomicBoolean atomicBoolean = _c;
        if (atomicBoolean.get()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong = _d;
        if (jCurrentTimeMillis - atomicLong.get() < 10000) {
            return;
        }
        atomicBoolean.set(true);
        atomicLong.set(jCurrentTimeMillis);
        com.kc.aw.lib.utils._d._b(new _a());
    }
}
