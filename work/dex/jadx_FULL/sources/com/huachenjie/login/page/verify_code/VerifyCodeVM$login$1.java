package com.huachenjie.login.page.verify_code;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.enums.LoginThirdType;
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
@DebugMetadata(c = "com.huachenjie.login.page.verify_code.VerifyCodeVM$login$1", f = "VerifyCodeVM.kt", i = {}, l = {53, 61, 72}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyCodeVM$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $verifyCode;
    int label;
    final /* synthetic */ VerifyCodeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyCodeVM$login$1(VerifyCodeVM verifyCodeVM, String str, Continuation<? super VerifyCodeVM$login$1> continuation) {
        super(2, continuation);
        this.this$0 = verifyCodeVM;
        this.$verifyCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VerifyCodeVM$login$1(this.this$0, this.$verifyCode, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LoginResultData loginResultData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Integer value = this.this$0.m().getValue();
            int type = LoginThirdType.None.getType();
            if (value != null && value.intValue() == type) {
                RequestModel requestModel = RequestModel.f34611a;
                String value2 = this.this$0.k().getValue();
                if (value2 == null) {
                    value2 = "";
                }
                String str = this.$verifyCode;
                String value3 = this.this$0.j().getValue();
                String str2 = value3 != null ? value3 : "";
                this.label = 1;
                obj = requestModel.l(value2, str, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                loginResultData = (LoginResultData) obj;
            } else {
                int type2 = LoginThirdType.School.getType();
                if (value != null && value.intValue() == type2) {
                    RequestModel requestModel2 = RequestModel.f34611a;
                    String value4 = this.this$0.n().getValue();
                    String str3 = value4 == null ? "" : value4;
                    String value5 = this.this$0.s().getValue();
                    String str4 = value5 == null ? "" : value5;
                    String value6 = this.this$0.k().getValue();
                    String str5 = value6 == null ? "" : value6;
                    String str6 = this.$verifyCode;
                    String value7 = this.this$0.i().getValue();
                    String str7 = value7 == null ? "" : value7;
                    String value8 = this.this$0.j().getValue();
                    String str8 = value8 == null ? "" : value8;
                    this.label = 2;
                    obj = requestModel2.k(str3, str4, str5, str6, str7, str8, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loginResultData = (LoginResultData) obj;
                } else {
                    RequestModel requestModel3 = RequestModel.f34611a;
                    Integer value9 = this.this$0.m().getValue();
                    if (value9 == null) {
                        value9 = Boxing.boxInt(0);
                    }
                    int iIntValue = value9.intValue();
                    String value10 = this.this$0.t().getValue();
                    if (value10 == null) {
                        value10 = "";
                    }
                    String value11 = this.this$0.k().getValue();
                    if (value11 == null) {
                        value11 = "";
                    }
                    String str9 = this.$verifyCode;
                    String value12 = this.this$0.j().getValue();
                    this.label = 3;
                    obj = requestModel3.w(iIntValue, value10, value11, str9, value12, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    loginResultData = (LoginResultData) obj;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            loginResultData = (LoginResultData) obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            loginResultData = (LoginResultData) obj;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            loginResultData = (LoginResultData) obj;
        }
        if (loginResultData != null) {
            this.this$0.l().setValue(loginResultData);
        }
        return Unit.INSTANCE;
    }
}
