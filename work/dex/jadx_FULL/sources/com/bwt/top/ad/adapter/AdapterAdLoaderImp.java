package com.bwt.top.ad.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bwt.top.ad.AdListener;
import com.bwt.top.ad.BaseAd;
import com.bwt.top.ad.bean.AdInfo;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.util.ALog;
import com.bwt.top.util.ClickShakeListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AdapterAdLoaderImp<V extends AdInfo, Y extends AdListener<V>, T extends BaseAd<Y>> implements AdapterAdLoader<T> {
    private int mAcceleration;
    protected T mAd;
    private V mAdInfo;
    protected AdapterAdLoaderCallback mAdLoaderCallback;
    protected boolean mCallShow;
    protected boolean mIsClick;
    private boolean mIsClosed;
    protected boolean mIsReleased;
    protected PosInfoBean mPosInfo;
    protected String TAG = getClass().getSimpleName();
    private int mCallBackFlag = 0;
    protected String mCloseBitmap64 = "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAmVBMVEUAAAAiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiJv+HxmAAAAMnRSTlMA9fz58dJHPTEiHBbu6uTcWlROASsm6ODOxQqVi4FxQTo3DwbWy7Sdd2tkNRO+uGARqh+5EbcAAAFkSURBVEjH7dPbcoIwFIXhoCAeUPCMZ8FDtdJq8/4PV1nRyUzZYRsvesV/l1l8M5oBUVVl0coNN6K8QTzzycGXUjrl+lqTMthRSyRz7ZfYqCbvtakpmyjN2HhIjs0gH92twfZhw7ZhvrjQCW3rZosSpS/UPcNOYQ1toYOmybZEWb5D6gZsD5bVXWhtHd6ijdKjgp2MBV/jr94wtvgH9cN+8afwuje2tmigL3fr6gu01QlswFjyRZ72tbXVCK+rbRE08aFYaHyi9o0C4LDzju1K1d5ejyfymdextb2cOYt3dAu23hBnpTMbO31YIdbQ8e1l21Z2gIPSh/RVGz4tOhGasbU+DlrPUmuLVkrPWdvZw0Y4cJq3Wn/Ny60Hey0MS14rKz9xoPS3WWextia9M9ibsmd6HS6wHmmdHrS11j/Y1rSE/sATC2qrPyynHWqa3YeTEKz2qKV19HDPpXrpeE1RVfVP/QKVdFHisUY+5QAAAABJRU5ErkJggg==";
    private Handler mAccelerationHandler = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (AdapterAdLoaderImp.this.mIsClick) {
                removeCallbacksAndMessages(null);
            } else if (!ClickShakeListener.getInstance().isClick(AdapterAdLoaderImp.this.mAcceleration)) {
                AdapterAdLoaderImp.this.mAccelerationHandler.sendEmptyMessageDelayed(1, 1000L);
            } else {
                removeCallbacksAndMessages(null);
                AdapterAdLoaderImp.this.adAccelerationClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adAccelerationClick() {
        ALog.i(getClass().getSimpleName(), "super click");
        adClick();
    }

    public void accelerationClick(int i) {
        if (i == -1 || this.mIsClick) {
            return;
        }
        this.mAcceleration = i;
        this.mAccelerationHandler.sendEmptyMessage(1);
    }

    public void adClick() {
        this.mIsClick = true;
        onAdClickListener();
    }

    public void adClose() {
        adClose(true);
    }

    public void adClose(boolean z) {
        if (this.mIsClosed) {
            return;
        }
        this.mIsClosed = true;
        if (z) {
            onAdCloseListener();
        }
        runAdClose();
        if (isReleased()) {
            return;
        }
        release();
    }

    public boolean checkRenderView() {
        return true;
    }

    public V createAdInfo() {
        return null;
    }

    public V getAdInfo() {
        return this.mAdInfo;
    }

    public Context getContext() {
        T t = this.mAd;
        if (t != null) {
            return t.getContext();
        }
        return null;
    }

    public final void handleAdLoaderCallback(boolean z) {
        int i = this.mCallBackFlag;
        if (i > 0) {
            return;
        }
        AdapterAdLoaderCallback adapterAdLoaderCallback = this.mAdLoaderCallback;
        if (adapterAdLoaderCallback == null) {
            this.mCallBackFlag = i + 1;
            return;
        }
        if (z) {
            adapterAdLoaderCallback.onLoadAdObjectSucceed(this.mPosInfo);
        } else {
            adapterAdLoaderCallback.onLoadAdObjectFailed(this.mPosInfo);
        }
        this.mCallBackFlag++;
    }

    public boolean hasAdListener() {
        T t = this.mAd;
        return (t == null || t.getAdListener() == null) ? false : true;
    }

    public boolean isReleased() {
        return this.mIsReleased;
    }

    public boolean isShowAd() {
        T t = this.mAd;
        boolean z = t != null && (t.isShow() || (this.mCallShow && !this.mAd.isShow()));
        this.mCallShow = true;
        return z;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void loadAdObject(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
        this.mPosInfo = posInfoBean;
        this.mAdLoaderCallback = adapterAdLoaderCallback;
        this.mAdInfo = (V) createAdInfo();
        startRequestAd(posInfoBean, adapterAdLoaderCallback);
    }

    public void onAdClickListener() {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdClick(this.mAdInfo);
        }
    }

    public void onAdCloseListener() {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdClose(this.mAdInfo);
        }
    }

    public void onAdExposeListener() {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdExpose(this.mAdInfo);
        }
    }

    public void onAdFailedListener(AdError adError) {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdFailed(adError);
        }
    }

    public void onAdReadyListener() {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdReady(this.mAdInfo);
        }
    }

    public void onAdReceiveListener() {
        if (hasAdListener()) {
            this.mAd.getAdListener().onAdReceive(this.mAdInfo);
        }
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void onPaused() {
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void onResumed() {
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void release() {
        this.mIsReleased = true;
        this.mAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
        removeHandler();
    }

    public void removeHandler() {
        ALog.i(getClass().getSimpleName(), "super release");
        Handler handler = this.mAccelerationHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mAccelerationHandler = null;
        }
    }

    public void renderView() {
    }

    public void runAdClose() {
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void setAd(T t) {
        this.mAd = t;
    }

    @Override // com.bwt.top.ad.adapter.AdapterAdLoader
    public void showAdObject() {
        if (this.mAd == null || getContext() == null || this.mIsReleased || !checkRenderView()) {
            return;
        }
        renderView();
    }

    public void startRequestAd(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
    }
}
