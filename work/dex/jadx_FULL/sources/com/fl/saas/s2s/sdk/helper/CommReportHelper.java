package com.fl.saas.s2s.sdk.helper;

import android.text.TextUtils;
import android.util.Pair;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.fl.saas.common.rest.AdHttpUtils;
import com.fl.saas.config.http.HttpCallbackStringListener;
import com.fl.saas.config.utils.AesUtils;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CommReportHelper {
    private static CommReportHelper sInstance;

    /* JADX INFO: renamed from: com.fl.saas.s2s.sdk.helper.CommReportHelper$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType;

        static {
            int[] iArr = new int[AdInfoPoJo.ClickType.values().length];
            $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType = iArr;
            try {
                iArr[AdInfoPoJo.ClickType.SHAKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[AdInfoPoJo.ClickType.SLIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[AdInfoPoJo.ClickType.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void doReport(List<String> list, AdInfoPoJo adInfoPoJo) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            AdHttpUtils.getInstance().doGet(gdtReplac(list.get(i), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.1
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                }
            });
        }
    }

    public static CommReportHelper getInstance() {
        if (sInstance == null) {
            synchronized (CommReportHelper.class) {
                sInstance = new CommReportHelper();
            }
        }
        return sInstance;
    }

    private static String replaceMacro(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(str2, str3);
    }

    private static List<String> replaceMacroForList(List<String> list, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(replaceMacro(it.next(), str, str2));
        }
        return arrayList;
    }

    @SafeVarargs
    private static String replaceMacros(String str, Pair<String, String>... pairArr) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (Pair<String, String> pair : pairArr) {
            str = replaceMacro(str, (String) pair.first, (String) pair.second);
        }
        return str;
    }

    @SafeVarargs
    private static List<String> replaceMacrosForList(List<String> list, Pair<String, String>... pairArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(replaceMacros(it.next(), pairArr));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x02bd A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0363 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x036f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:59:0x0371  */
    /* JADX WARN: Code duplicated, block: B:61:0x0374  */
    /* JADX WARN: Code duplicated, block: B:62:0x0375 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0378 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x037b A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x03d2 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x03e1 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x03f0 A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x03ff A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x040e A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x041d A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x042c A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x043b A[Catch: Exception -> 0x04aa, TryCatch #0 {Exception -> 0x04aa, blocks: (B:45:0x0124, B:46:0x0128, B:51:0x013c, B:53:0x02bd, B:54:0x02d4, B:56:0x0363, B:65:0x037d, B:62:0x0375, B:63:0x0378, B:64:0x037b, B:66:0x0383, B:68:0x03d2, B:69:0x03db, B:71:0x03e1, B:72:0x03ea, B:74:0x03f0, B:75:0x03f9, B:77:0x03ff, B:78:0x0408, B:80:0x040e, B:81:0x0417, B:83:0x041d, B:84:0x0426, B:86:0x042c, B:87:0x0435, B:89:0x043b, B:90:0x0444, B:50:0x0137), top: B:99:0x00f5 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:53:0x02bd, please report this as an issue */
    public String gdtReplac(String str, AdInfoPoJo adInfoPoJo) {
        String str2;
        String strReplaceAll;
        String strReplaceAll2;
        String strReplaceAll3;
        String strReplaceAll4;
        AdInfoPoJo.AdInteractiveMode adInteractiveMode;
        String strValueOf;
        String strValueOf2;
        String strValueOf3;
        String strValueOf4;
        String strValueOf5;
        String strValueOf6;
        String strValueOf7;
        String strValueOf8;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String strReplaceAll5 = "5";
        String str3 = "";
        try {
            if (adInfoPoJo.clickType == AdInfoPoJo.ClickType.SHAKE) {
                adInfoPoJo.down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.abs_down_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.abs_down_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.abs_up_x = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                adInfoPoJo.abs_up_y = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
            }
            String strValueOf9 = String.valueOf(adInfoPoJo.down_x);
            String strValueOf10 = String.valueOf(adInfoPoJo.down_y);
            String strValueOf11 = String.valueOf(adInfoPoJo.up_x);
            String strValueOf12 = String.valueOf(adInfoPoJo.up_y);
            if (adInfoPoJo.ac_type.equals("5") || adInfoPoJo.ac_type.equals("6")) {
                int i10 = adInfoPoJo.down_x;
                if (i10 != -999) {
                    strValueOf9 = String.valueOf(DeviceUtil.px2dip(i10));
                }
                int i11 = adInfoPoJo.down_y;
                if (i11 != -999) {
                    strValueOf10 = String.valueOf(DeviceUtil.px2dip(i11));
                }
                int i12 = adInfoPoJo.up_x;
                if (i12 != -999) {
                    strValueOf11 = String.valueOf(DeviceUtil.px2dip(i12));
                }
                int i13 = adInfoPoJo.up_y;
                if (i13 != -999) {
                    strValueOf12 = String.valueOf(DeviceUtil.px2dip(i13));
                }
            }
            int i14 = adInfoPoJo.realWidth;
            int i15 = adInfoPoJo.realHeight;
            int iPx2dip = DeviceUtil.px2dip(i14);
            int iPx2dip2 = DeviceUtil.px2dip(i15);
            int i16 = adInfoPoJo.width;
            int i17 = adInfoPoJo.height;
            Long lValueOf = Long.valueOf(System.currentTimeMillis());
            str2 = str;
            try {
                String strReplaceAll6 = str2.replaceAll("__REQ_WIDTH__", String.valueOf(i16));
                try {
                    String strReplaceAll7 = strReplaceAll6.replaceAll("__REQ_HEIGHT__", String.valueOf(i17)).replaceAll("__WIDTH__", String.valueOf(i14)).replaceAll("__HEIGHT__", String.valueOf(i15)).replaceAll("__DP_WIDTH__", String.valueOf(iPx2dip)).replaceAll("__DP_HEIGHT__", String.valueOf(iPx2dip2)).replaceAll("__LG_WIDTH__", String.valueOf(iPx2dip)).replaceAll("__LG_HEIGHT__", String.valueOf(iPx2dip2));
                    try {
                        if (adInfoPoJo.hotspot_type == 2 && (adInfoPoJo.ac_type.equals("5") || adInfoPoJo.ac_type.equals("6") || adInfoPoJo.adv_id == 991)) {
                            if (adInfoPoJo.down_x == -999 || adInfoPoJo.down_y == -999 || adInfoPoJo.up_x == -999 || adInfoPoJo.up_y == -999) {
                                strReplaceAll2 = strReplaceAll7;
                            } else {
                                strReplaceAll = strReplaceAll7.replaceAll("__DOWN_X__", strValueOf9).replaceAll("__DOWN_Y__", strValueOf10);
                            }
                            String strReplaceAll8 = strReplaceAll2.replaceAll("__ABS_DOWN_X__", adInfoPoJo.abs_down_x + "").replaceAll("__ABS_DOWN_Y__", adInfoPoJo.abs_down_y + "").replaceAll("__ABS_UP_X__", adInfoPoJo.abs_up_x + "").replaceAll("__ABS_UP_Y__", adInfoPoJo.abs_up_y + "").replaceAll("__TS__", String.valueOf(lValueOf)).replaceAll("__SEC__", String.valueOf(lValueOf.longValue() / 1000)).replaceAll("__CLICK_ID__", adInfoPoJo.clickId).replaceAll("__VIDEO_TIME__", adInfoPoJo.VIDEO_TIME + "").replaceAll("__DOWN_TIME__", adInfoPoJo.DOWN_TIME + "").replaceAll("__UP_TIME__", adInfoPoJo.UP_TIME + "").replaceAll("__READY_TIME__", adInfoPoJo.READY_TIME + "");
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            strReplaceAll3 = strReplaceAll8.replaceAll("__RESPONSE_TIME__", jCurrentTimeMillis + "").replaceAll("__EVENT_MSEC__", jCurrentTimeMillis + "").replaceAll("__EVENT_SEC__", (jCurrentTimeMillis / 1000) + "").replaceAll("__PROGRESS__", adInfoPoJo.PROGRESS + "").replaceAll("__PROGRESS_SEC__", adInfoPoJo.PROGRESS_SEC + "").replaceAll("__PROGRESS_PART_TIME__", adInfoPoJo.PROGRESS_PART_TIME + "").replaceAll("__DP_RESULT__", adInfoPoJo.dp_result + "");
                            if (adInfoPoJo.dp_result == 1) {
                                strReplaceAll3 = strReplaceAll3.replaceAll("__DP_REASON__", adInfoPoJo.dp_reason + "");
                            }
                            strReplaceAll4 = strReplaceAll3.replaceAll("__PRICE__", AesUtils.encrypt(adInfoPoJo.price + "")).replaceAll("__SECOND_PRICE__", AesUtils.encrypt(adInfoPoJo.second_price + "")).replaceAll("__X_MAX_ACC__", String.valueOf(adInfoPoJo.shake_x)).replaceAll("__Y_MAX_ACC__", String.valueOf(adInfoPoJo.shake_y)).replaceAll("__Z_MAX_ACC__", String.valueOf(adInfoPoJo.shake_z)).replaceAll("__COST_TIME__", String.valueOf(DeviceUtil.getBootTime() - adInfoPoJo.reqTime)).replaceAll("__CB__", String.valueOf(adInfoPoJo.type)).replaceAll("__CBR__", String.valueOf(adInfoPoJo.cbr)).replaceAll("__TRACK_ID__", adInfoPoJo.trackId);
                            adInteractiveMode = adInfoPoJo.adInteractiveMode;
                            if (adInteractiveMode != null) {
                                i9 = AnonymousClass6.$SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[adInfoPoJo.clickType.ordinal()];
                                if (i9 != 1) {
                                    str3 = adInteractiveMode.shake;
                                } else if (i9 != 2) {
                                    str3 = adInteractiveMode.slideclick;
                                } else if (i9 != 3) {
                                    str3 = adInteractiveMode.normalclick;
                                }
                                strReplaceAll4 = strReplaceAll4.replaceAll("__SLD__", str3);
                            }
                            String strReplaceAll9 = strReplaceAll4.replaceAll("__SHOW_TIME__", String.valueOf(jCurrentTimeMillis - adInfoPoJo.showTime)).replaceAll("__MAX_SHOW_RATIO__", String.valueOf(adInfoPoJo.maxShowRatio));
                            strValueOf = String.valueOf(adInfoPoJo.down_x);
                            strValueOf2 = String.valueOf(adInfoPoJo.down_y);
                            strValueOf3 = String.valueOf(adInfoPoJo.up_x);
                            strValueOf4 = String.valueOf(adInfoPoJo.up_y);
                            strValueOf5 = String.valueOf(adInfoPoJo.abs_down_x);
                            strValueOf6 = String.valueOf(adInfoPoJo.abs_down_y);
                            strValueOf7 = String.valueOf(adInfoPoJo.abs_up_x);
                            strValueOf8 = String.valueOf(adInfoPoJo.abs_up_y);
                            i = adInfoPoJo.down_x;
                            if (i != -999) {
                                strValueOf = String.valueOf(DeviceUtil.px2dip(i));
                            }
                            i2 = adInfoPoJo.down_y;
                            if (i2 != -999) {
                                strValueOf2 = String.valueOf(DeviceUtil.px2dip(i2));
                            }
                            i3 = adInfoPoJo.up_x;
                            if (i3 != -999) {
                                strValueOf3 = String.valueOf(DeviceUtil.px2dip(i3));
                            }
                            i4 = adInfoPoJo.up_y;
                            if (i4 != -999) {
                                strValueOf4 = String.valueOf(DeviceUtil.px2dip(i4));
                            }
                            i5 = adInfoPoJo.abs_down_x;
                            if (i5 != -999) {
                                strValueOf5 = String.valueOf(DeviceUtil.px2dip(i5));
                            }
                            i6 = adInfoPoJo.abs_down_y;
                            if (i6 != -999) {
                                strValueOf6 = String.valueOf(DeviceUtil.px2dip(i6));
                            }
                            i7 = adInfoPoJo.abs_up_x;
                            if (i7 != -999) {
                                strValueOf7 = String.valueOf(DeviceUtil.px2dip(i7));
                            }
                            i8 = adInfoPoJo.abs_up_y;
                            if (i8 != -999) {
                                strValueOf8 = String.valueOf(DeviceUtil.px2dip(i8));
                            }
                            strReplaceAll5 = strReplaceAll9.replaceAll("__LG_DOWN_X__", strValueOf).replaceAll("__LG_DOWN_Y__", strValueOf2).replaceAll("__LG_UP_X__", strValueOf3).replaceAll("__LG_UP_Y__", strValueOf4).replaceAll("__LG_ABS_DOWN_X__", strValueOf5).replaceAll("__LG_ABS_DOWN_Y__", strValueOf6).replaceAll("__LG_ABS_UP_X__", strValueOf7).replaceAll("__LG_ABS_UP_Y__", strValueOf8).replaceAll("__CLICKAREA__", adInfoPoJo.clickArea).replaceAll("__DPLINK__", adInfoPoJo.clickIsDp).replaceAll("__PUBLIC_AD_POOL__", adInfoPoJo.adPool).replaceAll("__GLOBAL_PLACE_ID__", adInfoPoJo.global_place_id).replaceAll("__GLOBAL_GROUP_ID__", adInfoPoJo.global_group_id);
                            return strReplaceAll5.replaceAll("__GLOBAL_TEST_ID__", adInfoPoJo.global_test_id);
                        }
                        strReplaceAll = strReplaceAll7.replaceAll("__DOWN_X__", strValueOf9).replaceAll("__DOWN_Y__", strValueOf10);
                        strReplaceAll2 = strReplaceAll.replaceAll("__UP_X__", strValueOf11).replaceAll("__UP_Y__", strValueOf12);
                        String strReplaceAll10 = strReplaceAll2.replaceAll("__ABS_DOWN_X__", adInfoPoJo.abs_down_x + "").replaceAll("__ABS_DOWN_Y__", adInfoPoJo.abs_down_y + "").replaceAll("__ABS_UP_X__", adInfoPoJo.abs_up_x + "").replaceAll("__ABS_UP_Y__", adInfoPoJo.abs_up_y + "").replaceAll("__TS__", String.valueOf(lValueOf)).replaceAll("__SEC__", String.valueOf(lValueOf.longValue() / 1000)).replaceAll("__CLICK_ID__", adInfoPoJo.clickId).replaceAll("__VIDEO_TIME__", adInfoPoJo.VIDEO_TIME + "").replaceAll("__DOWN_TIME__", adInfoPoJo.DOWN_TIME + "").replaceAll("__UP_TIME__", adInfoPoJo.UP_TIME + "").replaceAll("__READY_TIME__", adInfoPoJo.READY_TIME + "");
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        strReplaceAll3 = strReplaceAll10.replaceAll("__RESPONSE_TIME__", jCurrentTimeMillis2 + "").replaceAll("__EVENT_MSEC__", jCurrentTimeMillis2 + "").replaceAll("__EVENT_SEC__", (jCurrentTimeMillis2 / 1000) + "").replaceAll("__PROGRESS__", adInfoPoJo.PROGRESS + "").replaceAll("__PROGRESS_SEC__", adInfoPoJo.PROGRESS_SEC + "").replaceAll("__PROGRESS_PART_TIME__", adInfoPoJo.PROGRESS_PART_TIME + "").replaceAll("__DP_RESULT__", adInfoPoJo.dp_result + "");
                        if (adInfoPoJo.dp_result == 1) {
                            strReplaceAll3 = strReplaceAll3.replaceAll("__DP_REASON__", adInfoPoJo.dp_reason + "");
                        }
                        strReplaceAll4 = strReplaceAll3.replaceAll("__PRICE__", AesUtils.encrypt(adInfoPoJo.price + "")).replaceAll("__SECOND_PRICE__", AesUtils.encrypt(adInfoPoJo.second_price + "")).replaceAll("__X_MAX_ACC__", String.valueOf(adInfoPoJo.shake_x)).replaceAll("__Y_MAX_ACC__", String.valueOf(adInfoPoJo.shake_y)).replaceAll("__Z_MAX_ACC__", String.valueOf(adInfoPoJo.shake_z)).replaceAll("__COST_TIME__", String.valueOf(DeviceUtil.getBootTime() - adInfoPoJo.reqTime)).replaceAll("__CB__", String.valueOf(adInfoPoJo.type)).replaceAll("__CBR__", String.valueOf(adInfoPoJo.cbr)).replaceAll("__TRACK_ID__", adInfoPoJo.trackId);
                        adInteractiveMode = adInfoPoJo.adInteractiveMode;
                        if (adInteractiveMode != null) {
                            i9 = AnonymousClass6.$SwitchMap$com$fl$saas$s2s$sdk$helper$AdInfoPoJo$ClickType[adInfoPoJo.clickType.ordinal()];
                            if (i9 != 1) {
                                str3 = adInteractiveMode.shake;
                            } else if (i9 != 2) {
                                str3 = adInteractiveMode.slideclick;
                            } else if (i9 != 3) {
                                str3 = adInteractiveMode.normalclick;
                            }
                            strReplaceAll4 = strReplaceAll4.replaceAll("__SLD__", str3);
                        }
                        String strReplaceAll11 = strReplaceAll4.replaceAll("__SHOW_TIME__", String.valueOf(jCurrentTimeMillis2 - adInfoPoJo.showTime)).replaceAll("__MAX_SHOW_RATIO__", String.valueOf(adInfoPoJo.maxShowRatio));
                        strValueOf = String.valueOf(adInfoPoJo.down_x);
                        strValueOf2 = String.valueOf(adInfoPoJo.down_y);
                        strValueOf3 = String.valueOf(adInfoPoJo.up_x);
                        strValueOf4 = String.valueOf(adInfoPoJo.up_y);
                        strValueOf5 = String.valueOf(adInfoPoJo.abs_down_x);
                        strValueOf6 = String.valueOf(adInfoPoJo.abs_down_y);
                        strValueOf7 = String.valueOf(adInfoPoJo.abs_up_x);
                        strValueOf8 = String.valueOf(adInfoPoJo.abs_up_y);
                        i = adInfoPoJo.down_x;
                        if (i != -999) {
                            strValueOf = String.valueOf(DeviceUtil.px2dip(i));
                        }
                        i2 = adInfoPoJo.down_y;
                        if (i2 != -999) {
                            strValueOf2 = String.valueOf(DeviceUtil.px2dip(i2));
                        }
                        i3 = adInfoPoJo.up_x;
                        if (i3 != -999) {
                            strValueOf3 = String.valueOf(DeviceUtil.px2dip(i3));
                        }
                        i4 = adInfoPoJo.up_y;
                        if (i4 != -999) {
                            strValueOf4 = String.valueOf(DeviceUtil.px2dip(i4));
                        }
                        i5 = adInfoPoJo.abs_down_x;
                        if (i5 != -999) {
                            strValueOf5 = String.valueOf(DeviceUtil.px2dip(i5));
                        }
                        i6 = adInfoPoJo.abs_down_y;
                        if (i6 != -999) {
                            strValueOf6 = String.valueOf(DeviceUtil.px2dip(i6));
                        }
                        i7 = adInfoPoJo.abs_up_x;
                        if (i7 != -999) {
                            strValueOf7 = String.valueOf(DeviceUtil.px2dip(i7));
                        }
                        i8 = adInfoPoJo.abs_up_y;
                        if (i8 != -999) {
                            strValueOf8 = String.valueOf(DeviceUtil.px2dip(i8));
                        }
                        strReplaceAll5 = strReplaceAll11.replaceAll("__LG_DOWN_X__", strValueOf).replaceAll("__LG_DOWN_Y__", strValueOf2).replaceAll("__LG_UP_X__", strValueOf3).replaceAll("__LG_UP_Y__", strValueOf4).replaceAll("__LG_ABS_DOWN_X__", strValueOf5).replaceAll("__LG_ABS_DOWN_Y__", strValueOf6).replaceAll("__LG_ABS_UP_X__", strValueOf7).replaceAll("__LG_ABS_UP_Y__", strValueOf8).replaceAll("__CLICKAREA__", adInfoPoJo.clickArea).replaceAll("__DPLINK__", adInfoPoJo.clickIsDp).replaceAll("__PUBLIC_AD_POOL__", adInfoPoJo.adPool).replaceAll("__GLOBAL_PLACE_ID__", adInfoPoJo.global_place_id).replaceAll("__GLOBAL_GROUP_ID__", adInfoPoJo.global_group_id);
                        return strReplaceAll5.replaceAll("__GLOBAL_TEST_ID__", adInfoPoJo.global_test_id);
                    } catch (Exception unused) {
                        return strReplaceAll5;
                    }
                } catch (Exception unused2) {
                    strReplaceAll5 = strReplaceAll6;
                }
            } catch (Exception unused3) {
                strReplaceAll5 = str2;
                return strReplaceAll5;
            }
        } catch (Exception unused4) {
            str2 = str;
        }
    }

    public void reportApiBidFail(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(adInfoPoJo.notice_failed_urls, adInfoPoJo);
    }

    public void reportApiBidSuccess(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(adInfoPoJo.notice_success_urls, adInfoPoJo);
    }

    public void reportClick(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null || "5".equals(adInfoPoJo.ac_type) || "6".equals(adInfoPoJo.ac_type)) {
            return;
        }
        doReport(replaceMacrosForList(adInfoPoJo.click_notice_urls, Pair.create("__X_MAX_ACC__", String.valueOf(adInfoPoJo.shake_x)), Pair.create("__Y_MAX_ACC__", String.valueOf(adInfoPoJo.shake_y)), Pair.create("__Z_MAX_ACC__", String.valueOf(adInfoPoJo.shake_z))), adInfoPoJo);
    }

    public void reportDeepLink(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.deeplink_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.2
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkAttempt(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.dp_attempt_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.4
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink attempt requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkFail(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.dpfail_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.5
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink fail requset onSuccess");
                }
            });
        }
    }

    public void reportDeepLinkInstalled(AdInfoPoJo adInfoPoJo) {
        if (adInfoPoJo == null) {
            return;
        }
        Iterator<String> it = adInfoPoJo.app_installed_notice_urls.iterator();
        while (it.hasNext()) {
            AdHttpUtils.getInstance().doGet(gdtReplac(it.next(), adInfoPoJo), new HttpCallbackStringListener() { // from class: com.fl.saas.s2s.sdk.helper.CommReportHelper.3
                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onError(Exception exc) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset onError:" + exc.getMessage());
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onJump(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset 302");
                }

                @Override // com.fl.saas.config.http.HttpCallbackStringListener
                public void onSuccess(String str) {
                    LogcatUtil.d("YdSDK-S2S", "deeplink installed requset onSuccess");
                }
            });
        }
    }

    public void reportDisplay(AdInfoPoJo adInfoPoJo, boolean z) {
        if (adInfoPoJo == null) {
            return;
        }
        doReport(replaceMacroForList(adInfoPoJo.impress_notice_urls, "__IS_CACHED__", String.valueOf(z ? 1 : 0)), adInfoPoJo);
    }

    public void reportVideoClose(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.closes) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.closes, adInfoPoJo);
    }

    public void reportVideoContinue(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_continue_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_continue_notice_urls, adInfoPoJo);
    }

    public void reportVideoEnd(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.playing_end_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.playing_end_notice_urls, adInfoPoJo);
    }

    public void reportVideoFirst(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_first_quartile_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_first_quartile_notice_urls, adInfoPoJo);
    }

    public void reportVideoInfo(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_view_urls) == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = adInfoPoJo.video_view_urls.iterator();
        while (it.hasNext()) {
            arrayList.add(videoInfoReplac(it.next(), adInfoPoJo));
        }
        doReport(arrayList, adInfoPoJo);
    }

    public void reportVideoMute(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_mute_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_mute_notice_urls, adInfoPoJo);
    }

    public void reportVideoPause(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_pause_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_pause_notice_urls, adInfoPoJo);
    }

    public void reportVideoSkip(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_skip_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_skip_notice_urls, adInfoPoJo);
    }

    public void reportVideoStart(AdInfoPoJo adInfoPoJo, int i) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_start_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_start_notice_urls, adInfoPoJo);
    }

    public void reportVideoThird(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_third_quartile_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_third_quartile_notice_urls, adInfoPoJo);
    }

    public void reportVideomMidpoint(AdInfoPoJo adInfoPoJo) {
        List<String> list;
        if (adInfoPoJo == null || (list = adInfoPoJo.video_midpoint_notice_urls) == null || list.isEmpty()) {
            return;
        }
        doReport(adInfoPoJo.video_midpoint_notice_urls, adInfoPoJo);
    }

    public String videoInfoReplac(String str, AdInfoPoJo adInfoPoJo) {
        try {
            return str.replaceAll("__BEGIN_TIME__", adInfoPoJo.BEGIN_TIME + "").replaceAll("__END_TIME__", adInfoPoJo.END_TIME + "").replaceAll("__PLAY_FIRST_FRAME__", adInfoPoJo.PLAY_FIRST_FRAME + "").replaceAll("__PLAY_LAST_FRAME__", adInfoPoJo.PLAY_LAST_FRAME + "").replaceAll("__SCENE__", adInfoPoJo.SCENE + "").replaceAll("__TYPE__", adInfoPoJo.TYPE + "").replaceAll("__BEHAVIOR__", adInfoPoJo.BEHAVIOR + "").replaceAll("__STATUS__", adInfoPoJo.STATUS + "");
        } catch (Exception unused) {
            return str;
        }
    }
}
