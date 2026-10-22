package com.huachenjie.compat.page.account;

import com.huachenjie.base.bean.AliPay;
import com.huachenjie.base.bean.BindInfo;
import com.huachenjie.base.bean.Qq;
import com.huachenjie.base.bean.Wx;
import com.huachenjie.compat.api.CompatNewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.compat.page.account.AccountManageVM$loadUserSettings$1", f = "AccountManageVM.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAccountManageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AccountManageVM.kt\ncom/huachenjie/compat/page/account/AccountManageVM$loadUserSettings$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n1#2:98\n*E\n"})
public final class AccountManageVM$loadUserSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountManageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountManageVM$loadUserSettings$1(AccountManageVM accountManageVM, Continuation<? super AccountManageVM$loadUserSettings$1> continuation) {
        super(2, continuation);
        this.this$0 = accountManageVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountManageVM$loadUserSettings$1(this.this$0, continuation);
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
            obj = compatNewModel.g(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BindInfo bindInfo = (BindInfo) obj;
        if (bindInfo == null) {
            return Unit.INSTANCE;
        }
        Wx wx = bindInfo.getWx();
        if (wx != null) {
            this.this$0.q().setValue(Boxing.boxBoolean(Intrinsics.areEqual(wx.getBindStatus(), Boxing.boxBoolean(true))));
        }
        Qq qq = bindInfo.getQq();
        if (qq != null) {
            this.this$0.p().setValue(Boxing.boxBoolean(Intrinsics.areEqual(qq.getBindStatus(), Boxing.boxBoolean(true))));
        }
        AliPay aliPay = bindInfo.getAliPay();
        if (aliPay != null) {
            this.this$0.o().setValue(Boxing.boxBoolean(Intrinsics.areEqual(aliPay.getBindStatus(), Boxing.boxBoolean(true))));
        }
        return Unit.INSTANCE;
    }
}
