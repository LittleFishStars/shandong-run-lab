package com.huachenjie.mall.external.page.share_goods;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.mall.R;
import com.huachenjie.mall.databinding.MallFragmentSelectGoodsBinding;
import com.huachenjie.mall.external.bean.SelectGoodsBean;
import com.huachenjie.mall.external.page.share_goods.SelectGoodsFragment;
import com.zj.adlib.hk0;
import com.zj.adlib.yj7;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nR\u001b\u0010\u0016\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentSelectGoodsBinding;", "Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsVM;", "", "initAdapter", "", "", "getVariables", "getLayoutResID", "", "isAdd2ViewPager2", "initView", "lazyLoadData", "", "code", "checked", "updateSelected", "type$delegate", "Lkotlin/Lazy;", "getType", "()I", "type", "isSingleSelect$delegate", "isSingleSelect", "()Z", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class SelectGoodsFragment extends BaseMVVMFragment<MallFragmentSelectGoodsBinding, SelectGoodsVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_SINGLE = "key_single";

    @NotNull
    private static final String KEY_TYPE = "key_type";
    public static final int TYPE_ALL = 2;
    public static final int TYPE_MY = 1;

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.external.page.share_goods.SelectGoodsFragment$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m486invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("key_type") : 1);
        }
    });

    /* JADX INFO: renamed from: isSingleSelect$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy isSingleSelect = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.mall.external.page.share_goods.SelectGoodsFragment.isSingleSelect.2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m485invoke() {
            Bundle arguments = SelectGoodsFragment.this.getArguments();
            return Boolean.valueOf(arguments != null ? arguments.getBoolean(SelectGoodsFragment.KEY_SINGLE) : false);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mall.external.page.share_goods.SelectGoodsFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsFragment$a;", "", "", "type", "", "isSingleSelect", "Lcom/huachenjie/mall/external/page/share_goods/SelectGoodsFragment;", "a", "", "KEY_SINGLE", "Ljava/lang/String;", "KEY_TYPE", "TYPE_ALL", "I", "TYPE_MY", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectGoodsFragment a(int type, boolean isSingleSelect) {
            SelectGoodsFragment selectGoodsFragment = new SelectGoodsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("key_type", type);
            bundle.putBoolean(SelectGoodsFragment.KEY_SINGLE, isSingleSelect);
            selectGoodsFragment.setArguments(bundle);
            return selectGoodsFragment;
        }
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void initAdapter() {
        MutableLiveData<SelectGoodsAdapter> mutableLiveDataI = getMViewModel().i();
        final SelectGoodsAdapter selectGoodsAdapter = new SelectGoodsAdapter();
        selectGoodsAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.k48
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                SelectGoodsFragment.initAdapter$lambda$3$lambda$0(this.f42742a);
            }
        });
        View viewInflate = LayoutInflater.from(requireContext()).inflate(R.layout.mall_layout_empty_data, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(requireContext())\n …_empty_data, null, false)");
        selectGoodsAdapter.setEmptyView(viewInflate);
        selectGoodsAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.l48
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SelectGoodsFragment.initAdapter$lambda$3$lambda$2(selectGoodsAdapter, this, baseQuickAdapter, view, i);
            }
        });
        mutableLiveDataI.setValue(selectGoodsAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$0(SelectGoodsFragment selectGoodsFragment) {
        Intrinsics.checkNotNullParameter(selectGoodsFragment, "this$0");
        SelectGoodsVM mViewModel = selectGoodsFragment.getMViewModel();
        int type = selectGoodsFragment.getType();
        boolean zIsSingleSelect = selectGoodsFragment.isSingleSelect();
        FragmentActivity activity = selectGoodsFragment.getActivity();
        SelectGoodsActivity selectGoodsActivity = activity instanceof SelectGoodsActivity ? (SelectGoodsActivity) activity : null;
        mViewModel.l(type, zIsSingleSelect, selectGoodsActivity != null ? selectGoodsActivity.c0() : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$3$lambda$2(SelectGoodsAdapter selectGoodsAdapter, SelectGoodsFragment selectGoodsFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(selectGoodsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(selectGoodsFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        SelectGoodsBean item = selectGoodsAdapter.getItem(i);
        boolean z = false;
        if (selectGoodsFragment.isSingleSelect()) {
            FragmentActivity activity = selectGoodsFragment.getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra(yj7.e.KEY_GOODS_NO_LIST, CollectionsKt.arrayListOf(new String[]{item.getGoodsNo()}));
                intent.putExtra(yj7.e.KEY_GOODS_SINGLE_NAME, item.getGoodsName());
                Unit unit = Unit.INSTANCE;
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = selectGoodsFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        FragmentActivity activity3 = selectGoodsFragment.getActivity();
        SelectGoodsActivity selectGoodsActivity = activity3 instanceof SelectGoodsActivity ? (SelectGoodsActivity) activity3 : null;
        if (!item.getChecked()) {
            if (selectGoodsActivity != null && selectGoodsActivity.b0()) {
                z = true;
            }
            if (!z) {
                return;
            }
        }
        item.setChecked(!item.getChecked());
        selectGoodsAdapter.notifyItemChanged(i);
        if (selectGoodsActivity != null) {
            selectGoodsActivity.j0(selectGoodsFragment.getType(), item.getGoodsNo(), item.getChecked());
        }
    }

    private final boolean isSingleSelect() {
        return ((Boolean) this.isSingleSelect.getValue()).booleanValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_select_goods;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, SelectGoodsVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public boolean isAdd2ViewPager2() {
        return true;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseFragment
    public void lazyLoadData() {
        SelectGoodsVM mViewModel = getMViewModel();
        int type = getType();
        boolean zIsSingleSelect = isSingleSelect();
        FragmentActivity activity = getActivity();
        SelectGoodsActivity selectGoodsActivity = activity instanceof SelectGoodsActivity ? (SelectGoodsActivity) activity : null;
        mViewModel.n(type, zIsSingleSelect, selectGoodsActivity != null ? selectGoodsActivity.c0() : null);
    }

    public final void updateSelected(@NotNull String code, boolean checked) {
        Intrinsics.checkNotNullParameter(code, "code");
        if (!modelIsInitialized() || getMViewModel().i().getValue() == null) {
            return;
        }
        getMViewModel().q(code, checked);
    }
}
