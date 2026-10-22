package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private g uj;
    private b yW;

    @Nullable
    private d za;

    @Nullable
    private c zb;
    private final long zd;

    @NonNull
    private a zc = new a(0);
    private Handler jk = new Handler(Looper.getMainLooper());
    private boolean ze = false;
    private boolean zf = false;

    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    public static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> zk;
        private ShowActionBarResult zl;

        private a() {
            this.zk = new CopyOnWriteArrayList();
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.zk.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.zk.remove(aVar);
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.zl = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.zk.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface b {
        void a(boolean z, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface d {
        boolean f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(g gVar, Context context, AdTemplate adTemplate) {
        this.uj = gVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        long jCW = com.kwad.sdk.core.response.helper.b.cW(adTemplate) > 0 ? com.kwad.sdk.core.response.helper.b.cW(adTemplate) : 1000L;
        this.zd = jCW > 0 ? jCW : 1000L;
    }

    private ShowActionBarResult R(boolean z) {
        c cVar;
        if (com.kwad.components.ad.reward.a.b.j(this.mAdInfo) && (cVar = this.zb) != null) {
            cVar.e(this.zc);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.helper.b.cX(this.mAdTemplate) || com.kwad.sdk.core.response.helper.a.bj(this.mAdInfo) || this.za == null) {
            S(z);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success in " + this.zd);
        return this.za.f(this.zc) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(boolean z) {
        if (this.yW != null) {
            com.kwad.sdk.core.d.c.d("ActionBarControl", "showNativeActionBar");
            this.zf = true;
            this.yW.a(z, this.zc);
        }
    }

    public final void Q(boolean z) {
        ShowActionBarResult showActionBarResultR = R(z);
        com.kwad.sdk.core.d.c.d("ActionBarControl", "showActionBarOnVideoStart result: " + showActionBarResultR);
        if (showActionBarResultR != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.jk.postDelayed(new bi() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.c.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.za != null && !RewardActionBarControl.this.zf && RewardActionBarControl.this.za.f(RewardActionBarControl.this.zc)) {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.zd);
                } else {
                    com.kwad.sdk.core.d.c.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.zd);
                    com.kwad.components.core.p.a.vL().j(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.zd);
                    com.kwad.components.ad.reward.monitor.d.a(RewardActionBarControl.this.uj.mAdTemplate, RewardActionBarControl.this.uj.sO, "play_card", com.kwad.sdk.core.response.helper.b.cV(RewardActionBarControl.this.uj.mAdTemplate), RewardActionBarControl.this.zd, 1);
                    RewardActionBarControl.this.S(true);
                }
            }
        }, this.zd);
    }

    public final void jC() {
        if (this.ze) {
            com.kwad.sdk.core.d.c.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.jk.removeCallbacksAndMessages(null);
            R(true);
        }
    }

    @Nullable
    public final ShowActionBarResult jD() {
        return this.zc.zl;
    }

    public static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z) {
        rewardActionBarControl.ze = true;
        return true;
    }

    @MainThread
    public final void a(b bVar) {
        this.yW = bVar;
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.zc.d(aVar);
    }

    @MainThread
    public final void a(d dVar) {
        this.za = dVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.zb = cVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.zc.c(aVar);
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    aVar.a(showActionBarResult, view);
                }
            });
        }
    }
}
