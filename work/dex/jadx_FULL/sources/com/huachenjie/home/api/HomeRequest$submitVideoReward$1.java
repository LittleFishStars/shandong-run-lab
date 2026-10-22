package com.huachenjie.home.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.huachenjie.home.api.HomeRequest", f = "HomeRequest.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD}, m = "submitVideoReward", n = {}, s = {})
public final class HomeRequest$submitVideoReward$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRequest$submitVideoReward$1(HomeRequest homeRequest, Continuation<? super HomeRequest$submitVideoReward$1> continuation) {
        super(continuation);
        this.this$0 = homeRequest;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.D(this);
    }
}
