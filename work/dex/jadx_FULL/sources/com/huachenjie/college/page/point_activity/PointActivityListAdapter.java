package com.huachenjie.college.page.point_activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.college.R;
import com.huachenjie.college.bean.PointActivityBean;
import com.huachenjie.college.databinding.CollegeItemPointActivityListBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/college/page/point_activity/PointActivityListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/college/bean/PointActivityBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/college/databinding/CollegeItemPointActivityListBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "college_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPointActivityListAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PointActivityListAdapter.kt\ncom/huachenjie/college/page/point_activity/PointActivityListAdapter\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,33:1\n470#2:34\n*S KotlinDebug\n*F\n+ 1 PointActivityListAdapter.kt\ncom/huachenjie/college/page/point_activity/PointActivityListAdapter\n*L\n28#1:34\n*E\n"})
public final class PointActivityListAdapter extends BaseQuickAdapter<PointActivityBean, BaseDataBindingHolder<CollegeItemPointActivityListBinding>> implements LoadMoreModule {
    public PointActivityListAdapter() {
        super(R.layout.college_item_point_activity_list, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<CollegeItemPointActivityListBinding> holder, @NotNull PointActivityBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        CollegeItemPointActivityListBinding collegeItemPointActivityListBinding = (CollegeItemPointActivityListBinding) holder.getDataBinding();
        if (collegeItemPointActivityListBinding != null) {
            collegeItemPointActivityListBinding.k(item);
            Drawable background = collegeItemPointActivityListBinding.f8407a.getBackground();
            Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) background).setColor(Color.parseColor(item.formatterStatusBgColor()));
            collegeItemPointActivityListBinding.executePendingBindings();
        }
    }
}
