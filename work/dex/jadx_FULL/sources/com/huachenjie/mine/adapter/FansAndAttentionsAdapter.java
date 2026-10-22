package com.huachenjie.mine.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.external.bean.FansBean;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineItemFansAndAttentionBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mine/adapter/FansAndAttentionsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/external/bean/FansBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/mine/databinding/MineItemFansAndAttentionBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "", "a", "Z", "showFollowMenu", "c", "isAttentionPage", "<init>", "(ZZ)V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class FansAndAttentionsAdapter extends BaseQuickAdapter<FansBean, BaseDataBindingHolder<MineItemFansAndAttentionBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean showFollowMenu;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean isAttentionPage;

    /* JADX WARN: Illegal instructions before constructor call */
    public FansAndAttentionsAdapter() {
        boolean z = false;
        this(z, z, 3, null);
    }

    public /* synthetic */ FansAndAttentionsAdapter(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FansAndAttentionsAdapter(boolean z, boolean z2) {
        List list = null;
        super(R.layout.mine_item_fans_and_attention, list, 2, list);
        this.showFollowMenu = z;
        this.isAttentionPage = z2;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<MineItemFansAndAttentionBinding> holder, @NotNull FansBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        item.setAttentionPage(this.isAttentionPage);
        MineItemFansAndAttentionBinding mineItemFansAndAttentionBinding = (MineItemFansAndAttentionBinding) holder.getDataBinding();
        if (mineItemFansAndAttentionBinding != null) {
            mineItemFansAndAttentionBinding.l(item);
            mineItemFansAndAttentionBinding.m(Boolean.valueOf(this.showFollowMenu));
            Drawable background = mineItemFansAndAttentionBinding.f11326a.getBackground();
            GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(getContext().getResources().getColor(item.getEachFollow() ? R.color.color_c1c1c1 : R.color.color_650aec));
            }
            mineItemFansAndAttentionBinding.executePendingBindings();
        }
    }
}
