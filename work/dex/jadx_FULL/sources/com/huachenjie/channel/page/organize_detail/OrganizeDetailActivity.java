package com.huachenjie.channel.page.organize_detail;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coroutines.DataBindingUtil;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.ClubMessageAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeDetailBinding;
import com.huachenjie.channel.databinding.ChannelViewOrganizeDetailHeaderBinding;
import com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.ar6;
import com.zj.adlib.jj8;
import com.zj.adlib.tk0;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00030\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001d\u001a\n \u0018*\u0004\u0018\u00010\u00170\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/huachenjie/channel/page/organize_detail/OrganizeDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeDetailBinding;", "Lcom/huachenjie/channel/page/organize_detail/OrganizeDetailVM;", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "W", "", "isDark", "j0", "isTransparent", "h0", "g0", "e0", "a", "Z", "isTransparentToolBar", "Lcom/huachenjie/channel/databinding/ChannelViewOrganizeDetailHeaderBinding;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "d0", "()Lcom/huachenjie/channel/databinding/ChannelViewOrganizeDetailHeaderBinding;", "headerViewBinding", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeDetailActivity extends BaseMVVMActivity<ChannelActivityOrganizeDetailBinding, OrganizeDetailVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "organizeBean";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isTransparentToolBar;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerViewBinding = LazyKt.lazy(new Function0<ChannelViewOrganizeDetailHeaderBinding>() { // from class: com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity$headerViewBinding$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final ChannelViewOrganizeDetailHeaderBinding m315invoke() {
            ViewDataBinding viewDataBindingInflate = DataBindingUtil.inflate(this.this$0.getLayoutInflater(), R.layout.channel_view_organize_detail_header, null, false);
            OrganizeDetailActivity organizeDetailActivity = this.this$0;
            ChannelViewOrganizeDetailHeaderBinding channelViewOrganizeDetailHeaderBinding = (ChannelViewOrganizeDetailHeaderBinding) viewDataBindingInflate;
            channelViewOrganizeDetailHeaderBinding.k(organizeDetailActivity.getMViewModel());
            channelViewOrganizeDetailHeaderBinding.setLifecycleOwner(organizeDetailActivity);
            return channelViewOrganizeDetailHeaderBinding;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/channel/page/organize_detail/OrganizeDetailActivity$a;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/channel/bean/OrganizeBean;", "organizeBean", "", "a", "", "KEY_ORGANIZE_BEAN", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull OrganizeBean organizeBean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(organizeBean, "organizeBean");
            Intent intent = new Intent(context, (Class<?>) OrganizeDetailActivity.class);
            intent.putExtra("organizeBean", organizeBean);
            context.startActivity(intent);
        }
    }

    public static final void f0(OrganizeDetailActivity organizeDetailActivity) {
        Intrinsics.checkNotNullParameter(organizeDetailActivity, "this$0");
        organizeDetailActivity.getMViewModel().p();
    }

    public static final void i0(OrganizeDetailActivity organizeDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(organizeDetailActivity, "this$0");
        organizeDetailActivity.finish();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        j0(false);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, OrganizeDetailVM> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()));
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        super.W();
    }

    public final ChannelViewOrganizeDetailHeaderBinding d0() {
        return (ChannelViewOrganizeDetailHeaderBinding) this.headerViewBinding.getValue();
    }

    public final void e0() {
        MutableLiveData<ClubMessageAdapter> mutableLiveDataL = getMViewModel().l();
        ClubMessageAdapter clubMessageAdapter = new ClubMessageAdapter();
        clubMessageAdapter.setHeaderWithEmptyEnable(true);
        View root = d0().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "headerViewBinding.root");
        BaseQuickAdapter.setHeaderView$default(clubMessageAdapter, root, 0, 0, 6, null);
        View viewInflate = getLayoutInflater().inflate(R.layout.view_state_empty_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "layoutInflater.inflate(R…w_state_empty_view, null)");
        clubMessageAdapter.setEmptyView(viewInflate);
        clubMessageAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.je6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OrganizeDetailActivity.f0(this.f42570a);
            }
        });
        mutableLiveDataL.setValue(clubMessageAdapter);
    }

    public final void g0() {
        getMBinding().f33114a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.huachenjie.channel.page.organize_detail.OrganizeDetailActivity$initRecyclerView$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy) {
                Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                int iA = jj8.a(75.0f);
                Integer value = this.f33528a.getMViewModel().e().c().getValue();
                Intrinsics.checkNotNull(value);
                this.f33528a.h0(iComputeVerticalScrollOffset <= iA + value.intValue());
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize_detail;
    }

    public final void h0(boolean isTransparent) {
        if (isTransparent == this.isTransparentToolBar) {
            return;
        }
        this.isTransparentToolBar = isTransparent;
        j0(!isTransparent);
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(isTransparent ? 0 : -1).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(isTransparent ? -1 : -16777216)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ke6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizeDetailActivity.i0(this.f42801a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().o((OrganizeBean) getIntent().getParcelableExtra("organizeBean"));
        getMViewModel().p();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        getWindow().getDecorView().setBackgroundColor(ar6.E);
        h0(true);
        g0();
        e0();
    }

    public final void j0(boolean isDark) {
        e.p3(this).G2(R.color.transparent).T2(isDark).k3().a1();
    }
}
