package com.huachenjie.common.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.huachenjie.common.base.BasePresenter;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.dx4;
import com.zj.adlib.fv5;
import huachenjie.sdk.http.lifecycle.ILifeCycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements ILifeCycle, BaseView {
    protected Activity _mActivity;
    private Dialog loadingDialog;
    private Dialog loadingNewMessageDialog;
    protected View mCacheView;
    protected dx4 mLifeCycleObservable;
    protected P mPresenter;
    private Dialog unCancelableLoadingDialog;
    private Dialog unCancelableNewMessageLoadingDialog;

    @Override // com.huachenjie.common.base.BaseView
    public void dismissLoadingDialogs() {
        Activity activity = this._mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            this.loadingDialog.dismiss();
            this.loadingDialog = null;
        }
        Dialog dialog2 = this.unCancelableLoadingDialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.unCancelableLoadingDialog.dismiss();
            this.unCancelableLoadingDialog = null;
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

    public <V extends View> V f(int i) {
        return (V) getView().findViewById(i);
    }

    public View getCacheView() {
        return this.mCacheView;
    }

    public abstract int getContentViewRes();

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        return this._mActivity;
    }

    public dx4 getLifeCycleObservable() {
        if (this.mLifeCycleObservable == null) {
            this.mLifeCycleObservable = dx4.a();
        }
        return this.mLifeCycleObservable;
    }

    public void getServerData() {
    }

    public abstract void handleArguments(Bundle arguments);

    @Override // com.huachenjie.common.base.BaseView
    public void hideInputForce() {
        Activity activity = this._mActivity;
        if (activity == null || activity.getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) this._mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this._mActivity.getCurrentFocus().getWindowToken(), 2);
    }

    public abstract void initField();

    public P initPresenter() {
        return null;
    }

    public void initPresenterValue() {
        P p = (P) initPresenter();
        this.mPresenter = p;
        if (p != null) {
            p.a(this);
            this.mPresenter.e();
        }
    }

    public abstract void initView();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this._mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            handleArguments(getArguments());
        }
        initField();
        initPresenterValue();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (this.mCacheView == null) {
            this.mCacheView = inflater.inflate(getContentViewRes(), container, false);
        }
        return this.mCacheView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dx4 dx4Var = this.mLifeCycleObservable;
        if (dx4Var != null) {
            dx4Var.b();
            this.mLifeCycleObservable = null;
        }
        P p = this.mPresenter;
        if (p != null) {
            p.b(this);
            this.mPresenter.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState == null) {
            if (isHidden()) {
                return;
            }
            initView();
            getServerData();
            return;
        }
        if (isVisible()) {
            return;
        }
        initView();
        getServerData();
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showInput(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) this._mActivity.getSystemService("input_method");
        if (inputMethodManager != null) {
            view.requestFocus();
            inputMethodManager.showSoftInput(view, 0);
        }
    }

    @Override // com.huachenjie.common.base.BaseView
    public Dialog showLoadingDialog(boolean cancelable) {
        Activity activity = this._mActivity;
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.loadingDialog == null) {
                this.loadingDialog = DialogUtil.p(this._mActivity, true);
            }
            this.loadingDialog.show();
            return this.loadingDialog;
        }
        if (this.unCancelableLoadingDialog == null) {
            this.unCancelableLoadingDialog = DialogUtil.p(this._mActivity, false);
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
        Activity activity = this._mActivity;
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(this._mActivity, message, true);
            this.loadingNewMessageDialog = dialogO;
            dialogO.show();
            return this.loadingNewMessageDialog;
        }
        Dialog dialogO2 = DialogUtil.o(this._mActivity, message, false);
        this.unCancelableNewMessageLoadingDialog = dialogO2;
        dialogO2.show();
        return this.unCancelableNewMessageLoadingDialog;
    }
}
