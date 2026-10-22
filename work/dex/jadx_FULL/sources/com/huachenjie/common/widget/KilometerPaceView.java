package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.PaceInfo;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.s72;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class KilometerPaceView extends LinearLayout {
    private static final int COLOR_FASTEST = -13196801;
    private static final int COLOR_NORMAL = -16002049;
    private TextView mKilometerNo;
    private ViewGroup mPaceBar;
    private TextView mTvFastestTag;
    private TextView mTvPace;

    public KilometerPaceView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_kilometer_pace, this);
        this.mPaceBar = (ViewGroup) findViewById(R.id.ll_pace_bar);
        this.mKilometerNo = (TextView) findViewById(R.id.tv_kilometer_num);
        this.mTvPace = (TextView) findViewById(R.id.tv_pace);
        this.mTvFastestTag = (TextView) findViewById(R.id.tv_fastest_pace_tag);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateBarWidth$0(int i) {
        int width;
        ViewGroup viewGroup = (ViewGroup) this.mPaceBar.getParent();
        if (viewGroup != null && (width = viewGroup.getWidth() - this.mKilometerNo.getWidth()) > 0) {
            int iB = SizeUtils.b(this.mTvFastestTag.getVisibility() == 0 ? 72.0f : 49.0f);
            ViewGroup.LayoutParams layoutParams = this.mPaceBar.getLayoutParams();
            layoutParams.width = Math.max(iB, (width * Math.max(i, 1)) / 100);
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).weight = 0.0f;
            }
            this.mPaceBar.setLayoutParams(layoutParams);
        }
    }

    private void updateBarWidth(final int percents) {
        this.mPaceBar.post(new Runnable() { // from class: com.zj.adlib.qs4
            @Override // java.lang.Runnable
            public final void run() {
                this.f44290a.lambda$updateBarWidth$0(percents);
            }
        });
    }

    public void bindData(PaceInfo paceInfo) {
        if (paceInfo == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (paceInfo.isLessThanKilo()) {
            sb.append("＜");
        }
        sb.append(paceInfo.getKilometerNo());
        this.mKilometerNo.setText(sb);
        this.mTvFastestTag.setVisibility(paceInfo.isFasePace() ? 0 : 8);
        this.mTvPace.setText(s72.e(paceInfo.getPace()));
        this.mPaceBar.setBackground(new DrawableCreator.Builder().setCornersRadius(SizeUtils.b(8.0f)).setSolidColor(paceInfo.isFasePace() ? -13196801 : COLOR_NORMAL).build());
        updateBarWidth(paceInfo.getPercents());
    }

    public KilometerPaceView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public KilometerPaceView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
}
