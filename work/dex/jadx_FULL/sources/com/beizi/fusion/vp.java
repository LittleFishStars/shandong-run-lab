package com.beizi.fusion;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.ali.auth.third.login.LoginConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vp {
    private static vp d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f27877a = Executors.newFixedThreadPool(4);
    private LruCache b = new LruCache(1048576);
    private Handler c = new Handler();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27878a;
        final /* synthetic */ Context b;
        final /* synthetic */ e c;

        /* JADX INFO: renamed from: com.beizi.fusion.vp$a$a, reason: collision with other inner class name */
        public class RunnableC0326a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f27879a;

            public RunnableC0326a(String str) {
                this.f27879a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a(this.f27879a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c.a();
            }
        }

        public a(String str, Context context, e eVar) {
            this.f27878a = str;
            this.b = context;
            this.c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream inputStream = ((HttpURLConnection) new URL(this.f27878a).openConnection()).getInputStream();
                String str = this.f27878a;
                File file = new File(a8.e(this.b), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        String absolutePath = file.getAbsolutePath();
                        vp.this.c.post(new RunnableC0326a(absolutePath));
                        vp.this.b.put(this.f27878a, absolutePath);
                        fileOutputStream.close();
                        inputStream.close();
                        bufferedInputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Exception unused) {
                vp.this.c.post(new b());
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f27881a;
        final /* synthetic */ String b;

        public b(e eVar, String str) {
            this.f27881a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27881a.a(this.b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f27882a;
        final /* synthetic */ String b;

        public c(e eVar, String str) {
            this.f27882a = eVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27882a.a(this.b);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27883a;
        final /* synthetic */ Context b;
        final /* synthetic */ boolean c;
        final /* synthetic */ e d;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f27884a;

            public a(String str) {
                this.f27884a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.d.a(this.f27884a);
            }
        }

        public d(String str, Context context, boolean z, e eVar) {
            this.f27883a = str;
            this.b = context;
            this.c = z;
            this.d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream inputStream = ((HttpURLConnection) new URL(this.f27883a).openConnection()).getInputStream();
                String str = this.f27883a;
                String strSubstring = str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1);
                File file = new File(a8.e(this.b), c9.a(strSubstring) + LoginConstants.UNDER_LINE + Thread.currentThread().getId() + LoginConstants.UNDER_LINE + System.currentTimeMillis());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
                File file2 = new File(a8.e(this.b), c9.a(strSubstring));
                if (file2.exists()) {
                    file.delete();
                } else {
                    file.renameTo(file2);
                }
                String absolutePath = file2.getAbsolutePath();
                if (this.c) {
                    Handler handler = vp.this.c;
                    if (handler != null) {
                        handler.post(new a(absolutePath));
                    }
                } else {
                    this.d.a(absolutePath);
                }
                vp.this.b.put(this.f27883a, absolutePath);
                fileOutputStream.close();
                inputStream.close();
                bufferedInputStream.close();
            } catch (Exception unused) {
                this.d.a();
            }
        }
    }

    public interface e {
        void a();

        void a(String str);
    }

    private static vp a() {
        if (d == null) {
            synchronized (vp.class) {
                if (d == null) {
                    d = new vp();
                }
            }
        }
        return d;
    }

    private boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static vp c() {
        return a();
    }

    public void a(Context context, String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = (String) this.b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            eVar.a(str2);
            return;
        }
        File file = new File(a8.e(context), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.b.put(str, absolutePath);
            eVar.a(absolutePath);
        } else {
            this.f27877a.submit(new a(str, context, eVar));
        }
    }

    public void a(Context context, String str, boolean z, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = (String) this.b.get(str);
        if (!TextUtils.isEmpty(str2)) {
            if (z) {
                if (b()) {
                    eVar.a(str2);
                    return;
                }
                Handler handler = this.c;
                if (handler != null) {
                    handler.post(new b(eVar, str2));
                    return;
                }
                return;
            }
            eVar.a(str2);
            return;
        }
        File file = new File(a8.e(context), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        String absolutePath = (!file.exists() || file.length() <= 0) ? null : file.getAbsolutePath();
        if (!TextUtils.isEmpty(absolutePath)) {
            this.b.put(str, absolutePath);
            if (z) {
                if (b()) {
                    eVar.a(absolutePath);
                    return;
                }
                Handler handler2 = this.c;
                if (handler2 != null) {
                    handler2.post(new c(eVar, absolutePath));
                    return;
                }
                return;
            }
            eVar.a(absolutePath);
            return;
        }
        this.f27877a.submit(new d(str, context, z, eVar));
    }

    public void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty((String) this.b.get(str))) {
                this.b.remove(str);
            }
            File file = new File(a8.e(context), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
            if (!file.exists() || file.length() <= 0) {
                return;
            }
            file.delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
