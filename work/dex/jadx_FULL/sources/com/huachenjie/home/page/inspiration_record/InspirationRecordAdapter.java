package com.huachenjie.home.page.inspiration_record;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.BaseLoadMoreView;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.InspirationRecordBean;
import com.zj.adlib.xk0;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \u000f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005:\u0003\u000f\u0015\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0016J\u001e\u0010\r\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/home/bean/InspirationRecordBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "addLoadMoreModule", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", "f", "()I", "SIZE_DP16", "", "b", y6b.f, "()F", "SIZE_DP24", "<init>", "()V", "c", "home_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationRecordAdapter extends BaseMultiItemQuickAdapter<InspirationRecordBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP16;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP24;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordAdapter$b;", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "a", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "baseQuickAdapter", "<init>", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BaseLoadMoreModule {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public final BaseQuickAdapter<?, ?> baseQuickAdapter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull BaseQuickAdapter<?, ?> baseQuickAdapter) {
            super(baseQuickAdapter);
            Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
            this.baseQuickAdapter = baseQuickAdapter;
            setLoadMoreView(new c());
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordAdapter$c;", "Lcom/chad/library/adapter/base/loadmore/BaseLoadMoreView;", "Landroid/view/ViewGroup;", "parent", "Landroid/view/View;", "getRootView", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "getLoadingView", "getLoadComplete", "getLoadEndView", "getLoadFailView", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BaseLoadMoreView {
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
            return AdapterUtilsKt.getItemView(parent, R.layout.home_item_inspiration_record_load_more);
        }
    }

    public InspirationRecordAdapter() {
        super(null, 1, null);
        this.SIZE_DP16 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.inspiration_record.InspirationRecordAdapter$SIZE_DP16$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m425invoke() {
                return Integer.valueOf(SizeUtils.b(16.0f));
            }
        });
        this.SIZE_DP24 = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.home.page.inspiration_record.InspirationRecordAdapter$SIZE_DP24$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m426invoke() {
                return Float.valueOf(SizeUtils.b(24.0f));
            }
        });
        addItemType(0, R.layout.home_item_inspiration_record_get);
        addItemType(1, R.layout.home_item_inspiration_record_consume);
        addItemType(2, R.layout.home_item_inspiration_record_title);
    }

    @Override // com.chad.library.adapter.base.module.LoadMoreModule
    @NotNull
    public BaseLoadMoreModule addLoadMoreModule(@NotNull BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "baseQuickAdapter");
        return new b(baseQuickAdapter);
    }

    public final int f() {
        return ((Number) this.SIZE_DP16.getValue()).intValue();
    }

    public final float g() {
        return ((Number) this.SIZE_DP24.getValue()).floatValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull InspirationRecordBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (holder.getItemViewType() != 2) {
                View viewFindViewById = holder.itemView.findViewById(R.id.v_line);
                Drawable background = holder.itemView.getBackground();
                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (item.getHasNext() || holder.getBindingAdapterPosition() != getData().size() - 1) {
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(0);
                    }
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                    holder.itemView.setPadding(f(), 0, f(), 0);
                } else {
                    if (viewFindViewById != null) {
                        viewFindViewById.setVisibility(8);
                    }
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, g(), g(), g(), g()});
                    holder.itemView.setPadding(f(), 0, f(), (int) g());
                }
                holder.itemView.setBackground(gradientDrawable);
            }
            dataBinding.setVariable(xk0.g, item);
            dataBinding.executePendingBindings();
        }
    }
}
