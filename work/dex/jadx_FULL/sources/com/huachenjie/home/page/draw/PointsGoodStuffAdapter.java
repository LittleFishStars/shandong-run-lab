package com.huachenjie.home.page.draw;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coroutines.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.PointsGoodsBean;
import com.huachenjie.home.databinding.HomeItemPointsGoodStuffBinding;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.y6b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B%\u0012\b\b\u0002\u00103\u001a\u00020,\u0012\b\b\u0002\u00104\u001a\u00020,\u0012\b\b\u0002\u00105\u001a\u00020,¢\u0006\u0004\b6\u00107J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001dH\u0002R\u001b\u0010%\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010(\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u001b\u0010+\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\"\u001a\u0004\b*\u0010$R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\"\u001a\u0004\b.\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u00101¨\u00068"}, d2 = {"Lcom/huachenjie/home/page/draw/PointsGoodStuffAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/home/bean/PointsGoodsBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "Landroid/content/Context;", "context", "", "emptyLayoutId", "n", "Landroid/view/View;", "view", j.b, "q", "m", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/home/databinding/HomeItemPointsGoodStuffBinding;", "viewBiding", "r", "width", "height", "Landroid/util/Size;", y6b.g, "size", "p", "a", "Lkotlin/Lazy;", "j", "()I", "centerMargin", "b", "k", "horizontalMargin", "c", "i", "bottomMargin", "", "d", t.d, "()F", "imageWidth", "Landroid/view/View;", "mEmptyView", "itemCenterMargin", "itemHorizontalMargin", "itemBottomMargin", "<init>", "(FFF)V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class PointsGoodStuffAdapter extends BaseMultiItemQuickAdapter<PointsGoodsBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy centerMargin;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy horizontalMargin;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy bottomMargin;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy imageWidth;

    public PointsGoodStuffAdapter() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    public /* synthetic */ PointsGoodStuffAdapter(float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 2.5f : f, (i & 2) != 0 ? 8.0f : f2, (i & 4) != 0 ? 8.0f : f3);
    }

    public final Size h(int width, int height) {
        if (width == 0 || height == 0) {
            return new Size((int) l(), (int) l());
        }
        float fL = l();
        return new Size((int) fL, (int) ((height * fL) / width));
    }

    public final int i() {
        return ((Number) this.bottomMargin.getValue()).intValue();
    }

    public final int j() {
        return ((Number) this.centerMargin.getValue()).intValue();
    }

    public final int k() {
        return ((Number) this.horizontalMargin.getValue()).intValue();
    }

    public final float l() {
        return ((Number) this.imageWidth.getValue()).floatValue();
    }

    public final void m() {
        removeEmptyView();
    }

    public final void n(@NotNull Context context, int emptyLayoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEmptyView = LayoutInflater.from(context).inflate(emptyLayoutId, (ViewGroup) null);
    }

    public final void o(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.home.page.draw.PointsGoodStuffAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (PointsGoodStuffAdapter.this.getItemViewType(childAdapterPosition)) {
                    case BaseQuickAdapter.HEADER_VIEW /* 268435729 */:
                    case BaseQuickAdapter.LOAD_MORE_VIEW /* 268436002 */:
                    case BaseQuickAdapter.FOOTER_VIEW /* 268436275 */:
                    case BaseQuickAdapter.EMPTY_VIEW /* 268436821 */:
                        outRect.set(0, 0, 0, 0);
                        break;
                    default:
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                        if (((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex() % 2 != 0) {
                            outRect.set(PointsGoodStuffAdapter.this.j(), 0, PointsGoodStuffAdapter.this.k(), PointsGoodStuffAdapter.this.i());
                        } else {
                            outRect.set(PointsGoodStuffAdapter.this.k(), 0, PointsGoodStuffAdapter.this.j(), PointsGoodStuffAdapter.this.i());
                        }
                        break;
                }
            }
        });
    }

    public final void p(View view, Size size) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        view.setLayoutParams(layoutParams);
    }

    public final void q() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    public final void r(PointsGoodsBean bean, HomeItemPointsGoodStuffBinding viewBiding) {
        viewBiding.b.setText(bean.findGoodsName());
    }

    public PointsGoodStuffAdapter(final float f, final float f2, final float f3) {
        super(null, 1, null);
        this.centerMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.draw.PointsGoodStuffAdapter$centerMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m412invoke() {
                return Integer.valueOf(jj8.a(f));
            }
        });
        this.horizontalMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.draw.PointsGoodStuffAdapter$horizontalMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m413invoke() {
                return Integer.valueOf(jj8.a(f2));
            }
        });
        this.bottomMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.draw.PointsGoodStuffAdapter$bottomMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m411invoke() {
                return Integer.valueOf(jj8.a(f3));
            }
        });
        this.imageWidth = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.home.page.draw.PointsGoodStuffAdapter$imageWidth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m414invoke() {
                float f4 = 2;
                return Float.valueOf((fx7.e() - jj8.a((f2 * f4) + (f * f4))) / 2.0f);
            }
        });
        addItemType(0, R.layout.home_item_points_good_stuff);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull PointsGoodsBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        if (item.getPostType() == 0) {
            HomeItemPointsGoodStuffBinding homeItemPointsGoodStuffBinding = (HomeItemPointsGoodStuffBinding) dataBinding;
            ImageView imageView = homeItemPointsGoodStuffBinding.f34285a;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivImage");
            p(imageView, h(item.getCoverWidth(), item.getCoverHeight()));
            r(item, homeItemPointsGoodStuffBinding);
            homeItemPointsGoodStuffBinding.k(item);
        }
        dataBinding.executePendingBindings();
    }
}
