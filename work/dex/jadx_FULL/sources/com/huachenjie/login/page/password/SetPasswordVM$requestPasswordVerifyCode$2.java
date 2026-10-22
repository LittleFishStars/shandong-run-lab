package com.huachenjie.login.page.password;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.PasswordVerifyCodeData;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.page.password.SetPasswordVM$requestPasswordVerifyCode$2", f = "SetPasswordVM.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class SetPasswordVM$requestPasswordVerifyCode$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $captchaPoint;
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ SetPasswordVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPasswordVM$requestPasswordVerifyCode$2(String str, String str2, SetPasswordVM setPasswordVM, Continuation<? super SetPasswordVM$requestPasswordVerifyCode$2> continuation) {
        super(2, continuation);
        this.$phone = str;
        this.$captchaPoint = str2;
        this.this$0 = setPasswordVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SetPasswordVM$requestPasswordVerifyCode$2(this.$phone, this.$captchaPoint, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String ticket;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f34611a;
            String str = this.$phone;
            String str2 = this.$captchaPoint;
            this.label = 1;
            obj = requestModel.q(str, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PasswordVerifyCodeData passwordVerifyCodeData = (PasswordVerifyCodeData) obj;
        SetPasswordVM setPasswordVM = this.this$0;
        if (passwordVerifyCodeData == null || (ticket = passwordVerifyCodeData.getTicket()) == null) {
            ticket = "";
        }
        setPasswordVM.lastTicket = ticket;
        this.this$0.v().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
