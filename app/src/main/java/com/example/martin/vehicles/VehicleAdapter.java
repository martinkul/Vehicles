package com.example.martin.vehicles;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martin.vehicles.objects.*;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Vehicle> vehicles;
    private AlertDialog adInfo;

    public VehicleAdapter(Context context, ArrayList<Vehicle> vehicles) {
        this.context = context;
        this.vehicles = vehicles;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private AppCompatButton button;

        public ViewHolder(View view) {
            super(view);

            button = (AppCompatButton) view.findViewById(R.id.button);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), R.style.InfoDialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = inflater.inflate(R.layout.dialog_info, null);

            RecyclerView rvAttributes = (RecyclerView) v.findViewById(R.id.rv_attributes);
            ImageView clearDialog = (ImageView) v.findViewById(R.id.clear_dialog);
            TextView lblTitle = (TextView) v.findViewById(R.id.lbl_title);
            TextView lblStatus = (TextView) v.findViewById(R.id.lbl_status);
            AppCompatButton btnStart = (AppCompatButton) v.findViewById(R.id.btn_start);

            String title = "";
            final Vehicle vehicle = vehicles.get(getAdapterPosition());

            if (vehicle instanceof Car) {
                title = "Car";
                btnStart.setText("Drive car");
            } else if (vehicle instanceof Plane) {
                title = "Plane";
                btnStart.setText("Fly plane");
            } else if (vehicle instanceof Boat) {
                title = "Boat";
                btnStart.setText("Drive boat");
            }

            lblTitle.setText(title);

            if (vehicle.getOperational()) {
                lblStatus.setText("operational");
                lblStatus.setTextColor(ContextCompat.getColor(context, R.color.colorOperational));
                btnStart.setVisibility(View.VISIBLE);
            } else {
                lblStatus.setText("not operational");
                lblStatus.setTextColor(ContextCompat.getColor(context, R.color.colorError));
                btnStart.setVisibility(View.GONE);
            }

            AttributeAdapter adapter = new AttributeAdapter(vehicle.getAttributes());
            rvAttributes.setAdapter(adapter);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvAttributes.setLayoutManager(linearLayoutManager);

            clearDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adInfo.dismiss();
                }
            });

            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adInfo.dismiss();
                    MainActivity main = (MainActivity) context;
                    main.driveVehicle(vehicle);
                }
            });

            builder.setView(v);

            adInfo = builder.create();
            adInfo.show();
        }
    }

    @Override
    public VehicleAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_vehicle, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(VehicleAdapter.ViewHolder viewHolder, int i) {
        String title = "";
        Vehicle vehicle = vehicles.get(i);

        if (vehicle instanceof Car) {
            title = "Car";
        } else if (vehicle instanceof Plane) {
            title = "Plane";
        } else if (vehicle instanceof Boat) {
            title = "Boat";
        }

        viewHolder.button.setText(title + ": " + vehicle.getId());
    }

    @Override
    public int getItemCount() {
        return vehicles.size();
    }

}
