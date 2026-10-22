package com.byazt.jx;

import com.zj.adlib.go6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 42})
public class i implements ve {
    public final String c;
    public final c tt;
    public final boolean ve;

    public enum c {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static c c(int i) {
            if (i == 1) {
                return MERGE;
            }
            if (i == 2) {
                return ADD;
            }
            if (i == 3) {
                return SUBTRACT;
            }
            if (i != 4) {
                return i != 5 ? MERGE : EXCLUDE_INTERSECTIONS;
            }
            return INTERSECT;
        }
    }

    public i(String str, c cVar, boolean z) {
        this.c = str;
        this.tt = cVar;
        this.ve = z;
    }

    public String c() {
        return this.c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.tt + '}';
    }

    public c tt() {
        return this.tt;
    }

    public boolean ve() {
        return this.ve;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new com.byazt.zy.t(this);
    }
}
