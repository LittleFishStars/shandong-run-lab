package com.huachenjie.sport.page.mine.choose_classes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.coroutines.ViewDataBinding;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.PEClassBean;
import com.huachenjie.sport.databinding.FragmentChooseClassesBinding;
import com.huachenjie.sport.page.mine.choose_classes.ChooseClassesFragment;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.i)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/sport/page/mine/choose_classes/ChooseClassesVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "view", "onViewCreated", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "activityLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ChooseClassesFragment extends BaseVMFragment<ChooseClassesVM> {

    @Nullable
    private ActivityResultLauncher<Intent> activityLauncher;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(ChooseClassesFragment chooseClassesFragment, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(chooseClassesFragment, "this$0");
        if (activityResult == null || activityResult.getResultCode() != -1 || activityResult.getData() == null) {
            return;
        }
        Intent data = activityResult.getData();
        Intrinsics.checkNotNull(data);
        if (data.getBooleanExtra("ChooseSuccess", false)) {
            ((ChooseClassesVM) ((BaseVMFragment) chooseClassesFragment).mState).F(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(ChooseClassesFragment chooseClassesFragment) {
        Intrinsics.checkNotNullParameter(chooseClassesFragment, "this$0");
        ((ChooseClassesVM) ((BaseVMFragment) chooseClassesFragment).mState).F(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(ChooseClassesFragment chooseClassesFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseClassesFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        List data = baseQuickAdapter.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.huachenjie.sport.bean.PEClassBean>");
        String courseCode = ((PEClassBean) data.get(i)).getCourseCode();
        Intent intent = new Intent(chooseClassesFragment.getContext(), (Class<?>) ClassesDetailActivity.class);
        intent.putExtra("code", courseCode);
        ChooseClassesAdapter value = ((ChooseClassesVM) ((BaseVMFragment) chooseClassesFragment).mState).j().getValue();
        if (value != null) {
            intent.putExtra(ClassesDetailActivity.y, value.getType() == 2);
        }
        ActivityResultLauncher<Intent> activityResultLauncher = chooseClassesFragment.activityLauncher;
        if (activityResultLauncher != null) {
            activityResultLauncher.launch(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(ChooseClassesFragment chooseClassesFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(chooseClassesFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.tv_reselect_courses) {
            List data = baseQuickAdapter.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.huachenjie.sport.bean.PEClassBean>");
            String courseCode = ((PEClassBean) data.get(i)).getCourseCode();
            if (courseCode == null) {
                courseCode = "";
            }
            ((ChooseClassesVM) ((BaseVMFragment) chooseClassesFragment).mState).l(courseCode);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        ((BaseVMFragment) this).mState = (Q) getActivityScopeViewModel(ChooseClassesVM.class);
        return new i62(Integer.valueOf(R.layout.fragment_choose_classes), Integer.valueOf(ok0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        this.activityLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.jk1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ChooseClassesFragment.init$lambda$0(this.f42605a, (ActivityResult) obj);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        BaseLoadMoreModule loadMoreModule;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentChooseClassesBinding");
        ((FragmentChooseClassesBinding) binding).f36471a.onRefresh(new Function2<StateLayout, Object, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ChooseClassesFragment.onViewCreated.1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StateLayout) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull StateLayout stateLayout, @Nullable Object obj) {
                Intrinsics.checkNotNullParameter(stateLayout, "$this$onRefresh");
                if (((ChooseClassesVM) ((BaseVMFragment) ChooseClassesFragment.this).mState).getSearchType() == 2) {
                    ((ChooseClassesVM) ((BaseVMFragment) ChooseClassesFragment.this).mState).F(true);
                } else if (!((ChooseClassesVM) ((BaseVMFragment) ChooseClassesFragment.this).mState).w().isEmpty()) {
                    ((ChooseClassesVM) ((BaseVMFragment) ChooseClassesFragment.this).mState).F(true);
                } else {
                    ((ChooseClassesVM) ((BaseVMFragment) ChooseClassesFragment.this).mState).G();
                }
            }
        });
        ChooseClassesAdapter value = ((ChooseClassesVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value != null && (loadMoreModule = value.getLoadMoreModule()) != null) {
            loadMoreModule.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.gk1
                @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
                public final void onLoadMore() {
                    ChooseClassesFragment.onViewCreated$lambda$1(this.f41925a);
                }
            });
        }
        ChooseClassesAdapter value2 = ((ChooseClassesVM) ((BaseVMFragment) this).mState).j().getValue();
        if (value2 != null) {
            value2.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.hk1
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                    ChooseClassesFragment.onViewCreated$lambda$3(this.f42142a, baseQuickAdapter, view2, i);
                }
            });
        }
        if (((ChooseClassesVM) ((BaseVMFragment) this).mState).getSearchType() == 2) {
            ChooseClassesAdapter value3 = ((ChooseClassesVM) ((BaseVMFragment) this).mState).j().getValue();
            if (value3 != null) {
                value3.addChildClickViewIds(R.id.tv_reselect_courses);
            }
            ChooseClassesAdapter value4 = ((ChooseClassesVM) ((BaseVMFragment) this).mState).j().getValue();
            if (value4 != null) {
                value4.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ik1
                    @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
                    public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                        ChooseClassesFragment.onViewCreated$lambda$4(this.f42375a, baseQuickAdapter, view2, i);
                    }
                });
            }
        }
    }
}
