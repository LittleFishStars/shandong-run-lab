package com.huachenjie.mine.page.dressing_table.nickName;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\f0\f0\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mine/page/dressing_table/nickName/NicknameVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "k", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", NicknameFragment.NICKNAME, "", "b", "j", "saveSuccess", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class NicknameVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> nickname = new MutableLiveData<>("");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> saveSuccess = new MutableLiveData<>(Boolean.FALSE);

    @NotNull
    public final MutableLiveData<String> i() {
        return this.nickname;
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.saveSuccess;
    }

    public final void k() {
        if (TextUtils.isEmpty(this.nickname.getValue())) {
            fv5.b("请输入昵称");
            return;
        }
        String value = this.nickname.getValue();
        if (value == null) {
            value = "";
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new NicknameVM$saveNickname$1(value, this, null), 14, null);
    }
}
