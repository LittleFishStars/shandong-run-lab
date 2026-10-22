package com.huachenjie.login.page.base;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.enums.LoginThirdType;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR)\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00100\t8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\t8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/login/page/base/BaseLoginVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "i", "Lcom/huachenjie/login/enums/LoginThirdType;", "thirdType", "", VerifyCodeActivity.y, "m", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "isAgreeProtocol", "Lkotlin/Pair;", "b", "j", "thirdLoginBindData", "Lcom/huachenjie/login/bean/LoginResultData;", "c", "k", "thirdLoginResult", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public abstract class BaseLoginVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isAgreeProtocol = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Pair<LoginThirdType, String>> thirdLoginBindData = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginResultData> thirdLoginResult = new MutableLiveData<>();

    public final void i() {
        BaseViewModelExtKt.b(this, false, false, null, null, new BaseLoginVM$checkUpgrade$1(null), 15, null);
    }

    @NotNull
    public final MutableLiveData<Pair<LoginThirdType, String>> j() {
        return this.thirdLoginBindData;
    }

    @NotNull
    public final MutableLiveData<LoginResultData> k() {
        return this.thirdLoginResult;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.isAgreeProtocol;
    }

    public final void m(@NotNull final LoginThirdType thirdType, @NotNull final String thirdKey) {
        Intrinsics.checkNotNullParameter(thirdType, "thirdType");
        Intrinsics.checkNotNullParameter(thirdKey, VerifyCodeActivity.y);
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.page.base.BaseLoginVM$thirdLogin$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() != 6500) {
                    return Boolean.FALSE;
                }
                this.this$0.j().setValue(new Pair<>(thirdType, thirdKey));
                return Boolean.TRUE;
            }
        }, null, new BaseLoginVM$thirdLogin$2(this, thirdType, thirdKey, null), 10, null);
    }
}
