package com.huachenjie.compat.page.student;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/compat/page/student/UserFaceVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/base/bean/UserFaceBean;", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "userFaceBean", "", "c", "k", "result", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class UserFaceVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<UserFaceBean> userFaceBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> result = new MutableLiveData<>();

    public final void j() {
        BaseViewModelExtKt.b(this, true, false, null, null, new UserFaceVM$closeUserFace$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> k() {
        return this.result;
    }

    @NotNull
    public final MutableLiveData<UserFaceBean> l() {
        return this.userFaceBean;
    }
}
