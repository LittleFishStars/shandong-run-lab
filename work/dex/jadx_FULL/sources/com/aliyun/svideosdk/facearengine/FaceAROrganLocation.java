package com.aliyun.svideosdk.facearengine;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class FaceAROrganLocation {
    public ArrayList<FaceARFaceResult> mFacePonits;

    public int getFaceCount() {
        ArrayList<FaceARFaceResult> arrayList = this.mFacePonits;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
