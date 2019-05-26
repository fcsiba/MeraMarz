package com.example.meramarz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class TibbiIstilahaat extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static String[] Alpha_one ={"ایکٹیفائیڈ-پی (Actified-P): اسکا شُمار کھانسی اور سردی رفع کرنے والی ادویات میں کیا جاتا ہے", "اینسڈ (Ansaid): یہ استعمال کی جاتی ہے دانت میں درد, درد اور سوجن, پٹھوں میں درد, کمر درد, دانتوں میں درد, حیض درد, سر درد اور دوسرے حالات ور تشخیص میں علاج،قابو پانے کے لئے" ," ایرینیک (Arinac): یہ استعمال کی جاتی ہے سرد, سردی اور فلو کی علامات, یلرجی, ہڈیوں کی بھیڑ اور دباؤ, جسم میں درد, حیض درد, پٹھوں میں درد, کمر درد, سر درد, جوڑ میں درد اور دوسرے حالات اورتشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے " ,"ایسکارڈ (Ascard): یہ استعمال کی جاتی ہے  درد, فالج کے خطرے, دل کا دورہ,بخار, گٹھیا کا بخار, رمیٹی سندشوت , کاواساکی بیماری ,دوسرے حالات اورتشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے",
            "ایول (Avil): یہ استعمال کی جاتی ہے کھجلی اور ناک بہنا, الرجک, آنکھوں کی جلن, چھیںکنے, پیٹ کی خرابی. جلاب, آنکھ سوزش اور دوسرے حالات , تشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے"};

    private static String[] Alpha_two = {"بریکسن (Brexin): یہ استعمال کی جاتی ہے گٹھیا کی بیماری اور دوسرے حالات گٹھیا کی بیماری اور دوسرے حالات","بروفین (Brufen): یہ استعمال کی جاتی ہے دانت میں درد, جسم میں درد, سر درد, حیض درد, بدن میں درد, جوڑ میں درد, کمر درد, سردی اور فلو کی علامات اور دوسرے حالات تشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے","بسکوپن (Buscopan): یہ استعمال کی جاتی ہے اسہال, شدید اسہال اور دوسرے حالات تشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے"};

    private static String[] Alpha_three = {"پینڈول(Panadol):اسکا شُمار دَرد اور بُخار رفع کرنے والی ادویات میں کیا جاتا ہے","پولیبون (Polybion): یہ استعمال کی جاتی ہے پہلے اور بعد میں آپریٹو علاج, بخار, شدید جل, حمل, معدے کی خرابی کی شکایت اور دوسرے حالات  تشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے","پولی جیل (Polygel): یہ استعمال کی جاتی ہے پیٹ ایسڈ, آنتوں میں پانی بڑھ جاتا,پیٹ خراب, سینے کی جلن, ایسڈ اجیرن, لوئر فاسفیٹ \n" +
            "  سطحوں اور دوسرے حالات  تشخیص میں علاج،قابو پانے، روک تھام کرنے یا بہتری کے لئے"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tibbi_istilahaat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button button1 = (Button) findViewById(R.id.alpha1);
        Button button2 = (Button) findViewById(R.id.alpha);
        Button button3 = (Button) findViewById(R.id.alpha2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListView listView = (ListView) findViewById(R.id.medicinelist);
                listView.setAdapter(new ArrayAdapter<String>(TibbiIstilahaat.this,R.layout.listview,R.id.list_item_text,Alpha_one));
            }
        } );

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListView listView = (ListView) findViewById(R.id.medicinelist);
                listView.setAdapter(new ArrayAdapter<String>(TibbiIstilahaat.this,R.layout.listview,R.id.list_item_text,Alpha_two));
            }
        } );

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ListView listView = (ListView) findViewById(R.id.medicinelist);
                listView.setAdapter(new ArrayAdapter<String>(TibbiIstilahaat.this,R.layout.listview,R.id.list_item_text,Alpha_three));
            }
        } );




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tibbi_istilahaat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_hamdard) {

        } else if (id == R.id.nav_search) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
