package com.alibaba.appmonitor.d;

import com.alibaba.analytics.core.model.LogField;
import com.alibaba.appmonitor.a.e;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.event.d;
import com.alibaba.appmonitor.event.g;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.pool.ReuseJSONArray;
import com.alibaba.fastjson.JSON;
import com.coremedia.iso.boxes.MetaBox;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static void a(UTDimensionValueSet uTDimensionValueSet, d dVar) {
        Integer eventId = uTDimensionValueSet.getEventId();
        if (eventId != null) {
            EventType eventType = EventType.getEventType(eventId.intValue());
            g gVar = (g) com.alibaba.appmonitor.pool.a.a().a(g.class, new Object[0]);
            gVar.eventId = 6699;
            gVar.aI = dVar.module;
            gVar.aJ = dVar.monitorPoint;
            gVar.w.putAll(com.alibaba.appmonitor.a.a.c());
            if (uTDimensionValueSet.getMap() != null) {
                gVar.w.putAll(uTDimensionValueSet.getMap());
                gVar.w.remove("commitDay");
            }
            HashMap map = new HashMap();
            map.put(MetaBox.TYPE, e.d());
            map.put("_event_id", eventId);
            ReuseJSONArray reuseJSONArray = (ReuseJSONArray) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONArray.class, new Object[0]);
            reuseJSONArray.add(dVar.a());
            com.alibaba.appmonitor.pool.a.a().a(dVar);
            map.put("data", reuseJSONArray);
            gVar.w.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(map));
            gVar.w.put(LogField.EVENTID.toString(), String.valueOf(6699));
            b(gVar);
            com.alibaba.appmonitor.pool.a.a().a(reuseJSONArray);
        }
    }

    public static void b(g gVar) {
        com.alibaba.analytics.core.f.d.a().a(new com.alibaba.analytics.core.model.a(gVar.aH, String.valueOf(gVar.eventId), gVar.aI, gVar.aJ, gVar.aK, gVar.w));
        com.alibaba.appmonitor.pool.a.a().a(gVar);
    }

    public static void e(Map<UTDimensionValueSet, List<d>> map) {
        Integer eventId;
        for (Map.Entry<UTDimensionValueSet, List<d>> entry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            UTDimensionValueSet key = entry.getKey();
            List<d> value = entry.getValue();
            if (value.size() != 0 && (eventId = key.getEventId()) != null) {
                EventType eventType = EventType.getEventType(eventId.intValue());
                int i = 0;
                g gVar = (g) com.alibaba.appmonitor.pool.a.a().a(g.class, new Object[0]);
                gVar.eventId = eventId.intValue();
                gVar.w.putAll(com.alibaba.appmonitor.a.a.c());
                if (key.getMap() != null) {
                    gVar.w.putAll(key.getMap());
                    gVar.w.remove("commitDay");
                }
                HashMap map2 = new HashMap();
                map2.put(MetaBox.TYPE, e.d());
                ReuseJSONArray reuseJSONArray = (ReuseJSONArray) com.alibaba.appmonitor.pool.a.a().a(ReuseJSONArray.class, new Object[0]);
                for (d dVar : value) {
                    reuseJSONArray.add(dVar.a());
                    if (i == 0) {
                        sb.append(dVar.module);
                        sb2.append(dVar.monitorPoint);
                    } else {
                        sb.append(",");
                        sb.append(dVar.module);
                        sb2.append(",");
                        sb2.append(dVar.monitorPoint);
                    }
                    i++;
                    com.alibaba.appmonitor.pool.a.a().a(dVar);
                }
                map2.put("data", reuseJSONArray);
                gVar.w.put(eventType.getAggregateEventArgsKey(), JSON.toJSONString(map2));
                String string = sb.toString();
                String string2 = sb2.toString();
                gVar.w.put(LogField.ARG1.toString(), string);
                gVar.w.put(LogField.ARG2.toString(), string2);
                gVar.aI = string;
                gVar.aJ = string2;
                b(gVar);
                com.alibaba.appmonitor.pool.a.a().a(reuseJSONArray);
            }
            com.alibaba.appmonitor.pool.a.a().a(key);
        }
    }

    public static void a(g gVar) {
        if (gVar == null) {
            return;
        }
        com.alibaba.analytics.core.f.d.a().a(new com.alibaba.analytics.core.model.a(gVar.aH, String.valueOf(gVar.eventId), gVar.aI, gVar.aJ, gVar.aK, gVar.w));
        com.alibaba.appmonitor.pool.a.a().a(gVar);
    }
}
