package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.AdItemModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.trace.AdTraceModel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class i0 implements t9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f27376a;
    private final Map b = new HashMap();

    public i0(Context context) {
        this.f27376a = context.getApplicationContext();
    }

    @Override // com.beizi.fusion.t9
    public void a(AdItemModel adItemModel) {
        if (adItemModel != null) {
            String adnTraceTag = adItemModel.getAdnTraceTag();
            if (TextUtils.isEmpty(adnTraceTag) || this.b.containsKey(adnTraceTag)) {
                return;
            }
            bi biVar = new bi(this.f27376a);
            biVar.a(adItemModel);
            this.b.put(adnTraceTag, biVar);
        }
    }

    @Override // com.beizi.fusion.t9
    public void a(xa xaVar, AdTraceModel adTraceModel, String str) {
        bi biVar;
        if (this.b.get(str) == null || (biVar = (bi) this.b.get(str)) == null || !biVar.a()) {
            return;
        }
        biVar.a(xaVar, adTraceModel);
    }
}
