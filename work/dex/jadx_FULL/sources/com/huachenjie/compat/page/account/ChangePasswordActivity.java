package com.huachenjie.compat.page.account;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.base.dialog.CaptchaDialog;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.compat.R;
import com.huachenjie.compat.databinding.ActivityChangePasswordBinding;
import com.huachenjie.compat.page.account.ChangePasswordActivity;
import com.huachenjie.run.map.RouteOverlay;
import com.zj.adlib.ai9;
import com.zj.adlib.i62;
import com.zj.adlib.wk0;
import com.zj.adlib.wm6;
import com.zj.adlib.zn1;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Route(path = RoutePathConstants.Compat.h)
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/compat/page/account/ChangePasswordActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/compat/page/account/ChangePasswordVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "onDestroy", "o0", "Landroid/widget/EditText;", "editText", "", "show", "r0", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mHandler", "com/huachenjie/compat/page/account/ChangePasswordActivity$b", "Lcom/huachenjie/compat/page/account/ChangePasswordActivity$b;", "countDownTask", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class ChangePasswordActivity extends BaseVmActivity<ChangePasswordVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final b countDownTask = new b();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/compat/page/account/ChangePasswordActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/compat/page/account/ChangePasswordActivity;)V", "compat_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ((ChangePasswordVM) ((BaseVmActivity) ChangePasswordActivity.this).f8507a).r(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"com/huachenjie/compat/page/account/ChangePasswordActivity$b", "Ljava/lang/Runnable;", "", "run", "", "K", "I", "b", "()I", "c", "(I)V", "millisUntilFinished", "compat_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: K, reason: from kotlin metadata */
        public int millisUntilFinished;

        public b() {
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getMillisUntilFinished() {
            return this.millisUntilFinished;
        }

        public final void c(int i) {
            this.millisUntilFinished = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.millisUntilFinished <= 0) {
                ((ChangePasswordVM) ((BaseVmActivity) ChangePasswordActivity.this).f8507a).o().setValue("获取验证码");
                ((ChangePasswordVM) ((BaseVmActivity) ChangePasswordActivity.this).f8507a).i().setValue(Boolean.TRUE);
                return;
            }
            ((ChangePasswordVM) ((BaseVmActivity) ChangePasswordActivity.this).f8507a).o().setValue("重新发送(" + this.millisUntilFinished + ')');
            this.millisUntilFinished = this.millisUntilFinished + (-1);
            ChangePasswordActivity.this.mHandler.postDelayed(this, 1000L);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34095a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34095a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34095a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34095a.invoke(obj);
        }
    }

    public static final void m0(ChangePasswordActivity changePasswordActivity, ActivityChangePasswordBinding activityChangePasswordBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(changePasswordActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityChangePasswordBinding, "$this_apply");
        EditText editText = activityChangePasswordBinding.f9098b;
        Intrinsics.checkNotNullExpressionValue(editText, "etPassword");
        changePasswordActivity.r0(editText, z);
    }

    public static final void n0(ChangePasswordActivity changePasswordActivity, ActivityChangePasswordBinding activityChangePasswordBinding, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(changePasswordActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityChangePasswordBinding, "$this_apply");
        EditText editText = activityChangePasswordBinding.f9094a;
        Intrinsics.checkNotNullExpressionValue(editText, "etConfirmPassword");
        changePasswordActivity.r0(editText, z);
    }

    public static final void p0(ChangePasswordActivity changePasswordActivity, View view) {
        Intrinsics.checkNotNullParameter(changePasswordActivity, "this$0");
        changePasswordActivity.finish();
    }

    public static final void q0(ChangePasswordActivity changePasswordActivity, View view) {
        Intrinsics.checkNotNullParameter(changePasswordActivity, "this$0");
        ((ChangePasswordVM) ((BaseVmActivity) changePasswordActivity).f8507a).h();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_change_password), Integer.valueOf(wk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(wk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).i().setValue(Boolean.TRUE);
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).o().setValue("获取验证码");
        o0();
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).n().setValue(ai9.e().getPhone());
        final ActivityChangePasswordBinding activityChangePasswordBinding = (ActivityChangePasswordBinding) getBinding();
        if (activityChangePasswordBinding != null) {
            EditText editText = activityChangePasswordBinding.f9098b;
            Intrinsics.checkNotNullExpressionValue(editText, "etPassword");
            r0(editText, false);
            EditText editText2 = activityChangePasswordBinding.f9094a;
            Intrinsics.checkNotNullExpressionValue(editText2, "etConfirmPassword");
            r0(editText2, false);
            activityChangePasswordBinding.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.rh1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ChangePasswordActivity.m0(this.f19314a, activityChangePasswordBinding, compoundButton, z);
                }
            });
            activityChangePasswordBinding.f34028a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.zj.adlib.sh1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ChangePasswordActivity.n0(this.f19580a, activityChangePasswordBinding, compoundButton, z);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).p().observe(this, new c(new Function1<String, Unit>() { // from class: com.huachenjie.compat.page.account.ChangePasswordActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                ChangePasswordActivity.this.mHandler.removeCallbacks(ChangePasswordActivity.this.countDownTask);
                ChangePasswordActivity.this.countDownTask.c(60);
                ChangePasswordActivity.this.mHandler.post(ChangePasswordActivity.this.countDownTask);
            }
        }));
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).m().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.compat.page.account.ChangePasswordActivity.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    CaptchaDialog.Companion aVar = CaptchaDialog.INSTANCE;
                    FragmentManager supportFragmentManager = ChangePasswordActivity.this.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
                    final ChangePasswordActivity changePasswordActivity = ChangePasswordActivity.this;
                    aVar.a(supportFragmentManager, new Function1<String, Unit>() { // from class: com.huachenjie.compat.page.account.ChangePasswordActivity.initViewModel.2.1
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@Nullable String str) {
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            ((ChangePasswordVM) ((BaseVmActivity) changePasswordActivity).f8507a).r(str);
                        }
                    });
                }
            }
        }));
    }

    public final void o0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((ChangePasswordVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean titleName = bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(zn1.a(R.color.white)).setTitleName(getString(R.string.change_password));
        int i = R.color.color_2C3E50;
        ((ChangePasswordVM) ((BaseVmActivity) this).f8507a).q().setValue(titleName.setTitleTextColor(zn1.a(i)).setBackShow(true).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(i))).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.th1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePasswordActivity.p0(this.f44921a, view);
            }
        }).setShowRightText(true).setRightButtonText("确定").setRightButtonTextColor(Color.parseColor(RouteOverlay.f12338c)).setRightTextClick(new View.OnClickListener() { // from class: com.zj.adlib.uh1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChangePasswordActivity.q0(this.f45148a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public final void r0(EditText editText, boolean show) {
        int selectionStart = editText.getSelectionStart();
        if (show) {
            editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            editText.setTransformationMethod(wm6.a());
        }
        if (selectionStart > 0) {
            try {
                editText.setSelection(selectionStart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
