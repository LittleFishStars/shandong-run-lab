package com.byazt.vx;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 42})
public class i {
    public static boolean c = false;
    public static boolean tt = false;

    public static List<String> c() {
        ArrayList arrayList = null;
        if (!com.byazt.omf.x.m().lr()) {
            return null;
        }
        Field[] declaredFields = com.byazt.nbs.tt.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mTotalWaterFallCount");
            arrayList.remove("mWaterFallConfigList");
            arrayList.remove("mWaterFallConfMap");
            arrayList.remove("mTotalLoadLevelCount");
            arrayList.remove("mCurrentCommonAdMaxCpm");
            arrayList.remove("mLoadSortLevelList");
            arrayList.remove("hasServerBidding");
            arrayList.remove("hasClientOrMultiLevel");
            arrayList.remove("mRitInfoJson");
        }
        return arrayList;
    }

    public static List<String> tt() {
        ArrayList arrayList = null;
        if (!com.byazt.omf.x.m().lr()) {
            return null;
        }
        Field[] declaredFields = com.byazt.nbs.da.class.getDeclaredFields();
        if (declaredFields != null && declaredFields.length != 0) {
            arrayList = new ArrayList();
            for (Field field : declaredFields) {
                if (!TextUtils.isEmpty(field.getName()) && !Modifier.isFinal(field.getModifiers())) {
                    arrayList.add(field.getName());
                }
            }
            arrayList.remove("mServerBiddingWinner");
        }
        return arrayList;
    }

    public static void tt(List<String> list, String str) {
    }

    public static void c(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return;
        }
        list.remove(str);
    }
}
