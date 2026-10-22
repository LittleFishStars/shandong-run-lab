package com.huachenjie.works.adapter.search;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.search.SearchHotSpotItemBean;
import com.huachenjie.works.databinding.WorksItemSearchHotSpotBinding;
import com.zj.adlib.qk0;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/works/adapter/search/SearchHotSpotAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/works/bean/search/SearchHotSpotItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/works/databinding/WorksItemSearchHotSpotBinding;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", y6b.g, "()F", "SIZE_DP20", "", "b", y6b.f, "()I", "SIZE_DP14", "c", "f", "SIZE_DP12", "d", "i", "SIZE_DP8", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchHotSpotAdapter extends BaseQuickAdapter<SearchHotSpotItemBean, BaseDataBindingHolder<WorksItemSearchHotSpotBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP20;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP14;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP12;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP8;

    public SearchHotSpotAdapter() {
        super(R.layout.works_item_search_hot_spot, null, 2, null);
        this.SIZE_DP20 = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.works.adapter.search.SearchHotSpotAdapter$SIZE_DP20$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m808invoke() {
                return Float.valueOf(SizeUtils.b(20.0f) * 1.0f);
            }
        });
        this.SIZE_DP14 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.search.SearchHotSpotAdapter$SIZE_DP14$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m807invoke() {
                return Integer.valueOf(SizeUtils.b(14.0f));
            }
        });
        this.SIZE_DP12 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.search.SearchHotSpotAdapter$SIZE_DP12$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m806invoke() {
                return Integer.valueOf(SizeUtils.b(12.0f));
            }
        });
        this.SIZE_DP8 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.adapter.search.SearchHotSpotAdapter$SIZE_DP8$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m809invoke() {
                return Integer.valueOf(SizeUtils.b(8.0f));
            }
        });
    }

    public final int f() {
        return ((Number) this.SIZE_DP12.getValue()).intValue();
    }

    public final int g() {
        return ((Number) this.SIZE_DP14.getValue()).intValue();
    }

    public final float h() {
        return ((Number) this.SIZE_DP20.getValue()).floatValue();
    }

    public final int i() {
        return ((Number) this.SIZE_DP8.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<WorksItemSearchHotSpotBinding> holder, @NotNull SearchHotSpotItemBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Drawable background = holder.itemView.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (holder.getBindingAdapterPosition() == getData().size()) {
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, h(), h(), h(), h()});
            holder.itemView.setPadding(f(), g(), f(), g() + i());
        } else {
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            holder.itemView.setPadding(f(), g(), f(), g());
        }
        WorksItemSearchHotSpotBinding worksItemSearchHotSpotBinding = (WorksItemSearchHotSpotBinding) holder.getDataBinding();
        if (worksItemSearchHotSpotBinding != null) {
            worksItemSearchHotSpotBinding.setVariable(qk0.g, item);
            worksItemSearchHotSpotBinding.executePendingBindings();
        }
    }
}
