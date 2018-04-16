package door.opposite.grupo2.dungeonscrolls.adapter;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import door.opposite.grupo2.dungeonscrolls.R;

public class imagemAdapter {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (!url.equals("")) {
        }
    }
}
