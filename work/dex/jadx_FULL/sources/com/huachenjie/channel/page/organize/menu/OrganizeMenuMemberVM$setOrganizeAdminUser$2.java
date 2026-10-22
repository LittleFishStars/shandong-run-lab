package com.huachenjie.channel.page.organize.menu;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelMemberBean;
import com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter;
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
@DebugMetadata(c = "com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberVM$setOrganizeAdminUser$2", f = "OrganizeMenuMemberVM.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nOrganizeMenuMemberVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrganizeMenuMemberVM.kt\ncom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM$setOrganizeAdminUser$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,85:1\n350#2,7:86\n*S KotlinDebug\n*F\n+ 1 OrganizeMenuMemberVM.kt\ncom/huachenjie/channel/page/organize/menu/OrganizeMenuMemberVM$setOrganizeAdminUser$2\n*L\n69#1:86,7\n*E\n"})
public final class OrganizeMenuMemberVM$setOrganizeAdminUser$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChannelMemberBean $bean;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $clubCode;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ OrganizeMenuMemberVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeMenuMemberVM$setOrganizeAdminUser$2(String str, ChannelMemberBean channelMemberBean, String str2, OrganizeMenuMemberVM organizeMenuMemberVM, int i, Continuation<? super OrganizeMenuMemberVM$setOrganizeAdminUser$2> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$bean = channelMemberBean;
        this.$clubCode = str2;
        this.this$0 = organizeMenuMemberVM;
        this.$position = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeMenuMemberVM$setOrganizeAdminUser$2(this.$channelNo, this.$bean, this.$clubCode, this.this$0, this.$position, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<?> data;
        List<?> data2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f33012a;
            String str = this.$channelNo;
            String memberUserCode = this.$bean.getMemberUserCode();
            String str2 = this.$clubCode;
            this.label = 1;
            if (requestModel.E0(str, memberUserCode, str2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        BasePubWorkMenuAdapter<?, ?> value = this.this$0.B().getValue();
        int i2 = -1;
        if (value != null && (data2 = value.getData()) != null) {
            int i3 = 0;
            for (Object obj2 : data2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.huachenjie.channel.bean.ChannelMemberBean");
                if (((ChannelMemberBean) obj2).getChannelMemberType() == 4) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
        }
        BasePubWorkMenuAdapter<?, ?> value2 = this.this$0.B().getValue();
        if (value2 != null && (data = value2.getData()) != null) {
            OrganizeMenuMemberVM organizeMenuMemberVM = this.this$0;
            if (i2 >= 0 && i2 < data.size()) {
                Object obj3 = data.get(i2);
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type com.huachenjie.channel.bean.ChannelMemberBean");
                ((ChannelMemberBean) obj3).setChannelMemberType(3);
                BasePubWorkMenuAdapter<?, ?> value3 = organizeMenuMemberVM.B().getValue();
                if (value3 != null) {
                    value3.notifyItemChanged(i2);
                }
            }
        }
        this.$bean.setChannelMemberType(4);
        this.this$0.K().setValue(this.$bean.getMemberUserCode());
        BasePubWorkMenuAdapter<?, ?> value4 = this.this$0.B().getValue();
        if (value4 != null) {
            value4.notifyItemChanged(this.$position);
        }
        return Unit.INSTANCE;
    }
}
