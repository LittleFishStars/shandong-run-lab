package com.kc.cw.ad.internal.utilities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.kc.cw.ad.d.b.c;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.c.h;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.utils.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ImageManager {
    private static volatile ImageManager instance;
    private static SoftReference<Context> mContext;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final LruCache<String, Bitmap> imageCache = new LruCache<>(4194304);
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.utilities.ImageManager$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements Runnable {
        final ImageManager this$0;
        final String val$imgUrl;
        final BitmapLoadedListener val$listener;

        /* JADX INFO: renamed from: com.kc.cw.ad.internal.utilities.ImageManager$1$1, reason: invalid class name and collision with other inner class name */
        @Keep
        public class RunnableC10121 implements Runnable {
            final AnonymousClass1 this$1;

            public RunnableC10121(AnonymousClass1 anonymousClass1) {
                this.this$1 = anonymousClass1;
            }

            /* JADX WARN: Code duplicated, block: B:48:0x00e0 A[Catch: Exception -> 0x00dc, TryCatch #3 {Exception -> 0x00dc, blocks: (B:44:0x00d8, B:48:0x00e0, B:50:0x00e5), top: B:57:0x00d8 }] */
            /* JADX WARN: Code duplicated, block: B:50:0x00e5 A[Catch: Exception -> 0x00dc, TRY_LEAVE, TryCatch #3 {Exception -> 0x00dc, blocks: (B:44:0x00d8, B:48:0x00e0, B:50:0x00e5), top: B:57:0x00d8 }] */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                InputStream inputStream;
                Throwable th;
                HttpURLConnection httpURLConnection;
                FileOutputStream fileOutputStream = null;
                try {
                    try {
                        httpURLConnection = (HttpURLConnection) new URL(this.this$1.val$imgUrl).openConnection();
                        try {
                            httpURLConnection.setRequestMethod("GET");
                            httpURLConnection.setConnectTimeout(2000);
                            if (httpURLConnection.getResponseCode() == 200) {
                                inputStream = httpURLConnection.getInputStream();
                                try {
                                    try {
                                        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                                        this.this$1.this$0.handler.post(new Runnable(this, bitmapDecodeStream) { // from class: com.kc.cw.ad.internal.utilities.ImageManager.1.1.1
                                            final RunnableC10121 this$2;
                                            final Bitmap val$bm;

                                            {
                                                this.this$2 = this;
                                                this.val$bm = bitmapDecodeStream;
                                            }

                                            @Override // java.lang.Runnable
                                            public void run() {
                                                this.this$2.this$1.val$listener.onBitmapLoaded(this.val$bm);
                                            }
                                        });
                                        this.this$1.this$0.imageCache.put(this.this$1.val$imgUrl, bitmapDecodeStream);
                                        if (ImageManager.mContext != null && ImageManager.mContext.get() != null) {
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(c.c((Context) ImageManager.mContext.get()), h.a(this.this$1.val$imgUrl)));
                                            try {
                                                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                                fileOutputStream = fileOutputStream2;
                                            } catch (Exception unused) {
                                                fileOutputStream = fileOutputStream2;
                                                this.this$1.this$0.handler.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.utilities.ImageManager.1.1.2
                                                    final RunnableC10121 this$2;

                                                    {
                                                        this.this$2 = this;
                                                    }

                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        this.this$2.this$1.val$listener.onBitmapLoadFailed();
                                                    }
                                                });
                                                if (fileOutputStream != null) {
                                                    fileOutputStream.close();
                                                }
                                                if (inputStream != null) {
                                                    inputStream.close();
                                                }
                                                if (httpURLConnection == null) {
                                                    return;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                fileOutputStream = fileOutputStream2;
                                                if (fileOutputStream != null) {
                                                    try {
                                                        fileOutputStream.close();
                                                        if (inputStream != null) {
                                                            inputStream.close();
                                                        }
                                                        if (httpURLConnection != null) {
                                                            httpURLConnection.disconnect();
                                                        }
                                                    } catch (Exception e) {
                                                        f.a("OctopusAd", "An Exception Caught", e);
                                                        throw th;
                                                    }
                                                } else {
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    if (httpURLConnection != null) {
                                                        httpURLConnection.disconnect();
                                                    }
                                                }
                                                throw th;
                                            }
                                        }
                                    } catch (Exception unused2) {
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = fileOutputStream;
                                    httpURLConnection = httpURLConnection;
                                }
                            } else {
                                inputStream = null;
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Exception unused3) {
                            inputStream = null;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream = null;
                        }
                    } catch (Exception e2) {
                        f.a("OctopusAd", "An Exception Caught", e2);
                        return;
                    }
                } catch (Exception unused4) {
                    httpURLConnection = null;
                    inputStream = null;
                } catch (Throwable th5) {
                    inputStream = null;
                    th = th5;
                    httpURLConnection = null;
                }
                httpURLConnection.disconnect();
            }
        }

        public AnonymousClass1(ImageManager imageManager, String str, BitmapLoadedListener bitmapLoadedListener) {
            this.this$0 = imageManager;
            this.val$imgUrl = str;
            this.val$listener = bitmapLoadedListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap = (Bitmap) this.this$0.imageCache.get(this.val$imgUrl);
            if (bitmap != null) {
                this.val$listener.onBitmapLoaded(bitmap);
                return;
            }
            File file = new File(c.c((Context) ImageManager.mContext.get()), h.a(this.val$imgUrl));
            Bitmap bitmapDecodeFile = (!file.exists() || file.length() <= 0) ? null : BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bitmapDecodeFile == null) {
                this.this$0.executorService.submit(new RunnableC10121(this));
            } else {
                this.this$0.imageCache.put(this.val$imgUrl, bitmapDecodeFile);
                this.val$listener.onBitmapLoaded(bitmapDecodeFile);
            }
        }
    }

    @Keep
    public interface BitmapLoadedListener {
        void onBitmapLoadFailed();

        void onBitmapLoaded(Bitmap bitmap);
    }

    @Keep
    public class RequestCreatorRunnble implements Runnable {
        HttpURLConnection conn;
        int errorResId;
        int holderResId;
        ImageView imageView;
        InputStream is;
        FileOutputStream os;
        final ImageManager this$0;
        String url;

        public RequestCreatorRunnble(ImageManager imageManager, String str) {
            this.this$0 = imageManager;
            this.url = str;
        }

        private Bitmap getBitmapFile() {
            if (ImageManager.mContext != null && ImageManager.mContext.get() != null) {
                File file = new File(c.c((Context) ImageManager.mContext.get()), h.a(this.url));
                if (file.exists() && file.length() > 0) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
            }
            return null;
        }

        private void showError() {
            this.this$0.handler.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.utilities.ImageManager.RequestCreatorRunnble.2
                final RequestCreatorRunnble this$1;

                {
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                }
            });
        }

        public RequestCreatorRunnble error(int i) {
            this.errorResId = i;
            return this;
        }

        public String getImagePath() {
            if (ImageManager.mContext == null || ImageManager.mContext.get() == null || TextUtils.isEmpty(this.url)) {
                return "";
            }
            File file = new File(c.c((Context) ImageManager.mContext.get()), h.a(this.url));
            if (!file.exists() || file.length() <= 0) {
                this.this$0.executorService.submit(this);
                return this.url;
            }
            return "file://" + file.getAbsolutePath();
        }

        public void into(ImageView imageView) {
            this.imageView = imageView;
            if (TextUtils.isEmpty(this.url)) {
                return;
            }
            Bitmap bitmap = (Bitmap) this.this$0.imageCache.get(this.url);
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
                return;
            }
            Bitmap bitmapFile = getBitmapFile();
            if (bitmapFile == null) {
                this.this$0.executorService.submit(this);
            } else {
                imageView.setImageBitmap(bitmapFile);
                this.this$0.imageCache.put(this.url, bitmapFile);
            }
        }

        public RequestCreatorRunnble placeholder(int i) {
            this.holderResId = i;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpURLConnection httpURLConnection;
            try {
                try {
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(this.url).openConnection();
                        this.conn = httpURLConnection2;
                        httpURLConnection2.setRequestMethod("GET");
                        this.conn.setConnectTimeout(2000);
                        if (this.conn.getResponseCode() == 200) {
                            InputStream inputStream = this.conn.getInputStream();
                            this.is = inputStream;
                            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                            this.this$0.handler.post(new Runnable(this, bitmapDecodeStream) { // from class: com.kc.cw.ad.internal.utilities.ImageManager.RequestCreatorRunnble.1
                                final RequestCreatorRunnble this$1;
                                final Bitmap val$bm;

                                {
                                    this.this$1 = this;
                                    this.val$bm = bitmapDecodeStream;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageView imageView = this.this$1.imageView;
                                    if (imageView != null) {
                                        imageView.setImageBitmap(this.val$bm);
                                    }
                                }
                            });
                            this.this$0.imageCache.put(this.url, bitmapDecodeStream);
                            if (ImageManager.mContext != null && ImageManager.mContext.get() != null) {
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(c.c((Context) ImageManager.mContext.get()), h.a(this.url)));
                                this.os = fileOutputStream;
                                bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            }
                        } else {
                            showError();
                        }
                        InputStream inputStream2 = this.is;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        FileOutputStream fileOutputStream2 = this.os;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        httpURLConnection = this.conn;
                        if (httpURLConnection == null) {
                            return;
                        }
                    } catch (Exception e) {
                        f.a("OctopusAd", "An Exception Caught", e);
                        return;
                    }
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                    showError();
                    InputStream inputStream3 = this.is;
                    if (inputStream3 != null) {
                        inputStream3.close();
                    }
                    FileOutputStream fileOutputStream3 = this.os;
                    if (fileOutputStream3 != null) {
                        fileOutputStream3.close();
                    }
                    httpURLConnection = this.conn;
                    if (httpURLConnection == null) {
                        return;
                    }
                }
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                try {
                    InputStream inputStream4 = this.is;
                    if (inputStream4 != null) {
                        inputStream4.close();
                    }
                    FileOutputStream fileOutputStream4 = this.os;
                    if (fileOutputStream4 != null) {
                        fileOutputStream4.close();
                    }
                    HttpURLConnection httpURLConnection3 = this.conn;
                    if (httpURLConnection3 != null) {
                        httpURLConnection3.disconnect();
                    }
                } catch (Exception e3) {
                    f.a("OctopusAd", "An Exception Caught", e3);
                }
                throw th;
            }
        }
    }

    private static ImageManager getInstance() {
        if (instance == null) {
            synchronized (ImageManager.class) {
                try {
                    if (instance == null) {
                        instance = new ImageManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static ImageManager with(Context context) {
        if (q.a().s != null) {
            mContext = new SoftReference<>(q.a().s);
        } else {
            mContext = new SoftReference<>(context);
        }
        return getInstance();
    }

    public void getBitmap(String str, BitmapLoadedListener bitmapLoadedListener) {
        SoftReference<Context> softReference = mContext;
        if (softReference == null || softReference.get() == null || TextUtils.isEmpty(str)) {
            return;
        }
        ThreadUtils.runOnThreadPool(new AnonymousClass1(this, str, bitmapLoadedListener));
    }

    public RequestCreatorRunnble load(String str) {
        return new RequestCreatorRunnble(this, str);
    }
}
