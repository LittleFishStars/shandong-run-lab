package cj.mobile.wm.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cj.mobile.wm.aliagainstcheatingId.AliAgainstId;
import cj.mobile.wm.dexc;
import com.alipay.sdk.m.y.l;
import com.zj.adlib.c49;
import java.net.NetworkInterface;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeviceUtils {
    public static final String EMPTY_STRING = null;
    public static String androidId = "";
    public static String deviceBoard = "";
    public static float deviceDensity = 0.0f;
    public static String deviceDisplay = "";
    public static String deviceFingerprint = "";
    public static String deviceHardware = "";
    public static String deviceManufacturer = "";
    public static String deviceModel = "";
    public static String deviceResolutionHW = "";
    public static String deviceResolutionWH = "";
    public static int deviceType = -1;
    public static String deviceVendor = "";
    public static String imsi = "";
    public static boolean isCheckedAndroidId = false;
    public static boolean isCheckedDeviceBoard = false;
    public static boolean isCheckedDeviceDisplay = false;
    public static boolean isCheckedDeviceFingerprint = false;
    public static boolean isCheckedDeviceHardware = false;
    public static boolean isCheckedDeviceManufacturer = false;
    public static boolean isCheckedDeviceModel = false;
    public static boolean isCheckedDeviceVendor = false;
    public static boolean isCheckedImsi = false;
    public static boolean isCheckedMacAddress = false;
    public static boolean isCheckedMeid = false;
    public static String macAddress = "";
    public static String meid = null;
    public static String operatorValue = "";

    public static String concatString(Object... objArr) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (Object obj : objArr) {
                stringBuffer.append(obj);
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("dpodbuTusjoh!fssps-") + objArr + dexc.dexa(c49.f40900a) + th);
            return "";
        }
    }

    public static String getAndroidId(Context context) {
        if (isCheckedAndroidId) {
            DebugLog.common_debug(dexc.dexa("hfuBoespjeJe!dbdif!wbmje-boespjeJe"), androidId);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuBoespjeJe>>>>?"));
            long elapsedRealTime = Utils.getElapsedRealTime();
            try {
                String string = Settings.Secure.getString(context.getContentResolver(), dexc.dexa("boespje`je"));
                androidId = string;
                if (string == null) {
                    androidId = "";
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuBoespjeJe!gbjm!") + th);
            }
            long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
            if (elapsedRealTime2 > 10) {
                DebugLog.common_w(dexc.dexa("hfuBoespjeJe!") + elapsedRealTime2 + dexc.dexa("!nt"));
            }
            isCheckedAndroidId = true;
        }
        return androidId;
    }

    public static String getBootMark() {
        try {
            if (ConstantInfo.isCanUseBootId()) {
                return AliAgainstId.getBoot();
            }
            DebugLog.common_w(dexc.dexa("hfuCppuNbsl!qfsnjttjpo!efojfe"));
            return "";
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuCppuNbsl!gbjm!") + th);
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x008b  */
    public static int getConnectType(Context context) {
        byte b;
        int networkType;
        NetworkInfo activeNetworkInfo;
        long elapsedRealTime = Utils.getElapsedRealTime();
        int i = 0;
        try {
            String typeName = (!PermissionUtils.checkPermission(context, dexc.dexa("boespje/qfsnjttjpo/BDDFTT`OFUXPSL`TUBUF")) || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService(dexc.dexa("dpoofdujwjuz"))).getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
            int iHashCode = typeName.hashCode();
            if (iHashCode != -2015525726) {
                if (iHashCode != -1068855134) {
                    if (iHashCode != 0) {
                        if (iHashCode != 2664213) {
                            if (iHashCode == 3649301 && typeName.equals(dexc.dexa("xjgj"))) {
                                b = 0;
                            } else {
                                b = -1;
                            }
                        } else if (typeName.equals(dexc.dexa("XJGJ"))) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (typeName.equals("")) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (typeName.equals(dexc.dexa("npcjmf"))) {
                    b = 4;
                } else {
                    b = -1;
                }
            } else if (typeName.equals(dexc.dexa("NPCJMF"))) {
                b = 3;
            } else {
                b = -1;
            }
            if (b == 0 || b == 1) {
                i = 100;
            } else if (b != 2 && (b == 3 || b == 4)) {
                if (!ConstantInfo.isCanUsePhoneState()) {
                    DebugLog.common_w(dexc.dexa("hfuDpoofduUzqf!qfsnjttjpo!efojfe"));
                } else if (PermissionUtils.checkPermission(context, dexc.dexa("boespje/qfsnjttjpo/SFBE`QIPOF`TUBUF")) && (networkType = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getNetworkType()) != 20) {
                    switch (networkType) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            i = 2;
                            break;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            i = 3;
                            break;
                        case 13:
                            i = 4;
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuDpoofduUzqf!gbjm!") + th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.common_w(dexc.dexa("hfuDpoofduUzqf!") + elapsedRealTime2 + dexc.dexa("nt"));
        }
        return i;
    }

    public static String getDeviceBoard() {
        if (isCheckedDeviceBoard) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfCpbse!dbdif!wbmje-efwjdfCpbse"), deviceBoard);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfCpbse>>>>>?"));
            try {
                deviceBoard = Build.BOARD;
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfCpbse!gbjm-") + th);
            }
            isCheckedDeviceBoard = true;
        }
        return deviceBoard;
    }

    public static float getDeviceDensity(Context context) {
        if (deviceDensity <= 0.0f) {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfEfotjuz>>>>>?"));
            try {
                deviceDensity = context.getResources().getDisplayMetrics().density;
            } catch (Throwable th) {
                DebugLog.common_debug(dexc.dexa("hfuEfotjuz!gbjm!") + th);
            }
        } else {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfEfotjuz!dbdif!wbmje-efwjdfEfotjuz"), deviceDensity + "");
        }
        return deviceDensity;
    }

    public static String getDeviceDisplay() {
        if (isCheckedDeviceDisplay) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfEjtqmbz!dbdif!wbmje-efwjdfEjtqmbz"), deviceDisplay);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfEjtqmbz>>>>>?"));
            try {
                deviceDisplay = Build.DISPLAY;
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfEjtqmbz!gbjm-") + th);
            }
            isCheckedDeviceDisplay = true;
        }
        return deviceDisplay;
    }

    public static String getDeviceFingerprint() {
        if (isCheckedDeviceFingerprint) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfGjohfsqsjou!dbdif!wbmje-efwjdfGjohfsqsjou"), deviceFingerprint);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfGjohfsqsjou>>>>>?"));
            try {
                deviceFingerprint = Build.FINGERPRINT;
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfGjohfsqsjou!gbjm-") + th);
            }
            isCheckedDeviceFingerprint = true;
        }
        return deviceFingerprint;
    }

    public static String getDeviceHardware() {
        if (isCheckedDeviceHardware) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfIbsexbsf!dbdif!wbmje-efwjdfIbsexbsf"), deviceHardware);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfIbsexbsf>>>>>?"));
            try {
                deviceHardware = Build.HARDWARE;
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfIbsexbsf!gbjm-") + th);
            }
            isCheckedDeviceHardware = true;
        }
        return deviceHardware;
    }

    public static String getDeviceManufacturer() {
        if (isCheckedDeviceManufacturer) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfNbovgbduvsfs!dbdif!wbmje-efwjdfGjohfsqsjou"), deviceManufacturer);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfNbovgbduvsfs>>>>>?"));
            try {
                deviceManufacturer = Build.MANUFACTURER;
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfNbovgbduvsfs!gbjm-") + th);
            }
            isCheckedDeviceManufacturer = true;
        }
        return deviceManufacturer;
    }

    public static String getDeviceModel() {
        if (isCheckedDeviceModel) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfNpefm!dbdif!wbmje-efwjdfNpefm"), deviceModel);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfNpefm>>>>>?"));
            try {
                deviceModel = new String(Build.MODEL.getBytes(dexc.dexa("hcl")), dexc.dexa("vug.9"));
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfNpefm!gbjm-") + th);
            }
            isCheckedDeviceModel = true;
        }
        return deviceModel;
    }

    public static int getDeviceOrientation(Context context) {
        try {
            if (context.getResources().getConfiguration().orientation == 2) {
                return 1;
            }
            int i = context.getResources().getConfiguration().orientation;
            return 2;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuEfwjdfPsjfoubujpo!gbjm!") + th);
            return 2;
        }
    }

    public static String getDeviceResolution(Context context, boolean z) {
        try {
            if (z) {
                if (TextUtils.isEmpty(deviceResolutionWH)) {
                    DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfSftpmvujpo.efwjdfSftpmvujpoXI>>>>>?"));
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    deviceResolutionWH = concatString(Integer.valueOf(displayMetrics.widthPixels), dexc.dexa("y"), Integer.valueOf(displayMetrics.heightPixels));
                } else {
                    DebugLog.common_debug(dexc.dexa("hfuEfwjdfSftpmvujpo!dbdif!wbmje-efwjdfSftpmvujpoXI"), deviceResolutionWH);
                }
                return deviceResolutionWH;
            }
            if (TextUtils.isEmpty(deviceResolutionHW)) {
                DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfSftpmvujpo.efwjdfSftpmvujpoIX>>>>>?"));
                DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                int i = displayMetrics2.widthPixels;
                int i2 = displayMetrics2.heightPixels;
                if (i >= i2) {
                    deviceResolutionHW = concatString(Integer.valueOf(i2), dexc.dexa("y"), Integer.valueOf(displayMetrics2.widthPixels));
                } else {
                    deviceResolutionHW = concatString(Integer.valueOf(i), dexc.dexa("y"), Integer.valueOf(displayMetrics2.heightPixels));
                }
            } else {
                DebugLog.common_debug(dexc.dexa("hfuEfwjdfSftpmvujpo!dbdif!wbmje-efwjdfSftpmvujpoIX"), deviceResolutionHW);
            }
            return deviceResolutionHW;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuSftpmvujpo!fssps;") + th);
            return "";
        }
    }

    public static int getDeviceType(Context context) {
        if (deviceType == -1) {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfUzqf>>>>>?"));
            try {
                if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                    deviceType = 2;
                } else {
                    deviceType = 1;
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfUzqf!fssps;") + th);
            }
        } else {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfUzqf!dbdif!wbmje-efwjdfUzqf"), deviceType + "");
        }
        return deviceType;
    }

    public static String getDeviceVendor() {
        if (isCheckedDeviceVendor) {
            DebugLog.common_debug(dexc.dexa("hfuEfwjdfWfoeps!dbdif!wbmje-efwjdfWfoeps"), deviceVendor);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuEfwjdfWfoeps>>>>>?"));
            try {
                deviceVendor = new String(Build.BRAND.getBytes(dexc.dexa("hcl")), dexc.dexa("vug.9"));
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuEfwjdfWfoeps!gbjm-") + th);
            }
            isCheckedDeviceVendor = true;
        }
        return deviceVendor;
    }

    public static String getIMSI(Context context) {
        if (isCheckedImsi) {
            DebugLog.common_debug(dexc.dexa("hfuJNTJ!dbdif!wbmje-jntj"), imsi);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuJNTJ>>>>?"));
            long elapsedRealTime = Utils.getElapsedRealTime();
            try {
                String subscriberId = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getSubscriberId();
                imsi = subscriberId;
                if (subscriberId == null) {
                    imsi = "";
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuJNTJ!gbjm!") + th);
            }
            long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
            if (elapsedRealTime2 > 10) {
                DebugLog.common_w(dexc.dexa("hfuJNTJ!") + elapsedRealTime2 + dexc.dexa("!nt"));
            }
            isCheckedImsi = true;
        }
        return imsi;
    }

    public static String getMEID(Context context) {
        if (isCheckedMeid) {
            DebugLog.common_debug(dexc.dexa("hfuNFJE!dbdif!wbmje-nfje"), meid);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuNFJE>>>>?"));
            long elapsedRealTime = Utils.getElapsedRealTime();
            try {
                String deviceId = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getDeviceId();
                meid = deviceId;
                if (TextUtils.isEmpty(deviceId)) {
                    meid = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), dexc.dexa("boespje`je"));
                }
                if (meid == null) {
                    meid = "";
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuNFJE!gbjm!") + th);
            }
            long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
            if (elapsedRealTime2 > 10) {
                DebugLog.common_w(dexc.dexa("hfuNFJE!") + elapsedRealTime2 + dexc.dexa("!nt"));
            }
            isCheckedMeid = true;
        }
        return meid;
    }

    public static String getMacAddress(Context context) {
        if (isCheckedMacAddress) {
            DebugLog.common_debug(dexc.dexa("hfuNbdBeesftt!dbdif!wbmje-nbdBeesftt"), macAddress);
        } else {
            DebugLog.common_debug(dexc.dexa("ep!hfuNbdBeesftt>>>>>>?"));
            try {
                long elapsedRealTime = Utils.getElapsedRealTime();
                String macAddressByInterface = getMacAddressByInterface();
                macAddress = macAddressByInterface;
                macAddress = TextUtils.isEmpty(macAddressByInterface) ? dexc.dexa("131111111111") : macAddress;
                long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
                if (elapsedRealTime2 > 10) {
                    DebugLog.common_w(dexc.dexa("hfuNbdBeesftt!") + elapsedRealTime2 + dexc.dexa("!nt"));
                }
            } catch (Throwable th) {
                DebugLog.common_w(dexc.dexa("hfuNbdBeesftt!gbjm!") + th);
            }
            isCheckedMacAddress = true;
        }
        return macAddress;
    }

    public static String getMacAddressByDefault(Context context) {
        WifiManager wifiManager;
        try {
            if (PermissionUtils.checkPermission(context, dexc.dexa("boespje/qfsnjttjpo/BDDFTT`XJGJ`TUBUF")) && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(dexc.dexa("xjgj"))) != null && wifiManager.getConnectionInfo() != null && wifiManager.getConnectionInfo().getMacAddress() != null) {
                return wifiManager.getConnectionInfo().getMacAddress().replace(dexc.dexa(l.b), "").toUpperCase();
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuNbdBeesfttCzEfgbvmu!gbjm!") + th);
        }
        return "";
    }

    public static String getMacAddressByInterface() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(dexc.dexa("xmbo1"))) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format(dexc.dexa("&13Y;"), Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuNbdBeesfttCzJoufsgbdf!gbjm!") + th);
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004d  */
    public static String getMcc(Context context) {
        String strSubstring;
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            if (PermissionUtils.checkPermission(context, dexc.dexa("boespje/qfsnjttjpo/BDDFTT`OFUXPSL`TUBUF"))) {
                String simOperator = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getSimOperator();
                if (TextUtils.isEmpty(simOperator) || simOperator.length() < 5) {
                    strSubstring = "";
                } else {
                    strSubstring = simOperator.substring(0, 3);
                }
            } else {
                strSubstring = "";
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuNdd!gbjm!") + th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.common_w(dexc.dexa("hfuNdd!") + elapsedRealTime2 + dexc.dexa("!nt"));
        }
        return strSubstring;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004c  */
    public static String getMnc(Context context) {
        String strSubstring;
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            if (PermissionUtils.checkPermission(context, dexc.dexa("boespje/qfsnjttjpo/BDDFTT`OFUXPSL`TUBUF"))) {
                String simOperator = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getSimOperator();
                if (TextUtils.isEmpty(simOperator) || simOperator.length() < 5) {
                    strSubstring = "";
                } else {
                    strSubstring = simOperator.substring(3, 5);
                }
            } else {
                strSubstring = "";
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuNod!gbjm!") + th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.common_w(dexc.dexa("hfuNod!") + elapsedRealTime2 + dexc.dexa("!nt"));
        }
        return strSubstring;
    }

    public static String getOperator(Context context) {
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            String simOperator = ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getSimOperator();
            if (!TextUtils.isEmpty(simOperator) && simOperator.length() > 5) {
                operatorValue = simOperator.substring(0, 5);
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuPqfsbups!gbjm!") + th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.common_w(dexc.dexa("hfuPqfsbups!") + elapsedRealTime2 + dexc.dexa("!nt"));
        }
        return operatorValue;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00be  */
    public static int getOperatorType(Context context) {
        int i;
        long elapsedRealTime = Utils.getElapsedRealTime();
        try {
            String simOperator = !TextUtils.isEmpty(operatorValue) ? operatorValue : ((TelephonyManager) context.getSystemService(dexc.dexa("qipof"))).getSimOperator();
            if (TextUtils.isEmpty(simOperator)) {
                i = 99;
            } else if (simOperator.startsWith(dexc.dexa("57111")) || simOperator.startsWith(dexc.dexa("57113")) || simOperator.startsWith(dexc.dexa("57118")) || simOperator.startsWith(dexc.dexa("57115"))) {
                i = 1;
            } else if (simOperator.startsWith(dexc.dexa("57112")) || simOperator.startsWith(dexc.dexa("57117")) || simOperator.startsWith(dexc.dexa("5711:"))) {
                i = 3;
            } else if (simOperator.startsWith(dexc.dexa("57114")) || simOperator.startsWith(dexc.dexa("57116")) || simOperator.startsWith(dexc.dexa("57122"))) {
                i = 2;
            } else {
                i = 99;
            }
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuPqfsbupsUzqf!gbjm!") + th);
        }
        long elapsedRealTime2 = Utils.getElapsedRealTime() - elapsedRealTime;
        if (elapsedRealTime2 > 10) {
            DebugLog.common_w(dexc.dexa("hfuPqfsbupsUzqf!") + elapsedRealTime2 + dexc.dexa("!nt"));
        }
        return i;
    }

    @Deprecated
    public static String getUpdateMark() {
        try {
            return AliAgainstId.getUpdateV2();
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuVqebufNbsl!gbjm!") + th);
            return "";
        }
    }

    public static int getWindowHeight(Context context) {
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuXjoepxIfjhiu!fssps-") + th);
            return 0;
        }
    }

    public static float getWindowHeightDp(Context context) {
        float deviceDensity2 = getDeviceDensity(context);
        float windowHeight = getWindowHeight(context);
        if (deviceDensity2 <= 0.0f) {
            deviceDensity2 = 1.0f;
        }
        return (windowHeight / deviceDensity2) + 0.5f;
    }

    public static int getWindowWidth(Context context) {
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Throwable th) {
            DebugLog.common_w(dexc.dexa("hfuXjoepxXjeui!gbjm!") + th);
            return 0;
        }
    }

    public static float getWindowWidthDp(Context context) {
        float deviceDensity2 = getDeviceDensity(context);
        float windowWidth = getWindowWidth(context);
        if (deviceDensity2 <= 0.0f) {
            deviceDensity2 = 1.0f;
        }
        return (windowWidth / deviceDensity2) + 0.5f;
    }
}
