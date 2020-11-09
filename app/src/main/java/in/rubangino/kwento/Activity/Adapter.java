package in.rubangino.kwento.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.rubangino.kwento.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private LayoutInflater layoutInflater;
    private String[] sTitles;
    private String[] sContent;
    private String[] sNumber;

    Adapter (Context context, String[] sTitles, String[] sContent, String[] sNumber){
        this.layoutInflater = LayoutInflater.from(context);
        this.sTitles = sTitles;
        this.sContent = sContent;
        this.sNumber = sNumber;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String title = sTitles[position];
        String content = sContent[position];
        String number = sNumber[position];
        holder.storyTitle.setText(title);
        holder.storyContent.setText(content);
        holder.storyNumber.setText(number);

    }

    @Override
    public int getItemCount() {
        return sTitles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView storyTitle, storyContent, storyNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //Implement OnClick Listener for customView
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DetailsOfTheStory.class);
                    //implementing title and content of the story
                    intent.putExtra("titleOfStory", sTitles[getAdapterPosition()]);
                    intent.putExtra("contentOfStory", sContent[getAdapterPosition()]);
                    view.getContext().startActivity(intent);
                }
            });

            storyTitle = itemView.findViewById(R.id.storyTitle);
            storyContent = itemView.findViewById(R.id.storyContent);
            storyNumber = itemView.findViewById(R.id.sNumber);
        }
    }
}
