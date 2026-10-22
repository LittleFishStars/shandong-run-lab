package com.huachenjie.works.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/works/bean/publish/PubWorksMenuPageEntity;", "Lcom/huachenjie/works/bean/publish/PubWorkChannelBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.api.RequestModel$queryPubWorksChannelList$2", f = "RequestModel.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$queryPubWorksChannelList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PubWorksMenuPageEntity<PubWorkChannelBean>>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $refreshTime;
    final /* synthetic */ Integer $type;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$queryPubWorksChannelList$2(String str, int i, String str2, Integer num, Continuation<? super RequestModel$queryPubWorksChannelList$2> continuation) {
        super(1, continuation);
        this.$keyword = str;
        this.$pageNum = i;
        this.$refreshTime = str2;
        this.$type = num;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$queryPubWorksChannelList$2(this.$keyword, this.$pageNum, this.$refreshTime, this.$type, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PubWorksMenuPageEntity<PubWorkChannelBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WorksApi worksApiA = RequestModel.f36762a.a();
            String str = this.$keyword;
            int i2 = this.$pageNum;
            String str2 = this.$refreshTime;
            Integer num = this.$type;
            this.label = 1;
            obj = worksApiA.p0(str, i2, 20, str2, num, this);
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
