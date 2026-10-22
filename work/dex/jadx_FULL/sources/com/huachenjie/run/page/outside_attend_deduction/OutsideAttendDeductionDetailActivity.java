package com.huachenjie.run.page.outside_attend_deduction;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivityOutsideAttendDeductionDetailBinding;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;
import com.zj.adlib.y6b;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001-B\u0007¢\u0006\u0004\b+\u0010,J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0019\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u001b\u0010\u001f\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010#R#\u0010*\u001a\n &*\u0004\u0018\u00010%0%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0013\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/huachenjie/run/page/outside_attend_deduction/OutsideAttendDeductionDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityOutsideAttendDeductionDetailBinding;", "Lcom/huachenjie/run/page/outside_attend_deduction/OutsideAttendDeductionDetailVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "o0", "", "darkMode", "e0", "m0", "", "b", "Lkotlin/Lazy;", "g0", "()Ljava/lang/String;", "deductionDistance", "c", "h0", "deductionTimes", "d", "k0", "semesterCode", "e", "j0", DetailActivity.x, "", "f", "l0", "()F", "titleHeight", "Landroid/view/View;", "kotlin.jvm.PlatformType", y6b.f, "i0", "()Landroid/view/View;", "mHeaderView", "<init>", "()V", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class OutsideAttendDeductionDetailActivity extends BaseMVVMActivity<RunActivityOutsideAttendDeductionDetailBinding, OutsideAttendDeductionDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "deductionDistance";

    @NotNull
    public static final String x = "deductionTimes";

    @NotNull
    public static final String y = "semesterCode";

    @NotNull
    public static final String z = "runPlanCode";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy deductionDistance = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$deductionDistance$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("deductionDistance");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy deductionTimes = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$deductionTimes$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("deductionTimes");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy semesterCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$semesterCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("semesterCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy planCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$planCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("runPlanCode");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy titleHeight = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$titleHeight$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Float m659invoke() {
            float dimension = this.this$0.getResources().getDimension(R.dimen.title_bar_height);
            Integer value = this.this$0.getMViewModel().e().c().getValue();
            if (value == null) {
                value = 0;
            }
            return Float.valueOf(dimension + value.floatValue());
        }
    });

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final Lazy mHeaderView = LazyKt.lazy(new Function0<View>() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$mHeaderView$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final View m656invoke() {
            return this.this$0.getLayoutInflater().inflate(R.layout.run_layout_outside_attend_deduction_detail_header, (ViewGroup) null, false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/outside_attend_deduction/OutsideAttendDeductionDetailActivity$a;", "", "Landroid/content/Context;", "context", "", "deductionDistance", "deductionTimes", "semesterCode", DetailActivity.x, "", PerfId.startActivity, "KEY_DEDUCTION_DISTANCE", "Ljava/lang/String;", "KEY_DEDUCTION_TIMES", "KEY_PLAN_CODE", "KEY_SEMESTER_CODE", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context, @NotNull String deductionDistance, @NotNull String deductionTimes, @NotNull String semesterCode, @NotNull String planCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(deductionDistance, "deductionDistance");
            Intrinsics.checkNotNullParameter(deductionTimes, "deductionTimes");
            Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
            Intrinsics.checkNotNullParameter(planCode, DetailActivity.x);
            context.startActivity(new Intent(context, (Class<?>) OutsideAttendDeductionDetailActivity.class).putExtra("deductionDistance", deductionDistance).putExtra("deductionTimes", deductionTimes).putExtra("semesterCode", semesterCode).putExtra("runPlanCode", planCode));
        }
    }

    public static final void f0(OutsideAttendDeductionDetailActivity outsideAttendDeductionDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(outsideAttendDeductionDetailActivity, "this$0");
        outsideAttendDeductionDetailActivity.finish();
    }

    public static final void n0(OutsideAttendDeductionDetailActivity outsideAttendDeductionDetailActivity) {
        Intrinsics.checkNotNullParameter(outsideAttendDeductionDetailActivity, "this$0");
        outsideAttendDeductionDetailActivity.getMViewModel().n();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()));
    }

    public final void e0(boolean darkMode) {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean titleName = new BindingTitleBean().setTitleName("课外考勤抵扣");
        int i = R.color.color_2C3E50;
        BindingTitleBean backClick = titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackground(zn1.a(darkMode ? R.color.white : R.color.transparent)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.yg6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OutsideAttendDeductionDetailActivity.f0(this.f46027a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(backClick.setStatusBarHeight(value.intValue()));
    }

    public final String g0() {
        return (String) this.deductionDistance.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_outside_attend_deduction_detail;
    }

    public final String h0() {
        return (String) this.deductionTimes.getValue();
    }

    public final View i0() {
        return (View) this.mHeaderView.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().p();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        e0(false);
        o0();
        m0();
        getMViewModel().m().setValue(k0());
        getMViewModel().l().setValue(j0());
    }

    public final String j0() {
        return (String) this.planCode.getValue();
    }

    public final String k0() {
        return (String) this.semesterCode.getValue();
    }

    public final float l0() {
        return ((Number) this.titleHeight.getValue()).floatValue();
    }

    public final void m0() {
        MutableLiveData<OutsideAttendDeductionDetailAdapter> mutableLiveDataJ = getMViewModel().j();
        OutsideAttendDeductionDetailAdapter outsideAttendDeductionDetailAdapter = new OutsideAttendDeductionDetailAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.tv_empty)).setText("暂无数据…");
        viewInflate.setBackgroundColor(-1);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…olor.WHITE)\n            }");
        outsideAttendDeductionDetailAdapter.g(viewInflate);
        outsideAttendDeductionDetailAdapter.setHeaderWithEmptyEnable(true);
        View viewFindViewById = i0().findViewById(R.id.tv_deduction_km_title);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.tv_deduction_km_title)");
            if (viewFindViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ((int) l0()) + jj8.a(30.0f);
            }
        }
        TextView textView = (TextView) i0().findViewById(R.id.tv_deduction_km);
        if (textView != null) {
            textView.setText(g0());
        }
        TextView textView2 = (TextView) i0().findViewById(R.id.tv_deduction_times);
        if (textView2 != null) {
            textView2.setText(h0());
        }
        View viewI0 = i0();
        Intrinsics.checkNotNullExpressionValue(viewI0, "mHeaderView");
        BaseQuickAdapter.setHeaderView$default(outsideAttendDeductionDetailAdapter, viewI0, 0, 0, 6, null);
        outsideAttendDeductionDetailAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.xg6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OutsideAttendDeductionDetailActivity.n0(this.f45818a);
            }
        });
        mutableLiveDataJ.setValue(outsideAttendDeductionDetailAdapter);
        getMBinding().f35484a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity$initAdapter$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                this.f35890a.e0(((double) (((float) recyclerView.computeVerticalScrollOffset()) / this.f35890a.l0())) > 0.5d);
            }
        });
    }

    public final void o0() {
        e.p3(this).G2(R.color.transparent).T2(true).q1(false).u1(R.color.white).G1(true).a1();
    }
}
