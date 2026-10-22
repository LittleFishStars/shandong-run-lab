package com.huachenjie.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.huachenjie.common.base.BasePresenter;
import com.zj.adlib.dx4;
import com.zj.adlib.fv5;
import huachenjie.sdk.http.lifecycle.ILifeCycle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseDialogFragment<P extends BasePresenter> extends DialogFragment implements ILifeCycle, BaseView {
    protected Activity _mActivity;
    protected View mCacheView;
    protected dx4 mLifeCycleObservable;
    protected P mPresenter;

    public <V extends View> V f(int i) {
        return (V) getView().findViewById(i);
    }

    public View getCacheView() {
        return this.mCacheView;
    }

    public abstract int getContentViewRes();

    public dx4 getLifeCycleObservable() {
        if (this.mLifeCycleObservable == null) {
            this.mLifeCycleObservable = dx4.a();
        }
        return this.mLifeCycleObservable;
    }

    public void getServerData() {
    }

    public void handleArguments(Bundle arguments) {
    }

    @Override // com.huachenjie.common.base.BaseView
    public void hideInputForce() {
        Activity activity = this._mActivity;
        if (activity == null || activity.getCurrentFocus() == null) {
            return;
        }
        ((InputMethodManager) this._mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this._mActivity.getCurrentFocus().getWindowToken(), 2);
    }

    public void initField() {
    }

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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this._mActivity = (Activity) context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
        if (inputMethodManager == null || view == null) {
            return;
        }
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

    @Override // com.huachenjie.common.base.BaseView
    public void showToast(String text) {
        fv5.b(text);
    }
}
