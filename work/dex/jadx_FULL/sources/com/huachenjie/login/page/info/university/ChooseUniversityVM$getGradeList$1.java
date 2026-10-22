package com.huachenjie.login.page.info.university;

import com.huachenjie.login.api.RequestModel;
import com.huachenjie.login.bean.GradeBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.login.page.info.university.ChooseUniversityVM$getGradeList$1", f = "ChooseUniversityVM.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
public final class ChooseUniversityVM$getGradeList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChooseUniversityVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseUniversityVM$getGradeList$1(ChooseUniversityVM chooseUniversityVM, Continuation<? super ChooseUniversityVM$getGradeList$1> continuation) {
        super(2, continuation);
        this.this$0 = chooseUniversityVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChooseUniversityVM$getGradeList$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f34611a;
            this.label = 1;
            obj = requestModel.i(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List<GradeBean> list = (List) obj;
        List<GradeBean> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        }
        if (z) {
            return Unit.INSTANCE;
        }
        this.this$0.m().setValue(list);
        return Unit.INSTANCE;
    }
}
