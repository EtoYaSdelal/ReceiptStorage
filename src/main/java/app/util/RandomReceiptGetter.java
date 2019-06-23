package app.util;

import app.model.Receipt;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomReceiptGetter {

    public static Receipt getReceipt() {
        Receipt receipt = new Receipt();
        receipt.setId(UUID.randomUUID().toString().substring(0, 8));
        receipt.setCompanyName(new NameGenerator().getAcronym());
        receipt.setPayment(new Random().nextDouble() * new Random().nextInt(10000000));
        receipt.setDate(getDate());
        receipt.setTime(getTime());
        receipt.setPaid(new Random().nextBoolean());
        if (receipt.getPaid()) {
            receipt.setComment("everything were nice");
        } else {
            receipt.setComment("they didn't pay yet");
        }
        return receipt;
    }

    private static LocalDate getDate() {
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.now().toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static LocalTime getTime() {
        long minSec = LocalTime.of(0, 0).toSecondOfDay();
        long maxSec = LocalTime.of(23, 59).toSecondOfDay();
        long randomSec = ThreadLocalRandom.current().nextLong(minSec, maxSec);
        return LocalTime.ofSecondOfDay(randomSec);
    }

    private static class NameGenerator {
        private String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H",
                "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z"};

        private String acronym;

        private NameGenerator() {
            this.acronym = alphabet[new Random().nextInt(26)] +
                    alphabet[new Random().nextInt(26)] +
                    alphabet[new Random().nextInt(26)] +
                    alphabet[new Random().nextInt(26)] + " co.";
        }

        private String getAcronym() {
            return acronym;
        }
    }
}
