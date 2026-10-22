package com.zj.adlib;

import android.content.Context;
import com.alibaba.ariver.remotedebug.b.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u001d\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0012R\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/zj/adlib/dv6;", "", "Lcom/zj/adlib/fv6;", "person", "", "Lkotlin/Pair;", "", "", "a", "", "b", "Lorg/tensorflow/lite/a;", "Lorg/tensorflow/lite/a;", "interpreter", "Ljava/util/List;", "labels", "", "kotlin.jvm.PlatformType", "[I", com.alibaba.triver.triver_render.view.input.a.f25238a, c.g, "<init>", "(Lorg/tensorflow/lite/a;Ljava/util/List;)V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
public final class dv6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41281a = 4;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f16092a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f16093a = "classifier.tflite";

    @NotNull
    public static final String b = "labels.txt";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final List<String> labels;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final org.tensorflow.lite.a interpreter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public final int[] input;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    public final int[] output;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/dv6$a;", "", "Landroid/content/Context;", "context", "Lcom/zj/adlib/dv6;", "a", "", "CPU_NUM_THREADS", "I", "", "LABELS_FILENAME", "Ljava/lang/String;", "MODEL_FILENAME", "<init>", "()V", "pose_estimation_release"}, k = 1, mv = {1, 7, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final dv6 a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            org.tensorflow.lite.a.a aVar = new org.tensorflow.lite.a.a();
            aVar.v(4);
            org.tensorflow.lite.a aVar2 = new org.tensorflow.lite.a(ig3.f(context, dv6.f16093a), aVar);
            List listB = ig3.b(context, "labels.txt");
            Intrinsics.checkNotNullExpressionValue(listB, "loadLabels(context, LABELS_FILENAME)");
            return new dv6(aVar2, listB);
        }
    }

    public dv6(@NotNull org.tensorflow.lite.a aVar, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(aVar, "interpreter");
        Intrinsics.checkNotNullParameter(list, "labels");
        this.interpreter = aVar;
        this.labels = list;
        this.input = aVar.c0(0).i();
        this.output = aVar.p0(0).i();
    }

    @NotNull
    public final List<Pair<String, Float>> a(@Nullable PoseEstimationResult person) {
        List<KeyPoint> listQ;
        float[] fArr = new float[this.input[1]];
        int i = 0;
        if (person != null && (listQ = person.q()) != null) {
            int i2 = 0;
            for (Object obj : listQ) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KeyPoint keyPoint = (KeyPoint) obj;
                int i4 = i2 * 3;
                fArr[i4] = keyPoint.g().y;
                fArr[i4 + 1] = keyPoint.g().x;
                fArr[i4 + 2] = keyPoint.h();
                i2 = i3;
            }
        }
        int i5 = this.output[1];
        float[] fArr2 = new float[i5];
        this.interpreter.G(new float[][]{fArr}, new float[][]{fArr2});
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        while (i < i5) {
            arrayList.add(new Pair(this.labels.get(i6), Float.valueOf(fArr2[i])));
            i++;
            i6++;
        }
        return arrayList;
    }

    public final void b() {
        this.interpreter.close();
    }
}
