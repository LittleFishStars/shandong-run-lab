package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.StartRunEntity;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.rule.RuleV3Activity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0006\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005¢\u0006\u0002\u0010\u001bJ\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u0010w\u001a\u00020\u0014HÆ\u0003J\u0015\u0010x\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0005HÆ\u0003J\t\u0010|\u001a\u00020\u0005HÆ\u0003J\t\u0010}\u001a\u00020\u0005HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u007f\u001a\u00020\nHÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\rHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0010HÆ\u0003J´\u0001\u0010\u0084\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005HÆ\u0001J\n\u0010\u0085\u0001\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0086\u0001\u001a\u00020\r2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0012HÖ\u0001J\u001e\u0010\u008b\u0001\u001a\u00030\u008c\u00012\b\u0010\u008d\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0005HÖ\u0001R\"\u0010\u001c\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R&\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010/\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\"\u00103\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010;\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0016\n\u0002\u0010B\u0012\u0004\b=\u0010\u001e\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010<X\u0086\u000e¢\u0006\u0016\n\u0002\u0010B\u0012\u0004\bD\u0010\u001e\u001a\u0004\bE\u0010?\"\u0004\bF\u0010AR \u0010G\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bH\u0010\u001e\u001a\u0004\bI\u0010$\"\u0004\bJ\u0010&R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010$\"\u0004\bL\u0010&R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010$\"\u0004\bP\u0010&R\"\u0010Q\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bR\u0010\u001e\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010$\"\u0004\bV\u0010&R \u0010W\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bX\u0010\u001e\u001a\u0004\bY\u0010 \"\u0004\bZ\u0010\"R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010$\"\u0004\bd\u0010&R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010 \"\u0004\bf\u0010\"R\u001a\u0010\u0018\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010$\"\u0004\bh\u0010&R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR \u0010m\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bn\u0010\u001e\u001a\u0004\bo\u0010 \"\u0004\bp\u0010\"R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t¨\u0006\u0090\u0001"}, d2 = {"Lcom/huachenjie/run/bean/StartRunPageParam;", "Landroid/os/Parcelable;", "geoFenceDetail", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "runDistanceMode", "", "moreTargetDistance", "startRunEntity", "Lcom/huachenjie/common/bean/StartRunEntity;", "segmentStrideAvg", "", "segmentStrideExceptionNum", ReadyActivity.t, "", "amapGPSLevel", RuleV3Activity.x, "Lcom/huachenjie/common/bean/SchoolRule;", "semesterCode", "", "faceCheckData", "Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;", "cheatResult", "", "Lcom/huachenjie/run/bean/CheatResult;", "sportType", "runScene", "nfcPauseDuration", "(Lcom/huachenjie/common/bean/GeoFenceDetail;IILcom/huachenjie/common/bean/StartRunEntity;FIZILcom/huachenjie/common/bean/SchoolRule;Ljava/lang/String;Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;Ljava/util/Map;III)V", "activityCode", "getActivityCode$annotations", "()V", "getActivityCode", "()Ljava/lang/String;", "setActivityCode", "(Ljava/lang/String;)V", "getAmapGPSLevel", "()I", "setAmapGPSLevel", "(I)V", "getCheatResult", "()Ljava/util/Map;", "setCheatResult", "(Ljava/util/Map;)V", "getFaceCheckData", "()Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;", "setFaceCheckData", "(Lcom/huachenjie/run/bean/SunshineRunFaceCheckData;)V", "faceEnabled", "getFaceEnabled$annotations", "getFaceEnabled", "setFaceEnabled", "fenceCode", "getFenceCode$annotations", "getFenceCode", "setFenceCode", "getGeoFenceDetail", "()Lcom/huachenjie/common/bean/GeoFenceDetail;", "setGeoFenceDetail", "(Lcom/huachenjie/common/bean/GeoFenceDetail;)V", "lat", "", "getLat$annotations", "getLat", "()Ljava/lang/Double;", "setLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "lng", "getLng$annotations", "getLng", "setLng", "minRunDis", "getMinRunDis$annotations", "getMinRunDis", "setMinRunDis", "getMoreTargetDistance", "setMoreTargetDistance", "getNfcPauseDuration", "setNfcPauseDuration", "getRunDistanceMode", "setRunDistanceMode", "runPlanCode", "getRunPlanCode$annotations", "getRunPlanCode", "setRunPlanCode", "getRunScene", "setRunScene", "schoolCode", "getSchoolCode$annotations", "getSchoolCode", "setSchoolCode", "getSchoolRule", "()Lcom/huachenjie/common/bean/SchoolRule;", "setSchoolRule", "(Lcom/huachenjie/common/bean/SchoolRule;)V", "getSegmentStrideAvg", "()F", "setSegmentStrideAvg", "(F)V", "getSegmentStrideExceptionNum", "setSegmentStrideExceptionNum", "getSemesterCode", "setSemesterCode", "getSportType", "setSportType", "getStartRunEntity", "()Lcom/huachenjie/common/bean/StartRunEntity;", "setStartRunEntity", "(Lcom/huachenjie/common/bean/StartRunEntity;)V", "subSchoolCode", "getSubSchoolCode$annotations", "getSubSchoolCode", "setSubSchoolCode", "getUseCreditSword", "()Z", "setUseCreditSword", "(Z)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StartRunPageParam implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<StartRunPageParam> CREATOR = new Creator();

    @Nullable
    private String activityCode;
    private int amapGPSLevel;

    @NotNull
    private Map<Integer, CheatResult> cheatResult;

    @NotNull
    private SunshineRunFaceCheckData faceCheckData;
    private int faceEnabled;

    @Nullable
    private String fenceCode;

    @Nullable
    private GeoFenceDetail geoFenceDetail;

    @Nullable
    private Double lat;

    @Nullable
    private Double lng;
    private int minRunDis;
    private int moreTargetDistance;
    private int nfcPauseDuration;
    private int runDistanceMode;

    @Nullable
    private String runPlanCode;
    private int runScene;

    @NotNull
    private String schoolCode;

    @Nullable
    private SchoolRule schoolRule;
    private float segmentStrideAvg;
    private int segmentStrideExceptionNum;

    @Nullable
    private String semesterCode;
    private int sportType;

    @Nullable
    private StartRunEntity startRunEntity;

    @NotNull
    private String subSchoolCode;
    private boolean useCreditSword;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StartRunPageParam> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StartRunPageParam createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            GeoFenceDetail geoFenceDetail = (GeoFenceDetail) parcel.readParcelable(StartRunPageParam.class.getClassLoader());
            int i = parcel.readInt();
            int i2 = parcel.readInt();
            StartRunEntity startRunEntity = (StartRunEntity) parcel.readParcelable(StartRunPageParam.class.getClassLoader());
            float f = parcel.readFloat();
            int i3 = parcel.readInt();
            int i4 = 0;
            boolean z = parcel.readInt() != 0;
            int i5 = parcel.readInt();
            SchoolRule schoolRule = (SchoolRule) parcel.readParcelable(StartRunPageParam.class.getClassLoader());
            String string = parcel.readString();
            SunshineRunFaceCheckData sunshineRunFaceCheckDataCreateFromParcel = SunshineRunFaceCheckData.CREATOR.createFromParcel(parcel);
            int i6 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i6);
            while (i4 != i6) {
                linkedHashMap.put(Integer.valueOf(parcel.readInt()), CheatResult.CREATOR.createFromParcel(parcel));
                i4++;
                i6 = i6;
            }
            return new StartRunPageParam(geoFenceDetail, i, i2, startRunEntity, f, i3, z, i5, schoolRule, string, sunshineRunFaceCheckDataCreateFromParcel, linkedHashMap, parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final StartRunPageParam[] newArray(int i) {
            return new StartRunPageParam[i];
        }
    }

    public StartRunPageParam() {
        this(null, 0, 0, null, 0.0f, 0, false, 0, null, null, null, null, 0, 0, 0, 32767, null);
    }

    public StartRunPageParam(@Nullable GeoFenceDetail geoFenceDetail, int i, int i2, @Nullable StartRunEntity startRunEntity, float f, int i3, boolean z, int i4, @Nullable SchoolRule schoolRule, @Nullable String str, @NotNull SunshineRunFaceCheckData sunshineRunFaceCheckData, @NotNull Map<Integer, CheatResult> map, int i5, int i6, int i7) {
        Intrinsics.checkNotNullParameter(sunshineRunFaceCheckData, "faceCheckData");
        Intrinsics.checkNotNullParameter(map, "cheatResult");
        this.geoFenceDetail = geoFenceDetail;
        this.runDistanceMode = i;
        this.moreTargetDistance = i2;
        this.startRunEntity = startRunEntity;
        this.segmentStrideAvg = f;
        this.segmentStrideExceptionNum = i3;
        this.useCreditSword = z;
        this.amapGPSLevel = i4;
        this.schoolRule = schoolRule;
        this.semesterCode = str;
        this.faceCheckData = sunshineRunFaceCheckData;
        this.cheatResult = map;
        this.sportType = i5;
        this.runScene = i6;
        this.nfcPauseDuration = i7;
        this.runPlanCode = "";
        this.schoolCode = "";
        this.subSchoolCode = "";
    }

    public static /* synthetic */ void getActivityCode$annotations() {
    }

    public static /* synthetic */ void getFaceEnabled$annotations() {
    }

    public static /* synthetic */ void getFenceCode$annotations() {
    }

    public static /* synthetic */ void getLat$annotations() {
    }

    public static /* synthetic */ void getLng$annotations() {
    }

    public static /* synthetic */ void getMinRunDis$annotations() {
    }

    public static /* synthetic */ void getRunPlanCode$annotations() {
    }

    public static /* synthetic */ void getSchoolCode$annotations() {
    }

    public static /* synthetic */ void getSubSchoolCode$annotations() {
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GeoFenceDetail getGeoFenceDetail() {
        return this.geoFenceDetail;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getSemesterCode() {
        return this.semesterCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final SunshineRunFaceCheckData getFaceCheckData() {
        return this.faceCheckData;
    }

    @NotNull
    public final Map<Integer, CheatResult> component12() {
        return this.cheatResult;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getSportType() {
        return this.sportType;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getRunScene() {
        return this.runScene;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getNfcPauseDuration() {
        return this.nfcPauseDuration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRunDistanceMode() {
        return this.runDistanceMode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMoreTargetDistance() {
        return this.moreTargetDistance;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final StartRunEntity getStartRunEntity() {
        return this.startRunEntity;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final float getSegmentStrideAvg() {
        return this.segmentStrideAvg;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSegmentStrideExceptionNum() {
        return this.segmentStrideExceptionNum;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getUseCreditSword() {
        return this.useCreditSword;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getAmapGPSLevel() {
        return this.amapGPSLevel;
    }

    @Nullable
    /* JADX INFO: renamed from: component9, reason: from getter */
    public final SchoolRule getSchoolRule() {
        return this.schoolRule;
    }

    @NotNull
    public final StartRunPageParam copy(@Nullable GeoFenceDetail geoFenceDetail, int runDistanceMode, int moreTargetDistance, @Nullable StartRunEntity startRunEntity, float segmentStrideAvg, int segmentStrideExceptionNum, boolean useCreditSword, int amapGPSLevel, @Nullable SchoolRule schoolRule, @Nullable String semesterCode, @NotNull SunshineRunFaceCheckData faceCheckData, @NotNull Map<Integer, CheatResult> cheatResult, int sportType, int runScene, int nfcPauseDuration) {
        Intrinsics.checkNotNullParameter(faceCheckData, "faceCheckData");
        Intrinsics.checkNotNullParameter(cheatResult, "cheatResult");
        return new StartRunPageParam(geoFenceDetail, runDistanceMode, moreTargetDistance, startRunEntity, segmentStrideAvg, segmentStrideExceptionNum, useCreditSword, amapGPSLevel, schoolRule, semesterCode, faceCheckData, cheatResult, sportType, runScene, nfcPauseDuration);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartRunPageParam)) {
            return false;
        }
        StartRunPageParam startRunPageParam = (StartRunPageParam) other;
        return Intrinsics.areEqual(this.geoFenceDetail, startRunPageParam.geoFenceDetail) && this.runDistanceMode == startRunPageParam.runDistanceMode && this.moreTargetDistance == startRunPageParam.moreTargetDistance && Intrinsics.areEqual(this.startRunEntity, startRunPageParam.startRunEntity) && Float.compare(this.segmentStrideAvg, startRunPageParam.segmentStrideAvg) == 0 && this.segmentStrideExceptionNum == startRunPageParam.segmentStrideExceptionNum && this.useCreditSword == startRunPageParam.useCreditSword && this.amapGPSLevel == startRunPageParam.amapGPSLevel && Intrinsics.areEqual(this.schoolRule, startRunPageParam.schoolRule) && Intrinsics.areEqual(this.semesterCode, startRunPageParam.semesterCode) && Intrinsics.areEqual(this.faceCheckData, startRunPageParam.faceCheckData) && Intrinsics.areEqual(this.cheatResult, startRunPageParam.cheatResult) && this.sportType == startRunPageParam.sportType && this.runScene == startRunPageParam.runScene && this.nfcPauseDuration == startRunPageParam.nfcPauseDuration;
    }

    @Nullable
    public final String getActivityCode() {
        return this.activityCode;
    }

    public final int getAmapGPSLevel() {
        return this.amapGPSLevel;
    }

    @NotNull
    public final Map<Integer, CheatResult> getCheatResult() {
        return this.cheatResult;
    }

    @NotNull
    public final SunshineRunFaceCheckData getFaceCheckData() {
        return this.faceCheckData;
    }

    public final int getFaceEnabled() {
        return this.faceEnabled;
    }

    @Nullable
    public final String getFenceCode() {
        return this.fenceCode;
    }

    @Nullable
    public final GeoFenceDetail getGeoFenceDetail() {
        return this.geoFenceDetail;
    }

    @Nullable
    public final Double getLat() {
        return this.lat;
    }

    @Nullable
    public final Double getLng() {
        return this.lng;
    }

    public final int getMinRunDis() {
        return this.minRunDis;
    }

    public final int getMoreTargetDistance() {
        return this.moreTargetDistance;
    }

    public final int getNfcPauseDuration() {
        return this.nfcPauseDuration;
    }

    public final int getRunDistanceMode() {
        return this.runDistanceMode;
    }

    @Nullable
    public final String getRunPlanCode() {
        return this.runPlanCode;
    }

    public final int getRunScene() {
        return this.runScene;
    }

    @NotNull
    public final String getSchoolCode() {
        return this.schoolCode;
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

    @Nullable
    public final String getSemesterCode() {
        return this.semesterCode;
    }

    public final int getSportType() {
        return this.sportType;
    }

    @Nullable
    public final StartRunEntity getStartRunEntity() {
        return this.startRunEntity;
    }

    @NotNull
    public final String getSubSchoolCode() {
        return this.subSchoolCode;
    }

    public final boolean getUseCreditSword() {
        return this.useCreditSword;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    public int hashCode() {
        GeoFenceDetail geoFenceDetail = this.geoFenceDetail;
        int iHashCode = (((((geoFenceDetail == null ? 0 : geoFenceDetail.hashCode()) * 31) + Integer.hashCode(this.runDistanceMode)) * 31) + Integer.hashCode(this.moreTargetDistance)) * 31;
        StartRunEntity startRunEntity = this.startRunEntity;
        int iHashCode2 = (((((iHashCode + (startRunEntity == null ? 0 : startRunEntity.hashCode())) * 31) + Float.hashCode(this.segmentStrideAvg)) * 31) + Integer.hashCode(this.segmentStrideExceptionNum)) * 31;
        boolean z = this.useCreditSword;
        ?? r2 = z;
        if (z) {
            r2 = 1;
        }
        int iHashCode3 = (((iHashCode2 + r2) * 31) + Integer.hashCode(this.amapGPSLevel)) * 31;
        SchoolRule schoolRule = this.schoolRule;
        int iHashCode4 = (iHashCode3 + (schoolRule == null ? 0 : schoolRule.hashCode())) * 31;
        String str = this.semesterCode;
        return ((((((((((iHashCode4 + (str != null ? str.hashCode() : 0)) * 31) + this.faceCheckData.hashCode()) * 31) + this.cheatResult.hashCode()) * 31) + Integer.hashCode(this.sportType)) * 31) + Integer.hashCode(this.runScene)) * 31) + Integer.hashCode(this.nfcPauseDuration);
    }

    public final void setActivityCode(@Nullable String str) {
        this.activityCode = str;
    }

    public final void setAmapGPSLevel(int i) {
        this.amapGPSLevel = i;
    }

    public final void setCheatResult(@NotNull Map<Integer, CheatResult> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.cheatResult = map;
    }

    public final void setFaceCheckData(@NotNull SunshineRunFaceCheckData sunshineRunFaceCheckData) {
        Intrinsics.checkNotNullParameter(sunshineRunFaceCheckData, "<set-?>");
        this.faceCheckData = sunshineRunFaceCheckData;
    }

    public final void setFaceEnabled(int i) {
        this.faceEnabled = i;
    }

    public final void setFenceCode(@Nullable String str) {
        this.fenceCode = str;
    }

    public final void setGeoFenceDetail(@Nullable GeoFenceDetail geoFenceDetail) {
        this.geoFenceDetail = geoFenceDetail;
    }

    public final void setLat(@Nullable Double d) {
        this.lat = d;
    }

    public final void setLng(@Nullable Double d) {
        this.lng = d;
    }

    public final void setMinRunDis(int i) {
        this.minRunDis = i;
    }

    public final void setMoreTargetDistance(int i) {
        this.moreTargetDistance = i;
    }

    public final void setNfcPauseDuration(int i) {
        this.nfcPauseDuration = i;
    }

    public final void setRunDistanceMode(int i) {
        this.runDistanceMode = i;
    }

    public final void setRunPlanCode(@Nullable String str) {
        this.runPlanCode = str;
    }

    public final void setRunScene(int i) {
        this.runScene = i;
    }

    public final void setSchoolCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolCode = str;
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

    public final void setSemesterCode(@Nullable String str) {
        this.semesterCode = str;
    }

    public final void setSportType(int i) {
        this.sportType = i;
    }

    public final void setStartRunEntity(@Nullable StartRunEntity startRunEntity) {
        this.startRunEntity = startRunEntity;
    }

    public final void setSubSchoolCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subSchoolCode = str;
    }

    public final void setUseCreditSword(boolean z) {
        this.useCreditSword = z;
    }

    @NotNull
    public String toString() {
        return "StartRunPageParam(geoFenceDetail=" + this.geoFenceDetail + ", runDistanceMode=" + this.runDistanceMode + ", moreTargetDistance=" + this.moreTargetDistance + ", startRunEntity=" + this.startRunEntity + ", segmentStrideAvg=" + this.segmentStrideAvg + ", segmentStrideExceptionNum=" + this.segmentStrideExceptionNum + ", useCreditSword=" + this.useCreditSword + ", amapGPSLevel=" + this.amapGPSLevel + ", schoolRule=" + this.schoolRule + ", semesterCode=" + this.semesterCode + ", faceCheckData=" + this.faceCheckData + ", cheatResult=" + this.cheatResult + ", sportType=" + this.sportType + ", runScene=" + this.runScene + ", nfcPauseDuration=" + this.nfcPauseDuration + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.geoFenceDetail, flags);
        parcel.writeInt(this.runDistanceMode);
        parcel.writeInt(this.moreTargetDistance);
        parcel.writeParcelable(this.startRunEntity, flags);
        parcel.writeFloat(this.segmentStrideAvg);
        parcel.writeInt(this.segmentStrideExceptionNum);
        parcel.writeInt(this.useCreditSword ? 1 : 0);
        parcel.writeInt(this.amapGPSLevel);
        parcel.writeParcelable(this.schoolRule, flags);
        parcel.writeString(this.semesterCode);
        this.faceCheckData.writeToParcel(parcel, flags);
        Map<Integer, CheatResult> map = this.cheatResult;
        parcel.writeInt(map.size());
        for (Map.Entry<Integer, CheatResult> entry : map.entrySet()) {
            parcel.writeInt(entry.getKey().intValue());
            entry.getValue().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.sportType);
        parcel.writeInt(this.runScene);
        parcel.writeInt(this.nfcPauseDuration);
    }

    public /* synthetic */ StartRunPageParam(GeoFenceDetail geoFenceDetail, int i, int i2, StartRunEntity startRunEntity, float f, int i3, boolean z, int i4, SchoolRule schoolRule, String str, SunshineRunFaceCheckData sunshineRunFaceCheckData, Map map, int i5, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? null : geoFenceDetail, (i8 & 2) != 0 ? 0 : i, (i8 & 4) != 0 ? 0 : i2, (i8 & 8) != 0 ? null : startRunEntity, (i8 & 16) != 0 ? Float.MAX_VALUE : f, (i8 & 32) != 0 ? Integer.MAX_VALUE : i3, (i8 & 64) != 0 ? false : z, (i8 & 128) != 0 ? 3 : i4, (i8 & 256) == 0 ? schoolRule : null, (i8 & 512) != 0 ? "" : str, (i8 & 1024) != 0 ? new SunshineRunFaceCheckData(false, null, 0, 0, false, 0, 0, null, 0, 0L, 0L, 0L, 4095, null) : sunshineRunFaceCheckData, (i8 & 2048) != 0 ? MapsKt.emptyMap() : map, (i8 & 4096) != 0 ? 1 : i5, (i8 & 8192) == 0 ? i6 : 0, (i8 & 16384) != 0 ? 30 : i7);
    }
}
