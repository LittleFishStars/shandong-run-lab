package com.beizi.fusion;

import android.content.Context;
import android.os.Debug;
import android.text.TextUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.androidquery.callback.AbstractAjaxCallback;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.huawei.hms.adapter.internal.CommonCode;
import com.kc.openset.constant.DeviceIdType;
import com.zj.adlib.ze1;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class m9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f27537a = "HttpUtil";

    /* JADX WARN: Code duplicated, block: B:47:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00be A[Catch: IOException -> 0x00ba, TryCatch #0 {IOException -> 0x00ba, blocks: (B:44:0x00b6, B:48:0x00be, B:50:0x00c3), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c3 A[Catch: IOException -> 0x00ba, TRY_LEAVE, TryCatch #0 {IOException -> 0x00ba, blocks: (B:44:0x00b6, B:48:0x00be, B:50:0x00c3), top: B:80:0x00b6 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00df A[Catch: IOException -> 0x00db, TryCatch #13 {IOException -> 0x00db, blocks: (B:58:0x00d7, B:62:0x00df, B:64:0x00e4), top: B:91:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e4 A[Catch: IOException -> 0x00db, TRY_LEAVE, TryCatch #13 {IOException -> 0x00db, blocks: (B:58:0x00d7, B:62:0x00df, B:64:0x00e4), top: B:91:0x00d7 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00f7 A[Catch: IOException -> 0x00f3, TryCatch #4 {IOException -> 0x00f3, blocks: (B:70:0x00ef, B:74:0x00f7, B:76:0x00fc), top: B:82:0x00ef }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00fc A[Catch: IOException -> 0x00f3, TRY_LEAVE, TryCatch #4 {IOException -> 0x00f3, blocks: (B:70:0x00ef, B:74:0x00f7, B:76:0x00fc), top: B:82:0x00ef }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static String a(String e, String str) {
        ?? r0;
        ?? r1;
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                e = (HttpURLConnection) new URL(e).openConnection();
                try {
                    e.setRequestMethod("GET");
                    e.setConnectTimeout(10000);
                    e.setReadTimeout(5000);
                    e.setUseCaches(false);
                    if (!TextUtils.isEmpty(str)) {
                        e.setRequestProperty("User-Agent", str);
                    }
                    e.setChunkedStreamingMode(0);
                    e.setRequestProperty("Connection", "close");
                    e.setDoInput(true);
                    e.connect();
                    int responseCode = e.getResponseCode();
                    jh.a(f27537a, "get code:" + responseCode);
                    if (responseCode != 200) {
                        try {
                            e.disconnect();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                        return null;
                    }
                    str = e.getInputStream();
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(str));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                stringBuffer.append(line);
                            } catch (Exception e4) {
                                e2 = e4;
                            } catch (Throwable th2) {
                                th = th2;
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                        if (str != 0) {
                                            str.close();
                                        }
                                        if (e != 0) {
                                            e.disconnect();
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                        e.printStackTrace();
                                    }
                                } else {
                                    if (str != 0) {
                                        str.close();
                                    }
                                    if (e != 0) {
                                        e.disconnect();
                                    }
                                }
                                return null;
                            }
                        }
                        String string = stringBuffer.toString();
                        try {
                            bufferedReader.close();
                            if (str != 0) {
                                str.close();
                            }
                            e.disconnect();
                            return string;
                        } catch (IOException e6) {
                            e6.printStackTrace();
                            return string;
                        }
                    } catch (Exception e7) {
                        r1 = str;
                        e = e7;
                        e = e;
                        bufferedReader = null;
                        ?? r5 = r1;
                        e2 = e;
                        str = r5;
                    } catch (Throwable th3) {
                        r0 = str;
                        th = th3;
                        e = e;
                        bufferedReader = null;
                        ?? r6 = r0;
                        th = th;
                        str = r6;
                        th.printStackTrace();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                            if (str != 0) {
                                str.close();
                            }
                            if (e != 0) {
                                e.disconnect();
                            }
                        } else {
                            if (str != 0) {
                                str.close();
                            }
                            if (e != 0) {
                                e.disconnect();
                            }
                        }
                        return null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    r1 = 0;
                    e = e;
                } catch (Throwable th4) {
                    th = th4;
                    r0 = 0;
                    e = e;
                }
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        if (str != 0) {
                            str.close();
                        }
                        if (e != 0) {
                            e.disconnect();
                        }
                    } catch (IOException e9) {
                        e9.printStackTrace();
                        throw th5;
                    }
                } else {
                    if (str != 0) {
                        str.close();
                    }
                    if (e != 0) {
                        e.disconnect();
                    }
                }
                throw th5;
            }
        } catch (Exception e10) {
            e = e10;
            e = 0;
            r1 = 0;
        } catch (Throwable th6) {
            th = th6;
            e = 0;
            r0 = 0;
        }
        bufferedReader = null;
        ?? r7 = r1;
        e2 = e;
        str = r7;
        e2.printStackTrace();
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
                if (str != 0) {
                    str.close();
                }
                if (e != 0) {
                    e.disconnect();
                }
            } catch (IOException e11) {
                e = e11;
                e.printStackTrace();
            }
        } else {
            if (str != 0) {
                str.close();
            }
            if (e != 0) {
                e.disconnect();
            }
        }
        return null;
    }

    private static byte[] b(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", "5.5.0.2");
            jSONObject.put("srcType", 1);
            jSONObject.put("timeStamp", System.currentTimeMillis());
            jSONObject.put("appid", str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", 2);
            jSONObject2.put("devType", Integer.valueOf(devInfo.getDevType()));
            jSONObject2.put("brand", devInfo.getBrand());
            jSONObject2.put(ze1.k, devInfo.getModel());
            jSONObject2.put(CommonCode.MapKey.HAS_RESOLUTION, devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put(MediaFormat.KEY_LANGUAGE, devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("net", Integer.valueOf(envInfo.getNet()));
            jSONObject3.put("isp", Integer.valueOf(envInfo.getIsp()));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String strB = i2.b(qg.b(), jSONObject.toString());
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            return strB.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x00fe A[EXC_TOP_SPLITTER, PHI: r1 r2 r3 r7 r8
      0x00fe: PHI (r1v10 java.io.OutputStream) = (r1v9 java.io.OutputStream), (r1v12 java.io.OutputStream), (r1v28 java.io.OutputStream) binds: [B:67:0x00d6, B:84:0x00fc, B:42:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r2v8 ??) = (r2v7 ??), (r2v10 ??), (r2v15 ??) binds: [B:67:0x00d6, B:84:0x00fc, B:42:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r3v4 java.io.BufferedReader) = (r3v3 java.io.BufferedReader), (r3v6 java.io.BufferedReader) binds: [B:67:0x00d6, B:84:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r7v13 'e' ??) = (r7v12 'e' ??), (r7v18 'e' ??), (r7v20 'e' ??) binds: [B:67:0x00d6, B:84:0x00fc, B:42:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00fe: PHI (r8v11 ??) = (r8v10 ??), (r8v13 ??), (r8v18 ??) binds: [B:67:0x00d6, B:84:0x00fc, B:42:0x00a1] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c6 A[Catch: IOException -> 0x00d2, TryCatch #9 {IOException -> 0x00d2, blocks: (B:58:0x00c1, B:60:0x00c6, B:62:0x00cb, B:63:0x00ce), top: B:114:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00cb A[Catch: IOException -> 0x00d2, TryCatch #9 {IOException -> 0x00d2, blocks: (B:58:0x00c1, B:60:0x00c6, B:62:0x00cb, B:63:0x00ce), top: B:114:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00ec A[Catch: IOException -> 0x00f8, TryCatch #2 {IOException -> 0x00f8, blocks: (B:75:0x00e7, B:77:0x00ec, B:79:0x00f1, B:80:0x00f4), top: B:107:0x00e7 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00f1 A[Catch: IOException -> 0x00f8, TryCatch #2 {IOException -> 0x00f8, blocks: (B:75:0x00e7, B:77:0x00ec, B:79:0x00f1, B:80:0x00f4), top: B:107:0x00e7 }] */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a1, code lost:
    
        if (r1 != null) goto L118;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.io.InputStreamReader, java.io.Reader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.InputStreamReader] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20, types: [java.net.HttpURLConnection, java.net.URLConnection] */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r8v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v18, types: [int] */
    /* JADX WARN: Type inference failed for: r8v19, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String e, byte[] bArr) {
        ?? r7;
        OutputStream outputStream;
        ?? r8;
        OutputStream outputStream2;
        OutputStream outputStream3;
        OutputStream outputStream4;
        ?? r1;
        Throwable th;
        BufferedReader bufferedReader;
        OutputStream outputStream5;
        ?? inputStreamReader;
        ?? r2;
        Exception e2;
        try {
            try {
                e = (HttpURLConnection) new URL(e).openConnection();
                try {
                    e.setRequestMethod("POST");
                    e.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                    e.setRequestProperty("Content-Type", ze1.g);
                    e.setConnectTimeout(20000);
                    e.setReadTimeout(20000);
                    e.setDoOutput(true);
                    e.setDoInput(true);
                    e.connect();
                    if (bArr.length > 0) {
                        outputStream5 = e.getOutputStream();
                        try {
                            outputStream5.write((byte[]) bArr);
                            outputStream5 = outputStream5;
                        } catch (Exception e3) {
                            e = e3;
                            outputStream4 = outputStream5;
                            r2 = 0;
                            e = e;
                            e2 = e;
                            bufferedReader = null;
                            bArr = r2;
                            outputStream5 = outputStream4;
                            inputStreamReader = 0;
                            e2.printStackTrace();
                            e = e;
                            if (bArr != 0) {
                                try {
                                    bArr.close();
                                    if (inputStreamReader != 0) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    e.disconnect();
                                    e = e;
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    e = e4;
                                }
                            }
                            if (outputStream5 != null) {
                                try {
                                    outputStream5.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    e.printStackTrace();
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream3 = outputStream5;
                            r1 = 0;
                            e = e;
                            th = th;
                            bufferedReader = null;
                            bArr = r1;
                            outputStream5 = outputStream3;
                            inputStreamReader = 0;
                            th.printStackTrace();
                            e = e;
                            if (bArr != 0) {
                                try {
                                    bArr.close();
                                    if (inputStreamReader != 0) {
                                        inputStreamReader.close();
                                    }
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    e.disconnect();
                                    e = e;
                                } catch (IOException e6) {
                                    e6.printStackTrace();
                                    e = e6;
                                }
                            }
                            if (outputStream5 != null) {
                                outputStream5.close();
                            }
                            return null;
                        }
                    } else {
                        outputStream5 = null;
                    }
                    bArr = e.getResponseCode();
                    inputStreamReader = 200;
                    if (bArr == 200) {
                        bArr = e.getInputStream();
                        try {
                            inputStreamReader = new InputStreamReader(bArr);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        stringBuffer.append(line);
                                    }
                                    String string = stringBuffer.toString();
                                    if (bArr != 0) {
                                        try {
                                            bArr.close();
                                            inputStreamReader.close();
                                            bufferedReader.close();
                                            e.disconnect();
                                        } catch (IOException e7) {
                                            e7.printStackTrace();
                                        }
                                    }
                                    if (outputStream5 != null) {
                                        try {
                                            outputStream5.close();
                                        } catch (IOException e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    return string;
                                } catch (Exception e9) {
                                    e2 = e9;
                                    e2.printStackTrace();
                                    e = e;
                                    if (bArr != 0) {
                                        bArr.close();
                                        if (inputStreamReader != 0) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        e.disconnect();
                                        e = e;
                                    }
                                    if (outputStream5 != null) {
                                        outputStream5.close();
                                    }
                                    return null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    th.printStackTrace();
                                    e = e;
                                    if (bArr != 0) {
                                        bArr.close();
                                        if (inputStreamReader != 0) {
                                            inputStreamReader.close();
                                        }
                                        if (bufferedReader != null) {
                                            bufferedReader.close();
                                        }
                                        e.disconnect();
                                        e = e;
                                    }
                                    if (outputStream5 != null) {
                                        outputStream5.close();
                                    }
                                    return null;
                                }
                            } catch (Exception e10) {
                                e2 = e10;
                                bufferedReader = null;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = null;
                            }
                        } catch (Exception e11) {
                            OutputStream outputStream6 = outputStream5;
                            r2 = bArr;
                            e = e11;
                            outputStream4 = outputStream6;
                            e = e;
                            e2 = e;
                            bufferedReader = null;
                            bArr = r2;
                            outputStream5 = outputStream4;
                            inputStreamReader = 0;
                            e2.printStackTrace();
                            e = e;
                            if (bArr != 0) {
                                bArr.close();
                                if (inputStreamReader != 0) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                e.disconnect();
                                e = e;
                            }
                            if (outputStream5 != null) {
                                outputStream5.close();
                            }
                            return null;
                        } catch (Throwable th5) {
                            OutputStream outputStream7 = outputStream5;
                            r1 = bArr;
                            th = th5;
                            outputStream3 = outputStream7;
                            e = e;
                            th = th;
                            bufferedReader = null;
                            bArr = r1;
                            outputStream5 = outputStream3;
                            inputStreamReader = 0;
                            th.printStackTrace();
                            e = e;
                            if (bArr != 0) {
                                bArr.close();
                                if (inputStreamReader != 0) {
                                    inputStreamReader.close();
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                e.disconnect();
                                e = e;
                            }
                            if (outputStream5 != null) {
                                outputStream5.close();
                            }
                            return null;
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    outputStream2 = null;
                    r8 = e;
                    outputStream4 = outputStream2;
                    r2 = outputStream2;
                    e = r8;
                    e2 = e;
                    bufferedReader = null;
                    bArr = r2;
                    outputStream5 = outputStream4;
                    inputStreamReader = 0;
                    e2.printStackTrace();
                    e = e;
                    if (bArr != 0) {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                        e = e;
                    }
                    if (outputStream5 != null) {
                        outputStream5.close();
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                    r7 = e;
                    outputStream3 = outputStream;
                    r1 = outputStream;
                    e = r7;
                    th = th;
                    bufferedReader = null;
                    bArr = r1;
                    outputStream5 = outputStream3;
                    inputStreamReader = 0;
                    th.printStackTrace();
                    e = e;
                    if (bArr != 0) {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                        e = e;
                    }
                    if (outputStream5 != null) {
                        outputStream5.close();
                    }
                    return null;
                }
            } catch (Throwable th7) {
                if (bArr != 0) {
                    try {
                        bArr.close();
                        if (inputStreamReader != 0) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        e.disconnect();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                if (outputStream5 != null) {
                    try {
                        outputStream5.close();
                        throw th7;
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        throw th7;
                    }
                }
                throw th7;
            }
        } catch (Exception e15) {
            e = e15;
            r8 = 0;
            outputStream2 = null;
        } catch (Throwable th8) {
            th = th8;
            r7 = 0;
            outputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:0x012c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x0197 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x0118 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:153:? A[SYNTHETIC] */
    public static String a(String str, File file) throws Throwable {
        Throwable th;
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        InputStream inputStream2;
        InputStreamReader inputStreamReader2;
        BufferedReader bufferedReader2;
        StringBuffer stringBuffer = new StringBuffer();
        DataOutputStream dataOutputStream2 = null;
        BufferedReader bufferedReader3 = null;
        InputStream inputStream3 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", com.google.common.net.b.t0);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + AbstractAjaxCallback.m);
            dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            try {
                dataOutputStream.writeBytes("--" + AbstractAjaxCallback.m + "\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, i);
                    BufferedReader bufferedReader4 = bufferedReader2;
                    e = e;
                    inputStream = inputStream2;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = bufferedReader4;
                    try {
                        e.printStackTrace();
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream2 = dataOutputStream;
                        dataOutputStream = dataOutputStream2;
                        bufferedReader3 = bufferedReader;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                throw th;
                            } catch (IOException e8) {
                                e8.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                }
                dataOutputStream.writeBytes("\r\n");
                fileInputStream.close();
                dataOutputStream.writeBytes("--" + AbstractAjaxCallback.m + "--\r\n");
                dataOutputStream.flush();
                try {
                    try {
                        if (httpURLConnection.getResponseCode() == 200) {
                            inputStream = httpURLConnection.getInputStream();
                            try {
                                inputStreamReader = new InputStreamReader(inputStream);
                                try {
                                    bufferedReader = new BufferedReader(inputStreamReader);
                                    try {
                                        stringBuffer = new StringBuffer();
                                        while (true) {
                                            String line = bufferedReader.readLine();
                                            if (line == null) {
                                                break;
                                            }
                                            stringBuffer.append(line);
                                            stringBuffer.append("\n");
                                        }
                                        String string = stringBuffer.toString();
                                        dataOutputStream.close();
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e9) {
                                                e9.printStackTrace();
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (IOException e10) {
                                                e10.printStackTrace();
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (IOException e11) {
                                                e11.printStackTrace();
                                            }
                                        }
                                        return string;
                                    } catch (Exception e12) {
                                        e = e12;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedReader3 = bufferedReader;
                                        if (dataOutputStream != null) {
                                            dataOutputStream.close();
                                        }
                                        if (bufferedReader3 != null) {
                                            bufferedReader3.close();
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                            throw th;
                                        }
                                        throw th;
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                    bufferedReader = null;
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (dataOutputStream != null) {
                                        dataOutputStream.close();
                                    }
                                    if (bufferedReader3 != null) {
                                        bufferedReader3.close();
                                    }
                                    if (inputStreamReader != null) {
                                        inputStreamReader.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                        throw th;
                                    }
                                    throw th;
                                }
                            } catch (Exception e14) {
                                inputStreamReader2 = null;
                                bufferedReader2 = null;
                                inputStream2 = inputStream;
                                e = e14;
                            } catch (Throwable th5) {
                                bufferedReader = null;
                                inputStream3 = inputStream;
                                th = th5;
                                inputStreamReader = null;
                                th = th;
                                inputStream = inputStream3;
                                bufferedReader3 = bufferedReader;
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (bufferedReader3 != null) {
                                    bufferedReader3.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    throw th;
                                }
                                throw th;
                            }
                        } else {
                            inputStream = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                        }
                        dataOutputStream.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                    String string2 = stringBuffer.toString();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return string2;
                } catch (Exception e16) {
                    InputStreamReader inputStreamReader3 = inputStreamReader;
                    inputStream2 = inputStream;
                    e = e16;
                    bufferedReader2 = bufferedReader;
                    inputStreamReader2 = inputStreamReader3;
                } catch (Throwable th6) {
                    inputStream3 = inputStream;
                    th = th6;
                    th = th;
                    inputStream = inputStream3;
                    bufferedReader3 = bufferedReader;
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedReader3 != null) {
                        bufferedReader3.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                        throw th;
                    }
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                inputStream2 = null;
                inputStreamReader2 = null;
                bufferedReader2 = null;
            } catch (Throwable th7) {
                th = th7;
                inputStreamReader = null;
                bufferedReader = null;
            }
        } catch (Exception e18) {
            e = e18;
            inputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            dataOutputStream = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            dataOutputStream = dataOutputStream2;
            bufferedReader3 = bufferedReader;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
                throw th;
            }
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x00d6 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x0123 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r7
      0x0123: PHI (r7v7 java.io.OutputStream) = (r7v6 java.io.OutputStream), (r7v8 java.io.OutputStream), (r7v24 java.io.OutputStream) binds: [B:64:0x00e7, B:85:0x0121, B:47:0x00b3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public static String a(Context context, String str, String str2, Boolean bool) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        InputStream inputStream2;
        HttpURLConnection httpURLConnection2;
        OutputStream outputStream2;
        Throwable th;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        if (context != null && str != null && str2 != null) {
            byte[] bArrB = bool.booleanValue() ? b(context, str2) : a(context, str2);
            if (bArrB == null) {
                return null;
            }
            try {
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setRequestProperty("Content-Length", String.valueOf(bArrB.length));
                    httpURLConnection2.setRequestProperty("Content-Type", ze1.g);
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.connect();
                    if (bArrB.length > 0) {
                        outputStream2 = httpURLConnection2.getOutputStream();
                        try {
                            outputStream2.write(bArrB);
                        } catch (Exception unused) {
                            inputStream2 = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                    inputStreamReader.close();
                                    bufferedReader.close();
                                    httpURLConnection2.disconnect();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (outputStream2 != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            outputStream = outputStream2;
                            httpURLConnection = httpURLConnection2;
                            inputStream = null;
                            th = th;
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection;
                            outputStream2 = outputStream;
                            inputStreamReader = null;
                            bufferedReader = null;
                            try {
                                th.printStackTrace();
                                return null;
                            } finally {
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                        inputStreamReader.close();
                                        bufferedReader.close();
                                        httpURLConnection2.disconnect();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            }
                        }
                    } else {
                        outputStream2 = null;
                    }
                    if (httpURLConnection2.getResponseCode() == 200) {
                        inputStream2 = httpURLConnection2.getInputStream();
                        try {
                            inputStreamReader = new InputStreamReader(inputStream2);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                try {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    while (true) {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        stringBuffer.append(line);
                                    }
                                    String string = stringBuffer.toString();
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                            inputStreamReader.close();
                                            bufferedReader.close();
                                            httpURLConnection2.disconnect();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    return string;
                                } catch (Exception unused2) {
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                        inputStreamReader.close();
                                        bufferedReader.close();
                                        httpURLConnection2.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                    }
                                    return null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    th.printStackTrace();
                                    return null;
                                }
                            } catch (Exception unused3) {
                                bufferedReader = null;
                            } catch (Throwable th4) {
                                th = th4;
                                bufferedReader = null;
                            }
                        } catch (Exception unused4) {
                            inputStreamReader = null;
                            bufferedReader = null;
                            if (inputStream2 != null) {
                                inputStream2.close();
                                inputStreamReader.close();
                                bufferedReader.close();
                                httpURLConnection2.disconnect();
                            }
                            if (outputStream2 != null) {
                            }
                            return null;
                        } catch (Throwable th5) {
                            inputStream = inputStream2;
                            th = th5;
                            outputStream = outputStream2;
                            httpURLConnection = httpURLConnection2;
                            th = th;
                            inputStream2 = inputStream;
                            httpURLConnection2 = httpURLConnection;
                            outputStream2 = outputStream;
                            inputStreamReader = null;
                            bufferedReader = null;
                            th.printStackTrace();
                            return null;
                        }
                    } else if (outputStream2 != null) {
                    }
                } catch (Exception unused5) {
                    inputStream2 = null;
                    outputStream2 = null;
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                    outputStream = null;
                }
            } catch (Exception unused6) {
                inputStream2 = null;
                httpURLConnection2 = null;
                outputStream2 = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                httpURLConnection = null;
                outputStream = null;
            }
        }
        return null;
    }

    private static byte[] a(Context context, String str) {
        try {
            RequestInfo requestInfo = RequestInfo.getInstance(context);
            if (!requestInfo.isInit) {
                requestInfo.init();
            }
            DevInfo devInfo = requestInfo.getDevInfo();
            EnvInfo envInfo = requestInfo.getEnvInfo();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", str);
            jSONObject.put(ALPParamConstant.PACKAGENAME, so.d(context));
            jSONObject.put("installTime", String.valueOf(so.b(context)));
            jSONObject.put("updateTime", String.valueOf(so.c(context)));
            jSONObject.put("uploadTime", String.valueOf(System.currentTimeMillis()));
            jSONObject.put("appVersion", so.l(context));
            jSONObject.put("sdkVersion", "5.5.0.2");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sdkUID", devInfo.getSdkUID());
            jSONObject2.put("sdkUIDOrig", devInfo.getSdkUIDOrig());
            if (!TextUtils.isEmpty(devInfo.getOaid())) {
                jSONObject2.put(DeviceIdType.OAID, devInfo.getOaid());
            } else if (!TextUtils.isEmpty(requestInfo.getCustomOaid())) {
                jSONObject2.put(DeviceIdType.OAID, requestInfo.getCustomOaid());
            }
            if (!TextUtils.isEmpty(devInfo.getHonorOaid())) {
                jSONObject2.put("honorOaid", devInfo.getHonorOaid());
            }
            jSONObject2.put(DeviceIdType.GAID, devInfo.getGaid());
            jSONObject2.put("os", devInfo.getOs());
            jSONObject2.put("platform", "2");
            jSONObject2.put("devType", devInfo.getDevType());
            jSONObject2.put("brand", devInfo.getBrand());
            jSONObject2.put(ze1.k, devInfo.getModel());
            jSONObject2.put(CommonCode.MapKey.HAS_RESOLUTION, devInfo.getResolution());
            jSONObject2.put("screenSize", devInfo.getScreenSize());
            jSONObject2.put(MediaFormat.KEY_LANGUAGE, devInfo.getLanguage());
            jSONObject2.put("density", devInfo.getDensity());
            jSONObject2.put("root", devInfo.getRoot());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("net", envInfo.getNet());
            jSONObject3.put("isp", envInfo.getIsp());
            jSONObject3.put("developerMode", so.n(context));
            jSONObject3.put("isDebugApk", so.m(context));
            jSONObject3.put("isDebugConnected", Debug.isDebuggerConnected());
            jSONObject3.put("isWifiProxy", so.p(context));
            jSONObject3.put("isVpn", so.c());
            jSONObject3.put("isSimulator", h7.h().a(context));
            jSONObject.putOpt("devInfo", jSONObject2);
            jSONObject.putOpt("envInfo", jSONObject3);
            String strA = g2.a(jSONObject.toString(), qg.a());
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.getBytes();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
