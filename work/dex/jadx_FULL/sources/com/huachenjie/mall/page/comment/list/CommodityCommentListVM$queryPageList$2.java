package com.huachenjie.mall.page.comment.list;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.mall.api.MallModel;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.comment.list.CommodityCommentListVM$queryPageList$2", f = "CommodityCommentListVM.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
public final class CommodityCommentListVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommodityCommentListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommodityCommentListVM$queryPageList$2(CommodityCommentListVM commodityCommentListVM, Continuation<? super CommodityCommentListVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = commodityCommentListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CommodityCommentListVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MallModel mallModel = MallModel.f34763a;
            String value = this.this$0.k().getValue();
            String str = value == null ? "" : value;
            Integer value2 = this.this$0.j().getValue();
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            String str2 = refreshTime == null ? "" : refreshTime;
            this.label = 1;
            obj = mallModel.t(str, value2, pageNum, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        this.this$0.s(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.n().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                CommodityCommentAdapter value3 = this.this$0.i().getValue();
                if (value3 != null) {
                    value3.setList(null);
                }
                CommodityCommentAdapter value4 = this.this$0.i().getValue();
                if (value4 != null) {
                    value4.h();
                }
            } else {
                CommodityCommentAdapter value5 = this.this$0.i().getValue();
                if (value5 != null) {
                    value5.f();
                }
                CommodityCommentAdapter value6 = this.this$0.i().getValue();
                if (value6 != null) {
                    value6.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                CommodityCommentAdapter value7 = this.this$0.i().getValue();
                if (value7 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value7.addData((Collection) list2);
                }
            } else {
                CommodityCommentListVM commodityCommentListVM = this.this$0;
                commodityCommentListVM.r(commodityCommentListVM.getPageNum() - 1);
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            CommodityCommentAdapter value8 = this.this$0.i().getValue();
            if (value8 != null && (loadMoreModule2 = value8.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            CommodityCommentAdapter value9 = this.this$0.i().getValue();
            if (value9 != null && (loadMoreModule = value9.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
