package com.huachenjie.channel.page.advertise.create;

import android.text.TextUtils;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.channel.bean.CreateAdvertiseRequestBean;
import com.zj.adlib.fv5;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.huachenjie.channel.page.advertise.create.CreateAdvertiseVM$publishAdvertise$2", f = "CreateAdvertiseVM.kt", i = {}, l = {103, 105}, m = "invokeSuspend", n = {}, s = {})
public final class CreateAdvertiseVM$publishAdvertise$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CreateAdvertiseRequestBean $bean;
    final /* synthetic */ String $channelAdCode;
    int label;
    final /* synthetic */ CreateAdvertiseVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateAdvertiseVM$publishAdvertise$2(String str, CreateAdvertiseRequestBean createAdvertiseRequestBean, CreateAdvertiseVM createAdvertiseVM, Continuation<? super CreateAdvertiseVM$publishAdvertise$2> continuation) {
        super(2, continuation);
        this.$channelAdCode = str;
        this.$bean = createAdvertiseRequestBean;
        this.this$0 = createAdvertiseVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CreateAdvertiseVM$publishAdvertise$2(this.$channelAdCode, this.$bean, this.this$0, continuation);
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
            if (TextUtils.isEmpty(this.$channelAdCode)) {
                RequestModel requestModel = RequestModel.f33012a;
                CreateAdvertiseRequestBean createAdvertiseRequestBean = this.$bean;
                this.label = 1;
                if (requestModel.k(createAdvertiseRequestBean, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                RequestModel requestModel2 = RequestModel.f33012a;
                CreateAdvertiseRequestBean createAdvertiseRequestBean2 = this.$bean;
                this.label = 2;
                if (requestModel2.H0(createAdvertiseRequestBean2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.b("创建成功~");
        this.this$0.o().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
