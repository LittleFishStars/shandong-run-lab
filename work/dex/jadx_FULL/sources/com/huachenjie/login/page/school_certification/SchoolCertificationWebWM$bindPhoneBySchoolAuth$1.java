package com.huachenjie.login.page.school_certification;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.LoginResultData;
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
@DebugMetadata(c = "com.huachenjie.login.page.school_certification.SchoolCertificationWebWM$bindPhoneBySchoolAuth$1", f = "SchoolCertificationWebWM.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class SchoolCertificationWebWM$bindPhoneBySchoolAuth$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bindKey;
    final /* synthetic */ String $number;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $schoolCode;
    int label;
    final /* synthetic */ SchoolCertificationWebWM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SchoolCertificationWebWM$bindPhoneBySchoolAuth$1(String str, String str2, String str3, String str4, SchoolCertificationWebWM schoolCertificationWebWM, Continuation<? super SchoolCertificationWebWM$bindPhoneBySchoolAuth$1> continuation) {
        super(2, continuation);
        this.$schoolCode = str;
        this.$number = str2;
        this.$phone = str3;
        this.$bindKey = str4;
        this.this$0 = schoolCertificationWebWM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SchoolCertificationWebWM$bindPhoneBySchoolAuth$1(this.$schoolCode, this.$number, this.$phone, this.$bindKey, this.this$0, continuation);
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
            String str = this.$schoolCode;
            String str2 = this.$number;
            String str3 = this.$phone;
            String str4 = this.$bindKey;
            this.label = 1;
            obj = requestModel.c(str, str2, str3, str4, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        LoginResultData loginResultData = (LoginResultData) obj;
        if (loginResultData != null) {
            this.this$0.m().setValue(loginResultData);
        }
        return Unit.INSTANCE;
    }
}
