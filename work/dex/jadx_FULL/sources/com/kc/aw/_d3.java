package com.kc.aw;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.ot.LruDiskUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _d3 extends AsyncTask<String, Void, Bitmap> {
    public _g _b;
    public Application _c;
    public boolean _h;
    public boolean _j;
    public boolean _k;
    public final Handler _a = new Handler(Looper.getMainLooper());
    public boolean _d = false;
    public volatile boolean _e = false;
    public final _b _f = new _b(TimeUnit.SECONDS, new LinkedBlockingQueue(30), new _a(), new ThreadPoolExecutor.DiscardOldestPolicy());
    public boolean _g = false;
    public int _i = 0;
    public final _c _l = new _c(this);

    @Keep
    public final class _a implements ThreadFactory {
        public final AtomicInteger _a = new AtomicInteger(1);

        /* JADX INFO: renamed from: com.kc.aw._d3$_a$_a, reason: collision with other inner class name */
        @Keep
        public final class C0936_a implements Thread.UncaughtExceptionHandler {
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                StringBuilder sb_a = _jf._a("Thread ");
                sb_a.append(thread.getName());
                sb_a.append(" crashed");
                Logger.e("DownloadError", sb_a.toString(), th);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            StringBuilder sb_a = _jf._a("ImageDownload-");
            sb_a.append(this._a.getAndIncrement());
            Thread thread = new Thread(runnable, sb_a.toString());
            thread.setPriority(1);
            thread.setUncaughtExceptionHandler(new C0936_a());
            return thread;
        }
    }

    @Keep
    public final class _b extends ThreadPoolExecutor {
        public _b(TimeUnit timeUnit, LinkedBlockingQueue linkedBlockingQueue, _a _aVar, ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy) {
            super(4, 8, 30L, timeUnit, linkedBlockingQueue, _aVar, discardOldestPolicy);
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            allowCoreThreadTimeOut(true);
        }
    }

    @Keep
    public final class _c implements Runnable {
        public final _d3 _a;

        public _c(_d3 _d3Var) {
            this._a = _d3Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _d3 _d3Var = this._a;
            if (_d3Var._j) {
                return;
            }
            _d3Var._k = true;
            try {
                _g _gVar = _d3Var._b;
                if (_gVar != null) {
                    ((_d) _gVar)._a(new Exception("image load timeout!"));
                    this._a._b = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Keep
    public interface _d extends _g {
        void _a(Exception exc);
    }

    @Keep
    public static abstract class _e implements _d {
        public abstract void _a();

        @Override // com.kc.aw._d3._g
        public final void _a(Bitmap bitmap) {
        }
    }

    @Keep
    public static final class _f implements _g {
        public WeakReference<ImageView> _a;

        public _f(PlaceholderImageView placeholderImageView) {
            this._a = new WeakReference<>(placeholderImageView);
        }

        @Override // com.kc.aw._d3._g
        public final void _a(Bitmap bitmap) {
            ImageView imageView = this._a.get();
            if (imageView == null || bitmap == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    @Keep
    public interface _g {
        void _a(Bitmap bitmap);
    }

    public _d3(Context context, _d _dVar) {
        this._b = _dVar;
        this._c = _bq._a(context);
    }

    public _d3(Context context, PlaceholderImageView placeholderImageView) {
        this._b = new _f(placeholderImageView);
        this._c = _bq._a(context);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x010d  */
    /* JADX WARN: Code duplicated, block: B:79:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:? A[SYNTHETIC] */
    public static long _a(String str, File file) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        Throwable th;
        Throwable th2;
        InputStream inputStream2;
        _c9 _c9Var = _m4._a;
        String str2 = "";
        FileOutputStream fileOutputStream = null;
        if (_c9Var != null) {
            if (TextUtils.isEmpty(_c9Var._z)) {
                ArrayList arrayList = _cb._b;
                String str_c = _nw._c;
                if (TextUtils.isEmpty(str_c)) {
                    str_c = _jw._c(PtgAdSdk.getContext(), "ptg_ua");
                    Context context = PtgAdSdk.getContext();
                    if (context != null && _nw._b.get() <= 3 && _nw._a.compareAndSet(false, true)) {
                        com.kc.aw.lib.utils._d._b(new _nv(context, null));
                    } else {
                        _nw._a(null, "");
                    }
                }
                str2 = TextUtils.isEmpty(str_c) ? "" : str_c;
                _c9Var._z = str2;
            } else {
                str2 = _c9Var._z;
            }
        }
        URL url = new URL(str);
        int i = 0;
        while (true) {
            if (i >= 5) {
                httpURLConnection = null;
                break;
            }
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setRequestProperty("Host", url.getAuthority());
                    httpURLConnection.setRequestProperty("User-Agent", str2);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setConnectTimeout(10000);
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 300 && responseCode < 400) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            break;
                        }
                        i++;
                        URL url2 = new URL(headerField);
                        httpURLConnection.disconnect();
                        url = url2;
                    } else {
                        if (responseCode == 200) {
                            break;
                        }
                        throw new IOException("HTTP request failed: " + responseCode);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    InputStream inputStream3 = inputStream;
                    th2 = th;
                    inputStream2 = inputStream3;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnection == null) {
                        throw th2;
                    }
                    httpURLConnection.disconnect();
                    throw th2;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = null;
                httpURLConnection = null;
            }
        }
        if (i >= 5) {
            throw new IOException("Too many redirects: 5");
        }
        inputStream2 = httpURLConnection.getInputStream();
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                long j = 0;
                while (true) {
                    int i2 = inputStream2.read(bArr);
                    if (i2 != -1) {
                        fileOutputStream2.write(bArr, 0, i2);
                        j += (long) i2;
                    } else {
                        try {
                            break;
                        } catch (IOException unused3) {
                        }
                    }
                }
                inputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (IOException unused4) {
                }
                httpURLConnection.disconnect();
                return j;
            } catch (Throwable th5) {
                th2 = th5;
                fileOutputStream = fileOutputStream2;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (httpURLConnection == null) {
                    throw th2;
                }
                httpURLConnection.disconnect();
                throw th2;
            }
        } catch (Throwable th6) {
            inputStream = inputStream2;
            th = th6;
            InputStream inputStream4 = inputStream;
            th2 = th;
            inputStream2 = inputStream4;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (httpURLConnection == null) {
                throw th2;
            }
            httpURLConnection.disconnect();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0146  */
    /* JADX WARN: Code duplicated, block: B:102:0x0148 A[Catch: Exception -> 0x0150, TryCatch #0 {Exception -> 0x0150, blocks: (B:92:0x0121, B:102:0x0148, B:103:0x014f, B:98:0x0140, B:95:0x012f), top: B:163:0x0121, inners: #14 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0181  */
    /* JADX WARN: Code duplicated, block: B:123:0x018c A[Catch: all -> 0x01ab, TryCatch #8 {, blocks: (B:121:0x0188, B:123:0x018c, B:125:0x0195, B:126:0x019a, B:127:0x01a9), top: B:177:0x0188 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x0195 A[Catch: all -> 0x01ab, TryCatch #8 {, blocks: (B:121:0x0188, B:123:0x018c, B:125:0x0195, B:126:0x019a, B:127:0x01a9), top: B:177:0x0188 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:169:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:177:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:200:0x00bc A[EXC_TOP_SPLITTER, PHI: r0 r2
      0x00bc: PHI (r0v4 android.media.MediaMetadataRetriever) = (r0v3 android.media.MediaMetadataRetriever), (r0v9 android.media.MediaMetadataRetriever) binds: [B:57:0x00ba, B:49:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      0x00bc: PHI (r2v4 android.graphics.Bitmap) = (r2v3 android.graphics.Bitmap), (r2v14 android.graphics.Bitmap) binds: [B:57:0x00ba, B:49:0x00ae] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:142:0x01cb, please report this as an issue */
    @Override // android.os.AsyncTask
    public final Bitmap doInBackground(String[] strArr) throws Throwable {
        Exception e;
        Bitmap asBitmap;
        MediaMetadataRetriever mediaMetadataRetriever;
        Application application;
        String str;
        FileOutputStream fileOutputStream;
        Exception e2;
        LruDiskUtils._b _bVarTransaction;
        _g _gVar;
        boolean z = false;
        String str2 = strArr[0];
        String str_c = com.kc.aw.lib.utils._a._c(str2);
        MediaMetadataRetriever mediaMetadataRetriever2 = null;
        Bitmap bitmap_a = null;
        try {
            if (this._g) {
                try {
                    try {
                        if (this._d) {
                            if (this._c != null && str2 != null) {
                                try {
                                    File file = LruDiskUtils.get(this._c).file(com.kc.aw.lib.utils._a._c(str2));
                                    if (file != null && file.exists()) {
                                        z = true;
                                    }
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            z = !z;
                            asBitmap = null;
                        } else {
                            if (this._c == null || str2 == null) {
                                asBitmap = null;
                            } else {
                                try {
                                    asBitmap = LruDiskUtils.get(this._c).getAsBitmap(com.kc.aw.lib.utils._a._c(str2));
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                    asBitmap = null;
                                }
                            }
                            if (asBitmap == null) {
                                z = true;
                            }
                        }
                        if (z) {
                            try {
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str2, new HashMap());
                                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L, 2);
                                    if (frameAtTime != null) {
                                        asBitmap = Bitmap.createScaledBitmap(frameAtTime, frameAtTime.getWidth() / 2, frameAtTime.getHeight() / 2, true);
                                        LruDiskUtils._b _bVarTransaction2 = LruDiskUtils.get(this._c).transaction(str_c);
                                        try {
                                            FileOutputStream fileOutputStream2 = new FileOutputStream(_bVarTransaction2._a);
                                            try {
                                                asBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream2);
                                                fileOutputStream2.close();
                                            } catch (Throwable th) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Throwable th2) {
                                                    th.addSuppressed(th2);
                                                }
                                                throw th;
                                            }
                                        } catch (IOException unused) {
                                        }
                                        _bVarTransaction2._a();
                                        frameAtTime.recycle();
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    if (mediaMetadataRetriever != null) {
                                        try {
                                            mediaMetadataRetriever.release();
                                        } catch (Exception unused2) {
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                mediaMetadataRetriever = null;
                                e.printStackTrace();
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (this._h) {
                                    application = this._c;
                                    if (asBitmap != null) {
                                        str = com.kc.aw.lib.utils._a._c(str2) + "_blur";
                                        if (LruDiskUtils.get(application).getAsBitmap(str) == null) {
                                            try {
                                                bitmap_a = _a9._a(asBitmap);
                                            } catch (Exception unused3) {
                                            }
                                            LruDiskUtils._b _bVarTransaction3 = LruDiskUtils.get(application).transaction(str);
                                            try {
                                                fileOutputStream = new FileOutputStream(_bVarTransaction3._a);
                                                try {
                                                    bitmap_a.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                                                    fileOutputStream.close();
                                                } catch (Throwable th3) {
                                                    try {
                                                        fileOutputStream.close();
                                                    } catch (Throwable th4) {
                                                        th3.addSuppressed(th4);
                                                    }
                                                    throw th3;
                                                }
                                            } catch (IOException unused4) {
                                            }
                                            _bVarTransaction3._a();
                                        }
                                    }
                                }
                                return asBitmap;
                            }
                        } else {
                            mediaMetadataRetriever = null;
                        }
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                    } catch (Exception e7) {
                        e = e7;
                        asBitmap = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (mediaMetadataRetriever2 != null) {
                        try {
                            mediaMetadataRetriever2.release();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } else {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        throw new NullPointerException("download image url empty");
                    }
                    if (this._d) {
                        if (this._c != null && str2 != null) {
                            try {
                                File file2 = LruDiskUtils.get(this._c).file(com.kc.aw.lib.utils._a._c(str2));
                                if (file2 != null && file2.exists()) {
                                    z = true;
                                }
                            } catch (Exception e8) {
                                e8.printStackTrace();
                            }
                        }
                        z = !z;
                        asBitmap = null;
                    } else {
                        if (this._c == null || str2 == null) {
                            asBitmap = null;
                        } else {
                            try {
                                asBitmap = LruDiskUtils.get(this._c).getAsBitmap(com.kc.aw.lib.utils._a._c(str2));
                            } catch (Exception e9) {
                                e9.printStackTrace();
                                asBitmap = null;
                            }
                        }
                        if (asBitmap == null) {
                            z = true;
                        }
                    }
                    try {
                        if (z) {
                            _bVarTransaction = LruDiskUtils.get(this._c).transaction(str_c);
                            try {
                                _a(str2, _bVarTransaction._a);
                                _bVarTransaction._a();
                                if (this._c == null || str2 == null) {
                                    asBitmap = null;
                                    if (asBitmap != null) {
                                        throw new NullPointerException("download image download fail");
                                    }
                                } else {
                                    try {
                                        asBitmap = LruDiskUtils.get(this._c).getAsBitmap(com.kc.aw.lib.utils._a._c(str2));
                                    } catch (Exception e10) {
                                        e10.printStackTrace();
                                        asBitmap = null;
                                    }
                                    if (asBitmap != null) {
                                        throw new NullPointerException("download image download fail");
                                    }
                                }
                            } catch (Exception e11) {
                                e2 = e11;
                                Logger.e("Error", e2.getMessage());
                                e2.printStackTrace();
                                if (_bVarTransaction != null) {
                                    synchronized (_bVarTransaction._e.transactionMap) {
                                        if (!_bVarTransaction._c) {
                                            _bVarTransaction._a.deleteOnExit();
                                            if (!_bVarTransaction._d) {
                                                _bVarTransaction._b.deleteOnExit();
                                            }
                                        }
                                        _bVarTransaction._e.transactionMap.remove(_bVarTransaction._b.getAbsolutePath());
                                    }
                                }
                                _gVar = this._b;
                                if (_gVar != null) {
                                    this._e = true;
                                    this._a.post(new _d4(this, e2));
                                }
                            }
                        } else {
                            File file3 = LruDiskUtils.get(this._c).file(str_c);
                            if (file3 != null) {
                                file3.length();
                            }
                        }
                    } catch (Exception e12) {
                        e2 = e12;
                        _bVarTransaction = null;
                    }
                } catch (Exception e13) {
                    e2 = e13;
                    _bVarTransaction = null;
                    asBitmap = null;
                }
                Logger.e("Error", e2.getMessage());
                e2.printStackTrace();
                if (_bVarTransaction != null) {
                    synchronized (_bVarTransaction._e.transactionMap) {
                        if (!_bVarTransaction._c) {
                            _bVarTransaction._a.deleteOnExit();
                            if (!_bVarTransaction._d) {
                                _bVarTransaction._b.deleteOnExit();
                            }
                        }
                        _bVarTransaction._e.transactionMap.remove(_bVarTransaction._b.getAbsolutePath());
                    }
                }
                _gVar = this._b;
                if (_gVar != null && (_gVar instanceof _d)) {
                    this._e = true;
                    this._a.post(new _d4(this, e2));
                }
            }
            if (this._h) {
                application = this._c;
                if (asBitmap != null) {
                    str = com.kc.aw.lib.utils._a._c(str2) + "_blur";
                    if (LruDiskUtils.get(application).getAsBitmap(str) == null) {
                        bitmap_a = _a9._a(asBitmap);
                        LruDiskUtils._b _bVarTransaction4 = LruDiskUtils.get(application).transaction(str);
                        fileOutputStream = new FileOutputStream(_bVarTransaction4._a);
                        bitmap_a.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                        fileOutputStream.close();
                        _bVarTransaction4._a();
                    }
                }
            }
            return asBitmap;
        } catch (Throwable th6) {
            th = th6;
            mediaMetadataRetriever2 = null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Bitmap bitmap) {
        _c _cVar;
        Bitmap bitmap2 = bitmap;
        if (this._i > 0) {
            if (this._k) {
                return;
            }
            this._j = true;
            Handler handler = this._a;
            if (handler != null && (_cVar = this._l) != null) {
                handler.removeCallbacks(_cVar);
            }
        }
        _g _gVar = this._b;
        if (_gVar != null) {
            if (!(_gVar instanceof _d)) {
                _gVar._a(bitmap2);
            } else if (!this._e) {
                this._e = true;
                _g _gVar2 = this._b;
                if (_gVar2 instanceof _e) {
                    ((_e) _gVar2)._a();
                }
                _gVar = this._b;
                _gVar._a(bitmap2);
            }
            this._b = null;
        }
    }
}
