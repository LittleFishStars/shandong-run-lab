package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vr5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f45428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<a> f20286a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f45429a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f20287a;
        public final long b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final String f20288b;

        public a(String str, String str2, long j, long j2) {
            this.f20287a = str;
            this.f20288b = str2;
            this.f45429a = j;
            this.b = j2;
        }
    }

    public vr5(long j, List<a> list) {
        this.f45428a = j;
        this.f20286a = list;
    }

    @Nullable
    public MotionPhotoMetadata a(long j) {
        long j2;
        if (this.f20286a.size() < 2) {
            return null;
        }
        long j3 = j;
        long j4 = -1;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        boolean z = false;
        for (int size = this.f20286a.size() - 1; size >= 0; size--) {
            a aVar = this.f20286a.get(size);
            boolean zEquals = "video/mp4".equals(aVar.f20287a) | z;
            if (size == 0) {
                j3 -= aVar.b;
                j2 = 0;
            } else {
                j2 = j3 - aVar.f45429a;
            }
            long j8 = j3;
            j3 = j2;
            if (!zEquals || j3 == j8) {
                z = zEquals;
            } else {
                j7 = j8 - j3;
                j6 = j3;
                z = false;
            }
            if (size == 0) {
                j4 = j3;
                j5 = j8;
            }
        }
        if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
            return null;
        }
        return new MotionPhotoMetadata(j4, j5, this.f45428a, j6, j7);
    }
}
