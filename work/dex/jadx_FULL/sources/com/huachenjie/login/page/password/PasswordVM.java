package com.huachenjie.login.page.password;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.login.bean.LoginResultData;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00078\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u000bR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00078\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/huachenjie/login/page/password/PasswordVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "loginName", "captchaPoint", "", "n", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "password", "", "b", "m", "showPassword", "Lcom/huachenjie/login/bean/LoginResultData;", "c", "i", "loginResultData", "d", "k", "needCodeLogin", "e", "j", "needCaptchaCheck", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class PasswordVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> password = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showPassword = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginResultData> loginResultData = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> needCodeLogin = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> needCaptchaCheck = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<LoginResultData> i() {
        return this.loginResultData;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.needCaptchaCheck;
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.needCodeLogin;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.password;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.showPassword;
    }

    public final void n(@NotNull String loginName, @Nullable String captchaPoint) {
        Intrinsics.checkNotNullParameter(loginName, "loginName");
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.page.password.PasswordVM$loginPassword$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                int code = resultException.getCode();
                boolean z = true;
                if (code == 1600) {
                    this.this$0.j().setValue(Boolean.TRUE);
                } else if (code != 10101) {
                    z = false;
                } else {
                    fv5.b(resultException.getMessage());
                    this.this$0.k().setValue(Boolean.TRUE);
                }
                return Boolean.valueOf(z);
            }
        }, null, new PasswordVM$loginPassword$2(loginName, this, captchaPoint, null), 10, null);
    }
}
