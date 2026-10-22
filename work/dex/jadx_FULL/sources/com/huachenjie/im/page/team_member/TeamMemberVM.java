package com.huachenjie.im.page.team_member;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.triver.triver_render.view.canvas.tinyapp.c;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.bean.TeamMemberBean;
import com.kuaishou.weapon.p0.t;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R%\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0018\u0010\u0012R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/huachenjie/im/page/team_member/TeamMemberVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "chatTeamId", "", "p", "searchStr", "q", "", "Lcom/huachenjie/im/bean/TeamMemberBean;", "teamMemberList", j.b, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/im/page/team_member/TeamMemberAdapter;", "kotlin.jvm.PlatformType", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "c", t.d, TeamMemberActivity.y, "d", "n", "teamOwnerId", "", "a", "Ljava/util/List;", "m", "()Ljava/util/List;", "r", "(Ljava/util/List;)V", "originFriendList", "<init>", "()V", "IM_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nTeamMemberVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TeamMemberVM.kt\ncom/huachenjie/im/page/team_member/TeamMemberVM\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,67:1\n1#2:68\n1855#3,2:69\n*S KotlinDebug\n*F\n+ 1 TeamMemberVM.kt\ncom/huachenjie/im/page/team_member/TeamMemberVM\n*L\n59#1:69,2\n*E\n"})
public final class TeamMemberVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<TeamMemberAdapter> adapter = new MutableLiveData<>(new TeamMemberAdapter());

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> mineAccId = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> teamOwnerId = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public List<TeamMemberBean> originFriendList = new ArrayList();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/huachenjie/im/page/team_member/TeamMemberVM$a", "Lcom/huachenjie/im/DefaultCallback;", "", "Lcom/huachenjie/im/bean/TeamMemberBean;", "", "code", "result", "", c.f25231a, "", "onResult", "IM_release"}, k = 1, mv = {1, 8, 0})
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
            TeamMemberVM.this.o(result);
        }
    }

    @NotNull
    public final MutableLiveData<TeamMemberAdapter> k() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<String> l() {
        return this.mineAccId;
    }

    @NotNull
    public final List<TeamMemberBean> m() {
        return this.originFriendList;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.teamOwnerId;
    }

    public final void o(List<TeamMemberBean> teamMemberList) {
        Object next;
        TeamMemberAdapter value;
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
        MutableLiveData<TeamMemberAdapter> mutableLiveData2 = this.adapter;
        if (mutableLiveData2 == null || (value = mutableLiveData2.getValue()) == null) {
            return;
        }
        value.setList(this.originFriendList);
    }

    public final void p(@NotNull String chatTeamId) {
        Intrinsics.checkNotNullParameter(chatTeamId, "chatTeamId");
        z19.p(chatTeamId, new a());
    }

    public final void q(@NotNull String searchStr) {
        TeamMemberAdapter value;
        TeamMemberAdapter value2;
        Intrinsics.checkNotNullParameter(searchStr, "searchStr");
        if (TextUtils.isEmpty(searchStr)) {
            MutableLiveData<TeamMemberAdapter> mutableLiveData = this.adapter;
            if (mutableLiveData == null || (value2 = mutableLiveData.getValue()) == null) {
                return;
            }
            value2.setList(this.originFriendList);
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
        MutableLiveData<TeamMemberAdapter> mutableLiveData2 = this.adapter;
        if (mutableLiveData2 == null || (value = mutableLiveData2.getValue()) == null) {
            return;
        }
        value.setList(arrayList);
    }

    public final void r(@NotNull List<TeamMemberBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.originFriendList = list;
    }
}
