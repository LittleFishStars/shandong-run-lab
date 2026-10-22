package com.huachenjie.works.page.details.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.works.page.details.video.VideoWorkListVM", f = "VideoWorkListVM.kt", i = {0, 0, 0}, l = {104}, m = "dealPageData", n = {"this", "data", "urlList"}, s = {"L$0", "L$1", "L$2"})
public final class VideoWorkListVM$dealPageData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VideoWorkListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoWorkListVM$dealPageData$1(VideoWorkListVM videoWorkListVM, Continuation<? super VideoWorkListVM$dealPageData$1> continuation) {
        super(continuation);
        this.this$0 = videoWorkListVM;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
