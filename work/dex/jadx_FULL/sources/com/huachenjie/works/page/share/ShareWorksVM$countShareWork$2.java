package com.huachenjie.works.page.share;

import com.huachenjie.works.api.RequestModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.share.ShareWorksVM$countShareWork$2", f = "ShareWorksVM.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
public final class ShareWorksVM$countShareWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $authorNo;
    final /* synthetic */ String $shareAppUserCode;
    final /* synthetic */ String $targetNo;
    final /* synthetic */ int $targetType;
    final /* synthetic */ String $worksNo;
    int label;
    final /* synthetic */ ShareWorksVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareWorksVM$countShareWork$2(String str, int i, String str2, String str3, String str4, ShareWorksVM shareWorksVM, Continuation<? super ShareWorksVM$countShareWork$2> continuation) {
        super(2, continuation);
        this.$worksNo = str;
        this.$targetType = i;
        this.$authorNo = str2;
        this.$shareAppUserCode = str3;
        this.$targetNo = str4;
        this.this$0 = shareWorksVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ShareWorksVM$countShareWork$2(this.$worksNo, this.$targetType, this.$authorNo, this.$shareAppUserCode, this.$targetNo, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f36762a;
            String str = this.$worksNo;
            int i2 = this.$targetType;
            String str2 = this.$authorNo;
            String str3 = this.$shareAppUserCode;
            String str4 = this.$targetNo;
            this.label = 1;
            if (requestModel.g(str, i2, str2, str3, str4, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.j().setValue(Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    }
}
