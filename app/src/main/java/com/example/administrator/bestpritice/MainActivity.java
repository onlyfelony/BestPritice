package com.example.administrator.bestpritice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Message> mymeslist = new ArrayList<>();
    private RecyclerView recyclerView;
    private  Button send_button;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMessage();

        send_button = (Button) findViewById(R.id.send);
        editText = (EditText) findViewById(R.id.editmessage);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        final MessageAdapter adapter = new MessageAdapter(mymeslist);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

      send_button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String content = editText.getText().toString();
              if (!content.equals("")){
                  Message smessage = new Message(Message.SEND_MESSAGE,content);
                  mymeslist.add(smessage);

                  adapter.notifyItemInserted(mymeslist.size()-1);//当有新消息时，刷新recycleView中的显示
                  recyclerView.scrollToPosition(mymeslist.size()-1);//将recycleView定位到最后一行
                  editText.setText("");//清空edittext
              }


          }
      });

    }


   void initMessage(){
       Message message1 = new Message(Message.RECEIVE_MESSAGE,"Hello");
       mymeslist.add(message1);

       Message message0 = new Message(Message.SEND_MESSAGE,"Hello，test");
       mymeslist.add(message0);

       Message message2 = new Message(Message.RECEIVE_MESSAGE,"ok");
       mymeslist.add(message2);

    }


}
