package com.kwad.sdk.utils.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.utils.a.a$a, reason: collision with other inner class name */
    public static class C1307a extends j {
        public C1307a(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 7;
        }
    }

    public static abstract class b {
        int offset;

        public abstract byte Xi();
    }

    public static class c extends b {
        boolean value;

        public c(int i, boolean z) {
            this.offset = i;
            this.value = z;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 1;
        }
    }

    public static class d extends b {
        double value;

        public d(int i, double d) {
            this.offset = i;
            this.value = d;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 5;
        }
    }

    public static class e extends b {
        float value;

        public e(int i, float f) {
            this.offset = i;
            this.value = f;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 3;
        }
    }

    public static class f extends b {
        int value;

        public f(int i, int i2) {
            this.offset = i;
            this.value = i2;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 2;
        }
    }

    public static class g extends b {
        long value;

        public g(int i, long j) {
            this.offset = i;
            this.value = j;
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 4;
        }
    }

    public static class h extends j {
        public h(int i, int i2, Object obj, int i3, boolean z) {
            super(i, i2, obj, i3, z);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 8;
        }
    }

    public static class i extends j {
        public i(int i, int i2, String str, int i3, boolean z) {
            super(i, i2, str, i3, z);
        }

        @Override // com.kwad.sdk.utils.a.a.b
        public final byte Xi() {
            return (byte) 6;
        }
    }

    public static abstract class j extends b {
        int brJ;
        boolean brK;
        int start;
        Object value;

        public j(int i, int i2, Object obj, int i3, boolean z) {
            this.start = i;
            this.offset = i2;
            this.value = obj;
            this.brJ = i3;
            this.brK = z;
        }
    }
}
