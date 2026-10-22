package com.huachenjie.run.page.run_reward;

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
@DebugMetadata(c = "com.huachenjie.run.page.run_reward.RunRewardListVM$loadData$1", f = "RunRewardListVM.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class RunRewardListVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $runPlanCode;
    final /* synthetic */ String $semesterCode;
    final /* synthetic */ int $type;
    int label;
    final /* synthetic */ RunRewardListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunRewardListVM$loadData$1(RunRewardListVM runRewardListVM, String str, String str2, int i, Continuation<? super RunRewardListVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = runRewardListVM;
        this.$semesterCode = str;
        this.$runPlanCode = str2;
        this.$type = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RunRewardListVM$loadData$1(this.this$0, this.$semesterCode, this.$runPlanCode, this.$type, continuation);
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
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            int i2 = this.this$0.pageNum;
            String str = this.$semesterCode;
            String str2 = this.$runPlanCode;
            int i3 = this.$type;
            this.label = 1;
            obj = runRequestModel.r(i2, str, str2, i3, this);
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
            RunRewardListVM runRewardListVM = this.this$0;
            if (runRewardListVM.pageNum == 1) {
                RunRewardListAdapter value = runRewardListVM.k().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
            } else {
                RunRewardListAdapter value2 = runRewardListVM.k().getValue();
                if (value2 != null) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value2.addData((Collection) list);
                }
            }
            if (pageEntity.getHasNext()) {
                RunRewardListAdapter value3 = runRewardListVM.k().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                RunRewardListAdapter value4 = runRewardListVM.k().getValue();
                if (value4 != null && (loadMoreModule = value4.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            runRewardListVM.pageNum++;
        }
        return Unit.INSTANCE;
    }
}
