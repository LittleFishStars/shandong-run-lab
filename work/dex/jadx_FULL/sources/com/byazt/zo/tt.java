package com.byazt.zo;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 13})
public class tt extends c {
    public tt() {
    }

    @Override // com.byazt.zo.c
    public int c(Map<String, Object> map, ve veVar) {
        return !tt(this.uj) ? 1 : 0;
    }

    public boolean tt(View view) {
        if (view != null && this.c != null) {
            String strValueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(strValueOf)) {
                if ("click".equals(strValueOf)) {
                    return this.ve.x();
                }
                return true;
            }
            Context context = this.tt;
            if (context == null) {
                context = gt.getContext();
            }
            if (c(view, context)) {
                return this.c.f() != 1 || this.ve.x();
            }
            if (this.c.yf() == 1 && !this.ve.x()) {
                return false;
            }
        }
        return true;
    }

    public tt(ic icVar, Context context) {
        this.c = icVar;
        this.tt = context;
    }

    public boolean c(View view, Context context) {
        int id = view.getId();
        List<Integer> listYp = this.ve.yp();
        if (listYp != null && listYp.size() == 0) {
            listYp.add(2114387830);
            listYp.add(2114387864);
            listYp.add(2114387633);
            listYp.add(2114387466);
            listYp.add(2114387468);
            listYp.add(2114387962);
            listYp.add(2114387625);
        }
        return listYp != null && listYp.contains(Integer.valueOf(id));
    }

    public boolean c(View view, Point point) {
        int i;
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Context context = this.tt;
                if (context == null) {
                    context = gt.getContext();
                }
                if (c(childAt, context)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    int i4 = point.x;
                    int i5 = iArr[0];
                    return i4 >= i5 && i4 <= i5 + childAt.getWidth() && (i = point.y) >= (i2 = iArr[1]) && i <= i2 + childAt.getHeight();
                }
                if (c(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
