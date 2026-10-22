package com.huachenjie.mine.page.home.work;

import com.huachenjie.works.external.bean.WorkFirstItemBean;
import com.huachenjie.works.external.utils.WorksUtils;
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
@DebugMetadata(c = "com.huachenjie.mine.page.home.work.MyWorksVM$refreshList$2", f = "MyWorksVM.kt", i = {1}, l = {77, 81}, m = "invokeSuspend", n = {"draftSize"}, s = {"I$0"})
public final class MyWorksVM$refreshList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ MyWorksVM this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyWorksVM$refreshList$2(MyWorksVM myWorksVM, Continuation<? super MyWorksVM$refreshList$2> continuation) {
        super(2, continuation);
        this.this$0 = myWorksVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyWorksVM$refreshList$2(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 != 0) {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                ResultKt.throwOnFailure(obj);
            }
            str = (String) obj;
            if (str == null) {
                str = "";
            }
            WorkFirstItemBean workFirstItemBean = new WorkFirstItemBean();
            workFirstItemBean.setWorkSize(i);
            workFirstItemBean.getCoverImg().setPath(str);
            this.this$0.B(workFirstItemBean);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        WorksUtils worksUtils = WorksUtils.f37135a;
        this.label = 1;
        obj = worksUtils.b(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        int iIntValue = ((Number) obj).intValue();
        if (iIntValue <= 0) {
            MyWorksVM.C(this.this$0, null, 1, null);
        } else {
            WorksUtils worksUtils2 = WorksUtils.f37135a;
            this.I$0 = iIntValue;
            this.label = 2;
            Object objC = worksUtils2.c(this);
            if (objC == coroutine_suspended) {
                return coroutine_suspended;
            }
            i = iIntValue;
            obj = objC;
            str = (String) obj;
            if (str == null) {
                str = "";
            }
            WorkFirstItemBean workFirstItemBean2 = new WorkFirstItemBean();
            workFirstItemBean2.setWorkSize(i);
            workFirstItemBean2.getCoverImg().setPath(str);
            this.this$0.B(workFirstItemBean2);
        }
        return Unit.INSTANCE;
    }
}
