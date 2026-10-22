package com.huachenjie.channel.page.manage_channel.admin.add;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.ChannelMemberBean;
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
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminVM$addSubAdmin$1", f = "AddSubAdminVM.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class AddSubAdminVM$addSubAdmin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChannelMemberBean $bean;
    final /* synthetic */ String $channelNo;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ AddSubAdminVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddSubAdminVM$addSubAdmin$1(String str, ChannelMemberBean channelMemberBean, AddSubAdminVM addSubAdminVM, int i, Continuation<? super AddSubAdminVM$addSubAdmin$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$bean = channelMemberBean;
        this.this$0 = addSubAdminVM;
        this.$position = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AddSubAdminVM$addSubAdmin$1(this.$channelNo, this.$bean, this.this$0, this.$position, continuation);
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
            String memberUserCode = this.$bean.getMemberUserCode();
            this.label = 1;
            if (requestModel.c(str, memberUserCode, 1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$bean.setChannelMemberType(2);
        AddSubAdminAdapter value = this.this$0.l().getValue();
        if (value != null) {
            value.notifyItemChanged(this.$position);
        }
        this.this$0.m().setValue(this.$bean);
        return Unit.INSTANCE;
    }
}
