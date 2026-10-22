package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.zj.adlib.qwc;
import com.zj.adlib.ync;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w extends zzfc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class f31398a = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public w() {
        super(null);
    }

    public /* synthetic */ w(ync yncVar) {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) s0.k(obj, j);
        if (list instanceof zzew) {
            objUnmodifiableList = ((zzew) list).F();
        } else {
            if (f31398a.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzfw) && (list instanceof zzel)) {
                zzel zzelVar = (zzel) list;
                if (zzelVar.r()) {
                    zzelVar.p();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        s0.x(obj, j, objUnmodifiableList);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfc
    public final void b(Object obj, Object obj2, long j) {
        List list;
        List list2;
        List listW;
        List list3 = (List) s0.k(obj2, j);
        int size = list3.size();
        List list4 = (List) s0.k(obj, j);
        if (list4.isEmpty()) {
            if (list4 instanceof zzew) {
                listW = new v(size);
            } else {
                listW = ((list4 instanceof zzfw) && (list4 instanceof zzel)) ? ((zzel) list4).W(size) : new ArrayList(size);
            }
            s0.x(obj, j, listW);
            list2 = listW;
        } else {
            if (f31398a.isAssignableFrom(list4.getClass())) {
                ArrayList arrayList = new ArrayList(list4.size() + size);
                arrayList.addAll(list4);
                s0.x(obj, j, arrayList);
                list = arrayList;
            } else if (list4 instanceof qwc) {
                v vVar = new v(list4.size() + size);
                vVar.addAll(vVar.size(), (qwc) list4);
                s0.x(obj, j, vVar);
                list = vVar;
            } else if ((list4 instanceof zzfw) && (list4 instanceof zzel)) {
                zzel zzelVar = (zzel) list4;
                if (!zzelVar.r()) {
                    list2 = list4;
                    list2 = list4;
                    list2 = list4;
                    zzel zzelVarW = zzelVar.W(list4.size() + size);
                    s0.x(obj, j, zzelVarW);
                    list2 = zzelVarW;
                }
            }
            list2 = list;
        }
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        list2 = list4;
        int size2 = list2.size();
        int size3 = list3.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list3);
        }
        if (size2 > 0) {
            list3 = list2;
        }
        s0.x(obj, j, list3);
    }
}
