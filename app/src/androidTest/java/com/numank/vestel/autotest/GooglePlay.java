package com.numank.vestel.autotest;

import android.graphics.Rect;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;

public class GooglePlay extends InstrumentationTestCase {

    private UiDevice mdevice;

    public static final long shortBrake = 3000;
    public static final long longBreake = 7000;
    public static final long watching = 12000;


    @Override
    public void setUp() throws Exception {
        super.setUp();

        mdevice = UiDevice.getInstance(getInstrumentation());


        mdevice.sleep();

        mdevice.wakeUp();

        Thread.sleep(4000);

        unlockScreen();

        idle();

        mdevice.pressRecentApps();

        idle();

        //clear recent apps
        mdevice.wait(Until.hasObject(By.res("com.android.systemui", "com.android.systemui:id/recents_clear")), 1000);
        UiObject deleteRecentApps = mdevice.findObject(new UiSelector()
                .resourceId("com.android.systemui:id/recents_clear"));
        if (deleteRecentApps.isClickable() && deleteRecentApps.isEnabled())
            deleteRecentApps.click();
        else
            mdevice.pressHome();

        mdevice.openNotification();

        //clear notifications
        mdevice.wait(Until.hasObject(By.res("com.android.systemui", "com.android.systemui:id/dismiss_text")), 1000);
        UiObject2 clearNotifications = mdevice.findObject(By.res("com.android.systemui:id/dismiss_text"));
        if (clearNotifications != null)
            clearNotifications.click();
        else
            mdevice.pressHome();

    }


    public void testAdd() throws Exception {

        //UiObject appsButton = mdevice.findObject(new UiSelector().description("Uygulamalar"));

        //appsButton.click();
        mdevice.pressHome();
       clickTextt("Play Store");
        Thread.sleep(10000);
        clickTextt("UYGULAMALAR VE OYUNLAR");
        clickTextt("UYGULAMALAR");
        Thread.sleep(1000);
        clickTextt("ÜST SIRALAR");
        Thread.sleep(5000);
        clickTextt("ÜCRETSİZ EN POPÜLER");
        Thread.sleep(2000);


        int sira = 1;

        while (sira <= 100)

        {

            UiObject googleplay = mdevice.findObject(new UiSelector().textContains(toString().valueOf(sira)));

            if (googleplay.exists() && googleplay.isEnabled()) {
            googleplay.click();

        }

        else {

            mdevice.swipe(400, 850, 400, 420, 15);
            Thread.sleep(1000);
                googleplay.click();
        }

            Thread.sleep(1000);

            clickTextt("YÜKLE");

            clickTextt("YÜKLE");

            Thread.sleep(1000);

            clickTextt("Devam et");

            clickTextt("DEVAM");

            Thread.sleep(1000);

            clickTextt("KABUL ET");

            Thread.sleep(500);

            clickTextt("KABUL ET");

            Thread.sleep(500);

            clickTextt("KABUL ET");

            Thread.sleep(3000);

            mdevice.pressBack();

            Thread.sleep(2000);

            UiObject Text = mdevice.findObject(new UiSelector().resourceId("com.android.vending:id/cancel_download"));
            if (Text.exists() && Text.isEnabled()) {
                mdevice.pressBack();
            } else {


            }

            Thread.sleep(1000);

            mdevice.swipe(400, 850, 400, 720, 10);

            sira++;
        }
    }

    public void kameraFlashAc() throws InterruptedException {
        Thread.sleep(1000);
        mdevice.click(257, 68);
        Thread.sleep(1000);
        mdevice.click(264, 186);
        Thread.sleep(1000);
    }

    public void kameraFlashKapat() throws InterruptedException {
        Thread.sleep(1000);
        mdevice.click(257, 68);
        Thread.sleep(1000);
        mdevice.click(159, 174);
        Thread.sleep(1000);
    }

    public void kameraFlashAuto() throws InterruptedException {
        Thread.sleep(1000);
        mdevice.click(257, 68);
        Thread.sleep(1000);
        mdevice.click(359, 174);
        Thread.sleep(1000);
    }


    public void moveUp() {
        int height = mdevice.getDisplayHeight();
        int width = mdevice.getDisplayWidth();
        mdevice.swipe(width / 2, height - 200, width / 2, height - 800, 10);
    }

    public void moveDown() {
        int height = mdevice.getDisplayHeight();
        int width = mdevice.getDisplayWidth();
        mdevice.swipe(width / 2, height - 800, width / 2, height - 200, 10);
    }

