package com.huachenjie.run.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.huachenjie.run.bean.IntervalStep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Dao
public interface StepDao {
    @Query("update run_step set is_uploaded=1 where id in (:ids)")
    void a(List<Integer> ids);

    @Query("select * from run_step where is_uploaded=:isUploaded and runCode=:runCode")
    List<IntervalStep> b(boolean isUploaded, String runCode);

    @Update
    void c(IntervalStep... stepList);

    @Insert(onConflict = 1)
    void d(IntervalStep... stepList);

    @Query("select * from run_step where runCode=:runCode order by startTime desc limit 1")
    IntervalStep e(String runCode);
}
