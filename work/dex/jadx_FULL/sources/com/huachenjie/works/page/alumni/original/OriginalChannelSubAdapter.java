package com.huachenjie.works.page.alumni.original;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.OriginalChannelHotspotBean;
import com.huachenjie.works.databinding.WorksItemOrginalChannelSubBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/alumni/original/OriginalChannelSubAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/OriginalChannelHotspotBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemOrginalChannelSubBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", "f", "()I", "picWidthDp", "", "Z", y6b.f, "()Z", y6b.g, "(Z)V", "isNewTab", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class OriginalChannelSubAdapter extends BaseQuickAdapter<OriginalChannelHotspotBean, BaseDataBindingHolder<WorksItemOrginalChannelSubBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy picWidthDp;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isNewTab;

    public OriginalChannelSubAdapter() {
        super(R.layout.works_item_orginal_channel_sub, null, 2, null);
        this.picWidthDp = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.original.OriginalChannelSubAdapter$picWidthDp$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m854invoke() {
                return Integer.valueOf((int) ((fx7.j() - SizeUtils.b(75.0f)) / 3.0f));
            }
        });
    }

    public final int f() {
        return ((Number) this.picWidthDp.getValue()).intValue();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getIsNewTab() {
        return this.isNewTab;
    }

    public final void h(boolean z) {
        this.isNewTab = z;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemOrginalChannelSubBinding> holder, @NotNull OriginalChannelHotspotBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        item.setPicWidthDp(f());
        item.setPosition(holder.getBindingAdapterPosition());
        item.setNewTab(this.isNewTab);
        int rankUrl = item.formatRankUrl();
        WorksItemOrginalChannelSubBinding worksItemOrginalChannelSubBinding = (WorksItemOrginalChannelSubBinding) holder.getDataBinding();
        if (worksItemOrginalChannelSubBinding != null) {
            if (this.isNewTab) {
                worksItemOrginalChannelSubBinding.f14604b.setVisibility(8);
            } else if (rankUrl >= 0) {
                worksItemOrginalChannelSubBinding.f37041a.setImageResource(rankUrl);
                worksItemOrginalChannelSubBinding.f14604b.setVisibility(4);
            } else if (item.showTextRank()) {
                worksItemOrginalChannelSubBinding.f14604b.setVisibility(0);
            } else {
                worksItemOrginalChannelSubBinding.f14604b.setVisibility(8);
            }
            worksItemOrginalChannelSubBinding.k(item);
            worksItemOrginalChannelSubBinding.executePendingBindings();
        }
    }
}
