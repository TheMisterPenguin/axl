package fr.axl.axl.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import fr.axl.axl.MainActivity;
import fr.axl.axl.R;

public class RecipeCardView extends ConstraintLayout {

    private TextView recipeTitle;

    private ImageView recipeImage;

    private ProgressBar loader;

    private GridLayout cardInfo;

    public static int dpToPx(int dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    // Constructeurs
    public RecipeCardView(Context context) {
        super(context);
        init(context, null, 0);
        Log.i(RecipeCardView.class.toString(), "contruct: ");
    }

    public RecipeCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
        Log.i(RecipeCardView.class.toString(), "contruct: ");

    }

    public RecipeCardView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
        Log.i(RecipeCardView.class.toString(), "contruct: ");

    }

    // Initialisation
    private void init(Context context, AttributeSet attrs, int defStyle) {
        // Charger le layout XML

        Log.i(RecipeCardView.class.toString(), "init: ");
        LayoutInflater.from(context).inflate(R.layout.recipe_card_view, this, true);
        // Ici, vous pouvez initialiser vos vues (setText, setImage, etc.)

        recipeTitle = findViewById(R.id.recipe_title);
        recipeImage = findViewById(R.id.recipe_image);
        loader = findViewById(R.id.loader);
        cardInfo = findViewById(R.id.card_info);
        findViewById(R.id.card_background).setClipToOutline(true);

        //this.setBackground(R.drawable.axl_card_background);
        this.setMaxWidth(dpToPx(550, context));
        new Thread(){
            public void run() {
                InputStream is = null;
                try {
                    is = context.getResources().openRawResource(R.raw.img);
                }
                catch (Exception e){
                    Log.e(RecipeCardView.class.toString(), "error :", e);
                }

                // Create a Drawable from the InputStream
                Drawable d = Drawable.createFromStream(is, null);

                MainActivity.mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        recipeImage.setImageDrawable(d);

                        cardInfo.getBackground().setAlpha(130);

                        recipeTitle.setText("Spaghettis\n" +
                                "bolognaise");

                        loader.setVisibility(View.GONE);
                        ((View) cardInfo.getParent()).setVisibility(View.VISIBLE);
                        recipeImage.setVisibility(View.VISIBLE);
                    }
                });
            }
        }.start();








    }
}

