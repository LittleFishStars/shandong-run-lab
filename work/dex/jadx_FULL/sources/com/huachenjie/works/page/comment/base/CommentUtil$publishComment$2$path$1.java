package com.huachenjie.works.page.comment.base;

import android.content.Context;
import com.huachenjie.works.bean.comment.CommentBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$publishComment$2$path$1", f = "CommentUtil.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class CommentUtil$publishComment$2$path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ CommentBean $commentBean;
    final /* synthetic */ int $commentType;
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentUtil$publishComment$2$path$1(Context context, CommentBean commentBean, int i, Continuation<? super CommentUtil$publishComment$2$path$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$commentBean = commentBean;
        this.$commentType = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$publishComment$2$path$1(this.$context, this.$commentBean, this.$commentType, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws InterruptedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CommentUtil commentUtil = CommentUtil.f37253a;
            Context context = this.$context;
            String path = this.$commentBean.getImage().getPath();
            int i2 = this.$commentType;
            this.label = 1;
            obj = commentUtil.i(context, path, i2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
