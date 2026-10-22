package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class p7c implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Collection f43923a;

    public p7c(Collection collection) {
        this.f43923a = collection;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* bridge */ /* synthetic */ Object a(@NonNull Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f43923a.iterator();
        while (it.hasNext()) {
            arrayList.add(((Task) it.next()).r());
        }
        return arrayList;
    }
}
