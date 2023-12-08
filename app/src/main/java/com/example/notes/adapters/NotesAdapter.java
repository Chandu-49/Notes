package com.example.notes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes.R;
import com.example.notes.entities.Note;

import java.util.List;

public class NotesAdapter  extends RecyclerView.Adapter<NotesAdapter.NoteviewHolder>{
    private List<Note>notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         return new NoteviewHolder(
                 LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_note,parent,false)
         );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteviewHolder holder, int position) {
    holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position  ;
    }

    static class NoteviewHolder extends RecyclerView.ViewHolder{
        TextView textTitle,textSubtitle,textDateTime;

        public NoteviewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle=itemView.findViewById(R.id.textTitle);
            textSubtitle=itemView.findViewById(R.id.textSubTitle);
            textDateTime=itemView.findViewById(R.id.textDateTime);

        }
        void setNote(Note note){
            textTitle.setText(note.getTitle());
            if (note.getSubtitle().trim().isEmpty()){
                textSubtitle.setVisibility(View.GONE);
            }
            else{
                textSubtitle.setText(note.getTitle());
            }
            textDateTime.setText(note.getDateTime());

        }
    }
}
