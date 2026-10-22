package com.baidu.mapapi.http;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.triver.kit.api.model.SubscribeResouceItemModel;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.Logger;
import com.baidu.mapapi.http.wrapper.FileWrapper;
import com.baidu.mapsdkplatform.comapi.util.f;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HttpClient {
    public static final String BOUNDRYSTR = "bd_map_sdk_cc";
    public static final String ENDFLAG = "--";
    public static final String FILE_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"; filename=\"%s\"";
    public static final String NEWLINE = "\r\n";
    public static final String PARAM_TEMPLATE = "Content-Disposition: form-data; name=\"%s\"";
    public static boolean isHttpsEnable = true;
    private HttpURLConnection c;
    private final String f;
    private ProtoResultCallback g;
    private HttpHeader h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26496a = null;
    private String b = null;
    private int d = 10000;
    private int e = 10000;

    public static class HttpHeader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26497a;
        private String b;
        private String c;
        private String d;
        private Map<String, Object> e;

        public HttpHeader() {
        }

        public String getAccept() {
            return this.d;
        }

        public String getCharset() {
            return this.b;
        }

        public String getConnection() {
            return this.f26497a;
        }

        public String getContentType() {
            return this.c;
        }

        public Map<String, Object> getCustom() {
            return this.e;
        }

        public HttpHeader setAccept(String str) {
            this.d = str;
            return this;
        }

        public HttpHeader setCharset(String str) {
            this.b = str;
            return this;
        }

        public HttpHeader setConnection(String str) {
            this.f26497a = str;
            return this;
        }

        public HttpHeader setContentType(String str) {
            this.c = str;
            return this;
        }

        public HttpHeader setCustom(Map<String, Object> map) {
            this.e = map;
            return this;
        }

        public HttpHeader(String str, String str2, String str3, String str4) {
            this.f26497a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }
    }

    public enum HttpStateError {
        NO_ERROR,
        NETWORK_ERROR,
        INNER_ERROR,
        REQUEST_ERROR,
        SERVER_ERROR
    }

    public static abstract class ProtoResultCallback {
        public abstract void onFailed(HttpStateError httpStateError);

        public abstract void onSuccess(String str);
    }

    public static class b implements HostnameVerifier {
        private b() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(str, sSLSession);
        }
    }

    public HttpClient(String str) {
        this.f = str;
    }

    private HttpURLConnection a() {
        HttpURLConnection httpURLConnection;
        try {
            URL url = new URL(this.f26496a);
            if (isHttpsEnable) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
                httpsURLConnection.setHostnameVerifier(new b());
                httpURLConnection = httpsURLConnection;
            } else {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            }
            httpURLConnection.setRequestMethod(this.f);
            httpURLConnection.setDoOutput(!"GET".equalsIgnoreCase(this.f));
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(this.d);
            httpURLConnection.setReadTimeout(this.e);
            a(httpURLConnection);
            return httpURLConnection;
        } catch (Exception e) {
            Log.e("HttpClient", "url connect failed");
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            return null;
        }
    }

    public static String getAuthToken() {
        return f.F;
    }

    public static String getPhoneInfo() {
        return f.h();
    }

    public boolean checkNetwork() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) JNIInitializer.getCachedContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        } catch (Exception e) {
            if (Logger.debugEnable()) {
                e.printStackTrace();
            } else {
                Logger.logW("HttpClient", e.getMessage());
            }
            e.printStackTrace();
            return false;
        }
    }

    public void request(String str) throws Throwable {
        request(str, null, null, null);
    }

    public void setHeader(HttpHeader httpHeader) {
        this.h = httpHeader;
    }

    public void setMaxTimeOut(int i) {
        this.d = i;
    }

    public void setReadTimeOut(int i) {
        this.e = i;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x015c A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:34:0x0099, B:35:0x009e, B:37:0x00a5, B:38:0x00aa, B:84:0x0156, B:86:0x015c, B:88:0x0167, B:90:0x0170, B:91:0x0175, B:87:0x0160), top: B:116:0x007d }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0160 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:34:0x0099, B:35:0x009e, B:37:0x00a5, B:38:0x00aa, B:84:0x0156, B:86:0x015c, B:88:0x0167, B:90:0x0170, B:91:0x0175, B:87:0x0160), top: B:116:0x007d }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0170 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:34:0x0099, B:35:0x009e, B:37:0x00a5, B:38:0x00aa, B:84:0x0156, B:86:0x015c, B:88:0x0167, B:90:0x0170, B:91:0x0175, B:87:0x0160), top: B:116:0x007d }] */
    /* JADX WARN: Code duplicated, block: B:97:0x018a A[Catch: Exception -> 0x01a0, TryCatch #2 {Exception -> 0x01a0, blocks: (B:28:0x0072, B:40:0x00b2, B:41:0x00b8, B:43:0x00bc, B:101:0x0192, B:102:0x0198, B:104:0x019c, B:105:0x019f, B:94:0x0180, B:95:0x0186, B:97:0x018a, B:75:0x0143, B:77:0x0147), top: B:117:0x0072 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v14, types: [int] */
    /* JADX WARN: Type inference failed for: r6v22, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.Map, java.util.Map<java.lang.String, java.util.List<com.baidu.mapapi.http.wrapper.FileWrapper>>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public HttpResponse request(String str, String str2, String str3, Map<String, List<FileWrapper>> map) throws Throwable {
        Throwable th;
        ?? r7;
        BufferedReader bufferedReader;
        Exception e;
        ?? inputStream;
        ProtoResultCallback protoResultCallback;
        HttpURLConnection httpURLConnection;
        HttpStateError httpStateError;
        this.f26496a = str;
        if (str2 != null && !str2.isEmpty()) {
            this.f26496a += "?" + str2;
        }
        if (!checkNetwork()) {
            ProtoResultCallback protoResultCallback2 = this.g;
            if (protoResultCallback2 != null) {
                protoResultCallback2.onFailed(HttpStateError.NETWORK_ERROR);
            }
            return new HttpResponse(HttpStateError.NETWORK_ERROR);
        }
        HttpURLConnection httpURLConnectionA = a();
        this.c = httpURLConnectionA;
        if (httpURLConnectionA == null) {
            Log.e("HttpClient", "url connection failed");
            ProtoResultCallback protoResultCallback3 = this.g;
            if (protoResultCallback3 != null) {
                protoResultCallback3.onFailed(HttpStateError.INNER_ERROR);
            }
            return new HttpResponse(HttpStateError.INNER_ERROR);
        }
        if (TextUtils.isEmpty(this.f26496a)) {
            ProtoResultCallback protoResultCallback4 = this.g;
            if (protoResultCallback4 != null) {
                protoResultCallback4.onFailed(HttpStateError.REQUEST_ERROR);
            }
            return new HttpResponse(HttpStateError.REQUEST_ERROR);
        }
        try {
            this.c.connect();
            a(this.c, str3, map);
            try {
                try {
                    str3 = this.c.getResponseCode();
                    try {
                        if (200 != str3) {
                            Log.e("HttpClient", "responseCode is: " + str3);
                            if (str3 >= 500) {
                                httpStateError = HttpStateError.SERVER_ERROR;
                            } else {
                                httpStateError = str3 >= 400 ? HttpStateError.REQUEST_ERROR : HttpStateError.INNER_ERROR;
                            }
                            if (Logger.debugEnable()) {
                                Logger.logW("HttpClient", this.c.getErrorStream().toString());
                            } else {
                                Logger.logW("HttpClient", "Get response from server failed, http response code=" + str3 + ", error=" + httpStateError);
                            }
                            ProtoResultCallback protoResultCallback5 = this.g;
                            if (protoResultCallback5 != null) {
                                protoResultCallback5.onFailed(httpStateError);
                            }
                            HttpResponse httpResponse = new HttpResponse(httpStateError);
                            HttpURLConnection httpURLConnection2 = this.c;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            return httpResponse;
                        }
                        inputStream = this.c.getInputStream();
                        bufferedReader = new BufferedReader(new InputStreamReader((InputStream) inputStream, "UTF-8"));
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                int i = bufferedReader.read();
                                if (i == -1) {
                                    break;
                                }
                                stringBuffer.append((char) i);
                            }
                            this.b = stringBuffer.toString();
                            if (inputStream != 0) {
                                bufferedReader.close();
                                inputStream.close();
                            }
                            HttpURLConnection httpURLConnection3 = this.c;
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                            }
                            ProtoResultCallback protoResultCallback6 = this.g;
                            if (protoResultCallback6 != null) {
                                protoResultCallback6.onSuccess(this.b);
                            }
                            return new HttpResponse(this.b);
                        } catch (Exception e2) {
                            e = e2;
                            if (Logger.debugEnable()) {
                                e.printStackTrace();
                            } else {
                                Logger.logW("HttpClient", e.getMessage());
                            }
                            Log.e("HttpClient", "Catch exception. INNER_ERROR", e);
                            protoResultCallback = this.g;
                            if (protoResultCallback != null) {
                                protoResultCallback.onFailed(HttpStateError.INNER_ERROR);
                            }
                            HttpResponse httpResponse2 = new HttpResponse(HttpStateError.INNER_ERROR);
                            if (inputStream != 0 && bufferedReader != null) {
                                bufferedReader.close();
                                inputStream.close();
                            }
                            httpURLConnection = this.c;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            return httpResponse2;
                        }
                    } catch (Exception e3) {
                        r7 = str3;
                        e = e3;
                        ?? r2 = r7;
                        bufferedReader = null;
                        e = e;
                        inputStream = r2;
                        if (Logger.debugEnable()) {
                            e.printStackTrace();
                        } else {
                            Logger.logW("HttpClient", e.getMessage());
                        }
                        Log.e("HttpClient", "Catch exception. INNER_ERROR", e);
                        protoResultCallback = this.g;
                        if (protoResultCallback != null) {
                            protoResultCallback.onFailed(HttpStateError.INNER_ERROR);
                        }
                        HttpResponse httpResponse3 = new HttpResponse(HttpStateError.INNER_ERROR);
                        if (inputStream != 0) {
                            bufferedReader.close();
                            inputStream.close();
                        }
                        httpURLConnection = this.c;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        return httpResponse3;
                    } catch (Throwable th2) {
                        map = 0;
                        th = th2;
                        if (str3 != 0 && map != 0) {
                            map.close();
                            str3.close();
                        }
                        HttpURLConnection httpURLConnection4 = this.c;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e4) {
                e = e4;
                r7 = 0;
            } catch (Throwable th4) {
                map = 0;
                th = th4;
                str3 = 0;
            }
        } catch (Exception e5) {
            if (Logger.debugEnable()) {
                e5.printStackTrace();
            } else {
                Logger.logW("HttpClient", e5.getMessage());
            }
            Log.e("HttpClient", "Catch connection exception, INNER_ERROR", e5);
            ProtoResultCallback protoResultCallback7 = this.g;
            if (protoResultCallback7 != null) {
                protoResultCallback7.onFailed(HttpStateError.INNER_ERROR);
            }
            return new HttpResponse(HttpStateError.INNER_ERROR);
        }
    }

    public static class HttpResponse {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f26498a;
        private HttpStateError b;

        public HttpResponse(String str) {
            this.f26498a = str;
            this.b = HttpStateError.NO_ERROR;
        }

        public String getData() {
            return this.f26498a;
        }

        public HttpStateError getError() {
            return this.b;
        }

        public void setData(String str) {
            this.f26498a = str;
        }

        public void setError(HttpStateError httpStateError) {
            this.b = httpStateError;
        }

        public HttpResponse(HttpStateError httpStateError) {
            this.b = httpStateError;
        }
    }

    public HttpClient(String str, ProtoResultCallback protoResultCallback) {
        this.f = str;
        this.g = protoResultCallback;
    }

    private void a(HttpURLConnection httpURLConnection) {
        HttpHeader httpHeader = this.h;
        if (httpHeader == null || httpURLConnection == null) {
            return;
        }
        if (httpHeader.getConnection() != null && !this.h.getConnection().isEmpty()) {
            httpURLConnection.setRequestProperty("Connection", this.h.getConnection());
        }
        if (this.h.getCharset() != null && !this.h.getCharset().isEmpty()) {
            httpURLConnection.setRequestProperty("Charset", this.h.getCharset());
        }
        if (this.h.getContentType() != null && !this.h.getContentType().isEmpty()) {
            httpURLConnection.setRequestProperty("Content-Type", this.h.getContentType());
        }
        if (this.h.getAccept() != null && !this.h.getAccept().isEmpty()) {
            httpURLConnection.setRequestProperty(SubscribeResouceItemModel.ACCEPT, this.h.getAccept());
        }
        Map<String, Object> custom = this.h.getCustom();
        if (custom == null || custom.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : custom.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), String.valueOf(entry.getValue()));
        }
    }

    private void a(HttpURLConnection httpURLConnection, String str, Map<String, List<FileWrapper>> map) {
        if ("GET".equalsIgnoreCase(this.f)) {
            return;
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            a(str, outputStream);
            a(map, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void a(String str, OutputStream outputStream) throws IOException {
        if (str == null || str.isEmpty()) {
            return;
        }
        outputStream.write(str.getBytes());
    }

    private void a(Map<String, List<FileWrapper>> map, OutputStream outputStream) throws IOException {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, List<FileWrapper>> entry : map.entrySet()) {
                for (FileWrapper fileWrapper : entry.getValue()) {
                    if (fileWrapper.getRawFile() != null) {
                        File rawFile = fileWrapper.getRawFile();
                        outputStream.write(("--bd_map_sdk_cc\r\n" + String.format(FILE_TEMPLATE, entry.getKey(), rawFile.getName()) + "\r\n" + String.format("Content-Type: %s", URLConnection.getFileNameMap().getContentTypeFor(rawFile.getName())) + "\r\n\r\n").getBytes());
                        a(rawFile, outputStream);
                        outputStream.write("\r\n".getBytes());
                    } else {
                        byte[] file = fileWrapper.getFile();
                        String mimeType = fileWrapper.getMimeType();
                        String name = fileWrapper.getName();
                        if (file != null && file.length > 0 && !TextUtils.isEmpty(mimeType) && !TextUtils.isEmpty(name)) {
                            outputStream.write(("--bd_map_sdk_cc\r\n" + String.format(FILE_TEMPLATE, entry.getKey(), name) + "\r\n" + String.format("Content-Type: %s", mimeType) + "\r\n\r\n").getBytes());
                            outputStream.write(file);
                            outputStream.write("\r\n".getBytes());
                        }
                    }
                }
            }
        }
        outputStream.write("--bd_map_sdk_cc--\r\n".getBytes());
    }

    private void a(File file, OutputStream outputStream) throws IOException {
        int i;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        do {
            i = fileInputStream.read(bArr);
            if (i > 0) {
                outputStream.write(bArr, 0, i);
            }
        } while (i > 0);
        fileInputStream.close();
    }
}
