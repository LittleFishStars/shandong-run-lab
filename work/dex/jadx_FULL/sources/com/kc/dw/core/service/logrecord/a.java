package com.kc.dw.core.service.logrecord;

import android.text.TextUtils;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.domain.AppendInfo;
import com.kc.dw.core.router.log.EventBean;
import com.kc.dw.core.router.log.bean.CodeMsg;
import com.kc.dw.core.router.log.bean.DebugMsg;
import com.kc.dw.core.utils.o1;
import com.kc.dw.core.utils.w0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f39314a = new Object();

    public static AppendInfo a(com.kc.dw.core.loader.b bVar) {
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return null;
        }
        return bVar.getSdkAdInfo().getAppendInfo();
    }

    public static void a(int i, String str, com.kc.dw.core.loader.b bVar) {
        a(i, str, bVar, -1, null);
    }

    public static void a(int i, String str, com.kc.dw.core.loader.b bVar, int i2, String str2) {
        LinkedHashMap<String, Long> eventTimes;
        EventBean data = null;
        try {
            AppendInfo appendInfoA = a(bVar);
            eventTimes = appendInfoA != null ? appendInfoA.getEventTimes(b.a(bVar.getSdkAdInfo())) : null;
        } catch (Exception unused) {
        }
        try {
            data = i2 > -1 ? new CodeMsg().init(str, eventTimes).setData(i2, str2) : new EventBean().init(str, eventTimes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(i, str, bVar, data);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d8  */
    public static void a(int i, String str, com.kc.dw.core.loader.b bVar, EventBean eventBean) {
        LinkedHashMap<String, Long> eventTimes;
        String accept_id;
        String str2;
        String posId;
        AdType adType;
        long curAllTimes;
        if (bVar != null) {
            try {
                if (bVar.getSdkAdInfo() != null && !"SSD".equals(bVar.getSdkAdInfo().getSdk())) {
                    eventBean.put2Data("aid", bVar.getSdkAdInfo().getApp_id());
                    eventBean.put2Data("pid", bVar.getSdkAdInfo().getPid());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        AppendInfo appendInfoA = a(bVar);
        if (eventBean != null && appendInfoA != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (((str.hashCode() == 3187 && str.equals("e8")) ? (byte) 0 : (byte) -1) == 0) {
                        eventBean.data.put(com.google.android.exoplayer2.extractor.flv.c.f2766e, Integer.valueOf(appendInfoA.incrementAndGetEventCount(str)));
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        String curReqId = null;
        try {
            AppendInfo appendInfoA2 = a(bVar);
            eventTimes = appendInfoA2 != null ? appendInfoA2.getEventTimes(b.a(bVar.getSdkAdInfo())) : null;
        } catch (Exception unused) {
        }
        if (bVar != null) {
            try {
                if (bVar.getSdkAdInfo() == null) {
                    str2 = null;
                } else {
                    if ("SSD".equals(bVar.getSdkAdInfo().getSdk())) {
                        AppendInfo appendInfoA3 = a(bVar);
                        if (appendInfoA3 != null) {
                            accept_id = appendInfoA3.getFromId();
                        } else {
                            str2 = null;
                        }
                    } else {
                        accept_id = bVar.getSdkAdInfo().getAccept_id();
                    }
                    str2 = accept_id;
                }
            } catch (Exception unused2) {
            }
        } else {
            str2 = null;
        }
        if (bVar != null) {
            try {
                if (bVar.getAdLoader() != null) {
                    posId = bVar.getAdLoader().getPosId();
                } else {
                    posId = null;
                }
            } catch (Exception unused3) {
            }
        } else {
            posId = null;
        }
        if (bVar != null) {
            try {
                if (bVar.getAdLoader() != null) {
                    adType = bVar.getAdLoader().getAdType();
                } else {
                    adType = null;
                }
            } catch (Exception unused4) {
            }
        } else {
            adType = null;
        }
        try {
            AppendInfo appendInfoA4 = a(bVar);
            curAllTimes = appendInfoA4 != null ? appendInfoA4.getCurAllTimes() : -1L;
        } catch (Exception unused5) {
        }
        try {
            AppendInfo appendInfoA5 = a(bVar);
            if (appendInfoA5 != null) {
                curReqId = appendInfoA5.getCurReqId();
            }
        } catch (Exception unused6) {
        }
        a(eventTimes, i, str, str2, posId, adType, curAllTimes, curReqId, eventBean);
    }

    public static void a(LinkedHashMap<String, Long> linkedHashMap, int i, String str, String str2, String str3, AdType adType, long j, String str4) {
        a(linkedHashMap, i, str, str2, str3, adType, j, str4, new EventBean().init(str, linkedHashMap));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025 A[Catch: Exception -> 0x0078, TRY_LEAVE, TryCatch #1 {Exception -> 0x0078, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x0016, B:9:0x0018, B:10:0x001a, B:13:0x001f, B:15:0x0025, B:19:0x0031, B:21:0x003b, B:23:0x0041, B:25:0x0059, B:27:0x005d, B:34:0x0072, B:38:0x0077, B:11:0x001b, B:12:0x001e), top: B:53:0x0002, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x002e  */
    /* JADX WARN: Code duplicated, block: B:21:0x003b A[Catch: Exception -> 0x0078, TryCatch #1 {Exception -> 0x0078, blocks: (B:3:0x0002, B:4:0x0008, B:6:0x0010, B:8:0x0016, B:9:0x0018, B:10:0x001a, B:13:0x001f, B:15:0x0025, B:19:0x0031, B:21:0x003b, B:23:0x0041, B:25:0x0059, B:27:0x005d, B:34:0x0072, B:38:0x0077, B:11:0x001b, B:12:0x001e), top: B:53:0x0002, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0040  */
    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:32:0x006d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0070  */
    /* JADX WARN: Code duplicated, block: B:51:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void a(LinkedHashMap<String, Long> linkedHashMap, int i, String str, String str2, String str3, AdType adType, long j, String str4, EventBean eventBean) {
        String strAppId;
        int iValue;
        String str5;
        if (eventBean == null) {
            try {
                eventBean = new EventBean();
                if (TextUtils.isEmpty(eventBean.event) && !TextUtils.isEmpty(str)) {
                    eventBean.event = str;
                }
                synchronized (f39314a) {
                    a(linkedHashMap, eventBean);
                }
                if (com.kc.dw.base.a.adConfig() != null) {
                    strAppId = com.kc.dw.base.a.adConfig().appId();
                } else {
                    strAppId = "";
                }
                eventBean.app_id = o1.a(strAppId, 0);
                eventBean.pid = str3;
                if (adType != null) {
                    iValue = adType.value();
                } else {
                    iValue = 0;
                }
                eventBean.ad_type = iValue;
                eventBean.all_times = j;
                eventBean.uuid = str4;
                eventBean.network = o1.a(w0.F, 0);
                eventBean.adn = o1.a(str2, 0);
                if (i >= 10 && !(eventBean instanceof DebugMsg)) {
                    eventBean.put2Data("event", eventBean.event);
                    if (i != 10) {
                        str5 = "d1";
                    } else if (i != 15) {
                        str5 = "";
                    } else {
                        str5 = "d2";
                    }
                    eventBean.event = str5;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            if (TextUtils.isEmpty(eventBean.event)) {
                eventBean.event = str;
            }
            synchronized (f39314a) {
                a(linkedHashMap, eventBean);
                if (com.kc.dw.base.a.adConfig() != null) {
                    strAppId = com.kc.dw.base.a.adConfig().appId();
                } else {
                    strAppId = "";
                }
                eventBean.app_id = o1.a(strAppId, 0);
                eventBean.pid = str3;
                if (adType != null) {
                    iValue = adType.value();
                } else {
                    iValue = 0;
                }
                eventBean.ad_type = iValue;
                eventBean.all_times = j;
                eventBean.uuid = str4;
                eventBean.network = o1.a(w0.F, 0);
                eventBean.adn = o1.a(str2, 0);
                if (i >= 10) {
                    eventBean.put2Data("event", eventBean.event);
                    if (i != 10) {
                        str5 = "d1";
                    } else if (i != 15) {
                        str5 = "";
                    } else {
                        str5 = "d2";
                    }
                    eventBean.event = str5;
                }
            }
        }
        try {
            if (com.kc.dw.base.middleware.b.f39217a == null) {
                com.kc.dw.base.middleware.b.f39217a = (com.kc.dw.core.router.service.c) com.kc.dw.core.router.a.a(com.kc.dw.core.router.service.c.class);
            }
            com.kc.dw.core.router.service.c cVar = com.kc.dw.base.middleware.b.f39217a;
            if (cVar != null) {
                cVar.a(i, eventBean);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(LinkedHashMap<String, Long> linkedHashMap, EventBean eventBean) {
        LinkedHashMap<String, Long> linkedHashMap2;
        try {
            if (eventBean.timeline == null && linkedHashMap != null && !linkedHashMap.isEmpty()) {
                eventBean.timeline = linkedHashMap;
            }
            LinkedHashMap<String, Long> linkedHashMap3 = eventBean.timeline;
            if (linkedHashMap3 != null) {
                try {
                    if (!linkedHashMap3.containsKey("e0")) {
                        linkedHashMap3.put("e0", Long.valueOf(AdSdk.getInitTime()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            LinkedHashMap<String, Long> linkedHashMap4 = eventBean.timeline;
            if (linkedHashMap4 != null) {
                linkedHashMap2 = new LinkedHashMap<>();
                try {
                    for (Map.Entry<String, Long> entry : linkedHashMap4.entrySet()) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } else {
                linkedHashMap2 = null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            linkedHashMap2 = null;
        }
        try {
            if (eventBean.timeline != null && ((!"e5".equals(eventBean.event) && !"e6".equals(eventBean.event)) || !eventBean.timeline.containsKey(eventBean.event))) {
                eventBean.timeline.put(eventBean.event, Long.valueOf(eventBean.msec));
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        if (linkedHashMap2 != null) {
            eventBean.timeline = linkedHashMap2;
        }
    }
}
