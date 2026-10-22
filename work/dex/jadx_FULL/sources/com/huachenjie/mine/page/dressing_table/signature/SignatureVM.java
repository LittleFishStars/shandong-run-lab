package com.huachenjie.mine.page.dressing_table.signature;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00110\u00110\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/signature/SignatureVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", SignatureFragment.SIGNATURE, "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "k", "()Landroidx/lifecycle/MediatorLiveData;", "signatureLengthStr", "", "b", "i", "saveSuccess", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class SignatureVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> signatureLengthStr;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> signature;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> saveSuccess;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35382a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35382a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35382a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35382a.invoke(obj);
        }
    }

    public SignatureVM() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.signature = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.signatureLengthStr = mediatorLiveData;
        this.saveSuccess = new MutableLiveData<>(Boolean.FALSE);
        mediatorLiveData.addSource(mutableLiveData, new a(new Function1<String, Unit>() { // from class: com.huachenjie.mine.page.dressing_table.signature.SignatureVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                SignatureVM.this.k().setValue(str.length() + "/50");
            }
        }));
    }

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.saveSuccess;
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.signature;
    }

    @NotNull
    public final MediatorLiveData<String> k() {
        return this.signatureLengthStr;
    }

    public final void l() {
        if (TextUtils.isEmpty(this.signature.getValue())) {
            fv5.b("请输入个性签名");
        } else {
            BaseViewModelExtKt.b(this, true, false, null, null, new SignatureVM$saveUserSlogan$1(this, null), 14, null);
        }
    }
}
