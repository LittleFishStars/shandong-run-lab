package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab.ScopeExpressContainer;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.asset.AssetModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.ViewModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.view.status.StatusTextModel;
import com.beizi.fusion.df;
import com.beizi.fusion.he;
import com.beizi.fusion.no;
import com.beizi.fusion.re;
import com.beizi.fusion.un;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeTextView extends TextView implements he, re, df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f27048a;
    private final String b;
    private String c;
    protected RenderModel d;
    protected AssetModel e;
    private ScopeExpressContainer f;
    private StatusTextModel g;
    private String h;

    public ScopeTextView(@NonNull Context context) {
        super(context);
        this.f27048a = "left";
        this.b = "right";
    }

    public void a() {
        String title;
        AssetModel assetModel = this.e;
        if (assetModel == null || assetModel.getTitle() == null) {
            title = this.d.getViewModel() != null ? this.d.getViewModel().getTitle() : null;
        } else {
            title = this.e.getTitle().getText();
        }
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(title)) {
            setText(title);
        }
        updateTextWithStatus(re.a.NORMAL);
    }

    @Override // com.beizi.fusion.he
    public void bindAssetModel(AssetModel assetModel) {
        this.e = assetModel;
    }

    @Override // com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        this.d = renderModel;
        if (renderModel == null || renderModel.getViewModel() == null) {
            return;
        }
        StatusTextModel titleInfo = renderModel.getViewModel().getTitleInfo();
        this.g = titleInfo;
        if (titleInfo != null) {
            this.h = titleInfo.getNormal();
        }
    }

    public void fillContent(he.a aVar) {
        RenderModel renderModel = this.d;
        if (renderModel == null || renderModel.getViewModel() == null) {
            return;
        }
        ViewModel viewModel = this.d.getViewModel();
        un.a(getContext(), this, viewModel.getBgColor(), no.i(viewModel.getBorderSize()), viewModel.getBorderColor(), un.a(viewModel.getBorderRadius(), getLayoutParams().height));
        setTextConfig(viewModel);
        a();
        aVar.b(this.d.getId());
    }

    @Override // com.beizi.fusion.he
    public ScopeExpressContainer getExpressRoot() {
        return this.f;
    }

    @Override // com.beizi.fusion.he
    public int getLayer() {
        return this.d.getLayer();
    }

    @Override // com.beizi.fusion.he
    public String getScopeViewID() {
        return this.c;
    }

    @Override // com.beizi.fusion.he
    public void onViewDestroy() {
    }

    public void onViewPause(boolean z) {
    }

    public void onViewResume(boolean z) {
    }

    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        this.f = scopeExpressContainer;
        ScopeExpressContainer.d.a(scopeExpressContainer, (df) this);
        ScopeExpressContainer.d.a(scopeExpressContainer, (re) this);
    }

    @Override // com.beizi.fusion.he
    public void setScopeViewID(String str) {
        this.c = str;
        setId(no.i(str));
    }

    public void setTextConfig(ViewModel viewModel) {
        int lineCount = viewModel.getLineCount();
        if (lineCount > 0) {
            setLines(lineCount);
        }
        setTextSize(2, viewModel.getFontSize());
        if (no.d(viewModel.getTextColor())) {
            setTextColor(Color.parseColor(viewModel.getTextColor()));
        }
        String textAlign = viewModel.getTextAlign();
        if (TextUtils.isEmpty(textAlign)) {
            return;
        }
        textAlign.getClass();
        if (textAlign.equals("left")) {
            setGravity(19);
        } else if (textAlign.equals("right")) {
            setGravity(21);
        } else {
            setGravity(17);
        }
    }

    @Override // com.beizi.fusion.re
    public void updateTextWithStatus(final re.a aVar) {
        post(new Runnable() { // from class: com.zj.adlib.ww7
            @Override // java.lang.Runnable
            public final void run() {
                this.f45702a.a(aVar);
            }
        });
    }

    @Override // com.beizi.fusion.df
    public void updateTextWithTimer(final String str, final String str2) {
        post(new Runnable() { // from class: com.zj.adlib.xw7
            @Override // java.lang.Runnable
            public final void run() {
                this.f45908a.a(str, str2);
            }
        });
    }

    public ScopeTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27048a = "left";
        this.b = "right";
    }

    public ScopeTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27048a = "left";
        this.b = "right";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(re.a aVar) {
        StatusTextModel statusTextModel = this.g;
        if (statusTextModel != null) {
            if (aVar == re.a.NORMAL) {
                this.h = statusTextModel.getNormal();
            } else if (aVar == re.a.SELECTED) {
                this.h = statusTextModel.getSelected();
            } else {
                this.h = statusTextModel.getFinalText();
            }
            if (TextUtils.isEmpty(this.h) || this.h.contains("__")) {
                return;
            }
            setText(this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2) {
        if (TextUtils.isEmpty(this.h) || !this.h.contains(str)) {
            return;
        }
        setText(a(this.h, str, str2));
    }

    private String a(String str, String str2, String str3) {
        return str.replace(str2, str3);
    }
}
