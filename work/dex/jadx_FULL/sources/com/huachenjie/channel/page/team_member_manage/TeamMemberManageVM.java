package com.huachenjie.channel.page.team_member_manage;

import android.text.TextUtils;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.channel.page.team_member_manage.TeamMemberManageVM;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.TeamMemberBean;
import com.huachenjie.im.page.team_member.TeamMemberActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.y57;
import com.zj.adlib.y6b;
import com.zj.adlib.z19;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002R%\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f8\u0006¢\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b%\u0010#R%\u0010*\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010'0'0\u00118\u0006¢\u0006\f\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017R%\u0010-\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010'0'0\u00118\u0006¢\u0006\f\n\u0004\b+\u0010\u0015\u001a\u0004\b,\u0010\u0017R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00118\u0006¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b0\u0010\u0017¨\u00064"}, d2 = {"Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "chatTeamId", "", "x", "searchStr", "y", TeamMemberManageActivity.z, "m", "channelNo", TeamMemberManageActivity.C, t.d, "", "Lcom/huachenjie/im/bean/TeamMemberBean;", "teamMemberList", "w", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/channel/page/team_member_manage/TeamMemberManageAdapter;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "n", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "c", "p", TeamMemberActivity.y, "d", "u", "teamOwnerId", "", "a", "Ljava/util/List;", "q", "()Ljava/util/List;", "originFriendList", "s", "selectTeamMembers", "", "e", "r", "selectNum", "f", "t", "teamMemberNum", "", y6b.f, j.b, "dissolveFlag", "<init>", "()V", "channel_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTeamMemberManageVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeamMemberManageVM.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n1#2:112\n1855#3,2:113\n*S KotlinDebug\n*F\n+ 1 TeamMemberManageVM.kt\ncom/huachenjie/channel/page/team_member_manage/TeamMemberManageVM\n*L\n86#1:113,2\n*E\n"})
public final class TeamMemberManageVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final List<TeamMemberBean> originFriendList;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TeamMemberManageAdapter> adapter;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> mineAccId;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<TeamMemberBean> selectTeamMembers;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> teamOwnerId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectNum;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> teamMemberNum;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> dissolveFlag;

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/channel/page/team_member_manage/TeamMemberManageVM$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/TeamMemberBean;", "", "code", "result", "", c.f25231a, "", "onResult", "channel_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DefaultCallback<List<? extends TeamMemberBean>> {
        public a() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        public /* bridge */ /* synthetic */ void onResult(int i, List<? extends TeamMemberBean> list, Throwable th) {
            onResult2(i, (List<TeamMemberBean>) list, th);
        }

        /* JADX INFO: renamed from: onResult, reason: avoid collision after fix types in other method */
        public void onResult2(int code, @Nullable List<TeamMemberBean> result, @Nullable Throwable exception) {
            if (code != 200 || result == null) {
                return;
            }
            TeamMemberManageVM.this.w(result);
        }
    }

    public TeamMemberManageVM() {
        MutableLiveData<TeamMemberManageAdapter> mutableLiveData = new MutableLiveData<>(new TeamMemberManageAdapter());
        this.adapter = mutableLiveData;
        this.mineAccId = new MutableLiveData<>();
        this.teamOwnerId = new MutableLiveData<>();
        this.originFriendList = new ArrayList();
        this.selectTeamMembers = new ArrayList();
        this.selectNum = new MutableLiveData<>(0);
        this.teamMemberNum = new MutableLiveData<>(0);
        this.dissolveFlag = new MutableLiveData<>();
        final TeamMemberManageAdapter value = mutableLiveData.getValue();
        if (value != null) {
            y57.d(value, 0L, new OnItemClickListener() { // from class: com.zj.adlib.g29
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    TeamMemberManageVM.v(value, this, baseQuickAdapter, view, i);
                }
            }, 1, null);
        }
    }

    public static final void v(TeamMemberManageAdapter teamMemberManageAdapter, TeamMemberManageVM teamMemberManageVM, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(teamMemberManageAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(teamMemberManageVM, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        TeamMemberBean teamMemberBean = teamMemberManageAdapter.getData().get(i);
        if (Intrinsics.areEqual(teamMemberBean.isOwner(), Boolean.TRUE)) {
            return;
        }
        if (teamMemberBean.isSelect()) {
            teamMemberBean.setSelect(false);
            teamMemberManageVM.selectTeamMembers.remove(teamMemberBean);
        } else {
            teamMemberBean.setSelect(true);
            teamMemberManageVM.selectTeamMembers.add(teamMemberBean);
        }
        teamMemberManageVM.selectNum.setValue(Integer.valueOf(teamMemberManageVM.selectTeamMembers.size()));
        teamMemberManageAdapter.notifyItemChanged(i);
    }

    public final void l(@NotNull String channelNo, @NotNull String teamCode) {
        Intrinsics.checkNotNullParameter(channelNo, "channelNo");
        Intrinsics.checkNotNullParameter(teamCode, TeamMemberManageActivity.C);
        BaseViewModelExtKt.b(this, true, false, null, null, new TeamMemberManageVM$dissolveOrganizeGroup$1(channelNo, teamCode, this, null), 14, null);
    }

    public final void m(@NotNull String subjectGroupNo) {
        Intrinsics.checkNotNullParameter(subjectGroupNo, TeamMemberManageActivity.z);
        BaseViewModelExtKt.b(this, true, false, null, null, new TeamMemberManageVM$dissolveSubjectGroup$1(this, subjectGroupNo, null), 14, null);
    }

    @NotNull
    public final MutableLiveData<TeamMemberManageAdapter> n() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.dissolveFlag;
    }

    @NotNull
    public final MutableLiveData<String> p() {
        return this.mineAccId;
    }

    @NotNull
    public final List<TeamMemberBean> q() {
        return this.originFriendList;
    }

    @NotNull
    public final MutableLiveData<Integer> r() {
        return this.selectNum;
    }

    @NotNull
    public final List<TeamMemberBean> s() {
        return this.selectTeamMembers;
    }

    @NotNull
    public final MutableLiveData<Integer> t() {
        return this.teamMemberNum;
    }

    @NotNull
    public final MutableLiveData<String> u() {
        return this.teamOwnerId;
    }

    public final void w(List<TeamMemberBean> teamMemberList) {
        Object next;
        Iterator<T> it = teamMemberList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((TeamMemberBean) next).isOwner(), Boolean.TRUE));
        TeamMemberBean teamMemberBean = (TeamMemberBean) next;
        if (teamMemberBean != null) {
            MutableLiveData<String> mutableLiveData = this.teamOwnerId;
            String accId = teamMemberBean.getAccId();
            if (accId == null) {
                accId = "";
            }
            mutableLiveData.setValue(accId);
        }
        this.originFriendList.clear();
        this.originFriendList.addAll(teamMemberList);
        this.teamMemberNum.setValue(Integer.valueOf(this.originFriendList.size()));
        TeamMemberManageAdapter value = this.adapter.getValue();
        if (value != null) {
            value.setList(this.originFriendList);
        }
    }

    public final void x(@NotNull String chatTeamId) {
        Intrinsics.checkNotNullParameter(chatTeamId, "chatTeamId");
        z19.p(chatTeamId, new a());
    }

    public final void y(@NotNull String searchStr) {
        Intrinsics.checkNotNullParameter(searchStr, "searchStr");
        if (TextUtils.isEmpty(searchStr)) {
            TeamMemberManageAdapter value = this.adapter.getValue();
            if (value != null) {
                value.setList(this.originFriendList);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (TeamMemberBean teamMemberBean : this.originFriendList) {
            String name = teamMemberBean.getName();
            if (name == null) {
                name = "";
            }
            if (StringsKt.contains$default(name, searchStr, false, 2, (Object) null)) {
                arrayList.add(teamMemberBean);
            }
        }
        TeamMemberManageAdapter value2 = this.adapter.getValue();
        if (value2 != null) {
            value2.setList(arrayList);
        }
    }
}
