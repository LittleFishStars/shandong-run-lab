package com.huachenjie.run.page.rule;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.RunTimeAreaData;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunActivitySchoolRuleV3Binding;
import com.zj.adlib.dw7;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.lk0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.m)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u001bB\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\"\u0010\u0013\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0002R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0019¨\u0006!"}, d2 = {"Lcom/huachenjie/run/page/rule/RuleV3Activity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/run/page/rule/RuleV3VM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "k0", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "j0", "h0", "", "timeType", "", "Lcom/huachenjie/common/bean/RunTimeAreaData;", "datas", "i0", "Lcom/huachenjie/common/bean/SchoolRule;", "a", "Lcom/huachenjie/common/bean/SchoolRule;", RuleV3Activity.x, "Lcom/huachenjie/run/page/rule/RunTimePeriodAdapter;", "Lcom/huachenjie/run/page/rule/RunTimePeriodAdapter;", "mEverdayAdapter", "b", "mWorkdayAdapter", "c", "mWeekendAdapter", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRuleV3Activity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RuleV3Activity.kt\ncom/huachenjie/run/page/rule/RuleV3Activity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,167:1\n766#2:168\n857#2,2:169\n766#2:171\n857#2,2:172\n766#2:174\n857#2,2:175\n*S KotlinDebug\n*F\n+ 1 RuleV3Activity.kt\ncom/huachenjie/run/page/rule/RuleV3Activity\n*L\n89#1:168\n89#1:169,2\n91#1:171\n91#1:172,2\n93#1:174\n93#1:175,2\n*E\n"})
public final class RuleV3Activity extends BaseVmActivity<RuleV3VM> {

    @NotNull
    public static final String x = "schoolRule";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Autowired(name = x)
    @JvmField
    @Nullable
    public SchoolRule schoolRule;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunTimePeriodAdapter mEverdayAdapter;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public RunTimePeriodAdapter mWorkdayAdapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public RunTimePeriodAdapter mWeekendAdapter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/rule/RuleV3Activity$a;", "", "Landroid/view/View;", "v", "", "c", "b", "a", "<init>", "(Lcom/huachenjie/run/page/rule/RuleV3Activity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            RuleV3Activity.this.finish();
        }

        public final void b(@Nullable View v) {
            ARouter.getInstance().build(RoutePathConstants.Run.g).navigation();
        }

