package com.huachenjie.college.page.hw_health_detail;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.college.api.RequestModel;
import com.huachenjie.college.bean.HuaweiHealthDeductionOptionBean;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.hw_health_detail.HWHealthSportDetailVM$deductSunshineRun$2", f = "HWHealthSportDetailVM.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
public final class HWHealthSportDetailVM$deductSunshineRun$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $sportRecordCode;
    Object L$0;
    int label;
    final /* synthetic */ HWHealthSportDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWHealthSportDetailVM$deductSunshineRun$2(HWHealthSportDetailVM hWHealthSportDetailVM, String str, Continuation<? super HWHealthSportDetailVM$deductSunshineRun$2> continuation) {
        super(2, continuation);
        this.this$0 = hWHealthSportDetailVM;
        this.$sportRecordCode = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HWHealthSportDetailVM$deductSunshineRun$2(this.this$0, this.$sportRecordCode, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<List<HuaweiHealthDeductionOptionBean>> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<List<HuaweiHealthDeductionOptionBean>> mutableLiveDataM = this.this$0.m();
            RequestModel requestModel = RequestModel.f33549a;
            String str = this.$sportRecordCode;
            this.L$0 = mutableLiveDataM;
            this.label = 1;
            Object objG = requestModel.g(str, this);
            if (objG == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataM;
            obj = objG;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        List<HuaweiHealthDeductionOptionBean> list = pageEntity != null ? pageEntity.getList() : null;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        mutableLiveData.setValue(list);
        this.this$0.l().setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
