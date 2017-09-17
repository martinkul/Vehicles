package com.example.martin.vehicles;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.martin.vehicles.objects.Attribute;

import java.util.ArrayList;

public class AttributeAdapter extends RecyclerView.Adapter<AttributeAdapter.ViewHolder> {

    private ArrayList<Attribute> attributes;

    public AttributeAdapter(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView attribute, value;

        public ViewHolder(View view) {
            super(view);

            attribute = (TextView) view.findViewById(R.id.attribute);
            value = (TextView) view.findViewById(R.id.value);
        }
    }

    @Override
    public AttributeAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_attribute, viewGroup, false);
        AttributeAdapter.ViewHolder viewHolder = new AttributeAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AttributeAdapter.ViewHolder viewHolder, int i) {
        viewHolder.attribute.setText(attributes.get(i).getAttribute() + ":");
        viewHolder.value.setText(attributes.get(i).getValue());
    }

    @Override
    public int getItemCount() {
        return attributes.size();
    }
}

