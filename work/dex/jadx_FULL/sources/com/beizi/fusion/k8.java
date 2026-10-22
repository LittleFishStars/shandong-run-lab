package com.beizi.fusion;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.beizi.fusion.model.AdSpacesBean;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class k8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f27466a;
    private AdSpacesBean.BuyerBean.FullScreenClickBean b;
    private AdSpacesBean.BuyerBean.FullScreenClickBean c;
    private int e;
    private b d = null;
    private boolean f = false;

    public class a implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27467a;
        float b;
        float c;
        float d;
        float e;
        float f;
        final /* synthetic */ b g;

        public a(b bVar) {
            this.g = bVar;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b bVar;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f27467a = motionEvent.getX();
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
            } else if (Math.abs(this.e - this.f27467a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f && (bVar = this.g) != null) {
                bVar.a(String.valueOf(this.f27467a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f27467a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d));
            }
            return true;
        }
    }

    public interface b {
        void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);
    }

    public k8(Context context, AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean, String str) {
        this.f27466a = context;
        this.b = fullScreenClickBean;
        AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBeanA = a(fullScreenClickBean.getOrderData(), str);
        if (orderDataFullScreenClickBeanA != null && orderDataFullScreenClickBeanA.getFullScreenClick() != null) {
            this.c = orderDataFullScreenClickBeanA.getFullScreenClick();
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean2 = this.c;
        if (fullScreenClickBean2 != null) {
            this.e = fullScreenClickBean2.getRandomClickNum();
            return;
        }
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClickBean3 = this.b;
        if (fullScreenClickBean3 != null) {
            this.e = fullScreenClickBean3.getRandomClickNum();
        }
    }

    public void a(View view, b bVar) {
        if (view == null || bVar == null || !a(this.e)) {
            return;
        }
        this.f = true;
        view.setOnTouchListener(new a(bVar));
    }

    public void b() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.f27466a = null;
    }

    public static boolean a(int i) {
        return ((int) ((Math.random() * 100.0d) + 1.0d)) <= i;
    }

    private AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean a(List list, String str) {
        if (list != null && str != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean orderDataFullScreenClickBean = (AdSpacesBean.BuyerBean.OrderDataFullScreenClickBean) it.next();
                List<String> orderList = orderDataFullScreenClickBean.getOrderList();
                if (orderList != null && orderList.contains(str)) {
                    return orderDataFullScreenClickBean;
                }
            }
        }
        return null;
    }

    public boolean a() {
        return this.f;
    }
}
