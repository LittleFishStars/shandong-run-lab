package com.huachenjie.channel.page.my_channel.organize_member;

import com.huachenjie.channel.api.RequestModel;
import com.huachenjie.works.bean.publish.PubWorksMenuPageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberModel$loadMoreData$1", f = "OrganizeMemberModel.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
public final class OrganizeMemberModel$loadMoreData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OrganizeMemberModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrganizeMemberModel$loadMoreData$1(OrganizeMemberModel organizeMemberModel, Continuation<? super OrganizeMemberModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = organizeMemberModel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrganizeMemberModel$loadMoreData$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33012a;
            String clubCode = this.this$0.getClubCode();
            String value = this.this$0.E().getValue();
            int pageNum = this.this$0.getPageNum();
            this.label = 1;
            obj = requestModel.K(clubCode, value, pageNum, this);
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
        if (pubWorksMenuPageEntity == null) {
            return Unit.INSTANCE;
        }
        this.this$0.u().setValue(pubWorksMenuPageEntity);
        if (this.this$0.D().getValue() == null) {
            this.this$0.D().setValue(Boxing.boxInt(pubWorksMenuPageEntity.getTotal()));
        }
        return Unit.INSTANCE;
    }
}
