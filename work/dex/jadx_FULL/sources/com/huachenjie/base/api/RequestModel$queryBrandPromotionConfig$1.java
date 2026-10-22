package com.huachenjie.base.api;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.base.api.RequestModel", f = "RequestModel.kt", i = {}, l = {152}, m = "queryBrandPromotionConfig", n = {}, s = {})
public final class RequestModel$queryBrandPromotionConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$queryBrandPromotionConfig$1(RequestModel requestModel, Continuation<? super RequestModel$queryBrandPromotionConfig$1> continuation) {
        super(continuation);
        this.this$0 = requestModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(this);
    }
}
