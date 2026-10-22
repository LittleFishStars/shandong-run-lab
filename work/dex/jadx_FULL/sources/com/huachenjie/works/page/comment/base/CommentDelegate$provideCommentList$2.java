package com.huachenjie.works.page.comment.base;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.comment.CommentBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CommentDelegate$provideCommentList$2 extends FunctionReferenceImpl implements Function4<Integer, String, String, Continuation<? super PageEntity<CommentBean>>, Object>, SuspendFunction {
    public CommentDelegate$provideCommentList$2(Object obj) {
        super(4, obj, RequestModel.class, "queryCommentQuotePageList", "queryCommentQuotePageList(ILjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(int i, @Nullable String str, @NotNull String str2, @NotNull Continuation<? super PageEntity<CommentBean>> continuation) {
        return ((RequestModel) ((CallableReference) this).receiver).M(i, str, str2, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(((Number) obj).intValue(), (String) obj2, (String) obj3, (Continuation<? super PageEntity<CommentBean>>) obj4);
    }
}
