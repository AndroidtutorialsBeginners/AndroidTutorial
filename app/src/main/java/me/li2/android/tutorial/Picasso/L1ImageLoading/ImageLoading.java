package me.li2.android.tutorial.Picasso.L1ImageLoading;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.li2.android.tutorial.BasicUI.SimpleListActivity;
import me.li2.android.tutorial.BasicUI.SimpleListFragment;
import me.li2.android.tutorial.Picasso.PicassoTutorial;

/**
 * Created by weiyi on 09/04/2017.
 * https://github.com/li2
 */

public class ImageLoading extends SimpleListActivity {

    private ArrayList<String> mLoadingOptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoadingOptions = options();
        /**
         * It's weird if not postDelay, the {@link SimpleListFragment#getActivity()} always return null.
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setListData(mLoadingOptions);
            }
        }, 250);
    }

    @Override
    protected String getTitlePrefix() {
        return PicassoTutorial.TAG;
    }

    private ArrayList<String> options() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Url");
        options.add("Resources");
        options.add("File");
        options.add("Uri");
        return options;
    }

    @Override
    protected void onSimpleListItemClick(int position) {
        Toast.makeText(ImageLoading.this, "Loading Image from " + mLoadingOptions.get(position), Toast.LENGTH_SHORT).show();
        switch (position) {
            case 0:
                loadImageFromURL(URL);
                break;
        }
    }

    private static final String URL = "http://i.imgur.com/9gbQ7YR.jpg";

    private void loadImageFromURL(String url) {
        Picasso.with(this)
                .load(url)
                .into(showImageView());
    }

    /**
     * Popup ImageView, give its constructor a non-dialog theme can show ImageView in full screen. and
     * android.R.style.ThemeOverlay_Material_Dark will not change the statusBar's color.
     * http://stackoverflow.com/a/24946375/2722270
     * http://stackoverflow.com/a/10173576/2722270
     */
    private ImageView showImageView() {
        Dialog builder = new Dialog(this, android.R.style.Theme_Material_Light_DarkActionBar);
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
        builder.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.BLACK));
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                //nothing;
            }
        });

        ImageView imageView = new ImageView(this);
        builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        builder.show();
        return imageView;
    }
}
