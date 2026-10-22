package com.huachenjie.channel.page.channel_home;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelHomeItemBean;
import com.zj.adlib.wt1;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
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
@DebugMetadata(c = "com.huachenjie.channel.page.channel_home.ChannelHomeVM$queryPageList$2", f = "ChannelHomeVM.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nChannelHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ChannelHomeVM.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeVM$queryPageList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,160:1\n1855#2:161\n1855#2,2:162\n1856#2:164\n*S KotlinDebug\n*F\n+ 1 ChannelHomeVM.kt\ncom/huachenjie/channel/page/channel_home/ChannelHomeVM$queryPageList$2\n*L\n103#1:161\n106#1:162,2\n103#1:164\n*E\n"})
public final class ChannelHomeVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChannelHomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelHomeVM$queryPageList$2(ChannelHomeVM channelHomeVM, Continuation<? super ChannelHomeVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = channelHomeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChannelHomeVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        List<ChannelHomeItemBean> list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            int pageNum = this.this$0.getPageNum();
            this.label = 1;
            obj = requestModel.y0(pageNum, this);
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
        this.this$0.y().setValue(Boxing.boxBoolean(false));
        if (pageEntity != null && (list2 = pageEntity.getList()) != null) {
            ChannelHomeVM channelHomeVM = this.this$0;
            for (ChannelHomeItemBean channelHomeItemBean : list2) {
                channelHomeItemBean.setUnreadCount(wt1.h().k().k(channelHomeItemBean.formatTeamIdList()));
                Iterator<T> it = channelHomeItemBean.formatTeamIdList().iterator();
                while (it.hasNext()) {
                    channelHomeVM.q().put((String) it.next(), channelHomeItemBean.getChannelNo());
                }
            }
        }
        if (this.this$0.getPageNum() == 1) {
            this.this$0.o(pageEntity != null ? pageEntity.getList() : null);
        } else if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
            this.this$0.u().setValue(pageEntity.getList());
        } else {
            ChannelHomeVM channelHomeVM2 = this.this$0;
            channelHomeVM2.C(channelHomeVM2.getPageNum() - 1);
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            ChannelHomeAdapter value = this.this$0.p().getValue();
            if (value != null && (loadMoreModule2 = value.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            ChannelHomeAdapter value2 = this.this$0.p().getValue();
            if (value2 != null && (loadMoreModule = value2.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
