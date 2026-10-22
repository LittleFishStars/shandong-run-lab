package com.huachenjie.works.arouter;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.widget.Toast;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.page.campus_wall.detail.PostDetailActivity;
import com.igexin.push.g.o;
import com.zj.adlib.pm1;
import com.zj.adlib.zj7;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WorksDetailProcessor$processPost$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $fromMine;
    final /* synthetic */ String $postNo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException;", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ResultException, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Nullable
        public final Object invoke(@NotNull ResultException resultException, @Nullable Continuation<? super Boolean> continuation) {
            return create(resultException, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ResultException resultException = (ResultException) this.L$0;
            if (a.D().size() == 0) {
                ARouter.getInstance().build(zj7.a.HOME).navigation();
                z = true;
                Toast.makeText(Utils.a(), resultException.getMessage(), 1).show();
            } else {
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$2", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Dialog $dialog;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Dialog dialog, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$dialog = dialog;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$dialog, continuation);
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

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$processPost$1$3", f = "WorksDetailProcessor.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ boolean $fromMine;
        final /* synthetic */ String $postNo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Activity activity, boolean z, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$postNo = str;
            this.$activity = activity;
            this.$fromMine = z;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass3(this.$postNo, this.$activity, this.$fromMine, continuation);
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
                String str = this.$postNo;
                this.label = 1;
                obj = requestModel.V0(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (obj != null) {
                Activity activity = this.$activity;
                String str2 = this.$postNo;
                boolean z = this.$fromMine;
                Intent intent = new Intent(activity, (Class<?>) PostDetailActivity.class);
                intent.putExtra("postNo", str2);
                intent.putExtra("fromMine", z);
                if (activity == null) {
                    Application applicationA = Utils.a();
                    intent.addFlags(268435456);
                    applicationA.startActivity(intent);
                } else {
                    activity.startActivity(intent);
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailProcessor$processPost$1(String str, boolean z, Continuation<? super WorksDetailProcessor$processPost$1> continuation) {
        super(2, continuation);
        this.$postNo = str;
        this.$fromMine = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WorksDetailProcessor$processPost$1 worksDetailProcessor$processPost$1 = new WorksDetailProcessor$processPost$1(this.$postNo, this.$fromMine, continuation);
        worksDetailProcessor$processPost$1.L$0 = obj;
        return worksDetailProcessor$processPost$1;
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
        CoroutineExtKt.c(pm1Var, false, new AnonymousClass1(null), new AnonymousClass2(dialogM, null), new AnonymousClass3(this.$postNo, activityM, this.$fromMine, null), 1, null);
        return Unit.INSTANCE;
    }
}
