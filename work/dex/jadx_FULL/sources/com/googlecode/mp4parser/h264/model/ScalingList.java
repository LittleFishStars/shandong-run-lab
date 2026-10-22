package com.googlecode.mp4parser.h264.model;

import com.googlecode.mp4parser.h264.read.CAVLCReader;
import com.googlecode.mp4parser.h264.write.CAVLCWriter;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public static ScalingList read(CAVLCReader cAVLCReader, int i) throws IOException {
        ScalingList scalingList = new ScalingList();
        scalingList.scalingList = new int[i];
        int se = 8;
        int i2 = 8;
        int i3 = 0;
        while (i3 < i) {
            if (se != 0) {
                se = ((cAVLCReader.readSE("deltaScale") + i2) + 256) % 256;
                scalingList.useDefaultScalingMatrixFlag = i3 == 0 && se == 0;
            }
            int[] iArr = scalingList.scalingList;
            if (se != 0) {
                i2 = se;
            }
            iArr[i3] = i2;
            i3++;
        }
        return scalingList;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.scalingList + ", useDefaultScalingMatrixFlag=" + this.useDefaultScalingMatrixFlag + '}';
    }

    public void write(CAVLCWriter cAVLCWriter) throws IOException {
        int i = 0;
        if (this.useDefaultScalingMatrixFlag) {
            cAVLCWriter.writeSE(0, "SPS: ");
            return;
        }
        int i2 = 8;
        while (true) {
            int[] iArr = this.scalingList;
            if (i >= iArr.length) {
                return;
            }
            cAVLCWriter.writeSE((iArr[i] - i2) - 256, "SPS: ");
            i2 = this.scalingList[i];
            i++;
        }
    }
}
