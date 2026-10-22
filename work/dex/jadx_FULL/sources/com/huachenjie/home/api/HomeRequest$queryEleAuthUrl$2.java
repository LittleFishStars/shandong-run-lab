package com.huachenjie.home.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.home.bean.EleAuthUrlBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/home/bean/EleAuthUrlBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.api.HomeRequest$queryEleAuthUrl$2", f = "HomeRequest.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
public final class HomeRequest$queryEleAuthUrl$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<EleAuthUrlBean>>, Object> {
    int label;

    public HomeRequest$queryEleAuthUrl$2(Continuation<? super HomeRequest$queryEleAuthUrl$2> continuation) {
        super(1, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new HomeRequest$queryEleAuthUrl$2(continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<EleAuthUrlBean>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HomeApi homeApiA = HomeRequest.f34197a.a();
            this.label = 1;
            obj = homeApiA.k(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
