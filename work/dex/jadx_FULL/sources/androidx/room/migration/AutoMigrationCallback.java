package androidx.room.migration;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public interface AutoMigrationCallback {
    default void onPostMigrate(@NonNull SupportSQLiteDatabase db) {
    }
}
