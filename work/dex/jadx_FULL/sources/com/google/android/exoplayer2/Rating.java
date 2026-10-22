package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.Rating;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Rating implements Bundleable {
    public static final int K = -1;
    public static final int L = 0;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f30504a = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Bundleable.Creator<Rating> f2180a = new Bundleable.Creator() { // from class: com.zj.adlib.za7
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return Rating.b(bundle);
        }
    };

    public static Rating b(Bundle bundle) {
        int i = bundle.getInt(d(0), -1);
        if (i == 0) {
            return (Rating) f.b.a(bundle);
        }
        if (i == 1) {
            return (Rating) i.b.a(bundle);
        }
        if (i == 2) {
            return (Rating) m.b.a(bundle);
        }
        if (i == 3) {
            return (Rating) o.b.a(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i);
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    public abstract boolean c();
}
