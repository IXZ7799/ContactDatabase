package com.example.contactdatabase;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName, tvEmail, tvDob, tvPhone;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);

        tvName = itemView.findViewById(R.id.tvName);
        tvEmail = itemView.findViewById(R.id.tvEmail);
        tvDob = itemView.findViewById(R.id.tvDob);
        tvPhone = itemView.findViewById(R.id.tvPhone);
    }
}

