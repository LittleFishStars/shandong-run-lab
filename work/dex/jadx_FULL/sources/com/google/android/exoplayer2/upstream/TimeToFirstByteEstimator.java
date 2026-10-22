package com.google.android.exoplayer2.upstream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface TimeToFirstByteEstimator {
    void a(DataSpec dataSpec);

    void b(DataSpec dataSpec);

    long getTimeToFirstByteEstimateUs();

    void reset();
}
