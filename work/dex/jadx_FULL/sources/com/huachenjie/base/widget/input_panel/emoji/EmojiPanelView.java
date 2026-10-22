package com.huachenjie.base.widget.input_panel.emoji;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class EmojiPanelView extends FrameLayout {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Rect f32992a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f7342a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView f7343a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public EmojiCallback f7344a;
    public Rect b;

    public interface EmojiCallback {
        void a(@NonNull KeyEvent keyEventDown, @NonNull KeyEvent keyEventUp);

        void onEmojiSelected(String emoji);
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            EmojiPanelView.this.c();
        }
    }

    public class b implements InputEmojiAdapter.OnEmojiClickListener {
        public b() {
        }

        @Override // com.huachenjie.base.widget.input_panel.emoji.InputEmojiAdapter.OnEmojiClickListener
        public void a(View v, String text, int position) {
            if (EmojiPanelView.this.f7344a != null) {
                EmojiPanelView.this.f7344a.onEmojiSelected(text);
            }
        }
    }

    public class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            EmojiPanelView.this.fixVisibleRect();
        }
    }

    public EmojiPanelView(@NonNull Context context) {
        this(context, null);
    }

    public final void c() {
        KeyEvent keyEvent = new KeyEvent(0, 67);
        KeyEvent keyEvent2 = new KeyEvent(1, 67);
        EmojiCallback emojiCallback = this.f7344a;
        if (emojiCallback != null) {
            emojiCallback.a(keyEvent, keyEvent2);
        }
    }

    public void changeDeleteButton(boolean enabled) {
        View view = this.f7342a;
        if (view != null) {
            view.setEnabled(enabled);
        }
    }

    public final float d(Rect rect, Rect compareRect) {
        if (rect.isEmpty()) {
            return 0.0f;
        }
        Rect rect2 = new Rect(rect.left, rect.top, rect.right, rect.bottom);
        int iWidth = rect2.width() * rect2.height();
        rect2.intersect(compareRect);
        return ((rect2.width() * rect2.height()) * 1.0f) / iWidth;
    }

    public final void e(RecyclerView recyclerView, @NonNull Rect panelRect, Rect deleteRect) {
        RecyclerView.LayoutManager layoutManager;
        if (deleteRect == null || deleteRect.isEmpty() || (layoutManager = recyclerView.getLayoutManager()) == null) {
            return;
        }
        Rect rect = new Rect();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = layoutManager.getChildAt(i);
            rect.setEmpty();
            childAt.getGlobalVisibleRect(rect);
            if (panelRect.isEmpty() || panelRect.contains(rect)) {
                if (deleteRect.contains(rect)) {
                    childAt.setAlpha(0.0f);
                } else if (Rect.intersects(deleteRect, rect)) {
                    float fD = d(rect, deleteRect);
                    if (fD > 0.5f) {
                        childAt.setAlpha(0.0f);
                    } else {
                        childAt.setAlpha(1.0f - fD);
                    }
                } else {
                    childAt.setAlpha(1.0f);
                }
            }
        }
    }

    public final void f(Context context) {
        View.inflate(context, R.layout.view_panel_emoji, this);
        View viewFindViewById = findViewById(R.id.iv_delete_emoji);
        this.f7342a = viewFindViewById;
        viewFindViewById.setEnabled(false);
        this.f7342a.setOnClickListener(new a());
        this.f7343a = (RecyclerView) findViewById(R.id.emoji_recycler_view);
        InputEmojiAdapter inputEmojiAdapter = new InputEmojiAdapter();
        this.f7343a.setAdapter(inputEmojiAdapter);
        this.f7343a.setLayoutManager(new GridLayoutManager(getContext(), this.K));
        inputEmojiAdapter.setEmojiClickListener(new b());
        this.f7343a.addOnScrollListener(new c());
    }

    public void fixVisibleRect() {
        Rect rect = new Rect();
        if (getGlobalVisibleRect(rect)) {
            this.f32992a = rect;
            Rect rect2 = new Rect();
            boolean globalVisibleRect = this.f7342a.getGlobalVisibleRect(rect2);
            if (globalVisibleRect) {
                int width = getWidth() / this.K;
                Rect rect3 = this.b;
                Rect rect4 = this.f32992a;
                int i = rect4.right;
                rect3.set(i - (width * 2), rect2.top, i, rect4.bottom);
            }
            if (globalVisibleRect) {
                e(this.f7343a, this.f32992a, this.b);
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        fixVisibleRect();
    }

    public void setCallback(EmojiCallback callback) {
        this.f7344a = callback;
    }

    public EmojiPanelView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmojiPanelView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.K = 6;
        this.f32992a = new Rect();
        this.b = new Rect();
        f(context);
    }
}
