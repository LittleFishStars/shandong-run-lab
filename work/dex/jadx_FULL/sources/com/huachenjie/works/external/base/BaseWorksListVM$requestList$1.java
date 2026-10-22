package com.huachenjie.works.external.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.works.external.base.BaseWorksListVM", f = "BaseWorksListVM.kt", i = {}, l = {96}, m = "requestList$suspendImpl", n = {}, s = {})
public final class BaseWorksListVM$requestList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseWorksListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWorksListVM$requestList$1(BaseWorksListVM baseWorksListVM, Continuation<? super BaseWorksListVM$requestList$1> continuation) {
        super(continuation);
        this.this$0 = baseWorksListVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return BaseWorksListVM.s(this.this$0, 0, null, null, this);
    }
}
