package com.huachenjie.channel.arouter;

import android.app.Activity;
import android.app.Dialog;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.zj.adlib.pm1;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.arouter.TopicMainProcessor$process$1", f = "TopicMainProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TopicMainProcessor$process$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectNo;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.channel.arouter.TopicMainProcessor$process$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.arouter.TopicMainProcessor$process$1$1", f = "TopicMainProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.huachenjie.channel.arouter.TopicMainProcessor$process$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.arouter.TopicMainProcessor$process$1$2", f = "TopicMainProcessor.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $subjectNo;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$subjectNo = str;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$subjectNo, continuation);
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
                RequestModel requestModel = RequestModel.f33012a;
                String str = this.$subjectNo;
                this.label = 1;
                if (requestModel.h(str, 2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ARouter.getInstance().build(zj7.b.TOPIC_MAIN).withString(yj7.b.SUBJECT_NO, this.$subjectNo).greenChannel().navigation();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopicMainProcessor$process$1(String str, Continuation<? super TopicMainProcessor$process$1> continuation) {
        super(2, continuation);
        this.$subjectNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TopicMainProcessor$process$1 topicMainProcessor$process$1 = new TopicMainProcessor$process$1(this.$subjectNo, continuation);
        topicMainProcessor$process$1.L$0 = obj;
        return topicMainProcessor$process$1;
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
        Dialog dialogM = activityM != null ? DialogUtil.m(activityM) : null;
        if (dialogM != null) {
            dialogM.show();
        }
        CoroutineExtKt.c(pm1Var, false, null, new AnonymousClass1(dialogM, null), new AnonymousClass2(this.$subjectNo, null), 3, null);
        return Unit.INSTANCE;
    }
}
