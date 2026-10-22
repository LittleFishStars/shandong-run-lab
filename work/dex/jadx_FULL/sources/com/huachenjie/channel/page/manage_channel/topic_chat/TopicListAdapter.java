package com.huachenjie.channel.page.manage_channel.topic_chat;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.manage_topic_chat.ManageTopic;
import com.huachenjie.channel.databinding.ChannelItemTopicListBinding;
import com.zj.adlib.tk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/manage_channel/topic_chat/TopicListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/manage_topic_chat/ManageTopic;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemTopicListBinding;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopicListAdapter extends BaseQuickAdapter<ManageTopic, BaseDataBindingHolder<ChannelItemTopicListBinding>> {
    public TopicListAdapter() {
        super(R.layout.channel_item_topic_list, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemTopicListBinding> holder, @NotNull ManageTopic item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemTopicListBinding channelItemTopicListBinding = (ChannelItemTopicListBinding) holder.getDataBinding();
        if (channelItemTopicListBinding != null) {
            channelItemTopicListBinding.setVariable(tk0.g, item);
            channelItemTopicListBinding.executePendingBindings();
        }
    }
}
