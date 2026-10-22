package com.huachenjie.im.vm;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.im.DefaultCallback;
import com.huachenjie.im.adapter.SingleChatAdapter;
import com.huachenjie.im.bean.AllianceInviteBean;
import com.huachenjie.im.bean.DealInviteBean;
import com.huachenjie.im.bean.FollowBean;
import com.huachenjie.im.bean.RemoteExtBean;
import com.huachenjie.im.bean.TeamBean;
import com.huachenjie.im.bean.TeamChatParams;
import com.huachenjie.im.custom.ShareGoodsAttachment;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.msg.MessageBuilder;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.zj.adlib.fv5;
import com.zj.adlib.gq1;
import com.zj.adlib.n0a;
import com.zj.adlib.n76;
import com.zj.adlib.p44;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import huachenjie.sdk.http.ui.HttpVmDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class SingleChatVM extends BaseChatVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gq1 f9910a = new gq1();
    public MutableLiveData<String> m = new MutableLiveData<>();
    public MutableLiveData<TeamChatParams> n = new MutableLiveData<>();
    public MutableLiveData<String> o = new MutableLiveData<>();
    public MutableLiveData<Boolean> p = new MutableLiveData<>();
    public MutableLiveData<String> q = new MutableLiveData<>();
    public MutableLiveData<String> r = new MutableLiveData<>();
    public MutableLiveData<ShareGoodsAttachment> s = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RemoteExtBean f34593a = new RemoteExtBean();
    public RemoteExtBean b = new RemoteExtBean();

    public class a extends DialogVMSubscriber<Object> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            ARouter.getInstance().build(RoutePathConstants.SocialContact.l).withString("emojiStickerCode", this.f).navigation();
        }
    }

    public class b extends DialogVMSubscriber<FollowBean> {
        public b(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(FollowBean followBean) {
            if (followBean == null) {
                return;
            }
            SingleChatVM.this.q.setValue(followBean.getFriendAppUserCode());
            SingleChatVM.this.p.setValue(Boolean.valueOf(n0a.f43422a.l(followBean.getFriendAppUserCode(), followBean.getBisFollow())));
        }
    }

    public class c extends DefaultCallback<Long> {
        public c() {
        }

        @Override // com.huachenjie.im.DefaultCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, Long l, Throwable th) {
            if (i != 200) {
                l = 0L;
            }
            SingleChatVM.this.x(l);
        }
    }

    public class d extends RequestCallbackWrapper<List<IMMessage>> {
        public d() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<IMMessage> list, Throwable th) {
            if (list == null) {
                list = new ArrayList<>();
            }
            Collections.reverse(list);
            ArrayList arrayList = new ArrayList();
            for (IMMessage iMMessage : list) {
                String fromAccount = iMMessage.getFromAccount();
                if (fromAccount.equals(SingleChatVM.this.k.getValue())) {
                    arrayList.add(SingleChatVM.this.A(iMMessage));
                } else if (SingleChatVM.this.j.getValue() != null && SingleChatVM.this.j.getValue().getAccid().equals(fromAccount)) {
                    arrayList.add(SingleChatVM.this.B(iMMessage));
                }
            }
            SingleChatVM.this.h().setList(list);
        }
    }

    public class e extends DialogVMSubscriber<Object> {
        public e(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(Object obj) {
            fv5.b("物品领取成功");
        }
    }

    public class f extends BizSubscriber<Object> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(boolean z, String str) {
            super(z);
            this.f = str;
        }

        public void onCCSuccess(Object obj) {
            SingleChatVM.this.m.setValue(this.f);
        }
    }

    public class g extends DialogVMSubscriber<DealInviteBean> {
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(HttpVmDialog httpVmDialog, boolean z, boolean z2, boolean z3) {
            super(httpVmDialog, z, z2);
            this.c = z3;
        }

        public void onCCSuccess(DealInviteBean dealInviteBean) {
            if (this.c) {
                SingleChatVM.this.u(dealInviteBean);
            } else {
                SingleChatVM.this.a();
            }
        }
    }

    public class h extends BizSubscriber<TeamBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DealInviteBean f34601a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(boolean z, DealInviteBean dealInviteBean) {
            super(z);
            this.f34601a = dealInviteBean;
        }

        public void onFailed(int i, String str) {
            SingleChatVM.this.a();
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(i, str);
        }

        public void onCCSuccess(TeamBean teamBean) {
            SingleChatVM.this.a();
            ArrayList<String> arrayList = new ArrayList<>();
            if (teamBean != null && teamBean.getTeamMemberList() != null) {
                Iterator<TeamBean.MemberBean> it = teamBean.getTeamMemberList().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getAccid());
                }
            }
            fv5.b("入队成功");
            TeamChatParams teamChatParams = new TeamChatParams();
            teamChatParams.setTeamRoomId(this.f34601a.getTeamRoomid());
            teamChatParams.setPublicRoomId(this.f34601a.getPublicRoomId());
            teamChatParams.setRoomUserList(arrayList);
            teamChatParams.setMetaverseTeamCode(this.f34601a.getMetaverseTeamCode());
            SingleChatVM.this.n.setValue(teamChatParams);
        }
    }

    public class i extends DialogVMSubscriber<AllianceInviteBean> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(HttpVmDialog httpVmDialog, boolean z, String str) {
            super(httpVmDialog, z);
            this.f = str;
        }

        public void onCCSuccess(AllianceInviteBean allianceInviteBean) {
            if (allianceInviteBean == null) {
                return;
            }
            if (allianceInviteBean.getStatus() == 2) {
                SingleChatVM.this.o.setValue(this.f);
            } else if (allianceInviteBean.getStatus() == 1) {
                fv5.b("邀请已过期");
            }
        }
    }

    public class j extends DialogVMSubscriber<Object> {
        public j(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(Object obj) {
            fv5.b("结盟成功");
        }
    }

    public class k extends DialogVMSubscriber<Object> {
        public k(HttpVmDialog httpVmDialog, boolean z) {
            super(httpVmDialog, z);
        }

        public void onCCSuccess(Object obj) {
            fv5.b("已婉拒结盟邀请");
        }
    }

    public IMMessage A(IMMessage iMMessage) {
        iMMessage.setRemoteExtension(this.b.getRemoteExt());
        return iMMessage;
    }

    public IMMessage B(IMMessage iMMessage) {
        iMMessage.setRemoteExtension(this.f34593a.getRemoteExt());
        return iMMessage;
    }

    @Override // com.huachenjie.im.vm.BaseChatVM
    @NonNull
    public BaseQuickAdapter h() {
        if (this.i.getValue() != null) {
            return this.i.getValue();
        }
        SingleChatAdapter singleChatAdapter = new SingleChatAdapter("");
        this.i.setValue(singleChatAdapter);
        return singleChatAdapter;
    }

    public void p(String str, boolean z) {
        if (z) {
            n76.e(this, ((BaseChatVM) this).f34588a.a(str)).p5(new j(this, true));
        } else {
            n76.e(this, ((BaseChatVM) this).f34588a.l(str)).p5(new k(this, true));
        }
    }

    public void q(String str) {
        n76.e(this, ((BaseChatVM) this).f34588a.b(str)).p5(new e(this, true));
    }

    public void r(String str, boolean z) {
        n76.e(this, ((BaseChatVM) this).f34588a.d(str, z ? 1 : 2)).p5(new g(this, true, true, z));
    }

    public void s(String str) {
        n76.e(this, this.f9910a.b(str)).p5(new a(this, true, str));
    }

    public SingleChatAdapter t() {
        return (SingleChatAdapter) h();
    }

    public void u(DealInviteBean dealInviteBean) {
        if (dealInviteBean != null && !TextUtils.isEmpty(dealInviteBean.getMetaverseTeamCode()) && !TextUtils.isEmpty(dealInviteBean.getPublicRoomId()) && !TextUtils.isEmpty(dealInviteBean.getTeamRoomid())) {
            n76.e(this, ((BaseChatVM) this).f34588a.i(dealInviteBean.getMetaverseTeamCode())).p5(new h(true, dealInviteBean));
        } else {
            a();
            fv5.b("入队成功,跳转失败");
        }
    }

    public void v(String str) {
        n76.e(this, ((BaseChatVM) this).f34588a.c(str)).p5(new i(this, true, str));
    }

    public void w(String str) {
        n76.e(this, ((BaseChatVM) this).f34588a.k(str)).p5(new f(true, str));
    }

    public void x(Long l) {
        ((MsgService) NIMClient.getService(MsgService.class)).pullMessageHistory(MessageBuilder.createEmptyMessage(this.k.getValue(), SessionTypeEnum.P2P, l.longValue()), 100, false, false).setCallback(new d());
    }

    public void y() {
        p44.n(new c());
    }

    public void z(String str) {
        n76.e(this, ((BaseChatVM) this).f34588a.m(str)).p5(new b(this, true));
    }
}
