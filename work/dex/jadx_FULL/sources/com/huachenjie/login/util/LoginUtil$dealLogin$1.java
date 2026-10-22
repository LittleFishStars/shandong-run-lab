package com.huachenjie.login.util;

import android.content.Context;
import com.huachenjie.base.api.RequestModel;
import com.huachenjie.common.bean.CommonUserInfo;
import com.huachenjie.login.bean.LoginResultData;
import com.zj.adlib.ai9;
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
@DebugMetadata(c = "com.huachenjie.login.util.LoginUtil$dealLogin$1", f = "LoginUtil.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class LoginUtil$dealLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ LoginResultData $result;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginUtil$dealLogin$1(LoginResultData loginResultData, Context context, Continuation<? super LoginUtil$dealLogin$1> continuation) {
        super(2, continuation);
        this.$result = loginResultData;
        this.$context = context;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LoginUtil$dealLogin$1(this.$result, this.$context, continuation);
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
            RequestModel requestModel = RequestModel.f32789a;
            this.label = 1;
            obj = requestModel.l(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CommonUserInfo commonUserInfo = (CommonUserInfo) obj;
        if (commonUserInfo != null) {
            commonUserInfo.setToken(this.$result.getToken());
            commonUserInfo.setSatoken(this.$result.getSatoken());
            ai9.s(commonUserInfo);
            com.huachenjie.base.app_widget.a.e(false, 1, null);
        }
        LoginUtil.f34754a.c(this.$context, this.$result);
        return Unit.INSTANCE;
    }
}
