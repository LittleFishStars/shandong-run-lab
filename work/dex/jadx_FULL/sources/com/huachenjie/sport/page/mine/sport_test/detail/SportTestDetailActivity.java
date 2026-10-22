package com.huachenjie.sport.page.mine.sport_test.detail;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AdministrativeClasse;
import com.huachenjie.sport.bean.CourseClasse;
import com.huachenjie.sport.bean.SportTestDetailBean;
import com.huachenjie.sport.bean.UniqueCode;
import com.huachenjie.sport.databinding.ActivitySportTestDetailBinding;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity;
import com.huachenjie.sport.page.mine.sport_test.informed.InformedDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.e)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001e#B\u0007¢\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J4\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002R\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "r0", "t0", "Lcom/huachenjie/sport/bean/SportTestDetailBean;", "data", "m0", "", "isAgree", "Lkotlin/Function0;", "onAgreeSuccess", "onUnAgreeSuccess", "u0", "", bo.g, "Landroid/widget/LinearLayout$LayoutParams;", "q0", "s", "Landroid/widget/TextView;", "o0", "n0", "initData", "a", "Z", "hasAutoShownInformedDialog", "<init>", "()V", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSportTestDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SportTestDetailActivity.kt\ncom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,199:1\n1#2:200\n*E\n"})
public final class SportTestDetailActivity extends BaseVmActivity<SportTestDetailVM> {

    @NotNull
    public static final String x = "code";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean hasAutoShownInformedDialog;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailActivity$a;", "", "Landroid/view/View;", "v", "", "c", "d", "a", "b", "<init>", "(Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Integer reserveTimeStatus;
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestDetailBean value = ((SportTestDetailVM) ((BaseVmActivity) SportTestDetailActivity.this).f8507a).h().getValue();
            boolean z = false;
            if (value != null && (reserveTimeStatus = value.getReserveTimeStatus()) != null && reserveTimeStatus.intValue() == 2) {
                z = true;
            }
            if (z) {
                Postcard postcardBuild = ARouter.getInstance().build(RoutePathConstants.Sport.f);
                Intent intent = SportTestDetailActivity.this.getIntent();
                Postcard postcardWithString = postcardBuild.withString("testCode", intent != null ? intent.getStringExtra("code") : null);
                UniqueCode uniqueCode = value.getUniqueCode();
                Postcard postcardWithString2 = postcardWithString.withString("yearCode", uniqueCode != null ? uniqueCode.getYearMonthCode() : null);
                UniqueCode uniqueCode2 = value.getUniqueCode();
                Postcard postcardWithString3 = postcardWithString2.withString("dayCode", uniqueCode2 != null ? uniqueCode2.getDayCode() : null);
                UniqueCode uniqueCode3 = value.getUniqueCode();
                postcardWithString3.withString("timeCode", uniqueCode3 != null ? uniqueCode3.getTimeFragmentCode() : null).navigation();
            }
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestDetailBean value = ((SportTestDetailVM) ((BaseVmActivity) SportTestDetailActivity.this).f8507a).h().getValue();
            if (value != null ? Intrinsics.areEqual(value.getCanBeModified(), Boolean.TRUE) : false) {
                a(v);
            }
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestDetailBottomDialog.INSTANCE.a().show(SportTestDetailActivity.this.getSupportFragmentManager(), "explainDialog");
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            SportTestDetailActivity.v0(SportTestDetailActivity.this, true, null, null, 6, null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36717a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36717a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36717a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36717a.invoke(obj);
        }
    }

    public static final void s0(SportTestDetailActivity sportTestDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(sportTestDetailActivity, "this$0");
        sportTestDetailActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v0(SportTestDetailActivity sportTestDetailActivity, boolean z, Function0 function0, Function0 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        sportTestDetailActivity.u0(z, function0, function1);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_sport_test_detail), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        r0();
        t0();
        initData();
    }

    public final void initData() {
        String strP0 = p0();
        if (strP0 != null) {
            ((SportTestDetailVM) ((BaseVmActivity) this).f8507a).n(strP0);
        } else {
            fv5.b("数据异常");
            finish();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void m0(SportTestDetailBean data) {
        if (this.hasAutoShownInformedDialog || !data.getHasInformedConsent() || data.getHasConsent()) {
            return;
        }
        this.hasAutoShownInformedDialog = true;
        u0(false, new Function0<Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity$checkAndShowInformedDialog$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m786invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m786invoke() {
                SportTestDetailBean value = ((SportTestDetailVM) ((BaseVmActivity) this.this$0).f8507a).h().getValue();
                if (value != null) {
                    SportTestDetailActivity sportTestDetailActivity = this.this$0;
                    value.setHasConsent(true);
                    ((SportTestDetailVM) ((BaseVmActivity) sportTestDetailActivity).f8507a).h().setValue(value);
                }
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity$checkAndShowInformedDialog$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m787invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m787invoke() {
                this.this$0.finish();
            }
        });
    }

    public final TextView n0(String s) {
        TextView textView = new TextView(this);
        textView.setText(s);
        textView.setTextColor(zn1.a(R.color.color_666666));
        textView.setTextSize(14.0f);
        return textView;
    }

    public final TextView o0(String s) {
        TextView textView = new TextView(this);
        textView.setText(s);
        textView.setTextColor(zn1.a(R.color.color_333333));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextSize(14.0f);
        return textView;
    }

    public final String p0() {
        String stringExtra;
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("code")) == null || !(!TextUtils.isEmpty(stringExtra))) {
            return null;
        }
        return stringExtra;
    }

