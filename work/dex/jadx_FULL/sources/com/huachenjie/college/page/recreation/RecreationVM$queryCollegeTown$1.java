package com.huachenjie.college.page.recreation;

import com.huachenjie.base.util.ThirdUtil;
import com.huachenjie.college.api.RequestModel;
import com.huachenjie.college.bean.CollegeRecommendBean;
import com.huachenjie.college.bean.CollegeTownBean;
import com.igexin.assist.util.AssistUtils;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.college.page.recreation.RecreationVM$queryCollegeTown$1", f = "RecreationVM.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nRecreationVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecreationVM.kt\ncom/huachenjie/college/page/recreation/RecreationVM$queryCollegeTown$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,54:1\n766#2:55\n857#2,2:56\n766#2:58\n857#2,2:59\n*S KotlinDebug\n*F\n+ 1 RecreationVM.kt\ncom/huachenjie/college/page/recreation/RecreationVM$queryCollegeTown$1\n*L\n22#1:55\n22#1:56,2\n29#1:58\n29#1:59,2\n*E\n"})
public final class RecreationVM$queryCollegeTown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RecreationVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecreationVM$queryCollegeTown$1(RecreationVM recreationVM, Continuation<? super RecreationVM$queryCollegeTown$1> continuation) {
        super(2, continuation);
        this.this$0 = recreationVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RecreationVM$queryCollegeTown$1(this.this$0, continuation);
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
            obj = requestModel.e(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        CollegeTownBean collegeTownBean = (CollegeTownBean) obj;
        if (collegeTownBean == null) {
            collegeTownBean = new CollegeTownBean(null, null, null, false, 15, null);
        }
        if (Intrinsics.areEqual(ThirdUtil.f7255a.b(), AssistUtils.BRAND_HW)) {
            List<CollegeRecommendBean> typeList = collegeTownBean.getTypeList();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : typeList) {
                if (!Intrinsics.areEqual(((CollegeRecommendBean) obj2).getType(), "3")) {
                    arrayList.add(obj2);
                }
            }
            collegeTownBean.setTypeList(arrayList);
        }
        if (Intrinsics.areEqual(ThirdUtil.f7255a.b(), "xiaomi")) {
            List<CollegeRecommendBean> typeList2 = collegeTownBean.getTypeList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj3 : typeList2) {
                if (!Intrinsics.areEqual(((CollegeRecommendBean) obj3).getType(), "4")) {
                    arrayList2.add(obj3);
                }
            }
            collegeTownBean.setTypeList(arrayList2);
        }
        this.this$0.k().setValue(collegeTownBean);
        return Unit.INSTANCE;
    }
}
