package com.fl.saas.s2s.sdk.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.ImageLoader;
import com.fl.saas.common.util.ImageUtils;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.common.util.feature.Consumer;
import com.fl.saas.common.util.feature.Optional;
import com.fl.saas.common.widget.InterceptClickLayout;
import com.fl.saas.common.widget.RoundedFrameLayout;
import com.fl.saas.common.widget.ShaderRoundImageView;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;
import com.fl.saas.s2s.sdk.ad.S2STemplateViewHelper;
import com.fl.saas.s2s.sdk.helper.AdInfoPoJo;
import com.fl.saas.s2s.sdk.util.S2SVideoView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class S2STemplateViewHelper {
    private final FrameLayout actionContainer;
    private FrameLayout adContainer;
    private final View adView;
    private final TextView desView;
    private int horizontalPadding;
    private Runnable mClosedEvent;
    private final Context mContext;
    private int mHeight;
    private final Type mType;
    private int mWidth;
    private final RoundedFrameLayout mediaContainer;
    private View templateView;
    private final TextView titleView;
    private int verticalPadding;
    private S2SVideoView videoView;

    public interface OnLoadListener {
        void onClose();

        void onRenderFail();
    }

    public enum Type {
        MIXED_TEXT_IMAGE(true, R.layout.s2s_template_view_text_img_mixture),
        TEXT_OVERLAY(true, R.layout.s2s_template_view_text_float_layer),
        TOP_TEXT_BOTTOM_IMAGE(true, R.layout.s2s_template_view_top_text_bottom_img_with_btn),
        TOP_IMAGE_BOTTOM_TEXT(true, R.layout.s2s_template_view_top_img_bottom_text_with_btn),
        LEFT_TEXT_RIGHT_IMAGE(false, R.layout.s2s_template_view_left_text_right_img),
        LEFT_IMAGE_RIGHT_TEXT(false, R.layout.s2s_template_view_left_img_right_text),
        IMAGE_ONLY(true, R.layout.s2s_template_view_img);

        private final boolean isFullWidthMedia;
        private final int layoutId;

        Type(boolean z, int i) {
            this.layoutId = i;
            this.isFullWidthMedia = z;
        }

        public static Type parse(int i) {
            for (Type type : values()) {
                if (type.ordinal() == i) {
                    return type;
                }
            }
            return MIXED_TEXT_IMAGE;
        }

        public View inflateAdView(Context context) {
            return ViewHelper.inflate(context, this.layoutId);
        }

        public boolean isFullWidthMedia() {
            return this.isFullWidthMedia;
        }
    }

    public S2STemplateViewHelper(Context context, Type type) {
        this.mContext = context;
        this.mType = type;
        View viewInflateAdView = type.inflateAdView(context);
        this.adView = viewInflateAdView;
        RoundedFrameLayout roundedFrameLayout = (RoundedFrameLayout) viewInflateAdView.findViewById(R.id.s2s_template_view_media_container);
        this.mediaContainer = roundedFrameLayout;
        this.actionContainer = (FrameLayout) Optional.of(viewInflateAdView).map(new Function() { // from class: com.zj.adlib.xp7
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return S2STemplateViewHelper.lambda$new$0((View) obj);
            }
        }).orElse(roundedFrameLayout);
        TextView textView = (TextView) viewInflateAdView.findViewById(R.id.s2s_template_view_title);
        this.titleView = textView;
        TextView textView2 = (TextView) viewInflateAdView.findViewById(R.id.s2s_template_view_des);
        this.desView = textView2;
        if (type == Type.TEXT_OVERLAY) {
            if (textView != null) {
                textView.setTextColor(-1);
            }
            if (textView2 != null) {
                textView2.setTextColor(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addActionView$3(View view) {
        int width = this.actionContainer.getWidth();
        int height = this.actionContainer.getHeight();
        int[] iArrSelfMeasure = ViewHelper.selfMeasure(view);
        int i = iArrSelfMeasure[0];
        int i2 = iArrSelfMeasure[1];
        int iDip2px = DeviceUtil.dip2px(5.0f) * 2;
        int i3 = width - iDip2px;
        int i4 = height - iDip2px;
        if (i4 <= 0 || i3 <= 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.gravity = 17;
        if (i3 < i || i4 < i2) {
            float fMin = Math.min(i3 / i, i4 / i2);
            view.setScaleX(fMin);
            view.setScaleY(fMin);
        }
        this.actionContainer.addView(view, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCloseView$1(View view) {
        ViewHelper.removeParent(this.templateView);
        Runnable runnable = this.mClosedEvent;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addFillActionView$4(View view) {
        this.adContainer.addView(view, new FrameLayout.LayoutParams(this.mWidth, this.mHeight));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadImage$2(Drawable drawable) {
        ImageView imageView = new ImageView(this.mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ImageUtils.setBlurImage(imageView, drawable);
        ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(this.mContext);
        shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        shaderRoundImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = this.mType.isFullWidthMedia() ? new FrameLayout.LayoutParams(-2, -1) : new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        this.mediaContainer.addView(shaderRoundImageView, 0, layoutParams);
        this.mediaContainer.addView(imageView, 0, ViewHelper.getMatchParent());
        shaderRoundImageView.setImageDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FrameLayout lambda$new$0(View view) {
        return (FrameLayout) view.findViewById(R.id.s2s_template_action_container);
    }

    private void loadImage(String str) {
        ImageLoader.loadImageDrawable(str, new Consumer() { // from class: com.zj.adlib.vp7
            @Override // com.fl.saas.common.util.feature.Consumer
            public final void accept(Object obj) {
                this.f45412a.lambda$loadImage$2((Drawable) obj);
            }
        });
    }

    private void loadMedia(AdInfoPoJo adInfoPoJo) {
        S2SVideoView s2SVideoView = new S2SVideoView(this.mContext);
        this.videoView = s2SVideoView;
        s2SVideoView.setVideo(adInfoPoJo);
        this.mediaContainer.addView(this.videoView, ViewHelper.getMatchParent());
    }

    public void addActionView(final View view) {
        if (view == null) {
            return;
        }
        this.actionContainer.post(new Runnable() { // from class: com.zj.adlib.zp7
            @Override // java.lang.Runnable
            public final void run() {
                this.f21100a.lambda$addActionView$3(view);
            }
        });
    }

    public S2STemplateViewHelper addCloseView() {
        int i;
        int i2;
        if (this.actionContainer == null) {
            return this;
        }
        try {
            ImageView imageView = new ImageView(this.mContext);
            Type type = this.mType;
            if (type == Type.LEFT_TEXT_RIGHT_IMAGE || type == Type.LEFT_IMAGE_RIGHT_TEXT) {
                i = 16;
                i2 = 6;
            } else {
                i = 20;
                i2 = 12;
            }
            float f = i;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DeviceUtil.dip2px(f), DeviceUtil.dip2px(f));
            layoutParams.gravity = 8388661;
            int iDip2px = DeviceUtil.dip2px(i2);
            layoutParams.setMargins(iDip2px, iDip2px, iDip2px, iDip2px);
            imageView.setImageResource(R.mipmap.yd_sdk_ad_dialog_close);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.yp7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f46092a.lambda$addCloseView$1(view);
                }
            });
            this.actionContainer.addView(imageView, layoutParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public void addFillActionView(final View view) {
        if (view == null) {
            return;
        }
        this.adContainer.post(new Runnable() { // from class: com.zj.adlib.wp7
            @Override // java.lang.Runnable
            public final void run() {
                this.f20494a.lambda$addFillActionView$4(view);
            }
        });
    }

    public void destroy() {
        S2SVideoView s2SVideoView = this.videoView;
        if (s2SVideoView != null) {
            s2SVideoView.onDestroy();
        }
    }

    public View load() {
        if (this.templateView == null) {
            InterceptClickLayout interceptClickLayout = (InterceptClickLayout) ViewHelper.inflate(this.mContext, R.layout.s2s_template_view);
            int i = this.horizontalPadding;
            int i2 = this.verticalPadding;
            interceptClickLayout.setPadding(i, i2, i, i2);
            interceptClickLayout.setLayoutParams(new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
            this.adContainer = (FrameLayout) interceptClickLayout.findViewById(R.id.s2s_template_container);
            this.adContainer.addView(this.adView, new FrameLayout.LayoutParams(this.mWidth - (this.horizontalPadding * 2), this.mHeight - (this.verticalPadding * 2)));
            this.templateView = interceptClickLayout;
        }
        return this.templateView;
    }

    public S2STemplateViewHelper setAction(String str) {
        return this;
    }

    public S2STemplateViewHelper setAdLogo(Bitmap bitmap) {
        if (bitmap == null) {
            return this;
        }
        ShaderRoundImageView shaderRoundImageView = new ShaderRoundImageView(this.mContext);
        shaderRoundImageView.setRadius(DeviceUtil.dip2px(2.0f));
        shaderRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        shaderRoundImageView.setAdjustViewBounds(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, DeviceUtil.dip2px(12.0f));
        layoutParams.gravity = 85;
        int iDip2px = DeviceUtil.dip2px(4.0f);
        layoutParams.setMargins(iDip2px, iDip2px, iDip2px, iDip2px);
        shaderRoundImageView.setImageBitmap(bitmap);
        this.actionContainer.addView(shaderRoundImageView, layoutParams);
        return this;
    }

    public S2STemplateViewHelper setDes(String str) {
        ViewHelper.setTextView(this.desView, str);
        return this;
    }

    public S2STemplateViewHelper setLogo(String str) {
        return this;
    }

    public S2STemplateViewHelper setMedia(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return this;
        }
        AdInfoPoJo.Creative creative = adInfoPoJo.creative;
        if (creative == null || !creative.isVideo()) {
            loadImage(adInfoPoJo.img_url);
        } else {
            loadMedia(adInfoPoJo);
        }
        return this;
    }

    public S2STemplateViewHelper setOnClosedListener(Runnable runnable) {
        this.mClosedEvent = runnable;
        return this;
    }

    public S2STemplateViewHelper setPadding(int i, int i2) {
        this.horizontalPadding = i;
        this.verticalPadding = i2;
        return this;
    }

    public S2STemplateViewHelper setSize(int i, int i2) {
        float f;
        int mobileWidth = DeviceUtil.getMobileWidth();
        if (mobileWidth >= i && i > 0) {
            mobileWidth = i;
        }
        this.mWidth = mobileWidth;
        if (this.mType.isFullWidthMedia()) {
            f = 1.78f;
            if (i2 > i) {
                this.mHeight = Math.round(i / f);
            } else {
                if (i2 <= 0) {
                    i2 = Math.round(i / f);
                }
                this.mHeight = i2;
            }
        } else {
            f = 19.0f;
            if (i2 > i) {
                i *= 5;
                this.mHeight = Math.round(i / f);
            } else {
                if (i2 <= 0) {
                    i *= 5;
                    i2 = Math.round(i / f);
                }
                this.mHeight = i2;
            }
        }
        return this;
    }

    public S2STemplateViewHelper setTitle(String str) {
        ViewHelper.setTextView(this.titleView, str);
        return this;
    }
}
