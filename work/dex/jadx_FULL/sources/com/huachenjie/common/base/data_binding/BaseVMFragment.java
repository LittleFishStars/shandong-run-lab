package com.huachenjie.common.base.data_binding;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModel;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.BaseView;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.cr2;
import com.zj.adlib.dx4;
import com.zj.adlib.fl9;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.i62;
import huachenjie.sdk.http.lifecycle.ILifeCycle;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseVMFragment<Q extends BaseVM> extends Fragment implements ILifeCycle, BaseView {
    protected dx4 behavior;
    protected Dialog loadingDialog;
    private Dialog loadingNewMessageDialog;
    protected AppCompatActivity mActivity;
    private ViewDataBinding mBinding;
    protected Q mState;
    private Dialog unCancelableLoadingDialog;
    private Dialog unCancelableNewMessageLoadingDialog;
    public final String TAG = getClass().getSimpleName();
    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isUserVisible = false;
    private boolean isPrepared = false;

    private void initBaseObservable(final Q mState) {
        mState.d.observe(this, new Observer() { // from class: com.zj.adlib.as0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f15387a.lambda$initBaseObservable$0(mState, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBaseObservable$0(BaseVM baseVM, Boolean bool) {
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

    @Override // com.huachenjie.common.base.BaseView
    public void dismissLoadingDialogs() {
        if (this.mActivity.isFinishing()) {
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.loadingDialog.dismiss();
        }
        Dialog dialog2 = this.unCancelableLoadingDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.unCancelableLoadingDialog.dismiss();
        }
        Dialog dialog3 = this.loadingNewMessageDialog;
        if (dialog3 != null && dialog3.isShowing()) {
            this.loadingNewMessageDialog.dismiss();
            this.loadingNewMessageDialog = null;
        }
        Dialog dialog4 = this.unCancelableNewMessageLoadingDialog;
        if (dialog4 == null || !dialog4.isShowing()) {
            return;
        }
        this.unCancelableNewMessageLoadingDialog.dismiss();
        this.unCancelableNewMessageLoadingDialog = null;
    }

    public <T extends ViewModel> T getActivityScopeViewModel(@NonNull Class<T> cls) {
        return (T) fl9.e(this.mActivity).get(cls);
    }

    public ViewDataBinding getBinding() {
        return this.mBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this.mActivity;
    }

    public abstract i62 getDataBindingConfig();

    public <T extends ViewModel> T getFragmentScopeViewModel(@NonNull Class<T> cls) {
        return (T) fl9.c(this).get(cls);
    }

    public dx4 getLifeCycleObservable() {
        if (this.behavior == null) {
            this.behavior = dx4.a();
        }
        return this.behavior;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void hideInputForce() {
        if (this.mActivity.getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) this.mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mActivity.getCurrentFocus().getWindowToken(), 2);
    }

    public void init(Bundle savedInstanceState) {
    }

    public void initDataAfterView() {
    }

    public void initPrepare() {
        if (!this.isPrepared) {
            this.isPrepared = true;
        } else {
            this.isUserVisible = true;
            onUserVisible();
        }
    }

    public abstract void initViewModel();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.mActivity = (AppCompatActivity) context;
        if (this.mState == null) {
            this.mState = (Q) getFragmentScopeViewModel((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        int iK0 = e.K0(this);
        int iR0 = e.r0(this);
        this.mState.f33644a.setValue(Integer.valueOf(cr2.b(context, iK0)));
        this.mState.b.setValue(Integer.valueOf(iK0));
        this.mState.c.setValue(Integer.valueOf(cr2.b(context, iR0)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.mState == null) {
            this.mState = (Q) getFragmentScopeViewModel((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        }
        initViewModel();
        initBaseObservable(this.mState);
        init(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        i62 dataBindingConfig = getDataBindingConfig();
        ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(inflater, dataBindingConfig.c(), container, false);
        viewDataBindingInflate.setLifecycleOwner(this);
        viewDataBindingInflate.setVariable(dataBindingConfig.e(), dataBindingConfig.d());
        SparseArray sparseArrayB = dataBindingConfig.b();
        int size = sparseArrayB.size();
        for (int i = 0; i < size; i++) {
            viewDataBindingInflate.setVariable(sparseArrayB.keyAt(i), sparseArrayB.valueAt(i));
        }
        this.mBinding = viewDataBindingInflate;
        initDataAfterView();
        return viewDataBindingInflate.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        dx4 dx4Var = this.behavior;
        if (dx4Var != null) {
            dx4Var.b();
            this.behavior = null;
        }
        this.mBinding.unbind();
        this.mBinding = null;
        this.isFirstResume = true;
        this.isFirstVisible = true;
        this.isUserVisible = false;
        this.isPrepared = false;
    }

    public void onFragmentPause() {
        i4a.g(this.TAG, "onFragmentPause() called");
    }

    public void onFragmentResume() {
        i4a.g(this.TAG, "onFragmentResume() called");
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            onFragmentPause();
        } else {
            onFragmentResume();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.isFirstResume) {
            this.isFirstResume = false;
            return;
        }
        if (!isHidden()) {
            onFragmentPause();
        }
        if (getUserVisibleHint() && this.isUserVisible) {
            this.isUserVisible = false;
            onUserInvisible();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.isFirstResume) {
            this.isFirstResume = false;
            onFragmentResume();
            return;
        }
        if (!isHidden()) {
            onFragmentResume();
        }
        if (getUserVisibleHint()) {
            this.isUserVisible = true;
            onUserVisible();
        }
    }

    public void onUserInvisible() {
        i4a.g(this.TAG, "onUserINVISIBLE() called");
    }

    public void onUserVisible() {
        i4a.g(this.TAG, ">> onUserVisible() called");
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (!isVisibleToUser) {
            if (this.isUserVisible) {
                this.isUserVisible = false;
                onUserInvisible();
                return;
            }
            return;
        }
        if (this.isFirstVisible) {
            this.isFirstVisible = false;
            initPrepare();
        } else {
            this.isUserVisible = true;
            onUserVisible();
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mActivity.getSystemService("input_method");
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(boolean cancelable) {
        if (this.mActivity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.loadingDialog == null) {
                this.loadingDialog = DialogUtil.p(this.mActivity, true);
            }
            this.loadingDialog.show();
            return this.loadingDialog;
        }
        if (this.unCancelableLoadingDialog == null) {
            this.unCancelableLoadingDialog = DialogUtil.p(this.mActivity, false);
        }
        this.unCancelableLoadingDialog.show();
        return this.unCancelableLoadingDialog;
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showToast(String text) {
        fv5.b(text);
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(String message, boolean cancelable) {
        if (this.mActivity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(this.mActivity, message, true);
            this.loadingNewMessageDialog = dialogO;
            dialogO.show();
            return this.loadingNewMessageDialog;
        }
        Dialog dialogO2 = DialogUtil.o(this.mActivity, message, false);
        this.unCancelableNewMessageLoadingDialog = dialogO2;
        dialogO2.show();
        return this.unCancelableNewMessageLoadingDialog;
    }
}
