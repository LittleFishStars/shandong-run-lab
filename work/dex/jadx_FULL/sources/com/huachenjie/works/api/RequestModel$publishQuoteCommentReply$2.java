package com.huachenjie.works.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/works/bean/comment/CommentReplyBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.api.RequestModel$publishQuoteCommentReply$2", f = "RequestModel.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$publishQuoteCommentReply$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<CommentReplyBean>>, Object> {
    final /* synthetic */ RequestBody $body;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$publishQuoteCommentReply$2(RequestBody requestBody, Continuation<? super RequestModel$publishQuoteCommentReply$2> continuation) {
        super(1, continuation);
        this.$body = requestBody;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$publishQuoteCommentReply$2(this.$body, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<CommentReplyBean>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WorksApi worksApiA = RequestModel.f36762a.a();
            RequestBody requestBody = this.$body;
            this.label = 1;
            obj = worksApiA.I(requestBody, this);
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
