package com.huachenjie.run.page.activities_run;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.ReadyVM", f = "ReadyVM.kt", i = {0}, l = {88}, m = "nearbyRunStdInternal", n = {"this"}, s = {"L$0"})
public final class ReadyVM$nearbyRunStdInternal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReadyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadyVM$nearbyRunStdInternal$1(ReadyVM readyVM, Continuation<? super ReadyVM$nearbyRunStdInternal$1> continuation) {
        super(continuation);
        this.this$0 = readyVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.K(this);
    }
}
