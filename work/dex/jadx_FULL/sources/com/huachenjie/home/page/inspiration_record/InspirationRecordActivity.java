package com.huachenjie.home.page.inspiration_record;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeActivityInspirationRecordBinding;
import com.huachenjie.home.page.inspiration_record.InspirationRecordActivity;
import com.zj.adlib.xk0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/home/databinding/HomeActivityInspirationRecordBinding;", "Lcom/huachenjie/home/page/inspiration_record/InspirationRecordVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "c0", "b0", "", "Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "fragmentArray", "<init>", "()V", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationRecordActivity extends BaseMVVMActivity<HomeActivityInspirationRecordBinding, InspirationRecordVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "inspiration_key";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Fragment> fragmentArray;

    /* JADX INFO: renamed from: com.huachenjie.home.page.inspiration_record.InspirationRecordActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordActivity$a;", "", "Landroid/content/Context;", "context", "", "totalInspiration", "", "a", "", "INSPIRATION_KEY", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, long totalInspiration) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) InspirationRecordActivity.class);
            intent.putExtra(InspirationRecordActivity.t, totalInspiration);
            context.startActivity(intent);
        }
    }

    public InspirationRecordActivity() {
        InspirationRecordFragment.Companion aVar = InspirationRecordFragment.INSTANCE;
        this.fragmentArray = CollectionsKt.mutableListOf(new Fragment[]{aVar.a(true), aVar.a(false)});
    }

    public static final void d0(InspirationRecordActivity inspirationRecordActivity, View view) {
        Intrinsics.checkNotNullParameter(inspirationRecordActivity, "this$0");
        inspirationRecordActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    public final void b0() {
        getMBinding().f34203a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.home.page.inspiration_record.InspirationRecordActivity$initTab$1
            {
                super(this.f34357a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) this.f34357a.fragmentArray.get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f34357a.fragmentArray.size();
            }
        });
        String[] stringArray = getResources().getStringArray(R.array.home_inspiration_record_tab);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray…e_inspiration_record_tab)");
        SelectBoldTabLayout selectBoldTabLayout = getMBinding().f9278a;
        ViewPager2 viewPager2 = getMBinding().f34203a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        selectBoldTabLayout.attachViewPager(viewPager2, stringArray);
        getMBinding().f34203a.setOffscreenPageLimit(this.fragmentArray.size());
    }

    public final void c0() {
        int iIntValue;
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setTitleName(getString(R.string.home_inspiration_record_title));
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            iIntValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
            iIntValue = value.intValue();
        }
        bindingTitleBean.setStatusBarHeight(iIntValue);
        Resources resources = getResources();
        int i = R.color.color_191F20;
        bindingTitleBean.setTitleTextColor(resources.getColor(i));
        bindingTitleBean.setBackground(0);
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(getResources().getColor(i)));
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.gb4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InspirationRecordActivity.d0(this.f41865a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_activity_inspiration_record;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().j().setValue(String.valueOf(getIntent().getLongExtra(t, 0L)));
        getMViewModel().k();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        c0();
        b0();
        getWindow().getDecorView().setBackgroundColor(getResources().getColor(R.color.color_F7F7F7));
    }
}
