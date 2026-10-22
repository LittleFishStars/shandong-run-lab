package com.alibaba.triver.support.ui.auth.settings;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.BaseRenderImpl;
import com.alibaba.ariver.engine.api.RVEngine;
import com.alibaba.ariver.engine.api.bridge.RenderBridge;
import com.alibaba.ariver.engine.api.bridge.model.CreateParams;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.engine.api.bridge.model.ScrollChangedCallback;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.models.DynamicPluginInfo;
import com.alibaba.triver.kit.api.model.WindowInfoModel;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.alibaba.triver.support.ui.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class a extends BaseRenderImpl {
    private static final String b = "AriverTriver:AuthorizeSetting";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Page f25175a;
    private View c;
    private int d;
    private StatusUpdater e;
    private List<StatusItemEntity> f;
    private Set<Integer> g;
    private View.OnClickListener h;
    private StatusUpdater.a i;

    public a(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        super(rVEngine, activity, dataNode, createParams);
        this.f = new ArrayList();
        this.g = new HashSet();
        this.h = new View.OnClickListener() { // from class: com.alibaba.triver.support.ui.auth.settings.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIntValue = ((Integer) view.getTag()).intValue();
                StatusItemEntity statusItemEntity = (StatusItemEntity) a.this.f.get(iIntValue);
                if (statusItemEntity.hasAccess) {
                    statusItemEntity.hasAccess = false;
                    view.setBackgroundResource(R.drawable.triver_authorize_set_off);
                } else {
                    statusItemEntity.hasAccess = true;
                    view.setBackgroundResource(R.drawable.triver_authorize_set_on);
                }
                a.this.g.add(Integer.valueOf(iIntValue));
            }
        };
        this.i = new StatusUpdater.a() { // from class: com.alibaba.triver.support.ui.auth.settings.a.3
            @Override // com.alibaba.triver.support.ui.auth.settings.StatusUpdater.a
            public void a(boolean z, String str) {
                RVLogger.d(a.b, "update local authorize settings:" + z);
            }
        };
        Page page = (Page) dataNode;
        this.f25175a = page;
        WindowInfoModel windowInfoModel = (WindowInfoModel) page.getData(WindowInfoModel.class);
        if (windowInfoModel == null) {
            windowInfoModel = new WindowInfoModel();
            this.f25175a.setData(WindowInfoModel.class, windowInfoModel);
        }
        windowInfoModel.translucent = false;
        windowInfoModel.navigationBarForceEnable = true;
        this.d = this.f25175a.getPageId();
        this.c = View.inflate(getActivity(), R.layout.triver_view_authorize_setting, null);
    }

    @Override // com.alibaba.ariver.engine.api.Render
    @Nullable
    public Bitmap getCapture(int i) {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getPageId() {
        return this.d;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public RenderBridge getRenderBridge() {
        return null;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public int getScrollY() {
        return 0;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public View getView() {
        return this.c;
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void init() {
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    @SuppressLint({"StaticFieldLeak"})
    public void load(LoadParams loadParams) {
        TitleBar titleBar;
        super.load(loadParams);
        final AppModel appModel = this.f25175a.getApp() != null ? (AppModel) this.f25175a.getApp().getData(AppModel.class) : null;
        if (appModel == null) {
            TriverToastUtils.showToast(getActivity(), InternationalUtil.getString(this.f25175a, R.string.triver_get_scope_info_error));
            this.f25175a.getApp().popPage(null);
            return;
        }
        Page page = this.f25175a;
        if (page != null && page.getPageContext() != null && (titleBar = this.f25175a.getPageContext().getTitleBar()) != null) {
            titleBar.setTitle(InternationalUtil.getString(this.f25175a, R.string.triver_scope_setting), null, null, null, false);
        }
        new AsyncTask<Void, Void, List<StatusItemEntity>>() { // from class: com.alibaba.triver.support.ui.auth.settings.a.2
            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List<StatusItemEntity> doInBackground(Void... voidArr) {
                Page page2 = a.this.f25175a;
                return c.a(appModel, (page2 == null || page2.getApp() == null) ? null : (DynamicPluginInfo) a.this.f25175a.getApp().getData(DynamicPluginInfo.class));
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(List<StatusItemEntity> list) {
                if (list != null && !list.isEmpty()) {
                    a aVar = a.this;
                    aVar.e = new StatusUpdater(aVar.f25175a.getApp());
                    a.this.f = list;
                    a aVar2 = a.this;
                    aVar2.a((List<StatusItemEntity>) aVar2.f);
                    return;
                }
                TriverToastUtils.showToast(a.this.getActivity(), InternationalUtil.getString(a.this.f25175a, R.string.triver_get_scope_info_error));
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl
    public void onDestroy() {
        List<StatusItemEntity> list;
        if (this.e == null || (list = this.f) == null || list.isEmpty()) {
            return;
        }
        this.e.a(this.f, this.i);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onPause() {
        if (this.e == null || this.g.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.g.iterator();
        while (it.hasNext()) {
            StatusItemEntity statusItemEntity = this.f.get(it.next().intValue());
            if (statusItemEntity != null) {
                arrayList.add(statusItemEntity);
            }
        }
        this.e.a(arrayList, this.i);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onResume() {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(ScrollChangedCallback scrollChangedCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    private View a(int i, StatusItemEntity statusItemEntity) {
        View viewInflate = View.inflate(getActivity(), R.layout.triver_view_authorize_item, null);
        ((TextView) viewInflate.findViewById(R.id.triver_scope_name)).setText(statusItemEntity.displayName);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.triver_switch_view);
        if (statusItemEntity.hasAccess) {
            imageView.setBackgroundResource(R.drawable.triver_authorize_set_on);
        } else {
            imageView.setBackgroundResource(R.drawable.triver_authorize_set_off);
        }
        imageView.setOnClickListener(this.h);
        imageView.setTag(Integer.valueOf(i));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<StatusItemEntity> list) {
        LinearLayout linearLayout = (LinearLayout) this.c.findViewById(R.id.setting_content);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            linearLayout.addView(a(i, list.get(i)), new FrameLayout.LayoutParams(-1, -2));
        }
    }
}
