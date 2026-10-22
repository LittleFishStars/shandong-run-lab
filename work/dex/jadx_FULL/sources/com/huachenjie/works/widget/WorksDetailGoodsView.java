package com.huachenjie.works.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coroutines.BindingAdapter;
import androidx.coroutines.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.GoodsRecommendData;
import com.huachenjie.works.bean.RecommendGoodsBean;
import com.huachenjie.works.databinding.WorksViewWorksDetailGoodsBinding;
import com.huachenjie.works.page.details.goods.WorksDetailsGoodsFragment;
import com.huachenjie.works.widget.WorksDetailGoodsView;
import com.zj.adlib.gv1;
import com.zj.adlib.y57;
import com.zj.adlib.zj7;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001\nB\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001b\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB#\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001b\u0010\"B+\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b\u001b\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/huachenjie/works/widget/WorksDetailGoodsView;", "Landroid/widget/FrameLayout;", "", "goodsWorkNo", "Lcom/huachenjie/works/bean/GoodsRecommendData;", WorksDetailsGoodsFragment.WORK_GOODS_DATA, "", "setWorkGoodsData", "Lcom/huachenjie/works/databinding/WorksViewWorksDetailGoodsBinding;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getBinding", "()Lcom/huachenjie/works/databinding/WorksViewWorksDetailGoodsBinding;", "binding", "", "value", "Z", "setVideoWorks", "(Z)V", "isVideoWorks", "Lcom/huachenjie/works/bean/GoodsRecommendData;", "f", "Ljava/lang/String;", "workNo", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksDetailGoodsView extends FrameLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public GoodsRecommendData workGoodsData;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy binding;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isVideoWorks;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String workNo;

    /* JADX INFO: renamed from: com.huachenjie.works.widget.WorksDetailGoodsView$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J$\u0010\f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/widget/WorksDetailGoodsView$a;", "", "Lcom/huachenjie/works/widget/WorksDetailGoodsView;", "view", "", "isVideoWorks", "", "a", "", "goodsWorkNo", "Lcom/huachenjie/works/bean/GoodsRecommendData;", WorksDetailsGoodsFragment.WORK_GOODS_DATA, "b", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @BindingAdapter({"isVideoWorks"})
        @JvmStatic
        public final void a(@NotNull WorksDetailGoodsView view, boolean isVideoWorks) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.setVideoWorks(isVideoWorks);
        }

        @BindingAdapter({"goodsWorkNo", WorksDetailsGoodsFragment.WORK_GOODS_DATA})
        @JvmStatic
        public final void b(@Nullable WorksDetailGoodsView view, @NotNull String goodsWorkNo, @Nullable GoodsRecommendData workGoodsData) {
            Intrinsics.checkNotNullParameter(goodsWorkNo, "goodsWorkNo");
            if (view == null) {
                return;
            }
            view.workGoodsData = workGoodsData;
            view.setWorkGoodsData(goodsWorkNo, workGoodsData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailGoodsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = LazyKt.lazy(new Function0<WorksViewWorksDetailGoodsBinding>() { // from class: com.huachenjie.works.widget.WorksDetailGoodsView$binding$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WorksViewWorksDetailGoodsBinding m992invoke() {
                return (WorksViewWorksDetailGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getContext()), R.layout.works_view_works_detail_goods, this.this$0, true);
            }
        });
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        y57.f(root, 0L, new View.OnClickListener() { // from class: com.zj.adlib.g0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorksDetailGoodsView.b(this.f41790a, view);
            }
        }, 1, null);
    }

    public static final void b(WorksDetailGoodsView worksDetailGoodsView, View view) {
        List<RecommendGoodsBean> list;
        Intrinsics.checkNotNullParameter(worksDetailGoodsView, "this$0");
        GoodsRecommendData goodsRecommendData = worksDetailGoodsView.workGoodsData;
        if (goodsRecommendData == null || (list = goodsRecommendData.getList()) == null || list.isEmpty()) {
            return;
        }
        if (list.size() == 1) {
            Postcard postcardWithString = ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", ((RecommendGoodsBean) CollectionsKt.first(list)).getGoodsNo()).withString("source", "30");
            String str = worksDetailGoodsView.workNo;
            postcardWithString.withString("traceNo", str != null ? str : "").navigation();
            return;
        }
        Activity activity = gv1.getActivity(worksDetailGoodsView.getContext());
        if (activity == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(activity, "ContextUtils.getActivity…n@setOnQuickClickListener");
        WorksDetailsGoodsFragment.Companion companion = WorksDetailsGoodsFragment.INSTANCE;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
        String str2 = worksDetailGoodsView.workNo;
        companion.a(supportFragmentManager, str2 != null ? str2 : "", worksDetailGoodsView.workGoodsData);
    }

    private final WorksViewWorksDetailGoodsBinding getBinding() {
        return (WorksViewWorksDetailGoodsBinding) this.binding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setVideoWorks(boolean z) {
        this.isVideoWorks = z;
        Drawable background = getBinding().getRoot().getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(Color.parseColor(z ? "#66000000" : "#F5F5F5"));
        }
        if (z) {
            TextView textView = getBinding().f14819a;
            Resources resources = getResources();
            int i = R.color.white;
            textView.setTextColor(resources.getColor(i));
            getBinding().f37122a.setColorFilter(getResources().getColor(i));
            return;
        }
        TextView textView2 = getBinding().f14819a;
        Resources resources2 = getResources();
        int i2 = R.color.color_2C3E50;
        textView2.setTextColor(resources2.getColor(i2));
        getBinding().f37122a.setColorFilter(getResources().getColor(i2));
    }

    @BindingAdapter({"isVideoWorks"})
    @JvmStatic
    public static final void setWorksDetailGoodsInfo(@NotNull WorksDetailGoodsView worksDetailGoodsView, boolean z) {
        INSTANCE.a(worksDetailGoodsView, z);
    }

    @BindingAdapter({"goodsWorkNo", WorksDetailsGoodsFragment.WORK_GOODS_DATA})
    @JvmStatic
    public static final void setWorksGoods(@Nullable WorksDetailGoodsView worksDetailGoodsView, @NotNull String str, @Nullable GoodsRecommendData goodsRecommendData) {
        INSTANCE.b(worksDetailGoodsView, str, goodsRecommendData);
    }

    public final void setWorkGoodsData(@NotNull String goodsWorkNo, @Nullable GoodsRecommendData workGoodsData) {
        Intrinsics.checkNotNullParameter(goodsWorkNo, "goodsWorkNo");
        this.workNo = goodsWorkNo;
        if (workGoodsData != null) {
            getBinding().k(workGoodsData);
            getBinding().executePendingBindings();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailGoodsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = LazyKt.lazy(new Function0<WorksViewWorksDetailGoodsBinding>() { // from class: com.huachenjie.works.widget.WorksDetailGoodsView$binding$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WorksViewWorksDetailGoodsBinding m992invoke() {
                return (WorksViewWorksDetailGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getContext()), R.layout.works_view_works_detail_goods, this.this$0, true);
            }
        });
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        y57.f(root, 0L, new View.OnClickListener() { // from class: com.zj.adlib.g0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorksDetailGoodsView.b(this.f41790a, view);
            }
        }, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailGoodsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = LazyKt.lazy(new Function0<WorksViewWorksDetailGoodsBinding>() { // from class: com.huachenjie.works.widget.WorksDetailGoodsView$binding$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WorksViewWorksDetailGoodsBinding m992invoke() {
                return (WorksViewWorksDetailGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getContext()), R.layout.works_view_works_detail_goods, this.this$0, true);
            }
        });
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        y57.f(root, 0L, new View.OnClickListener() { // from class: com.zj.adlib.g0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorksDetailGoodsView.b(this.f41790a, view);
            }
        }, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailGoodsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.binding = LazyKt.lazy(new Function0<WorksViewWorksDetailGoodsBinding>() { // from class: com.huachenjie.works.widget.WorksDetailGoodsView$binding$2
            {
                super(0);
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final WorksViewWorksDetailGoodsBinding m992invoke() {
                return (WorksViewWorksDetailGoodsBinding) DataBindingUtil.inflate(LayoutInflater.from(this.this$0.getContext()), R.layout.works_view_works_detail_goods, this.this$0, true);
            }
        });
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        y57.f(root, 0L, new View.OnClickListener() { // from class: com.zj.adlib.g0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorksDetailGoodsView.b(this.f41790a, view);
            }
        }, 1, null);
    }
}
