package com.huachenjie.channel.page.channel_main.topic;

import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelTopicBean;
import com.huachenjie.channel.databinding.ChannelItemChannelMainHotTopicBinding;
import com.huachenjie.channel.page.channel_main.topic.ChannelMainHotTopicAdapter;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/topic/ChannelMainHotTopicAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/ChannelTopicBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemChannelMainHotTopicBinding;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelMainHotTopicAdapter extends BaseQuickAdapter<ChannelTopicBean, BaseDataBindingHolder<ChannelItemChannelMainHotTopicBinding>> {
    public ChannelMainHotTopicAdapter() {
        super(R.layout.channel_item_channel_main_hot_topic, null, 2, null);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ni1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChannelMainHotTopicAdapter.f(this.f43529a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void f(ChannelMainHotTopicAdapter channelMainHotTopicAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(channelMainHotTopicAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, channelMainHotTopicAdapter.getItem(i).getSubjectNo()).navigation();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemChannelMainHotTopicBinding> holder, @NotNull ChannelTopicBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemChannelMainHotTopicBinding channelItemChannelMainHotTopicBinding = (ChannelItemChannelMainHotTopicBinding) holder.getDataBinding();
        if (channelItemChannelMainHotTopicBinding != null) {
            channelItemChannelMainHotTopicBinding.k(item);
            channelItemChannelMainHotTopicBinding.executePendingBindings();
        }
    }
}
