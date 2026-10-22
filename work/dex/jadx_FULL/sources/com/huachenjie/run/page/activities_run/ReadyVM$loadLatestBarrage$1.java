package com.huachenjie.run.page.activities_run;

import com.huachenjie.run.bean.DanmuBean;
import com.huachenjie.run.model.RunRequestModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.ReadyVM$loadLatestBarrage$1", f = "ReadyVM.kt", i = {}, l = {182}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nReadyVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadyVM.kt\ncom/huachenjie/run/page/activities_run/ReadyVM$loadLatestBarrage$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,255:1\n1#2:256\n*E\n"})
public final class ReadyVM$loadLatestBarrage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ReadyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadyVM$loadLatestBarrage$1(ReadyVM readyVM, Continuation<? super ReadyVM$loadLatestBarrage$1> continuation) {
        super(2, continuation);
        this.this$0 = readyVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReadyVM$loadLatestBarrage$1(this.this$0, continuation);
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
            this.label = 1;
            obj = runRequestModel.l(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<DanmuBean> list = (List) obj;
        if (list != null) {
            this.this$0.r().setValue(list);
        }
        return Unit.INSTANCE;
    }
}
