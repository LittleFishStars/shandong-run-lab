package com.huachenjie.works.page.campus_wall.post.list;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.PostCategoryBean;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
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
@DebugMetadata(c = "com.huachenjie.works.page.campus_wall.post.list.PostListVM$queryPostCategoryTagList$1", f = "PostListVM.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class PostListVM$queryPostCategoryTagList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $postTypeId;
    int label;
    final /* synthetic */ PostListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostListVM$queryPostCategoryTagList$1(String str, PostListVM postListVM, Continuation<? super PostListVM$queryPostCategoryTagList$1> continuation) {
        super(2, continuation);
        this.$postTypeId = str;
        this.this$0 = postListVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostListVM$queryPostCategoryTagList$1(this.$postTypeId, this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<PostCategoryBean> list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$postTypeId;
            this.label = 1;
            obj = requestModel.a0(str, this);
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
        if (pageEntity != null && (list = pageEntity.getList()) != null) {
            this.this$0.m().setValue(list);
        }
        return Unit.INSTANCE;
    }
}
