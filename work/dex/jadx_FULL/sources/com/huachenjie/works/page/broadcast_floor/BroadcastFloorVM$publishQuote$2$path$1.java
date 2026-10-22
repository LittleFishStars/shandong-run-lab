package com.huachenjie.works.page.broadcast_floor;

import android.content.Context;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.works.bean.BroadcastFloorMessageImageBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.broadcast_floor.BroadcastFloorVM$publishQuote$2$path$1", f = "BroadcastFloorVM.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
public final class BroadcastFloorVM$publishQuote$2$path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ BroadcastFloorMessageImageBean $image;
    int label;
    final /* synthetic */ BroadcastFloorVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastFloorVM$publishQuote$2$path$1(BroadcastFloorVM broadcastFloorVM, Context context, BroadcastFloorMessageImageBean broadcastFloorMessageImageBean, Continuation<? super BroadcastFloorVM$publishQuote$2$path$1> continuation) {
        super(2, continuation);
        this.this$0 = broadcastFloorVM;
        this.$context = context;
        this.$image = broadcastFloorMessageImageBean;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BroadcastFloorVM$publishQuote$2$path$1(this.this$0, this.$context, this.$image, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super String> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws InterruptedException {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BroadcastFloorVM broadcastFloorVM = this.this$0;
            Context context = this.$context;
            String path = this.$image.getPath();
            UploadFileType uploadFileType = UploadFileType.UPLOAD_QUOTE_PHOTO;
            this.label = 1;
            obj = broadcastFloorVM.t(context, path, uploadFileType, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
