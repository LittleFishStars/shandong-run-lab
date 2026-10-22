package com.huachenjie.works.page.campus_wall.post;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PostItemBean;
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
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.campus_wall.post.PostAdapter$2$1$1$1$onShare$1", f = "PostAdapter.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
public final class PostAdapter$2$1$1$1$onShare$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostItemBean $bean;
    final /* synthetic */ String $shareFlavour;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostAdapter$2$1$1$1$onShare$1(PostItemBean postItemBean, String str, Continuation<? super PostAdapter$2$1$1$1$onShare$1> continuation) {
        super(2, continuation);
        this.$bean = postItemBean;
        this.$shareFlavour = str;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostAdapter$2$1$1$1$onShare$1(this.$bean, this.$shareFlavour, continuation);
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
            RequestModel requestModel = RequestModel.f36762a;
            String postNo = this.$bean.getPostInfo().getPostNo();
            int iA = z88.f46210a.a(this.$shareFlavour);
            String appUserCode = this.$bean.getUserInfo().getAppUserCode();
            String userId = ai9.e().getUserId();
            this.label = 1;
            if (RequestModel.f(requestModel, postNo, iA, appUserCode, userId, null, this, 16, null) == coroutine_suspended) {
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
