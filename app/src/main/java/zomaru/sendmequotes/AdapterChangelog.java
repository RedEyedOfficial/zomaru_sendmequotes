/*
 * Copyright (C) 2018 Red Eyed Official
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package zomaru.sendmequotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

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
