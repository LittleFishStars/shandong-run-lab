package com.huachenjie.works.utils;

import android.text.TextUtils;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.utils.PublishUtil$validPublish$1", f = "PublishUtil.kt", i = {}, l = {66, 70}, m = "invokeSuspend", n = {}, s = {})
public final class PublishUtil$validPublish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $attachmentType;
    final /* synthetic */ ArrayList<RecommendWorksBean> $categoryList;
    final /* synthetic */ String $categoryNo;
    final /* synthetic */ Function0<Unit> $onSuccess;
    final /* synthetic */ BaseViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishUtil$validPublish$1(int i, ArrayList<RecommendWorksBean> arrayList, String str, BaseViewModel baseViewModel, Function0<Unit> function0, Continuation<? super PublishUtil$validPublish$1> continuation) {
        super(2, continuation);
        this.$attachmentType = i;
        this.$categoryList = arrayList;
        this.$categoryNo = str;
        this.$viewModel = baseViewModel;
        this.$onSuccess = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new PublishUtil$validPublish$1(this.$attachmentType, this.$categoryList, this.$categoryNo, this.$viewModel, this.$onSuccess, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0079  */
    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0091  */
    /* JADX WARN: Code duplicated, block: B:45:0x00ab  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ArrayList<RecommendWorksBean> arrayList;
        String categoryNo;
        Function0<Unit> function0;
        RecommendWorksBean recommendWorksBean;
        PageEntity pageEntity;
        List listEmptyList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            pageEntity = (PageEntity) obj;
            if (pageEntity != null) {
                listEmptyList = pageEntity.getList();
            } else {
                listEmptyList = null;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type java.util.ArrayList<@[FlexibleNullability] com.huachenjie.works.bean.RecommendWorksBean?>");
            arrayList = (ArrayList) listEmptyList;
            if (TextUtils.isEmpty(this.$categoryNo)) {
                recommendWorksBean = (RecommendWorksBean) CollectionsKt.firstOrNull(arrayList);
                if (recommendWorksBean != null || (categoryNo = recommendWorksBean.getCategoryNo()) == null) {
                    categoryNo = "";
                }
            } else {
                categoryNo = this.$categoryNo;
            }
            this.$viewModel.c();
            ARouter.getInstance().build(zj7.i.WORKS_PUBLISH).withInt(yj7.g.WORKS_PUBLISH_TYPE, this.$attachmentType == 1 ? 1 : 2).withParcelableArrayList(yj7.g.WORKS_PUBLISH_CATEGORY_LIST, arrayList).withString(yj7.g.WORKS_PUBLISH_CATEGORY_NO, categoryNo).navigation();
            function0 = this.$onSuccess;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        RequestModel requestModel = RequestModel.f36762a;
        int i2 = this.$attachmentType;
        this.label = 1;
        if (requestModel.W0(i2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        ArrayList<RecommendWorksBean> arrayList2 = this.$categoryList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            RequestModel requestModel2 = RequestModel.f36762a;
            this.label = 2;
            obj = requestModel2.s0(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            pageEntity = (PageEntity) obj;
            if (pageEntity != null) {
                listEmptyList = pageEntity.getList();
            } else {
                listEmptyList = null;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type java.util.ArrayList<@[FlexibleNullability] com.huachenjie.works.bean.RecommendWorksBean?>");
            arrayList = (ArrayList) listEmptyList;
        } else {
            arrayList = this.$categoryList;
        }
        if (TextUtils.isEmpty(this.$categoryNo)) {
            recommendWorksBean = (RecommendWorksBean) CollectionsKt.firstOrNull(arrayList);
            if (recommendWorksBean != null) {
                categoryNo = "";
            } else {
                categoryNo = "";
            }
        } else {
            categoryNo = this.$categoryNo;
        }
        this.$viewModel.c();
        ARouter.getInstance().build(zj7.i.WORKS_PUBLISH).withInt(yj7.g.WORKS_PUBLISH_TYPE, this.$attachmentType == 1 ? 1 : 2).withParcelableArrayList(yj7.g.WORKS_PUBLISH_CATEGORY_LIST, arrayList).withString(yj7.g.WORKS_PUBLISH_CATEGORY_NO, categoryNo).navigation();
        function0 = this.$onSuccess;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }
}
