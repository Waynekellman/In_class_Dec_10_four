package com.nyc.in_class_dec_10_four;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Wayne Kellman on 12/10/17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<BirdModel> birdModels;

    public Adapter(ArrayList<BirdModel> birdModels) {
        this.birdModels = birdModels;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < birdModels.get(position).getMembers().size(); i++) {
            if(!(i == birdModels.get(position).getMembers().size() -1)) {
                sb.append(birdModels.get(position).getMembers().get(i) + "/");
            } else {
                sb.append(birdModels.get(position).getMembers().get(i));
            }
        }
        holder.family.setText("Family: " + birdModels.get(position).getFamily());
        String s = "Members: " + sb.toString();
        holder.members.setText(s);
    }

    @Override
    public int getItemCount() {
        return birdModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView family, members;
        public ViewHolder(View itemView) {
            super(itemView);

            family = itemView.findViewById(R.id.family);
            members = itemView.findViewById(R.id.members);
        }
    }
}
