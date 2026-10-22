package com.huachenjie.channel.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeTeamUserBean;
import com.huachenjie.channel.databinding.ChannelItemOrganizeMemberBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/adapter/OrganizeMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/OrganizeTeamUserBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemOrganizeMemberBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OrganizeMemberAdapter extends BaseQuickAdapter<OrganizeTeamUserBean, BaseDataBindingHolder<ChannelItemOrganizeMemberBinding>> implements LoadMoreModule {
    public OrganizeMemberAdapter() {
        super(R.layout.channel_item_organize_member, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemOrganizeMemberBinding> holder, @NotNull OrganizeTeamUserBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemOrganizeMemberBinding channelItemOrganizeMemberBinding = (ChannelItemOrganizeMemberBinding) holder.getDataBinding();
        if (channelItemOrganizeMemberBinding != null) {
            channelItemOrganizeMemberBinding.k(item);
            channelItemOrganizeMemberBinding.executePendingBindings();
        }
    }
}
