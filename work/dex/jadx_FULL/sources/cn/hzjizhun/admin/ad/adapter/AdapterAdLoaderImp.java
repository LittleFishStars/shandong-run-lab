package cn.hzjizhun.admin.ad.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import cn.hzjizhun.admin.ad.AdListener;
import cn.hzjizhun.admin.ad.BaseAd;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.impl.JZNativeAd;
import cn.hzjizhun.admin.ad.impl.JZSplashAd;
import cn.hzjizhun.admin.ad.utils.JZAdUtil;
import cn.hzjizhun.admin.api.ApiManager;
import cn.hzjizhun.admin.api.bean.PosInfoBean;
import cn.hzjizhun.admin.ddsksdddk;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.ClickShakeListener;
import cn.hzjizhun.admin.view.RootTouchViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.igexin.sdk.PushConsts;
import com.zj.adlib.cva;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AdapterAdLoaderImp<V extends JZAdInfo, Y extends AdListener<V>, T extends BaseAd<Y>> implements AdapterAdLoader<T> {
    public static String mCloseBitmap64 = "iVBORw0KGgoAAAANSUhEUgAAADwAAAA8CAMAAAANIilAAAAAmVBMVEUAAAAiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiIiJv+HxmAAAAMnRSTlMA9fz58dJHPTEiHBbu6uTcWlROASsm6ODOxQqVi4FxQTo3DwbWy7Sdd2tkNRO+uGARqh+5EbcAAAFkSURBVEjH7dPbcoIwFIXhoCAeUPCMZ8FDtdJq8/4PV1nRyUzZYRsvesV/l1l8M5oBUVVl0coNN6K8QTzzycGXUjrl+lqTMthRSyRz7ZfYqCbvtakpmyjN2HhIjs0gH92twfZhw7ZhvrjQCW3rZosSpS/UPcNOYQ1toYOmybZEWb5D6gZsD5bVXWhtHd6ijdKjgp2MBV/jr94wtvgH9cN+8afwuje2tmigL3fr6gu01QlswFjyRZ72tbXVCK+rbRE08aFYaHyi9o0C4LDzju1K1d5ejyfymdextb2cOYt3dAu23hBnpTMbO31YIdbQ8e1l21Z2gIPSh/RVGz4tOhGasbU+DlrPUmuLVkrPWdvZw0Y4cJq3Wn/Ny60Hey0MS14rKz9xoPS3WWextia9M9ibsmd6HS6wHmmdHrS11j/Y1rSE/sATC2qrPyynHWqa3YeTEKz2qKV19HDPpXrpeE1RVfVP/QKVdFHisUY+5QAAAABJRU5ErkJggg==";
    private int mAcceleration;
    protected T mAd;
    protected V mAdInfo;
    protected AdapterAdLoaderCallback mAdLoaderCallback;
    protected boolean mCallShow;
    private ClickShakeListener mClickShakeListener;
    protected boolean mIsAccelerationClick;
    protected boolean mIsClick;
    private boolean mIsClosed;
    protected boolean mIsReleased;
    protected PosInfoBean mPosInfo;
    protected String TAG = getClass().getSimpleName();
    private int mCallBackFlag = 0;
    private boolean mIsActResume = true;
    private final AtomicBoolean mIsDisplayReport = new AtomicBoolean(false);
    private final AtomicBoolean mIsClickReport = new AtomicBoolean(false);
    private Handler mAccelerationHandler = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                AdapterAdLoaderImp adapterAdLoaderImp = AdapterAdLoaderImp.this;
                if (!adapterAdLoaderImp.mIsClick && adapterAdLoaderImp.mClickShakeListener != null) {
                    AdapterAdLoaderImp.this.mClickShakeListener.start();
                    if (!AdapterAdLoaderImp.this.mClickShakeListener.isClick(AdapterAdLoaderImp.this.mAcceleration)) {
                        AdapterAdLoaderImp.this.mAccelerationHandler.sendEmptyMessageDelayed(1, 1000L);
                        return;
                    }
                    AdapterAdLoaderImp.this.mClickShakeListener.stop();
                    removeCallbacksAndMessages(null);
                    AdapterAdLoaderImp.this.adAccelerationClick();
                    return;
                }
                removeCallbacksAndMessages(null);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adAccelerationClick() {
        ALog.i(getClass().getSimpleName(), "super click");
        this.mIsAccelerationClick = true;
        adClickSource(Cs.SC);
    }

    public void accelerationClick(int i) {
        ALog.innerD("ClickShakeListener", "acc value....." + i);
        if (i == -1 || this.mIsClick) {
            return;
        }
        ALog.innerD("ClickShakeListener", "accelerationClick start acc....." + i);
        if (this.mClickShakeListener == null) {
            this.mClickShakeListener = ClickShakeListener.getInstance();
        }
        this.mAcceleration = i;
        this.mAccelerationHandler.sendEmptyMessage(1);
    }

    public void accelerationDisplayBefore(int i) {
        ALog.innerD("accelerationDisplayBefore", "acc....." + i);
        if (i == -1 || this.mIsClick || this.mClickShakeListener != null) {
            return;
        }
        ClickShakeListener clickShakeListener = ClickShakeListener.getInstance();
        this.mClickShakeListener = clickShakeListener;
        clickShakeListener.setAcceleratio(i);
        this.mClickShakeListener.start();
    }

    public void adClickSource(Cs cs) {
    }

    public void adClose() {
        adClose(true);
    }

    public boolean checkRenderView() {
        return true;
    }

    public void clickCoordinatesReport() {
        try {
            T t = this.mAd;
            if (t instanceof JZBannerAd) {
                clickCoordinatesReport((RootTouchViewGroup) ((JZBannerAd) t).getContainer(), MediationConstant.RIT_TYPE_BANNER);
                return;
            }
            if (t instanceof JZSplashAd) {
                clickCoordinatesReport((RootTouchViewGroup) ((JZSplashAd) t).getContainer(), MediationConstant.RIT_TYPE_SPLASH);
                return;
            }
            if (t instanceof JZNativeAd) {
                RootTouchViewGroup rootTouchViewGroupB = ddsksdddk.b(this.mPosInfo.getThirdPosId());
                String str = "native";
                if (rootTouchViewGroupB != null && rootTouchViewGroupB.kdsksdda) {
                    str = MediationConstant.RIT_TYPE_INTERSTITIAL;
                }
                clickCoordinatesReport(rootTouchViewGroupB, str);
            }
        } catch (Throwable unused) {
        }
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
        try {
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
        } catch (Throwable unused) {
        }
    }

    public boolean hasAdListener() {
        T t = this.mAd;
        return (t == null || t.getAdListener() == null) ? false : true;
    }

    public boolean isActResume() {
        return this.mIsActResume;
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

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void loadAdObject(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
        this.mPosInfo = posInfoBean;
        this.mAdLoaderCallback = adapterAdLoaderCallback;
        this.mAdInfo = (V) createAdInfo();
        posInfoBean.setReqId(this.mAd.createReqId());
        startRequestAd(posInfoBean, adapterAdLoaderCallback);
    }

    public void onAdClickListener() {
        try {
            clickCoordinatesReport();
            if (hasAdListener() && this.mIsClickReport.compareAndSet(false, true)) {
                onAdExposeListener();
                this.mAd.getAdListener().onAdClick(this.mAdInfo);
            }
        } catch (Throwable unused) {
        }
    }

    public void onAdCloseListener() {
        try {
            if (hasAdListener()) {
                this.mAd.getAdListener().onAdClose(this.mAdInfo);
            }
        } catch (Throwable unused) {
        }
    }

    public void onAdExposeListener() {
        ALog.d(this.TAG, "mIsDisplayReport" + hasAdListener() + "---" + this.mIsDisplayReport);
        if (hasAdListener() && this.mIsDisplayReport.compareAndSet(false, true)) {
            ALog.d(this.TAG, "曝光回调调用");
            this.mAd.getAdListener().onAdExpose(this.mAdInfo);
        }
    }

    public void onAdFailedListener(JZAdError jZAdError) {
        try {
            if (hasAdListener()) {
                this.mAd.getAdListener().onAdFailed(jZAdError);
            }
            if (jZAdError == null || jZAdError.errorCode() != 302) {
                return;
            }
            ApiManager.reportError(PushConsts.SEND_MESSAGE_ERROR_TIME_OUT, this.mPosInfo.getThirdPosId());
        } catch (Throwable unused) {
        }
    }

    public void onAdReadyListener() {
        try {
            if (hasAdListener()) {
                this.mAd.getAdListener().onAdReady(this.mAdInfo);
            }
        } catch (Throwable unused) {
        }
    }

    public void onAdReceiveListener() {
        try {
            ALog.innerD(this.TAG, "广告请求成功" + hasAdListener());
            if (hasAdListener()) {
                this.mAd.getAdListener().onAdReceive(this.mAdInfo);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void onPaused() {
        ALog.d("mCloseHandler", "onPaused: ");
        this.mIsActResume = false;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void onResumed() {
        ALog.d("mCloseHandler", "onResumed: ");
        this.mIsActResume = true;
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        ALog.d("release", this.mPosInfo + "releaserelease");
        PosInfoBean posInfoBean = this.mPosInfo;
        if (posInfoBean != null) {
            ddsksdddk.a(posInfoBean.getThirdPosId());
        }
        this.mIsReleased = true;
        this.mAd = null;
        this.mPosInfo = null;
        this.mAdLoaderCallback = null;
        removeHandler();
    }

    public void removeHandler() {
        ALog.i(getClass().getSimpleName(), "super release");
        ClickShakeListener clickShakeListener = this.mClickShakeListener;
        if (clickShakeListener != null) {
            clickShakeListener.stop();
        }
        Handler handler = this.mAccelerationHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mAccelerationHandler = null;
        }
    }

    public void renderView() {
        try {
            if (this.mAd instanceof JZNativeAd) {
                Log.d(this.TAG, "renderView: " + this.mPosInfo.getCountdown());
                JZAdUtil.setCountdown(this.mPosInfo.getCountdown());
            }
        } catch (Throwable unused) {
        }
    }

    public void runAdClose() {
    }

    public void setCloseViewIcon(ImageView imageView) {
        try {
            byte[] bArrDecode = Base64.decode(mCloseBitmap64, 0);
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void shakeClick() {
        try {
            T t = this.mAd;
            if ((t instanceof JZSplashAd) || (t instanceof JZInterstitialAd) || (t instanceof JZNativeAd)) {
                adClickSource(Cs.MC);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void showAdObject() {
        if (this.mAd == null || getContext() == null || this.mIsReleased || !checkRenderView()) {
            return;
        }
        renderView();
    }

    public void startRequestAd(PosInfoBean posInfoBean, AdapterAdLoaderCallback adapterAdLoaderCallback) {
    }

    public void adClose(boolean z) {
        try {
            if (this.mIsClosed) {
                return;
            }
            this.mIsClosed = true;
            if (z) {
                onAdCloseListener();
            }
            runAdClose();
            this.mAd.release();
        } catch (Throwable unused) {
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void setAd(T t) {
        this.mAd = t;
    }

    public void clickCoordinatesReport(RootTouchViewGroup rootTouchViewGroup, String str) {
        try {
            cva cvaVar = new cva();
            cvaVar.f41050a = str;
            String str2 = rootTouchViewGroup.ddksa;
            cvaVar.b = str2;
            String str3 = rootTouchViewGroup.dkkd;
            cvaVar.c = str3;
            String str4 = rootTouchViewGroup.akdsd;
            cvaVar.d = str4;
            ApiManager.clickCoordinatesReport(str, str2, str3, str4);
        } catch (Throwable unused) {
        }
    }
}
