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

public class AutoTest extends InstrumentationTestCase {

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


        /*// Kamera Uygulaması

        clickText("VCam", "Vcam'e Tıklanamadı");

        kameraFlashKapat();

        int fnok = 1;

        while (fnok <= 2)

        {
            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            fnok++;

        }

        Thread.sleep(2000);
        kameraFlashAc();
        Thread.sleep(2000);

        int fok = 1;

        while (fok <= 2)

        {
            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(4000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            fok++;

        }

        kameraFlashKapat();
        mdevice.pressHome();

        int geri = 1;

        while (geri <= 100)

        {
            clickText("VCam", "Vcam'e Tıklanamadı");
            Thread.sleep(5000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(4000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(3000);
            mdevice.pressBack();
            mdevice.pressBack();
            Thread.sleep(2000);
            geri++;
        }

        mdevice.pressHome();

        int hometusu = 1;

        while (hometusu <= 100)

        {
            clickText("VCam", "Vcam'e Tıklanamadı");
            Thread.sleep(3000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(4000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(3000);
            mdevice.pressHome();
            Thread.sleep(4000);
            hometusu++;
        }

        mdevice.pressHome();
        Thread.sleep(5000);
        clickText("VCam", "Vcam'e Tıklanamadı");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(142, 342);      //Kamera Ayarlar Genel Çözünürlülük 8Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);

        kameraFlashAc();

        int sekizmpac = 1;

        while(sekizmpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            sekizmpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int sekizmpflaskap = 1;

        while(sekizmpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            sekizmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(5000);
        clickText("VCam", "Vcam'e Tıklanamadı");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(359, 342);      //Kamera Ayarlar Genel Çözünürlülük 5Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int besmpac = 1;

        while(besmpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            besmpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int besmpflaskap = 1;

        while(besmpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            besmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "Vcam'e Tıklanamadı");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(584, 342);      //Kamera Ayarlar Genel Çözünürlülük 3Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int ucmpac = 1;

        while(ucmpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ucmpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int ucmpflaskap = 1;

        while(ucmpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ucmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam" , "Vcam'e Tıklanamadı");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(137, 536);      //Kamera Ayarlar Genel Çözünürlülük 2Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int ikimpac = 1;

        while(ikimpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ikimpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int ikimpflaskap = 1;

        while(ikimpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ikimpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","VCam Uygulamasına Girilemedi..");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(371, 536);      //Kamera Ayarlar Genel Çözünürlülük 1Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int birmpac = 1;

        while(birmpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            birmpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int birmpflaskap = 1;

        while(birmpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            birmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","VCam Uygulamasına Girilemedi..");
        Thread.sleep(1000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        mdevice.click(212, 174);     //Kamera Ayarlar Genel
        Thread.sleep(1000);
        mdevice.click(160, 323);     //Kamera Ayarlar Genel Çözünürlülük
        Thread.sleep(1000);
        mdevice.click(552, 536);      //Kamera Ayarlar Genel Çözünürlülük QVGA
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int QVGAmpac = 1;

        while(QVGAmpac <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            QVGAmpac++;
        }

        Thread.sleep(1000);

        kameraFlashKapat();

        int QVGAmpflaskap = 1;

        while(QVGAmpflaskap <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            QVGAmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","VCam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı","Kamera Uygulamasında Otomatik Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı","Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int kapalisure = 1;

        while(kapalisure <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            kapalisure++;
        }
        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","VCam Uygulamasına Girilemedi.");
        Thread.sleep(2000);

        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı","Kamera Uygulamasında Otomatik zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı","Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("3 saniye","Kamera Uygulamasında 3 Saniye Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int ucsaniye = 1;

        while(ucsaniye <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(5000);
            ucsaniye++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına girilemedi.");
        Thread.sleep(2000);

        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı", "Kamera Uygulamasında Otomatık Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı", "Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("5 saniye", "Kamera Uygulamasında 5 Saniye Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int bessaniye = 1;

        while(bessaniye <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(8000);
            bessaniye++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","VCam uygulamasına girilemedi.");
        Thread.sleep(2000);

        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı","Kamera Uygulamasında Otomatik Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı","Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("10 saniye","Kamera Uygulamasında 10 Saniye Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int onsaniye = 1;

        while(onsaniye <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(14000);
            onsaniye++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("AWB","Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde AWB seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int AWB = 1;
        while(AWB <=20){

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            AWB++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Ampül ışığı","Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde Ampul Işıgı seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int AMPI = 1;
        while(AMPI <=20){

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            AMPI++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Florasan ışığı","Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde Florasan seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int FSI = 1;
        while(FSI <=20){

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            FSI++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam","Vcam Kamera Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Gün ışığı","Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde gun ışıgı seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int GNI = 1;
        while(GNI <=20){

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            GNI++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam'e Tıklanamadı.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Bulutlu","Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde bulutlu seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int BLTI = 1;
        while(BLTI <=20){

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            BLTI++;
        }



       */ UiObject appsButton = mdevice.findObject(new UiSelector().description("Uygulamalar"));/*

        // Mesaj Atma
        Thread.sleep(2000);

        appsButton.click();


        Thread.sleep(shortBrake);
        mdevice.swipe(355, 991, 342, 349, 10);


        // Mesajlaşma İconu
        mdevice.wait(Until.hasObject(By.text("Mesajlaşma")), 1000);
        UiObject mesajlasma = mdevice.findObject(new UiSelector().text("Mesajlaşma"));
        if (mesajlasma.exists() && mesajlasma.isClickable())
            mesajlasma.clickAndWaitForNewWindow();
        // Mesaj Button (+)
        mdevice.wait(Until.hasObject(By.res("com.android.mms", "com.android.mms:id/floating_action_button")), 1000);
        UiObject msbt1 = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/floating_action_button"));
        if (msbt1.exists() && msbt1.isClickable())
            msbt1.click();
        // Mesaj Alıcı Kısmı
        mdevice.wait(Until.hasObject(By.res("com.android.mms", "com.android.mms:id/recipients_editor")), 1000);
        UiObject alici = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/recipients_editor"));
        if (alici.exists() && alici.isClickable())
            alici.click();
        alici.setText("05074766726");
        //Mesaj Text
        mdevice.wait(Until.hasObject(By.res("com.android.mms", "com.android.mms:id/embedded_text_editor")), 1000);
        UiObject mesajtext = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/embedded_text_editor"));
        if (mesajtext.exists() && mesajtext.isClickable())
            mesajtext.click();
        mesajtext.setText("Auto Test Mesajı Başladı");
        //Mesaj Gonder Buttonu
        mdevice.wait(Until.hasObject(By.res("com.android.mms", "com.android.mms:id/send_button_sms")), 1000);
        UiObject mesajgon = mdevice.findObject(new UiSelector().resourceId("com.android.mms:id/send_button_sms"));
        if (mesajgon.exists() && mesajgon.isClickable())
            mesajgon.click();
        Thread.sleep(shortBrake);

        int sayi = 1;
        while (sayi <= 2) {
            mesajtext.click();
            mesajtext.setText("Auto Test Mesajı " + sayi);
            Thread.sleep(1000);
            mesajgon.click();
            sayi = sayi + 1;
            Thread.sleep(1000);
        }

        // E-Mail
        mdevice.pressHome();
        appsButton.clickAndWaitForNewWindow();

        clickText("ES Dosya Yöneticisi", "Uygulama Menüsünde Es-Dosya Yöneticisine Tıklanamadı.");
        clickId("com.estrongs.android.pop:id/icon");
        clickText("Testler İçin Gerekli Dosyalar", "Es-Dosyanın içerisinde Testler için gerekli dosyalara tıklanamadı.");
        clickText("Varsayılan Testinde E-Mail Gönderimi Deneme Dosyaları","Es-Dosyanın içerisinde Varsayılan Testinde E-Mail Gönderimi Deneme Dosyalarına Tıklanamadı.");
        clickText("Belgeler","Es-Dosya Yöneticisi içerisinde Belgeler Klasörüne Tıklanamadı.");

        int rakam = 1;

        while (rakam <= 10) {

            Thread.sleep(3000);

            UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakam)));

            Rect button = varsayilan.getBounds();

            mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

            Thread.sleep(1000);

            clickId("com.estrongs.android.pop:id/menu_overflow");

            Thread.sleep(1000);

            mdevice.swipe(502, 825, 502, 273, 10);

            Thread.sleep(1000);

            clickText("Paylaş","Es Dosya İçerisinde Paylaş Seçeneğine Tıklanamadı");

            Thread.sleep(1000);

            clickText("Gmail","E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

            Thread.sleep(1000);

            clickText("Alıcı","E-Posta Gönderimi Sırasında Alıcı Kısmına Tıklanamadı.");

            Thread.sleep(2000);

            hotmailadresi();

            mdevice.pressEnter();

            UiObject konu = mdevice.findObject(new UiSelector().resourceId("com.google.android.gm:id/subject"));

            konu.setText("IİiıoöÖoĞğgGJ Auto Test Başlığı Atılan Mail Sayısı " + rakam);

            mdevice.pressEnter();

            UiObject ileti = mdevice.findObject(new UiSelector().resourceId("com.google.android.gm:id/body"));

            ileti.setText("IİiıoöÖoĞğgGJ Auto Test Mesajıdır Lütfen Cevap Vermeyiniz.");

            Thread.sleep(1000);

            clickId("com.google.android.gm:id/send");

            rakam++;
        }

        Thread.sleep(1000);
        mdevice.pressBack();
        Thread.sleep(1000);
        clickText("Belgeler2","Es-Dosyada Belgeler2 Klasörüne Ulaşılamadı.");
        int rakamm = 1;

        while (rakamm <= 10) {
            Thread.sleep(3000);

            UiObject varsayilan = mdevice.findObject(new UiSelector().textContains(toString().valueOf(rakamm)));

            Rect button = varsayilan.getBounds();

            mdevice.swipe(button.centerX(), button.centerY(), button.centerX(), button.centerY(), 50);

            Thread.sleep(1000);

            clickId("com.estrongs.android.pop:id/menu_overflow");

            Thread.sleep(1000);

            mdevice.swipe(502, 825, 502, 273, 10);

            Thread.sleep(1000);

            clickText("Paylaş","Es Dosya İçerisinde Paylaş Seçeneğine Tıklanamadı");

            Thread.sleep(1000);

            clickText("Gmail","E-posta Gönderimi Sırasında Gmail Seçeneğine Tıklanamadı");

            Thread.sleep(1000);

            clickText("Alıcı","E-Posta Gönderimi Sırasında Alıcı Kısmına Tıklanamadı.");

            Thread.sleep(2000);

            hotmailadresi();

            mdevice.pressEnter();

            UiObject konu = mdevice.findObject(new UiSelector().resourceId("com.google.android.gm:id/subject"));

            konu.setText("IİiıoöÖoĞğgGJ Auto Test Başlığı Atılan Mail Sayısı " + rakamm);

            mdevice.pressEnter();

            UiObject ileti = mdevice.findObject(new UiSelector().resourceId("com.google.android.gm:id/body"));

            ileti.setText("IİiıoöÖoĞğgGJ Auto Test Mesajıdır Lütfen Cevap Vermeyiniz.");

            Thread.sleep(1000);

            clickId("com.google.android.gm:id/send");

            rakamm++;
        }*/