    public final LinearLayout.LayoutParams q0() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, SizeUtils.b(10.0f), 0, 0);
        return layoutParams;
    }

    public final void r0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataM = ((SportTestDetailVM) ((BaseVmActivity) this).f8507a).m();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("体质测试");
        int i = R.color.color_333333;
        bindingTitleBean.setTitleTextColor(zn1.a(i));
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(i)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.mn8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTestDetailActivity.s0(this.f43341a, view);
            }
        });
        Integer value = ((BaseVM) ((SportTestDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value == null) {
            iIntValue = 24;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 24");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        mutableLiveDataM.setValue(bindingTitleBean);
    }

    public final void t0() {
        ((SportTestDetailVM) ((BaseVmActivity) this).f8507a).h().observe(this, new c(new Function1<SportTestDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity$observerData$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SportTestDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SportTestDetailBean sportTestDetailBean) {
                ViewDataBinding binding = this.this$0.getBinding();
                Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActivitySportTestDetailBinding");
                ActivitySportTestDetailBinding activitySportTestDetailBinding = (ActivitySportTestDetailBinding) binding;
                Integer fitnessType = sportTestDetailBean.getFitnessType();
                if (fitnessType != null && fitnessType.intValue() == 1) {
                    activitySportTestDetailBinding.f36428a.removeAllViews();
                    List<CourseClasse> courseClasses = sportTestDetailBean.getCourseClasses();
                    if (courseClasses != null) {
                        SportTestDetailActivity sportTestDetailActivity = this.this$0;
                        for (CourseClasse courseClasse : courseClasses) {
                            LinearLayout linearLayout = activitySportTestDetailBinding.f36428a;
                            String teacherNames = courseClasse.getTeacherNames();
                            if (teacherNames == null) {
                                teacherNames = "";
                            }
                            linearLayout.addView(sportTestDetailActivity.o0(teacherNames), sportTestDetailActivity.q0());
                            LinearLayout linearLayout2 = activitySportTestDetailBinding.f36428a;
                            String courses = courseClasse.getCourses();
                            if (courses == null) {
                                courses = "";
                            }
                            linearLayout2.addView(sportTestDetailActivity.n0(courses), sportTestDetailActivity.q0());
                        }
                    }
                    List<AdministrativeClasse> administrativeClasses = sportTestDetailBean.getAdministrativeClasses();
                    if (administrativeClasses != null) {
                        SportTestDetailActivity sportTestDetailActivity2 = this.this$0;
                        for (AdministrativeClasse administrativeClasse : administrativeClasses) {
                            LinearLayout linearLayout3 = activitySportTestDetailBinding.f36428a;
                            String departmentName = administrativeClasse.getDepartmentName();
                            if (departmentName == null) {
                                departmentName = "";
                            }
                            linearLayout3.addView(sportTestDetailActivity2.o0(departmentName), sportTestDetailActivity2.q0());
                            LinearLayout linearLayout4 = activitySportTestDetailBinding.f36428a;
                            String className = administrativeClasse.getClassName();
                            if (className == null) {
                                className = "";
                            }
                            linearLayout4.addView(sportTestDetailActivity2.n0(className), sportTestDetailActivity2.q0());
                        }
                    }
                } else {
                    Integer fitnessType2 = sportTestDetailBean.getFitnessType();
                    if (fitnessType2 != null && fitnessType2.intValue() == 2) {
                        activitySportTestDetailBinding.b.removeAllViews();
                        activitySportTestDetailBinding.b.addView(this.this$0.o0(sportTestDetailBean.getGradeNames()), this.this$0.q0());
                        List<String> departmentNames = sportTestDetailBean.getDepartmentNames();
                        if (departmentNames != null) {
                            SportTestDetailActivity sportTestDetailActivity3 = this.this$0;
                            Iterator<T> it = departmentNames.iterator();
                            while (it.hasNext()) {
                                activitySportTestDetailBinding.b.addView(sportTestDetailActivity3.n0((String) it.next()), sportTestDetailActivity3.q0());
                            }
                        }
                    }
                }
                SportTestDetailActivity sportTestDetailActivity4 = this.this$0;
                Intrinsics.checkNotNullExpressionValue(sportTestDetailBean, o.f);
                sportTestDetailActivity4.m0(sportTestDetailBean);
            }
        }));
    }

    public final void u0(boolean isAgree, Function0<Unit> onAgreeSuccess, Function0<Unit> onUnAgreeSuccess) {
        String strP0 = p0();
        if (strP0 == null) {
            fv5.b("数据异常");
            return;
        }
        InformedDialog informedDialogA = InformedDialog.INSTANCE.a(isAgree, strP0);
        informedDialogA.setOnAgreeSuccess(onAgreeSuccess);
        informedDialogA.setOnUnAgreeSuccess(onUnAgreeSuccess);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        informedDialogA.show(supportFragmentManager, "INFORMED_DIALOG");
    }
}
