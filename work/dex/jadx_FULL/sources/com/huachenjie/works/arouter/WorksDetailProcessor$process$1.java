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
import com.huachenjie.works.bean.ValidWorks;
import com.huachenjie.works.page.details.WorksDetailsActivity;
import com.igexin.push.g.o;
import com.zj.adlib.pm1;
import com.zj.adlib.yj7;
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
@DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$process$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WorksDetailProcessor$process$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $canLoadMore;
    final /* synthetic */ boolean $fromMine;
    final /* synthetic */ String $worksNo;
    final /* synthetic */ int $worksType;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$process$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/exception/ResultException;", o.f, "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$process$1$1", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$process$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$process$1$2", f = "WorksDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.huachenjie.works.arouter.WorksDetailProcessor$process$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.arouter.WorksDetailProcessor$process$1$3", f = "WorksDetailProcessor.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ boolean $canLoadMore;
        final /* synthetic */ boolean $fromMine;
        final /* synthetic */ String $worksNo;
        final /* synthetic */ int $worksType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Activity activity, boolean z, boolean z2, int i, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$worksNo = str;
            this.$activity = activity;
            this.$fromMine = z;
            this.$canLoadMore = z2;
            this.$worksType = i;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass3(this.$worksNo, this.$activity, this.$fromMine, this.$canLoadMore, this.$worksType, continuation);
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
                String str = this.$worksNo;
                this.label = 1;
                obj = requestModel.X0(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ValidWorks validWorks = (ValidWorks) obj;
            int attachmentType = validWorks != null ? validWorks.getAttachmentType() : 1;
            Intent intent = new Intent(this.$activity, (Class<?>) WorksDetailsActivity.class);
            String str2 = this.$worksNo;
            boolean z = this.$fromMine;
            boolean z2 = this.$canLoadMore;
            int i2 = this.$worksType;
            intent.putExtra(yj7.g.WORKS_ATTACH_TYPE, attachmentType);
            intent.putExtra(yj7.g.WORKS_NO, str2);
            intent.putExtra("fromMine", z);
            intent.putExtra(yj7.g.WORKS_LOAD_MORE, z2);
            intent.putExtra(yj7.g.WORKS_TYPE, i2);
            Activity activity = this.$activity;
            if (activity == null) {
                Application applicationA = Utils.a();
                intent.addFlags(268435456);
                applicationA.startActivity(intent);
            } else {
                activity.startActivity(intent);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksDetailProcessor$process$1(String str, boolean z, boolean z2, int i, Continuation<? super WorksDetailProcessor$process$1> continuation) {
        super(2, continuation);
        this.$worksNo = str;
        this.$fromMine = z;
        this.$canLoadMore = z2;
        this.$worksType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WorksDetailProcessor$process$1 worksDetailProcessor$process$1 = new WorksDetailProcessor$process$1(this.$worksNo, this.$fromMine, this.$canLoadMore, this.$worksType, continuation);
        worksDetailProcessor$process$1.L$0 = obj;
        return worksDetailProcessor$process$1;
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
        CoroutineExtKt.c(pm1Var, false, new AnonymousClass1(null), new AnonymousClass2(dialogM, null), new AnonymousClass3(this.$worksNo, activityM, this.$fromMine, this.$canLoadMore, this.$worksType, null), 1, null);
        return Unit.INSTANCE;
    }
}
