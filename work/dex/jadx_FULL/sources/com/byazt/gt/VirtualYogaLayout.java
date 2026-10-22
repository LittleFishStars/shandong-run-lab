package com.byazt.gt;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.bj.da;
import com.byazt.bj.sl;
import com.byazt.bj.sp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_GET_UMT_FAILED})
public class VirtualYogaLayout extends ViewGroup {
    public final List<View> c;
    public final Map<View, da> tt;
    public final da ve;

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.c(this);
            da yogaNode = virtualYogaLayout.getYogaNode();
            da daVar = this.ve;
            daVar.c(yogaNode, daVar.c());
            return;
        }
        da daVarC = sl.c();
        YogaLayout.c(new YogaLayout.c(layoutParams), daVarC, view);
        daVarC.c(view);
        daVarC.c((sp) new YogaLayout.tt());
        da daVar2 = this.ve;
        daVar2.c(daVarC, daVar2.c());
        c(view, daVarC);
    }

    public void c(View view, da daVar) {
        this.c.add(view);
        this.tt.put(view, daVar);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.c;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.c(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.c(layoutParams);
    }

    public da getYogaNode() {
        return this.ve;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.c) {
                ((VirtualYogaLayout) viewGroup).c(view, this.tt.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.c) {
                ((YogaLayout) viewGroup).c(view2, this.tt.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.c.clear();
    }
}
