package com.huachenjie.works.page.alumni.good_stuff;

import com.huachenjie.works.api.RequestModel;
import com.huachenjie.works.bean.GoodStuffTabBean;
import com.huachenjie.works.bean.GoodStuffTabData;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.alumni.good_stuff.GoodStuffVM$queryGoodStuffTabList$2", f = "GoodStuffVM.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nGoodStuffVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoodStuffVM.kt\ncom/huachenjie/works/page/alumni/good_stuff/GoodStuffVM$queryGoodStuffTabList$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,36:1\n1855#2,2:37\n*S KotlinDebug\n*F\n+ 1 GoodStuffVM.kt\ncom/huachenjie/works/page/alumni/good_stuff/GoodStuffVM$queryGoodStuffTabList$2\n*L\n25#1:37,2\n*E\n"})
public final class GoodStuffVM$queryGoodStuffTabList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ GoodStuffVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodStuffVM$queryGoodStuffTabList$2(GoodStuffVM goodStuffVM, Continuation<? super GoodStuffVM$queryGoodStuffTabList$2> continuation) {
        super(2, continuation);
        this.this$0 = goodStuffVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GoodStuffVM$queryGoodStuffTabList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List<GoodStuffTabBean> adZoneInfoList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RequestModel requestModel = RequestModel.f36762a;
            this.label = 1;
            obj = requestModel.T(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GoodStuffTabData goodStuffTabData = (GoodStuffTabData) obj;
        ArrayList arrayList = new ArrayList();
        if (goodStuffTabData != null && (adZoneInfoList = goodStuffTabData.getAdZoneInfoList()) != null) {
            for (GoodStuffTabBean goodStuffTabBean : adZoneInfoList) {
                if (goodStuffTabBean.getZoneType() == 1) {
                    arrayList.add(goodStuffTabBean);
                }
            }
        }
        this.this$0.i().setValue(arrayList);
        this.this$0.l(false);
        return Unit.INSTANCE;
    }
}
