package com.bianl.listviewwithedittext;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fhbianling on 2016/9/13.
 *
 * @mail:fhbianling@163.com
 */
public class Adapter extends BaseAdapter {
    List<String> data;
    LayoutInflater inflater;
    List<Entities> entities;

    public Adapter(List<String> data, Context context) {
        this.data = data;
        inflater = LayoutInflater.from(context);
        entities = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Entities entities = new Entities(data.get(i), null, null);
            this.entities.add(entities);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Entities getItem(int i) {
        return entities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item, viewGroup, false);
            holder.tv = (TextView) view.findViewById(R.id.tv);
            holder.et1 = (EditText) view.findViewById(R.id.et1);
            holder.et2 = (EditText) view.findViewById(R.id.et2);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String s = data.get(position);
        holder.tv.setText(s);
        final Entities entities = this.entities.get(position);

        Log.d("TAG", "getView|entities:" + entities.toString());
        String et1 = entities.et1;
        String et2 = entities.et2;

        holder.et1.setText(TextUtils.isEmpty(et1) ? "" : et1);
        holder.et2.setText(TextUtils.isEmpty(et2) ? "" : et2);

        holder.et1.setTag(entities);
        holder.et2.setTag(entities);
        View.OnFocusChangeListener listener = new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (!b) {
                    if (view == holder.et2) {
                        Entities entities = (Entities) holder.et2.getTag();
                        entities.setEt2(holder.et2.getText().toString());
                    } else if (view == holder.et1) {
                        Entities entities = (Entities) holder.et1.getTag();
                        entities.setEt1(holder.et1.getText().toString());
                    }
                    Log.d("TAG", "et1|position:" + position + "|entities:" + Adapter.this.entities.get(position).toString());
                } else {
                    if (view == holder.et2) {
                        Entities entities1 = (Entities) holder.et2.getTag();
                        String et21 = entities1.et2;
                        holder.et2.setText(TextUtils.isEmpty(et21) ? "" : et21);
                    } else if (view == holder.et1) {
                        Entities entities1 = (Entities) holder.et1.getTag();
                        String et11 = entities1.et1;
                        holder.et1.setText(TextUtils.isEmpty(et11) ? "" : et11);
                    }
                }
            }
        };
        holder.et1.setOnFocusChangeListener(listener);
        holder.et2.setOnFocusChangeListener(listener);
        return view;
    }

    private void doFunction(EditText editText) {
        Entities entities = (Entities) editText.getTag();
        entities.setEt1(editText.getText().toString());
    }

    private class ViewHolder {
        TextView tv;
        EditText et1;
        EditText et2;
    }

    public String getJson() {
        return new Gson().toJson(entities);
    }
}
