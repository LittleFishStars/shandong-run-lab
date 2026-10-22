package cj.mobile.wm.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WmExpressLayout extends RelativeLayout {
    public static final int MODE_LEFT_RIGHT = 1;
    public static final int MODE_TOP_BOTTOM = 2;
    public int currentMode;
    public View downloaderContainer;
    public View endPic;
    public int fixedRootHeight;
    public int fixedRootWidth;
    public View logoView;
    public View mainPic;
    public int materialHeight;
    public int materialWidth;
    public View prePic;
    public View richContainer;
    public View title2;
    public View videoView;

    public WmExpressLayout(Context context) {
        super(context);
        this.currentMode = 1;
        this.fixedRootWidth = -1;
        this.fixedRootHeight = -1;
        this.materialWidth = 0;
        this.materialHeight = 0;
    }

    private int computeRichHeightWithReserve(int i, int i2, int i3) {
        int i4 = (int) ((i * 9) / 16.0f);
        return i4 + i3 > i2 ? Math.max(0, i2 - i3) : i4;
    }

    private int computeRichWidth(int i, int i2) {
        return this.currentMode == 1 ? (int) ((i * 3) / 7.0f) : i2;
    }

    private void fitAllContent(int i, int i2) {
        if (isVisible(this.mainPic)) {
            fitContain(this.mainPic, i, i2, this.materialWidth, this.materialHeight);
        }
        if (isVisible(this.videoView)) {
            fitContain(this.videoView, i, i2, this.materialWidth, this.materialHeight);
        }
        if (isVisible(this.prePic)) {
            fitContain(this.prePic, i, i2, this.materialWidth, this.materialHeight);
        }
        if (isVisible(this.endPic)) {
            fitContain(this.endPic, i, i2, this.materialWidth, this.materialHeight);
        }
    }

    private void fitContain(View view, int i, int i2, int i3, int i4) {
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            return;
        }
        float f = i3;
        float f2 = i4;
        float fMin = Math.min(i / f, i2 / f2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        boolean z = true;
        int iMax = Math.max(1, Math.round(f * fMin));
        int iMax2 = Math.max(1, Math.round(f2 * fMin));
        if (marginLayoutParams.width == iMax && marginLayoutParams.height == iMax2) {
            z = false;
        }
        if (z) {
            marginLayoutParams.width = iMax;
            marginLayoutParams.height = iMax2;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    private boolean isVisible(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int measureWrapHeight(View view, int i) {
        if (!isVisible(view)) {
            return 0;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.max(0, (i - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int resolveBaseRichHeight(int i) {
        int i2;
        View view = this.richContainer;
        return (view == null || (i2 = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).height) <= 0) ? i : i2;
    }

    private int resolveRootHeight(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return (mode != 1073741824 && (i2 = this.fixedRootHeight) > 0) ? i2 : size;
    }

    private int resolveRootWidth(int i) {
        int i2;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return (mode != 1073741824 && (i2 = this.fixedRootWidth) > 0) ? i2 : size;
    }

    private void setSizeIfChanged(View view, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams.width == i && marginLayoutParams.height == i2) {
            return;
        }
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        view.setLayoutParams(marginLayoutParams);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int iResolveRootWidth = resolveRootWidth(i);
        int iResolveRootHeight = resolveRootHeight(i2);
        int iMax = Math.max(0, (iResolveRootWidth - getPaddingLeft()) - getPaddingRight());
        int iMax2 = Math.max(0, (iResolveRootHeight - getPaddingTop()) - getPaddingBottom());
        if (iResolveRootHeight != 0) {
            int iMeasureWrapHeight = measureWrapHeight(this.downloaderContainer, iMax);
            int iMeasureWrapHeight2 = this.currentMode == 2 ? measureWrapHeight(this.title2, iMax) : 0;
            int iMeasureWrapHeight3 = this.currentMode == 2 ? measureWrapHeight(this.logoView, iMax) : 0;
            if (isVisible(this.richContainer)) {
                int iComputeRichWidth = computeRichWidth(iResolveRootWidth, iMax);
                if (this.currentMode != 1) {
                    iMeasureWrapHeight = iMeasureWrapHeight + iMeasureWrapHeight2 + iMeasureWrapHeight3;
                }
                int iComputeRichHeightWithReserve = computeRichHeightWithReserve(iComputeRichWidth, iMax2, iMeasureWrapHeight);
                setSizeIfChanged(this.richContainer, iComputeRichWidth, iComputeRichHeightWithReserve);
                fitAllContent(iComputeRichWidth, iComputeRichHeightWithReserve);
            }
        } else if (isVisible(this.richContainer)) {
            int iComputeRichWidth2 = computeRichWidth(iResolveRootWidth, iMax);
            int i3 = (int) ((iComputeRichWidth2 * 9) / 16.0f);
            setSizeIfChanged(this.richContainer, iComputeRichWidth2, i3);
            fitAllContent(iComputeRichWidth2, i3);
        }
        super.onMeasure(i, i2);
    }

    public void setPicView(View view, int i, int i2) {
        this.mainPic = view;
        this.materialWidth = i;
        this.materialHeight = i2;
    }

    public void setVideoView(View view, View view2, View view3, int i, int i2) {
        this.videoView = view;
        this.prePic = view2;
        this.endPic = view3;
        this.materialWidth = i;
        this.materialHeight = i2;
    }

    public void setView(View view, View view2, int i, int i2) {
        this.currentMode = 1;
        this.downloaderContainer = view;
        this.richContainer = view2;
        this.title2 = null;
        this.logoView = null;
        this.fixedRootWidth = i;
        this.fixedRootHeight = i2 == 0 ? -1 : i2;
        if (getLayoutParams() != null) {
            if (i2 == 0) {
                i2 = -2;
            }
            setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        }
    }

    public WmExpressLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentMode = 1;
        this.fixedRootWidth = -1;
        this.fixedRootHeight = -1;
        this.materialWidth = 0;
        this.materialHeight = 0;
    }

    public void setView(View view, View view2, View view3, View view4, int i, int i2) {
        this.currentMode = 2;
        this.downloaderContainer = view;
        this.richContainer = view2;
        this.title2 = view3;
        this.logoView = view4;
        this.fixedRootWidth = i;
        this.fixedRootHeight = i2 == 0 ? -1 : i2;
        if (getLayoutParams() != null) {
            if (i2 == 0) {
                i2 = -2;
            }
            setLayoutParams(new FrameLayout.LayoutParams(i, i2));
        }
    }

    public WmExpressLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentMode = 1;
        this.fixedRootWidth = -1;
        this.fixedRootHeight = -1;
        this.materialWidth = 0;
        this.materialHeight = 0;
    }
}
