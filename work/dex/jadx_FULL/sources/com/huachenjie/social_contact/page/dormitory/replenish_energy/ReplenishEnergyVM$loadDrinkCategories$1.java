package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.social_contact.api.RequestModel;
import com.huachenjie.social_contact.bean.DrinkCategory;
import huachenjie.sdk.http.PageEntity;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyVM$loadDrinkCategories$1", f = "ReplenishEnergyVM.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class ReplenishEnergyVM$loadDrinkCategories$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ReplenishEnergyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplenishEnergyVM$loadDrinkCategories$1(ReplenishEnergyVM replenishEnergyVM, Continuation<? super ReplenishEnergyVM$loadDrinkCategories$1> continuation) {
        super(2, continuation);
        this.this$0 = replenishEnergyVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReplenishEnergyVM$loadDrinkCategories$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<List<DrinkCategory>> mutableLiveData;
        List<DrinkCategory> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<List<DrinkCategory>> mutableLiveDataJ = this.this$0.j();
            RequestModel requestModel = RequestModel.f36069a;
            this.L$0 = mutableLiveDataJ;
            this.label = 1;
            Object objD = requestModel.d(this);
            if (objD == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataJ;
            obj = objD;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null || (list = pageEntity.getList()) == null) {
            return Unit.INSTANCE;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }
}
