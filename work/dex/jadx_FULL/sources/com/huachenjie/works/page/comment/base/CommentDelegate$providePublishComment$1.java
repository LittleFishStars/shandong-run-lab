package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.comment.CommentBean;
import com.huachenjie.works.bean.comment.CommentImageBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CommentDelegate$providePublishComment$1 extends FunctionReferenceImpl implements Function5<String, String, List<? extends String>, CommentImageBean, Continuation<? super CommentBean>, Object>, SuspendFunction {
    public CommentDelegate$providePublishComment$1(Object obj) {
        super(5, obj, RequestModel.class, "publishComment", "publishComment(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/huachenjie/works/bean/comment/CommentImageBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull String str2, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentBean> continuation) {
        return ((RequestModel) ((CallableReference) this).receiver).n(str, str2, list, commentImageBean, continuation);
    }
}
