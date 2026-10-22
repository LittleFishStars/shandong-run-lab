package com.huachenjie.home.page.reward_record;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeItemRewardRecordBinding;
import com.zj.adlib.xk0;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/home/page/reward_record/RewardRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/home/databinding/HomeItemRewardRecordBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", "f", "()I", "SIZE_DP16", "", "b", y6b.f, "()F", "SIZE_DP20", "c", y6b.g, "SIZE_DP24", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class RewardRecordAdapter extends BaseQuickAdapter<RewardInfoBean, BaseDataBindingHolder<HomeItemRewardRecordBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP16;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP20;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP24;

    public RewardRecordAdapter() {
        super(R.layout.home_item_reward_record, null, 2, null);
        this.SIZE_DP16 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordAdapter$SIZE_DP16$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m431invoke() {
                return Integer.valueOf(SizeUtils.b(16.0f));
            }
        });
        this.SIZE_DP20 = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordAdapter$SIZE_DP20$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m432invoke() {
                return Float.valueOf(SizeUtils.b(20.0f));
            }
        });
        this.SIZE_DP24 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.reward_record.RewardRecordAdapter$SIZE_DP24$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m433invoke() {
                return Integer.valueOf(SizeUtils.b(24.0f));
            }
        });
    }

    public final int f() {
        return ((Number) this.SIZE_DP16.getValue()).intValue();
    }

    public final float g() {
        return ((Number) this.SIZE_DP20.getValue()).floatValue();
    }

    public final int h() {
        return ((Number) this.SIZE_DP24.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<HomeItemRewardRecordBinding> holder, @NotNull RewardInfoBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        HomeItemRewardRecordBinding homeItemRewardRecordBinding = (HomeItemRewardRecordBinding) holder.getDataBinding();
        if (homeItemRewardRecordBinding != null) {
            item.setPosition(holder.getBindingAdapterPosition() - 1);
            Drawable background = holder.itemView.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            if (item.getPosition() == getData().size() - 1) {
                holder.itemView.setPadding(f(), 0, f(), h());
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, g(), g(), g(), g()});
            } else {
                holder.itemView.setPadding(f(), 0, f(), f());
                gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            }
            holder.itemView.setBackground(gradientDrawable);
            homeItemRewardRecordBinding.setVariable(xk0.g, item);
            homeItemRewardRecordBinding.executePendingBindings();
        }
    }
}
