package com.beizi.fusion;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class cp {

    public class a extends cp {
        public a() {
        }

        @Override // com.beizi.fusion.cp
        public void a(og ogVar, Object obj) throws IOException {
            if (obj == null) {
                ogVar.k();
            } else {
                cp.this.a(ogVar, obj);
            }
        }
    }

    public final cp a() {
        return new a();
    }

    public abstract void a(og ogVar, Object obj);
}
