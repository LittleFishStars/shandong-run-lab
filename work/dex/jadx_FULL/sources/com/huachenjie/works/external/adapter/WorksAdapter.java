package com.huachenjie.works.external.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.works.R;
import com.huachenjie.works.databinding.WorksItemWorksActivityBinding;
import com.huachenjie.works.databinding.WorksItemWorksAdBinding;
import com.huachenjie.works.databinding.WorksItemWorksBinding;
import com.huachenjie.works.databinding.WorksItemWorksBroadcastFloorBinding;
import com.huachenjie.works.databinding.WorksItemWorksFirstBinding;
import com.huachenjie.works.databinding.WorksItemWorksLocaleBinding;
import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.external.bean.WorkNativeAdBean;
import com.huachenjie.works.page.activity.ActivityListActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.t;
import com.noober.background.view.BLFrameLayout;
import com.zj.adlib.fx7;
import com.zj.adlib.gv1;
import com.zj.adlib.jj8;
import com.zj.adlib.y57;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import com.zj.adlib.zz8;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B%\u0012\b\b\u0002\u0010$\u001a\u00020!\u0012\b\b\u0002\u0010&\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020!¢\u0006\u0004\b;\u0010<J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001e\u0010\f\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014J\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010 \u001a\u00020\u001bH\u0002R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010(\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010+\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u0014\u0010/\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*R\u0014\u00101\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010*R\u0014\u00103\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u0010*R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u00109¨\u0006="}, d2 = {"Lcom/huachenjie/works/external/adapter/WorksAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "onAttachedToRecyclerView", "holder", "item", "convert", "r", "p", "Landroid/widget/TextView;", "tvEmpty", "Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;", "ivLayoutParams", "s", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "k", "Landroid/view/View;", "view", "Landroid/util/Size;", "size", "q", "", "width", "height", t.d, "n", "m", "", "a", "Z", yj7.g.WORKS_LOAD_MORE, "c", "fromMine", "d", "showMineRelation", "K", "I", "minImageHeight", "L", "maxImageHeight", "M", "otherImageHeight", "N", "centerMargin", "O", "mMargin", "", "Lkotlin/Lazy;", j.b, "()F", "imageWidth", "Landroid/view/View;", "mEmptyView", "<init>", "(ZZZ)V", "works_release"}, k = 1, mv = {1, 8, 0})
public class WorksAdapter extends BaseMultiItemQuickAdapter<WorkItemBean, BaseDataBindingHolder<ViewDataBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int minImageHeight;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int maxImageHeight;

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public final int otherImageHeight;

    /* JADX INFO: renamed from: N, reason: from kotlin metadata */
    public final int centerMargin;

    /* JADX INFO: renamed from: O, reason: from kotlin metadata */
    public final int mMargin;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy imageWidth;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final boolean canLoadMore;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean fromMine;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final boolean showMineRelation;

    public WorksAdapter() {
        this(false, false, false, 7, null);
    }

    public /* synthetic */ WorksAdapter(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3);
    }

    public static final void g(WorksAdapter worksAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(worksAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        WorkItemBean workItemBean = (WorkItemBean) worksAdapter.getData().get(i);
        int itemType = workItemBean.getPostType();
        if (itemType == 0) {
            worksAdapter.k(workItemBean);
            return;
        }
        if (itemType == 2) {
            ARouter.getInstance().build(zj7.i.WORKS_DRAFT).navigation();
        } else {
            if (itemType != 3) {
                return;
            }
            ActivityListActivity.Companion aVar = ActivityListActivity.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            aVar.a(context, 1);
        }
    }

    public static final void j(WorksAdapter worksAdapter, WorkItemBean workItemBean, View view) {
        Intrinsics.checkNotNullParameter(worksAdapter, "this$0");
        Intrinsics.checkNotNullParameter(workItemBean, "$item");
        worksAdapter.remove(workItemBean);
    }

    public final void k(WorkItemBean bean) {
        int type = bean.getType();
        if (type == 1) {
            ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, bean.getWorksNo()).withBoolean("fromMine", this.fromMine).withBoolean(yj7.g.WORKS_LOAD_MORE, this.canLoadMore).navigation();
            return;
        }
        if (type == 2) {
            ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, bean.getWorksNo()).navigation();
        } else if (type == 3) {
            ARouter.getInstance().build(zj7.b.CHANNEL_MAIN).withString("channelNo", bean.getWorksNo()).navigation();
        } else {
            if (type != 6) {
                return;
            }
            ARouter.getInstance().build(zj7.i.WORKS_DETAIL).withString(yj7.g.WORKS_NO, bean.getWorksNo()).withInt(yj7.g.WORKS_TYPE, bean.getType()).navigation();
        }
    }

    public final Size l(int width, int height) {
        if (width == 0 || height == 0) {
            return new Size((int) o(), this.minImageHeight);
        }
        float fO = o();
        float f = (height * fO) / width;
        int i = this.minImageHeight;
        if (f < i) {
            f = i;
        }
        int i2 = this.maxImageHeight;
        if (f > i2) {
            f = i2;
        }
        return new Size((int) fO, (int) f);
    }

    public final int m() {
        return R.layout.layout_empty_work;
    }

    public final View n() {
        if (this.mEmptyView == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(m(), (ViewGroup) null);
            this.mEmptyView = viewInflate;
            Intrinsics.checkNotNull(viewInflate);
            View viewFindViewById = viewInflate.findViewById(R.id.tv_empty);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "mEmptyView!!.findViewById(R.id.tv_empty)");
            View view = this.mEmptyView;
            Intrinsics.checkNotNull(view);
            ViewGroup.LayoutParams layoutParams = ((ImageView) view.findViewById(R.id.emptyView)).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            s((TextView) viewFindViewById, (ConstraintLayout.LayoutParams) layoutParams);
        }
        return this.mEmptyView;
    }

    public final float o() {
        return ((Number) this.imageWidth.getValue()).floatValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.huachenjie.works.external.adapter.WorksAdapter.onAttachedToRecyclerView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
                Intrinsics.checkNotNullParameter(outRect, "outRect");
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(parent, "parent");
                Intrinsics.checkNotNullParameter(state, "state");
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (childAdapterPosition == -1) {
                }
                switch (WorksAdapter.this.getItemViewType(childAdapterPosition)) {
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
                            outRect.set(WorksAdapter.this.centerMargin, 0, WorksAdapter.this.mMargin, WorksAdapter.this.mMargin);
                        } else {
                            outRect.set(WorksAdapter.this.mMargin, 0, WorksAdapter.this.centerMargin, WorksAdapter.this.mMargin);
                        }
                        break;
                }
            }
        });
    }

    public final void p() {
        removeEmptyView();
    }

    public final void q(View view, Size size) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = size.getWidth();
        layoutParams.height = size.getHeight();
        view.setLayoutParams(layoutParams);
    }

    public final void r() {
        if (hasEmptyView() || n() == null) {
            return;
        }
        View viewN = n();
        Intrinsics.checkNotNull(viewN);
        setEmptyView(viewN);
    }

    public void s(@NotNull TextView tvEmpty, @NotNull ConstraintLayout.LayoutParams ivLayoutParams) {
        Intrinsics.checkNotNullParameter(tvEmpty, "tvEmpty");
        Intrinsics.checkNotNullParameter(ivLayoutParams, "ivLayoutParams");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WorksAdapter(boolean z, boolean z2, boolean z3) {
        List list = null;
        super(list, 1, list);
        this.canLoadMore = z;
        this.fromMine = z2;
        this.showMineRelation = z3;
        this.minImageHeight = jj8.a(140.0f);
        this.maxImageHeight = jj8.a(240.0f);
        this.otherImageHeight = jj8.a(200.0f);
        this.centerMargin = jj8.a(3.0f);
        this.mMargin = jj8.a(8.0f);
        this.imageWidth = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.works.external.adapter.WorksAdapter$imageWidth$2
            {
                super(0);
            }

            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m816invoke() {
                return Float.valueOf((fx7.e() - ((this.this$0.mMargin + this.this$0.centerMargin) * 2)) / 2.0f);
            }
        });
        addItemType(0, R.layout.works_item_works);
        addItemType(1, R.layout.works_item_works_locale);
        addItemType(2, R.layout.works_item_works_first);
        addItemType(3, R.layout.works_item_works_activity);
        addItemType(4, R.layout.works_item_works_ad);
        addItemType(6, R.layout.works_item_works_broadcast_floor);
        y57.d(this, 0L, new OnItemClickListener() { // from class: com.zj.adlib.b0a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WorksAdapter.g(this.f40648a, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull final WorkItemBean item) {
        JZUnifiedAdInfo adInfo;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            int itemType = item.getPostType();
            if (itemType == 0) {
                WorksItemWorksBinding worksItemWorksBinding = (WorksItemWorksBinding) dataBinding;
                if (item.getType() == 1) {
                    Size sizeL = l(item.getWidth(), item.getHeight());
                    ImageView imageView = worksItemWorksBinding.b;
                    Intrinsics.checkNotNullExpressionValue(imageView, "ivImage");
                    q(imageView, sizeL);
                    BLFrameLayout bLFrameLayout = worksItemWorksBinding.f14740a;
                    Intrinsics.checkNotNullExpressionValue(bLFrameLayout, "flImageContainer");
                    q(bLFrameLayout, sizeL);
                } else {
                    worksItemWorksBinding.b.getLayoutParams().height = this.otherImageHeight;
                    worksItemWorksBinding.f14740a.getLayoutParams().height = this.otherImageHeight;
                }
                worksItemWorksBinding.l(Boolean.valueOf(this.showMineRelation));
                worksItemWorksBinding.m(item);
            } else if (itemType == 1) {
                WorksItemWorksLocaleBinding worksItemWorksLocaleBinding = (WorksItemWorksLocaleBinding) dataBinding;
                Size sizeL2 = l(item.getWidth(), item.getHeight());
                ImageView imageView2 = worksItemWorksLocaleBinding.f37095a;
                Intrinsics.checkNotNullExpressionValue(imageView2, "ivImage");
                q(imageView2, sizeL2);
                worksItemWorksLocaleBinding.k(item);
            } else if (itemType == 2) {
                ((WorksItemWorksFirstBinding) dataBinding).k(item);
            } else if (itemType == 3) {
                WorksItemWorksActivityBinding worksItemWorksActivityBinding = (WorksItemWorksActivityBinding) dataBinding;
                SpannableString spannableString = new SpannableString("活动" + item.getTitle());
                spannableString.setSpan(new zz8(Color.parseColor("#FFFF3D3D"), -1, jj8.e(10.0f, getContext())), 0, 2, 33);
                worksItemWorksActivityBinding.f14725a.setText(spannableString);
                worksItemWorksActivityBinding.k(item);
            } else if (itemType == 4) {
                WorksItemWorksAdBinding worksItemWorksAdBinding = (WorksItemWorksAdBinding) dataBinding;
                Size sizeL3 = l(9, 16);
                ConstraintLayout constraintLayout = worksItemWorksAdBinding.f14730a;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "flAdContainer");
                q(constraintLayout, sizeL3);
                try {
                    if (item instanceof WorkNativeAdBean) {
                        RequestManager requestManagerWith = Glide.with(worksItemWorksAdBinding.b);
                        JZUnifiedAdInfo adInfo2 = ((WorkNativeAdBean) item).getAdInfo();
                        String jZImgUrl = adInfo2 != null ? adInfo2.getJZImgUrl() : null;
                        String str = "";
                        if (jZImgUrl == null) {
                            jZImgUrl = "";
                        } else {
                            Intrinsics.checkNotNullExpressionValue(jZImgUrl, "item.adInfo?.jzImgUrl ?: \"\"");
                        }
                        RequestBuilder<Drawable> requestBuilderLoad = requestManagerWith.load(jZImgUrl);
                        DiskCacheStrategy diskCacheStrategy = DiskCacheStrategy.ALL;
                        requestBuilderLoad.diskCacheStrategy(diskCacheStrategy).into(worksItemWorksAdBinding.b);
                        RequestManager requestManagerWith2 = Glide.with(worksItemWorksAdBinding.c);
                        JZUnifiedAdInfo adInfo3 = ((WorkNativeAdBean) item).getAdInfo();
                        String jZIconUrl = adInfo3 != null ? adInfo3.getJZIconUrl() : null;
                        if (jZIconUrl != null) {
                            Intrinsics.checkNotNullExpressionValue(jZIconUrl, "item.adInfo?.jzIconUrl ?: \"\"");
                            str = jZIconUrl;
                        }
                        requestManagerWith2.load(str).diskCacheStrategy(diskCacheStrategy).into(worksItemWorksAdBinding.c);
                        worksItemWorksAdBinding.f37083a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.c0a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                WorksAdapter.j(this.f40875a, item, view);
                            }
                        });
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(worksItemWorksAdBinding.b);
                        arrayList.add(worksItemWorksAdBinding.c);
                        FragmentActivity fragmentActivityA = gv1.a(getContext());
                        if (fragmentActivityA != null && (adInfo = ((WorkNativeAdBean) item).getAdInfo()) != null) {
                            adInfo.bindJZAdToView(fragmentActivityA, worksItemWorksAdBinding.f14731a, arrayList);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                worksItemWorksAdBinding.k(item);
            } else if (itemType == 6) {
                WorksItemWorksBroadcastFloorBinding worksItemWorksBroadcastFloorBinding = (WorksItemWorksBroadcastFloorBinding) dataBinding;
                SpannableString spannableString2 = new SpannableString("今日主题" + item.getTitle());
                spannableString2.setSpan(new zz8(Color.parseColor("#FFFF9118"), -1, jj8.e(10.0f, getContext())), 0, 4, 33);
                worksItemWorksBroadcastFloorBinding.f14749a.setText(spannableString2);
                worksItemWorksBroadcastFloorBinding.k(item);
            }
            dataBinding.executePendingBindings();
        }
    }
}
