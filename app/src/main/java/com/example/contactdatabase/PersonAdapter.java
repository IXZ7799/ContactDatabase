package com.example.contactdatabase;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    private final ArrayList<Person> people;

    public PersonAdapter(ArrayList<Person> people) {
        this.people = people;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        ImageView imageView = v.findViewById(R.id.imageView1);
        Log.d("PersonAdapter", "onCreateViewHolder called");
        return new PersonViewHolder(v, imageView);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Log.d("PersonAdapter", "onBindViewHolder called for position: " + position);
        Person person = people.get(position);
        holder.tvName.setText(people.get(position).getName());
        holder.tvEmail.setText(people.get(position).getEmail());
        holder.tvDob.setText(people.get(position).getDob());
        holder.tvPhone.setText(people.get(position).getPhone());
        Picasso.get().load(person.getAvatar()).into(holder.imageView1);

        holder.tvName.setFocusable(false);
        holder.tvEmail.setFocusable(false);
        holder.tvDob.setFocusable(false);
        holder.tvPhone.setFocusable(false);

    }

    @Override
    public int getItemCount() {
        Log.d("PersonAdapter", "getItemCount called, returning: " + people.size());
        return people.size();
    }
}
