package com.huachenjie.run.page.appeal;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.liveData.SingleLiveEvent;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR%\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00110\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/run/page/appeal/AppealVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "content", "", "n", "runRecordCode", "problemContent", "semesterCode", "j", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", t.d, "()Landroidx/lifecycle/MutableLiveData;", "contentCount", "", "c", "m", "submitEnable", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "", "a", "Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "k", "()Lcom/huachenjie/common/reconfig/liveData/SingleLiveEvent;", "appealSucceedEvent", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class AppealVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> contentCount = new MutableLiveData<>("0/180");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> submitEnable = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final SingleLiveEvent appealSucceedEvent = new SingleLiveEvent();

    public final void j(@NotNull String runRecordCode, @NotNull String problemContent, @NotNull String semesterCode) {
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        Intrinsics.checkNotNullParameter(problemContent, "problemContent");
        Intrinsics.checkNotNullParameter(semesterCode, "semesterCode");
        if (runRecordCode.length() == 0) {
            return;
        }
        BaseViewModelExtKt.b(this, true, false, null, null, new AppealVM$appeal$1(runRecordCode, problemContent, semesterCode, this, null), 14, null);
    }

    @NotNull
    /* JADX INFO: renamed from: k, reason: from getter */
    public final SingleLiveEvent getAppealSucceedEvent() {
        return this.appealSucceedEvent;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.contentCount;
    }

    @NotNull
    public final MutableLiveData<Boolean> m() {
        return this.submitEnable;
    }

    public final void n(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.contentCount.setValue(content.length() + "/180");
        MutableLiveData<Boolean> mutableLiveData = this.submitEnable;
        int length = StringsKt.trim(content).toString().length();
        boolean z = false;
        if (2 <= length && length < 181) {
            z = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z));
    }
}
