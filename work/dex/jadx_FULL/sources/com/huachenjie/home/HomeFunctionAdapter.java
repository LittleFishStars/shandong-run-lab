package com.huachenjie.home;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.home.bean.HomeHeaderBean;
import com.huachenjie.home.databinding.HomeItemHomeHeaderBinding;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/home/HomeFunctionAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/home/bean/HomeHeaderBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/home/databinding/HomeItemHomeHeaderBinding;", "holder", "item", "", "convert", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "", "a", "Lkotlin/Lazy;", "f", "()I", "itemWidth", "K", "I", "margin", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class HomeFunctionAdapter extends BaseQuickAdapter<HomeHeaderBean, BaseDataBindingHolder<HomeItemHomeHeaderBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int margin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy itemWidth;

    public HomeFunctionAdapter() {
        super(R.layout.home_item_home_header, null, 2, null);
        this.itemWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.HomeFunctionAdapter$itemWidth$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m400invoke() {
                return Integer.valueOf((int) ((fx7.j() - jj8.a(140.0f)) / 5.0f));
            }
        });
        this.margin = jj8.a(18.0f);
    }

    public final int f() {
        return ((Number) this.itemWidth.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.home.HomeFunctionAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (HomeFunctionAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        if (childAdapterPosition != 0) {
                            outRect.set(0, 0, 0, 0);
                        } else {
                            outRect.set(HomeFunctionAdapter.this.margin / 2, 0, 0, 0);
                        }
                        break;
                }
            }
        });
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<HomeItemHomeHeaderBinding> holder, @NotNull HomeHeaderBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        HomeItemHomeHeaderBinding homeItemHomeHeaderBinding = (HomeItemHomeHeaderBinding) holder.getDataBinding();
        if (homeItemHomeHeaderBinding != null) {
            homeItemHomeHeaderBinding.getRoot().getLayoutParams().width = f() + this.margin;
            homeItemHomeHeaderBinding.k(item);
            homeItemHomeHeaderBinding.executePendingBindings();
        }
    }
}
