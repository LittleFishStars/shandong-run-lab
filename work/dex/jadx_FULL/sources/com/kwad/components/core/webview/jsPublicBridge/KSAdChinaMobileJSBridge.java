package com.kwad.components.core.webview.jsPublicBridge;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.acse.ottn.p3;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kwad.sdk.core.a.b;
import com.kwad.sdk.core.a.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.aq;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KSAdChinaMobileJSBridge {
    private static int aoN = 5000;
    private static final List<String> aoO = Arrays.asList("46000", "46002", "46007", "46004");
    private static final List<String> aoP = Arrays.asList("46003", "46005", "46011");
    private static final List<String> aoQ = Arrays.asList("46001", "46006", "46009");
    private WebView ade;
    private ConnectivityManager aoL;
    private TelephonyManager aoM;
    private Context mContext;

    public enum OperatorType {
        CHINA_MOBILE(1),
        CHINA_TELECOM(2),
        CHINA_UNICOM(3),
        NO_PHONE_NUMBER_ACCESS_PERMISSION_UNDER_WIFI(-1),
        DATA_NOT_OPENED(-2),
        FAIL(-3);

        public final int value;

        OperatorType(int i) {
            this.value = i;
        }
    }

    public KSAdChinaMobileJSBridge(WebView webView) {
        this.ade = webView;
        try {
            Context context = ServiceProvider.getContext();
            this.mContext = context;
            this.aoL = (ConnectivityManager) context.getSystemService("connectivity");
            this.aoM = (TelephonyManager) this.mContext.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            c.d("KSAdChinaMobileJSBridge", "init KSAdChinaMobileJSBridge succeed");
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
    }

    private void bv(String str) {
        try {
            Map<String, String> jSON2MapString = ac.parseJSON2MapString(str);
            String str2 = jSON2MapString.get("url");
            if (str2.isEmpty()) {
                t(-2, "url参数为空");
                return;
            }
            final URL url = new URL(str2);
            final String strBz = bz(jSON2MapString.get("method"));
            if (strBz.isEmpty()) {
                t(-2, "method参数为空");
                return;
            }
            jSON2MapString.get("operType");
            String str3 = jSON2MapString.get("headers");
            if (str3.isEmpty()) {
                t(-2, "headers参数为空");
                return;
            }
            final Map<String, String> jSON2MapString2 = ac.parseJSON2MapString(str3);
            final String str4 = jSON2MapString.get("params");
            if (str4.isEmpty()) {
                t(-2, "params参数为空");
                return;
            }
            this.aoL.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), new ConnectivityManager.NetworkCallback() { // from class: com.kwad.components.core.webview.jsPublicBridge.KSAdChinaMobileJSBridge.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public final void onAvailable(final Network network) {
                    new Thread(new Runnable() { // from class: com.kwad.components.core.webview.jsPublicBridge.KSAdChinaMobileJSBridge.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (!KSAdChinaMobileJSBridge.this.aoL.getNetworkCapabilities(network).hasTransport(0)) {
                                    KSAdChinaMobileJSBridge.this.t(-1, "network 移动数据未打开");
                                    return;
                                }
                                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) network.openConnection(url);
                                httpsURLConnection.setConnectTimeout(KSAdChinaMobileJSBridge.aoN);
                                httpsURLConnection.setReadTimeout(KSAdChinaMobileJSBridge.aoN);
                                httpsURLConnection.setRequestMethod(strBz);
                                for (Map.Entry entry : jSON2MapString2.entrySet()) {
                                    httpsURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                }
                                HashMap map = new HashMap();
                                String[] strArrB = KSAdChinaMobileJSBridge.b(KSAdChinaMobileJSBridge.this);
                                map.put("ipv4List", strArrB[0]);
                                map.put("ipv6List", strArrB[1]);
                                map.put("networkType", String.valueOf(KSAdChinaMobileJSBridge.this.ym()));
                                map.put(ALPParamConstant.PACKAGENAME, ((f) ServiceProvider.get(f.class)).getAppName());
                                String[] strArrBy = KSAdChinaMobileJSBridge.this.by(ac.parseMap2JSON(map).toString());
                                if (!strArrBy[0].isEmpty() && !strArrBy[1].isEmpty()) {
                                    httpsURLConnection.setRequestProperty("sdkSecret", strArrBy[0]);
                                    httpsURLConnection.setRequestProperty("sdkData", strArrBy[1]);
                                    if (strBz.equals("POST")) {
                                        httpsURLConnection.setDoOutput(true);
                                        httpsURLConnection.setRequestProperty("Charset", "UTF-8");
                                        httpsURLConnection.setRequestProperty("Content-Type", ze1.g);
                                        OutputStream outputStream = httpsURLConnection.getOutputStream();
                                        outputStream.write(str4.getBytes());
                                        outputStream.close();
                                    } else {
                                        httpsURLConnection.setDoOutput(false);
                                    }
                                    int responseCode = httpsURLConnection.getResponseCode();
                                    if (responseCode != 200) {
                                        KSAdChinaMobileJSBridge.this.t(responseCode, httpsURLConnection.getErrorStream().toString());
                                        return;
                                    }
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "UTF-8"));
                                    String str5 = "";
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            bufferedReader.close();
                                            KSAdChinaMobileJSBridge.this.bw(str5);
                                            KSAdChinaMobileJSBridge.this.aoL.unregisterNetworkCallback(this);
                                            return;
                                        }
                                        str5 = str5 + line;
                                    }
                                }
                            } catch (Exception e) {
                                c.printStackTraceOnly(e);
                                KSAdChinaMobileJSBridge.this.t(-5, e.getMessage());
                            }
                        }
                    }).start();
                }
            });
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            t(-5, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(String str) {
        final String str2 = String.format(Locale.US, "javascript:window.receiveNetworkSwitch({data:\"%s\", netType:%d})", bx(str), Integer.valueOf(ym()));
        this.ade.post(new Runnable() { // from class: com.kwad.components.core.webview.jsPublicBridge.KSAdChinaMobileJSBridge.2
            @Override // java.lang.Runnable
            public final void run() {
                c.d("KSAdChinaMobileJSBridge", "jsSuccessCall: " + str2);
                KSAdChinaMobileJSBridge.this.ade.evaluateJavascript(str2, null);
            }
        });
    }

    private static String bx(String str) {
        if (str == null) {
            return null;
        }
        return str.replace("\"", "\\\"");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] by(String str) {
        String[] strArr = new String[2];
        try {
            String strKX = e.KX();
            c.d("KSAdChinaMobileJSBridge", "public key is " + strKX);
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            c.d("KSAdChinaMobileJSBridge", "aesKey: " + bArr);
            String str2 = new String(com.kwad.sdk.core.a.c.LN().encode(g.e(bArr, strKX)), StandardCharsets.UTF_8);
            c.d("KSAdChinaMobileJSBridge", "sdkScret: " + str2);
            String str3 = new String(com.kwad.sdk.core.a.c.LN().encode(b.d(bArr, str)), StandardCharsets.UTF_8);
            c.d("KSAdChinaMobileJSBridge", "sdkData: " + str3);
            strArr[0] = str2;
            strArr[1] = str3;
        } catch (Exception e) {
            t(-3, e.getMessage());
        }
        return strArr;
    }

    private static String bz(String str) {
        if (str.equals("post")) {
            return "POST";
        }
        return str.equals(p3.f) ? "GET" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i, String str) {
        final String str2 = String.format(Locale.US, "javascript:window.receiveNetworkSwitch({resultCode: %d, desc: %s})", Integer.valueOf(i), str);
        this.ade.post(new Runnable() { // from class: com.kwad.components.core.webview.jsPublicBridge.KSAdChinaMobileJSBridge.3
            @Override // java.lang.Runnable
            public final void run() {
                c.d("KSAdChinaMobileJSBridge", "jsFailCall: " + str2);
                KSAdChinaMobileJSBridge.this.ade.evaluateJavascript(str2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ym() {
        try {
            if (this.aoL == null) {
                return -1;
            }
            boolean zIsDataEnabled = this.aoM.isDataEnabled();
            boolean zIsWifiConnected = aq.isWifiConnected(this.mContext);
            if (zIsDataEnabled && zIsWifiConnected) {
                return 3;
            }
            if (zIsDataEnabled) {
                return 1;
            }
            return zIsWifiConnected ? 2 : -1;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return -1;
        }
    }

    private static String[] yn() {
        String[] strArr = {"", ""};
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (!networkInterfaceNextElement.getName().toLowerCase().contains("wlan")) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && !inetAddressNextElement.isLinkLocalAddress()) {
                            String hostAddress = inetAddressNextElement.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (inetAddressNextElement instanceof Inet6Address) {
                                    sb.append(hostAddress);
                                    sb.append(",");
                                } else if (inetAddressNextElement instanceof Inet4Address) {
                                    sb2.append(hostAddress);
                                    sb2.append(",");
                                }
                            }
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(sb)) {
                sb = sb.delete(sb.length() - 1, sb.length());
            }
            if (!TextUtils.isEmpty(sb2)) {
                sb2 = sb2.delete(sb2.length() - 1, sb2.length());
            }
            strArr[0] = sb2.toString();
            strArr[1] = sb.toString();
            c.d("KSAdChinaMobileJSBridge", "ipv4List: " + strArr[0]);
            c.d("KSAdChinaMobileJSBridge", "ipv6List: " + strArr[1]);
        } catch (Exception unused) {
        }
        return strArr;
    }

    @JavascriptInterface
    @Keep
    public int ksadGetOperJudge() {
        try {
            c.d("KSAdChinaMobileJSBridge", "ksadGetOperJudge called");
            String simOperator = this.aoM.getSimOperator();
            if (aoO.contains(simOperator)) {
                return OperatorType.CHINA_MOBILE.value;
            }
            if (aoP.contains(simOperator)) {
                return OperatorType.CHINA_TELECOM.value;
            }
            if (aoQ.contains(simOperator)) {
                return OperatorType.CHINA_UNICOM.value;
            }
            c.d("KSAdChinaMobileJSBridge", "ksadGetOperJudge operator:" + simOperator + " not in list");
            return OperatorType.FAIL.value;
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return OperatorType.FAIL.value;
        }
    }

    @JavascriptInterface
    @Keep
    public void ksadGetPhoneNumber(String str) {
        if (!SystemUtil.b(this.mContext, "android.permission.ACCESS_NETWORK_STATE")) {
            t(-1, "无网络权限");
            return;
        }
        try {
            c.d("KSAdChinaMobileJSBridge", "ksadGetPhoneNumber called, data:" + str);
            int type = this.aoL.getActiveNetworkInfo().getType();
            if (type == 0) {
                bv(str);
                return;
            }
            boolean z = true;
            if (type == 1) {
                boolean z2 = 1 != this.aoM.getSimState();
                if (ContextCompat.checkSelfPermission(this.mContext, "android.permission.CHANGE_NETWORK_STATE") != 0) {
                    z = false;
                }
                Boolean boolValueOf = Boolean.valueOf(this.aoM.isDataEnabled());
                if (z2 && z && boolValueOf.booleanValue()) {
                    bv(str);
                    return;
                }
                if (!z2) {
                    t(-1, "sim卡不可用");
                } else if (!z) {
                    t(-1, "无网络切换权限");
                } else {
                    if (boolValueOf.booleanValue()) {
                        return;
                    }
                    t(-1, "移动数据未打开");
                }
            }
        } catch (Exception e) {
            t(-5, e.toString());
        }
    }

    public static /* synthetic */ String[] b(KSAdChinaMobileJSBridge kSAdChinaMobileJSBridge) {
        return yn();
    }
}
