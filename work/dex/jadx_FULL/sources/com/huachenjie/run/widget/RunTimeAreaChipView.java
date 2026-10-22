package com.huachenjie.run.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.run.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0003J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/run/widget/RunTimeAreaChipView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isMorningRun", "", "mContent", "", "mData", "Lcom/huachenjie/common/bean/RunTimeAreaData;", "mRoot", "Landroid/view/View;", "mTv", "Landroid/widget/TextView;", "mTvTag", "bindData", "", "data", "initView", "onClick", "v", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RunTimeAreaChipView extends LinearLayout implements View.OnClickListener {
    private boolean isMorningRun;

    @Nullable
    private String mContent;

    @Nullable
    private RunTimeAreaData mData;

    @Nullable
    private View mRoot;

    @Nullable
    private TextView mTv;

    @Nullable
    private TextView mTvTag;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunTimeAreaChipView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunTimeAreaChipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RunTimeAreaChipView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @SuppressLint({"SetTextI18n"})
    private final void initView(Context context, AttributeSet attrs) {
        View viewInflate = View.inflate(context, R.layout.run_layout_run_time_area_view, this);
        this.mRoot = viewInflate;
        if (viewInflate != null) {
            viewInflate.setOnClickListener(this);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.run_RunTimeAreaChipView);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….run_RunTimeAreaChipView)");
        this.isMorningRun = typedArrayObtainStyledAttributes.getBoolean(R.styleable.run_RunTimeAreaChipView_run_chipIsMorning, false);
        this.mContent = typedArrayObtainStyledAttributes.getString(R.styleable.run_RunTimeAreaChipView_run_chipContent);
        View view = this.mRoot;
        this.mTv = view != null ? (TextView) view.findViewById(R.id.tvTime) : null;
        View view2 = this.mRoot;
        this.mTvTag = view2 != null ? (TextView) view2.findViewById(R.id.tvMorningTag) : null;
        TextView textView = this.mTv;
        if (textView != null) {
            textView.setText(this.mContent);
        }
        TextView textView2 = this.mTvTag;
        if (textView2 != null) {
            textView2.setVisibility(this.isMorningRun ? 0 : 8);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void bindData(@Nullable RunTimeAreaData data) {
        this.mData = data;
        if (data != null) {
            TextView textView = this.mTvTag;
            if (textView != null) {
                textView.setVisibility(1 == data.getTagType() ? 0 : 8);
            }
            TextView textView2 = this.mTv;
            if (textView2 != null) {
                textView2.setBackgroundResource(0);
            }
            TextView textView3 = this.mTv;
            if (textView3 != null) {
                textView3.setTextColor(getResources().getColor(R.color.color_191F20));
            }
            TextView textView4 = this.mTv;
            if (textView4 == null) {
                return;
            }
            textView4.setText(data.getTimes());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v) {
        Intrinsics.areEqual(v, this.mRoot);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RunTimeAreaChipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context, attributeSet);
    }
}
