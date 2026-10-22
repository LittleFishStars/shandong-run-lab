package com.beizi.fusion;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ip extends ca {
    public ip(Context context, ba baVar, d dVar) {
        super(context, baVar, dVar);
    }

    @Override // com.beizi.fusion.ca
    public void a(List list) {
        this.d = true;
        af afVar = (af) c();
        if (afVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new mp((rd) it.next()));
            }
            afVar.a(arrayList);
        }
    }
}
