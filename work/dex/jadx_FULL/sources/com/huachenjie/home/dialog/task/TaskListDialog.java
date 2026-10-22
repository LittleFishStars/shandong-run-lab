package com.huachenjie.home.dialog.task;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMBottomDialogFragment;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.home.R;
import com.huachenjie.home.bean.DailyTasksBean;
import com.huachenjie.home.databinding.HomeDialogTaskListBinding;
import com.zj.adlib.cr2;
import com.zj.adlib.fx7;
import com.zj.adlib.xk0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMBottomDialogFragment;", "Lcom/huachenjie/home/databinding/HomeDialogTaskListBinding;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "", "initView", "Ljava/util/ArrayList;", "Lcom/huachenjie/home/bean/DailyTasksBean;", "Lkotlin/collections/ArrayList;", "getTaskList", "Lcom/huachenjie/home/dialog/task/TaskListFragment;", "taskListFragment", "Lcom/huachenjie/home/dialog/task/TaskListFragment;", "<init>", "()V", "Companion", "a", "b", "home_release"}, k = 1, mv = {1, 8, 0})
public final class TaskListDialog extends BaseMVVMBottomDialogFragment<HomeDialogTaskListBinding, BaseViewModel> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_TASK_LIST = "task_list";

    @Nullable
    private TaskListFragment taskListFragment;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/home/dialog/task/TaskListDialog;)V", "home_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            TaskListDialog.this.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.home.dialog.task.TaskListDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/dialog/task/TaskListDialog$b;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/home/bean/DailyTasksBean;", "Lkotlin/collections/ArrayList;", "listData", "Lcom/huachenjie/home/dialog/task/TaskListDialog;", "a", "", "KEY_TASK_LIST", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TaskListDialog a(@Nullable ArrayList<DailyTasksBean> listData) {
            TaskListDialog taskListDialog = new TaskListDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(TaskListDialog.KEY_TASK_LIST, listData);
            taskListDialog.setArguments(bundle);
            return taskListDialog;
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return fx7.h() - cr2.c(getContext(), 130.0f);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_dialog_task_list;
    }

    @Nullable
    public final ArrayList<DailyTasksBean> getTaskList() {
        TaskListFragment taskListFragment = this.taskListFragment;
        if (taskListFragment != null) {
            return taskListFragment.getListData();
        }
        return null;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(xk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        Bundle arguments = getArguments();
        this.taskListFragment = TaskListFragment.Companion.b(TaskListFragment.INSTANCE, 0, arguments != null ? arguments.getParcelableArrayList(KEY_TASK_LIST) : null, null, 5, null);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        int i = R.id.fl_task_list;
        TaskListFragment taskListFragment = this.taskListFragment;
        Intrinsics.checkNotNull(taskListFragment);
        fragmentTransactionBeginTransaction.replace(i, taskListFragment).commit();
    }
}
