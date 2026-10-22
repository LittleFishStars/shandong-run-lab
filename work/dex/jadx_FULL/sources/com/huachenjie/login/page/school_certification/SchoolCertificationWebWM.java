package com.huachenjie.login.page.school_certification;

import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.bean.SchoolAuthBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J&\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002R\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/login/page/school_certification/SchoolCertificationWebWM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "schoolCode", "ticket", "type", "", "k", "number", AliyunLogCommon.TERMINAL_TYPE, "bindKey", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/login/bean/SchoolAuthBean;", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "checkResult", "Lcom/huachenjie/login/bean/LoginResultData;", "c", "m", "loginResult", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolCertificationWebWM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolAuthBean> checkResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<LoginResultData> loginResult = new MutableLiveData<>();

    public final void j(@NotNull String schoolCode, @NotNull String number, @NotNull String phone, @NotNull String bindKey) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(number, "number");
        Intrinsics.checkNotNullParameter(phone, AliyunLogCommon.TERMINAL_TYPE);
        Intrinsics.checkNotNullParameter(bindKey, "bindKey");
        BaseViewModelExtKt.b(this, true, true, null, null, new SchoolCertificationWebWM$bindPhoneBySchoolAuth$1(schoolCode, number, phone, bindKey, this, null), 12, null);
    }

    public final void k(@NotNull String schoolCode, @NotNull String ticket, @NotNull String type) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(type, "type");
        BaseViewModelExtKt.b(this, true, true, null, null, new SchoolCertificationWebWM$checkSchoolAuth$1(schoolCode, ticket, type, this, null), 12, null);
    }

    @NotNull
    public final MutableLiveData<SchoolAuthBean> l() {
        return this.checkResult;
    }

    @NotNull
    public final MutableLiveData<LoginResultData> m() {
        return this.loginResult;
    }
}
