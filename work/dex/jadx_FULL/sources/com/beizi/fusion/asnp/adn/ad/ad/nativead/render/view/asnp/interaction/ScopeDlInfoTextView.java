package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.bc;
import com.beizi.fusion.he;
import com.beizi.fusion.no;
import com.huawei.hms.push.AttributionReporter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeDlInfoTextView extends ScopeInteractionTextView implements bc {
    private DownloadInfoModel j;
    private String k;

    public class a extends no.a {
        private final String c;

        public a(String str, String str2, String str3) {
            super(str, str2);
            this.c = str3;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ScopeDlInfoTextView.this.k = this.c;
        }
    }

    public ScopeDlInfoTextView(@NonNull Context context) {
        super(context);
        this.k = null;
    }

    private void b() {
        DownloadInfoModel downloadInfoModel = this.j;
        if (downloadInfoModel == null || !downloadInfoModel.isConformanceByDlInfo()) {
            return;
        }
        SpannableString spannableStringA = no.a("应用名称: " + this.j.getName() + " | 开发者: " + this.j.getDeveloper() + " | 应用版本: " + this.j.getVersion() + " | 权限详情 | 隐私协议 | 功能介绍", new a("权限详情", "#02cbf7", AttributionReporter.SYSTEM_PERMISSION), new a("隐私协议", "#02cbf7", "privacy"), new a("功能介绍", "#02cbf7", "introduction"));
        setHighlightColor(0);
        setMovementMethod(LinkMovementMethod.getInstance());
        setText(spannableStringA);
    }

    @Override // com.beizi.fusion.bc
    public void bindDownloadInfo(DownloadInfoModel downloadInfoModel) {
        this.j = downloadInfoModel;
    }

    public void clearDetailActivityTab() {
        this.k = null;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeTextView, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        b();
        super.fillContent(aVar);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, com.beizi.fusion.zc
    public String getActionType() {
        return "downloadInfo";
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeInteractionTextView, com.beizi.fusion.zc
    public String getInteractionType() {
        return "click";
    }

    public String getWhereDetailActivityTab() {
        return this.k;
    }

    public ScopeDlInfoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = null;
    }

    public ScopeDlInfoTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = null;
    }
}
