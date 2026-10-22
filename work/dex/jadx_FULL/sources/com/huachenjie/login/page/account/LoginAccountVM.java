package com.huachenjie.login.page.account;

import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.login.bean.LoginCheckData;
import com.huachenjie.login.enums.LoginType;
import com.huachenjie.login.page.base.BaseLoginVM;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001f\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/login/page/account/LoginAccountVM;", "Lcom/huachenjie/login/page/base/BaseLoginVM;", "", "n", "Landroidx/lifecycle/MutableLiveData;", "", "d", "Landroidx/lifecycle/MutableLiveData;", "q", "()Landroidx/lifecycle/MutableLiveData;", "loginType", "", "e", j.b, "account", "Lcom/huachenjie/login/bean/LoginCheckData;", "f", "p", "checkResult", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class LoginAccountVM extends BaseLoginVM {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> loginType = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> account = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginCheckData> checkResult = new MutableLiveData<>();

    public final void n() {
        Integer value = this.loginType.getValue();
        LoginType loginType = ((value != null && value.intValue() == 1) || value == null || value.intValue() != 2) ? LoginType.PASSWORD : LoginType.SMS_CODE;
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.login.page.account.LoginAccountVM$checkAccount$1
            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (resultException.getCode() == 1605) {
                    fv5.b("校友ID不存在，换手机号登录试试");
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new LoginAccountVM$checkAccount$2(this, loginType, null), 10, null);
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.account;
    }

    @NotNull
    public final MutableLiveData<LoginCheckData> p() {
        return this.checkResult;
    }

    @NotNull
    public final MutableLiveData<Integer> q() {
        return this.loginType;
    }
}
