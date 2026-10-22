package com.bumptech.glide.repackaged.com.google.common.collect;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public ImmutableBiMap<K, V> build() {
            int i = this.size;
            if (i == 0) {
                return ImmutableBiMap.of();
            }
            if (i == 1) {
                return ImmutableBiMap.of((Object) this.entries[0].getKey(), (Object) this.entries[0].getValue());
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.entries = (ImmutableMapEntry[]) ObjectArrays.arraysCopyOf(this.entries, i);
                }
                Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
            }
            int i2 = this.size;
            ImmutableMapEntry<K, V>[] immutableMapEntryArr = this.entries;
            this.entriesUsed = i2 == immutableMapEntryArr.length;
            return RegularImmutableBiMap.fromEntryArray(i2, immutableMapEntryArr);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap.Builder
        public Builder<K, V> put(K k, V v) {
            super.put((Object) k, (Object) v);
            return this;
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public abstract ImmutableBiMap<V, K> inverse();

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        return new SingletonImmutableBiMap(k, v);
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }
}
