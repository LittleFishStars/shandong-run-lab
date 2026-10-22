package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0014J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\b\u0010\u0014\u001a\u00020\rH\u0003J\b\u0010\u0015\u001a\u00020\rH\u0002J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/common/widget/AnimatedWebpImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animResId", "animatedDrawable", "Landroid/graphics/drawable/AnimatedImageDrawable;", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityAggregated", "isVisible", "", "pauseAnim", "playAnim", "playSystemAnim", "releaseAnim", "resolveAnimResId", "setImageResource", "resId", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimatedWebpImageView extends AppCompatImageView {

    @NotNull
    private static final String ATTR_SRC = "src";

    @NotNull
    private static final String ATTR_SRC_COMPAT = "srcCompat";
    private int animResId;

    @Nullable
    private AnimatedImageDrawable animatedDrawable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatedWebpImageView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatedWebpImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnimatedWebpImageView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void pauseAnim() {
        if (Build.VERSION.SDK_INT < 28) {
            Glide.with(getContext().getApplicationContext()).clear(this);
            return;
        }
        AnimatedImageDrawable animatedImageDrawable = this.animatedDrawable;
        if (animatedImageDrawable != null) {
            animatedImageDrawable.stop();
        }
    }

    private final void playAnim() throws IOException {
        if (this.animResId == 0 || isInEditMode()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            playSystemAnim();
        } else {
            Glide.with(this).load(Integer.valueOf(this.animResId)).into(this);
        }
    }

    @RequiresApi(28)
    private final void playSystemAnim() throws IOException {
        AnimatedImageDrawable animatedImageDrawable = this.animatedDrawable;
        if (animatedImageDrawable != null) {
            if (animatedImageDrawable.isRunning()) {
                return;
            }
            animatedImageDrawable.setRepeatCount(-1);
            animatedImageDrawable.start();
            return;
        }
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), this.animResId));
        Intrinsics.checkNotNullExpressionValue(drawableDecodeDrawable, "decodeDrawable(\n        …ces, animResId)\n        )");
        if (!(drawableDecodeDrawable instanceof AnimatedImageDrawable)) {
            setImageDrawable(drawableDecodeDrawable);
            return;
        }
        AnimatedImageDrawable animatedImageDrawable2 = (AnimatedImageDrawable) drawableDecodeDrawable;
        this.animatedDrawable = animatedImageDrawable2;
        animatedImageDrawable2.setRepeatCount(-1);
        setImageDrawable(drawableDecodeDrawable);
        animatedImageDrawable2.start();
    }

    private final void releaseAnim() {
        pauseAnim();
        this.animatedDrawable = null;
        setImageDrawable(null);
    }

    private final int resolveAnimResId(AttributeSet attrs) {
        int attributeResourceValue;
        if (attrs == null) {
            return 0;
        }
        int attributeCount = attrs.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attrs.getAttributeName(i);
            if ((Intrinsics.areEqual(attributeName, ATTR_SRC) ? true : Intrinsics.areEqual(attributeName, ATTR_SRC_COMPAT)) && (attributeResourceValue = attrs.getAttributeResourceValue(i, 0)) != 0) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() throws IOException {
        super.onAttachedToWindow();
        playAnim();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        pauseAnim();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onVisibilityAggregated(boolean isVisible) throws IOException {
        super.onVisibilityAggregated(isVisible);
        if (isVisible) {
            playAnim();
        } else {
            pauseAnim();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int resId) throws IOException {
        if (resId != this.animResId || (this.animatedDrawable == null && getDrawable() == null)) {
            releaseAnim();
            this.animResId = resId;
            if (isAttachedToWindow()) {
                playAnim();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnimatedWebpImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        int iResolveAnimResId = resolveAnimResId(attributeSet);
        this.animResId = iResolveAnimResId;
        if (iResolveAnimResId != 0) {
            setImageDrawable(null);
        }
    }
}
