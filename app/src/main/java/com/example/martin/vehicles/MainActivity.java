package com.example.martin.vehicles;

import android.graphics.Point;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.martin.vehicles.objects.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private RecyclerView rvVehicles;
    private AppCompatButton btnCompare;
    private ImageView imgVehicle;

    private Car c1, c2;
    private Plane p1;
    private Boat b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c1 = new Car("NF123456", 147, true, 200, "green", "personal vehicle");
        //c2 = new Car("NF123456", 147, true, 200, "green", "personal vehicle");
        c2 = new Car("NF654321", 150, false, 195, "blue", "personal vehicle");
        p1 = new Plane("LN1234", 1000, true, 30, 2, 10, "jet plane");
        b1 = new Boat("ABC123", 100, false, 30, 500);

        vehicles.add(c1);
        vehicles.add(c2);
        vehicles.add(p1);
        vehicles.add(b1);

        rvVehicles = (RecyclerView) findViewById(R.id.rv_vehicles);
        btnCompare = (AppCompatButton) findViewById(R.id.btn_compare);
        imgVehicle = (ImageView) findViewById(R.id.img_vehicle);

        VehicleAdapter adapter = new VehicleAdapter(this, vehicles);
        rvVehicles.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVehicles.setLayoutManager(linearLayoutManager);

        btnCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message;

                if (c1.equals(c2)) {
                    message = "The cars are identical";
                } else {
                    message = "The cars do not match";
                }

                Snackbar.make(findViewById(R.id.linearlayout), message, Snackbar.LENGTH_LONG).show();
            }
        });

        for (Vehicle vehicle : vehicles) {
            Log.d("Vehicles", vehicle.toString());
        }
    }

    public void driveVehicle(Vehicle vehicle) {
        if (vehicle.getOperational()) {
            int height = 0;

            if (vehicle instanceof Car) {
                imgVehicle.setImageResource(R.drawable.car);
            } else if (vehicle instanceof Plane) {
                imgVehicle.setImageResource(R.drawable.plane);
                height = -100;
            }

            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);

            final int amountToMoveRight = size.x + 100;

            TranslateAnimation anim = new TranslateAnimation(0, amountToMoveRight, height, height);
            anim.setDuration(3000);

            anim.setAnimationListener(new TranslateAnimation.AnimationListener() {

                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationRepeat(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imgVehicle.getLayoutParams();
                    params.leftMargin = 0;
                    imgVehicle.setLayoutParams(params);

                    imgVehicle.setImageResource(0);

                    Snackbar.make(findViewById(android.R.id.content), "The vehicle has reached its destination", Snackbar.LENGTH_SHORT).show();
                }
            });

            imgVehicle.startAnimation(anim);
        }
    }

}
