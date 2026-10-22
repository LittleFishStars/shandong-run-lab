package com.huachenjie.sport.bean;

import com.huachenjie.sport.R;
import com.zj.adlib.zn1;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'NotStart' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/sport/bean/ExamStatus;", "", "type", "", "showName", "", "buttonColor", "triangleRes", "(Ljava/lang/String;IILjava/lang/String;II)V", "getButtonColor", "()I", "getShowName", "()Ljava/lang/String;", "getTriangleRes", "getType", "NotStart", "InExam", "ExamOver", "Companion", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamStatus {
    private static final /* synthetic */ ExamStatus[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final ExamStatus ExamOver;
    public static final ExamStatus InExam;
    public static final ExamStatus NotStart;
    private static Map<Integer, ExamStatus> id2object;
    private final int buttonColor;

    @NotNull
    private final String showName;
    private final int triangleRes;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/bean/ExamStatus$Companion;", "", "()V", "id2object", "", "", "Lcom/huachenjie/sport/bean/ExamStatus;", "id2Object", "type", "(Ljava/lang/Integer;)Lcom/huachenjie/sport/bean/ExamStatus;", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExamStatus id2Object(@Nullable Integer type) {
            Map map;
            if (ExamStatus.id2object == null) {
                ExamStatus.id2object = new HashMap();
            }
            ExamStatus[] examStatusArrValues = ExamStatus.values();
            int length = examStatusArrValues.length;
            int i = 0;
            while (true) {
                map = null;
                if (i >= length) {
                    break;
                }
                ExamStatus examStatus = examStatusArrValues[i];
                Map map2 = ExamStatus.id2object;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id2object");
                } else {
                    map = map2;
                }
                map.put(Integer.valueOf(examStatus.getType()), examStatus);
                i++;
            }
            Map map3 = ExamStatus.id2object;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("id2object");
            } else {
                map = map3;
            }
            ExamStatus examStatus2 = (ExamStatus) map.get(type);
            return examStatus2 == null ? ExamStatus.NotStart : examStatus2;
        }
    }

    private static final /* synthetic */ ExamStatus[] $values() {
        return new ExamStatus[]{NotStart, InExam, ExamOver};
    }

    static {
        int i = R.color.color_8997A4;
        int iA = zn1.a(i);
        int i2 = R.drawable.ic_exam_gray_triangle;
        NotStart = new ExamStatus("NotStart", 0, 1, "未开始", iA, i2);
        InExam = new ExamStatus("InExam", 1, 2, "考试中", zn1.a(R.color.color_00C97C), R.drawable.ic_exam_green_triangle);
        ExamOver = new ExamStatus("ExamOver", 2, 3, "已结束", zn1.a(i), i2);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    private ExamStatus(String str, int i, int i2, String str2, int i3, int i4) {
        super(str, i);
        this.type = i2;
        this.showName = str2;
        this.buttonColor = i3;
        this.triangleRes = i4;
    }

    public static ExamStatus valueOf(String str) {
        return (ExamStatus) Enum.valueOf(ExamStatus.class, str);
    }

    public static ExamStatus[] values() {
        return (ExamStatus[]) $VALUES.clone();
    }

    public final int getButtonColor() {
        return this.buttonColor;
    }

    @NotNull
    public final String getShowName() {
        return this.showName;
    }

    public final int getTriangleRes() {
        return this.triangleRes;
    }

    public final int getType() {
        return this.type;
    }
}
