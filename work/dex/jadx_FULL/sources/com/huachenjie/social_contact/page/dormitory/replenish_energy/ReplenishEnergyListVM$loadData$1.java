package com.huachenjie.social_contact.page.dormitory.replenish_energy;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.social_contact.adapter.ReplenishEnergyListAdapter;
import com.huachenjie.social_contact.api.RequestModel;
import huachenjie.sdk.http.PageEntity;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.social_contact.page.dormitory.replenish_energy.ReplenishEnergyListVM$loadData$1", f = "ReplenishEnergyListVM.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class ReplenishEnergyListVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $categoryCode;
    int label;
    final /* synthetic */ ReplenishEnergyListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplenishEnergyListVM$loadData$1(ReplenishEnergyListVM replenishEnergyListVM, int i, Continuation<? super ReplenishEnergyListVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = replenishEnergyListVM;
        this.$categoryCode = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ReplenishEnergyListVM$loadData$1(this.this$0, this.$categoryCode, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36069a;
            int i2 = this.this$0.pageNum;
            int i3 = this.$categoryCode;
            this.label = 1;
            obj = requestModel.e(i2, 20, i3, this);
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
        if (pageEntity != null) {
            ReplenishEnergyListVM replenishEnergyListVM = this.this$0;
            if (replenishEnergyListVM.pageNum == 1) {
                ReplenishEnergyListAdapter value = replenishEnergyListVM.m().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
            } else {
                ReplenishEnergyListAdapter value2 = replenishEnergyListVM.m().getValue();
                if (value2 != null) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value2.addData((Collection) list);
                }
            }
            if (pageEntity.getHasNext()) {
                ReplenishEnergyListAdapter value3 = replenishEnergyListVM.m().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                ReplenishEnergyListAdapter value4 = replenishEnergyListVM.m().getValue();
                if (value4 != null && (loadMoreModule = value4.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            replenishEnergyListVM.pageNum++;
        }
        return Unit.INSTANCE;
    }
}
