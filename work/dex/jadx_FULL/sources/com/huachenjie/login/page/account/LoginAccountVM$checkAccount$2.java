package com.huachenjie.login.page.account;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.LoginCheckData;
import com.huachenjie.login.enums.LoginType;
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
@DebugMetadata(c = "com.huachenjie.login.page.account.LoginAccountVM$checkAccount$2", f = "LoginAccountVM.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class LoginAccountVM$checkAccount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoginType $type;
    int label;
    final /* synthetic */ LoginAccountVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginAccountVM$checkAccount$2(LoginAccountVM loginAccountVM, LoginType loginType, Continuation<? super LoginAccountVM$checkAccount$2> continuation) {
        super(2, continuation);
        this.this$0 = loginAccountVM;
        this.$type = loginType;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoginAccountVM$checkAccount$2(this.this$0, this.$type, continuation);
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
            RequestModel requestModel = RequestModel.f34611a;
            String value = this.this$0.o().getValue();
            if (value == null) {
                value = "";
            }
            this.label = 1;
            obj = requestModel.m(value, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        LoginCheckData loginCheckData = (LoginCheckData) obj;
        if (loginCheckData != null) {
            loginCheckData.setLoginType(this.$type.getValue());
        }
        this.this$0.p().setValue(loginCheckData);
        return Unit.INSTANCE;
    }
}
