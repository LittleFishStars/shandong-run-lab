package com.huachenjie.home.util;

import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.CompleteTaskBean;
import com.zj.adlib.pm1;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lcom/zj/adlib/pm1;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.util.TasksUtil$requestCompleteTask$1", f = "TasksUtil.kt", i = {}, l = {WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_NOTIFY_UNLIKE, 437}, m = "invokeSuspend", n = {}, s = {})
public final class TasksUtil$requestCompleteTask$1 extends SuspendLambda implements Function2<pm1, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<List<String>, Unit> $block;
    final /* synthetic */ String $taskConfigNo;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TasksUtil$requestCompleteTask$1(String str, Function1<? super List<String>, Unit> function1, Continuation<? super TasksUtil$requestCompleteTask$1> continuation) {
        super(2, continuation);
        this.$taskConfigNo = str;
        this.$block = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TasksUtil$requestCompleteTask$1(this.$taskConfigNo, this.$block, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull pm1 pm1Var, @Nullable Continuation<? super Unit> continuation) {
        return create(pm1Var, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CompleteTaskBean completeTaskBean;
        List<String> taskNoList;
        List<String> list;
        Function1<List<String>, Unit> function1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            completeTaskBean = (CompleteTaskBean) obj;
            if (completeTaskBean != null) {
                taskNoList = completeTaskBean.getTaskNoList();
            } else {
                taskNoList = null;
            }
            list = taskNoList;
            if (list != null && !list.isEmpty()) {
                z = false;
            }
            if (z) {
                return Unit.INSTANCE;
            }
            function1 = this.$block;
            if (function1 != null) {
                Intrinsics.checkNotNull(completeTaskBean);
                function1.invoke(completeTaskBean.getTaskNoList());
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        HomeRequest homeRequest = HomeRequest.f34197a;
        this.label = 1;
        obj = homeRequest.w(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        String str = (String) obj;
        if (str == null) {
            return Unit.INSTANCE;
        }
        HomeRequest homeRequest2 = HomeRequest.f34197a;
        List<String> listListOf = CollectionsKt.listOf(this.$taskConfigNo);
        this.label = 2;
        obj = homeRequest2.A(listListOf, str, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        completeTaskBean = (CompleteTaskBean) obj;
        if (completeTaskBean != null) {
            taskNoList = completeTaskBean.getTaskNoList();
        } else {
            taskNoList = null;
        }
        list = taskNoList;
        if (list != null) {
            z = false;
        }
        if (z) {
            return Unit.INSTANCE;
        }
        function1 = this.$block;
        if (function1 != null) {
            Intrinsics.checkNotNull(completeTaskBean);
            function1.invoke(completeTaskBean.getTaskNoList());
        }
        return Unit.INSTANCE;
    }
}
