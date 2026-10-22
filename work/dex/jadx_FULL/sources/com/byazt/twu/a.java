package com.byazt.twu;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 970, 34})
public class a extends tt {
    public com.byazt.rz.c n;
    public com.byazt.vb.n tt;
    public final Context uj;
    public List<String> ve;

    public a(Context context, com.byazt.rz.c cVar, com.byazt.vb.n nVar) {
        super(context, nVar, cVar == null ? com.byazt.rz.c.ve() : cVar);
        this.ve = new ArrayList();
        this.uj = context;
        this.n = cVar;
        this.tt = nVar;
        if (cVar == null) {
            this.n = com.byazt.rz.c.ve();
        }
    }

    public static String n(String str) {
        return "ALTER TABLE " + str + " ADD COLUMN encrypt INTEGER default 0";
    }

    @Override // com.byazt.uf.c
    public boolean c(com.byazt.vb.tt ttVar) {
        return com.byazt.ml.c.n(ttVar);
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
        return (byte) 2;
    }

    @Override // com.byazt.twu.tt
    public com.byazt.vb.n uj() {
        return this.tt;
    }

    public byte ve() {
        return (byte) 0;
    }

    public String ve(List<String> list) {
        c();
        list.size();
        String strC = com.byazt.ym.tt.c(getContext(), "DELETE FROM " + c() + " WHERE " + c("id", (List<?>) list, 1000, true), this.tt);
        com.byazt.ml.tt.c(com.byazt.mv.tt.c.z(), list.size(), this.tt);
        c(list);
        return strC;
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
        com.byazt.vb.a aVarTt = this.tt.tt();
        if (aVarTt != null) {
            return aVarTt.tt();
        }
        return null;
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(int i, String str, int i2, boolean z) {
        String str2;
        com.byazt.vb.uj ujVar;
        long jC = com.byazt.mv.c.c(i, getContext(), this.tt);
        com.byazt.ml.ve.tt(c() + " query db max :" + jC + " limit:" + i, this.tt);
        if (jC <= 0) {
            jC = 1;
        } else if (jC > 100) {
            jC = 100;
        }
        String str3 = str + " DESC limit " + jC;
        List<com.byazt.vb.tt> arrayList = new ArrayList<>();
        this.ve.clear();
        com.byazt.vb.n nVar = this.tt;
        String str4 = BaseConstants.EVENT_LABEL_AD_EXTRA_DATA;
        Cursor cursorQuery = com.byazt.ym.tt.query(getContext(), c(), new String[]{"id", "value", "encrypt", "retry"}, null, null, null, null, str3, nVar);
        if (cursorQuery != null) {
            try {
                com.byazt.vb.uj ujVarUj = this.tt.uj();
                while (cursorQuery.moveToNext()) {
                    try {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                        int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("encrypt"));
                        int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("retry"));
                        if (i3 == 1) {
                            string2 = ujVarUj.c(string2);
                        }
                        if (TextUtils.isEmpty(string2)) {
                            this.ve.add(string);
                        } else {
                            if (arrayList.size() > 100) {
                                break;
                            }
                            JSONObject jSONObject = new JSONObject(string2);
                            str2 = str4;
                            try {
                                String strOptString = jSONObject.optString(str2);
                                if (TextUtils.isEmpty(strOptString)) {
                                    ujVar = ujVarUj;
                                } else {
                                    JSONObject jSONObject2 = new JSONObject(strOptString);
                                    jSONObject2.put("retry_count", i4);
                                    ujVar = ujVarUj;
                                    try {
                                        jSONObject2.put("db_rd", System.currentTimeMillis());
                                        jSONObject.put(str2, jSONObject2.toString());
                                    } catch (Throwable th) {
                                        th = th;
                                        com.byazt.ml.ve.ve(th.getMessage(), this.tt);
                                    }
                                }
                                com.byazt.fo.c cVar = new com.byazt.fo.c(string, jSONObject);
                                cVar.tt(i4 + 1);
                                cVar.c(ve());
                                cVar.tt(tt());
                                com.byazt.ml.c.c(jSONObject, cVar, this.tt, i4);
                                arrayList.add(cVar);
                            } catch (Throwable th2) {
                                th = th2;
                                ujVar = ujVarUj;
                                com.byazt.ml.ve.ve(th.getMessage(), this.tt);
                                ujVarUj = ujVar;
                                str4 = str2;
                            }
                            ujVarUj = ujVar;
                            str4 = str2;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = str4;
                    }
                }
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
            } catch (Throwable th4) {
                try {
                    cursorQuery.close();
                    if (!this.ve.isEmpty()) {
                        ve(this.ve);
                        this.ve.clear();
                    }
                    if (com.byazt.ml.c.c(i2) && !z) {
                        c(arrayList, 10, 604800000L);
                    }
                } catch (Exception unused2) {
                }
                throw th4;
            }
        }
        com.byazt.ml.ve.tt(c() + " query db actually size :" + arrayList.size(), this.tt);
        return arrayList;
    }

    public static String uj(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)";
    }

    @Override // com.byazt.twu.ve
    public List<com.byazt.vb.tt> c(String str, int i, boolean z) {
        com.byazt.rz.c cVar = this.n;
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
