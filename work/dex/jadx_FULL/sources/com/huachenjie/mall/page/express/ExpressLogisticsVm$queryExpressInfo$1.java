package com.huachenjie.mall.page.express;

import com.huachenjie.mall.api.MallModel;
import com.huachenjie.mall.bean.ExpressLogisticsBean;
import com.huachenjie.mall.bean.ExpressLogisticsDetailBean;
import com.huachenjie.mall.bean.ExpressLogisticsOutBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.huachenjie.mall.page.express.ExpressLogisticsVm$queryExpressInfo$1", f = "ExpressLogisticsVm.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nExpressLogisticsVm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExpressLogisticsVm.kt\ncom/huachenjie/mall/page/express/ExpressLogisticsVm$queryExpressInfo$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1855#2:81\n1864#2,3:82\n1856#2:85\n*S KotlinDebug\n*F\n+ 1 ExpressLogisticsVm.kt\ncom/huachenjie/mall/page/express/ExpressLogisticsVm$queryExpressInfo$1\n*L\n40#1:81\n41#1:82,3\n40#1:85\n*E\n"})
public final class ExpressLogisticsVm$queryExpressInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $logisticNo;
    int label;
    final /* synthetic */ ExpressLogisticsVm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressLogisticsVm$queryExpressInfo$1(String str, ExpressLogisticsVm expressLogisticsVm, Continuation<? super ExpressLogisticsVm$queryExpressInfo$1> continuation) {
        super(2, continuation);
        this.$logisticNo = str;
        this.this$0 = expressLogisticsVm;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ExpressLogisticsVm$queryExpressInfo$1(this.$logisticNo, this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            String str = this.$logisticNo;
            this.label = 1;
            obj = mallModel.D(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ExpressLogisticsOutBean expressLogisticsOutBean = (ExpressLogisticsOutBean) obj;
        if (expressLogisticsOutBean == null) {
            return Unit.INSTANCE;
        }
        expressLogisticsOutBean.setLightStatus(Intrinsics.areEqual(this.this$0.n().getValue(), Boxing.boxBoolean(true)));
        this.this$0.l().setValue(expressLogisticsOutBean);
        ArrayList arrayList = new ArrayList();
        List<ExpressLogisticsBean> list = expressLogisticsOutBean.getList();
        ExpressLogisticsVm expressLogisticsVm = this.this$0;
        for (ExpressLogisticsBean expressLogisticsBean : list) {
            int i2 = 0;
            for (Object obj2 : expressLogisticsBean.getDetails()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                expressLogisticsVm.p(arrayList, expressLogisticsBean, (ExpressLogisticsDetailBean) obj2, (!(expressLogisticsBean.getDetails().size() == 1 && i2 == 0) && (expressLogisticsBean.getDetails().size() <= 1 || i2 != expressLogisticsBean.getDetails().size() - 1)) ? 1 : 0);
                i2 = i3;
            }
        }
        ExpressLogisticsAdapter value = this.this$0.j().getValue();
        if (value != null) {
            value.setList(CollectionsKt.reversed(arrayList));
        }
        return Unit.INSTANCE;
    }
}
