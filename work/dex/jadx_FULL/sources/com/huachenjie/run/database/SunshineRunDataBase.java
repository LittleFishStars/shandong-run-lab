package com.huachenjie.run.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.huachenjie.common.bean.RunLatLng;
import com.huachenjie.run.bean.IntervalPace;
import com.huachenjie.run.bean.IntervalStep;
import com.huachenjie.run.database.dao.LatLngDao;
import com.huachenjie.run.database.dao.PaceDao;
import com.huachenjie.run.database.dao.StepDao;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Database(entities = {RunLatLng.class, IntervalStep.class, IntervalPace.class}, exportSchema = false, version = 7)
public abstract class SunshineRunDataBase extends RoomDatabase {
    public abstract LatLngDao c();

    public abstract PaceDao d();

    public abstract StepDao e();
}
