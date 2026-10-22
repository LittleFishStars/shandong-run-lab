package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.comment.CommentReplyBean;
import huachenjie.sdk.http.PageEntity;
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
public /* synthetic */ class CommentDelegate$provideCommentReplyList$1 extends FunctionReferenceImpl implements Function5<Integer, String, String, String, Continuation<? super PageEntity<CommentReplyBean>>, Object>, SuspendFunction {
    public CommentDelegate$provideCommentReplyList$1(Object obj) {
        super(5, obj, RequestModel.class, "queryCommentSubPageList", "queryCommentSubPageList(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(int i, @Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super PageEntity<CommentReplyBean>> continuation) {
        return ((RequestModel) ((CallableReference) this).receiver).Q(i, str, str2, str3, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke(((Number) obj).intValue(), (String) obj2, (String) obj3, (String) obj4, (Continuation<? super PageEntity<CommentReplyBean>>) obj5);
    }
}
