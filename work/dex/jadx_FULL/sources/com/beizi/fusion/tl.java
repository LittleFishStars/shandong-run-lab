package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class tl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27788a;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean b;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean c;
    private c d = null;
    private AdSpacesBean.BuyerBean.PercentPositionBean e;
    private String f;
    private String g;
    private double h;
    private String i;
    private int j;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27789a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c cVar;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27789a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    this.e = motionEvent.getX();
                    this.f = motionEvent.getY();
                }
            } else if (Math.abs(this.e - this.f27789a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && (cVar = tl.this.d) != null) {
                cVar.a(String.valueOf(this.f27789a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f27789a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
            }
            return true;
        }
    }

    public class b implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27790a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            c cVar;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27790a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    this.e = motionEvent.getX();
                    this.f = motionEvent.getY();
                }
            } else if (Math.abs(this.e - this.f27790a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && (cVar = tl.this.d) != null) {
                cVar.a(String.valueOf(this.f27790a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f27790a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
            }
            return true;
        }
    }

    public interface c {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public tl(Context context, AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean, String str, boolean z) {
        this.f = null;
        this.g = null;
        this.h = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.i = null;
        this.j = 0;
        try {
            this.f27788a = context;
            this.b = regionalClickViewBean;
            AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBeanA = a(regionalClickViewBean.getOrderData(), str);
            if (orderDataRegionalClickViewBeanA != null && orderDataRegionalClickViewBeanA.getRegionalClickView() != null) {
                this.c = orderDataRegionalClickViewBeanA.getRegionalClickView();
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean2 = this.c;
            if (regionalClickViewBean2 != null) {
                if (z) {
                    String downloadTitle = regionalClickViewBean2.getDownloadTitle();
                    this.i = downloadTitle;
                    if (TextUtils.isEmpty(downloadTitle)) {
                        this.i = "点击下载应用";
                    }
                } else {
                    this.i = regionalClickViewBean2.getTitle();
                }
                this.e = this.c.getPosition();
                this.f = this.c.getTitleColor();
                this.g = this.c.getBackgroundColor();
                this.h = this.c.getBackgroundAlpha();
                this.j = this.c.getIsDisableClick();
            } else {
                AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean3 = this.b;
                if (regionalClickViewBean3 != null) {
                    if (z) {
                        String downloadTitle2 = regionalClickViewBean3.getDownloadTitle();
                        this.i = downloadTitle2;
                        if (TextUtils.isEmpty(downloadTitle2)) {
                            this.i = "点击下载应用";
                        }
                    } else {
                        this.i = regionalClickViewBean3.getTitle();
                    }
                    this.e = this.b.getPosition();
                    this.f = this.b.getTitleColor();
                    this.g = this.b.getBackgroundColor();
                    this.h = this.b.getBackgroundAlpha();
                    this.j = this.b.getIsDisableClick();
                }
            }
            if (TextUtils.isEmpty(this.i)) {
                this.i = "点击跳转网页或第三方应用";
            }
            if (TextUtils.isEmpty(this.g)) {
                this.g = "#3976FF";
            }
            if (TextUtils.isEmpty(this.f)) {
                this.f = "#FFFFFF";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(LinearLayout linearLayout, TextView textView) {
        if (linearLayout == null || textView == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.i)) {
                textView.setText(this.i);
            }
            if (this.j != 0) {
                return;
            }
            linearLayout.setOnTouchListener(new b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(ViewGroup viewGroup) {
        if (viewGroup != null) {
            try {
                if (this.f27788a == null) {
                    return;
                }
                TextView textView = new TextView(this.f27788a);
                textView.setVisibility(0);
                textView.setLines(1);
                textView.setGravity(17);
                textView.setMaxLines(1);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                if (this.j == 0) {
                    textView.setOnTouchListener(new a());
                }
                if (!TextUtils.isEmpty(this.i)) {
                    textView.setText(this.i);
                }
                if (TextUtils.isEmpty(this.f)) {
                    this.f = "#FFFFFF";
                }
                if (!TextUtils.isEmpty(this.f) && this.f.startsWith("#")) {
                    textView.setTextColor(Color.parseColor(this.f));
                }
                if (TextUtils.isEmpty(this.g)) {
                    this.g = "#80000000";
                }
                GradientDrawable gradientDrawable = new GradientDrawable();
                if (!TextUtils.isEmpty(this.g) && this.g.startsWith("#")) {
                    gradientDrawable.setColor(Color.parseColor(this.g));
                }
                double d = this.h;
                if (d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    gradientDrawable.setAlpha((int) (d * 255.0d));
                }
                gradientDrawable.setCornerRadius(bq.a(this.f27788a, 7.0f));
                textView.setBackgroundDrawable(gradientDrawable);
                int[] iArrA = a(viewGroup);
                try {
                    int i = iArrA[1];
                    textView.setTextSize(2, (float) (i > 0 ? bq.b(this.f27788a, i) / 3 : 14.0d));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    int i2 = iArrA[0];
                    if (i2 > 0) {
                        layoutParams.width = i2;
                    }
                    int i3 = iArrA[1];
                    if (i3 > 0) {
                        layoutParams.height = i3;
                    }
                    layoutParams.leftMargin = iArrA[2];
                    layoutParams.topMargin = iArrA[3];
                    layoutParams.addRule(17);
                    viewGroup.addView(textView, layoutParams);
                    return;
                }
                if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                    int i4 = iArrA[0];
                    if (i4 > 0) {
                        layoutParams2.width = i4;
                    }
                    int i5 = iArrA[1];
                    if (i5 > 0) {
                        layoutParams2.height = i5;
                    }
                    layoutParams2.leftMargin = iArrA[2];
                    layoutParams2.topMargin = iArrA[3];
                    viewGroup.addView(textView, layoutParams2);
                    return;
                }
                if (!(viewGroup instanceof LinearLayout)) {
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
                    int i6 = iArrA[0];
                    if (i6 > 0) {
                        layoutParams3.width = i6;
                    }
                    int i7 = iArrA[1];
                    if (i7 > 0) {
                        layoutParams3.height = i7;
                    }
                    viewGroup.addView(textView, layoutParams3);
                    return;
                }
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int i8 = iArrA[0];
                if (i8 > 0) {
                    layoutParams4.width = i8;
                }
                int i9 = iArrA[1];
                if (i9 > 0) {
                    layoutParams4.height = i9;
                }
                layoutParams4.leftMargin = iArrA[2];
                layoutParams4.topMargin = iArrA[3];
                viewGroup.addView(textView, layoutParams4);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private int[] a(ViewGroup viewGroup) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = new int[4];
        if (viewGroup != null) {
            try {
                AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean = this.e;
                if (percentPositionBean != null) {
                    String centerX = percentPositionBean.getCenterX();
                    String centerY = this.e.getCenterY();
                    String width = this.e.getWidth();
                    String height = this.e.getHeight();
                    if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
                        centerX = "0";
                    }
                    if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
                        centerY = "0";
                    }
                    viewGroup.measure(0, 0);
                    int iB = bq.b(this.f27788a, viewGroup.getMeasuredWidth());
                    int iB2 = bq.b(this.f27788a, viewGroup.getMeasuredHeight());
                    if (iB <= 0) {
                        iB = to.j(this.f27788a);
                    }
                    kh.a("RegionClickUtil", "position containerWidth:" + iB + ";containerHeight:" + iB2 + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().width + com.alipay.sdk.m.y.l.b + viewGroup.getLayoutParams().height);
                    if (TextUtils.isEmpty(width) || "0".equals(width)) {
                        width = String.valueOf(iB);
                    }
                    if (TextUtils.isEmpty(height) || "0".equals(height)) {
                        height = "40";
                    }
                    if (centerX.endsWith("%")) {
                        i = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * iB) / 100;
                    } else {
                        i = !TextUtils.isEmpty(centerX) ? Integer.parseInt(centerX) : 0;
                    }
                    if (centerY.endsWith("%")) {
                        i2 = (iB2 * Integer.parseInt(centerY.substring(0, centerY.indexOf("%")))) / 100;
                    } else {
                        i2 = !TextUtils.isEmpty(centerY) ? Integer.parseInt(centerY) : 0;
                    }
                    if (width.endsWith("%")) {
                        i3 = (iB * Integer.parseInt(width.substring(0, width.indexOf("%")))) / 100;
                    } else {
                        i3 = !TextUtils.isEmpty(width) ? Integer.parseInt(width) : 0;
                    }
                    if (height.endsWith("%")) {
                        i4 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i3) / 100;
                    } else {
                        i4 = !TextUtils.isEmpty(width) ? Integer.parseInt(height) : 40;
                    }
                    int iA = bq.a(this.f27788a, i3);
                    int iA2 = bq.a(this.f27788a, i4);
                    int iA3 = bq.a(this.f27788a, i);
                    int iA4 = bq.a(this.f27788a, i2);
                    iArr[0] = iA;
                    iArr[1] = iA2;
                    if (iA3 > 0) {
                        iArr[2] = iA3;
                    }
                    if (iA4 > 0) {
                        iArr[3] = iA4;
                    }
                    kh.a("RegionClickUtil", "position widthInt:" + iArr[0] + ";heightInt:" + iArr[1] + ";centerX:" + iArr[2] + ";centerY:" + iArr[3] + com.alipay.sdk.m.y.l.b + centerX + com.alipay.sdk.m.y.l.b + centerY);
                    return iArr;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return iArr;
            }
        }
        int i5 = viewGroup.getLayoutParams().width;
        int iA5 = bq.a(this.f27788a, 40.0f);
        iArr[0] = i5;
        iArr[1] = iA5;
        iArr[2] = 0;
        iArr[3] = 0;
        return iArr;
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    private AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean orderDataRegionalClickViewBean = (AdSpacesBean.BuyerBean.OrderDataRegionalClickViewBean) it.next();
                List<String> orderList = orderDataRegionalClickViewBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataRegionalClickViewBean;
                }
            }
        }
        return null;
    }

    public String a() {
        return this.g;
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.e = null;
        this.d = null;
        this.f27788a = null;
    }
}
