package com.numank.vestel.autotest;

import android.graphics.Rect;
import android.os.RemoteException;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import android.test.InstrumentationTestCase;


public class AutoEposta extends InstrumentationTestCase {

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

                // E-Mail
                mdevice.pressHome();
                UiObject appsButton = mdevice.findObject(new UiSelector().description("Uygulamalar"));
                appsButton.clickAndWaitForNewWindow();

                clickText("ES Dosya Yöneticisi", "Uygulama Menüsünde Es-Dosya Yöneticisine Tıklanamadı.");
                clickId("com.estrongs.android.pop:id/icon");
                clickId("com.estrongs.android.pop:id/menu_overflow");
                clickTextt("Görünüm");
                clickTextt("Küçük Simge");
                Thread.sleep(1000);
                clickText("Testler İçin Gerekli Dosyalar", "Es-Dosyanın içerisinde Testler için gerekli dosyalara tıklanamadı.");
                clickText("Varsayılan Testinde E-Mail Gönderimi Deneme Dosyaları", "Es-Dosyanın içerisinde Varsayılan Testinde E-Mail Gönderimi Deneme Dosyalarına Tıklanamadı.");
                clickText("Belgeler", "Es-Dosya Yöneticisi içerisinde Belgeler Klasörüne Tıklanamadı.");

                int rakam = 1;

                while (rakam <= 27) {

                        Thread.sleep(3000);

                        UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakam)));

                        Rect button = varsayilan.getBounds();

                        mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 40);

                        Thread.sleep(2000);

                        clickId("com.estrongs.android.pop:id/menu_overflow");

                        Thread.sleep(2000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1000);


                        UiObject Text = mdevice.findObject(new UiSelector().textContains("Paylaş"));
                        if (Text.exists() && Text.isEnabled()) {
                                Text.click();
                        } else {

                                mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                                Thread.sleep(2000);

                                clickId("com.estrongs.android.pop:id/menu_overflow");

                                Thread.sleep(2000);

                                mdevice.swipe(502, 825, 502, 273, 10);

                                Thread.sleep(1500);

                                Text.click();
                        }

                        Thread.sleep(2000);

                        clickText("E-posta", "E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

                        Thread.sleep(2500);

                        mdevice.click(575, 1071);

                        Thread.sleep(1000);

                        mdevice.pressEnter();
                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        Thread.sleep(1000);

                        clickId("com.android.email:id/send");

                        rakam++;
                }

                Thread.sleep(1000);
                mdevice.pressBack();
                Thread.sleep(1000);
                clickText("Belgeler2", "Es-Dosyada Belgeler2 Klasörüne Ulaşılamadı.");
                int rakamm = 1;

                while (rakamm <= 27) {
                        Thread.sleep(3000);

                        UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakamm)));

                        Rect button = varsayilan.getBounds();

                        mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                        Thread.sleep(2000);

                        clickId("com.estrongs.android.pop:id/menu_overflow");

                        Thread.sleep(2000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1500);

                        UiObject Text = mdevice.findObject(new UiSelector().textContains("Paylaş"));
                        if (Text.exists() && Text.isEnabled()) {
                                Text.click();
                        } else {

                                mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                                Thread.sleep(2000);

                                clickId("com.estrongs.android.pop:id/menu_overflow");

                                Thread.sleep(2000);

                                mdevice.swipe(502, 825, 502, 273, 10);

                                Thread.sleep(1500);

                                Text.click();
                        }

                        Thread.sleep(2000);

                        clickText("E-posta", "E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

                        Thread.sleep(2500);

                        mdevice.click(575, 1071);

                        Thread.sleep(1000);

                        mdevice.pressEnter();
                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        Thread.sleep(1000);


                        clickId("com.android.email:id/send");

                        rakamm++;
                }

                Thread.sleep(1000);
                mdevice.pressBack();
                Thread.sleep(1000);
                clickText("Sesler", "Es-Dosyada Belgeler2 Klasörüne Ulaşılamadı.");
                int rakammm = 1;

                while (rakammm <= 26) {
                        Thread.sleep(3000);

                        UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakamm)));

                        Rect button = varsayilan.getBounds();

                        mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                        Thread.sleep(2000);

                        clickId("com.estrongs.android.pop:id/menu_overflow");

                        Thread.sleep(2000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1500);

                        UiObject Text = mdevice.findObject(new UiSelector().textContains("Paylaş"));
                        if (Text.exists() && Text.isEnabled()) {
                                Text.click();
                        } else {

                                mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                                Thread.sleep(2000);

                                clickId("com.estrongs.android.pop:id/menu_overflow");

                                Thread.sleep(2000);

                                mdevice.swipe(502, 825, 502, 273, 10);

                                Thread.sleep(1500);

                                Text.click();
                        }

                        Thread.sleep(2000);

                        clickText("E-posta", "E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

                        Thread.sleep(2500);

                        mdevice.click(575, 1071);

                        Thread.sleep(1000);

                        mdevice.pressEnter();
                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        Thread.sleep(1000);

                        clickId("com.android.email:id/send");

                        rakammm++;
                }

                Thread.sleep(1000);
                mdevice.pressBack();
                Thread.sleep(1000);
                clickText("Videolar", "Es-Dosyada Belgeler2 Klasörüne Ulaşılamadı.");
                int rakammmm = 1;

                while (rakammmm <= 13) {
                        Thread.sleep(3000);

                        UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakamm)));

                        Rect button = varsayilan.getBounds();

                        mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                        Thread.sleep(2000);

                        clickId("com.estrongs.android.pop:id/menu_overflow");

                        Thread.sleep(2000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1000);

                        mdevice.swipe(502, 825, 502, 273, 10);

                        Thread.sleep(1500);

                        UiObject Text = mdevice.findObject(new UiSelector().textContains("Paylaş"));
                        if (Text.exists() && Text.isEnabled()) {
                                Text.click();
                        } else {

                                mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

                                Thread.sleep(2000);

                                clickId("com.estrongs.android.pop:id/menu_overflow");

                                Thread.sleep(2000);

                                mdevice.swipe(502, 825, 502, 273, 10);

                                Thread.sleep(1500);

                                Text.click();
                        }

                        Thread.sleep(2000);

                        clickText("E-posta", "E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

                        Thread.sleep(2500);

                        mdevice.click(575, 1071);

                        Thread.sleep(1000);

                        mdevice.pressEnter();
                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        mdevice.pressEnter();

                        mdevice.click(482, 946);
                        mdevice.click(71, 946);
                        mdevice.click(71, 946);
                        mdevice.click(417, 1039);

                        Thread.sleep(1000);

                        clickId("com.android.email:id/send");

                        rakammmm++;
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
        public void clickText(String text, String mesaj) throws UiObjectNotFoundException, InterruptedException, RemoteException {
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
        public void mesajGonder(String Mesaj) throws InterruptedException, UiObjectNotFoundException, RemoteException {
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
                mdevice.pressRecentApps();
                mdevice.wait(Until.hasObject(By.res("com.android.systemui", "com.android.systemui:id/recents_clear")), 1000);
                UiObject deleteRecentApps = mdevice.findObject(new UiSelector()
                        .resourceId("com.android.systemui:id/recents_clear"));
                if (deleteRecentApps.isClickable() && deleteRecentApps.isEnabled())
                        deleteRecentApps.click();
                else
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