package com.googlecode.mp4parser.authoring.builder;

import androidx.camera.video.AudioStats;
import com.googlecode.mp4parser.authoring.Track;
import com.googlecode.mp4parser.util.Mp4Arrays;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DefaultFragmenterImpl implements Fragmenter {
    private double fragmentLength;

    public DefaultFragmenterImpl(double d) {
        this.fragmentLength = d;
    }

    @Override // com.googlecode.mp4parser.authoring.builder.Fragmenter
    public long[] sampleNumbers(Track track) {
        long[] jArrCopyOfAndAppend = {1};
        long[] sampleDurations = track.getSampleDurations();
        long[] syncSamples = track.getSyncSamples();
        long timescale = track.getTrackMetaData().getTimescale();
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        for (int i = 0; i < sampleDurations.length; i++) {
            d += sampleDurations[i] / timescale;
            if (d >= this.fragmentLength && (syncSamples == null || Arrays.binarySearch(syncSamples, i + 1) >= 0)) {
                if (i > 0) {
                    jArrCopyOfAndAppend = Mp4Arrays.copyOfAndAppend(jArrCopyOfAndAppend, i + 1);
                }
                d = AudioStats.AUDIO_AMPLITUDE_NONE;
            }
        }
        if (d >= this.fragmentLength || jArrCopyOfAndAppend.length <= 1) {
            return jArrCopyOfAndAppend;
        }
        long[] jArr = new long[jArrCopyOfAndAppend.length - 1];
        System.arraycopy(jArrCopyOfAndAppend, 0, jArr, 0, jArrCopyOfAndAppend.length - 1);
        return jArr;
    }
}
