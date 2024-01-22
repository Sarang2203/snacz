package com.shark.snacz;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.shark.snacz.ProfileActivity;

public class NavbarHandler {

    private Context context;

    public NavbarHandler(Context context) {
        this.context = context;
    }

    public void setNavbarClickListeners(View rootView) {
        ImageView offerImageView = rootView.findViewById(R.id.bottomImage1);
        ImageView cartImageView = rootView.findViewById(R.id.bottomImage2);
        ImageView searchImageView = rootView.findViewById(R.id.bottomImage6);
        ImageView homeImageView = rootView.findViewById(R.id.bottomImage3);
        ImageView profileImageView = rootView.findViewById(R.id.bottomImage4);

        offerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(OfferActivity.class);
            }
        });

        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(CartActivity.class);
            }
        });

        searchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(SearchActivity.class);
            }
        });

        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(MainActivity.class);
            }
        });

        profileImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(ProfileActivity.class);
            }
        });
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(context, activityClass);
        context.startActivity(intent);
    }
}
