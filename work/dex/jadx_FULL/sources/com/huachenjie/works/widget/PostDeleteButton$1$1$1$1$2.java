package com.huachenjie.works.widget;

import android.app.Activity;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.works.api.RequestModel;
import com.zj.adlib.pm1;
import com.zj.adlib.tv6;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.widget.PostDeleteButton$1$1$1$1$2", f = "PostDeleteButton.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
public final class PostDeleteButton$1$1$1$1$2 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    int label;
    final /* synthetic */ PostDeleteButton this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDeleteButton$1$1$1$1$2(PostDeleteButton postDeleteButton, Activity activity, Continuation<? super PostDeleteButton$1$1$1$1$2> continuation) {
        super(2, continuation);
        this.this$0 = postDeleteButton;
        this.$activity = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostDeleteButton$1$1$1$1$2(this.this$0, this.$activity, continuation);
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
            String postNo = this.this$0.getPostNo();
            Intrinsics.checkNotNull(postNo);
            this.label = 1;
            if (requestModel.M0(postNo, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        tv6 tv6Var = tv6.f45013a;
        Activity activity = this.$activity;
        Intrinsics.checkNotNullExpressionValue(activity, TTDownloadField.TT_ACTIVITY);
        tv6Var.b(activity);
        this.$activity.finish();
        return Unit.INSTANCE;
    }
}
