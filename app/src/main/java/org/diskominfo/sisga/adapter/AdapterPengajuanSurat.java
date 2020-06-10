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
import org.diskominfo.sisga.activity.DetailPengajuanSppdActivity;
import org.diskominfo.sisga.model.Pengajuansurat;

import java.util.List;

public class AdapterPengajuanSurat extends RecyclerView.Adapter<AdapterPengajuanSurat.PengajuanSuratHolder> {

    List<Pengajuansurat> pengajuansurats;
    Context context;
    private String status;

    public AdapterPengajuanSurat(List<Pengajuansurat> pengajuansurats, Context context) {
        this.pengajuansurats = pengajuansurats;
        this.context = context;
    }

    @NonNull
    @Override
    public PengajuanSuratHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_detail_pengajuan_surat, parent, false);
        return new AdapterPengajuanSurat.PengajuanSuratHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PengajuanSuratHolder holder, final int position) {
        final Pengajuansurat pengajuansurat = pengajuansurats.get(position);
        holder.tvKodePengajuanSurat.setText(pengajuansurat.getKode_pengajuan_surat());
        holder.tvTglPengajuan.setText(pengajuansurat.getTgl_pengajuan_surat());
        holder.tvMulaiSurat.setText(": " + pengajuansurat.getTgl_mulai_sppd());
        holder.tvSelesaiSurat.setText(": " + pengajuansurat.getTgl_selesai_sppd());
        holder.tvStatus.setText(pengajuansurat.getstatus_pengajuan_surat());
        holder.tvKeterangan.setText(pengajuansurat.getKet_pengajuan_sppd());
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
                Pengajuansurat pengajuansurat1 = pengajuansurats.get(position);
                Intent moveData = new Intent(context, DetailPengajuanSppdActivity.class);
                moveData.putExtra("data_surat", pengajuansurat1);
                context.startActivity(moveData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pengajuansurats.size();
    }

    public class PengajuanSuratHolder extends RecyclerView.ViewHolder {
        final TextView tvKodePengajuanSurat;
        final TextView tvTglPengajuan;
        final TextView tvMulaiSurat;
        final TextView tvSelesaiSurat;
        final TextView tvStatus;
        final TextView tvKeterangan;
        public PengajuanSuratHolder(@NonNull View itemView) {
            super(itemView);
            tvKodePengajuanSurat = itemView.findViewById(R.id.tv_kode_surat);
            tvTglPengajuan = itemView.findViewById(R.id.tv_tgl_pengajuan_surat);
            tvMulaiSurat = itemView.findViewById(R.id.tv_detail_tgl_mulai_surat);
            tvSelesaiSurat = itemView.findViewById(R.id.tv_detail_tgl_selesai_surat);
            tvStatus = itemView.findViewById(R.id.tv_status_pengajuan_surat);
            tvKeterangan = itemView.findViewById(R.id.tv_keterangan_surat);
        }
    }
}
