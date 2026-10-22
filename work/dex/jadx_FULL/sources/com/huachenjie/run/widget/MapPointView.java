package com.huachenjie.run.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.huachenjie.run.R;
import com.zj.adlib.jj8;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0015\u001a\u00020\u0016H\u0014J\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/huachenjie/run/widget/MapPointView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "guideView", "Landroid/widget/ImageView;", "labelView", "Landroid/widget/TextView;", "nameView", "getNameView", "()Landroid/widget/TextView;", "setNameView", "(Landroid/widget/TextView;)V", "nfcView", "getNfcView", "setNfcView", "bindViews", "", "setGuideFrame", "index", "setName", "name", "", "setText", "text", "showNFC", "", "Companion", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMapPointView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapPointView.kt\ncom/huachenjie/run/widget/MapPointView\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,77:1\n262#2,2:78\n262#2,2:80\n262#2,2:82\n262#2,2:84\n262#2,2:86\n*S KotlinDebug\n*F\n+ 1 MapPointView.kt\ncom/huachenjie/run/widget/MapPointView\n*L\n47#1:78,2\n53#1:80,2\n54#1:82,2\n56#1:84,2\n63#1:86,2\n*E\n"})
public class MapPointView extends FrameLayout {
    private static final float GUIDE_BASE_MARGIN_DP = 58.0f;

    @Nullable
    private ImageView guideView;

    @Nullable
    private TextView labelView;
    protected TextView nameView;

    @Nullable
    private TextView nfcView;

    @NotNull
    private static final float[] GUIDE_OFFSET_DP = {0.0f, -4.0f, -8.0f, -11.0f, -8.0f, -4.0f, 0.0f, 4.0f, 8.0f, 4.0f};

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MapPointView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MapPointView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MapPointView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void bindViews() {
        View.inflate(getContext(), R.layout.run_layout_map_point_view, this);
        View viewFindViewById = findViewById(R.id.tvName);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.tvName)");
        setNameView((TextView) viewFindViewById);
        this.nfcView = (TextView) findViewById(R.id.tvNFC);
        this.labelView = (TextView) findViewById(R.id.tvText);
        this.guideView = (ImageView) findViewById(R.id.ivGuide);
    }

    @NotNull
    public final TextView getNameView() {
        TextView textView = this.nameView;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameView");
        return null;
    }

    @Nullable
    public final TextView getNfcView() {
        return this.nfcView;
    }

    public final void setGuideFrame(int index) {
        ImageView imageView = this.guideView;
        if (imageView == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null) {
            return;
        }
        imageView.setVisibility(0);
        float[] fArr = GUIDE_OFFSET_DP;
        marginLayoutParams.bottomMargin = jj8.a(GUIDE_BASE_MARGIN_DP - fArr[RangesKt.coerceIn(index, ArraysKt.getIndices(fArr))]);
        imageView.setLayoutParams(marginLayoutParams);
    }

    public final void setName(@Nullable String name) {
        if (name == null || name.length() == 0) {
            return;
        }
        getNameView().setVisibility(0);
        getNameView().setText(name);
    }

    public final void setNameView(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameView = textView;
    }

    public final void setNfcView(@Nullable TextView textView) {
        this.nfcView = textView;
    }

    public final void setText(@Nullable String text) {
        TextView textView = this.labelView;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    public final void showNFC(boolean showNFC) {
        if (!showNFC) {
            TextView textView = this.nfcView;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        getNameView().setVisibility(8);
        TextView textView2 = this.nfcView;
        if (textView2 == null) {
            return;
        }
        textView2.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MapPointView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        bindViews();
    }
}
