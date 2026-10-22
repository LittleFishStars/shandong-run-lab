package com.huachenjie.mall.dialog.poster;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.PosterDetailBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.dialog.poster.CreatePosterVM$queryPosterDetail$1", f = "CreatePosterVM.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class CreatePosterVM$queryPosterDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $shareNo;
    int label;
    final /* synthetic */ CreatePosterVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreatePosterVM$queryPosterDetail$1(String str, CreatePosterVM createPosterVM, Continuation<? super CreatePosterVM$queryPosterDetail$1> continuation) {
        super(2, continuation);
        this.$shareNo = str;
        this.this$0 = createPosterVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreatePosterVM$queryPosterDetail$1(this.$shareNo, this.this$0, continuation);
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
            String str = this.$shareNo;
            this.label = 1;
            obj = mallModel.V(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PosterDetailBean posterDetailBean = (PosterDetailBean) obj;
        if (posterDetailBean == null) {
            posterDetailBean = new PosterDetailBean(null, null, null, null, null, null, null, null, null, 511, null);
        }
        this.this$0.m().setValue(posterDetailBean);
        return Unit.INSTANCE;
    }
}
