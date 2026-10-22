package com.huachenjie.channel.page.organize;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.alibaba.triver.basic.api.RequestPermission;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeBinding;
import com.huachenjie.channel.page.my_channel.organize_member.OrganizeMemberActivity;
import com.huachenjie.channel.page.organize.OrganizeActivity;
import com.huachenjie.channel.page.organize.create.CreateOrganizeActivity;
import com.huachenjie.channel.page.organize.menu.OnSetAdminCallback;
import com.huachenjie.channel.page.organize.menu.OrganizeMenuMemberFragment;
import com.huachenjie.channel.page.organize.team.OrganizeTeamActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.zj.adlib.fv5;
import com.zj.adlib.tk0;
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
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%\u001aB\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001b\u0010\u001e\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/channel/page/organize/OrganizeActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeBinding;", "Lcom/huachenjie/channel/page/organize/OrganizeVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "S", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "m0", "i0", "K", "I", "REQUEST_CODE_CREATE", "L", "REQUEST_CODE_TEAM", "", "b", "Lkotlin/Lazy;", "h0", "()Ljava/lang/String;", "channelNo", "", "c", "o0", "()Z", "isAdmin", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "a", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "onRefreshListener", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class OrganizeActivity extends BaseMVVMActivity<ChannelActivityOrganizeBinding, OrganizeVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "channelAdmin";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int REQUEST_CODE_CREATE = 101;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public final int REQUEST_CODE_TEAM = 102;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.OrganizeActivity$channelNo$2
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
    public final Lazy isAdmin = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.channel.page.organize.OrganizeActivity$isAdmin$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m306invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(OrganizeActivity.x, false));
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() { // from class: com.zj.adlib.ee6
        @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
        public final void onRefresh() {
            OrganizeActivity.p0(this.f41416a);
        }
    };

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/organize/OrganizeActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/channel/page/organize/OrganizeActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CreateOrganizeActivity.Companion companion = CreateOrganizeActivity.INSTANCE;
            OrganizeActivity organizeActivity = OrganizeActivity.this;
            int i = organizeActivity.REQUEST_CODE_CREATE;
            String strH0 = OrganizeActivity.this.h0();
            Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
            companion.a(organizeActivity, i, strH0, null);
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.organize.OrganizeActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/channel/page/organize/OrganizeActivity$b;", "", "Landroid/content/Context;", "context", "", "channelNo", "", "isAdmin", "", "a", "CHANNEL_ADMIN", "Ljava/lang/String;", "CHANNEL_NO", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String channelNo, boolean isAdmin) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intent intent = new Intent(context, (Class<?>) OrganizeActivity.class);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra(OrganizeActivity.x, isAdmin);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/channel/page/organize/OrganizeActivity$c", "Lcom/huachenjie/channel/page/organize/menu/OnSetAdminCallback;", "", "adminCode", "", "finish", "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements OnSetAdminCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f33512a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ OrganizeBean f8311a;

        public c(OrganizeBean organizeBean, int i) {
            this.f8311a = organizeBean;
            this.f33512a = i;
        }

        @Override // com.huachenjie.channel.page.organize.menu.OnSetAdminCallback
        public void a(@NotNull String adminCode, boolean finish) {
            MutableLiveData<OrganizeAdapter> mutableLiveDataL;
            OrganizeAdapter value;
            Intrinsics.checkNotNullParameter(adminCode, "adminCode");
            if (finish) {
                OrganizeActivity.this.finish();
                return;
            }
            this.f8311a.setClubAdminUserCode(adminCode);
            OrganizeVM organizeVMF0 = OrganizeActivity.f0(OrganizeActivity.this);
            if (organizeVMF0 == null || (mutableLiveDataL = organizeVMF0.l()) == null || (value = mutableLiveDataL.getValue()) == null) {
                return;
            }
            value.notifyItemChanged(this.f33512a);
        }
    }

    public static final /* synthetic */ OrganizeVM f0(OrganizeActivity organizeActivity) {
        return organizeActivity.getMViewModel();
    }

    public static final void j0(OrganizeActivity organizeActivity) {
        Intrinsics.checkNotNullParameter(organizeActivity, "this$0");
        organizeActivity.getMViewModel().o();
    }

    public static final void k0(OrganizeAdapter organizeAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(organizeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        organizeAdapter.getData().get(i);
    }

    public static final void l0(OrganizeAdapter organizeAdapter, OrganizeActivity organizeActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(organizeAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(organizeActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        OrganizeBean organizeBean = organizeAdapter.getData().get(i);
        int id = view.getId();
        if (id == R.id.ll_member) {
            OrganizeMemberActivity.INSTANCE.a(organizeActivity, organizeBean.getClubCode());
            return;
        }
        if (id == R.id.tv_edit) {
            CreateOrganizeActivity.Companion companion = CreateOrganizeActivity.INSTANCE;
            int i2 = organizeActivity.REQUEST_CODE_CREATE;
            String strH0 = organizeActivity.h0();
            Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
            companion.a(organizeActivity, i2, strH0, organizeBean);
            return;
        }
        if (id == R.id.tv_appoint) {
            OrganizeMenuMemberFragment.Companion companion2 = OrganizeMenuMemberFragment.INSTANCE;
            String strH1 = organizeActivity.h0();
            Intrinsics.checkNotNullExpressionValue(strH1, "channelNo");
            OrganizeMenuMemberFragment organizeMenuMemberFragmentA = companion2.a(strH1, organizeBean.getClubCode(), organizeBean.getClubAdminUserCode(), organizeActivity.new c(organizeBean, i));
            FragmentManager supportFragmentManager = organizeActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            organizeMenuMemberFragmentA.show(supportFragmentManager, OrganizeMenuMemberFragment.class.getSimpleName());
            return;
        }
        if (id == R.id.tv_community) {
            if (!organizeActivity.o0()) {
                fv5.b("您没有群管理权限");
                return;
            }
            OrganizeTeamActivity.Companion companion3 = OrganizeTeamActivity.INSTANCE;
            int i3 = organizeActivity.REQUEST_CODE_TEAM;
            String strH2 = organizeActivity.h0();
            Intrinsics.checkNotNullExpressionValue(strH2, "channelNo");
            companion3.a(organizeActivity, i3, strH2, organizeBean);
        }
    }

    public static final void n0(OrganizeActivity organizeActivity, View view) {
        Intrinsics.checkNotNullParameter(organizeActivity, "this$0");
        organizeActivity.finish();
    }

    public static final void p0(OrganizeActivity organizeActivity) {
        Intrinsics.checkNotNullParameter(organizeActivity, "this$0");
        organizeActivity.getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.R), this.onRefreshListener), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize;
    }

    public final String h0() {
        return (String) this.channelNo.getValue();
    }

    public final void i0() {
        final OrganizeAdapter organizeAdapter = new OrganizeAdapter(o0());
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
        organizeAdapter.h(viewInflate);
        organizeAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.zj.adlib.fe6
            @Override // com.chad.library.adapter.base.listener.OnLoadMoreListener
            public final void onLoadMore() {
                OrganizeActivity.j0(this.f41653a);
            }
        });
        y57.d(organizeAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.ge6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeActivity.k0(organizeAdapter, baseQuickAdapter, view, i);
            }
        }, 1, null);
        organizeAdapter.addChildClickViewIds(R.id.ll_member, R.id.tv_edit, R.id.tv_appoint, R.id.tv_community);
        y57.b(organizeAdapter, 0L, new OnItemChildClickListener() { // from class: com.zj.adlib.he6
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeActivity.l0(organizeAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().l().setValue(organizeAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().m().setValue(h0());
        getMViewModel().q();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        m0();
        i0();
    }

    public final void m0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.de6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizeActivity.n0(this.f41162a, view);
            }
        }).setTitleName("官方组织").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    public final boolean o0() {
        return ((Boolean) this.isAdmin.getValue()).booleanValue();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1) {
            return;
        }
        if (requestCode == this.REQUEST_CODE_CREATE) {
            if (data != null && data.getBooleanExtra("result", false)) {
                getMViewModel().q();
                return;
            }
            if (data != null && data.getBooleanExtra("finish", false)) {
                finish();
                return;
            }
            return;
        }
        if (requestCode == this.REQUEST_CODE_TEAM) {
            if (data != null && data.getBooleanExtra("result", false)) {
                getMViewModel().q();
                return;
            }
            if (data != null && data.getBooleanExtra("finish", false)) {
                finish();
            }
        }
    }
}
