package com.huachenjie.login.page.info.nickname;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.RegisterConfigBean;
import com.zj.adlib.pg3;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.page.info.nickname.FillNicknameVM$getRegisterConfig$1", f = "FillNicknameVM.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class FillNicknameVM$getRegisterConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public FillNicknameVM$getRegisterConfig$1(Continuation<? super FillNicknameVM$getRegisterConfig$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FillNicknameVM$getRegisterConfig$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        pg3 pg3Var;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pg3 pg3Var2 = pg3.f18845a;
            RequestModel requestModel = RequestModel.f34611a;
            this.L$0 = pg3Var2;
            this.label = 1;
            Object objJ = requestModel.j(this);
            if (objJ == coroutine_suspended) {
                return coroutine_suspended;
            }
            pg3Var = pg3Var2;
            obj = objJ;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pg3Var = (pg3) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        pg3Var.h((RegisterConfigBean) obj);
        return Unit.INSTANCE;
    }
}
