package cj.mobile.wm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class na {
    public static w9.dexa dexa(da daVar) {
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = daVar.dexc;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long jDexb = str != null ? dexb(str) : 0L;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z = false;
            j = 0;
            j2 = 0;
            while (i < strArrSplit.length) {
                String strTrim = strArrSplit[i].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j = 0;
            j2 = 0;
        }
        String str3 = map.get("Expires");
        long jDexb2 = str3 != null ? dexb(str3) : 0L;
        String str4 = map.get("Last-Modified");
        long jDexb3 = str4 != null ? dexb(str4) : 0L;
        String str5 = map.get("ETag");
        if (i != 0) {
            long j5 = jCurrentTimeMillis + (j * 1000);
            j3 = j5;
            j4 = z ? j5 : (j2 * 1000) + j5;
        } else {
            j3 = 0;
            if (jDexb <= 0 || jDexb2 < jDexb) {
                j4 = 0;
            } else {
                j4 = jCurrentTimeMillis + (jDexb2 - jDexb);
                j3 = j4;
            }
        }
        w9.dexa dexaVar = new w9.dexa();
        dexaVar.dexa = daVar.dexb;
        dexaVar.dexb = str5;
        dexaVar.dexf = j3;
        dexaVar.dexe = j4;
        dexaVar.dexc = jDexb;
        dexaVar.dexd = jDexb3;
        dexaVar.dexg = map;
        dexaVar.dexh = daVar.dexd;
        return dexaVar;
    }

    public static String dexa(long j) {
        return dexa("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    public static String dexa(Map<String, String> map) {
        return dexa(map, "ISO-8859-1");
    }

    public static String dexa(Map<String, String> map, String str) {
        String str2;
        if (map != null && (str2 = map.get("Content-Type")) != null) {
            String[] strArrSplit = str2.split(com.alipay.sdk.m.y.l.b, 0);
            for (int i = 1; i < strArrSplit.length; i++) {
                String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                    return strArrSplit2[1];
                }
            }
        }
        return str;
    }

    public static SimpleDateFormat dexa(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static List<aa> dexa(List<aa> list, w9.dexa dexaVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator<aa> it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(it.next().dexa());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<aa> list2 = dexaVar.dexh;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (aa aaVar : dexaVar.dexh) {
                    if (!treeSet.contains(aaVar.dexa())) {
                        arrayList.add(aaVar);
                    }
                }
            }
        } else if (!dexaVar.dexg.isEmpty()) {
            for (Map.Entry<String, String> entry : dexaVar.dexg.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new aa(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static Map<String, String> dexa(w9.dexa dexaVar) {
        if (dexaVar == null) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap();
        String str = dexaVar.dexb;
        if (str != null) {
            map.put("If-None-Match", str);
        }
        long j = dexaVar.dexd;
        if (j > 0) {
            map.put("If-Modified-Since", dexa(j));
        }
        return map;
    }

    public static long dexb(String str) {
        try {
            return dexa("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                ia.dexd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            ia.dexa(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }
}
