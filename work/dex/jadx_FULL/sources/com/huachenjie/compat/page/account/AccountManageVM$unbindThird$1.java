package com.huachenjie.compat.page.account;

import com.huachenjie.common.enums.ThirdLoginType;
import com.huachenjie.compat.api.CompatNewModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.compat.page.account.AccountManageVM$unbindThird$1", f = "AccountManageVM.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
public final class AccountManageVM$unbindThird$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ThirdLoginType $type;
    int label;
    final /* synthetic */ AccountManageVM this$0;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f34083a;

        static {
            int[] iArr = new int[ThirdLoginType.values().length];
            try {
                iArr[ThirdLoginType.WeiXin.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ThirdLoginType.QQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ThirdLoginType.AliPay.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f34083a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountManageVM$unbindThird$1(ThirdLoginType thirdLoginType, AccountManageVM accountManageVM, Continuation<? super AccountManageVM$unbindThird$1> continuation) {
        super(2, continuation);
        this.$type = thirdLoginType;
        this.this$0 = accountManageVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AccountManageVM$unbindThird$1(this.$type, this.this$0, continuation);
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
            ThirdLoginType thirdLoginType = this.$type;
            this.label = 1;
            if (compatNewModel.i(thirdLoginType, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        int i2 = a.f34083a[this.$type.ordinal()];
        if (i2 == 1) {
            this.this$0.q().setValue(Boxing.boxBoolean(false));
        } else if (i2 == 2) {
            this.this$0.p().setValue(Boxing.boxBoolean(false));
        } else if (i2 == 3) {
            this.this$0.o().setValue(Boxing.boxBoolean(false));
        }
        fv5.b("解绑成功");
        return Unit.INSTANCE;
    }
}
