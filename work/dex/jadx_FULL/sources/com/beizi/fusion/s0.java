package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27736a = "temp_%s_%s";
    private final Context b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27737a;

        static {
            int[] iArr = new int[d.values().length];
            f27737a = iArr;
            try {
                iArr[d.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27737a[d.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27737a[d.VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f27737a[d.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f27737a[d.NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public s0(Context context) {
        this.b = context.getApplicationContext();
    }

    public void a(d dVar, String str, String str2) {
        p0.b(this.b, a(dVar.c()), str, f3.c(str2));
    }

    public List b(d dVar) {
        Map mapA = p0.a(this.b, a(dVar.c()));
        ArrayList arrayList = new ArrayList();
        if (mapA != null && !mapA.isEmpty()) {
            arrayList.addAll(mapA.keySet());
        }
        return arrayList;
    }

    public List a(d dVar, String str) {
        String strA;
        JSONArray jSONArrayB;
        String strA2 = a(dVar.c());
        if (TextUtils.isEmpty(str)) {
            strA = null;
        } else {
            strA = p0.a(this.b, strA2, str, "");
            if (TextUtils.isEmpty(strA)) {
                strA = b(strA2);
            }
        }
        if (TextUtils.isEmpty(strA)) {
            strA = a(dVar);
        }
        if (!TextUtils.isEmpty(strA)) {
            String strB = f3.b(strA);
            if (!TextUtils.isEmpty(strB) && (jSONArrayB = mg.b(strB)) != null && jSONArrayB.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArrayB.length(); i++) {
                    try {
                        arrayList.add(new RenderModel(jSONArrayB.getJSONObject(i)));
                    } catch (JSONException unused) {
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    private String b(String str) {
        return p0.a(this.b, str, "default", "");
    }

    private String a(d dVar) {
        int i = a.f27737a[dVar.ordinal()];
        if (i == 1) {
            return "W3sidWlkIjoiMTAwMDAxIiwibGF5ZXIiOjEsIm1hcmdpblRvcCI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InJpZ2h0In0sIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoiYm90dG9tIn0sInN1cGVyVmlldyI6Im5vbmUiLCJiZ0NvbG9yIjoiIzAwMDAwMDAwIiwiY29udHJvbFR5cGUiOiJ2aWV3In0seyJ1aWQiOiIxMTAwMDEiLCJsYXllciI6MSwibWFyZ2luVG9wIjp7InNpemUiOiIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJ0b3AifSwibWFyZ2luTGVmdCI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoibGVmdCJ9LCJtYXJnaW5SaWdodCI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoicmlnaHQifSwibWFyZ2luQm90dG9tIjp7InNpemUiOiIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJib3R0b20ifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiMwMDAwMDAwMCIsImNvbnRyb2xUeXBlIjoiaW1hZ2UiLCJpc0JsdXIiOnRydWUsImFzc2V0SWQiOiIxMDAxIn0seyJ1aWQiOiIxMjAwMDEiLCJsYXllciI6MTAsIm1hcmdpblRvcCI6eyJzaXplIjoiMTAlIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJ0b3AifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6Ii01JSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoicmlnaHQifSwiaGVpZ2h0Ijp7InNpemUiOiIzMCIsInJlZmVyZW5jZSI6Im93biIsImxheW91dCI6ImhlaWdodCJ9LCJ3aWR0aCI6eyJzaXplIjoiNzAiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJ3aWR0aCJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzY2ODg4ODg4IiwiYm9yZGVyUmFkaXVzIjoiNTAlIiwiYm9yZGVyU2l6ZSI6IjEiLCJib3JkZXJDb2xvciI6IiNDQzg4ODg4OCIsImNvbnRyb2xUeXBlIjoiY2Fwc3VsZWNsb3NlIiwiYmluZEV2ZW50IjoiY2xpY2siLCJleGVjdXRpb24iOiJjbG9zZSIsInRpdGxlIjoi6Lez6L+HIiwiZm9udFNpemUiOjE1LCJ0ZXh0Q29sb3IiOiIjRkZGRkZGIiwidGV4dEFsaWduIjoiY2VudGVyIiwiY291bnREb3duVGltZSI6NTAwMH0seyJ1aWQiOiIxMzAwMDEiLCJsYXllciI6MywibWFyZ2luVG9wIjp7InNpemUiOiI1JSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJsZWZ0In0sImhlaWdodCI6eyJzaXplIjoiMTUiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJoZWlnaHQifSwid2lkdGgiOnsic2l6ZSI6IjUwJSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0Ijoid2lkdGgifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiMwMDAwMDAwMCIsImNvbnRyb2xUeXBlIjoidGFnIiwiZm9udFNpemUiOjksInRleHRDb2xvciI6IiMwMDAwMDAiLCJ0ZXh0QWxpZ24iOiJsZWZ0In0seyJ1aWQiOiIxNDAwMDEiLCJsYXllciI6MywibWFyZ2luQm90dG9tIjp7InNpemUiOiItMjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImJvdHRvbSJ9LCJtYXJnaW5SaWdodCI6eyJzaXplIjoiLTIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJyaWdodCJ9LCJoZWlnaHQiOnsic2l6ZSI6IjIwIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0IjoiaGVpZ2h0In0sIndpZHRoIjp7InNpemUiOiIxMDAiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJ3aWR0aCJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzY2ODg4ODg4IiwiYm9yZGVyUmFkaXVzIjoyLCJjb250cm9sVHlwZSI6ImxvZ28iLCJ0aXRsZSI6IuW5v+WRiiIsImZvbnRTaXplIjo5LCJ0ZXh0Q29sb3IiOiIjREREREREIiwidGV4dEFsaWduIjoiY2VudGVyIn0seyJ1aWQiOiIxNTAwMDEiLCJsYXllciI6NCwibWFyZ2luTGVmdCI6eyJzaXplIjoiOCUiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6Ii04JSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoicmlnaHQifSwibWFyZ2luQm90dG9tIjp7InNpemUiOiItMjAlIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJib3R0b20ifSwiaGVpZ2h0Ijp7InNpemUiOiI4MCIsInJlZmVyZW5jZSI6Im93biIsImxheW91dCI6ImhlaWdodCJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzY2ODg4ODg4IiwiYm9yZGVyUmFkaXVzIjoiNTAlIiwiYm9yZGVyU2l6ZSI6IjEiLCJib3JkZXJDb2xvciI6IiNDQzg4ODg4OCIsImNvbnRyb2xUeXBlIjoicmVnaW9uIiwiYmluZEV2ZW50IjoiY2xpY2siLCJleGVjdXRpb24iOiJjbGljayIsImZvbnRTaXplIjoyMCwidGV4dENvbG9yIjoiI0ZGRkZGRiIsInRleHRBbGlnbiI6ImNlbnRlciIsImludGVyYWN0aXZlVGl0bGUiOnsibm9ybWFsIjp7Im5vcm1hbCI6IueCueWHu+i3s+i9rOiHs+esrOS4ieaWueaIluivpuaDhSIsInBhc3NpdmF0aW9uIjoi54K55Ye76Lez6L2s6Iez56ys5LiJ5pa55oiW6K+m5oOFIiwiY29vbCI6IueCueWHu+i3s+i9rOiHs+esrOS4ieaWueaIluivpuaDhSJ9fX0seyJ1aWQiOiIxNjAwMDEiLCJsYXllciI6NSwibWFyZ2luQm90dG9tIjp7InNpemUiOiItMjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImJvdHRvbSJ9LCJtYXJnaW5MZWZ0Ijp7InNpemUiOiIyMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoibGVmdCJ9LCJ3aWR0aCI6eyJzaXplIjoiNzAlIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJ3aWR0aCJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzAwMDAwMDAwIiwiY29udHJvbFR5cGUiOiJhcHBpbmZvIiwiYmluZEV2ZW50IjoiY2xpY2siLCJleGVjdXRpb24iOiJhcHBpbmZvIiwiZm9udFNpemUiOjEyLCJ0ZXh0Q29sb3IiOiIjODg4ODg4IiwidGV4dEFsaWduIjoibGVmdCJ9XQ==";
        }
        if (i == 2) {
            return "W3sidWlkIjoiMTAwMDAxIiwibGF5ZXIiOjEsIm1hcmdpblRvcCI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InJpZ2h0In0sIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoiYm90dG9tIn0sInN1cGVyVmlldyI6Im5vbmUiLCJiZ0NvbG9yIjoiIzgwMDAwMDAwIiwiY29udHJvbFR5cGUiOiJ2aWV3In0seyJ1aWQiOiIxMTAwMDEiLCJsYXllciI6MSwibWFyZ2luTGVmdCI6eyJzaXplIjoiMTglIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJsZWZ0In0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiItMTglIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJyaWdodCJ9LCJoZWlnaHQiOnsic2l6ZSI6IjE3NyUiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJ3aWR0aCJ9LCJjZW50ZXJZIjp7InNpemUiOiItMjUiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImNlbnRlclkifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiNGRkZGRkYiLCJjb250cm9sVHlwZSI6InZpZXciLCJib3JkZXJSYWRpdXMiOiIxMCJ9LHsidWlkIjoiMTIwMDAxIiwibGF5ZXIiOjEsIm1hcmdpblRvcCI6eyJzaXplIjoiNSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjUiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6Ii01IiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJyaWdodCJ9LCJtYXJnaW5Cb3R0b20iOnsic2l6ZSI6Ii01IiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJib3R0b20ifSwic3VwZXJWaWV3IjoiMTEwMDAxIiwiYmdDb2xvciI6IiMwMDAwMDAwMCIsImNvbnRyb2xUeXBlIjoiaW1hZ2UiLCJib3JkZXJSYWRpdXMiOiI2IiwiaXNCbHVyIjp0cnVlLCJhc3NldElkIjoiMTAwMSJ9LHsidWlkIjoiMTMwMDAxIiwibGF5ZXIiOjEwLCJtYXJnaW5Ub3AiOnsic2l6ZSI6IjEwIiwicmVmZXJlbmNlIjoiMTIwMDAxIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiItMTAiLCJyZWZlcmVuY2UiOiIxMjAwMDEiLCJsYXlvdXQiOiJyaWdodCJ9LCJoZWlnaHQiOnsic2l6ZSI6IjIyIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0IjoiaGVpZ2h0In0sIndpZHRoIjp7InNpemUiOiI2MCIsInJlZmVyZW5jZSI6Im93biIsImxheW91dCI6IndpZHRoIn0sInN1cGVyVmlldyI6IjExMDAwMSIsImJnQ29sb3IiOiIjNjYzMzMzMzMiLCJib3JkZXJSYWRpdXMiOiI1MCUiLCJjb250cm9sVHlwZSI6ImNvdW50ZG93bmNsb3NlIiwiYXV0b0Nsb3NlIjowLCJiaW5kRXZlbnQiOiJjbGljayIsImV4ZWN1dGlvbiI6ImNsb3NlIiwidGl0bGUiOiLlhbPpl60iLCJmb250U2l6ZSI6MTIsInRleHRDb2xvciI6IiNGRkZGRkYiLCJ0ZXh0QWxpZ24iOiJjZW50ZXIiLCJjb3VudERvd25UaW1lIjoxMDAwMH0seyJ1aWQiOiIxNDAwMDEiLCJsYXllciI6MiwibWFyZ2luQm90dG9tIjp7InNpemUiOiItMTUiLCJyZWZlcmVuY2UiOiIxMjAwMDEiLCJsYXlvdXQiOiJib3R0b20ifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6Ii0yMiIsInJlZmVyZW5jZSI6IjEyMDAwMSIsImxheW91dCI6InJpZ2h0In0sImhlaWdodCI6eyJzaXplIjoiMTUiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJoZWlnaHQifSwid2lkdGgiOnsic2l6ZSI6IjUwJSIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0Ijoid2lkdGgifSwic3VwZXJWaWV3IjoiMTEwMDAxIiwiYmdDb2xvciI6IiMwMDAwMDAwMCIsImNvbnRyb2xUeXBlIjoidGFnIiwiZm9udFNpemUiOjksInRleHRDb2xvciI6IiMwMDAwMDAiLCJ0ZXh0QWxpZ24iOiJyaWdodCJ9LHsidWlkIjoiMTUwMDAxIiwibGF5ZXIiOjIsIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiLTIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJib3R0b20ifSwibWFyZ2luTGVmdCI6eyJzaXplIjoiMjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwiaGVpZ2h0Ijp7InNpemUiOiIyMCIsInJlZmVyZW5jZSI6Im93biIsImxheW91dCI6ImhlaWdodCJ9LCJ3aWR0aCI6eyJzaXplIjoiMTAwIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0Ijoid2lkdGgifSwic3VwZXJWaWV3IjoiMTEwMDAxIiwiYmdDb2xvciI6IiM2Njg4ODg4OCIsImJvcmRlclJhZGl1cyI6MiwiY29udHJvbFR5cGUiOiJsb2dvIiwidGl0bGUiOiLlub/lkYoiLCJmb250U2l6ZSI6OSwidGV4dENvbG9yIjoiI0RERERERCIsInRleHRBbGlnbiI6ImNlbnRlciJ9LHsidWlkIjoiMTYwMDAxIiwibGF5ZXIiOjIsIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiIxMTAwMDEiLCJsYXlvdXQiOiJsZWZ0In0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiIwIiwicmVmZXJlbmNlIjoiMTEwMDAxIiwibGF5b3V0IjoicmlnaHQifSwibWFyZ2luVG9wIjp7InNpemUiOiIxMCIsInJlZmVyZW5jZSI6IjExMDAwMSIsImxheW91dCI6ImJvdHRvbSJ9LCJoZWlnaHQiOnsic2l6ZSI6IjQwIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0IjoiaGVpZ2h0In0sInN1cGVyVmlldyI6IjEwMDAwMSIsImJnQ29sb3IiOiIjMzk3NkZGIiwiYm9yZGVyUmFkaXVzIjoiMTAiLCJjb250cm9sVHlwZSI6InJlZ2lvbiIsImJpbmRFdmVudCI6ImNsaWNrIiwiZXhlY3V0aW9uIjoiY2xpY2siLCJmb250U2l6ZSI6MTcsInRleHRDb2xvciI6IiNGRkZGRkYiLCJ0ZXh0QWxpZ24iOiJjZW50ZXIiLCJpbnRlcmFjdGl2ZVRpdGxlIjp7Im5vcm1hbCI6eyJub3JtYWwiOiLngrnlh7vot7Povazoh7PnrKzkuInmlrnmiJbor6bmg4UiLCJwYXNzaXZhdGlvbiI6IueCueWHu+i3s+i9rOiHs+esrOS4ieaWueaIluivpuaDhSIsImNvb2wiOiLngrnlh7vot7Povazoh7PnrKzkuInmlrnmiJbor6bmg4UifX19LHsidWlkIjoiMTcwMDAxIiwibGF5ZXIiOjUsIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiLTIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJib3R0b20ifSwibWFyZ2luTGVmdCI6eyJzaXplIjoiMjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6Ii0yMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoicmlnaHQifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiMwMDAwMDAwMCIsImNvbnRyb2xUeXBlIjoiYXBwaW5mbyIsImJpbmRFdmVudCI6ImNsaWNrIiwiZXhlY3V0aW9uIjoiYXBwaW5mbyIsImZvbnRTaXplIjoxMiwidGV4dENvbG9yIjoiIzMzMzMzMyIsInRleHRBbGlnbiI6ImxlZnQifV0=";
        }
        if (i == 3 || i == 4) {
            return "";
        }
        if (i != 5) {
            return null;
        }
        return "W3sidWlkIjoiMTAwMDAxIiwibGF5ZXIiOjEsIm1hcmdpblRvcCI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpbkxlZnQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImxlZnQifSwibWFyZ2luUmlnaHQiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InJpZ2h0In0sIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoiYm90dG9tIn0sInN1cGVyVmlldyI6Im5vbmUiLCJiZ0NvbG9yIjoiI0ZGRkZGRiIsImNvbnRyb2xUeXBlIjoidmlldyIsImJpbmRFdmVudCI6ImNsaWNrIiwiZXhlY3V0aW9uIjoiY2xpY2sifSx7InVpZCI6IjExMDAwMSIsImxheWVyIjoxLCJtYXJnaW5Ub3AiOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InRvcCJ9LCJtYXJnaW5MZWZ0Ijp7InNpemUiOiIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJsZWZ0In0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiIwIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJyaWdodCJ9LCJtYXJnaW5Cb3R0b20iOnsic2l6ZSI6IjAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6ImJvdHRvbSJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzAwMDAwMDAwIiwiY29udHJvbFR5cGUiOiJpbWFnZSIsImlzQmx1ciI6dHJ1ZSwiYXNzZXRJZCI6IjEwMDEifSx7InVpZCI6IjEyMDAwMSIsImxheWVyIjoxMCwibWFyZ2luVG9wIjp7InNpemUiOiIxMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoidG9wIn0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiItMTAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InJpZ2h0In0sImhlaWdodCI6eyJzaXplIjoiMjIiLCJyZWZlcmVuY2UiOiJvd24iLCJsYXlvdXQiOiJoZWlnaHQifSwid2lkdGgiOnsic2l6ZSI6IjYwIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0Ijoid2lkdGgifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiM2NjMzMzMzMyIsImJvcmRlclJhZGl1cyI6IjUwJSIsImNvbnRyb2xUeXBlIjoiY291bnRkb3duY2xvc2UiLCJhdXRvQ2xvc2UiOjAsImJpbmRFdmVudCI6ImNsaWNrIiwiZXhlY3V0aW9uIjoiY2xvc2UiLCJ0aXRsZSI6IuWFs+mXrSIsImZvbnRTaXplIjoxMiwidGV4dENvbG9yIjoiI0ZGRkZGRiIsInRleHRBbGlnbiI6ImNlbnRlciIsImNvdW50RG93blRpbWUiOjB9LHsidWlkIjoiMTMwMDAxIiwibGF5ZXIiOjIsIm1hcmdpbkJvdHRvbSI6eyJzaXplIjoiLTE1IiwicmVmZXJlbmNlIjoiMTAwMDAxIiwibGF5b3V0IjoiYm90dG9tIn0sIm1hcmdpblJpZ2h0Ijp7InNpemUiOiItMTUiLCJyZWZlcmVuY2UiOiIxMDAwMDEiLCJsYXlvdXQiOiJyaWdodCJ9LCJoZWlnaHQiOnsic2l6ZSI6IjE1IiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0IjoiaGVpZ2h0In0sIndpZHRoIjp7InNpemUiOiI1MCUiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6IndpZHRoIn0sInN1cGVyVmlldyI6IjEwMDAwMSIsImJnQ29sb3IiOiIjMDAwMDAwMDAiLCJjb250cm9sVHlwZSI6InRhZyIsImZvbnRTaXplIjo5LCJ0ZXh0Q29sb3IiOiIjMDAwMDAwIiwidGV4dEFsaWduIjoicmlnaHQifSx7InVpZCI6IjE0MDAwMSIsImxheWVyIjoyLCJtYXJnaW5Cb3R0b20iOnsic2l6ZSI6Ii0xNSIsInJlZmVyZW5jZSI6IjEwMDAwMSIsImxheW91dCI6ImJvdHRvbSJ9LCJtYXJnaW5MZWZ0Ijp7InNpemUiOiIxNSIsInJlZmVyZW5jZSI6IjEwMDAwMSIsImxheW91dCI6ImxlZnQifSwiaGVpZ2h0Ijp7InNpemUiOiIxNSIsInJlZmVyZW5jZSI6Im93biIsImxheW91dCI6ImhlaWdodCJ9LCJ3aWR0aCI6eyJzaXplIjoiMTAwIiwicmVmZXJlbmNlIjoib3duIiwibGF5b3V0Ijoid2lkdGgifSwic3VwZXJWaWV3IjoiMTAwMDAxIiwiYmdDb2xvciI6IiM2Njg4ODg4OCIsImJvcmRlclJhZGl1cyI6MiwiY29udHJvbFR5cGUiOiJsb2dvIiwidGl0bGUiOiLlub/lkYoiLCJmb250U2l6ZSI6OSwidGV4dENvbG9yIjoiI0RERERERCIsInRleHRBbGlnbiI6ImNlbnRlciJ9LHsidWlkIjoiMTUwMDAxIiwibGF5ZXIiOjUsIm1hcmdpblRvcCI6eyJzaXplIjoiMTAiLCJyZWZlcmVuY2UiOiJzdXBlciIsImxheW91dCI6InRvcCJ9LCJtYXJnaW5MZWZ0Ijp7InNpemUiOiIxMCIsInJlZmVyZW5jZSI6InN1cGVyIiwibGF5b3V0IjoibGVmdCJ9LCJ3aWR0aCI6eyJzaXplIjoiODAlIiwicmVmZXJlbmNlIjoic3VwZXIiLCJsYXlvdXQiOiJ3aWR0aCJ9LCJzdXBlclZpZXciOiIxMDAwMDEiLCJiZ0NvbG9yIjoiIzAwMDAwMDAwIiwiY29udHJvbFR5cGUiOiJhcHBpbmZvIiwiYmluZEV2ZW50IjoiY2xpY2siLCJleGVjdXRpb24iOiJhcHBpbmZvIiwiZm9udFNpemUiOjEyLCJ0ZXh0Q29sb3IiOiIjODg4ODg4IiwidGV4dEFsaWduIjoibGVmdCJ9XQ==";
    }

    private String a(String str) {
        return String.format("temp_%s_%s", m0.a(), str);
    }
}
