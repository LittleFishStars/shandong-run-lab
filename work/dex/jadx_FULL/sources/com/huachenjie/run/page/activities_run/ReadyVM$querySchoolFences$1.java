package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.model.RunRequestModel;
import java.util.List;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.ReadyVM$querySchoolFences$1", f = "ReadyVM.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class ReadyVM$querySchoolFences$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $schoolCode;
    Object L$0;
    int label;
    final /* synthetic */ ReadyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadyVM$querySchoolFences$1(ReadyVM readyVM, String str, Continuation<? super ReadyVM$querySchoolFences$1> continuation) {
        super(2, continuation);
        this.this$0 = readyVM;
        this.$schoolCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReadyVM$querySchoolFences$1(this.this$0, this.$schoolCode, continuation);
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
            MutableLiveData<List<GeoFenceDetail>> mutableLiveDataS = this.this$0.s();
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            String str = this.$schoolCode;
            this.L$0 = mutableLiveDataS;
            this.label = 1;
            Object objW = runRequestModel.w(str, this);
            if (objW == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataS;
            obj = objW;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        this.this$0.P();
        return Unit.INSTANCE;
    }
}
