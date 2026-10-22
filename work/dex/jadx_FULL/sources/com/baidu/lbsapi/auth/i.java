package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26310a;
    private String e;
    private String g;
    private String h;
    private String b = null;
    private HashMap c = null;
    private String d = null;
    private int f = -1;

    public i(Context context) {
        this.f26310a = context;
    }

    private String a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT < 29) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (extraInfo == null || !(extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) {
                        return "wifi";
                    }
                    return extraInfo.trim().toLowerCase().equals("ctwap") ? "ctwap" : "cmwap";
                }
                return null;
            }
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "wifi";
            }
            boolean zHasTransport = networkCapabilities.hasTransport(1);
            boolean zHasTransport2 = networkCapabilities.hasTransport(0);
            boolean zHasTransport3 = networkCapabilities.hasTransport(3);
            boolean zHasTransport4 = networkCapabilities.hasTransport(6);
            boolean zHasTransport5 = networkCapabilities.hasTransport(4);
            boolean zHasTransport6 = networkCapabilities.hasTransport(5);
            if (zHasTransport) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (zHasTransport2) {
                return "CELLULAR";
            }
            if (zHasTransport3) {
                return "ETHERNET";
            }
            if (zHasTransport4) {
                return "LoWPAN";
            }
            if (zHasTransport5) {
                return "VPN";
            }
            return zHasTransport6 ? "WifiAware" : "wifi";
        } catch (Exception e) {
            if (b.f26304a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private static String a(HashMap map) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0160 A[Catch: all -> 0x0127, TryCatch #12 {all -> 0x0127, blocks: (B:7:0x002e, B:86:0x012c, B:88:0x0130, B:89:0x0133, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018b, B:114:0x018f, B:115:0x0192), top: B:151:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:114:0x018f A[Catch: all -> 0x0127, TryCatch #12 {all -> 0x0127, blocks: (B:7:0x002e, B:86:0x012c, B:88:0x0130, B:89:0x0133, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018b, B:114:0x018f, B:115:0x0192), top: B:151:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:131:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:145:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x01af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x0150 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:0x017e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b0 A[Catch: all -> 0x0102, TryCatch #3 {all -> 0x0102, blocks: (B:44:0x00ac, B:46:0x00b0, B:47:0x00cb), top: B:143:0x00ac }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00fd A[PHI: r5 r9 r13
      0x00fd: PHI (r5v1 boolean) = (r5v0 boolean), (r5v0 boolean), (r5v0 boolean), (r5v3 boolean) binds: [B:95:0x0157, B:108:0x0185, B:121:0x01b6, B:57:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r9v6 int) = (r3v2 int), (r3v2 int), (r3v2 int), (r9v22 int) binds: [B:95:0x0157, B:108:0x0185, B:121:0x01b6, B:57:0x00fb] A[DONT_GENERATE, DONT_INLINE]
      0x00fd: PHI (r13v21 'e' java.io.IOException) = 
      (r13v9 'e' java.io.IOException)
      (r13v14 'e' java.io.IOException)
      (r13v19 'e' java.io.IOException)
      (r13v43 'e' java.io.IOException)
     binds: [B:95:0x0157, B:108:0x0185, B:121:0x01b6, B:57:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x0105 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x0130 A[Catch: all -> 0x0127, TryCatch #12 {all -> 0x0127, blocks: (B:7:0x002e, B:86:0x012c, B:88:0x0130, B:89:0x0133, B:99:0x015c, B:101:0x0160, B:102:0x0163, B:112:0x018b, B:114:0x018f, B:115:0x0192), top: B:151:0x002e }] */
    /* JADX WARN: Instruction removed from duplicated block: B:131:0x01fa, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00b0, please report this as an issue */
    private void a(HttpsURLConnection httpsURLConnection) throws Throwable {
        BufferedReader bufferedReader;
        b.a("https Post start,url:" + this.b);
        if (this.c == null) {
            this.d = ErrorMessage.a("httpsPost request paramters is null.");
            return;
        }
        int responseCode = -1;
        OutputStream outputStream = null;
        BufferedReader bufferedReader2 = null;
        inputStream = null;
        InputStream inputStream = null;
        OutputStream outputStream2 = null;
        OutputStream outputStream3 = null;
        OutputStream outputStream4 = null;
        boolean z = false;
        try {
            try {
                OutputStream outputStream5 = httpsURLConnection.getOutputStream();
                try {
                    try {
                        try {
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream5, "UTF-8"));
                            bufferedWriter.write(a(this.c));
                            b.a(a(this.c));
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            httpsURLConnection.connect();
                            try {
                                InputStream inputStream2 = httpsURLConnection.getInputStream();
                                try {
                                    responseCode = httpsURLConnection.getResponseCode();
                                    if (200 == responseCode) {
                                        try {
                                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                                            try {
                                                StringBuffer stringBuffer = new StringBuffer();
                                                while (true) {
                                                    int i = bufferedReader.read();
                                                    if (i == -1) {
                                                        break;
                                                    } else {
                                                        stringBuffer.append((char) i);
                                                    }
                                                }
                                                this.d = stringBuffer.toString();
                                                bufferedReader2 = bufferedReader;
                                            } catch (IOException e) {
                                                e = e;
                                                inputStream = inputStream2;
                                                try {
                                                    if (b.f26304a) {
                                                        e.printStackTrace();
                                                        b.a("httpsPost parse failed;" + e.getMessage());
                                                    }
                                                    this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                                    if (inputStream != null && bufferedReader != null) {
                                                        bufferedReader.close();
                                                        inputStream.close();
                                                    }
                                                    httpsURLConnection.disconnect();
                                                } catch (Throwable th) {
                                                    th = th;
                                                    if (inputStream != null && bufferedReader != null) {
                                                        bufferedReader.close();
                                                        inputStream.close();
                                                    }
                                                    httpsURLConnection.disconnect();
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream = inputStream2;
                                                if (inputStream != null) {
                                                    bufferedReader.close();
                                                    inputStream.close();
                                                }
                                                httpsURLConnection.disconnect();
                                                throw th;
                                            }
                                        } catch (IOException e2) {
                                            e = e2;
                                            bufferedReader = null;
                                            inputStream = inputStream2;
                                            if (b.f26304a) {
                                                e.printStackTrace();
                                                b.a("httpsPost parse failed;" + e.getMessage());
                                            }
                                            this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                                            if (inputStream != null) {
                                                bufferedReader.close();
                                                inputStream.close();
                                            }
                                            httpsURLConnection.disconnect();
                                            if (outputStream5 != null) {
                                                try {
                                                    outputStream5.close();
                                                } catch (IOException e3) {
                                                    e = e3;
                                                    if (b.f26304a) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (z) {
                                            }
                                            if (this.d == null) {
                                                b.a("httpsPost failed,mResult is null");
                                                this.d = ErrorMessage.a(-1, "httpsPost failed,internal error");
                                                return;
                                            } else {
                                                b.a("httpsPost success end,parse result = " + this.d);
                                                return;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            bufferedReader = null;
                                            inputStream = inputStream2;
                                            if (inputStream != null) {
                                                bufferedReader.close();
                                                inputStream.close();
                                            }
                                            httpsURLConnection.disconnect();
                                            throw th;
                                        }
                                    }
                                    if (inputStream2 != null && bufferedReader2 != null) {
                                        bufferedReader2.close();
                                        inputStream2.close();
                                    }
                                    httpsURLConnection.disconnect();
                                    z = true;
                                } catch (IOException e4) {
                                    e = e4;
                                    responseCode = -1;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (IOException e5) {
                                e = e5;
                                responseCode = -1;
                                bufferedReader = null;
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedReader = null;
                            }
                            if (outputStream5 != null) {
                                outputStream5.close();
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            outputStream2 = outputStream5;
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (IOException e6) {
                                    if (b.f26304a) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (MalformedURLException e7) {
                        e = e7;
                        outputStream3 = outputStream5;
                        if (b.f26304a) {
                            e.printStackTrace();
                        }
                        this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e8) {
                                e = e8;
                                if (b.f26304a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException e9) {
                        e = e9;
                        outputStream4 = outputStream5;
                        if (b.f26304a) {
                            e.printStackTrace();
                        }
                        this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                        if (outputStream4 != null) {
                            try {
                                outputStream4.close();
                            } catch (IOException e10) {
                                e = e10;
                                if (b.f26304a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        outputStream = outputStream5;
                        if (b.f26304a) {
                            e.printStackTrace();
                        }
                        this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e12) {
                                e = e12;
                                if (b.f26304a) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (MalformedURLException e13) {
                    e = e13;
                    outputStream3 = outputStream5;
                    if (b.f26304a) {
                        e.printStackTrace();
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,MalformedURLException:" + e.getMessage());
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                } catch (IOException e14) {
                    e = e14;
                    outputStream4 = outputStream5;
                    if (b.f26304a) {
                        e.printStackTrace();
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,IOException:" + e.getMessage());
                    if (outputStream4 != null) {
                        outputStream4.close();
                    }
                } catch (Exception e15) {
                    e = e15;
                    outputStream = outputStream5;
                    if (b.f26304a) {
                        e.printStackTrace();
                    }
                    this.d = ErrorMessage.a(-11, "httpsPost failed,Exception:" + e.getMessage());
                    if (outputStream != null) {
                        outputStream.close();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (MalformedURLException e16) {
            e = e16;
        } catch (IOException e17) {
            e = e17;
        } catch (Exception e18) {
            e = e18;
        }
        if (z || 200 == responseCode) {
            if (this.d == null) {
                b.a("httpsPost failed,mResult is null");
                this.d = ErrorMessage.a(-1, "httpsPost failed,internal error");
                return;
            } else {
                b.a("httpsPost success end,parse result = " + this.d);
                return;
            }
        }
        b.a("httpsPost failed,statusCode:" + responseCode);
        this.d = ErrorMessage.a(-11, "httpsPost failed,statusCode:" + responseCode);
    }

    private HashMap b(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    private HttpsURLConnection b() {
        String str;
        URLConnection uRLConnectionOpenConnection;
        try {
            URL url = new URL(this.b);
            b.a("https URL: " + this.b);
            String strA = a(this.f26310a);
            if (strA != null && !strA.equals("")) {
                if (TextUtils.isEmpty(this.e) || this.f == -1) {
                    b.a("checkNetwork = " + strA);
                    uRLConnectionOpenConnection = url.openConnection();
                } else {
                    b.a("Proxy mProxyHost: = " + this.e + " mProxyPort: " + this.f);
                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.e, this.f));
                    Authenticator.setDefault(new j(this));
                    uRLConnectionOpenConnection = url.openConnection(proxy);
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                httpsURLConnection.setHostnameVerifier(new k(this));
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setConnectTimeout(50000);
                httpsURLConnection.setReadTimeout(50000);
                return httpsURLConnection;
            }
            b.c("Current network is not available.");
            this.d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (b.f26304a) {
                e.printStackTrace();
                b.a(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e2) {
            if (b.f26304a) {
                e2.printStackTrace();
                b.a(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        }
    }

    public String a(HashMap map, String str, int i, String str2, String str3) throws Throwable {
        HashMap mapB = b(map);
        this.c = mapB;
        this.b = (String) mapB.get("url");
        this.e = str;
        this.f = i;
        this.g = str2;
        this.h = str3;
        HttpsURLConnection httpsURLConnectionB = b();
        if (httpsURLConnectionB == null) {
            b.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(httpsURLConnectionB);
        }
        return this.d;
    }

    public boolean a() {
        b.a("checkNetwork start");
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f26310a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            b.a("checkNetwork end");
            return true;
        } catch (Exception e) {
            if (b.f26304a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
