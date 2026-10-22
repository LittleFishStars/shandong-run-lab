package com.kc.dw.core.utils;

import com.google.gson.Gson;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, a> f39405a = new HashMap<>();
    public static final Gson b = new Gson();
    public static HashMap<String, HashMap<String, RecordBean>> c;

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f39406a;
        public boolean b;
    }

    public static HashMap<String, RecordBean> a() {
        try {
            RecordMapBean recordMapBean = (RecordMapBean) b.fromJson(r.a().a("record_data") ? r.a().a("record_data", "") : com.kc.dw.base.a.getSharedPreferences().getString("record_data", ""), RecordMapBean.class);
            if (recordMapBean == null) {
                return null;
            }
            HashMap<String, HashMap<String, RecordBean>> dateRecordMap = recordMapBean.getDateRecordMap();
            if (dateRecordMap == null) {
                dateRecordMap = new HashMap<>();
            }
            Calendar calendar = Calendar.getInstance();
            return dateRecordMap.get(String.format("%04d-%02d-%02d", Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(String str, int i) {
        long jCurrentTimeMillis;
        r rVarA;
        try {
            HashMap<String, RecordBean> mapA = a();
            if (mapA == null) {
                mapA = new HashMap<>();
            }
            RecordBean recordBean = mapA.get(str);
            if (recordBean == null) {
                recordBean = new RecordBean();
            }
            recordBean.setPid(str);
            switch (i) {
                case 1:
                    recordBean.setLoadNum(recordBean.getLoadNum() + 1);
                    break;
                case 2:
                    recordBean.setLoadSucc(recordBean.getLoadSucc() + 1);
                    break;
                case 3:
                    recordBean.setExposureNum(recordBean.getExposureNum() + 1);
                    break;
                case 4:
                    recordBean.setClickNum(recordBean.getClickNum() + 1);
                    break;
                case 5:
                    recordBean.setDynamicClickNum(recordBean.getDynamicClickNum() + 1);
                    break;
                case 6:
                    recordBean.setLastDynamicLoadedTime(System.currentTimeMillis());
                    break;
                case 7:
                    jCurrentTimeMillis = System.currentTimeMillis();
                    recordBean.setLastDynamicClickTime(jCurrentTimeMillis);
                    recordBean.setLastClickTime(jCurrentTimeMillis);
                    r.a().b("last_dynamic_time", jCurrentTimeMillis);
                    rVarA = r.a();
                    rVarA.b("last_click_time", jCurrentTimeMillis);
                    break;
                case 8:
                    jCurrentTimeMillis = System.currentTimeMillis();
                    recordBean.setLastClickTime(jCurrentTimeMillis);
                    rVarA = r.a();
                    rVarA.b("last_click_time", jCurrentTimeMillis);
                    break;
            }
            mapA.put(str, recordBean);
            a(mapA);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(HashMap<String, RecordBean> map) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
            String str = simpleDateFormat.format(new Date(jCurrentTimeMillis));
            if (c == null) {
                c = new HashMap<>();
            }
            c.put(str, map);
            RecordMapBean recordMapBean = new RecordMapBean();
            recordMapBean.setDateRecordMap(c);
            r.a().b("record_data", b.toJson(recordMapBean));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
