package com.huachenjie.common.reconfig.mvvm;

import android.app.Dialog;
import android.os.Bundle;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import androidx.p002lifecycle.ViewModelProvider;
import com.gyf.immersionbar.e;
import com.huachenjie.common.reconfig.baseView.BaseActivity;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007¢\u0006\u0004\b&\u0010'J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\rH\u0014J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000fH&J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002R\"\u0010\u001a\u001a\u00028\u00008\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010 \u001a\u00028\u00018\u0004@\u0004X\u0084.¢\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Landroidx/databinding/ViewDataBinding;", "V", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "VM", "Lcom/huachenjie/common/reconfig/baseView/BaseActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "T", "U", "W", "Ljava/lang/Class;", "getViewModelClass", "", "", "", "Y", "X", "a", "Landroidx/databinding/ViewDataBinding;", "getMBinding", "()Landroidx/databinding/ViewDataBinding;", "setMBinding", "(Landroidx/databinding/ViewDataBinding;)V", "mBinding", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "getMViewModel", "()Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "setMViewModel", "(Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;)V", "mViewModel", "Landroid/app/Dialog;", "Lkotlin/Lazy;", "getMLoadingDialog", "()Landroid/app/Dialog;", "mLoadingDialog", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBaseMVVMActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseMVVMActivity.kt\ncom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,81:1\n215#2,2:82\n*S KotlinDebug\n*F\n+ 1 BaseMVVMActivity.kt\ncom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity\n*L\n37#1:82,2\n*E\n"})
public abstract class BaseMVVMActivity<V extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public V mBinding;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public VM mViewModel;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy mLoadingDialog = LazyKt.lazy(new Function0<Dialog>(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity$mLoadingDialog$2
        final /* synthetic */ BaseMVVMActivity<V, VM> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        {
            super(0);
            this.this$0 = this;
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Dialog m352invoke() {
            return DialogUtil.p(this.this$0, false);
        }
    });

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33857a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33857a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33857a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33857a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void T() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, getLayoutResID());
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(this, getLayoutResID())");
        setMBinding(contentView);
        getMBinding().setLifecycleOwner(this);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void U() {
        Map<Integer, Object> mapV = V();
        if (mapV != null) {
            for (Map.Entry<Integer, Object> entry : mapV.entrySet()) {
                getMBinding().setVariable(entry.getKey().intValue(), entry.getValue());
            }
        }
        Y();
        X();
        W();
        super.U();
    }

    @Nullable
    public abstract Map<Integer, Object> V();

    public void W() {
    }

    public final void X() {
        getMViewModel().d().getShowLoadingEvent().observe(this, new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity$initUiChangeObservable$1
            final /* synthetic */ BaseMVVMActivity<V, VM> this$0;

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
        getMViewModel().d().getDismissLoadingEvent().observe(this, new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity$initUiChangeObservable$2
            final /* synthetic */ BaseMVVMActivity<V, VM> this$0;

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
        getMViewModel().d().d().observe(this, new a(new Function1<String, Unit>() { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity$initUiChangeObservable$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                fv5.b(str);
            }
        }));
        getMViewModel().d().getFinishEvent().observe(this, new a(new Function1(this) { // from class: com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity$initUiChangeObservable$4
            final /* synthetic */ BaseMVVMActivity<V, VM> this$0;

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
                this.this$0.onBackPressed();
            }
        }));
    }

    public final void Y() {
        int iH0 = e.H0(this);
        int iO0 = e.o0(this);
        getMViewModel().e().b().setValue(Integer.valueOf(cr2.b(this, iH0)));
        getMViewModel().e().c().setValue(Integer.valueOf(iH0));
        getMViewModel().e().a().setValue(Integer.valueOf(cr2.b(this, iO0)));
    }

    @NotNull
    public final V getMBinding() {
        V v = this.mBinding;
        if (v != null) {
            return v;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        return null;
    }

    @NotNull
    public final Dialog getMLoadingDialog() {
        Object value = this.mLoadingDialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLoadingDialog>(...)");
        return (Dialog) value;
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

    @NotNull
    public Class<VM> getViewModelClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity>");
        return (Class) type;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setMViewModel((BaseViewModel) new ViewModelProvider(this).get(getViewModelClass()));
        super.onCreate(savedInstanceState);
    }

    public final void setMBinding(@NotNull V v) {
        Intrinsics.checkNotNullParameter(v, "<set-?>");
        this.mBinding = v;
    }

    public final void setMViewModel(@NotNull VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.mViewModel = vm;
    }
}
