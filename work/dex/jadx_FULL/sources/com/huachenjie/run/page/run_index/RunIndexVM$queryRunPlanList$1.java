package com.huachenjie.run.page.run_index;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.bean.RunPlanListBean;
import com.huachenjie.run.model.RunRequestModel;
import com.zj.adlib.ai9;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.run_index.RunIndexVM$queryRunPlanList$1", f = "RunIndexVM.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
public final class RunIndexVM$queryRunPlanList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $semesterCode;
    int label;
    final /* synthetic */ RunIndexVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunIndexVM$queryRunPlanList$1(String str, RunIndexVM runIndexVM, Continuation<? super RunIndexVM$queryRunPlanList$1> continuation) {
        super(2, continuation);
        this.$semesterCode = str;
        this.this$0 = runIndexVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunIndexVM$queryRunPlanList$1(this.$semesterCode, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<RunPlanBean> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RunRequestModel runRequestModel = RunRequestModel.f35764a;
                String str = this.$semesterCode;
                this.label = 1;
                obj = runRequestModel.v(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            RunPlanListBean runPlanListBean = (RunPlanListBean) obj;
            Object obj2 = null;
            this.this$0.T().setValue(runPlanListBean != null ? runPlanListBean.getList() : null);
            if ((runPlanListBean == null || (list = runPlanListBean.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                String strI = ai9.i();
                MutableLiveData<RunPlanBean> mutableLiveDataD = this.this$0.D();
                for (Object obj3 : runPlanListBean.getList()) {
                    if (Intrinsics.areEqual(((RunPlanBean) obj3).getRunPlanCode(), strI)) {
                        obj2 = obj3;
                        break;
                    }
                }
                RunPlanBean runPlanBean = (RunPlanBean) obj2;
                if (runPlanBean == null) {
                    runPlanBean = runPlanListBean.getList().get(0);
                }
                mutableLiveDataD.setValue(runPlanBean);
            } else {
                this.this$0.D().setValue(null);
            }
            this.this$0.B0(true);
            this.this$0.isLoadPlanList = false;
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.isLoadPlanList = false;
            throw th;
        }
    }
}
