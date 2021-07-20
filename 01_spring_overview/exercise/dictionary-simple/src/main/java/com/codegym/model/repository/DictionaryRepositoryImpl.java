package com.codegym.model.repository;

import org.springframework.stereotype.Repository;

import com.codegym.model.bean.Dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class DictionaryRepositoryImpl implements DictionaryRepository {
    private static Map<Integer, Dictionary> map = new TreeMap<>();

    static {
        Dictionary dictionary1 = new Dictionary("Hello", "Xin chào");
        Dictionary dictionary2 = new Dictionary("Miss", "Nhớ");
        Dictionary dictionary3 = new Dictionary("Table", "Bàn");
        Dictionary dictionary4 = new Dictionary("Meet", "Gặp");
        Dictionary dictionary5 = new Dictionary("Goodbye", "Tạm biệt");
        map.put(1, dictionary1);
        map.put(2, dictionary2);
        map.put(3, dictionary3);
        map.put(4, dictionary4);
        map.put(5, dictionary5);
    }

    @Override
    public String find(String english) {
        String word = "Không có từ này trong từ điển!";
        List<Dictionary> list = new ArrayList<>(map.values());
        for (int i = 0; i < list.size(); i++) {
            if ((english.toLowerCase()).equals(list.get(i).getEnglish().toLowerCase())) {
                word = list.get(i).getVietnamese();
                return word;
            }
        }
        return word;
    }
}
