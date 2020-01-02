package org.xeny;

import org.xeny.Order;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator.Feature;

public final class App {

    private App() {

    }

    public static void main(final String[] args) {

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        mapper.findAndRegisterModules();

        try {

            Order order = mapper.readValue(new File(args[0]), Order.class);
            System.out.println("Input: " + order + "\n");

        } catch (final Exception e) {

            System.out.println("Oops! Something gone wrong behind the curtains!");
            System.out.println("Error: " + e);

        }

        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        mapper = new ObjectMapper(new YAMLFactory().disable(Feature.WRITE_DOC_START_MARKER));

        List<OrderLine> lines = new ArrayList<>();

        lines.add( new OrderLine(
            "Copper Wire (200ft)", 
            1, 
            new BigDecimal(50.67).setScale(2, RoundingMode.HALF_UP)
            )
        );

        lines.add( new OrderLine(
            "Washers (1/4\")", 
            24, 
            new BigDecimal(.15).setScale(2, RoundingMode.HALF_UP)
            )
        );

        Order order = new Order(
            "B-9910", 
            LocalDate.parse("2019-04-18", DateTimeFormatter.ISO_DATE), 
            "Customer, Jane",
            lines
        );

        try {

            mapper.writeValue(new File(args[1]), order);
            System.out.println("Output: " + order);

        } catch (final Exception e) {

            System.out.println("Oops! Something gone wrong behind the curtains!");
            System.out.println("Error: " + e);

        }

    }
}
