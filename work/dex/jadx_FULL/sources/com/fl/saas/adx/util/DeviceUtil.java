package com.fl.saas.adx.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import cn.hzjizhun.admin.util.ShellUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.fl.saas.AbstractC1412h0;
import com.fl.saas.C1428p0;
import com.fl.saas.C1432r0;
import com.fl.saas.S0;
import com.fl.saas.adx.base.bean.CustomLocation;
import com.fl.saas.adx.util.DeviceUtil;
import com.fl.saas.b1;
import com.fl.saas.c1;
import com.gyf.immersionbar.b;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.c49;
import com.zj.adlib.gm2;
import com.zj.adlib.xh9;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DeviceUtil {
    private static String HmsVersionCode = null;
    private static final Map<String, String[]> MARKETS;
    private static String MARKET_CODE = null;
    public static String appId = "";
    public static String channelId = "";
    public static C1432r0 controlBean = null;
    public static String customConfig = null;
    public static CustomLocation customLocation = null;
    private static String customizeId = null;
    public static int filling_timing = 0;
    private static List<String> materialAdvList = null;
    private static Context sContext = null;
    public static ImageView.ScaleType scaleType = null;
    private static int[] screenPx = null;
    public static String subChannel = "";
    public static String userExt = "";
    public static ConcurrentHashMap<String, Object> customMap = new ConcurrentHashMap<>();
    public static boolean isCanUseBootID = true;
    public static boolean isCanUseSSID = true;
    public static boolean isCanUseAndroid = true;
    public static boolean isCanUseMac = true;
    public static boolean isCanUseIMEI = true;
    public static boolean isCanUseIMSI = true;
    public static boolean isCanUseLocation = true;
    public static boolean personalizedState = true;
    public static boolean enableCollectAppInstallStatus = true;
    public static boolean isInitializeGDT = true;
    public static boolean isInitializeKS = true;
    public static boolean isInitializeBD = true;
    public static boolean isInitializeCSJ = true;
    public static boolean isInitializeQTT = true;
    public static String sourceTag = "";
    public static boolean isGetImei = false;
    public static String deviceImei = "";
    public static boolean isGetAndroidID = false;
    public static String deviceAndroidID = "";
    public static boolean isGetMac = false;
    public static boolean deviceHasAccelerometerSensor = false;
    public static boolean isCanUseSensor = false;
    public static String deviceMac = "";
    public static JSONArray appList = null;
    public static long totalRAM = 0;
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static String imsi = "";
    private static boolean hasGetImsi = false;
    private static boolean isLoadOperators = false;
    private static String operatorId = "0";
    public static String userAgent = "";
    private static Long autoNum = 0L;

    static {
        HashMap map = new HashMap();
        MARKETS = map;
        String[] strArr = {"com.heytap.market", "com.oppo.market"};
        map.put("OPPO", strArr);
        map.put("OnePlus", strArr);
        map.put("realme", strArr);
        map.put("Xiaomi", new String[]{"com.xiaomi.market"});
        map.put("Meizu", new String[]{"com.meizu.mstore"});
        map.put("vivo", new String[]{"com.bbk.appstore"});
        map.put("HUAWEI", new String[]{"com.huawei.appmarket"});
        map.put("HONOR", new String[]{"com.huawei.appmarket", "com.hihonor.appmarket"});
        map.put("SAM_SUNG", new String[]{"com.sec.android.app.samsungapps"});
        map.put("lenovo", new String[]{"com.lenovo.leos.appstore"});
        map.put("LE_TV", new String[]{"com.letv.app.appstore"});
        MARKET_CODE = null;
        HmsVersionCode = null;
        try {
            System.loadLibrary("flupdatemark");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean checkAccelerometerSensor(Context context) {
        if (context == null) {
            return true;
        }
        try {
            Iterator<Sensor> it = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).iterator();
            while (it.hasNext()) {
                if (it.next().getType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkApkExist(String str) {
        if (sContext != null && str != null && !"".equals(str)) {
            try {
                PackageManager packageManager = sContext.getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                packageManager.getApplicationInfo(str, 8192);
                return true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static boolean deviceCanHandleIntent(Intent intent) {
        try {
            return !sContext.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public static int dip2px(float f) {
        Context context = sContext;
        if (context == null || f == 0.0f) {
            return 0;
        }
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String directGetAgVersionCode() {
        String str = MARKET_CODE;
        if (str != null) {
            return str;
        }
        String str2 = "";
        MARKET_CODE = "";
        if (sContext == null) {
            return "";
        }
        try {
            String deviceMANUFACTURER = getDeviceMANUFACTURER();
            for (Map.Entry<String, String[]> entry : MARKETS.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(deviceMANUFACTURER)) {
                    String[] value = entry.getValue();
                    for (String str3 : value) {
                        String versionCode = getVersionCode(sContext, str3);
                        MARKET_CODE = versionCode;
                        if (!TextUtils.isEmpty(versionCode)) {
                            break;
                        }
                    }
                    String str4 = MARKET_CODE;
                    if (str4 != null) {
                        str2 = str4;
                    }
                    MARKET_CODE = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return MARKET_CODE;
    }

    public static String directGetHmsVersionCode() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        String str = HmsVersionCode;
        if (str != null) {
            return str;
        }
        try {
            HmsVersionCode = getVersionCode(context, "com.huawei.hwid");
        } catch (Exception unused) {
            HmsVersionCode = "";
        }
        if (HmsVersionCode == null) {
            HmsVersionCode = "";
        }
        return HmsVersionCode;
    }

    public static ArrayList<View> getAllChildren(View view) {
        ArrayList<View> arrayList = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                arrayList.add(childAt);
                arrayList.addAll(getAllChildren(childAt));
            }
        }
        return arrayList;
    }

    public static String getAndroidID() {
        if (sContext == null) {
            return "";
        }
        if (isGetAndroidID) {
            return deviceAndroidID;
        }
        C1432r0 c1432r0 = controlBean;
        if (c1432r0 != null) {
            if (!c1432r0.a()) {
                return "";
            }
        } else if (!isCanUseAndroid) {
            return "";
        }
        String string = Settings.Secure.getString(sContext.getContentResolver(), "android_id");
        deviceAndroidID = string;
        isGetAndroidID = true;
        return string;
    }

    public static JSONObject getAppInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", appId);
            jSONObject.putOpt(xh9.WEBSITE_PARAMS_CHANNEL, channelId);
            jSONObject.putOpt("sub_channel", subChannel);
            jSONObject.putOpt("source_tag", sourceTag);
            jSONObject.putOpt("name", getAppName());
            jSONObject.putOpt("bundle", getMyPackageName());
            jSONObject.putOpt("version", getVersionName());
            jSONObject.putOpt("installDate", Long.valueOf(getSelfInstallTimeMillis()));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static String getAppName() {
        PackageInfo packageInfo;
        return (sContext == null || (packageInfo = getPackageInfo()) == null) ? "" : sContext.getPackageManager().getApplicationLabel(packageInfo.applicationInfo).toString();
    }

    public static Application getApplication() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Field declaredField = cls.getDeclaredField("mInitialApplication");
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null).invoke(null, null);
            declaredField.setAccessible(true);
            return (Application) declaredField.get(objInvoke);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Long getAutoNum() {
        Long l = autoNum;
        autoNum = Long.valueOf(l.longValue() + 1);
        return l;
    }

    public static String getBootId() {
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            line = bufferedReader.readLine();
            bufferedReader.close();
            return line;
        } catch (Throwable th) {
            th.printStackTrace();
            return line;
        }
    }

    public static String getBootMark() {
        C1432r0 c1432r0 = controlBean;
        if (c1432r0 != null) {
            return c1432r0.b() ? getBootId() : "";
        }
        return isCanUseBootID ? getBootId() : "";
    }

    public static long getBootTime() {
        try {
            return SystemClock.elapsedRealtime();
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getCustomizeId() {
        String str;
        if (TextUtils.isEmpty(customizeId)) {
            String strA = S0.a().a("customizeId", "");
            customizeId = strA;
            if (TextUtils.isEmpty(strA)) {
                String androidID = getAndroidID();
                if (TextUtils.isEmpty(androidID)) {
                    str = UUID.randomUUID().toString() + getUpdateMark();
                } else {
                    str = androidID + getUpdateMark();
                }
                customizeId = str;
                S0.a().b("customizeId", customizeId);
            }
        }
        return customizeId;
    }

    public static String getDate() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static JSONObject getDeviceInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ua", getUserAgent());
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("osv", getDeviceSystemVersion());
            jSONObject.putOpt("devicetype", Integer.valueOf(isTablet() ? 1 : 0));
            jSONObject.putOpt("connectiontype", getNetworkType());
            jSONObject.putOpt("carrier", getOperators());
            jSONObject.putOpt("orientation", Integer.valueOf(getOrientation()));
            jSONObject.putOpt("sw", Integer.valueOf(getMobileWidth()));
            jSONObject.putOpt(ShellUtils.COMMAND_SH, Integer.valueOf(getMobileHeight()));
            jSONObject.putOpt("brand", getDeviceBrand());
            jSONObject.putOpt(ze1.k, getDeviceModel());
            jSONObject.putOpt("density", Float.valueOf(getScreenDensity()));
            jSONObject.putOpt("densityDpi", Integer.valueOf(getDpi()));
            jSONObject.putOpt(DeviceIdType.IMEI, getImei());
            jSONObject.putOpt(DeviceIdType.OAID, OaidUtils.getOaid());
            jSONObject.putOpt("androidid", getAndroidID());
            jSONObject.putOpt("mac", getMacAddress());
            jSONObject.putOpt("mark", getDeviceMANUFACTURER());
            jSONObject.putOpt("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("oaidmd5", AbstractC1412h0.a(OaidUtils.getOaid()));
            jSONObject.putOpt("imeimd5", AbstractC1412h0.a(getImei()));
            jSONObject.putOpt("androididmd5", AbstractC1412h0.a(getAndroidID()));
            jSONObject.putOpt("macmd5", AbstractC1412h0.a(getMacAddress()));
            try {
                jSONObject.putOpt("boot_mark", getBootMark());
                jSONObject.putOpt("update_mark", getUpdateMark());
            } catch (Throwable th) {
                th.printStackTrace();
            }
            jSONObject.putOpt("physical_memory_byte", Long.valueOf(getMemoryByte()));
            jSONObject.putOpt("verCodeOfHms", directGetHmsVersionCode());
            try {
                jSONObject.putOpt("verCodeOfAG", directGetAgVersionCode());
            } catch (Throwable unused) {
            }
            jSONObject.putOpt("customizeId", getCustomizeId());
            if (customLocation != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("lon", Double.valueOf(customLocation.getLng()));
                jSONObject2.putOpt("lat", Double.valueOf(customLocation.getLat()));
                jSONObject.putOpt("geo", jSONObject2);
            }
            JSONArray jSONArray = appList;
            if (jSONArray == null || jSONArray.length() <= 0) {
                JSONArray jSONArray2 = new JSONArray(S0.a().c(S0.h));
                if (jSONArray2.length() > 0) {
                    jSONObject.putOpt("app_list", jSONArray2);
                }
            } else {
                JSONArray jSONArray3 = new JSONArray();
                for (int i = 0; i < appList.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = appList.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && checkApkExist(jSONObjectOptJSONObject.optString("bundle"))) {
                        jSONArray3.put(jSONObjectOptJSONObject.optString("id"));
                    }
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.putOpt("app_list", jSONArray3);
                }
                S0.a().b(S0.g, (Object) getDate());
                S0.a().b(S0.h, jSONArray3.toString());
                appList = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return jSONObject;
    }

    public static String getDeviceMANUFACTURER() {
        String str = Build.MANUFACTURER;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getDpi() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static String getIMSI() {
        if (sContext == null || !isCanUseIMSI) {
            return "";
        }
        if (TextUtils.isEmpty(imsi) && !hasGetImsi) {
            try {
                hasGetImsi = true;
                TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    return "";
                }
                imsi = telephonyManager.getSubscriberId();
            } catch (Exception unused) {
            }
        }
        return imsi;
    }

    @SuppressLint({"MissingPermission"})
    public static String getImei() {
        String deviceId;
        if (sContext == null) {
            return "";
        }
        if (isGetImei) {
            return deviceImei;
        }
        C1432r0 c1432r0 = controlBean;
        if (c1432r0 != null) {
            if (!c1432r0.c()) {
                return "";
            }
        } else if (!isCanUseIMEI) {
            return "";
        }
        isGetImei = true;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) sContext.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null && (deviceId = telephonyManager.getDeviceId()) != null) {
                deviceImei = deviceId;
                return deviceId;
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String getMacAddress() {
        WifiInfo connectionInfo;
        if (sContext == null) {
            return "";
        }
        if (isGetMac) {
            return deviceMac;
        }
        C1432r0 c1432r0 = controlBean;
        if (c1432r0 != null) {
            if (!c1432r0.d()) {
                return "";
            }
        } else if (!isCanUseMac) {
            return "";
        }
        WifiManager wifiManager = (WifiManager) sContext.getSystemService("wifi");
        if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return "";
        }
        String macAddress = connectionInfo.getMacAddress();
        deviceMac = macAddress;
        isGetMac = true;
        return macAddress;
    }

    public static long getMemoryByte() {
        try {
            long j = totalRAM;
            if (j > 0) {
                return j;
            }
            ActivityManager activityManager = (ActivityManager) getContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            totalRAM = j2;
            return j2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static int getMobileHeight() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static int getMobileWidth() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static String getMyPackageName() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager == null ? "" : packageManager.getPackageInfo(sContext.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getNetworkType() {
        Context context = sContext;
        if (context == null) {
            return "";
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return "0";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "1";
        }
        if (activeNetworkInfo.getType() != 0) {
            return "0";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype != 20) {
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3";
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000") && !subtypeName.equalsIgnoreCase("LTE")) {
                        if (!subtypeName.equalsIgnoreCase("NR")) {
                            return "0";
                        }
                    }
                case 13:
                    return "4";
            }
        }
        return "5";
    }

    public static String getOSLevel() {
        return Build.VERSION.SDK;
    }

    public static String getOperators() {
        if (isCanUseIMSI && !isLoadOperators) {
            try {
                operatorId = (String) C1428p0.b(sContext).a(new Function() { // from class: com.zj.adlib.em2
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return DeviceUtil.lambda$getOperators$0((Context) obj);
                    }
                }).a((Function) new gm2()).a(new Function() { // from class: com.zj.adlib.im2
                    @Override // androidx.arch.core.util.Function
                    public final Object apply(Object obj) {
                        return DeviceUtil.lambda$getOperators$1((String) obj);
                    }
                }).b(new b1() { // from class: com.zj.adlib.km2
                    @Override // com.fl.saas.b1
                    public final Object a() {
                        return DeviceUtil.lambda$getOperators$2();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return operatorId;
    }

    public static int getOrientation() {
        Context context = sContext;
        if (context == null) {
            return 0;
        }
        int i = context.getResources().getConfiguration().orientation;
        if (i == 2) {
            return 2;
        }
        return i == 1 ? 1 : 0;
    }

    private static PackageInfo getPackageInfo() {
        Context context = sContext;
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getPackageInfo(sContext.getPackageName(), 16384);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getReqID(String str) {
        try {
            return AbstractC1412h0.a(getAutoNum() + str + System.currentTimeMillis() + UUID.randomUUID());
        } catch (Exception unused) {
            return "";
        }
    }

    public static float getScreenDensity() {
        if (sContext == null || screenPx != null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) sContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static long getSelfInstallTimeMillis() {
        Context context = sContext;
        if (context == null) {
            return 0L;
        }
        try {
            return context.getPackageManager().getPackageInfo(getMyPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static int getStatusBarHeight() {
        int identifier = sContext.getResources().getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return sContext.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String getSysLanguage() {
        if (sContext == null) {
            return "";
        }
        Locale locale = sContext.getResources().getConfiguration().getLocales().get(0);
        return locale.getLanguage() + c49.f40900a + locale.getCountry();
    }

    public static Activity getTopActivity() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            Object objInvoke = cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, null).invoke(null, null);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            for (Object obj : ((Map) declaredField.get(objInvoke)).values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField("paused");
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static native String getUpdate();

    public static String getUpdateMark() {
        try {
            return getUpdate();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getUserAgent() {
        return userAgent;
    }

    public static int getVersionCode() {
        if (sContext == null || getPackageInfo() == null) {
            return 0;
        }
        return getPackageInfo().versionCode;
    }

    public static String getVersionName() {
        return (sContext == null || getPackageInfo() == null) ? "" : getPackageInfo().versionName;
    }

    public static boolean inRangeOfView(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        float f = i;
        return (((motionEvent.getX() > f ? 1 : (motionEvent.getX() == f ? 0 : -1)) < 0 || (motionEvent.getX() > ((float) (view.getWidth() + i)) ? 1 : (motionEvent.getX() == ((float) (view.getWidth() + i)) ? 0 : -1)) > 0 || (motionEvent.getY() > ((float) i2) ? 1 : (motionEvent.getY() == ((float) i2) ? 0 : -1)) < 0 || (motionEvent.getY() > ((float) (view.getHeight() + i2)) ? 1 : (motionEvent.getY() == ((float) (view.getHeight() + i2)) ? 0 : -1)) > 0) && ((motionEvent.getX() > f ? 1 : (motionEvent.getX() == f ? 0 : -1)) < 0 || (motionEvent.getX() > ((float) (i + view.getWidth())) ? 1 : (motionEvent.getX() == ((float) (i + view.getWidth())) ? 0 : -1)) > 0 || (motionEvent.getY() > ((float) (i2 - getStatusBarHeight())) ? 1 : (motionEvent.getY() == ((float) (i2 - getStatusBarHeight())) ? 0 : -1)) < 0 || (motionEvent.getY() > ((float) ((i2 - getStatusBarHeight()) + view.getHeight())) ? 1 : (motionEvent.getY() == ((float) ((i2 - getStatusBarHeight()) + view.getHeight())) ? 0 : -1)) > 0)) ? false : true;
    }

    public static void initUserAgent() {
        String strA = S0.a().a(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, "");
        userAgent = strA;
        if (TextUtils.isEmpty(strA)) {
            loadUserAgent();
        } else {
            c1.a().a(new Runnable() { // from class: com.zj.adlib.nm2
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceUtil.loadUserAgent();
                }
            }, 120L, TimeUnit.SECONDS);
        }
    }

    public static boolean isAppList() {
        try {
            return !S0.a().a(S0.g, (Object) "").equals(getDate());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isClassExist(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean isContainMaterial(int i) {
        String strValueOf = String.valueOf(i);
        List<String> list = materialAdvList;
        if (list == null || list.isEmpty()) {
            return false;
        }
        return materialAdvList.contains(strValueOf);
    }

    public static int isHttpSupported() {
        try {
            return 1 ^ (NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? 1 : 0);
        } catch (Exception unused) {
            return 1;
        }
    }

    public static boolean isTablet() {
        Context context = sContext;
        return context != null && (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean isViewRange(MotionEvent motionEvent, View view, String str) {
        try {
            ArrayList<View> allChildren = getAllChildren(view);
            View view2 = null;
            for (int i = 0; i < allChildren.size(); i++) {
                if ((allChildren.get(i) instanceof TextView) && ((TextView) allChildren.get(i)).getText().toString().contains(str)) {
                    view2 = allChildren.get(i);
                }
            }
            if (view2 != null) {
                return inRangeOfView(view2, motionEvent);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TelephonyManager lambda$getOperators$0(Context context) {
        return (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOperators$1(String str) {
        isLoadOperators = true;
        if (str.startsWith("46000") || str.startsWith("46002") || str.startsWith("46004") || str.startsWith("46007")) {
            return "1";
        }
        if (str.startsWith("46001") || str.startsWith("46006") || str.startsWith("46009")) {
            return "2";
        }
        return (str.startsWith("46003") || str.startsWith("46005") || str.startsWith("46011")) ? "3" : "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$getOperators$2() {
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadUserAgent$3() {
        try {
            LogcatUtil.d("loadUserAgentStart");
            Context context = sContext;
            if (context != null) {
                userAgent = WebSettings.getDefaultUserAgent(context);
                S0.a().b(TRiverConstants.KEY_ENVIRONMENT_USERAGENT, userAgent);
            }
            LogcatUtil.d("loadUserAgent：" + userAgent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadUserAgent() {
        new Thread(new Runnable() { // from class: com.zj.adlib.mm2
            @Override // java.lang.Runnable
            public final void run() {
                DeviceUtil.lambda$loadUserAgent$3();
            }
        }).start();
    }

    public static void postUI(@NonNull Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            mainHandler.post(runnable);
        }
    }

    public static void postUIDelayed(long j, @NonNull Runnable runnable) {
        mainHandler.postDelayed(runnable, j);
    }

    public static int px2dip(float f) {
        Context context = sContext;
        if (context == null || f == 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void removePostUI(@Nullable Runnable runnable) {
        if (runnable == null) {
            return;
        }
        mainHandler.removeCallbacks(runnable);
    }

    public static void setContext(Context context) {
        sContext = context;
    }

    public static void setMaterialAdv(List<String> list) {
        materialAdvList = list;
    }

    public static native boolean startAction(Context context, String str);

    public static boolean startDpUrl(Context context, String str) {
        try {
            return startAction(context, str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int getOrientation(Context context) {
        return (context != null && context.getResources().getConfiguration().orientation == 2) ? 2 : 1;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = getPackageInfo(context, str);
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionCode);
        } catch (AndroidRuntimeException | Exception unused) {
            return null;
        }
    }
}
