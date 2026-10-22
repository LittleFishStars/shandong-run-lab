package com.huachenjie.works.page.search.result.child;

import com.huachenjie.base.works.BaseSearchResultModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.BuddyCardBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/works/page/search/result/child/SearchResultBuddyModel;", "Lcom/huachenjie/base/works/BaseSearchResultModel;", "Lcom/huachenjie/works/bean/BuddyCardBean;", "", "isRefreshData", "", "w", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class SearchResultBuddyModel extends BaseSearchResultModel<BuddyCardBean> {
    @Override // com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel
    public void w(boolean isRefreshData) {
        super.w(isRefreshData);
        BaseViewModelExtKt.b(this, false, false, q(), null, new SearchResultBuddyModel$loadMoreData$1(this, null), 11, null);
    }
}
