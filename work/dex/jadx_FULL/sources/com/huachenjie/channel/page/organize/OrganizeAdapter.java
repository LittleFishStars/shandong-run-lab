package com.huachenjie.channel.page.organize;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelItemOrganizeBinding;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b \u0010!J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bR\u0017\u0010\u0017\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001e¨\u0006\""}, d2 = {"Lcom/huachenjie/channel/page/organize/OrganizeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/channel/bean/OrganizeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/channel/databinding/ChannelItemOrganizeBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "Landroid/view/View;", "view", y6b.g, "j", y6b.f, "", "a", "Z", "i", "()Z", "isChannelAdmin", "", "K", "I", "mMargin", "L", "bottomMargin", "Landroid/view/View;", "mEmptyView", "<init>", "(Z)V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeAdapter extends BaseQuickAdapter<OrganizeBean, BaseDataBindingHolder<ChannelItemOrganizeBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int mMargin;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int bottomMargin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean isChannelAdmin;

    /* JADX WARN: Illegal instructions before constructor call */
    public OrganizeAdapter(boolean z) {
        List list = null;
        super(R.layout.channel_item_organize, list, 2, list);
        this.isChannelAdmin = z;
        this.mMargin = jj8.a(16.0f);
        this.bottomMargin = jj8.a(12.0f);
    }

    public final void g() {
        removeEmptyView();
    }

    public final void h(@Nullable View view) {
        this.mEmptyView = view;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final boolean getIsChannelAdmin() {
        return this.isChannelAdmin;
    }

    public final void j() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null) {
            return;
        }
        Intrinsics.checkNotNull(view);
        setEmptyView(view);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.channel.page.organize.OrganizeAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (OrganizeAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        if (childAdapterPosition != 0) {
                            outRect.set(OrganizeAdapter.this.mMargin, 0, OrganizeAdapter.this.mMargin, OrganizeAdapter.this.bottomMargin);
                        } else {
                            outRect.set(OrganizeAdapter.this.mMargin, OrganizeAdapter.this.mMargin, OrganizeAdapter.this.mMargin, OrganizeAdapter.this.bottomMargin);
                        }
                        break;
                }
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ChannelItemOrganizeBinding> holder, @NotNull OrganizeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ChannelItemOrganizeBinding channelItemOrganizeBinding = (ChannelItemOrganizeBinding) holder.getDataBinding();
        if (channelItemOrganizeBinding != null) {
            channelItemOrganizeBinding.l(item);
            channelItemOrganizeBinding.m(Boolean.valueOf(this.isChannelAdmin));
            channelItemOrganizeBinding.executePendingBindings();
        }
    }
}
