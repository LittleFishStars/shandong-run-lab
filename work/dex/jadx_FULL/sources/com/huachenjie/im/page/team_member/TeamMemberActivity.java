package com.huachenjie.im.page.team_member;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.gyf.immersionbar.e;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.R;
import com.huachenjie.im.databinding.ActivityTeamMemberBinding;
import com.huachenjie.im.page.TeamChatActivity;
import com.huachenjie.im.page.team_member.TeamMemberActivity;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.yk0;
import com.zj.adlib.z19;
import com.zj.adlib.zn1;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0007¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001b\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016¨\u0006\""}, d2 = {"Lcom/huachenjie/im/page/team_member/TeamMemberActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/im/databinding/ActivityTeamMemberBinding;", "Lcom/huachenjie/im/page/team_member/TeamMemberVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "", "darkMode", "l0", "h0", "g0", "", "b", "Lkotlin/Lazy;", "e0", "()Ljava/lang/String;", "teamId", "c", "f0", "()I", TeamMemberActivity.x, "d", "d0", TeamMemberActivity.y, "<init>", "()V", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
public final class TeamMemberActivity extends BaseMVVMActivity<ActivityTeamMemberBinding, TeamMemberVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "teamId";

    @NotNull
    public static final String x = "teamUserNum";

    @NotNull
    public static final String y = "mineAccId";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy teamId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.im.page.team_member.TeamMemberActivity$teamId$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("teamId");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy teamUserNum = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.im.page.team_member.TeamMemberActivity$teamUserNum$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m442invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra(TeamMemberActivity.x, 0));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy mineAccId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.im.page.team_member.TeamMemberActivity$mineAccId$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(TeamMemberActivity.y);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.im.page.team_member.TeamMemberActivity$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/im/page/team_member/TeamMemberActivity$a;", "", "Landroid/content/Context;", "context", "", "teamId", "", TeamMemberActivity.x, TeamMemberActivity.y, "", "a", "KEY_MINE_ACCID", "Ljava/lang/String;", "KEY_TEAM_ID", "KEY_TEAM_USER_NUM", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String teamId, int teamUserNum, @NotNull String mineAccId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            Intrinsics.checkNotNullParameter(mineAccId, TeamMemberActivity.y);
            Intent intent = new Intent(context, (Class<?>) TeamMemberActivity.class);
            intent.putExtra("teamId", teamId);
            intent.putExtra(TeamMemberActivity.x, teamUserNum);
            intent.putExtra(TeamMemberActivity.y, mineAccId);
            context.startActivity(intent);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/im/page/team_member/TeamMemberActivity$b", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", c.f25231a, "", "a", "IM_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DefaultCallback<Void> {
        public b() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
            if (code != 200 && code != 803 && code != 804) {
                fv5.b("退出失败");
            } else {
                ActivityLifecycleManager.l().f(TeamChatActivity.class);
                TeamMemberActivity.this.finish();
            }
        }
    }

    public static final void i0(TeamMemberActivity teamMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(teamMemberActivity, "this$0");
        teamMemberActivity.finish();
    }

    public static final void j0(final TeamMemberActivity teamMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(teamMemberActivity, "this$0");
        if (TextUtils.isEmpty(teamMemberActivity.getMViewModel().n().getValue())) {
            fv5.b("该群已解散");
        } else if (TextUtils.equals(teamMemberActivity.getMViewModel().n().getValue(), teamMemberActivity.getMViewModel().l().getValue())) {
            fv5.b("群主不支持退出群聊~");
        } else {
            ft1.h(view.getContext()).Q("确认退出该话题群吗？").J(new View.OnClickListener() { // from class: com.zj.adlib.a29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TeamMemberActivity.k0(this.f40439a, view2);
                }
            }).Y();
        }
    }

    public static final void k0(TeamMemberActivity teamMemberActivity, View view) {
        Intrinsics.checkNotNullParameter(teamMemberActivity, "this$0");
        z19.t(teamMemberActivity.e0(), teamMemberActivity.new b());
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        l0(true);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(TuplesKt.to(Integer.valueOf(yk0.p0), getMViewModel()));
    }

    public final String d0() {
        return (String) this.mineAccId.getValue();
    }

    public final String e0() {
        return (String) this.teamId.getValue();
    }

    public final int f0() {
        return ((Number) this.teamUserNum.getValue()).intValue();
    }

    public final void g0() {
        getMBinding().f34409a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.im.page.team_member.TeamMemberActivity$initSearch$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "searchStr");
                this.this$0.getMViewModel().q(str);
            }
        });
        getMBinding().f34409a.setClearListener(new Function0<Unit>() { // from class: com.huachenjie.im.page.team_member.TeamMemberActivity$initSearch$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m439invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m439invoke() {
                this.this$0.getMViewModel().q("");
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.activity_team_member;
    }

    public final void h0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("群成员(" + f0() + ')').setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.b29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamMemberActivity.i0(this.f40664a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().l().setValue(d0());
        TeamMemberVM mViewModel = getMViewModel();
        String strE0 = e0();
        Intrinsics.checkNotNullExpressionValue(strE0, "teamId");
        mViewModel.p(strE0);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        h0();
        g0();
        getMBinding().f9657a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.c29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamMemberActivity.j0(this.f40888a, view);
            }
        });
    }

    public final void l0(boolean darkMode) {
        View decorView = getWindow().getDecorView();
        int i = R.color.white;
        decorView.setBackgroundColor(zn1.a(i));
        e.p3(this).G2(R.color.transparent).T2(darkMode).q1(false).u1(i).G1(true).a1();
    }
}
