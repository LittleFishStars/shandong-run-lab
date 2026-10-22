package com.huachenjie.works.page.comment.base;

import android.content.Context;
import android.text.TextUtils;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.comment.base.CommentUtil$publishComment$2", f = "CommentUtil.kt", i = {}, l = {127, 137}, m = "invokeSuspend", n = {}, s = {})
public final class CommentUtil$publishComment$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CommentBean $commentBean;
    final /* synthetic */ int $commentType;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $onFail;
    final /* synthetic */ Function1<CommentBean, Unit> $onSuccess;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CommentUtil$publishComment$2(CommentBean commentBean, Function0<Unit> function0, int i, Context context, Function1<? super CommentBean, Unit> function1, Continuation<? super CommentUtil$publishComment$2> continuation) {
        super(2, continuation);
        this.$commentBean = commentBean;
        this.$onFail = function0;
        this.$commentType = i;
        this.$context = context;
        this.$onSuccess = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommentUtil$publishComment$2(this.$commentBean, this.$onFail, this.$commentType, this.$context, this.$onSuccess, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Function5 function5E;
        CommentBean commentBean;
        Function0<Unit> function0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            commentBean = (CommentBean) obj;
            if (commentBean != null) {
                Function1<CommentBean, Unit> function1 = this.$onSuccess;
                commentBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentBean.getContent(), 0, 2, null));
                function1.invoke(commentBean);
            } else {
                function0 = this.$onFail;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        if (this.$commentBean.getImage() == null || StringsKt.startsWith$default(this.$commentBean.getImage().getPath(), "http", false, 2, (Object) null)) {
            function5E = CommentDelegate.f37252a.e(this.$commentType);
            if (function5E != null) {
                String content = this.$commentBean.getContent();
                String bizNo = this.$commentBean.getBizNo();
                List<String> atUserList = this.$commentBean.getAtUserList();
                CommentImageBean image = this.$commentBean.getImage();
                this.label = 2;
                obj = function5E.invoke(content, bizNo, atUserList, image, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                commentBean = (CommentBean) obj;
            } else {
                commentBean = null;
            }
        } else {
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            CommentUtil$publishComment$2$path$1 commentUtil$publishComment$2$path$1 = new CommentUtil$publishComment$2$path$1(this.$context, this.$commentBean, this.$commentType, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC, commentUtil$publishComment$2$path$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (commentBean != null) {
            Function1<CommentBean, Unit> function2 = this.$onSuccess;
            commentBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentBean.getContent(), 0, 2, null));
            function2.invoke(commentBean);
        } else {
            function0 = this.$onFail;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            Function0<Unit> function3 = this.$onFail;
            if (function3 != null) {
                function3.invoke();
            }
            return Unit.INSTANCE;
        }
        CommentImageBean image2 = this.$commentBean.getImage();
        Intrinsics.checkNotNull(str);
        image2.setPath(str);
        function5E = CommentDelegate.f37252a.e(this.$commentType);
        if (function5E != null) {
            String content2 = this.$commentBean.getContent();
            String bizNo2 = this.$commentBean.getBizNo();
            List<String> atUserList2 = this.$commentBean.getAtUserList();
            CommentImageBean image3 = this.$commentBean.getImage();
            this.label = 2;
            obj = function5E.invoke(content2, bizNo2, atUserList2, image3, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            commentBean = (CommentBean) obj;
        } else {
            commentBean = null;
        }
        if (commentBean != null) {
            Function1<CommentBean, Unit> function4 = this.$onSuccess;
            commentBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, commentBean.getContent(), 0, 2, null));
            function4.invoke(commentBean);
        } else {
            function0 = this.$onFail;
            if (function0 != null) {
                function0.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}
