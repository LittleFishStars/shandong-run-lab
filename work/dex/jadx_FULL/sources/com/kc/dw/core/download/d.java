package com.kc.dw.core.download;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.o1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.c49;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends j {
    public static final Handler g = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.core.download.b f39245a;
    public String b;
    public ThreadPoolExecutor c;
    public final OkHttpClient d = new OkHttpClient.Builder().build();
    public Map<Object, h> e;
    public transient long f;

    @Keep
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.core.download.b f39246a;
        public final File b;
        public final d c;

        public a(d dVar, com.kc.dw.core.download.b bVar, File file) {
            this.c = dVar;
            this.f39246a = bVar;
            this.b = file;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            for (h hVar : this.c.e.values()) {
                hVar.b(this.f39246a);
                hVar.a(this.b, this.f39246a);
            }
        }
    }

    @Keep
    public class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.kc.dw.core.download.b f39247a;
        public final String b;
        public final d c;

        public b(d dVar, com.kc.dw.core.download.b bVar, String str) {
            this.c = dVar;
            this.f39247a = bVar;
            this.b = str;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            for (h hVar : this.c.e.values()) {
                hVar.b(this.f39247a);
                hVar.a(this.f39247a, this.b);
            }
        }
    }

    public d(String str, String str2, String str3, String str4) {
        this.b = str;
        com.kc.dw.core.download.b bVar = new com.kc.dw.core.download.b();
        this.f39245a = bVar;
        bVar.f39243a = str;
        this.f39245a.getClass();
        this.f39245a.b = com.kc.dw.core.download.a.b().a();
        if (!TextUtils.isEmpty(str)) {
            this.f39245a.d = str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER)).replace(WVNativeCallbackUtil.SEPERATER, "");
            this.f39245a.c = this.f39245a.b + WVNativeCallbackUtil.SEPERATER + System.currentTimeMillis() + ".apk";
        }
        com.kc.dw.core.download.b bVar2 = this.f39245a;
        bVar2.g = 0;
        bVar2.e = -1L;
        this.c = com.kc.dw.core.download.a.b().c().a();
        this.e = new HashMap();
    }

    public void a() {
        String str;
        com.kc.dw.core.download.b bVar = this.f39245a;
        int i = bVar.g;
        if (i == 0 || i == 3 || i == 4) {
            bVar.g = 0;
            g.post(new e(this, bVar));
            this.c.execute(this);
        } else if (i == 5) {
            if (bVar.c == null) {
                str = "filePath is null";
            } else {
                File file = new File(bVar.b, bVar.d);
                if (file.exists()) {
                    long length = file.length();
                    com.kc.dw.core.download.b bVar2 = this.f39245a;
                    if (length == bVar2.e) {
                        a(bVar2, file);
                        return;
                    }
                }
                bVar = this.f39245a;
                str = "filepath may be invalid or damaged";
            }
            a(bVar, str);
        }
    }

    public final void a(com.kc.dw.core.download.b bVar, File file) {
        File file2;
        if (file.exists()) {
            String str = bVar.d;
            try {
                str = o1.a(MessageDigest.getInstance("MD5").digest(bVar.f39243a.getBytes())).toLowerCase() + ".apk";
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            file2 = new File(bVar.b, str);
            file.renameTo(file2);
        } else {
            file2 = null;
        }
        bVar.g = 5;
        g.post(new a(this, bVar, file2));
    }

    public final void a(com.kc.dw.core.download.b bVar, String str) {
        Log.e("DownloadTask", "postOnError: " + str);
        bVar.g = 4;
        g.post(new b(this, bVar, str));
    }

    public final void a(InputStream inputStream, RandomAccessFile randomAccessFile, com.kc.dw.core.download.b bVar) {
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                    return;
                }
            }
            randomAccessFile.close();
            return;
        }
        try {
            bVar.g = 2;
            byte[] bArr = new byte[8192];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1 || bVar.g != 2) {
                    break;
                    break;
                }
                randomAccessFile.write(bArr, 0, i);
                long j = i;
                bVar.f += j;
                bVar.h += j;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                if (jElapsedRealtime - this.f >= 300) {
                    this.f = jElapsedRealtime;
                    g.post(new c(this, bVar));
                }
            }
        } catch (Exception unused2) {
            break;
        } catch (Throwable th) {
            try {
                inputStream.close();
                randomAccessFile.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
        try {
            inputStream.close();
            randomAccessFile.close();
        } catch (Exception unused4) {
        }
    }

    @Override // com.kc.dw.core.safe.j
    public void notifyRunnableCatch(Exception exc) {
        a(this.f39245a, "download runnable error");
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        com.kc.dw.core.download.b bVar = this.f39245a;
        long j = bVar.f;
        if (j < 0) {
            a(bVar, "startPosition<0");
            return;
        }
        if (TextUtils.isEmpty(bVar.d)) {
            return;
        }
        try {
            Response responseExecute = this.d.newCall(new Request.Builder().addHeader("Range", "bytes=" + j + c49.f40900a).url(this.f39245a.f39243a).get().build()).execute();
            int iCode = responseExecute.code();
            if (iCode == 404 || iCode >= 500) {
                a(this.f39245a, "network error! http response code is 404 or 5xx!");
                return;
            }
            ResponseBody responseBodyBody = responseExecute.body();
            if (responseBodyBody == null) {
                a(this.f39245a, "response body is null");
                return;
            }
            com.kc.dw.core.download.b bVar2 = this.f39245a;
            if (bVar2.e == -1) {
                bVar2.e = responseBodyBody.contentLength();
            }
            File file = new File(this.f39245a.b);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = !TextUtils.isEmpty(this.f39245a.c) ? new File(this.f39245a.c) : new File(file, this.f39245a.d);
            com.kc.dw.core.download.b bVar3 = this.f39245a;
            long j2 = bVar3.e;
            if (j > j2) {
                a(bVar3, "file has expired");
                return;
            }
            if (j == j2 && j > 0) {
                if (!file2.exists() || j != file2.length()) {
                    a(this.f39245a, "file has expired");
                    return;
                }
                a(this.f39245a, file2);
            }
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(j);
                this.f39245a.f = j;
                try {
                    a(responseBodyBody.byteStream(), randomAccessFile, this.f39245a);
                    com.kc.dw.core.download.b bVar4 = this.f39245a;
                    int i = bVar4.g;
                    if (i == 3) {
                        bVar4.g = 3;
                        g.post(new f(this, bVar4));
                    } else {
                        if (i != 2) {
                            a(bVar4, "file has expired");
                            return;
                        }
                        long length = file2.length();
                        com.kc.dw.core.download.b bVar5 = this.f39245a;
                        if (length == bVar5.e) {
                            a(bVar5, file2);
                        } else {
                            a(bVar5, "file has expired");
                        }
                    }
                } catch (Exception e) {
                    a(this.f39245a, e.toString());
                }
            } catch (Exception e2) {
                a(this.f39245a, e2.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a(this.f39245a, th.toString());
        }
    }
}