       /* clickTextt("Play Store");
        Thread.sleep(15000);
        UiObject deneme = mdevice.findObject(new UiSelector().description("E-posta adresinizi girin "));
        deneme.click();
        Thread.sleep(3000);
        gmailadresi();
        Thread.sleep(2000);
        mdevice.pressEnter();
        Thread.sleep(4000);
        gmailadresisifre();
        Thread.sleep(1000);
        mdevice.pressEnter();
        Thread.sleep(1000);
        clickDes("KABUL ET");
        Thread.sleep(125000);
        clickDes("Diğer");
        Thread.sleep(1000);
        clickTextt("İleri");
        Thread.sleep(1000);
        clickTextt("Hayır, teşekkürler");
        Thread.sleep(1000);
        clickTextt("Devam");
        Thread.sleep(10000);
        clickTextt("UYGULAMALAR");*/

        clickTextt("Play Store");
        Thread.sleep(10000);
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
            } else {

                mesajGonder("Hata " + sira + ". " + "'daki Uygulamaya Tıklanamadı.");

            }

            Thread.sleep(2000);

            clickTextt("YÜKLE");

            Thread.sleep(2000);

            clickTextt("DEVAM") ;

            Thread.sleep(2000);

            moveUp();

            Thread.sleep(1000);

            clickTextt("KABUL ET");

            mdevice.pressBack();

            Thread.sleep(1000);

            mdevice.swipe(400, 850, 400, 700, 10);

            sira++;
        }


        //İnternet
        mdevice.pressHome();
        appsButton.clickAndWaitForNewWindow();

        mdevice.wait(Until.hasObject(By.text("Chrome")), 1000);
        UiObject Chorome1 = mdevice.findObject(new UiSelector().text("Chrome"));

        if (Chorome1.exists() && Chorome1.isClickable())
            Chorome1.clickAndWaitForNewWindow();

        // Chrome search click
        mdevice.wait(Until.hasObject(By.res("com.android.chrome", "com.android.chrome:id/search_box_text")), 1000);
        UiObject chromeSearch1 = mdevice.findObject(new UiSelector().resourceId("com.android.chrome:id/search_box_text"));
        if (chromeSearch1.exists() && chromeSearch1.isClickable())
            chromeSearch1.click();

        // Go vestel.com.tr
        mdevice.wait(Until.hasObject(By.res("com.android.chrome", "com.android.chrome:id/url_bar")), 1000);
        UiObject chromeSearch2 = mdevice.findObject(new UiSelector().resourceId("com.android.chrome:id/url_bar"));
        if (chromeSearch2.exists() && chromeSearch2.isClickable())
            chromeSearch2.click();
        chromeSearch2.setText("www.vestel.com.tr");
        mdevice.pressEnter();

        Thread.sleep(longBreake);

        // Go radikal.com.tr
        mdevice.wait(Until.hasObject(By.res("com.android.chrome", "com.android.chrome:id/url_bar")), 1000);
        UiObject goRadikal = mdevice.findObject(new UiSelector().resourceId("com.android.chrome:id/url_bar"));
        if (goRadikal.exists() && goRadikal.isClickable())
            goRadikal.click();
        Thread.sleep(longBreake);
        //goRadikal.clearTextField();
        //idle();
        goRadikal.setText("www.radikal.com.tr");
        //idle();
        mdevice.pressEnter();


        Thread.sleep(longBreake);
        moveUp();
        Thread.sleep(longBreake);
        moveDown();


        mdevice.pressHome();


    }

    public void kameraFlashAc () throws InterruptedException {
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
    public  void longClickText(String text) throws UiObjectNotFoundException, InterruptedException {
        UiObject object = mdevice.findObject(new UiSelector().textContains(text));
        Rect coordinates = object.getBounds();
        Thread.sleep(1000);
        mdevice.swipe(coordinates.centerX(), coordinates.centerY(),
                coordinates.centerX(), coordinates.centerY(),
                50); }


    // Hata Mesajı Göndermez..
    public  void clickTextt(String yazi) throws UiObjectNotFoundException, InterruptedException {

        UiObject Text = mdevice.findObject(new UiSelector().textContains(yazi));
        if(Text.exists() && Text.isEnabled()) {
            Text.click();}
        else{}



    }

    //Hata Mesajı Gönderir..
    public  void clickText(String text , String mesaj) throws UiObjectNotFoundException, InterruptedException {
        UiObject Text = mdevice.findObject(new UiSelector().textContains(text));
        if(Text.exists() && Text.isEnabled()) {
            Text.click();}
        else{
            mesajGonder(mesaj);
        }
    }
    // ID bulur ve  Tıklamamızı Sağlar.. 
    public void clickId (String Id) throws UiObjectNotFoundException, InterruptedException {
        UiObject ıd = mdevice.findObject(new UiSelector().resourceId(Id));
        Thread.sleep(1000);
        ıd.click();
    }
    //description bulur ve tıklar..
    public void clickDes (String des) throws UiObjectNotFoundException, InterruptedException {
        UiObject dess = mdevice.findObject(new UiSelector().description(des));
        Thread.sleep(1000);
        dess.click();
    }

    // İstediğimiz zaman mesaj göndermemizi sağlar
    public void mesajGonder (String Mesaj) throws InterruptedException, UiObjectNotFoundException {
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
        mdevice.click(644,935);     // i
        mdevice.click(532,922);     // l
        mdevice.click(303,1024);    // v
        mdevice.click(144,807);     // e
        mdevice.click(216,809);     // r
        mdevice.click(481,923);     // k
        mdevice.click(56,916);      // a
        mdevice.click(56,916);      // a
        mdevice.click(413, 1037);   // n
        mdevice.click(507,1161);    // @
        mdevice.click(354,928);     // h
        mdevice.click(505,820);     // o
        mdevice.click(273,820);     // t
        mdevice.click(475,1047);    // m
        mdevice.click(56,916);      // a
        mdevice.click(644,935);     // i
        mdevice.click(532,922);     // l
        mdevice.click(576,1135);    // .
        mdevice.click(250,1027);    // c
        mdevice.click(503,812);     // o
        mdevice.click(475,1047);    // m
    }
    //Assos Plus Gmail Adresi..
    public void gmailadresi(){

        mdevice.click(31, 808);      //q
        mdevice.click(56,916);      //a
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273,820);     //t
        mdevice.click(303, 1024);    //v
        mdevice.click(144, 807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273, 820);     //t
        mdevice.click(144, 807);     //e
        mdevice.click(532, 922);     //l

    }
    // Assos Plus Gmail Adresinin Şifresi..
    public void gmailadresisifre(){

        mdevice.click(31, 808);      //q
        mdevice.click(56,916);      //a
        mdevice.click(273,820);     //t
        mdevice.click(144,807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273,820);     //t
        mdevice.click(303,1024);    //v
        mdevice.click(144,807);     //e
        mdevice.click(118, 936);    //s
        mdevice.click(273,820);     //t
        mdevice.click(144,807);     //e
        mdevice.click(532,922);     //l
        mdevice.click(50,1158);     //123
        mdevice.click(30,924);      //123-@

    }
}


