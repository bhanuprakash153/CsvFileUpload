package com.example.Zschedulars.categories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CategoriesCustomer {

    public static void main(String args[]) throws IOException {
        List<String> files_list = Files.list(Paths.get("/media/mani/HDD/categories"))
                .map(Path::toFile)
                .map(File::toString)
                .collect(Collectors.toList());

        files_list.forEach(file_name -> {
                    if (file_name.endsWith(".txt")) {
                        List<String> lines = new ArrayList<>();
                        List<String> final_lines = new ArrayList<>();

                        List<String> check_duplicates = new ArrayList<>();

                        Set<String> level1 = new HashSet<>();

                        try (Stream<String> stream = Files.lines(Paths.get(file_name))) {

                            stream.forEach(line -> {

                                //System.out.println(line);
                                lines.add(line);
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        lines.forEach(line -> {

                            //System.out.println(line.split(",").length);

                            if (!line.isEmpty()) {


                                if (line.split(",").length == 9) {
                                    final_lines.add(line);

                                    String[] line_array = line.split(",");

                                    // System.out.println("success:" + line);

                                } else if (line.split(",").length > 9) {
//                                    System.out.println(line.split(",").length);
//                                    System.out.println("error:" + line);
                                }

                            } else if (line.split(",").length > 4) {
//                                System.out.println(line.split(",").length);
//                                System.out.println("error:" + line);
                            }


                        });

                        //System.out.println("___" + final_lines.size());

                        final_lines.forEach(row ->
                        {
                            String level1_category = row.split(",")[1];
                            String level1_display_name = row.split(",")[0];
                            String level1_img_url = row.split(",")[2];
                            String level2_category = row.split(",")[4];
                            String level2_display_name = row.split(",")[3];
                            String level2_img_url = row.split(",")[5];
                            String level3_category = row.split(",")[7];
                            String level3_display_name = row.split(",")[6];
                            String level3_img_url = row.split(",")[8];

                            level1_category = level1_category.contains("$$") ? level1_category.replace("$$", ",") : level1_category;
                            level1_display_name = level1_display_name.contains("$$") ? level1_display_name.replace("$$", ",") : level1_display_name;
                            level1_img_url = level1_img_url.contains("$$") ? level1_img_url.replace("$$", ",") : level1_img_url;

                            level2_category = level2_category.contains("$$") ? level2_category.replace("$$", ",") : level2_category;
                            level2_display_name = level2_display_name.contains("$$") ? level2_display_name.replace("$$", ",") : level2_display_name;
                            level2_img_url = level2_img_url.contains("$$") ? level2_img_url.replace("$$", ",") : level2_img_url;

                            level3_category = level3_category.contains("$$") ? level3_category.replace("$$", ",") : level3_category;
                            level3_display_name = level3_display_name.contains("$$") ? level3_display_name.replace("$$", ",") : level3_display_name;
                            level3_img_url = level3_img_url.contains("$$") ? level3_img_url.replace("$$", ",") : level3_img_url;


//                            System.out.println("level1_category " + level1_category);
//                            System.out.println("level1_display_name " + level1_display_name);
//                            System.out.println("level1_img_url " + level1_img_url);
//                            System.out.println("level2_category " + level2_category);
//                            System.out.println("level2_display_name " + level2_display_name);
//                            System.out.println("level2_img_url " + level2_img_url);
//                            System.out.println("level3_category " + level3_category);
//                            System.out.println("level3_display_name " + level3_display_name);
//                            System.out.println("level3_img_url " + level3_img_url);


                            String type = file_name.contains("_store") ? "store" : "service";


                            //System.out.println(row);


                            /*String duplicate_chk = row.split(",")[1].replace(":", ",")
                                    + " " + row.split(",")[4].replace(":", ",")
                                    + " " + row.split(",")[7].replace(":", ",");*/

                            String duplicate_chk = row.split(",")[7].replace(":", ",");

                          /*  Map<String, Integer> map = new HashMap<>();
                            for (String s : final_lines) {
                                if (map.containsKey(duplicate_chk)) {
                                    map.put(duplicate_chk, map.get(duplicate_chk) + 1);
                                } else {
                                    map.put(duplicate_chk, 1);
                                }
                            }
                            for (Map.Entry<String, Integer> e : map.entrySet()) {
                                System.out.println(e.getKey() + "---" + e.getValue());

                            }
*/

                            Map<String, Integer> map = new HashMap<>();





                        /*if (check_duplicates.contains(duplicate_chk)) {


                            System.out.println("---" + duplicate_chk);

                        } else {
                            check_duplicates.add(duplicate_chk);
                        }*/


                            //System.out.println(duplicate_chk);
                               /* cc.getQASession().executeAsync(QueryBuilder
                                        .insertInto("customer_categories").value("level1_category", level1_category != null ? level1_category.trim() : level1_category)
                                        .value("level1_display_name", level1_display_name != null ? level1_display_name.trim() : level1_display_name)
                                        .value("level1_img_url", level1_img_url != null ? level1_img_url.trim() : level1_img_url)
                                        .value("level2_category", level2_category != null ? level2_category.trim() : level2_category)
                                        .value("level2_display_name", level2_display_name != null ? level2_display_name.trim() : level2_display_name)
                                        .value("level2_img_url", level2_img_url != null ? level2_img_url.trim() : level2_img_url)
                                        .value("level3_category", level3_category != null ? level3_category.trim() : level3_category)
                                        .value("level3_display_name", level3_display_name != null ? level3_display_name.trim() : level3_display_name)
                                        .value("level3_img_url", level3_img_url != null ? level3_img_url.trim() : level3_img_url)

                                        .value("category_type", type));



                            System.out.println(level1_category);*/


                        });

                    }
                }
        );
    }

}

