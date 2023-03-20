package com.example.ptselektronik;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ElectronicAdapter extends RecyclerView.Adapter<ElectronicAdapter.ViewHolder> {

    private ArrayList<Electronic> localDataSet;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvElectronicName;
        private final TextView tvElectronicHarga;
        private final ImageView imgElectronicPoster;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvElectronicName = view.findViewById(R.id.things_name);
            tvElectronicHarga = view.findViewById(R.id.things_price);
            imgElectronicPoster = view.findViewById(R.id.things_poster);
        }
    }
    public ElectronicAdapter(ArrayList<Electronic> dataSet) {
        localDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_items, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String name = localDataSet.get(position).getName();
        String harga = localDataSet.get(position).getHarga();
        int poster = localDataSet.get(position).getPoster();
        String desc = localDataSet.get(position).getDesc();

        viewHolder.tvElectronicName.setText(name);
        viewHolder.tvElectronicHarga.setText(harga);
        viewHolder.imgElectronicPoster.setImageResource(poster);



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("things_name", name);
                intent.putExtra("things_price",  harga);
                intent.putExtra("things_poster",  poster);
                intent.putExtra("things_description", desc);
                viewHolder.itemView.getContext().startActivity(intent);

            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}


