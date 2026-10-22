package com.fl.saas.adx.base.inner.banner.customView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.fl.saas.AbstractC1398a0;
import com.fl.saas.B;
import com.fl.saas.R;
import com.fl.saas.adx.base.inner.InnerNativeCustomView;
import com.fl.saas.adx.util.ViewHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class BannerSingleImgView implements InnerNativeCustomView {
    private final View adView;
    private final TextView desView;
    private final int height;
    private final Context mContext;
    private final ImageView mainImageView;
    private final FrameLayout mediaContainer;
    private final TextView titleView;
    private final int width;

    public BannerSingleImgView(Context context, int i, int i2) {
        this.mContext = context;
        this.width = i;
        this.height = i2;
        View viewInflate = ViewHelper.inflate(context, R.layout.fl_adx_banner_single_img);
        this.adView = viewInflate;
        this.titleView = (TextView) viewInflate.findViewById(R.id.fl_saas_banner_title);
        this.desView = (TextView) viewInflate.findViewById(R.id.fl_saas_banner_des);
        this.mediaContainer = (FrameLayout) viewInflate.findViewById(R.id.fl_saas_banner_media_container);
        this.mainImageView = (ImageView) viewInflate.findViewById(R.id.fl_saas_banner_img);
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public View getCATView() {
        return null;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public B loadIcon() {
        return null;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, @Nullable Drawable drawable) {
        if (view != null) {
            this.mediaContainer.addView(view, ViewHelper.getMatchParent());
        } else if (drawable != null) {
            ImageView imageView = new ImageView(this.mContext);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.mediaContainer.addView(imageView, 0, ViewHelper.getMatchParent());
            AbstractC1398a0.a(imageView, drawable);
            this.mainImageView.setImageDrawable(drawable);
        }
        return this;
    }

    @Override // com.fl.saas.adx.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
