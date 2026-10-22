package com.huachenjie.mall.page.search;

import com.huachenjie.mall.api.MallModel;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.search.SearchResultGoodsModel$loadMoreData$1", f = "SearchResultGoodsModel.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
public final class SearchResultGoodsModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SearchResultGoodsModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchResultGoodsModel$loadMoreData$1(SearchResultGoodsModel searchResultGoodsModel, Continuation<? super SearchResultGoodsModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = searchResultGoodsModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SearchResultGoodsModel$loadMoreData$1(this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            if (refreshTime == null) {
                refreshTime = "";
            }
            String value = this.this$0.C().getValue();
            this.label = 1;
            obj = mallModel.u(pageNum, refreshTime, (16 & 4) != 0 ? null : null, (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? null : value, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity<?> pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            return Unit.INSTANCE;
        }
        this.this$0.u().setValue(pageEntity);
        return Unit.INSTANCE;
    }
}
