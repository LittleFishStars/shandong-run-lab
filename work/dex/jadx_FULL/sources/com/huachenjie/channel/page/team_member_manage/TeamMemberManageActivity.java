package com.huachenjie.channel.page.team_member_manage;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.gyf.immersionbar.e;
import com.huachenjie.channel.R;
import com.huachenjie.channel.databinding.ChannelActivityTeamMemberManageBinding;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.bean.TeamMemberBean;
import com.igexin.push.g.o;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.p44;
import com.zj.adlib.tk0;
import com.zj.adlib.ws1;
import com.zj.adlib.wt1;
import com.zj.adlib.z19;
import com.zj.adlib.zn1;
import java.util.ArrayList;
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
import kotlin.collections.CollectionsKt;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)\u0015B\u0007¢\u0006\u0004\b'\u0010(J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010 \u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010#\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u001b\u0010&\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018¨\u0006*"}, d2 = {"Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/channel/databinding/ChannelActivityTeamMemberManageBinding;", "Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM;", "", "", "", "V", "getLayoutResID", "", "S", "initView", "initData", "W", "onBackPressed", "", "darkMode", "o0", "m0", "l0", "", "b", "Lkotlin/Lazy;", "k0", "()Ljava/lang/String;", "teamId", "c", "i0", TeamMemberManageActivity.z, "d", "h0", "()Z", TeamMemberManageActivity.A, "e", "g0", "channelNo", "f", "j0", TeamMemberManageActivity.C, "<init>", "()V", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
public final class TeamMemberManageActivity extends BaseMVVMActivity<ChannelActivityTeamMemberManageBinding, TeamMemberManageVM> {

    @NotNull
    public static final String A = "fromOrganizeTeam";

    @NotNull
    public static final String B = "channelNo";

    @NotNull
    public static final String C = "teamCode";
    public static final int K = 1;
    public static final int L = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String t = "result_type";

    @NotNull
    public static final String x = "result_member_count";

    @NotNull
    public static final String y = "teamId";

