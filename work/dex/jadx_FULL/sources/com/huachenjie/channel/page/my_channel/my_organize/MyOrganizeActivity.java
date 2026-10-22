package com.huachenjie.channel.page.my_channel.my_organize;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.huachenjie.channel.R;
import com.huachenjie.channel.adapter.AllOrMyOrganizeAdapter;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelActivityMyOrganizeBinding;
import com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity;
import com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity;
import com.huachenjie.channel.page.my_channel.organize_message.OrganizeMessageActivity;
import com.huachenjie.channel.page.my_channel.organize_publish.PublishOrgMessageActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.page.statelayout.StateLayout;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.reconfig.mvvm.BaseStateRequestModel;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.PageEntity;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001c\u000fB\u0007¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R)\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00150\u00150\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/my_organize/MyOrganizeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityMyOrganizeBinding;", "Lcom/huachenjie/channel/page/my_channel/my_organize/MyOrganizeVM;", "", "", "", "V", "getLayoutResID", "", "initView", "initData", "l0", "i0", "", "b", "Lkotlin/Lazy;", "h0", "()Ljava/lang/String;", "channelNo", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "c", "g0", "()Landroidx/activity/result/ActivityResultLauncher;", "activityDispatch", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class MyOrganizeActivity extends BaseMVVMActivity<ChannelActivityMyOrganizeBinding, MyOrganizeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channelNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy activityDispatch = LazyKt.lazy(new MyOrganizeActivity$activityDispatch$2(this));

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.wu5
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            MyOrganizeActivity.n0(this.f45693a);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/my_organize/MyOrganizeActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/channel/page/my_channel/my_organize/MyOrganizeActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0045  */
        public final void a(@Nullable View v) {
            OrganizeBean organizeBean;
            PageEntity<?> value = MyOrganizeActivity.f0(MyOrganizeActivity.this).u().getValue();
            ActivityResultLauncher activityResultLauncherG0 = MyOrganizeActivity.this.g0();
            PublishOrgMessageActivity.Companion companion = PublishOrgMessageActivity.INSTANCE;
            MyOrganizeActivity myOrganizeActivity = MyOrganizeActivity.this;
            String strH0 = myOrganizeActivity.h0();
            Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
            if (value != null) {
                List list = value.getList();
                Intrinsics.checkNotNullExpressionValue(list, "entity.list");
                if (list.size() == 1) {
                    List list2 = value.getList();
                    Intrinsics.checkNotNullExpressionValue(list2, "entity.list");
                    organizeBean = (OrganizeBean) CollectionsKt.first(list2);
                } else {
                    organizeBean = null;
                }
            } else {
                organizeBean = null;
            }
            activityResultLauncherG0.launch(companion.a(myOrganizeActivity, strH0, organizeBean));
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.my_channel.my_organize.MyOrganizeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/huachenjie/channel/page/my_channel/my_organize/MyOrganizeActivity$b;", "", "Landroid/content/Context;", "context", "", "channelNo", "", "a", "CHANNEL_NO", "Ljava/lang/String;", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String channelNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) MyOrganizeActivity.class);
            intent.putExtra("channelNo", channelNo);
            context.startActivity(intent);
        }
    }

    public static final /* synthetic */ MyOrganizeVM f0(MyOrganizeActivity myOrganizeActivity) {
        return myOrganizeActivity.getMViewModel();
    }

    public static final void j0(MyOrganizeActivity myOrganizeActivity) {
        Intrinsics.checkNotNullParameter(myOrganizeActivity, "this$0");
        BaseStateRequestModel.x(myOrganizeActivity.getMViewModel(), false, 1, null);
    }

    public static final void k0(AllOrMyOrganizeAdapter allOrMyOrganizeAdapter, MyOrganizeActivity myOrganizeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(allOrMyOrganizeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(myOrganizeActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        OrganizeBean organizeBean = allOrMyOrganizeAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ll_member) {
            OrganizeMemberActivity.INSTANCE.a(myOrganizeActivity, organizeBean.getClubCode());
        } else if (id == R.id.ll_published) {
            myOrganizeActivity.g0().launch(OrganizeMessageActivity.INSTANCE.a(myOrganizeActivity, myOrganizeActivity.getMViewModel().getChannelNo(), organizeBean.getClubCode()));
        }
    }

    public static final void m0(MyOrganizeActivity myOrganizeActivity, View view) {
        Intrinsics.checkNotNullParameter(myOrganizeActivity, "this$0");
        myOrganizeActivity.finish();
    }

    public static final void n0(MyOrganizeActivity myOrganizeActivity) {
        Intrinsics.checkNotNullParameter(myOrganizeActivity, "this$0");
        myOrganizeActivity.getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener)});
    }

    public final ActivityResultLauncher<Intent> g0() {
        return (ActivityResultLauncher) this.activityDispatch.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_my_organize;
    }

    public final String h0() {
        return (String) this.channelNo.getValue();
    }

    public final void i0() {
        MutableLiveData<AllOrMyOrganizeAdapter> mutableLiveDataB = getMViewModel().B();
        final AllOrMyOrganizeAdapter allOrMyOrganizeAdapter = new AllOrMyOrganizeAdapter(false, 1, null);
        allOrMyOrganizeAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.xu5
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                MyOrganizeActivity.j0(this.f45900a);
            }
        });
        getMBinding().f7591a.setEmptyLabel(getString(R.string.channel_my_organize_publish_empty));
        MyOrganizeVM mViewModel = getMViewModel();
        StateLayout stateLayout = getMBinding().f7591a;
        Intrinsics.checkNotNullExpressionValue(stateLayout, "mBinding.stateLayout");
        BaseStateRequestModel.p(mViewModel, this, stateLayout, allOrMyOrganizeAdapter, false, 8, null);
        BaseStateRequestModel.n(getMViewModel(), this, allOrMyOrganizeAdapter, false, 4, null);
        allOrMyOrganizeAdapter.addChildClickViewIds(R.id.ll_member, R.id.ll_published);
        y57.b(allOrMyOrganizeAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.yu5
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyOrganizeActivity.k0(allOrMyOrganizeAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        mutableLiveDataB.setValue(allOrMyOrganizeAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        MyOrganizeVM mViewModel = getMViewModel();
        String strH0 = h0();
        Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
        mViewModel.D(strH0);
        getMViewModel().y();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        g0();
        l0();
        i0();
    }

    public final void l0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.zu5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyOrganizeActivity.m0(this.f46342a, view);
            }
        }).setTitleName(getString(R.string.channel_my_organize_title)).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }
}
