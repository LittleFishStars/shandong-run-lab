package com.huachenjie.base.interact.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.zj.adlib.fj7;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Database(entities = {WorksInteractEventBean.class}, exportSchema = false, version = 1)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/huachenjie/base/interact/database/WorksInteractDatabase;", "Landroidx/room/RoomDatabase;", "Lcom/huachenjie/base/interact/database/WorksInteractDao;", "d", "<init>", "()V", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public abstract class WorksInteractDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f7223a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WorksInteractDao f32935a = ((WorksInteractDatabase) fj7.b().a(WorksInteractDatabase.class, new Migration[0])).d();

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/huachenjie/base/interact/database/WorksInteractDatabase$a;", "", "Lcom/huachenjie/base/interact/database/WorksInteractDao;", "interactDao", "Lcom/huachenjie/base/interact/database/WorksInteractDao;", "a", "()Lcom/huachenjie/base/interact/database/WorksInteractDao;", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WorksInteractDao a() {
            return WorksInteractDatabase.f32935a;
        }
    }

    @NotNull
    public abstract WorksInteractDao d();
}
