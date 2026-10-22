package com.huachenjie.login.page.base;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.LoginResultData;
import com.huachenjie.login.enums.LoginThirdType;
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
@DebugMetadata(c = "com.huachenjie.login.page.base.BaseLoginVM$thirdLogin$2", f = "BaseLoginVM.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
public final class BaseLoginVM$thirdLogin$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $thirdKey;
    final /* synthetic */ LoginThirdType $thirdType;
    Object L$0;
    int label;
    final /* synthetic */ BaseLoginVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseLoginVM$thirdLogin$2(BaseLoginVM baseLoginVM, LoginThirdType loginThirdType, String str, Continuation<? super BaseLoginVM$thirdLogin$2> continuation) {
        super(2, continuation);
        this.this$0 = baseLoginVM;
        this.$thirdType = loginThirdType;
        this.$thirdKey = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseLoginVM$thirdLogin$2(this.this$0, this.$thirdType, this.$thirdKey, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<LoginResultData> mutableLiveDataK = this.this$0.k();
            RequestModel requestModel = RequestModel.f34611a;
            int type = this.$thirdType.getType();
            String str = this.$thirdKey;
            this.L$0 = mutableLiveDataK;
            this.label = 1;
            Object objW = requestModel.w(type, str, (28 & 4) != 0 ? null : null, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null, this);
            if (objW == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataK;
            obj = objW;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }
}
