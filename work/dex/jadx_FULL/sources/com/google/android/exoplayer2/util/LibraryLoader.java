package com.google.android.exoplayer2.util;

import com.zj.adlib.sb0;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class LibraryLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31156a = "LibraryLoader";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f5264a;
    public boolean b;

    public LibraryLoader(String... strArr) {
        this.f5264a = strArr;
    }

    public synchronized boolean a() {
        if (this.f5263a) {
            return this.b;
        }
        this.f5263a = true;
        try {
            for (String str : this.f5264a) {
                loadLibrary(str);
            }
            this.b = true;
        } catch (UnsatisfiedLinkError unused) {
            Log.n(f31156a, "Failed to load " + Arrays.toString(this.f5264a));
        }
        return this.b;
    }

    public synchronized void b(String... strArr) {
        sb0.j(!this.f5263a, "Cannot set libraries after loading");
        this.f5264a = strArr;
    }

    public abstract void loadLibrary(String str);
}
