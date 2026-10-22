package com.byazt.rpt;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 311, WorksInteractEventBean.EVENT_TYPE_COMMENT_POST_DETAIL_UNLIKE})
public class PlayableEndcardFrameLayout extends FrameLayout {
    public c c;
    public int tt;

    public interface c {
        void c();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void c(c cVar) {
        this.c = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.tt = y;
        } else if (action == 2 && Math.abs(this.tt - y) > 100) {
            c();
            this.tt = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void c() {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }
}
