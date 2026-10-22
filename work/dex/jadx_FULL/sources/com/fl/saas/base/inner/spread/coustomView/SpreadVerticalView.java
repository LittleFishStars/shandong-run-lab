package com.fl.saas.base.inner.spread.coustomView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fl.saas.base.inner.InnerNativeCustomView;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.net.ThreadPoolManager;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SpreadVerticalView implements InnerNativeCustomView {
    private final FrameLayout adView;
    private final ImageView bgView;
    private final Context mContext;
    private final ImageView mainImageView;

    public SpreadVerticalView(Context context) {
        this.mContext = context;
        FrameLayout frameLayout = (FrameLayout) ViewHelper.inflate(context, R.layout.yd_saas_spread_material_vertical);
        this.adView = frameLayout;
        this.mainImageView = (ImageView) frameLayout.findViewById(R.id.iv_yd_saas_custom_spread_vertical_img);
        this.bgView = (ImageView) frameLayout.findViewById(R.id.yd_saas_view_background);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$0(Bitmap bitmap) {
        this.bgView.setImageBitmap(bitmap);
        this.bgView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$1(Drawable drawable) {
        final Bitmap bitmapRsBlur = ImageUtils.rsBlur(this.mContext, Boolean.TRUE, ((BitmapDrawable) drawable).getBitmap(), 200);
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.fo8
            @Override // java.lang.Runnable
            public final void run() {
                this.f16592a.lambda$setMediaView$0(bitmapRsBlur);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setMediaView$2(final Drawable drawable) {
        ThreadPoolManager.getInstance().addTask(new Runnable() { // from class: com.zj.adlib.ho8
            @Override // java.lang.Runnable
            public final void run() {
                this.f17047a.lambda$setMediaView$1(drawable);
            }
        });
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getAdView() {
        return this.adView;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public View getCATView() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public Consumer<Bitmap> loadIcon() {
        return null;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setCAT(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setDes(String str) {
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setMediaView(View view, final Drawable drawable) {
        if (view != null) {
            ViewHelper.removeParent(view);
            this.adView.addView(view, ViewHelper.getMatchParent());
            this.mainImageView.setVisibility(8);
        }
        if (drawable != null) {
            ImageView.ScaleType scaleType = DeviceUtil.scaleType;
            if (scaleType != null) {
                this.mainImageView.setScaleType(scaleType);
            }
            this.mainImageView.setImageDrawable(drawable);
            this.mainImageView.setVisibility(0);
        }
        if (drawable instanceof BitmapDrawable) {
            this.adView.post(new Runnable() { // from class: com.zj.adlib.do8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16051a.lambda$setMediaView$2(drawable);
                }
            });
        }
        return this;
    }

    @Override // com.fl.saas.base.inner.InnerNativeCustomView
    public InnerNativeCustomView setTitle(String str) {
        return this;
    }
}
