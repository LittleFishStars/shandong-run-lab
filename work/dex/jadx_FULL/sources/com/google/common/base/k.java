package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.y6b;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f31604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Ticker f5954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5955a;
    public long b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31605a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f31605a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31605a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31605a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31605a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31605a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31605a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31605a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public k() {
        this.f5954a = Ticker.b();
    }

    public static String a(TimeUnit timeUnit) {
        switch (a.f31605a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return MoreDistanceDialog.VALUE_MIN;
            case 6:
                return y6b.g;
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    public static TimeUnit b(long j) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static k c() {
        return new k().k();
    }

    public static k d(Ticker ticker) {
        return new k(ticker).k();
    }

    public static k e() {
        return new k();
    }

    public static k f(Ticker ticker) {
        return new k(ticker);
    }

    public long g(TimeUnit timeUnit) {
        return timeUnit.convert(h(), TimeUnit.NANOSECONDS);
    }

    public final long h() {
        return this.f5955a ? (this.f5954a.a() - this.b) + this.f31604a : this.f31604a;
    }

    public boolean i() {
        return this.f5955a;
    }

    @CanIgnoreReturnValue
    public k j() {
        this.f31604a = 0L;
        this.f5955a = false;
        return this;
    }

    @CanIgnoreReturnValue
    public k k() {
        i.h0(!this.f5955a, "This stopwatch is already running.");
        this.f5955a = true;
        this.b = this.f5954a.a();
        return this;
    }

    @CanIgnoreReturnValue
    public k l() {
        long jA = this.f5954a.a();
        i.h0(this.f5955a, "This stopwatch is already stopped.");
        this.f5955a = false;
        this.f31604a += jA - this.b;
        return this;
    }

    public String toString() {
        long jH = h();
        TimeUnit timeUnitB = b(jH);
        String strD = h.d(jH / TimeUnit.NANOSECONDS.convert(1L, timeUnitB));
        String strA = a(timeUnitB);
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 1 + String.valueOf(strA).length());
        sb.append(strD);
        sb.append(" ");
        sb.append(strA);
        return sb.toString();
    }

    public k(Ticker ticker) {
        this.f5954a = (Ticker) i.F(ticker, RemoteMessageConst.Notification.TICKER);
    }
}
