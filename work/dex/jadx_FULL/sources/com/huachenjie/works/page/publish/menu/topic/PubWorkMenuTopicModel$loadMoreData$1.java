package com.huachenjie.works.page.publish.menu.topic;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
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
@DebugMetadata(c = "com.huachenjie.works.page.publish.menu.topic.PubWorkMenuTopicModel$loadMoreData$1", f = "PubWorkMenuTopicModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class PubWorkMenuTopicModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyWord;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ PubWorkMenuTopicModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PubWorkMenuTopicModel$loadMoreData$1(String str, PubWorkMenuTopicModel pubWorkMenuTopicModel, int i, Continuation<? super PubWorkMenuTopicModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.$keyWord = str;
        this.this$0 = pubWorkMenuTopicModel;
        this.$type = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PubWorkMenuTopicModel$loadMoreData$1(this.$keyWord, this.this$0, this.$type, continuation);
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
            String str = this.$keyWord;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            this.label = 1;
            obj = requestModel.n0(str, pageNum, refreshTime, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PubWorksMenuPageEntity<?> pubWorksMenuPageEntityN = this.this$0.N(this.$type, this.$keyWord, (PubWorksMenuPageEntity) obj);
        if (pubWorksMenuPageEntityN == null) {
            return Unit.INSTANCE;
        }
        pubWorksMenuPageEntityN.setType(this.$type);
        this.this$0.E().setValue(pubWorksMenuPageEntityN);
        return Unit.INSTANCE;
    }
}
