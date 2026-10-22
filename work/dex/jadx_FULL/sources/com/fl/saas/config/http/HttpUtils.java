package com.fl.saas.config.http;

import android.accounts.NetworkErrorException;
import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.fl.saas.config.http.HttpUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.net.b;
import com.zj.adlib.c49;
import com.zj.adlib.ze1;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class HttpUtils {
    public static final int MAX_REDIRECTION = 10;
    private List<String> blackList;
    private List<String> whiteList;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x00f5 A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #2 {all -> 0x00d7, blocks: (B:3:0x0001, B:5:0x000e, B:7:0x001b, B:9:0x0022, B:11:0x002c, B:12:0x0038, B:14:0x003e, B:15:0x0054, B:17:0x0069, B:19:0x0074, B:20:0x0080, B:22:0x0086, B:23:0x008a, B:24:0x0090, B:25:0x009d, B:27:0x00a5, B:28:0x00b4, B:6:0x0015, B:34:0x00dc, B:41:0x00f5), top: B:49:0x0001, inners: #4, #3 }] */
    /* JADX WARN: Code duplicated, block: B:53:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void lambda$doGet$0(String str, HttpCallbackStringListener httpCallbackStringListener) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (getHeaders() != null && !getHeaders().isEmpty()) {
                    for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    StringBuffer stringBuffer = new StringBuffer();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                stringBuffer.append(line);
                            }
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                    new ResponseCall(httpCallbackStringListener).doSuccess(stringBuffer.toString());
                } else if (httpURLConnection.getResponseCode() == 302) {
                    new ResponseCall(httpCallbackStringListener).doJump(httpURLConnection.getHeaderField("Location"));
                } else {
                    new ResponseCall(httpCallbackStringListener).doFail(new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                }
            } catch (IOException e) {
                e = e;
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:39:0x00d0 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #1 {all -> 0x00b2, blocks: (B:3:0x000b, B:5:0x0011, B:8:0x0019, B:10:0x0030, B:12:0x003b, B:13:0x0047, B:15:0x004d, B:16:0x0051, B:17:0x0057, B:18:0x0064, B:20:0x006c, B:21:0x007b, B:22:0x009a, B:24:0x00a0, B:32:0x00b7, B:39:0x00d0), top: B:47:0x000b, inners: #4, #3 }] */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void lambda$doGet$1(String str, HttpCallbackStringListener httpCallbackStringListener) {
        ResponseCall responseCall;
        Exception httpRetryException;
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(10);
        HttpURLConnection httpURLConnectionInnerRequest = null;
        try {
            try {
                if (!TextUtils.isEmpty(str) && !checkBlack(str)) {
                    httpURLConnectionInnerRequest = innerRequest(Uri.parse(str), 0L, atomicInteger);
                    httpURLConnectionInnerRequest.setRequestMethod("GET");
                    if (httpURLConnectionInnerRequest.getResponseCode() == 200) {
                        StringBuffer stringBuffer = new StringBuffer();
                        InputStream inputStream = httpURLConnectionInnerRequest.getInputStream();
                        if (inputStream != null) {
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                } else {
                                    stringBuffer.append(line);
                                }
                            }
                            bufferedReader.close();
                            inputStream.close();
                        }
                        new ResponseCall(httpCallbackStringListener).doSuccess(stringBuffer.toString());
                    } else if (httpURLConnectionInnerRequest.getResponseCode() == 302) {
                        new ResponseCall(httpCallbackStringListener).doJump(httpURLConnectionInnerRequest.getHeaderField("Location"));
                    } else {
                        responseCall = new ResponseCall(httpCallbackStringListener);
                        httpRetryException = new NetworkErrorException("response err code:" + httpURLConnectionInnerRequest.getResponseCode());
                        responseCall.doFail(httpRetryException);
                    }
                } else if (httpCallbackStringListener != null) {
                    responseCall = new ResponseCall(httpCallbackStringListener);
                    httpRetryException = new HttpRetryException("url is fail", 20408);
                    responseCall.doFail(httpRetryException);
                }
                if (httpURLConnectionInnerRequest == null) {
                    return;
                }
            } catch (IOException e) {
                e = e;
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnectionInnerRequest.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnectionInnerRequest.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doGet$2(String str, HttpCallbackBytesListener httpCallbackBytesListener) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (getHeaders() != null && !getHeaders().isEmpty()) {
                    for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() != 200) {
                    new ResponseCall(httpCallbackBytesListener).doFail(new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = bufferedInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, i);
                            }
                        }
                        bufferedInputStream.close();
                        inputStream.close();
                    }
                    new ResponseCall(httpCallbackBytesListener).doSuccess(byteArrayOutputStream.toByteArray());
                }
            } catch (Exception e) {
                if (httpCallbackBytesListener != null) {
                    new ResponseCall(httpCallbackBytesListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e2) {
                if (httpCallbackBytesListener != null) {
                    new ResponseCall(httpCallbackBytesListener).doFail(new Exception(e2.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x0141 A[Catch: all -> 0x0120, TRY_LEAVE, TryCatch #0 {all -> 0x0120, blocks: (B:3:0x0003, B:5:0x0010, B:9:0x0020, B:11:0x0026, B:12:0x002e, B:14:0x0034, B:15:0x004a, B:17:0x0065, B:19:0x006f, B:20:0x007b, B:22:0x0081, B:23:0x0097, B:25:0x00cb, B:27:0x00d6, B:28:0x00e0, B:30:0x00e6, B:31:0x00ea, B:32:0x00f0, B:33:0x00fd, B:6:0x0017, B:39:0x0125, B:45:0x013c, B:47:0x0141), top: B:54:0x0003, inners: #3, #3 }] */
    /* JADX WARN: Code duplicated, block: B:59:? A[RETURN, SYNTHETIC] */
    public /* synthetic */ void lambda$doPost$3(String str, Map map, String str2, HttpCallbackStringListener httpCallbackStringListener) {
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                URL url = new URL(str);
                httpURLConnection = str.startsWith("https") ? (HttpsURLConnection) url.openConnection() : (HttpURLConnection) url.openConnection();
                if (map != null && !map.isEmpty()) {
                    for (Map.Entry entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.setRequestProperty(SubscribeResouceItemModel.ACCEPT, "*/*");
                httpURLConnection.setRequestProperty("Connection", "close");
                httpURLConnection.setRequestProperty("Content-Type", ze1.g);
                if (getHeaders() != null && !getHeaders().isEmpty()) {
                    for (Map.Entry<String, String> entry2 : getHeaders().entrySet()) {
                        httpURLConnection.setRequestProperty(entry2.getKey(), entry2.getValue());
                    }
                }
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setConnectTimeout(2500);
                httpURLConnection.setReadTimeout(2500);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
                bufferedWriter.write(str2);
                bufferedWriter.close();
                if (httpURLConnection.getResponseCode() == 200) {
                    StringBuffer stringBuffer = new StringBuffer();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (inputStream != null) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                stringBuffer.append(line);
                            }
                        }
                        bufferedReader.close();
                        inputStream.close();
                    }
                    new ResponseCall(httpCallbackStringListener).doSuccess(stringBuffer.toString());
                } else {
                    new ResponseCall(httpCallbackStringListener).doFail(new NetworkErrorException("response err code:" + httpURLConnection.getResponseCode()));
                }
            } catch (IOException e) {
                e = e;
                e.printStackTrace();
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e2) {
                e = e2;
                e.printStackTrace();
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e);
                }
                if (0 == 0) {
                    return;
                }
            } catch (OutOfMemoryError e3) {
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(new Exception(e3.getMessage()));
                }
                if (0 == 0) {
                    return;
                }
            }
            httpURLConnection.disconnect();
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:114:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:143:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:147:0x01eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:149:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x01fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:155:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:159:0x020d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x01da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:184:? A[RETURN, SYNTHETIC] */
    public static /* synthetic */ void lambda$uploadFile$4(String str, File[] fileArr, HttpCallbackStringListener httpCallbackStringListener) throws Throwable {
        HttpURLConnection httpURLConnection;
        Exception e;
        InputStream inputStream;
        BufferedReader bufferedReader;
        DataOutputStream dataOutputStream;
        InputStreamReader inputStreamReader;
        Exception e2;
        InputStream inputStream2;
        Throwable th;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        InputStream inputStream3;
        InputStream inputStream4;
        InputStreamReader inputStreamReader3 = null;
        BufferedReader bufferedReader3 = null;
        BufferedReader bufferedReader4 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", b.t0);
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                for (int i = 0; i < fileArr.length; i++) {
                    try {
                        File file = fileArr[i];
                        String name = file.getName();
                        dataOutputStream.writeBytes("--*****\r\n");
                        dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"file" + i + "\";filename=\"" + name + "\"\r\n");
                        dataOutputStream.writeBytes("\r\n");
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i2 = fileInputStream.read(bArr);
                            if (i2 != -1) {
                                dataOutputStream.write(bArr, 0, i2);
                            }
                        }
                        dataOutputStream.writeBytes("\r\n");
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        inputStream4 = null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream3 = null;
                    }
                }
                dataOutputStream.writeBytes("--*****--\r\n");
                dataOutputStream.flush();
                if (httpURLConnection.getResponseCode() >= 300) {
                    throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream2 = httpURLConnection.getInputStream();
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
                                    stringBuffer.append("\n");
                                }
                                new ResponseCall(httpCallbackStringListener).doSuccess(stringBuffer.toString());
                                bufferedReader3 = bufferedReader;
                            } catch (Exception e4) {
                                e2 = e4;
                                if (httpCallbackStringListener != null) {
                                    try {
                                        new ResponseCall(httpCallbackStringListener).doFail(e2);
                                    } catch (Throwable th3) {
                                        inputStreamReader2 = inputStreamReader;
                                        inputStream = inputStream2;
                                        th = th3;
                                        inputStreamReader3 = inputStreamReader2;
                                        bufferedReader2 = bufferedReader;
                                        th = th;
                                        inputStream2 = inputStream;
                                        inputStreamReader = inputStreamReader3;
                                        bufferedReader4 = bufferedReader2;
                                        if (dataOutputStream != null) {
                                            try {
                                                dataOutputStream.close();
                                            } catch (IOException e5) {
                                                if (httpCallbackStringListener != null) {
                                                    new ResponseCall(httpCallbackStringListener).doFail(e5);
                                                }
                                            }
                                        }
                                        if (bufferedReader4 != null) {
                                            try {
                                                bufferedReader4.close();
                                            } catch (IOException e6) {
                                                if (httpCallbackStringListener != null) {
                                                    new ResponseCall(httpCallbackStringListener).doFail(e6);
                                                }
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (IOException e7) {
                                                if (httpCallbackStringListener != null) {
                                                    new ResponseCall(httpCallbackStringListener).doFail(e7);
                                                }
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e8) {
                                                if (httpCallbackStringListener != null) {
                                                    new ResponseCall(httpCallbackStringListener).doFail(e8);
                                                }
                                            }
                                        }
                                        if (httpURLConnection == null) {
                                            throw th;
                                        }
                                        httpURLConnection.disconnect();
                                        throw th;
                                    }
                                }
                                if (dataOutputStream != null) {
                                    try {
                                        dataOutputStream.close();
                                    } catch (IOException e9) {
                                        if (httpCallbackStringListener != null) {
                                            new ResponseCall(httpCallbackStringListener).doFail(e9);
                                        }
                                    }
                                }
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e10) {
                                        if (httpCallbackStringListener != null) {
                                            new ResponseCall(httpCallbackStringListener).doFail(e10);
                                        }
                                    }
                                }
                                if (inputStreamReader != null) {
                                    try {
                                        inputStreamReader.close();
                                    } catch (IOException e11) {
                                        if (httpCallbackStringListener != null) {
                                            new ResponseCall(httpCallbackStringListener).doFail(e11);
                                        }
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e12) {
                                        if (httpCallbackStringListener != null) {
                                            new ResponseCall(httpCallbackStringListener).doFail(e12);
                                        }
                                    }
                                }
                                if (httpURLConnection == null) {
                                    return;
                                }
                            } catch (Throwable th4) {
                                bufferedReader2 = bufferedReader;
                                th = th4;
                                bufferedReader4 = bufferedReader2;
                                if (dataOutputStream != null) {
                                    dataOutputStream.close();
                                }
                                if (bufferedReader4 != null) {
                                    bufferedReader4.close();
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (httpURLConnection == null) {
                                    throw th;
                                }
                                httpURLConnection.disconnect();
                                throw th;
                            }
                        } catch (Exception e13) {
                            bufferedReader = null;
                            e2 = e13;
                        } catch (Throwable th5) {
                            inputStreamReader2 = inputStreamReader;
                            inputStream = inputStream2;
                            th = th5;
                            bufferedReader = null;
                            inputStreamReader3 = inputStreamReader2;
                            bufferedReader2 = bufferedReader;
                            th = th;
                            inputStream2 = inputStream;
                            inputStreamReader = inputStreamReader3;
                            bufferedReader4 = bufferedReader2;
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (bufferedReader4 != null) {
                                bufferedReader4.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (httpURLConnection == null) {
                                throw th;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } catch (Exception e14) {
                        inputStream4 = inputStream2;
                        e = e14;
                        bufferedReader = null;
                        e2 = e;
                        inputStream2 = inputStream4;
                        inputStreamReader = null;
                        if (httpCallbackStringListener != null) {
                            new ResponseCall(httpCallbackStringListener).doFail(e2);
                        }
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    } catch (Throwable th6) {
                        inputStream3 = inputStream2;
                        th = th6;
                        th = th;
                        inputStream2 = inputStream3;
                        inputStreamReader = null;
                        if (dataOutputStream != null) {
                            dataOutputStream.close();
                        }
                        if (bufferedReader4 != null) {
                            bufferedReader4.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        if (httpURLConnection == null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } else {
                    inputStream2 = null;
                    inputStreamReader = null;
                }
                try {
                    dataOutputStream.close();
                } catch (IOException e15) {
                    if (httpCallbackStringListener != null) {
                        new ResponseCall(httpCallbackStringListener).doFail(e15);
                    }
                }
                if (bufferedReader3 != null) {
                    try {
                        bufferedReader3.close();
                    } catch (IOException e16) {
                        if (httpCallbackStringListener != null) {
                            new ResponseCall(httpCallbackStringListener).doFail(e16);
                        }
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e17) {
                        if (httpCallbackStringListener != null) {
                            new ResponseCall(httpCallbackStringListener).doFail(e17);
                        }
                    }
                }
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e18) {
                        if (httpCallbackStringListener != null) {
                            new ResponseCall(httpCallbackStringListener).doFail(e18);
                        }
                    }
                }
                httpURLConnection.disconnect();
            } catch (Exception e19) {
                e = e19;
                inputStreamReader = null;
                bufferedReader = null;
                dataOutputStream = null;
                e2 = e;
                inputStream2 = null;
                if (httpCallbackStringListener != null) {
                    new ResponseCall(httpCallbackStringListener).doFail(e2);
                }
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                bufferedReader = null;
                dataOutputStream = null;
                bufferedReader2 = bufferedReader;
                th = th;
                inputStream2 = inputStream;
                inputStreamReader = inputStreamReader3;
                bufferedReader4 = bufferedReader2;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                if (bufferedReader4 != null) {
                    bufferedReader4.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (httpURLConnection == null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (Exception e20) {
            e = e20;
            httpURLConnection = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
        }
    }

    public boolean checkBlack(String str) {
        if (this.blackList == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : this.blackList) {
            if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRedirectBlack(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<String> list = this.whiteList;
            if (list != null && !list.isEmpty()) {
                for (String str2 : this.whiteList) {
                    if (!TextUtils.isEmpty(str2) && str.contains(str2)) {
                        return false;
                    }
                }
                return true;
            }
            List<String> list2 = this.blackList;
            if (list2 != null && !list2.isEmpty()) {
                for (String str3 : this.blackList) {
                    if (!TextUtils.isEmpty(str3) && str.contains(str3)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public SSLContext createSSLContext() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new X509TrustManager() { // from class: com.fl.saas.config.http.HttpUtils.1
                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                @SuppressLint({"TrustAllX509TrustManager"})
                public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                }

                @Override // javax.net.ssl.X509TrustManager
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void doGet(final String str, final HttpCallbackBytesListener httpCallbackBytesListener) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.y24
            @Override // java.lang.Runnable
            public final void run() {
                this.f20767a.lambda$doGet$2(str, httpCallbackBytesListener);
            }
        });
    }

    public void doGet(final String str, final HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.x24
            @Override // java.lang.Runnable
            public final void run() {
                this.f20600a.lambda$doGet$1(str, httpCallbackStringListener);
            }
        });
    }

    public void doGet(boolean z, final String str, final HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.w24
            @Override // java.lang.Runnable
            public final void run() {
                this.f20363a.lambda$doGet$0(str, httpCallbackStringListener);
            }
        });
    }

    public void doPost(String str, String str2, HttpCallbackStringListener httpCallbackStringListener) {
        doPost(str, null, str2, httpCallbackStringListener);
    }

    public void doPost(final String str, final Map<String, String> map, final String str2, final HttpCallbackStringListener httpCallbackStringListener) {
        LogcatUtil.d("YdSDK", str2);
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.u24
            @Override // java.lang.Runnable
            public final void run() {
                this.f19947a.lambda$doPost$3(str, map, str2, httpCallbackStringListener);
            }
        });
    }

    public Map<String, String> getHeaders() {
        return new HashMap();
    }

    public HttpURLConnection innerRequest(Uri uri, long j, AtomicInteger atomicInteger) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext sSLContextCreateSSLContext = createSSLContext();
            if (sSLContextCreateSSLContext != null) {
                httpURLConnection = httpsURLConnection;
                httpsURLConnection.setSSLSocketFactory(sSLContextCreateSSLContext.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection = httpsURLConnection;
        if (getHeaders() != null && !getHeaders().isEmpty()) {
            for (Map.Entry<String, String> entry : getHeaders().entrySet()) {
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        if (!TextUtils.isEmpty(DeviceUtil.getUserAgent())) {
            httpURLConnection.setRequestProperty("User-Agent", DeviceUtil.getUserAgent());
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Accept-Encoding", HlsPlaylistParser.V);
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        if (j > 0) {
            httpURLConnection.setRequestProperty("Range", "bytes=" + j + c49.f40900a);
        }
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 307) {
            switch (responseCode) {
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return httpURLConnection;
            }
        }
        if (atomicInteger.decrementAndGet() < 0) {
            throw new HttpRetryException("redirects too many times", responseCode);
        }
        LogcatUtil.d("YdSDK-HttpUtils", "statusCode 302 :" + atomicInteger.get());
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (TextUtils.isEmpty(headerField) || checkRedirectBlack(headerField)) {
            throw new HttpRetryException("redirectUrl is null", responseCode);
        }
        return innerRequest(Uri.parse(headerField), j, atomicInteger);
    }

    public void setBlackList(List<String> list) {
        this.blackList = list;
    }

    public void setWhiteList(List<String> list) {
        this.whiteList = list;
    }

    public void uploadFile(final String str, final File[] fileArr, final HttpCallbackStringListener httpCallbackStringListener) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.v24
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                HttpUtils.lambda$uploadFile$4(str, fileArr, httpCallbackStringListener);
            }
        });
    }
}
