package com.huachenjie.run.model;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.run.model.RunRequestModel", f = "RunRequestModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE}, m = "querySchoolFences", n = {}, s = {})
public final class RunRequestModel$querySchoolFences$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RunRequestModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRequestModel$querySchoolFences$1(RunRequestModel runRequestModel, Continuation<? super RunRequestModel$querySchoolFences$1> continuation) {
        super(continuation);
        this.this$0 = runRequestModel;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w(null, this);
    }
}
