package com.beizi.fusion;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ii extends ca {
    public ii(Context context, ba baVar, d dVar) {
        super(context, baVar, dVar);
    }

    @Override // com.beizi.fusion.ca
    public void a(List list) {
        this.d = true;
        qd qdVar = (qd) c();
        if (qdVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new wo((rd) it.next()));
            }
            qdVar.a(arrayList);
        }
    }
}
