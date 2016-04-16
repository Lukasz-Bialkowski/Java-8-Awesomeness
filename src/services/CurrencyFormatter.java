package services;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class CurrencyFormatter {


    public static String format(double c) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(c);
    }
}
