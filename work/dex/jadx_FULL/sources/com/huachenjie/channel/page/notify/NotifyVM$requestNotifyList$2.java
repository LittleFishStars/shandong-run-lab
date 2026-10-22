package com.huachenjie.channel.page.notify;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.NotifyBean;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.notify.NotifyVM$requestNotifyList$2", f = "NotifyVM.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nNotifyVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NotifyVM.kt\ncom/huachenjie/channel/page/notify/NotifyVM$requestNotifyList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,56:1\n1855#2,2:57\n*S KotlinDebug\n*F\n+ 1 NotifyVM.kt\ncom/huachenjie/channel/page/notify/NotifyVM$requestNotifyList$2\n*L\n39#1:57,2\n*E\n"})
public final class NotifyVM$requestNotifyList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotifyVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotifyVM$requestNotifyList$2(NotifyVM notifyVM, Continuation<? super NotifyVM$requestNotifyList$2> continuation) {
        super(2, continuation);
        this.this$0 = notifyVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotifyVM$requestNotifyList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<NotifyBean> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            this.label = 1;
            obj = requestModel.A0(this);
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
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            NotifyVM notifyVM = this.this$0;
            for (NotifyBean notifyBean : list) {
                NotifyBean notifyBean2 = (NotifyBean) notifyVM.itemList.get(Boxing.boxInt(notifyBean.getMessageType()));
                if (notifyBean2 != null) {
                    notifyBean2.setContent(notifyBean.getContent());
                    notifyBean2.setRedDot(notifyBean.getRedDot());
                }
            }
        }
        this.this$0.n();
        return Unit.INSTANCE;
    }
}
