package com.huachenjie.works.external.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.works.external.utils.WorksUtils", f = "WorksUtils.kt", i = {}, l = {33}, m = "queryLatestWorksPic", n = {}, s = {})
public final class WorksUtils$queryLatestWorksPic$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WorksUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorksUtils$queryLatestWorksPic$1(WorksUtils worksUtils, Continuation<? super WorksUtils$queryLatestWorksPic$1> continuation) {
        super(continuation);
        this.this$0 = worksUtils;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
