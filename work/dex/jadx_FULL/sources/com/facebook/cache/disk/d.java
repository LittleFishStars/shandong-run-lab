package com.facebook.cache.disk;

import com.facebook.common.internal.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class d implements EntryEvictionComparatorSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f29951a;
    public final float b;

    public class a implements EntryEvictionComparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29952a = System.currentTimeMillis();

        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            float fB = d.this.b(entry, this.f29952a);
            float fB2 = d.this.b(entry2, this.f29952a);
            if (fB < fB2) {
                return 1;
            }
            return fB2 == fB ? 0 : -1;
        }
    }

    public d(float f, float f2) {
        this.f29951a = f;
        this.b = f2;
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator a() {
        return new a();
    }

    @VisibleForTesting
    public float b(DiskStorage.Entry entry, long j) {
        return (this.f29951a * (j - entry.getTimestamp())) + (this.b * entry.getSize());
    }
}
