package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.zj.adlib.bt8;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ShapeStroke implements ContentModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f23372a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.airbnb.lottie.model.animatable.a f506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final b f507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LineCapType f509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LineJoinType f510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<b> f512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f513a;
    public final b b;

    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.f23373a[ordinal()];
            if (i != 1) {
                return i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23373a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            f23373a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23373a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23373a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable b bVar, List<b> list, com.airbnb.lottie.model.animatable.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f, boolean z) {
        this.f511a = str;
        this.f507a = bVar;
        this.f512a = list;
        this.f506a = aVar;
        this.f508a = dVar;
        this.b = bVar2;
        this.f509a = lineCapType;
        this.f510a = lineJoinType;
        this.f23372a = f;
        this.f513a = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content a(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        return new bt8(lottieDrawable, baseLayer, this);
    }

    public LineCapType b() {
        return this.f509a;
    }

    public com.airbnb.lottie.model.animatable.a c() {
        return this.f506a;
    }

    public b d() {
        return this.f507a;
    }

    public LineJoinType e() {
        return this.f510a;
    }

    public List<b> f() {
        return this.f512a;
    }

    public float g() {
        return this.f23372a;
    }

    public String h() {
        return this.f511a;
    }

    public d i() {
        return this.f508a;
    }

    public b j() {
        return this.b;
    }

    public boolean k() {
        return this.f513a;
    }
}
