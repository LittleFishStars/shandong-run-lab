package com.huachenjie.mall.page.test;

import com.huachenjie.mall.api.MallModel;
import huachenjie.sdk.http.PageEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.huachenjie.mall.page.test.TestPlayVM$queryPageList$1", f = "TestPlayVM.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
public final class TestPlayVM$queryPageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestPlayVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestPlayVM$queryPageList$1(TestPlayVM testPlayVM, Continuation<? super TestPlayVM$queryPageList$1> continuation) {
        super(2, continuation);
        this.this$0 = testPlayVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TestPlayVM$queryPageList$1(this.this$0, continuation);
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
            MallModel mallModel = MallModel.f34763a;
            this.label = 1;
            obj = mallModel.g0(1, "", "", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null) {
            pageEntity = new PageEntity();
            pageEntity.setList(CollectionsKt.emptyList());
            pageEntity.setHasNext(false);
        }
        if (pageEntity.getList().size() >= 3) {
            this.this$0.l().setValue(pageEntity.getList().get(2));
            this.this$0.n(2);
        }
        TestVideoAdapter value = this.this$0.j().getValue();
        if (value != null) {
            value.setList(pageEntity.getList());
        }
        return Unit.INSTANCE;
    }
}
