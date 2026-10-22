package com.huachenjie.works.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.works.external.bean.WorkItemBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/works/external/bean/WorkItemBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.api.RequestModel$searchWorksList$2", f = "RequestModel.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$searchWorksList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<WorkItemBean>>>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $keyword;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $refreshTime;
    final /* synthetic */ String $subjectNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$searchWorksList$2(int i, String str, String str2, String str3, String str4, Continuation<? super RequestModel$searchWorksList$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$refreshTime = str;
        this.$keyword = str2;
        this.$channelNo = str3;
        this.$subjectNo = str4;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$searchWorksList$2(this.$pageNum, this.$refreshTime, this.$keyword, this.$channelNo, this.$subjectNo, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<WorkItemBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WorksApi worksApiA = RequestModel.f36762a.a();
            int i2 = this.$pageNum;
            String str = this.$refreshTime;
            String str2 = this.$keyword;
            String str3 = this.$channelNo;
            String str4 = this.$subjectNo;
            this.label = 1;
            obj = worksApiA.e(i2, 10, str, str2, str3, str4, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
