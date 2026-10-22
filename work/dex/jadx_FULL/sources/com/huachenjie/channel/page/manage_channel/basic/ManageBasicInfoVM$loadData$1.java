package com.huachenjie.channel.page.manage_channel.basic;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelBasicInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.basic.ManageBasicInfoVM$loadData$1", f = "ManageBasicInfoVM.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
public final class ManageBasicInfoVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ ManageBasicInfoVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageBasicInfoVM$loadData$1(String str, ManageBasicInfoVM manageBasicInfoVM, Continuation<? super ManageBasicInfoVM$loadData$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = manageBasicInfoVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageBasicInfoVM$loadData$1(this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.N(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ChannelBasicInfo channelBasicInfo = (ChannelBasicInfo) obj;
        if (channelBasicInfo != null) {
            ManageBasicInfoVM manageBasicInfoVM = this.this$0;
            manageBasicInfoVM.i().setValue(channelBasicInfo);
            manageBasicInfoVM.j().setValue(channelBasicInfo.getChannelName());
        }
        return Unit.INSTANCE;
    }
}
