package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.k.s;
import com.kwad.components.ad.reward.monitor.LivePlayMonitorType;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g extends com.kwad.components.core.n.a {

    @Nullable
    public IAdLiveOfflineView dU;
    public boolean jM;
    public boolean jh;
    private Handler jk;
    public AdResultData mAdResultData;

    @NonNull
    public com.kwad.components.ad.reward.e.d mAdRewardStepListener;

    @Nullable
    public com.kwad.components.core.e.d.d mApkDownloadHelper;
    public boolean mCheckExposureResult;
    public long mPageEnterTime;

    @Nullable
    public JSONObject mReportExtData;
    private boolean mRewardVerifyCalled;

    @NonNull
    public AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    public long mStartRenderTime;
    public bx mTimerHelper;

    @NonNull
    public KsVideoPlayConfig mVideoPlayConfig;
    public boolean na;

    @Nullable
    public com.kwad.components.core.playable.a sA;

    @NonNull
    public RewardActionBarControl sB;

    @Nullable
    public j sC;

    @Nullable
    public com.kwad.components.ad.l.a sD;

    @Nullable
    public d sE;
    private final PriorityQueue<com.kwad.components.ad.reward.e.g> sF;
    public final List<com.kwad.components.ad.reward.k.a> sG;
    private final List<s> sH;
    private final List<com.kwad.components.ad.reward.m.c> sI;
    public Set<com.kwad.components.ad.reward.e.e> sJ;

    @Nullable
    private com.kwad.components.core.webview.tachikoma.f.a sK;
    private boolean sL;
    private boolean sM;
    private boolean sN;
    public boolean sO;
    public boolean sP;
    public boolean sQ;
    public boolean sR;
    private boolean sS;
    public boolean sT;
    public boolean sU;
    public List<Integer> sV;
    public int sW;
    public int sX;
    public int sY;
    public boolean sZ;
    public boolean sx;

    @NonNull
    public com.kwad.components.ad.reward.e.b sy;
    public com.kwad.components.ad.reward.m.e sz;

    @Nullable
    public com.kwad.components.ad.reward.n.p ta;
    public boolean tb;

    @Nullable
    private PlayableSource tc;
    private boolean td;
    public long te;
    private List<DialogInterface.OnDismissListener> tf;

    @Nullable
    public com.kwad.components.ad.reward.e.o tg;
    public boolean th;

    @Nullable
    public com.kwad.components.ad.reward.l.b.a ti;

    @Nullable
    public com.kwad.components.ad.reward.l.a.a tj;
    public int tk;
    private int tl;
    public long tm;
    public long tn;
    public boolean to;
    private boolean tp;
    private boolean tq;
    public boolean tr;
    public boolean ts;

    @NonNull
    public LoadStrategy tt;
    private RewardRenderResult tu;
    private List<a> tv;
    private List<b> tw;
    private List<com.kwad.components.core.j.a.InterfaceC1214a> tx;
    private List<com.kwad.components.core.innerEc.live.base.f> ty;

    public interface a {
        void hp();

        void hq();

        void hr();

        void hs();
    }

    public interface b {
        boolean interceptPlayCardResume();
    }

    public g(com.kwad.components.core.n.b<?> bVar) {
        super(bVar);
        this.sx = false;
        this.sF = new PriorityQueue<>();
        this.sG = new CopyOnWriteArrayList();
        this.sH = new CopyOnWriteArrayList();
        this.sI = new CopyOnWriteArrayList();
        this.sJ = new HashSet();
        this.sL = false;
        this.sM = false;
        this.sN = false;
        this.sP = false;
        this.sQ = false;
        this.sR = false;
        this.sS = false;
        this.sT = false;
        this.mRewardVerifyCalled = false;
        this.sU = false;
        this.sV = new ArrayList();
        this.mCheckExposureResult = true;
        this.sW = 1;
        this.sX = 1;
        this.sY = 0;
        this.sZ = false;
        this.tb = false;
        this.tc = null;
        this.td = false;
        this.jM = false;
        this.tf = new CopyOnWriteArrayList();
        this.jk = new Handler(Looper.getMainLooper());
        this.th = false;
        this.tl = 2;
        this.tp = false;
        this.tq = false;
        this.tr = false;
        this.ts = false;
        this.tt = LoadStrategy.FULL_TK;
        this.tv = new CopyOnWriteArrayList();
        this.tw = new CopyOnWriteArrayList();
        this.tx = new CopyOnWriteArrayList();
        this.ty = new CopyOnWriteArrayList();
        this.abk.add(new com.kwad.components.core.n.a.a() { // from class: com.kwad.components.ad.reward.g.1
            @Override // com.kwad.components.core.n.a.a
            public final void c(com.kwad.components.core.proxy.f fVar) {
                g.this.gP();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void d(com.kwad.components.core.proxy.f fVar) {
                g.this.gQ();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hk() {
                g.this.gO();
            }

            @Override // com.kwad.components.core.n.a.a
            public final void hl() {
                g.this.gR();
            }
        });
    }

    public static boolean R(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.n(adTemplate, com.kwad.components.ad.reward.a.b.l(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
    }

    public static boolean S(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.helper.e.S(adTemplate);
    }

    public static boolean T(AdTemplate adTemplate) {
        if (com.kwad.sdk.core.response.helper.a.de(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            return false;
        }
        return R(adTemplate) || S(adTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO() {
        Iterator<a> it = this.tv.iterator();
        while (it.hasNext()) {
            it.next().hp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR() {
        Iterator<a> it = this.tv.iterator();
        while (it.hasNext()) {
            it.next().hs();
        }
    }

    private void gV() {
        this.sF.clear();
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.clear();
        }
        j jVar = this.sC;
        if (jVar != null) {
            jVar.release();
        }
        d dVar2 = this.sE;
        if (dVar2 != null) {
            dVar2.release();
        }
        Set<com.kwad.components.ad.reward.e.e> set = this.sJ;
        if (set != null) {
            set.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gX() {
        try {
            int size = this.sF.size();
            for (int i = 0; i < size; i++) {
                com.kwad.components.ad.reward.e.g gVarPoll = this.sF.poll();
                if (gVarPoll != null) {
                    gVarPoll.dd();
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static long h(AdInfo adInfo) {
        return com.kwad.sdk.core.response.helper.a.ah(adInfo) * 1000;
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public final void A(boolean z) {
        this.sN = z;
        if (z) {
            gQ();
        } else {
            gP();
        }
    }

    public final void B(boolean z) {
        this.tq = z;
    }

    public final void C(boolean z) {
        this.td = true;
    }

    public final void D(boolean z) {
        this.tp = true;
    }

    public final void E(boolean z) {
        this.sM = z;
    }

    public final void F(boolean z) {
        this.sL = z;
    }

    public final void G(final boolean z) {
        if (z != this.mRewardVerifyCalled) {
            a(this.sH, new com.kwad.sdk.g.a<s>() { // from class: com.kwad.components.ad.reward.g.11
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.g.a
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void accept(s sVar) {
                    sVar.ac(z);
                }
            });
        }
        this.mRewardVerifyCalled = z;
    }

    public final void aj(int i) {
        this.tl = i;
    }

    public final void b(a aVar) {
        this.tv.remove(aVar);
    }

    public final void d(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.tf.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
    }

    public final void gP() {
        if (this.sN || this.sL || this.tp) {
            return;
        }
        Iterator<b> it = this.tw.iterator();
        boolean zInterceptPlayCardResume = false;
        while (it.hasNext()) {
            zInterceptPlayCardResume |= it.next().interceptPlayCardResume();
        }
        if (zInterceptPlayCardResume) {
            return;
        }
        Iterator<a> it2 = this.tv.iterator();
        while (it2.hasNext()) {
            it2.next().hq();
        }
    }

    public final void gQ() {
        Iterator<a> it = this.tv.iterator();
        while (it.hasNext()) {
            it.next().hr();
        }
    }

    public final boolean gS() {
        return this.sN;
    }

    public final void gT() {
        a(this.sI, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.m.c>() { // from class: com.kwad.components.ad.reward.g.5
            private static void c(com.kwad.components.ad.reward.m.c cVar) {
                cVar.jN();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(com.kwad.components.ad.reward.m.c cVar) {
                c(cVar);
            }
        });
    }

    @Nullable
    public final String gU() {
        TKAdLiveShopItemInfo tKAdLiveShopItemInfo = this.mAdTemplate.tkLiveShopItemInfo;
        if (tKAdLiveShopItemInfo == null) {
            return null;
        }
        return tKAdLiveShopItemInfo.itemId;
    }

    public final void gW() {
        if (isMainThread()) {
            gX();
        } else {
            this.jk.post(new bi() { // from class: com.kwad.components.ad.reward.g.6
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    g.this.gX();
                }
            });
        }
    }

    public final boolean gY() {
        return this.tq;
    }

    public final void gZ() {
        com.kwad.components.core.webview.tachikoma.f.a aVar = this.sK;
        if (aVar == null) {
            return;
        }
        aVar.kw();
    }

    public final boolean ha() {
        return this.sS;
    }

    @Nullable
    public final PlayableSource hb() {
        return this.tc;
    }

    public final boolean hc() {
        return this.td;
    }

    public final List<com.kwad.components.core.j.a.InterfaceC1214a> hd() {
        return this.tx;
    }

    public final RewardRenderResult he() {
        return this.tu;
    }

    public final boolean hf() {
        return RewardRenderResult.NEO_TK.equals(this.tu);
    }

    public final boolean hg() {
        return this.tp;
    }

    public final boolean hh() {
        return this.sM || this.sL;
    }

    public final boolean hi() {
        return this.mRewardVerifyCalled;
    }

    public final void hj() {
        long j = this.tn;
        int i = j != 0 ? (int) (j / 1000) : 0;
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.sdk.core.adlog.c.o(adTemplate, com.kwad.sdk.core.response.helper.a.ai(com.kwad.sdk.core.response.helper.e.eO(adTemplate)), i);
    }

    @Override // com.kwad.components.core.n.a, com.kwad.sdk.mvp.a
    public final void release() {
        gV();
        com.kwad.components.ad.reward.m.e eVar = this.sz;
        if (eVar != null) {
            eVar.release();
        }
    }

    public static boolean g(AdInfo adInfo) {
        return com.kwad.sdk.core.response.helper.b.g(adInfo) && !com.kwad.components.ad.reward.a.b.l(adInfo);
    }

    public final void E(String str) {
        int iA = -1;
        try {
            if (com.kwad.sdk.core.config.e.FZ()) {
                iA = com.kwad.components.ad.reward.j.a.a(getActivity());
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        com.kwad.components.ad.reward.j.b.a(this.mContext, this.mAdTemplate, str, iA, this.mReportExtData);
    }

    public final void a(AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    public final void b(b bVar) {
        this.tw.remove(bVar);
    }

    @MainThread
    public final void c(com.kwad.components.ad.reward.e.g gVar) {
        this.sF.remove(gVar);
    }

    public final void e(final boolean z, final boolean z2) {
        if (this.sz.ls()) {
            by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.reward.g.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    com.kwad.components.ad.reward.f.a aVarLt = g.this.sz.lt();
                    if (aVarLt != null) {
                        aVarLt.setAudioEnabled(z, z2);
                    }
                }
            }, 500L);
        }
    }

    private static com.kwad.components.ad.reward.k.a.b c(g gVar) {
        com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
        bVar.a(gVar.mAdResultData);
        bVar.bP(com.kwad.sdk.core.response.helper.b.eq(gVar.mAdTemplate));
        bVar.bo(false);
        bVar.bp(true);
        return com.kwad.components.ad.reward.k.a.b.a(gVar, bVar);
    }

    public final void b(com.kwad.components.ad.reward.k.a aVar) {
        this.sG.remove(aVar);
    }

    public final void d(@Nullable PlayableSource playableSource) {
        this.tc = playableSource;
    }

    private static com.kwad.components.ad.reward.k.a.b d(g gVar) {
        if (com.kwad.sdk.core.response.helper.a.cq(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate)) == 4 || com.kwad.sdk.core.response.helper.a.cq(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate)) == 3) {
            return c(gVar);
        }
        return null;
    }

    public final void a(a aVar) {
        this.tv.add(aVar);
    }

    public final void b(s sVar) {
        this.sH.remove(sVar);
    }

    public final void a(b bVar) {
        this.tw.add(bVar);
    }

    public final void b(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.sI.remove(cVar);
        }
    }

    public final void a(com.kwad.components.ad.reward.k.a aVar) {
        this.sG.add(aVar);
    }

    public final void b(com.kwad.components.core.innerEc.live.base.f fVar) {
        if (fVar != null) {
            this.ty.remove(fVar);
        }
    }

    public final void a(s sVar) {
        this.sH.add(sVar);
    }

    @MainThread
    public final void b(com.kwad.components.ad.reward.e.g gVar) {
        this.sF.offer(gVar);
    }

    public final void a(com.kwad.components.ad.reward.m.c cVar) {
        if (cVar != null) {
            this.sI.add(cVar);
        }
    }

    public final void b(int i, Context context, int i2, int i3) {
        a(i, context, i2, i3, 0L, false, null);
    }

    public final void a(com.kwad.components.core.innerEc.live.base.f fVar) {
        if (fVar != null) {
            this.ty.add(fVar);
        }
    }

    public final void b(DialogInterface.OnDismissListener onDismissListener) {
        this.tf.remove(onDismissListener);
    }

    public static <T> void a(List<T> list, com.kwad.sdk.g.a<T> aVar) {
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    public final void b(com.kwad.components.ad.reward.c.b bVar) {
        com.kwad.components.ad.reward.c.a.ih().a(this.mAdTemplate, bVar);
    }

    public final void b(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarQ = com.kwad.components.ad.reward.e.f.Q(this.mAdTemplate.getUniqueId());
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.g.10
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarQ;
                if (dVar != null) {
                    dVar.d(cVar);
                }
            }
        });
    }

    public final void a(LiveDetailReward liveDetailReward) {
        Iterator<com.kwad.components.core.innerEc.live.base.f> it = this.ty.iterator();
        while (it.hasNext()) {
            it.next().b(liveDetailReward);
        }
    }

    public final void a(long j, long j2, int i) {
        Iterator<com.kwad.components.ad.reward.e.e> it = this.sJ.iterator();
        while (it.hasNext()) {
            it.next().dw();
        }
    }

    public final void b(com.kwad.components.core.j.a.InterfaceC1214a interfaceC1214a) {
        List<com.kwad.components.core.j.a.InterfaceC1214a> list = this.tx;
        if (list != null) {
            list.remove(interfaceC1214a);
        }
    }

    public static boolean b(g gVar) {
        return gVar.sL;
    }

    public final void a(int i, Context context, int i2, int i3) {
        b(i, context, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(g gVar, h.c cVar, h.a aVar) {
        boolean zB = b(gVar);
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showNativeCloseDialog isCloseDialogShowing: " + zB);
        if (zB) {
            return;
        }
        h.a(gVar.getActivity(), gVar.mAdTemplate, cVar, aVar);
    }

    public final void a(int i, Context context, int i2, int i3, long j) {
        a(1, context, 40, 1, j, false, null);
    }

    public final void a(int i, Context context, final int i2, int i3, long j, boolean z, final com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(context).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(false).aN(i3).D(j).aM(i2).aL(i).ap(gU()).a(new Callable<String>() { // from class: com.kwad.components.ad.reward.g.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
            public String call() {
                com.kwad.components.ad.reward.m.e eVar = g.this.sz;
                if (eVar != null) {
                    return eVar.lt().getCurrentShowShopItemInfo().itemId;
                }
                return null;
            }
        }).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.g.7
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                try {
                    g.this.a(i2, bVar);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.ec(i);
        bVar.f(this.mRootContainer.getTouchCoords());
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, (String) null, (String) null, bVar, this.mReportExtData);
        com.kwad.components.ad.reward.c.a.ih().e(this.mAdTemplate, com.kwad.components.ad.reward.c.b.STATUS_NONE);
        this.sy.dc();
    }

    public final void a(DialogInterface.OnDismissListener onDismissListener) {
        this.tf.add(onDismissListener);
    }

    public final void a(@Nullable com.kwad.components.ad.reward.e.o oVar) {
        this.tg = oVar;
    }

    public final void a(com.kwad.components.core.webview.tachikoma.f.a aVar) {
        this.sK = aVar;
    }

    public final void a(final com.kwad.components.core.j.c cVar) {
        final com.kwad.components.core.j.d dVarQ = com.kwad.components.ad.reward.e.f.Q(this.mAdTemplate.getUniqueId());
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.g.9
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.j.d dVar = dVarQ;
                if (dVar != null) {
                    dVar.c(cVar);
                }
            }
        });
    }

    public final void a(com.kwad.components.core.j.a.InterfaceC1214a interfaceC1214a) {
        List<com.kwad.components.core.j.a.InterfaceC1214a> list = this.tx;
        if (list != null) {
            list.add(interfaceC1214a);
        }
    }

    @Nullable
    public static com.kwad.components.core.j.c a(List<com.kwad.components.core.j.c> list, long j) {
        if (j >= 0 && list != null) {
            for (com.kwad.components.core.j.c cVar : list) {
                if (com.kwad.sdk.core.response.helper.e.eY(cVar.getAdTemplate()) == j) {
                    return cVar;
                }
            }
        }
        return null;
    }

    public final void a(RewardRenderResult rewardRenderResult) {
        this.tu = rewardRenderResult;
    }

    public static void a(Context context, g gVar, ViewGroup viewGroup) {
        IAdLiveOfflineView iAdLiveOfflineViewA;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate);
        com.kwad.components.core.offline.a.c.a aVar = (com.kwad.components.core.offline.a.c.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.c.a.class);
        if (aVar != null && aVar.tu() && com.kwad.sdk.core.response.helper.a.cY(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate))) {
            try {
                iAdLiveOfflineViewA = com.kwad.components.ad.j.c.a(aVar, context, com.kwad.sdk.core.response.helper.a.bl(adInfoEO) == 8 ? 1 : 0);
            } catch (Throwable th) {
                com.kwad.components.ad.reward.monitor.b.a(2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.helper.a.cw(adInfoEO)), Long.valueOf(com.kwad.sdk.core.response.helper.a.cy(adInfoEO)), LivePlayMonitorType.AD_LIVE_IMPL_LOAD_ERROR.getValue(), "AdLiveImpl load error: " + th.getMessage());
                iAdLiveOfflineViewA = null;
            }
            IAdLiveOfflineView iAdLiveOfflineView = iAdLiveOfflineViewA;
            if (iAdLiveOfflineView != null) {
                View view = iAdLiveOfflineView.getView();
                gVar.dU = iAdLiveOfflineView;
                viewGroup.addView(view);
                gVar.sz.a(2, new com.kwad.components.ad.reward.f.a(gVar.mAdTemplate, aVar.getAdLivePlayModule(iAdLiveOfflineView, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.helper.a.cw(adInfoEO)), com.kwad.sdk.core.response.helper.a.cx(adInfoEO), com.kwad.sdk.core.response.helper.a.cy(adInfoEO), com.kwad.sdk.core.response.helper.e.eI(gVar.mAdTemplate)), adInfoEO));
            }
        }
    }

    public static void a(g gVar, final h.c cVar, final h.a aVar) {
        com.kwad.components.ad.reward.k.a.b bVarC = null;
        if (!gVar.sz.ls()) {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate);
            bVarC = com.kwad.components.ad.reward.a.b.k(adInfoEO) || com.kwad.sdk.core.response.helper.a.cq(adInfoEO) == 2 ? c(gVar) : null;
            if (bVarC == null) {
                bVarC = d(gVar);
            }
        }
        com.kwad.components.ad.reward.k.a.b bVar = bVarC;
        if (bVar != null) {
            com.kwad.components.ad.reward.k.a.b.a(bVar, gVar.getActivity(), gVar.sz.getPlayDuration(), aVar, new com.kwad.components.core.webview.tachikoma.d.e.a() { // from class: com.kwad.components.ad.reward.g.12
                @Override // com.kwad.components.core.webview.tachikoma.d.e.a
                public final boolean ho() {
                    g.b(g.this, cVar, aVar);
                    return true;
                }
            });
        } else {
            b(gVar, cVar, aVar);
        }
    }

    public static void a(Activity activity, g gVar) {
        com.kwad.sdk.core.d.c.d("RewardCallerContext", "showExtraDialog");
        com.kwad.components.ad.reward.k.a.b.a(gVar, activity, gVar.sz.getPlayDuration(), new DialogInterface.OnDismissListener() { // from class: com.kwad.components.ad.reward.g.3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                g.this.d(dialogInterface);
                com.kwad.sdk.core.c.b.LW();
                Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
                if (currentActivity == null || !currentActivity.equals(g.this.getActivity())) {
                    return;
                }
                g.this.sz.resume();
            }
        }, new h.b() { // from class: com.kwad.components.ad.reward.g.4
            @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
            public final void hm() {
                g.this.sz.pause();
            }
        });
    }
}
