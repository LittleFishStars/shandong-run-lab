package com.huachenjie.channel.page.home;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.notify.BuddyChatRoomBean;
import com.zj.adlib.dq1;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0010\u0005\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/huachenjie/channel/bean/notify/BuddyChatRoomBean;", "kotlin.jvm.PlatformType", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.home.FlashMessageVM$requestList$1$buddyChatRoomList$1", f = "FlashMessageVM.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class FlashMessageVM$requestList$1$buddyChatRoomList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<BuddyChatRoomBean>>, Object> {
    int label;

    public FlashMessageVM$requestList$1$buddyChatRoomList$1(Continuation<? super FlashMessageVM$requestList$1$buddyChatRoomList$1> continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FlashMessageVM$requestList$1$buddyChatRoomList$1(continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super List<BuddyChatRoomBean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!dq1.e().getBuddyEnable()) {
                return null;
            }
            RequestModel requestModel = RequestModel.f33012a;
            this.label = 1;
            obj = requestModel.r0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity != null) {
            return pageEntity.getList();
        }
        return null;
    }
}
