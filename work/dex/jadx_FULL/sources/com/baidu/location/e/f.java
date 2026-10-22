package com.baidu.location.e;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.b.l;
import com.baidu.location.b.r;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class f {
    public String eh = null;
    public int ei = 1;
    public String ej = null;
    public byte[] ek = null;
    public Map<String, Object> el = null;
    public String em = null;
    public byte[] en = null;
    public byte[] eo = null;
    public String ep = null;
    public boolean eq = false;
    public String er = null;
    public long es = 0;
    public static int eg = com.baidu.location.e.a.f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f26465a = "10.0.0.172";
    private static int b = 80;
    protected static int et = 0;

    public static class a implements HostnameVerifier {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HttpsURLConnection f26473a;

        public a(HttpsURLConnection httpsURLConnection) {
            this.f26473a = httpsURLConnection;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            String requestProperty = this.f26473a.getRequestProperty("Host");
            if (requestProperty == null) {
                requestProperty = this.f26473a.getURL().getHost();
            }
            return HttpsURLConnection.getDefaultHostnameVerifier().verify(requestProperty, sSLSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        r rVarA;
        String str2;
        a();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.er != null) {
            rVarA = r.a();
            str2 = this.er;
        } else {
            rVarA = r.a();
            str2 = null;
        }
        rVarA.a(str2);
        r.a().a(this.el, str, new r.a() { // from class: com.baidu.location.e.f.1
            @Override // com.baidu.location.b.r.a
            public void a(int i, String str3) {
                f fVar = f.this;
                fVar.ej = null;
                fVar.a(false);
            }

            @Override // com.baidu.location.b.r.a
            public void a(int i, String str3, byte[] bArr) {
                f fVar;
                boolean z;
                if (i == 200) {
                    f.this.es = System.currentTimeMillis() - jCurrentTimeMillis;
                    fVar = f.this;
                    fVar.ej = str3;
                    fVar.ek = bArr;
                    z = true;
                } else {
                    fVar = f.this;
                    fVar.ej = null;
                    z = false;
                }
                fVar.a(z);
            }
        });
    }

    public abstract void a();

    public void a(ExecutorService executorService, final String str) {
        try {
            executorService.execute(new Runnable() { // from class: com.baidu.location.e.f.6
                /* JADX WARN: Code duplicated, block: B:109:0x01e0  */
                /* JADX WARN: Code duplicated, block: B:123:0x01e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:125:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:139:0x01f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:158:? A[SYNTHETIC] */
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    InputStream inputStream;
                    OutputStream outputStream;
                    ByteArrayOutputStream byteArrayOutputStream;
                    HttpsURLConnection httpsURLConnection;
                    ByteArrayOutputStream byteArrayOutputStream2;
                    f.this.a();
                    f.this.eh = str;
                    HttpsURLConnection httpsURLConnection2 = null;
                    InputStream inputStream2 = null;
                    try {
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            boolean zA = l.a().a(f.this.eh);
                            httpsURLConnection = (HttpsURLConnection) (!zA ? new URL(f.this.eh) : new URL(l.a().b(f.this.eh))).openConnection();
                            try {
                                httpsURLConnection.setInstanceFollowRedirects(false);
                                httpsURLConnection.setDoOutput(true);
                                httpsURLConnection.setDoInput(true);
                                httpsURLConnection.setConnectTimeout(com.baidu.location.e.a.f26446a);
                                httpsURLConnection.setReadTimeout(com.baidu.location.e.a.b);
                                httpsURLConnection.setRequestMethod("POST");
                                httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                                httpsURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                                String str2 = h.aw;
                                if (str2 != null) {
                                    httpsURLConnection.setRequestProperty("bd-loc-android", str2);
                                }
                                if (zA) {
                                    httpsURLConnection.setRequestProperty("Host", d.f26461a);
                                }
                                for (Map.Entry<String, Object> entry : f.this.el.entrySet()) {
                                    stringBuffer.append(entry.getKey());
                                    stringBuffer.append("=");
                                    stringBuffer.append(entry.getValue());
                                    stringBuffer.append("&");
                                }
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                                }
                                outputStream = httpsURLConnection.getOutputStream();
                                try {
                                    outputStream.write(stringBuffer.toString().getBytes());
                                    outputStream.flush();
                                    if (httpsURLConnection.getResponseCode() == 200) {
                                        inputStream = httpsURLConnection.getInputStream();
                                        try {
                                            String contentEncoding = httpsURLConnection.getContentEncoding();
                                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                                inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                            }
                                            byteArrayOutputStream2 = new ByteArrayOutputStream();
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i = inputStream.read(bArr);
                                                    if (i == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream2.write(bArr, 0, i);
                                                    }
                                                }
                                                f.this.ej = new String(byteArrayOutputStream2.toByteArray(), "utf-8");
                                                f.this.a(true);
                                                inputStream2 = inputStream;
                                            } catch (Error e) {
                                                e = e;
                                                e.printStackTrace();
                                                Log.i("baidu_location_service", "https NetworkCommunicationError!");
                                                f fVar = f.this;
                                                fVar.ej = null;
                                                fVar.a(false);
                                                if (httpsURLConnection != null) {
                                                    httpsURLConnection.disconnect();
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception unused) {
                                                        Log.d("baidu_location_service", "close os IOException!");
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception unused2) {
                                                        Log.d("baidu_location_service", "close is IOException!");
                                                    }
                                                }
                                                if (byteArrayOutputStream2 == null) {
                                                    return;
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                e.printStackTrace();
                                                Log.i("baidu_location_service", "https NetworkCommunicationException!");
                                                f fVar2 = f.this;
                                                fVar2.ej = null;
                                                fVar2.a(false);
                                                if (httpsURLConnection != null) {
                                                    httpsURLConnection.disconnect();
                                                }
                                                if (outputStream != null) {
                                                    try {
                                                        outputStream.close();
                                                    } catch (Exception unused3) {
                                                        Log.d("baidu_location_service", "close os IOException!");
                                                    }
                                                }
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception unused4) {
                                                        Log.d("baidu_location_service", "close is IOException!");
                                                    }
                                                }
                                                if (byteArrayOutputStream2 == null) {
                                                    return;
                                                }
                                            }
                                        } catch (Error e3) {
                                            e = e3;
                                            byteArrayOutputStream2 = null;
                                        } catch (Exception e4) {
                                            e = e4;
                                            byteArrayOutputStream2 = null;
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream = null;
                                            httpsURLConnection2 = httpsURLConnection;
                                            if (httpsURLConnection2 != null) {
                                                httpsURLConnection2.disconnect();
                                            }
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception unused5) {
                                                    Log.d("baidu_location_service", "close os IOException!");
                                                }
                                            }
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Exception unused6) {
                                                    Log.d("baidu_location_service", "close is IOException!");
                                                }
                                            }
                                            if (byteArrayOutputStream != null) {
                                                throw th;
                                            }
                                            try {
                                                byteArrayOutputStream.close();
                                                throw th;
                                            } catch (Exception unused7) {
                                                Log.d("baidu_location_service", "close baos IOException!");
                                                throw th;
                                            }
                                        }
                                    } else {
                                        f fVar3 = f.this;
                                        fVar3.ej = null;
                                        fVar3.a(false);
                                        byteArrayOutputStream2 = null;
                                    }
                                    httpsURLConnection.disconnect();
                                    try {
                                        outputStream.close();
                                    } catch (Exception unused8) {
                                        Log.d("baidu_location_service", "close os IOException!");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused9) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream2 == null) {
                                        return;
                                    }
                                } catch (Error e5) {
                                    e = e5;
                                    inputStream = null;
                                    byteArrayOutputStream2 = null;
                                } catch (Exception e6) {
                                    e = e6;
                                    inputStream = null;
                                    byteArrayOutputStream2 = null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    inputStream = null;
                                    byteArrayOutputStream = null;
                                }
                            } catch (Error e7) {
                                e = e7;
                                inputStream = null;
                                outputStream = null;
                                byteArrayOutputStream2 = null;
                            } catch (Exception e8) {
                                e = e8;
                                inputStream = null;
                                outputStream = null;
                                byteArrayOutputStream2 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                                outputStream = null;
                                byteArrayOutputStream = null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Error e9) {
                        e = e9;
                        inputStream = null;
                        outputStream = null;
                        httpsURLConnection = null;
                        byteArrayOutputStream2 = null;
                    } catch (Exception e10) {
                        e = e10;
                        inputStream = null;
                        outputStream = null;
                        httpsURLConnection = null;
                        byteArrayOutputStream2 = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = null;
                        outputStream = null;
                        byteArrayOutputStream = null;
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            throw th;
                        }
                        byteArrayOutputStream.close();
                        throw th;
                    }
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused10) {
                        Log.d("baidu_location_service", "close baos IOException!");
                    }
                }
            });
        } catch (Throwable unused) {
            a(false);
        }
    }

    public void a(ExecutorService executorService, final boolean z, final String str) {
        try {
            executorService.execute(new Runnable() { // from class: com.baidu.location.e.f.2
                /* JADX WARN: Code duplicated, block: B:104:0x01c4 A[Catch: Exception -> 0x01c8, TRY_ENTER, TRY_LEAVE, TryCatch #24 {Exception -> 0x01c8, blocks: (B:87:0x019f, B:104:0x01c4), top: B:156:0x019f }] */
                /* JADX WARN: Code duplicated, block: B:110:0x01cf A[LOOP:0: B:3:0x001a->B:110:0x01cf, LOOP_END] */
                /* JADX WARN: Code duplicated, block: B:114:0x01d8  */
                /* JADX WARN: Code duplicated, block: B:129:0x01f9  */
                /* JADX WARN: Code duplicated, block: B:130:0x0208  */
                /* JADX WARN: Code duplicated, block: B:134:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:136:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:138:0x01ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:140:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:142:0x01dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:150:0x018d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:152:0x01bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:156:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:169:0x01f7 A[EDGE_INSN: B:169:0x01f7->B:128:0x01f7 BREAK  A[LOOP:0: B:3:0x001a->B:110:0x01cf], SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:172:? A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:77:0x0188  */
                /* JADX WARN: Code duplicated, block: B:94:0x01ad  */
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    OutputStream outputStream;
                    OutputStream outputStream2;
                    ByteArrayOutputStream byteArrayOutputStream;
                    InputStream inputStream;
                    InputStream inputStream2;
                    boolean z2;
                    f fVar = f.this;
                    fVar.eh = d.e;
                    fVar.a();
                    HttpsURLConnection httpsURLConnection = null;
                    for (int i = f.this.ei; i > 0; i--) {
                        try {
                            URL url = new URL(f.this.eh);
                            StringBuffer stringBuffer = new StringBuffer();
                            for (Map.Entry<String, Object> entry : f.this.el.entrySet()) {
                                stringBuffer.append(entry.getKey());
                                stringBuffer.append("=");
                                stringBuffer.append(entry.getValue());
                                stringBuffer.append("&");
                            }
                            if (stringBuffer.length() > 0) {
                                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                            }
                            HttpsURLConnection httpsURLConnection2 = (HttpsURLConnection) url.openConnection();
                            try {
                                httpsURLConnection2.setRequestMethod("POST");
                                httpsURLConnection2.setDoInput(true);
                                httpsURLConnection2.setDoOutput(true);
                                httpsURLConnection2.setUseCaches(false);
                                httpsURLConnection2.setConnectTimeout(com.baidu.location.e.a.f26446a);
                                httpsURLConnection2.setReadTimeout(com.baidu.location.e.a.f26446a);
                                httpsURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                                httpsURLConnection2.setRequestProperty(com.google.common.net.b.i, "UTF-8");
                                httpsURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                                String str2 = h.aw;
                                if (str2 != null) {
                                    httpsURLConnection2.setRequestProperty("bd-loc-android", str2);
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    httpsURLConnection2.setRequestProperty("Host", str);
                                }
                                httpsURLConnection2.setHostnameVerifier(new a(httpsURLConnection2));
                                OutputStream outputStream3 = httpsURLConnection2.getOutputStream();
                                try {
                                    outputStream3.write(stringBuffer.toString().getBytes());
                                    outputStream3.flush();
                                    if (httpsURLConnection2.getResponseCode() == 200) {
                                        inputStream2 = httpsURLConnection2.getInputStream();
                                        try {
                                            String contentEncoding = httpsURLConnection2.getContentEncoding();
                                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                                inputStream2 = new GZIPInputStream(new BufferedInputStream(inputStream2));
                                            }
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i2 = inputStream2.read(bArr);
                                                    if (i2 == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr, 0, i2);
                                                    }
                                                }
                                                f.this.ej = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                                if (z) {
                                                    f.this.en = byteArrayOutputStream.toByteArray();
                                                }
                                                f.this.a(true);
                                                z2 = true;
                                            } catch (Error unused) {
                                                outputStream = outputStream3;
                                                httpsURLConnection = httpsURLConnection2;
                                                try {
                                                    Log.d("baidu_location_service", "NetworkCommunicationError!");
                                                    if (httpsURLConnection != null) {
                                                        httpsURLConnection.disconnect();
                                                    }
                                                    if (outputStream != null) {
                                                        try {
                                                            outputStream.close();
                                                        } catch (Exception unused2) {
                                                            Log.d("baidu_location_service", "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream2 != null) {
                                                        try {
                                                            inputStream2.close();
                                                        } catch (Exception unused3) {
                                                            Log.d("baidu_location_service", "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream != null) {
                                                        try {
                                                            byteArrayOutputStream.close();
                                                        } catch (Exception unused4) {
                                                            Log.d("baidu_location_service", "close baos IOException!");
                                                        }
                                                    }
                                                    z2 = false;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    inputStream = inputStream2;
                                                    if (httpsURLConnection != null) {
                                                        httpsURLConnection.disconnect();
                                                    }
                                                    if (outputStream != null) {
                                                        try {
                                                            outputStream.close();
                                                        } catch (Exception unused5) {
                                                            Log.d("baidu_location_service", "close os IOException!");
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        try {
                                                            inputStream.close();
                                                        } catch (Exception unused6) {
                                                            Log.d("baidu_location_service", "close is IOException!");
                                                        }
                                                    }
                                                    if (byteArrayOutputStream == null) {
                                                        throw th;
                                                    }
                                                    try {
                                                        byteArrayOutputStream.close();
                                                        throw th;
                                                    } catch (Exception unused7) {
                                                        Log.d("baidu_location_service", "close baos IOException!");
                                                        throw th;
                                                    }
                                                }
                                            } catch (Exception unused8) {
                                                outputStream2 = outputStream3;
                                                httpsURLConnection = httpsURLConnection2;
                                                Log.d("baidu_location_service", "NetworkCommunicationException!");
                                                if (httpsURLConnection != null) {
                                                    httpsURLConnection.disconnect();
                                                }
                                                if (outputStream2 != null) {
                                                    try {
                                                        outputStream2.close();
                                                    } catch (Exception unused9) {
                                                        Log.d("baidu_location_service", "close os IOException!");
                                                    }
                                                }
                                                if (inputStream2 != null) {
                                                    try {
                                                        inputStream2.close();
                                                    } catch (Exception unused10) {
                                                        Log.d("baidu_location_service", "close is IOException!");
                                                    }
                                                }
                                                if (byteArrayOutputStream != null) {
                                                    byteArrayOutputStream.close();
                                                }
                                                z2 = false;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                outputStream = outputStream3;
                                                httpsURLConnection = httpsURLConnection2;
                                                inputStream = inputStream2;
                                                if (httpsURLConnection != null) {
                                                    httpsURLConnection.disconnect();
                                                }
                                                if (outputStream != null) {
                                                    outputStream.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (byteArrayOutputStream == null) {
                                                    throw th;
                                                }
                                                byteArrayOutputStream.close();
                                                throw th;
                                            }
                                        } catch (Error unused11) {
                                            outputStream = outputStream3;
                                            httpsURLConnection = httpsURLConnection2;
                                            byteArrayOutputStream = null;
                                            Log.d("baidu_location_service", "NetworkCommunicationError!");
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            z2 = false;
                                            if (z2) {
                                                break;
                                                if (i > 0) {
                                                    f.et = 0;
                                                    return;
                                                }
                                                f.et++;
                                                f fVar2 = f.this;
                                                fVar2.ej = null;
                                                fVar2.a(false);
                                            }
                                        } catch (Exception unused12) {
                                            outputStream2 = outputStream3;
                                            httpsURLConnection = httpsURLConnection2;
                                            byteArrayOutputStream = null;
                                            Log.d("baidu_location_service", "NetworkCommunicationException!");
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            if (outputStream2 != null) {
                                                outputStream2.close();
                                            }
                                            if (inputStream2 != null) {
                                                inputStream2.close();
                                            }
                                            if (byteArrayOutputStream != null) {
                                                byteArrayOutputStream.close();
                                            }
                                            z2 = false;
                                            if (z2) {
                                                break;
                                                if (i > 0) {
                                                    f.et = 0;
                                                    return;
                                                }
                                                f.et++;
                                                f fVar3 = f.this;
                                                fVar3.ej = null;
                                                fVar3.a(false);
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream = outputStream3;
                                            httpsURLConnection = httpsURLConnection2;
                                            inputStream = inputStream2;
                                            byteArrayOutputStream = null;
                                            if (httpsURLConnection != null) {
                                                httpsURLConnection.disconnect();
                                            }
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (byteArrayOutputStream == null) {
                                                throw th;
                                            }
                                            byteArrayOutputStream.close();
                                            throw th;
                                        }
                                    } else {
                                        z2 = false;
                                        inputStream2 = null;
                                        byteArrayOutputStream = null;
                                    }
                                    httpsURLConnection2.disconnect();
                                    try {
                                        outputStream3.close();
                                    } catch (Exception unused13) {
                                        Log.d("baidu_location_service", "close os IOException!");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused14) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused15) {
                                            Log.d("baidu_location_service", "close baos IOException!");
                                        }
                                    }
                                    httpsURLConnection = httpsURLConnection2;
                                } catch (Error unused16) {
                                    outputStream = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    inputStream2 = null;
                                    byteArrayOutputStream = null;
                                    Log.d("baidu_location_service", "NetworkCommunicationError!");
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z2 = false;
                                    if (z2) {
                                        break;
                                        if (i > 0) {
                                            f.et = 0;
                                            return;
                                        }
                                        f.et++;
                                        f fVar4 = f.this;
                                        fVar4.ej = null;
                                        fVar4.a(false);
                                    }
                                } catch (Exception unused17) {
                                    outputStream2 = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    inputStream2 = null;
                                    byteArrayOutputStream = null;
                                    Log.d("baidu_location_service", "NetworkCommunicationException!");
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream2 != null) {
                                        inputStream2.close();
                                    }
                                    if (byteArrayOutputStream != null) {
                                        byteArrayOutputStream.close();
                                    }
                                    z2 = false;
                                    if (z2) {
                                        break;
                                        if (i > 0) {
                                            f.et = 0;
                                            return;
                                        }
                                        f.et++;
                                        f fVar5 = f.this;
                                        fVar5.ej = null;
                                        fVar5.a(false);
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    outputStream = outputStream3;
                                    httpsURLConnection = httpsURLConnection2;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                    if (httpsURLConnection != null) {
                                        httpsURLConnection.disconnect();
                                    }
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    if (byteArrayOutputStream == null) {
                                        throw th;
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                            } catch (Error unused18) {
                                httpsURLConnection = httpsURLConnection2;
                                outputStream = null;
                                inputStream2 = null;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationError!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z2 = false;
                                if (z2) {
                                    break;
                                    if (i > 0) {
                                        f.et = 0;
                                        return;
                                    }
                                    f.et++;
                                    f fVar6 = f.this;
                                    fVar6.ej = null;
                                    fVar6.a(false);
                                }
                            } catch (Exception unused19) {
                                httpsURLConnection = httpsURLConnection2;
                                outputStream2 = null;
                                inputStream2 = null;
                                byteArrayOutputStream = null;
                                Log.d("baidu_location_service", "NetworkCommunicationException!");
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream2 != null) {
                                    outputStream2.close();
                                }
                                if (inputStream2 != null) {
                                    inputStream2.close();
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                z2 = false;
                                if (z2) {
                                    break;
                                    if (i > 0) {
                                        f.et = 0;
                                        return;
                                    }
                                    f.et++;
                                    f fVar7 = f.this;
                                    fVar7.ej = null;
                                    fVar7.a(false);
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                httpsURLConnection = httpsURLConnection2;
                                outputStream = null;
                                byteArrayOutputStream = null;
                                inputStream = null;
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (byteArrayOutputStream == null) {
                                    throw th;
                                }
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (Error unused20) {
                        } catch (Exception unused21) {
                        } catch (Throwable th6) {
                            th = th6;
                        }
                        if (z2) {
                            break;
                        }
                    }
                    if (i > 0) {
                        f.et = 0;
                        return;
                    }
                    f.et++;
                    f fVar8 = f.this;
                    fVar8.ej = null;
                    fVar8.a(false);
                }
            });
        } catch (Throwable unused) {
            a(false);
        }
    }

    public abstract void a(boolean z);

    public void b(final String str) {
        if (com.baidu.location.b.c.b().ds == 1) {
            (Looper.getMainLooper().getThread() == Thread.currentThread() ? new Thread(new Runnable() { // from class: com.baidu.location.e.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(str);
                }
            }) : new Thread(new Runnable() { // from class: com.baidu.location.e.f.4
                @Override // java.lang.Runnable
                public void run() {
                    f.this.a(str);
                }
            })).start();
            return;
        }
        try {
            new Thread() { // from class: com.baidu.location.e.f.5
                /* JADX WARN: Code duplicated, block: B:110:0x0228  */
                /* JADX WARN: Code duplicated, block: B:127:0x024d  */
                /* JADX WARN: Code duplicated, block: B:145:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:147:0x025b A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:149:0x0264 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:151:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:154:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:156:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:161:0x01fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:176:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:177:? A[SYNTHETIC] */
                /* JADX WARN: Code duplicated, block: B:94:0x01f8  */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Not initialized variable reg: 11, insn: 0x0249: MOVE (r16 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:125:0x0248 */
                /* JADX WARN: Type inference failed for: r6v15 */
                /* JADX WARN: Type inference failed for: r6v20 */
                /* JADX WARN: Type inference failed for: r6v26 */
                /* JADX WARN: Type inference failed for: r6v27 */
                /* JADX WARN: Type inference failed for: r6v8, types: [java.io.ByteArrayOutputStream] */
                /* JADX WARN: Type inference failed for: r9v10 */
                /* JADX WARN: Type inference failed for: r9v13 */
                /* JADX WARN: Type inference failed for: r9v17 */
                /* JADX WARN: Type inference failed for: r9v2 */
                /* JADX WARN: Type inference failed for: r9v4, types: [java.net.HttpURLConnection] */
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    boolean z;
                    HttpsURLConnection httpsURLConnection;
                    ByteArrayOutputStream byteArrayOutputStream;
                    HttpsURLConnection httpsURLConnection2;
                    ?? r9;
                    OutputStream outputStream;
                    OutputStream outputStream2;
                    InputStream inputStream;
                    OutputStream outputStream3;
                    ?? r6;
                    URLConnection uRLConnectionOpenConnection;
                    InputStream inputStream2;
                    ByteArrayOutputStream byteArrayOutputStream2;
                    f.this.a();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    f fVar = f.this;
                    fVar.eh = str;
                    try {
                        try {
                            try {
                                HttpsURLConnection.setDefaultSSLSocketFactory(h.k());
                                StringBuffer stringBuffer = new StringBuffer();
                                boolean zA = l.a().a(f.this.eh);
                                URL url = !zA ? new URL(f.this.eh) : new URL(l.a().b(f.this.eh));
                                String str2 = h.aZ;
                                int i = h.ba;
                                if (TextUtils.isEmpty(str2) || i == -1) {
                                    uRLConnectionOpenConnection = url.openConnection();
                                } else {
                                    Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(str2, i));
                                    final String str3 = h.bb;
                                    final String str4 = h.bc;
                                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                                        Authenticator.setDefault(new Authenticator() { // from class: com.baidu.location.e.f.5.1
                                            @Override // java.net.Authenticator
                                            public PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(str3, str4.toCharArray());
                                            }
                                        });
                                    }
                                    uRLConnectionOpenConnection = url.openConnection(proxy);
                                }
                                httpsURLConnection2 = (HttpsURLConnection) uRLConnectionOpenConnection;
                                if (zA) {
                                    try {
                                        httpsURLConnection2.setRequestProperty("Host", d.f26461a);
                                    } catch (Error e) {
                                        e = e;
                                        byteArrayOutputStream = null;
                                        inputStream = null;
                                        outputStream3 = null;
                                        e.printStackTrace();
                                        Log.i("baidu_location_service", "https NetworkCommunicationError!");
                                        f fVar2 = f.this;
                                        fVar2.ej = null;
                                        fVar2.a(false);
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (outputStream3 != null) {
                                            try {
                                                outputStream3.close();
                                            } catch (Exception unused) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused2) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream == null) {
                                            return;
                                        }
                                        byteArrayOutputStream.close();
                                    } catch (Exception e2) {
                                        e = e2;
                                        byteArrayOutputStream = null;
                                        inputStream = null;
                                        outputStream3 = null;
                                        e.printStackTrace();
                                        Log.i("baidu_location_service", "https NetworkCommunicationException!");
                                        f fVar3 = f.this;
                                        fVar3.ej = null;
                                        fVar3.a(false);
                                        if (httpsURLConnection2 != null) {
                                            httpsURLConnection2.disconnect();
                                        }
                                        if (outputStream3 != null) {
                                            try {
                                                outputStream3.close();
                                            } catch (Exception unused3) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused4) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (byteArrayOutputStream == null) {
                                            return;
                                        }
                                        byteArrayOutputStream.close();
                                    } catch (Throwable th) {
                                        th = th;
                                        httpsURLConnection = httpsURLConnection2;
                                        z = false;
                                        inputStream = null;
                                        outputStream2 = null;
                                        r6 = z;
                                        r9 = httpsURLConnection;
                                        if (r9 != 0) {
                                            r9.disconnect();
                                        }
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (Exception unused5) {
                                                Log.d("baidu_location_service", "close os IOException!");
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Exception unused6) {
                                                Log.d("baidu_location_service", "close is IOException!");
                                            }
                                        }
                                        if (r6 != 0) {
                                            throw th;
                                        }
                                        try {
                                            r6.close();
                                            throw th;
                                        } catch (Exception unused7) {
                                            Log.d("baidu_location_service", "close baos IOException!");
                                            throw th;
                                        }
                                    }
                                }
                                httpsURLConnection2.setInstanceFollowRedirects(false);
                                httpsURLConnection2.setDoOutput(true);
                                httpsURLConnection2.setDoInput(true);
                                httpsURLConnection2.setConnectTimeout(com.baidu.location.e.a.f26446a);
                                httpsURLConnection2.setReadTimeout(com.baidu.location.e.a.b);
                                httpsURLConnection2.setRequestMethod("POST");
                                httpsURLConnection2.setHostnameVerifier(new a(httpsURLConnection2));
                                httpsURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
                                String str5 = f.this.er;
                                if (str5 != null) {
                                    httpsURLConnection2.setRequestProperty("alwd", str5);
                                }
                                httpsURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
                                String str6 = h.aw;
                                if (str6 != null) {
                                    httpsURLConnection2.setRequestProperty("bd-loc-android", str6);
                                }
                                for (Map.Entry<String, Object> entry : f.this.el.entrySet()) {
                                    stringBuffer.append(entry.getKey());
                                    stringBuffer.append("=");
                                    stringBuffer.append(entry.getValue());
                                    stringBuffer.append("&");
                                }
                                if (stringBuffer.length() > 0) {
                                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                                }
                                outputStream3 = httpsURLConnection2.getOutputStream();
                                try {
                                    outputStream3.write(stringBuffer.toString().getBytes());
                                    outputStream3.flush();
                                    if (httpsURLConnection2.getResponseCode() == 200) {
                                        inputStream = httpsURLConnection2.getInputStream();
                                        try {
                                            f.this.es = System.currentTimeMillis() - jCurrentTimeMillis;
                                            String contentEncoding = httpsURLConnection2.getContentEncoding();
                                            if (contentEncoding != null && contentEncoding.contains("gzip")) {
                                                inputStream = new GZIPInputStream(new BufferedInputStream(inputStream));
                                            }
                                            byteArrayOutputStream = new ByteArrayOutputStream();
                                            try {
                                                byte[] bArr = new byte[1024];
                                                while (true) {
                                                    int i2 = inputStream.read(bArr);
                                                    if (i2 == -1) {
                                                        break;
                                                    } else {
                                                        byteArrayOutputStream.write(bArr, 0, i2);
                                                    }
                                                }
                                                f.this.ej = new String(byteArrayOutputStream.toByteArray(), "utf-8");
                                                f.this.a(true);
                                                byteArrayOutputStream2 = byteArrayOutputStream;
                                                inputStream2 = inputStream;
                                            } catch (Error e3) {
                                                e = e3;
                                                e.printStackTrace();
                                                Log.i("baidu_location_service", "https NetworkCommunicationError!");
                                                f fVar4 = f.this;
                                                fVar4.ej = null;
                                                fVar4.a(false);
                                                if (httpsURLConnection2 != null) {
                                                    httpsURLConnection2.disconnect();
                                                }
                                                if (outputStream3 != null) {
                                                    outputStream3.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (byteArrayOutputStream == null) {
                                                    return;
                                                }
                                                byteArrayOutputStream.close();
                                            } catch (Exception e4) {
                                                e = e4;
                                                e.printStackTrace();
                                                Log.i("baidu_location_service", "https NetworkCommunicationException!");
                                                f fVar5 = f.this;
                                                fVar5.ej = null;
                                                fVar5.a(false);
                                                if (httpsURLConnection2 != null) {
                                                    httpsURLConnection2.disconnect();
                                                }
                                                if (outputStream3 != null) {
                                                    outputStream3.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (byteArrayOutputStream == null) {
                                                    return;
                                                }
                                                byteArrayOutputStream.close();
                                            }
                                        } catch (Error e5) {
                                            e = e5;
                                            byteArrayOutputStream = null;
                                        } catch (Exception e6) {
                                            e = e6;
                                            byteArrayOutputStream = null;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r9 = httpsURLConnection2;
                                            outputStream2 = outputStream3;
                                            r6 = 0;
                                            if (r9 != 0) {
                                                r9.disconnect();
                                            }
                                            if (outputStream2 != null) {
                                                outputStream2.close();
                                            }
                                            if (inputStream != null) {
                                                inputStream.close();
                                            }
                                            if (r6 != 0) {
                                                throw th;
                                            }
                                            r6.close();
                                            throw th;
                                        }
                                    } else {
                                        f fVar6 = f.this;
                                        fVar6.ej = null;
                                        fVar6.a(false);
                                        inputStream2 = null;
                                        byteArrayOutputStream2 = null;
                                    }
                                    httpsURLConnection2.disconnect();
                                    try {
                                        outputStream3.close();
                                    } catch (Exception unused8) {
                                        Log.d("baidu_location_service", "close os IOException!");
                                    }
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception unused9) {
                                            Log.d("baidu_location_service", "close is IOException!");
                                        }
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                        byteArrayOutputStream2.close();
                                    }
                                } catch (Error e7) {
                                    e = e7;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                } catch (Exception e8) {
                                    e = e8;
                                    byteArrayOutputStream = null;
                                    inputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    r9 = httpsURLConnection2;
                                    outputStream2 = outputStream3;
                                    r6 = 0;
                                    inputStream = null;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                r9 = fVar;
                                outputStream2 = outputStream;
                                r6 = jCurrentTimeMillis;
                            }
                        } catch (Error e9) {
                            e = e9;
                            byteArrayOutputStream = null;
                            httpsURLConnection2 = null;
                        } catch (Exception e10) {
                            e = e10;
                            byteArrayOutputStream = null;
                            httpsURLConnection2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            z = false;
                            httpsURLConnection = null;
                        }
                    } catch (Exception unused10) {
                        Log.d("baidu_location_service", "close baos IOException!");
                    }
                }
            }.start();
        } catch (Throwable unused) {
            a(false);
        }
    }
}
