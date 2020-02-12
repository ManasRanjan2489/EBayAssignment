package Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Constants {

    public static String SEARCH_PRODUCT = "65-inch TV";

    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
