package zomaru.sendmequotes;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class AboutPhone extends Activity {

    private RecyclerView recyclerView;
    private AdapterAboutPhone adapterAboutPhone;
    private ArrayList<PhoneInfo>phoneInfoArrayList;
    public int ThemeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applytheme(this);
        setContentView(R.layout.recycler_view_about_phone);

        addData();

        recyclerView= (RecyclerView)findViewById(R.id.recycler_view_layout);

        adapterAboutPhone = new AdapterAboutPhone(phoneInfoArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AboutPhone.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapterAboutPhone);

    }

    void addData() {
        String infoDeviceModel;
        String infoDeviceBrand;
        String infoDeviceProduct;
        String infoDeviceDevice;
        String infoDeviceManufacturer;
        String infoDeviceCodename;
        infoDeviceModel = "Model: " + Build.MODEL;
        infoDeviceBrand = "Brand: " + Build.BRAND;
        infoDeviceProduct = "Product: " + Build.PRODUCT;
        infoDeviceDevice = "Device: " +Build.DEVICE;
        infoDeviceManufacturer = "Manufacturer: " + Build.MANUFACTURER;
        infoDeviceCodename = "Device Codename: " + Build.BRAND + " " + Build.DEVICE;

        phoneInfoArrayList = new ArrayList<>();
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceModel, Build.MODEL));
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceBrand, Build.BRAND));
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceProduct, Build.PRODUCT));
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceDevice, Build.DEVICE));
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceManufacturer, Build.MANUFACTURER));
        phoneInfoArrayList.add(new PhoneInfo(infoDeviceCodename, Build.BRAND + " " + Build.DEVICE));
    }

    public void Applytheme (Activity activity) {
        ThemeValue = Settings.Themevalues;
        switch (ThemeValue) {
            case 1:
                activity.setTheme(R.style.light_theme);
                break;
            case 2:
                activity.setTheme(R.style.dark_theme);
                break;
            case 3:
                activity.setTheme(R.style.black_theme);
                break;
            case 4:
                activity.setTheme(R.style.akame_theme);
                break;
            case 5:
                activity.setTheme(R.style.zero_two_theme);
                break;
            case 6:
                activity.setTheme(R.style.methode_theme);
                break;
            case 7:
                activity.setTheme(R.style.mary_theme);
                break;
            case 8:
                activity.setTheme(R.style.indonesia_theme);
                break;
        }
    }
}
