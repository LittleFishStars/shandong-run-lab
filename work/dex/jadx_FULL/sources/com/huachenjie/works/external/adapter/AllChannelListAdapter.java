package com.huachenjie.works.external.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksItemAllChannelListBinding;
import com.huachenjie.works.external.adapter.AllChannelListAdapter;
import com.huachenjie.works.external.bean.ChannelBean;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\"\u0010\f\u001a\u00020\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0014R\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/external/adapter/AllChannelListAdapter;", "Lcom/huachenjie/base/adapter/BaseRefreshAdapter;", "Lcom/huachenjie/works/external/bean/ChannelBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemAllChannelListBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "", "width", "", "u", "holder", "item", "convert", "a", "F", "mItemWidth", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public class AllChannelListAdapter extends BaseRefreshAdapter<ChannelBean, BaseDataBindingHolder<WorksItemAllChannelListBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public float mItemWidth;

    public AllChannelListAdapter() {
        super(R.layout.works_item_all_channel_list);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.l40
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AllChannelListAdapter.t(this.f42990a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void t(AllChannelListAdapter allChannelListAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(allChannelListAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", allChannelListAdapter.getData().get(i).getChannelNo()).navigation();
    }

    public final void u(float width) {
        this.mItemWidth = width;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@Nullable BaseDataBindingHolder<WorksItemAllChannelListBinding> holder, @Nullable ChannelBean item) {
        WorksItemAllChannelListBinding worksItemAllChannelListBinding;
        if (holder == null || (worksItemAllChannelListBinding = (WorksItemAllChannelListBinding) holder.getDataBinding()) == null) {
            return;
        }
        worksItemAllChannelListBinding.k(item);
        if (this.mItemWidth > 0.0f) {
            View root = worksItemAllChannelListBinding.getRoot();
            ViewGroup.LayoutParams layoutParams = worksItemAllChannelListBinding.getRoot().getLayoutParams();
            layoutParams.width = MathKt.roundToInt(this.mItemWidth);
            root.setLayoutParams(layoutParams);
        }
        worksItemAllChannelListBinding.executePendingBindings();
    }
}
