package com.huachenjie.home.dialog.task;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Lifecycle;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.bean.DailyTasksProgressBean;
import com.huachenjie.home.databinding.HomeFragmentTaskListBinding;
import com.huachenjie.home.dialog.task.TaskListFragment;
import com.huachenjie.home.util.TasksUtil;
import com.zj.adlib.xk0;
import com.zj.adlib.y57;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\u0007¢\u0006\u0004\b)\u0010*J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0018J\u001e\u0010\u001b\u001a\u00020\u00042\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0017j\b\u0012\u0004\u0012\u00020\u0006`\u0018J\b\u0010\u001c\u001a\u00020\u0004H\u0016R\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001fR\u001b\u0010%\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentTaskListBinding;", "Lcom/huachenjie/home/dialog/task/TaskListFragmentVM;", "", "initAdapter", "Lcom/huachenjie/home/bean/DailyTasksBean;", "item", "", "position", "goCompleteTask", "receiveTaskReward", "Landroidx/fragment/app/FragmentManager;", "dialogFragmentManager", "dismissParentDialog", "", "", "getVariables", "getLayoutResID", "initView", "initData", "onDestroyView", "reloadData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListData", "list", "updateListData", "initDataObservable", "", "hasInitData", "Z", "backFromAd", "limit$delegate", "Lkotlin/Lazy;", "getLimit", "()I", TaskListFragment.KEY_LIMIT, "Lkotlin/Function1;", "onSizeChange", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class TaskListFragment extends BaseMVVMFragment<HomeFragmentTaskListBinding, TaskListFragmentVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_LIMIT = "limit";

    @NotNull
    private static final String KEY_LIST = "list";
    private boolean backFromAd;
    private boolean hasInitData;

    /* JADX INFO: renamed from: limit$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy limit = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.home.dialog.task.TaskListFragment$limit$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m403invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("limit") : -1);
        }
    });

    @Nullable
    private Function1<? super Integer, Unit> onSizeChange;

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.task.TaskListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JF\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListFragment$a;", "", "", TaskListFragment.KEY_LIMIT, "Ljava/util/ArrayList;", "Lcom/huachenjie/home/bean/DailyTasksBean;", "Lkotlin/collections/ArrayList;", "list", "Lkotlin/Function1;", "", "onSizeChange", "Lcom/huachenjie/home/dialog/task/TaskListFragment;", "a", "", "KEY_LIMIT", "Ljava/lang/String;", "KEY_LIST", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TaskListFragment b(Companion companion, int i, ArrayList arrayList, Function1 function1, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = -1;
            }
            if ((i2 & 2) != 0) {
                arrayList = null;
            }
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            return companion.a(i, arrayList, function1);
        }

        @NotNull
        public final TaskListFragment a(int limit, @Nullable ArrayList<DailyTasksBean> list, @Nullable Function1<? super Integer, Unit> onSizeChange) {
            TaskListFragment taskListFragment = new TaskListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(TaskListFragment.KEY_LIMIT, limit);
            bundle.putParcelableArrayList("list", list);
            taskListFragment.setArguments(bundle);
            taskListFragment.onSizeChange = onSizeChange;
            return taskListFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f34327a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f34327a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f34327a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f34327a.invoke(obj);
        }
    }

    public static final /* synthetic */ TaskListFragmentVM access$getMViewModel(TaskListFragment taskListFragment) {
        return taskListFragment.getMViewModel();
    }

    private final FragmentManager dialogFragmentManager() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof DialogFragment) {
            FragmentManager parentFragmentManager = ((DialogFragment) parentFragment).getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragment.parentFragmentManager");
            return parentFragmentManager;
        }
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        return parentFragmentManager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissParentDialog() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof DialogFragment) {
            ((DialogFragment) parentFragment).dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getLimit() {
        return ((Number) this.limit.getValue()).intValue();
    }

    private final void goCompleteTask(final DailyTasksBean item, final int position) {
        TasksUtil tasksUtil = TasksUtil.f34372a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        Lifecycle lifecycle = getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, RequestParameters.SUBRESOURCE_LIFECYCLE);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        tasksUtil.e(contextRequireContext, lifecycle, childFragmentManager, dialogFragmentManager(), getMViewModel(), item, new Function2<Boolean, String, Unit>() { // from class: com.huachenjie.home.dialog.task.TaskListFragment.goCompleteTask.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Boolean) obj).booleanValue(), (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z, @Nullable String str) {
                int taskType = item.getTaskType();
                if (taskType != 2 && taskType != 7 && taskType != 9) {
                    this.dismissParentDialog();
                    return;
                }
                if (z) {
                    DailyTasksBean dailyTasksBean = item;
                    Intrinsics.checkNotNull(str);
                    dailyTasksBean.setTaskNo(str);
                    DailyTasksProgressBean progress = item.getProgress();
                    progress.setCompletedCount(progress.getCompletedCount() + 1);
                    item.setStatus(1);
                    TaskListAdapter value = TaskListFragment.access$getMViewModel(this).i().getValue();
                    if (value != null) {
                        value.notifyItemChanged(position);
                    }
                }
            }
        });
    }

    private final void initAdapter() {
        MutableLiveData<TaskListAdapter> mutableLiveDataI = getMViewModel().i();
        final TaskListAdapter taskListAdapter = new TaskListAdapter();
        taskListAdapter.addChildClickViewIds(R.id.tv_finish);
        y57.b(taskListAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.d19
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                TaskListFragment.initAdapter$lambda$1$lambda$0(taskListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(taskListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(TaskListAdapter taskListAdapter, TaskListFragment taskListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(taskListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(taskListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        DailyTasksBean item = taskListAdapter.getItem(i);
        if (item.getStatus() == 0) {
            taskListFragment.goCompleteTask(item, i);
        } else if (item.getStatus() == 1) {
            taskListFragment.receiveTaskReward(item, i);
        }
    }

    private final void receiveTaskReward(final DailyTasksBean item, final int position) {
        TasksUtil tasksUtil = TasksUtil.f34372a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        TaskListFragmentVM mViewModel = getMViewModel();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        tasksUtil.h(contextRequireContext, mViewModel, childFragmentManager, item, new Function1<Boolean, Unit>() { // from class: com.huachenjie.home.dialog.task.TaskListFragment.receiveTaskReward.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                TaskListFragment.this.backFromAd = z;
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.home.dialog.task.TaskListFragment.receiveTaskReward.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m404invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m404invoke() {
                int taskFrequency = item.getTaskFrequency();
                if (taskFrequency == 1) {
                    ArrayList<DailyTasksBean> value = TaskListFragment.access$getMViewModel(this).j().getValue();
                    if (value != null) {
                        value.remove(position);
                    }
                    TaskListFragment.access$getMViewModel(this).j().setValue(TaskListFragment.access$getMViewModel(this).j().getValue());
                    return;
                }
                if (taskFrequency != 2) {
                    return;
                }
                if (item.getProgress().getCompletedCount() >= item.getProgress().getMaxCompleteCount()) {
                    item.setStatus(2);
                } else {
                    item.setStatus(0);
                }
                if (item.getTaskType() == 8) {
                    item.setLocalOnceProgress(0);
                }
                TaskListAdapter value2 = TaskListFragment.access$getMViewModel(this).i().getValue();
                if (value2 != null) {
                    value2.notifyItemChanged(position);
                }
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_task_list;
    }

    @Nullable
    public final ArrayList<DailyTasksBean> getListData() {
        return getMViewModel().j().getValue();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        Bundle arguments = getArguments();
        ArrayList<DailyTasksBean> parcelableArrayList = arguments != null ? arguments.getParcelableArrayList("list") : null;
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            getMViewModel().k();
        } else {
            getMViewModel().j().setValue(parcelableArrayList);
        }
        this.hasInitData = true;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().j().observe(this, new b(new Function1<ArrayList<DailyTasksBean>, Unit>() { // from class: com.huachenjie.home.dialog.task.TaskListFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ArrayList<DailyTasksBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ArrayList<DailyTasksBean> arrayList) {
                if (arrayList == null) {
                    return;
                }
                if (TaskListFragment.this.getLimit() <= 0 || arrayList.size() <= TaskListFragment.this.getLimit()) {
                    TaskListAdapter value = TaskListFragment.access$getMViewModel(TaskListFragment.this).i().getValue();
                    if (value != null) {
                        value.setList(arrayList);
                    }
                } else {
                    TaskListAdapter value2 = TaskListFragment.access$getMViewModel(TaskListFragment.this).i().getValue();
                    if (value2 != null) {
                        value2.setList(arrayList.subList(0, TaskListFragment.this.getLimit()));
                    }
                }
                Function1 function1 = TaskListFragment.this.onSizeChange;
                if (function1 != null) {
                    function1.invoke(Integer.valueOf(arrayList.size()));
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.hasInitData = false;
        super.onDestroyView();
    }

    public final void reloadData() {
        if (this.hasInitData) {
            if (this.backFromAd) {
                this.backFromAd = false;
            } else {
                getMViewModel().k();
            }
        }
    }

    public final void updateListData(@NotNull ArrayList<DailyTasksBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        getMViewModel().j().setValue(list);
    }
}
