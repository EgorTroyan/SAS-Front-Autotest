package tests.yandexsearch;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class YandexSearchTest extends BaseTest {
    @Test
    public void chekIsYandexIsSearching() {
        basePage.openURL("https://ya.ru");
        startPage.findYandex();
    }
}
