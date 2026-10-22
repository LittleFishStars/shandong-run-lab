package com.huachenjie.home.dialog.task;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.ad.util.OAIDUtil;
import com.huachenjie.base.app_widget.InspirationWidget;
import com.huachenjie.home.api.HomeRequest;
import com.huachenjie.home.bean.BrowseGoodsDetailBean;
import com.huachenjie.home.bean.CompleteTaskBean;
import com.huachenjie.home.bean.DailyTasksActionBean;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.DailyTasksProgressBean;
import com.huachenjie.home.util.TasksUtil;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.zj.adlib.jo2;
import com.zj.adlib.jr8;
import com.zj.adlib.s72;
import com.zj.adlib.t47;
import com.zj.adlib.v41;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.huachenjie.home.dialog.task.TaskListFragmentVM$loadData$1", f = "TaskListFragmentVM.kt", i = {1}, l = {34, 35}, m = "invokeSuspend", n = {GoodsSpecificationPreviewActivity.z}, s = {"L$0"})
public final class TaskListFragmentVM$loadData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TaskListFragmentVM this$0;

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.task.TaskListFragmentVM$loadData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.huachenjie.home.dialog.task.TaskListFragmentVM$loadData$1$1", f = "TaskListFragmentVM.kt", i = {0, 0, 1, 1}, l = {105, 106}, m = "invokeSuspend", n = {"checkList", "taskConfigNoList", "checkList", "taskConfigNoList"}, s = {"L$0", "L$1", "L$0", "L$1"})
    @SourceDebugExtension({"SMAP\nTaskListFragmentVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskListFragmentVM.kt\ncom/huachenjie/home/dialog/task/TaskListFragmentVM$loadData$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,123:1\n1549#2:124\n1620#2,3:125\n*S KotlinDebug\n*F\n+ 1 TaskListFragmentVM.kt\ncom/huachenjie/home/dialog/task/TaskListFragmentVM$loadData$1$1\n*L\n102#1:124\n102#1:125,3\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<DailyTasksBean> $list;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ArrayList<DailyTasksBean> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean invokeSuspend$lambda$0(Function1 function1, Object obj) {
            return ((Boolean) function1.invoke(obj)).booleanValue();
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:106:0x01c3  */
        /* JADX WARN: Code duplicated, block: B:108:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:121:0x01d8 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:54:0x00da  */
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            List<DailyTasksBean> arrayList;
            List<String> list;
            List<String> list2;
            List list3;
            String threshold;
            int browseCount;
            int iB;
            String threshold2;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            CompleteTaskBean completeTaskBean = null;
            int i2 = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!jr8.f17466a.d()) {
                    ArrayList<DailyTasksBean> arrayList2 = this.$list;
                    final C08041 c08041 = new Function1<DailyTasksBean, Boolean>() { // from class: com.huachenjie.home.dialog.task.TaskListFragmentVM.loadData.1.1.1
                        @NotNull
                        public final Boolean invoke(DailyTasksBean dailyTasksBean) {
                            return Boolean.valueOf(dailyTasksBean.getTaskType() == 5);
                        }
                    };
                    arrayList2.removeIf(new Predicate() { // from class: com.huachenjie.home.dialog.task.a
                        @Override // java.util.function.Predicate
                        public final boolean test(Object obj2) {
                            return TaskListFragmentVM$loadData$1.AnonymousClass1.invokeSuspend$lambda$0(c08041, obj2);
                        }
                    });
                }
                arrayList = new ArrayList();
                for (DailyTasksBean dailyTasksBean : this.$list) {
                    int taskType = dailyTasksBean.getTaskType();
                    if (taskType != 1) {
                        if (taskType != 2) {
                            if (taskType == 5) {
                                jr8 jr8Var = jr8.f17466a;
                                Application applicationA = Utils.a();
                                Intrinsics.checkNotNullExpressionValue(applicationA, "getApp()");
                                if (jr8Var.c(applicationA)) {
                                    Application applicationA2 = Utils.a();
                                    Intrinsics.checkNotNullExpressionValue(applicationA2, "getApp()");
                                    iB = jr8Var.b(applicationA2);
                                } else {
                                    iB = 0;
                                }
                                dailyTasksBean.setLocalOnceProgress(iB);
                                if (dailyTasksBean.getStatus() == 0) {
                                    DailyTasksActionBean action = dailyTasksBean.getAction();
                                    if (iB >= ((action == null || (threshold2 = action.getThreshold()) == null) ? 0 : Integer.parseInt(threshold2))) {
                                        Intrinsics.checkNotNullExpressionValue(dailyTasksBean, "task");
                                        arrayList.add(dailyTasksBean);
                                    }
                                }
                            } else if (taskType == 8) {
                                BrowseGoodsDetailBean browseGoodsDetailBeanD = TasksUtil.f34372a.d();
                                String strC = s72.c(System.currentTimeMillis(), "yyyy-MM-dd");
                                if (!Intrinsics.areEqual(browseGoodsDetailBeanD != null ? browseGoodsDetailBeanD.getTaskConfigNo() : null, dailyTasksBean.getTaskConfigNo()) || !Intrinsics.areEqual(browseGoodsDetailBeanD.getDate(), strC)) {
                                    browseGoodsDetailBeanD = null;
                                }
                                if (dailyTasksBean.getStatus() != 0) {
                                    DailyTasksActionBean action2 = dailyTasksBean.getAction();
                                    if (action2 == null || (threshold = action2.getThreshold()) == null) {
                                        browseCount = 0;
                                    } else {
                                        browseCount = Integer.parseInt(threshold);
                                    }
                                } else if (browseGoodsDetailBeanD != null) {
                                    browseCount = browseGoodsDetailBeanD.getBrowseCount();
                                } else {
                                    browseCount = 0;
                                }
                                dailyTasksBean.setLocalOnceProgress(browseCount);
                            } else if (taskType == 100 && dailyTasksBean.getStatus() == 0 && OAIDUtil.b()) {
                                Intrinsics.checkNotNullExpressionValue(dailyTasksBean, "task");
                                arrayList.add(dailyTasksBean);
                            }
                        } else if (dailyTasksBean.getStatus() == 0 && com.huachenjie.base.app_widget.a.b(InspirationWidget.class)) {
                            Intrinsics.checkNotNullExpressionValue(dailyTasksBean, "task");
                            arrayList.add(dailyTasksBean);
                        }
                    } else if (dailyTasksBean.getStatus() == 0 && t47.d(Utils.a())) {
                        Intrinsics.checkNotNullExpressionValue(dailyTasksBean, "task");
                        arrayList.add(dailyTasksBean);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList3.add(((DailyTasksBean) it.next()).getTaskConfigNo());
                }
                if (!arrayList3.isEmpty()) {
                    try {
                        HomeRequest homeRequest = HomeRequest.f34197a;
                        this.L$0 = arrayList;
                        this.L$1 = arrayList3;
                        this.label = 1;
                        Object objW = homeRequest.w(this);
                        if (objW == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list2 = arrayList3;
                        obj = objW;
                        list3 = arrayList;
                    } catch (Exception unused) {
                        list = arrayList3;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = (List) this.L$1;
                arrayList = (List) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    completeTaskBean = (CompleteTaskBean) obj;
                } catch (Exception unused2) {
                }
                if (completeTaskBean != null && completeTaskBean.getTaskNoList().size() == list.size()) {
                    for (DailyTasksBean dailyTasksBean2 : arrayList) {
                        int i3 = i2 + 1;
                        str = (String) CollectionsKt.getOrNull(completeTaskBean.getTaskNoList(), i2);
                        if (str == null) {
                            str = "";
                        }
                        dailyTasksBean2.setTaskNo(str);
                        DailyTasksProgressBean progress = dailyTasksBean2.getProgress();
                        progress.setCompletedCount(progress.getCompletedCount() + 1);
                        dailyTasksBean2.setStatus(1);
                        i2 = i3;
                    }
                }
                return Unit.INSTANCE;
            }
            list2 = (List) this.L$1;
            list3 = (List) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception unused3) {
                list = list2;
                arrayList = list3;
            }
            String str2 = (String) obj;
            if (str2 == null) {
                str2 = "";
            }
            HomeRequest homeRequest2 = HomeRequest.f34197a;
            this.L$0 = list3;
            this.L$1 = list2;
            this.label = 2;
            obj = homeRequest2.A(list2, str2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = list2;
            arrayList = list3;
            completeTaskBean = (CompleteTaskBean) obj;
            if (completeTaskBean != null) {
                while (r14.hasNext()) {
                    int i4 = i2 + 1;
                    str = (String) CollectionsKt.getOrNull(completeTaskBean.getTaskNoList(), i2);
                    if (str == null) {
                        str = "";
                    }
                    dailyTasksBean2.setTaskNo(str);
                    DailyTasksProgressBean progress2 = dailyTasksBean2.getProgress();
                    progress2.setCompletedCount(progress2.getCompletedCount() + 1);
                    dailyTasksBean2.setStatus(1);
                    i2 = i4;
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskListFragmentVM$loadData$1(TaskListFragmentVM taskListFragmentVM, Continuation<? super TaskListFragmentVM$loadData$1> continuation) {
        super(2, continuation);
        this.this$0 = taskListFragmentVM;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new TaskListFragmentVM$loadData$1(this.this$0, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        List listEmptyList;
        ArrayList<DailyTasksBean> arrayList;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList = (ArrayList) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.j().setValue(arrayList);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        HomeRequest homeRequest = HomeRequest.f34197a;
        this.label = 1;
        obj = homeRequest.d(this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        PageEntity pageEntity = (PageEntity) obj;
        if (pageEntity == null || (listEmptyList = pageEntity.getList()) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList<DailyTasksBean> arrayList2 = new ArrayList<>(listEmptyList);
        CoroutineDispatcher coroutineDispatcherC = jo2.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(arrayList2, null);
        this.L$0 = arrayList2;
        this.label = 2;
        if (v41.h(coroutineDispatcherC, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        arrayList = arrayList2;
        this.this$0.j().setValue(arrayList);
        return Unit.INSTANCE;
    }
}
