package com.huachenjie.channel.page.channel_home;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.huachenjie.channel.databinding.ChannelItemHomeBinding;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0001H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/ChannelHomeItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemHomeBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "addLoadMoreModule", "holder", "item", "", "convert", "e", "<init>", "()V", "a", "b", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nChannelHomeAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelHomeAdapter.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,72:1\n1#2:73\n*E\n"})
public final class ChannelHomeAdapter extends BaseQuickAdapter<ChannelHomeItemBean, BaseDataBindingHolder<ChannelItemHomeBinding>> implements LoadMoreModule {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeAdapter$a;", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends BaseLoadMoreModule {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull BaseQuickAdapter<?, ?> baseQuickAdapter) {
            super(baseQuickAdapter);
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
            setLoadMoreView(new b());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/channel/page/channel_home/ChannelHomeAdapter$b;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "getRootView", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "getLoadingView", "getLoadComplete", "getLoadEndView", "getLoadFailView", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BaseLoadMoreView {
        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        @NotNull
        public View getLoadComplete(@NotNull BaseViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return holder.getView(R.id.load_more_load_complete_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        @NotNull
        public View getLoadEndView(@NotNull BaseViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return holder.getView(R.id.load_more_load_end_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        @NotNull
        public View getLoadFailView(@NotNull BaseViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return holder.getView(R.id.load_more_load_fail_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        @NotNull
        public View getLoadingView(@NotNull BaseViewHolder holder) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            return holder.getView(R.id.load_more_loading_view);
        }

        @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
        @NotNull
        public View getRootView(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            return AdapterUtilsKt.getItemView(parent, R.layout.channel_item_home_load_more);
        }
    }

    public ChannelHomeAdapter() {
        super(R.layout.channel_item_home, null, 2, null);
    }

    @Override // com.chad.library.adapter.base.module.LoadMoreModule
    @NotNull
    public BaseLoadMoreModule addLoadMoreModule(@NotNull BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        return new a(baseQuickAdapter);
    }

    public final void e(@NotNull ChannelHomeItemBean item) {
        Object next;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = getData().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((ChannelHomeItemBean) next).getSelected());
        ChannelHomeItemBean channelHomeItemBean = (ChannelHomeItemBean) next;
        if (channelHomeItemBean != null) {
            channelHomeItemBean.setSelected(false);
            notifyItemChanged(getData().indexOf(channelHomeItemBean));
        }
        item.setSelected(true);
        notifyItemChanged(getData().indexOf(item));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemHomeBinding> holder, @NotNull ChannelHomeItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemHomeBinding channelItemHomeBinding = (ChannelItemHomeBinding) holder.getDataBinding();
        if (channelItemHomeBinding != null) {
            channelItemHomeBinding.k(item);
            channelItemHomeBinding.executePendingBindings();
        }
    }
}
