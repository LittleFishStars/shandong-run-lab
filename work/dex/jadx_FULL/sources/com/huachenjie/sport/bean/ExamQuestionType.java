package com.huachenjie.sport.bean;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/sport/bean/ExamQuestionType;", "", "type", "", "showName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getShowName", "()Ljava/lang/String;", "getType", "()I", "Single", "Multiple", "TrueOrFalse", "Companion", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum ExamQuestionType {
    Single(100, "单选题"),
    Multiple(200, "多选题"),
    TrueOrFalse(300, "判断题");


    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static Map<Integer, ExamQuestionType> id2object;

    @NotNull
    private final String showName;
    private final int type;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/bean/ExamQuestionType$Companion;", "", "()V", "id2object", "", "", "Lcom/huachenjie/sport/bean/ExamQuestionType;", "id2Object", "type", "(Ljava/lang/Integer;)Lcom/huachenjie/sport/bean/ExamQuestionType;", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ExamQuestionType id2Object(@Nullable Integer type) {
            Map map;
            if (ExamQuestionType.id2object == null) {
                ExamQuestionType.id2object = new HashMap();
            }
            ExamQuestionType[] examQuestionTypeArrValues = ExamQuestionType.values();
            int length = examQuestionTypeArrValues.length;
            int i = 0;
            while (true) {
                map = null;
                if (i >= length) {
                    break;
                }
                ExamQuestionType examQuestionType = examQuestionTypeArrValues[i];
                Map map2 = ExamQuestionType.id2object;
                if (map2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("id2object");
                } else {
                    map = map2;
                }
                map.put(Integer.valueOf(examQuestionType.getType()), examQuestionType);
                i++;
            }
            Map map3 = ExamQuestionType.id2object;
            if (map3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("id2object");
            } else {
                map = map3;
            }
            ExamQuestionType examQuestionType2 = (ExamQuestionType) map.get(type);
            return examQuestionType2 == null ? ExamQuestionType.Single : examQuestionType2;
        }
    }

    ExamQuestionType(int i, String str) {
        this.type = i;
        this.showName = str;
    }

    @NotNull
    public final String getShowName() {
        return this.showName;
    }

    public final int getType() {
        return this.type;
    }
}
