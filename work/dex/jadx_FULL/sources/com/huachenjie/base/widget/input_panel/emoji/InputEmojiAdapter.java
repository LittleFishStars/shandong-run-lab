package com.huachenjie.base.widget.input_panel.emoji;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vanniktech.emoji.EmojiTextView;
import com.zj.adlib.kz2;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class InputEmojiAdapter extends RecyclerView.Adapter<InputEmojiViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnEmojiClickListener f32996a;
    public String f = "😀";

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public List<String> f7345f = kz2.b();

    public class InputEmojiViewHolder extends RecyclerView.ViewHolder {
        public InputEmojiViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnEmojiClickListener {
        void a(View v, String text, int position);
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ int K;

        public a(final int val$position) {
            this.K = val$position;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            if (InputEmojiAdapter.this.f32996a == null || TextUtils.isEmpty((CharSequence) InputEmojiAdapter.this.f7345f.get(this.K))) {
                return;
            }
            InputEmojiAdapter.this.f32996a.a(v, (String) InputEmojiAdapter.this.f7345f.get(this.K), this.K);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"RecyclerView"})
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull InputEmojiViewHolder holder, int position) {
        EmojiTextView emojiTextViewFindViewWithTag = holder.itemView.findViewWithTag(this.f);
        if (emojiTextViewFindViewWithTag != null) {
            emojiTextViewFindViewWithTag.setText(this.f7345f.get(position));
            emojiTextViewFindViewWithTag.setOnClickListener(new a(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public InputEmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        EmojiTextView emojiTextView = new EmojiTextView(parent.getContext());
        emojiTextView.setTag(this.f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        emojiTextView.setGravity(17);
        float fApplyDimension = TypedValue.applyDimension(2, 28.0f, parent.getContext().getResources().getDisplayMetrics());
        float fApplyDimension2 = TypedValue.applyDimension(1, 8.0f, parent.getContext().getResources().getDisplayMetrics());
        emojiTextView.setEmojiSize((int) fApplyDimension);
        layoutParams.gravity = 17;
        int i = (int) fApplyDimension2;
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        frameLayout.addView((View) emojiTextView, (ViewGroup.LayoutParams) layoutParams);
        return new InputEmojiViewHolder(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f7345f.size();
    }

    public void setEmojiClickListener(OnEmojiClickListener emojiClickListener) {
        this.f32996a = emojiClickListener;
    }
}
