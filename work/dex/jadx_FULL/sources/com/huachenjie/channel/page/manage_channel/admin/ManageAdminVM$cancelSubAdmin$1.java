package com.huachenjie.channel.page.manage_channel.admin;

import com.huachenjie.channel.api.RequestModel;
import com.zj.adlib.m10;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.admin.ManageAdminVM$cancelSubAdmin$1", f = "ManageAdminVM.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class ManageAdminVM$cancelSubAdmin$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    final /* synthetic */ String $memberUserCode;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ ManageAdminVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageAdminVM$cancelSubAdmin$1(String str, String str2, ManageAdminVM manageAdminVM, int i, Continuation<? super ManageAdminVM$cancelSubAdmin$1> continuation) {
        super(2, continuation);
        this.$channelNo = str;
        this.$memberUserCode = str2;
        this.this$0 = manageAdminVM;
        this.$position = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ManageAdminVM$cancelSubAdmin$1(this.$channelNo, this.$memberUserCode, this.this$0, this.$position, continuation);
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
            String str2 = this.$memberUserCode;
            this.label = 1;
            if (requestModel.c(str, str2, 2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ManageAdminAdapter value = this.this$0.l().getValue();
        if (value != null) {
            int i2 = this.$position;
            ManageAdminVM manageAdminVM = this.this$0;
            if (i2 >= 0 && i2 <= 5) {
                if (CollectionsKt.last(value.getData()) instanceof m10) {
                    value.removeAt(i2);
                } else if (i2 == value.getData().size() - 1) {
                    value.setData(i2, new m10());
                } else {
                    value.removeAt(i2);
                    value.addData(new m10());
                }
                manageAdminVM.p(false);
                manageAdminVM.n().setValue(Boxing.boxBoolean(true));
            }
        }
        return Unit.INSTANCE;
    }
}
