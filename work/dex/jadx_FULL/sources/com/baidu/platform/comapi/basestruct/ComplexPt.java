package com.baidu.platform.comapi.basestruct;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ComplexPt {
    public static final int TEN_THOUSAND = 100000;
    public static final int TYPE_LINE = 2;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_POINT = 1;
    public static final int TYPE_POLYGON = 3;
    public int eType;
    public ArrayList<ArrayList<Point>> mGeoPt;
    public Point mLL;
    public ArrayList<Point> mOriginPoints;
    public Point mRu;

    public static ComplexPt createComplexPt(List<? extends Number> list) {
        if (list == null || list.size() < 2) {
            return null;
        }
        ComplexPt complexPt = new ComplexPt();
        int size = list.size();
        if (size >= 5) {
            complexPt.mLL = new Point(list.get(0).doubleValue(), list.get(1).doubleValue());
            complexPt.mRu = new Point(list.get(2).doubleValue(), list.get(3).doubleValue());
            complexPt.eType = (int) list.get(4).doubleValue();
            complexPt.mGeoPt = new ArrayList<>();
            int i = 7;
            if (size >= 7) {
                ArrayList<Point> arrayList = new ArrayList<>();
                Point point = new Point(list.get(5).doubleValue(), list.get(6).doubleValue());
                arrayList.add(point);
                while (true) {
                    int i2 = i + 1;
                    if (i2 >= size) {
                        break;
                    }
                    Point point2 = new Point(point.getDoubleX() + list.get(i).doubleValue(), point.getDoubleY() + list.get(i2).doubleValue());
                    arrayList.add(point2);
                    i += 2;
                    point = point2;
                }
                complexPt.mGeoPt.add(arrayList);
            }
        } else if (size >= 2) {
            Point point3 = new Point(list.get(0).doubleValue(), list.get(1).doubleValue());
            ArrayList<Point> arrayList2 = new ArrayList<>();
            arrayList2.add(point3);
            complexPt.mLL = new Point(point3);
            complexPt.mRu = new Point(point3);
            complexPt.eType = 1;
            ArrayList<ArrayList<Point>> arrayList3 = new ArrayList<>();
            complexPt.mGeoPt = arrayList3;
            arrayList3.add(arrayList2);
        }
        return complexPt;
    }

    public String toString() {
        return "ComplexPt [eType=" + this.eType + ", mLL=" + this.mLL + ", mRu=" + this.mRu + ", mGeoPt=" + this.mGeoPt + "]";
    }
}
