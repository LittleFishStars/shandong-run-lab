package com.huachenjie.run.page.activities_run;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coroutines.DataBindingUtil;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.ActivityRunDetailBean;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.binding_adapter.FlowAdapter;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.databinding.RunActivityActivityRuleBinding;
import com.huachenjie.run.databinding.RunHeadActivityRuleBinding;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.run.utils.StartRunUtils;
import com.zj.adlib.ai9;
import com.zj.adlib.kl7;
import com.zj.adlib.lk0;
import com.zj.adlib.zn1;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
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
@Route(extras = 1, path = RoutePathConstants.Run.i)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001f\u0011B\u0007¢\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0017\u0010&\u001a\u00020\"8\u0006¢\u0006\f\n\u0004\b\u001f\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/huachenjie/run/page/activities_run/DetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityActivityRuleBinding;", "Lcom/huachenjie/run/page/activities_run/DetailActivityVM;", "", "getLayoutResID", "", "", "V", "", "W", "initView", "initData", "j0", "k0", "i0", "", "b", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "activityCode", "c", "h0", DetailActivity.x, "Lcom/huachenjie/run/databinding/RunHeadActivityRuleBinding;", "d", "g0", "()Lcom/huachenjie/run/databinding/RunHeadActivityRuleBinding;", "headBinding", "Lcom/huachenjie/run/utils/StartRunUtils;", "a", "Lcom/huachenjie/run/utils/StartRunUtils;", "startRunUtils", "Lcom/huachenjie/common/binding_adapter/FlowAdapter;", "Lcom/huachenjie/common/binding_adapter/FlowAdapter;", "f0", "()Lcom/huachenjie/common/binding_adapter/FlowAdapter;", "flowAdapter", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class DetailActivity extends BaseMVVMActivity<RunActivityActivityRuleBinding, DetailActivityVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "activityCode";

    @NotNull
    public static final String x = "planCode";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public StartRunUtils startRunUtils;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy activityCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.activities_run.DetailActivity$activityCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra("activityCode")) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy planCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.activities_run.DetailActivity$planCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra;
            Intent intent = this.this$0.getIntent();
            return (intent == null || (stringExtra = intent.getStringExtra(DetailActivity.x)) == null) ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy headBinding = LazyKt.lazy(new Function0<RunHeadActivityRuleBinding>() { // from class: com.huachenjie.run.page.activities_run.DetailActivity$headBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RunHeadActivityRuleBinding m636invoke() {
            return (RunHeadActivityRuleBinding) DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.run_head_activity_rule, null, false);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FlowAdapter flowAdapter = new c();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/run/page/activities_run/DetailActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/run/page/activities_run/DetailActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            StartRunUtils startRunUtils;
            if (DetailActivity.c0(DetailActivity.this).i(1) || (startRunUtils = DetailActivity.this.startRunUtils) == null) {
                return;
            }
            int iE = (int) kl7.f42851a.e(DetailActivity.c0(DetailActivity.this).t().getValue(), DetailActivity.c0(DetailActivity.this).n().getValue());
            String strE0 = DetailActivity.this.e0();
            SunshineRunDetail value = DetailActivity.c0(DetailActivity.this).n().getValue();
            Intrinsics.checkNotNull(value);
            SunshineRunDetail sunshineRunDetail = value;
            List<GeoFenceDetail> value2 = DetailActivity.c0(DetailActivity.this).l().getValue();
            RunPlanBean value3 = DetailActivity.c0(DetailActivity.this).k().getValue();
            startRunUtils.l0(1, 1, iE, 0, strE0, sunshineRunDetail, value2, value3 != null ? value3.getRunPlanCode() : null, false);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.run.page.activities_run.DetailActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/run/page/activities_run/DetailActivity$b;", "", "Landroid/content/Context;", "context", "", "activityCode", DetailActivity.x, "", "a", "ACTIVITY_CODE", "Ljava/lang/String;", "PLAN_CODE", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String activityCode, @NotNull String planCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(activityCode, "activityCode");
            Intrinsics.checkNotNullParameter(planCode, DetailActivity.x);
            Intent intent = new Intent(context, (Class<?>) DetailActivity.class);
            intent.putExtra("activityCode", activityCode);
            intent.putExtra(DetailActivity.x, planCode);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/huachenjie/run/page/activities_run/DetailActivity$c", "Lcom/huachenjie/common/binding_adapter/FlowAdapter;", "T", "Landroid/content/Context;", "context", "obj", "Landroid/view/View;", "a", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/view/View;", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements FlowAdapter {
        @Override // com.huachenjie.common.binding_adapter.FlowAdapter
        @Nullable
        public <T> View a(@Nullable Context context, T obj) {
            if (!(obj instanceof String)) {
                return null;
            }
            TextView textView = new TextView(context);
            textView.setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
            textView.setText((CharSequence) obj);
            textView.setTextSize(14.0f);
            textView.setTextColor(-13877680);
            textView.setId(View.generateViewId());
            return textView;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35778a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35778a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35778a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35778a.invoke(obj);
        }
    }

    public static final /* synthetic */ DetailActivityVM c0(DetailActivity detailActivity) {
        return detailActivity.getMViewModel();
    }

    public static final void l0(DetailActivity detailActivity, View view) {
        Intrinsics.checkNotNullParameter(detailActivity, "this$0");
        detailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().t().observe(this, new d(new Function1<ActivityRunDetailBean, Unit>() { // from class: com.huachenjie.run.page.activities_run.DetailActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ActivityRunDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ActivityRunDetailBean activityRunDetailBean) {
                this.this$0.g0().setVariable(lk0.r, this.this$0.getFlowAdapter());
                this.this$0.g0().setVariable(lk0.L, DetailActivity.c0(this.this$0).t().getValue());
                this.this$0.g0().executePendingBindings();
            }
        }));
    }

    public final String e0() {
        return (String) this.activityCode.getValue();
    }

    @NotNull
    /* JADX INFO: renamed from: f0, reason: from getter */
    public final FlowAdapter getFlowAdapter() {
        return this.flowAdapter;
    }

    public final RunHeadActivityRuleBinding g0() {
        Object value = this.headBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-headBinding>(...)");
        return (RunHeadActivityRuleBinding) value;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_activity_rule;
    }

    public final String h0() {
        return (String) this.planCode.getValue();
    }

    public final void i0() {
        g0().setLifecycleOwner(this);
        g0().getRoot().setTag("ActivityRuleHead");
        ActivityRuleAdapter activityRuleAdapter = new ActivityRuleAdapter();
        View root = g0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headBinding.root");
        BaseQuickAdapter.setHeaderView$default(activityRuleAdapter, root, 0, 0, 6, null);
        getMViewModel().v().setValue(activityRuleAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        MutableLiveData<RunPlanBean> mutableLiveDataK = getMViewModel().k();
        String strH0 = h0();
        Intrinsics.checkNotNullExpressionValue(strH0, x);
        mutableLiveDataK.setValue(new RunPlanBean(strH0, "", 1, null, 0, 0, 56, null));
        getMViewModel().r(1);
        getMViewModel().s(ai9.e().getSchoolCode());
        DetailActivityVM mViewModel = getMViewModel();
        String strE0 = e0();
        Intrinsics.checkNotNullExpressionValue(strE0, "activityCode");
        mViewModel.y(strE0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        j0();
        k0();
        i0();
    }

    public final void j0() {
        this.startRunUtils = new StartRunUtils(this, getMViewModel());
    }

    public final void k0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("活动详情");
        int iIntValue = 0;
        bindingTitleBean.setShowDivider(false);
        Integer value = getMViewModel().e().b().getValue();
        if (value != null) {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.hcj_header_txt));
        int i = R.color.white;
        bindingTitleBean.setBackground(zn1.a(i));
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.tk2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DetailActivity.l0(this.f44940a, view);
            }
        });
        e.p3(this).G2(R.color.transparent).T2(true).u1(i).G1(true).a1();
        getMViewModel().x().setValue(bindingTitleBean);
    }
}
