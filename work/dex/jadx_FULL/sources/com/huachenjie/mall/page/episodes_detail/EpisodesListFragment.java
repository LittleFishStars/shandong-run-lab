package com.huachenjie.mall.page.episodes_detail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.huachenjie.common.widget.GridSpacingItemDecoration;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.EpisodeItemBean;
import com.huachenjie.mall.databinding.MallFragmentEpisodesListBinding;
import com.huachenjie.mall.page.episodes_detail.EpisodesListFragment;
import com.zj.adlib.fx7;
import com.zj.adlib.y57;
import com.zj.adlib.yk0;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\b\n*\u0001\u0013\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0006H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesListFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/mall/databinding/MallFragmentEpisodesListBinding;", "Lcom/huachenjie/mall/page/episodes_detail/EpisodesListVM;", "", "initAdapter", "", "", "getVariables", "getLayoutResID", "initView", "onDestroyView", "initData", "", "orderItemNo$delegate", "Lkotlin/Lazy;", "getOrderItemNo", "()Ljava/lang/String;", "orderItemNo", "com/huachenjie/mall/page/episodes_detail/EpisodesListFragment$receiver$2$1", "receiver$delegate", "getReceiver", "()Lcom/huachenjie/mall/page/episodes_detail/EpisodesListFragment$receiver$2$1;", "receiver", "<init>", "()V", "Companion", "a", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class EpisodesListFragment extends BaseMVVMFragment<MallFragmentEpisodesListBinding, EpisodesListVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String KEY_ITEM_LIST = "key_item_list";

    @NotNull
    private static final String KEY_ORDER_ITEM_NO = "key_order_item_no";

    /* JADX INFO: renamed from: orderItemNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy orderItemNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesListFragment$orderItemNo$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            Bundle arguments = this.this$0.getArguments();
            if (arguments != null) {
                return arguments.getString("key_order_item_no");
            }
            return null;
        }
    });

    /* JADX INFO: renamed from: receiver$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy receiver = LazyKt.lazy(new Function0<EpisodesListFragment$receiver$2.AnonymousClass1>() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesListFragment$receiver$2
        {
            super(0);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.huachenjie.mall.page.episodes_detail.EpisodesListFragment$receiver$2$1] */
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AnonymousClass1 m519invoke() {
            final EpisodesListFragment episodesListFragment = this.this$0;
            return new BroadcastReceiver() { // from class: com.huachenjie.mall.page.episodes_detail.EpisodesListFragment$receiver$2.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(@Nullable Context context, @Nullable Intent intent) {
                    String stringExtra = intent != null ? intent.getStringExtra(EpisodesDetailActivity.A) : null;
                    String stringExtra2 = intent != null ? intent.getStringExtra(EpisodesDetailActivity.B) : null;
                    EpisodesListAdapter value = episodesListFragment.getMViewModel().i().getValue();
                    if (value != null) {
                        value.e(stringExtra, stringExtra2);
                    }
                }
            };
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mall.page.episodes_detail.EpisodesListFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/mall/page/episodes_detail/EpisodesListFragment$a;", "", "Ljava/util/ArrayList;", "Lcom/huachenjie/mall/bean/EpisodeItemBean;", "Lkotlin/collections/ArrayList;", "itemList", "", "orderItemNo", "Lcom/huachenjie/mall/page/episodes_detail/EpisodesListFragment;", "a", "KEY_ITEM_LIST", "Ljava/lang/String;", "KEY_ORDER_ITEM_NO", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final EpisodesListFragment a(@NotNull ArrayList<EpisodeItemBean> itemList, @Nullable String orderItemNo) {
            Intrinsics.checkNotNullParameter(itemList, "itemList");
            EpisodesListFragment episodesListFragment = new EpisodesListFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(EpisodesListFragment.KEY_ITEM_LIST, itemList);
            bundle.putString("key_order_item_no", orderItemNo);
            episodesListFragment.setArguments(bundle);
            return episodesListFragment;
        }
    }

    private final String getOrderItemNo() {
        return (String) this.orderItemNo.getValue();
    }

    private final EpisodesListFragment$receiver$2.AnonymousClass1 getReceiver() {
        return (EpisodesListFragment$receiver$2.AnonymousClass1) this.receiver.getValue();
    }

    private final void initAdapter() {
        RecyclerView recyclerView;
        MallFragmentEpisodesListBinding mBinding = getMBinding();
        RecyclerView recyclerView2 = mBinding != null ? mBinding.f34952a : null;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(null);
        }
        int iJ = (fx7.j() - SizeUtils.b(336.0f)) / 4;
        int iB = SizeUtils.b(12.0f);
        MallFragmentEpisodesListBinding mBinding2 = getMBinding();
        if (mBinding2 != null && (recyclerView = mBinding2.f34952a) != null) {
            recyclerView.addItemDecoration(new GridSpacingItemDecoration(5, iJ, iB, false));
        }
        MutableLiveData<EpisodesListAdapter> mutableLiveDataI = getMViewModel().i();
        final EpisodesListAdapter episodesListAdapter = new EpisodesListAdapter(!TextUtils.isEmpty(getOrderItemNo()));
        y57.d(episodesListAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.s43
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                EpisodesListFragment.initAdapter$lambda$1$lambda$0(episodesListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataI.setValue(episodesListAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$1$lambda$0(EpisodesListAdapter episodesListAdapter, EpisodesListFragment episodesListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(episodesListAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(episodesListFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        EpisodeItemBean item = episodesListAdapter.getItem(i);
        if (item.isPlaying()) {
            return;
        }
        if (episodesListAdapter.getHasBuy() || item.getTrySee() != 0) {
            FragmentActivity activity = episodesListFragment.getActivity();
            EpisodesDetailActivity episodesDetailActivity = activity instanceof EpisodesDetailActivity ? (EpisodesDetailActivity) activity : null;
            if (episodesDetailActivity != null) {
                episodesDetailActivity.n0(item);
            }
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_fragment_episodes_list;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, EpisodesListVM> getVariables() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(yk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        EpisodesListAdapter value = getMViewModel().i().getValue();
        if (value != null) {
            Bundle arguments = getArguments();
            value.setList(arguments != null ? arguments.getParcelableArrayList(KEY_ITEM_LIST) : null);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initAdapter();
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(getReceiver(), new IntentFilter(EpisodesDetailActivity.z));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment, com.huachenjie.common.reconfig.baseView.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(getReceiver());
        super.onDestroyView();
    }
}
