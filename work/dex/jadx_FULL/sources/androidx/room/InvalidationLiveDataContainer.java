package androidx.room;

import androidx.annotation.VisibleForTesting;
import androidx.p002lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;

    @VisibleForTesting
    final Set<LiveData> mLiveDataSet = Collections.newSetFromMap(new IdentityHashMap());

    public InvalidationLiveDataContainer(RoomDatabase database) {
        this.mDatabase = database;
    }

    public <T> LiveData<T> create(String[] tableNames, boolean inTransaction, Callable<T> computeFunction) {
        return new RoomTrackingLiveData(this.mDatabase, this, inTransaction, computeFunction, tableNames);
    }

    public void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    public void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}
