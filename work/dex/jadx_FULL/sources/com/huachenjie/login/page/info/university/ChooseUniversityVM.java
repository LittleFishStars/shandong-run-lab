package com.huachenjie.login.page.info.university;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.login.bean.GradeBean;
import com.kuaishou.weapon.p0.t;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00058\u0006¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u00058\u0006¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/login/page/info/university/ChooseUniversityVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "i", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/SchoolInfo;", "a", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", UserConstants.LOGIN_PARAMS.c, "", "Lcom/huachenjie/login/bean/GradeBean;", "b", "m", "gradeListData", "c", "k", "gradeBean", "", "d", "j", "alumnus", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseUniversityVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<SchoolInfo> schoolInfo = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<GradeBean>> gradeListData = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GradeBean> gradeBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> alumnus = new MutableLiveData<>();

    public final void i() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ChooseUniversityVM$generateAlumnus$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<String> j() {
        return this.alumnus;
    }

    @NotNull
    public final MutableLiveData<GradeBean> k() {
        return this.gradeBean;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ChooseUniversityVM$getGradeList$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<List<GradeBean>> m() {
        return this.gradeListData;
    }

    @NotNull
    public final MutableLiveData<SchoolInfo> n() {
        return this.schoolInfo;
    }
}
