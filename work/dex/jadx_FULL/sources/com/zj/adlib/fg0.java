package com.zj.adlib;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class fg0 {
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    public static final int g = 10000;
    public static final int h = 10000000;
    public static final int i = 500000;
    public static final int j = 500000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final a f16519a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16520b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f16521c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f16522d;

    @RequiresApi(19)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41669a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AudioTimestamp f16523a = new AudioTimestamp();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AudioTrack f16524a;
        public long b;
        public long c;

        public a(AudioTrack audioTrack) {
            this.f16524a = audioTrack;
        }

        public long a() {
            return this.c;
        }

        public long b() {
            return this.f16523a.nanoTime / 1000;
        }

        public boolean c() {
            boolean timestamp = this.f16524a.getTimestamp(this.f16523a);
            if (timestamp) {
                long j = this.f16523a.framePosition;
                if (this.b > j) {
                    this.f41669a++;
                }
                this.b = j;
                this.c = j + (this.f41669a << 32);
            }
            return timestamp;
        }
    }

    public fg0(AudioTrack audioTrack) {
        if (gj9.f41922a >= 19) {
            this.f16519a = new a(audioTrack);
            h();
        } else {
            this.f16519a = null;
            i(3);
        }
    }

    public void a() {
        if (this.f41668a == 4) {
            h();
        }
    }

    @TargetApi(19)
    public long b() {
        a aVar = this.f16519a;
        if (aVar != null) {
            return aVar.a();
        }
        return -1L;
    }

    @TargetApi(19)
    public long c() {
        a aVar = this.f16519a;
        if (aVar != null) {
            return aVar.b();
        }
        return -9223372036854775807L;
    }

    public boolean d() {
        return this.f41668a == 2;
    }

    public boolean e() {
        int i2 = this.f41668a;
        return i2 == 1 || i2 == 2;
    }

    @TargetApi(19)
    public boolean f(long j2) {
        a aVar = this.f16519a;
        if (aVar == null || j2 - this.f16521c < this.f16520b) {
            return false;
        }
        this.f16521c = j2;
        boolean zC = aVar.c();
        int i2 = this.f41668a;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                    } else if (zC) {
                        h();
                    }
                } else if (!zC) {
                    h();
                }
            } else if (!zC) {
                h();
            } else if (this.f16519a.a() > this.f16522d) {
                i(2);
            }
        } else if (zC) {
            if (this.f16519a.b() < this.f16518a) {
                return false;
            }
            this.f16522d = this.f16519a.a();
            i(1);
        } else if (j2 - this.f16518a > 500000) {
            i(3);
        }
        return zC;
    }

    public void g() {
        i(4);
    }

    public void h() {
        if (this.f16519a != null) {
            i(0);
        }
    }

    public final void i(int i2) {
        this.f41668a = i2;
        if (i2 == 0) {
            this.f16521c = 0L;
            this.f16522d = -1L;
            this.f16518a = System.nanoTime() / 1000;
            this.f16520b = 10000L;
            return;
        }
        if (i2 == 1) {
            this.f16520b = 10000L;
            return;
        }
        if (i2 == 2 || i2 == 3) {
            this.f16520b = 10000000L;
        } else {
            if (i2 != 4) {
                throw new IllegalStateException();
            }
            this.f16520b = 500000L;
        }
    }
}
