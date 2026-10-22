package com.zj.adlib;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class vsa {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[][] f20325a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f45450a = {"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[][] f20326a = {new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", ze1.s, "province", "city", "district", "town", "village"}};
    public static final String[] b = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = f45450a;
            if (i >= strArr.length) {
                i = -1;
                break;
            }
            if (strArr[i].equals(str)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return f20326a[i];
        }
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            String[] strArr = f45450a;
            if (i >= strArr.length) {
                i = -1;
                break;
            }
            if (strArr[i].equals(str)) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return b[i];
        }
        return null;
    }
}
