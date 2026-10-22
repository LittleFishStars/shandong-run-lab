package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.secure.android.common.ssl.SecureSSLSocketFactory;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.zj.adlib.c30;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class w {

    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static n0 a(String str, byte[] bArr, Map<String, String> map) {
        return a(str, bArr, map, "POST");
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0149  */
    /* JADX WARN: Code duplicated, block: B:47:0x009d  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:79:0x0105  */
    /* JADX WARN: Code duplicated, block: B:87:0x011f  */
    /* JADX WARN: Code duplicated, block: B:95:0x0139  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v18, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v21, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v22, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v23, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v24, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v27 */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v30 */
    /* JADX WARN: Type inference failed for: r8v31 */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33, types: [java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.io.BufferedOutputStream, java.io.Closeable, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.io.Closeable] */
    public static n0 a(String str, byte[] bArr, Map<String, String> map, String str2) throws Throwable {
        HttpURLConnection httpURLConnectionA;
        ?? bufferedOutputStream;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        HttpURLConnection httpURLConnection3;
        HttpURLConnection httpURLConnection4;
        HttpURLConnection httpURLConnection5;
        HttpURLConnection httpURLConnection6;
        HttpURLConnection httpURLConnection7;
        if (TextUtils.isEmpty(str)) {
            return new n0(-100, "");
        }
        String str3 = null;
        int i = c30.i;
        try {
            try {
                httpURLConnectionA = a(str, bArr.length, (Map<String, String>) map, str2);
                try {
                    if (httpURLConnectionA == null) {
                        n0 n0Var = new n0(c30.h, "");
                        k1.a((Closeable) null);
                        k1.a((Closeable) null);
                        if (httpURLConnectionA != null) {
                            k1.a(httpURLConnectionA);
                        }
                        return n0Var;
                    }
                    map = httpURLConnectionA.getOutputStream();
                    try {
                        bufferedOutputStream = new BufferedOutputStream(map);
                        try {
                            try {
                                bufferedOutputStream.write(bArr);
                                bufferedOutputStream.flush();
                                int responseCode = httpURLConnectionA.getResponseCode();
                                try {
                                    n0 n0Var2 = new n0(responseCode, b(httpURLConnectionA));
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    k1.a(httpURLConnectionA);
                                    return n0Var2;
                                } catch (SecurityException unused) {
                                    i = responseCode;
                                    httpURLConnection7 = httpURLConnectionA;
                                    v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                                    n0 n0Var3 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection7 != null) {
                                        k1.a(httpURLConnection7);
                                    }
                                    return n0Var3;
                                } catch (ConnectException unused2) {
                                    i = responseCode;
                                    httpURLConnection6 = httpURLConnectionA;
                                    v.f("hmsSdk", "Network is unreachable or Connection refused");
                                    n0 n0Var4 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection6 != null) {
                                        k1.a(httpURLConnection6);
                                    }
                                    return n0Var4;
                                } catch (UnknownHostException unused3) {
                                    i = responseCode;
                                    httpURLConnection5 = httpURLConnectionA;
                                    v.f("hmsSdk", "No address associated with hostname or No network");
                                    n0 n0Var5 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection5 != null) {
                                        k1.a(httpURLConnection5);
                                    }
                                    return n0Var5;
                                } catch (SSLHandshakeException unused4) {
                                    i = responseCode;
                                    httpURLConnection4 = httpURLConnectionA;
                                    v.f("hmsSdk", "Chain validation failed,Certificate expired");
                                    n0 n0Var6 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection4 != null) {
                                        k1.a(httpURLConnection4);
                                    }
                                    return n0Var6;
                                } catch (SSLPeerUnverifiedException unused5) {
                                    i = responseCode;
                                    httpURLConnection3 = httpURLConnectionA;
                                    v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                                    n0 n0Var7 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection3 != null) {
                                        k1.a(httpURLConnection3);
                                    }
                                    return n0Var7;
                                } catch (IOException unused6) {
                                    i = responseCode;
                                    httpURLConnection2 = httpURLConnectionA;
                                    v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                                    n0 n0Var8 = new n0(i, "");
                                    k1.a((Closeable) bufferedOutputStream);
                                    k1.a((Closeable) map);
                                    if (httpURLConnection2 != null) {
                                        k1.a(httpURLConnection2);
                                    }
                                    return n0Var8;
                                }
                            } catch (a unused7) {
                                httpURLConnection = httpURLConnectionA;
                                v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                                n0 n0Var9 = new n0(c30.h, "");
                                k1.a((Closeable) bufferedOutputStream);
                                k1.a((Closeable) map);
                                if (httpURLConnection != null) {
                                    k1.a(httpURLConnection);
                                }
                                return n0Var9;
                            } catch (Throwable th) {
                                th = th;
                                k1.a((Closeable) bufferedOutputStream);
                                k1.a((Closeable) map);
                                if (httpURLConnectionA != null) {
                                    k1.a(httpURLConnectionA);
                                }
                                throw th;
                            }
                        } catch (SecurityException unused8) {
                        } catch (ConnectException unused9) {
                        } catch (UnknownHostException unused10) {
                        } catch (SSLHandshakeException unused11) {
                        } catch (SSLPeerUnverifiedException unused12) {
                        } catch (IOException unused13) {
                        }
                    } catch (a unused14) {
                        bufferedOutputStream = 0;
                        httpURLConnection = httpURLConnectionA;
                        v.f("hmsSdk", "PostRequest(byte[]): No ssl socket factory set!");
                        n0 n0Var10 = new n0(c30.h, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection != null) {
                            k1.a(httpURLConnection);
                        }
                        return n0Var10;
                    } catch (SecurityException unused15) {
                        bufferedOutputStream = 0;
                        httpURLConnection7 = httpURLConnectionA;
                        v.f("hmsSdk", "SecurityException with HttpClient. Please check INTERNET permission.");
                        n0 n0Var11 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection7 != null) {
                            k1.a(httpURLConnection7);
                        }
                        return n0Var11;
                    } catch (ConnectException unused16) {
                        bufferedOutputStream = 0;
                        httpURLConnection6 = httpURLConnectionA;
                        v.f("hmsSdk", "Network is unreachable or Connection refused");
                        n0 n0Var12 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection6 != null) {
                            k1.a(httpURLConnection6);
                        }
                        return n0Var12;
                    } catch (UnknownHostException unused17) {
                        bufferedOutputStream = 0;
                        httpURLConnection5 = httpURLConnectionA;
                        v.f("hmsSdk", "No address associated with hostname or No network");
                        n0 n0Var13 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection5 != null) {
                            k1.a(httpURLConnection5);
                        }
                        return n0Var13;
                    } catch (SSLHandshakeException unused18) {
                        bufferedOutputStream = 0;
                        httpURLConnection4 = httpURLConnectionA;
                        v.f("hmsSdk", "Chain validation failed,Certificate expired");
                        n0 n0Var14 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection4 != null) {
                            k1.a(httpURLConnection4);
                        }
                        return n0Var14;
                    } catch (SSLPeerUnverifiedException unused19) {
                        bufferedOutputStream = 0;
                        httpURLConnection3 = httpURLConnectionA;
                        v.f("hmsSdk", "Certificate has not been verified,Request is restricted!");
                        n0 n0Var15 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection3 != null) {
                            k1.a(httpURLConnection3);
                        }
                        return n0Var15;
                    } catch (IOException unused20) {
                        bufferedOutputStream = 0;
                        httpURLConnection2 = httpURLConnectionA;
                        v.f("hmsSdk", "events PostRequest(byte[]): IOException occurred.");
                        n0 n0Var16 = new n0(i, "");
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnection2 != null) {
                            k1.a(httpURLConnection2);
                        }
                        return n0Var16;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = str3;
                        k1.a((Closeable) bufferedOutputStream);
                        k1.a((Closeable) map);
                        if (httpURLConnectionA != null) {
                            k1.a(httpURLConnectionA);
                        }
                        throw th;
                    }
                } catch (a unused21) {
                    map = 0;
                } catch (SecurityException unused22) {
                    map = 0;
                } catch (ConnectException unused23) {
                    map = 0;
                } catch (UnknownHostException unused24) {
                    map = 0;
                } catch (SSLHandshakeException unused25) {
                    map = 0;
                } catch (SSLPeerUnverifiedException unused26) {
                    map = 0;
                } catch (IOException unused27) {
                    map = 0;
                } catch (Throwable th3) {
                    th = th3;
                    map = 0;
                }
            } catch (Throwable th4) {
                th = th4;
                httpURLConnectionA = null;
                str3 = str2;
            }
        } catch (a unused28) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SecurityException unused29) {
            httpURLConnectionA = null;
            map = 0;
        } catch (ConnectException unused30) {
            httpURLConnectionA = null;
            map = 0;
        } catch (UnknownHostException unused31) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SSLHandshakeException unused32) {
            httpURLConnectionA = null;
            map = 0;
        } catch (SSLPeerUnverifiedException unused33) {
            httpURLConnectionA = null;
            map = 0;
        } catch (IOException unused34) {
            httpURLConnectionA = null;
            map = 0;
        } catch (Throwable th5) {
            th = th5;
            httpURLConnectionA = null;
            map = 0;
        }
    }

    private static HttpURLConnection a(String str, int i, Map<String, String> map, String str2) throws ProtocolException, a {
        if (TextUtils.isEmpty(str)) {
            v.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        a(httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setReadTimeout(15000);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(i));
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && !TextUtils.isEmpty(key)) {
                    httpURLConnection.setRequestProperty(key, entry.getValue());
                }
            }
        }
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection) throws a {
        String str;
        SecureSSLSocketFactory secureSSLSocketFactory;
        if (httpURLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            try {
                secureSSLSocketFactory = SecureSSLSocketFactory.getInstance(q0.i());
            } catch (IOException unused) {
                str = "getSocketFactory(): IO Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (IllegalAccessException unused2) {
                str = "getSocketFactory(): Illegal Access Exception ";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (KeyStoreException unused3) {
                str = "getSocketFactory(): Key Store exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (NoSuchAlgorithmException unused4) {
                str = "getSocketFactory(): Algorithm Exception!";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            } catch (GeneralSecurityException unused5) {
                str = "getSocketFactory(): General Security Exception";
                v.f("hmsSdk", str);
                secureSSLSocketFactory = null;
            }
            if (secureSSLSocketFactory == null) {
                throw new a("No ssl socket factory set");
            }
            httpsURLConnection.setSSLSocketFactory(secureSSLSocketFactory);
            httpsURLConnection.setHostnameVerifier(new StrictHostnameVerifier());
        }
    }

    private static String b(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            return k1.a(inputStream);
        } catch (IOException unused) {
            v.f("hmsSdk", "When Response Content From Connection inputStream operation exception! " + httpURLConnection.getResponseCode());
            return "";
        } finally {
            k1.a((Closeable) inputStream);
        }
    }
}
