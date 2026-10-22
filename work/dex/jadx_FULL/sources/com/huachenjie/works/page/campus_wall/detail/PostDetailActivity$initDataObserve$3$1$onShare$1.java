package com.huachenjie.works.page.campus_wall.detail;

import com.huachenjie.base.bean.UserInfoBean;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PostDetailBean;
import com.zj.adlib.ai9;
import com.zj.adlib.z88;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.campus_wall.detail.PostDetailActivity$initDataObserve$3$1$onShare$1", f = "PostDetailActivity.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
public final class PostDetailActivity$initDataObserve$3$1$onShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $shareFlavour;
    int label;
    final /* synthetic */ PostDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostDetailActivity$initDataObserve$3$1$onShare$1(PostDetailActivity postDetailActivity, String str, Continuation<? super PostDetailActivity$initDataObserve$3$1$onShare$1> continuation) {
        super(2, continuation);
        this.this$0 = postDetailActivity;
        this.$shareFlavour = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostDetailActivity$initDataObserve$3$1$onShare$1(this.this$0, this.$shareFlavour, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String appUserCode;
        UserInfoBean userInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            String strK0 = this.this$0.k0();
            Intrinsics.checkNotNullExpressionValue(strK0, "postNo");
            int iA = z88.f46210a.a(this.$shareFlavour);
            PostDetailBean value = PostDetailActivity.c0(this.this$0).n().getValue();
            if (value == null || (userInfo = value.getUserInfo()) == null || (appUserCode = userInfo.getAppUserCode()) == null) {
                appUserCode = "";
            }
            String userId = ai9.e().getUserId();
            this.label = 1;
            if (RequestModel.f(requestModel, strK0, iA, appUserCode, userId, null, this, 16, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
