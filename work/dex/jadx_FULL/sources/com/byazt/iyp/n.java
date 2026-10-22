package com.byazt.iyp;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.byazt.ga.LottieAnimationView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.MainThread;
import com.google.common.primitives.UnsignedBytes;
import com.ipd.dsp.internal.q.u;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f28676a = null;
    public static List<C0442n> c = null;
    public static boolean n = false;
    public static boolean sp = false;
    public static final c t;
    public static boolean tt = true;
    public static final uj u;
    public static boolean uj;
    public static Method ve;
    public static boolean x;
    public static final Rect i = new Rect();
    public static final Rect da = new Rect();
    public static final Rect sl = new Rect();

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 151})
    public static class c {
        public float c;
        public int tt;

        private c() {
        }
    }

    /* JADX INFO: renamed from: com.byazt.iyp.n$n, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 1143})
    public static class C0442n {
        public final int c;
        public final View tt;
        public final Rect uj;
        public String ve;

        public C0442n(int i, View view, String str, Rect rect) {
            this.c = i;
            this.tt = view;
            this.ve = str;
            this.uj = rect;
        }

        public String c() {
            if (!n.tt(this.ve)) {
                return this.ve + "_Tab_" + this.c;
            }
            View view = this.tt;
            if (view != null && view.isAttachedToWindow() && Thread.currentThread() == Looper.getMainLooper().getThread()) {
                String strTt = n.tt(this.tt);
                if (!n.tt(strTt)) {
                    this.ve = strTt;
                    return strTt + "_Tab_" + this.c;
                }
            }
            return "Tab_" + this.c;
        }

        public String toString() {
            return "TabInfo{index=" + this.c + ", tabRoot=" + this.tt + ", text='" + this.ve + "', rect=" + this.uj + '}';
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 934})
    public static class tt {
        public List<C0442n> uj;
        public String c = "";
        public int tt = -1;
        public int ve = 0;
        public String n = "";

        public String toString() {
            return "Result{bottomBarClassName='" + this.c + "', selectedIndex=" + this.tt + ", selectedConfidence=" + this.ve + ", tabInfos=" + this.uj + ", selectedTabLabel='" + this.n + "'}";
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, 938})
    public static class uj {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f28677a;
        public boolean c;
        public boolean n;
        public boolean tt;
        public boolean uj;
        public boolean ve;

        private uj() {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
    public static class ve {
        public int c;
        public int tt;
        public String ve;

        public ve(int i, int i2, String str) {
            this.c = i;
            this.tt = i2;
            this.ve = str;
        }
    }

    static {
        t = new c();
        u = new uj();
    }

    private static boolean a(View view) {
        if (view == null || !view.getClass().getSimpleName().contains(LottieAnimationView.c)) {
            return false;
        }
        if (!sp && !x) {
            try {
                try {
                    Method method = view.getClass().getMethod("isAnimating", new Class[0]);
                    method.setAccessible(true);
                    f28676a = method;
                } catch (Throwable unused) {
                    x = true;
                    f28676a = null;
                }
                sp = true;
            } catch (Throwable th) {
                sp = true;
                throw th;
            }
        }
        Method method2 = f28676a;
        if (method2 != null && !x) {
            try {
                Object objInvoke = method2.invoke(view, new Object[0]);
                return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
            } catch (Throwable unused2) {
                x = true;
                f28676a = null;
            }
        }
        return false;
    }

    @MainThread
    private static boolean n(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (a(view)) {
                return true;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    if (n(viewGroup.getChildAt(i2))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @MainThread
    private static boolean sp(View view) {
        if (view != null && view.getVisibility() == 0) {
            if (tt) {
                try {
                    if (view.isHovered()) {
                        return true;
                    }
                } catch (NoSuchMethodError unused) {
                    tt = false;
                } catch (Throwable unused2) {
                }
            }
            if (!uj && !n) {
                try {
                    try {
                        Method method = View.class.getMethod("isHovered", new Class[0]);
                        method.setAccessible(true);
                        ve = method;
                    } catch (Throwable unused3) {
                        n = true;
                        ve = null;
                    }
                    uj = true;
                } catch (Throwable th) {
                    uj = true;
                    throw th;
                }
            }
            Method method2 = ve;
            if (method2 != null && !n) {
                try {
                    Object objInvoke = method2.invoke(view, new Object[0]);
                    return (objInvoke instanceof Boolean) && ((Boolean) objInvoke).booleanValue();
                } catch (Throwable unused4) {
                    n = true;
                    ve = null;
                }
            }
        }
        return false;
    }

    @MainThread
    public static void tt() {
        c = null;
        com.byazt.iyp.uj.ve();
    }

    @MainThread
    public static int uj() {
        View view;
        da.uj();
        List<C0442n> list = c;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        for (C0442n c0442n : list) {
            if (c0442n == null || (view = c0442n.tt) == null || !view.isAttachedToWindow()) {
                da.n();
                return -1;
            }
        }
        ve veVarC = c(list);
        da.tt(veVarC.c, veVarC.tt, veVarC.ve);
        return veVarC.c;
    }

    @MainThread
    public static List<C0442n> ve() {
        return c;
    }

    private static boolean ve(String str) {
        if (str == null) {
            return false;
        }
        return str.contains(c(new byte[]{-36, -82, -80, -33, 125, -121})) || str.contains(c(new byte[]{-33, -118, -100, -37, -82, 119})) || str.contains(c(new byte[]{-35, -100, -123, -37, 126, -97})) || str.contains(c(new byte[]{-34, -85, -112, -33, -120, -89})) || str.contains(c(new byte[]{-36, -123, -122, -35, -124, -90})) || str.contains(c(new byte[]{-35, -80, -104, -37, -126, 123})) || str.contains(c(new byte[]{-36, -86, -79, -37, UnsignedBytes.f32243a, -98})) || str.contains(c(new byte[]{u.A7, -79, -79, -37, UnsignedBytes.f32243a, -105})) || str.contains(c(new byte[]{-34, -85, -112}));
    }

    @MainThread
    public static boolean c() {
        View view;
        List<C0442n> list = c;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (C0442n c0442n : list) {
            if (c0442n == null || (view = c0442n.tt) == null || !view.isAttachedToWindow()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(View view) {
        return c(view, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tt(String str) {
        return TextUtils.isEmpty(str) || str.trim().length() == 0;
    }

    @MainThread
    private static int tt(View view, String str) {
        TextView textView;
        CharSequence text;
        if (view != null && view.getVisibility() == 0) {
            if ((view instanceof TextView) && (text = (textView = (TextView) view).getText()) != null) {
                String strTrim = text.toString().trim();
                if (!strTrim.isEmpty() && (str == null || str.isEmpty() || strTrim.equals(str))) {
                    return textView.getCurrentTextColor();
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    int iTt = tt(viewGroup.getChildAt(i2), str);
                    if (iTt != 0) {
                        return iTt;
                    }
                }
            }
        }
        return 0;
    }

    @MainThread
    public static tt c(Activity activity) {
        ve veVarC;
        tt ttVar = new tt();
        if (activity != null && activity.getWindow() != null) {
            View decorView = activity.getWindow().getDecorView();
            ViewGroup viewGroupC = c(decorView, decorView.getResources().getDisplayMetrics().widthPixels, decorView.getResources().getDisplayMetrics().heightPixels);
            if (viewGroupC != null) {
                ttVar.c = viewGroupC.getClass().getName();
            }
            if (viewGroupC == null) {
                da.tt();
                return ttVar;
            }
            List<C0442n> listC = c(viewGroupC);
            ttVar.uj = listC;
            int iTt = com.byazt.iyp.uj.tt();
            if (iTt >= 0 && iTt < listC.size()) {
                veVarC = new ve(iTt, 100, "history click");
                da.c(veVarC.c);
            } else {
                veVarC = c(listC);
                da.c(veVarC.c, veVarC.tt, veVarC.ve);
            }
            int i2 = veVarC.c;
            ttVar.tt = i2;
            ttVar.ve = veVarC.tt;
            if (i2 >= 0 && i2 < listC.size()) {
                ttVar.n = listC.get(ttVar.tt).c();
            }
            if (listC != null && !listC.isEmpty()) {
                com.byazt.iyp.uj.ve();
                tt(viewGroupC, listC);
                com.byazt.iyp.uj.c(veVarC.c);
                com.byazt.iyp.uj.c(viewGroupC);
                c = listC;
                da.c(listC.size(), ttVar.n);
            } else {
                da.ve();
            }
        }
        return ttVar;
    }

    @MainThread
    private static float uj(View view) {
        c cVar = t;
        cVar.c = 0.0f;
        cVar.tt = 0;
        c(view, cVar);
        int i2 = cVar.tt;
        if (i2 == 0) {
            return 1.0f;
        }
        return cVar.c / i2;
    }

    @MainThread
    private static uj ve(View view) {
        uj ujVar = u;
        ujVar.f28677a = false;
        ujVar.n = false;
        ujVar.uj = false;
        ujVar.ve = false;
        ujVar.tt = false;
        ujVar.c = false;
        c(view, ujVar);
        ujVar.c = ujVar.tt || ujVar.ve || ujVar.uj || ujVar.n || ujVar.f28677a;
        return ujVar;
    }

    @MainThread
    private static void tt(ViewGroup viewGroup, List<C0442n> list) {
        for (C0442n c0442n : list) {
            com.byazt.iyp.uj.c(c0442n.tt, c0442n);
        }
    }

    @MainThread
    private static List<View> tt(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null && childAt.getVisibility() == 0) {
                arrayList.add(childAt);
            }
        }
        return arrayList;
    }

    @MainThread
    private static ViewGroup c(View view, int i2, int i3) {
        return c(view, i2, i3, true);
    }

    /* JADX WARN: Code duplicated, block: B:58:0x00f1  */
    @MainThread
    private static ViewGroup c(View view, int i2, int i3, boolean z) {
        boolean z2;
        boolean z3;
        if (!(view instanceof ViewGroup) || view.getVisibility() != 0) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        boolean zC = da.c();
        ArrayList arrayList = new ArrayList(viewGroup.getChildCount());
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt != null && childAt.getVisibility() == 0 && childAt.getWidth() > 0 && childAt.getHeight() > 0) {
                arrayList.add(childAt);
            }
        }
        boolean z4 = true;
        if (arrayList.size() >= 3 && arrayList.size() <= 6) {
            Rect rect = i;
            rect.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect)) {
                if (rect.width() >= ((double) i2) * 0.9d) {
                    double d = i3;
                    if (rect.bottom >= 0.9d * d && rect.height() <= d * 0.2d) {
                        int iWidth = rect.width() / arrayList.size();
                        int i5 = iWidth / 2;
                        Iterator it = arrayList.iterator();
                        int iCenterX = -1;
                        while (true) {
                            if (!it.hasNext()) {
                                z3 = true;
                                break;
                            }
                            View view2 = (View) it.next();
                            Rect rect2 = da;
                            rect2.setEmpty();
                            view2.getGlobalVisibleRect(rect2);
                            if (iCenterX == -1 || rect2.centerX() > iCenterX) {
                                iCenterX = rect2.centerX();
                                if (Math.abs(rect2.width() - iWidth) > i5) {
                                    rect2.width();
                                }
                            }
                            z3 = false;
                            break;
                        }
                        if (z3) {
                            Iterator it2 = arrayList.iterator();
                            do {
                                if (!it2.hasNext()) {
                                    z4 = false;
                                    break;
                                }
                            } while (!(((View) it2.next()) instanceof ViewGroup));
                            if (z4) {
                                return viewGroup;
                            }
                        }
                        if (zC && !z) {
                            arrayList.size();
                        }
                    } else if (zC && !z) {
                        arrayList.size();
                        rect.width();
                        rect.height();
                    }
                } else if (zC) {
                    arrayList.size();
                    rect.width();
                    rect.height();
                }
            }
        } else if (arrayList.size() > 6 && arrayList.size() <= 15) {
            Rect rect3 = i;
            rect3.setEmpty();
            if (viewGroup.getGlobalVisibleRect(rect3) && rect3.width() >= ((double) i2) * 0.9d) {
                double d2 = i3;
                if (rect3.bottom >= 0.9d * d2 && rect3.height() <= d2 * 0.2d) {
                    ArrayList arrayList2 = new ArrayList(arrayList);
                    c(viewGroup, arrayList2);
                    int size = arrayList2.size();
                    if (size >= 3 && size <= 6) {
                        int iWidth2 = rect3.width();
                        int i6 = iWidth2 / size;
                        int i7 = i6 / 2;
                        int i8 = 0;
                        int iCenterX2 = -1;
                        while (true) {
                            if (i8 >= size) {
                                z2 = true;
                                break;
                            }
                            View view3 = (View) arrayList2.get(i8);
                            Rect rect4 = da;
                            rect4.setEmpty();
                            view3.getGlobalVisibleRect(rect4);
                            if (iCenterX2 == -1 || rect4.centerX() > iCenterX2 + (iWidth2 * 0.05f)) {
                                iCenterX2 = rect4.centerX();
                                if (Math.abs(rect4.width() - i6) <= i7) {
                                    i8++;
                                }
                            }
                            z2 = false;
                            break;
                        }
                        if (z2) {
                            Iterator it3 = arrayList2.iterator();
                            do {
                                if (!it3.hasNext()) {
                                    z4 = false;
                                    break;
                                }
                            } while (!(((View) it3.next()) instanceof ViewGroup));
                            if (z4) {
                                if (zC) {
                                    arrayList.size();
                                }
                                return viewGroup;
                            }
                        }
                        if (zC && !z) {
                            arrayList.size();
                        }
                    }
                }
            }
        } else if (zC && !z) {
            arrayList.size();
            arrayList.size();
        }
        for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
            ViewGroup viewGroupC = c(viewGroup.getChildAt(i9), i2, i3, false);
            if (viewGroupC != null) {
                return viewGroupC;
            }
        }
        return null;
    }

    @MainThread
    private static List<C0442n> c(ViewGroup viewGroup) {
        List<View> listTt = tt(viewGroup);
        if (listTt.size() > 6) {
            c(viewGroup, listTt);
        }
        ArrayList arrayList = new ArrayList(listTt.size());
        for (int i2 = 0; i2 < listTt.size(); i2++) {
            View view = listTt.get(i2);
            Rect rect = sl;
            rect.setEmpty();
            view.getGlobalVisibleRect(rect);
            arrayList.add(new C0442n(i2, view, tt(view), new Rect(rect)));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:56:0x013f  */
    @MainThread
    private static void c(ViewGroup viewGroup, List<View> list) {
        boolean z;
        if (list == null || list.size() < 3) {
            return;
        }
        Rect rect = i;
        rect.setEmpty();
        if (viewGroup.getGlobalVisibleRect(rect)) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (iWidth == 0 || iHeight == 0) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                View view = list.get(size);
                Rect rect2 = da;
                rect2.setEmpty();
                view.getGlobalVisibleRect(rect2);
                int iWidth2 = rect2.width();
                int iHeight2 = rect2.height();
                float f = iWidth2;
                float f2 = iWidth;
                if (f >= 0.92f * f2 && iHeight2 >= iHeight * 0.6f) {
                    list.remove(size);
                } else if (f > 0.03f * f2) {
                    float f3 = iHeight2;
                    float f4 = iHeight;
                    if (f3 <= 0.12f * f4) {
                        list.remove(size);
                    } else if (f < f2 * 0.07f || f3 < f4 * 0.35f) {
                        list.remove(size);
                    }
                } else {
                    list.remove(size);
                }
            }
            int size2 = list.size();
            int i2 = 0;
            while (true) {
                int i3 = size2 - 1;
                if (i2 >= i3) {
                    break;
                }
                int i4 = 0;
                while (i4 < i3 - i2) {
                    View view2 = list.get(i4);
                    Rect rect3 = da;
                    rect3.setEmpty();
                    view2.getGlobalVisibleRect(rect3);
                    int iCenterX = rect3.centerX();
                    int i5 = i4 + 1;
                    View view3 = list.get(i5);
                    rect3.setEmpty();
                    view3.getGlobalVisibleRect(rect3);
                    if (iCenterX > rect3.centerX()) {
                        list.set(i4, view3);
                        list.set(i5, view2);
                    }
                    i4 = i5;
                }
                i2++;
            }
            for (int size3 = list.size() - 1; size3 > 0; size3--) {
                View view4 = list.get(size3);
                int i6 = size3 - 1;
                View view5 = list.get(i6);
                Rect rect4 = new Rect();
                view4.getGlobalVisibleRect(rect4);
                Rect rect5 = new Rect();
                view5.getGlobalVisibleRect(rect5);
                boolean z2 = ((float) Math.abs(rect4.centerX() - rect5.centerX())) <= ((float) iWidth) * 0.06f;
                if (z2 || !Rect.intersects(rect4, rect5)) {
                    z = false;
                } else {
                    Rect rect6 = new Rect(rect4);
                    rect6.intersect(rect5);
                    if (rect6.width() * rect6.height() >= Math.min(rect4.width() * rect4.height(), rect5.width() * rect5.height()) * 0.35f) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z2 || z) {
                    if (rect4.width() * rect4.height() >= rect5.width() * rect5.height()) {
                        list.remove(i6);
                    } else {
                        list.remove(size3);
                    }
                }
            }
        }
    }

    @MainThread
    private static String c(View view, String str) {
        CharSequence text;
        if (view != null && view.getVisibility() == 0) {
            if ((view instanceof TextView) && (text = ((TextView) view).getText()) != null) {
                String strTrim = text.toString().trim();
                if (!strTrim.isEmpty() && strTrim.length() <= 8 && (str.isEmpty() || strTrim.length() < str.length())) {
                    str = strTrim;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    str = c(viewGroup.getChildAt(i2), str);
                }
            }
        }
        return str;
    }

    private static String c(byte[] bArr) {
        try {
            byte[] bArr2 = new byte[bArr.length];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                bArr2[i2] = (byte) (bArr[i2] + 10);
            }
            return new String(bArr2, "UTF-8");
        } catch (Throwable unused) {
            return "";
        }
    }

    @MainThread
    private static ve c(List<C0442n> list) {
        HashMap map;
        if (list != null && !list.isEmpty()) {
            boolean zC = da.c();
            int size = list.size();
            int[] iArr = new int[size];
            if (zC) {
                map = new HashMap(size);
                for (int i2 = 0; i2 < size; i2++) {
                    map.put(Integer.valueOf(i2), new ArrayList());
                }
            } else {
                map = null;
            }
            int[] iArr2 = new int[size];
            for (int i3 = 0; i3 < size; i3++) {
                iArr2[i3] = tt(list.get(i3).tt, list.get(i3).ve);
            }
            int iC = c(iArr2);
            if (iC != -1) {
                iArr[iC] = iArr[iC] + 5;
                c(map, iC, "textColorOdd +5");
            }
            for (int i4 = 0; i4 < size; i4++) {
                C0442n c0442n = list.get(i4);
                boolean zVe = ve(c0442n.ve);
                uj ujVarVe = ve(c0442n.tt);
                if (ujVarVe.c) {
                    int i5 = ujVarVe.tt ? 6 : 0;
                    if (ujVarVe.ve) {
                        i5 += 4;
                    }
                    if (ujVarVe.uj) {
                        i5++;
                    }
                    if (ujVarVe.n) {
                        i5 += 2;
                    }
                    if (ujVarVe.f28677a) {
                        i5++;
                    }
                    iArr[i4] = iArr[i4] + i5;
                    c(map, i4, "stateHit +".concat(String.valueOf(i5)));
                }
                if (n(c0442n.tt)) {
                    if (zVe) {
                        c(map, i4, "lottie ignored(marketing)");
                    } else {
                        iArr[i4] = iArr[i4] + 2;
                        c(map, i4, "lottieAnimating +2");
                    }
                }
            }
            float[] fArr = new float[size];
            for (int i6 = 0; i6 < size; i6++) {
                fArr[i6] = uj(list.get(i6).tt);
            }
            int iC2 = c(fArr, 0.15f);
            if (iC2 != -1) {
                if (ve(list.get(iC2).ve)) {
                    c(map, iC2, "alphaOdd ignored(marketing)");
                } else {
                    iArr[iC2] = iArr[iC2] + 2;
                    c(map, iC2, "alphaOdd +2");
                }
            }
            int iMax = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = -1;
            for (int i9 = 0; i9 < size; i9++) {
                int i10 = iArr[i9];
                if (i10 > i7) {
                    i8 = i9;
                    i7 = i10;
                }
            }
            if (i7 <= 0) {
                return new ve(-1, 0, "no strong signals");
            }
            for (int i11 = 0; i11 < size; i11++) {
                if (i11 != i8) {
                    iMax = Math.max(iMax, iArr[i11]);
                }
            }
            return new ve(i8, Math.max(0, i7 - iMax) + i7, (!zC || map == null) ? "" : String.valueOf(map.get(Integer.valueOf(i8))));
        }
        return new ve(-1, 0, "no tabs");
    }

    private static void c(Map<Integer, List<String>> map, int i2, String str) {
        List<String> list;
        if (map == null || (list = map.get(Integer.valueOf(i2))) == null) {
            return;
        }
        list.add(str);
    }

    @MainThread
    private static void c(View view, uj ujVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (view.isSelected()) {
            ujVar.tt = true;
        }
        if (view.isActivated()) {
            ujVar.ve = true;
        }
        if (view.isPressed()) {
            ujVar.uj = true;
        }
        if (view.isFocused()) {
            ujVar.n = true;
        }
        if (sp(view)) {
            ujVar.f28677a = true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                c(viewGroup.getChildAt(i2), ujVar);
            }
        }
    }

    private static int c(int[] iArr) {
        if (iArr != null && iArr.length >= 3) {
            HashMap map = new HashMap();
            for (int i2 : iArr) {
                if (i2 != 0) {
                    map.put(Integer.valueOf(i2), Integer.valueOf(((Integer) map.getOrDefault(Integer.valueOf(i2), 0)).intValue() + 1));
                }
            }
            int iIntValue = 0;
            int iIntValue2 = 0;
            for (Map.Entry entry : map.entrySet()) {
                if (((Integer) entry.getValue()).intValue() > iIntValue) {
                    iIntValue = ((Integer) entry.getValue()).intValue();
                    iIntValue2 = ((Integer) entry.getKey()).intValue();
                }
            }
            if (iIntValue >= iArr.length / 2) {
                int i3 = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < iArr.length; i5++) {
                    int i6 = iArr[i5];
                    if (i6 != 0 && i6 != iIntValue2) {
                        i4++;
                        i3 = i5;
                    }
                }
                if (i4 == 1) {
                    return i3;
                }
            }
        }
        return -1;
    }

    @MainThread
    private static void c(View view, c cVar) {
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        if (!(view instanceof ViewGroup)) {
            cVar.c += view.getAlpha();
            cVar.tt++;
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            c(viewGroup.getChildAt(i2), cVar);
        }
    }

    private static int c(float[] fArr, float f) {
        if (fArr != null && fArr.length >= 3) {
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (float f4 : fArr) {
                f3 += f4;
            }
            float length = f3 / fArr.length;
            int i2 = -1;
            for (int i3 = 0; i3 < fArr.length; i3++) {
                float fAbs = Math.abs(fArr[i3] - length);
                if (fAbs > f2) {
                    i2 = i3;
                    f2 = fAbs;
                }
            }
            if (f2 >= f) {
                return i2;
            }
        }
        return -1;
    }
}
