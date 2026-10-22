package com.huachenjie.works.page.alumni.original;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.OriginalPageEntity;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.original.OriginalChannelSubVM$loadMoreData$1", f = "OriginalChannelSubVM.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
public final class OriginalChannelSubVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OriginalChannelSubVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OriginalChannelSubVM$loadMoreData$1(OriginalChannelSubVM originalChannelSubVM, Continuation<? super OriginalChannelSubVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = originalChannelSubVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OriginalChannelSubVM$loadMoreData$1(this.this$0, continuation);
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
            String originalNo = Intrinsics.areEqual(this.this$0.getOriginalNo(), "-1") ? null : this.this$0.getOriginalNo();
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            this.label = 1;
            obj = requestModel.Y(originalNo, pageNum, refreshTime, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.u().setValue((OriginalPageEntity) obj);
        return Unit.INSTANCE;
    }
}
