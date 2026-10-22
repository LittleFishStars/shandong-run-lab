package com.aliyun.svideosdk.common.struct.effect;

import android.graphics.PointF;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class Frame<PROPERTY> {
    float time;
    PROPERTY value;

    public static class FramePoint extends PointF {
        public FramePoint(float f, float f2) {
            super(f, f2);
        }

        @Override // android.graphics.PointF
        public String toString() {
            return ((PointF) this).x + "," + ((PointF) this).y;
        }
    }

    public Frame(float f, PROPERTY property) {
        this.time = f;
        this.value = property;
    }
}
