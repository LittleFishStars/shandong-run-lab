package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.interaction.ScopeDlInfoTextView;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.down.DownloadInfoModel;
import com.beizi.fusion.asnp.adn.ad.widget.activity.ASNPDlInfoDetailActivity;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h1 extends aa {
    private DownloadInfoModel b() {
        NativeModel nativeModel = this.b;
        if (nativeModel == null || nativeModel.getDownloadInfo() == null) {
            return null;
        }
        return this.b.getDownloadInfo();
    }

    @Override // com.beizi.fusion.dc
    public void a(View view, int i) {
        String whereDetailActivityTab;
        if (view instanceof ScopeDlInfoTextView) {
            ScopeDlInfoTextView scopeDlInfoTextView = (ScopeDlInfoTextView) view;
            whereDetailActivityTab = scopeDlInfoTextView.getWhereDetailActivityTab();
            scopeDlInfoTextView.clearDetailActivityTab();
        } else {
            whereDetailActivityTab = null;
        }
        DownloadInfoModel downloadInfoModelB = b();
        if (downloadInfoModelB != null) {
            a(view.getContext(), downloadInfoModelB, whereDetailActivityTab);
        }
    }

    private void a(Context context, DownloadInfoModel downloadInfoModel, String str) {
        Intent intent = new Intent(context, (Class<?>) ASNPDlInfoDetailActivity.class);
        intent.putExtra("dlm", downloadInfoModel.toJsonString());
        intent.putExtra("whichTab", str);
        wf.c(context, intent);
    }
}
