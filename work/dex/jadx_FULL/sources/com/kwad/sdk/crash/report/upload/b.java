package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.baichuan.log.TLogConstant;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huachenjie.common.constants.UserConstants;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.y;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) throws Throwable {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String string = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + com.kwad.sdk.core.network.idc.a.Mo().Z("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", com.google.common.net.b.t0);
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + string);
                httpURLConnection2.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.hD(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", Consts.DOT + y.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty(com.google.common.net.b.p, "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(f(str4, map.get(str4), string));
                    }
                    byte[] bytes = ("\r\n--" + string + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(string);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = dataInputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else {
                                outputStream.write(bArr, 0, i2);
                            }
                        }
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(bytes);
                        outputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        cVar.code = responseCode;
                        cVar.aSW = responseCode;
                        if (responseCode == 200) {
                            cVar.aSY = h.inputStream2String(httpURLConnection2.getInputStream());
                            try {
                                if (new JSONObject(cVar.aSY).optInt("result", -1) == 1) {
                                    aVar.QK();
                                } else {
                                    e eVar = e.bgb;
                                    aVar.QJ();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.bgc;
                                aVar.QJ();
                            }
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aSY);
                        } else {
                            e eVar3 = e.bga;
                            e.bga.CZ();
                            aVar.QJ();
                            com.kwad.sdk.core.network.idc.a aVarMo = com.kwad.sdk.core.network.idc.a.Mo();
                            int i3 = cVar.code;
                            if (i3 == 0) {
                                i3 = -1;
                            }
                            aVarMo.a(str3, i3, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar4 = e.bga;
                            e.getCause();
                            aVar.QJ();
                            com.kwad.sdk.core.network.idc.a aVarMo2 = com.kwad.sdk.core.network.idc.a.Mo();
                            int i4 = cVar.code;
                            if (i4 != 0) {
                                i = i4;
                            }
                            aVarMo2.a(str3, i, e);
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] f(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap map = new HashMap();
        if (fVar == null) {
            return map;
        }
        if (!TextUtils.isEmpty(fVar.bgl)) {
            map.put("uploadToken", fVar.bgl);
        }
        if (!TextUtils.isEmpty(fVar.bgi)) {
            map.put(NotificationCompat.CATEGORY_SYSTEM, fVar.bgi);
        }
        if (!TextUtils.isEmpty(fVar.bgh)) {
            map.put("did", fVar.bgh);
        }
        if (!TextUtils.isEmpty(fVar.bgg)) {
            map.put(LoginConstants.SID, fVar.bgg);
        }
        if (!TextUtils.isEmpty(fVar.beC)) {
            map.put("appver", fVar.beC);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            map.put(TLogConstant.PERSIST_TASK_ID, fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.mToken)) {
            map.put("token", fVar.mToken);
        }
        if (!TextUtils.isEmpty(fVar.bgf)) {
            map.put(UserConstants.URL_PARAMS.b, fVar.bgf);
        }
        if (!TextUtils.isEmpty(fVar.bgj)) {
            map.put(MediationConstant.KEY_EXTRA_INFO, fVar.bgj);
        }
        return map;
    }

    public static void a(File file, f fVar, a aVar) throws Throwable {
        a(file, fVar.bgh, fVar.mToken, a(fVar), aVar);
    }
}
