package com.kwad.components.ad.reward.l.b;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private c Cy = new c();
    private C1168a Cz = new C1168a();
    private final b CA = new b(com.kwad.components.ad.reward.a.b.hN());

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.b.a$a, reason: collision with other inner class name */
    public static class C1168a extends com.kwad.components.ad.reward.l.b {
        public C1168a() {
            this.Cu = "安装应用";
        }
    }

    public static class b extends com.kwad.components.ad.reward.l.b {
        public b(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.Cu = String.format("进阶奖励：安装并激活APP %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.Cv = String.format("进阶奖励：安装并激活APP %ss", sb2.toString());
        }
    }

    public static class c extends com.kwad.components.ad.reward.l.b {
        public c() {
            this.Cu = "基础奖励：观看视频";
            this.Cv = "基础奖励：需再观看%ss视频";
        }
    }

    public static void a(a aVar, Context context, AdTemplate adTemplate) {
        if (au.ax(context, com.kwad.sdk.core.response.helper.a.aE(e.eO(adTemplate)))) {
            aVar.lj();
        } else {
            aVar.lk();
        }
    }

    private void li() {
        if (this.Cy.isCompleted() && this.Cz.isCompleted() && this.CA.isCompleted()) {
            kY();
        } else {
            kZ();
        }
    }

    private void lk() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallUncompleted");
        this.Cz.kZ();
        li();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Cz.isCompleted() && this.CA.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<com.kwad.components.ad.reward.l.c> kW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Cy);
        arrayList.add(this.CA);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kX() {
        Iterator<com.kwad.components.ad.reward.l.c> it = kW().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void lg() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markWatchVideoCompleted");
        this.Cy.kY();
        li();
    }

    public final boolean lh() {
        return this.Cy.isCompleted();
    }

    public final void lj() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markInstallCompleted");
        this.Cz.kY();
        li();
    }

    public final void ll() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "markUseAppCompleted");
        this.CA.kY();
        li();
    }

    public final boolean lm() {
        com.kwad.sdk.core.d.c.d("LaunchAppTask", "isInstallCompleted");
        return this.Cz.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.Cy.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.CA.parseJson(jSONObject.optJSONObject("mUseAppTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "mWatchVideoTask", this.Cy);
        ac.a(jSONObject, "mInstallAppTask", this.Cz);
        ac.a(jSONObject, "mUseAppTask", this.CA);
        return jSONObject;
    }
}
