package com.bedenko.genaro.expresstable.models;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bedenko.genaro.expresstable.R;

import java.util.ArrayList;

/**
 * Created by Genaro Bedenko for 300CEM Android Application Development Assignment
 * File first created on 06/11/2018
 *
 * @author bedenkog
 */
public class CandidateAdaptor extends ArrayAdapter<Candidate> {

    private int resource;
    private ArrayList<Candidate> candidates;
    private Context context;

    public CandidateAdaptor(Context context, int resource, ArrayList<Candidate> candidates) {
        super(context, resource, candidates);
        this.resource = resource;
        this.candidates = candidates;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        try {
            if (v == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = layoutInflater.inflate(resource, parent, false);
            }

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
            TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
            TextView textViewDetail = (TextView) v.findViewById(R.id.textViewDetail);

            imageView.setImageResource(candidates.get(position).getPhoto());
            textViewName.setText(candidates.get(position).getName());
            textViewDetail.setText(candidates.get(position).getDetail());

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return v;
    }
}
