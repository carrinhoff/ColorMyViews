package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText mInput;
    Button mButton;
    RecyclerView mRv;
    MyRecyclerViewAdapter adapter;
    List<Word> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInput = findViewById(R.id.edt_input);
        mButton = findViewById(R.id.btn_send);
        mRv = findViewById(R.id.rv_list);
        onButtonClick();
        mRv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, mList);
        mRv.setAdapter(adapter);


    }


    public void onButtonClick(){
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mInput.getText().toString().isEmpty()){
                  mList = split(mInput.getText().toString());
                    adapter.setmData(mList);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public List<Word> split(String toSplit){
        Map<String,Word> newList = new HashMap<>();
        String [] words = toSplit.split(" ");
        for (int i = 0; i< words.length; i++){
            if (i == 0){
                Word word = new Word(words[i],1);
                newList.put(words[i],word);
            }
            else{
               boolean key = newList.containsKey(words[i]);
                if (key){
                    newList.get(words[i]).setCount(newList.get(words[i]).getCount() + 1);
                }
                else{
                    Word word = new Word(words[i],1);
                    newList.put(words[i],word);

                }
            }
        }
        List<Word> sortedList = new ArrayList<>(newList.values());
        Collections.sort(sortedList, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.getCount() > o2.getCount()){
                    return  1;
                }
                else{
                    return -1;
                }
            }
        });

        return sortedList;


    }
}