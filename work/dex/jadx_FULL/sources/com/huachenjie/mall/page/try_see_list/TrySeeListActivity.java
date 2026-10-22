package com.huachenjie.mall.page.try_see_list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.huachenjie.mall.R;
import com.huachenjie.mall.bean.TrySeeVideoBean;
import com.huachenjie.mall.databinding.MallActivityTrySeeListBinding;
import com.huachenjie.mall.page.course_detail.CourseDetailActivity;
import com.huachenjie.mall.page.episodes_detail.EpisodesDetailActivity;
import com.huachenjie.mall.page.try_see_list.TrySeeListActivity;
import com.zj.adlib.hk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0016\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/mall/page/try_see_list/TrySeeListActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/mall/databinding/MallActivityTrySeeListBinding;", "Lcom/huachenjie/mall/page/try_see_list/TrySeeListVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "g0", "d0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "b", "Lkotlin/Lazy;", "getType", "()I", "type", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
public final class TrySeeListActivity extends BaseMVVMActivity<MallActivityTrySeeListBinding, TrySeeListVM> {
    public static final int K = 0;
    public static final int L = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "goodsNo";

    @NotNull
    public static final String x = "type";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.hd9
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            TrySeeListActivity.i0(this.f42106a);
        }
    };

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.mall.page.try_see_list.TrySeeListActivity$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m579invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("type", 0));
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.mall.page.try_see_list.TrySeeListActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/mall/page/try_see_list/TrySeeListActivity$a;", "", "Landroid/content/Context;", "context", "", "goodsNo", "", "type", "", "a", "KEY_GOODS_NO", "Ljava/lang/String;", "KEY_TYPE", "TYPE_AI_KAN", "I", "TYPE_YU_QING", "<init>", "()V", "mall_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String goodsNo, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(goodsNo, "goodsNo");
            Intent intent = new Intent(context, (Class<?>) TrySeeListActivity.class);
            intent.putExtra("goodsNo", goodsNo);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }
    }

    public static final void e0(TrySeeListActivity trySeeListActivity) {
        Intrinsics.checkNotNullParameter(trySeeListActivity, "this$0");
        BaseStateRequestModel.x(trySeeListActivity.getMViewModel(), false, 1, null);
    }

    public static final void f0(TrySeeListAdapter trySeeListAdapter, TrySeeListActivity trySeeListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(trySeeListAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(trySeeListActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        TrySeeVideoBean item = trySeeListAdapter.getItem(i);
        if (trySeeListActivity.getType() == 0) {
            CourseDetailActivity.INSTANCE.a(trySeeListActivity, item.getEpisodeNo());
        } else {
            EpisodesDetailActivity.INSTANCE.a(trySeeListActivity, item.getEpisodeNo());
        }
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    public static final void h0(TrySeeListActivity trySeeListActivity, View view) {
        Intrinsics.checkNotNullParameter(trySeeListActivity, "this$0");
        trySeeListActivity.finish();
    }

    public static final void i0(TrySeeListActivity trySeeListActivity) {
        Intrinsics.checkNotNullParameter(trySeeListActivity, "this$0");
        trySeeListActivity.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(hk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(hk0.R), this.onRefreshListener)});
    }

    public final void d0() {
        MutableLiveData<TrySeeListAdapter> mutableLiveDataB = getMViewModel().B();
        final TrySeeListAdapter trySeeListAdapter = new TrySeeListAdapter();
        TrySeeListVM mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f10467a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, trySeeListAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, trySeeListAdapter, false, 4, null);
        trySeeListAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.fd9
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                TrySeeListActivity.e0(this.f41649a);
            }
        });
        y57.d(trySeeListAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.gd9
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                TrySeeListActivity.f0(trySeeListAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(trySeeListAdapter);
    }

    public final void g0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName(getString(getType() == 0 ? R.string.mall_video_enter_title1 : R.string.mall_video_enter_title2)).setTitleTextColor(zn1.a(R.color.hcj_header_txt)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ed9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TrySeeListActivity.h0(this.f41411a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.mall_activity_try_see_list;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        TrySeeListVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("goodsNo");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.D(stringExtra);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        d0();
    }
}
