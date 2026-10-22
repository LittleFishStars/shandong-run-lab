package com.zj.adlib;

import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.RequestCallbackWrapper;
import com.netease.nimlib.sdk.msg.MsgService;
import com.netease.nimlib.sdk.msg.MsgServiceObserve;
import com.netease.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.netease.nimlib.sdk.msg.model.IMMessage;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class wt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static wt1 f45686a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f20539a = "imLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yt1 f20541a = new yt1();
    public final yt1 b = new yt1();
    public final yt1 c = new yt1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Observer<List<RecentContact>> f20540a = new vt1(this);

    public class a extends RequestCallbackWrapper<List<RecentContact>> {
        public a() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(int i, List<RecentContact> list, Throwable th) {
            i4a.b(wt1.f20539a, "获取到最近会话列表code:" + i);
            i4a.b(wt1.f20539a, "获取到最近会话列表:" + list.size());
            if (i != 200) {
                i4a.b(wt1.f20539a, "获取最近会话列表失败");
            } else {
                i4a.b(wt1.f20539a, "获取到最近会话列表");
                wt1.this.c(list);
            }
        }
    }

    public static wt1 h() {
        wt1 wt1Var;
        synchronized (wt1.class) {
            if (f45686a == null) {
                f45686a = new wt1();
            }
            wt1Var = f45686a;
        }
        return wt1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RecentContact recentContact = (RecentContact) it.next();
            if (recentContact.getSessionType() == SessionTypeEnum.P2P) {
                if (m(recentContact)) {
                    arrayList3.add(recentContact);
                    this.c.b(recentContact);
                } else {
                    arrayList.add(recentContact);
                    this.f20541a.b(recentContact);
                }
            } else if (recentContact.getSessionType() == SessionTypeEnum.Team) {
                arrayList2.add(recentContact);
                this.b.b(recentContact);
            }
        }
        if (!arrayList.isEmpty()) {
            this.f20541a.m(arrayList);
        }
        if (!arrayList2.isEmpty()) {
            this.b.m(arrayList2);
        }
        if (arrayList3.isEmpty()) {
            return;
        }
        this.c.m(arrayList3);
    }

    public final void c(List<RecentContact> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        i4a.b(f20539a, "缓存列表：" + list.size());
        for (RecentContact recentContact : list) {
            if (recentContact.getSessionType() == SessionTypeEnum.P2P) {
                if (m(recentContact)) {
                    this.c.b(recentContact);
                } else {
                    this.f20541a.b(recentContact);
                }
            } else if (recentContact.getSessionType() == SessionTypeEnum.Team) {
                this.b.b(recentContact);
            }
        }
        i4a.b(f20539a, "p2p列表：" + this.f20541a.g());
        i4a.b(f20539a, "team列表：" + this.b.g());
        i4a.b(f20539a, "team列表：" + this.c.g());
        List<RecentContact> listI = this.f20541a.i();
        List<RecentContact> listI2 = this.b.i();
        List<RecentContact> listI3 = this.c.i();
        if (!listI.isEmpty()) {
            this.f20541a.m(listI);
        }
        if (!listI2.isEmpty()) {
            this.b.m(listI2);
        }
        if (listI3.isEmpty()) {
            return;
        }
        this.c.m(listI3);
    }

    public void d(String str) {
        dj1.k(str, SessionTypeEnum.Team);
    }

    public final void e(yt1 yt1Var, String str) {
        RecentContact recentContactH;
        if (yt1Var == null || (recentContactH = yt1Var.h(str)) == null) {
            return;
        }
        yt1Var.n(recentContactH);
        yt1Var.o(str);
    }

    public void f(String str, SessionTypeEnum sessionTypeEnum) {
        i4a.b(f20539a, "deleteRecentContact");
        if (sessionTypeEnum != SessionTypeEnum.P2P) {
            if (sessionTypeEnum == SessionTypeEnum.Team) {
                e(this.b, str);
            }
        } else if (this.f20541a.f(str)) {
            e(this.f20541a, str);
        } else {
            e(this.c, str);
        }
    }

    public void g() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeRecentContact(this.f20540a, false);
        } else {
            i4a.b(f20539a, "destroyContactObserver fail");
        }
    }

    public yt1 i() {
        return this.c;
    }

    public yt1 j() {
        return this.f20541a;
    }

    public yt1 k() {
        return this.b;
    }

    public int l() {
        return this.f20541a.j() + this.b.j();
    }

    public final boolean m(RecentContact recentContact) {
        i4a.c("isMerchants?");
        if (recentContact.getSessionType() != SessionTypeEnum.P2P) {
            return false;
        }
        String recentMessageId = recentContact.getRecentMessageId();
        i4a.c(recentContact.getFromNick() + c49.f40900a + recentContact.getContent());
        try {
            MsgService msgService = (MsgService) k44.a(MsgService.class);
            if (msgService == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(recentMessageId);
            List listQueryMessageListByUuidBlock = msgService.queryMessageListByUuidBlock(arrayList);
            if (listQueryMessageListByUuidBlock != null && listQueryMessageListByUuidBlock.size() != 0) {
                IMMessage iMMessage = (IMMessage) listQueryMessageListByUuidBlock.get(0);
                i4a.c("ext:" + iMMessage.getRemoteExtension());
                int iK = j64.k(iMMessage, "roleType");
                i4a.c("roleType-" + iK);
                return iK == 4;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void o() {
        i4a.b(f20539a, "刷新最近会话列表");
        MsgService msgService = (MsgService) k44.a(MsgService.class);
        if (msgService == null) {
            return;
        }
        msgService.queryRecentContacts().setCallback(new a());
    }

    public void p() {
        this.f20541a.e();
        this.b.e();
        this.c.e();
    }

    public void q() {
        MsgServiceObserve msgServiceObserve = (MsgServiceObserve) k44.a(MsgServiceObserve.class);
        if (msgServiceObserve != null) {
            msgServiceObserve.observeRecentContact(this.f20540a, true);
        } else {
            i4a.b(f20539a, "registerContactObserver fail");
        }
    }
}
