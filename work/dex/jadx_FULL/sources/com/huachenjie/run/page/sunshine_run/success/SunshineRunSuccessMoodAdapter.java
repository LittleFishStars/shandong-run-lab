package com.huachenjie.run.page.sunshine_run.success;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.EmaOptionBean;
import com.huachenjie.run.databinding.RunItemSunshineRunSuccessMoodBinding;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.y6b;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0016J\u001e\u0010\u000e\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\r\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0016\u0010\u0010\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002R*\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00118\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R#\u0010 \u001a\n \u001b*\u0004\u0018\u00010\u001a0\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/run/bean/EmaOptionBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/run/databinding/RunItemSunshineRunSuccessMoodBinding;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "", GoodsSpecificationPreviewActivity.z, "setList", "holder", "item", "convert", "i", "e", "", "value", "K", "I", y6b.f, "()I", y6b.g, "(I)V", DressingTableActivity.x, "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "f", "()Landroid/graphics/drawable/Drawable;", "selectedBackground", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunSuccessMoodAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunSuccessMoodAdapter.kt\ncom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1#2:112\n*E\n"})
public final class SunshineRunSuccessMoodAdapter extends BaseQuickAdapter<EmaOptionBean, BaseDataBindingHolder<RunItemSunshineRunSuccessMoodBinding>> {
    public static final int L = 5;

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int selectedIndex;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy selectedBackground;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessMoodAdapter$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f35970a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ SunshineRunSuccessMoodAdapter f12547a;

        public b(RecyclerView recyclerView, SunshineRunSuccessMoodAdapter sunshineRunSuccessMoodAdapter) {
            this.f35970a = recyclerView;
            this.f12547a = sunshineRunSuccessMoodAdapter;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f35970a.getWidth() <= 0) {
                return;
            }
            this.f35970a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (this.f12547a.getItemCount() > 0) {
                SunshineRunSuccessMoodAdapter sunshineRunSuccessMoodAdapter = this.f12547a;
                sunshineRunSuccessMoodAdapter.notifyItemRangeChanged(0, sunshineRunSuccessMoodAdapter.getItemCount());
            }
        }
    }

    public SunshineRunSuccessMoodAdapter() {
        super(R.layout.run_item_sunshine_run_success_mood, null, 2, null);
        this.selectedIndex = -1;
        this.selectedBackground = LazyKt.lazy(new Function0<Drawable>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessMoodAdapter$selectedBackground$2
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Drawable m720invoke() {
                return new DrawableCreator.Builder().setStrokeWidth(SizeUtils.b(1.0f)).setStrokeColor(Color.parseColor("#FF9118")).setSolidColor(Color.parseColor("#26FF9118")).setCornersRadius(SizeUtils.b(8.0f)).build();
            }
        });
    }

    public final void e(BaseDataBindingHolder<RunItemSunshineRunSuccessMoodBinding> holder) {
        Object obj;
        int width;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(getRecyclerView());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        RecyclerView recyclerView = (RecyclerView) obj;
        if (recyclerView != null && (width = (recyclerView.getWidth() - recyclerView.getPaddingStart()) - recyclerView.getPaddingEnd()) > 0) {
            int i = width / 5;
            ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(i, -2);
            }
            if (layoutParams.width != i) {
                layoutParams.width = i;
                holder.itemView.setLayoutParams(layoutParams);
            }
        }
    }

    public final Drawable f() {
        return (Drawable) this.selectedBackground.getValue();
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    public final void h(int i) {
        this.selectedIndex = i;
        notifyDataSetChanged();
    }

    public final void i() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(getRecyclerView());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        RecyclerView recyclerView = (RecyclerView) obj;
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        FlexboxLayoutManager flexboxLayoutManager = layoutManager instanceof FlexboxLayoutManager ? (FlexboxLayoutManager) layoutManager : null;
        if (flexboxLayoutManager == null) {
            return;
        }
        int itemCount = getItemCount();
        int i = 1 <= itemCount && itemCount < 5 ? 2 : 0;
        if (flexboxLayoutManager.getJustifyContent() != i) {
            flexboxLayoutManager.setJustifyContent(i);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
        flexboxLayoutManager.setFlexDirection(0);
        flexboxLayoutManager.setFlexWrap(1);
        flexboxLayoutManager.setAlignItems(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        i();
        recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new b(recyclerView, this));
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@Nullable Collection<? extends EmaOptionBean> list) {
        super.setList(list);
        i();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<RunItemSunshineRunSuccessMoodBinding> holder, @NotNull EmaOptionBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        e(holder);
        RunItemSunshineRunSuccessMoodBinding runItemSunshineRunSuccessMoodBinding = (RunItemSunshineRunSuccessMoodBinding) holder.getDataBinding();
        if (runItemSunshineRunSuccessMoodBinding != null) {
            runItemSunshineRunSuccessMoodBinding.k(item);
            runItemSunshineRunSuccessMoodBinding.getRoot().setBackground(holder.getBindingAdapterPosition() == this.selectedIndex ? f() : null);
            runItemSunshineRunSuccessMoodBinding.executePendingBindings();
        }
    }
}
