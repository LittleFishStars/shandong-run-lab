package com.huachenjie.channel.page.advertise;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.AdvertiseBean;
import com.huachenjie.channel.databinding.ChannelFragmentAdvertiseBinding;
import com.huachenjie.channel.page.advertise.AdvertiseFragment;
import com.huachenjie.channel.page.advertise.preview.PreviewAdvertiseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment;
import com.king.zxing.e;
import com.zj.adlib.ft1;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/page/advertise/AdvertiseFragment;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMFragment;", "Lcom/huachenjie/channel/databinding/ChannelFragmentAdvertiseBinding;", "Lcom/huachenjie/channel/page/advertise/AdvertiseVM;", "", "initAdapter", "", "", "", "getVariables", "getLayoutResID", "initView", "initData", "initDataObservable", "refreshList", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "", "channelNo$delegate", "Lkotlin/Lazy;", "getChannelNo", "()Ljava/lang/String;", "channelNo", "type$delegate", "getType", "()I", "type", "<init>", "()V", "Companion", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class AdvertiseFragment extends BaseMVVMFragment<ChannelFragmentAdvertiseBinding, AdvertiseVM> {

    @NotNull
    public static final String CHANNEL_NO = "channelNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TYPE = "type";

    @NotNull
    private final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.l20
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            AdvertiseFragment.onRefreshListener$lambda$0(this.f42977a);
        }
    };

    /* JADX INFO: renamed from: channelNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.advertise.AdvertiseFragment$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("channelNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: type$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy type = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.channel.page.advertise.AdvertiseFragment$type$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m247invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("type") : 0);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.advertise.AdvertiseFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\t¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/advertise/AdvertiseFragment$a;", "", "", "channelNo", "", "type", "Lcom/huachenjie/channel/page/advertise/AdvertiseFragment;", "a", "CHANNEL_NO", "Ljava/lang/String;", e.f.c, "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AdvertiseFragment a(@NotNull String channelNo, int type) {
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            AdvertiseFragment advertiseFragment = new AdvertiseFragment();
            Bundle bundle = new Bundle();
            bundle.putString("channelNo", channelNo);
            bundle.putInt("type", type);
            advertiseFragment.setArguments(bundle);
            return advertiseFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33357a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33357a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33357a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33357a.invoke(obj);
        }
    }

    public static final /* synthetic */ AdvertiseVM access$getMViewModel(AdvertiseFragment advertiseFragment) {
        return advertiseFragment.getMViewModel();
    }

    private final String getChannelNo() {
        return (String) this.channelNo.getValue();
    }

    private final int getType() {
        return ((Number) this.type.getValue()).intValue();
    }

    private final void initAdapter() {
        final AdvertiseAdapter advertiseAdapter = new AdvertiseAdapter();
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_empty_work, (ViewGroup) null, false);
        View viewFindViewById = viewInflate.findViewById(R.id.emptyView);
        if (viewFindViewById != null) {
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById<View>(R.id.emptyView)");
            if (viewFindViewById.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).verticalBias = 0.4f;
            }
        }
        advertiseAdapter.h(viewInflate);
        advertiseAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.i20
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                AdvertiseFragment.initAdapter$lambda$8$lambda$3(this.f42259a);
            }
        });
        y57.d(advertiseAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.j20
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AdvertiseFragment.initAdapter$lambda$8$lambda$4(advertiseAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        advertiseAdapter.addChildClickViewIds(R.id.ivEndAd, R.id.ivEditAd, R.id.ivDeleteAd, R.id.ll_ad_status);
        y57.b(advertiseAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.k20
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                AdvertiseFragment.initAdapter$lambda$8$lambda$7(advertiseAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().n().setValue(advertiseAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$3(AdvertiseFragment advertiseFragment) {
        Intrinsics.checkNotNullParameter(advertiseFragment, "this$0");
        advertiseFragment.getMViewModel().r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$4(AdvertiseAdapter advertiseAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(advertiseAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        AdvertiseBean advertiseBean = advertiseAdapter.getData().get(i);
        if (advertiseBean.getLinkType()) {
            ARouter.getInstance().build(RoutePathConstants.Common.c).withString("url", advertiseBean.getLinkUrl()).withString("title", "详情").navigation();
            return;
        }
        PreviewAdvertiseActivity.Companion aVar = PreviewAdvertiseActivity.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        aVar.a(context, advertiseBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$7(AdvertiseAdapter advertiseAdapter, final AdvertiseFragment advertiseFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(advertiseAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(advertiseFragment, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        final AdvertiseBean advertiseBean = advertiseAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ivEndAd) {
            ft1.p(view.getContext(), "确定结束展示该频道广告吗？", new View.OnClickListener() { // from class: com.zj.adlib.g20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdvertiseFragment.initAdapter$lambda$8$lambda$7$lambda$5(this.f16679a, advertiseBean, view2);
                }
            });
            return;
        }
        if (id == R.id.ivEditAd) {
            FragmentActivity activity = advertiseFragment.getActivity();
            if (activity != null && (activity instanceof AdvertiseActivity)) {
                ((AdvertiseActivity) activity).j0(advertiseBean);
                return;
            }
            return;
        }
        if (id == R.id.ivDeleteAd) {
            ft1.p(view.getContext(), "确定删除该频道广告吗？", new View.OnClickListener() { // from class: com.zj.adlib.h20
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AdvertiseFragment.initAdapter$lambda$8$lambda$7$lambda$6(this.f16918a, advertiseBean, view2);
                }
            });
            return;
        }
        if (id == R.id.ll_ad_status && advertiseBean.getAdStatus() == 3) {
            ft1.z(view.getContext(), "失败原因：" + advertiseBean.getFailReason(), "我知道了");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$7$lambda$5(AdvertiseFragment advertiseFragment, AdvertiseBean advertiseBean, View view) {
        Intrinsics.checkNotNullParameter(advertiseFragment, "this$0");
        Intrinsics.checkNotNullParameter(advertiseBean, "$bean");
        AdvertiseVM mViewModel = advertiseFragment.getMViewModel();
        String channelNo = advertiseFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.m(channelNo, advertiseBean.getChannelAdCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$8$lambda$7$lambda$6(AdvertiseFragment advertiseFragment, AdvertiseBean advertiseBean, View view) {
        Intrinsics.checkNotNullParameter(advertiseFragment, "this$0");
        Intrinsics.checkNotNullParameter(advertiseBean, "$bean");
        AdvertiseVM mViewModel = advertiseFragment.getMViewModel();
        String channelNo = advertiseFragment.getChannelNo();
        Intrinsics.checkNotNullExpressionValue(channelNo, "channelNo");
        mViewModel.l(channelNo, advertiseBean.getChannelAdCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onRefreshListener$lambda$0(AdvertiseFragment advertiseFragment) {
        Intrinsics.checkNotNullParameter(advertiseFragment, "this$0");
        advertiseFragment.getMViewModel().t();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_fragment_advertise;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().t();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMFragment
    public void initDataObservable() {
        getMViewModel().p().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.advertise.AdvertiseFragment.initDataObservable.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    AdvertiseFragment.access$getMViewModel(AdvertiseFragment.this).t();
                    FragmentActivity activity = AdvertiseFragment.this.getActivity();
                    if (activity != null && (activity instanceof AdvertiseActivity)) {
                        ((AdvertiseActivity) activity).i0(2);
                    }
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        getMViewModel().o().setValue(getChannelNo());
        getMViewModel().getType().setValue(Integer.valueOf(getType()));
        initAdapter();
    }

    public final void refreshList() {
        if (modelIsInitialized()) {
            getMViewModel().t();
        }
    }
}
