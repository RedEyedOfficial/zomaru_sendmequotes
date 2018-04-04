/*
 * Copyright (C) 2018 Red Eyed Official
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package zomaru.sendmequotes;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toolbar;

import java.util.ArrayList;
import zomaru.sendmequotes.ThemeSwap;


public class AboutPhone extends Activity {

    private RecyclerView recyclerView;
    private AdapterAboutPhone adapterAboutPhone;
    private ArrayList<PhoneInfo>phoneInfoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeSwap.onActivityCreateSetTheme(this);
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
}
