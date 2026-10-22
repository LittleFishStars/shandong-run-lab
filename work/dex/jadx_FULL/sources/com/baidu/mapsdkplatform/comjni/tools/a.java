package com.baidu.mapsdkplatform.comjni.tools;

import android.os.Bundle;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comjni.tools.ParcelItem;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a {
    public static ComplexPt a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("strkey", str);
        JNITools.TransGeoStr2ComplexPt(bundle);
        ComplexPt complexPt = new ComplexPt();
        Bundle bundle2 = bundle.getBundle("map_bound");
        if (bundle2 != null) {
            Bundle bundle3 = bundle2.getBundle(AliyunLogKey.KEY_LOG_LEVEL);
            if (bundle3 != null) {
                complexPt.mLL = new Point((int) bundle3.getDouble("ptx"), (int) bundle3.getDouble("pty"));
            }
            Bundle bundle4 = bundle2.getBundle("ru");
            if (bundle4 != null) {
                complexPt.mRu = new Point((int) bundle4.getDouble("ptx"), (int) bundle4.getDouble("pty"));
            }
        }
        for (ParcelItem parcelItem : (ParcelItem[]) bundle.getParcelableArray("poly_line")) {
            if (complexPt.mGeoPt == null) {
                complexPt.mGeoPt = new ArrayList<>();
            }
            Bundle bundle5 = parcelItem.getBundle();
            if (bundle5 != null) {
                ParcelItem[] parcelItemArr = (ParcelItem[]) bundle5.getParcelableArray("point_array");
                ArrayList<Point> arrayList = new ArrayList<>();
                for (ParcelItem parcelItem2 : parcelItemArr) {
                    Bundle bundle6 = parcelItem2.getBundle();
                    if (bundle6 != null) {
                        arrayList.add(new Point((int) bundle6.getDouble("ptx"), (int) bundle6.getDouble("pty")));
                    }
                }
                arrayList.trimToSize();
                complexPt.mGeoPt.add(arrayList);
            }
        }
        complexPt.mGeoPt.trimToSize();
        complexPt.eType = (int) bundle.getDouble("type");
        return complexPt;
    }

    public static String b() {
        return JNITools.GetToken();
    }

    public static double a(Point point, Point point2) {
        Bundle bundle = new Bundle();
        bundle.putDouble("x1", point.x);
        bundle.putDouble("y1", point.y);
        bundle.putDouble("x2", point2.x);
        bundle.putDouble("y2", point2.y);
        JNITools.GetDistanceByMC(bundle);
        return bundle.getDouble(SchoolActivitySuccessActivity.x);
    }

    public static void a(boolean z, int i) {
        JNITools.openLogEnable(z, i);
    }

    public static void a() {
        JNITools.initClass(new Bundle(), 0);
    }
}
