package com.byazt.twu;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 91})
public class sp extends tt {
    public com.byazt.vb.n tt;
    public com.byazt.rz.c uj;
    public List<String> ve;

    public sp(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, nVar, cVar == null ? com.byazt.rz.c.ve() : cVar);
        this.ve = new ArrayList();
        this.uj = cVar;
        this.tt = nVar;
        if (cVar == null) {
            this.uj = com.byazt.rz.c.ve();
        }
    }

    public static String n(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    @Override // com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.a(ttVar);
    }

    @Override // com.byazt.twu.ve
    public String delete(List<com.byazt.vb.tt> list) {
        if (list == null || list.size() == 0) {
            return "list is empty";
        }
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vb.tt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ve());
        }
        com.byazt.ml.c.c(list, this.tt, c());
        String strC = com.byazt.ym.tt.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) linkedList, 1000, true), this.tt);
        c(linkedList);
        return strC;
    }

    public byte tt() {
        return (byte) 1;
    }

    @Override // com.byazt.twu.tt
    public com.byazt.vb.n uj() {
        return this.tt;
    }

    public byte ve() {
        return (byte) 2;
    }

    public void ve(List<String> list) {
        c();
        list.size();
        com.byazt.ym.tt.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) list, 1000, true), this.tt);
        com.byazt.ml.tt.c(com.byazt.mv.tt.c.z(), list.size(), this.tt);
        c(list);
    }

    private void uj(List<com.byazt.vb.tt> list) {
        LinkedList linkedList = new LinkedList();
        Iterator<com.byazt.vb.tt> it = list.iterator();
        while (it.hasNext()) {
            linkedList.add(it.next().ve());
        }
        com.byazt.ym.tt.c(getContext(), "UPDATE " + c() + " SET retry = retry+1 WHERE " + c("id", (List<?>) linkedList, 1000, true), this.tt);
    }

    @Override // com.byazt.twu.tt
    public String c() {
        return this.tt.tt().uj();
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(int i, String str, int i2, boolean z) {
        long jC = com.byazt.mv.c.c(i, getContext(), this.tt);
        if (jC <= 0) {
            jC = 1;
        } else if (jC > 100) {
            jC = 100;
        }
        String str2 = str + " DESC limit " + jC;
        ArrayList arrayList = new ArrayList();
        this.ve.clear();
        Cursor cursorQuery = com.byazt.ym.tt.query(getContext(), c(), new String[]{"id", "value", "encrypt", "retry"}, null, null, null, null, str2, this.tt);
        if (cursorQuery != null) {
            while (true) {
                try {
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                    if (i3 == 1) {
                        string2 = this.tt.uj().c(string2);
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.ve.add(string);
                    } else {
                        if (arrayList.size() > 100) {
                            break;
                        }
                        com.byazt.fo.c cVar = new com.byazt.fo.c(string, new JSONObject(string2));
                        cVar.tt(i4 + 1);
                        cVar.tt(ve());
                        cVar.c(tt());
                        arrayList.add(cVar);
                    }
                } finally {
                    try {
                        cursorQuery.close();
                        if (!this.ve.isEmpty()) {
                            ve(this.ve);
                            this.ve.clear();
                        }
                        if (com.byazt.ml.c.c(i2) && !z) {
                            c(arrayList, 10, 604800000L);
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return arrayList;
    }

    public static String uj(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(String str, int i, boolean z) {
        com.byazt.rz.c cVar = this.uj;
        if (cVar == null) {
            return new ArrayList();
        }
        return c(cVar.tt(), str, i, z);
    }

    private void c(int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        Context context = getContext();
        String strC = c();
        StringBuilder sb = new StringBuilder();
        sb.append(jCurrentTimeMillis);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i);
        com.byazt.ym.tt.delete(context, strC, "gen_time <? OR retry >?", new String[]{sb.toString(), sb2.toString()}, this.tt);
    }

    public void c(List<com.byazt.vb.tt> list, int i, long j) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            uj(list);
            c(i, j);
        } catch (Exception unused) {
        }
    }

    private static String c(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int iMin = Math.min(i, 1000);
        int size = list.size();
        if (size % iMin == 0) {
            i2 = size / iMin;
        } else {
            i2 = (size / iMin) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * iMin;
            String strC = c(TextUtils.join("','", list.subList(i4, Math.min(i4 + iMin, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(strC);
            sb.append("')");
        }
        return c(sb.toString(), str + str2 + "('')");
    }

    private static String c(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
