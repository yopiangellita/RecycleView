package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BuahAdapter extends RecyclerView.Adapter<BuahAdapter.BPViewHolder> {
    Context context;
    List<buah> BPlist;
    OnClickShowListener monClickShowListener;

    public BuahAdapter(Context context, List<buah> BPlist, OnClickShowListener onClickShowListener) {
        this.context = context;
        this.BPlist = BPlist;
        this.monClickShowListener = onClickShowListener;
    }

    @NonNull
    @Override
    public BPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_layout_item_view,parent,false);
        return new BPViewHolder(view,monClickShowListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BPViewHolder holder, int position) {
        String name =BPlist.get(position).getName();
        int logo =BPlist.get(position).getLogo();

        holder.tvBPname.setText(name);
        holder.imgBPlogo.setImageResource(logo);
    }

    @Override
    public int getItemCount() {
        return BPlist.size();
    }

    public class BPViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvBPname;
        ImageView imgBPlogo;
        OnClickShowListener onClickShowListener;
        public BPViewHolder(@NonNull View itemView, OnClickShowListener onClickShowListener) {
            super(itemView);
            tvBPname = itemView.findViewById(R.id.BPname);
            imgBPlogo = itemView.findViewById(R.id.BPlogo);
            this.onClickShowListener = monClickShowListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onClickShowListener.onClickShowListener(getAdapterPosition());
        }
    }
    public interface OnClickShowListener {
        void onClickShowListener(int position);

    }
}
