package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.amr.AmrExtractor;
import com.google.android.exoplayer2.extractor.flac.FlacExtractor;
import com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Mp4Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.extractor.ts.q;
import com.google.android.exoplayer2.extractor.wav.WavExtractor;
import com.google.android.exoplayer2.util.FileTypes;
import com.zj.adlib.wo4;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DefaultExtractorsFactory implements ExtractorsFactory {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2700a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2701b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2702b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f2698a = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExtensionLoader f30618a = new ExtensionLoader(new ExtensionLoader.ConstructorSupplier() { // from class: com.zj.adlib.bg2
        @Override // com.google.android.exoplayer2.extractor.DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier
        public final Constructor getConstructor() {
            return DefaultExtractorsFactory.h();
        }
    });
    public static final ExtensionLoader b = new ExtensionLoader(new ExtensionLoader.ConstructorSupplier() { // from class: com.zj.adlib.dg2
        @Override // com.google.android.exoplayer2.extractor.DefaultExtractorsFactory.ExtensionLoader.ConstructorSupplier
        public final Constructor getConstructor() {
            return DefaultExtractorsFactory.i();
        }
    });
    public int h = 1;
    public int j = 112800;

    public static final class ExtensionLoader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstructorSupplier f30619a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        @GuardedBy("extensionLoaded")
        public Constructor<? extends Extractor> f2703a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicBoolean f2704a = new AtomicBoolean(false);

        public interface ConstructorSupplier {
            @Nullable
            Constructor<? extends Extractor> getConstructor() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public ExtensionLoader(ConstructorSupplier constructorSupplier) {
            this.f30619a = constructorSupplier;
        }

        @Nullable
        public Extractor a(Object... objArr) {
            Constructor<? extends Extractor> constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return constructorB.newInstance(objArr);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating extractor", e);
            }
        }

        @Nullable
        public final Constructor<? extends Extractor> b() {
            synchronized (this.f2704a) {
                if (this.f2704a.get()) {
                    return this.f2703a;
                }
                try {
                    return this.f30619a.getConstructor();
                } catch (ClassNotFoundException unused) {
                    this.f2704a.set(true);
                    return this.f2703a;
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
        }
    }

    @Nullable
    public static Constructor<? extends Extractor> h() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(Extractor.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    public static Constructor<? extends Extractor> i() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(Extractor.class).getConstructor(new Class[0]);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] a(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = f2698a;
        arrayList = new ArrayList(iArr.length);
        int iB = FileTypes.b(map);
        if (iB != -1) {
            g(iB, arrayList);
        }
        int iC = FileTypes.c(uri);
        if (iC != -1 && iC != iB) {
            g(iC, arrayList);
        }
        for (int i : iArr) {
            if (i != iB && i != iC) {
                g(i, arrayList);
            }
        }
        return (Extractor[]) arrayList.toArray(new Extractor[arrayList.size()]);
    }

    @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
    public synchronized Extractor[] d() {
        return a(Uri.EMPTY, new HashMap());
    }

    public final void g(int i, List<Extractor> list) {
        switch (i) {
            case 0:
                list.add(new com.google.android.exoplayer2.extractor.ts.a());
                break;
            case 1:
                list.add(new com.google.android.exoplayer2.extractor.ts.c());
                break;
            case 2:
                list.add(new AdtsExtractor((this.f2702b ? 2 : 0) | ((this.f2699a | (this.f2700a ? 1 : 0)) == true ? 1 : 0)));
                break;
            case 3:
                list.add(new AmrExtractor((this.f2702b ? 2 : 0) | this.f2701b | (this.f2700a ? 1 : 0)));
                break;
            case 4:
                Extractor extractorA = f30618a.a(Integer.valueOf(this.c));
                if (extractorA == null) {
                    list.add(new FlacExtractor(this.c));
                } else {
                    list.add(extractorA);
                }
                break;
            case 5:
                list.add(new com.google.android.exoplayer2.extractor.flv.b());
                break;
            case 6:
                list.add(new MatroskaExtractor(this.d));
                break;
            case 7:
                list.add(new Mp3Extractor((this.f2702b ? 2 : 0) | this.g | (this.f2700a ? 1 : 0)));
                break;
            case 8:
                list.add(new FragmentedMp4Extractor(this.f));
                list.add(new Mp4Extractor(this.e));
                break;
            case 9:
                list.add(new com.google.android.exoplayer2.extractor.ogg.c());
                break;
            case 10:
                list.add(new q());
                break;
            case 11:
                list.add(new TsExtractor(this.h, this.i, this.j));
                break;
            case 12:
                list.add(new WavExtractor());
                break;
            case 14:
                list.add(new wo4());
                break;
            case 15:
                Extractor extractorA2 = b.a(new Object[0]);
                if (extractorA2 != null) {
                    list.add(extractorA2);
                }
                break;
            case 16:
                list.add(new com.google.android.exoplayer2.extractor.avi.a());
                break;
        }
    }

    public synchronized DefaultExtractorsFactory j(int i) {
        this.f2699a = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory k(int i) {
        this.f2701b = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory l(boolean z) {
        this.f2702b = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory m(boolean z) {
        this.f2700a = z;
        return this;
    }

    public synchronized DefaultExtractorsFactory n(int i) {
        this.c = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory o(int i) {
        this.f = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory p(int i) {
        this.d = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory q(int i) {
        this.g = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory r(int i) {
        this.e = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory s(int i) {
        this.i = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory t(int i) {
        this.h = i;
        return this;
    }

    public synchronized DefaultExtractorsFactory u(int i) {
        this.j = i;
        return this;
    }
}
