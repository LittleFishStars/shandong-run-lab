package com.googlecode.mp4parser.authoring.builder;

import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Mp4Arrays;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class BetterFragmenter implements Fragmenter {
    private double targetDuration;

    public BetterFragmenter(double d) {
        this.targetDuration = d;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Fragmenter
    public long[] sampleNumbers(Track track) {
        int i;
        double timescale = track.getTrackMetaData().getTimescale();
        long j = (long) (this.targetDuration * timescale);
        long[] jArrCopyOfAndAppend = new long[0];
        long[] syncSamples = track.getSyncSamples();
        long[] sampleDurations = track.getSampleDurations();
        long j2 = 2;
        if (syncSamples == null) {
            long[] jArrCopyOfAndAppend2 = {1};
            double d = 0.0d;
            for (int i2 = 1; i2 < sampleDurations.length; i2++) {
                d += sampleDurations[i2] / timescale;
                if (d >= this.targetDuration) {
                    if (i2 > 0) {
                        jArrCopyOfAndAppend2 = Mp4Arrays.copyOfAndAppend(jArrCopyOfAndAppend2, i2 + 1);
                    }
                    d = 0.0d;
                }
            }
            if (d < this.targetDuration && jArrCopyOfAndAppend2.length > 1) {
                jArrCopyOfAndAppend2[jArrCopyOfAndAppend2.length - 1] = jArrCopyOfAndAppend2[jArrCopyOfAndAppend2.length - 2] + ((((long) (sampleDurations.length + 1)) - jArrCopyOfAndAppend2[jArrCopyOfAndAppend2.length - 2]) / 2);
            }
            return jArrCopyOfAndAppend2;
        }
        int length = syncSamples.length;
        long[] jArr = new long[length];
        long duration = track.getDuration();
        long j3 = 0;
        int i3 = 0;
        long j4 = 0;
        while (i3 < sampleDurations.length) {
            int iBinarySearch = Arrays.binarySearch(syncSamples, ((long) i3) + 1);
            if (iBinarySearch >= 0) {
                jArr[iBinarySearch] = j4;
            }
            j4 += sampleDurations[i3];
            i3++;
            j2 = 2;
        }
        int i4 = 0;
        while (true) {
            i = length - 1;
            if (i4 >= i) {
                break;
            }
            long j5 = jArr[i4];
            int i5 = i4 + 1;
            long j6 = jArr[i5];
            if (j3 <= j6 && Math.abs(j5 - j3) < Math.abs(j6 - j3)) {
                jArrCopyOfAndAppend = Mp4Arrays.copyOfAndAppend(jArrCopyOfAndAppend, syncSamples[i4]);
                j3 = jArr[i4] + j;
            }
            i4 = i5;
        }
        return duration - jArr[i] > j / j2 ? Mp4Arrays.copyOfAndAppend(jArrCopyOfAndAppend, syncSamples[i]) : jArrCopyOfAndAppend;
    }
}
