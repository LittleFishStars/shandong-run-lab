package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            int i = this.orientation;
            if (i == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i = 0; i < this.widgets.size(); i++) {
            this.widgets.get(i).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i = 0; i < size; i++) {
            WidgetRun widgetRun = this.widgets.get(i);
            wrapDimension = wrapDimension + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i = 0; i < size; i++) {
            if (!this.widgets.get(i).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        for (WidgetRun widgetRun : this.widgets) {
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:113:0x01be  */
    /* JADX WARN: Code duplicated, block: B:294:0x00f4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ec A[ADDED_TO_REGION] */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f2;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i14 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i15 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i15 >= size) {
                    i15 = -1;
                    break;
                } else if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    break;
                } else {
                    i15++;
                }
            }
            int i16 = size - 1;
            for (int i17 = i16; i17 >= 0; i17--) {
                if (this.widgets.get(i17).widget.getVisibility() != 8) {
                    i = i17;
                    break;
                }
            }
            int i18 = 0;
            while (true) {
                if (i18 >= 2) {
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    f = 0.0f;
                    break;
                }
                int i19 = 0;
                i4 = 0;
                i5 = 0;
                int i20 = 0;
                f = 0.0f;
                while (i19 < size) {
                    WidgetRun widgetRun = this.widgets.get(i19);
                    if (widgetRun.widget.getVisibility() != i2) {
                        i20++;
                        if (i19 > 0 && i19 >= i15) {
                            i4 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i21 = dimensionDependency.value;
                        boolean z2 = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z2) {
                            int i22 = this.orientation;
                            if (i22 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i22 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                i12 = i21;
                            }
                        } else {
                            i12 = i21;
                            if (widgetRun.matchConstraintsType == 1 && i18 == 0) {
                                i13 = dimensionDependency.wrapValue;
                                i5++;
                            } else {
                                if (dimensionDependency.resolved) {
                                    i13 = i12;
                                }
                                if (z2) {
                                    i4 += i13;
                                } else {
                                    i5++;
                                    f2 = widgetRun.widget.mWeight[this.orientation];
                                    if (f2 >= 0.0f) {
                                        f += f2;
                                    }
                                }
                                if (i19 >= i16 && i19 < i) {
                                    i4 += -widgetRun.end.margin;
                                }
                            }
                            z2 = true;
                            if (z2) {
                                i5++;
                                f2 = widgetRun.widget.mWeight[this.orientation];
                                if (f2 >= 0.0f) {
                                    f += f2;
                                }
                            } else {
                                i4 += i13;
                            }
                            if (i19 >= i16) {
                            }
                        }
                        i13 = i12;
                        if (z2) {
                            i5++;
                            f2 = widgetRun.widget.mWeight[this.orientation];
                            if (f2 >= 0.0f) {
                                f += f2;
                            }
                        } else {
                            i4 += i13;
                        }
                        if (i19 >= i16) {
                        }
                    }
                    i19++;
                    i2 = 8;
                }
                if (i4 < i14 || i5 == 0) {
                    i3 = i20;
                    break;
                } else {
                    i18++;
                    i2 = 8;
                }
            }
            int i23 = this.start.value;
            if (zIsRtl) {
                i23 = this.end.value;
            }
            if (i4 > i14) {
                i23 = zIsRtl ? i23 + ((int) (((i4 - i14) / 2.0f) + 0.5f)) : i23 - ((int) (((i4 - i14) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f3 = i14 - i4;
                int i24 = (int) ((f3 / i5) + 0.5f);
                int i25 = 0;
                int i26 = 0;
                while (i25 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i25);
                    int i27 = i24;
                    int i28 = i4;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (dimensionDependency2.resolved) {
                            zIsRtl = zIsRtl;
                            i23 = i23;
                            f3 = f3;
                        } else {
                            int i29 = f > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f3) / f) + 0.5f) : i27;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                i11 = constraintWidget.mMatchConstraintMaxWidth;
                                i10 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i30 = constraintWidget2.mMatchConstraintMaxHeight;
                                i10 = constraintWidget2.mMatchConstraintMinHeight;
                                i11 = i30;
                            }
                            int iMax = Math.max(i10, widgetRun2.matchConstraintsType == 1 ? Math.min(i29, dimensionDependency2.wrapValue) : i29);
                            if (i11 > 0) {
                                iMax = Math.min(i11, iMax);
                            }
                            if (iMax != i29) {
                                i26++;
                                i29 = iMax;
                            }
                            widgetRun2.dimension.resolve(i29);
                        }
                    } else {
                        zIsRtl = zIsRtl;
                        i23 = i23;
                        f3 = f3;
                    }
                    i25++;
                    i24 = i27;
                    i4 = i28;
                    i23 = i23;
                    f3 = f3;
                    zIsRtl = zIsRtl;
                    i3 = i3;
                }
                z = zIsRtl;
                i6 = i3;
                i7 = i23;
                int i31 = i4;
                if (i26 > 0) {
                    i5 -= i26;
                    int i32 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        WidgetRun widgetRun3 = this.widgets.get(i33);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i33 > 0 && i33 >= i15) {
                                i32 += widgetRun3.start.margin;
                            }
                            i32 += widgetRun3.dimension.value;
                            if (i33 < i16 && i33 < i) {
                                i32 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i4 = i32;
                } else {
                    i4 = i31;
                }
                i9 = 2;
                if (this.chainStyle == 2 && i26 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                z = zIsRtl;
                i6 = i3;
                i7 = i23;
                i8 = 0;
                i9 = 2;
            }
            if (i4 > i14) {
                this.chainStyle = i9;
            }
            if (i6 > 0 && i5 == 0 && i15 == i) {
                this.chainStyle = i9;
            }
            int i34 = this.chainStyle;
            if (i34 == 1) {
                int i35 = i6;
                int i36 = i35 > 1 ? (i14 - i4) / (i35 - 1) : i35 == 1 ? (i14 - i4) / 2 : i8;
                if (i5 > 0) {
                    i36 = i8;
                }
                int i37 = i7;
                for (int i38 = i8; i38 < size; i38++) {
                    WidgetRun widgetRun4 = this.widgets.get(z ? size - (i38 + 1) : i38);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i37);
                        widgetRun4.end.resolve(i37);
                    } else {
                        if (i38 > 0) {
                            i37 = z ? i37 - i36 : i37 + i36;
                        }
                        if (i38 > 0 && i38 >= i15) {
                            i37 = z ? i37 - widgetRun4.start.margin : i37 + widgetRun4.start.margin;
                        }
                        if (z) {
                            widgetRun4.end.resolve(i37);
                        } else {
                            widgetRun4.start.resolve(i37);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i39 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i39 = dimensionDependency3.wrapValue;
                        }
                        i37 = z ? i37 - i39 : i37 + i39;
                        if (z) {
                            widgetRun4.start.resolve(i37);
                        } else {
                            widgetRun4.end.resolve(i37);
                        }
                        widgetRun4.resolved = true;
                        if (i38 < i16 && i38 < i) {
                            i37 = z ? i37 - (-widgetRun4.end.margin) : i37 + (-widgetRun4.end.margin);
                        }
                    }
                }
                return;
            }
            int i40 = i6;
            if (i34 == 0) {
                int i41 = (i14 - i4) / (i40 + 1);
                if (i5 > 0) {
                    i41 = i8;
                }
                int i42 = i7;
                for (int i43 = i8; i43 < size; i43++) {
                    WidgetRun widgetRun5 = this.widgets.get(z ? size - (i43 + 1) : i43);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i42);
                        widgetRun5.end.resolve(i42);
                    } else {
                        int i44 = z ? i42 - i41 : i42 + i41;
                        if (i43 > 0 && i43 >= i15) {
                            i44 = z ? i44 - widgetRun5.start.margin : i44 + widgetRun5.start.margin;
                        }
                        if (z) {
                            widgetRun5.end.resolve(i44);
                        } else {
                            widgetRun5.start.resolve(i44);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i42 = z ? i44 - iMin : i44 + iMin;
                        if (z) {
                            widgetRun5.start.resolve(i42);
                        } else {
                            widgetRun5.end.resolve(i42);
                        }
                        if (i43 < i16 && i43 < i) {
                            i42 = z ? i42 - (-widgetRun5.end.margin) : i42 + (-widgetRun5.end.margin);
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (z) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i45 = (int) (((i14 - i4) * horizontalBiasPercent) + 0.5f);
                if (i45 < 0 || i5 > 0) {
                    i45 = i8;
                }
                int i46 = z ? i7 - i45 : i7 + i45;
                for (int i47 = i8; i47 < size; i47++) {
                    WidgetRun widgetRun6 = this.widgets.get(z ? size - (i47 + 1) : i47);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i46);
                        widgetRun6.end.resolve(i46);
                    } else {
                        if (i47 > 0 && i47 >= i15) {
                            i46 = z ? i46 - widgetRun6.start.margin : i46 + widgetRun6.start.margin;
                        }
                        if (z) {
                            widgetRun6.end.resolve(i46);
                        } else {
                            widgetRun6.start.resolve(i46);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i48 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i48 = dimensionDependency5.wrapValue;
                        }
                        i46 = z ? i46 - i48 : i46 + i48;
                        if (z) {
                            widgetRun6.start.resolve(i46);
                        } else {
                            widgetRun6.end.resolve(i46);
                        }
                        if (i47 < i16 && i47 < i) {
                            i46 = z ? i46 - (-widgetRun6.end.margin) : i46 + (-widgetRun6.end.margin);
                        }
                    }
                }
            }
        }
    }
}
