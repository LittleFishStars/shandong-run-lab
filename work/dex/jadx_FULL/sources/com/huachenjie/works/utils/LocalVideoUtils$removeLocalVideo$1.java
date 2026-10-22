package com.huachenjie.works.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.works.utils.LocalVideoUtils", f = "LocalVideoUtils.kt", i = {0}, l = {54}, m = "removeLocalVideo", n = {"filterList"}, s = {"L$0"})
public final class LocalVideoUtils$removeLocalVideo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalVideoUtils this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoUtils$removeLocalVideo$1(LocalVideoUtils localVideoUtils, Continuation<? super LocalVideoUtils$removeLocalVideo$1> continuation) {
        super(continuation);
        this.this$0 = localVideoUtils;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
