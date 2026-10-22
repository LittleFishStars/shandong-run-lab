package com.kwad.components.ad.reward.l.a;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.l.c;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.l.a {
    private b Cw = new b();
    private final C1167a Cx = new C1167a(e.JY());

    /* JADX INFO: renamed from: com.kwad.components.ad.reward.l.a.a$a, reason: collision with other inner class name */
    public static class C1167a extends com.kwad.components.ad.reward.l.b {
        public C1167a(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            this.Cu = String.format("进阶奖励：浏览详情页 %ss", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            this.Cv = String.format("进阶奖励：浏览详情页 %ss", sb2.toString());
        }
    }

    public static class b extends com.kwad.components.ad.reward.l.b {
        public b() {
            this.Cu = "基础奖励：观看视频";
            this.Cv = "基础奖励：需再观看%ss视频";
        }
    }

    private void li() {
        if (this.Cx.isCompleted()) {
            kY();
        } else {
            kZ();
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.components.ad.reward.l.c
    public final boolean isCompleted() {
        return this.Cx.isCompleted();
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final List<c> kW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.Cw);
        arrayList.add(this.Cx);
        return arrayList;
    }

    @Override // com.kwad.components.ad.reward.l.a
    public final int kX() {
        Iterator<c> it = kW().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!it.next().isCompleted()) {
                i++;
            }
        }
        return i;
    }

    public final void lg() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markWatchVideoCompleted");
        this.Cw.kY();
        li();
    }

    public final boolean lh() {
        return this.Cw.isCompleted();
    }

    public final void markOpenNsCompleted() {
        com.kwad.sdk.core.d.c.d("LandPageOpenTask", "markOpenNsCompleted");
        this.Cx.kY();
        li();
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.Cw.parseJson(jSONObject.optJSONObject("mWatchVideoTask"));
            this.Cx.parseJson(jSONObject.optJSONObject("mOpenNsTask"));
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.ad.reward.l.b, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "mWatchVideoTask", this.Cw);
        ac.a(jSONObject, "mOpenNsTask", this.Cx);
        return jSONObject;
    }
}
