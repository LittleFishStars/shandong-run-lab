package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class of {
    private static Context d;
    private static of e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f27602a = Executors.newFixedThreadPool(4);
    private LruCache b = new LruCache(4194304);
    private Handler c = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27603a;
        final /* synthetic */ f b;

        /* JADX INFO: renamed from: com.beizi.fusion.of$a$a, reason: collision with other inner class name */
        public class RunnableC0318a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f27604a;

            public RunnableC0318a(Bitmap bitmap) {
                this.f27604a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f27604a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a();
            }
        }

        public a(String str, f fVar) {
            this.f27603a = str;
            this.b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f27603a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    of.this.c.post(new RunnableC0318a(bitmapDecodeStream));
                    of.this.b.put(this.f27603a, bitmapDecodeStream);
                    String str = this.f27603a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(a8.e(of.d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
                }
            } catch (Exception unused) {
                of.this.c.post(new b());
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f27606a;
        final /* synthetic */ Bitmap b;

        public b(f fVar, Bitmap bitmap) {
            this.f27606a = fVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27606a.a(this.b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f27607a;
        final /* synthetic */ Bitmap b;

        public c(f fVar, Bitmap bitmap) {
            this.f27607a = fVar;
            this.b = bitmap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f27607a.a(this.b);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27608a;
        final /* synthetic */ boolean b;
        final /* synthetic */ f c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f27609a;

            public a(Bitmap bitmap) {
                this.f27609a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.c.a(this.f27609a);
            }
        }

        public d(String str, boolean z, f fVar) {
            this.f27608a = str;
            this.b = z;
            this.c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f27608a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    if (this.b) {
                        Handler handler = of.this.c;
                        if (handler != null) {
                            handler.post(new a(bitmapDecodeStream));
                        }
                    } else {
                        this.c.a(bitmapDecodeStream);
                    }
                    of.this.b.put(this.f27608a, bitmapDecodeStream);
                    String str = this.f27608a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(a8.e(of.d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
                }
            } catch (Exception unused) {
                this.c.a();
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f27610a;
        final /* synthetic */ f b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.b.a();
            }
        }

        public e(String str, f fVar) {
            this.f27610a = str;
            this.b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f27610a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    of.this.b.put(this.f27610a, bitmapDecodeStream);
                    String str = this.f27610a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(a8.c(of.d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
                }
            } catch (Exception unused) {
                of.this.c.post(new a());
            }
        }
    }

    public interface f {
        void a();

        void a(Bitmap bitmap);
    }

    private static of a() {
        if (e == null) {
            synchronized (of.class) {
                if (e == null) {
                    e = new of();
                }
            }
        }
        return e;
    }

    public void b(String str, f fVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.b.get(str);
        if (bitmap != null) {
            fVar.a(bitmap);
            return;
        }
        File file = new File(a8.c(d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile == null) {
            this.f27602a.submit(new e(str, fVar));
        } else {
            this.b.put(str, bitmapDecodeFile);
            fVar.a(bitmapDecodeFile);
        }
    }

    public static of a(Context context) {
        if (a4.j().u != null) {
            d = a4.j().u;
        } else if (context != null) {
            d = context.getApplicationContext();
        } else {
            d = q1.h().m();
        }
        return a();
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f27612a;
        ImageView b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f27613a;

            public a(Bitmap bitmap) {
                this.f27613a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.b.setImageBitmap(this.f27613a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public g(String str) {
            this.f27612a = str;
        }

        private void b() {
            of.this.c.post(new b());
        }

        public void a(ImageView imageView) {
            this.b = imageView;
            if (TextUtils.isEmpty(this.f27612a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) of.this.b.get(this.f27612a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapA = a();
            if (bitmapA == null) {
                of.this.f27602a.submit(this);
            } else {
                imageView.setImageBitmap(bitmapA);
                of.this.b.put(this.f27612a, bitmapA);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f27612a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(2000);
                if (httpURLConnection.getResponseCode() != 200) {
                    b();
                    return;
                }
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                of.this.c.post(new a(bitmapDecodeStream));
                of.this.b.put(this.f27612a, bitmapDecodeStream);
                String str = this.f27612a;
                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(a8.c(of.d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
            } catch (FileNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
                b();
            }
        }

        private Bitmap a() {
            String str = this.f27612a;
            File file = new File(a8.c(of.d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    private boolean b() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public g a(String str) {
        return new g(str);
    }

    public void a(String str, f fVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.b.get(str);
        if (bitmap != null) {
            fVar.a(bitmap);
            return;
        }
        File file = new File(a8.e(d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.b.put(str, bitmapDecodeFile);
            fVar.a(bitmapDecodeFile);
        } else {
            this.f27602a.submit(new a(str, fVar));
        }
    }

    public void a(String str, boolean z, f fVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.b.get(str);
        if (bitmap != null) {
            if (z) {
                if (b()) {
                    fVar.a(bitmap);
                    return;
                }
                Handler handler = this.c;
                if (handler != null) {
                    handler.post(new b(fVar, bitmap));
                    return;
                }
                return;
            }
            fVar.a(bitmap);
            return;
        }
        File file = new File(a8.e(d), c9.a(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.b.put(str, bitmapDecodeFile);
            if (z) {
                if (b()) {
                    fVar.a(bitmapDecodeFile);
                    return;
                }
                Handler handler2 = this.c;
                if (handler2 != null) {
                    handler2.post(new c(fVar, bitmapDecodeFile));
                    return;
                }
                return;
            }
            fVar.a(bitmapDecodeFile);
            return;
        }
        this.f27602a.submit(new d(str, z, fVar));
    }
}
