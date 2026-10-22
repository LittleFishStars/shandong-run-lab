package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.huachenjie.common.bean.CommonConfig;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.rule.RuleV3Activity;
import com.igexin.push.config.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\bb\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001Bù\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010#\u001a\u00020\u0006\u0012\b\b\u0002\u0010$\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020&\u0012\b\b\u0002\u0010'\u001a\u00020\u0006\u0012\b\b\u0002\u0010(\u001a\u00020\u0013\u0012\b\b\u0002\u0010)\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0+\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\u0006\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u0012\b\b\u0002\u00100\u001a\u00020\u0013¢\u0006\u0002\u00101J\n\u0010\u008d\u0001\u001a\u00020\u0006HÖ\u0001J\u001e\u0010\u008e\u0001\u001a\u00030\u008f\u00012\b\u0010\u0090\u0001\u001a\u00030\u0091\u00012\u0007\u0010\u0092\u0001\u001a\u00020\u0006HÖ\u0001R\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00107\"\u0004\b;\u00109R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010$\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00103\"\u0004\bC\u00105R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001a\u00100\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010O\"\u0004\bR\u0010QR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00103\"\u0004\bT\u00105R\u001a\u0010#\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u00103\"\u0004\bV\u00105R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u00103\"\u0004\bX\u00105R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u00107\"\u0004\bZ\u00109R\u001a\u0010\u001a\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00103\"\u0004\b\\\u00105R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010O\"\u0004\b^\u0010QR\u001a\u0010!\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00103\"\u0004\b`\u00105R\u001a\u0010 \u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u00107\"\u0004\bb\u00109R\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00107\"\u0004\bd\u00109R\u001a\u0010/\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00107\"\u0004\bf\u00109R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00103\"\u0004\bl\u00105R\u001a\u0010.\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00103\"\u0004\bn\u00105R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00107\"\u0004\bp\u00109R\u001a\u0010\u001e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00107\"\u0004\br\u00109R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001b\u0010'\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u00103\"\u0005\b\u0080\u0001\u00105R\u001c\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u00107\"\u0005\b\u0082\u0001\u00109R\u001c\u0010-\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u00103\"\u0005\b\u0084\u0001\u00105R \u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R\u001c\u0010\u0014\u001a\u00020\u0006X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u00103\"\u0005\b\u008a\u0001\u00105R\u001c\u0010(\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010O\"\u0005\b\u008c\u0001\u0010Q¨\u0006\u0093\u0001"}, d2 = {"Lcom/huachenjie/run/bean/SunshineRunServiceData;", "Landroid/os/Parcelable;", "saveCurrentTime", "", "currentTime", "nextPointIndex", "", "lastPointIndex", "runData", "Lcom/huachenjie/run/bean/RunDataV2;", "schoolGeoFenceDetail", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "startRunEntity", "Lcom/huachenjie/common/bean/StartRunEntity;", RuleV3Activity.x, "Lcom/huachenjie/common/bean/SchoolRule;", "commonConfig", "Lcom/huachenjie/common/bean/CommonConfig;", "isFinish", "", "stopStatus", "autoSavePauseTime", "autoPauseTime", "autoPauseLeftTime", "speedErrPauseLeftTime", "nfcCheckLeftTime", "nfcPauseDuration", "nfcVerified", "faceCheckData", "Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;", "savePauseTime", "pauseTime", "pauseLeftTime", "pauseCount", "runDistanceMode", "moreTargetDistance", "clockMode", "segmentStrideAvg", "", "segmentStrideExceptionNum", ReadyActivity.t, "amapGPSLevel", "cheatResult", "", "Lcom/huachenjie/run/bean/CheatResult;", "sportType", "runScene", "protectDistance", "hasProtect", "(JJIILcom/huachenjie/run/bean/RunDataV2;Lcom/huachenjie/common/bean/GeoFenceDetail;Lcom/huachenjie/common/bean/StartRunEntity;Lcom/huachenjie/common/bean/SchoolRule;Lcom/huachenjie/common/bean/CommonConfig;ZIJJJJJIZLcom/huachenjie/run/bean/SunshineRunFaceCheckData;JJJIIIIFIZILjava/util/Map;IIJZ)V", "getAmapGPSLevel", "()I", "setAmapGPSLevel", "(I)V", "getAutoPauseLeftTime", "()J", "setAutoPauseLeftTime", "(J)V", "getAutoPauseTime", "setAutoPauseTime", "getAutoSavePauseTime", "setAutoSavePauseTime", "getCheatResult", "()Ljava/util/Map;", "setCheatResult", "(Ljava/util/Map;)V", "getClockMode", "setClockMode", "getCommonConfig", "()Lcom/huachenjie/common/bean/CommonConfig;", "setCommonConfig", "(Lcom/huachenjie/common/bean/CommonConfig;)V", "getCurrentTime", "setCurrentTime", "getFaceCheckData", "()Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;", "setFaceCheckData", "(Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;)V", "getHasProtect", "()Z", "setHasProtect", "(Z)V", "setFinish", "getLastPointIndex", "setLastPointIndex", "getMoreTargetDistance", "setMoreTargetDistance", "getNextPointIndex", "setNextPointIndex", "getNfcCheckLeftTime", "setNfcCheckLeftTime", "getNfcPauseDuration", "setNfcPauseDuration", "getNfcVerified", "setNfcVerified", "getPauseCount", "setPauseCount", "getPauseLeftTime", "setPauseLeftTime", "getPauseTime", "setPauseTime", "getProtectDistance", "setProtectDistance", "getRunData", "()Lcom/huachenjie/run/bean/RunDataV2;", "setRunData", "(Lcom/huachenjie/run/bean/RunDataV2;)V", "getRunDistanceMode", "setRunDistanceMode", "getRunScene", "setRunScene", "getSaveCurrentTime", "setSaveCurrentTime", "getSavePauseTime", "setSavePauseTime", "getSchoolGeoFenceDetail", "()Lcom/huachenjie/common/bean/GeoFenceDetail;", "setSchoolGeoFenceDetail", "(Lcom/huachenjie/common/bean/GeoFenceDetail;)V", "getSchoolRule", "()Lcom/huachenjie/common/bean/SchoolRule;", "setSchoolRule", "(Lcom/huachenjie/common/bean/SchoolRule;)V", "getSegmentStrideAvg", "()F", "setSegmentStrideAvg", "(F)V", "getSegmentStrideExceptionNum", "setSegmentStrideExceptionNum", "getSpeedErrPauseLeftTime", "setSpeedErrPauseLeftTime", "getSportType", "setSportType", "getStartRunEntity", "()Lcom/huachenjie/common/bean/StartRunEntity;", "setStartRunEntity", "(Lcom/huachenjie/common/bean/StartRunEntity;)V", "getStopStatus", "setStopStatus", "getUseCreditSword", "setUseCreditSword", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SunshineRunServiceData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SunshineRunServiceData> CREATOR = new Creator();
    private int amapGPSLevel;
    private long autoPauseLeftTime;
    private long autoPauseTime;
    private long autoSavePauseTime;

    @NotNull
    private Map<Integer, CheatResult> cheatResult;
    private int clockMode;

    @Nullable
    private CommonConfig commonConfig;
    private long currentTime;

    @NotNull
    private SunshineRunFaceCheckData faceCheckData;
    private boolean hasProtect;
    private boolean isFinish;
    private int lastPointIndex;
    private int moreTargetDistance;
    private int nextPointIndex;
    private long nfcCheckLeftTime;
    private int nfcPauseDuration;
    private boolean nfcVerified;
    private int pauseCount;
    private long pauseLeftTime;
    private long pauseTime;
    private long protectDistance;

    @Nullable
    private RunDataV2 runData;
    private int runDistanceMode;
    private int runScene;
    private long saveCurrentTime;
    private long savePauseTime;

    @Nullable
    private GeoFenceDetail schoolGeoFenceDetail;

    @Nullable
    private SchoolRule schoolRule;
    private float segmentStrideAvg;
    private int segmentStrideExceptionNum;
    private long speedErrPauseLeftTime;
    private int sportType;

    @Nullable
    private StartRunEntity startRunEntity;
    private int stopStatus;
    private boolean useCreditSword;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SunshineRunServiceData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunServiceData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            long j = parcel.readLong();
            long j2 = parcel.readLong();
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            RunDataV2 runDataV2 = (RunDataV2) parcel.readParcelable(SunshineRunServiceData.class.getClassLoader());
            GeoFenceDetail geoFenceDetail = (GeoFenceDetail) parcel.readParcelable(SunshineRunServiceData.class.getClassLoader());
            StartRunEntity startRunEntity = (StartRunEntity) parcel.readParcelable(SunshineRunServiceData.class.getClassLoader());
            SchoolRule schoolRule = (SchoolRule) parcel.readParcelable(SunshineRunServiceData.class.getClassLoader());
            CommonConfig commonConfig = (CommonConfig) parcel.readParcelable(SunshineRunServiceData.class.getClassLoader());
            boolean z = parcel.readInt() != 0;
            int i3 = parcel.readInt();
            long j3 = parcel.readLong();
            long j4 = parcel.readLong();
            long j5 = parcel.readLong();
            long j6 = parcel.readLong();
            long j7 = parcel.readLong();
            int i4 = parcel.readInt();
            boolean z2 = parcel.readInt() != 0;
            SunshineRunFaceCheckData sunshineRunFaceCheckDataCreateFromParcel = SunshineRunFaceCheckData.CREATOR.createFromParcel(parcel);
            long j8 = parcel.readLong();
            long j9 = parcel.readLong();
            long j10 = parcel.readLong();
            int i5 = parcel.readInt();
            int i6 = parcel.readInt();
            int i7 = parcel.readInt();
            int i8 = parcel.readInt();
            float f = parcel.readFloat();
            int i9 = parcel.readInt();
            boolean z3 = parcel.readInt() != 0;
            int i10 = parcel.readInt();
            int i11 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i11);
            int i12 = 0;
            while (i12 != i11) {
                linkedHashMap.put(Integer.valueOf(parcel.readInt()), CheatResult.CREATOR.createFromParcel(parcel));
                i12++;
                z = z;
                i11 = i11;
            }
            return new SunshineRunServiceData(j, j2, i, i2, runDataV2, geoFenceDetail, startRunEntity, schoolRule, commonConfig, z, i3, j3, j4, j5, j6, j7, i4, z2, sunshineRunFaceCheckDataCreateFromParcel, j8, j9, j10, i5, i6, i7, i8, f, i9, z3, i10, linkedHashMap, parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunServiceData[] newArray(int i) {
            return new SunshineRunServiceData[i];
        }
    }

    public SunshineRunServiceData() {
        this(0L, 0L, 0, 0, null, null, null, null, null, false, 0, 0L, 0L, 0L, 0L, 0L, 0, false, null, 0L, 0L, 0L, 0, 0, 0, 0, 0.0f, 0, false, 0, null, 0, 0, 0L, false, -1, 7, null);
    }

    public SunshineRunServiceData(long j, long j2, int i, int i2, @Nullable RunDataV2 runDataV2, @Nullable GeoFenceDetail geoFenceDetail, @Nullable StartRunEntity startRunEntity, @Nullable SchoolRule schoolRule, @Nullable CommonConfig commonConfig, boolean z, int i3, long j3, long j4, long j5, long j6, long j7, int i4, boolean z2, @NotNull SunshineRunFaceCheckData sunshineRunFaceCheckData, long j8, long j9, long j10, int i5, int i6, int i7, int i8, float f, int i9, boolean z3, int i10, @NotNull Map<Integer, CheatResult> map, int i11, int i12, long j11, boolean z4) {
        Intrinsics.checkNotNullParameter(sunshineRunFaceCheckData, "faceCheckData");
        Intrinsics.checkNotNullParameter(map, "cheatResult");
        this.saveCurrentTime = j;
        this.currentTime = j2;
        this.nextPointIndex = i;
        this.lastPointIndex = i2;
        this.runData = runDataV2;
        this.schoolGeoFenceDetail = geoFenceDetail;
        this.startRunEntity = startRunEntity;
        this.schoolRule = schoolRule;
        this.commonConfig = commonConfig;
        this.isFinish = z;
        this.stopStatus = i3;
        this.autoSavePauseTime = j3;
        this.autoPauseTime = j4;
        this.autoPauseLeftTime = j5;
        this.speedErrPauseLeftTime = j6;
        this.nfcCheckLeftTime = j7;
        this.nfcPauseDuration = i4;
        this.nfcVerified = z2;
        this.faceCheckData = sunshineRunFaceCheckData;
        this.savePauseTime = j8;
        this.pauseTime = j9;
        this.pauseLeftTime = j10;
        this.pauseCount = i5;
        this.runDistanceMode = i6;
        this.moreTargetDistance = i7;
        this.clockMode = i8;
        this.segmentStrideAvg = f;
        this.segmentStrideExceptionNum = i9;
        this.useCreditSword = z3;
        this.amapGPSLevel = i10;
        this.cheatResult = map;
        this.sportType = i11;
        this.runScene = i12;
        this.protectDistance = j11;
        this.hasProtect = z4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getAmapGPSLevel() {
        return this.amapGPSLevel;
    }

    public final long getAutoPauseLeftTime() {
        return this.autoPauseLeftTime;
    }

    public final long getAutoPauseTime() {
        return this.autoPauseTime;
    }

    public final long getAutoSavePauseTime() {
        return this.autoSavePauseTime;
    }

    @NotNull
    public final Map<Integer, CheatResult> getCheatResult() {
        return this.cheatResult;
    }

    public final int getClockMode() {
        return this.clockMode;
    }

    @Nullable
    public final CommonConfig getCommonConfig() {
        return this.commonConfig;
    }

    public final long getCurrentTime() {
        return this.currentTime;
    }

    @NotNull
    public final SunshineRunFaceCheckData getFaceCheckData() {
        return this.faceCheckData;
    }

    public final boolean getHasProtect() {
        return this.hasProtect;
    }

    public final int getLastPointIndex() {
        return this.lastPointIndex;
    }

    public final int getMoreTargetDistance() {
        return this.moreTargetDistance;
    }

    public final int getNextPointIndex() {
        return this.nextPointIndex;
    }

    public final long getNfcCheckLeftTime() {
        return this.nfcCheckLeftTime;
    }

    public final int getNfcPauseDuration() {
        return this.nfcPauseDuration;
    }

    public final boolean getNfcVerified() {
        return this.nfcVerified;
    }

    public final int getPauseCount() {
        return this.pauseCount;
    }

    public final long getPauseLeftTime() {
        return this.pauseLeftTime;
    }

    public final long getPauseTime() {
        return this.pauseTime;
    }

    public final long getProtectDistance() {
        return this.protectDistance;
    }

    @Nullable
    public final RunDataV2 getRunData() {
        return this.runData;
    }

    public final int getRunDistanceMode() {
        return this.runDistanceMode;
    }

    public final int getRunScene() {
        return this.runScene;
    }

    public final long getSaveCurrentTime() {
        return this.saveCurrentTime;
    }

    public final long getSavePauseTime() {
        return this.savePauseTime;
    }

    @Nullable
    public final GeoFenceDetail getSchoolGeoFenceDetail() {
        return this.schoolGeoFenceDetail;
    }

    @Nullable
    public final SchoolRule getSchoolRule() {
        return this.schoolRule;
    }

    public final float getSegmentStrideAvg() {
        return this.segmentStrideAvg;
    }

    public final int getSegmentStrideExceptionNum() {
        return this.segmentStrideExceptionNum;
    }

    public final long getSpeedErrPauseLeftTime() {
        return this.speedErrPauseLeftTime;
    }

    public final int getSportType() {
        return this.sportType;
    }

    @Nullable
    public final StartRunEntity getStartRunEntity() {
        return this.startRunEntity;
    }

    public final int getStopStatus() {
        return this.stopStatus;
    }

    public final boolean getUseCreditSword() {
        return this.useCreditSword;
    }

    /* JADX INFO: renamed from: isFinish, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public final void setAmapGPSLevel(int i) {
        this.amapGPSLevel = i;
    }

    public final void setAutoPauseLeftTime(long j) {
        this.autoPauseLeftTime = j;
    }

    public final void setAutoPauseTime(long j) {
        this.autoPauseTime = j;
    }

    public final void setAutoSavePauseTime(long j) {
        this.autoSavePauseTime = j;
    }

    public final void setCheatResult(@NotNull Map<Integer, CheatResult> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cheatResult = map;
    }

    public final void setClockMode(int i) {
        this.clockMode = i;
    }

    public final void setCommonConfig(@Nullable CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
    }

    public final void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public final void setFaceCheckData(@NotNull SunshineRunFaceCheckData sunshineRunFaceCheckData) {
        Intrinsics.checkNotNullParameter(sunshineRunFaceCheckData, "<set-?>");
        this.faceCheckData = sunshineRunFaceCheckData;
    }

    public final void setFinish(boolean z) {
        this.isFinish = z;
    }

    public final void setHasProtect(boolean z) {
        this.hasProtect = z;
    }

    public final void setLastPointIndex(int i) {
        this.lastPointIndex = i;
    }

    public final void setMoreTargetDistance(int i) {
        this.moreTargetDistance = i;
    }

    public final void setNextPointIndex(int i) {
        this.nextPointIndex = i;
    }

    public final void setNfcCheckLeftTime(long j) {
        this.nfcCheckLeftTime = j;
    }

    public final void setNfcPauseDuration(int i) {
        this.nfcPauseDuration = i;
    }

    public final void setNfcVerified(boolean z) {
        this.nfcVerified = z;
    }

    public final void setPauseCount(int i) {
        this.pauseCount = i;
    }

    public final void setPauseLeftTime(long j) {
        this.pauseLeftTime = j;
    }

    public final void setPauseTime(long j) {
        this.pauseTime = j;
    }

    public final void setProtectDistance(long j) {
        this.protectDistance = j;
    }

    public final void setRunData(@Nullable RunDataV2 runDataV2) {
        this.runData = runDataV2;
    }

    public final void setRunDistanceMode(int i) {
        this.runDistanceMode = i;
    }

    public final void setRunScene(int i) {
        this.runScene = i;
    }

    public final void setSaveCurrentTime(long j) {
        this.saveCurrentTime = j;
    }

    public final void setSavePauseTime(long j) {
        this.savePauseTime = j;
    }

    public final void setSchoolGeoFenceDetail(@Nullable GeoFenceDetail geoFenceDetail) {
        this.schoolGeoFenceDetail = geoFenceDetail;
    }

    public final void setSchoolRule(@Nullable SchoolRule schoolRule) {
        this.schoolRule = schoolRule;
    }

    public final void setSegmentStrideAvg(float f) {
        this.segmentStrideAvg = f;
    }

    public final void setSegmentStrideExceptionNum(int i) {
        this.segmentStrideExceptionNum = i;
    }

    public final void setSpeedErrPauseLeftTime(long j) {
        this.speedErrPauseLeftTime = j;
    }

    public final void setSportType(int i) {
        this.sportType = i;
    }

    public final void setStartRunEntity(@Nullable StartRunEntity startRunEntity) {
        this.startRunEntity = startRunEntity;
    }

    public final void setStopStatus(int i) {
        this.stopStatus = i;
    }

    public final void setUseCreditSword(boolean z) {
        this.useCreditSword = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeLong(this.saveCurrentTime);
        parcel.writeLong(this.currentTime);
        parcel.writeInt(this.nextPointIndex);
        parcel.writeInt(this.lastPointIndex);
        parcel.writeParcelable(this.runData, flags);
        parcel.writeParcelable(this.schoolGeoFenceDetail, flags);
        parcel.writeParcelable(this.startRunEntity, flags);
        parcel.writeParcelable(this.schoolRule, flags);
        parcel.writeParcelable(this.commonConfig, flags);
        parcel.writeInt(this.isFinish ? 1 : 0);
        parcel.writeInt(this.stopStatus);
        parcel.writeLong(this.autoSavePauseTime);
        parcel.writeLong(this.autoPauseTime);
        parcel.writeLong(this.autoPauseLeftTime);
        parcel.writeLong(this.speedErrPauseLeftTime);
        parcel.writeLong(this.nfcCheckLeftTime);
        parcel.writeInt(this.nfcPauseDuration);
        parcel.writeInt(this.nfcVerified ? 1 : 0);
        this.faceCheckData.writeToParcel(parcel, flags);
        parcel.writeLong(this.savePauseTime);
        parcel.writeLong(this.pauseTime);
        parcel.writeLong(this.pauseLeftTime);
        parcel.writeInt(this.pauseCount);
        parcel.writeInt(this.runDistanceMode);
        parcel.writeInt(this.moreTargetDistance);
        parcel.writeInt(this.clockMode);
        parcel.writeFloat(this.segmentStrideAvg);
        parcel.writeInt(this.segmentStrideExceptionNum);
        parcel.writeInt(this.useCreditSword ? 1 : 0);
        parcel.writeInt(this.amapGPSLevel);
        Map<Integer, CheatResult> map = this.cheatResult;
        parcel.writeInt(map.size());
        for (Map.Entry<Integer, CheatResult> entry : map.entrySet()) {
            parcel.writeInt(entry.getKey().intValue());
            entry.getValue().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.sportType);
        parcel.writeInt(this.runScene);
        parcel.writeLong(this.protectDistance);
        parcel.writeInt(this.hasProtect ? 1 : 0);
    }

    public /* synthetic */ SunshineRunServiceData(long j, long j2, int i, int i2, RunDataV2 runDataV2, GeoFenceDetail geoFenceDetail, StartRunEntity startRunEntity, SchoolRule schoolRule, CommonConfig commonConfig, boolean z, int i3, long j3, long j4, long j5, long j6, long j7, int i4, boolean z2, SunshineRunFaceCheckData sunshineRunFaceCheckData, long j8, long j9, long j10, int i5, int i6, int i7, int i8, float f, int i9, boolean z3, int i10, Map map, int i11, int i12, long j11, boolean z4, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0L : j, (i13 & 2) != 0 ? 0L : j2, (i13 & 4) != 0 ? -1 : i, (i13 & 8) != 0 ? -1 : i2, (i13 & 16) != 0 ? null : runDataV2, (i13 & 32) != 0 ? null : geoFenceDetail, (i13 & 64) != 0 ? null : startRunEntity, (i13 & 128) != 0 ? null : schoolRule, (i13 & 256) == 0 ? commonConfig : null, (i13 & 512) != 0 ? false : z, (i13 & 1024) == 0 ? i3 : -1, (i13 & 2048) != 0 ? 0L : j3, (i13 & 4096) != 0 ? 0L : j4, (i13 & 8192) != 0 ? 120000L : j5, (i13 & 16384) != 0 ? 120000L : j6, (i13 & 32768) != 0 ? 30000L : j7, (i13 & 65536) != 0 ? 30 : i4, (i13 & 131072) != 0 ? false : z2, (i13 & 262144) != 0 ? new SunshineRunFaceCheckData(false, null, 0, 0, false, 0, 0, null, 0, 0L, 0L, 0L, 4095, null) : sunshineRunFaceCheckData, (i13 & 524288) != 0 ? 0L : j8, (i13 & 1048576) != 0 ? 0L : j9, (i13 & 2097152) == 0 ? j10 : c.l, (i13 & 4194304) != 0 ? 0 : i5, (i13 & 8388608) != 0 ? 0 : i6, (i13 & 16777216) != 0 ? 0 : i7, (i13 & 33554432) != 0 ? 2 : i8, (i13 & TTAdConstant.KEY_CLICK_AREA) != 0 ? Float.MAX_VALUE : f, (i13 & 134217728) != 0 ? Integer.MAX_VALUE : i9, (i13 & 268435456) != 0 ? false : z3, (i13 & 536870912) != 0 ? 3 : i10, (i13 & 1073741824) != 0 ? new HashMap() : map, (i13 & Integer.MIN_VALUE) != 0 ? 1 : i11, (i14 & 1) != 0 ? 0 : i12, (i14 & 2) != 0 ? 100L : j11, (i14 & 4) == 0 ? z4 : false);
    }
}
