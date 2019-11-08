package in.goodiebag.example;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;
import in.goodiebag.example.R;

public class MainActivity extends AppCompatActivity {
    CarouselPicker imageCarousel, textCarousel, mixCarousel, bitCarousel;
    TextView tvSelected;
    ImageView ivSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageCarousel = (CarouselPicker) findViewById(R.id.imageCarousel);
        textCarousel = (CarouselPicker) findViewById(R.id.textCarousel);
        mixCarousel = (CarouselPicker) findViewById(R.id.mixCarousel);
        bitCarousel = findViewById(R.id.bitCarousel);
        tvSelected = (TextView) findViewById(R.id.tvSelectedItem);
        ivSelected = findViewById(R.id.ivSelectedItem);

        List<CarouselPicker.PickerItem> imageItems = new ArrayList<>();
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i1));
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i2));
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i3));
        imageItems.add(new CarouselPicker.DrawableItem(R.drawable.i4));
        //CarouselPicker.CarouselViewAdapter imageAdapter = new CarouselPicker.CarouselViewAdapter(this, imageItems, 0);
        //imageCarousel.setAdapter(imageAdapter);

        List<CarouselPicker.PickerItem> textItems = new ArrayList<>();
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        textItems.add(new CarouselPicker.TextItem("hi", 20));
        //CarouselPicker.CarouselViewAdapter textAdapter = new CarouselPicker.CarouselViewAdapter(this, textItems, 0);
        //textCarousel.setAdapter(textAdapter);

        List<CarouselPicker.PickerItem> mixItems = new ArrayList<>();
        mixItems.add(new CarouselPicker.DrawableItem(R.drawable.i1));
        mixItems.add(new CarouselPicker.TextItem("hi", 20));
        mixItems.add(new CarouselPicker.DrawableItem(R.drawable.i2));
        mixItems.add(new CarouselPicker.TextItem("hi", 20));


        List<CarouselPicker.PickerItem> bitItems = new ArrayList<>();
        bitItems.add(new CarouselPicker.BitmapItem(convertToBit(R.drawable.black_jeans)));
        bitItems.add(new CarouselPicker.BitmapItem(convertToBit(R.drawable.striped_pants)));
        bitItems.add(new CarouselPicker.BitmapItem(convertToBit(R.drawable.jeans)));

        CarouselPicker.CarouselViewAdapter bitAdapter = new CarouselPicker.CarouselViewAdapter(this, bitItems, 0);
        bitCarousel.setAdapter(bitAdapter);

        bitCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //tvSelected.setText("Selected item in image carousel is  : "+ position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        textCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvSelected.setText("Selected item in text carousel is  : "+position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mixCarousel.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvSelected.setText("Selected item in mix carousel is  : "+ position);
                tvSelected.setTextColor(000000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private Bitmap convertToBit(int drawable) {
        Bitmap bitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(),
                drawable);
        return bitmap;
    }
}
