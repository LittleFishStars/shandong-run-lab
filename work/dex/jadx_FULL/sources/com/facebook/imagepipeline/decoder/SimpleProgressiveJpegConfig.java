package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;
import com.zj.adlib.ax6;
import com.zj.adlib.p84;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SimpleProgressiveJpegConfig implements ProgressiveJpegConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicValueConfig f29992a;

    public interface DynamicValueConfig {
        int a();

        List<Integer> b();
    }

    public static class b implements DynamicValueConfig {
        public b() {
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public int a() {
            return 0;
        }

        @Override // com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig.DynamicValueConfig
        public List<Integer> b() {
            return Collections.EMPTY_LIST;
        }
    }

    public SimpleProgressiveJpegConfig() {
        this(new b());
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public int a(int i) {
        List<Integer> listB = this.f29992a.b();
        if (listB == null || listB.isEmpty()) {
            return i + 1;
        }
        for (int i2 = 0; i2 < listB.size(); i2++) {
            if (listB.get(i2).intValue() > i) {
                return listB.get(i2).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    @Override // com.facebook.imagepipeline.decoder.ProgressiveJpegConfig
    public QualityInfo b(int i) {
        return p84.d(i, i >= this.f29992a.a(), false);
    }

    public SimpleProgressiveJpegConfig(DynamicValueConfig dynamicValueConfig) {
        this.f29992a = (DynamicValueConfig) ax6.i(dynamicValueConfig);
    }
}
