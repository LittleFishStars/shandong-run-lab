package com.huachenjie.mall.page.goods_detail;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.MerchantsBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailBean;
import com.huachenjie.mall.bean.goods_detail.GoodsDetailShop;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.goods_detail.GoodsDetailVM$loadData$1", f = "GoodsDetailVM.kt", i = {0, 1, 2, 3, 3, 4, 4}, l = {73, 75, 76, 95, 96}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "detailBean", "task2", "detailBean", "des"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1"})
public final class GoodsDetailVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $goodsNo;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GoodsDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodsDetailVM$loadData$1(GoodsDetailVM goodsDetailVM, String str, Continuation<? super GoodsDetailVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = goodsDetailVM;
        this.$goodsNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GoodsDetailVM$loadData$1 goodsDetailVM$loadData$1 = new GoodsDetailVM$loadData$1(this.this$0, this.$goodsNo, continuation);
        goodsDetailVM$loadData$1.L$0 = obj;
        return goodsDetailVM$loadData$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:41:0x010b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0110  */
    /* JADX WARN: Code duplicated, block: B:46:0x0113  */
    /* JADX WARN: Code duplicated, block: B:48:0x011f A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x0120  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object objC;
        Object objE;
        Object objB0;
        GoodsDetailBean goodsDetailBean;
        Deferred deferredB;
        Object objH;
        MerchantsBean merchantsBean;
        Object objH2;
        MerchantsBean merchantsBean2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            if (Intrinsics.areEqual(this.this$0.x().getValue(), Boxing.boxBoolean(true))) {
                MallModel mallModel = MallModel.f34763a;
                String str = this.$goodsNo;
                Integer value = this.this$0.D().getValue();
                Intrinsics.checkNotNull(value);
                int iIntValue = value.intValue();
                String cooperationNo = this.this$0.getCooperationNo();
                this.L$0 = coroutineScope;
                this.label = 1;
                objB0 = mallModel.b0(str, iIntValue, cooperationNo, this);
                if (objB0 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                goodsDetailBean = (GoodsDetailBean) objB0;
                if (goodsDetailBean == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.u().setValue(goodsDetailBean);
                if (goodsDetailBean.getGoodsStatus() != 1) {
                    return Unit.INSTANCE;
                }
                CoroutineScope coroutineScope2 = coroutineScope;
                Deferred deferredB2 = v41.b(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
                deferredB = v41.b(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
                this.L$0 = goodsDetailBean;
                this.L$1 = deferredB;
                this.label = 4;
                objH = deferredB2.H(this);
                if (objH == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean = (MerchantsBean) objH;
                if (merchantsBean == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = goodsDetailBean;
                this.L$1 = merchantsBean;
                this.label = 5;
                objH2 = deferredB.H(this);
                if (objH2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean2 = merchantsBean;
            } else if (this.this$0.getFromReward()) {
                MallModel mallModel2 = MallModel.f34763a;
                String str2 = this.$goodsNo;
                this.L$0 = coroutineScope;
                this.label = 2;
                objE = mallModel2.E(str2, this);
                if (objE == coroutine_suspended) {
                    return coroutine_suspended;
                }
                goodsDetailBean = (GoodsDetailBean) objE;
                if (goodsDetailBean == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.u().setValue(goodsDetailBean);
                if (goodsDetailBean.getGoodsStatus() != 1) {
                    return Unit.INSTANCE;
                }
                CoroutineScope coroutineScope3 = coroutineScope;
                Deferred deferredB3 = v41.b(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
                deferredB = v41.b(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
                this.L$0 = goodsDetailBean;
                this.L$1 = deferredB;
                this.label = 4;
                objH = deferredB3.H(this);
                if (objH == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean = (MerchantsBean) objH;
                if (merchantsBean == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = goodsDetailBean;
                this.L$1 = merchantsBean;
                this.label = 5;
                objH2 = deferredB.H(this);
                if (objH2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean2 = merchantsBean;
            } else {
                MallModel mallModel3 = MallModel.f34763a;
                String str3 = this.$goodsNo;
                this.L$0 = coroutineScope;
                this.label = 3;
                objC = mallModel3.C(str3, this);
                if (objC == coroutine_suspended) {
                    return coroutine_suspended;
                }
                goodsDetailBean = (GoodsDetailBean) objC;
                if (goodsDetailBean == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.u().setValue(goodsDetailBean);
                if (goodsDetailBean.getGoodsStatus() != 1) {
                    return Unit.INSTANCE;
                }
                CoroutineScope coroutineScope4 = coroutineScope;
                Deferred deferredB4 = v41.b(coroutineScope4, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
                deferredB = v41.b(coroutineScope4, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
                this.L$0 = goodsDetailBean;
                this.L$1 = deferredB;
                this.label = 4;
                objH = deferredB4.H(this);
                if (objH == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean = (MerchantsBean) objH;
                if (merchantsBean == null) {
                    return Unit.INSTANCE;
                }
                this.L$0 = goodsDetailBean;
                this.L$1 = merchantsBean;
                this.label = 5;
                objH2 = deferredB.H(this);
                if (objH2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                merchantsBean2 = merchantsBean;
            }
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objB0 = obj;
            goodsDetailBean = (GoodsDetailBean) objB0;
            if (goodsDetailBean == null) {
                return Unit.INSTANCE;
            }
            this.this$0.u().setValue(goodsDetailBean);
            if (goodsDetailBean.getGoodsStatus() != 1) {
                return Unit.INSTANCE;
            }
            CoroutineScope coroutineScope5 = coroutineScope;
            Deferred deferredB5 = v41.b(coroutineScope5, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
            deferredB = v41.b(coroutineScope5, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
            this.L$0 = goodsDetailBean;
            this.L$1 = deferredB;
            this.label = 4;
            objH = deferredB5.H(this);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean = (MerchantsBean) objH;
            if (merchantsBean == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = goodsDetailBean;
            this.L$1 = merchantsBean;
            this.label = 5;
            objH2 = deferredB.H(this);
            if (objH2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean2 = merchantsBean;
        } else if (i == 2) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objE = obj;
            goodsDetailBean = (GoodsDetailBean) objE;
            if (goodsDetailBean == null) {
                return Unit.INSTANCE;
            }
            this.this$0.u().setValue(goodsDetailBean);
            if (goodsDetailBean.getGoodsStatus() != 1) {
                return Unit.INSTANCE;
            }
            CoroutineScope coroutineScope6 = coroutineScope;
            Deferred deferredB6 = v41.b(coroutineScope6, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
            deferredB = v41.b(coroutineScope6, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
            this.L$0 = goodsDetailBean;
            this.L$1 = deferredB;
            this.label = 4;
            objH = deferredB6.H(this);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean = (MerchantsBean) objH;
            if (merchantsBean == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = goodsDetailBean;
            this.L$1 = merchantsBean;
            this.label = 5;
            objH2 = deferredB.H(this);
            if (objH2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean2 = merchantsBean;
        } else if (i == 3) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            objC = obj;
            goodsDetailBean = (GoodsDetailBean) objC;
            if (goodsDetailBean == null) {
                return Unit.INSTANCE;
            }
            this.this$0.u().setValue(goodsDetailBean);
            if (goodsDetailBean.getGoodsStatus() != 1) {
                return Unit.INSTANCE;
            }
            CoroutineScope coroutineScope7 = coroutineScope;
            Deferred deferredB7 = v41.b(coroutineScope7, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task1$1(goodsDetailBean, null), 3, (Object) null);
            deferredB = v41.b(coroutineScope7, (CoroutineContext) null, (CoroutineStart) null, new GoodsDetailVM$loadData$1$task2$1(goodsDetailBean, null), 3, (Object) null);
            this.L$0 = goodsDetailBean;
            this.L$1 = deferredB;
            this.label = 4;
            objH = deferredB7.H(this);
            if (objH == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean = (MerchantsBean) objH;
            if (merchantsBean == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = goodsDetailBean;
            this.L$1 = merchantsBean;
            this.label = 5;
            objH2 = deferredB.H(this);
            if (objH2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean2 = merchantsBean;
        } else if (i == 4) {
            deferredB = (Deferred) this.L$1;
            GoodsDetailBean goodsDetailBean2 = (GoodsDetailBean) this.L$0;
            ResultKt.throwOnFailure(obj);
            goodsDetailBean = goodsDetailBean2;
            objH = obj;
            merchantsBean = (MerchantsBean) objH;
            if (merchantsBean == null) {
                return Unit.INSTANCE;
            }
            this.L$0 = goodsDetailBean;
            this.L$1 = merchantsBean;
            this.label = 5;
            objH2 = deferredB.H(this);
            if (objH2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            merchantsBean2 = merchantsBean;
        } else {
            if (i != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            merchantsBean2 = (MerchantsBean) this.L$1;
            GoodsDetailBean goodsDetailBean3 = (GoodsDetailBean) this.L$0;
            ResultKt.throwOnFailure(obj);
            goodsDetailBean = goodsDetailBean3;
            objH2 = obj;
        }
        PageEntity pageEntity = (PageEntity) objH2;
        this.this$0.L(new GoodsDetailShop(goodsDetailBean.getType(), merchantsBean2, pageEntity != null ? pageEntity.getList() : null, goodsDetailBean.getShopGoodsShow()));
        this.this$0.F(goodsDetailBean);
        this.this$0.O();
        GoodsDetailVM goodsDetailVM = this.this$0;
        GoodsDetailShop shopInfo = goodsDetailVM.getShopInfo();
        Intrinsics.checkNotNull(shopInfo);
        goodsDetailVM.N(goodsDetailBean, shopInfo);
        return Unit.INSTANCE;
    }
}
