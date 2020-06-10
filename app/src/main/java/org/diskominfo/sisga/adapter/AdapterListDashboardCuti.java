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
import org.diskominfo.sisga.model.PengajuanCutiModel;

import java.util.List;

public class AdapterListDashboardCuti extends RecyclerView.Adapter<AdapterListDashboardCuti.CutiHolder> {

    private List<PengajuanCutiModel> daftar;
    private OnClickListener listener;

    public AdapterListDashboardCuti(List<PengajuanCutiModel> daftar) {
        this.daftar = daftar;
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CutiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_view_dashboard_cuti, parent, false);
        CutiHolder ch = new CutiHolder(view);
        return ch;
    }

    @Override
    public void onBindViewHolder(@NonNull CutiHolder holder, int position) {
        PengajuanCutiModel pengajuanCutiModel = daftar.get(position);
        holder.judul.setText(pengajuanCutiModel.getJudul());
        holder.desc.setText(pengajuanCutiModel.getDesc());
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

    public class CutiHolder extends RecyclerView.ViewHolder {
        final TextView judul;
        final TextView desc;
        final ImageView images;
        public CutiHolder(@NonNull View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.tv_judul);
            desc = itemView.findViewById(R.id.tv_desc);
            images = itemView.findViewById(R.id.iv_detailcuti);
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
