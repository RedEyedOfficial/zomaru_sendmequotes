package zomaru.sendmequotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 4/2/18.
 */

public class AdapterChangelog extends RecyclerView.Adapter<AdapterChangelog.AdapterHolder> {
    private ArrayList<ChangelogInfo> arrayList;

    public AdapterChangelog(ArrayList<ChangelogInfo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.changelog_layout, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getTitle());
        holder.textSub.setText(arrayList.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return (arrayList != null) ? arrayList.size() : 0;
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        private TextView textView, textSub;
        private ImageView imageView;

        public AdapterHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_changelog_title);
            imageView = (ImageView) itemView.findViewById(R.id.image_recycler_changelog);
            textSub = (TextView) itemView.findViewById(R.id.text_changelog_subtitle);
        }
    }
}
