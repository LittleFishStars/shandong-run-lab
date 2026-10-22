package com.huachenjie.channel.page.my_channel.organize_message;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeMessageBinding;
import com.huachenjie.channel.page.message_detail.MessageDetailActivity;
import com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.ft1;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_message/OrganizeMessageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeMessageBinding;", "Lcom/huachenjie/channel/page/my_channel/organize_message/OrganizeMessageVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "m0", "h0", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "Landroidx/activity/result/ActivityResultLauncher;", "detailLaunch", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeMessageActivity extends BaseMVVMActivity<ChannelActivityOrganizeMessageBinding, OrganizeMessageVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "clubCode";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> detailLaunch;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.se6
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            OrganizeMessageActivity.o0(this.f44671a);
        }
    };

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/organize_message/OrganizeMessageActivity$a;", "", "Landroid/content/Context;", "context", "", "channelNo", "clubCode", "Landroid/content/Intent;", "a", "CHANNEL_NO", "Ljava/lang/String;", "CLUB_CODE", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String channelNo, @NotNull String clubCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(clubCode, "clubCode");
            Intent intent = new Intent(context, (Class<?>) OrganizeMessageActivity.class);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra("clubCode", clubCode);
            return intent;
        }
    }

    public OrganizeMessageActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.te6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrganizeMessageActivity.g0(this.f44901a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…)\n            }\n        }");
        this.detailLaunch = activityResultLauncherRegisterForActivityResult;
    }

    public static final void g0(OrganizeMessageActivity organizeMessageActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        if (activityResult.getResultCode() == -1) {
            Intent data = activityResult.getData();
            boolean z = false;
            if (data != null && data.getBooleanExtra(MessageDetailActivity.t, false)) {
                z = true;
            }
            if (z) {
                organizeMessageActivity.getMViewModel().y();
                organizeMessageActivity.setResult(-1);
            }
        }
    }

    public static final void i0(OrganizeMessageActivity organizeMessageActivity) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        BaseStateRequestModel.x(organizeMessageActivity.getMViewModel(), false, 1, null);
    }

    public static final void j0(final OrganizeMessageActivity organizeMessageActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == R.id.tv_del) {
            ft1.p(organizeMessageActivity, organizeMessageActivity.getString(R.string.channel_organize_published_del_dialog_title), new View.OnClickListener() { // from class: com.zj.adlib.ue6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    OrganizeMessageActivity.k0(this.f45129a, i, view2);
                }
            });
        }
    }

    public static final void k0(OrganizeMessageActivity organizeMessageActivity, int i, View view) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        organizeMessageActivity.getMViewModel().B(i);
        organizeMessageActivity.setResult(-1);
    }

    public static final void l0(OrganizeMessageActivity organizeMessageActivity, OrganizeMessageAdapter organizeMessageAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        Intrinsics.checkNotNullParameter(organizeMessageAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        organizeMessageActivity.detailLaunch.launch(MessageDetailActivity.INSTANCE.a(organizeMessageActivity, organizeMessageAdapter.getItem(i), true));
    }

    public static final void n0(OrganizeMessageActivity organizeMessageActivity, View view) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        organizeMessageActivity.finish();
    }

    public static final void o0(OrganizeMessageActivity organizeMessageActivity) {
        Intrinsics.checkNotNullParameter(organizeMessageActivity, "this$0");
        organizeMessageActivity.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize_message;
    }

    public final void h0() {
        OrganizeMessageAdapter value = getMViewModel().C().getValue();
        Intrinsics.checkNotNull(value);
        final OrganizeMessageAdapter organizeMessageAdapter = value;
        organizeMessageAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.we6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OrganizeMessageActivity.i0(this.f45581a);
            }
        });
        getMBinding().f7665a.setEmptyLabel(getString(R.string.channel_organize_message_empty));
        OrganizeMessageVM mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f7665a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, organizeMessageAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, organizeMessageAdapter, false, 4, null);
        organizeMessageAdapter.addChildClickViewIds(R.id.tv_del);
        Intrinsics.checkNotNullExpressionValue(organizeMessageAdapter, "initAdapter$lambda$6");
        y57.b(organizeMessageAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.xe6
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeMessageActivity.j0(this.f45807a, baseQuickAdapter, view, i);
            }
        }, 1, null);
        y57.d(organizeMessageAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ye6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeMessageActivity.l0(this.f46015a, organizeMessageAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        OrganizeMessageVM mViewModel = getMViewModel();
        String stringExtra = getIntent().getStringExtra("channelNo");
        if (stringExtra == null) {
            stringExtra = "";
        }
        mViewModel.F(stringExtra);
        OrganizeMessageVM mViewModel2 = getMViewModel();
        String stringExtra2 = getIntent().getStringExtra("clubCode");
        mViewModel2.G(stringExtra2 != null ? stringExtra2 : "");
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        m0();
        h0();
    }

    public final void m0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.ve6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizeMessageActivity.n0(this.f45335a, view);
            }
        }).setTitleName(getString(R.string.channel_organize_published_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }
}
