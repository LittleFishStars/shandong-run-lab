package com.huachenjie.channel.page.channel_main.organize;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelItemChannelMainHotOrganizeBinding;
import com.huachenjie.channel.page.channel_main.organize.ChannelMainHotOrganizeAdapter;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity;
import com.zj.adlib.y57;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/channel_main/organize/ChannelMainHotOrganizeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemChannelMainHotOrganizeBinding;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChannelMainHotOrganizeAdapter extends BaseQuickAdapter<OrganizeBean, BaseDataBindingHolder<ChannelItemChannelMainHotOrganizeBinding>> {
    public ChannelMainHotOrganizeAdapter() {
        super(R.layout.channel_item_channel_main_hot_organize, null, 2, null);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.mi1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ChannelMainHotOrganizeAdapter.f(this.f43309a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void f(ChannelMainHotOrganizeAdapter channelMainHotOrganizeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(channelMainHotOrganizeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        OrganizeDetailActivity.INSTANCE.a(channelMainHotOrganizeAdapter.getContext(), channelMainHotOrganizeAdapter.getItem(i));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemChannelMainHotOrganizeBinding> holder, @NotNull OrganizeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemChannelMainHotOrganizeBinding channelItemChannelMainHotOrganizeBinding = (ChannelItemChannelMainHotOrganizeBinding) holder.getDataBinding();
        if (channelItemChannelMainHotOrganizeBinding != null) {
            channelItemChannelMainHotOrganizeBinding.k(item);
            channelItemChannelMainHotOrganizeBinding.executePendingBindings();
        }
    }
}
