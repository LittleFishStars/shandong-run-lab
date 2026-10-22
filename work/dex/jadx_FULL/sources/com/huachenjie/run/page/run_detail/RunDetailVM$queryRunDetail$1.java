package com.huachenjie.run.page.run_detail;

import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.model.RunRequestModel;
import com.zj.adlib.jj8;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.run_detail.RunDetailVM$queryRunDetail$1", f = "RunDetailVM.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class RunDetailVM$queryRunDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $runRecordCode;
    final /* synthetic */ String $semesterCode;
    int label;
    final /* synthetic */ RunDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunDetailVM$queryRunDetail$1(String str, String str2, RunDetailVM runDetailVM, Continuation<? super RunDetailVM$queryRunDetail$1> continuation) {
        super(2, continuation);
        this.$runRecordCode = str;
        this.$semesterCode = str2;
        this.this$0 = runDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunDetailVM$queryRunDetail$1(this.$runRecordCode, this.$semesterCode, this.this$0, continuation);
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
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            String str = this.$runRecordCode;
            String str2 = this.$semesterCode;
            this.label = 1;
            obj = runRequestModel.t(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        RunDetailEntity runDetailEntity = (RunDetailEntity) obj;
        if (runDetailEntity == null) {
            return Unit.INSTANCE;
        }
        this.this$0.o(runDetailEntity);
        this.this$0.m().setValue(Boxing.boxFloat(jj8.a(runDetailEntity.isValid() ? 420 : 272)));
        this.this$0.l().setValue(runDetailEntity);
        return Unit.INSTANCE;
    }
}
