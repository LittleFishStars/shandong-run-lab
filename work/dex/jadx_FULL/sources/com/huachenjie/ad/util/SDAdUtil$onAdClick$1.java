package com.huachenjie.ad.util;

import com.huachenjie.ad.api.AdModel;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.zj.adlib.pm1;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.ad.util.SDAdUtil$onAdClick$1", f = "SDAdUtil.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class SDAdUtil$onAdClick$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdPlatformSwitch $config;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SDAdUtil$onAdClick$1(AdPlatformSwitch adPlatformSwitch, Continuation<? super SDAdUtil$onAdClick$1> continuation) {
        super(2, continuation);
        this.$config = adPlatformSwitch;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SDAdUtil$onAdClick$1(this.$config, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AdModel adModelB = SDAdUtil.f32744a.b();
            String advertisementPlanCode = this.$config.getAdvertisementPlanCode();
            if (advertisementPlanCode == null) {
                advertisementPlanCode = "";
            }
            String adName = this.$config.getAdName();
            String str = adName != null ? adName : "";
            this.label = 1;
            if (adModelB.c(advertisementPlanCode, str, 11, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
