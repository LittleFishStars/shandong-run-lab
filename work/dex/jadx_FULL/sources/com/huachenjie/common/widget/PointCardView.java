package com.huachenjie.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.common.R;
import com.huachenjie.common.widget.PointCardView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/common/widget/PointCardView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "initView", "", "setText", "value", "", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointCardView extends ConstraintLayout {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PointCardView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PointCardView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ PointCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void initView(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PointCardView, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.theme.obtainStyl…,\n            0\n        )");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.PointCardView_pcv_icon, R.drawable.ic_plus);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.PointCardView_pcv_hide_add, false);
        typedArrayObtainStyledAttributes.recycle();
        setBackgroundResource(R.drawable.bg_point_card);
        View.inflate(context, R.layout.view_point_card, this);
        ImageView imageView = (ImageView) findViewById(R.id.point_card_icon);
        if (imageView != null) {
            imageView.setImageResource(resourceId);
        }
        ImageView imageView2 = (ImageView) findViewById(R.id.point_card_add);
        if (imageView2 != null) {
            imageView2.setVisibility(z ? 4 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setText$lambda$3(PointCardView pointCardView, String str) {
        Intrinsics.checkNotNullParameter(pointCardView, "this$0");
        TextView textView = (TextView) pointCardView.findViewById(R.id.point_card_value);
        if (textView != null) {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            textView.setText(str);
        }
    }

    public final void setText(@Nullable final String value) {
        post(new Runnable() { // from class: com.zj.adlib.jt6
            @Override // java.lang.Runnable
            public final void run() {
                PointCardView.setText$lambda$3(this.f42669a, value);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PointCardView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context, attributeSet);
    }
}
