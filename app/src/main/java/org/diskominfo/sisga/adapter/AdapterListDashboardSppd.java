package org.diskominfo.sisga.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.interfaces.OnClickListener;
import org.diskominfo.sisga.model.PengajuanSppdModel;

import java.util.ArrayList;

public class AdapterListDashboardSppd extends RecyclerView.Adapter<AdapterListDashboardSppd.SppdHolder> {

    private ArrayList<PengajuanSppdModel> daftar;
    private OnClickListener listener;

    public AdapterListDashboardSppd(ArrayList<PengajuanSppdModel> daftar) {
        this.daftar = daftar;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public SppdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_dashboard_sppd, parent, false);
        SppdHolder sh = new SppdHolder(view);
        return sh;
    }

    @Override
    public void onBindViewHolder(@NonNull SppdHolder holder, int position) {
        PengajuanSppdModel pengajuanSppdModel = daftar.get(position);
        holder.judul.setText(pengajuanSppdModel.getJudul());
        holder.desc.setText(pengajuanSppdModel.getDesc());
        switch (position){
            case 0:
                holder.images.setBackgroundResource(R.drawable.img_hand);
                break;
            case 1:
                holder.images.setBackgroundResource(R.drawable.img_calendar);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }

    public class SppdHolder extends RecyclerView.ViewHolder {
        final TextView judul;
        final TextView desc;
        final ImageView images;
        public SppdHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tv_judul);
            desc = itemView.findViewById(R.id.tv_desc);
            images = itemView.findViewById(R.id.iv_detailsppd);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onclick(position);
                        }
                    }
                }
            });
        }
    }
}
