package com.huachenjie.works.page.post;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PublishPostRequestBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.post.PublishPostVM$realPublishPost$2", f = "PublishPostVM.kt", i = {}, l = {165}, m = "invokeSuspend", n = {}, s = {})
public final class PublishPostVM$realPublishPost$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PublishPostRequestBean $bean;
    int label;
    final /* synthetic */ PublishPostVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishPostVM$realPublishPost$2(PublishPostRequestBean publishPostRequestBean, PublishPostVM publishPostVM, Continuation<? super PublishPostVM$realPublishPost$2> continuation) {
        super(2, continuation);
        this.$bean = publishPostRequestBean;
        this.this$0 = publishPostVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishPostVM$realPublishPost$2(this.$bean, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            PublishPostRequestBean publishPostRequestBean = this.$bean;
            this.label = 1;
            if (requestModel.r(publishPostRequestBean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.c();
        this.this$0.q().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
