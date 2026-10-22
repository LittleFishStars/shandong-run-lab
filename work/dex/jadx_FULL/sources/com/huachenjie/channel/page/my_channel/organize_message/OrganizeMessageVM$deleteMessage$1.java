package com.huachenjie.channel.page.my_channel.organize_message;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ClubMessageBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageVM$deleteMessage$1", f = "OrganizeMessageVM.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class OrganizeMessageVM$deleteMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ClubMessageBean $bean;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ OrganizeMessageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeMessageVM$deleteMessage$1(ClubMessageBean clubMessageBean, OrganizeMessageVM organizeMessageVM, int i, Continuation<? super OrganizeMessageVM$deleteMessage$1> continuation) {
        super(2, continuation);
        this.$bean = clubMessageBean;
        this.this$0 = organizeMessageVM;
        this.$position = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeMessageVM$deleteMessage$1(this.$bean, this.this$0, this.$position, continuation);
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
            String messageCode = this.$bean.getMessageCode();
            this.label = 1;
            if (requestModel.t(messageCode, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        OrganizeMessageAdapter value = this.this$0.C().getValue();
        Intrinsics.checkNotNull(value);
        value.removeAt(this.$position);
        OrganizeMessageAdapter value2 = this.this$0.C().getValue();
        Intrinsics.checkNotNull(value2);
        if (value2.getData().isEmpty()) {
            this.this$0.y();
        }
        return Unit.INSTANCE;
    }
}
