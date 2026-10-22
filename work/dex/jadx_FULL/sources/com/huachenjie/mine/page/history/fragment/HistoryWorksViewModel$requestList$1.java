package com.huachenjie.mine.page.history.fragment;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.mine.page.history.fragment.HistoryWorksViewModel", f = "HistoryWorksViewModel.kt", i = {}, l = {22}, m = "requestList", n = {}, s = {})
public final class HistoryWorksViewModel$requestList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HistoryWorksViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryWorksViewModel$requestList$1(HistoryWorksViewModel historyWorksViewModel, Continuation<? super HistoryWorksViewModel$requestList$1> continuation) {
        super(continuation);
        this.this$0 = historyWorksViewModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(0, null, null, this);
    }
}
