package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.net.InetAddress;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class aq {
    private static int bpI = 0;
    private static boolean bpJ = false;
    private static String bpK = "";

    public static String dA(Context context) {
        try {
            NetworkInfo networkInfoDz = dz(context);
            if (networkInfoDz != null && networkInfoDz.isConnected()) {
                int type = networkInfoDz.getType();
                if (type == 0) {
                    String subtypeName = networkInfoDz.getSubtypeName();
                    return TextUtils.isEmpty(subtypeName) ? networkInfoDz.getTypeName() : subtypeName;
                }
                if (type == 1) {
                    return networkInfoDz.getTypeName();
                }
            }
        } catch (Exception unused) {
        }
        return "unknown";
    }

    public static int dB(Context context) {
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo networkInfoDz = dz(context);
                if (!(networkInfoDz != null && networkInfoDz.isConnected())) {
                    return 0;
                }
                if (1 == networkInfoDz.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager != null) {
                    int iN = n(context, telephonyManager.getNetworkType());
                    if (iN == 20) {
                        return 5;
                    }
                    switch (iN) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 2;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 3;
                        case 13:
                            return 4;
                        default:
                            return 0;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo dz(Context context) {
        ConnectivityManager connectivityManager;
        if (!SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0099  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r11v2 int, still in use, count: 2, list:
      (r11v2 int) from 0x0031: IF  (r11v2 int) != (49679502 int)  -> B:12:0x0033 A[HIDDEN]
      (r11v2 int) from 0x0036: SWITCH (r11v2 int)
     case 49679475: goto B:27:0x0063
     case 49679476: goto B:24:0x0059
     case 49679477: goto B:21:0x004f
     case 49679478: goto B:18:0x0045
     case 49679479: goto B:15:0x003b
     default: goto B:14:0x0039 A[Catch: Exception -> 0x00d7, RegionRef:SW:13]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int e(Context context, String str, boolean z) {
        byte b;
        if (context == null || bpI > 0 || bpJ) {
            return bpI;
        }
        try {
            if (!z) {
                String simOperator = ((TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
                if (iHashCode != 49679502) {
                    switch (simOperator) {
                        case "46000":
                            b = 0;
                            break;
                        case "46001":
                            b = 4;
                            break;
                        case "46002":
                            b = 1;
                            break;
                        case "46003":
                            b = 7;
                            break;
                        default:
                            switch (iHashCode) {
                                case 49679475:
                                    if (!simOperator.equals("46005")) {
                                        b = -1;
                                    } else {
                                        b = 8;
                                    }
                                    break;
                                case 49679476:
                                    if (!simOperator.equals("46006")) {
                                        b = -1;
                                    } else {
                                        b = 5;
                                    }
                                    break;
                                case 49679477:
                                    if (!simOperator.equals("46007")) {
                                        b = -1;
                                    } else {
                                        b = 2;
                                    }
                                    break;
                                case 49679478:
                                    if (!simOperator.equals("46008")) {
                                        b = -1;
                                    } else {
                                        b = 3;
                                    }
                                    break;
                                case 49679479:
                                    if (!simOperator.equals("46009")) {
                                        b = -1;
                                    } else {
                                        b = 6;
                                    }
                                    break;
                                default:
                                    b = -1;
                                    break;
                            }
                    }
                } else if (simOperator.equals("46011")) {
                    b = 9;
                } else {
                    b = -1;
                }
                switch (b) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                        bpI = 1;
                        break;
                    case 4:
                    case 5:
                    case 6:
                        bpI = 3;
                        break;
                    case 7:
                    case 8:
                    case 9:
                        bpI = 2;
                        break;
                    default:
                        bpI = 0;
                        break;
                }
            } else {
                bpI = 0;
            }
            if (bpI == 0 && !TextUtils.isEmpty(str)) {
                if (str.startsWith("46000") || str.startsWith("46002")) {
                    bpI = 1;
                } else if (str.startsWith("46001")) {
                    bpI = 3;
                } else if (str.startsWith("46003")) {
                    bpI = 2;
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
        int i = bpI;
        bpJ = i == 0;
        return i;
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo networkInfoDz = dz(context);
            if (networkInfoDz == null) {
                return -1;
            }
            return networkInfoDz.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    public static String h(Context context, boolean z) {
        if (z) {
            return "";
        }
        if (!TextUtils.isEmpty(bpK)) {
            return bpK;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager != null) {
            try {
                bpK = telephonyManager.getSimOperator();
            } catch (Exception unused) {
            }
        }
        return bpK;
    }

    private static boolean hS(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean hT(String str) {
        return t(str, 3000);
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo networkInfoDz = dz(context);
            return networkInfoDz != null && networkInfoDz.isConnected() && networkInfoDz.getType() == 0;
        } catch (Exception unused) {
        }
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfoDz = dz(context);
            return networkInfoDz != null && networkInfoDz.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfoDz = dz(context);
            return networkInfoDz != null && networkInfoDz.isConnected() && 1 == networkInfoDz.getType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int n(Context context, int i) {
        ServiceState serviceState;
        int i2 = Build.VERSION.SDK_INT;
        if (!SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else if (context.getApplicationInfo().targetSdkVersion < 29 || i2 < 29) {
                try {
                    serviceState = (ServiceState) ab.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            } else {
                serviceState = telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i;
            }
            if (bd.Wa()) {
                Integer num = (Integer) ab.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            }
            if (hS(serviceState.toString())) {
                return 20;
            }
            return i;
        } catch (Exception unused2) {
            return i;
        }
    }

    @WorkerThread
    private static boolean t(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
