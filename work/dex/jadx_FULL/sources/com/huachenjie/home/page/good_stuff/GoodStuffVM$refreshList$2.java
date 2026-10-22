package com.huachenjie.home.page.good_stuff;

import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.GoodStuffBannerBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.good_stuff.GoodStuffVM$refreshList$2", f = "GoodStuffVM.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class GoodStuffVM$refreshList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $afterRefresh;
    int label;
    final /* synthetic */ GoodStuffVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodStuffVM$refreshList$2(GoodStuffVM goodStuffVM, Function0<Unit> function0, Continuation<? super GoodStuffVM$refreshList$2> continuation) {
        super(2, continuation);
        this.this$0 = goodStuffVM;
        this.$afterRefresh = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GoodStuffVM$refreshList$2(this.this$0, this.$afterRefresh, continuation);
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
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.label = 1;
            obj = homeRequest.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.p(this.$afterRefresh, (GoodStuffBannerBean) obj);
        return Unit.INSTANCE;
    }
}
