package com.huachenjie.channel.page.notify.mailbox;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.channel.page.notify.base.BaseNotifyNextModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\f8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/channel/page/notify/mailbox/NotifyMailBoxModel;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextModel;", "", "isRefreshData", "", "w", "", "position", "", RemoteMessageConst.MSGID, "F", "E", "Landroidx/lifecycle/MutableLiveData;", y6b.f, "Landroidx/lifecycle/MutableLiveData;", "C", "()Landroidx/lifecycle/MutableLiveData;", "clearAllMessage", y6b.g, "D", "clearMessage", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyMailBoxModel extends BaseNotifyNextModel {

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> clearAllMessage = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> clearMessage = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<Boolean> C() {
        return this.clearAllMessage;
    }

    @NotNull
    public final MutableLiveData<Integer> D() {
        return this.clearMessage;
    }

    public final void E() {
        BaseViewModelExtKt.b(this, true, false, null, null, new NotifyMailBoxModel$readAllMessage$1(this, null), 14, null);
    }

    public final void F(int position, @NotNull String msgId) {
        Intrinsics.checkNotNullParameter(msgId, RemoteMessageConst.MSGID);
        BaseViewModelExtKt.b(this, true, false, null, null, new NotifyMailBoxModel$readMessage$1(msgId, this, position, null), 14, null);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new NotifyMailBoxModel$loadMoreData$1(this, null), 11, null);
    }
}
