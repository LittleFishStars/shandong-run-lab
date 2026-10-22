package com.alibaba.triver.embed.video.fullscreenvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f24834a = "JZResizeTextureView";
    public int b;
    public int c;

    public TBMiniAppTextureView(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
    }

    public void a(int i, int i2) {
        if (this.b == i && this.c == i2) {
            return;
        }
        this.b = i;
        this.c = i2;
        requestLayout();
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0142  */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        RVLogger.d(f24834a, "onMeasure  [" + hashCode() + "] ");
        int rotation = (int) getRotation();
        int i7 = this.b;
        int i8 = this.c;
        int measuredHeight = ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i7 != 0 && i8 != 0 && TBMiniAppVideo.F == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i8 = (i7 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        int defaultSize = View.getDefaultSize(i7, i4);
        int defaultSize2 = View.getDefaultSize(i8, i3);
        if (i7 > 0 && i8 > 0) {
            int mode = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            RVLogger.d(f24834a, "widthMeasureSpec  [" + View.MeasureSpec.toString(i4) + "]");
            RVLogger.d(f24834a, "heightMeasureSpec [" + View.MeasureSpec.toString(i3) + "]");
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i9 = i7 * size2;
                int i10 = size * i8;
                if (i9 < i10) {
                    defaultSize = i9 / i8;
                } else if (i9 > i10) {
                    i6 = i10 / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                i6 = (size * i8) / i7;
                if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                    defaultSize = size;
                    defaultSize2 = i6;
                } else {
                    defaultSize = (size2 * i7) / i8;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                i5 = (size2 * i7) / i8;
                if (mode == Integer.MIN_VALUE && i5 > size) {
                    i6 = (size * i8) / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                }
                defaultSize = i5;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    i5 = i7;
                    size2 = i8;
                } else {
                    i5 = (size2 * i7) / i8;
                }
                if (mode == Integer.MIN_VALUE && i5 > size) {
                    i6 = (size * i8) / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                }
                defaultSize = i5;
                defaultSize2 = size2;
            }
        }
        if (measuredWidth == 0 || measuredHeight == 0 || i7 == 0 || i8 == 0) {
            i7 = defaultSize;
            i8 = defaultSize2;
        } else {
            int i11 = TBMiniAppVideo.F;
            if (i11 != 3) {
                if (i11 != 2) {
                    i7 = defaultSize;
                    i8 = defaultSize2;
                } else {
                    if (rotation == 90 || rotation == 270) {
                        int i12 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i12;
                    }
                    double d = ((double) i8) / ((double) i7);
                    double d2 = measuredHeight;
                    double d3 = measuredWidth;
                    double d4 = d2 / d3;
                    if (d > d4) {
                        i8 = (int) ((d3 / ((double) defaultSize)) * ((double) defaultSize2));
                        i7 = measuredWidth;
                    } else if (d < d4) {
                        i7 = (int) ((d2 / ((double) defaultSize2)) * ((double) defaultSize));
                        i8 = measuredHeight;
                    } else {
                        i7 = defaultSize;
                        i8 = defaultSize2;
                    }
                }
            }
        }
        setMeasuredDimension(i7, i8);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public TBMiniAppTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }
}
