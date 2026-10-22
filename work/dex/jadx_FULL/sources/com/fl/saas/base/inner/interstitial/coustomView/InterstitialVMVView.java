package com.fl.saas.base.inner.interstitial.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.base.inner.InnerNativeAdLogo;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterstitialVMVView implements InnerNativeCustomView, InnerNativeAdLogo {
    private final TextView CATView;
    private final ImageView adLogo;
    private final View adView;
    private final ImageView bgView;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final View textContent;
    private final TextView titleView;

    public InterstitialVMVView(Context context) {
        this.mContext = context;
        View viewInflate = ViewHelper.inflate(context, R.layout.yd_saas_interstitial_v_material_v);
        this.adView = viewInflate;
        this.titleView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_vertical_title);
        this.CATView = (TextView) viewInflate.findViewById(R.id.tv_yd_saas_custom_vertical_btn);
        this.bgView = (ImageView) viewInflate.findViewById(R.id.yd_saas_view_background);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_img);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_video);
        this.adLogo = (ImageView) viewInflate.findViewById(R.id.iv_yd_saas_custom_vertical_adlogo);
        this.textContent = viewInflate.findViewById(R.id.rl_yd_saas_custom_content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        if (this.mediaContainer.getVisibility() == 0) {
            this.mainImageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapRsBlur = ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.lf4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17930a.lambda$setMediaView$0(bitmapRsBlur);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.jf4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17381a.lambda$setMediaView$1(drawable);
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
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeAdLogo
    public void setAdLogo(Bitmap bitmap) {
        this.adLogo.setImageBitmap(bitmap);
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        ViewHelper.setTextView(this.CATView, str);
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable final Drawable drawable) {
        if (view != null) {
            this.mediaContainer.removeAllViews();
            this.mediaContainer.addView(view, ViewHelper.getMatchParent());
            this.mediaContainer.setVisibility(0);
            this.mainImageView.setVisibility(8);
        } else if (drawable != null) {
            this.mainImageView.setImageDrawable(drawable);
            this.mediaContainer.setVisibility(8);
            this.mainImageView.setVisibility(0);
            if (drawable instanceof BitmapDrawable) {
                this.bgView.post(new Runnable() { // from class: com.zj.adlib.hf4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f16980a.lambda$setMediaView$2(drawable);
                    }
                });
            }
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        if (!TextUtils.isEmpty(str)) {
            this.textContent.setVisibility(0);
        }
        return this;
    }
}
