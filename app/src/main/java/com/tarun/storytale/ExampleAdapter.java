package com.tarun.storytale;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {
    LayoutInflater inflater;
    String[] sTitles;
    String[] sContents;

    ExampleAdapter(Context context,String[] titles,String[] contents)
    {
        this.inflater = LayoutInflater.from(context);
        this.sTitles = titles;
        this.sContents = contents;
    }
    @NonNull
    @Override
    public ExampleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.custom_list,parent,false);
       return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.ViewHolder holder, int position) {
    String title = sTitles[position];
    String content = sContents[position];
    holder.StoryTitle.setText(title);
    holder.StoryContent.setText(content);
    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView StoryTitle;
        TextView StoryContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StoryTitle = itemView.findViewById(R.id.TitleText);
            StoryContent = itemView.findViewById(R.id.ContentText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),StoriesActivity.class);
                    i.putExtra("title",sTitles[getAdapterPosition()]);
                    i.putExtra("contents",sContents[getAdapterPosition()]);
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}
