package com.acse.ottn;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u4 {
    public static u4 b = null;
    public static String c = "VideoSoftwareUtil";
    public static CountDownTimer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f23270a;

    public class a implements n0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f23271a;

        public a(AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f23271a = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.n0.d
        public void a() {
        }

        @Override // com.acse.ottn.n0.d
        @RequiresApi(api = 16)
        public void a(long j) {
            CountDownTimer countDownTimer;
            u4.this.f23270a = new ArrayList();
            u4.this.a(this.f23271a);
            u4 u4Var = u4.this;
            if (!u4Var.a(u4Var.f23270a) || (countDownTimer = u4.d) == null) {
                return;
            }
            countDownTimer.cancel();
            u4.d = null;
        }
    }

    public static u4 a() {
        if (b == null) {
            synchronized (u4.class) {
                if (b == null) {
                    b = new u4();
                }
            }
        }
        return b;
    }

    public final Object b() throws ObjectStreamException {
        return b;
    }

    @RequiresApi(api = 16)
    public void a(ShopHelperService shopHelperService) {
        CountDownTimer countDownTimerA = n0.a().a(3500, 1000, new a(shopHelperService.getRootInActiveWindow()));
        d = countDownTimerA;
        countDownTimerA.start();
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            if (accessibilityNodeInfo.getText() != null) {
                String strTrim = accessibilityNodeInfo.getText().toString().trim();
                if (TextUtils.isEmpty(strTrim)) {
                    return;
                }
                this.f23270a.add(strTrim);
                return;
            }
            return;
        }
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).trim().equals("合计:")) {
                    h2.a(c, "合计:" + i);
                    int i2 = i + 1;
                    if (list.size() <= i2) {
                        return false;
                    }
                    if (list.get(i2).trim().length() > 0) {
                        h2.a(c, "合计:" + list.get(i2));
                        return true;
                    }
                }
            }
            return false;
        }
        h2.a(c, "lists = null");
        return false;
    }
}
