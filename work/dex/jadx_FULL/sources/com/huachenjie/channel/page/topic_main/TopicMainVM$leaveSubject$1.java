package com.huachenjie.channel.page.topic_main;

import com.huachenjie.channel.R;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.TopicMainBean;
import com.zj.adlib.fv5;
import com.zj.adlib.ys8;
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
@DebugMetadata(c = "com.huachenjie.channel.page.topic_main.TopicMainVM$leaveSubject$1", f = "TopicMainVM.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class TopicMainVM$leaveSubject$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectNo;
    int label;
    final /* synthetic */ TopicMainVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicMainVM$leaveSubject$1(String str, TopicMainVM topicMainVM, Continuation<? super TopicMainVM$leaveSubject$1> continuation) {
        super(2, continuation);
        this.$subjectNo = str;
        this.this$0 = topicMainVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TopicMainVM$leaveSubject$1(this.$subjectNo, this.this$0, continuation);
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
            String str = this.$subjectNo;
            this.label = 1;
            if (requestModel.C(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        TopicMainBean value = this.this$0.p().getValue();
        if (value != null) {
            TopicMainVM topicMainVM = this.this$0;
            value.setJoinFlag(false);
            topicMainVM.p().setValue(value);
            topicMainVM.n().setValue(Boxing.boxInt(2));
            fv5.b(ys8.e(R.string.channel_main_leave_success));
        }
        return Unit.INSTANCE;
    }
}
