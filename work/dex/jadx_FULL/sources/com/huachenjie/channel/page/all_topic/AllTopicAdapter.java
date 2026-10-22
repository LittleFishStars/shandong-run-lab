package com.huachenjie.channel.page.all_topic;

import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.databinding.ChannelItemAllTopicBinding;
import com.huachenjie.channel.page.all_topic.AllTopicAdapter;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/page/all_topic/AllTopicAdapter;", "Lcom/huachenjie/base/adapter/BaseRefreshAdapter;", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemAllTopicBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AllTopicAdapter extends BaseRefreshAdapter<ChannelTopicBean, BaseDataBindingHolder<ChannelItemAllTopicBinding>> implements LoadMoreModule {
    public AllTopicAdapter() {
        super(R.layout.channel_item_all_topic);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.x40
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AllTopicAdapter.t(this.f45742a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void t(AllTopicAdapter allTopicAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(allTopicAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, allTopicAdapter.getItem(i).getSubjectNo()).navigation();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemAllTopicBinding> holder, @NotNull ChannelTopicBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemAllTopicBinding channelItemAllTopicBinding = (ChannelItemAllTopicBinding) holder.getDataBinding();
        if (channelItemAllTopicBinding != null) {
            channelItemAllTopicBinding.k(item);
            channelItemAllTopicBinding.executePendingBindings();
        }
    }
}
