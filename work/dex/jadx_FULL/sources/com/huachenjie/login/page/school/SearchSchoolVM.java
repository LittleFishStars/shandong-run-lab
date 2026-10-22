package com.huachenjie.login.page.school;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.login.bean.SearchSchoolInfoBean;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00058\u0006¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/login/page/school/SearchSchoolVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "n", "m", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "inputValue", "Lcom/huachenjie/login/page/school/SearchSchoolAdapter;", "b", "j", "adapter", "", "K", "I", "pageNum", "Lcom/huachenjie/login/bean/SearchSchoolInfoBean;", "c", t.d, "schoolInfoBean", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SearchSchoolVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> inputValue = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchSchoolAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SearchSchoolInfoBean> schoolInfoBean = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<SearchSchoolAdapter> j() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.inputValue;
    }

    @NotNull
    public final MutableLiveData<SearchSchoolInfoBean> l() {
        return this.schoolInfoBean;
    }

    public final void m() {
        this.pageNum++;
        BaseViewModelExtKt.b(this, false, false, null, null, new SearchSchoolVM$loadMoreData$1(this.inputValue.getValue(), this, null), 15, null);
    }

    public final void n() {
        this.pageNum = 0;
        m();
    }
}
