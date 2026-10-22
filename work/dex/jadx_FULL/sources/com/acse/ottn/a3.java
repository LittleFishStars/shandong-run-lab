package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.Base64;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectStreamException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a3 {
    public static a3 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AccessibilityService f22785a;
    public boolean b = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22786a;
        public final /* synthetic */ int b;

        public a(int i, int i2) {
            this.f22786a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a3.this.f22785a == null) {
                h2.c("samon-->", "mService is null");
            } else if (l0.e) {
                try {
                    if (n3.a().e("ocr_screen_scroll").equals("1")) {
                        com.acse.ottn.b.c().a(a3.this.f22785a, this.f22786a, this.b);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.e && n3.a().e("ocr_screen_scroll").equals("1")) {
                com.acse.ottn.b.c().a(a3.this.f22785a, 520, 520, 520, 420, 250);
            }
        }
    }

    public class c implements AccessibilityService.TakeScreenshotCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f22788a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
            this.f22788a = accessibilityNodeInfo;
            this.b = str;
            this.c = str2;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i) {
            h2.c("samon ScreenShotResult", "onFailure code is " + i);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            int i;
            int i2;
            int iC;
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                Rect rect = new Rect();
                this.f22788a.getBoundsInScreen(rect);
                if ("1".equals(this.b)) {
                    i2 = rect.top - 90;
                    iC = p4.c(a3.this.f22785a);
                    i = 155;
                } else {
                    i = 150;
                    if ("2".equals(this.b) || "3".equals(this.b)) {
                        i2 = rect.bottom + 10;
                        iC = p4.c(a3.this.f22785a);
                    } else if ("4".equals(this.b)) {
                        i2 = rect.bottom + 20;
                        iC = p4.c(a3.this.f22785a);
                    } else if ("5".equals(this.b)) {
                        i2 = rect.top - 150;
                        iC = p4.c(a3.this.f22785a);
                    } else {
                        i2 = 0;
                        iC = 0;
                        i = 0;
                    }
                }
                if (i2 <= p4.b(a3.this.f22785a) && iC != 0 && i != 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapWrapHardwareBuffer, 0, i2, iC, i);
                    a3.this.a(bitmapCreateBitmap, this.c);
                    a3.this.b(bitmapCreateBitmap, this.c);
                }
            } catch (Throwable th) {
                h2.c("samon croppedImage", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public class d implements AccessibilityService.TakeScreenshotCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f22789a;
        public final /* synthetic */ int b;

        public d(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            this.f22789a = accessibilityNodeInfo;
            this.b = i;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i) {
            h2.c("samon startCroppedTitle", "onFailure code is " + i);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                Rect rect = new Rect();
                this.f22789a.getBoundsInScreen(rect);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapWrapHardwareBuffer, 0, 0, rect.right - rect.left, this.b);
                a3.this.a(bitmapCreateBitmap, "3");
                a3.this.b(bitmapCreateBitmap, "3");
            } catch (Throwable th) {
                h2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public class e implements AccessibilityService.TakeScreenshotCallback {
        public e() {
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i) {
            h2.c("samon startCroppedTitle", "onFailure code is " + i);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                a3.this.a(bitmapWrapHardwareBuffer, "3");
                a3.this.b(bitmapWrapHardwareBuffer, "3");
            } catch (Throwable th) {
                h2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public class f implements AccessibilityService.TakeScreenshotCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f22791a;
        public final /* synthetic */ int b;

        public f(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
            this.f22791a = accessibilityNodeInfo;
            this.b = i;
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        public void onFailure(int i) {
            h2.c("samon startCroppedTitle", "onFailure code is " + i);
        }

        @Override // android.accessibilityservice.AccessibilityService.TakeScreenshotCallback
        @RequiresApi(api = 30)
        public void onSuccess(@NonNull AccessibilityService.ScreenshotResult screenshotResult) {
            Bitmap bitmapCreateBitmap;
            Bitmap bitmapWrapHardwareBuffer = Bitmap.wrapHardwareBuffer(screenshotResult.getHardwareBuffer(), screenshotResult.getColorSpace());
            try {
                Rect rect = new Rect();
                this.f22791a.getBoundsInScreen(rect);
                int iC = p4.c(a3.this.f22785a);
                int iB = p4.b(a3.this.f22785a);
                int i = this.b;
                if (i == 0) {
                    int i2 = rect.bottom;
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapWrapHardwareBuffer, 0, i2 + 50, iC, (iB - i2) / 2);
                } else {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmapWrapHardwareBuffer, 0, rect.bottom + 50, iC, i);
                }
                a3.this.a(bitmapCreateBitmap, "3");
                a3.this.b(bitmapCreateBitmap, "3");
            } catch (Throwable th) {
                h2.c("samon startCroppedTitle", "Throwable e =  " + th.getMessage());
            }
        }
    }

    public static a3 d() {
        if (c == null) {
            synchronized (a3.class) {
                if (c == null) {
                    c = new a3();
                }
            }
        }
        return c;
    }

    public void b() {
        com.acse.ottn.d.d().m = "";
        com.acse.ottn.d.d().n = "";
    }

    public final File c() {
        File externalFilesDir = HelpShopAppUtil.getContext().getExternalFilesDir("crash");
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        return externalFilesDir;
    }

    public final Object e() throws ObjectStreamException {
        return c;
    }

    public String f() {
        File file = new File(c() + "/Screenshot.png");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            return Base64.encodeToString(bArr, 0);
        } catch (Throwable unused) {
            return "";
        }
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (this.b || this.f22785a == null) {
            return;
        }
        this.b = true;
        h2.a("samon", "找到截图目标");
        a(accessibilityNodeInfo, "1", str);
        Rect rect = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect);
        int i = rect.top;
        int i2 = rect.left + 200;
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new a(i2, i + ((rect.bottom - i) / 2)), 0L);
            if (p4.b(HelpShopAppUtil.getContext()) - rect.bottom < 200) {
                new Handler(Looper.getMainLooper()).postDelayed(new b(), 500L);
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(Bitmap bitmap, String str) {
        if (AcseHelpManager.mIsDebug) {
            if ("1".equals(str)) {
                a(bitmap, new File(c() + WVNativeCallbackUtil.SEPERATER + new Random().nextInt(10000) + "shot1.png"));
                return;
            }
            a(bitmap, new File(c() + WVNativeCallbackUtil.SEPERATER + new Random().nextInt(10000) + "shot2.png"));
        }
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        AccessibilityService accessibilityService;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f22785a) == null) {
            return;
        }
        accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new f(accessibilityNodeInfo, i));
    }

    public void a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(Bitmap bitmap, String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 20, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if ("1".equals(str)) {
                com.acse.ottn.d.d().n = Base64.encodeToString(byteArray, 0);
            } else if ("2".equals(str)) {
                h2.a("samon-->", "imageBase64");
                com.acse.ottn.d.d().m = Base64.encodeToString(byteArray, 0);
            } else if ("3".equals(str)) {
                com.acse.ottn.d.d().m = Base64.encodeToString(byteArray, 0);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(AccessibilityService accessibilityService) {
        this.f22785a = accessibilityService;
    }

    public final void a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        AccessibilityService accessibilityService;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f22785a) == null) {
            return;
        }
        accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new c(accessibilityNodeInfo, str2, str));
    }

    public void a(AccessibilityNodeInfo accessibilityNodeInfo, int i) {
        AccessibilityService accessibilityService;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f22785a) == null) {
            return;
        }
        accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new d(accessibilityNodeInfo, i));
    }

    public void a() {
        AccessibilityService accessibilityService;
        if (Build.VERSION.SDK_INT < 30 || (accessibilityService = this.f22785a) == null) {
            return;
        }
        accessibilityService.takeScreenshot(0, HelpShopAppUtil.getContext().getMainExecutor(), new e());
    }

    public int a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        HashMap map = new HashMap();
        int iIntValue = 0;
        for (int i2 = 0; i2 < i; i2++) {
            map.merge(Integer.valueOf(iArr[i2]), 1, new BiFunction() { // from class: com.zj.adlib.uha
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return Integer.valueOf(Integer.sum(((Integer) obj).intValue(), ((Integer) obj2).intValue()));
                }
            });
        }
        int iIntValue2 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > iIntValue2) {
                iIntValue2 = ((Integer) entry.getValue()).intValue();
                iIntValue = ((Integer) entry.getKey()).intValue();
            }
        }
        return iIntValue;
    }
}