    @NotNull
    public static final String z = "subjectGroupNo";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy teamId = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$teamId$2
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
    public final Lazy subjectGroupNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$subjectGroupNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(TeamMemberManageActivity.z);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy fromOrganizeTeam = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$fromOrganizeTeam$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m317invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(TeamMemberManageActivity.A, false));
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy channelNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$channelNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra("channelNo");
            return stringExtra == null ? "" : stringExtra;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy teamCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$teamCode$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String stringExtra = this.this$0.getIntent().getStringExtra(TeamMemberManageActivity.C);
            return stringExtra == null ? "" : stringExtra;
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$a;", "", "Landroid/view/View;", "view", "", "e", "c", "<init>", "(Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity;)V", "channel_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nTeamMemberManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeamMemberManageActivity.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$ClickProxy\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n1549#2:220\n1620#2,3:221\n*S KotlinDebug\n*F\n+ 1 TeamMemberManageActivity.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$ClickProxy\n*L\n164#1:220\n164#1:221,3\n*E\n"})
    public final class a {

        /* JADX INFO: renamed from: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$a$a", "Lcom/huachenjie/im/DefaultCallback;", "Ljava/lang/Void;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
        @SourceDebugExtension({"SMAP\nTeamMemberManageActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeamMemberManageActivity.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$ClickProxy$clickRemove$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,219:1\n1855#2,2:220\n*S KotlinDebug\n*F\n+ 1 TeamMemberManageActivity.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$ClickProxy$clickRemove$1$1\n*L\n178#1:220,2\n*E\n"})
        public static final class C0792a extends DefaultCallback<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TeamMemberManageActivity f33531a;

            public C0792a(TeamMemberManageActivity teamMemberManageActivity) {
                this.f33531a = teamMemberManageActivity;
            }

            @Override // com.huachenjie.im.DefaultCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(int code, @Nullable Void result, @Nullable Throwable exception) {
                if (code != 200) {
                    fv5.b("移出失败");
                    return;
                }
                List<TeamMemberBean> listS = TeamMemberManageActivity.c0(this.f33531a).s();
                TeamMemberManageActivity teamMemberManageActivity = this.f33531a;
                for (TeamMemberBean teamMemberBean : listS) {
                    TeamMemberManageActivity.c0(teamMemberManageActivity).q().remove(teamMemberBean);
                    TeamMemberManageAdapter value = TeamMemberManageActivity.c0(teamMemberManageActivity).n().getValue();
                    if (value != null) {
                        value.remove(teamMemberBean);
                    }
                }
                TeamMemberManageActivity.c0(this.f33531a).t().setValue(Integer.valueOf(TeamMemberManageActivity.c0(this.f33531a).q().size()));
                TeamMemberManageActivity.c0(this.f33531a).r().setValue(0);
                TeamMemberManageActivity.c0(this.f33531a).s().clear();
            }
        }

        public a() {
        }

        public static final void d(TeamMemberManageActivity teamMemberManageActivity, View view) {
            Intrinsics.checkNotNullParameter(teamMemberManageActivity, "this$0");
            if (!teamMemberManageActivity.h0()) {
                TeamMemberManageVM teamMemberManageVMC0 = TeamMemberManageActivity.c0(teamMemberManageActivity);
                String strI0 = teamMemberManageActivity.i0();
                Intrinsics.checkNotNullExpressionValue(strI0, TeamMemberManageActivity.z);
                teamMemberManageVMC0.m(strI0);
                return;
            }
            TeamMemberManageVM teamMemberManageVMC1 = TeamMemberManageActivity.c0(teamMemberManageActivity);
            String strG0 = teamMemberManageActivity.g0();
            Intrinsics.checkNotNullExpressionValue(strG0, "channelNo");
            String strJ0 = teamMemberManageActivity.j0();
            Intrinsics.checkNotNullExpressionValue(strJ0, TeamMemberManageActivity.C);
            teamMemberManageVMC1.l(strG0, strJ0);
        }

        public static final void f(TeamMemberManageActivity teamMemberManageActivity, List list, View view) {
            Intrinsics.checkNotNullParameter(teamMemberManageActivity, "this$0");
            Intrinsics.checkNotNullParameter(list, "$members");
            z19.v(teamMemberManageActivity.k0(), list, new C0792a(teamMemberManageActivity));
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (TextUtils.isEmpty(TeamMemberManageActivity.c0(TeamMemberManageActivity.this).u().getValue())) {
                fv5.b("该群已解散");
                return;
            }
            ws1 ws1VarQ = ft1.h(view.getContext()).Q("确认解散该话题群吗？");
            final TeamMemberManageActivity teamMemberManageActivity = TeamMemberManageActivity.this;
            ws1VarQ.J(new View.OnClickListener() { // from class: com.zj.adlib.f29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TeamMemberManageActivity.a.d(teamMemberManageActivity, view2);
                }
            }).Y();
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            List<TeamMemberBean> listS = TeamMemberManageActivity.c0(TeamMemberManageActivity.this).s();
            final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listS, 10));
            Iterator<T> it = listS.iterator();
            while (true) {
                String str = "";
                if (!it.hasNext()) {
                    break;
                }
                String accId = ((TeamMemberBean) it.next()).getAccId();
                if (accId != null) {
                    str = accId;
                }
                arrayList.add(str);
            }
            if (arrayList.isEmpty()) {
                ft1.h(view.getContext()).Q("请先勾选要移出的成员").F("").Y();
                return;
            }
            ws1 ws1VarQ = ft1.h(view.getContext()).Q("确定要移出勾选的成员吗？");
            final TeamMemberManageActivity teamMemberManageActivity = TeamMemberManageActivity.this;
            ws1VarQ.J(new View.OnClickListener() { // from class: com.zj.adlib.e29
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TeamMemberManageActivity.a.f(teamMemberManageActivity, arrayList, view2);
                }
            }).Y();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$b;", "", "Landroid/content/Context;", "context", "", "teamId", TeamMemberManageActivity.z, "Landroid/content/Intent;", "a", "channelNo", TeamMemberManageActivity.C, "b", "FROM_ORGANIZE_TEAM", "Ljava/lang/String;", "KEY_CHANNEL_NO", "KEY_SUBJECT_GROUP_NO", "KEY_TEAM_CODE", "KEY_TEAM_ID", "RESULT_MEMBER_COUNT", "RESULT_TYPE", "", "TYPE_DISSOLVE", "I", "TYPE_REMOVE_MEMBER", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent a(@NotNull Context context, @NotNull String teamId, @NotNull String subjectGroupNo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            Intrinsics.checkNotNullParameter(subjectGroupNo, TeamMemberManageActivity.z);
            Intent intent = new Intent(context, (Class<?>) TeamMemberManageActivity.class);
            intent.putExtra("teamId", teamId);
            intent.putExtra(TeamMemberManageActivity.z, subjectGroupNo);
            intent.putExtra(TeamMemberManageActivity.A, false);
            return intent;
        }

        @NotNull
        public final Intent b(@NotNull Context context, @NotNull String teamId, @NotNull String channelNo, @NotNull String teamCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            Intrinsics.checkNotNullParameter(channelNo, "channelNo");
            Intrinsics.checkNotNullParameter(teamCode, TeamMemberManageActivity.C);
            Intent intent = new Intent(context, (Class<?>) TeamMemberManageActivity.class);
            intent.putExtra("teamId", teamId);
            intent.putExtra(TeamMemberManageActivity.A, true);
            intent.putExtra("channelNo", channelNo);
            intent.putExtra(TeamMemberManageActivity.C, teamCode);
            return intent;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\n"}, d2 = {"com/huachenjie/channel/page/team_member_manage/TeamMemberManageActivity$c", "Lcom/huachenjie/im/DefaultCallback;", "Lcom/huachenjie/im/bean/IMTokenBean;", "", "code", "result", "", com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, "", "a", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DefaultCallback<IMTokenBean> {
        public c() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int code, @Nullable IMTokenBean result, @Nullable Throwable exception) {
            if (code != 200 || result == null) {
                return;
            }
            TeamMemberManageActivity.c0(TeamMemberManageActivity.this).p().setValue(result.getAccid());
            TeamMemberManageVM teamMemberManageVMC0 = TeamMemberManageActivity.c0(TeamMemberManageActivity.this);
            String strK0 = TeamMemberManageActivity.this.k0();
            Intrinsics.checkNotNullExpressionValue(strK0, "teamId");
            teamMemberManageVMC0.x(strK0);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class d implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f33533a;

        public d(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f33533a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f33533a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f33533a.invoke(obj);
        }
    }

    public static final /* synthetic */ TeamMemberManageVM c0(TeamMemberManageActivity teamMemberManageActivity) {
        return teamMemberManageActivity.getMViewModel();
    }

    public static final void n0(TeamMemberManageActivity teamMemberManageActivity, View view) {
        Intrinsics.checkNotNullParameter(teamMemberManageActivity, "this$0");
        teamMemberManageActivity.onBackPressed();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        o0(true);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(tk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(tk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().t().observe(this, new d(new Function1<Integer, Unit>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Integer) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Integer num) {
                Intrinsics.checkNotNullExpressionValue(num, o.f);
                if (num.intValue() > 0) {
                    BindingTitleBean value = TeamMemberManageActivity.c0(this.this$0).i().getValue();
                    if (value == null) {
                        value = new BindingTitleBean();
                    }
                    value.setTitleName("群成员" + num);
                    TeamMemberManageActivity.c0(this.this$0).i().setValue(value);
                }
            }
        }));
        getMViewModel().o().observe(this, new d(new Function1<Boolean, Unit>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    wt1.h().d(this.this$0.k0());
                    TeamMemberManageActivity teamMemberManageActivity = this.this$0;
                    Intent intent = new Intent();
                    intent.putExtra("result_type", 1);
                    Unit unit = Unit.INSTANCE;
                    teamMemberManageActivity.setResult(-1, intent);
                    this.this$0.finish();
                }
            }
        }));
    }

    public final String g0() {
        return (String) this.channelNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.channel_activity_team_member_manage;
    }

    public final boolean h0() {
        return ((Boolean) this.fromOrganizeTeam.getValue()).booleanValue();
    }

    public final String i0() {
        return (String) this.subjectGroupNo.getValue();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        p44.x(new c());
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        m0();
        l0();
    }

    public final String j0() {
        return (String) this.teamCode.getValue();
    }

    public final String k0() {
        return (String) this.teamId.getValue();
    }

    public final void l0() {
        getMBinding().f7695a.setSearchListener(new Function1<String, Unit>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$initSearch$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "searchStr");
                TeamMemberManageActivity.c0(this.this$0).y(str);
            }
        });
        getMBinding().f7695a.setClearListener(new Function0<Unit>() { // from class: com.huachenjie.channel.page.team_member_manage.TeamMemberManageActivity$initSearch$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m318invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m318invoke() {
                TeamMemberManageActivity.c0(this.this$0).y("");
            }
        });
    }

    public final void m0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        mutableLiveDataI.setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setBackground(-1).setTitleName("群成员").setTitleTextColor(zn1.a(com.huachenjie.im.R.color.color_2C3E50)).setBackIconResId(com.huachenjie.im.R.drawable.ic_back_black).setBackTintColor(-16777216).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.d29
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TeamMemberManageActivity.n0(this.f41095a, view);
            }
        }).setShowDivider(true));
    }

    public final void o0(boolean darkMode) {
        View decorView = getWindow().getDecorView();
        int i = com.huachenjie.im.R.color.white;
        decorView.setBackgroundColor(zn1.a(i));
        e.p3(this).G2(com.huachenjie.im.R.color.transparent).T2(darkMode).q1(false).u1(i).G1(true).a1();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("result_type", 2);
        intent.putExtra(x, getMViewModel().t().getValue());
        Unit unit = Unit.INSTANCE;
        setResult(-1, intent);
        super.onBackPressed();
    }
}
