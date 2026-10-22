package com.beizi.fusion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.AdvertCacheDBModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.db.StrategyEventDBModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class l extends la {
    public l(Context context) {
        super(context);
    }

    @Override // com.beizi.fusion.la
    public List a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AdvertCacheDBModel.class);
        arrayList.add(StrategyEventDBModel.class);
        return arrayList;
    }

    @Override // com.beizi.fusion.la
    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    @Override // com.beizi.fusion.la
    public String c() {
        return m0.a();
    }

    @Override // com.beizi.fusion.la
    public int e() {
        return 5;
    }
}
