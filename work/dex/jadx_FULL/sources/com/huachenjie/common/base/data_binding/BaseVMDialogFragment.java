package com.huachenjie.common.base.data_binding;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModel;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.fl9;
import com.zj.adlib.i62;
import java.lang.reflect.ParameterizedType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseVMDialogFragment<Q extends BaseVM> extends BaseDialogFragment {
    protected Dialog loadingDialog;
    private Dialog loadingNewMessageDialog;
    private ViewDataBinding mBinding;
    protected Q mState;
    private Dialog unCancelableLoadingDialog;
    private Dialog unCancelableNewMessageLoadingDialog;

    private void initBaseViewModel() {
        this.mState.d.observe(this, new Observer() { // from class: com.zj.adlib.zr0
            @Override // androidx.p002lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f46323a.lambda$initBaseViewModel$0((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initBaseViewModel$0(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (!bool.booleanValue()) {
            dismissLoadingDialogs();
        } else if (TextUtils.isEmpty(this.mState.f8502a.msg)) {
            showLoadingDialog(this.mState.f8502a.cancelAble);
        } else {
            BaseVM.LoadingDialogBean loadingDialogBean = this.mState.f8502a;
            showLoadingDialog(loadingDialogBean.msg, loadingDialogBean.cancelAble);
        }
    }

    public void dismissLoadingDialogs() {
        if (getActivity() == null || getActivity().isFinishing()) {
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

    public ViewDataBinding getBinding() {
        return this.mBinding;
    }

    public abstract i62 getDataBindingConfig();

    public <T extends ViewModel> T getFragmentScopeViewModel(@NonNull Class<T> cls) {
        return (T) fl9.c(this).get(cls);
    }

    public abstract void init(Bundle savedInstanceState);

    public void initView(View mRootView) {
    }

    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mState = (Q) getFragmentScopeViewModel((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        initBaseViewModel();
        initViewModel();
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
        initView(viewDataBindingInflate.getRoot());
        return viewDataBindingInflate.getRoot();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mBinding.unbind();
        this.mBinding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(savedInstanceState);
    }

    public Dialog showLoadingDialog(boolean cancelable) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.loadingDialog == null) {
                this.loadingDialog = DialogUtil.p(getActivity(), true);
            }
            this.loadingDialog.show();
            return this.loadingDialog;
        }
        if (this.unCancelableLoadingDialog == null) {
            this.unCancelableLoadingDialog = DialogUtil.p(getActivity(), false);
        }
        this.unCancelableLoadingDialog.show();
        return this.unCancelableLoadingDialog;
    }

    public Dialog showLoadingDialog(String message, boolean cancelable) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(getActivity(), message, true);
            this.loadingNewMessageDialog = dialogO;
            dialogO.show();
            return this.loadingNewMessageDialog;
        }
        Dialog dialogO2 = DialogUtil.o(getActivity(), message, false);
        this.unCancelableNewMessageLoadingDialog = dialogO2;
        dialogO2.show();
        return this.unCancelableNewMessageLoadingDialog;
    }
}
