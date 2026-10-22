package com.huachenjie.mine.page.home.work;

import com.huachenjie.works.external.adapter.WorksAdapter;
import com.huachenjie.works.external.bean.WorkFirstItemBean;
import com.huachenjie.works.external.bean.WorkItemBean;
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
@DebugMetadata(c = "com.huachenjie.mine.page.home.work.MyWorksVM$queryDraftSize$2", f = "MyWorksVM.kt", i = {1}, l = {41, 42}, m = "invokeSuspend", n = {"draftSize"}, s = {"I$0"})
public final class MyWorksVM$queryDraftSize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WorksAdapter $adapter;
    int I$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MyWorksVM$queryDraftSize$2(WorksAdapter worksAdapter, Continuation<? super MyWorksVM$queryDraftSize$2> continuation) {
        super(2, continuation);
        this.$adapter = worksAdapter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MyWorksVM$queryDraftSize$2(this.$adapter, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0071  */
    /* JADX WARN: Code duplicated, block: B:31:0x0074 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0076  */
    /* JADX WARN: Code duplicated, block: B:33:0x0092  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        int i;
        String str;
        boolean z;
        boolean z2;
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
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            z2 = !(this.$adapter.getData().isEmpty() ^ true) && ((WorkItemBean) this.$adapter.getData().get(0)).getPostType() == 2;
            if (z) {
                if (z2) {
                    WorkItemBean workItemBean = (WorkItemBean) this.$adapter.getData().get(0);
                    workItemBean.setWorkSize(i);
                    workItemBean.getCoverImg().setPath(str);
                    this.$adapter.notifyItemChanged(0);
                } else {
                    WorkFirstItemBean workFirstItemBean = new WorkFirstItemBean();
                    workFirstItemBean.setWorkSize(i);
                    workFirstItemBean.getCoverImg().setPath(str);
                    this.$adapter.getData().add(0, workFirstItemBean);
                    this.$adapter.notifyDataSetChanged();
                }
            } else if (z2) {
                this.$adapter.removeAt(0);
                if (this.$adapter.getData().isEmpty()) {
                    this.$adapter.r();
                }
            }
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
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.$adapter.getData().isEmpty() ^ true) {
        }
        if (z) {
            if (z2) {
                WorkItemBean workItemBean2 = (WorkItemBean) this.$adapter.getData().get(0);
                workItemBean2.setWorkSize(i);
                workItemBean2.getCoverImg().setPath(str);
                this.$adapter.notifyItemChanged(0);
            } else {
                WorkFirstItemBean workFirstItemBean2 = new WorkFirstItemBean();
                workFirstItemBean2.setWorkSize(i);
                workFirstItemBean2.getCoverImg().setPath(str);
                this.$adapter.getData().add(0, workFirstItemBean2);
                this.$adapter.notifyDataSetChanged();
            }
        } else if (z2) {
            this.$adapter.removeAt(0);
            if (this.$adapter.getData().isEmpty()) {
                this.$adapter.r();
            }
        }
        return Unit.INSTANCE;
    }
}
