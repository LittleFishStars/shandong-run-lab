package cn.hzjizhun.admin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import androidx.core.content.ContextCompat;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ad.listener.DeviceParamsController;
import cn.hzjizhun.admin.base.ad.NativeHelper;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeviceUtil {
    private static String invalidOaid = "00000000";
    private static String mImei = "";
    private static String mImsi = "";
    private static int mOprator = 0;
    private static String mSsid = "";
    private static String sysBootMark = "";
    private static String updateMark = "";
    static ReentrantReadWriteLock sRwLock = new ReentrantReadWriteLock();
    private static String mAndroidId = "";
    private static String defaultUAStr = "";
    private static String sMcid = "";

    @SuppressLint({"HardwareIds"})
    public static String getAndroidId(Context context) {
        try {
            if (!TextUtils.isEmpty(mAndroidId)) {
                return mAndroidId;
            }
            DeviceParamsController deviceController = JZAdSdk.getInstance().getDeviceController();
            if (deviceController != null && !deviceController.isCanUsePhoneState()) {
                String androidId = deviceController.getAndroidId();
                if (!TextUtils.isEmpty(androidId)) {
                    mAndroidId = androidId;
                    return androidId;
                }
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            mAndroidId = string;
            return string;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long getBootTime() {
        try {
            return SystemClock.elapsedRealtime() / 1000;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getDefaultUAString(Context context) {
        try {
            if (TextUtils.isEmpty(defaultUAStr)) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                defaultUAStr = defaultUserAgent;
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                    String packageName = PackageUtil.getPackageName(context);
                    if (!TextUtils.isEmpty(packageName) && defaultUAStr.contains(packageName)) {
                        defaultUAStr = defaultUAStr.replaceAll(packageName, "");
                    }
                }
            }
        } catch (Throwable unused) {
            defaultUAStr = "";
        }
        return defaultUAStr;
    }

    public static String getMcid(Context context) {
        try {
            if (!TextUtils.isEmpty(sMcid)) {
                return sMcid;
            }
            String oaid = OAIDUtil.getOaid(context);
            if (!TextUtils.isEmpty(oaid) && !oaid.contains(invalidOaid)) {
                String mDStr = MD5Util.getMDStr(oaid);
                sMcid = mDStr;
                return mDStr;
            }
            String mcidFile = readMcidFile();
            sMcid = mcidFile;
            if (!TextUtils.isEmpty(mcidFile)) {
                return sMcid;
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                String mDStr2 = MD5Util.getMDStr(androidId);
                sMcid = mDStr2;
                return mDStr2;
            }
            return "";
        } catch (Throwable unused) {
        }
    }

    public static int getOperator() {
        try {
            int i = mOprator;
            if (i > 0) {
                return i;
            }
            TelephonyManager telephonyManager = (TelephonyManager) JZAdSdk.getInstance().getContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            String simOperator = telephonyManager.getSimOperator();
            if (telephonyManager.getSimState() != 5) {
                return 0;
            }
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                mOprator = 1;
            } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                mOprator = 2;
            } else if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                mOprator = 3;
            } else {
                mOprator = 255;
            }
        } catch (Throwable unused) {
        }
        return mOprator;
    }

    public static long getOsUpdateTime() {
        try {
            return Build.TIME / 1000;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String getReqId(Context context) {
        try {
            String mDStr = MD5Util.getMDStr(getMcid(context) + System.currentTimeMillis() + String.valueOf(Process.myPid()));
            Objects.requireNonNull(mDStr);
            return mDStr.toLowerCase();
        } catch (Throwable unused) {
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String getSsid() {
        try {
            if (!TextUtils.isEmpty(mSsid)) {
                return mSsid;
            }
            String extraInfo = ((ConnectivityManager) JZAdSdk.getInstance().getContext().getSystemService("connectivity")).getActiveNetworkInfo().getExtraInfo();
            mSsid = extraInfo;
            return extraInfo;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSysBootMark() {
        try {
            if (TextUtils.isEmpty(sysBootMark) && Build.VERSION.SDK_INT > 26 && !isXiaomiOrRedmi()) {
                String sysBootMark2 = NativeHelper.getSysBootMark();
                sysBootMark = sysBootMark2;
                return sysBootMark2;
            }
        } catch (Throwable unused) {
        }
        return sysBootMark;
    }

    public static String getUpdateMark() {
        try {
            if (TextUtils.isEmpty(updateMark)) {
                updateMark = NativeHelper.getSysUpdateMark();
            }
            return updateMark;
        } catch (Throwable unused) {
            return updateMark;
        }
    }

    public static boolean isXiaomiOrRedmi() {
        String lowerCase = Build.BRAND.toLowerCase();
        String lowerCase2 = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("xiaomi") || lowerCase.contains("redmi") || lowerCase2.contains("xiaomi") || lowerCase2.contains("redmi");
    }

    private static String readMcidFile() {
        try {
            if (ContextCompat.checkSelfPermission(JZAdSdk.getInstance().getContext(), "android.permission.READ_EXTERNAL_STORAGE") == 0 && Build.VERSION.SDK_INT < 29) {
                File file = new File("/sdcard/Download/RCAD/mc_temp");
                if (file.exists()) {
                    try {
                        sRwLock.readLock().lock();
                        return FileInfoUtils.readFile(file);
                    } finally {
                        sRwLock.readLock().unlock();
                    }
                }
                String androidId = getAndroidId(JZAdSdk.getInstance().getContext());
                if (TextUtils.isEmpty(androidId)) {
                    androidId = System.currentTimeMillis() + "";
                }
                String mDStr = MD5Util.getMDStr(androidId);
                try {
                    file.getParentFile().mkdirs();
                    sRwLock.writeLock().lock();
                    writeMcid(file, mDStr);
                    return mDStr;
                } finally {
                    sRwLock.writeLock().unlock();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static void writeMcid(File file, String str) {
        try {
            FileInfoUtils.writeFile(file, str);
        } catch (Throwable unused) {
        }
    }
}
