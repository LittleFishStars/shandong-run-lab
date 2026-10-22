package com.huachenjie.works.page.alumni;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.SchoolmateConfigBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.AlumniVM$loadSchoolmateConfig$1", f = "AlumniVM.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
public final class AlumniVM$loadSchoolmateConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AlumniVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlumniVM$loadSchoolmateConfig$1(AlumniVM alumniVM, Continuation<? super AlumniVM$loadSchoolmateConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = alumniVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AlumniVM$loadSchoolmateConfig$1(this.this$0, continuation);
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
            MutableLiveData<SchoolmateConfigBean> mutableLiveDataI = this.this$0.i();
            RequestModel requestModel = RequestModel.f36762a;
            this.L$0 = mutableLiveDataI;
            this.label = 1;
            Object objX0 = requestModel.x0(this);
            if (objX0 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataI;
            obj = objX0;
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
