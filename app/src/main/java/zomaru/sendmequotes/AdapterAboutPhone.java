package zomaru.sendmequotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import zomaru.sendmequotes.PhoneInfo;

import java.util.ArrayList;

/**
 * Created by root on 1/7/18.
 */

public class AdapterAboutPhone extends RecyclerView.Adapter<AdapterAboutPhone.AdapterViewHolder> {

    private ArrayList<PhoneInfo> dataList;

    public AdapterAboutPhone(ArrayList<PhoneInfo> dataList) {
        this.dataList = dataList;

    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.about_phone, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        holder.textTitle.setText(dataList.get(position).getTitle());
        holder.textSubtilte.setText(dataList.get(position).getSubtitle());
    }

    @Override
    public int getItemCount () {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle, textSubtilte;
        private ImageView textImage;

        public AdapterViewHolder(View itemView) {
            super(itemView);
            textTitle = (TextView) itemView.findViewById(R.id.text_recycler_title);
            textImage = (ImageView) itemView.findViewById(R.id.image_recycler_about_phone);
            textSubtilte = (TextView) itemView.findViewById(R.id.text_recycler_subtitle);

        }
    }
}
