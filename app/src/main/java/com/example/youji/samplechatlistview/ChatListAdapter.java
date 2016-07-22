package com.example.youji.samplechatlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YouJi on 2016-07-22.
 */
public class ChatListAdapter extends BaseAdapter {

    List<String> items = new ArrayList<String>();

    public void add(String message) {
        items.add(message);

        // ȭ���� �����ϵ��� �ϴ� �Լ�  (�������� Invalidate() ������!
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {   // �Ⱦ�
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        // position : ����Ʈ�󿡼� �� ��° ������?
        // convertView : ���� ������ ���� �������� ��
        // parent : ���ؽ�Ʈ�� �������� ���� ��ü (parent.getContext())

        ChatItemView view;

        if (convertview == null) { // convertView == null : ���� ó�� �� ��(���� �ô� �䰡 �ƴ�)
            view = new ChatItemView(parent.getContext());
        } else {    // convertView != null : ���� �ô� �䰡 ����
            view = (ChatItemView) convertview;
        }

        // �信 �����͸� ����
        view.setMessage(items.get(position));

        // ������ ���� ���������� �並 ȭ�鿡 ���
        return view;
    }
}
