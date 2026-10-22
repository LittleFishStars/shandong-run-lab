package com.byazt.mt;

import android.content.Context;
import com.byazt.aq.x;
import com.byazt.sr.uj;
import com.byazt.tm.DynamicBaseInternalScrollWidgetImp;
import com.byazt.tm.DynamicBaseScrollWidgetImp;
import com.byazt.tm.DynamicBaseWidget;
import com.byazt.tm.DynamicBaseWidgetImp;
import com.byazt.tm.DynamicButton;
import com.byazt.tm.DynamicClose;
import com.byazt.tm.DynamicDislike;
import com.byazt.tm.DynamicDislikeFeedBack;
import com.byazt.tm.DynamicImageFlipSlide;
import com.byazt.tm.DynamicImageView;
import com.byazt.tm.DynamicLeisureWidget;
import com.byazt.tm.DynamicLogoAd;
import com.byazt.tm.DynamicLogoUnion;
import com.byazt.tm.DynamicLottie;
import com.byazt.tm.DynamicMutedView;
import com.byazt.tm.DynamicPrivacyView;
import com.byazt.tm.DynamicRoot;
import com.byazt.tm.DynamicRootView;
import com.byazt.tm.DynamicSkipCountDown;
import com.byazt.tm.DynamicSkipCountDownBtn;
import com.byazt.tm.DynamicSkipCountDownContainer;
import com.byazt.tm.DynamicSplitLineView;
import com.byazt.tm.DynamicStarView;
import com.byazt.tm.DynamicTextView;
import com.byazt.tm.DynamicTimeOuter;
import com.byazt.tm.DynamicTimeOuterContainerWidgetImp;
import com.byazt.tm.DynamicTimeOuterRewardFullSkip;
import com.byazt.tm.DynamicTimeOuterSkip;
import com.byazt.tm.DynamicUnKnowView;
import com.byazt.tm.DynamicVerticalScrollWidgetImp;
import com.byazt.tm.DynamicVideoView;
import com.byazt.xl.u;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 684, 13})
public class tt {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:53:0x0111  */
    public static DynamicBaseWidget c(Context context, DynamicRootView dynamicRootView, x xVar) {
        DynamicBaseWidget dynamicUnKnowView = null;
        if (context != null && dynamicRootView != null && xVar != null && xVar.da() != null) {
            switch (xVar.da().c()) {
                case -1:
                    dynamicUnKnowView = new DynamicUnKnowView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null && dynamicRootView.getRenderRequest() != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 0:
                    dynamicUnKnowView = new DynamicTextView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 1:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 2:
                    dynamicUnKnowView = new DynamicButton(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 3:
                    dynamicUnKnowView = new DynamicDislike(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 4:
                    dynamicUnKnowView = new DynamicLogoAd(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 5:
                    dynamicUnKnowView = new DynamicLogoUnion(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 6:
                case 9:
                case 17:
                    dynamicUnKnowView = new DynamicBaseWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 7:
                    dynamicUnKnowView = new DynamicVideoView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 8:
                    dynamicUnKnowView = new DynamicRoot(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 10:
                    dynamicUnKnowView = new DynamicMutedView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 11:
                    dynamicUnKnowView = new DynamicStarView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 12:
                    dynamicUnKnowView = new DynamicDislikeFeedBack(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 13:
                    dynamicUnKnowView = new DynamicTimeOuter(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 14:
                    dynamicUnKnowView = new DynamicTimeOuterContainerWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 15:
                    dynamicUnKnowView = uj.c() ? new DynamicTimeOuterRewardFullSkip(context, dynamicRootView, xVar) : new DynamicTimeOuterSkip(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 16:
                    dynamicUnKnowView = new DynamicImageView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 18:
                    dynamicUnKnowView = new DynamicSplitLineView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 19:
                    dynamicUnKnowView = new DynamicSkipCountDownContainer(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 20:
                    dynamicUnKnowView = new DynamicSkipCountDown(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 21:
                    dynamicUnKnowView = new DynamicSkipCountDownBtn(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 22:
                    dynamicUnKnowView = new DynamicClose(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 23:
                    dynamicUnKnowView = new DynamicPrivacyView(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 24:
                    dynamicUnKnowView = new DynamicBaseScrollWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 25:
                    dynamicUnKnowView = new DynamicLeisureWidget(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 26:
                    dynamicUnKnowView = "vertical".equals(xVar.da().n().g()) ? new DynamicVerticalScrollWidgetImp(context, dynamicRootView, xVar) : new DynamicBaseInternalScrollWidgetImp(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 27:
                    dynamicUnKnowView = new DynamicTimeOuterSkip(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 28:
                    if (uj.c()) {
                        u renderRequest = dynamicRootView.getRenderRequest();
                        if (renderRequest == null) {
                            return null;
                        }
                        dynamicUnKnowView = new DynamicLottie(context, dynamicRootView, xVar, renderRequest.yv());
                    }
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                case 29:
                    dynamicUnKnowView = new DynamicImageFlipSlide(context, dynamicRootView, xVar);
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
                default:
                    if (dynamicUnKnowView != null) {
                        dynamicUnKnowView.setCanUseSensor(dynamicRootView.getRenderRequest().i());
                    }
                    break;
            }
        }
        return dynamicUnKnowView;
    }
}
