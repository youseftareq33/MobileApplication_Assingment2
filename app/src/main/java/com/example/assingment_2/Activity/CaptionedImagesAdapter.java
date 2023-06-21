package com.example.assingment_2.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assingment_2.MainActivity3_test;
import com.example.assingment_2.R;
import com.example.assingment_2.classes.Subject;
import com.example.assingment_2.classes.Test;

public class CaptionedImagesAdapter
        extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{

    private String[] captions;
    private int[] imageIds;

    public CaptionedImagesAdapter(String[] captions, int[] imageIds){
        this.captions = captions;
        this.imageIds = imageIds;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,
                parent,
                false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
        Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);
        imageView.setImageDrawable(dr);
        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);
        int pos=position;
        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String subjectName = Subject.subjects[pos].getSubjectName();
                TextView textBackground1 = cardView.getRootView().findViewById(R.id.textBackground1);
                TextView textBackground2 = cardView.getRootView().findViewById(R.id.textBackground2);
                String testText = "";

                Test test_Math = new Test("math test", "1 + 2  = 3 (true)\n2 + 4 = 5 (false)\n5 + 6 = 11 (true)");
                Test test_Science = new Test("science test", "The Sun is a source of light (true)\nPlants need sunlight to grow (true)\n Animals can talk like humans (false)");
                Test test_English = new Test("english test", "The alphabet has 26 letters (true)\nAdjectives are words that describe nouns (true)\n\n" +
                        "A sentence does not always begin with a capital letter (false)");

                if (subjectName.equals("Math")) {
                    testText = "";
                    testText = test_Math.getTestName() + "\n---------------------------------\n" + test_Math.getQuestion();
                } else if (subjectName.equals("Science")) {
                    testText = "";
                    testText = test_Science.getTestName() + "\n---------------------------------\n" + test_Science.getQuestion();
                } else if (subjectName.equals("English")) {
                    testText = "";
                    testText = test_English.getTestName() + "\n---------------------------------\n" + test_English.getQuestion();
                }

                Intent intent = new Intent(cardView.getContext(), MainActivity3_test.class);
                intent.putExtra("name", subjectName);
                intent.putExtra("testText", testText);

                cardView.getContext().startActivity(intent);

            }


        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;
        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}
