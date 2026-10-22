package com.huachenjie.works.page.comment.base;

import com.alibaba.fastjson.JSONObject;
import com.huachenjie.works.api.RequestModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
public /* synthetic */ class CommentDelegate$provideDeleteComment$3 extends FunctionReferenceImpl implements Function2<String, Continuation<? super JSONObject>, Object>, SuspendFunction {
    public CommentDelegate$provideDeleteComment$3(Object obj) {
        super(2, obj, RequestModel.class, "deleteLiveComment", "deleteLiveComment(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull Continuation<? super JSONObject> continuation) {
        return ((RequestModel) ((CallableReference) this).receiver).j(str, continuation);
    }
}
