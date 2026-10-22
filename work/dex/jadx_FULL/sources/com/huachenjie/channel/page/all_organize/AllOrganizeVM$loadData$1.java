package com.huachenjie.channel.page.all_organize;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter;
import com.huachenjie.channel.api.RequestModel;
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
@DebugMetadata(c = "com.huachenjie.channel.page.all_organize.AllOrganizeVM$loadData$1", f = "AllOrganizeVM.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
public final class AllOrganizeVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ AllOrganizeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllOrganizeVM$loadData$1(AllOrganizeVM allOrganizeVM, String str, Continuation<? super AllOrganizeVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = allOrganizeVM;
        this.$channelNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AllOrganizeVM$loadData$1(this.this$0, this.$channelNo, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            int iK = this.this$0.getPageNum();
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.M(iK, 10, str, this);
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
            AllOrganizeVM allOrganizeVM = this.this$0;
            if (allOrganizeVM.getPageNum() == 1) {
                AllOrMyOrganizeAdapter value = allOrganizeVM.j().getValue();
                if (value != null) {
                    value.setList(pageEntity.getList());
                }
            } else {
                AllOrMyOrganizeAdapter value2 = allOrganizeVM.j().getValue();
                if (value2 != null) {
                    List list = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value2.addData((Collection) list);
                }
            }
            if (pageEntity.getHasNext()) {
                AllOrMyOrganizeAdapter value3 = allOrganizeVM.j().getValue();
                if (value3 != null && (loadMoreModule2 = value3.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                AllOrMyOrganizeAdapter value4 = allOrganizeVM.j().getValue();
                if (value4 != null && (loadMoreModule = value4.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            allOrganizeVM.m(allOrganizeVM.getPageNum() + 1);
        }
        return Unit.INSTANCE;
    }
}
