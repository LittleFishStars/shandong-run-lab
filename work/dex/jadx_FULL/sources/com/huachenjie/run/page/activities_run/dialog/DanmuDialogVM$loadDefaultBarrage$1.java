package com.huachenjie.run.page.activities_run.dialog;

import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.run.model.RunRequestModel;
import com.igexin.push.g.o;
import com.zj.adlib.ai9;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.run.page.activities_run.dialog.DanmuDialogVM$loadDefaultBarrage$1", f = "DanmuDialogVM.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDanmuDialogVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DanmuDialogVM.kt\ncom/huachenjie/run/page/activities_run/dialog/DanmuDialogVM$loadDefaultBarrage$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,40:1\n1#2:41\n*E\n"})
public final class DanmuDialogVM$loadDefaultBarrage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DanmuDialogVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmuDialogVM$loadDefaultBarrage$1(DanmuDialogVM danmuDialogVM, Continuation<? super DanmuDialogVM$loadDefaultBarrage$1> continuation) {
        super(2, continuation);
        this.this$0 = danmuDialogVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DanmuDialogVM$loadDefaultBarrage$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String barrageText;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            this.label = 1;
            obj = runRequestModel.k(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        List listEmptyList = (List) obj;
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        List mutableList = CollectionsKt.toMutableList(listEmptyList);
        BrandPromotionConfigBean brandPromotionConfigBeanC = ai9.c();
        final String str = null;
        if (brandPromotionConfigBeanC != null && (barrageText = brandPromotionConfigBeanC.getBarrageText()) != null && (!StringsKt.isBlank(barrageText))) {
            str = barrageText;
        }
        this.this$0.hasBrandFirstRow = str != null;
        if (str != null) {
            CollectionsKt.removeAll(mutableList, new Function1<String, Boolean>() { // from class: com.huachenjie.run.page.activities_run.dialog.DanmuDialogVM$loadDefaultBarrage$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull String str2) {
                    Intrinsics.checkNotNullParameter(str2, o.f);
                    return Boolean.valueOf(Intrinsics.areEqual(str2, str));
                }
            });
            mutableList.add(0, str);
        }
        DanmuDialogAdapter value = this.this$0.j().getValue();
        if (value != null) {
            value.f();
            value.setList(mutableList);
        }
        return Unit.INSTANCE;
    }
}
