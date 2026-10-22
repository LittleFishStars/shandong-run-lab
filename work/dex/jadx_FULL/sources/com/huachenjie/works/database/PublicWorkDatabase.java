package com.huachenjie.works.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.zj.adlib.fj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Database(entities = {PublicWorkDraft.class}, exportSchema = false, version = 3)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/huachenjie/works/database/PublicWorkDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getPublicWorkDao", "Lcom/huachenjie/works/database/PublicWorkDao;", "Companion", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class PublicWorkDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Migration MIGRATION_1_2;

    @NotNull
    private static final Migration MIGRATION_2_3;

    @NotNull
    private static final PublicWorkDao publicWorkDao;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/huachenjie/works/database/PublicWorkDatabase$Companion;", "", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "MIGRATION_2_3", "publicWorkDao", "Lcom/huachenjie/works/database/PublicWorkDao;", "getPublicWorkDao", "()Lcom/huachenjie/works/database/PublicWorkDao;", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PublicWorkDao getPublicWorkDao() {
            return PublicWorkDatabase.publicWorkDao;
        }
    }

    static {
        Migration migration = new Migration() { // from class: com.huachenjie.works.database.PublicWorkDatabase$Companion$MIGRATION_1_2$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                Intrinsics.checkNotNullParameter(database, "database");
                database.execSQL("alter table public_work_draft add column permissionType integer not null default 1");
            }
        };
        MIGRATION_1_2 = migration;
        Migration migration2 = new Migration() { // from class: com.huachenjie.works.database.PublicWorkDatabase$Companion$MIGRATION_2_3$1
            @Override // androidx.room.migration.Migration
            public void migrate(@NotNull SupportSQLiteDatabase database) {
                Intrinsics.checkNotNullParameter(database, "database");
                database.execSQL("ALTER TABLE public_work_draft ADD COLUMN categoryNo TEXT DEFAULT NULL");
                database.execSQL("ALTER TABLE public_work_draft ADD COLUMN tagNo TEXT DEFAULT NULL");
            }
        };
        MIGRATION_2_3 = migration2;
        publicWorkDao = ((PublicWorkDatabase) fj7.b().a(PublicWorkDatabase.class, migration, migration2)).getPublicWorkDao();
    }

    @NotNull
    public abstract PublicWorkDao getPublicWorkDao();
}
