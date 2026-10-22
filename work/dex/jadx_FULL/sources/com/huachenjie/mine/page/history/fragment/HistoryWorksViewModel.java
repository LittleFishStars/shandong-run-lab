package com.huachenjie.mine.page.history.fragment;

import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.works.external.base.BaseWorksListVM;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/huachenjie/mine/page/history/fragment/HistoryWorksViewModel;", "Lcom/huachenjie/works/external/base/BaseWorksListVM;", "", "pageNum", "", "refreshTime", "Lcom/huachenjie/works/external/bean/WorkItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lhuachenjie/sdk/http/PageEntity;", "q", "(ILjava/lang/String;Lcom/huachenjie/works/external/bean/WorkItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class HistoryWorksViewModel extends BaseWorksListVM {
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.huachenjie.works.external.base.BaseWorksListVM
    @Nullable
    public Object q(int i, @Nullable String str, @Nullable WorkItemBean workItemBean, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        HistoryWorksViewModel$requestList$1 historyWorksViewModel$requestList$1;
        if (continuation instanceof HistoryWorksViewModel$requestList$1) {
            historyWorksViewModel$requestList$1 = (HistoryWorksViewModel$requestList$1) continuation;
            int i2 = historyWorksViewModel$requestList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                historyWorksViewModel$requestList$1.label = i2 - Integer.MIN_VALUE;
            } else {
                historyWorksViewModel$requestList$1 = new HistoryWorksViewModel$requestList$1(this, continuation);
            }
        } else {
            historyWorksViewModel$requestList$1 = new HistoryWorksViewModel$requestList$1(this, continuation);
        }
        Object objO = historyWorksViewModel$requestList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = historyWorksViewModel$requestList$1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objO);
            RequestModel requestModel = RequestModel.f35285a;
            historyWorksViewModel$requestList$1.label = 1;
            objO = requestModel.o(i, str, historyWorksViewModel$requestList$1);
            if (objO == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objO);
        }
        PageEntity pageEntity = (PageEntity) objO;
        if (pageEntity != null) {
            return pageEntity;
        }
        PageEntity pageEntity2 = new PageEntity();
        pageEntity2.setList(new ArrayList());
        pageEntity2.setHasNext(false);
        return pageEntity2;
    }
}
