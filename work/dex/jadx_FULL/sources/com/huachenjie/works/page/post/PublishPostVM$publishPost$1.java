package com.huachenjie.works.page.post;

import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.post.PublishPostVM$publishPost$1", f = "PublishPostVM.kt", i = {0}, l = {83}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class PublishPostVM$publishPost$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PublishPostActivity $activity;
    final /* synthetic */ int $selTagIndex;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PublishPostVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.post.PublishPostVM$publishPost$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.post.PublishPostVM$publishPost$1$1", f = "PublishPostVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PublishPostVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PublishPostVM publishPostVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = publishPostVM;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.c();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishPostVM$publishPost$1(PublishPostActivity publishPostActivity, PublishPostVM publishPostVM, int i, Continuation<? super PublishPostVM$publishPost$1> continuation) {
        super(2, continuation);
        this.$activity = publishPostActivity;
        this.this$0 = publishPostVM;
        this.$selTagIndex = i;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PublishPostVM$publishPost$1 publishPostVM$publishPost$1 = new PublishPostVM$publishPost$1(this.$activity, this.this$0, this.$selTagIndex, continuation);
        publishPostVM$publishPost$1.L$0 = obj;
        return publishPostVM$publishPost$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) throws InterruptedException {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            List<PubWorkMediaData> listV0 = this.$activity.v0();
            if (!listV0.isEmpty()) {
                PublishPostVM publishPostVM = this.this$0;
                PublishPostActivity publishPostActivity = this.$activity;
                this.L$0 = coroutineScope2;
                this.label = 1;
                Object objY = publishPostVM.y(publishPostActivity, listV0, this);
                if (objY == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
                obj = objY;
            } else {
                this.this$0.w(this.$selTagIndex, null);
            }
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(obj);
        coroutineScope = coroutineScope3;
        List list = (List) obj;
        List list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        }
        if (z) {
            v41.e(coroutineScope, jo2.e(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        this.this$0.w(this.$selTagIndex, list);
        return Unit.INSTANCE;
    }
}
