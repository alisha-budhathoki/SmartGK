package com.example.smartgk;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smartgk.Actvities.ProfileActivity;
import com.example.smartgk.Fragment.AboutFragment;
import com.example.smartgk.Fragment.BooksFragment;
import com.example.smartgk.Fragment.ContactFragment;
import com.example.smartgk.Fragment.HomeFragmentTabs;
import com.example.smartgk.Fragment.InvoiceFragment;
import com.example.smartgk.Adapter.SlidingMenuAdapter;
import com.example.smartgk.Fragment.CourseFragment;
import com.example.smartgk.Fragment.HomeMainFragment;
import com.example.smartgk.Fragment.NewsFragment;
import com.example.smartgk.Fragment.SettingsFragment;
import com.example.smartgk.Fragment.SucessStoryFragment;
import com.example.smartgk.model.ItemSlideMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    boolean doubleBackToExitPressedOnce = false;
    Button btn;
    private List<ItemSlideMenu> listSliding;
    RelativeLayout mainView, drawerView;
    private SlidingMenuAdapter adapter;
    private ListView listViewSliding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    TextView toolbar_title, txt_userName;
    ImageView drawer_image, register_image, logOut, userImage;
    String user_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbarM);

        listViewSliding = (ListView) findViewById(R.id.lv_sliding_menu);
        //  lv_register = (ListView) findViewById(R.id.lv_register);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerView = (RelativeLayout) findViewById(R.id.Drawer_View);
        // drawerView1 = (RelativeLayout) findViewById(R.id.Drawer_View1);
        mainView = (RelativeLayout) findViewById(R.id.mainView);
        toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        drawer_image = toolbar.findViewById(R.id.toolbar_image);
        userImage = findViewById(R.id.user_image);
        txt_userName = findViewById(R.id.user_name);

        txt_userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        listSliding = new ArrayList<>();

        listSliding.add(new ItemSlideMenu(R.drawable.home, "Home"));
        listSliding.add(new ItemSlideMenu(R.drawable.loction, "Courses"));
        listSliding.add(new ItemSlideMenu(R.drawable.envelope, "Book"));
        listSliding.add(new ItemSlideMenu(R.drawable.loction, "News"));
        listSliding.add(new ItemSlideMenu(R.drawable.like, "Sucess story"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_invoice, "Invoice"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_check, "About"));
        listSliding.add(new ItemSlideMenu(R.drawable.loction, "Contact"));

        listSliding.add(new ItemSlideMenu(R.color.colorPrimary," "));
        listSliding.add(new ItemSlideMenu(R.color.colorPrimary," "));

        listSliding.add(new ItemSlideMenu(R.drawable.loction, "Settings"));
        listSliding.add(new ItemSlideMenu(R.drawable.ic_logout, "LogOut"));

        SlidingMenuAdapter adapter = new SlidingMenuAdapter(this, listSliding);
        listViewSliding.setAdapter(adapter);

        //Set title
        setTitle(listSliding.get(0).getTitle().replaceAll("Home", ""));
        //item selected
        listViewSliding.setItemChecked(0, true);
        //Close menu
        drawerLayout.closeDrawer(drawerView);


        //remove shadow from drawer

//        drawerLayout.setScrimColor(getResources().getColor(android.R.color.transparent));

        //Display fragment 1 when start
        replaceFragment(0);
        //Hanlde on item click

        listViewSliding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Set title
                setTitle(listSliding.get(position).getTitle());
                //item selected
                listViewSliding.setItemChecked(position, true);
                //Replace fragment
                replaceFragment(position);
                //Close menu
                drawerLayout.closeDrawer(drawerView);

                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });


        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_opened, R.string.drawer_closed) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());

                drawerLayout.bringChildToFront(drawerView);

                drawerLayout.requestLayout();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        // toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        drawer_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START)) {

                    drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    drawerLayout.openDrawer(GravityCompat.START);

                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }


    private void replaceFragment(int pos) {
        // Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();
        switch (pos) {

            case 0:
                toolbar_title.setText("Home");

                fragmentManager.beginTransaction().replace(R.id.main_content, new HomeFragmentTabs()).addToBackStack(null).commit();
                break;

            case 1:
                toolbar_title.setText("Courses");

                fragmentManager.beginTransaction().replace(R.id.main_content, new CourseFragment()).addToBackStack(null).commit();
                break;


            case 2:

                toolbar_title.setText("Book");

                fragmentManager.beginTransaction().replace(R.id.main_content, new BooksFragment()).addToBackStack(null).commit();
                break;


            case 3:

                toolbar_title.setText("News");

                fragmentManager.beginTransaction().replace(R.id.main_content, new NewsFragment()).addToBackStack(null).commit();
                break;

            case 4:


                toolbar_title.setText("Sucess Story");

                fragmentManager.beginTransaction().replace(R.id.main_content, new SucessStoryFragment()).addToBackStack(null).commit();
                break;

            case 5:
                toolbar_title.setText("Invoice");
                fragmentManager.beginTransaction().replace(R.id.main_content, new InvoiceFragment()).addToBackStack(null).commit();
                break;

            case 6:

                toolbar_title.setText("About");
                fragmentManager.beginTransaction().replace(R.id.main_content, new AboutFragment()).addToBackStack(null).commit();
                break;

            case 7:
                toolbar_title.setText("Contact");
                fragmentManager.beginTransaction().replace(R.id.main_content, new ContactFragment()).addToBackStack(null).commit();
                break;

            case 8:
                toolbar_title.setText("Settings");
                fragmentManager.beginTransaction().replace(R.id.main_content, new SettingsFragment()).addToBackStack(null).commit();
                break;


            case 9:
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT).create();

                alertDialog.setTitle("Sapna Ko Ghar");
                alertDialog.setMessage(Html.fromHtml("Would you like to logout?"));

                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "LogOut",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferences sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
                                sharedPreferences.edit().clear().commit();
                                register_image.setVisibility(View.VISIBLE);
                                logOut.setVisibility(View.GONE);
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                dialog.dismiss();
                            }
                        });

                alertDialog.show();
                final Button neutralButton = alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
                final Button positveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                neutralButton.setTextColor(getResources().getColor(R.color.black));
                positveButton.setTextColor(getResources().getColor(R.color.black));
                break;

            default:

                break;


        }

    }
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else if (!doubleBackToExitPressedOnce) {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Touch again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {

                    doubleBackToExitPressedOnce = false;

                }
            }, 2000);
        } else {
            super.onBackPressed();
            return;
        }
    }
}
