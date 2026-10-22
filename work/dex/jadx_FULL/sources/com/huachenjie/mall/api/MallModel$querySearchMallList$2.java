package com.huachenjie.mall.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.mall.external.bean.CommodityBean;
import huachenjie.sdk.http.PageEntity;
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
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.api.MallModel$querySearchMallList$2", f = "MallModel.kt", i = {}, l = {779}, m = "invokeSuspend", n = {}, s = {})
public final class MallModel$querySearchMallList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<CommodityBean>>>, Object> {
    final /* synthetic */ String $keyword;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $refreshTime;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallModel$querySearchMallList$2(String str, int i, String str2, Continuation<? super MallModel$querySearchMallList$2> continuation) {
        super(1, continuation);
        this.$keyword = str;
        this.$pageNum = i;
        this.$refreshTime = str2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new MallModel$querySearchMallList$2(this.$keyword, this.$pageNum, this.$refreshTime, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<CommodityBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallApi mallApiA = MallModel.f34763a.a();
            String str = this.$keyword;
            int i2 = this.$pageNum;
            String str2 = this.$refreshTime;
            this.label = 1;
            obj = mallApiA.P(str, i2, str2, 10, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
