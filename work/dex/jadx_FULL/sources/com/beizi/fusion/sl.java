package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.widget.RegionClickView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class sl {
    private static String e;
    private static String f;
    private static String g;
    private static String h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27755a;
    private c b;
    private AdSpacesBean.BuyerBean.RegionalClickViewBean c = null;
    private Boolean d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = sl.this.b;
            if (cVar != null) {
                String str = sl.e;
                String str2 = sl.f;
                String str3 = sl.g;
                String str4 = sl.h;
                cVar.b(str, str2, str3, str4, str, str2, str3, str4);
            }
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
                if (motionEvent.getAction() != 0) {
                    return false;
                }
                sl.e = motionEvent.getX() + "";
                sl.f = motionEvent.getY() + "";
                sl.g = motionEvent.getRawX() + "";
                sl.h = motionEvent.getRawY() + "";
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public interface c {
        void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public sl(Context context) {
        this.f27755a = context;
    }

    public void a(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        this.c = regionalClickViewBean;
    }

    public View a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean, boolean z) {
        if (this.f27755a == null || percentPositionBean == null) {
            return null;
        }
        jh.b("BeiZis", "adWidthDp = " + i + ",adHeightDp = " + i2);
        RegionClickView regionClickView = new RegionClickView(this.f27755a);
        if (this.c != null) {
            regionClickView.setDownloadApp(this.d);
            regionClickView.setRegionalClickViewBean(this.c);
        }
        regionClickView.setLayoutParams(a(i, i2, percentPositionBean));
        if (z) {
            regionClickView.setOnClickListener(new a());
            regionClickView.setOnTouchListener(new b());
        }
        return regionClickView;
    }

    private ViewGroup.MarginLayoutParams a(int i, int i2, AdSpacesBean.BuyerBean.PercentPositionBean percentPositionBean) {
        int i3;
        int i4;
        int i5;
        String centerX = percentPositionBean.getCenterX();
        String centerY = percentPositionBean.getCenterY();
        String width = percentPositionBean.getWidth();
        String height = percentPositionBean.getHeight();
        float f2 = so.f(this.f27755a);
        if (TextUtils.isEmpty(centerX) || "0".equals(centerX)) {
            centerX = "50%";
        }
        if (TextUtils.isEmpty(centerY) || "0".equals(centerY)) {
            jh.a("BeiZis", "screenHeightDp = " + f2 + ",adHeightDp = " + i2);
            centerY = f2 > ((float) i2) ? "63" : "188";
        }
        if (TextUtils.isEmpty(width) || "0".equals(width)) {
            width = "325";
        }
        if (TextUtils.isEmpty(height) || "0".equals(height)) {
            height = "65";
        }
        float fI = so.i(this.f27755a);
        if (centerX.endsWith("%")) {
            i3 = (Integer.parseInt(centerX.substring(0, centerX.indexOf("%"))) * i) / 100;
        } else {
            i3 = Integer.parseInt(centerX);
        }
        if (centerY.endsWith("%")) {
            i4 = (Integer.parseInt(centerY.substring(0, centerY.indexOf("%"))) * i2) / 100;
        } else {
            i4 = i2 - Integer.parseInt(centerY);
            jh.a("BeiZis", "adHeightDp = " + i2 + ", centerYInt = " + i4);
        }
        int i6 = 400;
        if (width.endsWith("%")) {
            int i7 = Integer.parseInt(width.substring(0, width.indexOf("%")));
            if (fI >= 400.0f) {
                i6 = (i7 * 400) / 100;
            } else {
                i6 = (((int) fI) * i7) / 100;
            }
        } else {
            int i8 = Integer.parseInt(width);
            if (i8 < 400) {
                i6 = i8;
            }
        }
        if (height.endsWith("%")) {
            i5 = (Integer.parseInt(height.substring(0, height.indexOf("%"))) * i6) / 100;
        } else {
            i5 = Integer.parseInt(height);
        }
        int iA = so.a(this.f27755a, i6);
        int iA2 = so.a(this.f27755a, i5);
        int iA3 = so.a(this.f27755a, i3);
        int iA4 = so.a(this.f27755a, i4);
        jh.a("BeiZis", "widthInt = " + iA + ",heightInt = " + iA2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(iA, iA2);
        jh.a("BeiZis", "centerYInt = " + iA4 + ",centerXInt = " + iA3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        marginLayoutParams.topMargin = iA4 - (iA2 / 2);
        marginLayoutParams.leftMargin = iA3 - (iA / 2);
        return marginLayoutParams;
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a() {
        this.f27755a = null;
        this.c = null;
    }

    public void a(Boolean bool) {
        this.d = bool;
    }
}
