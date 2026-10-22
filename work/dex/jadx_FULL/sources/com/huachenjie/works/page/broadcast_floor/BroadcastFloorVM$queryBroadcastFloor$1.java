package com.huachenjie.works.page.broadcast_floor;

import android.text.TextUtils;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.BroadcastFloorBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM$queryBroadcastFloor$1", f = "BroadcastFloorVM.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class BroadcastFloorVM$queryBroadcastFloor$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BroadcastFloorVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastFloorVM$queryBroadcastFloor$1(BroadcastFloorVM broadcastFloorVM, Continuation<? super BroadcastFloorVM$queryBroadcastFloor$1> continuation) {
        super(2, continuation);
        this.this$0 = broadcastFloorVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BroadcastFloorVM$queryBroadcastFloor$1(this.this$0, continuation);
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
            this.label = 1;
            obj = requestModel.A(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BroadcastFloorBean broadcastFloorBean = (BroadcastFloorBean) obj;
        if (broadcastFloorBean != null) {
            BroadcastFloorVM broadcastFloorVM = this.this$0;
            broadcastFloorVM.l().setValue(broadcastFloorBean);
            broadcastFloorVM.p().setValue(Boxing.boxBoolean(!TextUtils.isEmpty(broadcastFloorBean.getSurveyNo())));
        }
        return Unit.INSTANCE;
    }
}
