package com.huachenjie.mall.page.apply_refund;

import com.huachenjie.mall.bean.ApplyRefundFileBean;
import com.zj.adlib.PickedMedia;
import com.zj.adlib.gg3;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mall.page.apply_refund.ApplyRefundVM$uploadFiles$1", f = "ApplyRefundVM.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
public final class ApplyRefundVM$uploadFiles$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<ApplyRefundFileBean>, Unit> $adapterCallback;
    final /* synthetic */ List<PickedMedia> $items;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApplyRefundVM$uploadFiles$1(List<PickedMedia> list, Function1<? super List<ApplyRefundFileBean>, Unit> function1, Continuation<? super ApplyRefundVM$uploadFiles$1> continuation) {
        super(2, continuation);
        this.$items = list;
        this.$adapterCallback = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ApplyRefundVM$uploadFiles$1(this.$items, this.$adapterCallback, continuation);
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
            gg3 gg3Var = gg3.f41898a;
            String strE = ((PickedMedia) CollectionsKt.first(this.$items)).e();
            final Function1<List<ApplyRefundFileBean>, Unit> function1 = this.$adapterCallback;
            Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: com.huachenjie.mall.page.apply_refund.ApplyRefundVM$uploadFiles$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((String) obj2, (String) obj3);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable String str, @Nullable String str2) {
                    function1.invoke(CollectionsKt.listOf(new ApplyRefundFileBean(0, str2, str, null, 9, null)));
                }
            };
            this.label = 1;
            if (gg3Var.e(strE, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
