package com.huachenjie.login.page.school_certification;

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
@DebugMetadata(c = "com.huachenjie.login.page.school_certification.SchoolCertificationWebActivity$dealLogin$1", f = "SchoolCertificationWebActivity.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
public final class SchoolCertificationWebActivity$dealLogin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommonUserInfo $commonUserInfo;
    final /* synthetic */ LoginResultData $loginResult;
    int label;
    final /* synthetic */ SchoolCertificationWebActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SchoolCertificationWebActivity$dealLogin$1(LoginResultData loginResultData, CommonUserInfo commonUserInfo, SchoolCertificationWebActivity schoolCertificationWebActivity, Continuation<? super SchoolCertificationWebActivity$dealLogin$1> continuation) {
        super(2, continuation);
        this.$loginResult = loginResultData;
        this.$commonUserInfo = commonUserInfo;
        this.this$0 = schoolCertificationWebActivity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SchoolCertificationWebActivity$dealLogin$1(this.$loginResult, this.$commonUserInfo, this.this$0, continuation);
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
            commonUserInfo.setUserType(this.$loginResult.getUserType());
            commonUserInfo.setToken(this.$commonUserInfo.getToken());
            commonUserInfo.setSatoken(this.$commonUserInfo.getSatoken());
            ai9.s(commonUserInfo);
        }
        this.this$0.finish();
        return Unit.INSTANCE;
    }
}
