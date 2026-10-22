package com.ali.auth.third.core.rpc;

import android.text.TextUtils;
import com.ali.auth.third.core.config.Environment;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.InternalSession;
import com.ali.auth.third.core.model.User;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.IOUtils;
import com.ali.auth.third.core.util.RSAKey;
import com.ali.auth.third.core.util.Rsa;
import com.alipay.sdk.m.y.o;
import com.zj.adlib.u15;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23428a = "b";

    private static String a(InputStream inputStream, String str) {
        String str2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            str2 = null;
            try {
                try {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RpcException("net work error");
                }
            } catch (JSONException e2) {
                e = e2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("response  =");
            sb.append(str2);
            sb.append(u15.f19942b);
            sb.append(e);
            throw new RpcException((Integer) 10, sb.toString() == null ? "" : e.getMessage());
        }
        String str3 = new String(byteArrayOutputStream.toByteArray(), str);
        try {
            String strA = com.ali.auth.third.core.rpc.protocol.b.a();
            String str4 = f23428a;
            SDKLogger.e(str4, "raw response = " + str3);
            String strB = com.ali.auth.third.core.rpc.c.a.b().b(str3, strA);
            SDKLogger.e(str4, "decrypt gateway response=" + strB);
            JSONObject jSONObject = new JSONObject(strB);
            int i2 = jSONObject.getInt(o.f25542a);
            if (i2 == 1000) {
                return jSONObject.getString("result");
            }
            throw new RpcException(Integer.valueOf(i2), o.b);
        } catch (JSONException e3) {
            str2 = str3;
            e = e3;
        }
    }

    public static String a(String str, String str2) throws Throwable {
        String strC;
        String rsaPubkey = RSAKey.getRsaPubkey();
        if (TextUtils.isEmpty(rsaPubkey)) {
            throw new IllegalArgumentException("get rsa from server failed!!!");
        }
        String strEncrypt = Rsa.encrypt(str, rsaPubkey);
        try {
            strC = com.ali.auth.third.core.rpc.c.a.b().c(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
            strC = null;
        }
        return String.format(Locale.getDefault(), "%08X%s%08X%s", Integer.valueOf(strEncrypt.length()), strEncrypt, Integer.valueOf(strC.length()), strC);
    }

    public static String a(String str, String str2, String str3) {
        String strA = com.ali.auth.third.core.rpc.protocol.a.a(16);
        com.ali.auth.third.core.rpc.protocol.b.a(strA);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("id=1&");
            sb.append("apiName=" + str + "&");
            sb.append("apiVersion=" + str2 + "&");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestData=");
            sb2.append(URLEncoder.encode(a(strA, str3), "UTF-8"));
            sb.append(sb2.toString());
            sb.append("&symType=AES");
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            SDKLogger.e(f23428a, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String b(String str, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        URL url;
        SDKLogger.d(f23428a, "post target = " + str + " params" + str3);
        OutputStreamWriter outputStreamWriter = null;
        try {
            if (KernelContext.getEnvironment() == Environment.PRE) {
                url = new URL("https://pre-tbusergw.taobao.com/gw.do");
            } else {
                url = KernelContext.getEnvironment() == Environment.TEST ? new URL("http://hz.tbusergw.taobao.net/gw.do") : new URL("https://mgw.m.taobao.com/gw.do");
            }
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                InternalSession internalSession = CredentialManager.INSTANCE.getInternalSession();
                User user = internalSession.user;
                if (user != null && !TextUtils.isEmpty(user.userId)) {
                    httpURLConnection.setRequestProperty("userid", internalSession.user.userId);
                }
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(httpURLConnection.getOutputStream());
                try {
                    outputStreamWriter2.write(a(str, str2, str3));
                    outputStreamWriter2.flush();
                    a.a(httpURLConnection.getResponseCode());
                    String strA = a(httpURLConnection.getInputStream(), a.a(httpURLConnection.getContentType()));
                    IOUtils.closeQuietly(outputStreamWriter2);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                    return strA;
                } catch (Throwable th) {
                    th = th;
                    outputStreamWriter = outputStreamWriter2;
                    try {
                        throw new RuntimeException(th);
                    } catch (Throwable th2) {
                        IOUtils.closeQuietly(outputStreamWriter);
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }
}
