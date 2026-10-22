package com.huachenjie.run.page.run_index;

import androidx.p002lifecycle.MutableLiveData;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.run.bean.WaitReceiveMedalBean;
import com.huachenjie.run.model.RunRequestModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.run_index.RunIndexVM$queryMedalWall$1", f = "RunIndexVM.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500}, m = "invokeSuspend", n = {}, s = {})
public final class RunIndexVM$queryMedalWall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RunIndexVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunIndexVM$queryMedalWall$1(RunIndexVM runIndexVM, Continuation<? super RunIndexVM$queryMedalWall$1> continuation) {
        super(2, continuation);
        this.this$0 = runIndexVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunIndexVM$queryMedalWall$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        MutableLiveData<Boolean> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> mutableLiveDataE0 = this.this$0.e0();
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            this.L$0 = mutableLiveDataE0;
            this.label = 1;
            Object objA = runRequestModel.A(this);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = mutableLiveDataE0;
            obj = objA;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        WaitReceiveMedalBean waitReceiveMedalBean = (WaitReceiveMedalBean) obj;
        mutableLiveData.setValue(Boxing.boxBoolean(waitReceiveMedalBean != null && waitReceiveMedalBean.getHasConfiguredActivity()));
        return Unit.INSTANCE;
    }
}
