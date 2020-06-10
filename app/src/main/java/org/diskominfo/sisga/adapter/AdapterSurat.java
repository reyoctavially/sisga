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
import org.diskominfo.sisga.activity.DetailSuratActivity;
import org.diskominfo.sisga.model.Cuti;
import org.diskominfo.sisga.model.Surat;

import java.util.List;

public class AdapterSurat extends RecyclerView.Adapter<AdapterSurat.SuratHolder> {

    List<Surat> surats;
    Context context;
    private String status;

    public AdapterSurat(List<Surat> surats, Context context) {
        this.surats = surats;
        this.context = context;
    }

    @NonNull
    @Override
    public SuratHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_detail_surat, parent, false);
        return new AdapterSurat.SuratHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuratHolder holder, final int position) {
        final Surat surat = surats.get(position);
        holder.tvNomorSurat.setText(surat.getNo_surat());
        holder.tvJenisSurat.setText(surat.getJenis_surat());
        holder.tvMulaiSurat.setText(": " + surat.getTglmulaisppd());
        holder.tvSelesaiSurat.setText(": " + surat.getTglselesaisppd());
        holder.tvStatus.setText(surat.getStatussurat());
        holder.tvUangSaku.setText("Uang saku sebesar Rp. " + surat.getUang_saku());
        status = holder.tvStatus.getText().toString();
        if (status.equals("Berlaku")){
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_green);
        } else if (status.equals("Selesai")) {
            holder.tvStatus.setBackgroundResource(R.drawable.bg_radius_red);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Surat surat1 = surats.get(position);
                Intent moveData = new Intent(context, DetailSuratActivity.class);
                moveData.putExtra("data_surat", surat1);
                context.startActivity(moveData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return surats.size();
    }

    public class SuratHolder extends RecyclerView.ViewHolder {
        final TextView tvNomorSurat;
        final TextView tvJenisSurat;
        final TextView tvMulaiSurat;
        final TextView tvSelesaiSurat;
        final TextView tvStatus;
        final TextView tvUangSaku;
        public SuratHolder(@NonNull View itemView) {
            super(itemView);
            tvNomorSurat = itemView.findViewById(R.id.tvnomorsurat);
            tvJenisSurat = itemView.findViewById(R.id.tvjenissurat);
            tvMulaiSurat = itemView.findViewById(R.id.tvdetailtglmulaisurat);
            tvSelesaiSurat = itemView.findViewById(R.id.tvdetailtglselesaisurat);
            tvStatus= itemView.findViewById(R.id.tvstatussurat);
            tvUangSaku = itemView.findViewById(R.id.tvuangsaku);
        }
    }
}
