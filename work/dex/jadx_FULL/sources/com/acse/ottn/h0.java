package com.acse.ottn;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.adapter.AutoScrollViewPager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h0 f23021a = null;
    public static String b = "ButtonColorUtil";

    public static h0 a() {
        if (f23021a == null) {
            synchronized (h0.class) {
                if (f23021a == null) {
                    f23021a = new h0();
                }
            }
        }
        return f23021a;
    }

    public void b(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(l0.t)) {
            textView.setBackgroundResource(R.drawable.accessibilty_ydsj_green_button);
        } else if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            textView.setBackgroundResource(R.drawable.accessibilty_green_button);
        } else {
            textView.setBackgroundResource(R.drawable.accessibilty_sdxu_button);
            textView.setTextColor(Color.parseColor("#0AD3FF"));
        }
    }

    public String c(Activity activity) {
        return (activity.getPackageName().equals(l0.t) || activity.getPackageName().equals(l0.w) || activity.getPackageName().equals(l0.x) || activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) ? "https://www.idazhe.net/course/snt-privacyagreement?name=DETN" : "https://www.idazhe.net/course/snt-privacyagreement?name=省钱助手";
    }

    public void d(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            textView.setTextColor(Color.parseColor("#0AD3FF"));
        }
    }

    public void e(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(l0.t)) {
            textView.setTextColor(Color.parseColor("#5FCA8B"));
        } else if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            textView.setTextColor(Color.parseColor("#0AD3FF"));
        } else {
            textView.setTextColor(Color.parseColor("#3ECDA1"));
        }
    }

    public void f(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(l0.t)) {
            textView.setBackgroundResource(R.drawable.accessibilty_ydsj_green_button);
        } else if (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            textView.setBackgroundResource(R.drawable.accessibilty_sdxu_warn_button);
        } else {
            textView.setBackgroundResource(R.drawable.accessibilty_green_button);
        }
    }

    public String d(Activity activity) {
        if (activity.getPackageName().equals(l0.t)) {
            return "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/userService.html";
        }
        if (activity.getPackageName().equals(l0.w)) {
            return "https://www.boxkj.com/resources/user_agreement_info.html";
        }
        if (activity.getPackageName().equals(l0.x)) {
            return "https://api2.lptiyu.com/v3/api.php/Login/user_notice";
        }
        if (activity.getPackageName().equals(l0.u)) {
            return "https://mh5.huachenjie.com/h5/contract/document.html?code=501";
        }
        return activity.getPackageName().equals(l0.v) ? "https://mh5.huachenjie.com/h5/contract/document.html?code=801" : "";
    }

    public void c(Activity activity, TextView textView) {
        if (activity.getPackageName().equals(l0.t)) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(0);
        }
    }

    public String e(Activity activity) {
        return (activity.getPackageName().equals(l0.t) || activity.getPackageName().equals(l0.w) || activity.getPackageName().equals(l0.x) || activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) ? "https://www.idazhe.net/course/snt-serviceagreement?name=DETN" : "https://www.idazhe.net/course/snt-serviceagreement?name=省钱助手";
    }

    public String f(Activity activity) {
        if (activity.getPackageName().equals(l0.t)) {
            return "#5FCA8B";
        }
        return (activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) ? "#0AD3FF" : "#3ECDA1";
    }

    public void a(Activity activity, TextView textView) {
        textView.setBackgroundColor(Color.parseColor("#DEE2EC"));
    }

    public void b(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(l0.t)) {
            imageView.setImageResource(R.mipmap.sjxy_warning);
            return;
        }
        if (activity.getPackageName().equals(l0.x)) {
            imageView.setImageResource(R.mipmap.bdlp_warning);
        } else if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            imageView.setImageResource(R.mipmap.warning);
        } else {
            imageView.setImageResource(R.mipmap.sdxy_warning);
        }
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2) {
        imageView2.setVisibility(8);
        imageView.setVisibility(0);
        if (activity.getPackageName().equals(l0.t)) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(R.mipmap.run_dialog_icon);
            return;
        }
        if (activity.getPackageName().equals(l0.x)) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.bdlp_running_icon);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams);
            return;
        }
        if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setImageResource(R.mipmap.running_icon);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(14);
            layoutParams2.setMargins(0, 60, 0, 0);
            imageView.setLayoutParams(layoutParams2);
            return;
        }
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.mipmap.sdxy_run_icon);
    }

    public String b(Activity activity) {
        if (activity.getPackageName().equals(l0.t)) {
            return "https://h5.gxapp.iydsj.com/gxapp/privacy_policy/index.html";
        }
        if (activity.getPackageName().equals(l0.w)) {
            return "https://www.boxkj.com/resources/user_agreement.html";
        }
        if (activity.getPackageName().equals(l0.x)) {
            return "https://api2.lptiyu.com/v3/api.php/Login/user_privacy";
        }
        if (activity.getPackageName().equals(l0.u)) {
            return "https://mh5.huachenjie.com/h5/contract/document.html?code=502";
        }
        return activity.getPackageName().equals(l0.v) ? "https://mh5.huachenjie.com/h5/contract/document.html?code=802" : "";
    }

    public void b(Activity activity, RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundColor(Color.parseColor("#F3F3F3"));
    }

    public void a(Activity activity, ImageView imageView) {
        if (activity.getPackageName().equals(l0.t)) {
            imageView.setImageResource(R.mipmap.ydsj_up);
        } else if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            imageView.setImageResource(R.mipmap.up_green);
        } else {
            imageView.setImageResource(R.mipmap.sdxy_up);
        }
    }

    public void a(Activity activity, View view) {
        if (!activity.getPackageName().equals(l0.t) && !activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v) && !activity.getPackageName().equals(l0.w) && !activity.getPackageName().equals(l0.x)) {
            view.setVisibility(8);
        } else {
            view.setVisibility(0);
        }
    }

    public boolean a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, AutoScrollViewPager autoScrollViewPager, ImageView imageView5) {
        if (activity.getPackageName().equals(l0.t)) {
            autoScrollViewPager.setVisibility(8);
            imageView5.setImageResource(R.mipmap.yundong);
            imageView.setImageResource(R.mipmap.ydsj_accessiblity_green);
            imageView3.setImageResource(R.mipmap.ydsj_flow_window_green);
            imageView2.setImageResource(R.mipmap.ydsj_location_green_position);
            imageView4.setImageResource(R.mipmap.ydsj_battery_green);
            return true;
        }
        if (activity.getPackageName().equals(l0.x)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.bdlp_banner);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        }
        if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            autoScrollViewPager.setVisibility(8);
            imageView.setImageResource(R.mipmap.accessiblity_green_logo);
            imageView2.setImageResource(R.mipmap.location_green_position);
            imageView3.setImageResource(R.mipmap.flow_window_green);
            imageView5.setImageResource(R.mipmap.banner_6);
            imageView4.setImageResource(R.mipmap.battery_green_icon);
            return true;
        }
        autoScrollViewPager.setVisibility(8);
        imageView.setImageResource(R.mipmap.shandong_fuzhu_s);
        imageView2.setImageResource(R.mipmap.shandong_dingwei_s);
        imageView3.setImageResource(R.mipmap.shandong_xuanfu_s);
        imageView5.setImageResource(R.mipmap.ic_shandong_banner);
        imageView4.setImageResource(R.mipmap.shandong_houtai_s);
        return true;
    }

    public void a(Activity activity, TextPaint textPaint) {
        if (activity.getPackageName().equals(l0.t)) {
            textPaint.setColor(Color.parseColor("#5FCA8B"));
        } else if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            textPaint.setColor(Color.parseColor("#3ECDA1"));
        } else {
            textPaint.setColor(Color.parseColor("#0AD3FF"));
        }
    }

    public String a(Context context) {
        if (context.getPackageName().equals(l0.t)) {
            return "wxd67633bd92006e63";
        }
        if (context.getPackageName().equals(l0.u) || context.getPackageName().equals(l0.v)) {
            return "wx15d677743c454371";
        }
        if (context.getPackageName().equals(l0.x)) {
            return "wx5a2e1ff396785475";
        }
        return context.getPackageName().equals(l0.w) ? "wxc9214f296e1fba92" : "wx0b99368ff4dd7868";
    }

    public void a(Activity activity, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, TextView textView) {
        int i = R.mipmap.premission_unreadly;
        imageView.setImageResource(i);
        imageView3.setImageResource(i);
        imageView2.setImageResource(i);
        imageView4.setImageResource(i);
        int i2 = R.drawable.permission_background;
        relativeLayout.setBackgroundResource(i2);
        relativeLayout3.setBackgroundResource(i2);
        relativeLayout4.setBackgroundResource(i2);
        relativeLayout2.setBackgroundResource(i2);
        textView.setText("允许后台使用精准定位，以便持续记录跑步轨迹。");
        if (activity.getPackageName().equals(l0.t)) {
            if (b.c().e()) {
                imageView.setImageResource(R.mipmap.permission_readly);
                relativeLayout.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (b.c().a()) {
                imageView3.setImageResource(R.mipmap.permission_readly);
                relativeLayout3.setBackgroundResource(R.drawable.permission_green_background);
            }
            if (g2.a().a((Context) activity) && g2.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly);
                relativeLayout2.setBackgroundResource(R.drawable.permission_green_background);
            } else if (n3.a().c("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (d5.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly);
                relativeLayout4.setBackgroundResource(R.drawable.permission_green_background);
                return;
            }
            return;
        }
        if (!activity.getPackageName().equals(l0.u) && !activity.getPackageName().equals(l0.v)) {
            if (b.c().e()) {
                imageView.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (g2.a().a((Context) activity) && g2.a().b((Context) activity)) {
                imageView2.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout2.setBackgroundResource(R.drawable.permission_tsn_green_background);
            } else if (n3.a().c("location_permission_size") > 2) {
                imageView2.setImageResource(R.mipmap.premission_location_exceptional);
                textView.setText("开启异常请在设置中手动开启");
                textView.setTextColor(Color.parseColor("#FD5439"));
            }
            if (b.c().a()) {
                imageView3.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout3.setBackgroundResource(R.drawable.permission_tsn_green_background);
            }
            if (d5.a().b(activity.getPackageName())) {
                imageView4.setImageResource(R.mipmap.permission_readly_tsn);
                relativeLayout4.setBackgroundResource(R.drawable.permission_tsn_green_background);
                return;
            }
            return;
        }
        if (b.c().e()) {
            imageView.setImageResource(R.mipmap.shandong_select);
            relativeLayout.setBackgroundResource(R.drawable.permission_sd_background);
        }
        if (b.c().a()) {
            imageView3.setImageResource(R.mipmap.shandong_select);
            relativeLayout3.setBackgroundResource(R.drawable.permission_sd_background);
        }
        if (g2.a().a((Context) activity) && g2.a().b((Context) activity)) {
            imageView2.setImageResource(R.mipmap.shandong_select);
            relativeLayout2.setBackgroundResource(R.drawable.permission_sd_background);
        } else if (n3.a().c("location_permission_size") > 2) {
            imageView2.setImageResource(R.mipmap.premission_location_exceptional);
            textView.setText("开启异常请在设置中手动开启");
            textView.setTextColor(Color.parseColor("#FD5439"));
        }
        if (d5.a().b(activity.getPackageName())) {
            imageView4.setImageResource(R.mipmap.shandong_select);
            relativeLayout4.setBackgroundResource(R.drawable.permission_sd_background);
        }
    }

    public void a(Activity activity, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        if (activity.getPackageName().equals(l0.t) || activity.getPackageName().equals(l0.w) || activity.getPackageName().equals(l0.x) || activity.getPackageName().equals(l0.u) || activity.getPackageName().equals(l0.v)) {
            textView.setText("警告");
            textView2.setText("当前必要权限不完整，将无法记录准确的跑步轨迹，可能会影响您的跑步成绩! \n \n您仍然可以开始跑步，但建议您保持程序一直在前台运行，并保持屏幕常亮，以便记录成绩。\n");
            textView3.setText("继续使用");
            textView4.setText("尝试开权限");
        }
    }

    public void a(Activity activity, TextView textView, TextView textView2) {
        if (textView != null) {
            textView.setTextColor(-16777216);
        }
        if (textView2 != null) {
            textView2.setTextColor(Color.parseColor("#4A4A4A"));
        }
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundResource(R.drawable.circle_rect_in);
    }

    public String a(Activity activity) {
        if (activity.getPackageName().equals(l0.t)) {
            return "👉【运动世界】—请启用🏃";
        }
        if (activity.getPackageName().equals(l0.w)) {
            return "👉【体适能】—请启用🏃";
        }
        if (activity.getPackageName().equals(l0.x)) {
            return "👉【步道乐跑】—请启用🏃";
        }
        if (activity.getPackageName().equals(l0.u)) {
            return "👉【闪动校园】—请启用🏃";
        }
        return activity.getPackageName().equals(l0.v) ? "👉【闪动校园Pro】—请启用🏃" : "👉【体适能demo】—请启用🏃";
    }
}
