package com.huachenjie.mine.page.dressing_table.avatar_frame;

import com.huachenjie.mine.api.RequestModel;
import com.huachenjie.mine.bean.AvatarFrameBean;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.mine.page.dressing_table.avatar_frame.AvatarFrameVM$unlockAvatarFrame$1", f = "AvatarFrameVM.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
public final class AvatarFrameVM$unlockAvatarFrame$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AvatarFrameBean $item;
    int label;
    final /* synthetic */ AvatarFrameVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarFrameVM$unlockAvatarFrame$1(AvatarFrameBean avatarFrameBean, AvatarFrameVM avatarFrameVM, Continuation<? super AvatarFrameVM$unlockAvatarFrame$1> continuation) {
        super(2, continuation);
        this.$item = avatarFrameBean;
        this.this$0 = avatarFrameVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AvatarFrameVM$unlockAvatarFrame$1(this.$item, this.this$0, continuation);
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
            RequestModel requestModel = RequestModel.f35285a;
            String metaversePhotoFrameCode = this.$item.getMetaversePhotoFrameCode();
            this.label = 1;
            if (requestModel.L(metaversePhotoFrameCode, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        AvatarFrameAdapter value = this.this$0.k().getValue();
        if (value != null) {
            value.g(this.$item);
        }
        this.this$0.m().setValue(this.$item);
        return Unit.INSTANCE;
    }
}
