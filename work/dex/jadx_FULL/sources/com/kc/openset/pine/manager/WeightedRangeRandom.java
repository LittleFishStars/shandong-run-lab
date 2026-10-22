package com.kc.openset.pine.manager;

import androidx.camera.video.AudioStats;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WeightedRangeRandom {
    private final double[] cumulativeWeights;
    private final List<Range> ranges;

    static {
        OSETSDKProtected.interface11(4614);
    }

    public WeightedRangeRandom(List<Range> list) {
        ArrayList arrayList = new ArrayList();
        this.ranges = arrayList;
        validateRanges(list);
        arrayList.addAll(list);
        this.cumulativeWeights = new double[arrayList.size()];
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d2 = 0.0d;
        for (int i = 0; i < this.ranges.size(); i++) {
            d2 += this.ranges.get(i).weight;
            this.cumulativeWeights[i] = d2;
        }
        for (int i2 = 0; i2 < this.ranges.size(); i2++) {
            d += this.ranges.get(i2).weight;
            this.cumulativeWeights[i2] = d / d2;
        }
    }

    public static native /* synthetic */ int lambda$validateRanges$0(Range range, Range range2);

    private native void validateRanges(List<Range> list);

    public native int getRandom();
}
