package com.huachenjie.home.page.inspiration_record;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.home.R;
import com.huachenjie.home.databinding.HomeFragmentInsporationRecordBinding;
import com.huachenjie.home.page.inspiration_record.InspirationRecordFragment;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.zj.adlib.xk0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/home/databinding/HomeFragmentInsporationRecordBinding;", "Lcom/huachenjie/home/page/inspiration_record/InspirationRecordFVM;", "", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "<init>", "()V", "Companion", "a", "home_release"}, k = 1, mv = {1, 8, 0})
public final class InspirationRecordFragment extends BaseMVVMFragment<HomeFragmentInsporationRecordBinding, InspirationRecordFVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String IS_INSPIRATION_GET_KEY = "is_inspiration_get";

    /* JADX INFO: renamed from: com.huachenjie.home.page.inspiration_record.InspirationRecordFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/home/page/inspiration_record/InspirationRecordFragment$a;", "", "", "isInspirationGet", "Lcom/huachenjie/home/page/inspiration_record/InspirationRecordFragment;", "a", "", "IS_INSPIRATION_GET_KEY", "Ljava/lang/String;", "<init>", "()V", "home_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final InspirationRecordFragment a(boolean isInspirationGet) {
            InspirationRecordFragment inspirationRecordFragment = new InspirationRecordFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(InspirationRecordFragment.IS_INSPIRATION_GET_KEY, isInspirationGet);
            inspirationRecordFragment.setArguments(bundle);
            return inspirationRecordFragment;
        }
    }

    private final void initAdapter() {
        MutableLiveData<BaseQuickAdapter<?, ?>> mutableLiveDataB = getMViewModel().B();
        InspirationRecordAdapter inspirationRecordAdapter = new InspirationRecordAdapter();
        InspirationRecordFVM mViewModel = getMViewModel();
        HomeFragmentInsporationRecordBinding mBinding = getMBinding();
        Intrinsics.checkNotNull(mBinding);
        StateLayout stateLayout = mBinding.f34249a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding!!.stateLayout");
        mViewModel.o(this, stateLayout, inspirationRecordAdapter, true);
        getMViewModel().m(this, inspirationRecordAdapter, true);
        inspirationRecordAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.hb4
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                InspirationRecordFragment.initAdapter$lambda$2$lambda$0(this.f42091a);
            }
        });
        inspirationRecordAdapter.addChildClickViewIds(R.id.tv_record);
        inspirationRecordAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ib4
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                InspirationRecordFragment.initAdapter$lambda$2$lambda$1(this.f42319a, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataB.setValue(inspirationRecordAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$0(InspirationRecordFragment inspirationRecordFragment) {
        Intrinsics.checkNotNullParameter(inspirationRecordFragment, "this$0");
        BaseStateRequestModel.x(inspirationRecordFragment.getMViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$2$lambda$1(InspirationRecordFragment inspirationRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(inspirationRecordFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        inspirationRecordFragment.startActivity(new Intent(inspirationRecordFragment.requireContext(), (Class<?>) RewardRecordActivity.class));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.home_fragment_insporation_record;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(xk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        MutableLiveData<Boolean> mutableLiveDataC = getMViewModel().C();
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null && arguments.getBoolean(IS_INSPIRATION_GET_KEY)) {
            z = true;
        }
        mutableLiveDataC.setValue(Boolean.valueOf(z));
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }
}
