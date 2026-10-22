package com.kwad.components.core.h;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends KSFrameLayout {
    private ImageView cx;

    public b(@NonNull Context context) {
        super(context);
    }

    private ImageView qX() {
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    public final void a(String str, ImageLoadingListener imageLoadingListener) {
        ImageView imageView = this.cx;
        if (imageView != null) {
            ImageLoaderProxy.INSTANCE.load(imageView, str, imageLoadingListener);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void init(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super.init(context, attributeSet);
        this.cx = qX();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.cx, layoutParams);
    }

    public final void setImageGravity(int i) {
        FrameLayout.LayoutParams layoutParams;
        ImageView imageView = this.cx;
        if (imageView == null || (layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.gravity = i;
        this.cx.setLayoutParams(layoutParams);
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.cx;
        if (imageView == null || scaleType == null) {
            return;
        }
        imageView.setScaleType(scaleType);
    }
}
