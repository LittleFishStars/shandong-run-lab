package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.zj.adlib.gj9;
import com.zj.adlib.gv8;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SubtitleView extends FrameLayout {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;
    public int K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4943a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaptionStyleCompat f4944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Output f4945a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Cue> f4946a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4947a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4948b;

    public interface Output {
        void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewType {
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f4947a && this.f4948b) {
            return this.f4946a;
        }
        ArrayList arrayList = new ArrayList(this.f4946a.size());
        for (int i = 0; i < this.f4946a.size(); i++) {
            arrayList.add(a(this.f4946a.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (gj9.f41922a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        if (gj9.f41922a < 19 || isInEditMode()) {
            return CaptionStyleCompat.f31056a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? CaptionStyleCompat.f31056a : CaptionStyleCompat.a(captioningManager.getUserStyle());
    }

    private <T extends View & Output> void setView(T t) {
        removeView(this.f4943a);
        View view = this.f4943a;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).f();
        }
        this.f4943a = t;
        this.f4945a = t;
        addView(t);
    }

    public final Cue a(Cue cue) {
        Cue.b bVarB = cue.b();
        if (!this.f4947a) {
            gv8.e(bVarB);
        } else if (!this.f4948b) {
            gv8.f(bVarB);
        }
        return bVarB.a();
    }

    public final void b(int i, float f) {
        this.K = i;
        this.f31076a = f;
        c();
    }

    public final void c() {
        this.f4945a.update(getCuesWithStylingPreferencesApplied(), this.f4944a, this.f31076a, this.K, this.b);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.f4948b = z;
        c();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.f4947a = z;
        c();
    }

    public void setBottomPaddingFraction(float f) {
        this.b = f;
        c();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f4946a = list;
        c();
    }

    public void setFixedTextSize(@Dimension int i, float f) {
        Context context = getContext();
        b(2, TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public void setFractionalTextSize(float f) {
        setFractionalTextSize(f, false);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f4944a = captionStyleCompat;
        c();
    }

    public void setUserDefaultStyle() {
        setStyle(getUserCaptionStyle());
    }

    public void setUserDefaultTextSize() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setViewType(int i) {
        if (this.L == i) {
            return;
        }
        if (i == 1) {
            setView(new CanvasSubtitleOutput(getContext()));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new WebViewSubtitleOutput(getContext()));
        }
        this.L = i;
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4946a = Collections.emptyList();
        this.f4944a = CaptionStyleCompat.f31056a;
        this.K = 0;
        this.f31076a = 0.0533f;
        this.b = 0.08f;
        this.f4947a = true;
        this.f4948b = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.f4945a = canvasSubtitleOutput;
        this.f4943a = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.L = 1;
    }

    public void setFractionalTextSize(float f, boolean z) {
        b(z ? 1 : 0, f);
    }
}
