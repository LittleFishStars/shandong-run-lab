package com.huachenjie.channel.page.organize.team;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.p002lifecycle.Observer;
import com.alibaba.triver.basic.api.RequestPermission;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.gyf.immersionbar.e;
import com.huachenjie.base.widget.dialog.OnSaveInputListener;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.huachenjie.channel.R;
import com.huachenjie.channel.bean.OrganizeBean;
import com.huachenjie.channel.bean.OrganizeTeamBean;
import com.huachenjie.channel.databinding.ChannelActivityOrganizeTeamBinding;
import com.huachenjie.channel.page.organize.team.OrganizeTeamActivity;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.qi1;
import com.zj.adlib.ri1;
import com.zj.adlib.tk0;
import com.zj.adlib.y57;
import com.zj.adlib.zn1;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002#\u0016B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001eR\"\u0010%\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010!0!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010&¨\u0006*"}, d2 = {"Lcom/huachenjie/channel/page/organize/team/OrganizeTeamActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityOrganizeTeamBinding;", "Lcom/huachenjie/channel/page/organize/team/OrganizeTeamVM;", "", "getLayoutResID", "", "", "V", "", "initView", "initData", "W", "S", "onBackPressed", "k0", "i0", "f0", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "teamBean", "n0", "", "b", "Lkotlin/Lazy;", "h0", "()Ljava/lang/String;", "channelNo", "Lcom/huachenjie/channel/bean/OrganizeBean;", "c", "g0", "()Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "a", "Landroidx/activity/result/ActivityResultLauncher;", "mManageLauncher", "Lcom/huachenjie/channel/bean/OrganizeTeamBean;", "clickTeam", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nOrganizeTeamActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OrganizeTeamActivity.kt\ncom/huachenjie/channel/page/organize/team/OrganizeTeamActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,240:1\n350#2,7:241\n*S KotlinDebug\n*F\n+ 1 OrganizeTeamActivity.kt\ncom/huachenjie/channel/page/organize/team/OrganizeTeamActivity\n*L\n95#1:241,7\n*E\n"})
public final class OrganizeTeamActivity extends BaseMVVMActivity<ChannelActivityOrganizeTeamBinding, OrganizeTeamVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "channelNo";

    @NotNull
    public static final String x = "OrganizeInfo";

    @NotNull
    public static final String y = "result";

    @NotNull
    public static final String z = "finish";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ActivityResultLauncher<Intent> mManageLauncher;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public OrganizeTeamBean clickTeam;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.organize.team.OrganizeTeamActivity$channelNo$2
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
    public final Lazy bean = LazyKt.lazy(new Function0<OrganizeBean>() { // from class: com.huachenjie.channel.page.organize.team.OrganizeTeamActivity$bean$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final OrganizeBean m313invoke() {
            OrganizeBean organizeBean = (OrganizeBean) this.this$0.getIntent().getParcelableExtra("OrganizeInfo");
            return organizeBean == null ? new OrganizeBean(null, null, null, 0, null, 0, null, null, 0, 511, null) : organizeBean;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/channel/page/organize/team/OrganizeTeamActivity$a;", "", "Landroid/view/View;", "view", "", "b", "<init>", "(Lcom/huachenjie/channel/page/organize/team/OrganizeTeamActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void c(OrganizeTeamActivity organizeTeamActivity, Dialog dialog, String str) {
            Intrinsics.checkNotNullParameter(organizeTeamActivity, "this$0");
            if (TextUtils.isEmpty(str)) {
                fv5.b("未设置群名称～");
                return;
            }
            dialog.dismiss();
            OrganizeTeamVM organizeTeamVME0 = OrganizeTeamActivity.e0(organizeTeamActivity);
            String strH0 = organizeTeamActivity.h0();
            Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
            String clubCode = organizeTeamActivity.g0().getClubCode();
            Intrinsics.checkNotNullExpressionValue(str, "text");
            organizeTeamVME0.j(strH0, clubCode, str);
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            final OrganizeTeamActivity organizeTeamActivity = OrganizeTeamActivity.this;
            ft1.x(context, "新建社群", "", "请输入社群标题名称", 10, OptionsPickerHelper.e, OptionsPickerHelper.f, new OnSaveInputListener() { // from class: com.zj.adlib.df6
                @Override // com.huachenjie.base.widget.dialog.OnSaveInputListener
                public final void a(Dialog dialog, String str) {
                    OrganizeTeamActivity.a.c(organizeTeamActivity, dialog, str);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.organize.team.OrganizeTeamActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/channel/page/organize/team/OrganizeTeamActivity$b;", "", "Landroid/app/Activity;", "context", "", RequestPermission.REQUEST_CODE, "", "channelNo", "Lcom/huachenjie/channel/bean/OrganizeBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "", "a", "CHANNEL_NO", "Ljava/lang/String;", "FINISH", "ORGANIZE_INFO", com.alipay.android.phone.mobilesdk.socketcraft.e.c.j, "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Activity context, int requestCode, @NotNull String channelNo, @NotNull OrganizeBean bean) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(bean, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            Intent intent = new Intent(context, (Class<?>) OrganizeTeamActivity.class);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra("OrganizeInfo", bean);
            context.startActivityForResult(intent, requestCode);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33525a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33525a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33525a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33525a.invoke(obj);
        }
    }

    public OrganizeTeamActivity() {
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.zj.adlib.af6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                OrganizeTeamActivity.m0(this.f40523a, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…}\n            }\n        }");
        this.mManageLauncher = activityResultLauncherRegisterForActivityResult;
    }

    public static final /* synthetic */ OrganizeTeamVM e0(OrganizeTeamActivity organizeTeamActivity) {
        return organizeTeamActivity.getMViewModel();
    }

    public static final void j0(OrganizeTeamAdapter organizeTeamAdapter, OrganizeTeamActivity organizeTeamActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(organizeTeamAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(organizeTeamActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        organizeTeamActivity.n0(organizeTeamAdapter.getData().get(i));
    }

    public static final void l0(OrganizeTeamActivity organizeTeamActivity, View view) {
        Intrinsics.checkNotNullParameter(organizeTeamActivity, "this$0");
        organizeTeamActivity.f0();
    }

    public static final void m0(OrganizeTeamActivity organizeTeamActivity, ActivityResult activityResult) {
        List<OrganizeTeamBean> data;
        OrganizeTeamBean organizeTeamBean;
        OrganizeTeamAdapter value;
        Intrinsics.checkNotNullParameter(organizeTeamActivity, "this$0");
        int i = -1;
        if (activityResult.getResultCode() != -1 || activityResult.getData() == null) {
            return;
        }
        Intent data2 = activityResult.getData();
        Intrinsics.checkNotNull(data2);
        int intExtra = data2.getIntExtra("result_type", -1);
        if (intExtra != 1) {
            if (intExtra != 2 || (organizeTeamBean = organizeTeamActivity.clickTeam) == null || (value = organizeTeamActivity.getMViewModel().k().getValue()) == null) {
                return;
            }
            Intent data3 = activityResult.getData();
            Intrinsics.checkNotNull(data3);
            int intExtra2 = data3.getIntExtra(TeamMemberManageActivity.x, 0);
            Iterator<OrganizeTeamBean> it = value.getData().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getTeamId(), organizeTeamBean.getTeamId())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i >= 0 && i < value.getData().size()) {
                value.getData().get(i).setTeamCount(intExtra2);
                value.notifyItemChanged(i);
                return;
            }
            return;
        }
        OrganizeTeamBean organizeTeamBean2 = organizeTeamActivity.clickTeam;
        if (organizeTeamBean2 == null) {
            return;
        }
        OrganizeTeamAdapter value2 = organizeTeamActivity.getMViewModel().k().getValue();
        if ((value2 == null || (data = value2.getData()) == null || data.size() != 1) ? false : true) {
            OrganizeTeamAdapter value3 = organizeTeamActivity.getMViewModel().k().getValue();
            if (value3 != null) {
                value3.remove(organizeTeamBean2);
            }
            OrganizeTeamAdapter value4 = organizeTeamActivity.getMViewModel().k().getValue();
            if (value4 != null) {
                value4.h();
            }
        } else {
            OrganizeTeamAdapter value5 = organizeTeamActivity.getMViewModel().k().getValue();
            if (value5 != null) {
                value5.remove(organizeTeamBean2);
            }
        }
        organizeTeamActivity.clickTeam = null;
        ri1 ri1Var = ri1.f19330a;
        String strH0 = organizeTeamActivity.h0();
        Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
        ri1Var.b(organizeTeamActivity, strH0, 7);
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().m().observe(this, new c(new Function1<OrganizeTeamBean, Unit>() { // from class: com.huachenjie.channel.page.organize.team.OrganizeTeamActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((OrganizeTeamBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable OrganizeTeamBean organizeTeamBean) {
                if (organizeTeamBean != null) {
                    qi1 qi1Var = qi1.f44215a;
                    OrganizeTeamActivity organizeTeamActivity = this.this$0;
                    String strH0 = organizeTeamActivity.h0();
                    Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
                    qi1Var.a(organizeTeamActivity, strH0, organizeTeamBean.getTeamId(), true);
                    ri1 ri1Var = ri1.f19330a;
                    OrganizeTeamActivity organizeTeamActivity2 = this.this$0;
                    String strH1 = organizeTeamActivity2.h0();
                    Intrinsics.checkNotNullExpressionValue(strH1, "channelNo");
                    ri1Var.b(organizeTeamActivity2, strH1, 7);
                }
            }
        }));
        getMViewModel().l().observe(this, new c(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.organize.team.OrganizeTeamActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ri1 ri1Var = ri1.f19330a;
                    OrganizeTeamActivity organizeTeamActivity = this.this$0;
                    String strH0 = organizeTeamActivity.h0();
                    Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
                    ri1Var.b(organizeTeamActivity, strH0, 1);
                    Intent intent = new Intent();
                    intent.putExtra("finish", true);
                    this.this$0.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final void f0() {
        Intent intent = new Intent();
        intent.putExtra("result", true);
        setResult(-1, intent);
        finish();
    }

    public final OrganizeBean g0() {
        return (OrganizeBean) this.bean.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_organize_team;
    }

    public final String h0() {
        return (String) this.channelNo.getValue();
    }

    public final void i0() {
        final OrganizeTeamAdapter organizeTeamAdapter = new OrganizeTeamAdapter();
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
        organizeTeamAdapter.g(viewInflate);
        y57.d(organizeTeamAdapter, 0L, new OnItemClickListener() { // from class: com.zj.adlib.bf6
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                OrganizeTeamActivity.j0(organizeTeamAdapter, this, baseQuickAdapter, view, i);
            }
        }, 1, null);
        getMViewModel().k().setValue(organizeTeamAdapter);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().n(g0());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        k0();
        i0();
    }

    public final void k0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        getMViewModel().i().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackground(-1).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.cf6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrganizeTeamActivity.l0(this.f40961a, view);
            }
        }).setTitleName("社群管理").setTitleTextColor(zn1.a(R.color.color_2C3E50)).setShowDivider(true));
    }

    public final void n0(OrganizeTeamBean teamBean) {
        this.clickTeam = teamBean;
        ActivityResultLauncher<Intent> activityResultLauncher = this.mManageLauncher;
        TeamMemberManageActivity.Companion companion = TeamMemberManageActivity.INSTANCE;
        String teamId = teamBean.getTeamId();
        String strH0 = h0();
        Intrinsics.checkNotNullExpressionValue(strH0, "channelNo");
        activityResultLauncher.launch(companion.b(this, teamId, strH0, teamBean.getTeamCode()));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        f0();
    }
}
