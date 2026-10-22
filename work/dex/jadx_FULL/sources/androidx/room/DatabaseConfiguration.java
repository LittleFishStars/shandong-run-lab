package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @NonNull
    public final Context context;

    @Nullable
    public final String copyFromAssetPath;

    @Nullable
    public final File copyFromFile;

    @Nullable
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;

    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @Nullable
    public final String name;

    @Nullable
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;

    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @NonNull
    public final Executor transactionExecutor;

    @NonNull
    public final List<Object> typeConverters;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, boolean requireMigration, @Nullable Set<Integer> migrationNotRequiredFrom) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, queryExecutor, false, requireMigration, false, migrationNotRequiredFrom, null, null, null, null, null);
    }

    public boolean isMigrationRequired(int fromVersion, int toVersion) {
        Set<Integer> set;
        if ((fromVersion > toVersion) && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        return this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(fromVersion)));
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int version) {
        return isMigrationRequired(version, version + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, @NonNull Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, @Nullable Set<Integer> migrationNotRequiredFrom) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, null, null, null, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, @NonNull Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, @Nullable Set<Integer> migrationNotRequiredFrom, @Nullable String copyFromAssetPath, @Nullable File copyFromFile) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, null, null, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, @NonNull Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, @Nullable Set<Integer> migrationNotRequiredFrom, @Nullable String copyFromAssetPath, @Nullable File copyFromFile, @Nullable Callable<InputStream> copyFromInputStream) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, copyFromInputStream, null, null);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, @NonNull Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, @Nullable Set<Integer> migrationNotRequiredFrom, @Nullable String copyFromAssetPath, @Nullable File copyFromFile, @Nullable Callable<InputStream> copyFromInputStream, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, name, sqliteOpenHelperFactory, migrationContainer, callbacks, allowMainThreadQueries, journalMode, queryExecutor, transactionExecutor, multiInstanceInvalidation, requireMigration, allowDestructiveMigrationOnDowngrade, migrationNotRequiredFrom, copyFromAssetPath, copyFromFile, copyFromInputStream, prepackagedDatabaseCallback, null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String name, @NonNull SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> callbacks, boolean allowMainThreadQueries, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor queryExecutor, @NonNull Executor transactionExecutor, boolean multiInstanceInvalidation, boolean requireMigration, boolean allowDestructiveMigrationOnDowngrade, @Nullable Set<Integer> migrationNotRequiredFrom, @Nullable String copyFromAssetPath, @Nullable File copyFromFile, @Nullable Callable<InputStream> copyFromInputStream, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @Nullable List<Object> typeConverters) {
        this.sqliteOpenHelperFactory = sqliteOpenHelperFactory;
        this.context = context;
        this.name = name;
        this.migrationContainer = migrationContainer;
        this.callbacks = callbacks;
        this.allowMainThreadQueries = allowMainThreadQueries;
        this.journalMode = journalMode;
        this.queryExecutor = queryExecutor;
        this.transactionExecutor = transactionExecutor;
        this.multiInstanceInvalidation = multiInstanceInvalidation;
        this.requireMigration = requireMigration;
        this.allowDestructiveMigrationOnDowngrade = allowDestructiveMigrationOnDowngrade;
        this.mMigrationNotRequiredFrom = migrationNotRequiredFrom;
        this.copyFromAssetPath = copyFromAssetPath;
        this.copyFromFile = copyFromFile;
        this.copyFromInputStream = copyFromInputStream;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = typeConverters == null ? Collections.emptyList() : typeConverters;
    }
}
