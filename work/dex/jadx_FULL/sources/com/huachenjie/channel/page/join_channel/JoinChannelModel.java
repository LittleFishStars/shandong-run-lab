package com.huachenjie.channel.page.join_channel;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.adapter.JoinChannelAdapter;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/channel/page/join_channel/JoinChannelModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseStateRequestModel;", "", "isRefreshData", "", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/adapter/JoinChannelAdapter;", "f", "Landroidx/lifecycle/MutableLiveData;", "B", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", y6b.f, "C", "D", "(Landroidx/lifecycle/MutableLiveData;)V", "searchChannelNo", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class JoinChannelModel extends BaseStateRequestModel {

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<JoinChannelAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> searchChannelNo = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<JoinChannelAdapter> B() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> C() {
        return this.searchChannelNo;
    }

    public final void D(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.searchChannelNo = mutableLiveData;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        String value = this.searchChannelNo.getValue();
        if (value == null) {
            value = "";
        }
        BaseViewModelExtKt.b(this, false, false, q(), null, new JoinChannelModel$loadMoreData$1(value, this, null), 11, null);
    }
}
