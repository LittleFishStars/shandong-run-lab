package com.huachenjie.works.page.campus_wall.post.list;

import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.page.campus_wall.post.PostAdapter;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.campus_wall.post.list.PostListVM$queryPageList$2", f = "PostListVM.kt", i = {}, l = {65, 67}, m = "invokeSuspend", n = {}, s = {})
public final class PostListVM$queryPageList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $postType;
    final /* synthetic */ String $postTypeId;
    final /* synthetic */ String $schoolCode;
    final /* synthetic */ String $tagNo;
    int label;
    final /* synthetic */ PostListVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostListVM$queryPageList$2(int i, PostListVM postListVM, String str, String str2, String str3, Continuation<? super PostListVM$queryPageList$2> continuation) {
        super(2, continuation);
        this.$postType = i;
        this.this$0 = postListVM;
        this.$schoolCode = str;
        this.$postTypeId = str2;
        this.$tagNo = str3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PostListVM$queryPageList$2(this.$postType, this.this$0, this.$schoolCode, this.$postTypeId, this.$tagNo, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        PageEntity pageEntity;
        BaseLoadMoreModule loadMoreModule;
        BaseLoadMoreModule loadMoreModule2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$postType == 1) {
                RequestModel requestModel = RequestModel.f36762a;
                int pageNum = this.this$0.getPageNum();
                String refreshTime = this.this$0.getRefreshTime();
                String str = this.$schoolCode;
                this.label = 1;
                obj = requestModel.g0(pageNum, refreshTime, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pageEntity = (PageEntity) obj;
            } else {
                RequestModel requestModel2 = RequestModel.f36762a;
                int pageNum2 = this.this$0.getPageNum();
                String refreshTime2 = this.this$0.getRefreshTime();
                String str2 = this.$postTypeId;
                String str3 = this.$tagNo;
                String str4 = this.$schoolCode;
                this.label = 2;
                obj = requestModel2.i0(pageNum2, refreshTime2, str2, str3, str4, this);
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
            pageEntity = new PageEntity();
            pageEntity.setList(new ArrayList());
            pageEntity.setHasNext(false);
        }
        this.this$0.t(pageEntity.getRefreshTime());
        if (this.this$0.getPageNum() == 1) {
            this.this$0.n().setValue(Boxing.boxBoolean(false));
            if (pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
                PostAdapter value = this.this$0.j().getValue();
                if (value != null) {
                    value.setList(null);
                }
                PostAdapter value2 = this.this$0.j().getValue();
                if (value2 != null) {
                    value2.p();
                }
            } else {
                PostAdapter value3 = this.this$0.j().getValue();
                if (value3 != null) {
                    value3.n();
                }
                PostAdapter value4 = this.this$0.j().getValue();
                if (value4 != null) {
                    value4.setList(pageEntity.getList());
                }
            }
        } else {
            List list = pageEntity.getList();
            if (list != null && (list.isEmpty() ^ true)) {
                PostAdapter value5 = this.this$0.j().getValue();
                if (value5 != null) {
                    List list2 = pageEntity.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                    value5.addData((Collection) list2);
                }
            } else {
                PostListVM postListVM = this.this$0;
                postListVM.s(postListVM.getPageNum() - 1);
            }
        }
        if (pageEntity.getHasNext()) {
            PostAdapter value6 = this.this$0.j().getValue();
            if (value6 != null && (loadMoreModule2 = value6.getLoadMoreModule()) != null) {
                loadMoreModule2.loadMoreComplete();
            }
        } else {
            PostAdapter value7 = this.this$0.j().getValue();
            if (value7 != null && (loadMoreModule = value7.getLoadMoreModule()) != null) {
                BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
            }
        }
        return Unit.INSTANCE;
    }
}
