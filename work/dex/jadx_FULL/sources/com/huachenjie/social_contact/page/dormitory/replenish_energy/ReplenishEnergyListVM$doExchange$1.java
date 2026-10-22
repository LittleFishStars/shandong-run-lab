package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import com.huachenjie.social_contact.api.RequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListVM$doExchange$1", f = "ReplenishEnergyListVM.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class ReplenishEnergyListVM$doExchange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $drinkId;
    int label;
    final /* synthetic */ ReplenishEnergyListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplenishEnergyListVM$doExchange$1(String str, ReplenishEnergyListVM replenishEnergyListVM, Continuation<? super ReplenishEnergyListVM$doExchange$1> continuation) {
        super(2, continuation);
        this.$drinkId = str;
        this.this$0 = replenishEnergyListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReplenishEnergyListVM$doExchange$1(this.$drinkId, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f36069a;
            String str = this.$drinkId;
            this.label = 1;
            if (requestModel.c(str, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.n().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
