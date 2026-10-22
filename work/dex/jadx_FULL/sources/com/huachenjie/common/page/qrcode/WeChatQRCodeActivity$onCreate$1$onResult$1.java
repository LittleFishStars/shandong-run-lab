package com.huachenjie.common.page.qrcode;

import com.alibaba.android.arouter.utils.TextUtils;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.common.page.qrcode.WeChatQRCodeActivity$onCreate$1$onResult$1", f = "WeChatQRCodeActivity.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class WeChatQRCodeActivity$onCreate$1$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ WeChatQRCodeActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WeChatQRCodeActivity$onCreate$1$onResult$1(WeChatQRCodeActivity weChatQRCodeActivity, String str, Continuation<? super WeChatQRCodeActivity$onCreate$1$onResult$1> continuation) {
        super(2, continuation);
        this.this$0 = weChatQRCodeActivity;
        this.$path = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WeChatQRCodeActivity$onCreate$1$onResult$1(this.this$0, this.$path, continuation);
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
            this.this$0.getMLoadingDialog().show();
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            WeChatQRCodeActivity$onCreate$1$onResult$1$parsedResult$1 weChatQRCodeActivity$onCreate$1$onResult$1$parsedResult$1 = new WeChatQRCodeActivity$onCreate$1$onResult$1$parsedResult$1(this.$path, null);
            this.label = 1;
            obj = v41.h(coroutineDispatcherC, weChatQRCodeActivity$onCreate$1$onResult$1$parsedResult$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            fv5.b("二维码错误，请重试");
            this.this$0.g0();
        } else {
            this.this$0.Z(str);
        }
        this.this$0.getMLoadingDialog().dismiss();
        return Unit.INSTANCE;
    }
}
