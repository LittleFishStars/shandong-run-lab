package com.huachenjie.works.page.activity;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.MultipleActivityData;
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
@DebugMetadata(c = "com.huachenjie.works.page.activity.ActivityListModel$queryActivityList$1", f = "ActivityListModel.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
public final class ActivityListModel$queryActivityList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $promotionPlace;
    int label;
    final /* synthetic */ ActivityListModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityListModel$queryActivityList$1(int i, ActivityListModel activityListModel, Continuation<? super ActivityListModel$queryActivityList$1> continuation) {
        super(2, continuation);
        this.$promotionPlace = i;
        this.this$0 = activityListModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ActivityListModel$queryActivityList$1(this.$promotionPlace, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f36762a;
            int i2 = this.$promotionPlace;
            this.label = 1;
            obj = requestModel.V(i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        MultipleActivityData multipleActivityData = (MultipleActivityData) obj;
        if (multipleActivityData == null) {
            return Unit.INSTANCE;
        }
        this.this$0.i().setValue(multipleActivityData);
        return Unit.INSTANCE;
    }
}
