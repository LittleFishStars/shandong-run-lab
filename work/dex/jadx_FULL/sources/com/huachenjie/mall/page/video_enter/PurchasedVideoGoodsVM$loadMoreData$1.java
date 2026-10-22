package com.huachenjie.mall.page.video_enter;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.MyCourseOrEpisodesBean;
import huachenjie.sdk.http.PageEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.video_enter.PurchasedVideoGoodsVM$loadMoreData$1", f = "PurchasedVideoGoodsVM.kt", i = {}, l = {23, 25}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nPurchasedVideoGoodsVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PurchasedVideoGoodsVM.kt\ncom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsVM$loadMoreData$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,33:1\n1855#2,2:34\n*S KotlinDebug\n*F\n+ 1 PurchasedVideoGoodsVM.kt\ncom/huachenjie/mall/page/video_enter/PurchasedVideoGoodsVM$loadMoreData$1\n*L\n27#1:34,2\n*E\n"})
public final class PurchasedVideoGoodsVM$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PurchasedVideoGoodsVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PurchasedVideoGoodsVM$loadMoreData$1(PurchasedVideoGoodsVM purchasedVideoGoodsVM, Continuation<? super PurchasedVideoGoodsVM$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = purchasedVideoGoodsVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PurchasedVideoGoodsVM$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity<?> pageEntity;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getType() == 0) {
                MallModel mallModel = MallModel.f34763a;
                int pageNum = this.this$0.getPageNum();
                this.label = 1;
                obj = mallModel.M(pageNum, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            } else {
                MallModel mallModel2 = MallModel.f34763a;
                int pageNum2 = this.this$0.getPageNum();
                this.label = 2;
                obj = mallModel2.N(pageNum2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            pageEntity = (PageEntity) obj;
        }
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            PurchasedVideoGoodsVM purchasedVideoGoodsVM = this.this$0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((MyCourseOrEpisodesBean) it.next()).setType(purchasedVideoGoodsVM.getType());
            }
        }
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
