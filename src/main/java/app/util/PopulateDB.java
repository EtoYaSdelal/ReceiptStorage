package app.util;

import app.model.Receipt;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PopulateDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/receipt_storage";
    private static final String USER = "postgres";
    private static final String PASS = "admin";

    public static void main(String[] args) throws SQLException, ParseException {
        List<Receipt> receipts = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            receipts.add(RandomReceiptGetter.getReceipt());
        }

        List<Receipt> collect = receipts.stream().filter(x -> !x.isPaid()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        try (Connection connection = DriverManager.getConnection(URL, USER, PASS)) {
            populate(receipts, connection);
        }


    }

    private static void populate(List<Receipt> receipts, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT into receipt(rec_id,company_name, payment, paid, date, time, comment) values(?,?,?,?,?,?,?)");
        for (Receipt receipt : receipts) {
            preparedStatement.setString(1, receipt.getId());
            preparedStatement.setString(2, receipt.getCompanyName());
            preparedStatement.setDouble(3, receipt.getPayment());
            preparedStatement.setBoolean(4, receipt.isPaid());
            preparedStatement.setDate(5, Date.valueOf(receipt.getDate()));
            preparedStatement.setTime(6, Time.valueOf(receipt.getTime()));
            preparedStatement.setString(7, receipt.getComment());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        preparedStatement.close();
    }
}
