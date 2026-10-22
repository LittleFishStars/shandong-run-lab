package com.byazt.qw;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 726, 13})
public class tt {
    public static final tt c = new tt();

    /* JADX WARN: Code duplicated, block: B:26:0x00bd A[DONT_GENERATE, PHI: r1 r3
      0x00bd: PHI (r1v2 java.util.ArrayList) = (r1v3 java.util.ArrayList), (r1v5 java.util.ArrayList) binds: [B:25:0x00bb, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]
      0x00bd: PHI (r3v3 android.database.Cursor) = (r3v4 android.database.Cursor), (r3v5 android.database.Cursor) binds: [B:25:0x00bb, B:18:0x00b1] A[DONT_GENERATE, DONT_INLINE]] */
    public List<c> c(long j) {
        ArrayList arrayList;
        long j2 = j - 518400000;
        ArrayList arrayList2 = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = com.byazt.pe.c.query(gt.getContext(), "sdk_launch", null, "dev1 > ?", new String[]{String.valueOf(j2)}, null, null, "dev1 DESC");
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev1"));
                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev2"));
                        long j5 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev3"));
                        long j6 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev4"));
                        long j7 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev5"));
                        long j8 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev6"));
                        long j9 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev7"));
                        ArrayList arrayList3 = arrayList2;
                        try {
                            long j10 = cursorQuery.getLong(cursorQuery.getColumnIndex("dev8"));
                            c cVar = new c();
                            cVar.uj(j3);
                            cVar.n(j4);
                            cVar.a(j5);
                            cVar.sp(j6);
                            cVar.tt((int) j7);
                            cVar.ve(j8);
                            cVar.c(j9);
                            cVar.tt(j10);
                            arrayList = arrayList3;
                            try {
                                arrayList.add(cVar);
                                arrayList2 = arrayList;
                            } catch (Exception e) {
                                e = e;
                                m.c(e);
                                return arrayList;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            arrayList = arrayList3;
                        }
                    }
                }
                arrayList = arrayList2;
            } finally {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = arrayList2;
        }
        return arrayList;
    }

    public void insert(c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("dev1", Long.valueOf(cVar.i()));
        contentValues.put("dev2", Long.valueOf(cVar.da()));
        contentValues.put("dev3", Long.valueOf(cVar.sl()));
        contentValues.put("dev4", Long.valueOf(cVar.t()));
        contentValues.put("dev5", Integer.valueOf(cVar.u()));
        contentValues.put("dev6", Long.valueOf(cVar.x()));
        contentValues.put("dev7", Long.valueOf(cVar.c()));
        contentValues.put("dev8", Long.valueOf(cVar.tt()));
        com.byazt.pe.c.insert(gt.getContext(), "sdk_launch", contentValues);
    }

    public void c() {
        com.byazt.pe.c.delete(gt.getContext(), "sdk_launch", "dev1 < ?", new String[]{String.valueOf(ve.ve().sp() - 2592000000L)});
    }
}
