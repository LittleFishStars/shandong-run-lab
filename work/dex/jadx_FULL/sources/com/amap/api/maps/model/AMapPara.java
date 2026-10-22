package com.amap.api.maps.model;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);

        private int type;

        LineCapType(int i) {
            this.type = i;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineCapType valueOf(int i) {
            LineCapType[] lineCapTypeArrValues = values();
            return lineCapTypeArrValues[Math.max(0, Math.min(i, lineCapTypeArrValues.length))];
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);

        private int type;

        LineJoinType(int i) {
            this.type = i;
        }

        public final int getTypeValue() {
            return this.type;
        }

        public static LineJoinType valueOf(int i) {
            LineJoinType[] lineJoinTypeArrValues = values();
            return lineJoinTypeArrValues[Math.max(0, Math.min(i, lineJoinTypeArrValues.length))];
        }
    }
}
