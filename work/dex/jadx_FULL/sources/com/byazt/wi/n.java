package com.byazt.wi;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 983, 46})
public class n {
    public static void c(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        String asString = contentValues.getAsString("load_id");
        if (!TextUtils.isEmpty(asString) && com.byazt.pe.c.update(gt.getContext(), "union_tmax_record", contentValues, "load_id=?", new String[]{asString}) <= 0) {
            com.byazt.pe.c.insert(gt.getContext(), "union_tmax_record", contentValues);
        }
    }

    public static void insert(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        com.byazt.pe.c.insert(gt.getContext(), "union_tmax_record", contentValues);
    }

    public static Cursor c(int i, String str, long j, String str2) {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return null;
        }
        return com.byazt.pe.c.query(gt.getContext(), "union_tmax_record", null, "ad_slot_type=? AND ad_slot_id=? AND record_time>=?", new String[]{String.valueOf(i), str, String.valueOf(j)}, null, null, str2);
    }

    public static Cursor c(int i, long j, String str) {
        if (j <= 0) {
            return null;
        }
        return com.byazt.pe.c.query(gt.getContext(), "union_tmax_record", null, "ad_slot_type=? AND record_time>=?", new String[]{String.valueOf(i), String.valueOf(j)}, null, null, str);
    }

    public static int c(long j) {
        return com.byazt.pe.c.delete(gt.getContext(), "union_tmax_record", "record_time<?", new String[]{String.valueOf(j)});
    }
}
