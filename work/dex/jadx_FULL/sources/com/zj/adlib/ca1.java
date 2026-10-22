package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ca1 {
    public static final String b = "CachedContent";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ef2 f15771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f15772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<a> f15773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TreeSet<kg8> f15774a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f40932a;
        public final long b;

        public a(long j, long j2) {
            this.f40932a = j;
            this.b = j2;
        }

        public boolean a(long j, long j2) {
            long j3 = this.b;
            if (j3 == -1) {
                return j >= this.f40932a;
            }
            if (j2 == -1) {
                return false;
            }
            long j4 = this.f40932a;
            return j4 <= j && j + j2 <= j4 + j3;
        }

        public boolean b(long j, long j2) {
            long j3 = this.f40932a;
            if (j3 > j) {
                return j2 == -1 || j + j2 > j3;
            }
            long j4 = this.b;
            return j4 == -1 || j3 + j4 > j;
        }
    }

    public ca1(int i, String str) {
        this(i, str, ef2.f41422a);
    }

    public void a(kg8 kg8Var) {
        this.f15774a.add(kg8Var);
    }

    public boolean b(wu1 wu1Var) {
        ef2 ef2Var = this.f15771a;
        ef2 ef2VarE = ef2Var.e(wu1Var);
        this.f15771a = ef2VarE;
        return !ef2VarE.equals(ef2Var);
    }

    public long c(long j, long j2) {
        sb0.a(j >= 0);
        sb0.a(j2 >= 0);
        kg8 kg8VarE = e(j, j2);
        if (kg8VarE.b()) {
            return -Math.min(kg8VarE.c() ? Long.MAX_VALUE : kg8VarE.b, j2);
        }
        long j3 = j + j2;
        long j4 = j3 >= 0 ? j3 : Long.MAX_VALUE;
        long jMax = ((aa1) kg8VarE).f40491a + kg8VarE.b;
        if (jMax < j4) {
            for (kg8 kg8Var : this.f15774a.tailSet(kg8VarE, false)) {
                long j5 = ((aa1) kg8Var).f40491a;
                if (j5 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, j5 + kg8Var.b);
                if (jMax >= j4) {
                    break;
                }
            }
        }
        return Math.min(jMax - j, j2);
    }

    public ef2 d() {
        return this.f15771a;
    }

    public kg8 e(long j, long j2) {
        kg8 kg8VarH = kg8.h(this.f15772a, j);
        kg8 kg8VarFloor = this.f15774a.floor(kg8VarH);
        if (kg8VarFloor != null && ((aa1) kg8VarFloor).f40491a + kg8VarFloor.b > j) {
            return kg8VarFloor;
        }
        kg8 kg8VarCeiling = this.f15774a.ceiling(kg8VarH);
        if (kg8VarCeiling != null) {
            long j3 = ((aa1) kg8VarCeiling).f40491a - j;
            j2 = j2 == -1 ? j3 : Math.min(j3, j2);
        }
        return kg8.g(this.f15772a, j, j2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ca1.class != obj.getClass()) {
            return false;
        }
        ca1 ca1Var = (ca1) obj;
        return this.f40931a == ca1Var.f40931a && this.f15772a.equals(ca1Var.f15772a) && this.f15774a.equals(ca1Var.f15774a) && this.f15771a.equals(ca1Var.f15771a);
    }

    public TreeSet<kg8> f() {
        return this.f15774a;
    }

    public boolean g() {
        return this.f15774a.isEmpty();
    }

    public boolean h(long j, long j2) {
        for (int i = 0; i < this.f15773a.size(); i++) {
            if (this.f15773a.get(i).a(j, j2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f40931a * 31) + this.f15772a.hashCode()) * 31) + this.f15771a.hashCode();
    }

    public boolean i() {
        return this.f15773a.isEmpty();
    }

    public boolean j(long j, long j2) {
        for (int i = 0; i < this.f15773a.size(); i++) {
            if (this.f15773a.get(i).b(j, j2)) {
                return false;
            }
        }
        this.f15773a.add(new a(j, j2));
        return true;
    }

    public boolean k(aa1 aa1Var) {
        if (!this.f15774a.remove(aa1Var)) {
            return false;
        }
        File file = aa1Var.f15218a;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public kg8 l(kg8 kg8Var, long j, boolean z) {
        sb0.i(this.f15774a.remove(kg8Var));
        File file = (File) sb0.g(((aa1) kg8Var).f15218a);
        if (z) {
            File fileI = kg8.i((File) sb0.g(file.getParentFile()), this.f40931a, ((aa1) kg8Var).f40491a, j);
            if (file.renameTo(fileI)) {
                file = fileI;
            } else {
                Log.n(b, "Failed to rename " + file + " to " + fileI);
            }
        }
        kg8 kg8VarD = kg8Var.d(file, j);
        this.f15774a.add(kg8VarD);
        return kg8VarD;
    }

    public void m(long j) {
        for (int i = 0; i < this.f15773a.size(); i++) {
            if (this.f15773a.get(i).f40932a == j) {
                this.f15773a.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public ca1(int i, String str, ef2 ef2Var) {
        this.f40931a = i;
        this.f15772a = str;
        this.f15771a = ef2Var;
        this.f15774a = new TreeSet<>();
        this.f15773a = new ArrayList<>();
    }
}
