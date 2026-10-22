package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e extends RecyclerView {
    private boolean YH;
    private boolean YI;
    private boolean YJ;
    private boolean YK;

    public e(Context context) {
        this(context, null);
    }

    private void sR() {
        if (Build.MANUFACTURER.toLowerCase(Locale.US).contains("meitu")) {
            return;
        }
        setVerticalFadingEdgeEnabled(this.YH || this.YI);
        setHorizontalFadingEdgeEnabled(this.YJ || this.YK);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.YI) {
            return super.getBottomFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.YJ) {
            return super.getLeftFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.YK) {
            return super.getRightFadingEdgeStrength();
        }
        return 0.0f;
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.YH) {
            return super.getTopFadingEdgeStrength();
        }
        return 0.0f;
    }

    public void setEnableBottomFadingEdge(boolean z) {
        this.YI = z;
    }

    public void setEnableLeftFadingEdge(boolean z) {
        this.YJ = z;
    }

    public void setEnableRightFadingEdge(boolean z) {
        this.YK = z;
    }

    public void setEnableTopFadingEdge(boolean z) {
        this.YH = z;
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_CustomFadeEdgeRecyclerView);
        this.YH = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_CustomFadeEdgeRecyclerView_ksad_cerv_enableTopFadingEdge, false);
        this.YI = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_CustomFadeEdgeRecyclerView_ksad_cerv_enableBottomFadingEdge, false);
        this.YJ = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_CustomFadeEdgeRecyclerView_ksad_cerv_enableLeftFadingEdge, false);
        this.YK = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_CustomFadeEdgeRecyclerView_ksad_cerv_enableRightFadingEdge, false);
        typedArrayObtainStyledAttributes.recycle();
        sR();
    }

    public e(Context context, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        super(context, null, 0);
        this.YH = bool == null ? false : bool.booleanValue();
        this.YI = bool2 == null ? false : bool2.booleanValue();
        this.YJ = bool3 == null ? false : bool3.booleanValue();
        this.YK = bool4 != null ? bool4.booleanValue() : false;
        sR();
    }
}
