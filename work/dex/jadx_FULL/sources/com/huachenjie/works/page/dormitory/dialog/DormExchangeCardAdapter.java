package com.huachenjie.works.page.dormitory.dialog;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.dorm.DormExchangeCardBean;
import com.huachenjie.works.databinding.WorksItemDormExchangeCardBinding;
import com.noober.background.view.BLLinearLayout;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u000b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u0002R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/works/page/dormitory/dialog/DormExchangeCardAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/dorm/DormExchangeCardBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemDormExchangeCardBinding;", "", "position", "", "e", "holder", "item", "convert", "", "", "payloads", "Lcom/noober/background/view/BLLinearLayout;", "card", "", "isSelected", "f", "color", y6b.f, "K", "I", "selectedPosition", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class DormExchangeCardAdapter extends BaseQuickAdapter<DormExchangeCardBean, BaseDataBindingHolder<WorksItemDormExchangeCardBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selectedPosition;

    public DormExchangeCardAdapter() {
        super(R.layout.works_item_dorm_exchange_card, null, 2, null);
    }

    public final void e(int position) {
        int i = this.selectedPosition;
        this.selectedPosition = position;
        Boolean bool = Boolean.TRUE;
        notifyItemChanged(i, bool);
        notifyItemChanged(this.selectedPosition, bool);
    }

    public final void f(BLLinearLayout card, boolean isSelected) {
        Drawable background = card.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (isSelected) {
            gradientDrawable.setStroke(SizeUtils.b(2.0f), ContextCompat.getColor(card.getContext(), R.color.color_0BD3FF));
            gradientDrawable.setColor(Color.parseColor("#260BD3FF"));
            g(card, RunIndexRecordAdapter.P);
        } else {
            gradientDrawable.setStroke(SizeUtils.b(2.0f), ContextCompat.getColor(card.getContext(), R.color.color_E8E8E8));
            gradientDrawable.setColor(ContextCompat.getColor(card.getContext(), R.color.white));
            g(card, RunIndexRecordAdapter.K);
        }
    }

    public final void g(BLLinearLayout card, int color) {
        int childCount = card.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = card.getChildAt(i);
            if (childAt instanceof TextView) {
                ((TextView) childAt).setTextColor(color);
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, DormExchangeCardBean dormExchangeCardBean, List list) {
        convert((BaseDataBindingHolder<WorksItemDormExchangeCardBinding>) baseViewHolder, dormExchangeCardBean, (List<? extends Object>) list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemDormExchangeCardBinding> holder, @NotNull DormExchangeCardBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (getData().size() >= 3) {
            holder.itemView.getLayoutParams().width = SizeUtils.b(80.0f);
        } else if (getData().size() == 2) {
            holder.itemView.getLayoutParams().width = SizeUtils.b(120.0f);
        } else {
            holder.itemView.getLayoutParams().width = SizeUtils.b(252.0f);
        }
        WorksItemDormExchangeCardBinding worksItemDormExchangeCardBinding = (WorksItemDormExchangeCardBinding) holder.getDataBinding();
        if (worksItemDormExchangeCardBinding != null) {
            worksItemDormExchangeCardBinding.f37025a.setText(item.getPerksName());
            worksItemDormExchangeCardBinding.b.setText(String.valueOf(item.getCharmCost()));
            boolean z = holder.getBindingAdapterPosition() == this.selectedPosition;
            BLLinearLayout bLLinearLayout = worksItemDormExchangeCardBinding.f14556a;
            Intrinsics.checkNotNullExpressionValue(bLLinearLayout, "llCard");
            f(bLLinearLayout, z);
            worksItemDormExchangeCardBinding.executePendingBindings();
        }
    }

    public void convert(@NotNull BaseDataBindingHolder<WorksItemDormExchangeCardBinding> holder, @NotNull DormExchangeCardBean item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        WorksItemDormExchangeCardBinding worksItemDormExchangeCardBinding = (WorksItemDormExchangeCardBinding) holder.getDataBinding();
        if (worksItemDormExchangeCardBinding != null) {
            boolean z = holder.getBindingAdapterPosition() == this.selectedPosition;
            BLLinearLayout bLLinearLayout = worksItemDormExchangeCardBinding.f14556a;
            Intrinsics.checkNotNullExpressionValue(bLLinearLayout, "llCard");
            f(bLLinearLayout, z);
            worksItemDormExchangeCardBinding.executePendingBindings();
        }
    }
}
