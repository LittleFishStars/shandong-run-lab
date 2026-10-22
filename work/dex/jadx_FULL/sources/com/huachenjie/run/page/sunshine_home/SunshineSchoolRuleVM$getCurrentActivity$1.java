package com.huachenjie.run.page.sunshine_home;

import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.common.bean.CurrentActivityData;
import com.huachenjie.run.model.RunRequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.sunshine_home.SunshineSchoolRuleVM$getCurrentActivity$1", f = "SunshineSchoolRuleVM.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class SunshineSchoolRuleVM$getCurrentActivity$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SunshineSchoolRuleVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SunshineSchoolRuleVM$getCurrentActivity$1(SunshineSchoolRuleVM sunshineSchoolRuleVM, Continuation<? super SunshineSchoolRuleVM$getCurrentActivity$1> continuation) {
        super(2, continuation);
        this.this$0 = sunshineSchoolRuleVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SunshineSchoolRuleVM$getCurrentActivity$1(this.this$0, continuation);
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
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            this.label = 1;
            obj = runRequestModel.h(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CurrentActivityData currentActivityData = (CurrentActivityData) obj;
        this.this$0.o().setValue(Boxing.boxBoolean((currentActivityData == null || CollectionUtils.r(currentActivityData.getList())) ? false : true));
        return Unit.INSTANCE;
    }
}
