package com.kc.aw;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _jx {
    /* JADX WARN: Code duplicated, block: B:28:0x0047  */
    /* JADX WARN: Code duplicated, block: B:42:0x0074  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    public static Boolean _a(ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        if (viewGroup == null) {
            return null;
        }
        try {
            for (ViewParent parent = viewGroup.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                ViewGroup viewGroup2 = (ViewGroup) parent;
                boolean z3 = false;
                if (!(viewGroup2 == null ? false : viewGroup2 instanceof ScrollView)) {
                    ViewGroup viewGroup3 = (ViewGroup) parent;
                    if (!(viewGroup3 == null ? false : viewGroup3 instanceof HorizontalScrollView)) {
                        ViewGroup viewGroup4 = (ViewGroup) parent;
                        if (viewGroup4 == null) {
                            z = false;
                        } else {
                            try {
                                if (!Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup4)) {
                                    try {
                                        if (!Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup4)) {
                                            z = false;
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            } catch (Exception unused2) {
                            }
                            z = true;
                        }
                        if (!z) {
                            ViewGroup viewGroup5 = (ViewGroup) parent;
                            if (viewGroup5 == null) {
                                z2 = false;
                            } else {
                                try {
                                    if (!Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup5)) {
                                        try {
                                            if (!Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup5)) {
                                                try {
                                                    if (!Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup5)) {
                                                        z2 = false;
                                                    }
                                                } catch (Exception unused3) {
                                                }
                                            }
                                        } catch (Exception unused4) {
                                        }
                                    }
                                } catch (Exception unused5) {
                                }
                                z2 = true;
                            }
                            if (!z2) {
                                ViewGroup viewGroup6 = (ViewGroup) parent;
                                if (!(viewGroup6 == null ? false : viewGroup6 instanceof AbsListView)) {
                                    ViewGroup viewGroup7 = (ViewGroup) parent;
                                    if (viewGroup7 != null) {
                                        try {
                                            if (Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup7)) {
                                                z3 = true;
                                            } else {
                                                try {
                                                    if (Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup7)) {
                                                        z3 = true;
                                                    }
                                                } catch (Exception unused6) {
                                                }
                                            }
                                        } catch (Exception unused7) {
                                        }
                                    }
                                    if (!z3) {
                                    }
                                }
                                return Boolean.FALSE;
                            }
                        }
                    }
                }
                return Boolean.TRUE;
            }
        } catch (Exception unused8) {
        }
        return null;
    }
}
