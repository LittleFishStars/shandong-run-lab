package com.huachenjie.mine.page.history;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/mine/page/history/HistoryRecordViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "clearHistoryResult", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class HistoryRecordViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> clearHistoryResult = new MutableLiveData<>();

    public final void i() {
        BaseViewModelExtKt.b(this, true, false, null, null, new HistoryRecordViewModel$clearHistory$1(this, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<Boolean> j() {
        return this.clearHistoryResult;
    }
}
