package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.cache.ad.pre.model.PreCacheAdModel;
import com.beizi.fusion.asnp.adn.ad.cache.ad.pre.model.PreCacheSpaceAdModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.AdResponseModel;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class fl extends bb {
    public fl(Context context, String str) {
        super(context, str);
    }

    @Override // com.beizi.fusion.bb
    public void a(String str) {
        JSONObject jSONObjectB = mg.b();
        mg.a(jSONObjectB, "result", mg.b(str));
        List<PreCacheSpaceAdModel> listA = new PreCacheAdModel(jSONObjectB).a();
        a aVar = (a) b.a().b(this.b);
        for (PreCacheSpaceAdModel preCacheSpaceAdModel : listA) {
            if (preCacheSpaceAdModel != null) {
                String strB = preCacheSpaceAdModel.b();
                AdResponseModel adResponseModelA = preCacheSpaceAdModel.a();
                if (!TextUtils.isEmpty(strB) && adResponseModelA != null) {
                    aVar.a(strB, adResponseModelA);
                }
            }
        }
    }
}
