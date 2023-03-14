package com.example.contactdatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private final ArrayList<Person> people;

    public PersonAdapter(ArrayList<Person> people) {
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);

        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.tvName.setText(people.get(position).getName());
        holder.tvEmail.setText(people.get(position).getEmail());
        holder.tvDob.setText(people.get(position).getDob());
        holder.tvPhone.setText(people.get(position).getPhone());
        holder.imageView1.setImageResource(R.drawable.usersolid);

        holder.tvName.setFocusable(false);
        holder.tvEmail.setFocusable(false);
        holder.tvDob.setFocusable(false);
        holder.tvPhone.setFocusable(false);

    }

    @Override
    public int getItemCount() {
        return people.size();
    }


    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName, tvEmail, tvDob, tvPhone;
        public ImageView imageView1;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvDob = itemView.findViewById(R.id.tvDob);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            imageView1 = itemView.findViewById(R.id.imageView);
        }
    }
}