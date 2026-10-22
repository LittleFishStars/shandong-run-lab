package com.huachenjie.college.page.lightningPlay;

import com.huachenjie.college.api.RequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.lightningPlay.MoxiPlayVm$uploadGameRecordInfo$1", f = "MoxiPlayVm.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class MoxiPlayVm$uploadGameRecordInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $receiveFlag;
    final /* synthetic */ long $startTime;
    final /* synthetic */ int $viewTime;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoxiPlayVm$uploadGameRecordInfo$1(long j, int i, int i2, Continuation<? super MoxiPlayVm$uploadGameRecordInfo$1> continuation) {
        super(2, continuation);
        this.$startTime = j;
        this.$viewTime = i;
        this.$receiveFlag = i2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MoxiPlayVm$uploadGameRecordInfo$1(this.$startTime, this.$viewTime, this.$receiveFlag, continuation);
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
            RequestModel requestModel = RequestModel.f33549a;
            long j = this.$startTime;
            int i2 = this.$viewTime;
            int i3 = this.$receiveFlag;
            this.label = 1;
            if (requestModel.s(j, i2, i3, this) == coroutine_suspended) {
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
