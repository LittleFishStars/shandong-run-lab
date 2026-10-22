package com.huachenjie.login.page.password;

import com.huachenjie.login.R;
import com.huachenjie.login.api.RequestModel;
import com.zj.adlib.fv5;
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
@DebugMetadata(c = "com.huachenjie.login.page.password.SetPasswordVM$resetPassword$1", f = "SetPasswordVM.kt", i = {}, l = {114}, m = "invokeSuspend", n = {}, s = {})
public final class SetPasswordVM$resetPassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $phone;
    int label;
    final /* synthetic */ SetPasswordVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetPasswordVM$resetPassword$1(SetPasswordVM setPasswordVM, String str, Continuation<? super SetPasswordVM$resetPassword$1> continuation) {
        super(2, continuation);
        this.this$0 = setPasswordVM;
        this.$phone = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SetPasswordVM$resetPassword$1(this.this$0, this.$phone, continuation);
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
            String str = this.this$0.lastTicket;
            String value = this.this$0.q().getValue();
            String value2 = this.this$0.w().getValue();
            String str2 = this.$phone;
            this.label = 1;
            if (requestModel.r(str, value, value2, str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.a(R.string.login_set_password_success);
        this.this$0.m().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
