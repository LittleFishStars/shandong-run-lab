package com.zj.adlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.OperateCallback;
import com.huachenjie.im.bean.IMTokenBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.bean.TeamMemberBean;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.attachment.MsgAttachment;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.team.TeamService;
import com.netease.nimlib.sdk.team.constant.TeamFieldEnum;
import com.netease.nimlib.sdk.team.constant.TeamInviteModeEnum;
import com.netease.nimlib.sdk.team.constant.TeamMemberType;
import com.netease.nimlib.sdk.team.constant.TeamTypeEnum;
import com.netease.nimlib.sdk.team.constant.TeamUpdateModeEnum;
import com.netease.nimlib.sdk.team.constant.VerifyTypeEnum;
import com.netease.nimlib.sdk.team.model.CreateTeamResult;
import com.netease.nimlib.sdk.team.model.Team;
import com.netease.nimlib.sdk.team.model.TeamMember;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class z19 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RemoteExtBean f46161a = new RemoteExtBean();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements RequestCallback<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f46162a;

        public a(OperateCallback operateCallback) {
            this.f46162a = operateCallback;
        }

        public void onException(Throwable th) {
            i4a.a("异常：" + th.getMessage());
            OperateCallback operateCallback = this.f46162a;
            if (operateCallback != null) {
                operateCallback.onException(th);
            }
        }

        public void onFailed(int i) {
            i4a.a("错误code：" + i);
            OperateCallback operateCallback = this.f46162a;
            if (operateCallback != null) {
                operateCallback.onFailed(i);
            }
        }

        public void onSuccess(T t) {
            OperateCallback operateCallback = this.f46162a;
            if (operateCallback != null) {
                operateCallback.onSuccess(t);
            }
        }
    }

    public class b extends DefaultCallback<IMTokenBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f46163a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f20954a;

        public b(String str, OperateCallback operateCallback) {
            this.f20954a = str;
            this.f46163a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, IMTokenBean iMTokenBean, Throwable th) {
            if (i == 200) {
                z19.l(this.f20954a, this.f46163a);
            } else {
                z19.w(this.f46163a);
            }
        }
    }

    public class c extends RequestCallbackWrapper<List<TeamMember>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f46164a;

        public c(OperateCallback operateCallback) {
            this.f46164a = operateCallback;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<TeamMember> list, Throwable th) {
            if (i != 200 || list == null) {
                z19.w(this.f46164a);
            } else {
                z19.q(list, this.f46164a);
            }
        }
    }

    public class d extends DefaultCallback<List<NimUserInfo>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f46165a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f20955a;

        public d(Map map, OperateCallback operateCallback) {
            this.f20955a = map;
            this.f46165a = operateCallback;
        }

        @Override // com.huachenjie.im.DefaultCallback
        public void onResult(int i, @Nullable List<NimUserInfo> list, @Nullable Throwable th) {
            try {
                if (i != 200 || list == null) {
                    z19.w(this.f46165a);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (NimUserInfo nimUserInfo : list) {
                    if (nimUserInfo != null) {
                        arrayList.add(z19.D(nimUserInfo, (TeamMember) this.f20955a.get(nimUserInfo.getAccount())));
                    }
                }
                z19.C(arrayList, this.f46165a);
            } catch (Exception e) {
                z19.w(this.f46165a);
                e.printStackTrace();
            }
        }
    }

    public class e implements RequestCallback<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OperateCallback f46166a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ IMMessage f20956a;

        public e(OperateCallback operateCallback, IMMessage iMMessage) {
            this.f46166a = operateCallback;
            this.f20956a = iMMessage;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r2) {
            OperateCallback operateCallback = this.f46166a;
            if (operateCallback != null) {
                operateCallback.onSuccess(this.f20956a);
            }
        }

        public void onException(Throwable th) {
            OperateCallback operateCallback = this.f46166a;
            if (operateCallback != null) {
                operateCallback.onException(th);
            }
        }

        public void onFailed(int i) {
            i4a.b(p44.f18767a, "错误code：" + i);
            OperateCallback operateCallback = this.f46166a;
            if (operateCallback != null) {
                operateCallback.onFailed(i);
            }
        }
    }

    @UiThread
    public static void A(String str, String str2, OperateCallback<IMMessage> operateCallback) {
        B(MessageBuilder.createTextMessage(str2, SessionTypeEnum.Team, str), operateCallback);
    }

    public static void B(IMMessage iMMessage, OperateCallback<IMMessage> operateCallback) {
        MsgService msgService = (MsgService) k44.a(MsgService.class);
        if (msgService == null) {
            w(operateCallback);
        } else {
            iMMessage.setRemoteExtension(f46161a.getRemoteExt());
            msgService.sendMessage(iMMessage, false).setCallback(new e(operateCallback, iMMessage));
        }
    }

    public static void C(List<TeamMemberBean> list, OperateCallback<List<TeamMemberBean>> operateCallback) {
        if (list == null || list.size() == 0) {
            w(operateCallback);
            return;
        }
        Collections.sort(list, new Comparator() { // from class: com.zj.adlib.y19
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return z19.n((TeamMemberBean) obj, (TeamMemberBean) obj2);
            }
        });
        if (operateCallback != null) {
            operateCallback.onSuccess(list);
        }
    }

    public static TeamMemberBean D(NimUserInfo nimUserInfo, TeamMember teamMember) {
        String str;
        long j;
        Map extensionMap = nimUserInfo.getExtensionMap();
        String strR = j64.r(extensionMap, "appUserCode");
        String strR2 = j64.r(extensionMap, "avatarFrameImgUrl");
        boolean z = false;
        if (teamMember != null) {
            String teamNick = teamMember.getTeamNick();
            long joinTime = teamMember.getJoinTime();
            z = teamMember.getType() == TeamMemberType.Owner;
            str = teamNick;
            j = joinTime;
        } else {
            str = "";
            j = 0;
        }
        i4a.c("account:" + nimUserInfo.getAccount() + " name:" + nimUserInfo.getName() + " avatar:" + nimUserInfo.getAvatar() + " teamNick:" + str + " appUserCode:" + strR + " avatarFrameImgUrl:" + strR2 + " isOwner:" + z);
        return new TeamMemberBean(nimUserInfo.getAccount(), nimUserInfo.getName(), nimUserInfo.getAvatar(), strR, strR2, str, Boolean.valueOf(z), j, false);
    }

    public static void g(String str, OperateCallback<Team> operateCallback) {
        try {
            p44.j(new b(str, operateCallback));
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    @UiThread
    public static boolean h(String str) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                return false;
            }
            for (Team team : teamService.queryTeamListBlock()) {
                if (team != null && TextUtils.equals(str, team.getId())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static <T> RequestCallback<T> i(OperateCallback<T> operateCallback) {
        return new a(operateCallback);
    }

    @UiThread
    public static void j(List<String> list, String str, OperateCallback<CreateTeamResult> operateCallback) {
        TeamTypeEnum teamTypeEnum = TeamTypeEnum.Advanced;
        HashMap map = new HashMap();
        map.put(TeamFieldEnum.Name, str);
        map.put(TeamFieldEnum.InviteMode, TeamInviteModeEnum.All);
        map.put(TeamFieldEnum.TeamUpdateMode, TeamUpdateModeEnum.Manager);
        map.put(TeamFieldEnum.VerifyType, VerifyTypeEnum.Free);
        TeamService teamService = (TeamService) k44.a(TeamService.class);
        if (teamService != null) {
            teamService.createTeam(map, teamTypeEnum, "", list).setCallback(i(operateCallback));
        } else {
            w(operateCallback);
        }
    }

    @UiThread
    public static void k(String str, OperateCallback<Void> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.dismissTeam(str).setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    public static void l(String str, OperateCallback<Team> operateCallback) {
        try {
            if (h(str)) {
                r(str, operateCallback);
            } else {
                m(str, operateCallback);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    @UiThread
    public static void m(String str, OperateCallback<Team> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.applyJoinTeam(str, "").setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    public static /* synthetic */ int n(TeamMemberBean teamMemberBean, TeamMemberBean teamMemberBean2) {
        long joinTime = teamMemberBean.getJoinTime();
        long joinTime2 = teamMemberBean2.getJoinTime();
        if (joinTime > joinTime2) {
            return 1;
        }
        return joinTime < joinTime2 ? -1 : 0;
    }

    public static void o(String str, long j, OperateCallback<List<IMMessage>> operateCallback) {
        try {
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService == null) {
                w(operateCallback);
            } else {
                msgService.pullMessageHistory(MessageBuilder.createEmptyMessage(str, SessionTypeEnum.Team, j), 100, false, false).setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    @UiThread
    public static void p(String str, OperateCallback<List<TeamMemberBean>> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.queryMemberList(str).setCallback(new c(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    public static void q(List<TeamMember> list, OperateCallback<List<TeamMemberBean>> operateCallback) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (TeamMember teamMember : list) {
            if (teamMember != null && teamMember.isInTeam()) {
                map.put(teamMember.getAccount(), teamMember);
                arrayList.add(teamMember.getAccount());
            }
        }
        if (arrayList.isEmpty()) {
            w(operateCallback);
        } else {
            dj1.D(arrayList, new d(map, operateCallback));
        }
    }

    @UiThread
    public static void r(String str, OperateCallback<Team> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.queryTeam(str).setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    @Nullable
    @UiThread
    public static Team s(String str) {
        TeamService teamService = (TeamService) k44.a(TeamService.class);
        if (teamService == null) {
            return null;
        }
        try {
            return teamService.queryTeamBlock(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @UiThread
    public static void t(String str, OperateCallback<Void> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.quitTeam(str).setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    public static void u(RemoteExtBean remoteExtBean) {
        f46161a.clear();
        f46161a.setRoleType(3);
        f46161a.setAvatar(remoteExtBean.getAvatar());
        f46161a.setAvatarFrameImgUrl(remoteExtBean.getAvatarFrameImgUrl());
        f46161a.setNickName(remoteExtBean.getNickName());
        f46161a.setSpecialAbility(remoteExtBean.getSpecialAbility());
        f46161a.setSection(remoteExtBean.getSection());
        f46161a.setStarLevel(remoteExtBean.getStarLevel());
        f46161a.setAttitudeName(remoteExtBean.getAttitudeName());
    }

    @UiThread
    public static void v(String str, List<String> list, OperateCallback<Void> operateCallback) {
        try {
            TeamService teamService = (TeamService) k44.a(TeamService.class);
            if (teamService == null) {
                w(operateCallback);
            } else {
                teamService.removeMembers(str, list).setCallback(i(operateCallback));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            w(operateCallback);
        }
    }

    public static void w(OperateCallback operateCallback) {
        if (operateCallback != null) {
            operateCallback.onFailed(404);
        }
    }

    @UiThread
    public static void x(File file, long j, String str, OperateCallback<IMMessage> operateCallback) {
        B(MessageBuilder.createAudioMessage(str, SessionTypeEnum.Team, file, j), operateCallback);
    }

    @UiThread
    public static void y(@NonNull MsgAttachment msgAttachment, String str, OperateCallback<IMMessage> operateCallback) {
        B(MessageBuilder.createCustomMessage(str, SessionTypeEnum.Team, msgAttachment), operateCallback);
    }

    @UiThread
    public static void z(String str, String str2, OperateCallback<IMMessage> operateCallback) {
        SessionTypeEnum sessionTypeEnum = SessionTypeEnum.Team;
        File file = new File(str);
        B(MessageBuilder.createImageMessage(str2, sessionTypeEnum, file, file.getName()), operateCallback);
    }
}
