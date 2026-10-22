package cn.hzjizhun.admin.custom_ad;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.hzjizhun.admin.R;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.BasicJZAdInfoIpl;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZAdInfo;
import cn.hzjizhun.admin.ad.impl.JZBannerAd;
import cn.hzjizhun.admin.ad.impl.JZServiceAd;
import cn.hzjizhun.admin.ad.listener.JZBannerAdListener;
import cn.hzjizhun.admin.exception.JZAdError;
import cn.hzjizhun.admin.image.ImageLoaderCallback;
import cn.hzjizhun.admin.util.ALog;
import cn.hzjizhun.admin.util.DisplayUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomBannerAdLoader extends AdapterCustomAdLoader<JZAdInfo, JZBannerAdListener, JZBannerAd> {
    private RelativeLayout mBannerView;
    private ImageView mCloseImgView;
    private ImageView mImgView;

    private void addAdView(@NonNull View view) {
        T t = this.mAd;
        if (t == 0 || ((JZBannerAd) t).getContainer() == null) {
            ALog.i(this.TAG, "addAdView is failed ");
            return;
        }
        RelativeLayout container = ((JZBannerAd) this.mAd).getContainer();
        if (container != null) {
            container.addView(view);
            ViewGroup viewGroup = (ViewGroup) container.getParent();
            if (viewGroup == null) {
                return;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (viewGroup.getChildAt(i) != container) {
                    viewGroup.removeViewAt(i);
                }
            }
            if (container.getVisibility() != 0) {
                container.setVisibility(0);
            }
        }
    }

    private void closeEvent() {
        try {
            int closeIconSize = ((JZBannerAd) this.mAd).getCloseIconSize();
            ImageView imageView = (ImageView) this.mBannerView.findViewById(R.id.channel_banner_close_iv);
            this.mCloseImgView = imageView;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = DisplayUtil.dp2px(closeIconSize);
            layoutParams.height = DisplayUtil.dp2px(closeIconSize);
            this.mCloseImgView.setLayoutParams(layoutParams);
            this.mCloseImgView.setVisibility(((JZBannerAd) this.mAd).isShowCloseView() ? 0 : 8);
            this.mCloseImgView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f40423a.lambda$closeEvent$0(view);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$closeEvent$0(View view) {
        RelativeLayout relativeLayout = this.mBannerView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        onAdCloseListener();
    }

    private void preImgView(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.preLoadImage(str, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomBannerAdLoader.3
                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onError() {
                }

                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomBannerAdLoader.this.onAdReadyListener();
                }
            });
            return;
        }
        onAdFailedListener(new JZAdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void renderImgView(String str) {
        if (this.mImgView != null && !TextUtils.isEmpty(str)) {
            this.mImageLoader.loadImage(str, this.mImgView, new ImageLoaderCallback() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomBannerAdLoader.2
                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onError() {
                    AdapterCustomBannerAdLoader.this.onAdFailedListener(new JZAdError(302, "loadImage error"));
                }

                @Override // cn.hzjizhun.admin.image.ImageLoaderCallback
                public void onSuccess() {
                    AdapterCustomBannerAdLoader.this.onAdExposeListener();
                }
            });
            return;
        }
        onAdFailedListener(new JZAdError(10, "iv is null or imgUrl is empty" + str));
    }

    private void updateIcon() {
        RelativeLayout relativeLayout;
        if (this.mAdObject == null || this.mImageLoader == null || (relativeLayout = this.mBannerView) == null || (this.mAd instanceof JZServiceAd)) {
            return;
        }
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.channel_banner_ic_iv);
        imageView.setVisibility(0);
        this.mImageLoader.loadIcon(this.mAdObject.getIconUrl(), imageView);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZAdInfo createAdInfo() {
        return new BasicJZAdInfoIpl(this.mPosInfo, this);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void readyAdView() {
        RelativeLayout relativeLayout = (RelativeLayout) View.inflate(getContext(), R.layout.jz_layout_channel_banner, null);
        this.mBannerView = relativeLayout;
        this.mImgView = (ImageView) relativeLayout.findViewById(R.id.channel_banner_iv);
        closeEvent();
        this.mBannerView.setOnClickListener(new View.OnClickListener() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomBannerAdLoader.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdapterCustomBannerAdLoader.this.adClickSource(Cs.MC);
            }
        });
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        try {
            if (this.mBannerView == null) {
                return;
            }
            String imgUrl = this.mAdObject.getImgUrl();
            if (!isShowAd()) {
                preImgView(imgUrl);
                return;
            }
            addAdView(this.mBannerView);
            renderImgView(imgUrl);
            updateIcon();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [cn.hzjizhun.admin.ad.bean.JZAdInfo] */
    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void skipH5Listener(String str) {
        super.skipH5Listener(str);
        T t = this.mAd;
        if (t == 0 || ((JZBannerAd) t).getAdListener() == null) {
            return;
        }
        ((JZBannerAd) this.mAd).getAdListener().onAdClick(getAdInfo(), str);
    }
}
