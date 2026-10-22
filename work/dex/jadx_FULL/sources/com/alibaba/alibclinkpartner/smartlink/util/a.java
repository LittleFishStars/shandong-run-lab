package com.alibaba.alibclinkpartner.smartlink.util;

import com.alibaba.alibclinkpartner.smartlink.data.MAtrixAppData;
import com.alibaba.alibclinkpartner.smartlink.data.MatrixAppInfoDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f23580a = "android.permission.READ_PHONE_STATE";

    public static int a(String str, String str2) {
        int i = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf == -1) {
                return i;
            }
            str = str.substring(iIndexOf + str2.length());
            i++;
        }
    }

    public static List<String> a(MAtrixAppData mAtrixAppData) {
        Map<String, MatrixAppInfoDetail> map;
        ArrayList arrayList = new ArrayList();
        if (mAtrixAppData != null && (map = mAtrixAppData.appinfo) != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(map.get(it.next()).packageName);
            }
        }
        return arrayList;
    }
}
