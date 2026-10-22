package com.huachenjie.mine.page.fans;

import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.mine.page.FansAndAttentionsModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"Lcom/huachenjie/mine/page/fans/MyFansModel;", "Lcom/huachenjie/mine/page/FansAndAttentionsModel;", "", "isRefreshData", "", "w", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyFansModel extends FansAndAttentionsModel {
    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new MyFansModel$loadMoreData$1(this, null), 11, null);
    }
}
