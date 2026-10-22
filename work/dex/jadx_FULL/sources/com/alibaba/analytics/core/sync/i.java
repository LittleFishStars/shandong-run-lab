package com.alibaba.analytics.core.sync;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import com.ut.mini.internal.CustomDNS;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i {
    public static int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static k f23796a;
    public static final com.alibaba.analytics.core.selfmonitor.g mMonitor;

    static {
        System.setProperty("http.keepAlive", "true");
        G = 0;
        f23796a = new k();
        mMonitor = new com.alibaba.analytics.core.selfmonitor.g();
    }

    public static b a(byte[] bArr) {
        String str;
        DataOutputStream dataOutputStream;
        com.alibaba.analytics.a.j.d();
        b bVar = new b();
        try {
            String strX = c.a().x();
            String[] strArrResolveUrl = CustomDNS.instance().resolveUrl(strX);
            DataOutputStream dataOutputStream2 = null;
            dataInputStream = null;
            DataInputStream dataInputStream = null;
            DataOutputStream dataOutputStream3 = null;
            DataOutputStream dataOutputStream4 = null;
            if (strArrResolveUrl == null || strArrResolveUrl.length < 2) {
                str = null;
            } else {
                strX = strArrResolveUrl[0];
                str = strArrResolveUrl[1];
            }
            URL url = new URL(strX);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (TextUtils.isEmpty(url.getHost())) {
                    return bVar;
                }
                SSLContext sSLContext = SSLContext.getInstance("SSL");
                sSLContext.init(null, j.getTrustManagers(), new SecureRandom());
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier(f23796a);
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setInstanceFollowRedirects(true);
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    if (!TextUtils.isEmpty(str)) {
                        httpURLConnection.setRequestProperty("Host", str);
                    }
                    String appkey = com.alibaba.analytics.core.d.a().getAppkey();
                    if (!TextUtils.isEmpty(appkey)) {
                        httpURLConnection.setRequestProperty("x-k", appkey);
                    }
                    try {
                        UTBaseRequestAuthentication uTBaseRequestAuthenticationM113a = com.alibaba.analytics.core.d.a().m113a();
                        if (uTBaseRequestAuthenticationM113a != null) {
                            String sign = uTBaseRequestAuthenticationM113a.getSign(com.alibaba.analytics.a.k.d(bArr));
                            com.alibaba.analytics.a.j.d("", "signValue", sign);
                            httpURLConnection.setRequestProperty("x-s", sign);
                            if (uTBaseRequestAuthenticationM113a instanceof UTBaseRequestAuthentication) {
                                if (uTBaseRequestAuthenticationM113a.isEncode()) {
                                    httpURLConnection.setRequestProperty("x-t", "2");
                                    com.alibaba.analytics.a.j.d("", "x-t", 2);
                                } else {
                                    httpURLConnection.setRequestProperty("x-t", "3");
                                    com.alibaba.analytics.a.j.d("", "x-t", 3);
                                }
                            } else if ((uTBaseRequestAuthenticationM113a instanceof UTSecuritySDKRequestAuthentication) || (uTBaseRequestAuthenticationM113a instanceof UTSecurityThridRequestAuthentication)) {
                                httpURLConnection.setRequestProperty("x-t", "1");
                                com.alibaba.analytics.a.j.d("", "x-t", 1);
                            }
                        }
                    } catch (Throwable th) {
                        com.alibaba.analytics.a.j.e("", th, new Object[0]);
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        try {
                            httpURLConnection.connect();
                            if (bArr == null || bArr.length <= 0) {
                                dataOutputStream = null;
                            } else {
                                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                try {
                                    dataOutputStream.write(bArr);
                                    dataOutputStream.flush();
                                } catch (SSLHandshakeException e) {
                                    e = e;
                                    dataOutputStream4 = dataOutputStream;
                                    com.alibaba.analytics.a.j.d("", e);
                                    if (com.alibaba.analytics.core.d.a().m115g()) {
                                        HashMap map = new HashMap();
                                        map.put("type", "3");
                                        mMonitor.a(com.alibaba.analytics.core.selfmonitor.f.a(com.alibaba.analytics.core.selfmonitor.f.k, JSON.toJSONString(map), Double.valueOf(1.0d)));
                                    }
                                    bVar.rt = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (dataOutputStream4 != null) {
                                        try {
                                            dataOutputStream4.close();
                                        } catch (IOException e2) {
                                            com.alibaba.analytics.a.j.d("", e2);
                                        }
                                    }
                                    return bVar;
                                } catch (Exception e3) {
                                    e = e3;
                                    dataOutputStream2 = dataOutputStream;
                                    com.alibaba.analytics.a.j.d("", e);
                                    bVar.rt = System.currentTimeMillis() - jCurrentTimeMillis;
                                    if (dataOutputStream2 != null) {
                                        try {
                                            dataOutputStream2.close();
                                        } catch (IOException e4) {
                                            com.alibaba.analytics.a.j.d("", e4);
                                        }
                                    }
                                    return bVar;
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataOutputStream3 = dataOutputStream;
                                    if (dataOutputStream3 != null) {
                                        try {
                                            dataOutputStream3.close();
                                        } catch (IOException e5) {
                                            com.alibaba.analytics.a.j.d("", e5);
                                        }
                                    }
                                    throw th;
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e6) {
                                    com.alibaba.analytics.a.j.d("", e6);
                                }
                            }
                            bVar.rt = System.currentTimeMillis() - jCurrentTimeMillis;
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                try {
                                    DataInputStream dataInputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                                    try {
                                        byte[] bArr2 = new byte[2048];
                                        while (true) {
                                            int i = dataInputStream2.read(bArr2, 0, 2048);
                                            if (i != -1) {
                                                byteArrayOutputStream.write(bArr2, 0, i);
                                            } else {
                                                try {
                                                    break;
                                                } catch (Exception e7) {
                                                    com.alibaba.analytics.a.j.d("", e7);
                                                }
                                            }
                                        }
                                        dataInputStream2.close();
                                    } catch (IOException e8) {
                                        e = e8;
                                        dataInputStream = dataInputStream2;
                                        com.alibaba.analytics.a.j.d("", e);
                                        if (dataInputStream != null) {
                                            try {
                                                dataInputStream.close();
                                            } catch (Exception e9) {
                                                com.alibaba.analytics.a.j.d("", e9);
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        dataInputStream = dataInputStream2;
                                        if (dataInputStream != null) {
                                            try {
                                                dataInputStream.close();
                                            } catch (Exception e10) {
                                                com.alibaba.analytics.a.j.d("", e10);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                }
                                if (byteArrayOutputStream.size() > 0) {
                                    int iA = a.a(byteArrayOutputStream.toByteArray());
                                    G = iA;
                                    bVar.w = iA;
                                    bVar.ba = a.aX;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (SSLHandshakeException e12) {
                        e = e12;
                    } catch (Exception e13) {
                        e = e13;
                    }
                } catch (ProtocolException e14) {
                    com.alibaba.analytics.a.j.e("", e14, new Object[0]);
                }
            }
            return bVar;
        } catch (MalformedURLException e15) {
            com.alibaba.analytics.a.j.e("", e15, new Object[0]);
            return bVar;
        } catch (IOException e16) {
            com.alibaba.analytics.a.j.e("", e16, new Object[0]);
            return bVar;
        } catch (Exception e17) {
            com.alibaba.analytics.a.j.e("", e17, new Object[0]);
            return bVar;
        }
    }
}
