package com.huachenjie.college.api;

import com.huachenjie.college.bean.RecommendItemBean;
import com.huachenjie.common.reconfig.net.IResponse;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/college/bean/RecommendItemBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.api.RequestModel$requestCollegeTownBanner$2", f = "RequestModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$requestCollegeTownBanner$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<RecommendItemBean>>>, Object> {
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $refreshTime;
    final /* synthetic */ String $type;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$requestCollegeTownBanner$2(int i, String str, String str2, Continuation<? super RequestModel$requestCollegeTownBanner$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$refreshTime = str;
        this.$type = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$requestCollegeTownBanner$2(this.$pageNum, this.$refreshTime, this.$type, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<RecommendItemBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CollegeApi collegeApiA = RequestModel.f33549a.a();
            int i2 = this.$pageNum;
            String str = this.$refreshTime;
            String str2 = this.$type;
            this.label = 1;
            obj = collegeApiA.p(i2, str, 15, str2, this);
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
