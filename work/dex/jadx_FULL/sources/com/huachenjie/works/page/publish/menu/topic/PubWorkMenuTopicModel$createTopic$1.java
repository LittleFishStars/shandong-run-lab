package com.huachenjie.works.page.publish.menu.topic;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.CreateTopicResultBean;
import com.huachenjie.works.bean.publish.PubWorkTopicBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicModel$createTopic$1", f = "PubWorkMenuTopicModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class PubWorkMenuTopicModel$createTopic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PubWorkTopicBean $bean;
    int label;
    final /* synthetic */ PubWorkMenuTopicModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PubWorkMenuTopicModel$createTopic$1(PubWorkTopicBean pubWorkTopicBean, PubWorkMenuTopicModel pubWorkMenuTopicModel, Continuation<? super PubWorkMenuTopicModel$createTopic$1> continuation) {
        super(2, continuation);
        this.$bean = pubWorkTopicBean;
        this.this$0 = pubWorkMenuTopicModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PubWorkMenuTopicModel$createTopic$1(this.$bean, this.this$0, continuation);
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
            String title = this.$bean.getTitle();
            this.label = 1;
            obj = requestModel.h(title, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CreateTopicResultBean createTopicResultBean = (CreateTopicResultBean) obj;
        if (createTopicResultBean == null) {
            return Unit.INSTANCE;
        }
        this.$bean.setSubjectNo(createTopicResultBean.getSubjectNo());
        this.this$0.L().setValue(this.$bean);
        return Unit.INSTANCE;
    }
}
