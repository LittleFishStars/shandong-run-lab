package com.kwad.components.core.innerEc.live.b.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.innerEc.live.base.QLiveMessage;
import com.kwad.components.core.innerEc.live.base.UserInfo;
import com.kwad.components.core.innerEc.live.comment.history.HistoryCommentsResponse;
import com.kwad.components.core.innerEc.live.comment.sendcomment.LiveSendCommentResponse;
import com.kwad.components.core.innerEc.live.widget.LiveCommentsView;
import com.kwad.components.core.innerEc.live.widget.OverScrollLayout;
import com.kwad.components.core.innerEc.live.widget.p;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbCommentFeed;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSCFeedPush;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PbSystemNoticeFeed;
import com.kwad.components.offline.api.core.adInnerEc.longconnection.listener.SCMessageListener;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.core.innerEc.live.b.a.a {
    private OverScrollLayout Va;
    private LiveCommentsView Vb;
    private com.kwad.components.core.innerEc.live.widget.h Vc;
    private com.kwad.components.core.innerEc.live.widget.f Vd;
    private com.kwad.components.core.innerEc.live.widget.j Vk;
    private com.kwad.components.core.innerEc.live.comment.history.b Vm;
    private com.kwad.components.core.innerEc.live.comment.sendcomment.b Vo;
    private ViewGroup Vr;
    private EditText Vs;
    private View Vt;
    private View Vu;
    private ViewGroup Vv;
    private Handler jk = new Handler(Looper.getMainLooper());
    private int Ve = 0;
    private int Vf = 8;
    private boolean Vg = false;
    private List<String> Vh = new ArrayList();
    private boolean Vi = true;
    private boolean Vj = false;
    private int Vl = 0;
    private boolean Vn = false;
    private List<com.kwad.components.core.innerEc.live.widget.c> Vp = new ArrayList();
    private final Object Vq = new Object();
    private boolean Vw = false;
    private com.kwad.components.core.innerEc.live.config.a UY = new com.kwad.components.core.innerEc.live.config.a() { // from class: com.kwad.components.core.innerEc.live.b.c.c.5
        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void a(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
        }

        @Override // com.kwad.components.core.innerEc.live.config.a
        public final void b(@NonNull com.kwad.components.core.innerEc.live.config.net.g gVar) {
            c.this.Vw = gVar.Ur.Uh.Uo;
        }
    };
    private SCMessageListener Vx = new com.kwad.components.core.innerEc.live.g.c() { // from class: com.kwad.components.core.innerEc.live.b.c.c.6
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.components.core.innerEc.live.g.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void g(PbSCFeedPush pbSCFeedPush) {
            if (pbSCFeedPush == null) {
                com.kwad.sdk.core.d.c.w("LiveAdCommentsPresenter", "scFeedPush is null");
                return;
            }
            List<PbSystemNoticeFeed> systemNoticeFeeds = pbSCFeedPush.getSystemNoticeFeeds();
            if (!c.this.Vg && systemNoticeFeeds != null && systemNoticeFeeds.size() > 0) {
                c.b(c.this, true);
                c cVar = c.this;
                cVar.a(new com.kwad.components.core.innerEc.live.widget.c(com.kwad.components.core.innerEc.live.comment.a.a(cVar.getContext(), c.a(c.this, systemNoticeFeeds.get(0).getContent(), "")), 1), false);
            }
            List<PbCommentFeed> commentFeeds = pbSCFeedPush.getCommentFeeds();
            if (commentFeeds == null || commentFeeds.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < commentFeeds.size(); i++) {
                PbCommentFeed pbCommentFeed = commentFeeds.get(i);
                if (!c.this.Vh.contains(pbCommentFeed.getCommentId())) {
                    c.this.Vh.add(pbCommentFeed.getCommentId());
                    arrayList.add(new com.kwad.components.core.innerEc.live.widget.c(com.kwad.components.core.innerEc.live.comment.a.a(c.this.getContext(), c.a(c.this, pbCommentFeed.getContent(), pbCommentFeed.getUser().getUserName()))));
                }
            }
            c.this.a((List<com.kwad.components.core.innerEc.live.widget.c>) arrayList, true);
        }
    };
    private com.kwad.components.core.innerEc.live.comment.history.b.a Vy = new com.kwad.components.core.innerEc.live.comment.history.b.a() { // from class: com.kwad.components.core.innerEc.live.b.c.c.7
        @Override // com.kwad.components.core.innerEc.live.comment.history.b.a
        @SuppressLint({"NotifyDataSetChanged"})
        public final void c(HistoryCommentsResponse historyCommentsResponse) {
            if (historyCommentsResponse != null && !historyCommentsResponse.historyFeedList.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < historyCommentsResponse.historyFeedList.size(); i++) {
                    PbCommentFeed pbCommentFeed = historyCommentsResponse.historyFeedList.get(i);
                    if (!c.this.Vh.contains(pbCommentFeed.getCommentId())) {
                        c.this.Vh.add(pbCommentFeed.getCommentId());
                        arrayList.add(new com.kwad.components.core.innerEc.live.widget.c(com.kwad.components.core.innerEc.live.comment.a.a(c.this.getContext(), c.a(c.this, pbCommentFeed.getContent(), pbCommentFeed.getUser().getUserName()))));
                    }
                }
                c.this.Vc.p(arrayList);
            }
            c.c(c.this, true);
            c.this.rR();
            c.this.Vc.notifyDataSetChanged();
        }

        @Override // com.kwad.components.core.innerEc.live.comment.history.b.a
        public final void rC() {
            c.c(c.this, true);
            c.this.rR();
        }
    };
    private com.kwad.components.core.innerEc.live.comment.sendcomment.b.a Vz = new com.kwad.components.core.innerEc.live.comment.sendcomment.b.a() { // from class: com.kwad.components.core.innerEc.live.b.c.c.8
        @Override // com.kwad.components.core.innerEc.live.comment.sendcomment.b.a
        public final void a(LiveSendCommentResponse liveSendCommentResponse, com.kwad.components.core.innerEc.live.base.b bVar) {
            if ((liveSendCommentResponse != null && liveSendCommentResponse.commentCode == 228205) || liveSendCommentResponse == null || TextUtils.isEmpty(liveSendCommentResponse.commentId)) {
                return;
            }
            ae.U(c.this.getContext(), "评论成功");
            if (c.this.Vh.contains(liveSendCommentResponse.commentId)) {
                return;
            }
            c.this.Vh.add(liveSendCommentResponse.commentId);
            c cVar = c.this;
            Context context = cVar.getContext();
            c cVar2 = c.this;
            cVar.a(new com.kwad.components.core.innerEc.live.widget.c(com.kwad.components.core.innerEc.live.comment.a.a(context, c.a(cVar2, bVar.content, cVar2.rQ()))));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public String rQ() {
        String strRe = com.kwad.components.core.innerEc.e.rf().re();
        if (TextUtils.isEmpty(strRe)) {
            return "广告联盟用户";
        }
        if (!this.Vw) {
            return strRe;
        }
        return strRe.substring(0, 1) + "***";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rR() {
        synchronized (this.Vq) {
            if (!this.Vp.isEmpty()) {
                this.Vc.p(new ArrayList(this.Vp));
                this.Vp.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        if (this.Vl != 0) {
            rT();
        } else if (rY()) {
            rV();
        } else {
            rW();
        }
    }

    private void rT() {
        by.s(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rU() {
        this.Vi = false;
    }

    private void rV() {
        this.Vi = true;
    }

    private void rW() {
        if (!this.Vj || this.Vi) {
            by.a(new bi() { // from class: com.kwad.components.core.innerEc.live.b.c.c.9
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    c.this.rX();
                }
            }, this, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rX() {
        RecyclerView.Adapter adapter;
        int itemCount;
        if (sb() || this.Vk.sZ() || (adapter = this.Vb.getAdapter()) == null || (itemCount = adapter.getItemCount()) <= 0) {
            return;
        }
        this.Vb.smoothScrollToPosition(itemCount - 1);
    }

    private boolean rY() {
        if (this.Vb.getChildCount() == 0 || this.Vb.getAdapter() == null) {
            return true;
        }
        LiveCommentsView liveCommentsView = this.Vb;
        View childAt = liveCommentsView.getChildAt(liveCommentsView.getChildCount() - 1);
        return (childAt.getBottom() - this.Vf <= this.Vb.getHeight() - this.Vb.getPaddingBottom()) && this.Vb.getChildAdapterPosition(childAt) == this.Vb.getAdapter().getItemCount() - 1;
    }

    private void rZ() {
        com.kwad.components.core.innerEc.live.widget.f fVar = new com.kwad.components.core.innerEc.live.widget.f(this.Vb);
        this.Vd = fVar;
        fVar.setOrientation(1);
        this.Vd.setStackFromEnd(true);
        this.Vd.a(new com.kwad.components.core.innerEc.live.widget.f.a(true, 250, 200));
        this.Vd.aL(true);
        this.Vb.setLayoutManager(this.Vd);
    }

    private void sa() {
        this.Vb.setCustomFadingEdgeLength(com.kwad.sdk.c.a.a.a(getContext(), 24.0f));
        this.Vb.setCustomFadingEdgeTop(0);
    }

    private boolean sb() {
        return this.Vd.sS() instanceof com.kwad.components.core.innerEc.live.widget.g.e;
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Ub.UO.add(new com.kwad.sdk.g.b<Object, Object>() { // from class: com.kwad.components.core.innerEc.live.b.c.c.3
            @Override // com.kwad.sdk.g.b
            public final Object apply(Object obj) {
                c cVar = c.this;
                View viewC = cVar.c(cVar.Vv, "commentContainer");
                com.kwad.sdk.core.d.c.d("LiveAdCommentsPresenter", "find commentContainer view: " + viewC);
                if (viewC == null || !(viewC instanceof ViewGroup)) {
                    return null;
                }
                p.b((ViewGroup) viewC, c.this.Vu);
                return null;
            }
        });
        this.Ub.UQ = new com.kwad.sdk.g.b<Object, Object>() { // from class: com.kwad.components.core.innerEc.live.b.c.c.4
            @Override // com.kwad.sdk.g.b
            @SuppressLint({"NotifyDataSetChanged"})
            public final Object apply(Object obj) {
                c.this.Vc.notifyDataSetChanged();
                return null;
            }
        };
        com.kwad.components.core.innerEc.live.widget.i iVar = new com.kwad.components.core.innerEc.live.widget.i();
        iVar.Zm = true;
        this.Vk = new com.kwad.components.core.innerEc.live.widget.j(iVar, this.Vb, getActivity());
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        bVar.UL = this.Vc;
        com.kwad.components.core.innerEc.live.comment.history.b bVar2 = new com.kwad.components.core.innerEc.live.comment.history.b(bVar.mAdTemplate);
        this.Vm = bVar2;
        bVar2.a(this.Vy);
        this.Vm.rA();
        this.Vo = new com.kwad.components.core.innerEc.live.comment.sendcomment.b(this.Ub.mAdTemplate);
        this.Ub.UH.registerSCMessageListener(this.Vx);
        this.Ub.UF.a(this.UY);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Vv = (ViewGroup) findViewById(R.id.ksad_live_ad_container);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.ksad_live_comments_layout, (ViewGroup) null);
        this.Vu = viewInflate;
        OverScrollLayout overScrollLayout = (OverScrollLayout) viewInflate.findViewById(R.id.ksad_live_comments_container);
        this.Va = overScrollLayout;
        overScrollLayout.setOverScrollType(OverScrollLayout.OverScrollType.ONLY_DOWN_DRAG);
        LiveCommentsView liveCommentsView = (LiveCommentsView) this.Vu.findViewById(R.id.ksad_live_comments_recyclerview);
        this.Vb = liveCommentsView;
        liveCommentsView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.kwad.components.core.innerEc.live.b.c.c.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                c.this.Vl = i;
                c.this.rS();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                if (i2 >= 0 || c.this.Vl != 1) {
                    return;
                }
                c.this.rU();
                c.this.Vd.aL(false);
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.comment_edit_root);
        this.Vr = viewGroup;
        viewGroup.setVisibility(8);
        this.Vs = (EditText) findViewById(R.id.ksad_comment_edit);
        View viewFindViewById = findViewById(R.id.ksad_comment_send);
        this.Vt = viewFindViewById;
        viewFindViewById.setOnClickListener(new com.kwad.components.core.innerEc.live.i.b(new View.OnClickListener() { // from class: com.kwad.components.core.innerEc.live.b.c.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String string = c.this.Vs.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    ae.c(c.this.getContext(), "说点什么吧~", 0);
                    return;
                }
                c.this.Vo.a(string, c.this.Vz);
                c.this.sc();
                c.this.Vs.setText("");
                c.this.Vr.setVisibility(8);
            }
        }));
        rZ();
        com.kwad.components.core.innerEc.live.widget.h hVar = new com.kwad.components.core.innerEc.live.widget.h();
        this.Vc = hVar;
        this.Vb.setAdapter(hVar);
        sa();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Vm.b(this.Vy);
        sc();
        synchronized (this.Vq) {
            this.Vp.clear();
        }
        this.Ub.UH.unregisterSCMessageListener(this.Vx);
        this.Vh.clear();
        this.Ub.UF.b(this.UY);
    }

    public final void sc() {
        this.Vr.setVisibility(8);
        try {
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.Vr.getWindowToken(), 2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.Vg = true;
        return true;
    }

    public static /* synthetic */ boolean c(c cVar, boolean z) {
        cVar.Vn = true;
        return true;
    }

    private static QLiveMessage m(String str, String str2) {
        QLiveMessage qLiveMessage = new QLiveMessage();
        qLiveMessage.content = str;
        UserInfo userInfo = new UserInfo();
        qLiveMessage.user = userInfo;
        userInfo.userName = str2;
        return qLiveMessage;
    }

    public static /* synthetic */ QLiveMessage a(c cVar, String str, String str2) {
        return m(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View c(View view, String str) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getContentDescription() != null && childAt.getContentDescription().toString().contains(str)) {
                return childAt;
            }
            View viewC = c(childAt, str);
            if (viewC != null) {
                return viewC;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.innerEc.live.widget.c cVar, boolean z) {
        if (z && !this.Vn) {
            synchronized (this.Vq) {
                this.Vp.add(cVar);
            }
        } else {
            this.Vc.b(cVar);
            if (z) {
                a(com.kwad.components.core.innerEc.live.widget.g.c.YZ);
                rX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<com.kwad.components.core.innerEc.live.widget.c> list, boolean z) {
        if (z && !this.Vn) {
            synchronized (this.Vq) {
                this.Vp.addAll(list);
            }
        } else {
            this.Vc.p(list);
            if (z) {
                a(com.kwad.components.core.innerEc.live.widget.g.c.YZ);
                rX();
            }
        }
    }

    private void a(com.kwad.components.core.innerEc.live.widget.g gVar) {
        this.Vd.b(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.components.core.innerEc.live.widget.c cVar) {
        a(cVar, true);
    }
}