        public final void c(@Nullable View v) throws UnsupportedEncodingException {
            SchoolRule value = ((RuleV3VM) ((BaseVmActivity) RuleV3Activity.this).f8507a).l().getValue();
            String str = value != null ? value.fileUrl : null;
            if (str == null || str.length() == 0) {
                fv5.b("文件地址为空");
                return;
            }
            String strEncode = URLEncoder.encode(str, "UTF-8");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = RuleV3Activity.this.getResources().getString(R.string.pdf_link_format);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.pdf_link_format)");
            String str2 = String.format(string, Arrays.copyOf(new Object[]{strEncode}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("title", "学校规则附件").withString("url", str2).navigation();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35908a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35908a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35908a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35908a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.run_activity_school_rule_v3), Integer.valueOf(lk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(lk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void h0() {
    }

    public final void i0(String timeType, List<RunTimeAreaData> datas) {
        RunTimePeriodAdapter runTimePeriodAdapter;
        if (timeType == null) {
            return;
        }
        List<RunTimeAreaData> list = datas;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (Intrinsics.areEqual(timeType, SchoolRule.RUN_TIME_TYPE_ERVERY_DAY)) {
            RunTimePeriodAdapter runTimePeriodAdapter2 = this.mEverdayAdapter;
            if (runTimePeriodAdapter2 != null) {
                runTimePeriodAdapter2.setList(list);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(timeType, SchoolRule.RUN_TIME_TYPE_WORKDAY)) {
            RunTimePeriodAdapter runTimePeriodAdapter3 = this.mWorkdayAdapter;
            if (runTimePeriodAdapter3 != null) {
                runTimePeriodAdapter3.setList(list);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(timeType, SchoolRule.RUN_TIME_TYPE_WEEKEND) || (runTimePeriodAdapter = this.mWeekendAdapter) == null) {
            return;
        }
        runTimePeriodAdapter.setList(list);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        k0();
        h0();
        this.mEverdayAdapter = new RunTimePeriodAdapter();
        RuleV3VM ruleV3VM = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<RunTimePeriodAdapter> mutableLiveDataM = ruleV3VM != null ? ruleV3VM.m() : null;
        if (mutableLiveDataM != null) {
            mutableLiveDataM.setValue(this.mEverdayAdapter);
        }
        RuleV3VM ruleV3VM2 = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<FlexboxLayoutManager> mutableLiveDataH = ruleV3VM2 != null ? ruleV3VM2.h() : null;
        if (mutableLiveDataH != null) {
            mutableLiveDataH.setValue(j0());
        }
        this.mWorkdayAdapter = new RunTimePeriodAdapter();
        RuleV3VM ruleV3VM3 = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<RunTimePeriodAdapter> mutableLiveDataO = ruleV3VM3 != null ? ruleV3VM3.o() : null;
        if (mutableLiveDataO != null) {
            mutableLiveDataO.setValue(this.mWorkdayAdapter);
        }
        RuleV3VM ruleV3VM4 = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<FlexboxLayoutManager> mutableLiveDataI = ruleV3VM4 != null ? ruleV3VM4.i() : null;
        if (mutableLiveDataI != null) {
            mutableLiveDataI.setValue(j0());
        }
        this.mWeekendAdapter = new RunTimePeriodAdapter();
        RuleV3VM ruleV3VM5 = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<RunTimePeriodAdapter> mutableLiveDataN = ruleV3VM5 != null ? ruleV3VM5.n() : null;
        if (mutableLiveDataN != null) {
            mutableLiveDataN.setValue(this.mWeekendAdapter);
        }
        RuleV3VM ruleV3VM6 = (RuleV3VM) ((BaseVmActivity) this).f8507a;
        MutableLiveData<FlexboxLayoutManager> mutableLiveDataJ = ruleV3VM6 != null ? ruleV3VM6.j() : null;
        if (mutableLiveDataJ == null) {
            return;
        }
        mutableLiveDataJ.setValue(j0());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((RuleV3VM) ((BaseVmActivity) this).f8507a).k().observe(this, new c(new Function1<List<? extends RunTimeAreaData>, Unit>() { // from class: com.huachenjie.run.page.rule.RuleV3Activity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<RunTimeAreaData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<RunTimeAreaData> list) {
                RuleV3Activity.this.i0(SchoolRule.RUN_TIME_TYPE_ERVERY_DAY, list);
            }
        }));
        ((RuleV3VM) ((BaseVmActivity) this).f8507a).q().observe(this, new c(new Function1<List<? extends RunTimeAreaData>, Unit>() { // from class: com.huachenjie.run.page.rule.RuleV3Activity.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<RunTimeAreaData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<RunTimeAreaData> list) {
                RuleV3Activity.this.i0(SchoolRule.RUN_TIME_TYPE_WORKDAY, list);
            }
        }));
        ((RuleV3VM) ((BaseVmActivity) this).f8507a).p().observe(this, new c(new Function1<List<? extends RunTimeAreaData>, Unit>() { // from class: com.huachenjie.run.page.rule.RuleV3Activity.initViewModel.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<RunTimeAreaData>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<RunTimeAreaData> list) {
                RuleV3Activity.this.i0(SchoolRule.RUN_TIME_TYPE_WEEKEND, list);
            }
        }));
    }

    public final FlexboxLayoutManager j0() {
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setFlexDirection(2);
        flexboxLayoutManager.setFlexWrap(0);
        flexboxLayoutManager.setJustifyContent(0);
        return flexboxLayoutManager;
    }

    public final void k0() {
        ArrayList arrayList;
        ArrayList arrayList2;
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.run.databinding.RunActivitySchoolRuleV3Binding");
        RunActivitySchoolRuleV3Binding runActivitySchoolRuleV3Binding = (RunActivitySchoolRuleV3Binding) binding;
        SchoolRule schoolRule = this.schoolRule;
        if (schoolRule != null) {
            ((RuleV3VM) ((BaseVmActivity) this).f8507a).l().setValue(schoolRule);
            MutableLiveData<List<RunTimeAreaData>> mutableLiveDataK = ((RuleV3VM) ((BaseVmActivity) this).f8507a).k();
            List<RunTimeAreaData> list = schoolRule.timeFragment;
            ArrayList arrayList3 = null;
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "timeFragment");
                arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics.areEqual(SchoolRule.RUN_TIME_TYPE_ERVERY_DAY, ((RunTimeAreaData) obj).getTimeType())) {
                        arrayList.add(obj);
                    }
                }
            } else {
                arrayList = null;
            }
            mutableLiveDataK.setValue(arrayList);
            MutableLiveData<List<RunTimeAreaData>> mutableLiveDataQ = ((RuleV3VM) ((BaseVmActivity) this).f8507a).q();
            List<RunTimeAreaData> list2 = schoolRule.timeFragment;
            if (list2 != null) {
                Intrinsics.checkNotNullExpressionValue(list2, "timeFragment");
                arrayList2 = new ArrayList();
                for (Object obj2 : list2) {
                    if (Intrinsics.areEqual(SchoolRule.RUN_TIME_TYPE_WORKDAY, ((RunTimeAreaData) obj2).getTimeType())) {
                        arrayList2.add(obj2);
                    }
                }
            } else {
                arrayList2 = null;
            }
            mutableLiveDataQ.setValue(arrayList2);
            MutableLiveData<List<RunTimeAreaData>> mutableLiveDataP = ((RuleV3VM) ((BaseVmActivity) this).f8507a).p();
            List<RunTimeAreaData> list3 = schoolRule.timeFragment;
            if (list3 != null) {
                Intrinsics.checkNotNullExpressionValue(list3, "timeFragment");
                arrayList3 = new ArrayList();
                for (Object obj3 : list3) {
                    if (Intrinsics.areEqual(SchoolRule.RUN_TIME_TYPE_WEEKEND, ((RunTimeAreaData) obj3).getTimeType())) {
                        arrayList3.add(obj3);
                    }
                }
            }
            mutableLiveDataP.setValue(arrayList3);
            dw7 dw7Var = dw7.f41295a;
            dw7Var.a(runActivitySchoolRuleV3Binding, schoolRule);
            TextView textView = runActivitySchoolRuleV3Binding.c;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.tvDisAndTimesLabel");
            TextView textView2 = runActivitySchoolRuleV3Binding.b;
            Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.tvDisAndTimes");
            dw7Var.b(textView, textView2, schoolRule);
        }
    }
}
