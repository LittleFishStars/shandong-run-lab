package com.huachenjie.channel.page.manage_channel.admin;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelAdminBean;
import com.huachenjie.channel.bean.ChannelAdminListBean;
import com.zj.adlib.SubAdminTitle;
import com.zj.adlib.m10;
import com.zj.adlib.u10;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.admin.ManageAdminVM$loadData$1", f = "ManageAdminVM.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nManageAdminVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ManageAdminVM.kt\ncom/huachenjie/channel/page/manage_channel/admin/ManageAdminVM$loadData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,101:1\n1549#2:102\n1620#2,3:103\n*S KotlinDebug\n*F\n+ 1 ManageAdminVM.kt\ncom/huachenjie/channel/page/manage_channel/admin/ManageAdminVM$loadData$1\n*L\n29#1:102\n29#1:103,3\n*E\n"})
public final class ManageAdminVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ boolean $isSubAdmin;
    int label;
    final /* synthetic */ ManageAdminVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageAdminVM$loadData$1(String str, ManageAdminVM manageAdminVM, boolean z, Continuation<? super ManageAdminVM$loadData$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.this$0 = manageAdminVM;
        this.$isSubAdmin = z;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageAdminVM$loadData$1(this.$channelNo, this.this$0, this.$isSubAdmin, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelAdminBean admin;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.Q(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ChannelAdminListBean channelAdminListBean = (ChannelAdminListBean) obj;
        if (channelAdminListBean == null || (admin = channelAdminListBean.getAdmin()) == null) {
            return Unit.INSTANCE;
        }
        List<ChannelAdminBean> list = channelAdminListBean.getList();
        List<ChannelAdminBean> list2 = list;
        boolean z = this.$isSubAdmin;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            ((ChannelAdminBean) it.next()).setCanCancel(!z);
            arrayList.add(Unit.INSTANCE);
        }
        ArrayList arrayList2 = new ArrayList();
        boolean z2 = this.$isSubAdmin;
        arrayList2.add(new u10());
        arrayList2.add(admin);
        arrayList2.add(new SubAdminTitle(list.size()));
        arrayList2.addAll(list);
        if (list.size() < 3 && !z2) {
            arrayList2.add(new m10());
        }
        ManageAdminAdapter value = this.this$0.l().getValue();
        if (value != null) {
            value.setList(arrayList2);
        }
        return Unit.INSTANCE;
    }
}
