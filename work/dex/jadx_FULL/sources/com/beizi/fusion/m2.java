package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.common.analyse2.db.AnalyseEventDBModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class m2 extends la {
    public m2(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.la
    public List a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AnalyseEventDBModel.class);
        return arrayList;
    }

    @Override // com.beizi.fusion.la
    public String c() {
        return "Analyse";
    }
}
