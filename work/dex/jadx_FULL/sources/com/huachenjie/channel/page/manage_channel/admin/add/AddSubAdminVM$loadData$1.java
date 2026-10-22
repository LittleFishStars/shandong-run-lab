package com.huachenjie.channel.page.manage_channel.admin.add;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
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
@DebugMetadata(c = "com.huachenjie.channel.page.manage_channel.admin.add.AddSubAdminVM$loadData$1", f = "AddSubAdminVM.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class AddSubAdminVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelNo;
    int label;
    final /* synthetic */ AddSubAdminVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddSubAdminVM$loadData$1(AddSubAdminVM addSubAdminVM, String str, Continuation<? super AddSubAdminVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = addSubAdminVM;
        this.$channelNo = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AddSubAdminVM$loadData$1(this.this$0, this.$channelNo, continuation);
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
            int i2 = this.this$0.pageNum;
            String value = this.this$0.n().getValue();
            String str = this.$channelNo;
            this.label = 1;
            obj = requestModel.O(i2, value, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PubWorksMenuPageEntity pubWorksMenuPageEntity = (PubWorksMenuPageEntity) obj;
        if (pubWorksMenuPageEntity != null) {
            AddSubAdminVM addSubAdminVM = this.this$0;
            if (addSubAdminVM.pageNum == 1) {
                AddSubAdminAdapter value2 = addSubAdminVM.l().getValue();
                if (value2 != null) {
                    value2.setList(pubWorksMenuPageEntity.getList());
                }
            } else {
                AddSubAdminAdapter value3 = addSubAdminVM.l().getValue();
                if (value3 != null) {
                    List list = pubWorksMenuPageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list, "it.list");
                    value3.addData((Collection) list);
                }
            }
            if (pubWorksMenuPageEntity.getHasNext()) {
                AddSubAdminAdapter value4 = addSubAdminVM.l().getValue();
                if (value4 != null && (loadMoreModule2 = value4.getLoadMoreModule()) != null) {
                    loadMoreModule2.loadMoreComplete();
                }
            } else {
                AddSubAdminAdapter value5 = addSubAdminVM.l().getValue();
                if (value5 != null && (loadMoreModule = value5.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
            }
            addSubAdminVM.pageNum++;
        }
        return Unit.INSTANCE;
    }
}
