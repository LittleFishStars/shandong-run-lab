package com.aliyun.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.cicada.player.utils.NativeUsed;
import com.zj.adlib.c49;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@NativeUsed
public class DeviceInfoUtils {
    public static File ALIVC_DATA_FILE = null;
    public static final String DATA_DIRECTORY = "AlivcData";
    private static final int MAX_WRITE_COUNT = 10;
    private static final String UUID_FILE = "alivc_data.txt";
    private static final String UUID_PROP = "UUID";
    private static c mCpuTracker;
    private static Context sAppContext;
    private static String sCpuProcessorInfo;
    private static String sDeviceUUID;
    private static String sSessionId;
    private static int sWriteUUIDCount;

    public static class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f25860a;
        final /* synthetic */ String b;

        public a(File file, String str) {
            this.f25860a = file;
            this.b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                boolean z2 = this.f25860a.exists() || this.f25860a.createNewFile();
                Properties properties = new Properties();
                properties.setProperty(DeviceInfoUtils.UUID_PROP, this.b);
                if (z2) {
                    FileWriter fileWriter = new FileWriter(this.f25860a);
                    properties.store(fileWriter, (String) null);
                    fileWriter.close();
                    z = true;
                }
            } catch (Throwable unused) {
            }
            DeviceInfoUtils.access$008();
            if (z || DeviceInfoUtils.sWriteUUIDCount >= 10) {
                return;
            }
            DeviceInfoUtils.writeUUIDToFile(this.f25860a, this.b);
        }
    }

    static {
        f.b();
        ALIVC_DATA_FILE = null;
    }

    public static /* synthetic */ int access$008() {
        int i = sWriteUUIDCount;
        sWriteUUIDCount = i + 1;
        return i;
    }

    private static String canGetContext() {
        return getSDKContext() != null ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE;
    }

    public static String generateNewSessionId() {
        String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
        sSessionId = strReplace;
        return strReplace;
    }

    public static String getApplicationName() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getSDKContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getSDKContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static String getApplicationVersion() {
        try {
            if (getSDKContext() != null) {
                return getSDKContext().getPackageManager().getPackageInfo(getSDKContext().getPackageName(), 0).versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return "";
    }

    public static String getCPUInfo() {
        String str;
        try {
            str = (String) Class.forName("android.os.SystemProperties").getDeclaredMethod(p3.f, String.class, String.class).invoke(null, "ro.board.platform", "");
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return str.equals("") ? Build.HARDWARE : str;
    }

    public static String getCPUProcessorInfo() throws Throwable {
        if (!TextUtils.isEmpty(sCpuProcessorInfo)) {
            return sCpuProcessorInfo;
        }
        requestCPUInfo();
        return sCpuProcessorInfo;
    }

    public static String getCPUUsageRatio() {
        if (mCpuTracker == null) {
            mCpuTracker = new c();
        }
        return String.valueOf(mCpuTracker.e());
    }

    private static String getCacheDir() {
        File externalCacheDir;
        return (getSDKContext() == null || (externalCacheDir = getSDKContext().getExternalCacheDir()) == null || !externalCacheDir.exists()) ? "" : externalCacheDir.getAbsolutePath();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String getCurrentTimestamp() {
        return new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    private static String getDeviceFeature() {
        JSONObject jSONObject = new JSONObject();
        if (sAppContext != null) {
            try {
                jSONObject.put("UIModeType", getUIModeType());
            } catch (Exception unused) {
            }
            putFeature(jSONObject, "android.hardware.audio.low_latency");
            putFeature(jSONObject, "android.hardware.bluetooth");
            putFeature(jSONObject, "android.hardware.bluetooth_le");
            putFeature(jSONObject, "android.hardware.screen.landscape");
            putFeature(jSONObject, "android.hardware.screen.portrait");
            int i = Build.VERSION.SDK_INT;
            putFeature(jSONObject, "android.hardware.type.watch");
            putFeature(jSONObject, "android.hardware.audio.output");
            putFeature(jSONObject, "android.software.live_tv");
            putFeature(jSONObject, "android.hardware.opengles.aep");
            putFeature(jSONObject, "android.hardware.audio.pro");
            putFeature(jSONObject, "android.hardware.type.automotive");
            putFeature(jSONObject, "android.hardware.sensor.hifi_sensors");
            putFeature(jSONObject, "android.software.midi");
            putFeature(jSONObject, "android.software.picture_in_picture");
            putFeature(jSONObject, "android.hardware.vr.high_performance");
            putFeature(jSONObject, "android.hardware.vulkan.level");
            putFeature(jSONObject, "android.hardware.vulkan.version");
            if (i >= 27) {
                putFeature(jSONObject, "android.hardware.ram.low");
                putFeature(jSONObject, "android.hardware.ram.normal");
            }
            putFeature(jSONObject, "android.software.activities_on_secondary_displays");
            putFeature(jSONObject, "android.hardware.type.embedded");
            putFeature(jSONObject, "android.hardware.vr.headtracking");
            putFeature(jSONObject, "android.hardware.vulkan.compute");
            putFeature(jSONObject, "android.hardware.touchscreen");
            putFeature(jSONObject, "android.hardware.faketouch");
            putFeature(jSONObject, "android.hardware.telephony");
            putFeature(jSONObject, "android.hardware.camera");
            putFeature(jSONObject, "android.hardware.nfc");
            putFeature(jSONObject, "android.hardware.location.gps");
            putFeature(jSONObject, "android.hardware.microphone");
            putFeature(jSONObject, "android.hardware.sensor.compass");
        }
        return jSONObject.toString();
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static synchronized String getDeviceUUID() {
        if (!TextUtils.isEmpty(sDeviceUUID)) {
            return sDeviceUUID;
        }
        if (ALIVC_DATA_FILE == null) {
            ALIVC_DATA_FILE = new File(getSDKContext().getCacheDir(), "AlivcData");
        }
        File file = new File(ALIVC_DATA_FILE, UUID_FILE);
        try {
            if (ALIVC_DATA_FILE.exists() || ALIVC_DATA_FILE.mkdir()) {
                Properties properties = new Properties();
                FileReader fileReader = new FileReader(file);
                properties.load(fileReader);
                fileReader.close();
                sDeviceUUID = properties.getProperty(UUID_PROP);
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(sDeviceUUID)) {
            sWriteUUIDCount = 0;
            String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
            sDeviceUUID = strReplace;
            writeUUIDToFile(file, strReplace);
        }
        return sDeviceUUID;
    }

    public static String getElectricUsageRatio() {
        if (sAppContext == null) {
            return "0";
        }
        try {
            Intent intentRegisterReceiver = sAppContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            return String.valueOf((int) (((intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(com.alibaba.ariver.permission.b.b, -1) : -1) / (intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : -1)) * 100.0f));
        } catch (Throwable unused) {
            return "0";
        }
    }

    public static String getGPUInfo() {
        return "";
    }

    public static String getMemoryTotal() {
        try {
            Context context = sAppContext;
            if (context == null) {
                return "0";
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return ((int) (memoryInfo.totalMem / 1048576.0f)) + "";
        } catch (Exception unused) {
            return "0";
        }
    }

    public static String getMemoryUsage() {
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) sAppContext.getSystemService(TTDownloadField.TT_ACTIVITY)).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo.length == 0) {
            return "0";
        }
        return (processMemoryInfo[0].getTotalPss() / 1024.0f) + "";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String getNetworkType() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) sAppContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "NoActive";
            }
            String subtypeName = activeNetworkInfo.getSubtypeName();
            if (activeNetworkInfo.getType() == 1) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (activeNetworkInfo.getType() != 0) {
                return subtypeName;
            }
            int subtype = activeNetworkInfo.getSubtype();
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NetworkUtil.NETWORK_TYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NetworkUtil.NETWORK_TYPE_3G;
                case 13:
                    return NetworkUtil.NETWORK_TYPE_4G;
                default:
                    if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                        return "Mobile:" + subtypeName;
                    }
                    return NetworkUtil.NETWORK_TYPE_3G;
            }
        } catch (Exception unused) {
            return "Unknow";
        }
    }

    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    public static String getOpenGLVersion() {
        ConfigurationInfo deviceConfigurationInfo;
        Context context = sAppContext;
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                if (activityManager != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                    return Integer.toHexString(Integer.parseInt(deviceConfigurationInfo.reqGlEsVersion + ""));
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Context getSDKContext() {
        return sAppContext;
    }

    public static String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getTerminalType() {
        try {
            Context context = sAppContext;
            return (context == null || context.getResources() == null || sAppContext.getResources().getConfiguration() == null || (sAppContext.getResources().getConfiguration().screenLayout & 15) < 3) ? AliyunLogCommon.TERMINAL_TYPE : "pad";
        } catch (Throwable unused) {
            return AliyunLogCommon.TERMINAL_TYPE;
        }
    }

    private static String getUIModeType() throws Exception {
        int currentModeType = ((UiModeManager) sAppContext.getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 6) {
            return "WATCH";
        }
        if (currentModeType == 7) {
            return "VR_HEADSET";
        }
        if (currentModeType == 15) {
            return "MASK";
        }
        if (currentModeType == 1) {
            return RVScheduleType.NORMAL;
        }
        if (currentModeType == 2) {
            return "DESK";
        }
        if (currentModeType != 3) {
            return currentModeType != 4 ? "UNDEFINED" : "TELEVISION";
        }
        return "CAR";
    }

    public static void loadClass() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @NativeUsed
    private static String native_getDeviceInfo(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2133529830:
                if (str.equals("device_manufacturer")) {
                    b = 0;
                }
                break;
            case -1628011446:
                if (str.equals("cpu_usage")) {
                    b = 1;
                }
                break;
            case -1453464803:
                if (str.equals("terminal_type")) {
                    b = 2;
                }
                break;
            case -1287148950:
                if (str.equals("application_id")) {
                    b = 3;
                }
                break;
            case -1182845946:
                if (str.equals("os_name")) {
                    b = 4;
                }
                break;
            case -1117382559:
                if (str.equals("gpu_info")) {
                    b = 5;
                }
                break;
            case -1010275000:
                if (str.equals("opengl_version")) {
                    b = 6;
                }
                break;
            case -977897239:
                if (str.equals("application_version")) {
                    b = 7;
                }
                break;
            case -902394881:
                if (str.equals("electric_usage")) {
                    b = 8;
                }
                break;
            case -601148322:
                if (str.equals("device_brand")) {
                    b = 9;
                }
                break;
            case -591076352:
                if (str.equals("device_model")) {
                    b = 10;
                }
                break;
            case -553266608:
                if (str.equals("cache_dir")) {
                    b = 11;
                }
                break;
            case -379364393:
                if (str.equals("can_get_context")) {
                    b = 12;
                }
                break;
            case -19457365:
                if (str.equals("network_type")) {
                    b = 13;
                }
                break;
            case 589850:
                if (str.equals("application_name")) {
                    b = com.google.common.base.a.p;
                }
                break;
            case 3601339:
                if (str.equals("uuid")) {
                    b = com.google.common.base.a.q;
                }
                break;
            case 216651451:
                if (str.equals("cpu_processor")) {
                    b = com.google.common.base.a.r;
                }
                break;
            case 501310693:
                if (str.equals("cpu_info")) {
                    b = 17;
                }
                break;
            case 672836989:
                if (str.equals("os_version")) {
                    b = com.google.common.base.a.u;
                }
                break;
            case 1000114701:
                if (str.equals("device_feature")) {
                    b = 19;
                }
                break;
            case 1270116442:
                if (str.equals("mem_total")) {
                    b = com.google.common.base.a.x;
                }
                break;
            case 1271141047:
                if (str.equals("mem_usage")) {
                    b = com.google.common.base.a.y;
                }
                break;
        }
        switch (b) {
            case 0:
                return getDeviceManufacturer();
            case 1:
                return getCPUUsageRatio();
            case 2:
                return getTerminalType();
            case 3:
                return getSDKContext().getPackageName();
            case 4:
                return "android";
            case 5:
                return getGPUInfo();
            case 6:
                return getOpenGLVersion();
            case 7:
                return getApplicationVersion();
            case 8:
                return getElectricUsageRatio();
            case 9:
                return getDeviceBrand();
            case 10:
                return getDeviceModel();
            case 11:
                return getCacheDir();
            case 12:
                return canGetContext();
            case 13:
                return getNetworkType();
            case 14:
                return getApplicationName();
            case 15:
                return getDeviceUUID();
            case 16:
                return getCPUProcessorInfo();
            case 17:
                return getCPUInfo();
            case 18:
                return getOSVersion();
            case 19:
                return getDeviceFeature();
            case 20:
                return getMemoryTotal();
            case 21:
                return getMemoryUsage();
            default:
                return "";
        }
    }

    private static void putFeature(JSONObject jSONObject, String str) {
        try {
            jSONObject.put(str, sAppContext.getPackageManager().hasSystemFeature(str) ? "1" : "0");
        } catch (Exception unused) {
        }
    }

    private static void requestCPUInfo() throws Throwable {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    String line = bufferedReader.readLine();
                    int i = 0;
                    while (true) {
                        i++;
                        if (i < 30) {
                            String[] strArrSplit = line.split(":\\s+", 2);
                            if (strArrSplit.length > 1 && strArrSplit[0].contains("Processor")) {
                                sCpuProcessorInfo = strArrSplit[1];
                            }
                            if (!TextUtils.isEmpty(sCpuProcessorInfo)) {
                                break;
                            } else {
                                line = bufferedReader.readLine();
                            }
                        } else {
                            break;
                        }
                    }
                    try {
                        fileReader2.close();
                    } catch (IOException unused) {
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        fileReader2.close();
                    } catch (IOException unused3) {
                    }
                } catch (Exception unused4) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (bufferedReader == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (IOException unused6) {
                        }
                    }
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException unused7) {
                        throw th;
                    }
                }
            } catch (Exception unused8) {
                bufferedReader = null;
            } catch (Throwable th2) {
                bufferedReader = null;
                fileReader = fileReader2;
                th = th2;
            }
        } catch (Exception unused9) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused10) {
        }
    }

    public static void setSDKContext(Context context) {
        if (context != null) {
            context = context.getApplicationContext();
        }
        sAppContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeUUIDToFile(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        new Timer().schedule(new a(file, str), 3000L);
    }
}
