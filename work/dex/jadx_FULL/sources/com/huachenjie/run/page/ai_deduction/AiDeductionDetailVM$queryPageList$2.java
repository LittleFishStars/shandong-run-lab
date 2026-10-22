package com.huachenjie.run.page.ai_deduction;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.run.model.RunRequestModel;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.ai_deduction.AiDeductionDetailVM$queryPageList$2", f = "AiDeductionDetailVM.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class AiDeductionDetailVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AiDeductionDetailVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiDeductionDetailVM$queryPageList$2(AiDeductionDetailVM aiDeductionDetailVM, Continuation<? super AiDeductionDetailVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.this$0 = aiDeductionDetailVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AiDeductionDetailVM$queryPageList$2(this.this$0, continuation);
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
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            int pageNum = this.this$0.getPageNum();
            String value = this.this$0.l().getValue();
            if (value == null) {
                value = "";
            }
            this.label = 1;
            obj = runRequestModel.p(pageNum, value, this);
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
        if (this.this$0.getPageNum() == 1) {
            if ((pageEntity != null ? pageEntity.getList() : null) == null || pageEntity.getList().isEmpty()) {
                AiDeductionDetailAdapter value2 = this.this$0.j().getValue();
                if (value2 != null) {
                    value2.h();
                }
                AiDeductionDetailAdapter value3 = this.this$0.j().getValue();
                if (value3 != null) {
                    value3.setList(null);
                }
            } else {
                AiDeductionDetailAdapter value4 = this.this$0.j().getValue();
                if (value4 != null) {
                    value4.f();
                }
                AiDeductionDetailAdapter value5 = this.this$0.j().getValue();
                if (value5 != null) {
                    value5.setList(pageEntity.getList());
                }
            }
        } else {
            if ((pageEntity == null || (list = pageEntity.getList()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                AiDeductionDetailAdapter value6 = this.this$0.j().getValue();
                if (value6 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value6.addData((Collection) list2);
                }
            } else {
                AiDeductionDetailVM aiDeductionDetailVM = this.this$0;
                aiDeductionDetailVM.p(aiDeductionDetailVM.getPageNum() - 1);
            }
        }
        if (pageEntity != null && pageEntity.getHasNext()) {
            AiDeductionDetailAdapter value7 = this.this$0.j().getValue();
            if (value7 != null && (loadMoreModule2 = value7.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            AiDeductionDetailAdapter value8 = this.this$0.j().getValue();
            if (value8 != null && (loadMoreModule = value8.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
