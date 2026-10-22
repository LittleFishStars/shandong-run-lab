package com.huachenjie.login.page.info.nickname;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.page.dressing_table.nickName.NicknameFragment;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058\u0006¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/login/page/info/nickname/FillNicknameVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "m", "i", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", NicknameFragment.NICKNAME, "b", "k", "inputHint", "", "c", "j", "checkSensitiveResult", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class FillNicknameVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> nickname = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> inputHint = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> checkSensitiveResult = new MutableLiveData<>();

    public final void i() {
        BaseViewModelExtKt.b(this, true, false, null, null, new FillNicknameVM$checkSensitiveWords$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.checkSensitiveResult;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.inputHint;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.nickname;
    }

    public final void m() {
        BaseViewModelExtKt.b(this, false, false, null, null, new FillNicknameVM$getRegisterConfig$1(null), 15, null);
    }
}
