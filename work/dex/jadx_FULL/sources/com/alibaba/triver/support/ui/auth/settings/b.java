package com.alibaba.triver.support.ui.auth.settings;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
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
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.triver.kit.api.model.WindowInfoModel;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import com.alibaba.triver.support.ui.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends BaseRenderImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25179a = "AriverTriver:AuthorizeSetting";
    private Page b;
    private View c;
    private int d;
    private boolean e;
    private Activity f;
    private ExpandableListView g;
    private BaseExpandableListAdapter h;
    private TextView i;
    private List<AuthStatusEntity> j;
    private ExpandableListView.OnGroupClickListener k;
    private ExpandableListView.OnChildClickListener l;

    public class a extends BaseExpandableListAdapter {
        public a() {
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getChild(int i, int i2) {
            List<AuthStatusEntity> listD = ((AuthStatusEntity) b.this.j.get(i)).d();
            if (listD == null || listD.isEmpty()) {
                return null;
            }
            return listD.get(i2);
        }

        @Override // android.widget.ExpandableListAdapter
        public long getChildId(int i, int i2) {
            return i2;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            C0179b c0179b;
            if (view == null) {
                view = LayoutInflater.from(b.this.f).inflate(R.layout.triver_view_subscribe_item, viewGroup, false);
                c0179b = new C0179b();
                c0179b.f25183a = (TextView) view.findViewById(R.id.triver_subscribe_name);
                c0179b.b = (ImageView) view.findViewById(R.id.triver_switch_view);
                c0179b.c = view.findViewById(R.id.triver_top_split);
                c0179b.d = view.findViewById(R.id.triver_line);
                view.setTag(c0179b);
            } else {
                c0179b = (C0179b) view.getTag();
            }
            if (i >= b.this.j.size()) {
                c0179b.f25183a.setVisibility(8);
                c0179b.b.setVisibility(8);
                c0179b.c.setVisibility(8);
                return view;
            }
            AuthStatusEntity authStatusEntity = (AuthStatusEntity) b.this.j.get(i);
            if (authStatusEntity.d() == null || authStatusEntity.d().isEmpty() || !authStatusEntity.g() || authStatusEntity.d().size() <= i2) {
                c0179b.f25183a.setVisibility(8);
                c0179b.b.setVisibility(8);
                c0179b.c.setVisibility(8);
            } else {
                AuthStatusEntity authStatusEntity2 = ((AuthStatusEntity) b.this.j.get(i)).d().get(i2);
                if (i2 == 0) {
                    c0179b.c.setVisibility(0);
                    c0179b.d.setVisibility(8);
                } else {
                    c0179b.c.setVisibility(8);
                    c0179b.d.setVisibility(0);
                }
                c0179b.f25183a.setVisibility(0);
                c0179b.b.setVisibility(0);
                c0179b.f25183a.setText(authStatusEntity2.b());
                if (authStatusEntity2.g()) {
                    c0179b.b.setImageResource(R.drawable.triver_subscribe_auth_check);
                } else {
                    c0179b.b.setImageResource(R.drawable.triver_subscribe_auth_uncheck);
                }
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public int getChildrenCount(int i) {
            List<AuthStatusEntity> listD = ((AuthStatusEntity) b.this.j.get(i)).d();
            if (listD != null) {
                return listD.size();
            }
            return 0;
        }

        @Override // android.widget.ExpandableListAdapter
        public Object getGroup(int i) {
            return b.this.j.get(i);
        }

        @Override // android.widget.ExpandableListAdapter
        public int getGroupCount() {
            return b.this.j.size();
        }

        @Override // android.widget.ExpandableListAdapter
        public long getGroupId(int i) {
            return i;
        }

        @Override // android.widget.ExpandableListAdapter
        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = LayoutInflater.from(b.this.f).inflate(R.layout.triver_view_authorize_item_new, viewGroup, false);
                cVar = new c();
                cVar.f25184a = (TextView) view.findViewById(R.id.triver_scope_name);
                cVar.b = (ImageView) view.findViewById(R.id.triver_switch_view);
                cVar.c = (TextView) view.findViewById(R.id.triver_setting_title);
                cVar.d = view.findViewById(R.id.triver_line);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            if (i >= b.this.j.size()) {
                cVar.f25184a.setVisibility(8);
                cVar.b.setVisibility(8);
                cVar.c.setVisibility(8);
                cVar.d.setVisibility(8);
                return view;
            }
            AuthStatusEntity authStatusEntity = (AuthStatusEntity) b.this.j.get(i);
            cVar.f25184a.setText(authStatusEntity.b());
            cVar.f25184a.setVisibility(0);
            if (authStatusEntity.c() == AuthStatusEntity.AuthType.Device || authStatusEntity.c() == AuthStatusEntity.AuthType.UserInfo) {
                if (i == 0) {
                    cVar.c.setVisibility(0);
                    cVar.d.setVisibility(8);
                } else {
                    cVar.c.setVisibility(8);
                }
                cVar.c.setText(R.string.triver_scopt_allow_get_my_info);
            } else {
                cVar.c.setVisibility(0);
                cVar.c.setText(authStatusEntity.f());
                cVar.d.setVisibility(8);
            }
            cVar.b.setVisibility(0);
            if (authStatusEntity.g()) {
                b.this.g.expandGroup(i);
                cVar.b.setImageResource(R.drawable.triver_authorize_set_on);
            } else {
                b.this.g.collapseGroup(i);
                cVar.b.setImageResource(R.drawable.triver_authorize_set_off);
            }
            return view;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.ExpandableListAdapter
        public boolean isChildSelectable(int i, int i2) {
            return true;
        }
    }

    /* JADX INFO: renamed from: com.alibaba.triver.support.ui.auth.settings.b$b, reason: collision with other inner class name */
    public static class C0179b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f25183a;
        ImageView b;
        View c;
        View d;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f25184a;
        ImageView b;
        TextView c;
        View d;
    }

    public static class e implements com.alibaba.triver.support.ui.auth.settings.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<b> f25186a;

        public e(b bVar) {
            this.f25186a = new WeakReference<>(bVar);
        }

        @Override // com.alibaba.triver.support.ui.auth.settings.d.a
        public void a(final boolean z, final String str) {
            RVLogger.d(b.f25179a, "update local authorize settings:" + z);
            final b bVar = this.f25186a.get();
            if (bVar == null) {
                return;
            }
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.support.ui.auth.settings.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!z) {
                        TriverToastUtils.showToast(bVar.f, str);
                    }
                    if (bVar.e) {
                        return;
                    }
                    if (z) {
                        bVar.h.notifyDataSetChanged();
                    } else {
                        new d(bVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }
                }
            });
        }
    }

    public b(RVEngine rVEngine, Activity activity, DataNode dataNode, CreateParams createParams) {
        super(rVEngine, activity, dataNode, createParams);
        this.j = new ArrayList();
        this.k = new ExpandableListView.OnGroupClickListener() { // from class: com.alibaba.triver.support.ui.auth.settings.b.1
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
                if (b.this.j.size() <= i) {
                    return false;
                }
                AuthStatusEntity authStatusEntity = (AuthStatusEntity) b.this.j.get(i);
                authStatusEntity.b(!authStatusEntity.g());
                authStatusEntity.a(!authStatusEntity.e());
                b.this.h.notifyDataSetChanged();
                return true;
            }
        };
        this.l = new ExpandableListView.OnChildClickListener() { // from class: com.alibaba.triver.support.ui.auth.settings.b.2
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
                if (b.this.j.size() <= i) {
                    return false;
                }
                AuthStatusEntity authStatusEntity = (AuthStatusEntity) b.this.j.get(i);
                if (authStatusEntity != null && authStatusEntity.d() != null && authStatusEntity.d().size() > i2) {
                    AuthStatusEntity authStatusEntity2 = authStatusEntity.d().get(i2);
                    authStatusEntity2.b(!authStatusEntity2.g());
                    authStatusEntity2.a(!authStatusEntity2.e());
                    b.this.h.notifyDataSetChanged();
                }
                return true;
            }
        };
        Page page = (Page) dataNode;
        this.b = page;
        this.f = activity;
        WindowInfoModel windowInfoModel = (WindowInfoModel) page.getData(WindowInfoModel.class);
        if (windowInfoModel == null) {
            windowInfoModel = new WindowInfoModel();
            this.b.setData(WindowInfoModel.class, windowInfoModel);
        }
        windowInfoModel.translucent = false;
        windowInfoModel.navigationBarForceEnable = true;
        this.d = this.b.getPageId();
        this.c = View.inflate(getActivity(), R.layout.triver_view_authorize_setting_new, null);
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
    public void load(LoadParams loadParams) {
        super.load(loadParams);
        TitleBar titleBar = this.b.getPageContext() != null ? this.b.getPageContext().getTitleBar() : null;
        if (titleBar != null) {
            titleBar.setTitle(InternationalUtil.getString(this.b, R.string.triver_scope_setting), null, null, null, false);
        }
        if ((this.b.getApp() != null ? (AppModel) this.b.getApp().getData(AppModel.class) : null) == null) {
            TriverToastUtils.showToast(getActivity(), this.f.getResources().getString(R.string.triver_get_scope_info_error));
            this.b.getApp().popPage(null);
            return;
        }
        ExpandableListView expandableListView = (ExpandableListView) this.c.findViewById(R.id.trv_expand_list);
        this.g = expandableListView;
        expandableListView.setGroupIndicator(null);
        a aVar = new a();
        this.h = aVar;
        this.g.setAdapter(aVar);
        this.g.setOnGroupClickListener(this.k);
        this.g.setOnChildClickListener(this.l);
        this.h.notifyDataSetChanged();
        this.i = (TextView) this.c.findViewById(R.id.trv_no_setting_desc);
        new d(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl
    public void onDestroy() {
        this.e = true;
        a();
    }

    @Override // com.alibaba.ariver.engine.BaseRenderImpl, com.alibaba.ariver.engine.api.Render
    public void onPause() {
        a();
        super.onPause();
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void setScrollChangedCallback(ScrollChangedCallback scrollChangedCallback) {
    }

    @Override // com.alibaba.ariver.engine.api.Render
    public void showErrorView(View view) {
    }

    public static class d extends AsyncTask<Void, Void, List<AuthStatusEntity>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        WeakReference<b> f25185a;

        public d(b bVar) {
            this.f25185a = new WeakReference<>(bVar);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<AuthStatusEntity> doInBackground(Void... voidArr) {
            b bVar = this.f25185a.get();
            if (bVar == null) {
                return null;
            }
            return com.alibaba.triver.support.ui.auth.settings.c.a(bVar.b.getApp());
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<AuthStatusEntity> list) {
            b bVar = this.f25185a.get();
            if (bVar == null) {
                return;
            }
            if (list != null && !list.isEmpty()) {
                bVar.j.clear();
                bVar.j.addAll(list);
                bVar.h.notifyDataSetChanged();
            } else {
                bVar.i.setVisibility(0);
                bVar.g.setVisibility(8);
            }
        }
    }

    private void a() {
        new com.alibaba.triver.support.ui.auth.settings.d().a(this.b.getApp(), this.j, new e(this));
    }
}
