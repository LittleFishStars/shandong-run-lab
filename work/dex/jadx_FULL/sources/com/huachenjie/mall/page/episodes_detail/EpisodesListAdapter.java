package com.huachenjie.mall.page.episodes_detail;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.databinding.MallItemEpisodesListBinding;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.ar6;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tR\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemEpisodesListBinding;", "holder", "item", "", "convert", "", "lastEpisodeItemNo", "episodeItemNo", "e", "", "a", "Z", "f", "()Z", "hasBuy", "<init>", "(Z)V", "mall_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nEpisodesListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EpisodesListAdapter.kt\ncom/huachenjie/mall/page/episodes_detail/EpisodesListAdapter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,65:1\n1864#2,3:66\n*S KotlinDebug\n*F\n+ 1 EpisodesListAdapter.kt\ncom/huachenjie/mall/page/episodes_detail/EpisodesListAdapter\n*L\n59#1:66,3\n*E\n"})
public final class EpisodesListAdapter extends BaseQuickAdapter<EpisodeItemBean, BaseDataBindingHolder<MallItemEpisodesListBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean hasBuy;

    /* JADX WARN: Illegal instructions before constructor call */
    public EpisodesListAdapter(boolean z) {
        List list = null;
        super(R.layout.mall_item_episodes_list, list, 2, list);
        this.hasBuy = z;
    }

    public final void e(@Nullable String lastEpisodeItemNo, @Nullable String episodeItemNo) {
        int i = 0;
        for (Object obj : getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            EpisodeItemBean episodeItemBean = (EpisodeItemBean) obj;
            if (Intrinsics.areEqual(episodeItemBean.getEpisodeItemNo(), lastEpisodeItemNo) || Intrinsics.areEqual(episodeItemBean.getEpisodeItemNo(), episodeItemNo)) {
                notifyItemChanged(i);
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getHasBuy() {
        return this.hasBuy;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemEpisodesListBinding> holder, @NotNull EpisodeItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemEpisodesListBinding mallItemEpisodesListBinding = (MallItemEpisodesListBinding) holder.getDataBinding();
        if (mallItemEpisodesListBinding != null) {
            DrawableCreator.Builder cornersRadius = new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(8.0f));
            DrawableCreator.Builder strokeWidth = new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(8.0f), 0.0f, 0.0f, SizeUtils.b(8.0f)).setStrokeColor(-10155284).setStrokeWidth(SizeUtils.b(1.0f));
            if (item.isPlaying()) {
                cornersRadius.setSolidColor(-10155284);
                strokeWidth.setSolidColor(-1);
                mallItemEpisodesListBinding.f34988a.playAnimation();
            } else {
                cornersRadius.setSolidColor(ar6.E);
                strokeWidth.setSolidColor(-10155284);
                mallItemEpisodesListBinding.f34988a.cancelAnimation();
                mallItemEpisodesListBinding.f34988a.setProgress(0.0f);
            }
            mallItemEpisodesListBinding.getRoot().setBackground(cornersRadius.build());
            mallItemEpisodesListBinding.f10767a.setBackground(strokeWidth.build());
            mallItemEpisodesListBinding.l(item);
            mallItemEpisodesListBinding.m(Boolean.valueOf(this.hasBuy));
            mallItemEpisodesListBinding.executePendingBindings();
        }
    }
}
