package com.huachenjie.run.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.huachenjie.common.bean.RunLatLng;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Dao
public interface LatLngDao {
    @Query("update run_lat_lng set state=:newState where state=:uploadingState")
    void a(int uploadingState, int newState);

    @Query("select * from run_lat_lng where state in (:states) and isValid=:isValid and runCode=:runCode")
    List<RunLatLng> b(List<Integer> states, boolean isValid, String runCode);

    @Insert(onConflict = 1)
    void c(RunLatLng... runLatLngList);

    @Query("update run_lat_lng set state=(:retState) where id in (:ids)")
    void d(List<Integer> ids, int retState);

    @Query("select * from run_lat_lng where isValid=:isValid and runCode=:runCode")
    List<RunLatLng> e(boolean isValid, String runCode);

    @Update
    void f(RunLatLng... runLatLngList);
}
