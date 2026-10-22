package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int i2;
        ChainHead[] chainHeadArr;
        int i3;
        if (i == 0) {
            i2 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i3 = 0;
        } else {
            i2 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i3 = 2;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            ChainHead chainHead = chainHeadArr[i4];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x016e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0171  */
    /* JADX WARN: Code duplicated, block: B:105:0x0177  */
    /* JADX WARN: Code duplicated, block: B:107:0x0198  */
    /* JADX WARN: Code duplicated, block: B:202:0x034c  */
    /* JADX WARN: Code duplicated, block: B:222:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:25:0x0044 A[PHI: r8 r16
      0x0044: PHI (r8v3 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0044: PHI (r16v3 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0046 A[PHI: r8 r16
      0x0046: PHI (r8v43 boolean) = (r8v1 boolean), (r8v45 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]
      0x0046: PHI (r16v6 boolean) = (r16v1 boolean), (r16v8 boolean) binds: [B:24:0x0042, B:15:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:325:0x03a5 A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v40 */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i, int i2, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        int i3;
        int i4;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        ?? r5;
        SolverVariable solverVariable4;
        float f;
        int size;
        ConstraintAnchor constraintAnchor3;
        int i5;
        int i6 = i;
        ConstraintWidget constraintWidget = chainHead.mFirst;
        ConstraintWidget constraintWidget2 = chainHead.mLast;
        ConstraintWidget constraintWidget3 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget4 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget5 = chainHead.mHead;
        float f2 = chainHead.mTotalWeight;
        boolean z4 = constraintWidgetContainer.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i6 == 0) {
            int i7 = constraintWidget5.mHorizontalChainStyle;
            z = i7 == 0;
            z2 = i7 == 1;
            if (i7 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            int i8 = constraintWidget5.mVerticalChainStyle;
            z = i8 == 0;
            z2 = i8 == 1;
            if (i8 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        boolean z5 = z2;
        boolean z6 = false;
        boolean z7 = z;
        ?? r8 = constraintWidget;
        while (true) {
            obj = null;
            if (z6) {
                break;
            }
            ConstraintAnchor constraintAnchor4 = r8.mListAnchors[i2];
            int i9 = z3 ? 1 : 4;
            int margin = constraintAnchor4.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r8.mListDimensionBehaviors[i6];
            float f3 = f2;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z8 = dimensionBehaviour == dimensionBehaviour2 && r8.mResolvedMatchConstraintDefault[i6] == 0;
            ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
            if (constraintAnchor5 != null && r8 != constraintWidget) {
                margin += constraintAnchor5.getMargin();
            }
            int i10 = margin;
            if (z3 && r8 != constraintWidget && r8 != constraintWidget3) {
                i9 = 8;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchor4.mTarget;
            if (constraintAnchor6 != null) {
                if (r8 == constraintWidget3) {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i10, 6);
                } else {
                    linearSystem.addGreaterThan(constraintAnchor4.mSolverVariable, constraintAnchor6.mSolverVariable, i10, 8);
                }
                if (z8 && !z3) {
                    i9 = 5;
                }
                linearSystem.addEquality(constraintAnchor4.mSolverVariable, constraintAnchor4.mTarget.mSolverVariable, i10, (r8 == constraintWidget3 && z3 && r8.isInBarrier(i6)) ? 5 : i9);
            } else {
                constraintWidget = constraintWidget;
            }
            if (z4) {
                if (r8.getVisibility() == 8 || r8.mListDimensionBehaviors[i6] != dimensionBehaviour2) {
                    i5 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r8.mListAnchors;
                    i5 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i2 + 1].mSolverVariable, constraintAnchorArr[i2].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r8.mListAnchors[i2].mSolverVariable, constraintWidgetContainer.mListAnchors[i2].mSolverVariable, i5, 8);
            }
            ConstraintAnchor constraintAnchor7 = r8.mListAnchors[i2 + 1].mTarget;
            if (constraintAnchor7 != null) {
                ConstraintWidget constraintWidget6 = constraintAnchor7.mOwner;
                ConstraintAnchor constraintAnchor8 = constraintWidget6.mListAnchors[i2].mTarget;
                if (constraintAnchor8 != null && constraintAnchor8.mOwner == r8) {
                    obj = constraintWidget6;
                }
            }
            if (obj != null) {
                r8 = obj;
                z6 = z6;
            } else {
                z6 = true;
            }
            constraintWidget5 = constraintWidget5;
            f2 = f3;
            constraintWidget = constraintWidget;
            r8 = r8;
        }
        ConstraintWidget constraintWidget7 = constraintWidget5;
        float f4 = f2;
        ConstraintWidget constraintWidget8 = constraintWidget;
        if (constraintWidget4 != null) {
            int i11 = i2 + 1;
            if (constraintWidget2.mListAnchors[i11].mTarget != null) {
                ConstraintAnchor constraintAnchor9 = constraintWidget4.mListAnchors[i11];
                if ((constraintWidget4.mListDimensionBehaviors[i6] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget4.mResolvedMatchConstraintDefault[i6] == 0) && !z3) {
                    ConstraintAnchor constraintAnchor10 = constraintAnchor9.mTarget;
                    if (constraintAnchor10.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor10.mSolverVariable, -constraintAnchor9.getMargin(), 5);
                    } else if (z3) {
                        constraintAnchor3 = constraintAnchor9.mTarget;
                        if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                        }
                    }
                } else if (z3) {
                    constraintAnchor3 = constraintAnchor9.mTarget;
                    if (constraintAnchor3.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor9.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor9.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor9.mSolverVariable, constraintWidget2.mListAnchors[i11].mTarget.mSolverVariable, -constraintAnchor9.getMargin(), 6);
            }
        }
        if (z4) {
            int i12 = i2 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i12].mSolverVariable;
            ConstraintAnchor constraintAnchor11 = constraintWidget2.mListAnchors[i12];
            linearSystem.addGreaterThan(solverVariable5, constraintAnchor11.mSolverVariable, constraintAnchor11.getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null && (size = arrayList.size()) > 1) {
            float f5 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f4 : chainHead.mWidgetsMatchCount;
            float f6 = 0.0f;
            float f7 = 0.0f;
            ConstraintWidget constraintWidget9 = null;
            int i13 = 0;
            while (i13 < size) {
                ConstraintWidget constraintWidget10 = arrayList.get(i13);
                float f8 = constraintWidget10.mWeight[i6];
                if (f8 < f6) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget10.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr2[i2 + 1].mSolverVariable, constraintAnchorArr2[i2].mSolverVariable, 0, 4);
                    } else {
                        f8 = 1.0f;
                        f6 = 0.0f;
                    }
                    arrayList = arrayList;
                    size = size;
                    i13++;
                    size = size;
                    arrayList = arrayList;
                    f6 = 0.0f;
                }
                if (f8 == f6) {
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget10.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr3[i2 + 1].mSolverVariable, constraintAnchorArr3[i2].mSolverVariable, 0, 8);
                    arrayList = arrayList;
                    size = size;
                } else {
                    if (constraintWidget9 != null) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget9.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr4[i2].mSolverVariable;
                        int i14 = i2 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr4[i14].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget10.mListAnchors;
                        SolverVariable solverVariable8 = constraintAnchorArr5[i2].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr5[i14].mSolverVariable;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f7, f5, f8, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    }
                    constraintWidget9 = constraintWidget10;
                    f7 = f8;
                }
                i13++;
                size = size;
                arrayList = arrayList;
                f6 = 0.0f;
            }
        }
        if (constraintWidget3 != null && (constraintWidget3 == constraintWidget4 || z3)) {
            ConstraintAnchor constraintAnchor12 = constraintWidget8.mListAnchors[i2];
            int i15 = i2 + 1;
            ConstraintAnchor constraintAnchor13 = constraintWidget2.mListAnchors[i15];
            ConstraintAnchor constraintAnchor14 = constraintAnchor12.mTarget;
            SolverVariable solverVariable10 = constraintAnchor14 != null ? constraintAnchor14.mSolverVariable : null;
            ConstraintAnchor constraintAnchor15 = constraintAnchor13.mTarget;
            SolverVariable solverVariable11 = constraintAnchor15 != null ? constraintAnchor15.mSolverVariable : null;
            ConstraintAnchor constraintAnchor16 = constraintWidget3.mListAnchors[i2];
            if (constraintWidget4 != null) {
                constraintAnchor13 = constraintWidget4.mListAnchors[i15];
            }
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i6 == 0) {
                    f = constraintWidget7.mHorizontalBiasPercent;
                } else {
                    f = constraintWidget7.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor16.mSolverVariable, solverVariable10, constraintAnchor16.getMargin(), f, solverVariable11, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 7);
            }
        } else if (!z7 || constraintWidget3 == null) {
            int i16 = 8;
            if (z5 && constraintWidget3 != null) {
                int i17 = chainHead.mWidgetsMatchCount;
                boolean z9 = i17 > 0 && chainHead.mWidgetsCount == i17;
                ConstraintWidget constraintWidget11 = constraintWidget3;
                ConstraintWidget constraintWidget12 = constraintWidget11;
                while (constraintWidget12 != null) {
                    ConstraintWidget constraintWidget13 = constraintWidget12.mNextChainWidget[i6];
                    while (constraintWidget13 != null && constraintWidget13.getVisibility() == i16) {
                        constraintWidget13 = constraintWidget13.mNextChainWidget[i6];
                    }
                    if (constraintWidget12 == constraintWidget3 || constraintWidget12 == constraintWidget4 || constraintWidget13 == null) {
                        constraintWidget11 = constraintWidget11;
                        i4 = i16;
                    } else {
                        ConstraintWidget constraintWidget14 = constraintWidget13 == constraintWidget4 ? null : constraintWidget13;
                        ConstraintAnchor constraintAnchor17 = constraintWidget12.mListAnchors[i2];
                        SolverVariable solverVariable12 = constraintAnchor17.mSolverVariable;
                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.mTarget;
                        if (constraintAnchor18 != null) {
                            SolverVariable solverVariable13 = constraintAnchor18.mSolverVariable;
                        }
                        int i18 = i2 + 1;
                        SolverVariable solverVariable14 = constraintWidget11.mListAnchors[i18].mSolverVariable;
                        int margin2 = constraintAnchor17.getMargin();
                        int margin3 = constraintWidget12.mListAnchors[i18].getMargin();
                        if (constraintWidget14 != null) {
                            constraintAnchor = constraintWidget14.mListAnchors[i2];
                            SolverVariable solverVariable15 = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor19 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor19 != null ? constraintAnchor19.mSolverVariable : null;
                            solverVariable = solverVariable15;
                        } else {
                            constraintAnchor = constraintWidget4.mListAnchors[i2];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget12.mListAnchors[i18].mSolverVariable;
                        }
                        if (constraintAnchor != null) {
                            margin3 += constraintAnchor.getMargin();
                        }
                        int i19 = margin3;
                        int margin4 = constraintWidget11.mListAnchors[i18].getMargin() + margin2;
                        int i20 = z9 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            i4 = 8;
                        } else {
                            i4 = 8;
                            linearSystem.addCentering(solverVariable12, solverVariable14, margin4, 0.5f, solverVariable, solverVariable2, i19, i20);
                        }
                        constraintWidget13 = constraintWidget14;
                    }
                    constraintWidget11 = constraintWidget12.getVisibility() != i4 ? constraintWidget12 : constraintWidget11;
                    constraintWidget12 = constraintWidget13;
                    i16 = i4;
                    i6 = i;
                }
                ConstraintAnchor constraintAnchor20 = constraintWidget3.mListAnchors[i2];
                ConstraintAnchor constraintAnchor21 = constraintWidget8.mListAnchors[i2].mTarget;
                int i21 = i2 + 1;
                ConstraintAnchor constraintAnchor22 = constraintWidget4.mListAnchors[i21];
                ConstraintAnchor constraintAnchor23 = constraintWidget2.mListAnchors[i21].mTarget;
                if (constraintAnchor21 == null) {
                    i3 = 5;
                } else if (constraintWidget3 != constraintWidget4) {
                    i3 = 5;
                    linearSystem.addEquality(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 5);
                } else {
                    i3 = 5;
                    if (constraintAnchor23 != null) {
                        linearSystem.addCentering(constraintAnchor20.mSolverVariable, constraintAnchor21.mSolverVariable, constraintAnchor20.getMargin(), 0.5f, constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, constraintAnchor22.getMargin(), 5);
                    }
                }
                if (constraintAnchor23 != null && constraintWidget3 != constraintWidget4) {
                    linearSystem.addEquality(constraintAnchor22.mSolverVariable, constraintAnchor23.mSolverVariable, -constraintAnchor22.getMargin(), i3);
                }
            }
        } else {
            int i22 = chainHead.mWidgetsMatchCount;
            boolean z10 = i22 > 0 && chainHead.mWidgetsCount == i22;
            ConstraintWidget constraintWidget15 = constraintWidget3;
            ConstraintWidget constraintWidget16 = constraintWidget15;
            while (constraintWidget16 != null) {
                ConstraintWidget constraintWidget17 = constraintWidget16.mNextChainWidget[i6];
                while (constraintWidget17 != null && constraintWidget17.getVisibility() == 8) {
                    constraintWidget17 = constraintWidget17.mNextChainWidget[i6];
                }
                if (constraintWidget17 != null || constraintWidget16 == constraintWidget4) {
                    ConstraintAnchor constraintAnchor24 = constraintWidget16.mListAnchors[i2];
                    SolverVariable solverVariable16 = constraintAnchor24.mSolverVariable;
                    ConstraintAnchor constraintAnchor25 = constraintAnchor24.mTarget;
                    SolverVariable solverVariable17 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                    if (constraintWidget15 != constraintWidget16) {
                        solverVariable17 = constraintWidget15.mListAnchors[i2 + 1].mSolverVariable;
                    } else if (constraintWidget16 == constraintWidget3) {
                        ConstraintAnchor constraintAnchor26 = constraintWidget8.mListAnchors[i2].mTarget;
                        solverVariable17 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                    }
                    int margin5 = constraintAnchor24.getMargin();
                    int i23 = i2 + 1;
                    int margin6 = constraintWidget16.mListAnchors[i23].getMargin();
                    if (constraintWidget17 != null) {
                        constraintAnchor2 = constraintWidget17.mListAnchors[i2];
                        solverVariable3 = constraintAnchor2.mSolverVariable;
                    } else {
                        constraintAnchor2 = constraintWidget2.mListAnchors[i23].mTarget;
                        if (constraintAnchor2 != null) {
                            solverVariable3 = constraintAnchor2.mSolverVariable;
                        } else {
                            solverVariable3 = null;
                        }
                        SolverVariable solverVariable18 = constraintWidget16.mListAnchors[i23].mSolverVariable;
                        if (constraintAnchor2 != null) {
                            margin6 += constraintAnchor2.getMargin();
                        }
                        int margin7 = margin5 + constraintWidget15.mListAnchors[i23].getMargin();
                        if (solverVariable16 == null && solverVariable17 != null && solverVariable3 != null && solverVariable18 != null) {
                            if (constraintWidget16 == constraintWidget3) {
                                margin7 = constraintWidget3.mListAnchors[i2].getMargin();
                            }
                            constraintWidget17 = constraintWidget17;
                            linearSystem.addCentering(solverVariable16, solverVariable17, margin7, 0.5f, solverVariable3, solverVariable18, constraintWidget16 == constraintWidget4 ? constraintWidget4.mListAnchors[i23].getMargin() : margin6, z10 ? 8 : 5);
                        }
                        if (constraintWidget16.getVisibility() != 8) {
                            constraintWidget16 = constraintWidget15;
                        }
                        constraintWidget15 = constraintWidget16;
                        constraintWidget16 = constraintWidget17;
                    }
                    SolverVariable solverVariable19 = constraintWidget16.mListAnchors[i23].mSolverVariable;
                    if (constraintAnchor2 != null) {
                        margin6 += constraintAnchor2.getMargin();
                    }
                    int margin8 = margin5 + constraintWidget15.mListAnchors[i23].getMargin();
                    if (solverVariable16 == null) {
                    }
                }
                if (constraintWidget16.getVisibility() != 8) {
                    constraintWidget16 = constraintWidget15;
                }
                constraintWidget15 = constraintWidget16;
                constraintWidget16 = constraintWidget17;
            }
        }
        if ((!z7 && !z5) || constraintWidget3 == null || constraintWidget3 == constraintWidget4) {
            return;
        }
        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget3.mListAnchors;
        ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i2];
        if (constraintWidget4 == null) {
            constraintWidget4 = constraintWidget3;
        }
        int i24 = i2 + 1;
        ConstraintAnchor constraintAnchor28 = constraintWidget4.mListAnchors[i24];
        ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
        SolverVariable solverVariable20 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
        ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
        if (constraintAnchor30 != null) {
            solverVariable4 = constraintAnchor30.mSolverVariable;
        } else {
            r5 = 0;
        }
        if (constraintWidget2 != constraintWidget4) {
            ConstraintAnchor constraintAnchor31 = constraintWidget2.mListAnchors[i24].mTarget;
            if (constraintAnchor31 != null) {
                r5 = solverVariable4;
                obj = constraintAnchor31.mSolverVariable;
            }
            r5 = solverVariable4;
            r5 = obj;
        }
        if (constraintWidget3 == constraintWidget4) {
            constraintAnchor28 = constraintAnchorArr6[i24];
        }
        if (solverVariable20 == null || r5 == 0) {
            return;
        }
        linearSystem.addCentering(constraintAnchor27.mSolverVariable, solverVariable20, constraintAnchor27.getMargin(), 0.5f, r5, constraintAnchor28.mSolverVariable, constraintWidget4.mListAnchors[i24].getMargin(), 5);
    }
}
