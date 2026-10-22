package com.huachenjie.works.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Dao
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0003H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH'J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H'J\b\u0010\n\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/works/database/PublicWorkDao;", "", "delWork", "", "work", "Lcom/huachenjie/works/database/PublicWorkDraft;", "deleteAllWorks", "getAllWorks", "", "getLatestWorks", "getWorksSize", "", "insertWork", "", "updateWork", "works_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PublicWorkDao {
    @Delete
    void delWork(@NotNull PublicWorkDraft work);

    @Query("DELETE FROM public_work_draft")
    void deleteAllWorks();

    @Query("SELECT * FROM public_work_draft ORDER BY updateTime DESC")
    @NotNull
    List<PublicWorkDraft> getAllWorks();

    @Query("SELECT * FROM public_work_draft ORDER BY updateTime DESC LIMIT 1")
    @Nullable
    PublicWorkDraft getLatestWorks();

    @Query("SELECT COUNT(*) FROM public_work_draft")
    int getWorksSize();

    @Insert
    long insertWork(@NotNull PublicWorkDraft work);

    @Update
    void updateWork(@NotNull PublicWorkDraft work);
}
