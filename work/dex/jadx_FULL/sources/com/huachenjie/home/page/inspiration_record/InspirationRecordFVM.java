package com.huachenjie.home.page.inspiration_record;

import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR%\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordFVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "f", "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "isGetRecord", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", y6b.f, "B", "adapter", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationRecordFVM extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isGetRecord = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BaseQuickAdapter<?, ?>> adapter = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<BaseQuickAdapter<?, ?>> B() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> C() {
        return this.isGetRecord;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new InspirationRecordFVM$loadMoreData$1(this, null), 10, null);
    }
}
