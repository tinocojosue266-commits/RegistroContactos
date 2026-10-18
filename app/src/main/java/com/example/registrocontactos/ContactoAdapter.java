
package com.example.registrocontactos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private final ArrayList<String> contactos;

    public ContactoAdapter(ArrayList<String> contactos) {
        this.contactos = contactos;
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView tvContacto;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContacto = (TextView) itemView;
        }
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_contacto, parent, false);
        return new ContactoViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.tvContacto.setText(contactos.get(position));
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }
}
