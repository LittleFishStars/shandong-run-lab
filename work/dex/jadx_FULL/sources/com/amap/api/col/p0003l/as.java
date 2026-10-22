package com.amap.api.col.p0003l;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class as extends ar {

    public static abstract class a implements ar.a {
        @Override // com.amap.api.col.3l.ar.a
        public final boolean a(ar arVar) {
            return d((as) arVar);
        }

        @Override // com.amap.api.col.3l.ar.a
        public final boolean b(ar arVar) {
            return e((as) arVar);
        }

        @Override // com.amap.api.col.3l.ar.a
        public final void c(ar arVar) {
            f((as) arVar);
        }

        public abstract boolean d(as asVar);

        public abstract boolean e(as asVar);

        public abstract void f(as asVar);
    }

    public as(Context context, a aVar) {
        super(context, aVar);
    }

    public final float s() {
        return (float) (((Math.atan2(m(), l()) - Math.atan2(k(), j())) * 180.0d) / 3.141592653589793d);
    }
}
