package com.huachenjie.run.page.run_index.adapter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.run.R;
import com.zj.adlib.DeductionTip;
import com.zj.adlib.jj8;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/run/page/run_index/adapter/RunIndexDeductionAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/zj/adlib/s82;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "roundStart", "roundEnd", "Landroid/graphics/drawable/GradientDrawable;", "e", "", "K", "I", "gap", "", "a", "F", "radius", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunIndexDeductionAdapter extends BaseQuickAdapter<DeductionTip, BaseViewHolder> {
    public static final float b = 20.0f;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int gap;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final float radius;

    public RunIndexDeductionAdapter() {
        super(R.layout.run_item_index_deduction, null, 2, null);
        this.gap = jj8.a(1.0f);
        this.radius = jj8.a(10.0f);
    }

    public final GradientDrawable e(boolean roundStart, boolean roundEnd) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        float f = roundStart ? this.radius : 0.0f;
        float f2 = roundEnd ? this.radius : 0.0f;
        gradientDrawable.setCornerRadii(new float[]{f, f, f2, f2, f2, f2, f, f});
        return gradientDrawable;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseViewHolder holder, @NotNull DeductionTip item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        View view = holder.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) view;
        int bindingAdapterPosition = holder.getBindingAdapterPosition();
        int lastIndex = CollectionsKt.getLastIndex(getData());
        textView.setText(item.e());
        textView.setBackground(e(bindingAdapterPosition == 0, bindingAdapterPosition == lastIndex));
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(bindingAdapterPosition != lastIndex ? this.gap : 0);
    }
}
