package com.byazt.fiq;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, 34})
public class a {
    public final Context c;
    public final com.byazt.fiq.c tt;
    public boolean ve = false;
    public int uj = 0;
    public int n = -3;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, 464})
    public static final class c {
        public static String c(int i) {
            switch (i) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH})
    public static class tt {
        public static volatile tt n;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f28544a;
        public ConnectivityManager c;
        public final Runnable sp = new Runnable() { // from class: com.byazt.fiq.a.tt.2
            @Override // java.lang.Runnable
            public void run() {
                tt.this.c();
            }
        };
        public Network tt;
        public boolean uj;
        public ConnectivityManager.NetworkCallback ve;

        private tt(Context context) {
            try {
                this.c = (ConnectivityManager) context.getSystemService("connectivity");
                this.f28544a = new Handler(Looper.getMainLooper());
            } catch (Exception e) {
                m.c(e);
            }
        }

        public static tt c(Context context) {
            if (n == null) {
                synchronized (tt.class) {
                    if (n == null) {
                        n = new tt(context);
                    }
                }
            }
            return n;
        }

        @TargetApi(21)
        public void c(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.f28544a.removeCallbacks(this.sp);
            ConnectivityManager connectivityManager = this.c;
            if (connectivityManager == null) {
                m.c("transmit_business", "forceNet mConnectivityManager is null");
                return;
            }
            Network network = this.tt;
            if (network != null && !this.uj && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                m.c("transmit_business", "forceNet reuse network");
                networkCallback.onAvailable(this.tt);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.ve;
            if (networkCallback2 != null) {
                try {
                    this.c.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e) {
                    m.c(e);
                    this.ve = null;
                }
                m.c("transmit_business", "forceNet clear");
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.byazt.fiq.a.tt.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (tt.this.c.getNetworkCapabilities(network2).hasTransport(0)) {
                            tt.this.tt = network2;
                            networkCallback.onAvailable(network2);
                            tt.this.uj = false;
                        } else {
                            m.c("transmit_business", "forceNet check fail...");
                            tt.this.tt = null;
                            networkCallback.onAvailable(null);
                            tt.this.uj = true;
                        }
                    } catch (Exception e2) {
                        m.c(e2);
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    tt.this.uj = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    networkCallback.onUnavailable();
                }
            };
            this.ve = networkCallback3;
            this.c.requestNetwork(networkRequestBuild, networkCallback3, 5000);
        }

        public void c(long j) {
            this.f28544a.postDelayed(this.sp, j);
        }

        public void c() {
            if (this.c == null) {
                return;
            }
            try {
                if (this.ve == null) {
                    return;
                }
                m.c("transmit_business", "unregisterNetwork");
                this.c.unregisterNetworkCallback(this.ve);
                this.ve = null;
                this.tt = null;
            } catch (Exception e) {
                m.c(e);
            }
        }
    }

    public a(Context context, com.byazt.fiq.c cVar) {
        this.c = context;
        this.tt = cVar;
    }

    public void c(String str, ve veVar) {
        if (veVar == null) {
            return;
        }
        boolean zC = n.c(this.c);
        this.uj = n.c(this.c, zC);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("headers");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> mapC = c(jSONObjectOptJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String strOptString = jSONObject.optString("url");
            this.tt.c("method", upperCase);
            this.tt.c("url", strOptString);
            this.n = jSONObject.optInt("operType");
            try {
                if (c(zC, this.tt, veVar)) {
                    if (this.ve) {
                        c(mapC, jSONObjectOptJSONObject2, veVar);
                    } else {
                        c(null, mapC, jSONObjectOptJSONObject2, veVar);
                    }
                }
            } catch (Throwable th) {
                m.c(th);
                veVar.c(false, this.uj, 102204, c.c(102204), null, null);
            }
        } catch (JSONException e) {
            m.c(e);
            veVar.c(false, this.uj, 102203, c.c(102203), null, null);
        }
    }

    private Map<String, List<String>> c(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                List list = (List) map.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(strOptString);
                    map.put(next, arrayList);
                } else {
                    list.add(strOptString);
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return map;
    }

    private boolean c(boolean z, com.byazt.fiq.c cVar, ve veVar) {
        cVar.c("networktype", this.uj);
        m.c("transmit_business", "preCheck networkType:" + this.uj);
        String packageName = this.c.getPackageName();
        String strC = com.byazt.fiq.tt.c(uj.c(this.c, packageName));
        cVar.c("apppackage", packageName);
        cVar.c("appsign", strC);
        int i = this.uj;
        if (i == 3) {
            this.ve = true;
        }
        if (!z) {
            veVar.c(false, i, 200010, c.c(200010), null, null);
            return false;
        }
        if (i == 0) {
            veVar.c(false, i, 102101, c.c(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        veVar.c(false, i, 102103, c.c(102103), null, null);
        return false;
    }

    @TargetApi(21)
    private void c(final Map<String, List<String>> map, final JSONObject jSONObject, final ve veVar) {
        m.c("transmit_business", "wifiSwitchAndDoRequest");
        final tt ttVarC = tt.c(this.c);
        tt.c(this.c).c(new ConnectivityManager.NetworkCallback() { // from class: com.byazt.fiq.a.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f28543a = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) throws Throwable {
                m.c("transmit_business", "wifiSwitchAndDoRequest onAvailable:".concat(String.valueOf(network)));
                if (this.f28543a.getAndSet(true) || network == null) {
                    return;
                }
                a.this.c(network, map, jSONObject, veVar);
                ttVarC.c(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                m.c("transmit_business", "wifiSwitchAndDoRequest onUnavailable");
                veVar.c(false, a.this.uj, 102508, c.c(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Network network, Map<String, List<String>> map, JSONObject jSONObject, ve veVar) throws Throwable {
        String strC = this.tt.c("url");
        String strC2 = this.tt.c("method");
        sp spVar = new sp(strC, strC2, map, jSONObject);
        spVar.c(this.tt.c("apppackage"));
        spVar.tt(this.tt.c("appsign"));
        if (p3.f.equalsIgnoreCase(strC2)) {
            spVar.c("Content-Type", "application/x-www-form-urlencoded");
        }
        try {
            com.byazt.zv.c.c(spVar, this.tt.tt("networktype"), this.tt.c("apppackage"), this.n);
            c(network, spVar, veVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:107:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:113:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:117:0x0204  */
    /* JADX WARN: Code duplicated, block: B:124:0x0219  */
    /* JADX WARN: Code duplicated, block: B:127:0x0224  */
    /* JADX WARN: Code duplicated, block: B:131:0x0230  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.byazt.fiq.a] */
    /* JADX WARN: Type inference failed for: r21v0, types: [com.byazt.fiq.ve] */
    @SuppressLint({"NewApi"})
    private void c(Network network, sp spVar, ve veVar) throws Throwable {
        StringBuilder sb;
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        OutputStream outputStream3;
        int i;
        OutputStream outputStream4;
        int responseCode;
        OutputStream outputStream5;
        ?? r12;
        ?? r13;
        int i2;
        HttpsURLConnection httpsURLConnection2;
        InputStream inputStream;
        InputStream inputStream2;
        m.c("transmit_business", "doRealTransmitRequest: " + spVar.tt());
        SystemClock.elapsedRealtime();
        String string = null;
        boolean z = false;
        try {
            URL url = new URL(spVar.tt());
            if (network != null) {
                httpsURLConnection2 = (HttpsURLConnection) network.openConnection(url);
            } else {
                httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
            }
            httpsURLConnection = httpsURLConnection2;
            try {
                Map<String, List<String>> mapC = spVar.c();
                if (mapC != null) {
                    for (String str : mapC.keySet()) {
                        List<String> list = mapC.get(str);
                        if (list != null) {
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                httpsURLConnection.addRequestProperty(str, it.next());
                            }
                        }
                    }
                }
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setInstanceFollowRedirects(false);
                httpsURLConnection.setConnectTimeout(5000);
                httpsURLConnection.setReadTimeout(5000);
                httpsURLConnection.setDefaultUseCaches(false);
                httpsURLConnection.setRequestMethod(spVar.uj());
                if (spVar.uj().equalsIgnoreCase("post")) {
                    m.c("transmit_business", "doRealTransmitRequest params:" + spVar.ve());
                    httpsURLConnection.setDoOutput(true);
                    outputStream = httpsURLConnection.getOutputStream();
                    try {
                        outputStream.write(spVar.ve().getBytes("utf-8"));
                        outputStream.flush();
                    } catch (IOException e) {
                        e = e;
                        sb = null;
                        outputStream3 = null;
                        responseCode = -1;
                        outputStream5 = outputStream3;
                        r13 = outputStream3;
                        try {
                            m.uj("transmit_business", "doRealTransmitRequest e: " + e.toString());
                            m.c(e);
                            if (e instanceof EOFException) {
                                i2 = 200050;
                            } else {
                                i2 = 102102;
                            }
                            int i3 = i2;
                            c(outputStream);
                            c(outputStream5);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            veVar.c(false, this.uj, i3, TextUtils.isEmpty(null) ? c.c(i3) : null, r13, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        } catch (Throwable th) {
                            th = th;
                            i = responseCode;
                            outputStream4 = outputStream5;
                            r12 = r13;
                            c(outputStream);
                            c(outputStream4);
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            veVar.c(false, this.uj, i, TextUtils.isEmpty(null) ? c.c(i) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        sb = null;
                        outputStream2 = null;
                        i = -1;
                        outputStream4 = outputStream2;
                        r12 = outputStream2;
                        c(outputStream);
                        c(outputStream4);
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        veVar.c(false, this.uj, i, TextUtils.isEmpty(null) ? c.c(i) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                        throw th;
                    }
                } else {
                    outputStream = null;
                }
                responseCode = httpsURLConnection.getResponseCode();
                try {
                    Map<String, List<String>> headerFields = httpsURLConnection.getHeaderFields();
                    try {
                        InputStream inputStream3 = httpsURLConnection.getInputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                try {
                                    try {
                                        int i4 = inputStream3.read(bArr);
                                        if (i4 <= 0) {
                                            break;
                                        } else {
                                            sb2.append(new String(bArr, 0, i4, "utf-8"));
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        sb = sb2;
                                        inputStream2 = inputStream3;
                                        r13 = headerFields;
                                        outputStream5 = inputStream2;
                                        m.uj("transmit_business", "doRealTransmitRequest e: " + e.toString());
                                        m.c(e);
                                        if (e instanceof EOFException) {
                                            i2 = 200050;
                                        } else {
                                            i2 = 102102;
                                        }
                                        int i5 = i2;
                                        c(outputStream);
                                        c(outputStream5);
                                        if (httpsURLConnection != null) {
                                            httpsURLConnection.disconnect();
                                        }
                                        veVar.c(false, this.uj, i5, TextUtils.isEmpty(null) ? c.c(i5) : null, r13, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    sb = sb2;
                                    inputStream = inputStream3;
                                    i = responseCode;
                                    r12 = headerFields;
                                    outputStream4 = inputStream;
                                    c(outputStream);
                                    c(outputStream4);
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    veVar.c(false, this.uj, i, TextUtils.isEmpty(null) ? c.c(i) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                                    throw th;
                                }
                            }
                            String string2 = sb2.toString();
                            if (!TextUtils.isEmpty(string2)) {
                                if (!string2.contains("getNewUnicomPhone") && !string2.contains("getTelecomPhone")) {
                                    try {
                                        JSONObject jSONObject = new JSONObject(sb2.toString());
                                        String string3 = jSONObject.getString("resultCode");
                                        if (string3 == null || !string3.equals("103000")) {
                                            string = jSONObject.getString("desc");
                                        } else {
                                            z = true;
                                            string = "取号成功";
                                        }
                                    } catch (Exception unused) {
                                    }
                                } else if ((string2.contains("\"result\":0") || string2.contains("\"result\":\"0\"")) && string2.contains("\"data\":")) {
                                    z = true;
                                    string = "取号成功";
                                } else {
                                    string = string2.contains("getNewUnicomPhone") ? "联通取号失败" : "电信取号失败";
                                }
                            }
                            c(outputStream);
                            c(inputStream3);
                            httpsURLConnection.disconnect();
                            veVar.c(z, this.uj, responseCode, TextUtils.isEmpty(string) ? c.c(responseCode) : string, headerFields, TextUtils.isEmpty(sb2) ? "" : sb2.toString());
                        } catch (IOException e3) {
                            e = e3;
                            sb = null;
                            inputStream2 = inputStream3;
                        } catch (Throwable th4) {
                            th = th4;
                            sb = null;
                            inputStream = inputStream3;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        sb = null;
                        inputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        sb = null;
                        inputStream = null;
                    }
                } catch (IOException e5) {
                    e = e5;
                    sb = null;
                    outputStream5 = null;
                    r13 = 0;
                } catch (Throwable th6) {
                    th = th6;
                    sb = null;
                    outputStream5 = null;
                    r13 = 0;
                    i = responseCode;
                    outputStream4 = outputStream5;
                    r12 = r13;
                    c(outputStream);
                    c(outputStream4);
                    if (httpsURLConnection != null) {
                        httpsURLConnection.disconnect();
                    }
                    veVar.c(false, this.uj, i, TextUtils.isEmpty(null) ? c.c(i) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
                sb = null;
                outputStream = null;
                outputStream3 = outputStream;
                responseCode = -1;
                outputStream5 = outputStream3;
                r13 = outputStream3;
                m.uj("transmit_business", "doRealTransmitRequest e: " + e.toString());
                m.c(e);
                if (e instanceof EOFException) {
                    i2 = 200050;
                } else {
                    i2 = 102102;
                }
                int i6 = i2;
                c(outputStream);
                c(outputStream5);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                veVar.c(false, this.uj, i6, TextUtils.isEmpty(null) ? c.c(i6) : null, r13, TextUtils.isEmpty(sb) ? "" : sb.toString());
            } catch (Throwable th7) {
                th = th7;
                sb = null;
                outputStream = null;
                outputStream2 = outputStream;
                i = -1;
                outputStream4 = outputStream2;
                r12 = outputStream2;
                c(outputStream);
                c(outputStream4);
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                }
                veVar.c(false, this.uj, i, TextUtils.isEmpty(null) ? c.c(i) : null, r12, TextUtils.isEmpty(sb) ? "" : sb.toString());
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            sb = null;
            httpsURLConnection = null;
            outputStream = null;
        } catch (Throwable th8) {
            th = th8;
            sb = null;
            httpsURLConnection = null;
            outputStream = null;
        }
    }

    private void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                m.c(e);
            }
        }
    }
}
