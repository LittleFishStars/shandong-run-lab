package com.huachenjie.channel.adapter;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelItemMyOrganizeBinding;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity;
import com.zj.adlib.jj8;
import com.zj.adlib.y57;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R\u0017\u0010\u0012\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/channel/adapter/AllOrMyOrganizeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemMyOrganizeBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "", "a", "Z", "i", "()Z", "isMyOrganize", "", "K", "I", "mMargin", "L", "bottomMargin", "<init>", "(Z)V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AllOrMyOrganizeAdapter extends BaseQuickAdapter<OrganizeBean, BaseDataBindingHolder<ChannelItemMyOrganizeBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int mMargin;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int bottomMargin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean isMyOrganize;

    public AllOrMyOrganizeAdapter() {
        this(false, 1, null);
    }

    public /* synthetic */ AllOrMyOrganizeAdapter(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    public static final void f(AllOrMyOrganizeAdapter allOrMyOrganizeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(allOrMyOrganizeAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        OrganizeDetailActivity.INSTANCE.a(allOrMyOrganizeAdapter.getContext(), allOrMyOrganizeAdapter.getItem(i));
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsMyOrganize() {
        return this.isMyOrganize;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (AllOrMyOrganizeAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        if (childAdapterPosition != 0) {
                            outRect.set(AllOrMyOrganizeAdapter.this.mMargin, 0, AllOrMyOrganizeAdapter.this.mMargin, AllOrMyOrganizeAdapter.this.bottomMargin);
                        } else {
                            outRect.set(AllOrMyOrganizeAdapter.this.mMargin, AllOrMyOrganizeAdapter.this.mMargin, AllOrMyOrganizeAdapter.this.mMargin, AllOrMyOrganizeAdapter.this.bottomMargin);
                        }
                        break;
                }
            }
        });
    }

    public AllOrMyOrganizeAdapter(boolean z) {
        super(R.layout.channel_item_my_organize, null, 2, null);
        this.isMyOrganize = z;
        this.mMargin = jj8.a(16.0f);
        this.bottomMargin = jj8.a(12.0f);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.s40
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AllOrMyOrganizeAdapter.f(this.f44604a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemMyOrganizeBinding> holder, @NotNull OrganizeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemMyOrganizeBinding channelItemMyOrganizeBinding = (ChannelItemMyOrganizeBinding) holder.getDataBinding();
        if (channelItemMyOrganizeBinding != null) {
            channelItemMyOrganizeBinding.l(item);
            channelItemMyOrganizeBinding.m(Boolean.valueOf(this.isMyOrganize));
            channelItemMyOrganizeBinding.executePendingBindings();
        }
    }
}
