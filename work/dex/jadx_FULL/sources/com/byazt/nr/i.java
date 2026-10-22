package com.byazt.nr;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME, 42})
public class i extends TouchDelegate {
    public View c;
    public int n;
    public Rect tt;
    public boolean uj;
    public Rect ve;

    public i(Rect rect, View view) {
        super(rect, view);
        this.tt = rect;
        this.n = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        Rect rect2 = new Rect(rect);
        this.ve = rect2;
        int i = this.n;
        rect2.inset(-i, -i);
        this.c = view;
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zContains;
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1 || action == 2) {
                boolean z2 = this.uj;
                zContains = z2 ? this.ve.contains(x, y) : true;
                z = z2;
            } else if (action != 3) {
                zContains = true;
                z = false;
            } else {
                boolean z3 = this.uj;
                this.uj = false;
                z = z3;
                zContains = true;
            }
        } else if (this.tt.contains(x, y)) {
            this.uj = true;
            zContains = true;
        } else {
            this.uj = false;
            zContains = true;
            z = false;
        }
        if (!z) {
            return false;
        }
        View view = this.c;
        if (zContains) {
            motionEvent.setLocation(view.getWidth() / 2, view.getHeight() / 2);
        } else {
            float f = -(this.n * 2);
            motionEvent.setLocation(f, f);
        }
        if (view.getVisibility() == 0) {
            return view.dispatchTouchEvent(motionEvent);
        }
        return false;
    }
}
