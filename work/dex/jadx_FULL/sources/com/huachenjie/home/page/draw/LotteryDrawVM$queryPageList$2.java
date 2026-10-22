package com.huachenjie.home.page.draw;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.home.api.HomeRequest;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.page.draw.LotteryDrawVM$queryPageList$2", f = "LotteryDrawVM.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
public final class LotteryDrawVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LotteryDrawVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryDrawVM$queryPageList$2(LotteryDrawVM lotteryDrawVM, Continuation<? super LotteryDrawVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = lotteryDrawVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LotteryDrawVM$queryPageList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:68:0x0131  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List list;
        PointsGoodStuffAdapter value;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        List list2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HomeRequest homeRequest = HomeRequest.f34197a;
            int pageNum = this.this$0.getPageNum();
            String refreshTime = this.this$0.getRefreshTime();
            this.label = 1;
            obj = homeRequest.r(pageNum, refreshTime, this);
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
        this.this$0.v(pageEntity != null ? pageEntity.getRefreshTime() : null);
        if (this.this$0.getPageNum() == 1) {
            this.this$0.o().setValue(Boxing.boxBoolean(false));
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                PointsGoodStuffAdapter value2 = this.this$0.i().getValue();
                if (value2 != null) {
                    value2.setList(null);
                }
                PointsGoodStuffAdapter value3 = this.this$0.i().getValue();
                if (value3 != null) {
                    value3.q();
                }
            } else {
                PointsGoodStuffAdapter value4 = this.this$0.i().getValue();
                if (value4 != null) {
                    value4.m();
                }
                PointsGoodStuffAdapter value5 = this.this$0.i().getValue();
                if (value5 != null) {
                    value5.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                PointsGoodStuffAdapter value6 = this.this$0.i().getValue();
                if (value6 != null) {
                    List list3 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list3, "data.list");
                    value6.addData((Collection) list3);
                }
            } else {
                LotteryDrawVM lotteryDrawVM = this.this$0;
                lotteryDrawVM.u(lotteryDrawVM.getPageNum() - 1);
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            if ((pageEntity == null || (list2 = pageEntity.getList()) == null || !(list2.isEmpty() ^ true)) ? false : true) {
                PointsGoodStuffAdapter value7 = this.this$0.i().getValue();
                if (value7 != null && (loadMoreModule2 = value7.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                value = this.this$0.i().getValue();
                if (value != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
        } else {
            value = this.this$0.i().getValue();
            if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
