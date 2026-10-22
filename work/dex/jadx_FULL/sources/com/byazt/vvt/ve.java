package com.byazt.vvt;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.LruCache;
import com.byazt.aas.nb;
import com.byazt.bwm.sp;
import com.byazt.ete.ic;
import com.byazt.ete.x;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 210, 54})
public class ve {
    public static final LruCache<String, Integer> c = new LruCache<>(20);
    public static final Map<Integer, tt> tt = new ConcurrentHashMap();

    @com.byazt.zqa.c(c = {0, 1, 210, 24})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.byazt.dj.tt f29150a;
        public int c;
        public int n = 0;
        public String tt;
        public int uj;
        public long ve;

        public c(int i, String str, int i2, long j, com.byazt.dj.tt ttVar) {
            this.c = i;
            this.tt = str;
            this.uj = i2;
            this.ve = j;
            this.f29150a = ttVar;
        }

        public void c(int i) {
            this.n = i;
        }
    }

    public static JSONObject c(int i, String str) {
        Map<Integer, tt> map = tt;
        if (map.get(Integer.valueOf(i)) == null) {
            map.put(Integer.valueOf(i), new tt());
        }
        tt ttVar = map.get(Integer.valueOf(i));
        if (ttVar != null) {
            return ttVar.c(i, str);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    public static JSONObject tt(int i, String str) {
        long jTt;
        JSONObject jSONObject = new JSONObject();
        boolean zC = 3;
        try {
            try {
                if (i != 3 && i != 4) {
                    com.byazt.eti.n nVarC = com.byazt.eti.n.c(i);
                    zC = nVarC.uj(str);
                    jTt = nVarC.n(str);
                } else if ((com.byazt.by.n.c().sl() & 16) == 16) {
                    com.byazt.eti.n nVarC2 = com.byazt.eti.n.c(3);
                    zC = nVarC2.uj(str);
                    jTt = nVarC2.n(str);
                } else {
                    com.byazt.tdq.uj ujVar = new com.byazt.tdq.uj();
                    zC = ujVar.c(str);
                    jTt = ujVar.tt(str);
                }
            } catch (Throwable unused) {
                zC = 0;
                jTt = 0;
            }
        } catch (Throwable unused2) {
            jTt = 0;
        }
        try {
            jSONObject.put("has_cache", zC);
            zC = "cache_exp_ts";
            jSONObject.put("cache_exp_ts", Math.max(0L, jTt));
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject uj(int i, String str) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int iYp = x.c(i).yp();
        if (iYp <= 0) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - (((long) iYp) * 60000);
        int i8 = 0;
        int i9 = 1;
        Cursor cursorQuery = com.byazt.pe.c.query(gt.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 1 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery == null || !cursorQuery.moveToFirst()) {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        } else {
            int i10 = 0;
            int i11 = 0;
            i4 = 0;
            int i12 = 0;
            i5 = 0;
            while (true) {
                int i13 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                if (i13 == i9) {
                    i10 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                } else if (i13 == 2) {
                    i11 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i4 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                } else if (i13 == 3) {
                    i12 += cursorQuery.getInt(cursorQuery.getColumnIndex("request_count"));
                    i5 += cursorQuery.getInt(cursorQuery.getColumnIndex("response_count"));
                }
                if (!cursorQuery.moveToNext()) {
                    break;
                }
                i9 = 1;
            }
            i3 = i10 + i11 + i12;
            i2 = i4 + i5;
        }
        Cursor cursorQuery2 = com.byazt.pe.c.query(gt.getContext(), "meta_req_record_v1", null, "slot_type = ? and create_time >= ? and event_type = 2 and appid = ?", new String[]{String.valueOf(i), String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        if (cursorQuery2 == null || !cursorQuery2.moveToFirst()) {
            i6 = 0;
            i7 = 0;
        } else {
            i6 = 0;
            do {
                int i14 = Integer.parseInt(cursorQuery2.getString(cursorQuery2.getColumnIndex("status")));
                if (i14 == 1) {
                    i8++;
                } else if (i14 == 2) {
                    i6++;
                }
            } while (cursorQuery2.moveToNext());
            int i15 = i8;
            i8 += i6;
            i7 = i15;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (cursorQuery2 != null) {
            cursorQuery2.close();
        }
        int i16 = i3 <= 0 ? -1 : (int) ((i2 * 100.0f) / i3);
        int i17 = i2 <= 0 ? -1 : (int) ((i4 * 100.0f) / i2);
        int i18 = i2 <= 0 ? -1 : (int) ((i5 * 100.0f) / i2);
        int i19 = (i8 <= 0 || i2 <= 0) ? -1 : (int) ((i8 * 100.0f) / i2);
        int i20 = i8 <= 0 ? -1 : (int) ((i6 * 100.0f) / i8);
        int i21 = i8 > 0 ? (int) ((i7 * 100.0f) / i8) : -1;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("send_request_sum", i3);
            jSONObject.put("send_response_sum", i2);
            jSONObject.put("send_fill_rate", i16);
            jSONObject.put("send_net_rate", i17);
            jSONObject.put("send_cache_rate", i18);
            jSONObject.put("show_sum", i8);
            jSONObject.put("show_rate", i19);
            jSONObject.put("show_cache_rate", i20);
            jSONObject.put("show_net_rate", i21);
            jSONObject.put("interval_minute", iYp);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 210, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt {
        public long c;
        public JSONObject tt;

        public JSONObject c(int i, String str) {
            if (!c(i)) {
                this.tt = ve.uj(i, str);
                this.c = System.currentTimeMillis();
            }
            return this.tt;
        }

        private boolean c(int i) {
            return System.currentTimeMillis() - this.c <= ((long) ((Math.max(0, x.c(i).z()) * 60) * 1000)) && this.tt != null;
        }
    }

    public static void c(final c cVar, final int i) {
        if (cVar != null && x.c(cVar.c).yp() > 0) {
            com.byazt.bzd.x.c(new sp("cacheDataCenter-recordSend") { // from class: com.byazt.vvt.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("rit", cVar.tt);
                    contentValues.put("appid", cVar.f29150a == null ? "" : cVar.f29150a.or());
                    contentValues.put("slot_type", Integer.valueOf(cVar.c));
                    contentValues.put("create_time", Long.valueOf(cVar.ve));
                    contentValues.put("status", Integer.valueOf(i));
                    contentValues.put("request_count", Integer.valueOf(cVar.uj));
                    contentValues.put("response_count", Integer.valueOf(cVar.n));
                    contentValues.put("event_type", (Integer) 1);
                    com.byazt.pe.c.insert(gt.getContext(), "meta_req_record_v1", contentValues);
                }
            });
        }
    }

    public static void c(final ic icVar) {
        LruCache<String, Integer> lruCache = c;
        if (lruCache.get(icVar.sf()) != null) {
            return;
        }
        lruCache.put(icVar.sf(), 1);
        final int iSl = nb.sl(icVar);
        if (x.c(iSl).yp() <= 0) {
            return;
        }
        com.byazt.bzd.x.c(new sp("cacheDataCenter-recordShow") { // from class: com.byazt.vvt.ve.2
            @Override // java.lang.Runnable
            public void run() {
                String strC = nb.c(icVar, "");
                ContentValues contentValues = new ContentValues();
                contentValues.put("rit", strC);
                contentValues.put("appid", icVar.jl());
                contentValues.put("slot_type", Integer.valueOf(iSl));
                contentValues.put("create_time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("status", Integer.valueOf(icVar.up() ? 2 : 1));
                contentValues.put("event_type", (Integer) 2);
                com.byazt.pe.c.insert(gt.getContext(), "meta_req_record_v1", contentValues);
            }
        });
    }

    public static void c() {
        com.byazt.bzd.x.c(new sp("cacheDataCenter-clearOldData") { // from class: com.byazt.vvt.ve.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.pe.c.delete(gt.getContext(), "meta_req_record_v1", "create_time < ?", new String[]{String.valueOf(System.currentTimeMillis() - 86400000)});
            }
        });
    }
}
