package com.igexin.push.g;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.getui.gtc.base.util.CommonUtil;
import com.igexin.push.core.b.y;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38159a = "Task145PhoneDataUtils";

    private static int a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("wlan0".equalsIgnoreCase(networkInterfaceNextElement.getName())) {
                    for (InterfaceAddress interfaceAddress : networkInterfaceNextElement.getInterfaceAddresses()) {
                        InetAddress address = interfaceAddress.getAddress();
                        short networkPrefixLength = interfaceAddress.getNetworkPrefixLength();
                        if (!address.isLoopbackAddress() && (address instanceof Inet4Address)) {
                            com.igexin.c.a.c.a.b(f38159a, "IPv4 maskLength: ".concat(String.valueOf((int) networkPrefixLength)));
                            if (networkPrefixLength > 0) {
                                return networkPrefixLength;
                            }
                            return 24;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return 24;
    }

    private static String a(int i) {
        return (i & 255) + Consts.DOT + ((i >> 8) & 255) + Consts.DOT + ((i >> 16) & 255) + Consts.DOT + ((i >> 24) & 255);
    }

    public static String a(Context context) {
        String str = "";
        try {
            String str2 = c(context).b;
            try {
                com.igexin.c.a.c.a.b(f38159a, "new get self iv4 by dhcp, ip = ".concat(String.valueOf(str2)));
                if (!TextUtils.isEmpty(str2) && !"0.0.0.0".equalsIgnoreCase(str2)) {
                    return str2;
                }
                for (String str3 : b().split("#")) {
                    if (str3.contains("wlan0/ipv4")) {
                        String strReplace = str3.replace("wlan0/ipv4=", "");
                        if (strReplace.contains(WVNativeCallbackUtil.SEPERATER)) {
                            str2 = strReplace.split(WVNativeCallbackUtil.SEPERATER)[0];
                        }
                        str = str2;
                        com.igexin.c.a.c.a.b(f38159a, "new get self iv4 by sl, ip = ".concat(String.valueOf(str)));
                    }
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                str = str2;
                com.igexin.c.a.c.a.a(th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return str;
    }

    public static com.igexin.push.core.b.d b(Context context) {
        try {
            if (CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false) && d(context)) {
                return e(context);
            }
        } catch (Throwable unused) {
        }
        return new com.igexin.push.core.b.d();
    }

    /* JADX WARN: Code duplicated, block: B:55:0x013f  */
    private static String b() {
        Process processExec;
        char c;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec("ip addr");
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                    String strTrim = "";
                    String str = "";
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb2.append(line);
                            sb2.append("\n");
                            if (line.contains("link/ether")) {
                                String[] strArrSplit = str.split(u15.f19942b);
                                if (strArrSplit.length >= 2) {
                                    String strTrim2 = strArrSplit[1].trim();
                                    sb.append(line.replace("brd ff:ff:ff:ff:ff:ff", "").replace("link/ether ", strTrim2 + "/mac=").trim());
                                    sb.append("#");
                                }
                            }
                            str = line;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            try {
                                com.igexin.c.a.c.a.a(th);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e) {
                                        com.igexin.c.a.c.a.a(e);
                                    }
                                }
                                if (processExec != null) {
                                    processExec.destroy();
                                }
                                if (sb.toString().endsWith("#")) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                return sb.toString();
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        com.igexin.c.a.c.a.a(e2);
                                    }
                                }
                                if (processExec == null) {
                                    throw th2;
                                }
                                try {
                                    processExec.destroy();
                                    throw th2;
                                } catch (Throwable th3) {
                                    com.igexin.c.a.c.a.a(th3);
                                    throw th2;
                                }
                            }
                        }
                    }
                    Pattern patternCompile = Pattern.compile("[0-9]+");
                    String[] strArrSplit2 = sb2.toString().split("\n");
                    int length = strArrSplit2.length;
                    char c2 = 0;
                    int i = 0;
                    while (i < length) {
                        String str2 = strArrSplit2[i];
                        String[] strArrSplit3 = str2.split(u15.f19942b);
                        if (strArrSplit3.length >= 3 && patternCompile.matcher(strArrSplit3[c2].trim()).matches()) {
                            strTrim = strArrSplit3[1].trim();
                        }
                        if (str2.contains("inet")) {
                            String[] strArrSplit4 = str2.trim().split(" ");
                            c = 2;
                            if (strArrSplit4.length >= 2) {
                                sb.append(strTrim + WVNativeCallbackUtil.SEPERATER + strArrSplit4[c2].replace("inet6", "ipv6").replace("inet", "ipv4").trim() + "=" + strArrSplit4[1].trim());
                                sb.append("#");
                            }
                        } else {
                            c = 2;
                        }
                        i++;
                        c2 = 0;
                    }
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                    processExec.destroy();
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                com.igexin.c.a.c.a.a(th5);
            }
        } catch (Throwable th6) {
            th = th6;
            processExec = null;
        }
        if (sb.toString().endsWith("#")) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static y c(Context context) {
        com.igexin.c.a.c.a.b(f38159a, "SLMA getDhcpWifiInfo.");
        y yVar = new y();
        try {
            CommonUtil.hasPermission(context, com.kuaishou.weapon.p0.g.d, false);
            DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
            yVar.f37977a = a(dhcpInfo.gateway);
            yVar.b = a(dhcpInfo.ipAddress);
            yVar.c = a();
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
        return yVar;
    }

    private static boolean d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimState() == 5;
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
            return false;
        }
    }

    private static com.igexin.push.core.b.d e(Context context) {
        List<CellInfo> allCellInfo = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getAllCellInfo();
        if (allCellInfo == null || allCellInfo.isEmpty()) {
            return new com.igexin.push.core.b.d();
        }
        long cid = 0;
        int mcc = 0;
        int mnc = 0;
        int lac = 0;
        int i = 0;
        for (CellInfo cellInfo : allCellInfo) {
            if (cellInfo.isRegistered()) {
                if (cellInfo instanceof CellInfoGsm) {
                    CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                    mcc = cellIdentity.getMcc();
                    mnc = cellIdentity.getMnc();
                    lac = cellIdentity.getLac();
                    cid = cellIdentity.getCid();
                    i = 1;
                } else if (cellInfo instanceof CellInfoCdma) {
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    mnc = cellIdentity2.getSystemId();
                    lac = cellIdentity2.getNetworkId();
                    cid = cellIdentity2.getBasestationId();
                    i = 2;
                } else if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    mcc = cellIdentity3.getMcc();
                    mnc = cellIdentity3.getMnc();
                    lac = cellIdentity3.getLac();
                    cid = cellIdentity3.getCid();
                    i = 4;
                } else if (cellInfo instanceof CellInfoLte) {
                    CellIdentityLte cellIdentity4 = ((CellInfoLte) cellInfo).getCellIdentity();
                    mcc = cellIdentity4.getMcc();
                    mnc = cellIdentity4.getMnc();
                    lac = cellIdentity4.getTac();
                    cid = cellIdentity4.getCi();
                    i = 3;
                } else if ("android.telephony.CellInfoNr".equals(cellInfo.getClass().getName())) {
                    try {
                        Method method = Class.forName("android.telephony.CellInfoNr").getMethod("getCellIdentity", new Class[0]);
                        Class<?> cls = Class.forName("android.telephony.CellIdentityNr");
                        Method method2 = cls.getMethod("getMccString", new Class[0]);
                        Method method3 = cls.getMethod("getMncString", new Class[0]);
                        Method method4 = cls.getMethod("getTac", new Class[0]);
                        Method method5 = cls.getMethod("getNci", new Class[0]);
                        Object objInvoke = method.invoke(cellInfo, new Object[0]);
                        String str = (String) method2.invoke(objInvoke, new Object[0]);
                        String str2 = (String) method3.invoke(objInvoke, new Object[0]);
                        mcc = Integer.parseInt(str);
                        mnc = Integer.parseInt(str2);
                        lac = ((Integer) method4.invoke(objInvoke, new Object[0])).intValue();
                        cid = ((Long) method5.invoke(objInvoke, new Object[0])).longValue();
                        i = 6;
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }
            }
        }
        com.igexin.push.core.b.d dVar = new com.igexin.push.core.b.d();
        dVar.f37954a = mcc;
        dVar.b = mnc;
        dVar.c = lac;
        dVar.d = cid;
        dVar.e = i;
        return dVar;
    }

    private static boolean f(Context context) {
        return CommonUtil.hasPermission(context, Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 ? "android.permission.ACCESS_FINE_LOCATION" : "android.permission.ACCESS_COARSE_LOCATION", false);
    }
}
