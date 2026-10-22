package com.huachenjie.channel.page.notify.fans;

import com.huachenjie.channel.page.notify.base.BaseNotifyNextModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/notify/fans/NotifyFansModel;", "Lcom/huachenjie/channel/page/notify/base/BaseNotifyNextModel;", "", "isRefreshData", "", "w", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class NotifyFansModel extends BaseNotifyNextModel {
    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new NotifyFansModel$loadMoreData$1(this, null), 11, null);
    }
}
