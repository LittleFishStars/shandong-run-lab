package com.huachenjie.sport.page.mine.huodong;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.databinding.ActiviySchoolyardBinding;
import com.huachenjie.sport.page.mine.huodong.SchoolyardActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.b)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "g0", "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SchoolyardActivity extends BaseVmActivity<BaseVM> {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/SchoolyardActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/huodong/SchoolyardActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SchoolyardActivity.this.finish();
        }
    }

    public static final void h0(List list, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(list, "$titles");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText((CharSequence) list.get(i));
    }

    public final void g0() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.ActiviySchoolyardBinding");
        ActiviySchoolyardBinding activiySchoolyardBinding = (ActiviySchoolyardBinding) binding;
        final List listListOf = CollectionsKt.listOf(new String[]{"全部活动", "我的报名"});
        activiySchoolyardBinding.f36440a.setUserInputEnabled(false);
        activiySchoolyardBinding.f36440a.setAdapter(new FragmentStateAdapter(this) { // from class: com.huachenjie.sport.page.mine.huodong.SchoolyardActivity$initTabLayout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return position == 0 ? SchoolyardFragment.INSTANCE.a(false) : SchoolyardFragment.INSTANCE.a(true);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return listListOf.size();
            }
        });
        new TabLayoutMediator(activiySchoolyardBinding.f13377a, activiySchoolyardBinding.f36440a, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.zj.adlib.ew7
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                SchoolyardActivity.h0(listListOf, tab, i);
            }
        }).attach();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activiy_schoolyard), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        g0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
