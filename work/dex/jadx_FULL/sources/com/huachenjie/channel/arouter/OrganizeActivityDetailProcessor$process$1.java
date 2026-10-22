package com.huachenjie.channel.arouter;

import android.app.Activity;
import android.app.Dialog;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ClubMessageBean;
import com.huachenjie.channel.page.message_detail.MessageDetailActivity;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.util.DialogUtil;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.arouter.OrganizeActivityDetailProcessor$process$1", f = "OrganizeActivityDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class OrganizeActivityDetailProcessor$process$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    final /* synthetic */ Activity $topActivity;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.channel.arouter.OrganizeActivityDetailProcessor$process$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.arouter.OrganizeActivityDetailProcessor$process$1$1", f = "OrganizeActivityDetailProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            this.$dialog.dismiss();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.arouter.OrganizeActivityDetailProcessor$process$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.channel.arouter.OrganizeActivityDetailProcessor$process$1$2", f = "OrganizeActivityDetailProcessor.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $code;
        final /* synthetic */ Activity $topActivity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Activity activity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$code = str;
            this.$topActivity = activity;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$code, this.$topActivity, continuation);
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
                String str = this.$code;
                this.label = 1;
                obj = requestModel.V(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ClubMessageBean clubMessageBean = (ClubMessageBean) obj;
            if (clubMessageBean != null) {
                Activity activity = this.$topActivity;
                activity.startActivity(MessageDetailActivity.INSTANCE.a(activity, clubMessageBean, false));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeActivityDetailProcessor$process$1(Activity activity, String str, Continuation<? super OrganizeActivityDetailProcessor$process$1> continuation) {
        super(2, continuation);
        this.$topActivity = activity;
        this.$code = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        OrganizeActivityDetailProcessor$process$1 organizeActivityDetailProcessor$process$1 = new OrganizeActivityDetailProcessor$process$1(this.$topActivity, this.$code, continuation);
        organizeActivityDetailProcessor$process$1.L$0 = obj;
        return organizeActivityDetailProcessor$process$1;
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
        Dialog dialogM = DialogUtil.m(this.$topActivity);
        dialogM.show();
        CoroutineExtKt.c(pm1Var, false, null, new AnonymousClass1(dialogM, null), new AnonymousClass2(this.$code, this.$topActivity, null), 3, null);
        return Unit.INSTANCE;
    }
}
