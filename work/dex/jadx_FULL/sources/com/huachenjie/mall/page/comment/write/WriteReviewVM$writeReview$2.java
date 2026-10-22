package com.huachenjie.mall.page.comment.write;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.WriteReviewRequestBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.comment.write.WriteReviewVM$writeReview$2", f = "WriteReviewVM.kt", i = {}, l = {135}, m = "invokeSuspend", n = {}, s = {})
public final class WriteReviewVM$writeReview$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WriteReviewRequestBean $bean;
    int label;
    final /* synthetic */ WriteReviewVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WriteReviewVM$writeReview$2(WriteReviewRequestBean writeReviewRequestBean, WriteReviewVM writeReviewVM, Continuation<? super WriteReviewVM$writeReview$2> continuation) {
        super(2, continuation);
        this.$bean = writeReviewRequestBean;
        this.this$0 = writeReviewVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WriteReviewVM$writeReview$2(this.$bean, this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            WriteReviewRequestBean writeReviewRequestBean = this.$bean;
            this.label = 1;
            obj = mallModel.n0(writeReviewRequestBean, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (Intrinsics.areEqual((Boolean) obj, Boxing.boxBoolean(true))) {
            this.this$0.v().setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
