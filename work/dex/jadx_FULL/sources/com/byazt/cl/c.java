package com.byazt.cl;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ete.gu;
import com.byazt.omf.gt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1542, 20})
public class c {
    public static JSONObject c() {
        int i;
        int i2;
        if (gu.c() <= 0 || gu.tt() <= 0) {
            return new JSONObject();
        }
        int iC = gu.c();
        int i3 = 0;
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "dpl_status_record", null, "create_time >= ?", new String[]{String.valueOf(System.currentTimeMillis() - (((long) iC) * 60000))}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            i = 0;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
            do {
                int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i4 == 1) {
                    i3++;
                } else if (i4 == 2) {
                    i++;
                } else if (i4 == 3) {
                    i2++;
                }
            } while (cursorQuery.moveToNext());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("minute", iC);
            jSONObject.put("trigger_count", i3);
            jSONObject.put("dialog_count", i);
            jSONObject.put("reject_count", i2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void tt() {
        try {
            com.byazt.pe.c.delete(gt.getContext(), "dpl_status_record", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 604800000)});
        } catch (Throwable unused) {
        }
    }

    public static void c(final int i) {
        if (gu.c() <= 0 || gu.tt() <= 0) {
            return;
        }
        x.c(new sp("recordStatus") { // from class: com.byazt.cl.c.1
            @Override // java.lang.Runnable
            public void run() {
                ContentValues contentValues = new ContentValues();
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("status", Integer.valueOf(i));
                com.byazt.pe.c.insert(gt.getContext(), "dpl_status_record", contentValues);
            }
        });
    }

    public static void c(JSONObject jSONObject) {
        if (gu.c() <= 0 || gu.tt() <= 0) {
            return;
        }
        try {
            jSONObject.put("dpl_status_counter", c());
        } catch (JSONException unused) {
        }
    }
}
