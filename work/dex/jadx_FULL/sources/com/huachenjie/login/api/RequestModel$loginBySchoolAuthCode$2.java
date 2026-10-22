package com.huachenjie.login.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.login.bean.LoginResultData;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lcom/huachenjie/login/bean/LoginResultData;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.api.RequestModel$loginBySchoolAuthCode$2", f = "RequestModel.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$loginBySchoolAuthCode$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<LoginResultData>>, Object> {
    final /* synthetic */ String $bindKey;
    final /* synthetic */ String $code;
    final /* synthetic */ String $number;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $schoolCode;
    final /* synthetic */ String $ticket;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$loginBySchoolAuthCode$2(String str, String str2, String str3, String str4, String str5, String str6, Continuation<? super RequestModel$loginBySchoolAuthCode$2> continuation) {
        super(1, continuation);
        this.$schoolCode = str;
        this.$number = str2;
        this.$phone = str3;
        this.$code = str4;
        this.$bindKey = str5;
        this.$ticket = str6;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$loginBySchoolAuthCode$2(this.$schoolCode, this.$number, this.$phone, this.$code, this.$bindKey, this.$ticket, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<LoginResultData>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LoginApi loginApiA = RequestModel.f34611a.a();
            String str = this.$schoolCode;
            String str2 = this.$number;
            String str3 = this.$phone;
            String str4 = this.$code;
            String str5 = this.$bindKey;
            String str6 = this.$ticket;
            this.label = 1;
            obj = loginApiA.o(str, str2, str3, str4, str5, str6, this);
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
