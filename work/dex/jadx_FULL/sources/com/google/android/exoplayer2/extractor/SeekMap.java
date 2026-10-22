package com.google.android.exoplayer2.extractor;

import androidx.annotation.Nullable;
import com.zj.adlib.sb0;
import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SeekMap {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x38 f30623a;
        public final x38 b;

        public a(x38 x38Var) {
            this(x38Var, x38Var);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f30623a.equals(aVar.f30623a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.f30623a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f30623a);
            if (this.f30623a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(x38 x38Var, x38 x38Var2) {
            this.f30623a = (x38) sb0.g(x38Var);
            this.b = (x38) sb0.g(x38Var2);
        }
    }

    public static class b implements SeekMap {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30624a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final a f2705a;

        public b(long j) {
            this(j, 0L);
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public a a(long j) {
            return this.f2705a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.f30624a;
        }

        @Override // com.google.android.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return false;
        }

        public b(long j, long j2) {
            this.f30624a = j;
            this.f2705a = new a(j2 == 0 ? x38.f45741a : new x38(0L, j2));
        }
    }

    a a(long j);

    long getDurationUs();

    boolean isSeekable();
}
