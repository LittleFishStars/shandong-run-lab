package com.huachenjie.compat.page.account;

import com.huachenjie.compat.api.CompatNewModel;
import com.huachenjie.compat.bean.PhonePreCheck;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.compat.page.account.AccountManageVM$modifyPhonePreCheck$2", f = "AccountManageVM.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
public final class AccountManageVM$modifyPhonePreCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountManageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountManageVM$modifyPhonePreCheck$2(AccountManageVM accountManageVM, Continuation<? super AccountManageVM$modifyPhonePreCheck$2> continuation) {
        super(2, continuation);
        this.this$0 = accountManageVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountManageVM$modifyPhonePreCheck$2(this.this$0, continuation);
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
            CompatNewModel compatNewModel = CompatNewModel.f33981a;
            this.label = 1;
            obj = compatNewModel.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PhonePreCheck phonePreCheck = (PhonePreCheck) obj;
        if (phonePreCheck == null) {
            return Unit.INSTANCE;
        }
        if (phonePreCheck.getCount() > 0) {
            this.this$0.k().setValue(Boxing.boxInt(phonePreCheck.getCount()));
        }
        return Unit.INSTANCE;
    }
}
