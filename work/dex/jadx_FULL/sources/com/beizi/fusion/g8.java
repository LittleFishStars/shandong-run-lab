package com.beizi.fusion;

import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class g8 {
    public static final g8 d = new g8("", "", false);
    public static final g8 e = new g8("\n", com.ipd.dsp.internal.i.q.a.i, true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27345a;
    private final String b;
    private final boolean c;

    private g8(String str, String str2, boolean z) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.f27345a = str;
        this.b = str2;
        this.c = z;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f27345a;
    }

    public boolean c() {
        return this.c;
    }
}
