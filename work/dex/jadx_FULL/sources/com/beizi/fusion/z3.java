package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class z3 {
    private static Context d;
    private static z3 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f28089a = Executors.newFixedThreadPool(4);
    private LruCache b = new LruCache(4194304);
    private Handler c = new Handler();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28090a;
        final /* synthetic */ c b;

        /* JADX INFO: renamed from: com.beizi.fusion.z3$a$a, reason: collision with other inner class name */
        public class RunnableC0338a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f28091a;

            public RunnableC0338a(Bitmap bitmap) {
                this.f28091a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b.a(this.f28091a);
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

        public a(String str, c cVar) {
            this.f28090a = str;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f28090a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    z3.this.c.post(new RunnableC0338a(bitmapDecodeStream));
                    z3.this.b.put(this.f28090a, bitmapDecodeStream);
                    String str = this.f28090a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(j4.a(z3.d), z3.b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
                }
            } catch (Exception unused) {
                z3.this.c.post(new b());
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f28093a;
        final /* synthetic */ c b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b.a();
            }
        }

        public b(String str, c cVar) {
            this.f28093a = str;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f28093a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() == 200) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                    httpURLConnection.disconnect();
                    z3.this.b.put(this.f28093a, bitmapDecodeStream);
                    String str = this.f28093a;
                    bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(new File(j4.a(z3.d), z3.b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)))));
                }
            } catch (Exception unused) {
                z3.this.c.post(new a());
            }
        }
    }

    public interface c {
        void a();

        void a(Bitmap bitmap);
    }

    private static z3 a() {
        if (e == null) {
            synchronized (z3.class) {
                if (e == null) {
                    e = new z3();
                }
            }
        }
        return e;
    }

    public void b(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.b.get(str);
        if (bitmap != null) {
            cVar.a(bitmap);
            return;
        }
        File file = new File(j4.a(d), b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile == null) {
            this.f28089a.submit(new b(str, cVar));
        } else {
            this.b.put(str, bitmapDecodeFile);
            cVar.a(bitmapDecodeFile);
        }
    }

    public static z3 a(Context context) {
        if (context == null) {
            so.c("Illegal Argument: context is null");
        } else {
            d = context;
        }
        return a();
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f28095a;
        ImageView b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f28096a;

            public a(Bitmap bitmap) {
                this.f28096a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.b.setImageBitmap(this.f28096a);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
            }
        }

        public d(String str) {
            this.f28095a = str;
        }

        private void b() {
            z3.this.c.post(new b());
        }

        public void a(ImageView imageView) {
            this.b = imageView;
            if (TextUtils.isEmpty(this.f28095a)) {
                return;
            }
            Bitmap bitmap = (Bitmap) z3.this.b.get(this.f28095a);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapA = a();
            if (bitmapA == null) {
                z3.this.f28089a.submit(this);
            } else {
                imageView.setImageBitmap(bitmapA);
                z3.this.b.put(this.f28095a, bitmapA);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f28095a).openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                if (httpURLConnection.getResponseCode() != 200) {
                    b();
                    return;
                }
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                z3.this.c.post(new a(bitmapDecodeStream));
                z3.this.b.put(this.f28095a, bitmapDecodeStream);
                String str = this.f28095a;
                File file = new File(j4.a(z3.d), z3.b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
                jh.a("BeiZis", "BeiZiImageUtils run file == " + file);
                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(file));
            } catch (FileNotFoundException unused) {
            } catch (Exception unused2) {
                b();
            }
        }

        private Bitmap a() {
            String str = this.f28095a;
            File file = new File(j4.a(z3.d), z3.b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
            jh.a("BeiZis", "BeiZiImageUtils getBitmapFile file == " + file);
            if (!file.exists() || file.length() <= 0) {
                return null;
            }
            return BitmapFactory.decodeFile(file.getAbsolutePath());
        }
    }

    public d a(String str) {
        return new d(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public void a(String str, c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bitmap bitmap = (Bitmap) this.b.get(str);
        if (bitmap != null) {
            cVar.a(bitmap);
            return;
        }
        File file = new File(j4.a(d), b(str.substring(str.lastIndexOf(WVNativeCallbackUtil.SEPERATER) + 1)));
        Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
        if (bitmapDecodeFile != null) {
            this.b.put(str, bitmapDecodeFile);
            cVar.a(bitmapDecodeFile);
        } else {
            this.f28089a.submit(new a(str, cVar));
        }
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            int i = (b2 >>> 4) & 15;
            int i2 = 0;
            while (true) {
                sb.append((char) ((i < 0 || i > 9) ? i + 87 : i + 48));
                i = b2 & com.google.common.base.a.q;
                int i3 = i2 + 1;
                if (i2 >= 1) {
                    break;
                }
                i2 = i3;
            }
        }
        return sb.toString();
    }
}
