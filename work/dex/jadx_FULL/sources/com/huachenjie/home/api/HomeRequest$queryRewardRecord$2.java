package com.huachenjie.home.api;

import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.common.reconfig.net.IResponse;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\u008a@"}, d2 = {"Lcom/huachenjie/common/reconfig/net/IResponse;", "Lhuachenjie/sdk/http/PageEntity;", "Lcom/huachenjie/base/bean/reward/RewardInfoBean;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.api.HomeRequest$queryRewardRecord$2", f = "HomeRequest.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
public final class HomeRequest$queryRewardRecord$2 extends SuspendLambda implements Function1<Continuation<? super IResponse<PageEntity<RewardInfoBean>>>, Object> {
    final /* synthetic */ boolean $historyData;
    final /* synthetic */ int $pageNum;
    final /* synthetic */ String $refreshTime;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeRequest$queryRewardRecord$2(int i, String str, boolean z, Continuation<? super HomeRequest$queryRewardRecord$2> continuation) {
        super(1, continuation);
        this.$pageNum = i;
        this.$refreshTime = str;
        this.$historyData = z;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new HomeRequest$queryRewardRecord$2(this.$pageNum, this.$refreshTime, this.$historyData, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super IResponse<PageEntity<RewardInfoBean>>> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HomeApi homeApiA = HomeRequest.f34197a.a();
            int i2 = this.$pageNum;
            String str = this.$refreshTime;
            boolean z = this.$historyData;
            this.label = 1;
            obj = homeApiA.x(i2, 10, str, z, this);
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
