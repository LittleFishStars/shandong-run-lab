package com.huachenjie.college.page.recreation;

import com.huachenjie.base.api.RequestModel;
import com.huachenjie.base.bean.EntryTypeUrlBean;
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
@DebugMetadata(c = "com.huachenjie.college.page.recreation.RecreationVM$queryVideoUrl$1", f = "RecreationVM.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class RecreationVM$queryVideoUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $callback;
    int label;
    final /* synthetic */ RecreationVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RecreationVM$queryVideoUrl$1(RecreationVM recreationVM, Function1<? super String, Unit> function1, Continuation<? super RecreationVM$queryVideoUrl$1> continuation) {
        super(2, continuation);
        this.this$0 = recreationVM;
        this.$callback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecreationVM$queryVideoUrl$1(this.this$0, this.$callback, continuation);
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
            RequestModel requestModel = RequestModel.f32789a;
            this.label = 1;
            obj = requestModel.m(22, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        EntryTypeUrlBean entryTypeUrlBean = (EntryTypeUrlBean) obj;
        if (entryTypeUrlBean == null) {
            return Unit.INSTANCE;
        }
        this.this$0.com.huachenjie.common.video.VideoPlayerActivity.t java.lang.String = entryTypeUrlBean.getLinkUrl();
        Function1<String, Unit> function1 = this.$callback;
        String str = this.this$0.com.huachenjie.common.video.VideoPlayerActivity.t java.lang.String;
        Intrinsics.checkNotNull(str);
        function1.invoke(str);
        return Unit.INSTANCE;
    }
}
