package com.huachenjie.channel.page.organize.menu;

import android.view.View;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.channel.databinding.ChannelItemOrganizeMemberChannelBinding;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.tk0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberAdapter;", "Lcom/huachenjie/works/adapter/publish/BasePubWorkMenuAdapter;", "Lcom/huachenjie/channel/bean/ChannelMemberBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemOrganizeMemberChannelBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "Landroid/view/View;", "view", "k", t.d, "j", "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMenuMemberAdapter extends BasePubWorkMenuAdapter<ChannelMemberBean, BaseDataBindingHolder<ChannelItemOrganizeMemberChannelBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public OrganizeMenuMemberAdapter() {
        super(R.layout.channel_item_organize_member_channel);
    }

    public final void j() {
        removeEmptyView();
    }

    public final void k(@Nullable View view) {
        this.mEmptyView = view;
    }

    public final void l() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemOrganizeMemberChannelBinding> holder, @NotNull ChannelMemberBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemOrganizeMemberChannelBinding channelItemOrganizeMemberChannelBinding = (ChannelItemOrganizeMemberChannelBinding) holder.getDataBinding();
        if (channelItemOrganizeMemberChannelBinding != null) {
            channelItemOrganizeMemberChannelBinding.setVariable(tk0.g, item);
            channelItemOrganizeMemberChannelBinding.executePendingBindings();
        }
    }
}
