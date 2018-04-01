package com.example.administrator.bestpritice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/4/1 0001.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {

    private List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
         LinearLayout left_linearLayout,right_linearLayout;
         TextView left_textView,right_textView;

        public MyViewHolder(View itemView) {
            super(itemView);
            left_linearLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            right_linearLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            left_textView = (TextView) itemView.findViewById(R.id.left_me);
            right_textView = (TextView) itemView.findViewById(R.id.right_me);

        }


    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mess,parent,false);


        MyViewHolder myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        String recon = message.getContent();
        if(message.getMs_type() == Message.RECEIVE_MESSAGE){
            holder.right_linearLayout.setVisibility(View.GONE);
            holder.left_linearLayout.setVisibility(View.VISIBLE);
            holder.left_textView.setText(recon);

        }else if(message.getMs_type() == Message.SEND_MESSAGE){
            holder.right_linearLayout.setVisibility(View.VISIBLE);
            holder.left_linearLayout.setVisibility(View.GONE);
            holder.right_textView.setText(recon);


        }



    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }



}
