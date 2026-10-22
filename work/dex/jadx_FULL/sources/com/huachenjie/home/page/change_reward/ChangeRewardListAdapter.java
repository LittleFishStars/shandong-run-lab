package com.huachenjie.home.page.change_reward;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.reward.AwardListBean;
import com.huachenjie.home.databinding.HomeItemChangeRewardListBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/home/page/change_reward/ChangeRewardListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/home/bean/reward/AwardListBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/home/databinding/HomeItemChangeRewardListBinding;", "holder", "item", "", "convert", "", "K", "I", "jackpotType", "<init>", "(I)V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class ChangeRewardListAdapter extends BaseQuickAdapter<AwardListBean, BaseDataBindingHolder<HomeItemChangeRewardListBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int jackpotType;

    /* JADX WARN: Illegal instructions before constructor call */
    public ChangeRewardListAdapter(int i) {
        List list = null;
        super(R.layout.home_item_change_reward_list, list, 2, list);
        this.jackpotType = i;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<HomeItemChangeRewardListBinding> holder, @NotNull AwardListBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        HomeItemChangeRewardListBinding homeItemChangeRewardListBinding = (HomeItemChangeRewardListBinding) holder.getDataBinding();
        if (homeItemChangeRewardListBinding != null) {
            homeItemChangeRewardListBinding.l(item);
            homeItemChangeRewardListBinding.m(Integer.valueOf(this.jackpotType));
            homeItemChangeRewardListBinding.executePendingBindings();
        }
    }
}
