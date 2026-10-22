package com.huachenjie.works.page.campus_wall.post;

import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.base.dialog.ShareDialog;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PostItemBean;
import com.igexin.push.g.o;
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
@DebugMetadata(c = "com.huachenjie.works.page.campus_wall.post.PostAdapter$2$1$1", f = "PostAdapter.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
public final class PostAdapter$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PostItemBean $bean;
    final /* synthetic */ FragmentManager $it;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ PostAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostAdapter$2$1$1(PostItemBean postItemBean, FragmentManager fragmentManager, View view, PostAdapter postAdapter, Continuation<? super PostAdapter$2$1$1> continuation) {
        super(2, continuation);
        this.$bean = postItemBean;
        this.$it = fragmentManager;
        this.$view = view;
        this.this$0 = postAdapter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostAdapter$2$1$1(this.$bean, this.$it, this.$view, this.this$0, continuation);
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
            this.label = 1;
            obj = requestModel.V0(postNo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (obj == null) {
            return Unit.INSTANCE;
        }
        z88 z88Var = z88.f46210a;
        FragmentManager fragmentManager = this.$it;
        Intrinsics.checkNotNullExpressionValue(fragmentManager, o.f);
        String str = '#' + this.$bean.getPostInfo().getTag();
        String content = this.$bean.getPostInfo().getContent();
        String postNo2 = this.$bean.getPostInfo().getPostNo();
        String strFindImageUrl = this.$bean.findImageUrl();
        Resources resources = this.$view.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
        final PostAdapter postAdapter = this.this$0;
        final PostItemBean postItemBean = this.$bean;
        z88Var.b(fragmentManager, str, content, postNo2, strFindImageUrl, resources, new ShareDialog.OnShareCallback() { // from class: com.huachenjie.works.page.campus_wall.post.PostAdapter$2$1$1.1
            @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
            public void a(boolean shareToInternal, @NotNull String shareFlavour) {
                Intrinsics.checkNotNullParameter(shareFlavour, "shareFlavour");
                BaseViewModelExtKt.b(postAdapter.viewModel, false, false, null, null, new PostAdapter$2$1$1$1$onShare$1(postItemBean, shareFlavour, null), 15, null);
            }

            @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
            public void onFailed(@Nullable String str2) {
                ShareDialog.OnShareCallback.a.a(this, str2);
            }

            @Override // com.huachenjie.base.dialog.ShareDialog.OnShareCallback
            public void onSuccess() {
                ShareDialog.OnShareCallback.a.c(this);
            }
        });
        return Unit.INSTANCE;
    }
}
