package com.insightface.sdk.inspireface;

import android.content.Context;
import android.graphics.Bitmap;
import com.insightface.sdk.inspireface.base.CustomParameter;
import com.insightface.sdk.inspireface.base.FaceAttributeResult;
import com.insightface.sdk.inspireface.base.FaceBasicToken;
import com.insightface.sdk.inspireface.base.FaceEmotionResult;
import com.insightface.sdk.inspireface.base.FaceFeature;
import com.insightface.sdk.inspireface.base.FaceFeatureIdentity;
import com.insightface.sdk.inspireface.base.FaceInteractionState;
import com.insightface.sdk.inspireface.base.FaceInteractionsActions;
import com.insightface.sdk.inspireface.base.FaceMaskConfidence;
import com.insightface.sdk.inspireface.base.FaceQualityConfidence;
import com.insightface.sdk.inspireface.base.FeatureHubConfiguration;
import com.insightface.sdk.inspireface.base.ImageStream;
import com.insightface.sdk.inspireface.base.InspireFaceVersion;
import com.insightface.sdk.inspireface.base.MultipleFaceData;
import com.insightface.sdk.inspireface.base.Point2f;
import com.insightface.sdk.inspireface.base.RGBLivenessConfidence;
import com.insightface.sdk.inspireface.base.SearchTopKResults;
import com.insightface.sdk.inspireface.base.Session;
import com.insightface.sdk.inspireface.base.SimilarityConverterConfig;
import com.insightface.sdk.inspireface.base.TypeDefine;
import com.insightface.sdk.inspireface.utils.SDKUtils;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class InspireFace extends TypeDefine {
    static {
        System.loadLibrary("InspireFace");
    }

    public static native float CosineSimilarityConvertToPercentage(float f);

    public static CustomParameter CreateCustomParameter() {
        return new CustomParameter();
    }

    public static FeatureHubConfiguration CreateFeatureHubConfiguration() {
        return new FeatureHubConfiguration();
    }

    public static native ImageStream CreateImageStreamFromBitmap(Bitmap bitmap, int i);

    public static native ImageStream CreateImageStreamFromByteBuffer(byte[] bArr, int i, int i2, int i3, int i4);

    public static native Session CreateSession(CustomParameter customParameter, int i, int i2, int i3, int i4);

    public static native MultipleFaceData ExecuteFaceTrack(Session session, ImageStream imageStream);

    public static native FaceFeature ExtractFaceFeature(Session session, ImageStream imageStream, FaceBasicToken faceBasicToken);

    public static native float FaceComparison(FaceFeature faceFeature, FaceFeature faceFeature2);

    public static native boolean FeatureHubDataDisable();

    public static native boolean FeatureHubDataEnable(FeatureHubConfiguration featureHubConfiguration);

    public static native boolean FeatureHubFaceRemove(long j);

    public static native FaceFeatureIdentity FeatureHubFaceSearch(FaceFeature faceFeature);

    public static native void FeatureHubFaceSearchThresholdSetting(float f);

    public static native SearchTopKResults FeatureHubFaceSearchTopK(FaceFeature faceFeature, int i);

    public static native boolean FeatureHubFaceUpdate(FaceFeatureIdentity faceFeatureIdentity);

    public static native int FeatureHubGetFaceCount();

    public static native FaceFeatureIdentity FeatureHubGetFaceIdentity(long j);

    public static native boolean FeatureHubInsertFeature(FaceFeatureIdentity faceFeatureIdentity);

    public static native SimilarityConverterConfig GetCosineSimilarityConverter();

    public static native Bitmap GetFaceAlignmentImage(Session session, ImageStream imageStream, FaceBasicToken faceBasicToken);

    public static native FaceAttributeResult GetFaceAttributeResult(Session session);

    public static native Point2f[] GetFaceDenseLandmarkFromFaceToken(FaceBasicToken faceBasicToken);

    public static native FaceEmotionResult GetFaceEmotionResult(Session session);

    public static native FaceInteractionsActions GetFaceInteractionActionsResult(Session session);

    public static native FaceInteractionState GetFaceInteractionStateResult(Session session);

    public static native FaceMaskConfidence GetFaceMaskConfidence(Session session);

    public static native FaceQualityConfidence GetFaceQualityConfidence(Session session);

    public static native int GetFeatureLength();

    public static native RGBLivenessConfidence GetRGBLivenessConfidence(Session session);

    public static native float GetRecommendedCosineThreshold();

    public static Boolean GlobalLaunch(Context context, String str) {
        return Boolean.valueOf(GlobalLaunch(new File(copyResourceFileToApplicationDir(context), str).getAbsolutePath()));
    }

    public static native boolean GlobalLaunch(String str);

    public static native boolean GlobalReload(String str);

    public static native boolean GlobalTerminate();

    public static native boolean MultipleFacePipelineProcess(Session session, ImageStream imageStream, MultipleFaceData multipleFaceData, CustomParameter customParameter);

    public static native InspireFaceVersion QueryInspireFaceVersion();

    public static native boolean QueryLaunchStatus();

    public static native void ReleaseImageStream(ImageStream imageStream);

    public static native void ReleaseSession(Session session);

    public static native void SetFaceDetectThreshold(Session session, float f);

    public static native void SetFilterMinimumFacePixelSize(Session session, int i);

    public static native void SetLogLevel(int i);

    public static native void SetTrackModeDetectInterval(Session session, int i);

    public static native void SetTrackModeNumSmoothCacheFrame(Session session, int i);

    public static native void SetTrackModeSmoothRatio(Session session, float f);

    public static native void SetTrackPreviewSize(Session session, int i);

    public static native void UpdateCosineSimilarityConverter(SimilarityConverterConfig similarityConverterConfig);

    public static native void WriteImageStreamToFile(ImageStream imageStream, String str);

    public static String copyResourceFileToApplicationDir(Context context) {
        String absolutePath = new File(context.getExternalFilesDir(null), TypeDefine.INSPIREFACE_IN_ASSETS_FOLDER_NAME).getAbsolutePath();
        SDKUtils.copyFilesFromAssets(context, TypeDefine.INSPIREFACE_IN_ASSETS_FOLDER_NAME, absolutePath);
        return absolutePath;
    }

    public static CustomParameter CreateCustomParameter(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        CustomParameter customParameter = new CustomParameter();
        customParameter.enableRecognition = z ? 1 : 0;
        customParameter.enableLiveness = z2 ? 1 : 0;
        customParameter.enableIrLiveness = z3 ? 1 : 0;
        customParameter.enableMaskDetect = z4 ? 1 : 0;
        customParameter.enableFaceQuality = z5 ? 1 : 0;
        customParameter.enableFaceAttribute = z6 ? 1 : 0;
        customParameter.enableInteractionLiveness = z7 ? 1 : 0;
        customParameter.enableFacePose = z8 ? 1 : 0;
        return customParameter;
    }

    public static FeatureHubConfiguration CreateFeatureHubConfiguration(int i, boolean z, String str, float f, int i2) {
        FeatureHubConfiguration featureHubConfiguration = new FeatureHubConfiguration();
        featureHubConfiguration.primaryKeyMode = i;
        featureHubConfiguration.enablePersistence = z ? 1 : 0;
        featureHubConfiguration.persistenceDbPath = str;
        featureHubConfiguration.searchThreshold = f;
        featureHubConfiguration.searchMode = i2;
        return featureHubConfiguration;
    }
}
