package com.huachenjie.channel.page.manage_channel.topic;

import com.huachenjie.channel.bean.my_channel.MyChannelTopic;
import com.zj.adlib.pf6;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.topic.CreateTopicVM$uploadFile$2$2", f = "CreateTopicVM.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class CreateTopicVM$uploadFile$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MyChannelTopic $bean;
    final /* synthetic */ List<pf6> $fileInfoList;
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onSuccess;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateTopicVM$uploadFile$2$2(MyChannelTopic myChannelTopic, List<pf6> list, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super CreateTopicVM$uploadFile$2$2> continuation) {
        super(2, continuation);
        this.$bean = myChannelTopic;
        this.$fileInfoList = list;
        this.$onSuccess = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreateTopicVM$uploadFile$2$2(this.$bean, this.$fileInfoList, this.$onSuccess, continuation);
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
            MyChannelTopic myChannelTopic = this.$bean;
            String strE = this.$fileInfoList.get(0).e();
            Intrinsics.checkNotNullExpressionValue(strE, "fileInfoList[0].fileUrl");
            myChannelTopic.setSubjectImg(strE);
            Function1<Continuation<? super Unit>, Object> function1 = this.$onSuccess;
            this.label = 1;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
