package com.baidu.location.e;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26461a = "loc.map.baidu.com";
    public static String b = "https://blg.map.baidu.com/map_loc_debug/debug_url.json";
    public static String c = "https://loc.map.baidu.com/sdk_ep.php";
    public static String d = "https://loc.map.baidu.com/tcu.php";
    public static String e = "https://loc.map.baidu.com/sdk.php";
    public static String f = "https://loc.map.baidu.com/cfgs/loc/commcfgs";
    public static String g = "https://client.map.baidu.com/phpui2/?";
    public static String h = "https://loc.map.baidu.com/cfgs/indoorloc/indoorroadnet";
    public static String i = "https://aispace.baidu.com/cfgs/indoorloc/indoorbldgrects";
    public static String j = "https://parking.baidu.com/parking/api/parkingdata/getcarportlistforlocation?";
    public static String k = "https://daup.map.baidu.com/cltr/rcvr";
    public static String l = "https://loc.map.baidu.com/vdr_yawcheck";
    public static String m = "https://ofloc.map.baidu.com/locnd";
    public static String n = "https://ofloc.map.baidu.com/locnu";
    public static String o = "https://aispace.baidu.com/aispacelbs/receiver/recordlog";
    public static String p = "https://ofloc.map.baidu.com/LocBrokerService/do_loc_map_match";
    public static String q = "https://ofloc.map.baidu.com/PlanarStartService/detect_parking_exits";
    public static String r = "https://loc.map.baidu.com/gpsz";
    public static String s = "https://loc.map.baidu.com/indoorlocbuildinginfo.php";
    public static String t = "https://loc.map.baidu.com/cc.php";

    public static void a() {
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getType().equals(String.class) && Modifier.isStatic(field.getModifiers())) {
                try {
                    field.set(null, field.get(null).toString().replace("//" + f26461a, "//cnloc.map.baidu.com"));
                } catch (Exception unused) {
                }
            }
        }
    }
}
