package com.huachenjie.sport.page.mine.choose_classes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.ClassDetailBean;
import com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity;
import com.zj.adlib.d60;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002¨\u0006\u0010"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "j0", "h0", "<init>", "()V", "a", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ClassesDetailActivity extends BaseVmActivity<ClassesDetailVM> {

    @NotNull
    public static final String x = "code";

    @NotNull
    public static final String y = "isFromMyCourse";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nClassesDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassesDetailActivity.kt\ncom/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity$ClickProxy\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n1#2:168\n*E\n"})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            String courseCode;
            Intrinsics.checkNotNullParameter(v, "v");
            ClassDetailBean value = ((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).m().getValue();
            if (value == null) {
                return;
            }
            Long value2 = ((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).w().getValue();
            if (value2 == null) {
                value2 = Long.valueOf(System.currentTimeMillis());
            }
            long jLongValue = value2.longValue();
            Long value3 = ((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).p().getValue();
            if (value3 == null) {
                value3 = 0L;
            }
            if (jLongValue > value3.longValue()) {
                return;
            }
            if (!((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).getCom.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity.y java.lang.String()) {
                if (Intrinsics.areEqual(value.getSelected(), Boolean.TRUE)) {
                    return;
                }
                Integer remainCount = value.getRemainCount();
                if ((remainCount != null ? remainCount.intValue() : 0) <= 0) {
                    return;
                }
                ((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).h();
                return;
            }
            Integer signUpStatus = value.getSignUpStatus();
            if (signUpStatus != null && signUpStatus.intValue() == 2 && Intrinsics.areEqual(value.getSelected(), Boolean.TRUE) && (courseCode = value.getCourseCode()) != null) {
                ((ClassesDetailVM) ((BaseVmActivity) ClassesDetailActivity.this).f8507a).q(courseCode);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36629a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36629a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36629a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36629a.invoke(obj);
        }
    }

    public static final void i0(ClassesDetailActivity classesDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(classesDetailActivity, "this$0");
        classesDetailActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_classes_detail), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void h0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataY = ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).y();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("课程详情");
        Integer value = ((BaseVM) ((ClassesDetailVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        if (value == null) {
            iIntValue = 24;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mState.statusBarHeight.value ?: 24");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        int i = R.color.color_333333;
        bindingTitleBean.setTitleTextColor(zn1.a(i));
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(i)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ul1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClassesDetailActivity.i0(this.f45170a, view);
            }
        });
        mutableLiveDataY.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        String stringExtra;
        h0();
        j0();
        Intent intent = getIntent();
        if (intent == null || (stringExtra = intent.getStringExtra("code")) == null) {
            stringExtra = "";
        }
        ClassesDetailVM classesDetailVM = (ClassesDetailVM) ((BaseVmActivity) this).f8507a;
        Intent intent2 = getIntent();
        classesDetailVM.H(intent2 != null ? intent2.getBooleanExtra(y, false) : false);
        if (TextUtils.isEmpty(stringExtra)) {
            fv5.b("未查询到课程信息");
            finish();
        } else {
            ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).G(stringExtra);
            ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).E();
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).v().observe(this, new c(new ClassesDetailActivity$observerData$1(this)));
        ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).x().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity$observerData$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (bool != null) {
                    ClassesDetailActivity classesDetailActivity = this.this$0;
                    if (bool.booleanValue()) {
                        Activity activityC = ActivityLifecycleManager.l().c(MyChooseClassesActivity.class);
                        if (activityC != null) {
                            activityC.finish();
                        }
                        if (ActivityLifecycleManager.l().c(ChooseClassesActivity.class) == null) {
                            ARouter.getInstance().build(RoutePathConstants.Sport.g).navigation();
                        }
                        classesDetailActivity.finish();
                    }
                }
            }
        }));
        ((ClassesDetailVM) ((BaseVmActivity) this).f8507a).s().observe(this, new c(new Function1<Long, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity$observerData$3

            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity$observerData$3$a", "Lcom/huachenjie/common/util/DialogUtil$PositiveNegativeClickListener;", "", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
            public static final class a extends DialogUtil.PositiveNegativeClickListener {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ClassesDetailActivity f36630a;

                /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailActivity$observerData$3$a$a, reason: collision with other inner class name */
                @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailActivity$observerData$3$a$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
                public static final class C0826a extends DialogVMSubscriber<Object> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ ClassesDetailActivity f36631a;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C0826a(ClassesDetailActivity classesDetailActivity, ClassesDetailVM classesDetailVM) {
                        super(classesDetailVM, true);
                        this.f36631a = classesDetailActivity;
                    }

                    public void onCCSuccess(@Nullable Object data) {
                        fv5.b("在线选课成功");
                        Intent intent = new Intent();
                        intent.putExtra("ChooseSuccess", true);
                        this.f36631a.setResult(-1, intent);
                        this.f36631a.finish();
                    }

                    public void onFailed(int code, @Nullable String message) {
                        super.onFailed(code, message);
                        if (code == 6001 || code == 6002) {
                            ((ClassesDetailVM) ((BaseVmActivity) this.f36631a).f8507a).E();
                        }
                    }
                }

                public a(ClassesDetailActivity classesDetailActivity) {
                    this.f36630a = classesDetailActivity;
                }

                @Override // com.huachenjie.common.util.DialogUtil.PositiveNegativeClickListener
                public void b() {
                    ((ClassesDetailVM) ((BaseVmActivity) this.f36630a).f8507a).r().P(((ClassesDetailVM) ((BaseVmActivity) this.f36630a).f8507a).getCode()).u5(Schedulers.io()).G3(d60.c()).p5(new C0826a(this.f36630a, (ClassesDetailVM) ((BaseVmActivity) this.f36630a).f8507a));
                }
            }

            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                long jCurrentTimeMillis = l == null ? System.currentTimeMillis() : l.longValue();
                Long value = ((ClassesDetailVM) ((BaseVmActivity) this.this$0).f8507a).p().getValue();
                if (value == null) {
                    value = 0L;
                }
                if (jCurrentTimeMillis <= value.longValue()) {
                    DialogUtil.h("确定选择该课程为我的体育课吗？", "我再想想", "确定", new a(this.this$0)).create(this.this$0).show();
                    return;
                }
                fv5.b("选课已结束");
                ((ClassesDetailVM) ((BaseVmActivity) this.this$0).f8507a).w().setValue(l);
                ((ClassesDetailVM) ((BaseVmActivity) this.this$0).f8507a).A().setValue(Boolean.FALSE);
            }
        }));
    }
}
