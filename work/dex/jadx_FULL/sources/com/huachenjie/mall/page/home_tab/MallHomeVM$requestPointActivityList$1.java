package com.huachenjie.mall.page.home_tab;

import android.text.TextUtils;
import com.huachenjie.college.api.RequestModel;
import com.huachenjie.college.bean.PointActivityBean;
import com.igexin.push.g.o;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.home_tab.MallHomeVM$requestPointActivityList$1", f = "MallHomeVM.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMallHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MallHomeVM.kt\ncom/huachenjie/mall/page/home_tab/MallHomeVM$requestPointActivityList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,105:1\n1855#2,2:106\n*S KotlinDebug\n*F\n+ 1 MallHomeVM.kt\ncom/huachenjie/mall/page/home_tab/MallHomeVM$requestPointActivityList$1\n*L\n96#1:106,2\n*E\n"})
public final class MallHomeVM$requestPointActivityList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MallHomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MallHomeVM$requestPointActivityList$1(MallHomeVM mallHomeVM, Continuation<? super MallHomeVM$requestPointActivityList$1> continuation) {
        super(2, continuation);
        this.this$0 = mallHomeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MallHomeVM$requestPointActivityList$1(this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f33549a;
            this.label = 1;
            obj = requestModel.q(1, this);
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
        if (pageEntity == null || pageEntity.getList() == null || pageEntity.getList().isEmpty()) {
            this.this$0.n().setValue(new ArrayList());
        } else {
            ArrayList arrayList = new ArrayList();
            List<PointActivityBean> list = pageEntity.getList();
            Intrinsics.checkNotNullExpressionValue(list, "data.list");
            for (PointActivityBean pointActivityBean : list) {
                if (TextUtils.equals(pointActivityBean.getStatus(), "ONGOING")) {
                    Intrinsics.checkNotNullExpressionValue(pointActivityBean, o.f);
                    arrayList.add(pointActivityBean);
                }
            }
            this.this$0.n().setValue(arrayList);
        }
        return Unit.INSTANCE;
    }
}
