package com.huachenjie.run.page.sunshine_home;

import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.common.bean.SunshineRunDetail;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.sunshine_home.SunshineSchoolRuleVM$queryRunDetail$1", f = "SunshineSchoolRuleVM.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nSunshineSchoolRuleVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineSchoolRuleVM.kt\ncom/huachenjie/run/page/sunshine_home/SunshineSchoolRuleVM$queryRunDetail$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,79:1\n1#2:80\n*E\n"})
public final class SunshineSchoolRuleVM$queryRunDetail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    final /* synthetic */ int $sportType;
    int label;
    final /* synthetic */ SunshineSchoolRuleVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SunshineSchoolRuleVM$queryRunDetail$1(String str, String str2, int i, SunshineSchoolRuleVM sunshineSchoolRuleVM, Continuation<? super SunshineSchoolRuleVM$queryRunDetail$1> continuation) {
        super(2, continuation);
        this.$semesterCode = str;
        this.$runPlanCode = str2;
        this.$sportType = i;
        this.this$0 = sunshineSchoolRuleVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SunshineSchoolRuleVM$queryRunDetail$1(this.$semesterCode, this.$runPlanCode, this.$sportType, this.this$0, continuation);
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RunRequestModel runRequestModel = RunRequestModel.f35764a;
                String str = this.$semesterCode;
                String str2 = this.$runPlanCode;
                int i2 = this.$sportType;
                this.label = 1;
                obj = runRequestModel.x(str, str2, i2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            SunshineRunDetail sunshineRunDetail = (SunshineRunDetail) obj;
            this.this$0.n().setValue(sunshineRunDetail);
            MutableLiveData<Boolean> mutableLiveDataQ = this.this$0.q();
            if (sunshineRunDetail == null || sunshineRunDetail.getSchoolDemandRule() == null || CollectionUtils.r(sunshineRunDetail.getSchoolDemandRule().getMorningTimeFragment())) {
                z = false;
            }
            mutableLiveDataQ.setValue(Boxing.boxBoolean(z));
            if (sunshineRunDetail != null) {
                EventBus.f().q(sunshineRunDetail);
            }
            this.this$0.setRequestSunshineDetail(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.setRequestSunshineDetail(false);
            throw th;
        }
    }
}
