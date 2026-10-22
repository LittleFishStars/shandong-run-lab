package cn.hzjizhun.admin.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import androidx.annotation.RequiresPermission;
import cn.hzjizhun.admin.JZAdSdk;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkTypeUtils {
    private static final int NETWORK_TYPE_NR = 20;
    private static NetworkTypeUtils mUtils;

    public enum CpNetEnum {
        TYPE_NONE(0),
        TYPE_WIFI(100),
        TYPE_2G(2),
        TYPE_3G(3),
        TYPE_4G(4),
        TYPE_5G(5);

        private final int value;

        CpNetEnum(int i) {
            this.value = i;
        }

        public int ddksa() {
            return this.value;
        }
    }

    private CpNetEnum convert2CusNetType(int i) {
        if (i != 19) {
            if (i == 20) {
                return CpNetEnum.TYPE_5G;
            }
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return CpNetEnum.TYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return CpNetEnum.TYPE_3G;
                case 13:
                    break;
                default:
                    return CpNetEnum.TYPE_NONE;
            }
        }
        return CpNetEnum.TYPE_4G;
    }

    private static NetworkTypeUtils getInstance() {
        if (mUtils == null) {
            synchronized (NetworkTypeUtils.class) {
                if (mUtils == null) {
                    mUtils = new NetworkTypeUtils();
                }
            }
        }
        return mUtils;
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    private CpNetEnum getMobileNetType(Context context) {
        TelephonyManager telephonyManager;
        try {
            if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)) != null) {
                return convert2CusNetType(telephonyManager.getDataNetworkType());
            }
            return CpNetEnum.TYPE_NONE;
        } catch (Throwable unused) {
            return CpNetEnum.TYPE_NONE;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static int getNetworkType() {
        try {
            return getInstance().getNetType(JZAdSdk.getInstance().getContext()).ddksa();
        } catch (Throwable unused) {
            return CpNetEnum.TYPE_NONE.value;
        }
    }

    private boolean isCellular(NetworkCapabilities networkCapabilities) {
        try {
            return networkCapabilities.hasTransport(0);
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isNetConnected(NetworkCapabilities networkCapabilities) {
        try {
            return networkCapabilities.hasCapability(12);
        } catch (Throwable unused) {
            return false;
        }
    }

    @TargetApi(23)
    private boolean isNetValidated(NetworkCapabilities networkCapabilities) {
        try {
            return networkCapabilities.hasCapability(16);
        } catch (Throwable unused) {
            return false;
        }
    }

    private boolean isWifi(NetworkCapabilities networkCapabilities) {
        try {
            return networkCapabilities.hasTransport(1);
        } catch (Throwable unused) {
            return false;
        }
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    public CpNetEnum getNetType(Context context) {
        try {
            if (context == null) {
                return CpNetEnum.TYPE_NONE;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && isNetConnected(networkCapabilities)) {
                return isWifi(networkCapabilities) ? CpNetEnum.TYPE_WIFI : getMobileNetType(context);
            }
            return CpNetEnum.TYPE_NONE;
        } catch (Throwable unused) {
            return CpNetEnum.TYPE_NONE;
        }
    }
}
