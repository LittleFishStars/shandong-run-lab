package com.alipay.sdk.m.b0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.j;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static final String e = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    public static final String f = "AES/GCM/NoPadding";
    public static final String g = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkzi87lcyX1t/OSjlmjmj\nUFTAb0Y0wPZ79j10sjVrDtV+lMZXz/hOalITFyXRpmS8g8I1H3AlhihQQsierIFa\nQj5omUsXhzvNO+4DorkMJ14n1o1sfL0iOLTrzydghuUpyspj0M8v5bJTBbLv8DGM\nreKtJ8sbIYC5aj8pAdxn+YTnZ4Rhp/pNRbmIAlxs4Btu3whJt/RTfEASgsDRaTgO\nr9Rlj2YDiyEM4T3d0LsLjNed7B0Ogulzj6OzvHj+foIyb+YEEn6C5F9r+uNY2l2i\nYlHfaizd1HKfISrcAseJu6lGKRP0I3mv538Twqg1u0DFV6waQ9gwgOhq4ORCiNpd\nIQIDAQAB";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f25392a;
    public WeakReference<WebView> b;
    public WeakReference<com.alipay.sdk.m.w.a> c;
    public String d = j.a.f25532a;

    /* JADX INFO: renamed from: com.alipay.sdk.m.b0.a$a, reason: collision with other inner class name */
    public class RunnableC0188a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebView f25393a;
        public final /* synthetic */ String b;

        /* JADX INFO: renamed from: com.alipay.sdk.m.b0.a$a$a, reason: collision with other inner class name */
        public class C0189a implements ValueCallback<String> {
            public C0189a() {
            }

            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        public RunnableC0188a(WebView webView, String str) {
            this.f25393a = webView;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25393a.evaluateJavascript(this.b, new C0189a());
        }
    }

    public class b extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f25395a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;

        /* JADX INFO: renamed from: com.alipay.sdk.m.b0.a$b$a, reason: collision with other inner class name */
        public class RunnableC0190a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ConnectivityManager.NetworkCallback f25396a;

            public RunnableC0190a(ConnectivityManager.NetworkCallback networkCallback) {
                this.f25396a = networkCallback;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f25395a.unregisterNetworkCallback(this.f25396a);
            }
        }

        public b(ConnectivityManager connectivityManager, String str, String str2, Map map, String str3) {
            this.f25395a = connectivityManager;
            this.b = str;
            this.c = str2;
            this.d = map;
            this.e = str3;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge checkNetworkAndRequest onAvailable");
            try {
                if (this.f25395a.getNetworkCapabilities(network).hasTransport(0)) {
                    a.this.a(network, this.b, this.c, this.d, this.e, new RunnableC0190a(this));
                } else {
                    g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge sendNetworkByWifiBridge net error ");
                }
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f25397a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Runnable f;

        public c(Network network, String str, String str2, Map map, String str3, Runnable runnable) {
            this.f25397a = network;
            this.b = str;
            this.c = str2;
            this.d = map;
            this.e = str3;
            this.f = runnable;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00bf A[Catch: all -> 0x00ea, TRY_LEAVE, TryCatch #6 {all -> 0x00ea, blocks: (B:36:0x00b0, B:38:0x00bf), top: B:82:0x00b0 }] */
        /* JADX WARN: Code duplicated, block: B:50:0x00de  */
        /* JADX WARN: Code duplicated, block: B:54:0x00e6  */
        /* JADX WARN: Code duplicated, block: B:70:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:84:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() {
            OutputStream outputStream;
            BufferedReader bufferedReader;
            com.alipay.sdk.m.w.a aVar;
            HttpsURLConnection httpsURLConnection;
            Runnable runnable;
            StringBuilder sb = new StringBuilder();
            HttpsURLConnection httpsURLConnection2 = null;
            try {
                httpsURLConnection = (HttpsURLConnection) this.f25397a.openConnection(new URL(this.b));
                try {
                    httpsURLConnection.setRequestMethod(this.c.toUpperCase());
                    httpsURLConnection.setConnectTimeout(5000);
                    httpsURLConnection.setReadTimeout(5000);
                    for (String str : this.d.keySet()) {
                        httpsURLConnection.setRequestProperty(str, (String) this.d.get(str));
                    }
                    if (TextUtils.equals("POST", this.c.toUpperCase())) {
                        outputStream = httpsURLConnection.getOutputStream();
                        try {
                            outputStream.write(this.e.getBytes(StandardCharsets.UTF_8));
                            outputStream.flush();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = null;
                            httpsURLConnection2 = httpsURLConnection;
                            try {
                                g.a(th);
                                aVar = a.this.c.get();
                                if (aVar != null) {
                                    com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "AlipayChinaMobileBridge", "sendNetworkAsyncError");
                                }
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e) {
                                        g.a(e);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        g.a(e2);
                                    }
                                }
                                if (httpsURLConnection2 != null) {
                                    httpsURLConnection = httpsURLConnection2;
                                    httpsURLConnection.disconnect();
                                }
                                runnable = this.f;
                                if (runnable != null) {
                                    runnable.run();
                                }
                            } catch (Throwable th2) {
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e3) {
                                        g.a(e3);
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e4) {
                                        g.a(e4);
                                    }
                                }
                                if (httpsURLConnection2 == null) {
                                    throw th2;
                                }
                                httpsURLConnection2.disconnect();
                                throw th2;
                            }
                        }
                    } else {
                        outputStream = null;
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                            sb.append("\n");
                        } catch (Throwable th3) {
                            th = th3;
                            httpsURLConnection2 = httpsURLConnection;
                            g.a(th);
                            aVar = a.this.c.get();
                            if (aVar != null) {
                                com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "AlipayChinaMobileBridge", "sendNetworkAsyncError");
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (httpsURLConnection2 != null) {
                                httpsURLConnection = httpsURLConnection2;
                            }
                            runnable = this.f;
                            if (runnable != null) {
                                runnable.run();
                            }
                        }
                    }
                    a.this.b(sb.toString());
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e5) {
                            g.a(e5);
                        }
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        g.a(e6);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    outputStream = null;
                    bufferedReader = null;
                }
            } catch (Throwable th5) {
                th = th5;
                outputStream = null;
                bufferedReader = null;
            }
            httpsURLConnection.disconnect();
            runnable = this.f;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public a(Context context, WebView webView, com.alipay.sdk.m.w.a aVar) {
        this.f25392a = null;
        this.b = null;
        this.c = null;
        this.f25392a = new WeakReference<>(context);
        this.b = new WeakReference<>(webView);
        this.c = new WeakReference<>(aVar);
    }

    public final void b(String str) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge sendCallbackForSendNetwork:" + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            jSONObject.put("netType", this.d);
        } catch (Throwable th) {
            g.a(th);
        }
        c("window.receiveNetworkSwitch(" + jSONObject + ")");
    }

    public final void c(String str) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge sendWebCallback: " + str);
        WebView webView = this.b.get();
        if (webView == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new RunnableC0188a(webView, str));
    }

    @JavascriptInterface
    public int getMobileOperator(String str) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge getMobileOperator params: " + str);
        Context context = this.f25392a.get();
        if (context == null) {
            return -3;
        }
        try {
            String strA = a(context);
            if (!TextUtils.equals(strA, "46000") && !TextUtils.equals(strA, "46002") && !TextUtils.equals(strA, "46007") && !TextUtils.equals(strA, "46004")) {
                if (!TextUtils.equals(strA, "46003") && !TextUtils.equals(strA, "46005") && !TextUtils.equals(strA, "46011")) {
                    return (TextUtils.equals(strA, "46001") || TextUtils.equals(strA, "46006") || TextUtils.equals(strA, "46009")) ? 3 : -3;
                }
                return 2;
            }
            return 1;
        } catch (Throwable th) {
            g.a(th);
            return -3;
        }
    }

    @JavascriptInterface
    public void sendNetworkByWifiBridge(String str) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge sendNetworkSwitch params: " + str);
        if (TextUtils.isEmpty(str) || this.f25392a.get() == null) {
            return;
        }
        this.d = j.a.f25532a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("method");
            String string2 = jSONObject.getString("url");
            String string3 = jSONObject.getString("headers");
            String string4 = jSONObject.getString("params");
            HashMap map = new HashMap();
            JSONObject jSONObject2 = new JSONObject(string3);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject2.optString(next, ""));
            }
            a(map);
            a(string2, string, map, string4);
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public final String a(Context context) {
        if (context == null) {
            return "";
        }
        String simOperator = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator();
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge getMobileOperator: " + simOperator);
        return simOperator;
    }

    public final void a(String str, String str2, Map<String, String> map, String str3) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge checkNetworkAndRequest");
        Context context = this.f25392a.get();
        if (context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        connectivityManager.requestNetwork(new NetworkRequest.Builder().addCapability(12).addTransportType(0).build(), new b(connectivityManager, str, str2, map, str3));
    }

    public static String b() {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return sb.toString();
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if ((inetAddressNextElement instanceof Inet6Address) && !inetAddressNextElement.isLoopbackAddress()) {
                            String hostAddress = inetAddressNextElement.getHostAddress();
                            int iIndexOf = hostAddress.indexOf(37);
                            if (iIndexOf > 0) {
                                hostAddress = hostAddress.substring(0, iIndexOf);
                            }
                            arrayList.add(hostAddress);
                        }
                    }
                    for (String str : arrayList) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(str);
                    }
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            g.a(e2);
        }
    }

    public final void a(Network network, String str, String str2, Map<String, String> map, String str3, Runnable runnable) {
        g.b(com.alipay.sdk.m.n.a.B, "AlipayChinaMobileBridge sendNetworkAsync");
        com.alipay.sdk.m.q.a.a(new c(network, str, str2, map, str3, runnable));
    }

    public final void a(@NonNull Map<String, String> map) {
        g.b(com.alipay.sdk.m.n.a.B, "attachParamsToHeader");
        Context context = this.f25392a.get();
        if (context == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ipv4List", a());
            jSONObject.put("ipv6List", b());
            String strA = j.a(context);
            this.d = strA;
            jSONObject.put("networkType", strA);
            jSONObject.put(ALPParamConstant.PACKAGENAME, context.getPackageName());
            String string = jSONObject.toString();
            g.b(com.alipay.sdk.m.n.a.B, "AlipayJsBridge attachParamsToHeader sdkDataStr：" + string);
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            String strA2 = a(bArr, g);
            String strA3 = a(string.getBytes(), bArr);
            map.put("sdkSecret", strA2);
            map.put("sdkData", strA3);
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static String a() {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return sb.toString();
            }
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                            arrayList.add(inetAddressNextElement.getHostAddress());
                        }
                    }
                }
            }
            for (String str : arrayList) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
            return sb.toString();
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static String a(byte[] bArr, byte[] bArr2) throws Exception {
        Cipher cipher = Cipher.getInstance(f);
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new GCMParameterSpec(128, Arrays.copyOf(bArr2, 12)));
        return com.alipay.sdk.m.p.a.a(cipher.doFinal(bArr));
    }

    public static String a(byte[] bArr, String str) throws Exception {
        if (bArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        RSAPublicKey rSAPublicKeyA = a(str);
        Cipher cipher = Cipher.getInstance(e);
        cipher.init(1, rSAPublicKeyA);
        return com.alipay.sdk.m.p.a.a(a(bArr, cipher, (rSAPublicKeyA.getModulus().bitLength() / 8) - 66));
    }

    public static RSAPublicKey a(String str) throws Exception {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.alipay.sdk.m.p.a.a(str)));
    }

    public static byte[] a(byte[] bArr, Cipher cipher, int i) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int length = bArr.length;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = length - i2;
                if (i4 > 0) {
                    byte[] bArrDoFinal = cipher.doFinal(bArr, i2, Math.min(i4, i));
                    byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                    i3++;
                    i2 = i3 * i;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
