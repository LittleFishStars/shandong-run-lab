package com.huachenjie.home.page.reward_record;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/home/page/reward_record/RewardRecordVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/home/page/reward_record/RewardRecordAdapter;", "kotlin.jvm.PlatformType", "f", "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "adapter", y6b.f, "F", "isLoadHistory", y6b.g, "D", "firstHistoryData", "", "L", "I", "E", "()I", "G", "(I)V", "nowDataPage", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class RewardRecordVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RewardRecordAdapter> adapter = new MutableLiveData<>(new RewardRecordAdapter());

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isLoadHistory = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> firstHistoryData = new MutableLiveData<>();

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int nowDataPage = 1;

    @NotNull
    public final MutableLiveData<RewardRecordAdapter> C() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> D() {
        return this.firstHistoryData;
    }

    /* JADX INFO: renamed from: E, reason: from getter */
    public final int getNowDataPage() {
        return this.nowDataPage;
    }

    @NotNull
    public final MutableLiveData<Boolean> F() {
        return this.isLoadHistory;
    }

    public final void G(int i) {
        this.nowDataPage = i;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new RewardRecordVM$loadMoreData$1(this, null), 11, null);
    }
}
