package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.comment.CommentImageBean;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CommentDelegate$providePublishCommentReply$3 extends FunctionReferenceImpl implements Function6<String, String, String, List<? extends String>, CommentImageBean, Continuation<? super CommentReplyBean>, Object>, SuspendFunction {
    public CommentDelegate$providePublishCommentReply$3(Object obj) {
        super(6, obj, RequestModel.class, "publishLiveCommentReply", "publishLiveCommentReply(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/huachenjie/works/bean/comment/CommentImageBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable List<String> list, @Nullable CommentImageBean commentImageBean, @NotNull Continuation<? super CommentReplyBean> continuation) {
        return ((RequestModel) ((CallableReference) this).receiver).q(str, str2, str3, list, commentImageBean, continuation);
    }
}
