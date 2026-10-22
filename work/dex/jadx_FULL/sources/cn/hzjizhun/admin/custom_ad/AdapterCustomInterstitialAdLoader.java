package cn.hzjizhun.admin.custom_ad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo;
import cn.hzjizhun.admin.ad.impl.JZInterstitialAd;
import cn.hzjizhun.admin.ad.listener.JZInterstitialAdListener;
import cn.hzjizhun.admin.custom_ad.http.CustomAdPosResult;
import cn.hzjizhun.admin.ddd;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.image.ImageLoaderCallback;
import cn.hzjizhun.admin.image.ImageLoaderImp;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DisplayUtil;
import cn.hzjizhun.admin.view.AdDialog;
import cn.hzjizhun.admin.view.RootTouchViewGroup;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomInterstitialAdLoader extends AdapterCustomAdLoader<JZInterstitialAdInfo, JZInterstitialAdListener, JZInterstitialAd> {
    private ImageView iconIv;
    private LinearLayout llPopClick;
    private AdDialog mAdDialog;
    private ImageView mCloseIv;
    private View mContentView;
    private boolean mIsShow;
    private ImageView mPicIv;
    private RootTouchViewGroup mRootTouchViewGroup;

    private void autoClose() {
        T t = this.mAd;
        if (t == 0 || ((JZInterstitialAd) t).getCloseTime() <= 0) {
            return;
        }
        ((JZInterstitialAd) this.mAd).getCloseHandler().postDelayed(new Runnable() { // from class: com.zj.adlib.c00
            @Override // java.lang.Runnable
            public final void run() {
                this.f40872a.lambda$autoClose$1();
            }
        }, ((JZInterstitialAd) this.mAd).getCloseTime());
    }

    private void closeBottomConfig() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mCloseIv.getLayoutParams();
        layoutParams.addRule(11);
        layoutParams.addRule(8, R.id.channel_insert_pic_iv);
        layoutParams.bottomMargin = DisplayUtil.dp2px(8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private boolean keenClick() {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || !customAdPosResult.isKeen() || this.mContentView == null) {
            return false;
        }
        this.mAdDialog.setCancelable(false);
        this.mContentView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.e00
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f41314a.lambda$keenClick$0(view, motionEvent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$autoClose$1() {
        adClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$keenClick$0(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        adClickSource(Cs.KC);
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void setClick() {
        LinearLayout linearLayout;
        ImageView imageView = this.mCloseIv;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AdapterCustomInterstitialAdLoader.this.adClose();
                }
            });
        }
        if (keenClick() || (linearLayout = this.llPopClick) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdapterCustomInterstitialAdLoader.this.adClickSource(Cs.MC);
            }
        });
    }

    private void updateIcon(ImageLoaderImp imageLoaderImp) {
        CustomAdPosResult customAdPosResult = this.mAdObject;
        if (customAdPosResult == null || imageLoaderImp == null || this.mAd == 0) {
            return;
        }
        imageLoaderImp.loadIcon(customAdPosResult.getIconUrl(), this.iconIv);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void clickCoordinatesReport() {
        clickCoordinatesReport(this.mRootTouchViewGroup, MediationConstant.RIT_TYPE_INTERSTITIAL);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        super.readyAdView();
        View viewInflate = View.inflate(getContext(), R.layout.jz_layout_channel_insert, null);
        this.mContentView = viewInflate;
        this.mRootTouchViewGroup = (RootTouchViewGroup) viewInflate.findViewById(R.id.rootTouchGroup);
        this.mPicIv = (ImageView) this.mContentView.findViewById(R.id.channel_insert_pic_iv);
        this.llPopClick = (LinearLayout) this.mContentView.findViewById(R.id.llPopClick);
        this.mCloseIv = (ImageView) this.mContentView.findViewById(R.id.channel_insert_close_iv);
        this.iconIv = (ImageView) this.mContentView.findViewById(R.id.iv_ad_icon);
        ((JZInterstitialAd) this.mAd).isCloseViewTop();
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader, cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp, cn.hzjizhun.admin.ad.adapter.AdapterAdLoader
    public void release() {
        super.release();
        T t = this.mAd;
        if (t != 0 && ((JZInterstitialAd) t).getCloseHandler() != null) {
            ((JZInterstitialAd) this.mAd).getCloseHandler().removeCallbacksAndMessages(null);
        }
        AdDialog adDialog = this.mAdDialog;
        if (adDialog != null) {
            adDialog.dismiss();
            this.mAdDialog = null;
            this.mPicIv = null;
            this.mCloseIv = null;
        }
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        this.mImageLoader.preLoadImage(this.mAdObject.getImgUrl(), new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.1
            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onError() {
            }

            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onSuccess() {
                if (((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd == null || ((JZInterstitialAd) ((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd).getAdListener() == null) {
                    return;
                }
                ((JZInterstitialAd) ((AdapterAdLoaderImp) AdapterCustomInterstitialAdLoader.this).mAd).getAdListener().onAdReady((JZInterstitialAdInfo) AdapterCustomInterstitialAdLoader.this.getAdInfo());
            }
        });
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void runAdClose() {
        super.runAdClose();
        try {
            AdDialog adDialog = this.mAdDialog;
            if (adDialog == null || !adDialog.isShowing()) {
                return;
            }
            this.mAdDialog.dismiss();
        } catch (Throwable unused) {
        }
    }

    public void showInterstitialAd(Activity activity) {
        ALog.d(this.TAG, "showInterstitial");
        if (this.mIsShow) {
            return;
        }
        this.mIsShow = true;
        AdDialog adDialog = new AdDialog(activity);
        this.mAdDialog = adDialog;
        adDialog.setContentView(this.mContentView);
        this.mAdDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                AdapterCustomInterstitialAdLoader.this.adClose();
            }
        });
        this.mAdDialog.setCanceledOnTouchOutside(((JZInterstitialAd) this.mAd).isOutsideCancel());
        this.mAdDialog.setCancelable(((JZInterstitialAd) this.mAd).isCancelable());
        autoClose();
        this.mAdDialog.show();
        setClick();
        ImageLoaderImp imageLoaderImp = new ImageLoaderImp(activity, this.TAG);
        updateIcon(imageLoaderImp);
        imageLoaderImp.loadImage(this.mAdObject.getImgUrl(), this.mPicIv, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.4
            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onError() {
                AdapterCustomInterstitialAdLoader.this.onAdFailedListener(new JZAdError(302, "preload img failed"));
            }

            @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
            public void onSuccess() {
                AdapterCustomInterstitialAdLoader.this.onAdExposeListener();
            }
        });
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZInterstitialAdInfo createAdInfo() {
        return new ddd(this.mPosInfo, this) { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomInterstitialAdLoader.2
            @Override // cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo
            public boolean hasExpired() {
                return isReleased();
            }

            @Override // cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo
            public boolean hasShown() {
                return AdapterCustomInterstitialAdLoader.this.mIsShow;
            }

            @Override // cn.hzjizhun.admin.ad.bean.JZInterstitialAdInfo
            public void showInterstitial(Activity activity) {
                AdapterCustomInterstitialAdLoader.this.showInterstitialAd(activity);
            }
        };
    }
}
