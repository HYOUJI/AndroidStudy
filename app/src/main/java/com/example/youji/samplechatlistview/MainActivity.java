package com.example.youji.samplechatlistview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ListView listView;
    EditText inputView;
    Button sendBtn;

    ChatListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View Initialize
        listView = (ListView) findViewById(R.id.listView);
        inputView = (EditText) findViewById(R.id.inputView);
        sendBtn = (Button) findViewById(R.id.sendBtn);

        mAdapter = new ChatListAdapter();
        listView.setAdapter(mAdapter);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputView.getText().toString();
                mAdapter.add(input);
                inputView.setText("");

                listView.smoothScrollToPosition(mAdapter.getCount());
            }
        });

        // 리스트뷰 아이템을 클릭했을 때 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedMessage = (String)mAdapter.getItem(position);
                Toast.makeText(MainActivity.this, clickedMessage, Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
//                intent.putExtra("채팅방이름", clickedMessage);
//                startActivity(intent);
            }
        });

    }
}
