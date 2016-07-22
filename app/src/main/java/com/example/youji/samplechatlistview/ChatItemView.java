package com.example.youji.samplechatlistview;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by YouJi on 2016-07-22.
 */
public class ChatItemView extends LinearLayout {

    TextView messageView;
    public ChatItemView(Context context) {
        super(context);
    }

    private void init() {       // 초기화 함수.
        inflate(getContext(), R.layout.chat_view, this);

        // View initialize
        messageView = (TextView) findViewById(R.id.messageView);

    }

    public void setMessage(String message) {
        messageView.setText(message);
    }

}
