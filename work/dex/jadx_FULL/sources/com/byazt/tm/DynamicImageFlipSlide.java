package com.byazt.tm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.aq.x;
import com.byazt.nk.z;
import com.byazt.oq.ImageFlipSlideGroup;
import com.byazt.xl.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1632})
@SuppressLint({"ViewConstructor"})
public class DynamicImageFlipSlide extends DynamicImageView {
    public final ImageFlipSlideGroup c;
    public final tt tt;

    public interface c {
        void c();
    }

    public interface tt {
        void c(c cVar);
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.tt = new tt() { // from class: com.byazt.tm.DynamicImageFlipSlide.1
            @Override // com.byazt.tm.DynamicImageFlipSlide.tt
            public void c(c cVar) {
                if (DynamicImageFlipSlide.this.c != null) {
                    DynamicImageFlipSlide.this.c.c(cVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().ca(), "slide"));
        this.c = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidget
    public com.byazt.wl.c getDynamicClickListener() {
        com.byazt.wl.c dynamicClickListener = this.yp.getDynamicClickListener();
        return this.t.g() ? new ve(dynamicClickListener, this.tt) : dynamicClickListener;
    }

    @Override // com.byazt.tm.DynamicImageView, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.c();
    }

    @Override // com.byazt.tm.DynamicImageView, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c.tt();
    }

    @Override // com.byazt.tm.DynamicImageView, com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        this.c.c(this.t.sl(), tt(this.t.sl()));
        this.c.tt(this.t.f(), tt(this.t.f()));
        this.c.setFilterColors(this.t.ir());
        this.c.ve();
        return true;
    }

    @com.byazt.zqa.c(c = {0, 1, 48, 1971})
    public static class ve implements View.OnClickListener, View.OnTouchListener, com.byazt.wl.c {
        public com.byazt.wl.c c;
        public tt tt;

        public ve(com.byazt.wl.c cVar, tt ttVar) {
            this.c = cVar;
            this.tt = ttVar;
        }

        @Override // com.byazt.wl.c
        public void c(View view) {
            com.byazt.wl.c cVar = this.c;
            if (cVar != null) {
                cVar.c(view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            tt ttVar = this.tt;
            if (ttVar != null) {
                ttVar.c(new c() { // from class: com.byazt.tm.DynamicImageFlipSlide.ve.1
                    @Override // com.byazt.tm.DynamicImageFlipSlide.c
                    public void c() {
                        com.byazt.wl.c cVar = ve.this.c;
                        if (cVar instanceof View.OnClickListener) {
                            ((View.OnClickListener) cVar).onClick(view);
                        }
                    }
                });
                return;
            }
            com.byazt.wl.c cVar = this.c;
            if (cVar instanceof View.OnClickListener) {
                ((View.OnClickListener) cVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.byazt.wl.c cVar = this.c;
            if (cVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) cVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.byazt.wl.c
        public void tt(View view) {
            com.byazt.wl.c cVar = this.c;
            if (cVar != null) {
                cVar.tt(view);
            }
        }

        @Override // com.byazt.wl.c
        public void c(sl slVar) {
            com.byazt.wl.c cVar = this.c;
            if (cVar != null) {
                cVar.c(slVar);
            }
        }

        @Override // com.byazt.wl.c
        public void c(boolean z, z zVar) {
            com.byazt.wl.c cVar = this.c;
            if (cVar != null) {
                cVar.c(z, zVar);
            }
        }

        @Override // com.byazt.wl.c
        public void c(JSONObject jSONObject) {
            com.byazt.wl.c cVar = this.c;
            if (cVar != null) {
                cVar.c(jSONObject);
            }
        }
    }
}
