package com.huachenjie.college.page.lightningPlay;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.page.home.showcase.ShowcaseFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/college/page/lightningPlay/MoxiPlayVm;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "j", "", "startTime", "", "viewTime", "receiveFlag", "k", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "i", "()Landroidx/lifecycle/MutableLiveData;", ShowcaseFragment.USER_NO, "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class MoxiPlayVm extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> userNo = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<String> i() {
        return this.userNo;
    }

    public final void j() {
        BaseViewModelExtKt.b(this, true, false, null, null, new MoxiPlayVm$queryGameUserInfo$1(this, null), 14, null);
    }

    public final void k(long startTime, int viewTime, int receiveFlag) {
        BaseViewModelExtKt.b(this, false, false, null, null, new MoxiPlayVm$uploadGameRecordInfo$1(startTime, viewTime, receiveFlag, null), 15, null);
    }
}
