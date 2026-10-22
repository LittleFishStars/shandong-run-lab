package com.huachenjie.common.reconfig.mvvm;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModelProvider;
import com.gyf.immersionbar.e;
import com.huachenjie.common.reconfig.baseView.BaseDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.cr2;
import com.zj.adlib.fv5;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010\u001bH\u0016J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00010\u001fH\u0014J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020!H\u0002J\b\u0010$\u001a\u00020%H\u0004J\u0012\u0010&\u001a\u00020!2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010/\u001a\u00020!H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\u00028\u0001X\u0084.¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u00060"}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "V", "Landroidx/databinding/ViewDataBinding;", "VM", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Lcom/huachenjie/common/reconfig/baseView/BaseDialogFragment;", "()V", "mBinding", "getMBinding", "()Landroidx/databinding/ViewDataBinding;", "setMBinding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "mLoadingDialog", "Landroid/app/Dialog;", "kotlin.jvm.PlatformType", "getMLoadingDialog", "()Landroid/app/Dialog;", "mLoadingDialog$delegate", "Lkotlin/Lazy;", "mViewModel", "getMViewModel", "()Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "setMViewModel", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;)V", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "getVariables", "", "", "", "getViewModelClass", "Ljava/lang/Class;", "initDataObserve", "", "initUiChangeObservable", "initUiObservable", "modelIsInitialized", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseMVVMDialogFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMVVMDialogFragment.kt\ncom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,96:1\n215#2,2:97\n*S KotlinDebug\n*F\n+ 1 BaseMVVMDialogFragment.kt\ncom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment\n*L\n44#1:97,2\n*E\n"})
public abstract class BaseMVVMDialogFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseDialogFragment {

    @Nullable
    private V mBinding;

    /* JADX INFO: renamed from: mLoadingDialog$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLoadingDialog = LazyKt.lazy(new Function0<Dialog>(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment$mLoadingDialog$2
        final /* synthetic */ BaseMVVMDialogFragment<V, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Dialog m353invoke() {
            return DialogUtil.p(this.this$0.requireActivity(), false);
        }
    });
    protected VM mViewModel;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33858a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33858a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33858a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33858a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Dialog getMLoadingDialog() {
        return (Dialog) this.mLoadingDialog.getValue();
    }

    private final void initUiChangeObservable() {
        getMViewModel().d().getShowLoadingEvent().observe(getViewLifecycleOwner(), new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment.initUiChangeObservable.1
            final /* synthetic */ BaseMVVMDialogFragment<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Void r1) {
                this.this$0.getMLoadingDialog().show();
            }
        }));
        getMViewModel().d().getDismissLoadingEvent().observe(getViewLifecycleOwner(), new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment.initUiChangeObservable.2
            final /* synthetic */ BaseMVVMDialogFragment<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Void r1) {
                this.this$0.getMLoadingDialog().dismiss();
            }
        }));
        getMViewModel().d().d().observe(getViewLifecycleOwner(), new a(new Function1<String, Unit>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment.initUiChangeObservable.3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                fv5.b(str);
            }
        }));
        getMViewModel().d().getFinishEvent().observe(getViewLifecycleOwner(), new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment.initUiChangeObservable.4
            final /* synthetic */ BaseMVVMDialogFragment<V, VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Void) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Void r1) {
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        }));
    }

    private final void initUiObservable() {
        int iK0 = e.K0(this);
        int iR0 = e.r0(this);
        getMViewModel().e().b().setValue(Integer.valueOf(cr2.b(requireContext(), iK0)));
        getMViewModel().e().c().setValue(Integer.valueOf(iK0));
        getMViewModel().e().a().setValue(Integer.valueOf(cr2.b(requireContext(), iR0)));
    }

    @Nullable
    public final V getMBinding() {
        return this.mBinding;
    }

    @NotNull
    public final VM getMViewModel() {
        VM vm = this.mViewModel;
        if (vm != null) {
            return vm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        return null;
    }

    @Nullable
    public Map<Integer, Object> getVariables() {
        return null;
    }

    @NotNull
    public Class<VM> getViewModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment>");
        return (Class) type;
    }

    public void initDataObserve() {
    }

    public final boolean modelIsInitialized() {
        return this.mViewModel != null;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setMViewModel((BaseViewModel) new ViewModelProvider(this).get(getViewModelClass()));
        super.onCreate(savedInstanceState);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        V v = (V) DataBindingUtil.inflate(inflater, getLayoutResID(), container, false);
        this.mBinding = v;
        if (v != null) {
            v.setLifecycleOwner(this);
        }
        Map<Integer, Object> variables = getVariables();
        if (variables != null) {
            for (Map.Entry<Integer, Object> entry : variables.entrySet()) {
                V v2 = this.mBinding;
                if (v2 != null) {
                    v2.setVariable(entry.getKey().intValue(), entry.getValue());
                }
            }
        }
        initUiObservable();
        initUiChangeObservable();
        initDataObserve();
        V v3 = this.mBinding;
        if (v3 != null) {
            return v3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mBinding = null;
        super.onDestroyView();
    }

    public final void setMBinding(@Nullable V v) {
        this.mBinding = v;
    }

    public final void setMViewModel(@NotNull VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.mViewModel = vm;
    }
}
