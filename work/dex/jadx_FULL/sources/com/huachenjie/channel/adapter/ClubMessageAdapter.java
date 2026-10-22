package com.huachenjie.channel.adapter;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.channel.databinding.ChannelItemClubMessageBinding;
import com.huachenjie.channel.page.message_detail.MessageDetailActivity;
import com.zj.adlib.y57;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/channel/adapter/ClubMessageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/ClubMessageBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemClubMessageBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "()V", "convert", "", "holder", "item", "channel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClubMessageAdapter extends BaseQuickAdapter<ClubMessageBean, BaseDataBindingHolder<ChannelItemClubMessageBinding>> implements LoadMoreModule {
    public ClubMessageAdapter() {
        super(R.layout.channel_item_club_message, null, 2, null);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.um1
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ClubMessageAdapter.f(this.f45175a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    public static final void f(ClubMessageAdapter clubMessageAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(clubMessageAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        clubMessageAdapter.getContext().startActivity(MessageDetailActivity.Companion.b(MessageDetailActivity.INSTANCE, clubMessageAdapter.getContext(), clubMessageAdapter.getItem(i), false, 4, null));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemClubMessageBinding> holder, @NotNull ClubMessageBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemClubMessageBinding channelItemClubMessageBinding = (ChannelItemClubMessageBinding) holder.getDataBinding();
        if (channelItemClubMessageBinding != null) {
            channelItemClubMessageBinding.k(item);
            channelItemClubMessageBinding.executePendingBindings();
        }
    }
}
