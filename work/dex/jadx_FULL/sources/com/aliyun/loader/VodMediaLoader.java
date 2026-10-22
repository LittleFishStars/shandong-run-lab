package com.aliyun.loader;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.source.VidAuth;
import com.aliyun.player.source.VidSts;
import com.aliyun.utils.f;
import com.cicada.player.utils.NativeUsed;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VodMediaLoader {
    private static final String TAG;
    private static Handler mMainHandler;
    private static VodMediaLoader sInstance;
    private OnLoadStatusListener onLoadStatusListener = null;

    public interface OnLoadStatusListener {
        void onCanceled(String str, int i);

        void onCompleted(String str, int i);

        void onError(String str, int i, int i2, String str2);

        void onPrepared(MediaInfo mediaInfo);
    }

    static {
        f.b();
        TAG = MediaLoader.class.getSimpleName();
        sInstance = null;
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    private VodMediaLoader() {
    }

    public static VodMediaLoader getInstance() {
        if (sInstance == null) {
            synchronized (MediaLoader.class) {
                if (sInstance == null) {
                    sInstance = new VodMediaLoader();
                }
            }
        }
        return sInstance;
    }

    public static void loadClass() {
    }

    private static native void nCancel(String str, int i);

    private static native void nLoad(String str, int i, long j);

    @NativeUsed
    private static void nOnCanceled(final String str, final int i) {
        mMainHandler.post(new Runnable() { // from class: com.aliyun.loader.VodMediaLoader.4
            @Override // java.lang.Runnable
            public void run() {
                if (VodMediaLoader.getInstance().onLoadStatusListener != null) {
                    VodMediaLoader.getInstance().onLoadStatusListener.onCanceled(str, i);
                }
            }
        });
    }

    @NativeUsed
    private static void nOnCompleted(final String str, final int i) {
        mMainHandler.post(new Runnable() { // from class: com.aliyun.loader.VodMediaLoader.3
            @Override // java.lang.Runnable
            public void run() {
                if (VodMediaLoader.getInstance().onLoadStatusListener != null) {
                    VodMediaLoader.getInstance().onLoadStatusListener.onCompleted(str, i);
                }
            }
        });
    }

    @NativeUsed
    private static void nOnError(final String str, final int i, final int i2, final String str2) {
        mMainHandler.post(new Runnable() { // from class: com.aliyun.loader.VodMediaLoader.2
            @Override // java.lang.Runnable
            public void run() {
                if (VodMediaLoader.getInstance().onLoadStatusListener != null) {
                    VodMediaLoader.getInstance().onLoadStatusListener.onError(str, i, i2, str2);
                }
            }
        });
    }

    @NativeUsed
    private static void nOnPrepared(final Object obj) {
        mMainHandler.post(new Runnable() { // from class: com.aliyun.loader.VodMediaLoader.1
            @Override // java.lang.Runnable
            public void run() {
                if (VodMediaLoader.getInstance().onLoadStatusListener != null) {
                    VodMediaLoader.getInstance().onLoadStatusListener.onPrepared((MediaInfo) obj);
                }
            }
        });
    }

    private static native void nPause(boolean z, String str, int i);

    private static native void nPrepareAuth(Object obj);

    private static native void nPrepareSts(Object obj);

    private static native void nRemoveSource(String str);

    public void cancel(String str, int i) {
        nCancel(str, i);
    }

    public void load(String str, int i, long j) {
        if (TextUtils.isEmpty(str) || i < 0) {
            return;
        }
        nLoad(str, i, j);
    }

    public void pause(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 0) {
            return;
        }
        nPause(true, str, i);
    }

    public void prepareVidSource(VidAuth vidAuth) {
        nPrepareAuth(vidAuth);
    }

    public void prepareVidSource(VidSts vidSts) {
        nPrepareSts(vidSts);
    }

    public void removeVidSource(String str) {
        nRemoveSource(str);
    }

    public void resume(String str, int i) {
        if (TextUtils.isEmpty(str) || i < 0) {
            return;
        }
        nPause(false, str, i);
    }

    public void setOnLoadStatusListener(OnLoadStatusListener onLoadStatusListener) {
        this.onLoadStatusListener = onLoadStatusListener;
    }
}
