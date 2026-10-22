package com.kc.bw.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.provider.Settings;
import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PermissionUtils {
    public static final String TAG = dexg.dexa("QfsnjttjpoVujmt");
    public static int hasQueryAllPackagesPermissionStatus = -1;
    public static int hasGetInstalledAppsPermissionStatus = -1;
    public static int vivoSupportedRuntimeGIAPStatus = -1;
    public static int oppoSupportedRuntimeGIAPStatus = -1;
    public static int xiaomiSupportedRuntimeGIAPStatus = -1;
    public static int huaweiSupportedRuntimeGIAPStatus = -1;

    public static boolean checkConfigPermission(Context context, String str) {
        try {
            boolean zContains = Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
            if (!zContains) {
                DebugLog.common_w(str + dexg.dexa("!qfsnjttjpo!efojfe"));
            }
            return zContains;
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("difdlDpogjhQfsnjttjpo!gbjm!") + th);
            return false;
        }
    }

    @Deprecated
    public static boolean checkPermission(Context context, String str) {
        return checkConfigPermission(context, str) && checkRuntimePermission(context, str);
    }

    public static boolean checkRuntimePermission(Context context, String str) {
        boolean z = context.checkSelfPermission(str) == 0;
        if (!z) {
            DebugLog.common_w(str + dexg.dexa("!svoujnf!qfsnjttjpo!efojfe"));
        }
        return z;
    }

    public static boolean hasConfigQueryAllPackagesPermission(Context context) {
        Object th;
        boolean zCheckConfigPermission;
        boolean z = false;
        try {
            int i = hasQueryAllPackagesPermissionStatus;
            if (i == -1) {
                zCheckConfigPermission = checkConfigPermission(context, dexg.dexa("boespje/qfsnjttjpo/RVFSZ`BMM`QBDLBHFT"));
                try {
                    if (zCheckConfigPermission) {
                        hasQueryAllPackagesPermissionStatus = 1;
                    } else {
                        hasQueryAllPackagesPermissionStatus = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    hasQueryAllPackagesPermissionStatus = 0;
                    DebugLog.common_w(dexg.dexa("RVFSZ`BMM`QBDLBHFT!gbjm") + th);
                }
                z = zCheckConfigPermission;
            } else if (i == 1) {
                z = true;
            }
        } catch (Throwable th3) {
            th = th3;
            zCheckConfigPermission = false;
        }
        if (!z) {
            DebugLog.common_w(dexg.dexa("RVFSZ`BMM`QBDLBHFT!qfsnjttjpo!efojfe"));
        }
        return z;
    }

    public static boolean hasGetInstalledAppsPermissionFromHonor(Context context) {
        return !isSupportRuntimeGIAPByHonor(context) || checkRuntimePermission(context, dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"));
    }

    public static boolean hasGetInstalledAppsPermissionFromHuawei(Context context) {
        Object[] objArrIsSupportRuntimeGIAPByHuawei = isSupportRuntimeGIAPByHuawei(context);
        return objArrIsSupportRuntimeGIAPByHuawei == null || objArrIsSupportRuntimeGIAPByHuawei.length != 2 || !((Boolean) objArrIsSupportRuntimeGIAPByHuawei[0]).booleanValue() || checkRuntimePermission(context, (String) objArrIsSupportRuntimeGIAPByHuawei[1]);
    }

    public static boolean hasGetInstalledAppsPermissionFromOppo(Context context) {
        return !isSupportRuntimeGIAPByOppo(context) || checkRuntimePermission(context, dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"));
    }

    public static boolean hasGetInstalledAppsPermissionFromVivo(Context context) {
        return !isSupportRuntimeGIAPByVivo(context) || checkRuntimePermission(context, dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"));
    }

    public static boolean hasGetInstalledAppsPermissionFromXiaomi(Context context) {
        return !isSupportRuntimeGIAPByXiaomi(context) || checkRuntimePermission(context, dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"));
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    public static boolean hasRuntimeGetInstalledAppsPermission(Context context, String str) {
        byte b;
        try {
            switch (str.hashCode()) {
                case -1706170181:
                    if (!str.equals(dexg.dexa("YJBPNJ"))) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 2432928:
                    if (!str.equals(dexg.dexa("PQQP"))) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 2634924:
                    if (!str.equals(dexg.dexa("WJWP"))) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 68924490:
                    if (!str.equals(dexg.dexa("IPOPS"))) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 2141820391:
                    if (!str.equals(dexg.dexa("IVBXFJ"))) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                return hasGetInstalledAppsPermissionFromVivo(context);
            }
            if (b == 1) {
                return hasGetInstalledAppsPermissionFromOppo(context);
            }
            if (b == 2) {
                return hasGetInstalledAppsPermissionFromXiaomi(context);
            }
            if (b == 3) {
                return hasGetInstalledAppsPermissionFromHuawei(context);
            }
            if (b != 4) {
                return false;
            }
            return hasGetInstalledAppsPermissionFromHonor(context);
        } catch (Throwable th) {
            DebugLog.common_w(dexg.dexa("ibtSvoujnfHfuJotubmmfeBqqtQfsnjttjpo!gbjm!") + th);
            return false;
        }
    }

    public static boolean isSupportRuntimeGIAPByHonor(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            int i = oppoSupportedRuntimeGIAPStatus;
            z = true;
            if (i == -1) {
                if (context.getPackageManager().getPermissionInfo(dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"), 0) != null) {
                    try {
                        oppoSupportedRuntimeGIAPStatus = 1;
                    } catch (Throwable th) {
                        th = th;
                        oppoSupportedRuntimeGIAPStatus = 0;
                        DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)ipops*!") + th);
                    }
                    z2 = z;
                } else {
                    oppoSupportedRuntimeGIAPStatus = 0;
                }
            } else if (i == 1) {
                z2 = z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!z2) {
            DebugLog.common_w(dexg.dexa("votvqqpsufe!hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo)ipops*"));
        }
        return z2;
    }

    public static Object[] isSupportRuntimeGIAPByHuawei(Context context) {
        boolean z;
        String str = "";
        try {
            int i = huaweiSupportedRuntimeGIAPStatus;
            if (i == -1) {
                String strDexa = dexg.dexa("dpn/ivbxfj/qfsnjttjpo/JOTUBMMFE`BQQT");
                String strDexa2 = dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT");
                PackageManager packageManager = context.getPackageManager();
                PermissionInfo permissionInfo = null;
                for (int i2 = 0; i2 < 2; i2++) {
                    String str2 = new String[]{strDexa, strDexa2}[i2];
                    try {
                        permissionInfo = packageManager.getPermissionInfo(str2, 0);
                        if (permissionInfo != null) {
                            str = str2;
                            break;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (permissionInfo != null) {
                    try {
                        huaweiSupportedRuntimeGIAPStatus = 1;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        huaweiSupportedRuntimeGIAPStatus = 0;
                        DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)ivbxfj*!") + th);
                    }
                } else {
                    huaweiSupportedRuntimeGIAPStatus = 0;
                }
                huaweiSupportedRuntimeGIAPStatus = 0;
                DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)ivbxfj*!") + th);
            } else {
                z = i == 1;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!z) {
            DebugLog.common_w(dexg.dexa("votvqqpsufe!hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo)ivbxfj*"));
        }
        return new Object[]{Boolean.valueOf(z), str};
    }

    public static boolean isSupportRuntimeGIAPByOppo(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            int i = oppoSupportedRuntimeGIAPStatus;
            z = true;
            if (i == -1) {
                if (context.getPackageManager().getPermissionInfo(dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"), 0) != null) {
                    try {
                        oppoSupportedRuntimeGIAPStatus = 1;
                    } catch (Throwable th) {
                        th = th;
                        oppoSupportedRuntimeGIAPStatus = 0;
                        DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)pqqp*!") + th);
                    }
                    z2 = z;
                } else {
                    oppoSupportedRuntimeGIAPStatus = 0;
                }
            } else if (i == 1) {
                z2 = z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!z2) {
            DebugLog.common_w(dexg.dexa("votvqqpsufe!hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo)pqqp*"));
        }
        return z2;
    }

    public static boolean isSupportRuntimeGIAPByVivo(Context context) {
        Object th;
        boolean z;
        boolean z2 = false;
        try {
            int i = vivoSupportedRuntimeGIAPStatus;
            if (i == -1) {
                z = Settings.Secure.getInt(context.getContentResolver(), dexg.dexa("pfn`jotubmmfe`bqqt`svoujnf`qfsnjttjpo`fobcmf"), 0) > 0;
                try {
                    if (z) {
                        vivoSupportedRuntimeGIAPStatus = 1;
                    } else {
                        vivoSupportedRuntimeGIAPStatus = 0;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    vivoSupportedRuntimeGIAPStatus = 0;
                    DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)wjwp*!") + th);
                }
                z2 = z;
            } else if (i == 1) {
                z2 = true;
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
        if (!z2) {
            DebugLog.common_w(dexg.dexa("votvqqpsufe!hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo)wjwp*"));
        }
        return z2;
    }

    public static boolean isSupportRuntimeGIAPByXiaomi(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            int i = xiaomiSupportedRuntimeGIAPStatus;
            z = true;
            if (i == -1) {
                PermissionInfo permissionInfo = context.getPackageManager().getPermissionInfo(dexg.dexa("dpn/boespje/qfsnjttjpo/HFU`JOTUBMMFE`BQQT"), 0);
                if (permissionInfo == null || !permissionInfo.packageName.equals(dexg.dexa("dpn/mcf/tfdvsjuz/njvj"))) {
                    xiaomiSupportedRuntimeGIAPStatus = 0;
                } else {
                    try {
                        xiaomiSupportedRuntimeGIAPStatus = 1;
                    } catch (Throwable th) {
                        th = th;
                        xiaomiSupportedRuntimeGIAPStatus = 0;
                        DebugLog.common_w(dexg.dexa("hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo!tubuvt!gbjm)yjbpnj*!") + th);
                    }
                    z2 = z;
                }
            } else if (i == 1) {
                z2 = z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!z2) {
            DebugLog.common_w(dexg.dexa("votvqqpsufe!hfu!jotubmmfe!bqqt!svoujnf!qfsnjttjpo)yjbpnj*"));
        }
        return z2;
    }

    public static void reportErrorInfo(Context context, String str, Throwable th) {
        ReportUtils.exReport(context, 900025, dexg.dexa("滕蕩苷灂礁砦楲鵦"), str + (th != null ? th.toString() : ""));
    }
}
