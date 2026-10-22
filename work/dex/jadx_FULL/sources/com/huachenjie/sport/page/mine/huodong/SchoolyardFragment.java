package com.huachenjie.sport.page.mine.huodong;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.HuodongBean;
import com.huachenjie.sport.databinding.FragmentSchoolyardBinding;
import com.huachenjie.sport.page.mine.huodong.SchoolyardFragment;
import com.igexin.push.g.o;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001b\u0010\u0016\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/sport/page/mine/huodong/SchoolyardVM;", "", "initList", "refreshData", "Lcom/huachenjie/sport/page/mine/huodong/SchoolyardAdapter;", "adapter", "initLoadMore", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "init", "onResume", "", "isMy$delegate", "Lkotlin/Lazy;", SchoolyardFragment.KEY_IS_MY, "()Z", "hasLoadData", "Z", "<init>", "()V", "Companion", "a", "b", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolyardFragment extends BaseVMFragment<SchoolyardVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_IS_MY = "isMy";
    private boolean hasLoadData;

    /* JADX INFO: renamed from: isMy$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isMy = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.sport.page.mine.huodong.SchoolyardFragment.isMy.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m782invoke() {
            Bundle arguments = SchoolyardFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(SchoolyardFragment.KEY_IS_MY) : false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.huodong.SchoolyardFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardFragment$a;", "", "", SchoolyardFragment.KEY_IS_MY, "Lcom/huachenjie/sport/page/mine/huodong/SchoolyardFragment;", "a", "", "KEY_IS_MY", "Ljava/lang/String;", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SchoolyardFragment a(boolean isMy) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(SchoolyardFragment.KEY_IS_MY, isMy);
            SchoolyardFragment schoolyardFragment = new SchoolyardFragment();
            schoolyardFragment.setArguments(bundle);
            return schoolyardFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardFragment$b;", "", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/huodong/SchoolyardFragment;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class b {
        public b() {
        }

        public final void a() {
            ((SchoolyardVM) ((BaseVMFragment) SchoolyardFragment.this).mState).p(1);
            ((SchoolyardVM) ((BaseVMFragment) SchoolyardFragment.this).mState).o(SchoolyardFragment.this.isMy());
        }
    }

    private final void initList() {
        SchoolyardAdapter schoolyardAdapter = new SchoolyardAdapter();
        ((SchoolyardVM) ((BaseVMFragment) this).mState).h().setValue(schoolyardAdapter);
        initLoadMore(schoolyardAdapter);
        schoolyardAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.fw7
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SchoolyardFragment.initList$lambda$1(this.f41771a, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initList$lambda$1(SchoolyardFragment schoolyardFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(schoolyardFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        List data = baseQuickAdapter.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.huachenjie.sport.bean.HuodongBean>");
        FragmentActivity activity = schoolyardFragment.getActivity();
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) HuodongDetailActivity.class);
            if ((!data.isEmpty()) && data.get(i) != null) {
                intent.putExtra("activityCode", ((HuodongBean) data.get(i)).getActivityCode());
                intent.putExtra("title", ((HuodongBean) data.get(i)).getActivityTitle());
            }
            activity.startActivity(intent);
        }
    }

    private final void initLoadMore(SchoolyardAdapter adapter) {
        adapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.gw7
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                SchoolyardFragment.initLoadMore$lambda$2(this.f42002a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoadMore$lambda$2(SchoolyardFragment schoolyardFragment) {
        Intrinsics.checkNotNullParameter(schoolyardFragment, "this$0");
        SchoolyardVM schoolyardVM = (SchoolyardVM) ((BaseVMFragment) schoolyardFragment).mState;
        schoolyardVM.p(schoolyardVM.getIndex() + 1);
        ((SchoolyardVM) ((BaseVMFragment) schoolyardFragment).mState).o(schoolyardFragment.isMy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMy() {
        return ((Boolean) this.isMy.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshData() {
        ((SchoolyardVM) ((BaseVMFragment) this).mState).p(1);
        ((SchoolyardVM) ((BaseVMFragment) this).mState).m().setValue(Boolean.TRUE);
        ((SchoolyardVM) ((BaseVMFragment) this).mState).o(isMy());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.fragment_schoolyard), Integer.valueOf(ok0.p0), ((BaseVMFragment) this).mState).a(Integer.valueOf(ok0.R), new b());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…am(BR.refresh, Refresh())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        initList();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hasLoadData) {
            return;
        }
        this.hasLoadData = true;
        refreshData();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentSchoolyardBinding");
        FragmentSchoolyardBinding fragmentSchoolyardBinding = (FragmentSchoolyardBinding) binding;
        fragmentSchoolyardBinding.f36481a.onRefresh(new Function2<StateLayout, Object, Unit>() { // from class: com.huachenjie.sport.page.mine.huodong.SchoolyardFragment.onViewCreated.1
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((StateLayout) obj, obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull StateLayout stateLayout, @Nullable Object obj) {
                Intrinsics.checkNotNullParameter(stateLayout, "$this$onRefresh");
                ((SchoolyardVM) ((BaseVMFragment) SchoolyardFragment.this).mState).p(1);
                ((SchoolyardVM) ((BaseVMFragment) SchoolyardFragment.this).mState).o(SchoolyardFragment.this.isMy());
            }
        });
        if (isMy()) {
            fragmentSchoolyardBinding.f36481a.setEmptyLayout(R.layout.layout_empty_my_huodong);
        }
        fragmentSchoolyardBinding.f13500a.openIntervalCallback(500L, new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.huodong.SchoolyardFragment.onViewCreated.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, o.f);
                SchoolyardVM schoolyardVM = (SchoolyardVM) ((BaseVMFragment) SchoolyardFragment.this).mState;
                if (schoolyardVM != null) {
                    schoolyardVM.q(str);
                }
                SchoolyardFragment.this.refreshData();
            }
        });
    }
}
