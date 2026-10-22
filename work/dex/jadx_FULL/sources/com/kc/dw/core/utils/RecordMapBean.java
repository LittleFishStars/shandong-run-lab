package com.kc.dw.core.utils;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RecordMapBean implements Serializable {
    private HashMap<String, HashMap<String, RecordBean>> dateRecordMap;

    public static RecordMapBean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            RecordMapBean recordMapBean = new RecordMapBean();
            HashMap<String, HashMap<String, RecordBean>> map = new HashMap<>();
            JSONObject jSONObject2 = jSONObject.getJSONObject("dateRecordMap");
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                HashMap<String, RecordBean> map2 = new HashMap<>();
                Iterator<String> itKeys2 = jSONObject3.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    RecordBean recordBeanFromJson = RecordBean.fromJson(jSONObject3.getJSONObject(next2));
                    if (recordBeanFromJson != null) {
                        map2.put(next2, recordBeanFromJson);
                    }
                }
                map.put(next, map2);
            }
            recordMapBean.setDateRecordMap(map);
            return recordMapBean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap<String, HashMap<String, RecordBean>> getDateRecordMap() {
        return this.dateRecordMap;
    }

    public void setDateRecordMap(HashMap<String, HashMap<String, RecordBean>> map) {
        this.dateRecordMap = map;
    }
}
