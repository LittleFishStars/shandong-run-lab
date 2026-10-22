package com.kwad.components.core.innerEc.live.c;

import android.app.Activity;
import android.text.TextUtils;
import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.end.LiveAudienceEndReason;
import com.kwad.components.core.innerEc.live.video.a.b;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PBHelper;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.ServerException;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private final b UI;
    private final com.kwad.components.core.innerEc.live.b.a.b Ub;
    private boolean Xb;
    private boolean Xc;
    private Runnable Xd;
    private boolean Xe;
    private final com.kwad.components.core.innerEc.live.video.a.a Xf = new com.kwad.components.core.innerEc.live.video.a.a() { // from class: com.kwad.components.core.innerEc.live.c.a.1
        @Override // com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLivePlayerCompleteListener
        public final void onLiveComplete() {
            a.a(a.this, true);
            a.this.sF();
        }
    };
    private final Activity mActivity;

    public a(Activity activity, com.kwad.components.core.innerEc.live.b.a.b bVar) {
        this.mActivity = activity;
        this.Ub = bVar;
        this.UI = bVar.UI;
        init();
    }

    private void aM(final String str) {
        com.kwad.components.core.innerEc.live.a aVar = com.kwad.components.core.innerEc.live.b.Tr;
        if (aVar != null) {
            aVar.rt();
        }
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.live.c.a.3
            @Override // java.lang.Runnable
            public final void run() {
                ae.V(a.this.mActivity, str);
                a.this.mActivity.finish();
            }
        });
    }

    private void i(Throwable th) {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing()) {
            return;
        }
        j(th);
    }

    private void init() {
        this.Ub.UI.a(this.Xf);
        this.Xe = false;
    }

    private void j(Throwable th) {
        ServerException serverExceptionL = com.kwad.components.core.innerEc.live.i.a.l(th);
        int i = serverExceptionL.errorCode;
        c.i("LiveExceptionService", "handleServerException errorCode: " + i + ", subCode" + serverExceptionL.subCode);
        PBHelper pBHelperRi = f.ri();
        if (i == 601) {
            if (serverExceptionL.subCode == 611) {
                c.d("LiveExceptionService", "LIVE_NEW_ONE_OPENED");
                return;
            }
            this.Xb = true;
            c.i("LiveExceptionService", "LIVE_AUDIENCE_END handleServerException");
            sF();
            return;
        }
        if (i == 603) {
            this.Xb = true;
            if (this.Ub.UC.isAdded()) {
                this.Ub.UI.setPlayerReleaseReason(pBHelperRi.getPbClientStat().getLiveEndByAdmin());
                this.Ub.UK.a(LiveAudienceEndReason.LIVE_BANNED);
                return;
            }
            return;
        }
        if (i == 607) {
            this.Xc = true;
            c.i("LiveExceptionService", "LIVE_KICKED_OUT_ROOM" + serverExceptionL.errorMessage);
            this.UI.setPlayerReleaseReason(pBHelperRi.getPbClientStat().getBannedByAnchor());
            aM(serverExceptionL.errorMessage);
            return;
        }
        if (i == 80216) {
            c.i("LiveExceptionService", "LIVE_START_PLAY_OVER_LOAD" + serverExceptionL.errorMessage);
            aM(serverExceptionL.errorMessage);
            return;
        }
        if (i < 600 || i == 608 || TextUtils.isEmpty(serverExceptionL.errorMessage)) {
            return;
        }
        c.i("LiveExceptionService", "LIVE_START_PLAY_OVER_LOAD" + serverExceptionL.errorMessage);
    }

    private boolean sE() {
        return this.Xb;
    }

    private void sG() {
        if (this.Xd == null) {
            bi biVar = new bi() { // from class: com.kwad.components.core.innerEc.live.c.a.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    a.a(a.this, true);
                    a.this.sF();
                }
            };
            this.Xd = biVar;
            by.a(biVar, this, 5000L);
        }
    }

    private void sH() {
        Runnable runnable = this.Xd;
        if (runnable != null) {
            by.b(runnable);
            this.Xd = null;
        }
    }

    public final void destroy() {
        by.t(this);
        this.Ub.UI.b(this.Xf);
    }

    public final void h(Throwable th) {
        i(th);
    }

    public final void sF() {
        if (this.Ub.UC.isAdded() && this.Ub.UJ.sE()) {
            if (!this.Xe && !this.UI.isBuffering() && this.UI.isPlaying()) {
                sG();
                return;
            }
            sH();
            this.UI.setPlayerReleaseReason(f.ri().getPbClientStat().getLiveEndByAnchor());
            this.Ub.UK.a(LiveAudienceEndReason.ANCHOR_CLOSE);
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.Xe = true;
        return true;
    }
}
