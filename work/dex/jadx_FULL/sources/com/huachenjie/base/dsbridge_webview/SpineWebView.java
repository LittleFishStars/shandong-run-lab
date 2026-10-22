package com.huachenjie.base.dsbridge_webview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.huachenjie.base.bean.SpineWebBean;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.PetModelBean;
import com.huachenjie.common.bean.SpineSuitModelBean;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.PetAnimationType;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class SpineWebView extends WebContentView {
    public static final int O = 1;
    public static final int P = 2;
    public static final int Q = 3;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SpineWebBean f32926a;
    public final String h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SpineWebView.this.reloadSpine();
            SpineWebView.this.getWebView().reload();
        }
    }

    public SpineWebView(Context context) {
        this(context, null);
    }

    private void setPetModelBean(PetModelBean petBean) {
        if (petBean == null) {
            petBean = new PetModelBean();
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("petModelCode", petBean.getMetaverseModelCode());
                ArrayList arrayList = new ArrayList();
                arrayList.add(jSONObject);
                getWebView().callHandler("setPetModel", arrayList.toArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f32926a.setPetSpineBean(null);
        }
    }

    private void setSuitModelBean(SpineSuitModelBean bean) {
        if (bean == null) {
            bean = new SpineSuitModelBean();
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("modelCode", bean.getModelCode());
                JSONArray jSONArray = new JSONArray();
                if (bean.getPartCodeList() != null && !bean.getPartCodeList().isEmpty()) {
                    for (String str : bean.getPartCodeList()) {
                        if (!TextUtils.isEmpty(str)) {
                            jSONArray.put(str);
                        }
                    }
                    jSONObject.put("partCodes", jSONArray);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(jSONObject);
                getWebView().callHandler("setModel", arrayList.toArray());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f32926a.setSpineBean(null);
        }
    }

    public final void g(String methodName, Object model) {
        try {
            if (model == null) {
                getWebView().callHandler(methodName, null, null);
            } else {
                JSONObject jSONObject = new JSONObject(new Gson().toJson(model));
                ArrayList arrayList = new ArrayList();
                arrayList.add(jSONObject);
                getWebView().callHandler(methodName, arrayList.toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void h(SpineWebBean bean) {
        StringBuffer stringBuffer = new StringBuffer(this.h);
        Map<String, String> params = bean.getParams();
        if (params == null) {
            params = new HashMap<>();
        }
        int i = 0;
        if (bean.getSpineBean() != null) {
            params.put(ze1.k, bean.getSpineBean().getModelCode());
            if (bean.getSpineBean().getPartCodeList() != null && !bean.getSpineBean().getPartCodeList().isEmpty()) {
                String strSubstring = "";
                for (String str : bean.getSpineBean().getPartCodeList()) {
                    if (!TextUtils.isEmpty(str)) {
                        strSubstring = strSubstring + str + ",";
                    }
                }
                if (strSubstring.endsWith(",")) {
                    strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
                }
                params.put("parts", strSubstring);
            }
        }
        if (bean.getPetSpineBean() != null) {
            params.put("petModel", bean.getPetSpineBean().getMetaverseModelCode());
        }
        if (bean.getOnlyPet()) {
            params.put("pet", "1");
        }
        for (String str2 : params.keySet()) {
            stringBuffer.append(i == 0 ? "?" : "&");
            stringBuffer.append(str2);
            stringBuffer.append("=");
            stringBuffer.append(params.get(str2));
            i++;
        }
        if (this.N != 2) {
            this.N = 2;
            if (bean.getHomeLotteryBean() != null) {
                this.f32926a.setHomeLotteryBean(bean.getHomeLotteryBean());
            }
            getWebView().loadUrl(stringBuffer.toString());
            return;
        }
        if (bean.getSpineBean() != null) {
            this.f32926a.setSpineBean(bean.getSpineBean());
        }
        if (bean.getPetSpineBean() != null) {
            this.f32926a.setPetSpineBean(bean.getPetSpineBean());
        }
        if (bean.getHomeLotteryBean() != null) {
            this.f32926a.setHomeLotteryBean(bean.getHomeLotteryBean());
        }
    }

    @Override // com.huachenjie.base.dsbridge_webview.WebContentView
    public void initError(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_web_network_error_spine, (ViewGroup) null);
        this.mErrorView = viewInflate;
        viewInflate.setLayoutParams(getChildLayoutParams());
        this.mErrorView.findViewById(R.id.web_net_error_bt).setOnClickListener(new a());
        addView(this.mErrorView);
    }

    @Override // com.huachenjie.base.dsbridge_webview.WebContentView
    public void initWebViewConfig(DWebView webView) {
        webView.setNeedCallClick(true);
        webView.setBackgroundColor(0);
        if (webView.getBackground() != null) {
            webView.getBackground().setAlpha(0);
        }
    }

    public void loadSpine(SpineSuitModelBean bean, PetModelBean petBean) {
        loadSpine(new SpineWebBean(bean, petBean, false, null, null));
    }

    public void loadSpineFinish() {
        this.N = 3;
        if (this.f32926a.getSpineBean() != null) {
            setSuitModelBean(this.f32926a.getSpineBean());
        }
        if (this.f32926a.getPetSpineBean() != null) {
            setPetModelBean(this.f32926a.getPetSpineBean());
        }
        if (this.f32926a.getHomeLotteryBean() != null) {
            g("setLottery", this.f32926a.getHomeLotteryBean());
        }
    }

    public void reloadSpine() {
        this.N = 1;
    }

    public void restartAnimation() {
        try {
            getWebView().callHandler("resetAnimation", null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setPetAnimations(PetAnimationType animationType) {
        setPetAnimations(Collections.singletonList(animationType.value));
    }

    public SpineWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.N = 1;
        this.f32926a = new SpineWebBean();
        this.h = Environment.c + "/spine-reborn.html";
    }

    private void setPetAnimations(List<String> animationList) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (animationList != null && !animationList.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : animationList) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("animations", jSONArray);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(jSONObject);
            getWebView().callHandler("setPetAnimations", arrayList.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSpine(SpineSuitModelBean bean) {
        loadSpine(new SpineWebBean(bean, null, false, null, null));
    }

    public void loadSpine(PetModelBean petBean) {
        loadSpine(new SpineWebBean(null, petBean, true, null, null));
    }

    public void loadSpine(SpineWebBean bean) {
        if (this.N == 3) {
            if (!bean.getOnlyPet()) {
                this.f32926a.setSpineBean(bean.getSpineBean());
                setSuitModelBean(bean.getSpineBean());
            }
            this.f32926a.setPetSpineBean(bean.getPetSpineBean());
            setPetModelBean(bean.getPetSpineBean());
            if (bean.getHomeLotteryBean() != null) {
                this.f32926a.setHomeLotteryBean(bean.getHomeLotteryBean());
                g("setLottery", bean.getHomeLotteryBean());
                return;
            }
            return;
        }
        h(bean);
    }
}
