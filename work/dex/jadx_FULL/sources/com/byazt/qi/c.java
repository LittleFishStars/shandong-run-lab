package com.byazt.qi;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.byakv.z.SoftDecTool;
import com.byazt.nr.m;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 527, 20})
public class c extends View.AccessibilityDelegate {
    public static Field tt;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.AccessibilityDelegate f28977a;
    public View sp;
    public static c c = new c(null, null);
    public static int ve = 0;
    public static String uj = "";
    public static Set<Integer> n = new HashSet();

    static {
        tt = null;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                Field declaredField = Class.forName("android.view.View").getDeclaredField("mAccessibilityDelegate");
                declaredField.setAccessible(true);
                tt = declaredField;
            } catch (Throwable th) {
                m.c(th);
            }
        }
    }

    public c(View.AccessibilityDelegate accessibilityDelegate, View view) {
        this.f28977a = accessibilityDelegate;
        this.sp = view;
        SoftDecTool.h = true;
    }

    public static void c(View view) {
        View.AccessibilityDelegate accessibilityDelegate;
        if (n.contains(Integer.valueOf(view.hashCode()))) {
            return;
        }
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 29) {
            accessibilityDelegate = view.getAccessibilityDelegate();
        } else {
            try {
                Field field = tt;
                if (field != null) {
                    accessibilityDelegate = (View.AccessibilityDelegate) field.get(view);
                } else {
                    z = false;
                    accessibilityDelegate = null;
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        if (!(accessibilityDelegate instanceof c) && z) {
            view.setAccessibilityDelegate(new c(accessibilityDelegate, view));
            n.add(Integer.valueOf(view.hashCode()));
        }
    }

    @Override // android.view.View.AccessibilityDelegate
    public void addExtraDataToAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            } else {
                super.addExtraDataToAccessibilityNodeInfo(view, accessibilityNodeInfo, str, bundle);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
        boolean zDispatchPopulateAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        view.setAccessibilityDelegate(this);
        return zDispatchPopulateAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        SoftDecTool.f = true;
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        if (c()) {
            return;
        }
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        viewGroup.setAccessibilityDelegate(this.f28977a);
        View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
        boolean zOnRequestSendAccessibilityEvent = accessibilityDelegate != null ? accessibilityDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        viewGroup.setAccessibilityDelegate(this);
        return zOnRequestSendAccessibilityEvent;
    }

    @Override // android.view.View.AccessibilityDelegate
    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        SoftDecTool.f28270a = true;
        view.setAccessibilityDelegate(this.f28977a);
        View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
        boolean zPerformAccessibilityAction = accessibilityDelegate != null ? accessibilityDelegate.performAccessibilityAction(view, i, bundle) : super.performAccessibilityAction(view, i, bundle);
        view.setAccessibilityDelegate(this);
        return zPerformAccessibilityAction;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEvent(View view, int i) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEvent(view, i);
            } else {
                super.sendAccessibilityEvent(view, i);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    @Override // android.view.View.AccessibilityDelegate
    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        ve = hashCode();
        uj = String.valueOf(this.f28977a);
        view.setAccessibilityDelegate(this.f28977a);
        try {
            View.AccessibilityDelegate accessibilityDelegate = this.f28977a;
            if (accessibilityDelegate != null) {
                accessibilityDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        view.setAccessibilityDelegate(this);
    }

    public boolean c() {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4 || (stackTraceElement = stackTrace[3]) == null) {
            return false;
        }
        for (int i = 4; i < stackTrace.length; i++) {
            if (stackTrace[i] != null && stackTraceElement.getMethodName().equals(stackTrace[i].getMethodName()) && stackTraceElement.getClassName().equals(stackTrace[i].getClassName())) {
                return true;
            }
        }
        return false;
    }
}
