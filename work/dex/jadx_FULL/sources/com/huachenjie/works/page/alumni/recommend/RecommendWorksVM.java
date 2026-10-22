package com.huachenjie.works.page.alumni.recommend;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.external.base.BaseWorksListVM;
import com.huachenjie.works.external.bean.WorkItemBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nR(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/works/page/alumni/recommend/RecommendWorksVM;", "Lcom/huachenjie/works/external/base/BaseWorksListVM;", "", "pageNum", "", "refreshTime", "Lcom/huachenjie/works/external/bean/WorkItemBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Lhuachenjie/sdk/http/PageEntity;", "q", "(ILjava/lang/String;Lcom/huachenjie/works/external/bean/WorkItemBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/MutableLiveData;", "c", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "x", "(Landroidx/lifecycle/MutableLiveData;)V", "channelCategoryNo", "d", "w", "y", "sportFlag", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class RecommendWorksVM extends BaseWorksListVM {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<String> channelCategoryNo = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<Integer> sportFlag = new MutableLiveData<>(0);

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.huachenjie.works.external.base.BaseWorksListVM
    @Nullable
    public Object q(int i, @Nullable String str, @Nullable WorkItemBean workItemBean, @NotNull Continuation<? super PageEntity<WorkItemBean>> continuation) {
        RecommendWorksVM$requestList$1 recommendWorksVM$requestList$1;
        String value;
        if (continuation instanceof RecommendWorksVM$requestList$1) {
            recommendWorksVM$requestList$1 = (RecommendWorksVM$requestList$1) continuation;
            int i2 = recommendWorksVM$requestList$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                recommendWorksVM$requestList$1.label = i2 - Integer.MIN_VALUE;
            } else {
                recommendWorksVM$requestList$1 = new RecommendWorksVM$requestList$1(this, continuation);
            }
        } else {
            recommendWorksVM$requestList$1 = new RecommendWorksVM$requestList$1(this, continuation);
        }
        RecommendWorksVM$requestList$1 recommendWorksVM$requestList$2 = recommendWorksVM$requestList$1;
        Object objV0 = recommendWorksVM$requestList$2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = recommendWorksVM$requestList$2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objV0);
            RequestModel requestModel = RequestModel.f36762a;
            Integer value2 = this.sportFlag.getValue();
            if (value2 == null) {
                value2 = Boxing.boxInt(0);
            }
            int iIntValue = value2.intValue();
            MutableLiveData<String> mutableLiveData = this.channelCategoryNo;
            if (mutableLiveData == null || (value = mutableLiveData.getValue()) == null) {
                value = "";
            }
            recommendWorksVM$requestList$2.L$0 = workItemBean;
            recommendWorksVM$requestList$2.label = 1;
            objV0 = requestModel.v0(i, str, "", iIntValue, value, recommendWorksVM$requestList$2);
            if (objV0 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            workItemBean = (WorkItemBean) recommendWorksVM$requestList$2.L$0;
            ResultKt.throwOnFailure(objV0);
        }
        PageEntity pageEntity = (PageEntity) objV0;
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setList(new ArrayList());
            pageEntity.setHasNext(false);
        }
        if (workItemBean != null) {
            if (pageEntity.getList() == null) {
                pageEntity.setList(new ArrayList());
            }
            if (pageEntity.getList().isEmpty()) {
                pageEntity.setList(CollectionsKt.mutableListOf(new WorkItemBean[]{workItemBean}));
            } else {
                pageEntity.getList().add(0, workItemBean);
            }
        }
        return pageEntity;
    }

    @NotNull
    public final MutableLiveData<String> v() {
        return this.channelCategoryNo;
    }

    @NotNull
    public final MutableLiveData<Integer> w() {
        return this.sportFlag;
    }

    public final void x(@NotNull MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.channelCategoryNo = mutableLiveData;
    }

    public final void y(@NotNull MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.sportFlag = mutableLiveData;
    }
}
