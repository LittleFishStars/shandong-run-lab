package com.huachenjie.works.page.publish;

import com.huachenjie.works.database.PublicWorkDatabase;
import com.huachenjie.works.database.PublicWorkDraft;
import com.zj.adlib.jo2;
import com.zj.adlib.v41;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$2", f = "PublishWorkViewModel.kt", i = {0}, l = {104}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class PublishWorkViewModel$updateDraft$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ PublishWorkActivity $context;
    final /* synthetic */ int $type;
    final /* synthetic */ PublicWorkDraft $workDraft;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PublishWorkViewModel this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$2$1", f = "PublishWorkViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PublishWorkActivity $context;
        final /* synthetic */ int $type;
        final /* synthetic */ PublicWorkDraft $workDraft;
        int label;
        final /* synthetic */ PublishWorkViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PublishWorkViewModel publishWorkViewModel, PublishWorkActivity publishWorkActivity, int i, PublicWorkDraft publicWorkDraft, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = publishWorkViewModel;
            this.$context = publishWorkActivity;
            this.$type = i;
            this.$workDraft = publicWorkDraft;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$context, this.$type, this.$workDraft, continuation);
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
            this.this$0.L(this.$context, this.$type, this.$workDraft);
            if (this.$workDraft.getIsNewWork()) {
                this.$workDraft.setId(PublicWorkDatabase.INSTANCE.getPublicWorkDao().insertWork(this.$workDraft));
                this.$workDraft.setNewWork(false);
            } else {
                PublicWorkDatabase.INSTANCE.getPublicWorkDao().updateWork(this.$workDraft);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.publish.PublishWorkViewModel$updateDraft$2$2", f = "PublishWorkViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $callback;
        int label;
        final /* synthetic */ PublishWorkViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(PublishWorkViewModel publishWorkViewModel, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = publishWorkViewModel;
            this.$callback = function0;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$callback, continuation);
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
            this.this$0.H();
            this.$callback.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PublishWorkViewModel$updateDraft$2(PublishWorkViewModel publishWorkViewModel, PublishWorkActivity publishWorkActivity, int i, PublicWorkDraft publicWorkDraft, Function0<Unit> function0, Continuation<? super PublishWorkViewModel$updateDraft$2> continuation) {
        super(2, continuation);
        this.this$0 = publishWorkViewModel;
        this.$context = publishWorkActivity;
        this.$type = i;
        this.$workDraft = publicWorkDraft;
        this.$callback = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PublishWorkViewModel$updateDraft$2 publishWorkViewModel$updateDraft$2 = new PublishWorkViewModel$updateDraft$2(this.this$0, this.$context, this.$type, this.$workDraft, this.$callback, continuation);
        publishWorkViewModel$updateDraft$2.L$0 = obj;
        return publishWorkViewModel$updateDraft$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$context, this.$type, this.$workDraft, null);
            this.L$0 = coroutineScope2;
            this.label = 1;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope = coroutineScope2;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            coroutineScope = coroutineScope3;
        }
        v41.e(coroutineScope, jo2.e(), (CoroutineStart) null, new AnonymousClass2(this.this$0, this.$callback, null), 2, (Object) null);
        return Unit.INSTANCE;
    }
}
