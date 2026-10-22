package com.huachenjie.home.dialog.sign;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.home.bean.SignConfigBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00068\u0006¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/home/dialog/sign/SignVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "m", "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/home/bean/SignConfigBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "signConfig", "Lcom/huachenjie/home/dialog/sign/SignAdapter;", "b", "i", "adapter", "", "c", "k", "signReward", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class SignVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SignConfigBean> signConfig = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SignAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> signReward = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<SignAdapter> i() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<SignConfigBean> j() {
        return this.signConfig;
    }

    @NotNull
    public final MutableLiveData<Integer> k() {
        return this.signReward;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, false, false, null, null, new SignVM$querySignStatus$1(this, null), 15, null);
    }

    public final void m() {
        BaseViewModelExtKt.b(this, true, false, null, null, new SignVM$submitSign$1(this, null), 14, null);
    }

    public final void n() {
        BaseViewModelExtKt.b(this, true, false, null, null, new SignVM$submitVideoReward$1(this, null), 14, null);
    }
}
