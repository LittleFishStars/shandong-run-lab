package com.google.mlkit.vision.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import com.google.mlkit.common.sdkinternal.ClientPriority;
import com.zj.adlib.hq5;
import com.zj.adlib.yw6;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class MultiFlavorDetectorCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f32488a = new HashMap();

    @KeepForSdk
    public interface DetectorCreator<DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> {
        @NonNull
        @KeepForSdk
        DetectorT a(@NonNull OptionsT optionst);
    }

    @KeepForSdk
    public interface DetectorOptions<DetectorT> {
    }

    @KeepForSdk
    public interface MultiFlavorDetector {
    }

    @KeepForSdk
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @ClientPriority
        public final int f32489a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Provider f6714a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Class f6715a;

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> a(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider) {
            this(cls, provider, 100);
        }

        @KeepForSdk
        public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> a(@NonNull Class<? extends OptionsT> cls, @NonNull Provider<? extends DetectorCreator<DetectorT, OptionsT>> provider, @ClientPriority int i) {
            this.f6715a = cls;
            this.f6714a = provider;
            this.f32489a = i;
        }

        @ClientPriority
        public final int a() {
            return this.f32489a;
        }

        public final Provider b() {
            return this.f6714a;
        }

        public final Class c() {
            return this.f6715a;
        }
    }

    public MultiFlavorDetectorCreator(Set set) {
        HashMap map = new HashMap();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            Class clsC = aVar.c();
            if (!this.f32488a.containsKey(clsC) || aVar.a() >= ((Integer) yw6.l((Integer) map.get(clsC))).intValue()) {
                this.f32488a.put(clsC, aVar.b());
                map.put(clsC, Integer.valueOf(aVar.a()));
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static synchronized MultiFlavorDetectorCreator b() {
        return (MultiFlavorDetectorCreator) hq5.c().a(MultiFlavorDetectorCreator.class);
    }

    @NonNull
    @KeepForSdk
    public <DetectorT extends MultiFlavorDetector, OptionsT extends DetectorOptions<DetectorT>> DetectorT a(@NonNull OptionsT optionst) {
        return (DetectorT) ((DetectorCreator) ((Provider) yw6.l((Provider) this.f32488a.get(optionst.getClass()))).get()).a(optionst);
    }
}
