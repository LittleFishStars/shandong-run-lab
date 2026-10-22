package com.byazt.rl;

import android.annotation.TargetApi;
import android.util.SparseArray;
import androidx.camera.video.AudioStats;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 117, 54})
public class ve {
    public static final ValueSet c = c(0).tt();
    public static final Bridge tt;
    public static final Function<SparseArray<Object>, Object> ve;
    public ValueSet n;
    public final SparseArray<Object> uj;

    @com.byazt.zqa.c(c = {0, 1, 117, 24})
    public static final class c implements Bridge {
        private c() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) Float.valueOf(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge, com.bykv.vk.openvk.api.proto.Manager
        public ValueSet values() {
            return ve.c;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 117, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    @TargetApi(24)
    public static final class tt<T, R> implements Function<T, R> {
        private tt() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.byazt.rl.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 117, 917})
    public static final class C0515ve implements ValueSet {
        public final SparseArray<Object> c;
        public ValueSet tt;
        public int ve;

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.c.get(i);
            if (obj == null) {
                ValueSet valueSet = this.tt;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int iIndexOfKey = this.c.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.tt) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.c.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.c.keyAt(i)));
            }
            ValueSet valueSet = this.tt;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.ve = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.c.get(i);
            if (supplier == null) {
                ValueSet valueSet = this.tt;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (supplier instanceof Supplier) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.c.remove(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.ve < 0) {
                keys();
            }
            return this.ve;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.tt;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.c;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    sparseArray2.put(this.c.keyAt(i2), this.c.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        private C0515ve(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.ve = -1;
            this.c = sparseArray;
            this.tt = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }
    }

    static {
        tt = new c();
        ve = new tt();
    }

    private ve(SparseArray<Object> sparseArray) {
        this.uj = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final ve c() {
        return new ve(new SparseArray());
    }

    public ValueSet tt() {
        return new C0515ve(this.uj, this.n);
    }

    public static final ve c(int i) {
        return new ve(new SparseArray(i));
    }

    public static final ve c(SparseArray<Object> sparseArray) {
        return new ve(sparseArray);
    }

    public ve c(int i, Object obj) {
        this.uj.put(i, obj);
        return this;
    }

    public ve c(int i, String str) {
        this.uj.put(i, str);
        return this;
    }

    public ve c(int i, int i2) {
        this.uj.put(i, Integer.valueOf(i2));
        return this;
    }

    public ve c(int i, double d) {
        this.uj.put(i, Double.valueOf(d));
        return this;
    }

    public ve c(int i, boolean z) {
        this.uj.put(i, Boolean.valueOf(z));
        return this;
    }

    public ve c(int i, long j) {
        this.uj.put(i, Long.valueOf(j));
        return this;
    }

    public ve c(int i, float f) {
        this.uj.put(i, Float.valueOf(f));
        return this;
    }
}
