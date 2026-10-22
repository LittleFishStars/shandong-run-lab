package com.ipd.dsp.internal.j;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class o implements l {
    public static final int d = 8;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f;
    public static final Bitmap.Config[] g;
    public static final Bitmap.Config[] h;
    public static final Bitmap.Config[] i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f38357a = new c();
    public final h<b, Bitmap> b = new h<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38358a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f38358a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38358a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38358a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38358a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    public static class c extends d<b> {
        @Override // com.ipd.dsp.internal.j.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b a(int i, Bitmap.Config config) {
            b bVarB = b();
            bVarB.a(i, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        e = configArr;
        f = configArr;
        g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.ipd.dsp.internal.j.l
    public void a(Bitmap bitmap) {
        b bVarA = this.f38357a.a(com.ipd.dsp.internal.d0.o.a(bitmap), bitmap.getConfig());
        this.b.a(bVarA, bitmap);
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num = navigableMapB.get(Integer.valueOf(bVarA.b));
        navigableMapB.put(Integer.valueOf(bVarA.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    public final NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.c.put(config, treeMap);
        return treeMap;
    }

    @Override // com.ipd.dsp.internal.j.l
    public String c(Bitmap bitmap) {
        return b(com.ipd.dsp.internal.d0.o.a(bitmap), bitmap.getConfig());
    }

    @Override // com.ipd.dsp.internal.j.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapA = this.b.a();
        if (bitmapA != null) {
            a(Integer.valueOf(com.ipd.dsp.internal.d0.o.a(bitmapA)), bitmapA);
        }
        return bitmapA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @VisibleForTesting
    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f38359a;
        public int b;
        public Bitmap.Config c;

        public b(c cVar) {
            this.f38359a = cVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.b = i;
            this.c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b && com.ipd.dsp.internal.d0.o.b(this.c, bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.b(this.b, this.c);
        }

        @VisibleForTesting
        public b(c cVar, int i, Bitmap.Config config) {
            this(cVar);
            a(i, config);
        }

        @Override // com.ipd.dsp.internal.j.m
        public void a() {
            this.f38359a.a(this);
        }
    }

    @Override // com.ipd.dsp.internal.j.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return b(com.ipd.dsp.internal.d0.o.a(i2, i3, config), config);
    }

    @Override // com.ipd.dsp.internal.j.l
    public int b(Bitmap bitmap) {
        return com.ipd.dsp.internal.d0.o.a(bitmap);
    }

    public static String b(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    @Override // com.ipd.dsp.internal.j.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        b bVarA = a(com.ipd.dsp.internal.d0.o.a(i2, i3, config), config);
        Bitmap bitmapA = this.b.a(bVarA);
        if (bitmapA != null) {
            a(Integer.valueOf(bVarA.b), bitmapA);
            bitmapA.reconfigure(i2, i3, config);
        }
        return bitmapA;
    }

    public final b a(int i2, Bitmap.Config config) {
        b bVarA = this.f38357a.a(i2, config);
        for (Bitmap.Config config2 : a(config)) {
            Integer numCeilingKey = b(config2).ceilingKey(Integer.valueOf(i2));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i2 * 8) {
                if (numCeilingKey.intValue() == i2 && Objects.equals(config2, config)) {
                    break;
                }
                this.f38357a.a(bVarA);
                return this.f38357a.a(numCeilingKey.intValue(), config2);
            }
        }
        return bVarA;
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapB = b(bitmap.getConfig());
        Integer num2 = navigableMapB.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapB.remove(num);
                return;
            } else {
                navigableMapB.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(bitmap) + ", this: " + this);
    }

    public static Bitmap.Config[] a(Bitmap.Config config) {
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            return f;
        }
        int i2 = a.f38358a[config.ordinal()];
        if (i2 == 1) {
            return e;
        }
        if (i2 == 2) {
            return g;
        }
        if (i2 != 3) {
            return i2 != 4 ? new Bitmap.Config[]{config} : i;
        }
        return h;
    }
}
