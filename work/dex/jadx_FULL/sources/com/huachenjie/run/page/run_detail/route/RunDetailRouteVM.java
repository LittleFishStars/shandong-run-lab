package com.huachenjie.run.page.run_detail.route;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u00040\u00040\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/run_detail/route/RunDetailRouteVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "", "visible", "", "i", "j", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "userInfoVisible", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunDetailRouteVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> userInfoVisible = new MutableLiveData<>(Boolean.TRUE);

    @NotNull
    public final String i(boolean visible) {
        return visible ? ai9.e().getUserName() : "******";
    }

    @NotNull
    public final String j(boolean visible) {
        return visible ? "学号：" + ai9.e().getStudentNumber() : "********************";
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.userInfoVisible;
    }

    public final void l() {
        MutableLiveData<Boolean> mutableLiveData = this.userInfoVisible;
        Boolean value = mutableLiveData.getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        mutableLiveData.setValue(Boolean.valueOf(!value.booleanValue()));
    }
}
