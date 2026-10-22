package com.huachenjie.works.page.local;

import android.text.TextUtils;
import com.huachenjie.works.database.PublicWorkDatabase;
import com.huachenjie.works.database.PublicWorkDraft;
import com.huachenjie.works.utils.a;
import com.zj.adlib.jo2;
import com.zj.adlib.r90;
import com.zj.adlib.v41;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.works.page.local.LocalWorksVM$deleteWork$1", f = "LocalWorksVM.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
public final class LocalWorksVM$deleteWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PublicWorkDraft $work;
    int label;
    final /* synthetic */ LocalWorksVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.works.page.local.LocalWorksVM$deleteWork$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.works.page.local.LocalWorksVM$deleteWork$1$1", f = "LocalWorksVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nLocalWorksVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalWorksVM.kt\ncom/huachenjie/works/page/local/LocalWorksVM$deleteWork$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ PublicWorkDraft $work;
        int label;
        final /* synthetic */ LocalWorksVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PublicWorkDraft publicWorkDraft, LocalWorksVM localWorksVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$work = publicWorkDraft;
            this.this$0 = localWorksVM;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$work, this.this$0, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            String parent;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            PublicWorkDatabase.INSTANCE.getPublicWorkDao().delWork(this.$work);
            a.Companion companion = a.INSTANCE;
            companion.b(this.$work.getMediaPath());
            if (this.this$0.x().isEmpty() && TextUtils.isEmpty(r90.n()) && (parent = new File(this.$work.getMediaPath()).getParent()) != null) {
                companion.b(parent);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalWorksVM$deleteWork$1(PublicWorkDraft publicWorkDraft, LocalWorksVM localWorksVM, Continuation<? super LocalWorksVM$deleteWork$1> continuation) {
        super(2, continuation);
        this.$work = publicWorkDraft;
        this.this$0 = localWorksVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LocalWorksVM$deleteWork$1(this.$work, this.this$0, continuation);
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
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$work, this.this$0, null);
            this.label = 1;
            if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
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
