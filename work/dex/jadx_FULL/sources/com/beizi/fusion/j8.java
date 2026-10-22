package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.model.EventItem;
import com.beizi.fusion.model.FreqItem;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap f27428a = new HashMap();
    private static HashMap b = new HashMap();
    private static Comparator c = new a();
    private static HashMap d = new HashMap();
    private static HashMap e = new HashMap();
    private static HashSet f = new HashSet();

    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EventItem eventItem, EventItem eventItem2) {
            return eventItem.getTimeStamp().compareTo(eventItem2.getTimeStamp());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27429a;
        final /* synthetic */ String b;

        public b(Context context, String str) {
            this.f27429a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            j8.b(this.f27429a, this.b);
        }
    }

    public static int a(String str, String str2) {
        ArrayList arrayList;
        int i = 0;
        if (str2 == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("enter getTodayEventTimes channelMap != null ?  ");
        sb.append(b != null);
        sb.append(",eventCode = ");
        sb.append(str2);
        d(sb.toString());
        a(q1.h().m(), str);
        String strValueOf = String.valueOf(a());
        if ("200.000".equalsIgnoreCase(str2)) {
            HashMap map = f27428a;
            if (map != null && map.get(str) != null) {
                d("getSpaceTodayEventTimes platFormMap.containsKey(adUnitId) = " + f27428a.containsKey(str));
                HashMap map2 = (HashMap) f27428a.get(str);
                if (map2 != null && (arrayList = (ArrayList) map2.get(str2)) != null) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        if (((EventItem) obj).getTimeStamp().compareTo(strValueOf) > 0) {
                            i2++;
                        }
                    }
                    i = i2;
                }
            }
        } else {
            HashMap map3 = b;
            if (map3 != null && map3.get(str) != null) {
                d("getSpaceTodayEventTimes channelMap.containsKey(adUnitId) = " + b.containsKey(str));
                HashMap map4 = (HashMap) b.get(str);
                int i3 = 0;
                for (String str3 : f) {
                    if (map4 != null && map4.get(str3) != null) {
                        HashMap map5 = (HashMap) map4.get(str3);
                        d("getSpaceTodayEventTimes eventMap = " + map5);
                        if (map5 != null && map5.get(str2) != null) {
                            ArrayList arrayList2 = (ArrayList) map5.get(str2);
                            d("getSpaceTodayEventTimes itemList = " + arrayList2 + ",eventCode = " + str2);
                            if (arrayList2 != null && arrayList2.size() > 0) {
                                jh.b("BeiZis", arrayList2.toString());
                                int size2 = arrayList2.size();
                                int i4 = 0;
                                while (i4 < size2) {
                                    Object obj2 = arrayList2.get(i4);
                                    i4++;
                                    if (((EventItem) obj2).getTimeStamp().compareTo(strValueOf) > 0) {
                                        i3++;
                                    }
                                }
                            }
                        }
                    }
                }
                i = i3;
            }
        }
        jh.b("BeiZis", "todayEventTimes = " + i);
        return i;
    }

    public static void b(Context context, String str) {
        try {
            ArrayList arrayList = (ArrayList) i6.a(context).c(str);
            f27428a.put(str, b(arrayList));
            b.put(str, a(arrayList));
            d("adUnitId = " + str + ",platFormMap get = " + f27428a.get(str) + ",channelMap get = " + b.get(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void c(Context context, String str) {
        v3.b().a().execute(new b(context, str));
    }

    public static void d(String str) {
        jh.c("FreqUtil", str);
    }

    public static boolean c(String str) {
        return f27428a.containsKey(str) && b.containsKey(str);
    }

    public static FreqItem b(String str) {
        return (FreqItem) e.get(str);
    }

    private static Map b(List list) {
        ArrayList arrayList;
        if (list != null && list.size() != 0) {
            HashMap map = new HashMap();
            Iterator it = list.iterator();
            Object obj = null;
            ArrayList arrayList2 = null;
            while (it.hasNext()) {
                EventItem eventItem = (EventItem) it.next();
                String code = eventItem.getCode();
                if (!code.equals(obj)) {
                    if (obj != null && arrayList2 != null) {
                        map.put(obj, arrayList2);
                    }
                    if (!map.containsKey(code)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) map.get(code);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    map.put(code, arrayList);
                    arrayList2 = arrayList;
                } else if (arrayList2 != null) {
                    arrayList2.add(eventItem);
                }
                obj = code;
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                Collections.sort(arrayList3, c);
                map.put(str, arrayList3);
            }
            return map;
        }
        return new HashMap();
    }

    public static long a() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    public static void a(Context context, String str) {
        if (c(str)) {
            return;
        }
        c(context, str);
        int i = 0;
        while (!c(str) && i < 100) {
            d("currentWaitInitTime = " + i);
            try {
                Thread.sleep(5L);
                i += 5;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static boolean a(List list, String str, String str2, String str3) {
        if (list != null && list.size() != 0) {
            a(str, list);
            boolean z = false;
            if (str2 == null) {
                HashMap map = (HashMap) f27428a.get(str);
                d("eventMap = " + map);
                if (map == null || map.size() == 0) {
                    return true;
                }
                Iterator it = list.iterator();
                boolean z2 = false;
                while (it.hasNext()) {
                    FreqItem freqItem = (FreqItem) it.next();
                    String eventCode = freqItem.getEventCode();
                    long interval = freqItem.getInterval();
                    int count = freqItem.getCount();
                    ArrayList arrayList = (ArrayList) map.get(eventCode);
                    if (count == 0) {
                        return false;
                    }
                    if (arrayList != null) {
                        if (count > arrayList.size()) {
                            continue;
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis() - Long.parseLong(((EventItem) arrayList.get(arrayList.size() - count)).getTimeStamp());
                            d("platform filter interval = " + interval + ",timeInterval = " + jCurrentTimeMillis);
                            if (jCurrentTimeMillis <= interval) {
                                e.put(str, freqItem);
                            }
                        }
                    } else {
                        d("platform filter localEventItems = null");
                    }
                    z2 = true;
                }
                z = z2;
            } else {
                HashMap map2 = (HashMap) b.get(str);
                d("spaceChannelMap = " + map2);
                if (map2 != null && map2.size() != 0) {
                    HashMap map3 = (HashMap) map2.get(str2);
                    d("channel filter eventMap = " + map3);
                    if (map3 != null && map3.size() != 0) {
                        Iterator it2 = list.iterator();
                        boolean z3 = false;
                        while (it2.hasNext()) {
                            FreqItem freqItem2 = (FreqItem) it2.next();
                            String eventCode2 = freqItem2.getEventCode();
                            long interval2 = freqItem2.getInterval();
                            int count2 = freqItem2.getCount();
                            if (freqItem2.getComponentType() == 1) {
                                map3 = (HashMap) map2.get(str3);
                                d("channel filter by space eventMap = " + map3);
                                if (map3 == null || map3.size() == 0) {
                                    return true;
                                }
                            }
                            d("channel filter code = " + eventCode2);
                            ArrayList arrayList2 = (ArrayList) map3.get(eventCode2);
                            if (count2 == 0) {
                                return false;
                            }
                            if (arrayList2 != null) {
                                d("channel filter localEventItems != null count = " + count2 + ",localEventItems.size() = " + arrayList2.size());
                                if (count2 > arrayList2.size()) {
                                    continue;
                                } else {
                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - Long.parseLong(((EventItem) arrayList2.get(arrayList2.size() - count2)).getTimeStamp());
                                    d("channel filter interval = " + interval2 + ",timeInterval = " + jCurrentTimeMillis2);
                                    if (jCurrentTimeMillis2 <= interval2) {
                                        e.put(str, freqItem2);
                                    }
                                }
                            } else {
                                d("channel filter localEventItems = null");
                            }
                            z3 = true;
                        }
                        z = z3;
                    }
                }
            }
            d("filter adUnitId = " + str + ",channel = " + str2 + ",goThrough = " + z);
            return z;
        }
        return true;
    }

    public static long a(String str) {
        Long l = (Long) d.get(str);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    private static void a(String str, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        long jA = a(str);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jA = Math.max(((FreqItem) it.next()).getInterval(), jA);
        }
        d("maxInterval = " + jA);
        d.put(str, Long.valueOf(jA));
    }

    private static Map a(List list) {
        ArrayList arrayList;
        ArrayList arrayList2;
        if (list != null && list.size() != 0) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                EventItem eventItem = (EventItem) it.next();
                String spaceId = eventItem.getSpaceId();
                if (spaceId != null) {
                    if (!map.containsKey(spaceId)) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(eventItem);
                    } else {
                        arrayList2 = (ArrayList) map.get(spaceId);
                        if (arrayList2 != null) {
                            arrayList2.add(eventItem);
                        }
                    }
                    map.put(spaceId, arrayList2);
                }
                String channel = eventItem.getChannel();
                f.add(channel);
                if (channel != null) {
                    if (!map2.containsKey(channel)) {
                        arrayList = new ArrayList();
                        arrayList.add(eventItem);
                    } else {
                        arrayList = (ArrayList) map2.get(channel);
                        if (arrayList != null) {
                            arrayList.add(eventItem);
                        }
                    }
                    map2.put(channel, arrayList);
                }
            }
            HashMap map3 = new HashMap();
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null) {
                    map3.put(str, (HashMap) b(arrayList3));
                }
            }
            for (String str2 : map2.keySet()) {
                ArrayList arrayList4 = (ArrayList) map2.get(str2);
                if (arrayList4 != null) {
                    map3.put(str2, (HashMap) b(arrayList4));
                }
            }
            return map3;
        }
        return new HashMap();
    }

    public static void a(String str, EventItem eventItem) {
        try {
            HashMap map = (HashMap) f27428a.get(str);
            if (map == null) {
                map = new HashMap();
            }
            String code = eventItem.getCode();
            a(eventItem, map, code);
            String spaceId = eventItem.getSpaceId();
            if (spaceId != null) {
                HashMap map2 = (HashMap) b.get(str);
                if (map2 == null) {
                    map2 = new HashMap();
                }
                HashMap map3 = (HashMap) map2.get(spaceId);
                if (map3 == null) {
                    map3 = new HashMap();
                }
                a(eventItem, map3, code);
                map2.put(spaceId, map3);
            }
            String channel = eventItem.getChannel();
            f.add(channel);
            if (channel != null) {
                HashMap map4 = (HashMap) b.get(str);
                if (map4 == null) {
                    map4 = new HashMap();
                }
                HashMap map5 = (HashMap) map4.get(channel);
                if (map5 == null) {
                    map5 = new HashMap();
                }
                a(eventItem, map5, code);
                map4.put(channel, map5);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(EventItem eventItem, HashMap map, String str) {
        if (map != null) {
            if (!map.containsKey(str)) {
                if (str != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(eventItem);
                    map.put(str, arrayList);
                    return;
                }
                return;
            }
            ArrayList arrayList2 = (ArrayList) map.get(str);
            if (arrayList2 != null) {
                arrayList2.add(eventItem);
                Collections.sort(arrayList2, c);
                map.put(str, arrayList2);
            }
        }
    }
}
