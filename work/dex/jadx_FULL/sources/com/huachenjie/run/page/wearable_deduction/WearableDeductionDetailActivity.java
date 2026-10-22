package com.huachenjie.run.page.wearable_deduction;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.WearableDeductionSummaryBean;
import com.huachenjie.run.databinding.RunActivityWearableDeductionDetailBinding;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0007¢\u0006\u0004\b\"\u0010#J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001b\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR#\u0010!\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/huachenjie/run/page/wearable_deduction/WearableDeductionDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityWearableDeductionDetailBinding;", "Lcom/huachenjie/run/page/wearable_deduction/WearableDeductionDetailVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "m0", "", "darkMode", "f0", "k0", "", "b", "Lkotlin/Lazy;", "i0", "()Ljava/lang/String;", DetailActivity.x, "", "c", "j0", "()F", "titleHeight", "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "h0", "()Landroid/view/View;", "mHeaderView", "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class WearableDeductionDetailActivity extends BaseMVVMActivity<RunActivityWearableDeductionDetailBinding, WearableDeductionDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "runPlanCode";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy planCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity$planCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("runPlanCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy titleHeight = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity$titleHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m728invoke() {
            float dimension = this.this$0.getResources().getDimension(R.dimen.title_bar_height);
            Integer value = this.this$0.getMViewModel().e().c().getValue();
            if (value == null) {
                value = 0;
            }
            return Float.valueOf(dimension + value.floatValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy mHeaderView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity$mHeaderView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final View m726invoke() {
            return this.this$0.getLayoutInflater().inflate(R.layout.run_layout_wearable_deduction_detail_header, (ViewGroup) null, false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/run/page/wearable_deduction/WearableDeductionDetailActivity$a;", "", "Landroid/content/Context;", "context", "", DetailActivity.x, "", PerfId.startActivity, "KEY_PLAN_CODE", "Ljava/lang/String;", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull String planCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(planCode, DetailActivity.x);
            context.startActivity(new Intent(context, (Class<?>) WearableDeductionDetailActivity.class).putExtra("runPlanCode", planCode));
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35976a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35976a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35976a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35976a.invoke(obj);
        }
    }

    public static final void g0(WearableDeductionDetailActivity wearableDeductionDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(wearableDeductionDetailActivity, "this$0");
        wearableDeductionDetailActivity.finish();
    }

    public static final void l0(WearableDeductionDetailActivity wearableDeductionDetailActivity) {
        Intrinsics.checkNotNullParameter(wearableDeductionDetailActivity, "this$0");
        wearableDeductionDetailActivity.getMViewModel().o();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    public final void f0(boolean darkMode) {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName("运动手表抵扣");
        int i = R.color.color_2C3E50;
        BindingTitleBean backClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackground(zn1.a(darkMode ? R.color.white : R.color.transparent)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.iu9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WearableDeductionDetailActivity.g0(this.f42446a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(backClick.setStatusBarHeight(value.intValue()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_wearable_deduction_detail;
    }

    public final View h0() {
        return (View) this.mHeaderView.getValue();
    }

    public final String i0() {
        return (String) this.planCode.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().m().observe(this, new b(new Function1<WearableDeductionSummaryBean, Unit>() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity.initData.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WearableDeductionSummaryBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WearableDeductionSummaryBean wearableDeductionSummaryBean) {
                String times;
                String distance;
                TextView textView = (TextView) WearableDeductionDetailActivity.this.h0().findViewById(R.id.tv_deduction_km);
                if (textView != null) {
                    if (wearableDeductionSummaryBean == null || (distance = wearableDeductionSummaryBean.formatDistance()) == null) {
                        distance = "0.00";
                    }
                    textView.setText(distance);
                }
                TextView textView2 = (TextView) WearableDeductionDetailActivity.this.h0().findViewById(R.id.tv_deduction_times);
                if (textView2 == null) {
                    return;
                }
                if (wearableDeductionSummaryBean == null || (times = wearableDeductionSummaryBean.formatTimes()) == null) {
                    times = "0";
                }
                textView2.setText(times);
            }
        }));
        getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        f0(false);
        m0();
        k0();
        getMViewModel().l().setValue(i0());
    }

    public final float j0() {
        return ((Number) this.titleHeight.getValue()).floatValue();
    }

    public final void k0() {
        MutableLiveData<WearableDeductionDetailAdapter> mutableLiveDataJ = getMViewModel().j();
        WearableDeductionDetailAdapter wearableDeductionDetailAdapter = new WearableDeductionDetailAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText("暂无数据…");
        viewInflate.setBackgroundColor(-1);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…olor.WHITE)\n            }");
        wearableDeductionDetailAdapter.g(viewInflate);
        wearableDeductionDetailAdapter.setHeaderWithEmptyEnable(true);
        View viewFindViewById = h0().findViewById(R.id.tv_deduction_km_title);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.tv_deduction_km_title)");
            if (viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((int) j0()) + jj8.a(30.0f);
            }
        }
        View viewH0 = h0();
        Intrinsics.checkNotNullExpressionValue(viewH0, "mHeaderView");
        BaseQuickAdapter.setHeaderView$default(wearableDeductionDetailAdapter, viewH0, 0, 0, 6, null);
        wearableDeductionDetailAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.hu9
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                WearableDeductionDetailActivity.l0(this.f42210a);
            }
        });
        mutableLiveDataJ.setValue(wearableDeductionDetailAdapter);
        getMBinding().f35514a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity$initAdapter$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.f35977a.f0(((double) (((float) recyclerView.computeVerticalScrollOffset()) / this.f35977a.j0())) > 0.5d);
            }
        });
    }

    public final void m0() {
        e.p3(this).G2(R.color.transparent).T2(true).q1(false).u1(R.color.white).G1(true).a1();
    }
}
