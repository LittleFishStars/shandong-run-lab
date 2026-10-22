package com.huachenjie.mall.page.goods_detail;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.external.bean.CommodityBean;
import huachenjie.sdk.http.PageEntity;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/mall/external/bean/CommodityBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.goods_detail.GoodsDetailVM$loadData$1$task2$1", f = "GoodsDetailVM.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class GoodsDetailVM$loadData$1$task2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PageEntity<CommodityBean>>, Object> {
    final /* synthetic */ GoodsDetailBean $detailBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsDetailVM$loadData$1$task2$1(GoodsDetailBean goodsDetailBean, Continuation<? super GoodsDetailVM$loadData$1$task2$1> continuation) {
        super(2, continuation);
        this.$detailBean = goodsDetailBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GoodsDetailVM$loadData$1$task2$1(this.$detailBean, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super PageEntity<CommodityBean>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String shopNo = this.$detailBean.getShopNo();
            this.label = 1;
            obj = mallModel.J(shopNo, 1, 1, "", this);
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
