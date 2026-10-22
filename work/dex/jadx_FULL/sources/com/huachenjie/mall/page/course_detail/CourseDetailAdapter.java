package com.huachenjie.mall.page.course_detail;

import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.databinding.MallItemCourseDetailBinding;
import com.noober.background.drawable.DrawableCreator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0018\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0002R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mall/page/course_detail/CourseDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mall/databinding/MallItemCourseDetailBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "laEpisodeItem", "episodeItem", "e", "", "a", "Z", "f", "()Z", "hasBuy", "<init>", "(Z)V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class CourseDetailAdapter extends BaseQuickAdapter<EpisodeItemBean, BaseDataBindingHolder<MallItemCourseDetailBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean hasBuy;

    public CourseDetailAdapter(boolean z) {
        super(R.layout.mall_item_course_detail, null, 2, null);
        this.hasBuy = z;
    }

    public final void e(@Nullable EpisodeItemBean laEpisodeItem, @NotNull EpisodeItemBean episodeItem) {
        Intrinsics.checkNotNullParameter(episodeItem, "episodeItem");
        if (laEpisodeItem != null) {
            notifyItemChanged(getItemPosition(laEpisodeItem) + getHeaderLayoutCount());
        }
        notifyItemChanged(getItemPosition(episodeItem) + getHeaderLayoutCount());
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final boolean getHasBuy() {
        return this.hasBuy;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MallItemCourseDetailBinding> holder, @NotNull EpisodeItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        MallItemCourseDetailBinding mallItemCourseDetailBinding = (MallItemCourseDetailBinding) holder.getDataBinding();
        if (mallItemCourseDetailBinding != null) {
            if (item.isPlaying()) {
                mallItemCourseDetailBinding.f34986a.playAnimation();
            } else {
                mallItemCourseDetailBinding.f34986a.cancelAnimation();
                mallItemCourseDetailBinding.f34986a.setProgress(0.0f);
            }
            DrawableCreator.Builder solidColor = new DrawableCreator.Builder().setSolidColor(-1);
            int positionType = item.getPositionType();
            if (positionType == 0) {
                solidColor.setCornersRadius(0.0f);
            } else if (positionType == 1) {
                solidColor.setCornersRadius(0.0f, 0.0f, SizeUtils.b(12.0f), SizeUtils.b(12.0f));
            } else if (positionType == 2) {
                solidColor.setCornersRadius(SizeUtils.b(12.0f), SizeUtils.b(12.0f), 0.0f, 0.0f);
            } else if (positionType == 3) {
                solidColor.setCornersRadius(SizeUtils.b(12.0f), SizeUtils.b(12.0f), SizeUtils.b(12.0f), SizeUtils.b(12.0f));
            }
            mallItemCourseDetailBinding.getRoot().setBackground(solidColor.build());
            mallItemCourseDetailBinding.l(item);
            mallItemCourseDetailBinding.m(Boolean.valueOf(this.hasBuy));
            mallItemCourseDetailBinding.executePendingBindings();
        }
    }
}
