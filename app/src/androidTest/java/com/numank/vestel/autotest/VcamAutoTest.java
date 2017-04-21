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

public class VcamAutoTest extends InstrumentationTestCase {

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

        // Kamera Uygulaması
        mdevice.pressHome();
        Thread.sleep(1000);
        clickText("VCam", "Vcam'e Tıklanamadı");

        kameraFlashKapat();

        int fnok = 1;

        while (fnok <= 50)

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

        while (fok <= 50)

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

        while (geri <= 50)

        {
            clickText("VCam", "Vcam'e Tıklanamadı");
            Thread.sleep(3000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(4000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(3000);
            mdevice.pressBack();
            mdevice.pressBack();
            Thread.sleep(1000);
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
            Thread.sleep(1000);
            mdevice.pressHome();
            Thread.sleep(2000);
            hometusu++;
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
        mdevice.click(142, 342);      //Kamera Ayarlar Genel Çözünürlülük 8Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);

        kameraFlashAc();

        int sekizmpac = 1;

        while (sekizmpac <= 20) {

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

        while (sekizmpflaskap <= 20) {

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

        while (besmpac <= 20) {

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



        while (besmpflaskap <= 20) {

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

        while (ucmpac <= 20) {

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

        while (ucmpflaskap <= 20) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ucmpflaskap++;
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
        mdevice.click(137, 536);      //Kamera Ayarlar Genel Çözünürlülük 2Mp
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        Thread.sleep(1000);
        kameraFlashAc();

        int ikimpac = 1;

        while (ikimpac <= 20) {

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

        while (ikimpflaskap <= 20) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            ikimpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına Girilemedi..");
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

        while (birmpac <= 20) {

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

        while (birmpflaskap <= 20) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            birmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına Girilemedi..");
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

        while (QVGAmpac <= 20) {

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

        while (QVGAmpflaskap <= 20) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            QVGAmpflaskap++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı", "Kamera Uygulamasında Otomatik Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı", "Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int kapalisure = 1;

        while (kapalisure <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            kapalisure++;
        }
        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına Girilemedi.");
        Thread.sleep(2000);

        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı", "Kamera Uygulamasında Otomatik zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı", "Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("3 saniye", "Kamera Uygulamasında 3 Saniye Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int ucsaniye = 1;

        while (ucsaniye <= 10) {

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

        while (bessaniye <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(8000);
            bessaniye++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam uygulamasına girilemedi.");
        Thread.sleep(2000);

        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı", "Kamera Uygulamasında Otomatik Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı", "Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("10 saniye", "Kamera Uygulamasında 10 Saniye Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();
        int onsaniye = 1;

        while (onsaniye <= 10) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(14000);
            onsaniye++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "VCam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Otomatik zamanlayıcı", "Kamera Uygulamasında Otomatik Zamanlayıcı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        clickText("Kapalı", "Kamera Uygulamasında Kapalı Seçeneğine Tıklanamadı.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("AWB", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde AWB seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int AWB = 1;
        while (AWB <= 30) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            AWB++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Ampül ışığı", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde Ampul Işıgı seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int AMPI = 1;
        while (AMPI <= 30) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            AMPI++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "Vcam Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Florasan ışığı", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde Florasan seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int FSI = 1;
        while (FSI <= 30) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            FSI++;
        }

        mdevice.pressHome();
        Thread.sleep(2000);
        clickText("VCam", "Vcam Kamera Uygulamasına Girilemedi.");
        Thread.sleep(2000);
        mdevice.click(100, 58);      //Kamera Ayarlar
        Thread.sleep(1000);
        clickText("Gelişmiş", "Kamera Uygulaması içerisinde ayarlarda Gelişmiş seçeneğine tıklanamadı.");
        Thread.sleep(1000);
        clickText("Beyaz dengesi", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi tıklanamadı");
        Thread.sleep(1000);
        clickText("Gün ışığı", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde gun ışıgı seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int GNI = 1;
        while (GNI <= 30) {

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
        clickText("Bulutlu", "Kamera Uygulaması içerisinde ayarlarda Beyaz Dengesi içinde bulutlu seçilemedi.");
        Thread.sleep(1000);
        mdevice.pressBack();
        mdevice.pressBack();

        int BLTI = 1;
        while (BLTI <= 30) {

            Thread.sleep(2000);
            mdevice.click(342, 619);    //Odakla
            Thread.sleep(3000);
            mdevice.click(353, 1130);   //Fotoğraf Çek Buttonu
            Thread.sleep(2000);
            BLTI++;
        }

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
        else{

        }

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