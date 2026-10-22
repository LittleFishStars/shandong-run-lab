package com.beizi.fusion;

import android.content.ContentValues;
import android.database.Cursor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface sb {
    String[] getColumns();

    ContentValues getContentValuesStruct();

    void parseFromDb(Cursor cursor);
}
