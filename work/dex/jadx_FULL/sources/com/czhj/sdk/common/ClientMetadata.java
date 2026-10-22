package com.czhj.sdk.common;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowInsets;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.czhj.devicehelper.DeviceHelper;
import com.czhj.devicehelper.cnoaid.c;
import com.czhj.sdk.common.Database.SQLiteMTAHelper;
import com.czhj.sdk.common.Database.SQLiteTrackHelper;
import com.czhj.sdk.common.ThreadPool.RepeatingHandlerRunnable;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.models.Config;
import com.czhj.sdk.common.mta.BuriedPointManager;
import com.czhj.sdk.common.network.SigmobRequestUtil;
import com.czhj.sdk.common.track.TrackManager;
import com.czhj.sdk.common.utils.AESUtil;
import com.czhj.sdk.common.utils.AdvertisingId;
import com.czhj.sdk.common.utils.AppPackageUtil;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.sdk.common.utils.IdentifierManager;
import com.czhj.sdk.common.utils.ResourceUtil;
import com.czhj.sdk.common.utils.RomUtils;
import com.czhj.sdk.common.utils.SharedPreferencesUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.huachenjie.common.constants.UserConstants;
import com.kc.openset.constant.DeviceIdType;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ClientMetadata implements IdentifierManager.AdvertisingIdChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f29377a = new AtomicInteger(1);
    private static String b = "-1";
    private static String c;
    private static volatile ClientMetadata d;
    private static String g;
    private int A;
    private boolean B;
    private long C;
    private Location e;
    private IdentifierManager f;
    private int h;
    private String j;
    private String k;
    private String l;
    private String m;
    private Context n;
    private boolean o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private long u;
    private int v;
    private int w;
    private Display x;
    private RepeatingHandlerRunnable y;
    private boolean i = true;
    private boolean z = false;

    public enum a {
        FORCE_PORTRAIT(RVParams.LONG_PORTRAIT),
        FORCE_LANDSCAPE("landscape"),
        DEVICE_ORIENTATION("device"),
        UNDEFINED("");

        private final String mKey;

        a(String str) {
            this.mKey = str;
        }
    }

    private String b() {
        if (!TextUtils.isEmpty(this.q)) {
            return this.q;
        }
        try {
            DeviceHelper.getOAID(this.n, new com.czhj.devicehelper.msaoaId.a.InterfaceC0616a() { // from class: com.czhj.sdk.common.ClientMetadata.1
                @Override // com.czhj.devicehelper.msaoaId.a.InterfaceC0616a
                public void a(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        ClientMetadata.this.q = str;
                        if (!str.equalsIgnoreCase(ClientMetadata.this.p)) {
                            SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.n).edit();
                            editorEdit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                            editorEdit.apply();
                        }
                    }
                    ClientMetadata.this.z = true;
                }
            });
        } catch (Throwable unused) {
        }
        return this.q;
    }

    private String c() {
        try {
            if (Build.VERSION.SDK_INT > 28 && !Config.sharedInstance().getOaidApiDisable()) {
                if (!TextUtils.isEmpty(this.s)) {
                    return this.s;
                }
                if (this.A <= 10 && !this.B && System.currentTimeMillis() - this.C >= 1000) {
                    this.C = System.currentTimeMillis();
                    this.B = true;
                    this.A++;
                    com.czhj.devicehelper.cnoaid.a.a(this.n, new c() { // from class: com.czhj.sdk.common.ClientMetadata.2
                        @Override // com.czhj.devicehelper.cnoaid.c
                        public void a(Exception exc) {
                            ClientMetadata.this.B = false;
                        }

                        @Override // com.czhj.devicehelper.cnoaid.c
                        public void a(String str) {
                            ClientMetadata.this.B = false;
                            if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(ClientMetadata.this.s)) {
                                return;
                            }
                            ClientMetadata.this.s = str;
                            if (str.equalsIgnoreCase(ClientMetadata.this.p)) {
                                return;
                            }
                            SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(ClientMetadata.this.n).edit();
                            editorEdit.putString("oaid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                            editorEdit.apply();
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private boolean d() {
        return !this.n.getPackageManager().queryIntentActivities(new Intent("android.settings.USAGE_ACCESS_SETTINGS"), 65536).isEmpty();
    }

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f29377a;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static Long getBootSystemTime() {
        return Long.valueOf(DeviceUtils.getBootSystemTime());
    }

    public static String getCPUInfo() {
        try {
            return DeviceUtils.getCPUInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getCPUModel() {
        return Build.BOARD;
    }

    public static String getCell_ip() {
        return DeviceUtils.getCell_ip();
    }

    public static String getDeviceBrand() {
        return DeviceUtils.getDeviceBrand();
    }

    public static String getDeviceManufacturer() {
        return DeviceUtils.getDeviceManufacturer();
    }

    public static String getDeviceModel() {
        return DeviceUtils.getDeviceModel();
    }

    public static Integer getDeviceOSLevel() {
        return Integer.valueOf(DeviceUtils.getDeviceOSLevel());
    }

    public static String getDeviceOsVersion() {
        return DeviceUtils.getDeviceOsVersion();
    }

    public static ClientMetadata getInstance() {
        if (d == null) {
            synchronized (ClientMetadata.class) {
                if (d == null) {
                    d = new ClientMetadata();
                }
            }
        }
        return d;
    }

    public static String getMacAddress() {
        try {
            return DeviceHelper.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static PackageInfo getPackageInfoWithUri(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> getQueryParamMap(Uri uri) {
        HashMap map = new HashMap();
        for (String str : uri.getQueryParameterNames()) {
            map.put(str, TextUtils.join(",", uri.getQueryParameters(str)));
        }
        return map;
    }

    public static String getUid() {
        return g;
    }

    public static String getUserId() {
        return TextUtils.isEmpty(b) ? "-1" : b;
    }

    public static String getVAID() {
        try {
            return DeviceHelper.getVAID();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isEmulator() {
        try {
            return DeviceUtils.isEmulator();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isPermissionGranted(Context context, String str) {
        return context != null && context.checkSelfPermission(str) == 0;
    }

    public static boolean isRoot() {
        try {
            return DeviceUtils.isRoot();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setOAIDCertPem(String str) {
        try {
            com.czhj.devicehelper.msaoaId.a.a(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setOaidCertFileName(String str) {
        try {
            com.czhj.devicehelper.msaoaId.a.b(str);
        } catch (Throwable unused) {
            SigmobLog.e("not support OAID Module");
        }
    }

    public static void setUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = str;
    }

    public DownloadManager a() {
        return (DownloadManager) this.n.getSystemService("download");
    }

    public int getActiveNetworkType() {
        try {
            return DeviceUtils.getActiveNetworkType().getId();
        } catch (Throwable unused) {
            return DeviceUtils.NetworkType.UNKNOWN.getId();
        }
    }

    public String getAdvertisingId() {
        return null;
    }

    public String getAndroidId() {
        try {
            return DeviceUtils.getAndroidId(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkMd5() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.n, "MD5");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApkSha1() {
        try {
            return DeviceUtils.getApkSha1OrMd5(this.n, "SHA1");
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppName() {
        return AppPackageUtil.getAppName(this.n);
    }

    public String getAppPackageName() {
        try {
            return AppPackageUtil.getAppPackageName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getAppVersion() {
        try {
            return AppPackageUtil.getAppVersionFromContext(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Float getBatteryLevel() {
        try {
            return Float.valueOf(DeviceUtils.getBatteryLevel(this.n));
        } catch (Throwable unused) {
            return Float.valueOf(0.0f);
        }
    }

    public Boolean getBatterySaveEnable() {
        try {
            return Boolean.valueOf(DeviceUtils.getBatterySaveEnable(this.n));
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    public Integer getBatteryState() {
        try {
            return Integer.valueOf(DeviceUtils.getBatteryState(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getBlueToothName() {
        try {
            return DeviceUtils.getBlueToothName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getBootId() {
        try {
            if (Config.sharedInstance().isDisableBootMark()) {
                return "";
            }
            if (TextUtils.isEmpty(c)) {
                return c;
            }
            String strReplaceAll = c.replaceAll("\\s*|\t|\r|\n", "");
            c = strReplaceAll;
            if (strReplaceAll.length() > 36) {
                c = c.substring(0, 36);
            }
            SigmobLog.i("getBootId: bootId = " + c);
            return c;
        } catch (Throwable th) {
            SigmobLog.e("getBootId: error = " + th.getMessage());
        }
    }

    public Context getContext() {
        return this.n;
    }

    public int getDensityDpi() {
        try {
            return (int) DeviceUtils.getDensityDpi(this.n);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceId() {
        try {
            return getDeviceId(-1);
        } catch (Throwable th) {
            SigmobLog.e("getDeviceId:" + th.getMessage());
            return null;
        }
    }

    public synchronized String getDeviceId(int i) {
        try {
            if (TextUtils.isEmpty(this.j) && Build.VERSION.SDK_INT < 29) {
                if (DeviceUtils.isCanUsePhoneState(this.n) && DeviceUtils.isCanRetryIMEI()) {
                    this.j = DeviceHelper.getIMEI(this.n);
                    this.k = DeviceHelper.getIMEI(this.n, 0);
                    this.l = DeviceHelper.getIMEI(this.n, 1);
                }
                return null;
            }
            if (i == -1) {
                return this.j;
            }
            if (i == 0) {
                return this.k;
            }
            return this.l;
        } catch (Throwable th) {
            SigmobLog.e("getDeviceId:" + th.getMessage());
            return null;
        }
    }

    public Locale getDeviceLocale() {
        try {
            return DeviceUtils.getDeviceLocale(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getDeviceName() {
        try {
            return DeviceUtils.getDeviceName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenHeightDip(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public Integer getDeviceScreenRealHeightDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealHeightDip(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenRealWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenRealWidthDip(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer getDeviceScreenWidthDip() {
        try {
            return Integer.valueOf(DeviceUtils.getDeviceScreenWidthDip(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getDeviceSerial() {
        try {
            return DeviceUtils.getDeviceSerial();
        } catch (Throwable unused) {
            return null;
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        try {
            return DeviceUtils.getDisplayMetrics(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getIMSI() {
        try {
            return DeviceHelper.getIMSI(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getInsetBottom() {
        return this.h;
    }

    public long getInstallTime() {
        return this.u;
    }

    public boolean getLimitAdTrackingEnabled() {
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public Location getLocation() {
        try {
            if (!this.o) {
                return null;
            }
            Location location = this.e;
            if (location != null) {
                return location;
            }
            LocationManager locationManager = getLocationManager();
            if (locationManager != null && DeviceUtils.isCanRetryLocation()) {
                SigmobLog.d("private :use_location ");
                Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
                if (lastKnownLocation != null) {
                    this.e = lastKnownLocation;
                }
            }
        } catch (Exception unused) {
        }
        return this.e;
    }

    public LocationManager getLocationManager() {
        try {
            if (DeviceUtils.isCanUseLocation(this.n)) {
                return (LocationManager) this.n.getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
            }
            return null;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public String getNetworkOperatorForUrl() {
        try {
            return DeviceUtils.getNetworkOperatorForUrl(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getNetworkOperatorName() {
        try {
            return DeviceUtils.getNetworkOperatorName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getOAID() {
        int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
        boolean oaidApiDisable = Config.sharedInstance().getOaidApiDisable();
        if ((disable_up_OAid < 0 || disable_up_OAid > 1) && oaidApiDisable) {
            return null;
        }
        String oaid_sdk = getOAID_SDK();
        if (TextUtils.isEmpty(oaid_sdk) && this.z) {
            oaid_sdk = c();
        }
        if (TextUtils.isEmpty(oaid_sdk) || oaid_sdk.equalsIgnoreCase(this.p)) {
            return this.p;
        }
        this.p = oaid_sdk;
        return oaid_sdk;
    }

    public String getOAID_API() {
        return this.s;
    }

    public String getOAID_SDK() {
        try {
            int disable_up_OAid = Config.sharedInstance().getDisable_up_OAid();
            if (disable_up_OAid != 0) {
                if (disable_up_OAid == 1) {
                    return b();
                }
            } else if (Build.VERSION.SDK_INT > 28) {
                return b();
            }
        } catch (Throwable unused) {
        }
        this.B = true;
        return null;
    }

    public Integer getOrientationInt() {
        try {
            return Integer.valueOf(DeviceUtils.getOrientationInt(this.n));
        } catch (Throwable unused) {
            return 0;
        }
    }

    public String getPermission(Context context) {
        StringBuilder sb;
        String string = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            String[] strArr = packageManager.getPackageInfo(packageName, 4096).requestedPermissions;
            for (int i = 0; i < strArr.length; i++) {
                if (packageManager.checkPermission(strArr[i], packageName) == 0) {
                    if (i == strArr.length - 1) {
                        sb = new StringBuilder();
                        sb.append(string);
                        sb.append(strArr[i]);
                    } else {
                        sb = new StringBuilder();
                        sb.append(string);
                        sb.append(strArr[i]);
                        sb.append(",");
                    }
                    string = sb.toString();
                }
            }
            SigmobLog.d("permissionReq:" + string);
            if (!TextUtils.isEmpty(string)) {
                return Base64.encodeToString(string.getBytes(), 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return string;
    }

    public DisplayMetrics getRealMetrics() {
        try {
            return DeviceUtils.getRealMetrics(this.n);
        } catch (Throwable unused) {
            return DeviceUtils.getDisplayMetrics(this.n);
        }
    }

    public String getRotation() {
        try {
            return DeviceUtils.getRotation(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getSDCardPath() {
        try {
            return DeviceUtils.getSDCardPath(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getScreenOrientation(Context context) {
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            return 0;
        }
        return display.getRotation();
    }

    public String getStringResources(String str, String str2) {
        return ResourceUtil.getString(this.n, str, str2, new Object[0]);
    }

    public String getStringResources(String str, String str2, Object... objArr) {
        return ResourceUtil.getString(this.n, str, str2, objArr);
    }

    public int getStyleResources(String str) {
        return ResourceUtil.getStyleId(this.n, str);
    }

    public Long getSystemTotalMemorySize() {
        try {
            return Long.valueOf(DeviceUtils.getSysteTotalMemorySize(this.n));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getTargetSdkVersion() {
        try {
            if (!TextUtils.isEmpty(this.t)) {
                return this.t;
            }
            String strValueOf = String.valueOf(this.n.getApplicationInfo().targetSdkVersion);
            this.t = strValueOf;
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getUDID() {
        String str = this.r;
        if (str != null) {
            return str;
        }
        this.r = UUID.randomUUID().toString();
        SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
        editorEdit.putString("sig_UDID", this.r);
        editorEdit.apply();
        return this.r;
    }

    public String getUpdateId() {
        try {
            if (Config.sharedInstance().isDisableBootMark()) {
                return "";
            }
        } catch (Throwable th) {
            SigmobLog.e("getUpdateId: error = " + th.getMessage());
        }
        return this.m;
    }

    public String getWifiName() {
        try {
            return DeviceHelper.getWifiName(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getWifimac() {
        try {
            return DeviceHelper.getWifimac(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public synchronized void initialize(Context context) {
        String str;
        if (this.n == null) {
            Context applicationContext = context.getApplicationContext();
            this.n = applicationContext;
            long j = SharedPreferencesUtil.getSharedPreferences(applicationContext).getLong("install_time", 0L);
            this.u = j;
            if (j == 0) {
                PackageInfo packageInfo = AppPackageUtil.getPackageInfo(context);
                this.u = packageInfo == null ? System.currentTimeMillis() / 1000 : packageInfo.firstInstallTime / 1000;
                SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                editorEdit.putLong("install_time", this.u);
                editorEdit.apply();
            }
            this.r = SharedPreferencesUtil.getSharedPreferences(this.n).getString("sig_UDID", null);
            String string = SharedPreferencesUtil.getSharedPreferences(this.n).getString("uid_aes_gcm", null);
            if (string != null) {
                g = AESUtil.DecryptString(string, Constants.AESKEY);
            } else {
                String string2 = SharedPreferencesUtil.getSharedPreferences(this.n).getString(UserConstants.URL_PARAMS.b, null);
                g = string2;
                if (string2 != null) {
                    SharedPreferences.Editor editorEdit2 = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                    editorEdit2.remove(UserConstants.URL_PARAMS.b);
                    editorEdit2.putString("uid_aes_gcm", AESUtil.EncryptString(g, Constants.AESKEY));
                    editorEdit2.apply();
                }
            }
            String string3 = SharedPreferencesUtil.getSharedPreferences(this.n).getString("oaid_aes_gcm", null);
            if (string3 != null) {
                this.p = AESUtil.DecryptString(string3, Constants.AESKEY);
            } else {
                String string4 = SharedPreferencesUtil.getSharedPreferences(this.n).getString(DeviceIdType.OAID, null);
                this.p = string4;
                if (string4 != null) {
                    SharedPreferences.Editor editorEdit3 = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                    editorEdit3.remove(DeviceIdType.OAID);
                    editorEdit3.putString("oaid_aes_gcm", AESUtil.EncryptString(this.p, Constants.AESKEY));
                    editorEdit3.apply();
                }
            }
            this.f = new IdentifierManager(this.n, this);
            SQLiteMTAHelper.initialize(this.n);
            SQLiteTrackHelper.initialize(this.n);
            BuriedPointManager.getInstance().start();
            try {
                DeviceUtils.registerNetworkChange(this.n);
            } catch (Exception e) {
                if ((e.getMessage() == null || !e.getMessage().contains("Too many requests")) && !e.getClass().getSimpleName().equals("TooManyRequestsException")) {
                    str = "Failed to register network monitoring: " + e.getMessage();
                } else {
                    str = "Failed to register network monitoring: registration limit exceeded - " + e.getMessage();
                }
                SigmobLog.e(str);
            } catch (Throwable th) {
                str = "Failed to register network monitoring: " + th.getMessage();
                SigmobLog.e(str);
            }
            TrackManager.getInstance().startRetryTracking();
            ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new Runnable() { // from class: com.zj.adlib.em1
                @Override // java.lang.Runnable
                public final void run() {
                    RomUtils.getRomInfo();
                }
            });
        }
    }

    public boolean isNetworkConnected(String str) {
        try {
            return SigmobRequestUtil.isConnection(new URL(str).getHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean isRetryAble() {
        return this.i;
    }

    public boolean isSDCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public boolean isTablet() {
        try {
            return DeviceUtils.isTablet(this.n);
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.czhj.sdk.common.utils.IdentifierManager.AdvertisingIdChangeListener
    public void onIdChanged(AdvertisingId advertisingId, AdvertisingId advertisingId2) {
    }

    public void setEnableLocation(boolean z) {
        this.o = z;
    }

    public void setLocation(Location location) {
        this.e = location;
    }

    public void setRetryAble(boolean z) {
        this.i = z;
    }

    public void setUid(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(g) || !str.equalsIgnoreCase(g)) {
                g = str;
                SharedPreferences.Editor editorEdit = SharedPreferencesUtil.getSharedPreferences(this.n).edit();
                editorEdit.putString("uid_aes_gcm", AESUtil.EncryptString(str, Constants.AESKEY));
                editorEdit.apply();
            }
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
        }
    }

    public void setWindInsets(WindowInsets windowInsets) {
        if (windowInsets == null || !windowInsets.isRound()) {
            return;
        }
        this.h = windowInsets.getSystemWindowInsetBottom();
    }
}
