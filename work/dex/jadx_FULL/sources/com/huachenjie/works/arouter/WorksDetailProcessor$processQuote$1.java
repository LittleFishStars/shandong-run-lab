package com.huachenjie.works.arouter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.BroadcastFloorMessageBean;
import com.huachenjie.works.page.broadcast_floor.BroadcastFloorActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.pm1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processQuote$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WorksDetailProcessor$processQuote$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $quoteNo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$processQuote$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processQuote$1$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Dialog dialog, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$dialog = dialog;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$dialog, continuation);
        }

        @Nullable
        public final Object invoke(@Nullable Continuation<? super Unit> continuation) {
            return create(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Dialog dialog = this.$dialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$processQuote$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processQuote$1$2", f = "WorksDetailProcessor.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $quoteNo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Activity activity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$quoteNo = str;
            this.$activity = activity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$quoteNo, this.$activity, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
            return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                RequestModel requestModel = RequestModel.f36762a;
                String str = this.$quoteNo;
                this.label = 1;
                obj = requestModel.q0(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            BroadcastFloorMessageBean broadcastFloorMessageBean = (BroadcastFloorMessageBean) obj;
            if (broadcastFloorMessageBean != null) {
                Activity activity = this.$activity;
                Intent intent = new Intent(activity, (Class<?>) BroadcastFloorActivity.class);
                intent.putExtra(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, broadcastFloorMessageBean);
                activity.startActivity(intent);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailProcessor$processQuote$1(String str, Continuation<? super WorksDetailProcessor$processQuote$1> continuation) {
        super(2, continuation);
        this.$quoteNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WorksDetailProcessor$processQuote$1 worksDetailProcessor$processQuote$1 = new WorksDetailProcessor$processQuote$1(this.$quoteNo, continuation);
        worksDetailProcessor$processQuote$1.L$0 = obj;
        return worksDetailProcessor$processQuote$1;
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        pm1 pm1Var = (pm1) this.L$0;
        Activity activityM = ActivityLifecycleManager.l().m();
        Dialog dialogM = activityM == null ? null : DialogUtil.m(activityM);
        if (dialogM != null) {
            dialogM.show();
        }
        CoroutineExtKt.c(pm1Var, false, null, new AnonymousClass1(dialogM, null), new AnonymousClass2(this.$quoteNo, activityM, null), 3, null);
        return Unit.INSTANCE;
    }
}
