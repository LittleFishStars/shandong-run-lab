package com.huachenjie.works.page.publish.menu.permission;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.yj7;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\tR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0007\u001a\u0004\b\u0011\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/page/publish/menu/permission/PubWorkMenuPermissionModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", yj7.g.WORKS_NO, "", "b", "j", "visibleType", "", "c", "i", "updateResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PubWorkMenuPermissionModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> worksNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> visibleType = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> updateResult = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Boolean> i() {
        return this.updateResult;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.visibleType;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.worksNo;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, true, false, null, null, new PubWorkMenuPermissionModel$updateVisit$1(this, null), 14, null);
    }
}
