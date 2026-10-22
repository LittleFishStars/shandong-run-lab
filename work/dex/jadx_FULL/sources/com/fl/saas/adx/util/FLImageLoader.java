package com.fl.saas.adx.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StatFs;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;
import com.aliyun.vod.common.utils.FileUtils;
import com.fl.saas.C1401c;
import com.fl.saas.S;
import com.fl.saas.adx.util.FLImageLoader;
import com.google.android.exoplayer2.util.FileTypes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLImageLoader {
    private static final float CACHE_SIZE_RATIO = 0.005f;
    private static final float CLEANUP_THRESHOLD_RATIO = 0.9f;
    private static final long DEFAULT_CLEANUP_THRESHOLD = 188743680;
    private static final long DEFAULT_MAX_DISK_CACHE_SIZE = 209715200;
    private static final String TAG = "FLImageLoader";
    private static volatile FLImageLoader instance;
    private LruCache<String, Bitmap> bitmapCache;
    private File cacheDir;
    private LruCache<String, File> gifFileCache;
    private LruCache<String, Bitmap> gifFirstFrameCache;
    private Map<String, ImageLoadTask> taskMap = new ConcurrentHashMap();
    private Map<String, BitmapLoadTask> bitmapLoadTaskMap = new ConcurrentHashMap();
    private int defaultImageResId = 0;
    private int errorImageResId = 0;
    private boolean enableDiskCache = true;
    private boolean enableMemoryCache = false;
    private boolean forceArgb8888 = true;
    private long maxDiskCacheSize = DEFAULT_MAX_DISK_CACHE_SIZE;
    private long cleanupThreshold = DEFAULT_CLEANUP_THRESHOLD;
    private Handler mainHandler = new Handler(Looper.getMainLooper());

    public class BitmapLoadTask extends AsyncTask<Void, Void, Object> {
        private String imageUrl;
        private boolean isGif;
        private boolean isWebp;
        private OnBitmapLoadListener listener;

        public BitmapLoadTask(String str, boolean z, OnBitmapLoadListener onBitmapLoadListener) {
            this.imageUrl = str;
            this.isGif = z;
            this.isWebp = str.toLowerCase().endsWith(".webp");
            this.listener = onBitmapLoadListener;
        }

        private Bitmap safeCompressBitmap(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width <= 1024 && height <= 1024) {
                    return bitmap;
                }
                float f = 1024;
                float f2 = width;
                float f3 = height;
                float fMin = Math.min(f / f2, f / f3);
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.max((int) (f2 * fMin), 1), Math.max((int) (f3 * fMin), 1), true);
                    if (bitmapCreateScaledBitmap == bitmap) {
                        return bitmap;
                    }
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return bitmapCreateScaledBitmap;
                } catch (OutOfMemoryError e) {
                    Log.e(FLImageLoader.TAG, "Out of memory compressing bitmap", e);
                    return bitmap;
                }
                Log.e(FLImageLoader.TAG, "Error compressing bitmap", e);
                return bitmap;
            } catch (Exception e2) {
                Log.e(FLImageLoader.TAG, "Error compressing bitmap", e2);
                return bitmap;
            }
        }

        /* JADX WARN: Code duplicated, block: B:34:0x0087 A[Catch: Exception -> 0x008b, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x008b, blocks: (B:23:0x0074, B:34:0x0087), top: B:50:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
        private void safeSaveBitmapToDiskCache(String str, Bitmap bitmap) throws Throwable {
            FileOutputStream fileOutputStream;
            if (!FLImageLoader.this.enableDiskCache || bitmap == null || FLImageLoader.this.cacheDir == null) {
                return;
            }
            FLImageLoader.this.checkAndCleanupDiskCacheIfNeeded();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        String cacheFilename = FLImageLoader.this.getCacheFilename(str);
                        if (cacheFilename == null) {
                            return;
                        }
                        File file = new File(FLImageLoader.this.cacheDir, cacheFilename);
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            if (cacheFilename.endsWith(".png")) {
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            } else {
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
                            }
                            fileOutputStream.flush();
                            Log.d(FLImageLoader.TAG, "Saved bitmap to disk cache: " + cacheFilename);
                            fileOutputStream.close();
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            Log.e(FLImageLoader.TAG, "Error saving bitmap to disk cache", e);
                            if (fileOutputStream2 == null) {
                                return;
                            } else {
                                fileOutputStream2.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    Log.e(FLImageLoader.TAG, "Error closing stream", e2);
                                }
                            }
                            throw th;
                        }
                        return;
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (fileOutputStream2 == null) {
                        fileOutputStream2.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
                Log.e(FLImageLoader.TAG, "Error saving bitmap to disk cache", e);
            } catch (Exception e4) {
                Log.e(FLImageLoader.TAG, "Error closing stream", e4);
            }
        }

        public void addListener(OnBitmapLoadListener onBitmapLoadListener) {
            this.listener = onBitmapLoadListener;
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            try {
                FLImageLoader.this.bitmapLoadTaskMap.remove(this.imageUrl);
            } catch (Exception e) {
                Log.e(FLImageLoader.TAG, "Error removing bitmap task on cancellation", e);
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            FLImageLoader fLImageLoader;
            OnBitmapLoadListener onBitmapLoadListener;
            String str;
            String str2;
            try {
                FLImageLoader.this.bitmapLoadTaskMap.remove(this.imageUrl);
                if (obj == null || !(obj instanceof Bitmap)) {
                    fLImageLoader = FLImageLoader.this;
                    onBitmapLoadListener = this.listener;
                    str = this.imageUrl;
                    str2 = "Load failed";
                } else {
                    Bitmap bitmap = (Bitmap) obj;
                    if (!bitmap.isRecycled()) {
                        if (FLImageLoader.this.enableMemoryCache) {
                            if (this.isGif) {
                                FLImageLoader.this.addGifFirstFrameToMemoryCache(this.imageUrl, bitmap);
                            } else {
                                FLImageLoader.this.addBitmapToMemoryCache(this.imageUrl, bitmap);
                            }
                        }
                        FLImageLoader.this.safeCallBitmapLoaded(this.listener, this.imageUrl, bitmap, false);
                        return;
                    }
                    fLImageLoader = FLImageLoader.this;
                    onBitmapLoadListener = this.listener;
                    str = this.imageUrl;
                    str2 = "Bitmap is null or recycled";
                }
                fLImageLoader.safeCallBitmapLoadFailed(onBitmapLoadListener, str, str2);
            } catch (Exception e) {
                Log.e(FLImageLoader.TAG, "Error in BitmapLoadTask onPostExecute", e);
                FLImageLoader.this.safeCallBitmapLoadFailed(this.listener, this.imageUrl, "Unexpected error: " + e.getMessage());
            }
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Void... voidArr) throws Throwable {
            String cacheFilename;
            try {
                if (isCancelled()) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.imageUrl).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                if (isCancelled()) {
                    httpURLConnection.disconnect();
                    return null;
                }
                httpURLConnection.connect();
                if (isCancelled()) {
                    httpURLConnection.disconnect();
                    return null;
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    httpURLConnection.disconnect();
                    Log.e(FLImageLoader.TAG, "HTTP error: " + httpURLConnection.getResponseCode() + " for URL: " + this.imageUrl);
                    return null;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                if (isCancelled()) {
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return null;
                }
                if (!this.isGif) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    httpURLConnection.disconnect();
                    if (isCancelled()) {
                        if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                            bitmapDecodeStream.recycle();
                        }
                        return null;
                    }
                    if (bitmapDecodeStream != null) {
                        if (this.isWebp) {
                            bitmapDecodeStream = FLImageLoader.this.checkAndFixBitmapConfig(bitmapDecodeStream, this.imageUrl);
                        }
                        bitmapDecodeStream = safeCompressBitmap(bitmapDecodeStream);
                        if (isCancelled()) {
                            if (!bitmapDecodeStream.isRecycled()) {
                                bitmapDecodeStream.recycle();
                            }
                            return null;
                        }
                        if (FLImageLoader.this.enableDiskCache && FLImageLoader.this.cacheDir != null) {
                            safeSaveBitmapToDiskCache(this.imageUrl, bitmapDecodeStream);
                        }
                    }
                    return bitmapDecodeStream;
                }
                byte[] bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        if (isCancelled()) {
                            return null;
                        }
                        if (FLImageLoader.this.enableDiskCache && FLImageLoader.this.cacheDir != null) {
                            FLImageLoader.this.saveToDiskCache(this.imageUrl, byteArray);
                        }
                        Bitmap bitmapDecodeGifFirstFrame = FLImageLoader.this.decodeGifFirstFrame(byteArray);
                        if (FLImageLoader.this.enableMemoryCache && FLImageLoader.this.cacheDir != null && (cacheFilename = FLImageLoader.this.getCacheFilename(this.imageUrl)) != null) {
                            FLImageLoader.this.addGifToMemoryCache(this.imageUrl, new File(FLImageLoader.this.cacheDir, cacheFilename));
                        }
                        return bitmapDecodeGifFirstFrame;
                    }
                    if (isCancelled()) {
                        inputStream.close();
                        byteArrayOutputStream.close();
                        httpURLConnection.disconnect();
                        return null;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Exception e) {
                Log.e(FLImageLoader.TAG, "Error loading bitmap: " + this.imageUrl, e);
            } catch (OutOfMemoryError e2) {
                Log.e(FLImageLoader.TAG, "Out of memory loading bitmap: " + this.imageUrl, e2);
                System.gc();
            }
        }
    }

    public static class CacheFileInfo {
        private String fileName;
        private long fileSize;
        private long lastModified;

        public CacheFileInfo(String str, long j, long j2) {
            this.fileName = str;
            this.lastModified = j;
            this.fileSize = j2;
        }

        public String getFileName() {
            return this.fileName;
        }

        public long getFileSize() {
            return this.fileSize;
        }

        public long getLastModified() {
            return this.lastModified;
        }
    }

    public class ImageLoadTask extends AsyncTask<Void, Void, Object> {
        private String imageUrl;
        private ImageView imageView;
        private boolean isGif;
        private boolean isWebp;
        private OnImageLoadListener listener;

        public class GifLoadResult {
            Bitmap firstFrameBitmap;
            byte[] gifData;

            public GifLoadResult(byte[] bArr, Bitmap bitmap) {
                this.gifData = bArr;
                this.firstFrameBitmap = bitmap;
            }
        }

        public ImageLoadTask(ImageView imageView, String str, boolean z, OnImageLoadListener onImageLoadListener) {
            this.imageView = imageView;
            this.imageUrl = str;
            this.isGif = z;
            this.isWebp = str.toLowerCase().endsWith(".webp");
            this.listener = onImageLoadListener;
        }

        private Bitmap safeCompressBitmap(Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width <= 1024 && height <= 1024) {
                    return bitmap;
                }
                float f = 1024;
                float f2 = width;
                float f3 = height;
                float fMin = Math.min(f / f2, f / f3);
                try {
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.max((int) (f2 * fMin), 1), Math.max((int) (f3 * fMin), 1), true);
                    if (bitmapCreateScaledBitmap == bitmap) {
                        return bitmap;
                    }
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return bitmapCreateScaledBitmap;
                } catch (OutOfMemoryError e) {
                    Log.e(FLImageLoader.TAG, "Out of memory compressing bitmap", e);
                    return bitmap;
                }
                Log.e(FLImageLoader.TAG, "Error compressing bitmap", e);
                return bitmap;
            } catch (Exception e2) {
                Log.e(FLImageLoader.TAG, "Error compressing bitmap", e2);
                return bitmap;
            }
        }

        /* JADX WARN: Code duplicated, block: B:38:0x0092 A[Catch: Exception -> 0x0096, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0096, blocks: (B:27:0x007f, B:38:0x0092), top: B:55:0x001e }] */
        /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
        private void safeSaveBitmapToDiskCache(String str, Bitmap bitmap) throws Throwable {
            FileOutputStream fileOutputStream;
            Bitmap.CompressFormat compressFormat;
            if (!FLImageLoader.this.enableDiskCache || bitmap == null || FLImageLoader.this.cacheDir == null) {
                return;
            }
            FLImageLoader.this.checkAndCleanupDiskCacheIfNeeded();
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    try {
                        String cacheFilename = FLImageLoader.this.getCacheFilename(str);
                        if (cacheFilename == null) {
                            return;
                        }
                        File file = new File(FLImageLoader.this.cacheDir, cacheFilename);
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            if (!cacheFilename.endsWith(".png")) {
                                if (cacheFilename.endsWith(".webp")) {
                                    compressFormat = Bitmap.CompressFormat.WEBP;
                                } else {
                                    bitmap.compress(Bitmap.CompressFormat.JPEG, 85, fileOutputStream);
                                }
                                fileOutputStream.flush();
                                Log.d(FLImageLoader.TAG, "Saved bitmap to disk cache: " + cacheFilename);
                                fileOutputStream.close();
                                return;
                            }
                            compressFormat = Bitmap.CompressFormat.PNG;
                            bitmap.compress(compressFormat, 100, fileOutputStream);
                            fileOutputStream.flush();
                            Log.d(FLImageLoader.TAG, "Saved bitmap to disk cache: " + cacheFilename);
                            fileOutputStream.close();
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream2 = fileOutputStream;
                            Log.e(FLImageLoader.TAG, "Error saving bitmap to disk cache", e);
                            if (fileOutputStream2 == null) {
                                return;
                            } else {
                                fileOutputStream2.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e2) {
                                    Log.e(FLImageLoader.TAG, "Error closing stream", e2);
                                }
                            }
                            throw th;
                        }
                        return;
                    } catch (Exception e3) {
                        e = e3;
                    }
                    if (fileOutputStream2 == null) {
                        fileOutputStream2.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                }
                Log.e(FLImageLoader.TAG, "Error saving bitmap to disk cache", e);
            } catch (Exception e4) {
                Log.e(FLImageLoader.TAG, "Error closing stream", e4);
            }
        }

        public void addListener(OnImageLoadListener onImageLoadListener) {
            this.listener = onImageLoadListener;
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
            try {
                FLImageLoader.this.taskMap.remove(this.imageUrl);
            } catch (Exception e) {
                Log.e(FLImageLoader.TAG, "Error removing task on cancellation", e);
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            FLImageLoader fLImageLoader;
            OnImageLoadListener onImageLoadListener;
            String str;
            String str2;
            String cacheFilename;
            try {
                FLImageLoader.this.taskMap.remove(this.imageUrl);
                ImageView imageView = this.imageView;
                if (imageView == null) {
                    return;
                }
                if (obj != null) {
                    boolean z = this.isGif;
                    if (z && (obj instanceof GifLoadResult)) {
                        GifLoadResult gifLoadResult = (GifLoadResult) obj;
                        try {
                            if (FLImageLoader.this.enableMemoryCache && (cacheFilename = FLImageLoader.this.getCacheFilename(this.imageUrl)) != null && FLImageLoader.this.cacheDir != null) {
                                FLImageLoader.this.addGifToMemoryCache(this.imageUrl, new File(FLImageLoader.this.cacheDir, cacheFilename));
                                Bitmap bitmap = gifLoadResult.firstFrameBitmap;
                                if (bitmap != null) {
                                    FLImageLoader.this.addGifFirstFrameToMemoryCache(this.imageUrl, bitmap);
                                }
                            }
                            String cacheFilename2 = FLImageLoader.this.getCacheFilename(this.imageUrl);
                            if (cacheFilename2 == null || FLImageLoader.this.cacheDir == null) {
                                FLImageLoader.this.safeSetErrorImage(this.imageView);
                            } else {
                                FLImageLoader.this.safeDisplayGif(this.imageView, new File(FLImageLoader.this.cacheDir, cacheFilename2), this.imageUrl);
                            }
                            FLImageLoader.this.safeCallOnSuccess(this.listener, this.imageUrl, gifLoadResult.firstFrameBitmap, false);
                            return;
                        } catch (Exception e) {
                            Log.e(FLImageLoader.TAG, "Error processing GIF result", e);
                            FLImageLoader.this.safeSetErrorImage(this.imageView);
                            fLImageLoader = FLImageLoader.this;
                            onImageLoadListener = this.listener;
                            str = this.imageUrl;
                            str2 = "Error processing GIF: " + e.getMessage();
                        }
                    } else {
                        if (z || !(obj instanceof Bitmap)) {
                            return;
                        }
                        Bitmap bitmap2 = (Bitmap) obj;
                        if (!bitmap2.isRecycled()) {
                            if (FLImageLoader.this.enableMemoryCache) {
                                FLImageLoader.this.addBitmapToMemoryCache(this.imageUrl, bitmap2);
                            }
                            FLImageLoader.this.safeDisplayBitmap(this.imageView, bitmap2, this.imageUrl);
                            FLImageLoader.this.safeCallOnSuccess(this.listener, this.imageUrl, bitmap2, false);
                            return;
                        }
                        FLImageLoader.this.safeSetErrorImage(this.imageView);
                        fLImageLoader = FLImageLoader.this;
                        onImageLoadListener = this.listener;
                        str = this.imageUrl;
                        str2 = "Bitmap is null or recycled";
                    }
                } else {
                    FLImageLoader.this.safeSetErrorImage(imageView);
                    fLImageLoader = FLImageLoader.this;
                    onImageLoadListener = this.listener;
                    str = this.imageUrl;
                    str2 = "Load failed";
                }
                fLImageLoader.safeCallOnError(onImageLoadListener, str, str2);
            } catch (Exception e2) {
                Log.e(FLImageLoader.TAG, "Error in ImageLoadTask onPostExecute", e2);
                FLImageLoader.this.safeSetErrorImage(this.imageView);
                FLImageLoader.this.safeCallOnError(this.listener, this.imageUrl, "Unexpected error: " + e2.getMessage());
            }
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Void... voidArr) throws Throwable {
            try {
                if (isCancelled()) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.imageUrl).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
                if (isCancelled()) {
                    httpURLConnection.disconnect();
                    return null;
                }
                httpURLConnection.connect();
                if (isCancelled()) {
                    httpURLConnection.disconnect();
                    return null;
                }
                if (httpURLConnection.getResponseCode() != 200) {
                    httpURLConnection.disconnect();
                    Log.e(FLImageLoader.TAG, "HTTP error: " + httpURLConnection.getResponseCode() + " for URL: " + this.imageUrl);
                    return null;
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                if (isCancelled()) {
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return null;
                }
                if (!this.isGif) {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    httpURLConnection.disconnect();
                    if (isCancelled()) {
                        if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                            bitmapDecodeStream.recycle();
                        }
                        return null;
                    }
                    if (bitmapDecodeStream != null) {
                        if (this.isWebp) {
                            bitmapDecodeStream = FLImageLoader.this.checkAndFixBitmapConfig(bitmapDecodeStream, this.imageUrl);
                        }
                        bitmapDecodeStream = safeCompressBitmap(bitmapDecodeStream);
                        if (isCancelled()) {
                            if (!bitmapDecodeStream.isRecycled()) {
                                bitmapDecodeStream.recycle();
                            }
                            return null;
                        }
                        if (FLImageLoader.this.enableDiskCache && FLImageLoader.this.cacheDir != null) {
                            safeSaveBitmapToDiskCache(this.imageUrl, bitmapDecodeStream);
                        }
                    }
                    return bitmapDecodeStream;
                }
                byte[] bArr = new byte[4096];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        inputStream.close();
                        httpURLConnection.disconnect();
                        if (isCancelled()) {
                            return null;
                        }
                        if (FLImageLoader.this.enableDiskCache && FLImageLoader.this.cacheDir != null) {
                            FLImageLoader.this.saveToDiskCache(this.imageUrl, byteArray);
                        }
                        return new GifLoadResult(byteArray, FLImageLoader.this.decodeGifFirstFrame(byteArray));
                    }
                    if (isCancelled()) {
                        inputStream.close();
                        byteArrayOutputStream.close();
                        httpURLConnection.disconnect();
                        return null;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
            } catch (Exception e) {
                Log.e(FLImageLoader.TAG, "Error loading image: " + this.imageUrl, e);
            } catch (OutOfMemoryError e2) {
                Log.e(FLImageLoader.TAG, "Out of memory loading image: " + this.imageUrl, e2);
                System.gc();
            }
        }
    }

    public static final class LastModifiedComparator implements Comparator<CacheFileInfo> {
        private LastModifiedComparator() {
        }

        private int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(CacheFileInfo cacheFileInfo, CacheFileInfo cacheFileInfo2) {
            return compareLong(cacheFileInfo.getLastModified(), cacheFileInfo2.getLastModified());
        }
    }

    public interface OnBitmapLoadListener {
        void onBitmapLoadFailed(String str, String str2);

        void onBitmapLoaded(String str, Bitmap bitmap, boolean z);
    }

    public interface OnBitmapLoadSuccessListener {
        void onSuccess(String str, Bitmap bitmap, boolean z);
    }

    public interface OnGifLoadListener {
        void onError(String str, String str2);

        void onSuccess(String str, File file, Bitmap bitmap, boolean z);
    }

    public interface OnImageLoadListener {
        void onError(String str, String str2);

        void onSuccess(String str, Bitmap bitmap, boolean z);
    }

    public interface OnImageLoadSuccessListener {
        void onSuccess(String str, Bitmap bitmap, boolean z);
    }

    private FLImageLoader(Context context) {
        initMemoryCache();
        initDiskCache(context);
        calculateCacheSizeLimits();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addBitmapToMemoryCache(String str, Bitmap bitmap) {
        try {
            if (this.bitmapCache == null || str == null || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.bitmapCache.put(str, bitmap);
        } catch (Exception e) {
            Log.e(TAG, "Error adding bitmap to memory cache", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGifFirstFrameToMemoryCache(String str, Bitmap bitmap) {
        try {
            if (this.gifFirstFrameCache == null || str == null || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            this.gifFirstFrameCache.put(str, bitmap);
        } catch (Exception e) {
            Log.e(TAG, "Error adding GIF first frame to memory cache", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGifToMemoryCache(String str, File file) {
        try {
            if (this.gifFileCache == null || str == null || file == null || !file.exists()) {
                return;
            }
            this.gifFileCache.put(str, file);
        } catch (Exception e) {
            Log.e(TAG, "Error adding GIF to memory cache", e);
        }
    }

    private void calculateCacheSizeLimits() {
        StringBuilder sb;
        try {
            long availableStorageSpace = getAvailableStorageSpace();
            long totalStorageSpace = getTotalStorageSpace();
            Log.d(TAG, "Storage info - Available: " + formatSize(availableStorageSpace) + ", Total: " + formatSize(totalStorageSpace));
            if (availableStorageSpace < DEFAULT_MAX_DISK_CACHE_SIZE) {
                long jMin = Math.min((long) (totalStorageSpace * CACHE_SIZE_RATIO), (availableStorageSpace * 5) / 10);
                this.maxDiskCacheSize = jMin;
                this.cleanupThreshold = (long) (jMin * 0.9f);
                sb = new StringBuilder();
                sb.append("Low storage mode - Max cache: ");
                sb.append(formatSize(this.maxDiskCacheSize));
                sb.append(", Cleanup threshold: ");
                sb.append(formatSize(this.cleanupThreshold));
            } else {
                this.maxDiskCacheSize = DEFAULT_MAX_DISK_CACHE_SIZE;
                this.cleanupThreshold = DEFAULT_CLEANUP_THRESHOLD;
                sb = new StringBuilder();
                sb.append("Normal mode - Max cache: ");
                sb.append(formatSize(this.maxDiskCacheSize));
                sb.append(", Cleanup threshold: ");
                sb.append(formatSize(this.cleanupThreshold));
            }
            Log.d(TAG, sb.toString());
        } catch (Exception e) {
            Log.e(TAG, "Error calculating cache size limits, using defaults", e);
            this.maxDiskCacheSize = DEFAULT_MAX_DISK_CACHE_SIZE;
            this.cleanupThreshold = DEFAULT_CLEANUP_THRESHOLD;
        }
    }

    private long calculateCurrentCacheSize() {
        File[] fileArrListFiles;
        File file = this.cacheDir;
        long length = 0;
        if (file != null && file.exists() && (fileArrListFiles = this.cacheDir.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    length += file2.length();
                }
            }
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void checkAndCleanupDiskCacheIfNeeded() {
        File file = this.cacheDir;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            long jCalculateCurrentCacheSize = calculateCurrentCacheSize();
            long currentCleanupThreshold = getCurrentCleanupThreshold();
            Log.d(TAG, "Cache check - Current size: " + formatSize(jCalculateCurrentCacheSize) + ", Threshold: " + formatSize(currentCleanupThreshold));
            if (jCalculateCurrentCacheSize > currentCleanupThreshold) {
                Log.i(TAG, "Cache size exceeds threshold, cleaning up...");
                cleanupDiskCache(currentCleanupThreshold);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error checking disk cache size", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap checkAndFixBitmapConfig(Bitmap bitmap, String str) {
        Bitmap bitmapFixWebpTransparency;
        if (bitmap != null && !bitmap.isRecycled() && str != null) {
            try {
                if (!str.toLowerCase().endsWith(".webp") || !this.forceArgb8888 || bitmap.getConfig() == Bitmap.Config.ARGB_8888 || (bitmapFixWebpTransparency = fixWebpTransparency(bitmap)) == null || bitmapFixWebpTransparency == bitmap) {
                    return bitmap;
                }
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return bitmapFixWebpTransparency;
            } catch (Exception e) {
                Log.e(TAG, "Error checking and fixing bitmap config", e);
            }
        }
        return bitmap;
    }

    private synchronized void cleanupDiskCache(long j) {
        File file = this.cacheDir;
        if (file == null || !file.exists()) {
            return;
        }
        try {
            File[] fileArrListFiles = this.cacheDir.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                ArrayList<CacheFileInfo> arrayList = new ArrayList();
                long length = 0;
                for (File file2 : fileArrListFiles) {
                    if (file2.isFile()) {
                        arrayList.add(new CacheFileInfo(file2.getName(), file2.lastModified(), file2.length()));
                        length += file2.length();
                    }
                }
                Collections.sort(arrayList, new LastModifiedComparator());
                for (CacheFileInfo cacheFileInfo : arrayList) {
                    if (length <= j) {
                        break;
                    }
                    File file3 = new File(this.cacheDir, cacheFileInfo.getFileName());
                    if (file3.exists()) {
                        long length2 = file3.length();
                        if (file3.delete()) {
                            length -= length2;
                            Log.d(TAG, "Deleted cache file: " + cacheFileInfo.getFileName() + ", Size: " + formatSize(length2));
                        }
                    }
                }
                Log.i(TAG, "Cache cleanup completed. New size: " + formatSize(length));
            }
        } catch (Exception e) {
            Log.e(TAG, "Error cleaning up disk cache", e);
        }
    }

    private Bitmap decodeGifFirstFrame(File file) {
        String str;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        } catch (Exception e) {
            e = e;
            str = "Error decoding GIF first frame";
            Log.e(TAG, str, e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Out of memory decoding GIF first frame", e2);
            try {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                return BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
            } catch (Exception e3) {
                e = e3;
                str = "Error decoding GIF first frame with sample size 2";
                Log.e(TAG, str, e);
                return null;
            }
        }
    }

    private Bitmap fixWebpTransparency(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        try {
            Bitmap.Config config = bitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config == config2) {
                return bitmap;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), config2);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            Log.e(TAG, "Error fixing WebP transparency", e);
            return bitmap;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Out of memory fixing WebP transparency", e2);
            System.gc();
            return bitmap;
        }
    }

    private String formatSize(long j) {
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            return String.format("%.1fKB", Double.valueOf(j / 1024.0d));
        }
        double d = j;
        return j < FileUtils.ONE_GB ? String.format("%.1fMB", Double.valueOf(d / 1048576.0d)) : String.format("%.1fGB", Double.valueOf(d / 1.073741824E9d));
    }

    public static long getAvailableStorageSpace() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            Log.e(TAG, "Error getting available storage space", e);
            return 0L;
        }
    }

    private Bitmap getBitmapFromDiskCache(String str) {
        if (this.cacheDir == null) {
            return null;
        }
        try {
            String cacheFilename = getCacheFilename(str);
            if (cacheFilename == null) {
                return null;
            }
            File file = new File(this.cacheDir, cacheFilename);
            if (file.exists() && file.length() > 0) {
                if (System.currentTimeMillis() - file.lastModified() <= 604800000) {
                    return BitmapFactory.decodeFile(file.getAbsolutePath());
                }
                safeDeleteFile(file);
                return null;
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Error getting bitmap from disk cache", e);
        }
    }

    private Bitmap getBitmapFromMemoryCache(String str) {
        try {
            LruCache<String, Bitmap> lruCache = this.bitmapCache;
            if (lruCache == null || str == null) {
                return null;
            }
            return lruCache.get(str);
        } catch (Exception e) {
            Log.e(TAG, "Error getting bitmap from memory cache", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCacheFilename(String str) {
        String str2 = ".bmp";
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            String lowerCase = str.toLowerCase();
            String str3 = FileTypes.F;
            if (lowerCase.endsWith(".png")) {
                str2 = ".png";
            } else if (lowerCase.endsWith(".webp")) {
                str2 = ".webp";
            } else {
                if (!lowerCase.endsWith(".gif")) {
                    if (lowerCase.endsWith(".bmp")) {
                    }
                    return sb.toString() + str3;
                }
                str2 = ".gif";
            }
            str3 = str2;
            return sb.toString() + str3;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "MD5 algorithm not available", e);
            try {
                return String.valueOf(Math.abs(str.hashCode())) + ".cache";
            } catch (Exception e2) {
                Log.e(TAG, "Error generating fallback filename", e2);
                return "unknown.cache";
            }
        } catch (Exception e3) {
            Log.e(TAG, "Error generating cache filename", e3);
            return "error.cache";
        }
    }

    private long getCurrentCleanupThreshold() {
        return getAvailableStorageSpace() < DEFAULT_MAX_DISK_CACHE_SIZE ? this.cleanupThreshold : DEFAULT_CLEANUP_THRESHOLD;
    }

    private Bitmap getGifFirstFrameFromMemoryCache(String str) {
        try {
            LruCache<String, Bitmap> lruCache = this.gifFirstFrameCache;
            if (lruCache == null || str == null) {
                return null;
            }
            return lruCache.get(str);
        } catch (Exception e) {
            Log.e(TAG, "Error getting GIF first frame from memory cache", e);
            return null;
        }
    }

    private File getGifFromDiskCache(String str) {
        if (this.cacheDir == null) {
            return null;
        }
        try {
            String cacheFilename = getCacheFilename(str);
            if (cacheFilename == null) {
                return null;
            }
            File file = new File(this.cacheDir, cacheFilename);
            if (file.exists() && file.length() > 0) {
                if (System.currentTimeMillis() - file.lastModified() <= 604800000) {
                    return file;
                }
                safeDeleteFile(file);
                return null;
            }
        } catch (Exception e) {
            Log.e(TAG, "Error getting GIF from disk cache", e);
        }
        return null;
    }

    private File getGifFromMemoryCache(String str) {
        try {
            LruCache<String, File> lruCache = this.gifFileCache;
            if (lruCache == null || str == null) {
                return null;
            }
            return lruCache.get(str);
        } catch (Exception e) {
            Log.e(TAG, "Error getting GIF from memory cache", e);
            return null;
        }
    }

    public static FLImageLoader getInstance(Context context) {
        if (instance == null) {
            synchronized (FLImageLoader.class) {
                if (instance == null) {
                    if (context == null) {
                        context = DeviceUtil.getContext();
                    }
                    if (context != null) {
                        context = context.getApplicationContext();
                    }
                    instance = new FLImageLoader(context);
                }
            }
        }
        return instance;
    }

    public static long getTotalStorageSpace() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Exception e) {
            Log.e(TAG, "Error getting total storage space", e);
            return 0L;
        }
    }

    private void initDiskCache(Context context) {
        if (context == null) {
            return;
        }
        try {
            File file = new File(context.getCacheDir(), "image_cache");
            this.cacheDir = file;
            if (file.exists()) {
                return;
            }
            this.cacheDir.mkdirs();
        } catch (Exception e) {
            Log.e(TAG, "Error initializing disk cache", e);
            this.cacheDir = null;
        }
    }

    private void initMemoryCache() {
        try {
            int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
            int iMax = Math.max(iMaxMemory / 8, 1024);
            int iMax2 = Math.max(iMaxMemory / 16, 512);
            int iMax3 = Math.max(iMaxMemory / 32, 256);
            this.bitmapCache = new LruCache<String, Bitmap>(iMax) { // from class: com.fl.saas.adx.util.FLImageLoader.1
                @Override // android.util.LruCache
                public int sizeOf(String str, Bitmap bitmap) {
                    if (bitmap == null) {
                        return 0;
                    }
                    try {
                        if (bitmap.isRecycled()) {
                            return 0;
                        }
                        return bitmap.getByteCount() / 1024;
                    } catch (Exception e) {
                        Log.e(FLImageLoader.TAG, "Error calculating bitmap size", e);
                        return 0;
                    }
                }
            };
            this.gifFileCache = new LruCache<String, File>(iMax2) { // from class: com.fl.saas.adx.util.FLImageLoader.2
                @Override // android.util.LruCache
                public int sizeOf(String str, File file) {
                    if (file == null) {
                        return 0;
                    }
                    try {
                        if (file.exists()) {
                            return (int) (file.length() / 1024);
                        }
                        return 0;
                    } catch (Exception e) {
                        Log.e(FLImageLoader.TAG, "Error calculating file size", e);
                        return 0;
                    }
                }
            };
            this.gifFirstFrameCache = new LruCache<String, Bitmap>(iMax3) { // from class: com.fl.saas.adx.util.FLImageLoader.3
                @Override // android.util.LruCache
                public int sizeOf(String str, Bitmap bitmap) {
                    if (bitmap == null) {
                        return 0;
                    }
                    try {
                        if (bitmap.isRecycled()) {
                            return 0;
                        }
                        return bitmap.getByteCount() / 1024;
                    } catch (Exception e) {
                        Log.e(FLImageLoader.TAG, "Error calculating gif first frame size", e);
                        return 0;
                    }
                }
            };
        } catch (Exception e) {
            Log.e(TAG, "Error initializing memory cache", e);
            this.bitmapCache = new LruCache<>(1024);
            this.gifFileCache = new LruCache<>(512);
            this.gifFirstFrameCache = new LruCache<>(256);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$safeCallBitmapLoadFailed$7(OnBitmapLoadListener onBitmapLoadListener, String str, String str2) {
        try {
            onBitmapLoadListener.onBitmapLoadFailed(str, str2);
        } catch (Exception e) {
            Log.e(TAG, "Error in onBitmapLoadFailed callback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$safeCallBitmapLoaded$6(OnBitmapLoadListener onBitmapLoadListener, String str, Bitmap bitmap, boolean z) {
        try {
            onBitmapLoadListener.onBitmapLoaded(str, bitmap, z);
        } catch (Exception e) {
            Log.e(TAG, "Error in onBitmapLoaded callback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$safeCallOnError$5(OnImageLoadListener onImageLoadListener, String str, String str2) {
        try {
            onImageLoadListener.onError(str, str2);
        } catch (Exception e) {
            Log.e(TAG, "Error in onError callback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$safeCallOnSuccess$4(OnImageLoadListener onImageLoadListener, String str, Bitmap bitmap, boolean z) {
        try {
            onImageLoadListener.onSuccess(str, bitmap, z);
        } catch (Exception e) {
            Log.e(TAG, "Error in onSuccess callback", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDisplayBitmap$0(ImageView imageView, String str, Bitmap bitmap) {
        try {
            Object tag = imageView.getTag();
            if (tag == null || !tag.equals(str) || bitmap == null || bitmap.isRecycled()) {
                return;
            }
            imageView.setImageBitmap(bitmap);
        } catch (Exception e) {
            Log.e(TAG, "Error displaying bitmap", e);
            safeSetErrorImage(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
    
        if (r4 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void lambda$safeDisplayGif$1(ImageView imageView, String str, File file) {
        Bitmap bitmapDecodeGifFirstFrame;
        try {
            Object tag = imageView.getTag();
            if (tag != null && tag.equals(str) && file != null && file.exists()) {
                if (Build.VERSION.SDK_INT < 28) {
                    bitmapDecodeGifFirstFrame = decodeGifFirstFrame(file);
                    if (bitmapDecodeGifFirstFrame != null) {
                        imageView.setImageBitmap(bitmapDecodeGifFirstFrame);
                        imageView.setBackgroundColor(0);
                        return;
                    }
                    safeSetErrorImage(imageView);
                    return;
                }
                try {
                    Drawable drawableCreateFromPath = Drawable.createFromPath(file.getAbsolutePath());
                    if (drawableCreateFromPath instanceof AnimatedImageDrawable) {
                        imageView.setImageDrawable(drawableCreateFromPath);
                        ((AnimatedImageDrawable) drawableCreateFromPath).start();
                    } else {
                        imageView.setImageDrawable(drawableCreateFromPath);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Error loading GIF on Android P+", e);
                    bitmapDecodeGifFirstFrame = decodeGifFirstFrame(file);
                }
            }
        } catch (Exception e2) {
            Log.e(TAG, "Error displaying GIF", e2);
            safeSetErrorImage(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeSetDefaultImage$2(ImageView imageView) {
        try {
            imageView.setImageResource(this.defaultImageResId);
        } catch (Exception e) {
            Log.e(TAG, "Error setting default image", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeSetErrorImage$3(ImageView imageView) {
        try {
            imageView.setImageResource(this.errorImageResId);
        } catch (Exception e) {
            Log.e(TAG, "Error setting error image", e);
        }
    }

    private void loadBitmapFromNetwork(String str, boolean z, OnBitmapLoadListener onBitmapLoadListener) {
        try {
            if (!this.bitmapLoadTaskMap.containsKey(str)) {
                BitmapLoadTask bitmapLoadTask = new BitmapLoadTask(str, z, onBitmapLoadListener);
                this.bitmapLoadTaskMap.put(str, bitmapLoadTask);
                bitmapLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                BitmapLoadTask bitmapLoadTask2 = this.bitmapLoadTaskMap.get(str);
                if (bitmapLoadTask2 == null || onBitmapLoadListener == null) {
                    return;
                }
                bitmapLoadTask2.addListener(onBitmapLoadListener);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error starting bitmap network load", e);
            safeCallBitmapLoadFailed(onBitmapLoadListener, str, "Error starting load: " + e.getMessage());
        }
    }

    private void loadBitmapImageInternal(ImageView imageView, String str, OnImageLoadListener onImageLoadListener) {
        Bitmap bitmapFromDiskCache;
        Bitmap bitmapFromMemoryCache;
        try {
            if (this.enableMemoryCache && (bitmapFromMemoryCache = getBitmapFromMemoryCache(str)) != null && !bitmapFromMemoryCache.isRecycled()) {
                safeDisplayBitmap(imageView, bitmapFromMemoryCache, str);
                safeCallOnSuccess(onImageLoadListener, str, bitmapFromMemoryCache, true);
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.6
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
            } else {
                if (!this.enableDiskCache || (bitmapFromDiskCache = getBitmapFromDiskCache(str)) == null || bitmapFromDiskCache.isRecycled()) {
                    loadFromNetwork(imageView, str, false, onImageLoadListener);
                    return;
                }
                safeDisplayBitmap(imageView, bitmapFromDiskCache, str);
                addBitmapToMemoryCache(str, bitmapFromDiskCache);
                safeCallOnSuccess(onImageLoadListener, str, bitmapFromDiskCache, true);
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.7
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in loadBitmapImageInternal", e);
            safeSetErrorImage(imageView);
            safeCallOnError(onImageLoadListener, str, "Error loading bitmap: " + e.getMessage());
        }
    }

    private void loadBitmapOnlyInternal(String str, OnBitmapLoadListener onBitmapLoadListener) {
        Bitmap bitmapFromDiskCache;
        Bitmap bitmapFromMemoryCache;
        try {
            if (this.enableMemoryCache && (bitmapFromMemoryCache = getBitmapFromMemoryCache(str)) != null && !bitmapFromMemoryCache.isRecycled()) {
                safeCallBitmapLoaded(onBitmapLoadListener, str, bitmapFromMemoryCache, true);
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.10
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
            } else {
                if (!this.enableDiskCache || (bitmapFromDiskCache = getBitmapFromDiskCache(str)) == null || bitmapFromDiskCache.isRecycled()) {
                    loadBitmapFromNetwork(str, false, onBitmapLoadListener);
                    return;
                }
                addBitmapToMemoryCache(str, bitmapFromDiskCache);
                safeCallBitmapLoaded(onBitmapLoadListener, str, bitmapFromDiskCache, true);
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.11
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in loadBitmapOnlyInternal", e);
            safeCallBitmapLoadFailed(onBitmapLoadListener, str, "Error loading bitmap only: " + e.getMessage());
        }
    }

    private void loadFromNetwork(ImageView imageView, String str, boolean z, OnImageLoadListener onImageLoadListener) {
        try {
            if (!this.taskMap.containsKey(str)) {
                ImageLoadTask imageLoadTask = new ImageLoadTask(imageView, str, z, onImageLoadListener);
                this.taskMap.put(str, imageLoadTask);
                imageLoadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                ImageLoadTask imageLoadTask2 = this.taskMap.get(str);
                if (imageLoadTask2 == null || onImageLoadListener == null) {
                    return;
                }
                imageLoadTask2.addListener(onImageLoadListener);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error starting network load", e);
            safeSetErrorImage(imageView);
            safeCallOnError(onImageLoadListener, str, "Error starting load: " + e.getMessage());
        }
    }

    private void loadGifBitmapInternal(String str, OnBitmapLoadListener onBitmapLoadListener) {
        File gifFromDiskCache;
        Bitmap gifFirstFrameFromMemoryCache;
        try {
            if (this.enableMemoryCache && (gifFirstFrameFromMemoryCache = getGifFirstFrameFromMemoryCache(str)) != null && !gifFirstFrameFromMemoryCache.isRecycled()) {
                safeCallBitmapLoaded(onBitmapLoadListener, str, gifFirstFrameFromMemoryCache, true);
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.12
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
                return;
            }
            if (this.enableDiskCache && (gifFromDiskCache = getGifFromDiskCache(str)) != null && gifFromDiskCache.exists()) {
                Bitmap bitmapDecodeGifFirstFrame = decodeGifFirstFrame(gifFromDiskCache);
                if (bitmapDecodeGifFirstFrame != null) {
                    addGifFirstFrameToMemoryCache(str, bitmapDecodeGifFirstFrame);
                    safeCallBitmapLoaded(onBitmapLoadListener, str, bitmapDecodeGifFirstFrame, true);
                    return;
                }
                C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.13
                    @Override // com.fl.saas.S
                    public void onError(Exception exc) {
                    }

                    @Override // com.fl.saas.S
                    public void onSuccess(byte[] bArr) {
                    }
                });
            }
            loadBitmapFromNetwork(str, true, onBitmapLoadListener);
        } catch (Exception e) {
            Log.e(TAG, "Error in loadGifBitmapInternal", e);
            safeCallBitmapLoadFailed(onBitmapLoadListener, str, "Error loading GIF bitmap: " + e.getMessage());
        }
    }

    private void loadGifImageInternal(ImageView imageView, String str, OnImageLoadListener onImageLoadListener) {
        File gifFromDiskCache;
        Bitmap bitmapDecodeGifFirstFrame;
        try {
            if (this.enableMemoryCache) {
                Bitmap gifFirstFrameFromMemoryCache = getGifFirstFrameFromMemoryCache(str);
                File gifFromMemoryCache = getGifFromMemoryCache(str);
                if (gifFirstFrameFromMemoryCache != null && gifFromMemoryCache != null && gifFromMemoryCache.exists()) {
                    safeDisplayGif(imageView, gifFromMemoryCache, str);
                    safeCallOnSuccess(onImageLoadListener, str, gifFirstFrameFromMemoryCache, true);
                    C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.8
                        @Override // com.fl.saas.S
                        public void onError(Exception exc) {
                        }

                        @Override // com.fl.saas.S
                        public void onSuccess(byte[] bArr) {
                        }
                    });
                    return;
                }
            }
            if (!this.enableDiskCache || (gifFromDiskCache = getGifFromDiskCache(str)) == null || !gifFromDiskCache.exists() || (bitmapDecodeGifFirstFrame = decodeGifFirstFrame(gifFromDiskCache)) == null) {
                loadFromNetwork(imageView, str, true, onImageLoadListener);
                return;
            }
            safeDisplayGif(imageView, gifFromDiskCache, str);
            addGifToMemoryCache(str, gifFromDiskCache);
            addGifFirstFrameToMemoryCache(str, bitmapDecodeGifFirstFrame);
            safeCallOnSuccess(onImageLoadListener, str, bitmapDecodeGifFirstFrame, true);
            C1401c.c().a(str, new S() { // from class: com.fl.saas.adx.util.FLImageLoader.9
                @Override // com.fl.saas.S
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.S
                public void onSuccess(byte[] bArr) {
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error in loadGifImageInternal", e);
            safeSetErrorImage(imageView);
            safeCallOnError(onImageLoadListener, str, "Error loading GIF: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCallBitmapLoadFailed(final OnBitmapLoadListener onBitmapLoadListener, final String str, final String str2) {
        if (onBitmapLoadListener == null) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.rc3
                @Override // java.lang.Runnable
                public final void run() {
                    FLImageLoader.lambda$safeCallBitmapLoadFailed$7(onBitmapLoadListener, str, str2);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting onBitmapLoadFailed", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCallBitmapLoaded(final OnBitmapLoadListener onBitmapLoadListener, final String str, final Bitmap bitmap, final boolean z) {
        if (onBitmapLoadListener == null) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.tc3
                @Override // java.lang.Runnable
                public final void run() {
                    FLImageLoader.lambda$safeCallBitmapLoaded$6(onBitmapLoadListener, str, bitmap, z);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting onBitmapLoaded", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCallOnError(final OnImageLoadListener onImageLoadListener, final String str, final String str2) {
        if (onImageLoadListener == null) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.sc3
                @Override // java.lang.Runnable
                public final void run() {
                    FLImageLoader.lambda$safeCallOnError$5(onImageLoadListener, str, str2);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting onError", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeCallOnSuccess(final OnImageLoadListener onImageLoadListener, final String str, final Bitmap bitmap, final boolean z) {
        if (onImageLoadListener == null) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.wc3
                @Override // java.lang.Runnable
                public final void run() {
                    FLImageLoader.lambda$safeCallOnSuccess$4(onImageLoadListener, str, bitmap, z);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting onSuccess", e);
        }
    }

    private void safeDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            file.delete();
        } catch (Exception e) {
            Log.e(TAG, "Error deleting file", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeDisplayBitmap(final ImageView imageView, final Bitmap bitmap, final String str) {
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.pc3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f18817a.lambda$safeDisplayBitmap$0(imageView, str, bitmap);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting display bitmap", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeDisplayGif(final ImageView imageView, final File file, final String str) {
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.vc3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20205a.lambda$safeDisplayGif$1(imageView, str, file);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting display GIF", e);
        }
    }

    private void safeSetDefaultImage(final ImageView imageView) {
        if (imageView == null || this.defaultImageResId == 0) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.uc3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20033a.lambda$safeSetDefaultImage$2(imageView);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting set default image", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void safeSetErrorImage(final ImageView imageView) {
        if (imageView == null || this.errorImageResId == 0) {
            return;
        }
        try {
            this.mainHandler.post(new Runnable() { // from class: com.zj.adlib.qc3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19058a.lambda$safeSetErrorImage$3(imageView);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error posting set error image", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:32:0x0074 A[Catch: Exception -> 0x0078, TRY_ENTER, TRY_LEAVE, TryCatch #2 {Exception -> 0x0078, blocks: (B:21:0x0061, B:32:0x0074), top: B:48:0x0017 }] */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    public void saveToDiskCache(String str, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        if (!this.enableDiskCache || bArr == null || bArr.length == 0 || this.cacheDir == null) {
            return;
        }
        checkAndCleanupDiskCacheIfNeeded();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    String cacheFilename = getCacheFilename(str);
                    if (cacheFilename == null) {
                        return;
                    }
                    File file = new File(this.cacheDir, cacheFilename);
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write(bArr);
                        fileOutputStream.flush();
                        Log.d(TAG, "Saved to disk cache: " + cacheFilename + ", Size: " + formatSize(bArr.length));
                        fileOutputStream.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream2 = fileOutputStream;
                        Log.e(TAG, "Error saving to disk cache", e);
                        if (fileOutputStream2 == null) {
                            return;
                        } else {
                            fileOutputStream2.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e2) {
                                Log.e(TAG, "Error closing stream", e2);
                            }
                        }
                        throw th;
                    }
                    return;
                } catch (Exception e3) {
                    e = e3;
                }
                if (fileOutputStream2 == null) {
                    fileOutputStream2.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
            }
            Log.e(TAG, "Error saving to disk cache", e);
        } catch (Exception e4) {
            Log.e(TAG, "Error closing stream", e4);
        }
    }

    public void cancelAllLoads() {
        try {
            for (ImageLoadTask imageLoadTask : this.taskMap.values()) {
                if (imageLoadTask != null && !imageLoadTask.isCancelled()) {
                    imageLoadTask.cancel(true);
                }
            }
            this.taskMap.clear();
            for (BitmapLoadTask bitmapLoadTask : this.bitmapLoadTaskMap.values()) {
                if (bitmapLoadTask != null && !bitmapLoadTask.isCancelled()) {
                    bitmapLoadTask.cancel(true);
                }
            }
            this.bitmapLoadTaskMap.clear();
        } catch (Exception e) {
            Log.e(TAG, "Error canceling all loads", e);
        }
    }

    public void cancelLoad(String str) {
        if (str == null) {
            return;
        }
        try {
            if (this.taskMap.containsKey(str)) {
                ImageLoadTask imageLoadTask = this.taskMap.get(str);
                if (imageLoadTask != null && !imageLoadTask.isCancelled()) {
                    imageLoadTask.cancel(true);
                }
                this.taskMap.remove(str);
            }
            if (this.bitmapLoadTaskMap.containsKey(str)) {
                BitmapLoadTask bitmapLoadTask = this.bitmapLoadTaskMap.get(str);
                if (bitmapLoadTask != null && !bitmapLoadTask.isCancelled()) {
                    bitmapLoadTask.cancel(true);
                }
                this.bitmapLoadTaskMap.remove(str);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error canceling load", e);
        }
    }

    public void cleanupDiskCacheToSize(long j) {
        cleanupDiskCache(j);
    }

    public void clearAllCache() {
        clearMemoryCache();
        clearDiskCache();
    }

    public void clearDiskCache() {
        File[] fileArrListFiles;
        try {
            File file = this.cacheDir;
            if (file == null || !file.exists() || (fileArrListFiles = this.cacheDir.listFiles()) == null) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                safeDeleteFile(file2);
            }
        } catch (Exception e) {
            Log.e(TAG, "Error clearing disk cache", e);
        }
    }

    public void clearMemoryCache() {
        try {
            LruCache<String, Bitmap> lruCache = this.bitmapCache;
            if (lruCache != null) {
                lruCache.evictAll();
            }
            LruCache<String, File> lruCache2 = this.gifFileCache;
            if (lruCache2 != null) {
                lruCache2.evictAll();
            }
            LruCache<String, Bitmap> lruCache3 = this.gifFirstFrameCache;
            if (lruCache3 != null) {
                lruCache3.evictAll();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error clearing memory cache", e);
        }
    }

    public void forceCleanupDiskCache() {
        cleanupDiskCache(getCurrentCleanupThreshold());
    }

    public Bitmap getCachedBitmap(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (!str.toLowerCase().endsWith(".gif")) {
                Bitmap bitmapFromMemoryCache = getBitmapFromMemoryCache(str);
                return bitmapFromMemoryCache != null ? bitmapFromMemoryCache : getBitmapFromDiskCache(str);
            }
            Bitmap gifFirstFrameFromMemoryCache = getGifFirstFrameFromMemoryCache(str);
            if (gifFirstFrameFromMemoryCache != null) {
                return gifFirstFrameFromMemoryCache;
            }
            File gifFromDiskCache = getGifFromDiskCache(str);
            if (gifFromDiskCache != null) {
                return decodeGifFirstFrame(gifFromDiskCache);
            }
            return null;
        } catch (Exception e) {
            Log.e(TAG, "Error getting cached bitmap", e);
        }
    }

    public File getCachedGifFile(String str) {
        if (str == null) {
            return null;
        }
        try {
            File gifFromMemoryCache = getGifFromMemoryCache(str);
            return gifFromMemoryCache != null ? gifFromMemoryCache : getGifFromDiskCache(str);
        } catch (Exception e) {
            Log.e(TAG, "Error getting cached GIF file", e);
            return null;
        }
    }

    public long getCleanupThreshold() {
        return getCurrentCleanupThreshold();
    }

    public long getCurrentDiskCacheSize() {
        return calculateCurrentCacheSize();
    }

    public long getMaxDiskCacheSize() {
        return this.maxDiskCacheSize;
    }

    public void loadBitmap(String str, OnBitmapLoadListener onBitmapLoadListener) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    String strTrim = str.trim();
                    if (strTrim.toLowerCase().endsWith(".gif")) {
                        loadGifBitmapInternal(strTrim, onBitmapLoadListener);
                        return;
                    } else {
                        loadBitmapOnlyInternal(strTrim, onBitmapLoadListener);
                        return;
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "Error in loadBitmap", e);
                safeCallBitmapLoadFailed(onBitmapLoadListener, str, "Unexpected error: " + e.getMessage());
                return;
            }
        }
        safeCallBitmapLoadFailed(onBitmapLoadListener, str, "Invalid URL");
    }

    public void loadImage(ImageView imageView, String str) {
        loadImage(imageView, str, (OnImageLoadListener) null);
    }

    public void removeFromCache(String str) {
        String cacheFilename;
        if (str == null) {
            return;
        }
        try {
            boolean zEndsWith = str.toLowerCase().endsWith(".gif");
            LruCache<String, Bitmap> lruCache = this.bitmapCache;
            if (lruCache != null) {
                lruCache.remove(str);
            }
            LruCache<String, File> lruCache2 = this.gifFileCache;
            if (lruCache2 != null && zEndsWith) {
                lruCache2.remove(str);
            }
            LruCache<String, Bitmap> lruCache3 = this.gifFirstFrameCache;
            if (lruCache3 != null && zEndsWith) {
                lruCache3.remove(str);
            }
            if (this.cacheDir == null || (cacheFilename = getCacheFilename(str)) == null) {
                return;
            }
            safeDeleteFile(new File(this.cacheDir, cacheFilename));
        } catch (Exception e) {
            Log.e(TAG, "Error removing from cache", e);
        }
    }

    public FLImageLoader setDefaultImage(int i) {
        this.defaultImageResId = i;
        return this;
    }

    public FLImageLoader setEnableDiskCache(boolean z) {
        this.enableDiskCache = z;
        return this;
    }

    public FLImageLoader setEnableMemoryCache(boolean z) {
        return this;
    }

    public FLImageLoader setErrorImage(int i) {
        this.errorImageResId = i;
        return this;
    }

    public FLImageLoader setForceArgb8888(boolean z) {
        this.forceArgb8888 = z;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap decodeGifFirstFrame(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (Exception e) {
            e = e;
            str = "Error decoding GIF first frame from byte array";
            Log.e(TAG, str, e);
            return null;
        } catch (OutOfMemoryError e2) {
            Log.e(TAG, "Out of memory decoding GIF first frame from byte array", e2);
            try {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = 2;
                return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options2);
            } catch (Exception e3) {
                e = e3;
                str = "Error decoding GIF first frame with sample size 2";
                Log.e(TAG, str, e);
                return null;
            }
        }
    }

    public void loadBitmap(String str, final OnBitmapLoadSuccessListener onBitmapLoadSuccessListener) {
        loadBitmap(str, new OnBitmapLoadListener() { // from class: com.fl.saas.adx.util.FLImageLoader.5
            @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
            public void onBitmapLoadFailed(String str2, String str3) {
                Log.e(FLImageLoader.TAG, "Load bitmap failed: " + str3);
            }

            @Override // com.fl.saas.adx.util.FLImageLoader.OnBitmapLoadListener
            public void onBitmapLoaded(String str2, Bitmap bitmap, boolean z) {
                try {
                    OnBitmapLoadSuccessListener onBitmapLoadSuccessListener2 = onBitmapLoadSuccessListener;
                    if (onBitmapLoadSuccessListener2 != null) {
                        onBitmapLoadSuccessListener2.onSuccess(str2, bitmap, z);
                    }
                } catch (Exception e) {
                    Log.e(FLImageLoader.TAG, "Error in bitmap success listener", e);
                }
            }
        });
    }

    public void loadImage(ImageView imageView, String str, OnImageLoadListener onImageLoadListener) {
        if (imageView != null && str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    String strTrim = str.trim();
                    safeSetDefaultImage(imageView);
                    try {
                        imageView.setTag(strTrim);
                    } catch (Exception e) {
                        Log.e(TAG, "Error setting tag", e);
                    }
                    if (strTrim.toLowerCase().endsWith(".gif")) {
                        loadGifImageInternal(imageView, strTrim, onImageLoadListener);
                        return;
                    } else {
                        loadBitmapImageInternal(imageView, strTrim, onImageLoadListener);
                        return;
                    }
                }
            } catch (Exception e2) {
                Log.e(TAG, "Error in loadImage", e2);
                safeSetErrorImage(imageView);
                safeCallOnError(onImageLoadListener, str, "Unexpected error: " + e2.getMessage());
                return;
            }
        }
        safeCallOnError(onImageLoadListener, str, "Invalid parameters");
    }

    public void loadImage(ImageView imageView, String str, final OnImageLoadSuccessListener onImageLoadSuccessListener) {
        loadImage(imageView, str, new OnImageLoadListener() { // from class: com.fl.saas.adx.util.FLImageLoader.4
            @Override // com.fl.saas.adx.util.FLImageLoader.OnImageLoadListener
            public void onError(String str2, String str3) {
                Log.e(FLImageLoader.TAG, "Load image error: " + str3);
            }

            @Override // com.fl.saas.adx.util.FLImageLoader.OnImageLoadListener
            public void onSuccess(String str2, Bitmap bitmap, boolean z) {
                try {
                    OnImageLoadSuccessListener onImageLoadSuccessListener2 = onImageLoadSuccessListener;
                    if (onImageLoadSuccessListener2 != null) {
                        onImageLoadSuccessListener2.onSuccess(str2, bitmap, z);
                    }
                } catch (Exception e) {
                    Log.e(FLImageLoader.TAG, "Error in success listener", e);
                }
            }
        });
    }
}
