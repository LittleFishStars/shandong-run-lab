package com.huachenjie.channel.page.notify.mailbox;

import com.huachenjie.channel.api.RequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.notify.mailbox.NotifyMailBoxModel$readMessage$1", f = "NotifyMailBoxModel.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class NotifyMailBoxModel$readMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msgId;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ NotifyMailBoxModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyMailBoxModel$readMessage$1(String str, NotifyMailBoxModel notifyMailBoxModel, int i, Continuation<? super NotifyMailBoxModel$readMessage$1> continuation) {
        super(2, continuation);
        this.$msgId = str;
        this.this$0 = notifyMailBoxModel;
        this.$position = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotifyMailBoxModel$readMessage$1(this.$msgId, this.this$0, this.$position, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$msgId;
            this.label = 1;
            if (requestModel.x0(7, str, 1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.D().setValue(Boxing.boxInt(this.$position));
        return Unit.INSTANCE;
    }
}
