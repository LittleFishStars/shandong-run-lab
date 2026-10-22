package com.huachenjie.works.page.dormitory;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.dorm.DormEnergyBean;
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
@DebugMetadata(c = "com.huachenjie.works.page.dormitory.DormitoryVM$querySpaceEnergyStatus$1", f = "DormitoryVM.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
public final class DormitoryVM$querySpaceEnergyStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $needRefreshCharm;
    Object L$0;
    int label;
    final /* synthetic */ DormitoryVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DormitoryVM$querySpaceEnergyStatus$1(DormitoryVM dormitoryVM, boolean z, Continuation<? super DormitoryVM$querySpaceEnergyStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = dormitoryVM;
        this.$needRefreshCharm = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DormitoryVM$querySpaceEnergyStatus$1(this.this$0, this.$needRefreshCharm, continuation);
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
            MutableLiveData<DormEnergyBean> mutableLiveDataJ = this.this$0.j();
            RequestModel requestModel = RequestModel.f36762a;
            this.L$0 = mutableLiveDataJ;
            this.label = 1;
            Object objD0 = requestModel.D0(this);
            if (objD0 == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataJ;
            obj = objD0;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        mutableLiveData.setValue(obj);
        if (this.$needRefreshCharm) {
            DormEnergyBean value = this.this$0.j().getValue();
            if (value != null && value.getShowSupplementBtn()) {
                this.this$0.q();
            }
        }
        return Unit.INSTANCE;
    }
}
