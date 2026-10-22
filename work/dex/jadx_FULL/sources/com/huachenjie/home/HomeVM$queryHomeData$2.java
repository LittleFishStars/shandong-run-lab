package com.huachenjie.home;

import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.HomeData;
import com.huachenjie.home.bean.HomeHeaderBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.HomeVM$queryHomeData$2", f = "HomeVM.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nHomeVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeVM.kt\ncom/huachenjie/home/HomeVM$queryHomeData$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,321:1\n766#2:322\n857#2,2:323\n*S KotlinDebug\n*F\n+ 1 HomeVM.kt\ncom/huachenjie/home/HomeVM$queryHomeData$2\n*L\n110#1:322\n110#1:323,2\n*E\n"})
public final class HomeVM$queryHomeData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeVM$queryHomeData$2(HomeVM homeVM, Continuation<? super HomeVM$queryHomeData$2> continuation) {
        super(2, continuation);
        this.this$0 = homeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeVM$queryHomeData$2(this.this$0, continuation);
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
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.label = 1;
            obj = homeRequest.l(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HomeData homeDataZ = (HomeData) obj;
        if (homeDataZ == null) {
            homeDataZ = this.this$0.z();
        }
        List<HomeHeaderBean> functionEntries = homeDataZ.getFunctionEntries();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : functionEntries) {
            if (((HomeHeaderBean) obj2).isShow()) {
                arrayList.add(obj2);
            }
        }
        this.this$0.C().setValue(new HomeData(arrayList, homeDataZ.getSeaview(), homeDataZ.getHasSeaview()));
        return Unit.INSTANCE;
    }
}
