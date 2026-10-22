package com.kwad.components.ad.reward;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.y;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.l.b {
    private List<AdTemplate> sq;
    private boolean sr;
    private List<com.kwad.components.core.e.d.d> ss;
    private y.b st;

    public d(List<AdTemplate> list, @Nullable JSONObject jSONObject, y.b bVar) {
        super(jSONObject, null);
        this.sr = false;
        this.ss = new ArrayList();
        this.sq = list;
        this.st = bVar;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<AdTemplate> it = this.sq.iterator();
        while (it.hasNext()) {
            this.ss.add(new com.kwad.components.core.e.d.d(it.next()));
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final String O(AdTemplate adTemplate) {
        List<AdTemplate> list = this.sq;
        return (list == null || list.size() < 2) ? super.O(adTemplate) : com.kwad.sdk.core.response.helper.b.cZ(this.sq.get(1));
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(FrameLayout frameLayout, AdBaseFrameLayout adBaseFrameLayout, AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar, int i) {
        super.a(frameLayout, adBaseFrameLayout, this.sq, this.ss);
    }

    @Override // com.kwad.components.ad.l.b
    public final void b(com.kwad.sdk.core.webview.b bVar) {
        bVar.setAdTemplateList(this.sq);
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean cN() {
        return this.sr ? this.NR : super.cN();
    }

    @Override // com.kwad.components.ad.l.b
    @SuppressLint({"ClickableViewAccessibility"})
    public final void gE() {
        super.gE();
        this.ff.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.d.1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getAction() == 2;
            }
        });
    }

    @Override // com.kwad.components.ad.l.b
    public final boolean gF() {
        return false;
    }

    public final void gG() {
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yy();
        }
    }

    @Override // com.kwad.components.ad.l.b
    public final void gH() {
        com.kwad.components.ad.reward.monitor.d.a(this.mAdTemplate, true, "middle_play_end_card");
    }

    @Override // com.kwad.components.ad.l.b
    public final void gI() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.d.a(adTemplate, true, "middle_play_end_card", O(adTemplate));
    }

    @Override // com.kwad.components.ad.l.b
    public final void gJ() {
        AdTemplate adTemplate = this.mAdTemplate;
        com.kwad.components.ad.reward.monitor.d.a(adTemplate, true, "middle_play_end_card", O(adTemplate), System.currentTimeMillis() - getLoadTime());
    }

    @Override // com.kwad.components.ad.l.b
    public final String getName() {
        return "MiddlePlayEndCard";
    }

    public final void setShowLandingPage(boolean z) {
        this.sr = z;
    }

    @Override // com.kwad.components.ad.l.b
    public final void a(com.kwad.components.core.webview.a aVar) {
        super.a(aVar);
        List<AdTemplate> list = this.sq;
        y yVar = new y(new ArrayList(list.subList(1, list.size() - 1)));
        yVar.a(this.st);
        aVar.a(yVar);
    }
}
