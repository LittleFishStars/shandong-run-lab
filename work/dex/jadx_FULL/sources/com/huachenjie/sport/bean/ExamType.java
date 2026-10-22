package com.huachenjie.sport.bean;

import com.huachenjie.sport.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EndOfTerm' uses external variables
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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/bean/ExamType;", "", "type", "", "showName", "", "iconRes", "(Ljava/lang/String;IILjava/lang/String;I)V", "getIconRes", "()I", "getShowName", "()Ljava/lang/String;", "getType", "EndOfTerm", "MakeUp", "PracticeExams", "Companion", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ExamType {
    private static final /* synthetic */ ExamType[] $VALUES;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final ExamType EndOfTerm;
    public static final ExamType MakeUp;
    public static final ExamType PracticeExams;
    private static Map<Integer, ExamType> id2object;
    private final int iconRes;

    @NotNull
    private final String showName;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/bean/ExamType$Companion;", "", "()V", "id2object", "", "", "Lcom/huachenjie/sport/bean/ExamType;", "id2Object", "type", "(Ljava/lang/Integer;)Lcom/huachenjie/sport/bean/ExamType;", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExamType id2Object(@Nullable Integer type) {
            Map map;
            if (ExamType.id2object == null) {
                ExamType.id2object = new HashMap();
            }
            ExamType[] examTypeArrValues = ExamType.values();
            int length = examTypeArrValues.length;
            int i = 0;
            while (true) {
                map = null;
                if (i >= length) {
                    break;
                }
                ExamType examType = examTypeArrValues[i];
                Map map2 = ExamType.id2object;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id2object");
                } else {
                    map = map2;
                }
                map.put(Integer.valueOf(examType.getType()), examType);
                i++;
            }
            Map map3 = ExamType.id2object;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("id2object");
            } else {
                map = map3;
            }
            ExamType examType2 = (ExamType) map.get(type);
            return examType2 == null ? ExamType.EndOfTerm : examType2;
        }
    }

    private static final /* synthetic */ ExamType[] $values() {
        return new ExamType[]{EndOfTerm, MakeUp, PracticeExams};
    }

    static {
        int i = R.drawable.ic_exam_end_of_term;
        EndOfTerm = new ExamType("EndOfTerm", 0, 100, "期末考试", i);
        MakeUp = new ExamType("MakeUp", 1, 200, "补考", R.drawable.ic_exam_make_up);
        PracticeExams = new ExamType("PracticeExams", 2, 300, "模拟考试", i);
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    private ExamType(String str, int i, int i2, String str2, int i3) {
        super(str, i);
        this.type = i2;
        this.showName = str2;
        this.iconRes = i3;
    }

    public static ExamType valueOf(String str) {
        return (ExamType) Enum.valueOf(ExamType.class, str);
    }

    public static ExamType[] values() {
        return (ExamType[]) $VALUES.clone();
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    @NotNull
    public final String getShowName() {
        return this.showName;
    }

    public final int getType() {
        return this.type;
    }
}
