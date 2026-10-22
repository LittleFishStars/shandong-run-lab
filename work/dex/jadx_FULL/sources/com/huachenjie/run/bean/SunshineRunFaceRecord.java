package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.profileinstaller.ProfileVerifier;
import com.huachenjie.base.widget.OperatePopupWindow;
import com.zj.adlib.q47;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Parcelize
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u001aJ\t\u0010K\u001a\u00020\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010N\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010O\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u0010\u0010X\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010Y\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\"J\u0010\u0010Z\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010)J\u0010\u0010[\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010)J\t\u0010\\\u001a\u00020\u0006HÆ\u0003JÜ\u0001\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010^J\t\u0010_\u001a\u00020\u0003HÖ\u0001J\u0013\u0010`\u001a\u00020\u00062\b\u0010a\u001a\u0004\u0018\u00010bHÖ\u0003J\t\u0010c\u001a\u00020\u0003HÖ\u0001J\t\u0010d\u001a\u00020\u0010HÖ\u0001J\u0019\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001e\u0010\n\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001e\u0010\r\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001c\"\u0004\b5\u0010\u001eR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001c\"\u0004\b7\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u001c\"\u0004\b9\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010'R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bE\u00100\"\u0004\bF\u00102R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010;\"\u0004\bJ\u0010=¨\u0006j"}, d2 = {"Lcom/huachenjie/run/bean/SunshineRunFaceRecord;", "Landroid/os/Parcelable;", "checkIndex", "", "randomDistance", "hasChecked", "", "finishFaceCheck", "popTime", "", "checkDistance", "checkLng", "", "checkLat", "runFaceUpload", "runFaceImg", "", "confidence", "", "rate", "label", "faceRequestId", "bodyRequestId", "faceCheckErrorCode", "bodyCheckErrorCode", q47.f19000b, "(IIZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBodyCheckErrorCode", "()Ljava/lang/String;", "setBodyCheckErrorCode", "(Ljava/lang/String;)V", "getBodyRequestId", "setBodyRequestId", "getCheckDistance", "()Ljava/lang/Long;", "setCheckDistance", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCheckIndex", "()I", "getCheckLat", "()Ljava/lang/Double;", "setCheckLat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getCheckLng", "setCheckLng", "getConfidence", "()Ljava/lang/Float;", "setConfidence", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getExtendParam", "setExtendParam", "getFaceCheckErrorCode", "setFaceCheckErrorCode", "getFaceRequestId", "setFaceRequestId", "getFinishFaceCheck", "()Z", "setFinishFaceCheck", "(Z)V", "getHasChecked", "setHasChecked", "getLabel", "setLabel", "getPopTime", "setPopTime", "getRandomDistance", "getRate", "setRate", "getRunFaceImg", "setRunFaceImg", "getRunFaceUpload", "setRunFaceUpload", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", OperatePopupWindow.g, "(IIZZLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Double;Ljava/lang/Double;ZLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/huachenjie/run/bean/SunshineRunFaceRecord;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "run_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SunshineRunFaceRecord implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<SunshineRunFaceRecord> CREATOR = new Creator();

    @Nullable
    private String bodyCheckErrorCode;

    @Nullable
    private String bodyRequestId;

    @Nullable
    private Long checkDistance;
    private final int checkIndex;

    @Nullable
    private Double checkLat;

    @Nullable
    private Double checkLng;

    @Nullable
    private Float confidence;

    @Nullable
    private String extendParam;

    @Nullable
    private String faceCheckErrorCode;

    @Nullable
    private String faceRequestId;
    private boolean finishFaceCheck;
    private boolean hasChecked;

    @Nullable
    private String label;

    @Nullable
    private Long popTime;
    private final int randomDistance;

    @Nullable
    private Float rate;

    @Nullable
    private String runFaceImg;
    private boolean runFaceUpload;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SunshineRunFaceRecord> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFaceRecord createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SunshineRunFaceRecord(parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() == 0 ? null : Double.valueOf(parcel.readDouble()), parcel.readInt() != 0, parcel.readString(), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SunshineRunFaceRecord[] newArray(int i) {
            return new SunshineRunFaceRecord[i];
        }
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i) {
        this(i, 0, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 262142, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2) {
        this(i, i2, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 262140, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z) {
        this(i, i2, z, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 262136, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2) {
        this(i, i2, z, z2, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 262128, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l) {
        this(i, i2, z, z2, l, null, null, null, false, null, null, null, null, null, null, null, null, null, 262112, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2) {
        this(i, i2, z, z2, l, l2, null, null, false, null, null, null, null, null, null, null, null, null, 262080, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d) {
        this(i, i2, z, z2, l, l2, d, null, false, null, null, null, null, null, null, null, null, null, 262016, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2) {
        this(i, i2, z, z2, l, l2, d, d2, false, null, null, null, null, null, null, null, null, null, 261888, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3) {
        this(i, i2, z, z2, l, l2, d, d2, z3, null, null, null, null, null, null, null, null, null, 261632, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, null, null, null, null, null, null, null, null, 261120, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, null, null, null, null, null, null, null, 260096, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, null, null, null, null, null, null, 258048, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, str2, null, null, null, null, null, 253952, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2, @Nullable String str3) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, str2, str3, null, null, null, null, 245760, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, str2, str3, str4, null, null, null, 229376, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, str2, str3, str4, str5, null, null, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this(i, i2, z, z2, l, l2, d, d2, z3, str, f, f2, str2, str3, str4, str5, str6, null, 131072, null);
    }

    @JvmOverloads
    public SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, @Nullable Long l, @Nullable Long l2, @Nullable Double d, @Nullable Double d2, boolean z3, @Nullable String str, @Nullable Float f, @Nullable Float f2, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.checkIndex = i;
        this.randomDistance = i2;
        this.hasChecked = z;
        this.finishFaceCheck = z2;
        this.popTime = l;
        this.checkDistance = l2;
        this.checkLng = d;
        this.checkLat = d2;
        this.runFaceUpload = z3;
        this.runFaceImg = str;
        this.confidence = f;
        this.rate = f2;
        this.label = str2;
        this.faceRequestId = str3;
        this.bodyRequestId = str4;
        this.faceCheckErrorCode = str5;
        this.bodyCheckErrorCode = str6;
        this.extendParam = str7;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCheckIndex() {
        return this.checkIndex;
    }

    @Nullable
    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRunFaceImg() {
        return this.runFaceImg;
    }

    @Nullable
    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Float getConfidence() {
        return this.confidence;
    }

    @Nullable
    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Float getRate() {
        return this.rate;
    }

    @Nullable
    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFaceRequestId() {
        return this.faceRequestId;
    }

    @Nullable
    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getBodyRequestId() {
        return this.bodyRequestId;
    }

    @Nullable
    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getFaceCheckErrorCode() {
        return this.faceCheckErrorCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getBodyCheckErrorCode() {
        return this.bodyCheckErrorCode;
    }

    @Nullable
    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getExtendParam() {
        return this.extendParam;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getRandomDistance() {
        return this.randomDistance;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getHasChecked() {
        return this.hasChecked;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getFinishFaceCheck() {
        return this.finishFaceCheck;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getPopTime() {
        return this.popTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getCheckDistance() {
        return this.checkDistance;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Double getCheckLng() {
        return this.checkLng;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Double getCheckLat() {
        return this.checkLat;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getRunFaceUpload() {
        return this.runFaceUpload;
    }

    @NotNull
    public final SunshineRunFaceRecord copy(int checkIndex, int randomDistance, boolean hasChecked, boolean finishFaceCheck, @Nullable Long popTime, @Nullable Long checkDistance, @Nullable Double checkLng, @Nullable Double checkLat, boolean runFaceUpload, @Nullable String runFaceImg, @Nullable Float confidence, @Nullable Float rate, @Nullable String label, @Nullable String faceRequestId, @Nullable String bodyRequestId, @Nullable String faceCheckErrorCode, @Nullable String bodyCheckErrorCode, @Nullable String extendParam) {
        return new SunshineRunFaceRecord(checkIndex, randomDistance, hasChecked, finishFaceCheck, popTime, checkDistance, checkLng, checkLat, runFaceUpload, runFaceImg, confidence, rate, label, faceRequestId, bodyRequestId, faceCheckErrorCode, bodyCheckErrorCode, extendParam);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SunshineRunFaceRecord)) {
            return false;
        }
        SunshineRunFaceRecord sunshineRunFaceRecord = (SunshineRunFaceRecord) other;
        return this.checkIndex == sunshineRunFaceRecord.checkIndex && this.randomDistance == sunshineRunFaceRecord.randomDistance && this.hasChecked == sunshineRunFaceRecord.hasChecked && this.finishFaceCheck == sunshineRunFaceRecord.finishFaceCheck && Intrinsics.areEqual(this.popTime, sunshineRunFaceRecord.popTime) && Intrinsics.areEqual(this.checkDistance, sunshineRunFaceRecord.checkDistance) && Intrinsics.areEqual(this.checkLng, sunshineRunFaceRecord.checkLng) && Intrinsics.areEqual(this.checkLat, sunshineRunFaceRecord.checkLat) && this.runFaceUpload == sunshineRunFaceRecord.runFaceUpload && Intrinsics.areEqual(this.runFaceImg, sunshineRunFaceRecord.runFaceImg) && Intrinsics.areEqual(this.confidence, sunshineRunFaceRecord.confidence) && Intrinsics.areEqual(this.rate, sunshineRunFaceRecord.rate) && Intrinsics.areEqual(this.label, sunshineRunFaceRecord.label) && Intrinsics.areEqual(this.faceRequestId, sunshineRunFaceRecord.faceRequestId) && Intrinsics.areEqual(this.bodyRequestId, sunshineRunFaceRecord.bodyRequestId) && Intrinsics.areEqual(this.faceCheckErrorCode, sunshineRunFaceRecord.faceCheckErrorCode) && Intrinsics.areEqual(this.bodyCheckErrorCode, sunshineRunFaceRecord.bodyCheckErrorCode) && Intrinsics.areEqual(this.extendParam, sunshineRunFaceRecord.extendParam);
    }

    @Nullable
    public final String getBodyCheckErrorCode() {
        return this.bodyCheckErrorCode;
    }

    @Nullable
    public final String getBodyRequestId() {
        return this.bodyRequestId;
    }

    @Nullable
    public final Long getCheckDistance() {
        return this.checkDistance;
    }

    public final int getCheckIndex() {
        return this.checkIndex;
    }

    @Nullable
    public final Double getCheckLat() {
        return this.checkLat;
    }

    @Nullable
    public final Double getCheckLng() {
        return this.checkLng;
    }

    @Nullable
    public final Float getConfidence() {
        return this.confidence;
    }

    @Nullable
    public final String getExtendParam() {
        return this.extendParam;
    }

    @Nullable
    public final String getFaceCheckErrorCode() {
        return this.faceCheckErrorCode;
    }

    @Nullable
    public final String getFaceRequestId() {
        return this.faceRequestId;
    }

    public final boolean getFinishFaceCheck() {
        return this.finishFaceCheck;
    }

    public final boolean getHasChecked() {
        return this.hasChecked;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final Long getPopTime() {
        return this.popTime;
    }

    public final int getRandomDistance() {
        return this.randomDistance;
    }

    @Nullable
    public final Float getRate() {
        return this.rate;
    }

    @Nullable
    public final String getRunFaceImg() {
        return this.runFaceImg;
    }

    public final boolean getRunFaceUpload() {
        return this.runFaceUpload;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v58 */
    /* JADX WARN: Type inference failed for: r1v59 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.checkIndex) * 31) + Integer.hashCode(this.randomDistance)) * 31;
        boolean z = this.hasChecked;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z2 = this.finishFaceCheck;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        Long l = this.popTime;
        int iHashCode2 = (i2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.checkDistance;
        int iHashCode3 = (iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Double d = this.checkLng;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Double d2 = this.checkLat;
        int iHashCode5 = (iHashCode4 + (d2 == null ? 0 : d2.hashCode())) * 31;
        boolean z3 = this.runFaceUpload;
        int i3 = (iHashCode5 + (z3 ? 1 : z3)) * 31;
        String str = this.runFaceImg;
        int iHashCode6 = (i3 + (str == null ? 0 : str.hashCode())) * 31;
        Float f = this.confidence;
        int iHashCode7 = (iHashCode6 + (f == null ? 0 : f.hashCode())) * 31;
        Float f2 = this.rate;
        int iHashCode8 = (iHashCode7 + (f2 == null ? 0 : f2.hashCode())) * 31;
        String str2 = this.label;
        int iHashCode9 = (iHashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.faceRequestId;
        int iHashCode10 = (iHashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.bodyRequestId;
        int iHashCode11 = (iHashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.faceCheckErrorCode;
        int iHashCode12 = (iHashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.bodyCheckErrorCode;
        int iHashCode13 = (iHashCode12 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.extendParam;
        return iHashCode13 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setBodyCheckErrorCode(@Nullable String str) {
        this.bodyCheckErrorCode = str;
    }

    public final void setBodyRequestId(@Nullable String str) {
        this.bodyRequestId = str;
    }

    public final void setCheckDistance(@Nullable Long l) {
        this.checkDistance = l;
    }

    public final void setCheckLat(@Nullable Double d) {
        this.checkLat = d;
    }

    public final void setCheckLng(@Nullable Double d) {
        this.checkLng = d;
    }

    public final void setConfidence(@Nullable Float f) {
        this.confidence = f;
    }

    public final void setExtendParam(@Nullable String str) {
        this.extendParam = str;
    }

    public final void setFaceCheckErrorCode(@Nullable String str) {
        this.faceCheckErrorCode = str;
    }

    public final void setFaceRequestId(@Nullable String str) {
        this.faceRequestId = str;
    }

    public final void setFinishFaceCheck(boolean z) {
        this.finishFaceCheck = z;
    }

    public final void setHasChecked(boolean z) {
        this.hasChecked = z;
    }

    public final void setLabel(@Nullable String str) {
        this.label = str;
    }

    public final void setPopTime(@Nullable Long l) {
        this.popTime = l;
    }

    public final void setRate(@Nullable Float f) {
        this.rate = f;
    }

    public final void setRunFaceImg(@Nullable String str) {
        this.runFaceImg = str;
    }

    public final void setRunFaceUpload(boolean z) {
        this.runFaceUpload = z;
    }

    @NotNull
    public String toString() {
        return "SunshineRunFaceRecord(checkIndex=" + this.checkIndex + ", randomDistance=" + this.randomDistance + ", hasChecked=" + this.hasChecked + ", finishFaceCheck=" + this.finishFaceCheck + ", popTime=" + this.popTime + ", checkDistance=" + this.checkDistance + ", checkLng=" + this.checkLng + ", checkLat=" + this.checkLat + ", runFaceUpload=" + this.runFaceUpload + ", runFaceImg=" + this.runFaceImg + ", confidence=" + this.confidence + ", rate=" + this.rate + ", label=" + this.label + ", faceRequestId=" + this.faceRequestId + ", bodyRequestId=" + this.bodyRequestId + ", faceCheckErrorCode=" + this.faceCheckErrorCode + ", bodyCheckErrorCode=" + this.bodyCheckErrorCode + ", extendParam=" + this.extendParam + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.checkIndex);
        parcel.writeInt(this.randomDistance);
        parcel.writeInt(this.hasChecked ? 1 : 0);
        parcel.writeInt(this.finishFaceCheck ? 1 : 0);
        Long l = this.popTime;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        Long l2 = this.checkDistance;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Double d = this.checkLng;
        if (d == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d.doubleValue());
        }
        Double d2 = this.checkLat;
        if (d2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
        }
        parcel.writeInt(this.runFaceUpload ? 1 : 0);
        parcel.writeString(this.runFaceImg);
        Float f = this.confidence;
        if (f == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f.floatValue());
        }
        Float f2 = this.rate;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeString(this.label);
        parcel.writeString(this.faceRequestId);
        parcel.writeString(this.bodyRequestId);
        parcel.writeString(this.faceCheckErrorCode);
        parcel.writeString(this.bodyCheckErrorCode);
        parcel.writeString(this.extendParam);
    }

    public /* synthetic */ SunshineRunFaceRecord(int i, int i2, boolean z, boolean z2, Long l, Long l2, Double d, Double d2, boolean z3, String str, Float f, Float f2, String str2, String str3, String str4, String str5, String str6, String str7, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? false : z, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? null : l, (i3 & 32) != 0 ? null : l2, (i3 & 64) != 0 ? null : d, (i3 & 128) != 0 ? null : d2, (i3 & 256) == 0 ? z3 : false, (i3 & 512) != 0 ? null : str, (i3 & 1024) != 0 ? null : f, (i3 & 2048) != 0 ? null : f2, (i3 & 4096) != 0 ? null : str2, (i3 & 8192) != 0 ? null : str3, (i3 & 16384) != 0 ? null : str4, (i3 & 32768) != 0 ? null : str5, (i3 & 65536) != 0 ? null : str6, (i3 & 131072) == 0 ? str7 : null);
    }
}
