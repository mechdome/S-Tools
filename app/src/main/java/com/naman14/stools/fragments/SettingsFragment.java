package com.naman14.stools.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mechdome.aboutmechdome.AboutMechDomeActivity;
import com.naman14.stools.R;
import com.naman14.stools.util.HelpUtils;

import org.w3c.dom.Text;

/**
 * Created by naman on 30/01/15.
 */
public class SettingsFragment extends Fragment {



    String Urlgithub="https://github.com/mechdome/S-Tools";

    ImageView github,share;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_settings, container,
                false);
        github=(ImageView) v.findViewById(R.id.github);
        share=(ImageView) v.findViewById(R.id.share);

        ImageView photo1 = (ImageView)v.findViewById(R.id.photo1);
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpUtils.showThemes(getActivity());
            }


        });
        TextView text1 = (TextView)v.findViewById(R.id.text1);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpUtils.showThemes(getActivity());
            }


        });
        ImageView photo2 = (ImageView)v.findViewById(R.id.photo2);
        photo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpUtils.showAbout(getActivity());
            }


        });
        TextView text2 = (TextView)v.findViewById(R.id.text2);
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpUtils.showAbout(getActivity());
            }

        });

        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(Urlgithub));
                startActivity(i);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "S Tools+");
                String sAux = getActivity().getString(R.string.recommend_content);
                i.putExtra(Intent.EXTRA_TEXT, sAux);
                startActivity(Intent.createChooser(i, getActivity().getString(R.string.recommend_choose)));
            }
        });

        TextView mechdome = (TextView) v.findViewById(R.id.aboutmechdome);
        mechdome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), AboutMechDomeActivity.class);
                startActivity(i);
            }
        });

        return v;
    }


}
