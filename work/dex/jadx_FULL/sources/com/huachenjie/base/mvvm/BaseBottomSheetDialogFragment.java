package com.huachenjie.base.mvvm;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModelProvider;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.huachenjie.base.R;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.fl9;
import com.zj.adlib.i62;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b9\u0010:J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH$J\b\u0010\u000f\u001a\u00020\u0004H\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H$J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0014\u0010!\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001fJ\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016R$\u0010&\u001a\u0004\u0018\u00010%8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00028\u00008\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00104\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0018\u00105\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00103R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/huachenjie/base/mvvm/BaseBottomSheetDialogFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "T", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "initBaseViewModel", "", "cancelable", "Landroid/app/Dialog;", "showLoadingDialog", "", "message", "dismissLoadingDialogs", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "initViewModel", "Landroid/view/View;", "mRootView", "initView", "Landroid/os/Bundle;", "savedInstanceState", "init", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "onCreateView", "view", "onViewCreated", "onDestroyView", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setDismissListener", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroidx/databinding/ViewDataBinding;", "mBinding", "Landroidx/databinding/ViewDataBinding;", "getMBinding", "()Landroidx/databinding/ViewDataBinding;", "setMBinding", "(Landroidx/databinding/ViewDataBinding;)V", "mState", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "getMState", "()Lcom/huachenjie/common/base/data_binding/BaseVM;", "setMState", "(Lcom/huachenjie/common/base/data_binding/BaseVM;)V", "loadingDialog", "Landroid/app/Dialog;", "unCancelableLoadingDialog", "loadingNewMessageDialog", "unCancelableNewMessageLoadingDialog", "mDismissListener", "Lkotlin/jvm/functions/Function0;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseBottomSheetDialogFragment<T extends BaseVM> extends BottomSheetDialogFragment {

    @Nullable
    private Dialog loadingDialog;

    @Nullable
    private Dialog loadingNewMessageDialog;

    @Nullable
    private ViewDataBinding mBinding;

    @Nullable
    private Function0<Unit> mDismissListener;
    protected T mState;

    @Nullable
    private Dialog unCancelableLoadingDialog;

    @Nullable
    private Dialog unCancelableNewMessageLoadingDialog;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f32938a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f32938a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f32938a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f32938a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissLoadingDialogs() {
        FragmentActivity activity = getActivity();
        boolean z = false;
        if (activity != null && activity.isFinishing()) {
            z = true;
        }
        if (z) {
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                Dialog dialog2 = this.loadingDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.dismiss();
            }
        }
        Dialog dialog3 = this.unCancelableLoadingDialog;
        if (dialog3 != null) {
            Intrinsics.checkNotNull(dialog3);
            if (dialog3.isShowing()) {
                Dialog dialog4 = this.unCancelableLoadingDialog;
                Intrinsics.checkNotNull(dialog4);
                dialog4.dismiss();
            }
        }
        Dialog dialog5 = this.loadingNewMessageDialog;
        if (dialog5 != null) {
            Intrinsics.checkNotNull(dialog5);
            if (dialog5.isShowing()) {
                Dialog dialog6 = this.loadingNewMessageDialog;
                Intrinsics.checkNotNull(dialog6);
                dialog6.dismiss();
                this.loadingNewMessageDialog = null;
            }
        }
        Dialog dialog7 = this.unCancelableNewMessageLoadingDialog;
        if (dialog7 != null) {
            Intrinsics.checkNotNull(dialog7);
            if (dialog7.isShowing()) {
                Dialog dialog8 = this.unCancelableNewMessageLoadingDialog;
                Intrinsics.checkNotNull(dialog8);
                dialog8.dismiss();
                this.unCancelableNewMessageLoadingDialog = null;
            }
        }
    }

    private final void initBaseViewModel() {
        getMState().d.observe(this, new a(new Function1<Boolean, Unit>(this) { // from class: com.huachenjie.base.mvvm.BaseBottomSheetDialogFragment.initBaseViewModel.1
            final /* synthetic */ BaseBottomSheetDialogFragment<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Boolean bool) {
                if (bool == null) {
                    return;
                }
                if (!bool.booleanValue()) {
                    this.this$0.dismissLoadingDialogs();
                } else if (TextUtils.isEmpty(this.this$0.getMState().f8502a.msg)) {
                    BaseBottomSheetDialogFragment<T> baseBottomSheetDialogFragment = this.this$0;
                    baseBottomSheetDialogFragment.showLoadingDialog(baseBottomSheetDialogFragment.getMState().f8502a.cancelAble);
                } else {
                    BaseBottomSheetDialogFragment<T> baseBottomSheetDialogFragment2 = this.this$0;
                    baseBottomSheetDialogFragment2.showLoadingDialog(baseBottomSheetDialogFragment2.getMState().f8502a.msg, this.this$0.getMState().f8502a.cancelAble);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog showLoadingDialog(boolean cancelable) {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            if (this.loadingDialog == null) {
                this.loadingDialog = DialogUtil.p(getActivity(), true);
            }
            Dialog dialog = this.loadingDialog;
            if (dialog != null) {
                dialog.show();
            }
        } else {
            if (this.unCancelableLoadingDialog == null) {
                this.unCancelableLoadingDialog = DialogUtil.p(getActivity(), false);
            }
            Dialog dialog2 = this.unCancelableLoadingDialog;
            if (dialog2 != null) {
                dialog2.show();
            }
        }
        return null;
    }

    @NotNull
    public abstract i62 getDataBindingConfig();

    @Nullable
    public final ViewDataBinding getMBinding() {
        return this.mBinding;
    }

    @NotNull
    public final T getMState() {
        T t = this.mState;
        if (t != null) {
            return t;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mState");
        return null;
    }

    public abstract void init(@Nullable Bundle savedInstanceState);

    public void initView(@Nullable View mRootView) {
    }

    public void initViewModel() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(1, R.style.BaseBottomSheetDialogFragmentTheme);
        ViewModelProvider viewModelProviderC = fl9.c(this);
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.huachenjie.base.mvvm.BaseBottomSheetDialogFragment>");
        setMState((BaseVM) viewModelProviderC.get((Class) type));
        initBaseViewModel();
        initViewModel();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
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
        ViewDataBinding viewDataBinding = this.mBinding;
        if (viewDataBinding != null) {
            viewDataBinding.unbind();
        }
        this.mBinding = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.mDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        init(savedInstanceState);
    }

    public final void setDismissListener(@NotNull Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.mDismissListener = listener;
    }

    public final void setMBinding(@Nullable ViewDataBinding viewDataBinding) {
        this.mBinding = viewDataBinding;
    }

    public final void setMState(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "<set-?>");
        this.mState = t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog showLoadingDialog(String message, boolean cancelable) {
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            return null;
        }
        if (cancelable) {
            Dialog dialogO = DialogUtil.o(getActivity(), message, true);
            this.loadingNewMessageDialog = dialogO;
            if (dialogO != null) {
                dialogO.show();
            }
        } else {
            Dialog dialogO2 = DialogUtil.o(getActivity(), message, false);
            this.unCancelableNewMessageLoadingDialog = dialogO2;
            if (dialogO2 != null) {
                dialogO2.show();
            }
        }
        return null;
    }
}
