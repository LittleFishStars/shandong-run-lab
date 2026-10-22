package com.huachenjie.channel.page.home;

import com.huachenjie.channel.bean.FlashMessageBuddyChatBean;
import com.huachenjie.channel.bean.notify.BuddyChatRoomBean;
import com.zj.adlib.v41;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.home.FlashMessageVM$requestList$1", f = "FlashMessageVM.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nFlashMessageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlashMessageVM.kt\ncom/huachenjie/channel/page/home/FlashMessageVM$requestList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,225:1\n1549#2:226\n1620#2,3:227\n*S KotlinDebug\n*F\n+ 1 FlashMessageVM.kt\ncom/huachenjie/channel/page/home/FlashMessageVM$requestList$1\n*L\n53#1:226\n53#1:227,3\n*E\n"})
public final class FlashMessageVM$requestList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FlashMessageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashMessageVM$requestList$1(FlashMessageVM flashMessageVM, Continuation<? super FlashMessageVM$requestList$1> continuation) {
        super(2, continuation);
        this.this$0 = flashMessageVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlashMessageVM$requestList$1 flashMessageVM$requestList$1 = new FlashMessageVM$requestList$1(this.this$0, continuation);
        flashMessageVM$requestList$1.L$0 = obj;
        return flashMessageVM$requestList$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred deferredB = v41.b((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new FlashMessageVM$requestList$1$buddyChatRoomList$1(null), 3, (Object) null);
            this.label = 1;
            obj = deferredB.H(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List list = (List) obj;
        FlashMessageVM flashMessageVM = this.this$0;
        if (list != null) {
            List<BuddyChatRoomBean> list2 = list;
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (BuddyChatRoomBean buddyChatRoomBean : list2) {
                listEmptyList.add(new FlashMessageBuddyChatBean(buddyChatRoomBean.getCreatorAvatar(), true, buddyChatRoomBean.getTitle(), buddyChatRoomBean.getDescription(), buddyChatRoomBean.getBuddyCode(), buddyChatRoomBean.getRoomId()));
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        flashMessageVM.buddyChatList = listEmptyList;
        this.this$0.r();
        return Unit.INSTANCE;
    }
}
