package com.huachenjie.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class CustomTextureView extends TextureView {
    protected static final String TAG = "CustomTextureView";
    public static int VIDEO_IMAGE_DISPLAY_TYPE = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ADAPTER = 0;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT = 1;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_SCROP = 2;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_FILL_X = 4;
    public static final int VIDEO_IMAGE_DISPLAY_TYPE_ORIGINAL = 3;
    public int currentVideoHeight;
    public int currentVideoWidth;

    public CustomTextureView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        int i3;
        int rotation = (int) getRotation();
        int i4 = this.currentVideoWidth;
        int i5 = this.currentVideoHeight;
        int measuredHeight = ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i4 != 0 && i5 != 0 && VIDEO_IMAGE_DISPLAY_TYPE == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i5 = (i4 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i = widthMeasureSpec;
            i2 = heightMeasureSpec;
        } else {
            i2 = widthMeasureSpec;
            i = heightMeasureSpec;
        }
        int defaultSize = View.getDefaultSize(i4, i2);
        int defaultSize2 = View.getDefaultSize(i5, i);
        if (i4 > 0 && i5 > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i);
            int size2 = View.MeasureSpec.getSize(i);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = i4 * size2;
                int i7 = size * i5;
                if (i6 < i7) {
                    defaultSize = i6 / i5;
                } else if (i6 > i7) {
                    defaultSize2 = i7 / i4;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i8 = (size * i5) / i4;
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    defaultSize2 = i8;
                    defaultSize = size;
                } else {
                    defaultSize = (size2 * i4) / i5;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                i3 = (size2 * i4) / i5;
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (size * i5) / i4;
                    defaultSize = size;
                }
                defaultSize = i3;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i5 <= size2) {
                    i3 = i4;
                    size2 = i5;
                } else {
                    i3 = (size2 * i4) / i5;
                }
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (size * i5) / i4;
                    defaultSize = size;
                }
                defaultSize = i3;
                defaultSize2 = size2;
            }
        }
        if (measuredWidth != 0 && measuredHeight != 0 && i4 != 0 && i5 != 0) {
            int i9 = VIDEO_IMAGE_DISPLAY_TYPE;
            if (i9 == 3) {
                defaultSize = i4;
                defaultSize2 = i5;
            } else if (i9 == 2) {
                if (rotation != 90 && rotation != 270) {
                    int i10 = measuredWidth;
                    measuredWidth = measuredHeight;
                    measuredHeight = i10;
                }
                double d = ((double) i4) / ((double) i5);
                double d2 = measuredHeight;
                double d3 = measuredWidth;
                double d4 = d2 / d3;
                if (d > d4) {
                    int i11 = (int) ((d3 / ((double) defaultSize2)) * ((double) defaultSize));
                    defaultSize2 = measuredWidth;
                    defaultSize = i11;
                    measuredWidth = measuredHeight;
                    measuredHeight = defaultSize2;
                } else if (d < d4) {
                    int i12 = (int) ((d2 / ((double) defaultSize)) * ((double) defaultSize2));
                    defaultSize = measuredHeight;
                    defaultSize2 = i12;
                    measuredHeight = measuredWidth;
                    measuredWidth = defaultSize;
                } else {
                    int i13 = measuredWidth;
                    measuredWidth = measuredHeight;
                    measuredHeight = i13;
                }
            }
            if (i9 == 4) {
                if (rotation == 90 || rotation == 270) {
                    int i14 = measuredWidth;
                    measuredWidth = measuredHeight;
                    measuredHeight = i14;
                }
                double d5 = ((double) i4) / ((double) i5);
                double d6 = measuredWidth;
                if (d5 < d6 / ((double) measuredHeight)) {
                    defaultSize2 = (int) (d6 / d5);
                    defaultSize = measuredWidth;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.TextureView, android.view.View
    public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
    }

    @Override // android.view.View
    public void setRotation(float rotation) {
        if (rotation != getRotation()) {
            super.setRotation(rotation);
            requestLayout();
        }
    }

    public void setVideoCustomCropSize(int currentVideoWidth, int currentVideoHeight, int type) {
        if (this.currentVideoWidth == currentVideoWidth && this.currentVideoHeight == currentVideoHeight) {
            return;
        }
        this.currentVideoWidth = currentVideoWidth;
        this.currentVideoHeight = currentVideoHeight;
        VIDEO_IMAGE_DISPLAY_TYPE = type;
        setMeasuredDimension(currentVideoWidth, currentVideoHeight);
        requestLayout();
    }

    public void setVideoSize(int currentVideoWidth, int currentVideoHeight) {
        if (this.currentVideoWidth == currentVideoWidth && this.currentVideoHeight == currentVideoHeight) {
            return;
        }
        this.currentVideoWidth = currentVideoWidth;
        this.currentVideoHeight = currentVideoHeight;
        setMeasuredDimension(currentVideoWidth, currentVideoHeight);
        requestLayout();
    }

    public CustomTextureView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
