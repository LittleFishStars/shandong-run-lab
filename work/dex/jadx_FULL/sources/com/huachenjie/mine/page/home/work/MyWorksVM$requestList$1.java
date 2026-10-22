package com.huachenjie.mine.page.home.work;

import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.mine.page.home.work.MyWorksVM", f = "MyWorksVM.kt", i = {0, 1, 2}, l = {109, 115, 121}, m = "requestList", n = {BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY}, s = {"L$0", "L$0", "L$0"})
public final class MyWorksVM$requestList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MyWorksVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyWorksVM$requestList$1(MyWorksVM myWorksVM, Continuation<? super MyWorksVM$requestList$1> continuation) {
        super(continuation);
        this.this$0 = myWorksVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(0, null, null, this);
    }
}
