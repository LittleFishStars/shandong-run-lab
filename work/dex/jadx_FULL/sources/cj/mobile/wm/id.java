package cj.mobile.wm;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.FanTiAdSdk;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.common.AdError;
import com.wangmai.insightvision.openadsdk.template.rendering.reward.IRewardInteractionListener;
import com.wangmai.insightvision.openadsdk.template.rendering.reward.activity.RewardAdActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class id {
    public static final id dexg = new id();
    public INativeAd dexa;
    public AdSlot dexb;
    public Map<String, String> dexc;
    public final List<IRewardInteractionListener> dexd = new CopyOnWriteArrayList();
    public boolean dexe = false;
    public WeakReference<Activity> dexf;

    public static id dexm() {
        return dexg;
    }

    public void dexa() {
        WeakReference<Activity> weakReference = this.dexf;
        if (weakReference != null && weakReference.get() != null && !this.dexf.get().isFinishing()) {
            this.dexf.get().finish();
            this.dexf = null;
        }
        this.dexd.clear();
    }

    public void dexa(INativeAd iNativeAd) {
        this.dexa = iNativeAd;
    }

    public void dexa(AdError adError) {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdRenderFail(adError);
        }
    }

    public void dexa(IRewardInteractionListener iRewardInteractionListener) {
        if (iRewardInteractionListener == null || this.dexd.contains(iRewardInteractionListener)) {
            return;
        }
        this.dexd.add(iRewardInteractionListener);
    }

    public void dexa(Map<String, String> map) {
        this.dexc = map;
    }

    public void dexa(boolean z) {
        this.dexe = z;
    }

    public void dexa(boolean z, int i, Map map) {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onRewardArrived(z, i, map);
        }
    }

    public AdSlot dexb() {
        return this.dexb;
    }

    public INativeAd dexc() {
        return this.dexa;
    }

    public boolean dexd() {
        return this.dexe;
    }

    public void dexe() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdClicked((View) null);
        }
    }

    public void dexf() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdClosed();
        }
    }

    public void dexg() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdFinished();
        }
    }

    public void dexh() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdRenderSuccess();
        }
    }

    public void dexi() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdShake();
        }
    }

    public void dexj() {
        if (this.dexd.isEmpty()) {
            return;
        }
        Iterator<IRewardInteractionListener> it = this.dexd.iterator();
        while (it.hasNext()) {
            it.next().onAdShow((View) null);
        }
    }

    public void dexk() {
        try {
            Context context = FanTiAdSdk.getContext();
            this.dexf = new WeakReference<>(new RewardAdActivity());
            Intent intent = new Intent(context, (Class<?>) RewardAdActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException | SecurityException unused) {
        }
    }

    public void dexl() {
        this.dexd.clear();
    }
}
