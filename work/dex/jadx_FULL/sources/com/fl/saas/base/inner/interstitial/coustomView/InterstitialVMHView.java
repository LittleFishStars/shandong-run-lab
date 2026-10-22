package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.base.inner.interstitial.InterstitialViewHelper;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialVMHView implements InnerNativeCustomView {
    private final TextView CATView;
    private final View adView;
    private final ImageView bgView;
    private final TextView desView;
    private final ImageView logoIcon;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;

    public InterstitialVMHView(Context context) {
        this.mContext = context;
        View viewInflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_material_h);
        this.adView = viewInflate;
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.logoIcon = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitia_icon);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.yd_saas_custom_interstitial_media_container);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_interstitial);
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_desc);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_interstitia_btn);
        ImageLoader.loadImageBitmap("https://creative.medproad.com/medpro/imgs/yd_saas_custom_spread_bg.webp", new Consumer() { // from class: com.zj.adlib.we4
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f45580a.lambda$new$0((Bitmap) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadIcon$4(Bitmap bitmap) {
        this.logoIcon.setVisibility(0);
        this.logoIcon.setImageBitmap(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.adView.setBackground(new BitmapDrawable(this.mContext.getResources(), bitmap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        if (this.mediaContainer.getVisibility() == 0) {
            this.mainImageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(Drawable drawable) {
        final Bitmap bitmapRsBlur = ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.af4
            @Override // java.lang.Runnable
            public final void run() {
                this.f15263a.lambda$setMediaView$1(bitmapRsBlur);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$3(final Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.ye4
            @Override // java.lang.Runnable
            public final void run() {
                this.f20841a.lambda$setMediaView$2(drawable);
            }
        });
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getCATView() {
        return this.CATView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public Consumer<Bitmap> loadIcon() {
        return new Consumer() { // from class: com.zj.adlib.ef4
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f41423a.lambda$loadIcon$4((Bitmap) obj);
            }
        };
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable final Drawable drawable) {
        this.bgView.setVisibility(drawable == null ? 8 : 0);
        if (view != null) {
            this.mediaContainer.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (drawable != null) {
                layoutParams.height = Math.round(((InterstitialViewHelper.getInterstitialSize().first.intValue() - (DeviceUtil.dip2px(15.0f) * 2)) * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth());
            } else {
                this.mainImageView.setVisibility(8);
            }
            this.mediaContainer.addView(view, layoutParams);
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
            if (drawable instanceof BitmapDrawable) {
                this.bgView.post(new Runnable() { // from class: com.zj.adlib.cf4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f15810a.lambda$setMediaView$3(drawable);
                    }
                });
            }
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
