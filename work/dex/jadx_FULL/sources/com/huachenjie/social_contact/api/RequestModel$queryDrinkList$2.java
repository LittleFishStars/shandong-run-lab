package com.huachenjie.social_contact.api;

import com.huachenjie.common.reconfig.net.IResponse;
import com.huachenjie.social_contact.bean.DrinkDetailBean;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/social_contact/bean/DrinkDetailBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.social_contact.api.RequestModel$queryDrinkList$2", f = "RequestModel.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class RequestModel$queryDrinkList$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<DrinkDetailBean>>>, Object> {
    final /* synthetic */ int $categoryCode;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ int $pageSize;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestModel$queryDrinkList$2(int i, int i2, int i3, Continuation<? super RequestModel$queryDrinkList$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$pageSize = i2;
        this.$categoryCode = i3;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new RequestModel$queryDrinkList$2(this.$pageNum, this.$pageSize, this.$categoryCode, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<DrinkDetailBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            UniverseApi universeApiA = RequestModel.f36069a.a();
            int i2 = this.$pageNum;
            int i3 = this.$pageSize;
            int i4 = this.$categoryCode;
            this.label = 1;
            obj = universeApiA.h(i2, i3, i4, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
