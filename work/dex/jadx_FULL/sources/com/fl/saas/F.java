package com.fl.saas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.fl.saas.adx.util.DeviceUtil;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.zj.adlib.c49;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class F {
    public static String s = "YDActionStartDownloadCheckUrl";
    public static String t = "YDActionPauseDownloadCheckUrl";
    public static String u = "YDActionCancelDownloadCheckUrl";
    public static String v = "YDActionErrorDownloadCheckUrl";
    public static String w = "YDActionCancelLastDownloadCheckUrl";
    public static String x = "YDActionUpdateProgress";
    public static String y = "YDActionDownloadSuccess";
    private static G z = new G();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30047a;
    private long d;
    private File e;
    private String f;
    private File g;
    private RandomAccessFile h;
    private e i;
    private Context j;
    private C1415j k;
    private d m;
    private C1441w n;
    private c o;
    private Handler q;
    private boolean b = false;
    private long c = 0;
    private boolean l = false;
    private final AtomicInteger p = new AtomicInteger();
    private boolean r = true;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 1001) {
                if (i == 1002) {
                    File file = (File) message.obj;
                    if (F.this.m != null) {
                        F.this.m.onSuccess(file);
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = message.arg1;
            String str = (String) message.obj;
            if (F.this.m != null) {
                F.this.m.onProgress(i2);
            }
            if (F.this.n != null) {
                F.this.n.a(i2, str);
            }
        }
    }

    public class b implements X509TrustManager {
        public b() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0073  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                String stringExtra = intent.getStringExtra("downLoadUrl");
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (F.s.equals(action)) {
                    if (F.this.f30047a.equals(stringExtra)) {
                        F.this.f();
                        return;
                    }
                    return;
                }
                if (F.t.equals(action)) {
                    if (F.this.f30047a.equals(stringExtra)) {
                        F.this.e();
                        return;
                    }
                    return;
                }
                if (F.u.equals(action)) {
                    if (!F.this.f30047a.equals(stringExtra)) {
                        return;
                    }
                    if (F.this.m != null) {
                        F.this.m.onCancel();
                    }
                } else {
                    if (!F.w.equals(action)) {
                        return;
                    }
                    if (F.this.m != null) {
                        F.this.m.onCancel();
                    }
                }
                F.this.b();
            }
        }
    }

    public interface d {
        void onCancel();

        void onError();

        void onProgress(int i);

        void onSuccess(File file);
    }

    public class e extends Thread {
        public e() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            F.this.c();
        }
    }

    public F(Context context, C1415j c1415j, d dVar) {
        String strSubstring;
        this.j = context;
        this.k = c1415j;
        this.m = dVar;
        this.f30047a = !TextUtils.isEmpty(c1415j.z0) ? c1415j.z0 : c1415j.x0;
        if (!TextUtils.isEmpty(c1415j.A0)) {
            StringBuilder sb = new StringBuilder();
            sb.append((c1415j.A0 + c1415j.E0).replace(Consts.DOT, ""));
            sb.append(".apk");
            strSubstring = sb.toString();
        } else if (this.f30047a.endsWith(".apk")) {
            String str = this.f30047a;
            strSubstring = str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1, this.f30047a.length());
        } else {
            strSubstring = "temp.apk";
        }
        this.f = strSubstring;
        this.q = new a(Looper.getMainLooper());
    }

    private void d() {
        this.b = false;
        Message messageObtainMessage = this.q.obtainMessage();
        messageObtainMessage.what = 1002;
        messageObtainMessage.obj = this.g;
        this.q.sendMessage(messageObtainMessage);
        C1415j c1415j = this.k;
        if (c1415j != null) {
            G g = z;
            if (g != null) {
                g.a(c1415j);
            }
            C1435t.a().a(this.k, 5);
        }
        AbstractC1419l.a(this.j, this.g, this.k);
        if (!this.l && z != null && DeviceUtil.enableCollectAppInstallStatus) {
            z.a(this.j.getApplicationContext());
            this.l = true;
        }
        b();
    }

    public void e() {
        if (this.b) {
            this.b = false;
            if (this.i != null) {
                c1.a().c(this.i);
                this.i = null;
            }
            C1441w c1441w = this.n;
            if (c1441w != null) {
                c1441w.a(false);
            }
        }
    }

    public void f() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.r = true;
        if (this.i == null) {
            this.i = new e();
        }
        c1.a().b(this.i);
    }

    public SSLContext a() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, new TrustManager[]{new b()}, new SecureRandom());
            return sSLContext;
        } catch (KeyManagementException | NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void b() {
        if (this.b) {
            this.b = false;
            if (this.i != null) {
                c1.a().c(this.i);
                this.i = null;
            }
        }
        C1441w c1441w = this.n;
        if (c1441w != null) {
            c1441w.a();
            this.n = null;
        }
        c cVar = this.o;
        if (cVar != null) {
            try {
                this.j.unregisterReceiver(cVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.o = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x020c  */
    /* JADX WARN: Code duplicated, block: B:124:0x0211 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [long] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public void c() throws Throwable {
        ?? r2;
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        HttpURLConnection httpURLConnectionA;
        this.p.set(5);
        try {
            if (this.n == null) {
                this.n = new C1441w(this.j, this.f30047a, this.k.C0);
            }
            ?? r1 = this.c;
            try {
                try {
                    if (r1 < 1) {
                        this.e = this.j.getCacheDir();
                        File file = new File(this.e, this.f);
                        this.g = file;
                        if (file.exists()) {
                            if ("temp.apk".equals(this.f)) {
                                this.g.delete();
                            } else {
                                this.c = this.g.length();
                            }
                        }
                        httpURLConnectionA = a(Uri.parse(this.f30047a), this.c);
                        RandomAccessFile randomAccessFile3 = new RandomAccessFile(this.g, "rwd");
                        this.h = randomAccessFile3;
                        randomAccessFile3.seek(this.c);
                        long contentLength = httpURLConnectionA.getContentLength();
                        long j = this.c;
                        long j2 = contentLength + j;
                        this.d = j2;
                        if (j == j2) {
                            d();
                            httpURLConnectionA.disconnect();
                            RandomAccessFile randomAccessFile4 = this.h;
                            if (randomAccessFile4 != null) {
                                try {
                                    randomAccessFile4.close();
                                    this.h = null;
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        this.o = new c();
                        try {
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(s);
                            intentFilter.addAction(t);
                            intentFilter.addAction(u);
                            intentFilter.addAction(w);
                            if (Build.VERSION.SDK_INT >= 34) {
                                this.j.registerReceiver(this.o, intentFilter, 2);
                            } else {
                                this.j.registerReceiver(this.o, intentFilter);
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            d dVar = this.m;
                            if (dVar != null) {
                                dVar.onError();
                            }
                            File file2 = this.g;
                            if (file2 != null && file2.exists()) {
                                this.g.delete();
                            }
                            b();
                        }
                    } else {
                        if (r1 == this.d) {
                            d();
                            RandomAccessFile randomAccessFile5 = this.h;
                            if (randomAccessFile5 != null) {
                                try {
                                    randomAccessFile5.close();
                                    this.h = null;
                                    return;
                                } catch (IOException unused2) {
                                    return;
                                }
                            }
                            return;
                        }
                        httpURLConnectionA = a(Uri.parse(this.f30047a), this.c);
                        RandomAccessFile randomAccessFile6 = new RandomAccessFile(this.g, "rwd");
                        this.h = randomAccessFile6;
                        randomAccessFile6.seek(this.c);
                        httpURLConnectionA.connect();
                        this.n.a(true);
                    }
                    InputStream inputStream2 = httpURLConnectionA.getInputStream();
                    try {
                        byte[] bArr = new byte[1024];
                        long j3 = 0;
                        int i = 0;
                        while (true) {
                            int i2 = inputStream2.read(bArr);
                            if (i2 == -1 || !this.b) {
                                break;
                            }
                            this.h.write(bArr, 0, i2);
                            long j4 = this.c + ((long) i2);
                            this.c = j4;
                            int i3 = (int) ((j4 * 100) / this.d);
                            if (i3 != i || this.r) {
                                this.r = false;
                                if (System.currentTimeMillis() - j3 > 1000) {
                                    DecimalFormat decimalFormat = new DecimalFormat("#.00");
                                    String str = decimalFormat.format((this.d / 1024.0d) / 1024.0d);
                                    String str2 = decimalFormat.format((this.c / 1024.0d) / 1024.0d);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    Message messageObtainMessage = this.q.obtainMessage();
                                    messageObtainMessage.what = 1001;
                                    messageObtainMessage.arg1 = i3;
                                    messageObtainMessage.obj = str2 + "MB/" + str + "MB";
                                    this.q.sendMessage(messageObtainMessage);
                                    j3 = jCurrentTimeMillis;
                                }
                            }
                            i = i3;
                        }
                        if (this.c >= this.d) {
                            d();
                        }
                        httpURLConnectionA.disconnect();
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                        randomAccessFile2 = this.h;
                        if (randomAccessFile2 == null) {
                            return;
                        }
                    } catch (Exception e3) {
                        r2 = httpURLConnectionA;
                        e = e3;
                        inputStream = inputStream2;
                        try {
                            e.printStackTrace();
                            d dVar2 = this.m;
                            if (dVar2 != null) {
                                dVar2.onError();
                            }
                            File file3 = this.g;
                            if (file3 != null && file3.exists()) {
                                this.g.delete();
                            }
                            b();
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            randomAccessFile2 = this.h;
                            if (randomAccessFile2 == null) {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (r2 != 0) {
                                r2.disconnect();
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused5) {
                                }
                            }
                            randomAccessFile = this.h;
                            if (randomAccessFile != null) {
                                throw th;
                            }
                            try {
                                randomAccessFile.close();
                                this.h = null;
                                throw th;
                            } catch (IOException unused6) {
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        r2 = httpURLConnectionA;
                        th = th2;
                        inputStream = inputStream2;
                        if (r2 != 0) {
                            r2.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        randomAccessFile = this.h;
                        if (randomAccessFile != null) {
                            throw th;
                        }
                        randomAccessFile.close();
                        this.h = null;
                        throw th;
                    }
                } catch (Exception e4) {
                    inputStream = null;
                    r2 = r1;
                    e = e4;
                }
            } catch (Throwable th3) {
                inputStream = null;
                r2 = r1;
                th = th3;
            }
        } catch (Exception e5) {
            e = e5;
            r2 = 0;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            r2 = 0;
            inputStream = null;
        }
        try {
            randomAccessFile2.close();
            this.h = null;
        } catch (IOException unused7) {
        }
    }

    public HttpURLConnection a(Uri uri, long j) throws IOException {
        HttpURLConnection httpURLConnection;
        HttpsURLConnection httpsURLConnection;
        if (uri != null && TextUtils.isEmpty(uri.toString())) {
            if (C1401c.c().a(uri.toString())) {
                throw new H(0, "url is fail");
            }
        }
        URL url = new URL(uri.toString());
        if ("https".equals(uri.getScheme())) {
            httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SSLContext sSLContextA = a();
            if (sSLContextA != null) {
                httpURLConnection = httpsURLConnection;
                httpsURLConnection.setSSLSocketFactory(sSLContextA.getSocketFactory());
                httpURLConnection = httpsURLConnection;
            }
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection = httpsURLConnection;
        httpURLConnection.setInstanceFollowRedirects(true);
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
        if (this.p.decrementAndGet() < 0) {
            throw new H(responseCode, "redirects too many times");
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        if (TextUtils.isEmpty(headerField) || C1401c.c().b(headerField)) {
            throw new H(responseCode, "redirects too many times");
        }
        return a(Uri.parse(headerField), j);
    }
}
