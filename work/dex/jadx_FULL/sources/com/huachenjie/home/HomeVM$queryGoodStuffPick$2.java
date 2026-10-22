package com.huachenjie.home;

import android.text.TextUtils;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.GoodStuffPickData;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.HomeVM$queryGoodStuffPick$2", f = "HomeVM.kt", i = {}, l = {131}, m = "invokeSuspend", n = {}, s = {})
public final class HomeVM$queryGoodStuffPick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeVM$queryGoodStuffPick$2(HomeVM homeVM, Continuation<? super HomeVM$queryGoodStuffPick$2> continuation) {
        super(2, continuation);
        this.this$0 = homeVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new HomeVM$queryGoodStuffPick$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (TextUtils.isEmpty(OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String)) {
                str = "";
            } else {
                str = OAIDUtil.com.kc.openset.constant.DeviceIdType.OAID java.lang.String;
                Intrinsics.checkNotNull(str);
            }
            String str2 = TextUtils.isEmpty(str) ? "" : "OAID";
            HomeRequest homeRequest = HomeRequest.f34197a;
            this.label = 1;
            obj = homeRequest.j(str2, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        GoodStuffPickData goodStuffPickData = (GoodStuffPickData) obj;
        if (goodStuffPickData == null) {
            goodStuffPickData = new GoodStuffPickData(null, 1, null);
        }
        this.this$0.G().setValue(goodStuffPickData);
        HomeGoodsAdapter value = this.this$0.A().getValue();
        if (value != null) {
            value.setList(goodStuffPickData.getPromoSlots());
        }
        return Unit.INSTANCE;
    }
}
