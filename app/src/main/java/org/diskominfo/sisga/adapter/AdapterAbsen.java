package org.diskominfo.sisga.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.diskominfo.sisga.R;
import org.diskominfo.sisga.model.Absensi;
import org.diskominfo.sisga.model.Pengajuancuti;

import java.util.List;

public class AdapterAbsen extends RecyclerView.Adapter<AdapterAbsen.AbsenHolder> {

    List<Absensi> absensis;
    Context context;

    public AdapterAbsen(List<Absensi> absensis, Context context) {
        this.absensis = absensis;
        this.context = context;
    }

    @NonNull
    @Override
    public AbsenHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_absen, parent, false);
        return new AdapterAbsen.AbsenHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenHolder holder, final int position) {
        final Absensi absensi = absensis.get(position);
        holder.tvKodeAbsen.setText(absensi.getKode_absensi());
        holder.tvTglAbsen.setText(absensi.getTanggal_absen());
        holder.tvJamMasuk.setText(": " + absensi.getJam_masuk());
        holder.tvJamKeluar.setText(": " + absensi.getJam_keluar());
    }

    @Override
    public int getItemCount() {
        return absensis.size();
    }

    public class AbsenHolder extends RecyclerView.ViewHolder {
        final TextView tvKodeAbsen;
        final TextView tvTglAbsen;
        final TextView tvJamMasuk;
        final TextView tvJamKeluar;
        public AbsenHolder(@NonNull View itemView) {
            super(itemView);
            tvKodeAbsen = itemView.findViewById(R.id.tv_kode_absen);
            tvTglAbsen = itemView.findViewById(R.id.tv_tgl_absen);
            tvJamMasuk = itemView.findViewById(R.id.tv_detail_jam_masuk);
            tvJamKeluar = itemView.findViewById(R.id.tv_detail_jam_keluar);
        }
    }
}
