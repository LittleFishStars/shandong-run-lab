package cj.mobile.wm;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.wangmai.insightvision.openadsdk.api.AdSlot;
import com.wangmai.insightvision.openadsdk.api.FanTiAdSdk;
import com.wangmai.insightvision.openadsdk.api.INativeAd;
import com.wangmai.insightvision.openadsdk.api.listener.ITemplateInteractionListener;
import com.wangmai.insightvision.openadsdk.common.AdError;
import com.wangmai.insightvision.openadsdk.template.rendering.table.activity.TableScreenActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class wd {
    public static final wd dexd = new wd();
    public INativeAd dexa;
    public AdSlot dexb;
    public final List<ITemplateInteractionListener> dexc = new ArrayList();

    public static wd dexk() {
        return dexd;
    }

    public AdSlot dexa() {
        return this.dexb;
    }

    public void dexa(INativeAd iNativeAd) {
        this.dexa = iNativeAd;
    }

    public void dexa(ITemplateInteractionListener iTemplateInteractionListener) {
        if (iTemplateInteractionListener == null || this.dexc.contains(iTemplateInteractionListener)) {
            return;
        }
        this.dexc.add(iTemplateInteractionListener);
    }

    public void dexa(AdError adError) {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdRenderFail(adError);
        }
    }

    public INativeAd dexb() {
        return this.dexa;
    }

    public void dexc() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdClicked((View) null);
        }
    }

    public void dexd() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdClosed();
        }
    }

    public void dexe() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdFinished();
        }
    }

    public void dexf() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdRenderSuccess();
        }
    }

    public void dexg() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdShake();
        }
    }

    public void dexh() {
        if (this.dexc.isEmpty()) {
            return;
        }
        Iterator<ITemplateInteractionListener> it = this.dexc.iterator();
        while (it.hasNext()) {
            it.next().onAdShow((View) null);
        }
    }

    public void dexi() {
        try {
            Context context = FanTiAdSdk.getContext();
            Intent intent = new Intent(context, (Class<?>) TableScreenActivity.class);
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (ActivityNotFoundException | SecurityException unused) {
        }
    }

    public void dexj() {
        this.dexc.clear();
    }
}
