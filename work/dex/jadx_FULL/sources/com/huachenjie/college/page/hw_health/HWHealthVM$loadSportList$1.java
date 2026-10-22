package com.huachenjie.college.page.hw_health;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.college.api.RequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.hw_health.HWHealthVM$loadSportList$1", f = "HWHealthVM.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
public final class HWHealthVM$loadSportList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HWHealthVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HWHealthVM$loadSportList$1(HWHealthVM hWHealthVM, Continuation<? super HWHealthVM$loadSportList$1> continuation) {
        super(2, continuation);
        this.this$0 = hWHealthVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HWHealthVM$loadSportList$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33549a;
            Integer numM = this.this$0.getSelectedYear();
            Integer numL = this.this$0.getSelectedMonth();
            int iK = this.this$0.getPageNum();
            this.label = 1;
            obj = requestModel.j(numM, numL, iK, 10, this);
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
            HWHealthVM hWHealthVM = this.this$0;
            if (hWHealthVM.getPageNum() == 1) {
                HWHealthAdapter value = hWHealthVM.j().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
            } else {
                HWHealthAdapter value2 = hWHealthVM.j().getValue();
                if (value2 != null) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value2.addData((Collection) list);
                }
            }
            if (pageEntity.getHasNext()) {
                HWHealthAdapter value3 = hWHealthVM.j().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                HWHealthAdapter value4 = hWHealthVM.j().getValue();
                if (value4 != null && (loadMoreModule = value4.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            hWHealthVM.s(hWHealthVM.getPageNum() + 1);
        }
        return Unit.INSTANCE;
    }
}
