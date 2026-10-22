package com.insightface.sdk.inspireface.base;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class FaceFeatureIdentity {
    public FaceFeature feature;
    public long id = -1;
    public float searchConfidence = -1.0f;

    public static FaceFeatureIdentity create(long j, FaceFeature faceFeature) {
        FaceFeatureIdentity faceFeatureIdentity = new FaceFeatureIdentity();
        faceFeatureIdentity.id = j;
        faceFeatureIdentity.feature = faceFeature;
        return faceFeatureIdentity;
    }
}
