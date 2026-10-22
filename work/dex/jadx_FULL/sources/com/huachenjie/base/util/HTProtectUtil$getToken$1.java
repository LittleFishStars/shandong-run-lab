package com.huachenjie.base.util;

import com.huachenjie.base.api.RequestModel;
import com.netease.htprotect.HTProtect;
import com.netease.htprotect.result.AntiCheatResult;
import com.zj.adlib.i4a;
import com.zj.adlib.jo2;
import com.zj.adlib.pm1;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.util.HTProtectUtil$getToken$1", f = "HTProtectUtil.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class HTProtectUtil$getToken$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $runRecordCode;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.base.util.HTProtectUtil$getToken$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.base.util.HTProtectUtil$getToken$1$1", f = "HTProtectUtil.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $runRecordCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$runRecordCode = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$runRecordCode, continuation);
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
                AntiCheatResult token = HTProtect.getToken(3000, HTProtectUtil.c);
                i4a.b(HTProtectUtil.f7247a, "code:" + token.code + "，codeStr:" + token.codeStr + '}');
                if (token.code == 200) {
                    String str = token.token;
                    i4a.b(HTProtectUtil.f7247a, "sync token:" + str);
                    RequestModel requestModel = RequestModel.f32789a;
                    String str2 = this.$runRecordCode;
                    Intrinsics.checkNotNullExpressionValue(str, "token");
                    this.label = 1;
                    if (requestModel.t(str2, HTProtectUtil.c, str, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HTProtectUtil$getToken$1(String str, Continuation<? super HTProtectUtil$getToken$1> continuation) {
        super(2, continuation);
        this.$runRecordCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HTProtectUtil$getToken$1(this.$runRecordCode, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$runRecordCode, null);
            this.label = 1;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
