package com.huachenjie.run.page.rankinglist;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RankItemData;
import com.huachenjie.run.databinding.RunItemSunshineRankingBinding;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J/\u0010\u000e\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/run/page/rankinglist/SunshineRankingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/RankItemData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemSunshineRankingBinding;", "holder", "item", "", "convert", "", "rankingType", "rankingListType", "", "data", "e", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/Collection;)V", "K", "I", "L", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class SunshineRankingAdapter extends BaseQuickAdapter<RankItemData, BaseDataBindingHolder<RunItemSunshineRankingBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int rankingType;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int rankingListType;

    public SunshineRankingAdapter() {
        super(R.layout.run_item_sunshine_ranking, null, 2, null);
        this.rankingType = 1;
        this.rankingListType = 1;
    }

    public final void e(@Nullable Integer rankingType, @Nullable Integer rankingListType, @NotNull Collection<RankItemData> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.rankingType = rankingType != null ? rankingType.intValue() : 2;
        this.rankingListType = rankingListType != null ? rankingListType.intValue() : 2;
        setList(data);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemSunshineRankingBinding> holder, @NotNull RankItemData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        RunItemSunshineRankingBinding runItemSunshineRankingBinding = (RunItemSunshineRankingBinding) holder.getDataBinding();
        if (runItemSunshineRankingBinding != null) {
            runItemSunshineRankingBinding.o(item);
            runItemSunshineRankingBinding.n(Integer.valueOf(this.rankingType));
            runItemSunshineRankingBinding.m(Integer.valueOf(this.rankingListType));
            runItemSunshineRankingBinding.executePendingBindings();
        }
    }
}
