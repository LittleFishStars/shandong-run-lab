package com.huachenjie.compat.page.account;

import androidx.p002lifecycle.MutableLiveData;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.enums.ThirdLoginType;
import com.huachenjie.common.reconfig.liveData.SingleLiveEvent;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.login.page.verify_code.VerifyCodeActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.o38;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b.\u0010/J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0002R%\u0010\u0012\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00070\u00070\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0016\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011R%\u0010\u0019\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u00130\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R%\u0010\u001c\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u00130\f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011R%\u0010\u001f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u00130\f8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R%\u0010\"\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u00130\f8\u0006¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u0011R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020)0#8\u0006¢\u0006\f\n\u0004\b\u000e\u0010%\u001a\u0004\b*\u0010'R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020)0#8\u0006¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b,\u0010'¨\u00060"}, d2 = {"Lcom/huachenjie/compat/page/account/AccountManageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "t", "u", "Lcom/huachenjie/common/enums/ThirdLoginType;", "type", "", VerifyCodeActivity.y, "j", "w", "v", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", AliyunLogCommon.TERMINAL_TYPE, "", "c", "q", "isBindWx", "d", "p", "isBindQQ", "e", j.b, "isBindAL", "f", "s", "isInstallWx", y6b.f, "r", "isInstallQQ", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "a", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "n", "()Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "thirdAlreadyBoundEvent", "", "m", "phoneCheckErrorEvent", "k", "openModifyPhoneEvent", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class AccountManageVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent<ThirdLoginType> thirdAlreadyBoundEvent;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> phone = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent<Integer> phoneCheckErrorEvent;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isBindWx;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent<Integer> openModifyPhoneEvent;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isBindQQ;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isBindAL;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isInstallWx;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isInstallQQ;

    public AccountManageVM() {
        Boolean bool = Boolean.FALSE;
        this.isBindWx = new MutableLiveData<>(bool);
        this.isBindQQ = new MutableLiveData<>(bool);
        this.isBindAL = new MutableLiveData<>(bool);
        this.isInstallWx = new MutableLiveData<>(bool);
        this.isInstallQQ = new MutableLiveData<>(bool);
        this.thirdAlreadyBoundEvent = new SingleLiveEvent<>();
        this.phoneCheckErrorEvent = new SingleLiveEvent<>();
        this.openModifyPhoneEvent = new SingleLiveEvent<>();
    }

    public final void j(@NotNull final ThirdLoginType type, @NotNull String thirdKey) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(thirdKey, VerifyCodeActivity.y);
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.compat.page.account.AccountManageVM$bindThird$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, "e");
                if (resultException.getCode() == 6502) {
                    this.this$0.n().setValue(type);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, null, new AccountManageVM$bindThird$2(type, thirdKey, this, null), 10, null);
    }

    @NotNull
    public final SingleLiveEvent<Integer> k() {
        return this.openModifyPhoneEvent;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.phone;
    }

    @NotNull
    public final SingleLiveEvent<Integer> m() {
        return this.phoneCheckErrorEvent;
    }

    @NotNull
    public final SingleLiveEvent<ThirdLoginType> n() {
        return this.thirdAlreadyBoundEvent;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.isBindAL;
    }

    @NotNull
    public final MutableLiveData<Boolean> p() {
        return this.isBindQQ;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isBindWx;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.isInstallQQ;
    }

    @NotNull
    public final MutableLiveData<Boolean> s() {
        return this.isInstallWx;
    }

    public final void t() {
        this.phone.setValue(o38.b(ai9.e().getPhone()));
    }

    public final void u() {
        BaseViewModelExtKt.b(this, false, false, null, null, new AccountManageVM$loadUserSettings$1(this, null), 15, null);
    }

    public final void v() {
        BaseViewModelExtKt.b(this, true, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.compat.page.account.AccountManageVM$modifyPhonePreCheck$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                boolean z;
                Intrinsics.checkNotNullParameter(resultException, "e");
                switch (resultException.getCode()) {
                    case UserConstants.MODIFY_PHONE_ERROR_CODE.f33733a /* 1552 */:
                    case UserConstants.MODIFY_PHONE_ERROR_CODE.b /* 1553 */:
                    case UserConstants.MODIFY_PHONE_ERROR_CODE.c /* 1554 */:
                        this.this$0.m().setValue(Integer.valueOf(resultException.getCode()));
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                return Boolean.valueOf(z);
            }
        }, null, new AccountManageVM$modifyPhonePreCheck$2(this, null), 10, null);
    }

    public final void w(@NotNull ThirdLoginType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        BaseViewModelExtKt.b(this, true, false, null, null, new AccountManageVM$unbindThird$1(type, this, null), 14, null);
    }
}
