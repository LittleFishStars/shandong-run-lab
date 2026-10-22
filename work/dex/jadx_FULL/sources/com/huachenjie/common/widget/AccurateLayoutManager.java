package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class AccurateLayoutManager extends LinearLayoutManager {
    private int height;
    private final Map<Integer, Integer> heightMap;
    PositionLayoutCompleted positionLayoutCompleted;

    public interface PositionLayoutCompleted {
        int onComplete(Map<Integer, Integer> heightMap, int recyclerViewWidth, int recyclerViewHeight);

        void onCompleteVisibleItem(int position, int height, int recyclerViewWidth, int recyclerViewHeight);
    }

    public AccurateLayoutManager(Context context) {
        super(context);
        this.height = 0;
        this.heightMap = new HashMap();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        View viewFindViewByPosition = findViewByPosition(iFindFirstVisibleItemPosition);
        int iIntValue = 0;
        for (int i = 0; i < iFindFirstVisibleItemPosition; i++) {
            if (this.heightMap.containsKey(Integer.valueOf(i))) {
                iIntValue += this.heightMap.get(Integer.valueOf(i)).intValue();
            }
        }
        return viewFindViewByPosition != null ? iIntValue - viewFindViewByPosition.getTop() : iIntValue;
    }

    public Map<Integer, Integer> getHeightMap() {
        return this.heightMap;
    }

    public int getTopForPosition(int position) {
        if (position < 0) {
            return 0;
        }
        int iIntValue = 0;
        for (int i = 0; i < position; i++) {
            if (this.heightMap.containsKey(Integer.valueOf(i))) {
                iIntValue += this.heightMap.get(Integer.valueOf(i)).intValue();
            }
        }
        return iIntValue;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        int iFindFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = findLastVisibleItemPosition();
        int width = getWidth();
        int height = getHeight();
        if (iFindFirstVisibleItemPosition < 0 || iFindLastVisibleItemPosition < 0) {
            return;
        }
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                int height2 = childAt.getHeight();
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int i2 = height2 + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                int position = getPosition(childAt);
                this.heightMap.put(Integer.valueOf(position), Integer.valueOf(i2));
                PositionLayoutCompleted positionLayoutCompleted = this.positionLayoutCompleted;
                if (positionLayoutCompleted != null) {
                    positionLayoutCompleted.onCompleteVisibleItem(position, i2, width, height);
                }
            }
        }
    }

    public void setPositionLayoutCompleted(PositionLayoutCompleted positionLayoutCompleted) {
        this.positionLayoutCompleted = positionLayoutCompleted;
    }

    public AccurateLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        this.height = 0;
        this.heightMap = new HashMap();
    }

    public AccurateLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.height = 0;
        this.heightMap = new HashMap();
    }
}
