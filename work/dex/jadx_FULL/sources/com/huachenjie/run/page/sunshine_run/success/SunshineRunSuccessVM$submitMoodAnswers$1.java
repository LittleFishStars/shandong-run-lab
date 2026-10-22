package com.huachenjie.run.page.sunshine_run.success;

import com.huachenjie.run.bean.EmaSelectionBean;
import com.huachenjie.run.model.RunRequestModel;
import java.util.List;
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
@DebugMetadata(c = "com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessVM$submitMoodAnswers$1", f = "SunshineRunSuccessVM.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class SunshineRunSuccessVM$submitMoodAnswers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $no;
    final /* synthetic */ List<EmaSelectionBean> $selections;
    int label;
    final /* synthetic */ SunshineRunSuccessVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SunshineRunSuccessVM$submitMoodAnswers$1(String str, List<EmaSelectionBean> list, SunshineRunSuccessVM sunshineRunSuccessVM, Continuation<? super SunshineRunSuccessVM$submitMoodAnswers$1> continuation) {
        super(2, continuation);
        this.$no = str;
        this.$selections = list;
        this.this$0 = sunshineRunSuccessVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SunshineRunSuccessVM$submitMoodAnswers$1(this.$no, this.$selections, this.this$0, continuation);
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
            String str = this.$no;
            List<EmaSelectionBean> list = this.$selections;
            this.label = 1;
            if (runRequestModel.F(str, list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.q().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
