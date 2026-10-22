package com.huachenjie.base.util;

import android.app.Activity;
import android.app.Dialog;
import com.huachenjie.base.api.RequestModel;
import com.huachenjie.common.bean.CustomerServerStatusData;
import com.huachenjie.common.util.DialogUtil;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.base.util.CustomerServiceUtil$consultOfficial$1", f = "CustomerServiceUtil.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"loading"}, s = {"L$0"})
public final class CustomerServiceUtil$consultOfficial$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerServiceUtil$consultOfficial$1(Activity activity, Continuation<? super CustomerServiceUtil$consultOfficial$1> continuation) {
        super(2, continuation);
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CustomerServiceUtil$consultOfficial$1(this.$activity, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0076  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
        Dialog dialog;
        Throwable th;
        CustomerServiceUtil customerServiceUtil;
        Activity activity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Dialog dialogP = DialogUtil.p(this.$activity, false);
            dialogP.show();
            try {
                customerServiceUtil = CustomerServiceUtil.f32958a;
                Activity activity2 = this.$activity;
                RequestModel requestModel = RequestModel.f32789a;
                this.L$0 = dialogP;
                this.L$1 = customerServiceUtil;
                this.L$2 = activity2;
                this.label = 1;
                Object objH = requestModel.h(this);
                if (objH == coroutine_suspended) {
                    return coroutine_suspended;
                }
                activity = activity2;
                dialog = dialogP;
                obj = objH;
            } catch (Exception unused) {
                dialog = dialogP;
                CustomerServiceUtil.f32958a.j(this.$activity);
                if (dialog.isShowing()) {
                }
                return Unit.INSTANCE;
            } catch (Throwable th2) {
                dialog = dialogP;
                th = th2;
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                throw th;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            activity = (Activity) this.L$2;
            customerServiceUtil = (CustomerServiceUtil) this.L$1;
            dialog = (Dialog) this.L$0;
            try {
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused2) {
                    CustomerServiceUtil.f32958a.j(this.$activity);
                    if (dialog.isShowing()) {
                    }
                    return Unit.INSTANCE;
                }
            } catch (Throwable th3) {
                th = th3;
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                throw th;
            }
        }
        customerServiceUtil.e(activity, (CustomerServerStatusData) obj);
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
        return Unit.INSTANCE;
    }
}
