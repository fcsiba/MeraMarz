package com.example.meramarz;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class tabAdapterAdwiyaat extends FragmentStatePagerAdapter {

    String[] tabarray = new String[]{"دوا کی یاد دہانی", "نسخہ", "میری ادویات"};
    Integer tabnumber = 3;

    public tabAdapterAdwiyaat(FragmentManager fm) {
        super(fm);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                MedicineReminder medicineReminder =new MedicineReminder();
                return medicineReminder;
            case 1:
                Prescriptions prescriptions = new Prescriptions();
                return prescriptions;
            case 2:
                ViewMedicine viewMedicine = new ViewMedicine();
                return viewMedicine;
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabnumber;
    }
}
