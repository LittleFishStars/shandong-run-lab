package com.huachenjie.works.page.alumni.recommend;

import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.works.page.alumni.recommend.RecommendWorksVM", f = "RecommendWorksVM.kt", i = {0}, l = {23}, m = "requestList", n = {BroadcastFloorDetailDialog.DETAIL_BEAN_KEY}, s = {"L$0"})
public final class RecommendWorksVM$requestList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RecommendWorksVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecommendWorksVM$requestList$1(RecommendWorksVM recommendWorksVM, Continuation<? super RecommendWorksVM$requestList$1> continuation) {
        super(continuation);
        this.this$0 = recommendWorksVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(0, null, null, this);
    }
}
