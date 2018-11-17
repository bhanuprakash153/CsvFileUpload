package com.example.Zschedulars.categories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CategoriesExample {

    public static void main(String args[]) {

        String file = "/media/mani/HDD/bhanu/categories/abc.txt";

        List<String> lines = new ArrayList<>();
        List<String> final_lines = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();
        Map<String, Integer> check_duplicates_using_map = new HashMap<>();

        try {
            Stream<String> stream = Files.lines(Paths.get(file));

            stream.forEach(row -> {

                lines.add(row);
                // System.out.println(lines);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.forEach(row -> {

            if (!row.isEmpty()) {

                if (row.split(",").length == 9) {

                    final_lines.add(row);
                    //  System.out.println(final_lines);
                }

            }
        });

        final_lines.forEach(row -> {

            String level1_category = row.split(",")[1];
            String level1_display_name = row.split(",")[0];
            String level1_img_url = row.split(",")[2];
            String level2_category = row.split(",")[4];
            String level2_display_name = row.split(",")[3];
            String level2_img_url = row.split(",")[5];
            String level3_category = row.split(",")[7];
            String level3_display_name = row.split(",")[6];
            String level3_img_url = row.split(",")[8];

           /* System.out.println("level1_category:" + level1_category);
            System.out.println("level1_display_name:" + level1_display_name);
            System.out.println("level1_img_url:" + level1_img_url);
            System.out.println("level2_category:" + level2_category);
            System.out.println("level2_display_name:" + level2_display_name);
            System.out.println("level2_img_url:" + level2_img_url);
            System.out.println("level3_category:" + level3_category);
            System.out.println("level3_display_name:" + level3_display_name);
            System.out.println("level3_img_url:" + level3_img_url);
*/
            String check_duplicates = row.split(",")[1] + "\n" + row.split(",")[4] + "\n" + row.split(",")[7];

            /*if (duplicates.contains(check_duplicates)) {

                //  System.out.println("---" + check_duplicates);

            } else {
                duplicates.add(check_duplicates);
            }*/

            if (check_duplicates_using_map.containsKey(check_duplicates)) {

                int counter = check_duplicates_using_map.get(check_duplicates);
                check_duplicates_using_map.put(check_duplicates, counter + 1);
                System.out.println("duplicates:" + check_duplicates_using_map);
            } else {
                check_duplicates_using_map.put(check_duplicates, 1);

            }


        });
    }


}
