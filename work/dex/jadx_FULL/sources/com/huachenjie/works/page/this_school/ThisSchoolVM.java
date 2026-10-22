package com.huachenjie.works.page.this_school;

import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.kernel.RVParams;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR%\u0010\t\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR%\u0010\f\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/page/this_school/ThisSchoolVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", "backTint", "b", "j", RVParams.LONG_TITLE_COLOR, "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class ThisSchoolVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> backTint = new MutableLiveData<>(-1);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> titleColor = new MutableLiveData<>(-1);

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.backTint;
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.titleColor;
    }
}
