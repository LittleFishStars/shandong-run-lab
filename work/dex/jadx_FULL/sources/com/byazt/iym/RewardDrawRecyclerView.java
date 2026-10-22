package com.byazt.iym;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import com.byazt.kt.RecyclerView;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 784, 1570})
public class RewardDrawRecyclerView extends RecyclerView {
    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.byazt.kt.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.byazt.kt.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        m.uj("lfz", motionEvent.toString());
        return false;
    }
}
