package com.huachenjie.social_contact.dialog;

import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.common.base.data_binding.BaseDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment;
import com.huachenjie.common.base.data_binding.BaseVMDialogFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.bean.CrystalPageInfo;
import com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog;
import com.huachenjie.social_contact.vm.ExchangeWorldCrystalsVM;
import com.igexin.push.g.o;
import com.zj.adlib.cr2;
import com.zj.adlib.fv5;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.h)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\nH\u0014R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog;", "Lcom/huachenjie/common/base/data_binding/BaseVMBottomDialogFragment;", "Lcom/huachenjie/social_contact/vm/ExchangeWorldCrystalsVM;", "", "getHeight", "getWidth", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", "getCallback", "()Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", "setCallback", "(Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;)V", "<init>", "()V", "Companion", "a", "b", "OnActionCallback", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class ExchangeWorldCrystalsDialog extends BaseVMBottomDialogFragment<ExchangeWorldCrystalsVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private OnActionCallback callback;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", "", "onAction", "", "social_contact_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnActionCallback {
        void onAction();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$a;", "", "Landroid/view/View;", "v", "", "b", "a", "<init>", "(Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@Nullable View v) {
            MutableLiveData<CrystalPageInfo> mutableLiveDataK;
            CrystalPageInfo value;
            MutableLiveData<CrystalPageInfo> mutableLiveDataK2;
            CrystalPageInfo value2;
            ExchangeWorldCrystalsVM exchangeWorldCrystalsVM = (ExchangeWorldCrystalsVM) ((BaseVMDialogFragment) ExchangeWorldCrystalsDialog.this).mState;
            int starDrill = 0;
            if (((exchangeWorldCrystalsVM == null || (mutableLiveDataK2 = exchangeWorldCrystalsVM.k()) == null || (value2 = mutableLiveDataK2.getValue()) == null) ? 0 : value2.getStarDrill()) <= 0) {
                fv5.b("今天兑换次数已用完");
                return;
            }
            ExchangeWorldCrystalsVM exchangeWorldCrystalsVM2 = (ExchangeWorldCrystalsVM) ((BaseVMDialogFragment) ExchangeWorldCrystalsDialog.this).mState;
            if (exchangeWorldCrystalsVM2 != null && (mutableLiveDataK = exchangeWorldCrystalsVM2.k()) != null && (value = mutableLiveDataK.getValue()) != null) {
                starDrill = value.getStarDrill();
            }
            if (starDrill < 10) {
                fv5.b("星空钻不足");
                return;
            }
            ExchangeWorldCrystalsVM exchangeWorldCrystalsVM3 = (ExchangeWorldCrystalsVM) ((BaseVMDialogFragment) ExchangeWorldCrystalsDialog.this).mState;
            if (exchangeWorldCrystalsVM3 != null) {
                exchangeWorldCrystalsVM3.h();
            }
        }

        public final void b(@Nullable View v) {
            ExchangeWorldCrystalsDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$b;", "", "Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog$OnActionCallback;", RenderCallContext.TYPE_CALLBACK, "Lcom/huachenjie/social_contact/dialog/ExchangeWorldCrystalsDialog;", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExchangeWorldCrystalsDialog a(@NotNull OnActionCallback callback) {
            Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
            ExchangeWorldCrystalsDialog exchangeWorldCrystalsDialog = new ExchangeWorldCrystalsDialog();
            exchangeWorldCrystalsDialog.setCallback(callback);
            return exchangeWorldCrystalsDialog;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36205a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36205a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36205a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36205a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0() {
    }

    @Nullable
    public final OnActionCallback getCallback() {
        return this.callback;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.dialog_exchange_world_crystals), Integer.valueOf(nk0.p0), ((BaseVMDialogFragment) this).mState).a(Integer.valueOf(nk0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(\n     …m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getHeight() {
        return cr2.c(getContext(), 500.0f);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMBottomDialogFragment
    public int getWidth() {
        return this.MATCH;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void init(@Nullable Bundle savedInstanceState) {
        setFragmentDialogDismissCallback(new BaseDialogFragment.FragmentDialogDismissCallback() { // from class: com.zj.adlib.a73
            @Override // com.huachenjie.common.base.data_binding.BaseDialogFragment.FragmentDialogDismissCallback
            public final void onDismiss() {
                ExchangeWorldCrystalsDialog.init$lambda$0();
            }
        });
        ExchangeWorldCrystalsVM exchangeWorldCrystalsVM = (ExchangeWorldCrystalsVM) ((BaseVMDialogFragment) this).mState;
        if (exchangeWorldCrystalsVM != null) {
            exchangeWorldCrystalsVM.i(false);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMDialogFragment
    public void initViewModel() {
        MutableLiveData<Boolean> mutableLiveDataJ;
        ExchangeWorldCrystalsVM exchangeWorldCrystalsVM = (ExchangeWorldCrystalsVM) ((BaseVMDialogFragment) this).mState;
        if (exchangeWorldCrystalsVM == null || (mutableLiveDataJ = exchangeWorldCrystalsVM.j()) == null) {
            return;
        }
        mutableLiveDataJ.observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.social_contact.dialog.ExchangeWorldCrystalsDialog.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    fv5.b("世界水晶兑换成功");
                    OnActionCallback callback = ExchangeWorldCrystalsDialog.this.getCallback();
                    if (callback != null) {
                        callback.onAction();
                    }
                }
            }
        }));
    }

    public final void setCallback(@Nullable OnActionCallback onActionCallback) {
        this.callback = onActionCallback;
    }
}
