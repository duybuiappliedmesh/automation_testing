package com.duybui.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import static org.testng.Assert.assertEquals;

public class automation {
    private static AndroidDriver<MobileElement> driver;

    @BeforeTest
    public void beforeTest() throws MalformedURLException, InterruptedException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.56.101:5555");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        dc.setCapability("appPackage", "com.appliedmesh.getkaki.dev");
        dc.setCapability("appActivity",
                         "com.fastrack.appliedmesh.ft.activities.SplashScreenActivity");

        //auto accept runtime permission
        dc.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
        driver = new AndroidDriver<>(new URL(
                "http://127.0.0.1:4723/wd/hub"), dc);
        waitElementShowingById("android:id/button1");
    }

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        //        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //        Thread.sleep(5000);
        //wait to term and conditions showing
        waitElementShowingById("android:id/button1");
    }

    public void testClickFloatingActionButton() {
        MobileElement el1 = driver.findElementById("com.appliedmesh.getkaki.dev:id/fab");
        el1.click();
    }

    @Test
    public void testPromoCodeFail() {
        testPromoCode("a", "Invalid code");
    }

    @Test
    public void testPromoCodeError() {
        testPromoCode("abcd", "Error happens!");
    }

    @Test
    public void testScanQRCode() {
        //close Terms and conditions
        MobileElement elTerms = driver.findElementById("android:id/button1");
        elTerms.click();

        //click button fab
        MobileElement emFab = driver.findElementById("com.appliedmesh.getkaki.dev:id/fab");
        emFab.click();

        //click button scan qr
        MobileElement emCode = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/ll_scan_qr_container");
        emCode.click();

        //click button more
        MobileElement btnMore = driver.findElementById("com.appliedmesh.getkaki.dev:id/iv_checkout");
        btnMore.click();

        //click view Choose QR code from Phone album
        MobileElement viewChoosePhoto = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/ll_bottom_option_container");
        viewChoosePhoto.click();

        //chose first image
        MobileElement qrPhoto = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView[1]");
        qrPhoto.click();
    }

    @Test
    public void testBuyWWWTicket() throws InterruptedException {
        //close Terms and conditions
        MobileElement elTerms = driver.findElementById("android:id/button1");
        elTerms.click();

        MobileElement el1 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
        el1.click();
        MobileElement el2 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout[1]/android.widget.Button[1]");
        el2.click();
        MobileElement el3 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
        el3.click();

        MobileElement el4 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button");
        el4.click();

        MobileElement el5 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.Button[3]");
        el5.click();

        MobileElement el6 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout");
        el6.click();
        MobileElement el7 = driver.findElementById("android:id/button1");
        el7.click();
        MobileElement el8 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/iv_checkout");
        el8.click();
        MobileElement el9 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btn_checkout");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btn_order_now");
        el10.click();
        MobileElement el11 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
        el11.click();
        MobileElement el12 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btn_proceed");
        el12.click();
        MobileElement el13 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/et_email");
        el13.sendKeys("duy.bui@appliedmesh.com");

        MobileElement el14 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btn_proceed");
        el14.click();
        MobileElement el15 = driver.findElementByAccessibilityId(
                "Card number (Required)");
        el15.sendKeys("4111111111111111");
        MobileElement el16 = driver.findElementByAccessibilityId("MM");
        el16.click();
        MobileElement el17 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]");
        el17.click();
        MobileElement el18 = driver.findElementByAccessibilityId("YYYY");
        el18.click();
        MobileElement el19 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[3]");
        el19.click();
        MobileElement el20 = driver.findElementByAccessibilityId("CVV/CVV2");
        el20.sendKeys("100");
        MobileElement el21 = driver.findElementByAccessibilityId(
                "Cardholder name (Required)");
        el21.sendKeys("a");
        MobileElement el22 = driver.findElementByAccessibilityId(
                "Issuing bank name (Required)");
        el22.sendKeys("a");
        MobileElement el23 = driver.findElementByAccessibilityId("Continue Payment");
        el23.click();

        MobileElement el24 = driver.findElementByAccessibilityId("Proceed");
        //wait 10 seconds to fill OTP
        Thread.sleep(10000);

        MobileElement el25 = driver.findElementByAccessibilityId(
                "Return to Merchant");
        el25.click();

        MobileElement el26 = driver.findElementById("android:id/button1");
        el26.click();
        MobileElement el27 = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/ll_add_to_cart");
        el27.click();
        MobileElement el28 = driver.findElementById("otp-input0");

        //wait 20 seconds to fill OTP
        Thread.sleep(20000);
        MobileElement el29 = driver.findElementByAccessibilityId("Verify");
        el29.click();
        MobileElement el30 = driver.findElementByAccessibilityId("Navigate up");
        el30.click();

    }

    @Test
    public void testJoinMembership() throws InterruptedException {
        MobileElement elTerms = driver.findElementById("android:id/button1");
        elTerms.click();

        //click hambuger
        MobileElement el2 = driver.findElementByAccessibilityId("d* getkaki");
        el2.click();

        //click membership
        MobileElement el3 = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout[2]/android.widget.ExpandableListView/android.widget.LinearLayout[5]/android.widget.TextView");
        el3.click();

        //get private code
        MobileElement elCode = driver.findElementById("com.appliedmesh.getkaki.dev:id/etCode");
        elCode.setValue("123");

        //get email
        MobileElement elEmail = driver.findElementById("com.appliedmesh.getkaki.dev:id/etEmail");
        elEmail.setValue("duy.bui@appliedmesh.com");

        //hide keyboard
        driver.hideKeyboard();

        //click done
        MobileElement btnDone = driver.findElementById("com.appliedmesh.getkaki.dev:id/btn_proceed");
        btnDone.click();

        //delay 20s to fill OTP code
        Thread.sleep(30000);

        MobileElement btnVerify = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.webkit.WebView/android.webkit.WebView/android.view.View[3]/android.view.View[2]/android.widget.Button");
        btnVerify.click();

        //get title
        MobileElement title = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/actionbar_title");

        Thread.sleep(5000);

        assertEquals(title.getText(), "Home");
    }

    public void testPromoCode(String promoCode, String expectedResult) {
        //close Terms and conditions
        MobileElement elTerms = driver.findElementById("android:id/button1");
        elTerms.click();

        //        MobileElement elHumbuger = driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"d* getkaki\"]");
        //        elHumbuger.click();

        //click button fab
        MobileElement emFab = driver.findElementById("com.appliedmesh.getkaki.dev:id/fab");
        emFab.click();

        //click button code
        MobileElement emCode = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/ll_promo_container");
        emCode.click();

        //get edittext enter code
        MobileElement edtCode = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/et_promo_code");
        edtCode.setValue(promoCode);

        //click button apply
        MobileElement btnApply = driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]");
        btnApply.click();

        //get value from warning TextView
        MobileElement tvWarning = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/tv_promo_code_error");

        assertEquals(expectedResult, tvWarning.getText());
    }

    @Test
    public void testSearchHomePage() throws InterruptedException {
        //close Terms and conditions
        MobileElement elTerms = driver.findElementById("android:id/button1");
        elTerms.click();

        MobileElement el1 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/iv_search");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/search_field");
        el2.sendKeys("miam miam");

        MobileElement el3 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/cbSelectAll");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btnAction");
        el4.click();

        //get title
        MobileElement title = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/actionbar_title");

        Thread.sleep(5000);

        assertEquals(title.getText(), "Home");
    }

    public void waitElementShowingById(String id) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Test
    public void testAddOutletByMerchant() throws InterruptedException {
        MobileElement el1 = (MobileElement) driver.findElementById("android:id/button1");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/fab");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/ll_add_outlet_container");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByXPath(
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[1]");
        el4.click();
        MobileElement el5 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/cbSelectAll");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/btnAction");
        el6.click();

        //get title
        MobileElement title = driver.findElementById(
                "com.appliedmesh.getkaki.dev:id/actionbar_title");

        Thread.sleep(5000);

        assertEquals(title.getText(), "Home");
    }

    @AfterMethod
    public void afterMethod() {
        driver.closeApp();
        driver.launchApp();
    }

    @AfterTest
    public void end() {
        driver.quit();
    }
}
