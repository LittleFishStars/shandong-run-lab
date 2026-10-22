package com.huachenjie.sport.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.HuodongStatus;
import com.zj.adlib.p34;
import com.zj.adlib.xf7;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B\u001b\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b&\u0010*B#\b\u0016\u0012\u0006\u0010%\u001a\u00020$\u0012\b\u0010)\u001a\u0004\u0018\u00010(\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b&\u0010,J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\b\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002R\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/huachenjie/sport/widget/HuodongStatusWidget;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "status", "", "setStatus", "Lcom/huachenjie/sport/page/mine/huodong/HuodongStatus;", "huodongStatus", "C", "argb", "Landroid/graphics/drawable/Drawable;", "drawable", "", "str", "D", "Landroid/view/View;", "vBg", "Landroid/view/View;", "getVBg", "()Landroid/view/View;", "setVBg", "(Landroid/view/View;)V", "Landroid/widget/ImageView;", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "setIvIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "setTv", "(Landroid/widget/TextView;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongStatusWidget extends ConstraintLayout {
    public ImageView ivIcon;
    public TextView tv;
    public View vBg;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36748a;

        static {
            int[] iArr = new int[HuodongStatus.values().length];
            try {
                iArr[HuodongStatus.sign_not_start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HuodongStatus.sign_in_progress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HuodongStatus.sign_finish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HuodongStatus.huodong_in_progress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HuodongStatus.huodong_finish.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HuodongStatus.huodong_stop.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f36748a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HuodongStatusWidget(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void C() {
        View.inflate(getContext(), R.layout.widget_huodong_status, this);
        View viewFindViewById = findViewById(R.id.v_bg);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.v_bg)");
        setVBg(viewFindViewById);
        View viewFindViewById2 = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById<ImageView>(R.id.iv_icon)");
        setIvIcon((ImageView) viewFindViewById2);
        View viewFindViewById3 = findViewById(R.id.tv);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById<TextView>(R.id.tv)");
        setTv((TextView) viewFindViewById3);
    }

    public final void D(@ColorInt int argb, Drawable drawable, String str) {
        Drawable background = getVBg().getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(argb);
        getIvIcon().setImageDrawable(drawable);
        getTv().setText(str);
    }

    @NotNull
    public final ImageView getIvIcon() {
        ImageView imageView = this.ivIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
        return null;
    }

    @NotNull
    public final TextView getTv() {
        TextView textView = this.tv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tv");
        return null;
    }

    @NotNull
    public final View getVBg() {
        View view = this.vBg;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("vBg");
        return null;
    }

    public final void setIvIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivIcon = imageView;
    }

    public final void setStatus(int status) {
        setStatus(p34.f43883a.b(status));
    }

    public final void setTv(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tv = textView;
    }

    public final void setVBg(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.vBg = view;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HuodongStatusWidget(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setStatus(@Nullable HuodongStatus huodongStatus) {
        if (huodongStatus == null || this.vBg == null) {
            return;
        }
        switch (a.f36748a[huodongStatus.ordinal()]) {
            case 1:
                int iA = zn1.a(R.color.color_8997A4);
                Drawable drawableF = xf7.f(R.drawable.ic_sign_not_start);
                Intrinsics.checkNotNullExpressionValue(drawableF, "getDrawable(R.drawable.ic_sign_not_start)");
                D(iA, drawableF, huodongStatus.getContent());
                break;
            case 2:
                int iA2 = zn1.a(R.color.color_00C97C);
                Drawable drawableF2 = xf7.f(R.drawable.ic_sign_in_progress);
                Intrinsics.checkNotNullExpressionValue(drawableF2, "getDrawable(R.drawable.ic_sign_in_progress)");
                D(iA2, drawableF2, huodongStatus.getContent());
                break;
            case 3:
                int iA3 = zn1.a(R.color.color_8997A4);
                Drawable drawableF3 = xf7.f(R.drawable.ic_sign_huodong_finish);
                Intrinsics.checkNotNullExpressionValue(drawableF3, "getDrawable(R.drawable.ic_sign_huodong_finish)");
                D(iA3, drawableF3, huodongStatus.getContent());
                break;
            case 4:
                int iA4 = zn1.a(R.color.color_FF762F);
                Drawable drawableF4 = xf7.f(R.drawable.ic_huodong_in_progress);
                Intrinsics.checkNotNullExpressionValue(drawableF4, "getDrawable(R.drawable.ic_huodong_in_progress)");
                D(iA4, drawableF4, huodongStatus.getContent());
                break;
            case 5:
                int iA5 = zn1.a(R.color.color_8997A4);
                Drawable drawableF5 = xf7.f(R.drawable.ic_sign_huodong_finish);
                Intrinsics.checkNotNullExpressionValue(drawableF5, "getDrawable(R.drawable.ic_sign_huodong_finish)");
                D(iA5, drawableF5, huodongStatus.getContent());
                break;
            case 6:
                int iA6 = zn1.a(R.color.color_8997A4);
                Drawable drawableF6 = xf7.f(R.drawable.ic_sign_huodong_finish);
                Intrinsics.checkNotNullExpressionValue(drawableF6, "getDrawable(R.drawable.ic_sign_huodong_finish)");
                D(iA6, drawableF6, huodongStatus.getContent());
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HuodongStatusWidget(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        C();
    }
}
