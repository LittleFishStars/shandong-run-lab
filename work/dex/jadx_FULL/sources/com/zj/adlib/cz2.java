package com.zj.adlib;

import com.aliyun.vod.log.struct.AliyunLogKey;
import com.google.zxing.client.result.ResultParser;
import com.google.zxing.client.result.d;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class cz2 extends ResultParser {
    public static final Pattern d = Pattern.compile(",");

    @Override // com.google.zxing.client.result.ResultParser
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public bz2 e(ug7 ug7Var) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String str;
        String str2;
        String str3;
        String massagedText = ResultParser.getMassagedText(ug7Var);
        if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
            if (d.k(massagedText)) {
                return new bz2(massagedText);
            }
            return null;
        }
        String strSubstring = massagedText.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        try {
            String strH = ResultParser.h(strSubstring);
            String[] strArrSplit = !strH.isEmpty() ? d.split(strH) : null;
            Map<String, String> mapF = ResultParser.f(massagedText);
            if (mapF != null) {
                if (strArrSplit == null && (str3 = mapF.get("to")) != null) {
                    strArrSplit = d.split(str3);
                }
                String str4 = mapF.get(AliyunLogKey.KEY_VIDEO_CODEC);
                String[] strArrSplit2 = str4 != null ? d.split(str4) : null;
                String str5 = mapF.get("bcc");
                String[] strArrSplit3 = str5 != null ? d.split(str5) : null;
                String str6 = mapF.get("subject");
                str2 = mapF.get("body");
                strArr = strArrSplit;
                strArr3 = strArrSplit3;
                strArr2 = strArrSplit2;
                str = str6;
            } else {
                strArr = strArrSplit;
                strArr2 = null;
                strArr3 = null;
                str = null;
                str2 = null;
            }
            return new bz2(strArr, strArr2, strArr3, str, str2);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
