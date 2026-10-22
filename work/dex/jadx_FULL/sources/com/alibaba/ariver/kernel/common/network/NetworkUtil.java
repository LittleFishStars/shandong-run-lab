package com.alibaba.ariver.kernel.common.network;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.VisibleForTesting;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.igexin.sdk.PushConsts;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkUtil {
    public static final String NETWORK_TYPE_2G = "2G";
    public static final String NETWORK_TYPE_3G = "3G";
    public static final String NETWORK_TYPE_4G = "4G";
    public static final String NETWORK_TYPE_NOTREACHABLE = "NotReachable";
    public static final String NETWORK_TYPE_UNKNOWN = "UNKNOWN";
    public static final String NETWORK_TYPE_WIFI = "WIFI";
    public static final String TAG = "NetworkUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Network f24261a;
    private static final List<NetworkListener> b = new CopyOnWriteArrayList();
    private static boolean c = false;

    @VisibleForTesting
    protected static BroadcastReceiver sBroadcastReceiver = null;

    /* JADX INFO: renamed from: com.alibaba.ariver.kernel.common.network.NetworkUtil$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network;

        static {
            int[] iArr = new int[Network.values().length];
            $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network = iArr;
            try {
                iArr[Network.NETWORK_NO_CONNECTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_SLOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_MIDDLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_MOBILE_FAST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[Network.NETWORK_WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class MyBroadcastReceiver extends BroadcastReceiver {
        private MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            NetworkUtil.c(context);
        }

        public /* synthetic */ MyBroadcastReceiver(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public enum Network {
        NETWORK_WIFI,
        NETWORK_MOBILE_FAST,
        NETWORK_MOBILE_MIDDLE,
        NETWORK_MOBILE_SLOW,
        NETWORK_NO_CONNECTION,
        NETWORK_TYPE_UNKNOWN
    }

    public interface NetworkListener {
        void onNetworkChanged(Network network, Network network2);
    }

    private static synchronized void a(Context context) {
        try {
            if (!c && context != null) {
                c = true;
                try {
                    if (sBroadcastReceiver == null) {
                        sBroadcastReceiver = new MyBroadcastReceiver(null);
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
                    context.getApplicationContext().registerReceiver(sBroadcastReceiver, intentFilter);
                } catch (Throwable th) {
                    RVLogger.e(TAG, "registerReceiver error", th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void addListener(Context context, NetworkListener networkListener) {
        if (networkListener != null) {
            List<NetworkListener> list = b;
            if (list.contains(networkListener)) {
                return;
            }
            a(context);
            list.add(networkListener);
        }
    }

    private static synchronized void b(Context context) {
        try {
            c = false;
            if (sBroadcastReceiver == null || context == null) {
                return;
            }
            try {
                context.getApplicationContext().unregisterReceiver(sBroadcastReceiver);
                sBroadcastReceiver = null;
            } catch (Throwable th) {
                RVLogger.e(TAG, "unRegisterReceiver error", th);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public static void c(Context context) {
        NetworkInfo activeNetworkInfo;
        List<NetworkListener> list;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "exception detail", th);
            activeNetworkInfo = null;
        }
        Network network = f24261a;
        Network networkA = a(activeNetworkInfo);
        f24261a = networkA;
        if (network == null || networkA == network || (list = b) == null) {
            return;
        }
        RVLogger.d(TAG, "onNetworkChanged");
        synchronized (list) {
            for (NetworkListener networkListener : list) {
                if (networkListener != null) {
                    networkListener.onNetworkChanged(network, f24261a);
                }
            }
        }
    }

    public static Network getCurrentNetworkType(Context context, boolean z) {
        Network network = f24261a;
        if (network != null && z) {
            return network;
        }
        c(context);
        return f24261a;
    }

    public static String getDetailNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "get network info exception.", th);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return NETWORK_TYPE_NOTREACHABLE;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1 || type == 9) {
            return NETWORK_TYPE_WIFI;
        }
        int networkType = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getNetworkType();
        if (networkType == 18) {
            return NETWORK_TYPE_3G;
        }
        switch (networkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NETWORK_TYPE_3G;
            case 13:
                return NETWORK_TYPE_4G;
            default:
                return "UNKNOWN";
        }
    }

    public static String getSimpleNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            RVLogger.e(TAG, "Exception", th);
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return "fail";
        }
        int type = activeNetworkInfo.getType();
        return (type == 1 || type == 9) ? "wifi" : "wwan";
    }

    public static void removeListener(Context context, NetworkListener networkListener) {
        if (networkListener == null) {
            return;
        }
        List<NetworkListener> list = b;
        list.remove(networkListener);
        if (list.size() == 0) {
            b(context);
        }
    }

    public static String transferNetworkType(Network network) {
        int i = AnonymousClass1.$SwitchMap$com$alibaba$ariver$kernel$common$network$NetworkUtil$Network[network.ordinal()];
        if (i == 1) {
            return "none";
        }
        if (i == 2) {
            return "2g";
        }
        if (i == 3) {
            return "3g";
        }
        if (i != 4) {
            return i != 5 ? "unknown" : "wifi";
        }
        return "4g";
    }

    private static Network a(NetworkInfo networkInfo) {
        try {
            if (networkInfo == null) {
                return Network.NETWORK_NO_CONNECTION;
            }
            if (!networkInfo.isConnected()) {
                return Network.NETWORK_NO_CONNECTION;
            }
            int type = networkInfo.getType();
            int subtype = networkInfo.getSubtype();
            RVLogger.d(TAG, "type: " + type + " subType: " + subtype);
            if (type != 1 && type != 9) {
                if (type != 0) {
                    return Network.NETWORK_TYPE_UNKNOWN;
                }
                if (subtype == 0) {
                    return Network.NETWORK_TYPE_UNKNOWN;
                }
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    return Network.NETWORK_MOBILE_SLOW;
                }
                if (subtype != 13) {
                    return Network.NETWORK_MOBILE_MIDDLE;
                }
                return Network.NETWORK_MOBILE_FAST;
            }
            return Network.NETWORK_WIFI;
        } catch (Exception e) {
            RVLogger.e(TAG, "detectNetwork error!", e);
            return Network.NETWORK_TYPE_UNKNOWN;
        }
    }
}
