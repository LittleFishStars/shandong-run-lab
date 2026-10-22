package cj.mobile.wm;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@TargetApi(19)
public class x3 implements v3 {
    public static final Bitmap.Config[] dexd = {Bitmap.Config.ARGB_8888, null};
    public static final Bitmap.Config[] dexe = {Bitmap.Config.RGB_565};
    public static final Bitmap.Config[] dexf = {Bitmap.Config.ARGB_4444};
    public static final Bitmap.Config[] dexg = {Bitmap.Config.ALPHA_8};
    public final dexc dexa = new dexc();
    public final t3<dexb, Bitmap> dexb = new t3<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> dexc = new HashMap();

    public static /* synthetic */ class dexa {
        public static final /* synthetic */ int[] dexa;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            dexa = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                dexa[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                dexa[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                dexa[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class dexb implements w3 {
        public final dexc dexa;
        public int dexb;
        public Bitmap.Config dexc;

        public dexb(dexc dexcVar) {
            this.dexa = dexcVar;
        }

        @Override // cj.mobile.wm.w3
        public void a() {
            this.dexa.dexa(this);
        }

        public void dexa(int i, Bitmap.Config config) {
            this.dexb = i;
            this.dexc = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof dexb)) {
                return false;
            }
            dexb dexbVar = (dexb) obj;
            if (this.dexb != dexbVar.dexb) {
                return false;
            }
            Bitmap.Config config = this.dexc;
            Bitmap.Config config2 = dexbVar.dexc;
            if (config == null) {
                if (config2 != null) {
                    return false;
                }
            } else if (!config.equals(config2)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.dexb * 31;
            Bitmap.Config config = this.dexc;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return x3.dexb(this.dexb, this.dexc);
        }
    }

    public static class dexc extends q3<dexb> {
        public dexb dexa(int i, Bitmap.Config config) {
            dexb dexbVarDexb = dexb();
            dexbVarDexb.dexa(i, config);
            return dexbVarDexb;
        }

        @Override // cj.mobile.wm.q3
        /* JADX INFO: renamed from: dexc, reason: merged with bridge method [inline-methods] */
        public dexb dexa() {
            return new dexb(this);
        }
    }

    private dexb dexa(dexb dexbVar, int i, Bitmap.Config config) {
        for (Bitmap.Config config2 : dexa(config)) {
            Integer numCeilingKey = dexb(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return dexbVar;
                        }
                    } else if (config2.equals(config)) {
                        return dexbVar;
                    }
                }
                this.dexa.dexa(dexbVar);
                return this.dexa.dexa(numCeilingKey.intValue(), config2);
            }
        }
        return dexbVar;
    }

    private void dexa(Integer num, Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMapDexb = dexb(config);
        Integer num2 = navigableMapDexb.get(num);
        if (num2.intValue() == 1) {
            navigableMapDexb.remove(num);
        } else {
            navigableMapDexb.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public static Bitmap.Config[] dexa(Bitmap.Config config) {
        int i = dexa.dexa[config.ordinal()];
        if (i == 1) {
            return dexd;
        }
        if (i == 2) {
            return dexe;
        }
        if (i != 3) {
            return i != 4 ? new Bitmap.Config[]{config} : dexg;
        }
        return dexf;
    }

    public static String dexb(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    private NavigableMap<Integer, Integer> dexb(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.dexc.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.dexc.put(config, treeMap);
        return treeMap;
    }

    @Override // cj.mobile.wm.v3
    public Bitmap a() {
        Bitmap bitmapDexa = this.dexb.dexa();
        if (bitmapDexa != null) {
            dexa(Integer.valueOf(e9.dexa(bitmapDexa)), bitmapDexa.getConfig());
        }
        return bitmapDexa;
    }

    @Override // cj.mobile.wm.v3
    public void a(Bitmap bitmap) {
        dexb dexbVarDexa = this.dexa.dexa(e9.dexa(bitmap), bitmap.getConfig());
        this.dexb.dexa(dexbVarDexa, bitmap);
        NavigableMap<Integer, Integer> navigableMapDexb = dexb(bitmap.getConfig());
        Integer num = navigableMapDexb.get(Integer.valueOf(dexbVarDexa.dexb));
        navigableMapDexb.put(Integer.valueOf(dexbVarDexa.dexb), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // cj.mobile.wm.v3
    public Bitmap dexa(int i, int i2, Bitmap.Config config) {
        int iDexa = e9.dexa(i, i2, config);
        Bitmap bitmapDexa = this.dexb.dexa(dexa(this.dexa.dexa(iDexa, config), iDexa, config));
        if (bitmapDexa != null) {
            dexa(Integer.valueOf(e9.dexa(bitmapDexa)), bitmapDexa.getConfig());
            bitmapDexa.reconfigure(i, i2, bitmapDexa.getConfig() != null ? bitmapDexa.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmapDexa;
    }

    @Override // cj.mobile.wm.v3
    public String dexa(Bitmap bitmap) {
        return dexb(e9.dexa(bitmap), bitmap.getConfig());
    }

    @Override // cj.mobile.wm.v3
    public int dexb(Bitmap bitmap) {
        return e9.dexa(bitmap);
    }

    @Override // cj.mobile.wm.v3
    public String dexb(int i, int i2, Bitmap.Config config) {
        return dexb(e9.dexa(i, i2, config), config);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.dexb);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.dexc.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.dexc.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
