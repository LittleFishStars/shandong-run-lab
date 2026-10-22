package com.zj.adlib;

import com.igexin.assist.sdk.AssistPushConsts;
import com.insightface.sdk.inspireface.base.FaceFeature;
import com.insightface.sdk.inspireface.base.FaceInteractionsActions;
import com.insightface.sdk.inspireface.base.FaceRect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.zj.adlib.td3, reason: from toString */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\t\u001a\u00020\bHÆ\u0003J3\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/zj/adlib/td3;", "", "Lcom/insightface/sdk/inspireface/base/FaceRect;", "a", "", "b", "Lcom/insightface/sdk/inspireface/base/FaceInteractionsActions;", "c", "Lcom/insightface/sdk/inspireface/base/FaceFeature;", "d", "faceRect", "qualityConfidence", AssistPushConsts.MSG_TYPE_ACTIONS, "faceFeature", "e", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/insightface/sdk/inspireface/base/FaceRect;", "i", "()Lcom/insightface/sdk/inspireface/base/FaceRect;", "F", "j", "()F", "Lcom/insightface/sdk/inspireface/base/FaceInteractionsActions;", y6b.f, "()Lcom/insightface/sdk/inspireface/base/FaceInteractionsActions;", "Lcom/insightface/sdk/inspireface/base/FaceFeature;", y6b.g, "()Lcom/insightface/sdk/inspireface/base/FaceFeature;", "<init>", "(Lcom/insightface/sdk/inspireface/base/FaceRect;FLcom/insightface/sdk/inspireface/base/FaceInteractionsActions;Lcom/insightface/sdk/inspireface/base/FaceFeature;)V", "base_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class FaceResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final float qualityConfidence;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final FaceFeature faceFeature;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @Nullable
    public final FaceInteractionsActions actions;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata and from toString */
    @NotNull
    public final FaceRect faceRect;

    public FaceResult(@NotNull FaceRect faceRect, float f, @Nullable FaceInteractionsActions faceInteractionsActions, @NotNull FaceFeature faceFeature) {
        Intrinsics.checkNotNullParameter(faceRect, "faceRect");
        Intrinsics.checkNotNullParameter(faceFeature, "faceFeature");
        this.faceRect = faceRect;
        this.qualityConfidence = f;
        this.actions = faceInteractionsActions;
        this.faceFeature = faceFeature;
    }

    public static /* synthetic */ FaceResult f(FaceResult faceResult, FaceRect faceRect, float f, FaceInteractionsActions faceInteractionsActions, FaceFeature faceFeature, int i, Object obj) {
        if ((i & 1) != 0) {
            faceRect = faceResult.faceRect;
        }
        if ((i & 2) != 0) {
            f = faceResult.qualityConfidence;
        }
        if ((i & 4) != 0) {
            faceInteractionsActions = faceResult.actions;
        }
        if ((i & 8) != 0) {
            faceFeature = faceResult.faceFeature;
        }
        return faceResult.e(faceRect, f, faceInteractionsActions, faceFeature);
    }

    @NotNull
    /* JADX INFO: renamed from: a, reason: from getter */
    public final FaceRect getFaceRect() {
        return this.faceRect;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final float getQualityConfidence() {
        return this.qualityConfidence;
    }

    @Nullable
    /* JADX INFO: renamed from: c, reason: from getter */
    public final FaceInteractionsActions getActions() {
        return this.actions;
    }

    @NotNull
    /* JADX INFO: renamed from: d, reason: from getter */
    public final FaceFeature getFaceFeature() {
        return this.faceFeature;
    }

    @NotNull
    public final FaceResult e(@NotNull FaceRect faceRect, float qualityConfidence, @Nullable FaceInteractionsActions actions, @NotNull FaceFeature faceFeature) {
        Intrinsics.checkNotNullParameter(faceRect, "faceRect");
        Intrinsics.checkNotNullParameter(faceFeature, "faceFeature");
        return new FaceResult(faceRect, qualityConfidence, actions, faceFeature);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceResult)) {
            return false;
        }
        FaceResult faceResult = (FaceResult) other;
        return Intrinsics.areEqual(this.faceRect, faceResult.faceRect) && Float.compare(this.qualityConfidence, faceResult.qualityConfidence) == 0 && Intrinsics.areEqual(this.actions, faceResult.actions) && Intrinsics.areEqual(this.faceFeature, faceResult.faceFeature);
    }

    @Nullable
    public final FaceInteractionsActions g() {
        return this.actions;
    }

    @NotNull
    public final FaceFeature h() {
        return this.faceFeature;
    }

    public int hashCode() {
        int iHashCode = ((this.faceRect.hashCode() * 31) + Float.hashCode(this.qualityConfidence)) * 31;
        FaceInteractionsActions faceInteractionsActions = this.actions;
        return ((iHashCode + (faceInteractionsActions == null ? 0 : faceInteractionsActions.hashCode())) * 31) + this.faceFeature.hashCode();
    }

    @NotNull
    public final FaceRect i() {
        return this.faceRect;
    }

    public final float j() {
        return this.qualityConfidence;
    }

    @NotNull
    public String toString() {
        return "FaceResult(faceRect=" + this.faceRect + ", qualityConfidence=" + this.qualityConfidence + ", actions=" + this.actions + ", faceFeature=" + this.faceFeature + ')';
    }
}
