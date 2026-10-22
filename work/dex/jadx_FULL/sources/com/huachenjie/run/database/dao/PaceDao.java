package com.huachenjie.run.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.huachenjie.run.bean.IntervalPace;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Dao
public interface PaceDao {
    @Query("update run_pace set is_uploaded=1 where id in (:ids)")
    void a(List<Integer> ids);

    @Query("select * from run_pace where is_uploaded=:isUploaded and isValid=1 and runCode=:runCode")
    List<IntervalPace> b(boolean isUploaded, String runCode);

    @Query("select * from run_pace where runCode=:runCode order by startTime desc limit 1")
    IntervalPace c(String runCode);

    @Update
    void d(IntervalPace... paceList);

    @Insert(onConflict = 1)
    void e(IntervalPace... paceList);
}
