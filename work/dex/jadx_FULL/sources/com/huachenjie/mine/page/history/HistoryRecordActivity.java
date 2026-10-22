package com.huachenjie.mine.page.history;

import android.view.View;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Observer;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.mine.R;
import com.huachenjie.mine.databinding.MineActivityHistoryRecordBinding;
import com.huachenjie.mine.page.history.HistoryRecordActivity;
import com.huachenjie.mine.page.history.fragment.HistoryChannelFragment;
import com.huachenjie.mine.page.history.fragment.HistoryTopicFragment;
import com.huachenjie.mine.page.history.fragment.HistoryWorksFragment;
import com.zj.adlib.ft1;
import com.zj.adlib.ik0;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/mine/page/history/HistoryRecordActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mine/databinding/MineActivityHistoryRecordBinding;", "Lcom/huachenjie/mine/page/history/HistoryRecordViewModel;", "", "", "", "V", "getLayoutResID", "", "initView", "W", "b0", "", "Landroidx/fragment/app/Fragment;", "c", "Ljava/util/List;", "fragmentArray", "<init>", "()V", "a", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class HistoryRecordActivity extends BaseMVVMActivity<MineActivityHistoryRecordBinding, HistoryRecordViewModel> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final List<Fragment> fragmentArray = CollectionsKt.mutableListOf(new Fragment[]{new HistoryWorksFragment(), new HistoryChannelFragment(), new HistoryTopicFragment()});

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/mine/page/history/HistoryRecordActivity$a;", "", "Landroid/view/View;", "v", "", "b", "c", "<init>", "(Lcom/huachenjie/mine/page/history/HistoryRecordActivity;)V", "mine_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void d(HistoryRecordActivity historyRecordActivity, View view) {
            Intrinsics.checkNotNullParameter(historyRecordActivity, "this$0");
            HistoryRecordActivity.a0(historyRecordActivity).i();
        }

        public final void b(@Nullable View v) {
            HistoryRecordActivity.this.finish();
        }

        public final void c(@Nullable View v) {
            HistoryRecordActivity historyRecordActivity = HistoryRecordActivity.this;
            String string = historyRecordActivity.getString(R.string.mine_history_record_clear_content);
            final HistoryRecordActivity historyRecordActivity2 = HistoryRecordActivity.this;
            ft1.p(historyRecordActivity, string, new View.OnClickListener() { // from class: com.zj.adlib.m04
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HistoryRecordActivity.a.d(historyRecordActivity2, view);
                }
            });
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35387a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35387a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35387a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35387a.invoke(obj);
        }
    }

    public static final /* synthetic */ HistoryRecordViewModel a0(HistoryRecordActivity historyRecordActivity) {
        return historyRecordActivity.getMViewModel();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(ik0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(ik0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
        getMViewModel().j().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.mine.page.history.HistoryRecordActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                for (ActivityResultCaller activityResultCaller : this.this$0.fragmentArray) {
                    if (activityResultCaller instanceof IHistoryFragmentListener) {
                        ((IHistoryFragmentListener) activityResultCaller).clearHistory();
                    }
                }
            }
        }));
    }

    public final void b0() {
        getMBinding().f11192a.setAdapter(new FragmentStateAdapter() { // from class: com.huachenjie.mine.page.history.HistoryRecordActivity$initTab$1
            {
                super(this.f35388a);
            }

            @Override // androidx.viewpager2.adapter.FragmentStateAdapter
            @NotNull
            public Fragment createFragment(int position) {
                return (Fragment) this.f35388a.fragmentArray.get(position);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.f35388a.fragmentArray.size();
            }
        });
        String[] stringArray = getResources().getStringArray(R.array.mine_history_record_tab);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray….mine_history_record_tab)");
        SelectBoldTabLayout selectBoldTabLayout = getMBinding().f11193a;
        ViewPager2 viewPager2 = getMBinding().f11192a;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "mBinding.viewPager");
        selectBoldTabLayout.attachViewPager(viewPager2, stringArray);
        getMBinding().f11192a.setOffscreenPageLimit(this.fragmentArray.size());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mine_activity_history_record;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        b0();
    }
}
