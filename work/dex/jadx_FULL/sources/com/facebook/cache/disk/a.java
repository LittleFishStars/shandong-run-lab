package com.facebook.cache.disk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements EntryEvictionComparatorSupplier {

    /* JADX INFO: renamed from: com.facebook.cache.disk.a$a, reason: collision with other inner class name */
    public class C0633a implements EntryEvictionComparator {
        public C0633a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(DiskStorage.Entry entry, DiskStorage.Entry entry2) {
            long timestamp = entry.getTimestamp();
            long timestamp2 = entry2.getTimestamp();
            if (timestamp < timestamp2) {
                return -1;
            }
            return timestamp2 == timestamp ? 0 : 1;
        }
    }

    @Override // com.facebook.cache.disk.EntryEvictionComparatorSupplier
    public EntryEvictionComparator a() {
        return new C0633a();
    }
}
