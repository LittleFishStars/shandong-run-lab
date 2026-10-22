package com.huachenjie.channel.page.all_member;

import com.huachenjie.channel.api.RequestModel;
import huachenjie.sdk.http.PageEntity;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.all_member.AllMemberModel$loadMoreData$1", f = "AllMemberModel.kt", i = {}, l = {32, 35}, m = "invokeSuspend", n = {}, s = {})
public final class AllMemberModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AllMemberModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllMemberModel$loadMoreData$1(AllMemberModel allMemberModel, Continuation<? super AllMemberModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = allMemberModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AllMemberModel$loadMoreData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity<?> pageEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Integer value = this.this$0.getType().getValue();
            int i2 = AllMemberActivity.K;
            if (value != null && value.intValue() == i2) {
                RequestModel requestModel = RequestModel.f33012a;
                int pageNum = this.this$0.getPageNum();
                String value2 = this.this$0.E().getValue();
                String value3 = this.this$0.C().getValue();
                Intrinsics.checkNotNull(value3);
                this.label = 1;
                obj = requestModel.O(pageNum, value2, value3, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            } else {
                RequestModel requestModel2 = RequestModel.f33012a;
                int pageNum2 = this.this$0.getPageNum();
                String value4 = this.this$0.E().getValue();
                String value5 = this.this$0.C().getValue();
                Intrinsics.checkNotNull(value5);
                this.label = 2;
                obj = requestModel2.o0(pageNum2, value4, value5, this);
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
        if (pageEntity == null) {
            return Unit.INSTANCE;
        }
        this.this$0.u().setValue(pageEntity);
        if (this.this$0.D().getValue() == null) {
            this.this$0.D().setValue(Boxing.boxInt(pageEntity.getTotal()));
        }
        return Unit.INSTANCE;
    }
}
