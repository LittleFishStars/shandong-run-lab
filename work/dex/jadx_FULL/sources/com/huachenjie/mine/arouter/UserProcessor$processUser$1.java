package com.huachenjie.mine.arouter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.alibaba.android.arouter.facade.Postcard;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.mine.bean.AccountWrittenBean;
import com.huachenjie.mine.page.home.FriendInfoActivity;
import com.zj.adlib.fv5;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.arouter.UserProcessor$processUser$1", f = "UserProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserProcessor$processUser$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ Postcard $postcard;
    final /* synthetic */ String $userCode;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.huachenjie.mine.arouter.UserProcessor$processUser$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.mine.arouter.UserProcessor$processUser$1$1", f = "UserProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    /* JADX INFO: renamed from: com.huachenjie.mine.arouter.UserProcessor$processUser$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.mine.arouter.UserProcessor$processUser$1$2", f = "UserProcessor.kt", i = {}, l = {36}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Postcard $postcard;
        final /* synthetic */ String $userCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Activity activity, Postcard postcard, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$userCode = str;
            this.$activity = activity;
            this.$postcard = postcard;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.$userCode, this.$activity, this.$postcard, continuation);
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
                RequestModel requestModel = RequestModel.f35285a;
                String str = this.$userCode;
                this.label = 1;
                obj = requestModel.d(str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            AccountWrittenBean accountWrittenBean = (AccountWrittenBean) obj;
            if (accountWrittenBean != null ? accountWrittenBean.getBisWrittenOff() : false) {
                fv5.b("用户账号已注销");
                return Unit.INSTANCE;
            }
            Activity activity = this.$activity;
            Intent intent = new Intent(this.$activity, (Class<?>) FriendInfoActivity.class);
            intent.putExtras(this.$postcard.getExtras());
            activity.startActivity(intent);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProcessor$processUser$1(String str, Postcard postcard, Continuation<? super UserProcessor$processUser$1> continuation) {
        super(2, continuation);
        this.$userCode = str;
        this.$postcard = postcard;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        UserProcessor$processUser$1 userProcessor$processUser$1 = new UserProcessor$processUser$1(this.$userCode, this.$postcard, continuation);
        userProcessor$processUser$1.L$0 = obj;
        return userProcessor$processUser$1;
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
        if (activityM == null) {
            return Unit.INSTANCE;
        }
        Dialog dialogM = DialogUtil.m(activityM);
        if (dialogM != null) {
            dialogM.show();
        }
        CoroutineExtKt.c(pm1Var, false, null, new AnonymousClass1(dialogM, null), new AnonymousClass2(this.$userCode, activityM, this.$postcard, null), 3, null);
        return Unit.INSTANCE;
    }
}
