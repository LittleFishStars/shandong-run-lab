package com.huachenjie.base.interact.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Dao
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH'J\b\u0010\u000b\u001a\u00020\nH'J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\bH'J\b\u0010\r\u001a\u00020\nH'¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/base/interact/database/WorksInteractDao;", "", "Lcom/huachenjie/base/interact/bean/WorksInteractEventBean;", "event", "", "d", "", "c", "", "f", "", "e", "b", "a", "base_release"}, k = 1, mv = {1, 8, 0})
public interface WorksInteractDao {
    @Query("DELETE FROM works_interact_event where biz_type < 0")
    int a();

    @Query("SELECT * FROM works_interact_event where biz_type < 0")
    @NotNull
    List<WorksInteractEventBean> b();

    @Delete
    void c(@NotNull WorksInteractEventBean event);

    @Insert
    long d(@NotNull WorksInteractEventBean event);

    @Query("DELETE FROM works_interact_event where biz_type > 0")
    int e();

    @Query("SELECT * FROM works_interact_event where biz_type > 0")
    @NotNull
    List<WorksInteractEventBean> f();
}
