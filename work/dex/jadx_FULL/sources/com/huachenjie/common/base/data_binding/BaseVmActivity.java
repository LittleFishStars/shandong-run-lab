package com.huachenjie.common.base.data_binding;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModel;
import androidx.p002lifecycle.ViewModelStoreOwner;
import com.alibaba.android.arouter.launcher.ARouter;
import com.gyf.immersionbar.e;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.base.SideTextInterface;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.zj.adlib.cr2;
import com.zj.adlib.dx4;
import com.zj.adlib.fl9;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.r90;
import com.zj.adlib.rh3;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.lifecycle.ILifeCycle;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseVmActivity<Q extends BaseVM> extends AppCompatActivity implements ViewModelStoreOwner, ILifeCycle, BaseView, SideTextInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f33645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f8505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewDataBinding f8506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Q f8507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public dx4 f8508a;
    public Dialog b;
    public Activity c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Dialog f8509c;
    public Dialog d;
    public String t = getClass().getSimpleName();
    public TextView p = null;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(BaseVM baseVM, Boolean bool) {
        if (bool == null) {
            return;
        }
        if (!bool.booleanValue()) {
            dismissLoadingDialogs();
        } else if (TextUtils.isEmpty(baseVM.f8502a.msg)) {
            showLoadingDialog(baseVM.f8502a.cancelAble);
        } else {
            BaseVM.LoadingDialogBean loadingDialogBean = baseVM.f8502a;
            showLoadingDialog(loadingDialogBean.msg, loadingDialogBean.cancelAble);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(String str) {
        TextView textViewP;
        if (TextUtils.isEmpty(str) || (textViewP = getSideTextView()) == null) {
            return;
        }
        textViewP.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(CustomizeViewDialog.Builder builder) {
        if (builder != null) {
            builder.create(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogFragment dialogFragment) {
        if (dialogFragment != null) {
            dialogFragment.show(getSupportFragmentManager(), ys8.c("dialog_%d", Long.valueOf(System.currentTimeMillis())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(Boolean bool) {
        if (bool.booleanValue()) {
            finish();
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return zn1.a(R.color.color_8997A4);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public String H() {
        return null;
    }

    public final void X(final Q mState) {
        mState.d.observe(this, new Observer() { // from class: com.zj.adlib.bs0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f15629a.Y(mState, (Boolean) obj);
            }
        });
        mState.e.observe(this, new Observer() { // from class: com.zj.adlib.cs0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f41034a.Z((String) obj);
            }
        });
        mState.f.observe(this, new Observer() { // from class: com.zj.adlib.ds0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f41265a.a0((CustomizeViewDialog.Builder) obj);
            }
        });
        mState.g.observe(this, new Observer() { // from class: com.zj.adlib.es0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f41516a.b0((DialogFragment) obj);
            }
        });
        mState.h.observe(this, new Observer() { // from class: com.zj.adlib.fs0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f41747a.c0((Boolean) obj);
            }
        });
    }

    public void d0() {
    }

    @Override // com.huachenjie.common.base.BaseView
    public void dismissLoadingDialogs() {
        if (isFinishing()) {
            return;
        }
        Dialog dialog = this.f33645a;
        if (dialog != null && dialog.isShowing()) {
            this.f33645a.dismiss();
        }
        Dialog dialog2 = this.b;
        if (dialog2 != null && dialog2.isShowing()) {
            this.b.dismiss();
        }
        Dialog dialog3 = this.f8509c;
        if (dialog3 != null && dialog3.isShowing()) {
            this.f8509c.dismiss();
            this.f8509c = null;
        }
        Dialog dialog4 = this.d;
        if (dialog4 == null || !dialog4.isShowing()) {
            return;
        }
        this.d.dismiss();
        this.d = null;
    }

    public void e0() {
        e.p3(this).G2(R.color.transparent).T2(true).u1(R.color.white).G1(true).a1();
    }

    public <T extends ViewModel> T getActivityScopeViewModel(@NonNull Class<T> cls) {
        return (T) fl9.e(this).get(cls);
    }

    public ViewDataBinding getBinding() {
        return this.f8506a;
    }

    @Override // com.huachenjie.common.base.BaseView
    public Context getContext() {
        return this.c;
    }

    public abstract i62 getDataBindingConfig();

    public dx4 getLifeCycleObservable() {
        if (this.f8508a == null) {
            this.f8508a = dx4.a();
        }
        return this.f8508a;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = new Configuration();
        configuration.setToDefaults();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return resources;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void hideInputForce() {
        if (getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
    }

    public abstract void init(@Nullable Bundle savedInstanceState);

    public abstract void initViewModel();

    public void injectArouter() {
        if (r90.G()) {
            ARouter.getInstance().inject(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        rh3.b(this, savedInstanceState);
        injectArouter();
        e0();
        super.onCreate(savedInstanceState);
        try {
            setRequestedOrientation(1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8505a = this;
        this.c = this;
        this.f8507a = (Q) getActivityScopeViewModel((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        int iH0 = e.H0(this);
        int iO0 = e.o0(this);
        this.f8507a.f33644a.setValue(Integer.valueOf(cr2.b(this, iH0)));
        this.f8507a.b.setValue(Integer.valueOf(iH0));
        this.f8507a.c.setValue(Integer.valueOf(cr2.b(this, iO0)));
        initViewModel();
        i62 dataBindingConfig = getDataBindingConfig();
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, dataBindingConfig.c());
        contentView.setLifecycleOwner(this);
        contentView.setVariable(dataBindingConfig.e(), dataBindingConfig.d());
        SparseArray sparseArrayB = dataBindingConfig.b();
        int size = sparseArrayB.size();
        for (int i = 0; i < size; i++) {
            contentView.setVariable(sparseArrayB.keyAt(i), sparseArrayB.valueAt(i));
        }
        this.f8506a = contentView;
        X(this.f8507a);
        init(savedInstanceState);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d0();
        dx4 dx4Var = this.f8508a;
        if (dx4Var != null) {
            dx4Var.b();
            this.f8508a = null;
        }
        ViewDataBinding viewDataBinding = this.f8506a;
        if (viewDataBinding != null) {
            viewDataBinding.unbind();
            this.f8506a = null;
        }
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    /* JADX INFO: renamed from: p */
    public TextView getSideTextView() {
        return this.p;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public void q(TextView view) {
        this.p = view;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return false;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(boolean cancelable) {
        if (isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.f33645a == null) {
                this.f33645a = DialogUtil.p(this, true);
            }
            this.f33645a.show();
            return this.f33645a;
        }
        if (this.b == null) {
            this.b = DialogUtil.p(this, false);
        }
        this.b.show();
        return this.b;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showToast(String text) {
        fv5.b(text);
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(String message, boolean cancelable) {
        if (isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(this, message, true);
            this.f8509c = dialogO;
            dialogO.show();
            return this.f8509c;
        }
        Dialog dialogO2 = DialogUtil.o(this, message, false);
        this.d = dialogO2;
        dialogO2.show();
        return this.d;
    }
}
