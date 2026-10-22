package com.huachenjie.sport.page.mine.choose_classes;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.dialog.AlertDialog;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.choose_classes.MyChooseClassesActivity;
import com.igexin.push.g.o;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.h)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¨\u0006\f"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/MyChooseClassesActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class MyChooseClassesActivity extends BaseVmActivity<ChooseClassesVM> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36639a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36639a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36639a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36639a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.choose_classes.MyChooseClassesActivity$initViewModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", o.f, "", "kotlin.jvm.PlatformType", BridgeDSL.INVOKE, "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$3$lambda$2$lambda$1(MyChooseClassesActivity myChooseClassesActivity, View view) {
            Intrinsics.checkNotNullParameter(myChooseClassesActivity, "this$0");
            ((ChooseClassesVM) ((BaseVmActivity) myChooseClassesActivity).f8507a).H();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Integer) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(Integer num) {
            if (num != null) {
                final MyChooseClassesActivity myChooseClassesActivity = MyChooseClassesActivity.this;
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    AlertDialog.AlertDataBean alertDataBean = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                    alertDataBean.setContent("本学期选课次数已用完，请联系你的体育老师进行调课。");
                    alertDataBean.setConfirm("我知道了");
                    AlertDialog.INSTANCE.a(alertDataBean).show(myChooseClassesActivity.getSupportFragmentManager(), "AlertDialog");
                    return;
                }
                if (iIntValue > 0) {
                    AlertDialog.AlertDataBean alertDataBean2 = new AlertDialog.AlertDataBean(null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, null, 0.0f, 0, false, 8191, null);
                    alertDataBean2.setContent("确认要重新选课吗？你还有" + iIntValue + "次选课机会，请谨慎选择要参加的课程！");
                    alertDataBean2.setCancel(OptionsPickerHelper.e);
                    alertDataBean2.setConfirm("确定重选");
                    AlertDialog.INSTANCE.b(alertDataBean2, new View.OnClickListener() { // from class: com.huachenjie.sport.page.mine.choose_classes.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MyChooseClassesActivity.AnonymousClass1.invoke$lambda$3$lambda$2$lambda$1(myChooseClassesActivity, view);
                        }
                    }).show(myChooseClassesActivity.getSupportFragmentManager(), "AlertDialog");
                }
            }
        }
    }

    public static final void h0(MyChooseClassesActivity myChooseClassesActivity, View view) {
        Intrinsics.checkNotNullParameter(myChooseClassesActivity, "this$0");
        myChooseClassesActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_my_choose_classes), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataC = ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).C();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName("我的选课");
        Integer value = ((BaseVM) ((ChooseClassesVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
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
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pu5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyChooseClassesActivity.h0(this.f44060a, view);
            }
        });
        mutableLiveDataC.setValue(bindingTitleBean);
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "supportFragmentManager.beginTransaction()");
        Object objNavigation = ARouter.getInstance().build(RoutePathConstants.Sport.i).navigation();
        if (objNavigation instanceof Fragment) {
            fragmentTransactionBeginTransaction.add(R.id.fl_content, (Fragment) objNavigation, RoutePathConstants.Sport.i);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            getSupportFragmentManager().executePendingTransactions();
            ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).J(2);
            ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).j().setValue(new ChooseClassesAdapter(2));
            ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).F(true);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).r().observe(this, new a(new AnonymousClass1()));
        ((ChooseClassesVM) ((BaseVmActivity) this).f8507a).x().observe(this, new a(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.MyChooseClassesActivity.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (bool != null) {
                    MyChooseClassesActivity myChooseClassesActivity = MyChooseClassesActivity.this;
                    if (bool.booleanValue()) {
                        if (ActivityLifecycleManager.l().c(ChooseClassesActivity.class) == null) {
                            ARouter.getInstance().build(RoutePathConstants.Sport.g).navigation();
                        }
                        myChooseClassesActivity.finish();
                    }
                }
            }
        }));
    }
}
