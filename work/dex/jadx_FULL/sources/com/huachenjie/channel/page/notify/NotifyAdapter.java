package com.huachenjie.channel.page.notify;

import android.content.Intent;
import android.view.View;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.NotifyBean;
import com.huachenjie.channel.databinding.ChannelItemNotifyBinding;
import com.huachenjie.channel.page.notify.NotifyAdapter;
import com.huachenjie.channel.page.notify.broad_build.NotifyBroadBuildActivity;
import com.huachenjie.channel.page.notify.fans.NotifyFansActivity;
import com.huachenjie.channel.page.notify.favorites.NotifyFavoritesActivity;
import com.huachenjie.channel.page.notify.friend_apply.FriendApplyListActivity;
import com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxActivity;
import com.huachenjie.channel.page.notify.post.NotifyPostActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/huachenjie/channel/page/notify/NotifyAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/NotifyBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemNotifyBinding;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NotifyAdapter extends BaseQuickAdapter<NotifyBean, BaseDataBindingHolder<ChannelItemNotifyBinding>> {
    public NotifyAdapter() {
        super(R.layout.channel_item_notify, null, 2, null);
        setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.x26
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                NotifyAdapter.f(this.f45736a, baseQuickAdapter, view, i);
            }
        });
    }

    public static final void f(NotifyAdapter notifyAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(notifyAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        switch (notifyAdapter.getData().get(i).getMessageType()) {
            case 2:
                ARouter.getInstance().build(RoutePathConstants.SocialContact.e).navigation();
                break;
            case 4:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) NotifyFavoritesActivity.class));
                break;
            case 5:
                ARouter.getInstance().build(zj7.i.COMMENT_ON_ME_LIST).navigation();
                break;
            case 6:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) NotifyFansActivity.class));
                break;
            case 7:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) NotifyMailBoxActivity.class));
                break;
            case 8:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) FriendApplyListActivity.class));
                break;
            case 9:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) NotifyBroadBuildActivity.class));
                break;
            case 10:
                notifyAdapter.getContext().startActivity(new Intent(notifyAdapter.getContext(), (Class<?>) NotifyPostActivity.class));
                break;
            case 11:
                ARouter.getInstance().build(zj7.g.SHOPPING_MESSAGE).navigation();
                break;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemNotifyBinding> holder, @NotNull NotifyBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemNotifyBinding channelItemNotifyBinding = (ChannelItemNotifyBinding) holder.getDataBinding();
        if (channelItemNotifyBinding != null) {
            channelItemNotifyBinding.k(item);
            channelItemNotifyBinding.executePendingBindings();
        }
    }
}
