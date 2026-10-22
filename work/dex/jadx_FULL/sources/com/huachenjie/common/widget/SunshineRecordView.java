package com.huachenjie.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.ll7;
import com.zj.adlib.s72;
import com.zj.adlib.xf7;
import com.zj.adlib.zn1;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class SunshineRecordView extends RelativeLayout {
    private LinearLayout llStatus;
    private ImageView mImgRunThumb;
    private TextView mIvMorning;
    private TextView mIvStatus;
    private TextView mTvCalories;
    private TextView mTvDuration;
    private TextView mTvPace;
    private TextView mTvRunDistance;
    private TextView mTvRunDistanceUnit;
    private TextView mTvTotal;
    private SportRecord runRecord;
    private boolean showAppeal;
    private boolean showAppealSucceedMark;
    private TextView tvActivityFlag;
    private TextView tvDateTime;
    private TextView tvErrorBtn;
    private TextView tvErrorInfo;
    private TextView tvFreeRunStatus;
    private TextView tvScene;
    private TextView tvUnexpectedData;
    private TextView tvVisioning;
    private View vScene;

    public SunshineRecordView(Context context) {
        super(context);
        this.showAppealSucceedMark = false;
        this.showAppeal = false;
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_sunshine_record, this);
        this.mImgRunThumb = (ImageView) findViewById(R.id.img_run_thumb);
        this.mTvRunDistance = (TextView) findViewById(R.id.tv_run_distance);
        this.mTvRunDistanceUnit = (TextView) findViewById(R.id.tv_run_distance_unit);
        this.mTvDuration = (TextView) findViewById(R.id.tv_duration);
        this.mTvPace = (TextView) findViewById(R.id.tv_pace);
        this.mTvCalories = (TextView) findViewById(R.id.tv_calories);
        this.mIvStatus = (TextView) findViewById(R.id.iv_status);
        this.mIvMorning = (TextView) findViewById(R.id.iv_morning);
        this.tvDateTime = (TextView) findViewById(R.id.tvDateTime);
        this.mTvTotal = (TextView) findViewById(R.id.tv_total);
        this.tvActivityFlag = (TextView) findViewById(R.id.tvActivityRun);
        this.tvUnexpectedData = (TextView) findViewById(R.id.tvUnexpectedData);
        this.llStatus = (LinearLayout) findViewById(R.id.llStatus);
        this.tvErrorInfo = (TextView) findViewById(R.id.tvErrorInfo);
        this.tvErrorBtn = (TextView) findViewById(R.id.tvErrorBtn);
        this.tvFreeRunStatus = (TextView) findViewById(R.id.tvFreeRunStatus);
        this.tvVisioning = (TextView) findViewById(R.id.tv_visioning);
        this.vScene = findViewById(R.id.v_scene);
        this.tvScene = (TextView) findViewById(R.id.tv_scene);
    }

    private void setRunScene(SportRecord runRecord) {
        int runScene = runRecord.getRunScene();
        if (runScene != 10 && runScene != 20 && runScene != 30) {
            this.vScene.setVisibility(8);
            this.tvScene.setVisibility(8);
            return;
        }
        this.vScene.setVisibility(0);
        this.tvScene.setVisibility(0);
        if (runScene == 10) {
            this.tvScene.setText("无感识别");
            this.tvScene.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.run_ic_run_record_vision, 0, 0, 0);
        } else if (runScene == 20) {
            this.tvScene.setText("人脸识别");
            this.tvScene.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.run_ic_run_record_face, 0, 0, 0);
        } else {
            this.tvScene.setText("打卡机");
            this.tvScene.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.run_ic_run_record_machine, 0, 0, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0231  */
    /* JADX WARN: Code duplicated, block: B:66:0x0240  */
    /* JADX WARN: Code duplicated, block: B:69:0x0249  */
    /* JADX WARN: Code duplicated, block: B:70:0x024b  */
    /* JADX WARN: Code duplicated, block: B:73:0x0253  */
    /* JADX WARN: Code duplicated, block: B:74:0x0255  */
    /* JADX WARN: Code duplicated, block: B:77:0x025f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0265  */
    /* JADX WARN: Code duplicated, block: B:82:0x026f  */
    /* JADX WARN: Code duplicated, block: B:86:0x0283  */
    /* JADX WARN: Code duplicated, block: B:87:0x0291  */
    /* JADX WARN: Code duplicated, block: B:89:0x0297  */
    /* JADX WARN: Code duplicated, block: B:92:0x02af  */
    /* JADX WARN: Code duplicated, block: B:94:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:95:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:97:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:98:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:99:0x02e9  */
    public void bindData(SportRecord runRecord) {
        String str;
        int i;
        int i2;
        int i3;
        this.runRecord = runRecord;
        boolean runActivityFlag = runRecord.getRunActivityFlag();
        boolean zIsMorningFlag = runRecord.isMorningFlag();
        this.mImgRunThumb.setImageDrawable(runActivityFlag ? xf7.f(R.drawable.record_actvivty_dark) : xf7.f(R.drawable.icon_run_map));
        setRunScene(runRecord);
        this.mIvMorning.setVisibility(zIsMorningFlag ? 0 : 8);
        this.tvActivityFlag.setVisibility(runRecord.getRunActivityFlag() ? 0 : 8);
        this.mImgRunThumb.setImageDrawable(runRecord.getRunActivityFlag() ? xf7.f(R.drawable.icon_run_activity) : xf7.f(R.drawable.icon_run_map));
        this.mTvRunDistance.setText(BigDecimal.valueOf(runRecord.getValidDistance()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP).toString());
        boolean z = true;
        this.mTvTotal.setText(String.format("本次总里程  %sKm", BigDecimal.valueOf(runRecord.getDistance()).divide(BigDecimal.valueOf(1000L), 3, RoundingMode.HALF_UP).toString()));
        this.mTvDuration.setText(s72.n(runRecord.getDuration()));
        this.mTvPace.setText(ll7.f43096a.p(runRecord.getPace(), true));
        this.tvDateTime.setText(s72.c(runRecord.getStartTime(), "MM/dd HH:mm"));
        this.mTvCalories.setText(BigDecimal.valueOf(runRecord.getCalorie()).divide(BigDecimal.valueOf(1000L), 0, RoundingMode.HALF_UP).toString());
        int sunRunRecordStatus = runRecord.getSunRunRecordStatus();
        boolean z2 = 1 == runRecord.getSportType();
        boolean z3 = 1 == runRecord.getSportType();
        String str2 = "本次跑步无效 / 不可申诉";
        String str3 = "";
        String str4 = "无效";
        if (sunRunRecordStatus != 2) {
            if (sunRunRecordStatus == 3) {
                this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_error);
                TextView textView = this.mTvRunDistance;
                int i4 = R.color.color_e7332d;
                textView.setTextColor(zn1.a(i4));
                this.mTvRunDistanceUnit.setTextColor(zn1.a(i4));
                this.tvVisioning.setVisibility(8);
                str3 = "点击申诉";
                str2 = "本次跑步无效";
                String str5 = str4;
                str = str3;
                str3 = str5;
            } else if (sunRunRecordStatus == 4) {
                this.mIvStatus.setBackgroundResource(this.showAppealSucceedMark ? R.drawable.bg_rect_record_state_report_ing : R.drawable.bg_rect_record_state_error);
                if (this.showAppealSucceedMark) {
                    z2 = false;
                    z3 = false;
                } else {
                    str3 = "无效";
                }
                TextView textView2 = this.mTvRunDistance;
                int i5 = R.color.color_e7332d;
                textView2.setTextColor(zn1.a(i5));
                this.mTvRunDistanceUnit.setTextColor(zn1.a(i5));
                this.tvVisioning.setVisibility(8);
                z = true;
                str = "申诉中";
                str2 = "本次跑步无效";
            } else if (sunRunRecordStatus != 5) {
                str = null;
                if (sunRunRecordStatus == 6) {
                    this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_ok);
                    str3 = this.showAppealSucceedMark ? "计入成绩 | 申诉成功" : "计入成绩";
                    this.mTvRunDistance.setTextColor(zn1.a(R.color.color_2C3E50));
                    this.mTvRunDistanceUnit.setTextColor(zn1.a(R.color.percent_80_translucent_2C3E50));
                    this.tvVisioning.setVisibility(8);
                    z = false;
                } else if (sunRunRecordStatus != 10) {
                    this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_ok);
                    this.mTvRunDistance.setTextColor(zn1.a(R.color.color_2C3E50));
                    this.mTvRunDistanceUnit.setTextColor(zn1.a(R.color.percent_80_translucent_2C3E50));
                    this.tvVisioning.setVisibility(8);
                    z = false;
                    str3 = "计入成绩";
                } else {
                    this.mTvRunDistance.setTextColor(zn1.a(R.color.color_2C3E50));
                    this.mTvRunDistanceUnit.setTextColor(zn1.a(R.color.percent_80_translucent_2C3E50));
                    this.tvVisioning.setVisibility(0);
                    z3 = true;
                    z = false;
                    z2 = false;
                }
                str2 = null;
            } else {
                this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_error);
                str4 = this.showAppealSucceedMark ? "无效 | 申诉失败" : "无效";
                TextView textView3 = this.mTvRunDistance;
                int i6 = R.color.color_e7332d;
                textView3.setTextColor(zn1.a(i6));
                this.mTvRunDistanceUnit.setTextColor(zn1.a(i6));
                this.tvVisioning.setVisibility(8);
            }
            if (runRecord.getRecheckStatus() == 2) {
                this.mIvStatus.setText("复核中");
                this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_morning_flag);
            } else {
                this.mIvStatus.setText(str3);
            }
            TextView textView4 = this.mIvStatus;
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            textView4.setVisibility(i);
            TextView textView5 = this.mTvTotal;
            if (z3) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            textView5.setVisibility(i2);
            if (runRecord.getArchiveState() == 1) {
                this.llStatus.setVisibility(8);
            } else {
                LinearLayout linearLayout = this.llStatus;
                if (this.showAppeal || !z) {
                    i3 = 8;
                } else {
                    i3 = 0;
                }
                linearLayout.setVisibility(i3);
            }
            this.tvUnexpectedData.setVisibility(8);
            this.tvErrorInfo.setText(str2);
            if ("申诉中".equals(str)) {
                this.tvErrorBtn.setTextColor(RunIndexRecordAdapter.O);
                this.tvErrorBtn.setClickable(false);
            } else if (!TextUtils.isEmpty(str)) {
                this.tvErrorBtn.setTextColor(-10155284);
                this.tvErrorBtn.setClickable(true);
            }
            this.tvErrorBtn.setText(str);
            if (runRecord.getSportType() == 2) {
                this.tvFreeRunStatus.setVisibility(8);
                return;
            }
            if (runRecord.getStatus() == 1) {
                this.tvFreeRunStatus.setVisibility(0);
                this.tvFreeRunStatus.setText("目标失败");
                this.tvFreeRunStatus.setBackgroundResource(R.drawable.bg_rect_record_state_error);
            } else {
                if (runRecord.getStatus() == 2) {
                    this.tvFreeRunStatus.setVisibility(8);
                    return;
                }
                this.tvFreeRunStatus.setVisibility(0);
                this.tvFreeRunStatus.setText("目标达成");
                this.tvFreeRunStatus.setBackgroundResource(R.drawable.bg_rect_record_state_ok);
            }
        }
        this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_error);
        TextView textView6 = this.mTvRunDistance;
        int i7 = R.color.color_e7332d;
        textView6.setTextColor(zn1.a(i7));
        this.mTvRunDistanceUnit.setTextColor(zn1.a(i7));
        this.tvVisioning.setVisibility(8);
        String str6 = str4;
        str = str3;
        str3 = str6;
        if (runRecord.getRecheckStatus() == 2) {
            this.mIvStatus.setText("复核中");
            this.mIvStatus.setBackgroundResource(R.drawable.bg_rect_record_state_morning_flag);
        } else {
            this.mIvStatus.setText(str3);
        }
        TextView textView7 = this.mIvStatus;
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        textView7.setVisibility(i);
        TextView textView8 = this.mTvTotal;
        if (z3) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView8.setVisibility(i2);
        if (runRecord.getArchiveState() == 1) {
            this.llStatus.setVisibility(8);
        } else {
            LinearLayout linearLayout2 = this.llStatus;
            if (this.showAppeal) {
                i3 = 8;
            } else {
                i3 = 8;
            }
            linearLayout2.setVisibility(i3);
        }
        this.tvUnexpectedData.setVisibility(8);
        this.tvErrorInfo.setText(str2);
        if ("申诉中".equals(str)) {
            this.tvErrorBtn.setTextColor(RunIndexRecordAdapter.O);
            this.tvErrorBtn.setClickable(false);
        } else if (!TextUtils.isEmpty(str)) {
            this.tvErrorBtn.setTextColor(-10155284);
            this.tvErrorBtn.setClickable(true);
        }
        this.tvErrorBtn.setText(str);
        if (runRecord.getSportType() == 2) {
            this.tvFreeRunStatus.setVisibility(8);
            return;
        }
        if (runRecord.getStatus() == 1) {
            this.tvFreeRunStatus.setVisibility(0);
            this.tvFreeRunStatus.setText("目标失败");
            this.tvFreeRunStatus.setBackgroundResource(R.drawable.bg_rect_record_state_error);
        } else {
            if (runRecord.getStatus() == 2) {
                this.tvFreeRunStatus.setVisibility(8);
                return;
            }
            this.tvFreeRunStatus.setVisibility(0);
            this.tvFreeRunStatus.setText("目标达成");
            this.tvFreeRunStatus.setBackgroundResource(R.drawable.bg_rect_record_state_ok);
        }
    }

    public SportRecord getRunRecord() {
        return this.runRecord;
    }

    public void hideLogoAndShowTime() {
        this.tvDateTime.setVisibility(0);
        this.mImgRunThumb.setVisibility(8);
    }

    public void setShowAppeal(boolean showAppeal) {
        this.showAppeal = showAppeal;
    }

    public void setShowAppealSucceedMark(boolean isShow) {
        this.showAppealSucceedMark = isShow;
    }

    public SunshineRecordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.showAppealSucceedMark = false;
        this.showAppeal = false;
        initView(context);
    }

    public SunshineRecordView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.showAppealSucceedMark = false;
        this.showAppeal = false;
        initView(context);
    }
}
