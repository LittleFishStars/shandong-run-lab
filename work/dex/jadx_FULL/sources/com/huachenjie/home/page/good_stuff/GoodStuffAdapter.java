package com.huachenjie.home.page.good_stuff;

import android.content.Context;
import android.graphics.Rect;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.BannerItemBean;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import com.huachenjie.home.bean.GoodStuffBean;
import com.huachenjie.home.databinding.HomeItemGoodStuffBannerBinding;
import com.huachenjie.home.databinding.HomeItemGoodStuffBinding;
import com.huachenjie.home.page.good_stuff.GoodStuffAdapter;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.zj.adlib.er7;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.ju3;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B3\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%\u0012\b\b\u0002\u0010=\u001a\u000206\u0012\b\b\u0002\u0010>\u001a\u000206\u0012\b\b\u0002\u0010?\u001a\u000206¢\u0006\u0004\b@\u0010AJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u0019H\u0002J\u0018\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u001dH\u0002J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000fH\u0002J\u0018\u0010$\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010#\u001a\u00020!H\u0002R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%8\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001b\u0010/\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010,\u001a\u0004\b-\u0010.R\u001b\u00102\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010.R\u001b\u00105\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b3\u0010,\u001a\u0004\b4\u0010.R\u001b\u0010:\u001a\u0002068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010,\u001a\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010;¨\u0006B"}, d2 = {"Lcom/huachenjie/home/page/good_stuff/GoodStuffAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "Landroid/content/Context;", "context", "", "emptyLayoutId", "r", "Landroid/view/View;", "view", "s", "u", j.b, "Lcom/huachenjie/home/databinding/HomeItemGoodStuffBannerBinding;", "viewBiding", "Lcom/huachenjie/home/bean/GoodStuffBannerBean;", "p", "Lcom/huachenjie/home/bean/GoodStuffBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lcom/huachenjie/home/databinding/HomeItemGoodStuffBinding;", "v", "width", "height", "Landroid/util/Size;", "i", "size", "t", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "a", "Ljava/lang/ref/WeakReference;", "n", "()Ljava/lang/ref/WeakReference;", "lifecycleWeak", "Lkotlin/Lazy;", "k", "()I", "centerMargin", "b", t.d, "horizontalMargin", "c", "j", "bottomMargin", "", "d", "m", "()F", "imageWidth", "Landroid/view/View;", "mEmptyView", "itemCenterMargin", "itemHorizontalMargin", "itemBottomMargin", "<init>", "(Ljava/lang/ref/WeakReference;FFF)V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class GoodStuffAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final WeakReference<LifecycleOwner> lifecycleWeak;

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

    public /* synthetic */ GoodStuffAdapter(WeakReference weakReference, float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, (i & 2) != 0 ? 2.5f : f, (i & 4) != 0 ? 8.0f : f2, (i & 8) != 0 ? 8.0f : f3);
    }

    public static final void q(HomeItemGoodStuffBannerBinding homeItemGoodStuffBannerBinding, BannerItemBean bannerItemBean, int i) {
        Intrinsics.checkNotNullParameter(homeItemGoodStuffBannerBinding, "$viewBiding");
        er7 er7Var = er7.f41510a;
        Context context = homeItemGoodStuffBannerBinding.f34267a.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "viewBiding.banner.context");
        er7Var.b(context, bannerItemBean.getClickType(), bannerItemBean.getClickTarget());
    }

    public final Size i(int width, int height) {
        if (width == 0 || height == 0) {
            return new Size((int) m(), (int) m());
        }
        float fM = m();
        return new Size((int) fM, (int) ((height * fM) / width));
    }

    public final int j() {
        return ((Number) this.bottomMargin.getValue()).intValue();
    }

    public final int k() {
        return ((Number) this.centerMargin.getValue()).intValue();
    }

    public final int l() {
        return ((Number) this.horizontalMargin.getValue()).intValue();
    }

    public final float m() {
        return ((Number) this.imageWidth.getValue()).floatValue();
    }

    @NotNull
    public final WeakReference<LifecycleOwner> n() {
        return this.lifecycleWeak;
    }

    public final void o() {
        removeEmptyView();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (GoodStuffAdapter.this.getItemViewType(childAdapterPosition)) {
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
                            outRect.set(GoodStuffAdapter.this.k(), 0, GoodStuffAdapter.this.l(), GoodStuffAdapter.this.j());
                        } else {
                            outRect.set(GoodStuffAdapter.this.l(), 0, GoodStuffAdapter.this.k(), GoodStuffAdapter.this.j());
                        }
                        break;
                }
            }
        });
    }

    public final void p(final HomeItemGoodStuffBannerBinding viewBiding, GoodStuffBannerBean item) {
        BannerImageAdapter<BannerItemBean> bannerImageAdapter = new BannerImageAdapter<BannerItemBean>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter$initBanner$bannerAdapter$1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onBindView(@NotNull BannerImageHolder holder, @NotNull BannerItemBean data, int position, int size) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                Intrinsics.checkNotNullParameter(data, "data");
                Glide.with(holder.itemView).load(data.getImageUrl()).apply((BaseRequestOptions<?>) ju3.m).into(holder.imageView);
            }
        };
        bannerImageAdapter.setOnBannerListener(new OnBannerListener() { // from class: com.zj.adlib.bv3
            public final void OnBannerClick(Object obj, int i) {
                GoodStuffAdapter.q(viewBiding, (BannerItemBean) obj, i);
            }
        });
        Banner banner = viewBiding.f34267a;
        banner.setAdapter(bannerImageAdapter);
        banner.setIndicator(new CircleIndicator(banner.getContext()));
        if (this.lifecycleWeak.get() != null) {
            banner.addBannerLifecycleObserver(this.lifecycleWeak.get());
        }
        banner.setDatas(item.getList());
    }

    public final void r(@NotNull Context context, int emptyLayoutId) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mEmptyView = LayoutInflater.from(context).inflate(emptyLayoutId, (ViewGroup) null);
    }

    public final void s(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mEmptyView = view;
    }

    public final void t(View view, Size size) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        view.setLayoutParams(layoutParams);
    }

    public final void u() {
        View view;
        if (hasEmptyView() || (view = this.mEmptyView) == null || view.getParent() != null) {
            return;
        }
        setEmptyView(view);
    }

    public final void v(GoodStuffBean bean, HomeItemGoodStuffBinding viewBiding) {
        viewBiding.b.setText(bean.findGoodsName());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodStuffAdapter(@NotNull WeakReference<LifecycleOwner> weakReference, final float f, final float f2, final float f3) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(weakReference, "lifecycleWeak");
        this.lifecycleWeak = weakReference;
        this.centerMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter$centerMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m416invoke() {
                return Integer.valueOf(jj8.a(f));
            }
        });
        this.horizontalMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter$horizontalMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m417invoke() {
                return Integer.valueOf(jj8.a(f2));
            }
        });
        this.bottomMargin = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter$bottomMargin$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m415invoke() {
                return Integer.valueOf(jj8.a(f3));
            }
        });
        this.imageWidth = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.home.page.good_stuff.GoodStuffAdapter$imageWidth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m418invoke() {
                float f4 = 2;
                return Float.valueOf((fx7.e() - jj8.a((f2 * f4) + (f * f4))) / 2.0f);
            }
        });
        addItemType(0, R.layout.home_item_good_stuff);
        addItemType(1, R.layout.home_item_good_stuff_banner);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull MultiItemEntity item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding == null) {
            return;
        }
        int postType = item.getPostType();
        if (postType == 0) {
            HomeItemGoodStuffBinding homeItemGoodStuffBinding = (HomeItemGoodStuffBinding) dataBinding;
            if (item instanceof GoodStuffBean) {
                ImageView imageView = homeItemGoodStuffBinding.f34269a;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivImage");
                GoodStuffBean goodStuffBean = (GoodStuffBean) item;
                t(imageView, i(goodStuffBean.getCoverWidth(), goodStuffBean.getCoverHeight()));
                v(goodStuffBean, homeItemGoodStuffBinding);
                homeItemGoodStuffBinding.k(goodStuffBean);
            }
        } else if (postType == 1) {
            HomeItemGoodStuffBannerBinding homeItemGoodStuffBannerBinding = (HomeItemGoodStuffBannerBinding) dataBinding;
            if (item instanceof GoodStuffBannerBean) {
                p(homeItemGoodStuffBannerBinding, (GoodStuffBannerBean) item);
            }
        }
        dataBinding.executePendingBindings();
    }
}
