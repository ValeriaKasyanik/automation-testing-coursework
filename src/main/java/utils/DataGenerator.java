package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    public static Random rnd = new Random();

    public static String generateInvalidEmail() {
        List<String> incorrectEmails = new ArrayList<>((
                Arrays.asList(RandomStringUtils.randomAlphanumeric(10), " ", "test@gmail.com", "test%gmail.com",
                        "test @gmail.com", "test@gmail:com", "@gmail.com", "test", "testEmail@.")));
        return incorrectEmails.get(rnd.nextInt(incorrectEmails.size()));
    }

    public static String generatePassword() {
        List<String> passwords = new ArrayList<>((
                Arrays.asList(RandomStringUtils.randomAlphanumeric(15), " ")));
        return passwords.get(rnd.nextInt(passwords.size()));
    }
}
