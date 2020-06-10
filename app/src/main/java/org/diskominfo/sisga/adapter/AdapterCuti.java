package org.diskominfo.sisga.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.activity.DetailCutiActivity;
import org.diskominfo.sisga.activity.DetailPengajuanCutiActivity;
import org.diskominfo.sisga.model.Cuti;
import org.diskominfo.sisga.model.Pengajuancuti;

import java.util.List;

public class AdapterCuti extends RecyclerView.Adapter<AdapterCuti.CutiHolder> {

    List<Cuti> cutis;
    Context context;
    private String status;

    public AdapterCuti(List<Cuti> cutis, Context context) {
        this.cutis = cutis;
        this.context = context;
    }

    @NonNull
    @Override
    public CutiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_detail_cuti, parent, false);
        return new AdapterCuti.CutiHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CutiHolder holder, final int position) {
        final Cuti cuti = cutis.get(position);
        holder.tvKodeCuti.setText(cuti.getKode_cuti());
        holder.tvJenisCuti.setText(cuti.getJenis_cuti());
        holder.tvMulaiCuti.setText(": " + cuti.getTglmulaicuti());
        holder.tvSelesaiCuti.setText(": " + cuti.getTglselesaicuti());
        holder.tvStatus.setText(cuti.getStatuscuti());
        holder.tvHonor.setText("Pemotongan honor sebesar Rp. " + cuti.getPemotongan_honor());
        status = holder.tvStatus.getText().toString();
        if (status.equals("Berlaku")){
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (status.equals("Selesai")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_red);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cuti cuti1 = cutis.get(position);
                Intent moveData = new Intent(context, DetailCutiActivity.class);
                moveData.putExtra("data_cuti", cuti1);
                context.startActivity(moveData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cutis.size();
    }

    public class CutiHolder extends RecyclerView.ViewHolder {
        final TextView tvKodeCuti;
        final TextView tvJenisCuti;
        final TextView tvMulaiCuti;
        final TextView tvSelesaiCuti;
        final TextView tvStatus;
        final TextView tvHonor;
        public CutiHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeCuti = itemView.findViewById(R.id.tvkodecuti);
            tvJenisCuti = itemView.findViewById(R.id.tvjeniscuti);
            tvMulaiCuti = itemView.findViewById(R.id.tvdetailtglmulai);
            tvSelesaiCuti = itemView.findViewById(R.id.tvdetailtglselesai);
            tvStatus = itemView.findViewById(R.id.tvstatuscuti);
            tvHonor = itemView.findViewById(R.id.tvpemotonganhonor);
        }
    }
}
