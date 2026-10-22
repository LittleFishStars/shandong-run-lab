package com.huachenjie.mall.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huachenjie.common.reconfig.net.IResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$updateAddress$2", f = "MallModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$updateAddress$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<Object>>, Object> {
    final /* synthetic */ String $address;
    final /* synthetic */ String $addressNo;
    final /* synthetic */ String $cityCode;
    final /* synthetic */ String $cityName;
    final /* synthetic */ boolean $defaultFlag;
    final /* synthetic */ String $districtCode;
    final /* synthetic */ String $districtName;
    final /* synthetic */ String $provinceCode;
    final /* synthetic */ String $provinceName;
    final /* synthetic */ String $receiverName;
    final /* synthetic */ String $receiverPhone;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$updateAddress$2(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10, Continuation<? super MallModel$updateAddress$2> continuation) {
        super(1, continuation);
        this.$receiverName = str;
        this.$receiverPhone = str2;
        this.$provinceCode = str3;
        this.$provinceName = str4;
        this.$cityCode = str5;
        this.$cityName = str6;
        this.$districtCode = str7;
        this.$districtName = str8;
        this.$address = str9;
        this.$defaultFlag = z;
        this.$addressNo = str10;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$updateAddress$2(this.$receiverName, this.$receiverPhone, this.$provinceCode, this.$provinceName, this.$cityCode, this.$cityName, this.$districtCode, this.$districtName, this.$address, this.$defaultFlag, this.$addressNo, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<Object>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        MallApi mallApiA = MallModel.f34763a.a();
        String str = this.$receiverName;
        String str2 = this.$receiverPhone;
        String str3 = this.$provinceCode;
        String str4 = this.$provinceName;
        String str5 = this.$cityCode;
        String str6 = this.$cityName;
        String str7 = this.$districtCode;
        String str8 = this.$districtName;
        String str9 = this.$address;
        boolean z = this.$defaultFlag;
        String str10 = this.$addressNo;
        this.label = 1;
        Object objH0 = mallApiA.h0(str, str2, str3, str4, str5, str6, str7, str8, str9, z, str10, this);
        return objH0 == coroutine_suspended ? coroutine_suspended : objH0;
    }
}