    public void unlockScreen() {
        int height = mdevice.getDisplayHeight();
        int width = mdevice.getDisplayWidth();
        mdevice.swipe(width / 2, height - 100, width / 2, height - 800, 10);
    }

    public void idle() {
        mdevice.waitForIdle(10000);

    }

    // Uzun Tıklama
    public void longClickText(String text) throws UiObjectNotFoundException, InterruptedException {
        UiObject object = mdevice.findObject(new UiSelector().textContains(text));
        Rect coordinates = object.getBounds();
        Thread.sleep(1000);
        mdevice.swipe(coordinates.centerX(), coordinates.centerY(),
                coordinates.centerX(), coordinates.centerY(),
                50);
    }


    // Hata Mesajı Göndermez..
    public void clickTextt(String yazi) throws UiObjectNotFoundException, InterruptedException {

        UiObject Text = mdevice.findObject(new UiSelector().textContains(yazi));
        if (Text.exists() && Text.isEnabled()) {
            Text.click();
        } else {
        }


    }

    //Hata Mesajı Gönderir..
    public void clickText(String text, String mesaj) throws UiObjectNotFoundException, InterruptedException {
        UiObject Text = mdevice.findObject(new UiSelector().textContains(text));
        if (Text.exists() && Text.isEnabled()) {
            Text.click();
        } else {
            mesajGonder(mesaj);
        }
    }

    // ID bulur ve  Tıklamamızı Sağlar..
    public void clickId(String Id) throws UiObjectNotFoundException, InterruptedException {
        UiObject ıd = mdevice.findObject(new UiSelector().resourceId(Id));
        Thread.sleep(1000);
        ıd.click();
    }

    //description bulur ve tıklar..
    public void clickDes(String des) throws UiObjectNotFoundException, InterruptedException {
        UiObject dess = mdevice.findObject(new UiSelector().description(des));
        Thread.sleep(1000);
        dess.click();
    }

    // İstediğimiz zaman mesaj göndermemizi sağlar
    public void mesajGonder(String Mesaj) throws InterruptedException, UiObjectNotFoundException {
        UiObject alici = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/recipients_editor"));
        UiObject mesajtext = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/embedded_text_editor"));

        mdevice.pressHome();
        Thread.sleep(2000);
        clickTextt("Mesajlaşma");
        Thread.sleep(2000);
        clickId("com.android.mms:id/floating_action_button");
        Thread.sleep(1000);
        alici.click();
        Thread.sleep(1000);
        alici.setText("05074766726");
        Thread.sleep(1000);
        mesajtext.click();
        Thread.sleep(1000);
        mesajtext.setText(Mesaj);
        Thread.sleep(1000);
        clickId("com.android.mms:id/send_button_sms");
        Thread.sleep(3000);
        mdevice.pressHome();
    }

    //Assos Plus Hotmail Adresi.. ( Gönderilen E-Mail Adresi.)
    public void hotmailadresi() {

        mdevice.click(118, 936);    // S
        mdevice.click(644, 935);     // i
        mdevice.click(532, 922);     // l
        mdevice.click(303, 1024);    // v
        mdevice.click(144, 807);     // e
        mdevice.click(216, 809);     // r
        mdevice.click(481, 923);     // k
        mdevice.click(56, 916);      // a
        mdevice.click(56, 916);      // a
        mdevice.click(413, 1037);   // n
        mdevice.click(507, 1161);    // @
        mdevice.click(354, 928);     // h
        mdevice.click(505, 820);     // o
        mdevice.click(273, 820);     // t
        mdevice.click(475, 1047);    // m
        mdevice.click(56, 916);      // a
        mdevice.click(644, 935);     // i
        mdevice.click(532, 922);     // l
        mdevice.click(576, 1135);    // .
        mdevice.click(250, 1027);    // c
        mdevice.click(503, 812);     // o
        mdevice.click(475, 1047);    // m
    }

    //Assos Plus Gmail Adresi..
    public void gmailadresi() {

        mdevice.click(31, 808);      //q
        mdevice.click(56, 916);      //a
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273, 820);     //t
        mdevice.click(303, 1024);    //v
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(532, 922);     //l

    }

    // Assos Plus Gmail Adresinin Şifresi..
    public void gmailadresisifre() {

        mdevice.click(31, 808);      //q
        mdevice.click(56, 916);      //a
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273, 820);     //t
        mdevice.click(303, 1024);    //v
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(532, 922);     //l
        mdevice.click(50, 1158);     //123
        mdevice.click(30, 924);      //123-@

    }
}