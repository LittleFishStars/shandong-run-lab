package com.huachenjie.channel.page.my_channel.organize;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import com.zj.adlib.wt1;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.my_channel.organize.OrganizeVM$queryChannelClubList$1", f = "OrganizeVM.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nOrganizeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrganizeVM.kt\ncom/huachenjie/channel/page/my_channel/organize/OrganizeVM$queryChannelClubList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,81:1\n1855#2:82\n1855#2,2:83\n1856#2:85\n*S KotlinDebug\n*F\n+ 1 OrganizeVM.kt\ncom/huachenjie/channel/page/my_channel/organize/OrganizeVM$queryChannelClubList$1\n*L\n45#1:82\n46#1:83,2\n45#1:85\n*E\n"})
public final class OrganizeVM$queryChannelClubList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ OrganizeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeVM$queryChannelClubList$1(String str, OrganizeVM organizeVM, Continuation<? super OrganizeVM$queryChannelClubList$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = organizeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeVM$queryChannelClubList$1(this.$channelNo, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            int i2 = this.this$0.pageNum;
            this.label = 1;
            obj = requestModel.J(str, i2, this);
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
            OrganizeVM organizeVM = this.this$0;
            List list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "it.list");
            Iterator it = list.iterator();
            while (it.hasNext()) {
                for (OrganizeTeamBean organizeTeamBean : ((OrganizeBean) it.next()).getClubTeamList()) {
                    RecentContact recentContactH = wt1.h().k().h(organizeTeamBean.getTeamId());
                    if (recentContactH != null) {
                        organizeVM.p(organizeTeamBean, recentContactH);
                    }
                    organizeVM.l().put(organizeTeamBean.getTeamId(), organizeTeamBean);
                }
            }
            if (organizeVM.pageNum == 1) {
                OrganizeAdapter value = organizeVM.k().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
            } else {
                OrganizeAdapter value2 = organizeVM.k().getValue();
                if (value2 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "it.list");
                    value2.addData((Collection<? extends BaseNode>) list2);
                }
            }
            if (pageEntity.getHasNext()) {
                OrganizeAdapter value3 = organizeVM.k().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                OrganizeAdapter value4 = organizeVM.k().getValue();
                if (value4 != null && (loadMoreModule = value4.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            organizeVM.pageNum++;
        }
        return Unit.INSTANCE;
    }
}
