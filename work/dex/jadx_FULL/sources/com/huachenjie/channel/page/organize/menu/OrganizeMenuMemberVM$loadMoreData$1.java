package com.huachenjie.channel.page.organize.menu;

import android.text.TextUtils;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberVM$loadMoreData$1", f = "OrganizeMenuMemberVM.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nOrganizeMenuMemberVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrganizeMenuMemberVM.kt\ncom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM$loadMoreData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,85:1\n1855#2,2:86\n*S KotlinDebug\n*F\n+ 1 OrganizeMenuMemberVM.kt\ncom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM$loadMoreData$1\n*L\n37#1:86,2\n*E\n"})
public final class OrganizeMenuMemberVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $keyWord;
    int label;
    final /* synthetic */ OrganizeMenuMemberVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeMenuMemberVM$loadMoreData$1(OrganizeMenuMemberVM organizeMenuMemberVM, String str, Continuation<? super OrganizeMenuMemberVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = organizeMenuMemberVM;
        this.$keyWord = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeMenuMemberVM$loadMoreData$1(this.this$0, this.$keyWord, continuation);
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
            String value = this.this$0.J().getValue();
            if (value == null) {
                value = "";
            }
            int pageNum = this.this$0.getPageNum();
            String str = this.$keyWord;
            this.label = 1;
            obj = requestModel.O(pageNum, str, value, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PubWorksMenuPageEntity<?> pubWorksMenuPageEntity = (PubWorksMenuPageEntity) obj;
        if (pubWorksMenuPageEntity == null) {
            return Unit.INSTANCE;
        }
        List<ChannelMemberBean> list = pubWorksMenuPageEntity.getList();
        Intrinsics.checkNotNullExpressionValue(list, "pageEntity.list");
        OrganizeMenuMemberVM organizeMenuMemberVM = this.this$0;
        for (ChannelMemberBean channelMemberBean : list) {
            if (TextUtils.equals(channelMemberBean.getMemberUserCode(), organizeMenuMemberVM.K().getValue()) && channelMemberBean.getChannelMemberType() != 1) {
                channelMemberBean.setChannelMemberType(4);
            }
        }
        this.this$0.C().setValue(Boxing.boxInt(pubWorksMenuPageEntity.getType()));
        this.this$0.E().setValue(pubWorksMenuPageEntity);
        return Unit.INSTANCE;
    }
}
