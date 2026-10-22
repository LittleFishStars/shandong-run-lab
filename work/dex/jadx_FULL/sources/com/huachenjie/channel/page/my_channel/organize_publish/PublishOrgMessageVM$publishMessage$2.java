package com.huachenjie.channel.page.my_channel.organize_publish;

import com.huachenjie.base.bean.ImageBean;
import com.huachenjie.base.widget.image_pick.ImagePickBean;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.PublishClubMsgRequestBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageVM$publishMessage$2", f = "PublishOrgMessageVM.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPublishOrgMessageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishOrgMessageVM.kt\ncom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageVM$publishMessage$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1549#2:60\n1620#2,3:61\n*S KotlinDebug\n*F\n+ 1 PublishOrgMessageVM.kt\ncom/huachenjie/channel/page/my_channel/organize_publish/PublishOrgMessageVM$publishMessage$2\n*L\n46#1:60\n46#1:61,3\n*E\n"})
public final class PublishOrgMessageVM$publishMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PublishOrgMessageVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishOrgMessageVM$publishMessage$2(PublishOrgMessageVM publishOrgMessageVM, Continuation<? super PublishOrgMessageVM$publishMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = publishOrgMessageVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishOrgMessageVM$publishMessage$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List listEmptyList;
        String clubCode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String value = this.this$0.l().getValue();
            String str = "";
            if (value == null) {
                value = "";
            }
            String value2 = this.this$0.k().getValue();
            if (value2 == null) {
                value2 = "";
            }
            OrganizeBean value3 = this.this$0.n().getValue();
            if (value3 != null && (clubCode = value3.getClubCode()) != null) {
                str = clubCode;
            }
            List<ImagePickBean> value4 = this.this$0.j().getValue();
            if (value4 != null) {
                List<ImagePickBean> list = value4;
                listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (ImagePickBean imagePickBean : list) {
                    String url = imagePickBean.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "it.url");
                    listEmptyList.add(new ImageBean(url, "", imagePickBean.getWidth(), imagePickBean.getHeight(), 0, 16, null));
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
            }
            PublishClubMsgRequestBean publishClubMsgRequestBean = new PublishClubMsgRequestBean(value, str, value2, listEmptyList);
            RequestModel requestModel = RequestModel.f33012a;
            this.label = 1;
            if (requestModel.D(publishClubMsgRequestBean, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.m().setValue(Boxing.boxInt(0));
        return Unit.INSTANCE;
    }
}
