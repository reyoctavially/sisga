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
import org.diskominfo.sisga.activity.DetailPengajuanCutiActivity;
import org.diskominfo.sisga.model.Pengajuancuti;

import java.util.List;

public class AdapterPengajuanCuti extends RecyclerView.Adapter<AdapterPengajuanCuti.PengajuanCutiHoler> {

    List<Pengajuancuti> pengajuancutis;
    Context context;
    private String status;

    public AdapterPengajuanCuti(List<Pengajuancuti> pengajuancutis, Context context) {
        this.pengajuancutis = pengajuancutis;
        this.context = context;
    }

    @NonNull
    @Override
    public PengajuanCutiHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_detail_pengajuan_cuti, parent, false);
        return new AdapterPengajuanCuti.PengajuanCutiHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PengajuanCutiHoler holder, final int position) {
        final Pengajuancuti pengajuancuti = pengajuancutis.get(position);
        holder.tvKodePengajuanCuti.setText(pengajuancuti.getKode_pengajuan_cuti());
        holder.tvTglPengajuan.setText(pengajuancuti.getTgl_pengajuan_cuti());
        holder.tvMulaiCuti.setText(": " + pengajuancuti.getTgl_mulai_cuti());
        holder.tvSelesaiCUti.setText(": " + pengajuancuti.getTgl_selesai_cuti());
        holder.tvStatus.setText(pengajuancuti.getStatus_pengajuan_cuti());
        holder.tvKeterangan.setText(pengajuancuti.getKet_pengajuan_cuti());
        status = holder.tvStatus.getText().toString();
        if (status.equals("Menunggu")){
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_coral);
        } else if (status.equals("Disetujui")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (status.equals("Ditolak")){
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_red);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pengajuancuti pengajuancuti1 = pengajuancutis.get(position);
                Intent moveData = new Intent(context, DetailPengajuanCutiActivity.class);
                moveData.putExtra("data_cuti", pengajuancuti1);
                context.startActivity(moveData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pengajuancutis.size();
    }

    public class PengajuanCutiHoler extends RecyclerView.ViewHolder {
        final TextView tvKodePengajuanCuti;
        final TextView tvTglPengajuan;
        final TextView tvMulaiCuti;
        final TextView tvSelesaiCUti;
        final TextView tvStatus;
        final TextView tvKeterangan;

        public PengajuanCutiHoler(@NonNull View itemView) {
            super(itemView);
            tvKodePengajuanCuti = itemView.findViewById(R.id.tv_kode_cuti);
            tvTglPengajuan = itemView.findViewById(R.id.tv_tgl_pengajuan_cuti);
            tvMulaiCuti = itemView.findViewById(R.id.tv_detail_tgl_mulai);
            tvSelesaiCUti = itemView.findViewById(R.id.tv_detail_tgl_selesai);
            tvStatus = itemView.findViewById(R.id.tv_status_pengajuan_cuti);
            tvKeterangan = itemView.findViewById(R.id.tv_keterangan_cuti);
        }
    }
}
